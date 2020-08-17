package hfz.code.smpldrawconsole.tools;


import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
public abstract class AbstractCommand implements Command{

    protected int width;
    protected int height;
    protected char[][] shape;

    private static final String LINE_SEPERATOR = System
            .getProperty("line.separator");

    public void draw(int x1, int y1, int x2, int y2, char drawChar) {
        if (x1 == x2) {
            // vertical line
            for (int i = y1; i <= y2; i++) {
                shape[i][x1] = drawChar;
            }
        } else if (y1 == y2) {
            // horizontal line
            Arrays.fill(shape[y1], x1, x2 + 1, drawChar);
        } else {
            // we have a slope
            double slope = (double) (y2 - y1) / (double) (x2 - x1);
            for (int i = y1; i <= y2; i++) {
                shape[i][(int) Math.ceil(x1 + (slope * i))] = drawChar;
            }
        }
    }

    public String shapeAsString(){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shape.length; ++i){
            for (int j = 0; j < shape[i].length; j++){
                result.append((shape[i][j]) == 0 ? " " : shape[i][j]);
            }
            result.append(LINE_SEPERATOR);
        }
        return result.toString();
    }

    public void validate(int x1, int y1, int x2, int y2)
            throws InvalidCommandException {
        if (x1 >= 1 && y1 >= 1 && x2 >= 1 && y2 >= 1 && x1 < width
                && y1 < height && x2 < width && y2 < height && x1 <= x2
                && y1 <= y2) {
            return;
        }
        throw new InvalidCommandException(
                "Points are beyond the canvas borders or incorrect co-ordinates");
    }
}
