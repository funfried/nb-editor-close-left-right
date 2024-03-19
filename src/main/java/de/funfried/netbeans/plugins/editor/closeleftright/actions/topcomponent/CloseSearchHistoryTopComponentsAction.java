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

/**
 * Close VCS search history editor tab context menu action.
 *
 * @author bahlef
 */
public class CloseSearchHistoryTopComponentsAction extends AbstractTopComponentBaseAction {
	private static final long serialVersionUID = 1132788229885401011L;

	/**
	 * Creates a new instance of {@link CloseSearchHistoryTopComponentsAction}.
	 */
	CloseSearchHistoryTopComponentsAction(String name) {
		super(name, org.netbeans.modules.git.ui.history.SearchHistoryTopComponent.class, org.netbeans.modules.subversion.ui.history.SearchHistoryTopComponent.class,
				org.netbeans.modules.mercurial.ui.log.SearchHistoryTopComponent.class);
	}
}
