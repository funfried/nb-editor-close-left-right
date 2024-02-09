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
package de.funfried.netbeans.plugins.editor.closeleftright.actions.vcs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.openide.filesystems.FileObject;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

import de.funfried.netbeans.plugins.editor.closeleftright.vcs.GitUtils;
import de.funfried.netbeans.plugins.editor.closeleftright.vcs.HgUtils;
import de.funfried.netbeans.plugins.editor.closeleftright.vcs.SvnUtils;

/**
 * Base class for closing tabs VCS related actions.
 *
 * @author bahlef
 */
abstract class AbstractVcsBaseAction extends AbstractAction {
	private static final long serialVersionUID = 2663271640670763067L;

	/** the related {@link TopComponent} of this action. */
	protected final TopComponent topComponent;

	/**
	 * Constructor of abstract class {@link ActionBase}.
	 *
	 * @param topComponent the related {@link TopComponent} of this action
	 * @param name the name of this action
	 */
	AbstractVcsBaseAction(TopComponent topComponent, String name) {
		super(name);

		this.topComponent = topComponent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Mode mode = WindowManager.getDefault().findMode(topComponent);
		if (mode == null) {
			return;
		}

		for (TopComponent tc : mode.getTopComponents()) {
			if (tc.isOpened()) {
				FileObject fileObject = tc.getLookup().lookup(FileObject.class);
				if (fileObject != null) {
					Boolean gitModified = GitUtils.isModified(fileObject);
					Boolean svnModified = SvnUtils.isModified(fileObject);
					Boolean hgModified = HgUtils.isModified(fileObject);

					if (!Boolean.TRUE.equals(gitModified) && !Boolean.TRUE.equals(svnModified) && !Boolean.TRUE.equals(hgModified)) {
						tc.close();
					}

				}
			}
		}
	}

	@Override
	public boolean isEnabled() {
		Mode mode = WindowManager.getDefault().findMode(topComponent);
		if (mode == null) {
			return false;
		}

		for (TopComponent tc : mode.getTopComponents()) {
			FileObject fileObject = tc.getLookup().lookup(FileObject.class);
			if (fileObject != null) {
				Boolean gitModified = GitUtils.isModified(fileObject);
				Boolean svnModified = SvnUtils.isModified(fileObject);
				Boolean hgModified = HgUtils.isModified(fileObject);

				if (!Boolean.TRUE.equals(gitModified) && !Boolean.TRUE.equals(svnModified) && !Boolean.TRUE.equals(hgModified)) {
					return true;
				}
			}
		}

		return false;
	}
}
