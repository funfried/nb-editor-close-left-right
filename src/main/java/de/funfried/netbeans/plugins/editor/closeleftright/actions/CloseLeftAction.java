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

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.ServiceProvider;

import de.funfried.netbeans.plugins.editor.closeleftright.AdditionalCloseAction;

/**
 * Close left editor tab context menu action.
 *
 * @author Alexander Yastrebov
 */
@Messages("CTL_CloseLeftAction=Close Left")
@ServiceProvider(service = AdditionalCloseAction.class, position = 100)
public class CloseLeftAction extends AbstractInitialCloseBaseAction implements AdditionalCloseAction {
	private static final long serialVersionUID = -6948129193867379695L;

	/**
	 * Creates a new instance of {@link CloseLeftAction}.
	 */
	public CloseLeftAction() {
		super(NbBundle.getMessage(CloseLeftAction.class, "CTL_CloseLeftAction"), true);
	}

	@Override
	public String getId() {
		return "closeLeftAction";
	}

	@Override
	public boolean isGlobalAction() {
		return true;
	}
}
