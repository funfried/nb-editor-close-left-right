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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import org.openide.cookies.EditorCookie;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Base class for closing editor tabs actions.
 *
 * @author Alexander Yastrebov
 */
abstract class ActionBase implements ActionListener {
	/** The {@link EditorCookie}. */
	private final EditorCookie cookie;

	/** Flag indicating to close all left or all right tabs. */
	private final boolean initialClose;

	/**
	 * Constructor of abstract class {@link ActionBase}.
	 *
	 * @param cookie the {@link EditorCookie}
	 * @param initialClose flag indicating to close all left ({@code true}) or all right ({@code false}) tabs
	 */
	ActionBase(EditorCookie cookie, boolean initialClose) {
		this.cookie = cookie;
		this.initialClose = initialClose;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent unused) {
		JEditorPane[] panes = cookie.getOpenedPanes();
		if (panes == null || panes.length == 0) {
			return;
		}

		TopComponent self = getOuterTopComponent(panes[0]);
		Mode mode = WindowManager.getDefault().findMode(self);
		if (mode == null) {
			return;
		}

		boolean close = initialClose;
		for (TopComponent tc : mode.getTopComponents()) {
			if (tc == self) {
				close = !close;
				continue;
			}

			if (close && tc.isOpened()) {
				tc.close();
			}
		}
	}

	/**
	 * Returns the {@link TopComponent} belonging to the given {@code target}.
	 *
	 * @param target a {@link JTextComponent}
	 *
	 * @return the {@link TopComponent} belonging to the given {@code target} or {@code null} if it could not be found
	 */
	private TopComponent getOuterTopComponent(JTextComponent target) {
		TopComponent tc = null;

		TopComponent parent = (TopComponent) SwingUtilities.getAncestorOfClass(TopComponent.class, target);
		while (parent != null) {
			tc = parent;
			parent = (TopComponent) SwingUtilities.getAncestorOfClass(TopComponent.class, tc);
		}

		return tc;
	}
}
