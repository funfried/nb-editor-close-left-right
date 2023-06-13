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

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.funfried.netbeans.plugins.editor.closeleftright.yenta.Yenta;

public class Installer extends Yenta {
	private static final long serialVersionUID = -1116541188000901765L;

	@Override
	protected Set<String> friends() {
		// Exposes an API, just not to us.
		return Collections.emptySet();
	}

	@Override
	protected Set<String> siblings() {
		return new HashSet<>(Arrays.asList("org.netbeans.core.windows", "org.netbeans.modules.subversion", "org.netbeans.modules.mercurial"));
	}
}
