package edu.calpoly.android.lab3;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class AdvancedJokeList extends Activity {

	/** Contains the name of the Author for the jokes. */
	protected String m_strAuthorName;

	/** Contains the list of Jokes the Activity will present to the user. */
	protected ArrayList<Joke> m_arrJokeList;
	
	/** Contains the list of filtered Jokes the Activity will present to the user. */
	protected ArrayList<Joke> m_arrFilteredJokeList;

	/** Adapter used to bind an AdapterView to List of Jokes. */
	protected JokeListAdapter m_jokeAdapter;

	/** ViewGroup used for maintaining a list of Views that each display Jokes. */
	protected LinearLayout m_vwJokeLayout;

	/** EditText used for entering text for a new Joke to be added to m_arrJokeList. */
	protected EditText m_vwJokeEditText;

	/** Button used for creating and adding a new Joke to m_arrJokeList using the
	 *  text entered in m_vwJokeEditText. */
	protected Button m_vwJokeButton;
	
	/** Menu used for filtering Jokes. */
	protected Menu m_vwMenu;

	/** Background Color values used for alternating between light and dark rows
	 *  of Jokes. Add a third for text color if necessary. */
	protected int m_nDarkColor;
	protected int m_nLightColor;
	protected int m_nTextColor;
	protected int m_nCurrentColor;
		
	/**
	 * Context-Menu MenuItem IDs.
	 * IMPORTANT: You must use these when creating your MenuItems or the tests
	 * used to grade your submission will fail. These are commented out for now.
	 */
	//protected static final int FILTER = Menu.FIRST;
	//protected static final int FILTER_LIKE = SubMenu.FIRST;
	//protected static final int FILTER_DISLIKE = SubMenu.FIRST + 1;
	//protected static final int FILTER_UNRATED = SubMenu.FIRST + 2;
	//protected static final int FILTER_SHOW_ALL = SubMenu.FIRST + 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Resources res = this.getResources();
		m_nDarkColor = res.getColor(R.color.dark);
		m_nLightColor = res.getColor(R.color.light);
		m_nTextColor = res.getColor(R.color.dark);
		m_nCurrentColor = m_nDarkColor;
		m_arrJokeList = new ArrayList<Joke>();
		initLayout();
		initAddJokeListeners();
		String[] jokes = res.getStringArray(R.array.jokeList);
		for(int i=0; i < jokes.length; i++){
			Joke j = new Joke(jokes[i], "Vee");
			addJoke(j);
		}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO
        return true;
    }

	/**
	 * Method is used to encapsulate the code that initializes and sets the
	 * Layout for this Activity.
	 */
	protected void initLayout() {
		
		this.setContentView(R.layout.advanced);
		
		this.m_vwJokeLayout = (LinearLayout) findViewById(R.id.jokeListViewGroup);
		this.m_vwJokeEditText = (EditText) findViewById(R.id.newJokeEditText);
		this.m_vwJokeButton = (Button) findViewById(R.id.addJokeButton);
		
		/*
		LinearLayout lv = new LinearLayout(this);
		lv.setOrientation(LinearLayout.VERTICAL);

		LinearLayout lh = new LinearLayout(this);
		lh.setOrientation(LinearLayout.HORIZONTAL);
		
		m_vwJokeButton = new Button(this);
		m_vwJokeButton.setText("Add Joke");
		
		m_vwJokeEditText = new EditText(this);
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		m_vwJokeEditText.setLayoutParams(param);
		
		lh.addView(m_vwJokeButton);
		lh.addView(m_vwJokeEditText);

		m_vwJokeLayout = new LinearLayout(this);
		m_vwJokeLayout.setOrientation(LinearLayout.VERTICAL);
		
		ScrollView sw = new ScrollView(this);
		sw.addView(m_vwJokeLayout);
		
		lv.addView(lh);
		lv.addView(sw);
		
		this.setContentView(lv);
		*/
	}

	/**
	 * Method is used to encapsulate the code that initializes and sets the
	 * Event Listeners which will respond to requests to "Add" a new Joke to the
	 * list.
	 */
	protected void initAddJokeListeners() {
		
		m_vwJokeEditText.setOnKeyListener(new OnKeyListener() {

			public boolean onKey(View v, int keyCode, KeyEvent event){
				if((event.getAction() == KeyEvent.ACTION_DOWN) &&
				   (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
				  ){
					String jokeText = m_vwJokeEditText.getText().toString();
					Joke joke = new Joke(jokeText, "Vee");
					m_vwJokeEditText.setText("");
					addJoke(joke);
					
					InputMethodManager imm = (InputMethodManager)
							getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(m_vwJokeEditText.getWindowToken(), 0);
				}
				return true;
			}
		});
		
		m_vwJokeButton.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				String jokeText = m_vwJokeEditText.getText().toString();
				m_vwJokeEditText.setText("");
				Joke joke = new Joke(jokeText, "Vee");
				m_vwJokeEditText.setText("");
				addJoke(joke);
				
				InputMethodManager imm = (InputMethodManager)
						getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(m_vwJokeEditText.getWindowToken(), 0);
			}
		});
	}

	/**
	 * Method used for encapsulating the logic necessary to properly add a new
	 * Joke to m_arrJokeList, and display it on screen.
	 * 
	 * @param joke
	 *            The Joke to add to list of Jokes.
	 */
	protected void addJoke(Joke joke) {
		m_vwJokeLayout.addView(new JokeView(this, joke));
		m_arrJokeList.add(joke);
		/*
		TextView tw = new TextView(this);
		tw.setText(joke.getJoke());
		tw.setTextSize(TypedValue.COMPLEX_UNIT_PX, 16);
		tw.setBackgroundColor(m_nCurrentColor);
		tw.setTextColor(m_nTextColor);
		if(m_nCurrentColor == m_nDarkColor){
			m_nCurrentColor = m_nLightColor;
		}
		else{
			m_nCurrentColor = m_nDarkColor;
		}
		m_vwJokeLayout.addView(tw);*/
	}
}