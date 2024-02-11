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

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;

import org.openide.util.NbPreferences;
import org.openide.windows.TopComponent;

/**
 * Base class for closing actions.
 *
 * @author bahlef
 */
public abstract class AbstractBaseAction extends AbstractAction {
	private static final long serialVersionUID = -9120253952276652530L;

	private static final Logger log = Logger.getLogger(AbstractBaseAction.class.getName());

	/** the related {@link TopComponent} of this action. */
	protected TopComponent topComponent;

	/**
	 * Constructor of abstract class {@link AbstractBaseAction}.
	 *
	 * @param name the name of this action
	 */
	protected AbstractBaseAction(String name) {
		super(name);
	}

	public abstract String getId();

	public String getName() {
		return (String) getValue(Action.NAME);
	}

	public boolean isActive() {
		return NbPreferences.forModule(AbstractBaseAction.class).getBoolean(getId(), true);
	}

	public void setActive(boolean active) {
		Preferences prefs = NbPreferences.forModule(AbstractBaseAction.class);
		prefs.putBoolean(getId(), active);

		try {
			prefs.flush();
		} catch (BackingStoreException ex) {
			log.log(Level.WARNING, "Could not flush active flag", ex);
		}
	}

	public void setTopComponent(TopComponent topComponent) {
		this.topComponent = topComponent;
	}
}
