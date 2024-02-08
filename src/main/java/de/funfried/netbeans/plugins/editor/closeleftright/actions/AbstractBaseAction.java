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

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;

import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Base class for closing left or right tabs actions.
 *
 * @author bahlef
 */
public abstract class AbstractBaseAction extends AbstractAction {
	private static final long serialVersionUID = -8499198129424546354L;

	private static final Logger log = Logger.getLogger(AbstractBaseAction.class.getName());

	/** the related {@link TopComponent} of this action. */
	protected final TopComponent topComponent;

	/** Flag indicating to close all left or all right tabs. */
	protected final boolean initialClose;

	/**
	 * Constructor of abstract class {@link ActionBase}.
	 *
	 * @param topComponent the related {@link TopComponent} of this action
	 * @param name the name of this action
	 * @param initialClose flag indicating to close all left ({@code true}) or all right ({@code false}) tabs
	 */
	protected AbstractBaseAction(TopComponent topComponent, String name, boolean initialClose) {
		super(name);

		this.topComponent = topComponent;
		this.initialClose = initialClose;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Mode mode = WindowManager.getDefault().findMode(topComponent);
		if (mode == null) {
			return;
		}

		boolean close = initialClose;
		for (TopComponent tc : mode.getTopComponents()) {
			if (tc == topComponent) {
				close = !close;
				continue;
			}

			if (close && tc.isOpened()) {
				tc.close();
			}
		}
	}

	@Override
	public boolean isEnabled() {
		Mode mode = WindowManager.getDefault().findMode(topComponent);
		if (mode == null) {
			return false;
		}

		boolean close = initialClose;

		try {
			for (TopComponent tc : mode.getTopComponents()) {
				if (tc == topComponent) {
					close = !close;
					continue;
				}

				if (close && tc.isOpened()) {
					return true;
				}
			}
		} catch (Exception ex) {
			log.log(Level.WARNING, NAME, ex);
		}

		return false;
	}
}
