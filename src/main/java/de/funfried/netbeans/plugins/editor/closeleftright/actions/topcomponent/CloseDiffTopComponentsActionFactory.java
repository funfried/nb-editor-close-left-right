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

import javax.swing.AbstractAction;

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.TopComponent;

import de.funfried.netbeans.plugins.editor.closeleftright.AbstractActionFactory;
import de.funfried.netbeans.plugins.editor.closeleftright.AdditionalCloseActionFactory;

/**
 * {@link AdditionalCloseActionFactory} to create {@link CloseDiffTopComponentsAction}.
 *
 * @author bahlef
 */
@Messages("CTL_CloseDiffTopComponentsAction=Close VCS Diff Tabs")
@ServiceProvider(service = AdditionalCloseActionFactory.class, position = 600)
public class CloseDiffTopComponentsActionFactory extends AbstractActionFactory {
	/**
	 * Creates a new instance of {@link CloseDiffTopComponentsActionFactory}.
	 */
	public CloseDiffTopComponentsActionFactory() {
		super(NbBundle.getMessage(CloseDiffTopComponentsActionFactory.class, "CTL_CloseDiffTopComponentsAction"));
	}

	@Override
	public String getId() {
		return "closeDiffTopComponentsAction";
	}

	@Override
	public boolean isGlobalAction() {
		return false;
	}

	@Override
	public AbstractAction createAction(TopComponent topComponent) {
		return new CloseDiffTopComponentsAction(getName());
	}
}
