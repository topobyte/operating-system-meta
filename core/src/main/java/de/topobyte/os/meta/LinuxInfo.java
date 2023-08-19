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

public class LinuxInfo
{

	private String distributorId = null;
	private String description = null;
	private String release = null;
	private String codename = null;

	public LinuxInfo(String distributorId, String description, String release,
			String codename)
	{
		super();
		this.distributorId = distributorId;
		this.description = description;
		this.release = release;
		this.codename = codename;
	}

	public String getDistributorId()
	{
		return distributorId;
	}

	public String getDescription()
	{
		return description;
	}

	public String getRelease()
	{
		return release;
	}

	public String getCodename()
	{
		return codename;
	}

}
