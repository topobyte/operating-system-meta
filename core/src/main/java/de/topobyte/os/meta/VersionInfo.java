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

public class VersionInfo
{

	private boolean installed = false;

	private int major;
	private int minor;
	private int patch;

	public VersionInfo(boolean installed)
	{
		this.installed = installed;
	}

	public VersionInfo(int major, int minor, int patch)
	{
		installed = true;
		this.major = major;
		this.minor = minor;
		this.patch = patch;
	}

	public boolean isInstalled()
	{
		return installed;
	}

	public int getMajor()
	{
		return major;
	}

	public int getMinor()
	{
		return minor;
	}

	public int getPatch()
	{
		return patch;
	}

}
