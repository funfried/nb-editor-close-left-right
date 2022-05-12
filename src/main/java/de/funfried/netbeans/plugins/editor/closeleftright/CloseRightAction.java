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

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.cookies.EditorCookie;
import org.openide.util.NbBundle.Messages;

/**
 *
 * @author Alexander Yastrebov
 */
@ActionID(category = "Editor", id = "de.funfried.netbeans.plugins.editor.closeleftright.CloseRightAction")
@ActionRegistration(displayName = "#CTL_CloseRightAction")
@ActionReferences({
		@ActionReference(path = "Editors/TabActions", position = 2)
})
@Messages("CTL_CloseRightAction=Close Right")
public class CloseRightAction extends ActionBase {
	public CloseRightAction(EditorCookie cookie) {
		super(cookie, false);
	}
}
