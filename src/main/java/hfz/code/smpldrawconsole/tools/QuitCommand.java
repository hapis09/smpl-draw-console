package hfz.code.smpldrawconsole.tools;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandType;

import java.util.List;

public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(List<String> param, CommandType mainCommand) throws InvalidCommandException {
        System.exit(0);
    }
}
