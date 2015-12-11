// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import com.fanhattan.services.contextualmenu.api.ContextualMenu;
import com.fanhattan.services.contextualmenu.api.ContextualMenuItem;
import com.fanhattan.services.contextualmenu.api.ContextualMenuSection;
import com.fanhattan.services.contextualmenu.api.ContextualMenuService;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.gotv.crackle.adapters.BrowseGridAdapter;
import com.gotv.crackle.adapters.TabsPagerAdapter;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.SearchResults;
import com.gotv.crackle.fragments.BrowseMoviesFragment;
import com.gotv.crackle.fragments.BrowseShowsFragment;
import com.gotv.crackle.fragments.HomeFragment;
import com.gotv.crackle.fragments.WatchlistsFragment;
import com.gotv.crackle.helpers.ChromeCastHelper;
import com.gotv.crackle.helpers.MyCrackleViewHelper;
import com.gotv.crackle.model.BrowseModel;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            Application, DetailsActivityResolver

public class MainActivity extends BaseActivity
    implements com.fanhattan.services.contextualmenu.api.ContextualMenuService.ContextualMenuCallback
{
    private class AbsTabListener
        implements android.support.v7.app.ActionBar.TabListener
    {

        final MainActivity this$0;

        public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
        {
        }

        public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
        {
            switch (tab.getPosition())
            {
            default:
                return;

            case 0: // '\0'
                mViewPager.setCurrentItem(tab.getPosition());
                mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.HOME;
                return;

            case 1: // '\001'
                mViewPager.setCurrentItem(tab.getPosition());
                mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.MOVIES;
                return;

            case 2: // '\002'
                mViewPager.setCurrentItem(tab.getPosition());
                mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.SHOWS;
                return;

            case 3: // '\003'
                mViewPager.setCurrentItem(tab.getPosition());
                break;
            }
            mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS;
        }

        public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
        {
        }

        private AbsTabListener()
        {
            this$0 = MainActivity.this;
            super();
        }

    }


    private static final String CURRENT_TAB = "currentTab";
    public static final String EXTRA_SELECTED_TAB = null;
    public static final String FANHATTAN_MENU_ID_ABOUT = "FAN_ID_ABOUT";
    public static final String FANHATTAN_MENU_ID_FAQ = "FAN_ID_FAQ";
    public static final String FANHATTAN_MENU_ID_PRIVACY = "FAN_ID_PRIVACY";
    public static final String FANHATTAN_MENU_ID_SETTINGS = "FAN_ID_SETTINGS";
    public static final String FANHATTAN_MENU_ID_TERMS = "FAN_ID_TERMS";
    public static int sCurrentViewStyle;
    private ActionBar actionBar;
    private BrowseMoviesFragment fragBrowseMovies;
    private BrowseShowsFragment fragBrowseShows;
    private HomeFragment fragHome;
    private WatchlistsFragment fragWatchlists;
    private ContextualMenuService mContextualMenuService;
    private com.gotv.crackle.base.BaseActivity.AppSection mCurrentTab;
    private TextView mGoToRecommendedWatchlistText;
    private ListView mListView;
    protected ProgressBar mLoadingProgress;
    private TextView mNoResultFoundText;
    private android.view.View.OnClickListener mOnClickListener;
    private TabsPagerAdapter mPagerAdapter;
    private TextView mSearchEncouragementText;
    private SearchManager mSearchManager;
    private SearchResults mSearchResults;
    private SearchView mSearchView;
    private ViewPager mViewPager;

    public MainActivity()
    {
        mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.HOME;
        mOnClickListener = new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                launchMediaDetails(view);
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
    }

    private void addActionBar()
    {
        setContentView(0x7f030076);
        mViewPager = (ViewPager)findViewById(0x7f0a0189);
        mPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(mPagerAdapter);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(2);
        AbsTabListener abstablistener = new AbsTabListener();
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(0x7f0b0097)).setTabListener(abstablistener));
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(0x7f0b0098)).setTabListener(abstablistener));
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(0x7f0b0099)).setTabListener(abstablistener));
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(0x7f0b009a)).setTabListener(abstablistener));
        actionBar.setSelectedNavigationItem(mCurrentTab.ordinal());
        if (Application.selectedTab != 0) goto _L2; else goto _L1
_L1:
        mViewPager.setCurrentItem(Application.selectedTab);
        mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.HOME;
        actionBar.setSelectedNavigationItem(0);
        Application.selectedTab = 0;
