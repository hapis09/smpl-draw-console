package hfz.code.smpldrawconsole.tools;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandType;

import java.util.List;

public class FillExecute extends AbstractCommand{

    ConfigCommand configCommand;

    @Override
    public void execute(List<String> param, CommandType mainCommand) throws InvalidCommandException {
        //validate param
        configCommand = new ConfigCommand();
        configCommand.validateParam(param, mainCommand);

        int x = Integer.parseInt(param.get(0));
        int y = Integer.parseInt(param.get(1));
        char fillChar = param.get(2).charAt(0);

        String getFill = fillBlank(x,y,fillChar);
        System.out.println(getFill);
    }

    public String fillBlank(int x, int y, char c){
        if (shape[x][y] != 0){
            return "";
        }

        if (x > 0 || x < height || y > 0 || y <height){
            if (shape[x][y] == 0)
                shape[x][y] = c;
            fillBlank(x + 1, y, c);
            fillBlank(x - 1, y, c);
            fillBlank(x, y + 1, c);
            fillBlank(x, y - 1, c);
        }
        return shapeAsString();
    }
}
