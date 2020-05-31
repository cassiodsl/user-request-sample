package com.userrequest.sample.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.userrequest.sample.factory.FactoryProvider;
import com.userrequest.sample.factory.IFileTypeFactory;
import com.userrequest.sample.util.NoCommandMatchAvailable;
import com.userrequest.sample.util.NoFactoryDetectedException;

public class FileTypeServiceTest {

	@Test
	public void whenSimpleFactory_CheckFactoryWasBuilt() throws NoFactoryDetectedException {
		IFileTypeFactory factory = new FactoryProvider().getFactory("simple");
		assertNotNull(factory);
	}

	@Test(expected = NoFactoryDetectedException.class)
	public void whenNoFactoryDefined_ThrowNoFactoryDetectedException() throws NoFactoryDetectedException {
		new FactoryProvider().getFactory(null);
	}

	@Test(expected = NoFactoryDetectedException.class)
	public void whenNoMatchFactoryDefined_ThrowNoFactoryDetectedException() throws NoFactoryDetectedException {
		new FactoryProvider().getFactory("testNoFactory");
	}

	@Test
	public void whenRegister_ReturnRegisterFormCommand() {

		IFileService service = new TypeFileService();
		String file = null;
		try {
			file = service.getFile("register");
		} catch (NoCommandMatchAvailable e) {
			e.printStackTrace();
		}
		assertEquals(file, "RegisterFormCommand");
	}

	@Test
	public void whenAttachment_ReturnAttachmentCommand() {

		IFileService service = new TypeFileService();
		String file = null;
		try {
			file = service.getFile("attachment");
		} catch (NoCommandMatchAvailable e) {
			e.printStackTrace();
		}
		assertEquals(file, "AttachmentCommand");
	}

	@Test
	public void whenRequest_ReturnRequestSummaryCommand() {

		IFileService service = new TypeFileService();
		String file = null;
		try {
			file = service.getFile("request");
		} catch (NoCommandMatchAvailable e) {
			e.printStackTrace();
		}
		assertEquals(file, "RequestSummaryCommand");
	}

	@Test(expected = NoCommandMatchAvailable.class)
	public void whenIvalid_ThrowNoCommandMatchAvailable() throws NoCommandMatchAvailable {

		IFileService service = new TypeFileService();
		service.getFile("");
	}

	@Test(expected = NoCommandMatchAvailable.class)
	public void whenNull_ThrowNoCommandMatchAvailable() throws NoCommandMatchAvailable {

		IFileService service = new TypeFileService();
		service.getFile(null);
	}
	
	@Test
	public void whenNoFactory_ReturnNullFile() throws NoCommandMatchAvailable, NoFactoryDetectedException {

		IFileService service = new TypeFileService();
		service.setFactoryName("test");
		String file = service.getFile(null);
		assertNull(file);
	}

}
