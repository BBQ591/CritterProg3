package assignment;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Method;
/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */


public class Interpreter implements CritterInterpreter {


//	public static HashMap<String, HashMap<Integer, ArrayList<Integer>>> allPaths = new HashMap<>();
//	private boolean isValidPath(ArrayList<Integer> path, String name) {
//		for (int i = 0; i < path.size()-1; i++) {
//			if (!allPaths.containsKey(name) && allPaths.get(name).get(path.get(i)).contains(path.get(i+1))) {
//				return false;
//			}
//		}
//		return true;
//	}
//	private void createTrees() {
//		allPaths.put("Rover", new HashMap<>());
//		allPaths.get("Rover").put(0, new ArrayList<>());
//		allPaths.get("Rover").get(0).add(1);
//		allPaths.get("Rover").get(0).add(9);
//		//if hungry
//		allPaths.get("Rover").put(9, new ArrayList<>());
//		allPaths.get("Rover").get(9).add(10);
//		allPaths.get("Rover").get(9).add(12);
//		//ifempty
//		allPaths.get("Rover").put(1, new ArrayList<>());
//		allPaths.get("Rover").get(1).add(2);
//		allPaths.get("Rover").get(1).add(7);
//		//ifrandom
//		allPaths.get("Rover").put(2, new ArrayList<>());
//		allPaths.get("Rover").get(2).add(5);
//		allPaths.get("Rover").get(2).add(3);
//
//
//
//
//		allPaths.put("Test2", new HashMap<>());
//		allPaths.get("Test2").put(0, new ArrayList<>());
//		allPaths.get("Test2").get(0).add(1);
//		allPaths.get("Test2").get(0).add(6);
//		//if hungry
//		allPaths.get("Test2").put(1, new ArrayList<>());
//		allPaths.get("Test2").get(1).add(2);
//		allPaths.get("Test2").get(1).add(8);
//		//ifempty
//		allPaths.get("Test2").put(2, new ArrayList<>());
//		allPaths.get("Test2").get(2).add(10);
//		allPaths.get("Test2").get(2).add(3);
//		//ifrandom
//		allPaths.get("Test2").put(3, new ArrayList<>());
//		allPaths.get("Test2").get(3).add(4);
//		//ifempty
//		allPaths.get("Test2").put(10, new ArrayList<>());
//		allPaths.get("Test2").get(10).add(11);
//		allPaths.get("Test2").get(10).add(13);
//		//jdklsfalkaf;ds
//		allPaths.get("Test2").put(13, new ArrayList<>());
//		allPaths.get("Test2").get(13).add(14);
//		allPaths.get("Test2").get(13).add(16);
//
//
//
//
//		allPaths.put("Test1", new HashMap<>());
//		allPaths.get("Test1").put(0, new ArrayList<>());
//		allPaths.get("Test1").get(0).add(1);
//		allPaths.get("Test1").get(0).add(5);
//		//if hungry
//		allPaths.get("Test1").put(1, new ArrayList<>());
//		allPaths.get("Test1").get(1).add(2);
//		allPaths.get("Test1").get(1).add(12);
//		//ifempty
//		allPaths.get("Test1").put(2, new ArrayList<>());
//		allPaths.get("Test1").get(2).add(10);
//		allPaths.get("Test1").get(2).add(3);
//		//ifrandom
//		allPaths.get("Test1").put(5, new ArrayList<>());
//		allPaths.get("Test1").get(5).add(6);
//		allPaths.get("Test1").get(5).add(8);
//	}
//
//
//	public static Set<String> testedCommands = new HashSet<>();

