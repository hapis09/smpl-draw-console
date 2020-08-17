package hfz.code.smpldrawconsole.tools;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandInput;
import hfz.code.smpldrawconsole.model.CommandType;

import java.util.List;

public class ConfigCommand {

    private AbstractCommand command;

    public void setCommand(final CommandInput commandInput)
        throws InvalidCommandException{
        AbstractCommand mainCommand = getMainCommand(commandInput);
        if (this.command != null){
            mainCommand.setHeight(this.command.getHeight());
            mainCommand.setWidth(this.command.getWidth());
            mainCommand.setShape(this.command.getShape());
        }

        this.command = mainCommand;
    }

    public final AbstractCommand getMainCommand(CommandInput commandInput)
        throws InvalidCommandException{
        switch (commandInput.getCommandType()){
            case CANVAS:
                return new CanvasExecute();
            case LINE:
                return new LineExecute();
            case RECTANGLE:
                return new RectangleExecute();
            case FILL:
                return new FillExecute();
            case QUIT:
                return new QuitCommand();
            default:
                throw new InvalidCommandException("Invalid Command!");
        }
    }

    public void executeCommand(final List<String> params, CommandType mainCommand)throws InvalidCommandException{
        command.execute(params, mainCommand);
    }

    public void validateParam(List<String> param, CommandType mainCommand) throws InvalidCommandException{
        if (param.size() < 2 && mainCommand.name().equals("CANVA")){
            throw new InvalidCommandException("ERR - Invalid Command "+ mainCommand.name() + ", requires 2 parameter");
        }else if (param.size() < 3 && mainCommand.name().equals("FILL")){
            throw new InvalidCommandException("ERR - Invalid Command "+ mainCommand.name() + ", requires 3 parameters");
        }else if (param.size() < 4 && (mainCommand.name().equals("LINE") || mainCommand.name().equals("RECTANGLE"))){
            throw new InvalidCommandException("ERR - Invalid Command "+ mainCommand.name() + ", requires 4 parameter");
        }

    }

//    public Command getCommand(String commandLine) throws InvalidCommandException{
//        Canvas canvas = new Canvas();
//        commandLine = commandLine.trim().replaceAll(" {2}", " ");
//        String[] split = commandLine.split(" ");
//        String mainCommand = split[0].toUpperCase();
//        String[] params = Arrays.copyOfRange(split, 1, split.length);
//
//    }
}
