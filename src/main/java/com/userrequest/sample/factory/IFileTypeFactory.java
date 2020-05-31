package com.userrequest.sample.factory;

import com.userrequest.sample.command.IFileTypeCommand;
import com.userrequest.sample.util.NoCommandMatchAvailable;

public interface IFileTypeFactory {

	public IFileTypeCommand getCommand(CommandTO data) throws NoCommandMatchAvailable;

}
