// Copyright 2023 Sebastian Kuerten
//
// This file is part of operating-system-meta.
//
// operating-system-meta is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// operating-system-meta is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with operating-system-meta. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.os.meta;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.topobyte.processutils.ProcessRunner;

public class Linux
{

	public static LinuxInfo getLinuxInfo() throws IOException
	{
		Process process = new ProcessBuilder("lsb_release", "-a").start();
		ProcessRunner runner = new ProcessRunner(process);
		int returnCode = runner.waitForEnd();
		if (returnCode != 0) {
			throw new IOException(
					"Unable to determine version info using 'lsb_release'");
		}
		Map<String, String> map = new HashMap<>();

		String stdOut = new String(runner.getStdOut(), StandardCharsets.UTF_8);
		List<String> lines = Arrays.asList(stdOut.split("\\r?\\n"));
		for (String line : lines) {
			List<String> parts = Arrays.asList(line.split(":"));
			if (parts.size() != 2) {
				continue;
			}
			String key = parts.get(0).trim();
			String value = parts.get(1).trim();
			map.put(key, value);
		}

		return new LinuxInfo(map.get("Distributor ID"), map.get("Description"),
				map.get("Release"), map.get("Codename"));
	}

}
