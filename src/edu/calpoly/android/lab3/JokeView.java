package edu.calpoly.android.lab3;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class JokeView extends LinearLayout {

	/** Radio buttons for liking or disliking a joke. */
	private RadioButton m_vwLikeButton;
	private RadioButton m_vwDislikeButton;
	
	/** The container for the radio buttons. */
	private RadioGroup m_vwLikeGroup;

	/** Displays the joke text. */
	private TextView m_vwJokeText;
	
	/** The data version of this View, containing the joke's information. */
	private Joke m_joke;

	/**
	 * Basic Constructor that takes only an application Context.
	 * 
	 * @param context
	 *            The application Context in which this view is being added. 
	 *            
	 * @param joke
	 * 			  The Joke this view is responsible for displaying.
	 */
	public JokeView(Context context, Joke joke) {
		super(context);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.joke_view, this, true);
		
		m_vwLikeButton = (RadioButton) findViewById(R.id.likeButton);
		m_vwDislikeButton = (RadioButton) findViewById(R.id.dislikeButton);
		m_vwLikeGroup = (RadioGroup) findViewById(R.id.ratingRadioGroup);
		m_vwJokeText = (TextView) findViewById(R.id.jokeTextView);
		
		m_joke = joke;
		setJoke(joke);
		requestLayout();
		
		m_vwLikeGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton c = (RadioButton) findViewById(checkedId);
				if(checkedId == R.id.likeButton){
					m_vwLikeButton.setChecked(true);
					m_joke.setRating(Joke.LIKE);
				}
				else if(checkedId == R.id.dislikeButton){
					m_vwDislikeButton.setChecked(true);
					m_joke.setRating(Joke.DISLIKE);
				}
			}
		});
	}

	/**
	 * Mutator method for changing the Joke object this View displays. This View
	 * will be updated to display the correct contents of the new Joke.
	 * 
	 * @param joke
	 *            The Joke object which this View will display.
	 */
	public void setJoke(Joke joke) {
		m_joke = joke;
		m_vwJokeText.setText(joke.getJoke());
		m_vwJokeText.setTextSize(TypedValue.COMPLEX_UNIT_PX, 26);
		
		m_vwLikeGroup.clearCheck();
		if(joke.getRating() == 1){
			m_vwLikeButton.setChecked(true);
		}
		else if(joke.getRating() == 2){
			m_vwDislikeButton.setChecked(true);
		}
	}

}
