// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.PassiveStateChangeListener;
import com.comcast.cim.android.accessibility.SpeechDelegate;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.sideribbon.SideMenuBuilder;
import com.comcast.cim.android.sideribbon.SideRibbonDelegateBuilder;
import com.comcast.cim.android.view.common.Searchable;
import com.comcast.cim.android.view.flow.flyinmenu.FlyinMenuActivity;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.model.user.UserManager;
import com.ijsbrandslob.appirater.Appirater;
import com.xfinity.playerlib.alt.speechrecognizers.PlayerSpeechRecognizer;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.common.AnnouncementOverlayActivity;
import com.xfinity.playerlib.view.search.SearchActivity;
import com.xfinity.playerlib.view.search.SearchResultsFragment;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PlayNowFlyinMenuActivity extends FlyinMenuActivity
    implements PassiveStateChangeListener, Searchable, com.xfinity.playerlib.view.search.SearchResultsFragment.HostingActivity
{
    protected class PlayNowFlyinMenuSpeechListener extends com.comcast.cim.android.view.common.BaseActivity.ActivitySpeechListener
    {

        final PlayNowFlyinMenuActivity this$0;

        public boolean onSpeechResponseSearch(String as[])
        {
            getSpeechDelegate().startSearch(com/xfinity/playerlib/view/search/SearchActivity, as);
            return false;
        }

        protected PlayNowFlyinMenuSpeechListener()
        {
            this$0 = PlayNowFlyinMenuActivity.this;
            super(PlayNowFlyinMenuActivity.this);
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity);
    private AccessibilityUtil accessibilityUtil;
    private Appirater appirater;
    private View clearSearchButton;
    protected HashMap focusToggleState;
    private Handler handler;
    private InputMethodManager inputMethodManager;
    private boolean isInSearchMode;
    private boolean optionsMenuWasInvalidatedAfterSearchExpansion;
    private View searchDropDownUnderlay;
    private EditText searchEditText;
    protected MenuItem searchMenuItem;
    private Provider searchQueryProvider;
    protected SearchResultsFragment searchResultsFragment;
    private SideMenuBuilder sideMenuBuilder;
    private SideRibbonDelegateBuilder sideRibbonDelegateBuilder;
    protected PlayNowUserManager userManager;
    private View voiceSearchButton;

    public PlayNowFlyinMenuActivity()
    {
        userManager = PlayerContainer.getInstance().getUserManager();
        inputMethodManager = PlayerContainer.getInstance().getInputMethodManager();
        sideRibbonDelegateBuilder = PlayerContainer.getInstance().getSideRibbonDelegateBuilder();
        sideMenuBuilder = PlayerContainer.getInstance().getSideMenuBuilder();
        accessibilityUtil = CALContainer.getInstance().getAccessibilityUtil();
        appirater = PlayerContainer.getInstance().getAppirater();
        searchQueryProvider = PlayerContainer.getInstance().getSearchQueryProvider();
        handler = new Handler();
        focusToggleState = new HashMap();
    }

    private void stopGapMenuInit()
    {
        (new AsyncTask() {

            final PlayNowFlyinMenuActivity this$0;

            protected transient Boolean doInBackground(Void avoid[])
            {
                return Boolean.valueOf(((PlayerUserSettings)userManager.getUserSettings()).getHasSeenMenuOptions());
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(Boolean boolean1)
            {
                if (!boolean1.booleanValue())
                {
                    (new Handler(getMainLooper())).postDelayed(new Runnable() {

                        final _cls8 this$1;

                        public void run()
                        {
                            openOptionsMenu();
                            ((PlayerUserSettings)userManager.getUserSettings()).setHasSeenMenuOptions(true);
                            userManager.saveUserAsync();
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    }, 200L);
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Boolean)obj);
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        }).execute(new Void[0]);
    }

    protected void addDefaultActivitySpeechListener()
    {
        addSpeechListener(new PlayNowFlyinMenuSpeechListener());
    }

    protected SearchResultsFragment addSearchResultsFragmentIfApplicable()
    {
        Object obj = getFragmentManager();
        FragmentTransaction fragmenttransaction = ((FragmentManager) (obj)).beginTransaction();
        SearchResultsFragment searchresultsfragment = (SearchResultsFragment)((FragmentManager) (obj)).findFragmentByTag("SEARCH_RESULTS_FRAGMENT_TAG");
        obj = searchresultsfragment;
        if (searchresultsfragment == null)
        {
            obj = new SearchResultsFragment();
            fragmenttransaction.add(((android.app.Fragment) (obj)), "SEARCH_RESULTS_FRAGMENT_TAG");
            fragmenttransaction.commit();
        }
        return ((SearchResultsFragment) (obj));
    }

    protected void enterSearchMode()
    {
        searchDropDownUnderlay.setVisibility(0);
        setActionBarIcon(getSearchBackIcon());
        handler.post(new Runnable() {

            final PlayNowFlyinMenuActivity this$0;

            public void run()
            {
                searchEditText.requestFocus();
                inputMethodManager.showSoftInput(searchEditText, 1);
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        });
        isInSearchMode = true;
        ViewGroup viewgroup = (ViewGroup)findViewById(0x1020002);
        accessibilityUtil.toggleScreenFocus(focusToggleState, viewgroup, viewgroup, true, false);
    }

    protected void exitSearchMode()
    {
        searchDropDownUnderlay.setVisibility(8);
        resetActionBarIcon();
        inputMethodManager.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
        isInSearchMode = false;
        ViewGroup viewgroup = (ViewGroup)findViewById(0x1020002);
        accessibilityUtil.toggleScreenFocus(focusToggleState, viewgroup, viewgroup, false, false);
    }

    public abstract int getSearchBackIcon();

    public EditText getSearchEditText()
    {
        return searchEditText;
    }

    protected SideMenuBuilder getSideMenuBuilder()
    {
        return sideMenuBuilder;
    }

    protected SideRibbonDelegateBuilder getSideRibbonDelegateBuilder()
    {
        return sideRibbonDelegateBuilder;
    }

    protected Class getSpeechRecognizerClass()
    {
        return com/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
    }

    protected UserManager getUserManager()
    {
        return userManager;
    }

    public boolean isSearching()
    {
        return isInSearchMode;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            isInSearchMode = bundle.getBoolean("EXTRA_IS_IN_SEARCH_MODE", false);
        }
        searchResultsFragment = addSearchResultsFragmentIfApplicable();
        searchDropDownUnderlay = new FrameLayout(this);
        searchDropDownUnderlay.setBackgroundColor(getResources().getColor(com.xfinity.playerlib.R.color.TranslucentBlack));
        searchDropDownUnderlay.setOnClickListener(new android.view.View.OnClickListener() {

            final PlayNowFlyinMenuActivity this$0;

            public void onClick(View view)
            {
                searchMenuItem.collapseActionView();
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        });
        searchDropDownUnderlay.setVisibility(8);
        addContentView(searchDropDownUnderlay, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(com.xfinity.playerlib.R.menu.app_menu, menu);
        searchMenuItem = menu.findItem(com.xfinity.playerlib.R.id.menu_item_search);
        menu = searchMenuItem.getActionView();
        searchEditText = (EditText)menu.findViewById(com.xfinity.playerlib.R.id.search_edit_text);
        clearSearchButton = menu.findViewById(com.xfinity.playerlib.R.id.clear_search);
        clearSearchButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PlayNowFlyinMenuActivity this$0;

            public void onClick(View view)
            {
                searchResultsFragment.clearSearchQuery();
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        });
        voiceSearchButton = menu.findViewById(com.xfinity.playerlib.R.id.speech_search);
        if (accessibilityUtil.isAccessibilityEnabled())
        {
            voiceSearchButton.setVisibility(0);
            voiceSearchButton.setOnClickListener(new android.view.View.OnClickListener() {

                final PlayNowFlyinMenuActivity this$0;

                public void onClick(View view)
                {
                    accessibilityUtil.setImportantForAccessibility(searchEditText, 2);
                    getTalkDelegate().stopSpeaking();
                    getSpeechDelegate().getSpeechInput(com/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer);
                }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
            });
        }
        searchEditText.addTextChangedListener(new TextWatcher() {

            final PlayNowFlyinMenuActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                View view = clearSearchButton;
                int i;
                if (!editable.toString().isEmpty())
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                view.setVisibility(i);
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        });
        searchEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final PlayNowFlyinMenuActivity this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                boolean flag = false;
                if (i == 6)
                {
                    inputMethodManager.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);
                    flag = true;
                }
                return flag;
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        });
        searchMenuItem.setOnActionExpandListener(new android.view.MenuItem.OnActionExpandListener() {

            final PlayNowFlyinMenuActivity this$0;

            public boolean onMenuItemActionCollapse(MenuItem menuitem)
            {
                exitSearchMode();
                optionsMenuWasInvalidatedAfterSearchExpansion = false;
                searchResultsFragment.onMenuItemActionCollapse(menuitem);
                handler.post(new Runnable() {

                    final _cls6 this$1;

                    public void run()
                    {
                        invalidateOptionsMenu();
                    }

            
            {
                this$1 = _cls6.this;
                super();
            }
                });
                menuitem.setTitle(com.xfinity.playerlib.R.string.search);
                getTalkDelegate().stopSpeaking();
                return true;
            }

            public boolean onMenuItemActionExpand(MenuItem menuitem)
            {
                if (accessibilityUtil.isAccessibilityEnabled())
                {
                    menuitem = new Intent(PlayNowFlyinMenuActivity.this, com/xfinity/playerlib/view/search/SearchActivity);
                    menuitem.putExtra("KEY_SHOW_KEYBOARD_ON_START", true);
                    startActivityForResult(menuitem, 0);
                    return false;
                }
                if (!optionsMenuWasInvalidatedAfterSearchExpansion)
                {
                    optionsMenuWasInvalidatedAfterSearchExpansion = true;
                    handler.post(new Runnable() {

                        final _cls6 this$1;

                        public void run()
                        {
                            invalidateOptionsMenu();
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                }
                enterSearchMode();
                searchResultsFragment.onMenuItemActionExpand(menuitem);
                return true;
            }

            
            {
                this$0 = PlayNowFlyinMenuActivity.this;
                super();
            }
        });
        if (isInSearchMode)
        {
            searchMenuItem.expandActionView();
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onPause()
    {
        super.onPause();
        appirater.dismiss();
        if (searchEditText != null)
        {
            accessibilityUtil.setImportantForAccessibility(searchEditText, 2);
        }
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        PlayerUserSettings playerusersettings = (PlayerUserSettings)userManager.getUserSettings();
        if (!playerusersettings.getHasSeenCellularEnabledMessage() || !playerusersettings.getHasSeenUpgradeMessage() || !playerusersettings.getHasSeenParentalControlsMessage())
        {
            Intent intent = new Intent(this, com/xfinity/playerlib/view/common/AnnouncementOverlayActivity);
            intent.setFlags(0x20000000);
            startActivity(intent);
        }
        stopGapMenuInit();
        appirater.appEnteredForeground(true, this);
        if (searchEditText != null)
        {
            accessibilityUtil.setImportantForAccessibility(searchEditText, 1);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("EXTRA_IS_IN_SEARCH_MODE", isInSearchMode);
    }

    public boolean onSearchRequested()
    {
        searchMenuItem.expandActionView();
        return true;
    }

    public void onSideRibbonStateChanged(com.comcast.cim.android.sideribbon.SideRibbonDelegate.State state)
    {
        super.onSideRibbonStateChanged(state);
        if (isInSearchMode)
        {
            searchMenuItem.collapseActionView();
        }
    }








/*
    static boolean access$402(PlayNowFlyinMenuActivity playnowflyinmenuactivity, boolean flag)
    {
        playnowflyinmenuactivity.optionsMenuWasInvalidatedAfterSearchExpansion = flag;
        return flag;
    }

*/

}
