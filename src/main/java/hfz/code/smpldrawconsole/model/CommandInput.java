package hfz.code.smpldrawconsole.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CommandInput {

    private CommandType commandType;
    private List<String> params;

    public CommandInput(String input){
        String[] item = input.split(" ");
        this.commandType = CommandType.get(item[0].toUpperCase());
        this.params = new ArrayList<String>();
        for (int i = 1; i < item.length; i++){
            this.params.add(item[i]);
        }
    }
}
