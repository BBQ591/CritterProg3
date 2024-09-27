package assignment;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Arrays;
/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */


public class Interpreter implements CritterInterpreter {
	// returns true if the input is an integer. Otherwise, returns false.
	private boolean isInt(String integer) {

		try {
			Integer.parseInt(integer);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	//go command
	public int go(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(currBehavior.get(1).charAt(0) == '+' && isInt(currBehavior.get(1).substring(1))) {
			currStep += Integer.parseInt(currBehavior.get(1).substring(1)) - 1;
		} else if (currBehavior.get(1).charAt(0) == '-'&& isInt(currBehavior.get(1).substring(1))) {
			currStep -= Integer.parseInt(currBehavior.get(1).substring(1)) - 1;
		} else if (currBehavior.get(1).charAt(0) == 'r'&& isInt(currBehavior.get(1).substring(1))) {
			currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
		} else if (isInt(currBehavior.get(1))) {
			currStep = Integer.parseInt(currBehavior.get(1)) - 1;
		}
		//if this is an invalid go command
		else {
			System.err.println("Not valid go");
			return -1;
		}
		return currStep;
	}
	//ifrandom command
	public int ifrandom(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(c.ifRandom()) {
			if (currBehavior.get(1).charAt(0) == 'r' && isInt(currBehavior.get(1).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(1))) {
				currStep = Integer.parseInt(currBehavior.get(1)) - 1;
			}
			//if this is an invalid ifrandom command
			else {
				return -1;
			}
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//ifstarving command
	public int ifstarving(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(c.getHungerLevel() == Critter.HungerLevel.STARVING) {
			if (currBehavior.get(1).charAt(0) == 'r'&&isInt(currBehavior.get(1).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(1))) {
				currStep = Integer.parseInt(currBehavior.get(1)) - 1;
			}
			//if the ifstarving inputs are wrong
			else {
				return -1;
			}
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//isempty command
	public int ifempty(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(isInt(currBehavior.get(1))&&c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 0) {
			if (currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			// if the inputs for ifempty are not valid
			else {
				return -1;
			}
		}
		//if input is invalid
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
//ifhungry command
	public int ifhungry(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
			if (currBehavior.get(1).charAt(0) == 'r'&&isInt(currBehavior.get(1).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(1))) {
				currStep = Integer.parseInt(currBehavior.get(1)) - 1;
			}
			//if input is invalid
			else {
				return -1;
			}
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//ifally command
	public int ifally(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(isInt(currBehavior.get(1))&&c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 3) {
			if (currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			// if the input is invalid
			else {
				return -1;
			}
		}
		//if the input is invalid
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//ifenemy command
	public int ifenemy(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(isInt(currBehavior.get(1)) && c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 2) {
			if (currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			//if the input is invalid
			else {
				return -1;
			}
		}
		//if the input is invalid
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//ifwall command
	public int ifwall(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(isInt(currBehavior.get(1))&&c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 1) {
			if (isInt(currBehavior.get(2).substring(1))&&currBehavior.get(2).charAt(0) == 'r') {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			//invalid input
			else {
				return -1;
			}
		}
		//invalid input
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//ifangle command
	public int ifangle(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if(isInt(currBehavior.get(1))&&isInt(currBehavior.get(2))&&c.getOffAngle(Integer.parseInt(currBehavior.get(1))) == Integer.parseInt(currBehavior.get(2))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			//if the input is invalid
			else {
				return -1;
			}
		}
		//if input is invalid
		else if (!isInt(currBehavior.get(1))|| !isInt(currBehavior.get(2))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//iflt command
	public int iflt(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if (isInt(currBehavior.get(1).substring(1))&&isInt(currBehavior.get(2).substring(1))&&c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) < c.getReg(Integer.parseInt(currBehavior.get(2).substring(1)))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}

			//if input is invalid
			else {
				return -1;
			}
		}
		//if input is invalid
		else if (!isInt(currBehavior.get(1).substring(1))|| !isInt(currBehavior.get(2).substring(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	// ifeq behavior
	public int ifeq(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if (isInt(currBehavior.get(1).substring(1))&&isInt(currBehavior.get(2).substring(1)) &&c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) == c.getReg(Integer.parseInt(currBehavior.get(2).substring(1)))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			// if the inputs are invalid
			else {
				return -1;
			}
		}
		// if the input is invalid
		else if (!isInt(currBehavior.get(1).substring(1))|| !isInt(currBehavior.get(2).substring(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	//ifgt function
	public int ifgt(Critter c, ArrayList<String> currBehavior, int currStep) {
		// checking the different possibilities for the input and updating currStep
		if (isInt(currBehavior.get(1).substring(1))&&isInt(currBehavior.get(2).substring(1)) && c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) > c.getReg(Integer.parseInt(currBehavior.get(2).substring(1)))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			//invalid inputs
			else {
				return -1;
			}
		}
		//invalid inputs
		else if (!isInt(currBehavior.get(1).substring(1))|| !isInt(currBehavior.get(2).substring(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}



	public void executeCritter(Critter c) {
		ArrayList<ArrayList<String>> behaviors = new ArrayList<>(c.getCode());
		// loading in the behavior that this critter left off on
		int currStep = c.getNextCodeLine() -1;
		if(currStep >= behaviors.size()) {
			System.err.println("critter instructions point to invalid line");
			return;
		}
		//loading in critter behaviors
		ArrayList<String> currBehavior = behaviors.get(currStep);
		//while loops keeps running until it detects an action command
		while(!currBehavior.get(0).equals("hop") && !currBehavior.get(0).equals("left") && !currBehavior.get(0).equals("right") && !currBehavior.get(0).equals("eat") && !currBehavior.get(0).equals("infect") ) {
			//the following if statements figure out what command currStep is on and runs the respective function to update currStep.
			if(currBehavior.get(0).equals("go") && currBehavior.size() == 2) {
				currStep = go(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifrandom") && currBehavior.size() == 2) {
				currStep = ifrandom(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifhungry") && currBehavior.size() == 2) {
				currStep = ifhungry(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifstarving") && currBehavior.size() == 2) {
				currStep = ifstarving(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifempty") && currBehavior.size() == 3) {
				currStep = ifempty(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifally") && currBehavior.size() == 3) {
				currStep = ifally(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifenemy") && currBehavior.size() == 3) {
				currStep = ifenemy(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifwall") && currBehavior.size() == 3) {
				currStep = ifwall(c, currBehavior, currStep);
			}
			else if(currBehavior.get(0).equals("ifangle") && currBehavior.size() == 4) {
				currStep = ifangle(c, currBehavior, currStep);
			}

			else if(currBehavior.get(0).equals("write") && currBehavior.size() == 3) {
				if (!(currBehavior.get(1).charAt(0) == 'r' && isInt(currBehavior.get(1).substring(1))&& isInt(currBehavior.get(2)))) {
					currStep = -1;
				}
				else {
					c.setReg(Integer.parseInt(currBehavior.get(1)), Integer.parseInt(currBehavior.get(2)));
					currStep += 1;
				}

			}

			else if(currBehavior.get(0).equals("add") && currBehavior.size() == 3) {
				if (!(currBehavior.get(1).charAt(0) == 'r'&&isInt(currBehavior.get(1).substring(1)) && currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1)))) {
					currStep = -1;
				}
				else {
					c.setReg(Integer.parseInt(currBehavior.get(1)), c.getReg(Integer.parseInt(currBehavior.get(2))) + c.getReg(Integer.parseInt(currBehavior.get(1))));
					currStep += 1;
				}
			}
			else if(currBehavior.get(0).equals("sub") && currBehavior.size() == 3) {
				if (!(currBehavior.get(1).charAt(0) == 'r'&&isInt(currBehavior.get(1).substring(1)) && currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1)))) {
					currStep = -1;
				}
				else {
					c.setReg(Integer.parseInt(currBehavior.get(1)), c.getReg(Integer.parseInt(currBehavior.get(2))) - c.getReg(Integer.parseInt(currBehavior.get(1))));
					currStep += 1;
				}
			}
			else if(currBehavior.get(0).equals("inc") && currBehavior.size() == 2) {
				if (!(currBehavior.get(1).charAt(0) == 'r' && isInt(currBehavior.get(1).substring(1)))) {
					currStep = -1;
				}
				else {
					c.setReg(Integer.parseInt(currBehavior.get(1)), c.getReg(Integer.parseInt(currBehavior.get(1))) + 1);
					currStep += 1;
				}
			}
			else if(currBehavior.get(0).equals("dec") && currBehavior.size() == 2) {
				if (!(currBehavior.get(1).charAt(0) == 'r' && isInt(currBehavior.get(1).substring(1)))) {
					currStep = -1;
				}
				else {
					c.setReg(Integer.parseInt(currBehavior.get(1)), c.getReg(Integer.parseInt(currBehavior.get(2))) -1);
					currStep += 1;
				}
			}
			else if (currBehavior.get(0).equals("iflt") && currBehavior.size() == 4) {
				currStep = iflt(c, currBehavior, currStep);
			}
			else if (currBehavior.get(0).equals("ifeq") && currBehavior.size() == 4) {
				currStep = ifeq(c, currBehavior, currStep);
			}
			else if (currBehavior.get(0).equals("ifgt") && currBehavior.size() == 4) {
				currStep = ifgt(c, currBehavior, currStep);
			}
			else {
				System.err.println("Critter Instructions Invalid");
				return;
			}
			if(currStep >= behaviors.size()-1 || currStep < 0) {
				System.err.println("critter instructions point to invalid line");
				return;
			}
			//updating currBehavior
			currBehavior = behaviors.get(currStep);
		}
		//the following if statements run the action command
		if(currBehavior.get(0).equals("hop")) {
			c.hop();
		}
		else if(currBehavior.get(0).equals("left")) {
			c.left();
		}
		else if(currBehavior.get(0).equals("right")) {
			c.right();
		}
		else if(currBehavior.get(0).equals("eat")) {
			c.eat();
		}
		else if(currBehavior.get(0).equals("infect")) {
			if(currBehavior.size() == 2) {
				//make function that detects if the input is a register or not. that is the only thing that we are doing
				if (currBehavior.get(1).charAt(0) == 'r' && isInt(currBehavior.get(1).substring(1))) {
					c.infect(c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))));
				}
				else if (isInt(currBehavior.get(1))) {
					c.infect(Integer.parseInt(currBehavior.get(1)));
				}
				else {
					System.err.println("This infect is not possible");
					return;
				}
			}
			else{
				c.infect();
			}
		}
		else {
			System.err.println("Critter Instructions Invalid");
			return;
		}
		//updating the last behavior that this critter has run
		c.setNextCodeLine(currStep+2);
	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
		ArrayList<ArrayList<String>> critterBehavior = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		//reading in name
		String name = reader.readLine();

		//reading in input file and saving them as behaviors in the following format: [string behavior, input1, input2, ..., inputN]
		String currLine = reader.readLine();
		while (!currLine.isEmpty()) {
			critterBehavior.add(new ArrayList<>(Arrays.asList(currLine.split(" "))));
			currLine = reader.readLine();
		}
		reader.close();
		//end of reading in behaviors
		return new CritterSpecies(name, critterBehavior);
	}
}
