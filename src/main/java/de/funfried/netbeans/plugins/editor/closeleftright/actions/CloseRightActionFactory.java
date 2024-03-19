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

import javax.swing.AbstractAction;

import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.TopComponent;

import de.funfried.netbeans.plugins.editor.closeleftright.AbstractActionFactory;
import de.funfried.netbeans.plugins.editor.closeleftright.AdditionalCloseActionFactory;

/**
 * {@link CloseRightActionFactory} to create {@link CloseRightAction}.
 *
 * @author Alexander Yastrebov
 */
@Messages("CTL_CloseRightAction=Close Right")
@ServiceProvider(service = AdditionalCloseActionFactory.class, position = 100)
public class CloseRightActionFactory extends AbstractActionFactory {
	/**
	 * Creates a new instance of {@link CloseRightActionFactory}.
	 */
	public CloseRightActionFactory() {
		super(NbBundle.getMessage(CloseRightActionFactory.class, "CTL_CloseRightAction"));
	}

	@Override
	public String getId() {
		return "closeRightAction";
	}

	@Override
	public boolean isGlobalAction() {
		return true;
	}

	@Override
	public AbstractAction createAction(TopComponent topComponent) {
		return new CloseRightAction(getName(), topComponent);
	}
}
