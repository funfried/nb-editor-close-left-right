/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.funfried.netbeans.plugins.editor.closeleftright.actions.project;

import java.awt.event.ActionEvent;
import java.util.Objects;

import javax.swing.Action;

import org.apache.commons.lang3.ArrayUtils;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectInformation;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.ui.OpenProjects;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

import de.funfried.netbeans.plugins.editor.closeleftright.actions.AbstractInitialCloseBaseAction;

/**
 * Base class for closing project related tabs actions.
 *
 * @author bahlef
 */
abstract class AbstractProjectBaseAction extends AbstractInitialCloseBaseAction {
	private static final long serialVersionUID = 5322225046091709258L;

	private final String actionNamePrefix;

	/**
	 * Constructor of abstract class {@link ActionBase}.
	 *
	 * @param name the name of this action
	 * @param initialClose flag indicating to close all tabs with the same ({@code true}) or all tabs with a different ({@code false}) project
	 */
	public AbstractProjectBaseAction(String name, TopComponent topComponent, boolean initialClose) {
		super(name, topComponent, initialClose);

		actionNamePrefix = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Project[] openProjects = OpenProjects.getDefault().getOpenProjects();

		Project project = getProjectByTopComponent(openProjects, this.topComponent);
		if (project == null) {
			return;
		}

		Mode mode = WindowManager.getDefault().findMode(this.topComponent);
		if (mode == null) {
			return;
		}

		for (TopComponent tc : mode.getTopComponents()) {
			Project otherProject = getProjectByTopComponent(openProjects, tc);
			if (tc.isOpened() && ((initialClose && Objects.equals(project, otherProject)) || (!initialClose && !Objects.equals(project, otherProject)))) {
				tc.close();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		Project project = getProjectByTopComponent(OpenProjects.getDefault().getOpenProjects(), topComponent);
		if (project != null) {
			ProjectInformation projectInfo = ProjectUtils.getInformation(project);
			if (projectInfo != null) {
				putValue(Action.NAME, actionNamePrefix + " (" + projectInfo.getDisplayName() + ")");
			}

			return true;
		} else {
			putValue(Action.NAME, actionNamePrefix);

			return false;
		}
	}

	private Project getProjectByTopComponent(Project[] openProjects, TopComponent topComponent) {
		if (ArrayUtils.isEmpty(openProjects) || topComponent == null) {
			return null;
		}

		Project ret = null;

		FileObject fileObject = topComponent.getLookup().lookup(FileObject.class);
		if (fileObject != null) {
			for (Project project : openProjects) {
				if (FileUtil.isParentOf(project.getProjectDirectory(), fileObject)
						&& (ret == null || FileUtil.isParentOf(ret.getProjectDirectory(), project.getProjectDirectory()))) {
					ret = project;
				}
			}
		}

		return ret;
	}
}
