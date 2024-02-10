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

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.ServiceProvider;

import de.funfried.netbeans.plugins.editor.closeleftright.AdditionalCloseAction;

/**
 * Close left editor tab context menu action.
 *
 * @author bahlef
 */
@Messages("CTL_CloseCommitedAction=Close All Commited")
@ServiceProvider(service = AdditionalCloseAction.class, position = 500)
public class CloseCommitedAction extends AbstractVcsBaseAction implements AdditionalCloseAction {
	private static final long serialVersionUID = -1294837770606016114L;

	/**
	 * Creates a new instance of {@link CloseCommitedAction}.
	 */
	public CloseCommitedAction() {
		super(NbBundle.getMessage(CloseCommitedAction.class, "CTL_CloseCommitedAction"));
	}

	@Override
	public String getId() {
		return "closeCommitedAction";
	}

	@Override
	public boolean isGlobalAction() {
		return false;
	}
}
