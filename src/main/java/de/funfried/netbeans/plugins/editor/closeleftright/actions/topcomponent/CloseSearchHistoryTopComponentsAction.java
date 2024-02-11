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

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.ServiceProvider;

import de.funfried.netbeans.plugins.editor.closeleftright.AdditionalCloseAction;

/**
 * Close VCS search history editor tab context menu action.
 *
 * @author bahlef
 */
@Messages("CTL_CloseSearchHistoryTopComponentsAction=Close VCS Search History Tabs")
@ServiceProvider(service = AdditionalCloseAction.class, position = 700)
public class CloseSearchHistoryTopComponentsAction extends AbstractTopComponentBaseAction implements AdditionalCloseAction {
	private static final long serialVersionUID = 1132788229885401011L;

	/**
	 * Creates a new instance of {@link CloseSearchHistoryTopComponentsAction}.
	 */
	public CloseSearchHistoryTopComponentsAction() {
		super(NbBundle.getMessage(CloseSearchHistoryTopComponentsAction.class, "CTL_CloseSearchHistoryTopComponentsAction"),
				org.netbeans.modules.git.ui.history.SearchHistoryTopComponent.class, org.netbeans.modules.subversion.ui.history.SearchHistoryTopComponent.class,
				org.netbeans.modules.mercurial.ui.log.SearchHistoryTopComponent.class);
	}

	@Override
	public String getId() {
		return "closeSearchHistoryTopComponentsAction";
	}

	@Override
	public boolean isGlobalAction() {
		return false;
	}
}
