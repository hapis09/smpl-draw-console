package hfz.code.smpldrawconsole.tools;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandType;

import java.util.List;

public interface Command {

    public void execute(List<String> param, CommandType mainCommand) throws InvalidCommandException;
}
