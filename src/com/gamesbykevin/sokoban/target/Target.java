package com.gamesbykevin.sokoban.target;

import com.gamesbykevin.androidframework.base.Cell;
import com.gamesbykevin.androidframework.resources.Disposable;

/**
 * The target class contains the current location and a destination<br>
 * Used to move the blocks and the player
 * @author GOD
 */
public class Target extends Cell implements Disposable
{
    //destination location
    private Cell destination;
    
    //is this target at a goal
    private boolean goal = false;
    
    /**
     * Create a new Target with the specified location
     * @param col Column
     * @param row Row
     */
    public Target(final double col, final double row)
    {
        super(col, row);
        
        //assign current location as the destination
        this.destination = new Cell(col, row);
    }
    
    @Override
    public void dispose()
    {
        this.destination = null;
    }
    
    /**
     * Flag this target located at a goal
     * @param goal true = yes, false = no
     */
    public void setGoal(final boolean goal)
    {
        this.goal = goal;
    }
    
    /**
     * Is this target at a goal?
     * @return true = yes, false = no
     */
    public boolean hasGoal()
    {
        return this.goal;
    }
    
    /**
     * Assign the destination
     * @param col Column of our destination
     * @param row Row of our destination
     */
    public void setDestination(final double col, final double row)
    {
        //assign destination location
        this.destination.setCol(col);
        this.destination.setRow(row);
    }
    
    /**
     * Get the destination
     * @return The location of the destination
     */
    public Cell getDestination()
    {
        return this.destination;
    }
    
    /**
     * Do we have the destination?
     * @return true if the current location matches the target location, false otherwise
     */
    public boolean hasDestination()
    {
        return (getCol() == getDestination().getCol() && getRow() == getDestination().getRow());
    }
}