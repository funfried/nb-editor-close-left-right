/*
 * Copyright (c) 2022 Airtango.
 * All rights reserved.
 */

package de.funfried.netbeans.plugins.editor.closeleftright.vcs;

import java.io.File;

import org.netbeans.modules.subversion.FileInformation;
import org.netbeans.modules.subversion.Subversion;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author fbahle
 */
public interface SvnUtils {
	static Boolean isModified(FileObject fileObject) {
		int status = getStatus(fileObject);
		if (status == FileInformation.STATUS_UNKNOWN || status == FileInformation.STATUS_NOTVERSIONED_NOTMANAGED) {
			return null;
		}

		return (status & FileInformation.STATUS_LOCAL_CHANGE) != 0;
	}

	static int getStatus(FileObject fileObject) {
		if (fileObject != null) {
			File file = FileUtil.toFile(fileObject);
			if (file != null) {
				FileInformation fileInformation = Subversion.getInstance().getStatusCache().getStatus(file);
				if (fileInformation != null) {
					return fileInformation.getStatus();
				}
			}
		}

		return FileInformation.STATUS_UNKNOWN;
	}
}
