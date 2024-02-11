/*
 * Copyright (c) 2022 Airtango.
 * All rights reserved.
 */

package de.funfried.netbeans.plugins.editor.closeleftright.options;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.HelpCtx;
import org.openide.util.Lookup;
import org.openide.util.WeakListeners;

@OptionsPanelController.SubRegistration(location = "Appearance", displayName = "#AdvancedOption_DisplayName_AdditionalCloseActions", keywords = "#AdvancedOption_Keywords_AdditionalCloseActions", keywordsCategory = "Appearance/AdditionalCloseActions", position = 100)
@org.openide.util.NbBundle.Messages({ "AdvancedOption_DisplayName_AdditionalCloseActions=Additional Close Actions",
		"AdvancedOption_Keywords_AdditionalCloseActions=action,actions,close,editor,project,left,right,git,subversion,mercurial,vcs,version,control,system,diff,search,history" })
public final class AdditionalCloseActionsOptionsPanelController extends OptionsPanelController implements ChangeListener {
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	private AdditionalCloseActionsPanel panel;

	private boolean changed;

	@Override
	public void update() {
		getOrCreatePanel().load();
		changed = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyChanges() {
		SwingUtilities.invokeLater(() -> {
			getOrCreatePanel().store();
			changed = false;
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void cancel() {
		// need not do anything special, if no changes have been persisted yet
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isValid() {
		return getOrCreatePanel().valid();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isChanged() {
		return changed;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HelpCtx getHelpCtx() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JComponent getComponent(Lookup masterLookup) {
		return getOrCreatePanel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(l);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removePropertyChangeListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(l);
	}

	private AdditionalCloseActionsPanel getOrCreatePanel() {
		if (panel == null) {
			panel = new AdditionalCloseActionsPanel();
			panel.addChangeListener(WeakListeners.change(this, panel));
		}

		return panel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if (!changed) {
			changed = true;
			pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, false, true);
		}

		pcs.firePropertyChange(OptionsPanelController.PROP_VALID, null, null);
	}

}
