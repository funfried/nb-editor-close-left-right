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
 * Close VCS diff editor tab context menu action.
 *
 * @author bahlef
 */
@Messages("CTL_CloseDiffTopComponentsAction=Close VCS Diff Tabs")
@ServiceProvider(service = AdditionalCloseAction.class, position = 600)
public class CloseDiffTopComponentsAction extends AbstractTopComponentBaseAction implements AdditionalCloseAction {
	private static final long serialVersionUID = 8838158102777470061L;

	/**
	 * Creates a new instance of {@link CloseDiffTopComponentsAction}.
	 */
	public CloseDiffTopComponentsAction() {
		super(NbBundle.getMessage(CloseDiffTopComponentsAction.class, "CTL_CloseDiffTopComponentsAction"), org.netbeans.modules.git.ui.diff.DiffTopComponent.class,
				org.netbeans.modules.subversion.ui.diff.DiffTopComponent.class, org.netbeans.modules.mercurial.ui.diff.DiffTopComponent.class);
	}

	@Override
	public String getId() {
		return "closeDiffTopComponentsAction";
	}

	@Override
	public boolean isGlobalAction() {
		return false;
	}
}
