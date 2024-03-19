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
 * {@link CloseLeftActionFactory} to create {@link CloseLeftAction}.
 *
 * @author Alexander Yastrebov
 */
@Messages("CTL_CloseLeftAction=Close Left")
@ServiceProvider(service = AdditionalCloseActionFactory.class, position = 100)
public class CloseLeftActionFactory extends AbstractActionFactory {
	/**
	 * Creates a new instance of {@link CloseRightActionFactory}.
	 */
	public CloseLeftActionFactory() {
		super(NbBundle.getMessage(CloseLeftActionFactory.class, "CTL_CloseLeftAction"));
	}

	@Override
	public String getId() {
		return "closeLeftAction";
	}

	@Override
	public boolean isGlobalAction() {
		return true;
	}

	@Override
	public AbstractAction createAction(TopComponent topComponent) {
		return new CloseLeftAction(getName(), topComponent);
	}
}
