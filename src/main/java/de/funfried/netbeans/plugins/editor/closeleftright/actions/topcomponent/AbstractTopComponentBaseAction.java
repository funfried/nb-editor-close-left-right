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
package de.funfried.netbeans.plugins.editor.closeleftright.actions.topcomponent;

import java.awt.event.ActionEvent;

import org.apache.commons.lang3.ArrayUtils;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

import de.funfried.netbeans.plugins.editor.closeleftright.AbstractBaseAction;

/**
 * Base class for closing tabs with specific TopComponent implementations related actions.
 *
 * @author bahlef
 */
abstract class AbstractTopComponentBaseAction extends AbstractBaseAction {
	private static final long serialVersionUID = 4175615224177055417L;

	protected final Class<? extends TopComponent>[] topComponentTypes;

	/**
	 * Constructor of abstract class {@link ActionBase}.
	 *
	 * @param name the name of this action
	 * @param topComponentTypes the {@link TopComponent} {@link Class}es which should get closed
	 */
	AbstractTopComponentBaseAction(String name, Class<? extends TopComponent>... topComponentTypes) {
		super(name);

		this.topComponentTypes = topComponentTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (topComponent != null) {
			Mode mode = WindowManager.getDefault().findMode(topComponent);
			if (mode == null) {
				return;
			}

			for (TopComponent tc : mode.getTopComponents()) {
				if (tc.isOpened() && isAssignableFromGivenTypes(tc.getClass())) {
					tc.close();
				}
			}
		}
	}

	@Override
	public boolean isEnabled() {
		if (topComponent != null) {
			Mode mode = WindowManager.getDefault().findMode(topComponent);
			if (mode == null) {
				return false;
			}

			for (TopComponent tc : mode.getTopComponents()) {
				if (tc.isOpened() && isAssignableFromGivenTypes(tc.getClass())) {
					return true;
				}
			}
		}

		return false;
	}

	protected boolean isAssignableFromGivenTypes(Class<? extends TopComponent> topComponentClass) {
		if (topComponentClass != null && ArrayUtils.isNotEmpty(topComponentTypes)) {
			for (Class<? extends TopComponent> topComponentType : topComponentTypes) {
				if (topComponentClass.isAssignableFrom(topComponentType)) {
					return true;
				}
			}
		}

		return false;
	}
}
