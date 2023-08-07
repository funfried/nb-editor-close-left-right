/*
 * Copyright (c) 2022 Airtango.
 * All rights reserved.
 */

package de.funfried.netbeans.plugins.editor.closeleftright.vcs;

import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.netbeans.libs.git.GitClient;
import org.netbeans.libs.git.GitException;
import org.netbeans.libs.git.GitRepository;
import org.netbeans.libs.git.GitStatus;
import org.netbeans.libs.git.progress.ProgressMonitor;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author fbahle
 */
public interface GitUtils {
	static Boolean isModified(FileObject fileObject) {
		GitStatus.Status status = getStatus(fileObject);
		if (status == null) {
			return null;
		}

		return !GitStatus.Status.STATUS_NORMAL.equals(status);
	}

	static GitStatus.Status getStatus(FileObject fileObject) {
		if (fileObject != null) {
			ProgressMonitor progressMonitor = new ProgressMonitor.DefaultProgressMonitor();

			GitRepository gitRepo = GitUtils.getRepo(fileObject);
			if (gitRepo != null) {
				GitClient client = null;
				try {
					client = gitRepo.createClient();

					File file = FileUtil.toFile(fileObject);
					if (file != null) {
						Map<File, GitStatus> status = client.getStatus(new File[] { file }, progressMonitor);
						if (status != null) {
							GitStatus gitStatus = status.get(file);
							if (gitStatus != null) {
								return gitStatus.getStatusIndexWC();
							}
						}
					}
				} catch (GitException ex) {
					Logger.getLogger(GitUtils.class.getName()).log(Level.WARNING, "Fetching git status ran into", ex);
				} finally {
					if (client != null) {
						client.release();
					}
				}
			}
		}

		return null;
	}

	static GitRepository getRepo(FileObject fileObject) {
		FileObject gitRepoDirectory = getRepoDirectory(fileObject);
		if (gitRepoDirectory != null) {
			File file = FileUtil.toFile(gitRepoDirectory);
			if (file != null) {
				return GitRepository.getInstance(file);
			}
		}

		return null;
	}

	static FileObject getRepoDirectory(FileObject fileObject) {
		FileObject fileObj = fileObject;
		while (fileObj != null) {
			if (fileObj.isFolder() && fileObj.getFileObject(".git", "") != null) {
				return fileObj;
			}

			fileObj = fileObj.getParent();
		}

		return null;
	}
}
