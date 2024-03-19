/*
 * Copyright (c) 2022 Airtango.
 * All rights reserved.
 */

package de.funfried.netbeans.plugins.editor.closeleftright;

import javax.swing.AbstractAction;

import org.openide.windows.TopComponent;

/**
 *
 * @author fbahle
 */
public interface AdditionalCloseActionFactory {
	String getId();

	String getName();

	boolean isActive();

	void setActive(boolean active);

	boolean isGlobalAction();

	AbstractAction createAction(TopComponent topComponent);
}