	private boolean isInt(String integer) {
		try {
			Integer.parseInt(integer);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	public int go(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(currBehavior.get(1).charAt(0) == '+' && isInt(currBehavior.get(1).substring(1))) {
			currStep += Integer.parseInt(currBehavior.get(1).substring(1)) - 1;
		} else if (currBehavior.get(1).charAt(0) == '-'&& isInt(currBehavior.get(1).substring(1))) {
			currStep -= Integer.parseInt(currBehavior.get(1).substring(1)) - 1;
		} else if (currBehavior.get(1).charAt(0) == 'r'&& isInt(currBehavior.get(1).substring(1))) {
			currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
		} else if (isInt(currBehavior.get(1))) {
			currStep = Integer.parseInt(currBehavior.get(1)) - 1;
		}
		else {
			System.err.println("Not valid go");
			return -1;
		}
		return currStep;
	}
	public int ifrandom(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(c.ifRandom()) {
			if (currBehavior.get(1).charAt(0) == 'r' && isInt(currBehavior.get(1).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(1))) {
				currStep = Integer.parseInt(currBehavior.get(1)) - 1;
			}
			else {
				return -1;
			}
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int ifstarving(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(c.getHungerLevel() == Critter.HungerLevel.STARVING) {
			if (currBehavior.get(1).charAt(0) == 'r'&&isInt(currBehavior.get(1).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(1))) {
				currStep = Integer.parseInt(currBehavior.get(1)) - 1;
			}
			else {
				return -1;
			}
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int ifempty(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(isInt(currBehavior.get(1))&&c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 0) {
			if (currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	public int ifhungry(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
			if (currBehavior.get(1).charAt(0) == 'r'&&isInt(currBehavior.get(1).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(1))) {
				currStep = Integer.parseInt(currBehavior.get(1)) - 1;
			}
			else {
				return -1;
			}
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int ifally(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(isInt(currBehavior.get(1))&&c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 3) {
			if (currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int ifenemy(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(isInt(currBehavior.get(1)) && c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 2) {
			if (currBehavior.get(2).charAt(0) == 'r'&&isInt(currBehavior.get(2).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int ifwall(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(isInt(currBehavior.get(1))&&c.getCellContent(Integer.parseInt(currBehavior.get(1))) == 1) {
			if (isInt(currBehavior.get(2).substring(1))&&currBehavior.get(2).charAt(0) == 'r') {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(2).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(2))) {
				currStep = Integer.parseInt(currBehavior.get(2)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int ifangle(Critter c, ArrayList<String> currBehavior, int currStep) {
		if(isInt(currBehavior.get(1))&&isInt(currBehavior.get(2))&&c.getOffAngle(Integer.parseInt(currBehavior.get(1))) == Integer.parseInt(currBehavior.get(2))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1))|| !isInt(currBehavior.get(2))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}
	public int iflt(Critter c, ArrayList<String> currBehavior, int currStep) {
		if (isInt(currBehavior.get(1).substring(1))&&isInt(currBehavior.get(2).substring(1))&&c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) < c.getReg(Integer.parseInt(currBehavior.get(2).substring(1)))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1).substring(1))|| !isInt(currBehavior.get(2).substring(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	public int ifeq(Critter c, ArrayList<String> currBehavior, int currStep) {
		if (isInt(currBehavior.get(1).substring(1))&&isInt(currBehavior.get(2).substring(1)) &&c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) == c.getReg(Integer.parseInt(currBehavior.get(2).substring(1)))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1).substring(1))|| !isInt(currBehavior.get(2).substring(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}

	public int ifgt(Critter c, ArrayList<String> currBehavior, int currStep) {
		if (isInt(currBehavior.get(1).substring(1))&&isInt(currBehavior.get(2).substring(1)) && c.getReg(Integer.parseInt(currBehavior.get(1).substring(1))) > c.getReg(Integer.parseInt(currBehavior.get(2).substring(1)))) {
			if (currBehavior.get(3).charAt(0) == 'r'&&isInt(currBehavior.get(3).substring(1))) {
				currStep = c.getReg(Integer.parseInt(currBehavior.get(3).substring(1))) - 1;
			}
			else if (isInt(currBehavior.get(3))) {
				currStep = Integer.parseInt(currBehavior.get(3)) - 1;
			}
			else {
				return -1;
			}
		}
		else if (!isInt(currBehavior.get(1).substring(1))|| !isInt(currBehavior.get(2).substring(1))) {
			return -1;
		}
		else {
			currStep += 1;
		}
		return currStep;
	}



	public void executeCritter(Critter c) {
//		createTrees();
		ArrayList<ArrayList<String>> behaviors = new ArrayList<>(c.getCode());
		int currStep = c.getNextCodeLine() -1;
		if(currStep >= behaviors.size()) {
			System.err.println("critter instructions point to invalid line");
			return;
		}
		ArrayList<String> currBehavior = behaviors.get(currStep);

		while(!currBehavior.get(0).equals("hop") && !currBehavior.get(0).equals("left") && !currBehavior.get(0).equals("right") && !currBehavior.get(0).equals("eat") && !currBehavior.get(0).equals("infect") ) {

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
				System.out.println(currBehavior + "in while loop");
				System.err.println("Critter Instructions Invalid");
				return;
			}



			if(currStep >= behaviors.size()-1 || currStep < 0) {
				System.err.println("critter instructions point to invalid line");
				return;
			}
			currBehavior = behaviors.get(currStep);
		}
//		if (!isValidPath(allCommands, behaviors.get(behaviors.size()-1).get(0))) {
//			System.err.println("critter instructions point to invalid line");
//			return;
//		}
//		else {
//			for (int i = 0; i < allCommands.size(); i++) {
//				testedCommands.add(behaviors.get(allCommands.get(i)).get(0));
//			}
//		}
//		if (testedCommands.size() == 14) {
//			System.out.println("reached all commands");
//		}

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
			System.out.println(currBehavior + "Hello");
			System.err.println("Critter Instructions Invalid");
			return;
		}
		c.setNextCodeLine(currStep+2);


	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
		// obviously, your code should do something
		ArrayList<ArrayList<String>> critterBehavior = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String name = reader.readLine();
			String currLine = reader.readLine();
			while (!currLine.isEmpty()) {
				critterBehavior.add(new ArrayList<>(Arrays.asList(currLine.split(" "))));
				currLine = reader.readLine();
			}
			reader.close();
//			critterBehavior.add(new ArrayList<>(Arrays.asList(name)));
			return new CritterSpecies(name, critterBehavior);

		}
		catch (FileNotFoundException e) {
			System.err.println("File not found: " + filename);
		}
		return null;
	}
}
