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

import org.openide.util.NbPreferences;

/**
 * Base class for closing actions.
 *
 * @author bahlef
 */
public abstract class AbstractActionFactory implements AdditionalCloseActionFactory {
	private static final Logger log = Logger.getLogger(AbstractActionFactory.class.getName());

	private String name;

	/**
	 * Constructor of abstract class {@link AbstractActionFactory}.
	 *
	 * @param name the name of the action
	 */
	protected AbstractActionFactory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isActive() {
		return NbPreferences.forModule(AbstractActionFactory.class).getBoolean(getId(), true);
	}

	@Override
	public void setActive(boolean active) {
		Preferences prefs = NbPreferences.forModule(AbstractActionFactory.class);
		prefs.putBoolean(getId(), active);

		try {
			prefs.flush();
		} catch (BackingStoreException ex) {
			log.log(Level.WARNING, "Could not flush active flag", ex);
		}
	}
}
