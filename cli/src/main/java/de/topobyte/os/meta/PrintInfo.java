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

public class PrintInfo
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Detecting Operating System basics...");
		if (OS.isWindows()) {
			System.out.println("This is Windows");
		} else if (OS.isMacOs()) {
			System.out.println("This is macOS");
		} else if (OS.isAndroid()) {
			System.out.println("This is Android");
		} else if (OS.isLinux()) {
			System.out.println("This is Linux");
			LinuxInfo linuxInfo = Linux.getLinuxInfo();
			System.out.println("Distributor: " + linuxInfo.getDistributorId());
			System.out.println("Description: " + linuxInfo.getDescription());
			System.out.println("Release: " + linuxInfo.getRelease());
			System.out.println("Codename: " + linuxInfo.getCodename());

			VersionInfo inkscape = Software.getInkscapeVersionInfo();
			if (inkscape.isInstalled()) {
				System.out.printf("Inkscape: %d.%d.%d%n", inkscape.getMajor(),
						inkscape.getMinor(), inkscape.getPatch());
			} else {
				System.out.println("Inkscape: not found");
			}
		}
	}
}
