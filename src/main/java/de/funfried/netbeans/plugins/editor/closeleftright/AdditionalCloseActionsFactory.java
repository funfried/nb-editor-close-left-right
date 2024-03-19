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

import java.util.Collection;

import javax.swing.Action;

import org.apache.commons.lang3.ArrayUtils;
import org.netbeans.core.windows.actions.ActionsFactory;
import org.netbeans.core.windows.actions.CloseAllButThisAction;
import org.netbeans.core.windows.actions.CloseModeAction;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 *
 * @author fbahle
 */
@ServiceProvider(service = ActionsFactory.class, position = Integer.MAX_VALUE)
public class AdditionalCloseActionsFactory extends ActionsFactory {
	private final Collection<? extends AdditionalCloseActionFactory> additionalCloseActionFactories;

	public AdditionalCloseActionsFactory() {
		additionalCloseActionFactories = Lookup.getDefault().lookupAll(AdditionalCloseActionFactory.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Action[] createPopupActions(TopComponent tc, Action[] actions) {
		return addAdditionalActions(tc, WindowManager.getDefault().findMode(tc), actions);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Action[] createPopupActions(Mode mode, Action[] actions) {
		return addAdditionalActions(mode.getSelectedTopComponent(), mode, actions);
	}

	private Action[] addAdditionalActions(TopComponent tc, Mode mode, Action[] actions) {
		boolean isEditorTc = mode != null && mode.getName().equalsIgnoreCase("editor");

		Action[] actionsToAdd = new Action[0];
		for (AdditionalCloseActionFactory additionalCloseActionFactory : additionalCloseActionFactories) {
			if (additionalCloseActionFactory.isActive() && (isEditorTc || additionalCloseActionFactory.isGlobalAction())) {
				actionsToAdd = ArrayUtils.add(actionsToAdd, additionalCloseActionFactory.createAction(tc));
			}
		}

		for (int i = 0; i < actions.length; i++) {
			Action action = actions[i];
			if (action instanceof CloseAllButThisAction || action instanceof CloseModeAction) {
				actions = ArrayUtils.insert(i + 1, actions, actionsToAdd);

				break;
			}
		}

		return actions;
	}
}
