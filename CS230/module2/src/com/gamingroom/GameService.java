package com.gamingroom;

import java.util.ArrayList;

import java.util.List;

import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	
	// Turned into singleton pattern to ensure that there can only be one game service
	
	private static GameService instance = new GameService();
	
	// private constructor 
	
	private GameService(){}
	
	// return the GameService instance
	

	public static GameService getInstance()
	{
		
	      return instance;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// returning the instance of the game where the name of the game matches the unique name.
		
		// Instantiating the iterator
		
		Iterator<Game> iterator = games.iterator();
		
		// iterate through the game list 
		
			while (iterator.hasNext()) {
				
				// Assigning the iterated element to the local game variable 
				
				  Game gameInstance = iterator.next();
				  
				  // checking to see if the game names match 
				  if (gameInstance.getName().equals(name)) {
					  
					  // return the instance 
					  
				   return gameInstance;
				  
				  }
				  }
		

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// Using iterator to loop through the game id values and assigns the id value
		// to the game variable
		
		// instantiate the iterator
		
		Iterator<Game> iterator = games.iterator();
		
		
		// iterate through the game list 
		
		while (iterator.hasNext()) {
			
			// Assigning the iterated element to the local game variable 
			
			  Game gameInstance = iterator.next();
			  
			  
			// checking to see if the game names match 
			  
			  if (gameInstance.getId() == id) {
				  
				// return the instance 
				  
			  return gameInstance;
			  
			  
			  }
			  }

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// Using iterator to loop through the game instances and return once we get the value that matches
		// the needed game name
		
		// instantiate the iterator
		
		Iterator<Game> iterator = games.iterator();

		while (iterator.hasNext()) {
			
			// Assigning the iterated element to the local game variable 
			  Game gameInstance = iterator.next();
			  if (gameInstance.getName().equals(name)) {
				  
			 return gameInstance;
			  
			  
			  
			  }
			  }
		
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
