package hfz.code.smpldrawconsole.tools;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandType;

import java.util.List;

public class RectangleExecute extends  AbstractCommand{

    ConfigCommand configCommand;

    private static final char LINE_CHAR = 'x';

    @Override
    public void execute(List<String> param, CommandType mainCommand) throws InvalidCommandException {
        //validate param
        configCommand = new ConfigCommand();
        configCommand.validateParam(param, mainCommand);

        int x1 = Integer.parseInt(param.get(0));
        int y1 = Integer.parseInt(param.get(1));
        int x2 = Integer.parseInt(param.get(2));
        int y2 = Integer.parseInt(param.get(3));

        //validate node
        validate(x1,y1,x2,y2);

        String getRectangle = drawRectangle(x1,y1,x2,y2);
        System.out.println(getRectangle);
    }

    private String drawRectangle(int x1, int y1, int x2, int y2) {
        //Draw Rectangle
        draw(x1, y1, x2, y1, LINE_CHAR);
        draw(x1, y1, x1, y2, LINE_CHAR);
        draw(x2, y1, x2, y2, LINE_CHAR);
        draw(x1, y2, x2, y2, LINE_CHAR);

        return shapeAsString();
    }
}
