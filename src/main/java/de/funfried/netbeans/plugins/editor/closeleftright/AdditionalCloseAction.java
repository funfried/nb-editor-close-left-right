/*
 * Copyright (c) 2022 Airtango.
 * All rights reserved.
 */

package de.funfried.netbeans.plugins.editor.closeleftright;

import javax.swing.Action;

import org.openide.windows.TopComponent;

/**
 *
 * @author fbahle
 */
public interface AdditionalCloseAction extends Action {
	String getId();

	String getName();

	boolean isActive();

	void setActive(boolean active);

	boolean isGlobalAction();

	void setTopComponent(TopComponent topComponent);
}
