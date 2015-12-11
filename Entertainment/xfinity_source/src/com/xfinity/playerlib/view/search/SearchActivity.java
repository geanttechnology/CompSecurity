// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.alt.speechrecognizers.SearchSpeechRecognizer;
import com.xfinity.playerlib.view.flyinmenu.PlayNowFlyinMenuActivity;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

public class SearchActivity extends PlayNowFlyinMenuActivity
{
    protected class SearchActivitySpeechListener extends com.comcast.cim.android.view.common.BaseActivity.ActivitySpeechListener
    {

        final SearchActivity this$0;

        public boolean onSpeechResponseSearch(String as[])
        {
            return false;
        }

        protected SearchActivitySpeechListener()
        {
            this$0 = SearchActivity.this;
            super(SearchActivity.this);
        }
    }


    private Handler handler;
    private InputMethodManager inputMethodManager;
    private EditText searchEditText;
    private final OrientationStrategy sensorIfHasKeyboardOrientationStrategy = PlayerContainer.getInstance().getSensorIfHasKeyboardOrientationStrategy();

    public SearchActivity()
    {
        handler = new Handler();
        inputMethodManager = PlayerContainer.getInstance().getInputMethodManager();
    }

    private SearchResultsFragment getSearchResultsFragment()
    {
        return (SearchResultsFragment)getFragmentManager().findFragmentById(com.xfinity.playerlib.R.id.main_fragment);
    }

    private boolean loadSearchTermsIfAvail()
    {
        Intent intent = getIntent();
        if (isAccessibilityEnabled() && intent != null)
        {
            String as[] = intent.getStringArrayExtra("KEY_TERMS");
            if (as != null)
            {
                String s = StringUtils.join(as, " ");
                searchEditText.setText(s);
                return true;
            }
        }
        return false;
    }

    protected void addDefaultActivitySpeechListener()
    {
        addSpeechListener(new SearchActivitySpeechListener());
    }

    protected SearchResultsFragment addSearchResultsFragmentIfApplicable()
    {
        return getSearchResultsFragment();
    }

    protected int getLayoutId()
    {
        return com.xfinity.playerlib.R.layout.search;
    }

    public OrientationStrategy getOrientationStrategy()
    {
        return sensorIfHasKeyboardOrientationStrategy;
    }

    public int getSearchBackIcon()
    {
        return com.xfinity.playerlib.R.drawable.ico_search;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setTitle(getString(com.xfinity.playerlib.R.string.search));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        boolean flag = super.onCreateOptionsMenu(menu);
        searchEditText = (EditText)searchMenuItem.getActionView().findViewById(com.xfinity.playerlib.R.id.search_edit_text);
        searchMenuItem.setOnActionExpandListener(new android.view.MenuItem.OnActionExpandListener() {

            final SearchActivity this$0;

            public boolean onMenuItemActionCollapse(MenuItem menuitem)
            {
                inputMethodManager.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                getSearchResultsFragment().onMenuItemActionCollapse(menuitem);
                setResult(-1);
                finish();
                return true;
            }

            public boolean onMenuItemActionExpand(MenuItem menuitem)
            {
                if (getIntent().getBooleanExtra("KEY_SHOW_KEYBOARD_ON_START", false))
                {
                    handler.postDelayed(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            if (!loadSearchTermsIfAvail())
                            {
                                inputMethodManager.toggleSoftInput(2, 0);
                            }
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }, 200L);
                }
                getSearchResultsFragment().onMenuItemActionExpand(menuitem);
                return true;
            }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
        });
        searchMenuItem.expandActionView();
        setActionBarIcon(getSearchBackIcon());
        return flag;
    }

    public void onSpeechSwipe()
    {
        getSearchResultsFragment().onSpeechSwiped();
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        if (intent != null)
        {
            bundle = intent.getExtras();
        }
        bundle.putString("KEY_SEARCH_TERMS", searchEditText.getText().toString());
        getTalkDelegate().stopSpeaking();
        getSpeechDelegate().getSpeechInput(getSpeechRecognizerClass(), bundle);
    }





}
