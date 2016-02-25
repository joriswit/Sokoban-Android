package com.gamesbykevin.sokoban.ai;

import com.gamesbykevin.androidframework.resources.Files;
import com.gamesbykevin.sokoban.assets.Assets;
import com.gamesbykevin.sokoban.level.Level;
import com.gamesbykevin.sokoban.player.Player;
import com.gamesbykevin.sokoban.player.PlayerHelper;

/**
 * What he ai class will do is analyze a text file and move the player according to those instructions
 */
public class AI 
{
	//list of instructions to follow
	private final String instructions;

	//the position of the instructions String
	private int index = 0;
	
	/**
	 * The string representing the instruction to move left
	 */
	private static final String LEFT = "L";
	
	/**
	 * The string representing the instruction to move right
	 */
	private static final String RIGHT = "R";
	
	/**
	 * The string representing the instruction to move down
	 */
	private static final String DOWN = "D";
	
	/**
	 * The string representing the instruction to move up
	 */
	private static final String UP = "U";
	
	/**
	 * Create the ai to solve the level
	 */
	public AI() 
	{
		//load text file and store instructions, assuming all instructions are contained on a single line
		instructions = Files.getText(Assets.TextAiInstructionsKey.SOLVED_EASY_B_170).getLines().get(0);
	}

	public void update(final Player player, final Level level)
	{
		//stay inbounds
		if (index >= instructions.length())
			return;
		
		//make sure we have not yet selected the player
		if (!player.isSelected())
		{
			//make sure the player is at the current target as well
			if (player.hasTarget())
			{
				//flag selected true
				player.setSelected(true);
				
				//determine which direction we are moving
				if (instructions.substring(index, index + 1).equalsIgnoreCase(DOWN))
				{
					player.setTarget(player.getCol(), player.getRow() + 1);
				}
				else if (instructions.substring(index, index + 1).equalsIgnoreCase(UP))
				{
					player.setTarget(player.getCol(), player.getRow() - 1);
				}
				else if (instructions.substring(index, index + 1).equalsIgnoreCase(LEFT))
				{
					player.setTarget(player.getCol() - 1, player.getRow());
				}
				else if (instructions.substring(index, index + 1).equalsIgnoreCase(RIGHT))
				{
					player.setTarget(player.getCol() + 1, player.getRow());
				}
				
                //calculate the targets
                PlayerHelper.calculateTargets(player, level);
                
                //move to the next instruction
                index++;
			}
		}
	}
}