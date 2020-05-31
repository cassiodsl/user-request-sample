package com.userrequest.sample.service;

import com.userrequest.sample.util.NoCommandMatchAvailable;

public interface IFileService {

	public String getFile(String fileType) throws NoCommandMatchAvailable;
	public void setFactoryName(String fName);
}
