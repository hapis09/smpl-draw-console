package hfz.code.smpldrawconsole.model;

import java.util.HashMap;
import java.util.Map;

public enum  CommandType {

    CANVAS("C", 2),
    LINE("L", 4),
    RECTANGLE("R", 4),
    FILL("B", 3),
    QUIT("Q", 0);

    private static final Map<String, CommandType> lookup = new HashMap<>();

    static {
        for (CommandType t : CommandType.values()) {
            lookup.put(t.mainCommand, t);
        }
    }

    private final String mainCommand;
    private final int numParams;

    private CommandType(String mainCommand, int numParams) {
        this.mainCommand = mainCommand;
        this.numParams = numParams;
    }

    public String toString(){
        return this.mainCommand;
    }

    public static CommandType get(String mainCommand){
        return lookup.get(mainCommand);
    }
}
