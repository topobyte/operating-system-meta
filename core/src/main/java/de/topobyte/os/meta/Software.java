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

import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.topobyte.processutils.ProcessRunner;

public class Software
{

	final static Logger logger = LoggerFactory.getLogger(Software.class);

	public static VersionInfo getInkscapeVersionInfo()
	{
		logger.info("Checking installed inkscape version");
		int major = -1;
		int minor = -1;
		int patch = -1;
		try {
			Process process = new ProcessBuilder("inkscape", "--version")
					.start();
			ProcessRunner runner = new ProcessRunner(process);
			int returnCode = runner.waitForEnd();
			if (returnCode != 0) {
				return new VersionInfo(false);
			}

			String versionOutput = new String(runner.getStdOut(),
					StandardCharsets.UTF_8);

			Pattern pattern = Pattern
					.compile("Inkscape (\\d+)\\.(\\d+)\\.(\\d+).*");
			Matcher matcher = pattern.matcher(versionOutput);
			if (matcher.find()) {
				major = Integer.parseInt(matcher.group(1));
				minor = Integer.parseInt(matcher.group(2));
				patch = Integer.parseInt(matcher.group(3));
			}
		} catch (Throwable e) {
			return new VersionInfo(false);
		}

		logger.info("Detected version " + major + "." + minor + "." + patch);
		return new VersionInfo(major, minor, patch);
	}

}
