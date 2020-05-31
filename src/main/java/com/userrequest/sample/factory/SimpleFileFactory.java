package com.userrequest.sample.factory;

import com.userrequest.sample.command.AttachmentCommand;
import com.userrequest.sample.command.IFileTypeCommand;
import com.userrequest.sample.command.RegisterFormCommand;
import com.userrequest.sample.command.RequestSummaryCommand;
import com.userrequest.sample.util.NoCommandMatchAvailable;

public class SimpleFileFactory extends AbstractFileTypeFactory {

	public IFileTypeCommand getCommand(CommandTO data) throws NoCommandMatchAvailable {
		// it could be an Enum or whatever you decide to use
		if(data.getName() == null ) {
			throw new NoCommandMatchAvailable();
		}
		switch (data.getName()) {
		case "request":
			return new RequestSummaryCommand();
		case "attachment":
			return new AttachmentCommand();
		case "register":
			return new RegisterFormCommand();
		default:
			throw new NoCommandMatchAvailable();
		}
	}

}
