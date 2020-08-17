package hfz.code.smpldrawconsole.tools;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandType;

import java.util.List;

public class CanvasExecute extends AbstractCommand {

    private static final char HORIZONTAL_EDGE_CHAR = '-';
    private static final char VERTICAL_EDGE_CHAR   = '|';

    @Override
    public void execute(List<String> param, CommandType mainCommand) throws InvalidCommandException {
        if (param.size() < 2){
            throw new InvalidCommandException("ERR - Invalid Command Canvas, requires 2 parameters");
        }

        setWidth(Integer.parseInt(param.get(0)));
        setHeight(Integer.parseInt(param.get(1)));

        String canvasFinal = drawCanvas();

        System.out.println(canvasFinal);

    }

    public String drawCanvas(){
        shape = new char[height + 2][width];
        //Upper Line
        draw(0, 0, width - 1, 0, HORIZONTAL_EDGE_CHAR);
        //Left Line
        draw(0, 1, 0, height + 1, VERTICAL_EDGE_CHAR);
        //Lower Line
        draw(0, height + 1, width - 1, height + 1, HORIZONTAL_EDGE_CHAR);
        //Right Line
        draw(width - 1, 1, width - 1, height, VERTICAL_EDGE_CHAR);

        return shapeAsString();
    }
}
