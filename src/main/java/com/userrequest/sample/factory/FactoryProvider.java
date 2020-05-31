package com.userrequest.sample.factory;

import com.userrequest.sample.util.NoFactoryDetectedException;

public class FactoryProvider {
	
	public IFileTypeFactory getFactory(String name) throws NoFactoryDetectedException {
		if("simple".equals(name)) {
			return new SimpleFileFactory();
		}
		// add more options if needed
		throw new NoFactoryDetectedException();
	}

}
