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

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Close left editor tab context menu action.
 *
 * @author bahlef
 */
@Messages("CTL_CloseOtherProjectTabsAction=Close All From Other Projects")
public class CloseOtherProjectTabsAction extends AbstractProjectBaseAction {
	private static final long serialVersionUID = -6406411298190620857L;

	/**
	 * Creates a new instance of {@link CloseOtherProjectTabsAction}.
	 *
	 * @param topComponent the related {@link TopComponent} of this action
	 */
	public CloseOtherProjectTabsAction(TopComponent topComponent) {
		super(topComponent, NbBundle.getMessage(CloseOtherProjectTabsAction.class, "CTL_CloseOtherProjectTabsAction"), false);
	}
}