_L4:
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final MainActivity this$0;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
                actionBar.setSelectedNavigationItem(i);
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        return;
_L2:
        if (Application.selectedTab == 1)
        {
            mViewPager.setCurrentItem(Application.selectedTab);
            mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.MOVIES;
            actionBar.setSelectedNavigationItem(1);
            Application.selectedTab = 0;
        } else
        if (Application.selectedTab == 2)
        {
            mViewPager.setCurrentItem(Application.selectedTab);
            mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.SHOWS;
            actionBar.setSelectedNavigationItem(2);
            Application.selectedTab = 0;
        } else
        if (Application.selectedTab == 3)
        {
            mViewPager.setCurrentItem(Application.selectedTab);
            mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS;
            actionBar.setSelectedNavigationItem(3);
            Application.selectedTab = 0;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void displaySearchResults()
    {
label0:
        {
            if (mSearchResults != null)
            {
                if (mSearchResults.getItems().size() <= 0)
                {
                    break label0;
                }
                mListView = (ListView)findViewById(0x7f0a015e);
                mListView.setAdapter(new BrowseGridAdapter(this, mSearchResults.getItems(), mOnClickListener, null, null));
                mListView.setOnItemClickListener(null);
            }
            return;
        }
        mNoResultFoundText = (TextView)findViewById(0x7f0a0160);
        mNoResultFoundText.setVisibility(0);
        mGoToRecommendedWatchlistText = (TextView)findViewById(0x7f0a0161);
        mGoToRecommendedWatchlistText.setOnClickListener(new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                mLoadingProgress.setVisibility(0);
                view = getIntent();
                Application.selectedTab = 3;
                finish();
                startActivity(view);
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        mGoToRecommendedWatchlistText.setVisibility(0);
    }

    private void initializeSearchView(MenuItem menuitem)
    {
        actionBar.setNavigationMode(0);
        android.widget.SearchView.OnQueryTextListener onquerytextlistener;
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.HOME)
        {
            Application.selectedTab = 0;
        } else
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
        {
            Application.selectedTab = 1;
        } else
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.SHOWS)
        {
            Application.selectedTab = 2;
        } else
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS)
        {
            Application.selectedTab = 3;
        }
        mSearchManager = (SearchManager)getSystemService("search");
        mSearchView = (SearchView)menuitem.getActionView();
        mSearchView.setSearchableInfo(mSearchManager.getSearchableInfo(getComponentName()));
        setContentView(0x7f030068);
        mSearchEncouragementText = (TextView)findViewById(0x7f0a015f);
        mSearchEncouragementText.setVisibility(0);
        onquerytextlistener = new android.widget.SearchView.OnQueryTextListener() {

            final MainActivity this$0;

            public boolean onQueryTextChange(String s)
            {
                if (s.length() < 3)
                {
                    return false;
                } else
                {
                    search(s);
                    return true;
                }
            }

            public boolean onQueryTextSubmit(String s)
            {
                search(s);
                return true;
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        };
        mSearchView.setOnQueryTextListener(onquerytextlistener);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            menuitem.setOnActionExpandListener(new android.view.MenuItem.OnActionExpandListener() {

                final MainActivity this$0;

                public boolean onMenuItemActionCollapse(MenuItem menuitem1)
                {
                    menuitem1 = getIntent();
                    finish();
                    startActivity(menuitem1);
                    return true;
                }

                public boolean onMenuItemActionExpand(MenuItem menuitem1)
                {
                    return true;
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            });
            return;
        } else
        {
            mSearchView.setOnCloseListener(new android.widget.SearchView.OnCloseListener() {

                final MainActivity this$0;

                public boolean onClose()
                {
                    Intent intent = new Intent(MainActivity.this, com/gotv/crackle/MainActivity);
                    startActivity(intent);
                    return false;
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void search(String s)
    {
        setContentView(0x7f030068);
        mLoadingProgress = (ProgressBar)findViewById(0x7f0a015d);
        mLoadingProgress.setVisibility(0);
        mSearchResults = new SearchResults(this, s);
    }

    public ContextualMenu createContextualMenu()
    {
        ContextualMenu contextualmenu = new ContextualMenu(getPackageName());
        ContextualMenuSection contextualmenusection = new ContextualMenuSection(getString(0x7f0b002d));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_SETTINGS", getString(0x7f0b011a)));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_ABOUT", getString(0x7f0b006a)));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_FAQ", getString(0x7f0b011f)));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_TERMS", getString(0x7f0b0120)));
        contextualmenusection.add(new ContextualMenuItem("FAN_ID_PRIVACY", getString(0x7f0b0121)));
        contextualmenu.add(contextualmenusection);
        return contextualmenu;
    }

    public Fragment findFragmentByPosition(int i)
    {
        return getSupportFragmentManager().findFragmentByTag((new StringBuilder()).append("android:switcher:").append(mViewPager.getId()).append(":").append(mPagerAdapter.getItemId(i)).toString());
    }

    protected void launchMediaDetails(View view)
    {
        String s = ((BrowseModel)view.getTag()).getID();
        view = ((BrowseModel)view.getTag()).getRootChannelID();
        Intent intent = new Intent(this, com/gotv/crackle/DetailsActivityResolver);
        intent.putExtra("ID", s);
        intent.putExtra("ROOT_CHANNEL", view);
        startActivity(intent);
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    public void onCloseContextualMenu()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (mCurrentTab != com.gotv.crackle.base.BaseActivity.AppSection.HOME) goto _L2; else goto _L1
_L1:
        fragHome = (HomeFragment)findFragmentByPosition(0);
        fragHome.onConfigurationChanged();
_L4:
        super.onConfigurationChanged(configuration);
        return;
_L2:
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
        {
            fragBrowseMovies = (BrowseMoviesFragment)findFragmentByPosition(1);
            fragBrowseMovies.onConfigurationChanged();
        } else
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.SHOWS)
        {
            fragBrowseShows = (BrowseShowsFragment)findFragmentByPosition(2);
            fragBrowseShows.onConfigurationChanged();
        } else
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS)
        {
            fragWatchlists = (WatchlistsFragment)findFragmentByPosition(3);
            fragWatchlists.onConfigurationChanged();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onContextualMenuSelected(String s)
    {
        if ("FAN_ID_SETTINGS".equals(s))
        {
            performMenuAction(0x7f0a01b3);
            return true;
        }
        if ("FAN_ID_ABOUT".equals(s))
        {
            performMenuAction(0x7f0a01b6);
            return true;
        }
        if ("FAN_ID_FAQ".equals(s))
        {
            performMenuAction(0x7f0a01bd);
            return true;
        }
        if ("FAN_ID_TERMS".equals(s))
        {
            performMenuAction(0x7f0a01be);
            return true;
        }
        if ("FAN_ID_PRIVACY".equals(s))
        {
            performMenuAction(0x7f0a01bf);
            return true;
        } else
        {
            return false;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mCurrentTab = com.gotv.crackle.base.BaseActivity.AppSection.valueOf(bundle.getString("currentTab"));
        }
        addActionBar();
        if (Application.isLeanBack())
        {
            try
            {
                getSupportActionBar().setLogo(0x7f0200b5);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle) { }
        }
        if (Application.isFanhattan())
        {
            mContextualMenuService = new ContextualMenuService(this, this);
        }
        if (Application.selectedTab == -1)
        {
            VideoCastManager.checkGooglePlaySevices(this);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (Application.isLeanBack())
        {
            getMenuInflater().inflate(0x7f0f0003, menu);
        } else
        {
            getMenuInflater().inflate(0x7f0f0002, menu);
        }
        mChromeCastHelper.setupMenuItem(menu);
        return true;
    }

    public void onDataFailed(String s, String s1)
    {
        if (!isFinishing())
        {
            runOnUiThread(new Runnable() {

                final MainActivity this$0;

                public void run()
                {
                    try
                    {
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                        builder.setMessage(getResources().getString(0x7f0b0146));
                        builder.setPositiveButton(getResources().getString(0x7f0b00e0), new android.content.DialogInterface.OnClickListener() {

                            final _cls6 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                dialoginterface = getIntent();
                                finish();
                                startActivity(dialoginterface);
                            }

            
            {
                this$1 = _cls6.this;
                super();
            }
                        });
                        builder.create().show();
                        return;
                    }
                    catch (Exception exception)
                    {
                        return;
                    }
                }

            
            {
                this$0 = MainActivity.this;
                super();
            }
            });
        }
    }

    public void onDataSuccess(String s)
    {
        runOnUiThread(new Runnable() {

            final MainActivity this$0;

            public void run()
            {
                if (mSearchResults != null && mSearchResults.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
                {
                    mLoadingProgress.setVisibility(4);
                    displaySearchResults();
                }
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x7f0a01b7)
        {
            sMyCrackleHelper.showSigInOut(this, menuitem);
            if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS && !CrackleAccountManager.isLoggedIn())
            {
                fragWatchlists = (WatchlistsFragment)findFragmentByPosition(3);
                fragWatchlists.displayRecWatchlist();
            }
        } else
        if (i == 0x7f0a01b8)
        {
            initializeSearchView(menuitem);
        } else
        {
            performMenuAction(i);
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        if (Application.isFanhattan())
        {
            mContextualMenuService.onPause();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem = menu.findItem(0x7f0a01b9);
        if (menuitem != null)
        {
            if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.HOME || !Application.getInstance().isTablet() || Application.isLeanBack())
            {
                menuitem.setVisible(false);
            } else
            {
                menuitem.setVisible(true);
            }
        }
        menuitem = menu.findItem(0x7f0a01b4);
        if (!MyCrackleViewHelper.isEnableSessionM() && menuitem != null)
        {
            menuitem.setVisible(false);
        }
        menuitem = menu.findItem(0x7f0a01b7);
        if (CrackleAccountManager.isLoggedIn())
        {
            menuitem.setTitle(getResources().getString(0x7f0b0066));
        } else
        {
            menuitem.setTitle(getResources().getString(0x7f0b0065));
        }
        menu = menu.findItem(0x7f0a01c1);
        if (menu != null && Application.isNookTablet())
        {
            menu.setVisible(false);
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        if (Application.isNielsenOptOutShowing)
        {
            sMyCrackleHelper.showAboutNielsen(this);
        }
        if (Application.isFanhattan())
        {
            mContextualMenuService.onResume();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("currentTab", mCurrentTab.toString());
    }

    protected void performMenuAction(int i)
    {
        if (i != 0x7f0a01bc) goto _L2; else goto _L1
_L1:
        sMyCrackleHelper.showHistory(this);
_L4:
        return;
_L2:
        if (i == 0x7f0a01b3)
        {
            sMyCrackleHelper.showSettings(this);
            return;
        }
        if (i == 0x7f0a01b4)
        {
            sMyCrackleHelper.showSessionMPortal();
            return;
        }
        if (i == 0x7f0a01b5)
        {
            sMyCrackleHelper.showGiveFeedback(this);
            return;
        }
        if (i == 0x7f0a01b6)
        {
            sMyCrackleHelper.showAboutCrackle(this);
            return;
        }
        if (i == 0x7f0a01bd)
        {
            sMyCrackleHelper.showFAQ(this);
            return;
        }
        if (i == 0x7f0a01be)
        {
            sMyCrackleHelper.showTOS(this);
            return;
        }
        if (i == 0x7f0a01bf)
        {
            sMyCrackleHelper.showPrivacyPolicy(this);
            return;
        }
        if (i == 0x7f0a01c0)
        {
            sMyCrackleHelper.showAboutNielsen(this);
            return;
        }
        if (i == 0x7f0a01c1)
        {
            sMyCrackleHelper.showRateMe(this);
            return;
        }
        if (i != 0x7f0a01ba)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
        {
            fragBrowseMovies = (BrowseMoviesFragment)findFragmentByPosition(1);
            fragBrowseMovies.displayGridView();
            return;
        }
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.SHOWS)
        {
            fragBrowseShows = (BrowseShowsFragment)findFragmentByPosition(2);
            fragBrowseShows.displayGridView();
            return;
        }
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS)
        {
            fragWatchlists = (WatchlistsFragment)findFragmentByPosition(3);
            fragWatchlists.displayGridView();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (i != 0x7f0a01bb) goto _L4; else goto _L3
_L3:
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
        {
            fragBrowseMovies = (BrowseMoviesFragment)findFragmentByPosition(1);
            fragBrowseMovies.displayListView();
            return;
        }
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.SHOWS)
        {
            fragBrowseShows = (BrowseShowsFragment)findFragmentByPosition(2);
            fragBrowseShows.displayListView();
            return;
        }
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.WATCHLISTS)
        {
            fragWatchlists = (WatchlistsFragment)findFragmentByPosition(3);
            fragWatchlists.displayListView();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void refreshData()
    {
        if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.HOME)
        {
            fragHome = (HomeFragment)findFragmentByPosition(0);
            fragHome.refreshData();
        } else
        {
            if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.MOVIES)
            {
                fragBrowseMovies = (BrowseMoviesFragment)findFragmentByPosition(1);
                fragBrowseMovies.refreshData();
                return;
            }
            if (mCurrentTab == com.gotv.crackle.base.BaseActivity.AppSection.SHOWS)
            {
                fragBrowseShows = (BrowseShowsFragment)findFragmentByPosition(2);
                fragBrowseShows.refreshData();
                return;
            }
        }
    }





/*
    static com.gotv.crackle.base.BaseActivity.AppSection access$302(MainActivity mainactivity, com.gotv.crackle.base.BaseActivity.AppSection appsection)
    {
        mainactivity.mCurrentTab = appsection;
        return appsection;
    }

*/



}
