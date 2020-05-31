package com.userrequest.sample.service;

import com.userrequest.sample.factory.CommandTO;
import com.userrequest.sample.factory.FactoryProvider;
import com.userrequest.sample.factory.IFileTypeFactory;
import com.userrequest.sample.util.NoCommandMatchAvailable;
import com.userrequest.sample.util.NoFactoryDetectedException;

public class TypeFileService implements IFileService {

	private IFileTypeFactory factory;
	private String factoryName;

	public TypeFileService() {
		this.factoryName = "simple"; // default
	}

	public String getFile(String fileType) throws NoCommandMatchAvailable {
		try {
			setFactory();
			CommandTO options = new CommandTO();
			options.setName(fileType);
			return this.factory.getCommand(options).execute();
		} catch (NoFactoryDetectedException e) {
			// check
			e.printStackTrace();
		}
		return null;

	}

	public void setFactoryName(String fName) {
		this.factoryName = fName;
	}
	
	private void setFactory() throws NoFactoryDetectedException {
		this.factory = new FactoryProvider().getFactory(factoryName);
	}

}
