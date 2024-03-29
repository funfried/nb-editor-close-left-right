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
package de.funfried.netbeans.plugins.editor.closeleftright.actions;

import org.openide.windows.TopComponent;

/**
 * Close right editor tab context menu action.
 *
 * @author Alexander Yastrebov
 */
public class CloseRightAction extends AbstractInitialCloseBaseAction {
	private static final long serialVersionUID = -8970638174416914392L;

	/**
	 * Creates a new instance of {@link CloseRightAction}.
	 *
	 * @param name the name of the action
	 * @param topComponent the {@link TopComponent}
	 */
	CloseRightAction(String name, TopComponent topComponent) {
		super(name, topComponent, false);
	}
}
