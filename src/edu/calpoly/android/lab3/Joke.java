package edu.calpoly.android.lab3;

/**
 * This class encapsulates the data pertaining to a Joke.
 */
public class Joke {

	/** The three possible rating values for jokes */
	public static final int UNRATED = 0;
	public static final int LIKE = UNRATED + 1;
	public static final int DISLIKE = UNRATED + 2;

	/** Contains the text of this joke */
	private String m_strJoke;

	/** Contains the rating of this joke, should only be one of the constant
	 * rating values declared above. */
	private int m_nRating;

	/** Contains the name of the Author of this joke. */
	private String m_strAuthorName;

	/**
	 * Initializes with an empty joke and author string and the default rating
	 * of UNRATED.
	 */
	public Joke() {
		// TODO
		m_strJoke = "";
		m_nRating = Joke.UNRATED;
		m_strAuthorName = "";
	}

	/**
	 * Initializes with the joke and author strings passed in and the default
	 * rating of UNRATED.
	 * 
	 * @param strJoke
	 *            Joke String used to initialize the text of this joke.
	 * 
	 * @param strAuthor
	 *            The name of the Author of this Joke.
	 */
	public Joke(String strJoke, String strAuthor) {
		// TODO
		this.m_strJoke = strJoke;
		this.m_nRating = Joke.UNRATED;
	}

	/**
	 * Initializes with a joke and author string and rating value passed in.
	 * 
	 * @param strJoke
	 *            Joke String used to initialize the text of this joke.
	 * 
	 * @param strAuthor
	 *            The name of the Author of this Joke.
	 * 
	 * @param nRating
	 *            Rating value to initialize the rating of this joke.
	 */
	public Joke(String strJoke, String strAuthor, int nRating) {
		// TODO
	}

	/**
	 * Accessor for the text of this joke.
	 * 
	 * @return A String value containing the text of this joke.
	 */
	public String getJoke() {
		// TODO
		return null;
	}

	/**
	 * Mutator that changes the text of this joke.
	 * 
	 * @param strJoke
	 *            The text of this joke.
	 */
	public void setJoke(String strJoke) {
		// TODO
	}

	/**
	 * Accessor for the rating of this joke.
	 * 
	 * @return An integer value containing one of the possible rating constants.
	 */
	public int getRating() {
		// TODO
		return 0;
	}

	/**
	 * Mutator that changes the rating of this joke.
	 * 
	 * @param rating
	 *            One of the possible rating constants.
	 */
	public void setRating(int rating) {
		// TODO
	}

	/**
	 * Accessor for the Author of this joke.
	 * 
	 * @return A String containing the Authors name.
	 */
	public String getAuthor() {
		// TODO
		return null;
	}

	/**
	 * Mutator that changes the Author of this joke.
	 * 
	 * @param strAuthor
	 *            A String containing the Authors name.
	 */
	public void setAuthor(String strAuthor) {
		// TODO
	}

	/**
	 * Returns only the text of the joke. This method should mimic getJoke().
	 * 
	 * @return A string containing the text of the joke
	 */
	@Override
	public String toString() {
		// TODO
		return null;
	}

	/**
	 * An Object is equal to this Joke if all items below are true:
	 * 
	 * 1) The Object is a Joke.
	 * 
	 * 2) The Joke's text is the same as this Joke's text. Whereby text equality
	 *    is defined by String.equals(...).
	 *    
	 * 3) the Author of the Joke is the same as this Joke's Author. Whereby
	 *    equality is defined by String.equals(...).
	 *    
	 * The rating is ignored in the determination of equality.
	 * 
	 * @param obj
	 *            The object to be compared to this Joke object.
	 * 
	 * @return True if the object passed in is a Joke with the same text and 
	 * 		   Author as this one; False otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO
		return false;
	}
}
