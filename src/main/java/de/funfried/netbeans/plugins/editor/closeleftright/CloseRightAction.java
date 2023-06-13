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
package de.funfried.netbeans.plugins.editor.closeleftright;

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Close right editor tab context menu action.
 *
 * @author Alexander Yastrebov
 */
@Messages("CTL_CloseRightAction=Close Right")
public class CloseRightAction extends AbstractBaseAction {
	private static final long serialVersionUID = -8970638174416914392L;

	/**
	 * Creates a new instance of {@link CloseRightAction}.
	 *
	 * @param topComponent the related {@link TopComponent} of this action
	 */
	public CloseRightAction(TopComponent topComponent) {
		super(topComponent, NbBundle.getMessage(CloseRightAction.class, "CTL_CloseRightAction"), false);
	}
}
