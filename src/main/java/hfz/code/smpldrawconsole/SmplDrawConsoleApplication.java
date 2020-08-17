package hfz.code.smpldrawconsole;

import hfz.code.smpldrawconsole.exception.InvalidCommandException;
import hfz.code.smpldrawconsole.model.CommandInput;
import hfz.code.smpldrawconsole.model.CommandType;
import hfz.code.smpldrawconsole.tools.Command;
import hfz.code.smpldrawconsole.tools.ConfigCommand;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmplDrawConsoleApplication {


	private ConfigCommand configCommand;

	public static void main(String[] args) {
		instruction();
		SmplDrawConsoleApplication app = new SmplDrawConsoleApplication();

		try (Scanner scanner = new Scanner(System.in)){
			while (true){
				try {
					System.out.print("enter command: ");
					app.commandProcess(scanner.nextLine());
				} catch (Exception ex){
					System.err.println(ex.getMessage());
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private void commandProcess(final String commandLine) throws InvalidCommandException{

		//Validate Config
		validateCommand(commandLine);

		CommandInput commandInput = new CommandInput(commandLine);
		if (configCommand == null){
			if (!(commandInput.getCommandType().equals(CommandType.CANVAS) || commandInput
					.getCommandType().equals(CommandType.QUIT))){
				throw new InvalidCommandException(
						"Canvas is not ready for drawing, please create a canvas first with C <width> <height>");
			}else {
				configCommand = new ConfigCommand();
			}
		}
		//setCommand
		configCommand.setCommand(commandInput);
		configCommand.executeCommand(commandInput.getParams(), commandInput.getCommandType());
	}

	private final Pattern pattern = Pattern
			.compile("[a-zA-Z]{1}(\\s\\d+)*(\\s[a-zA-z]{1})?+");

	public void validateCommand(String commandInput)throws InvalidCommandException{
		Matcher matcher = pattern.matcher(commandInput);
		if (!matcher.matches()){
			throw new InvalidCommandException("Invalid Command Input");
		}
	}

	private static void instruction() {

		String inst = "the program work as follows:\n" +
				" 1. Create a new canvas surface\n" +
				" 2. Start drawing on the canvas surface by issuing various commands\n" +
				" 3. Quit \n\n\n" +
				"Command \t\tDescription\n" +
						"C w h           Should create a new canvas surface of width w and height h.\n" +
						"L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" +
						"                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
						"                will be drawn using the 'x' character.\n" +
						"R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" +
						"                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
						"                using the 'x' character.\n" +
						"B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" +
						"                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
						"                programs.\n" +
						"Q               Should quit the program.\n";
		System.out.println(inst);
	}

}
