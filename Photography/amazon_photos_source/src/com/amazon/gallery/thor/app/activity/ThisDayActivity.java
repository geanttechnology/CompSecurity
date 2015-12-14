// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.CommonActivity;
import com.amazon.gallery.framework.kindle.cds.SyncHandler;
import com.amazon.gallery.framework.kindle.fragment.ThisDayDataFragment;
import com.amazon.gallery.framework.kindle.fragment.ThisDayFragment;
import com.amazon.gallery.framework.kindle.ui.ActivityIndicatorCheckThread;
import com.amazon.gallery.framework.kindle.ui.LoadingSpinner;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.controller.NavigationPaneController;
import com.amazon.gallery.thor.di.GalleryActivityBeans;
import com.amazon.gallery.thor.presenters.ThisDayPresenter;
import com.amazon.gallery.thor.thisday.ThisDayEmailFragment;
import com.amazon.gallery.thor.thisday.ThisDayMetricsHelper;
import com.amazon.gallery.thor.thisday.ThisDaySharedPrefsManager;
import com.amazon.gallery.thor.thisday.ThisDayUtils;
import com.amazon.gallery.thor.thisday.ThisDayViewCollection;
import com.amazon.gallery.thor.view.AsyncDataLoadingView;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AndroidToolbar, GalleryNavigationSetting, GalleryToolbar

public class ThisDayActivity extends CommonActivity
    implements AsyncDataLoadingView
{
    private static class ThisDayFragmentAdapter extends FragmentPagerAdapter
    {

        private final ThisDayFragment fragments[] = new ThisDayFragment[3];
        private final String tabTitles[];

        public void addFragment(ThisDayFragment thisdayfragment, int i)
        {
            fragments[i] = thisdayfragment;
        }

        public int getCount()
        {
            return fragments.length;
        }

        public Fragment getItem(int i)
        {
            return fragments[i];
        }

        public CharSequence getPageTitle(int i)
        {
            return tabTitles[i];
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            viewgroup = (ThisDayFragment)super.instantiateItem(viewgroup, i);
            fragments[i] = viewgroup;
            return viewgroup;
        }

        ThisDayFragmentAdapter(FragmentManager fragmentmanager, String as[])
        {
            super(fragmentmanager);
            tabTitles = as;
        }
    }


    private static String KEY_FIRST_LOAD_COMPLETED = "first_load_completed";
    private static String KEY_FOCUSED_COLLECTION_TYPE = "focused_collection";
    private ActivityIndicatorCheckThread activityIndicatorCheckThread;
    private ThisDayDataFragment dataFragment;
    private ActionBarDrawerToggle drawerToggle;
    private boolean firstLoadCompleted;
    private GridStatus gridStatus;
    private MediaItemDao mediaItemDao;
    private ThisDayMetricsHelper metricsHelper;
    private PhotosNavigationPane navPane;
    private NavigationPaneController navPaneController;
    private ThisDayFragmentAdapter pagerAdapter;
    private ThisDayPresenter presenter;
    private TabLayout tabLayout;
    private TagDao tagDao;
    private GalleryToolbar toolbar;
    private ViewPager viewPager;

    public ThisDayActivity()
    {
        super(new GalleryActivityBeans(), null);
        firstLoadCompleted = false;
    }

    private void hideFirstLoadProgress()
    {
        findViewById(0x7f0c01ef).setVisibility(8);
    }

    private void reportMetric(ThisDayViewCollection thisdayviewcollection)
    {
        switch (thisdayviewcollection.collectionType)
        {
        default:
            return;

        case 0: // '\0'
            metricsHelper.onOpenThisDayView(thisdayviewcollection);
            return;

        case 1: // '\001'
            metricsHelper.onOpenThisWeekView(thisdayviewcollection);
            return;

        case 2: // '\002'
            metricsHelper.onOpenShuffleView(thisdayviewcollection);
            break;
        }
    }

    private void setupActionBar()
    {
        toolbar = new AndroidToolbar(this, (Toolbar)findViewById(0x7f0c0086), navPane);
        toolbar.setNavigationSetting(GalleryNavigationSetting.LEFT);
        toolbar.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final ThisDayActivity this$0;

            public void onClick(View view)
            {
                navPane.open();
            }

            
            {
                this$0 = ThisDayActivity.this;
                super();
            }
        });
        toolbar.setTitle(ThisDayUtils.getTitleForThisDayCollectionView(this));
        drawerToggle = new ActionBarDrawerToggle(this, (DrawerLayout)navPane, ((AndroidToolbar)toolbar).getToolbar(), 0, 0);
        drawerToggle.setDrawerIndicatorEnabled(true);
    }

    private void setupActivityIndicator(GridStatus gridstatus)
    {
        activityIndicatorCheckThread = new ActivityIndicatorCheckThread(this, null, gridstatus, (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY));
        activityIndicatorCheckThread.getLoadingSpinner().setSpinnerColor(getResources().getColor(0x7f090004));
        activityIndicatorCheckThread.start();
    }

    private void setupDataFragment()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        dataFragment = (ThisDayDataFragment)fragmentmanager.findFragmentByTag(com/amazon/gallery/framework/kindle/fragment/ThisDayDataFragment.getSimpleName());
        if (dataFragment == null)
        {
            dataFragment = new ThisDayDataFragment();
            fragmentmanager.beginTransaction().add(dataFragment, com/amazon/gallery/framework/kindle/fragment/ThisDayDataFragment.getSimpleName()).commitAllowingStateLoss();
            fragmentmanager.executePendingTransactions();
        }
    }

    private void setupNavPane()
    {
        navPane = (PhotosNavigationPane)findViewById(0x7f0c014e);
        navPaneController = new NavigationPaneController(this, navPane, tagDao, mediaItemDao, (Executor)ThorGalleryApplication.getBean(Keys.UI_READY_EXECUTOR));
    }

    private void setupPresenter()
    {
        presenter = (ThisDayPresenter)dataFragment.getSavedState();
        if (presenter != null)
        {
            presenter.updateView(this);
            return;
        } else
        {
            presenter = new ThisDayPresenter(this, getApplicationContext(), mediaItemDao);
            return;
        }
    }

    private void setupTabLayout()
    {
        tabLayout = (TabLayout)findViewById(0x7f0c01ed);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager()
    {
        viewPager = (ViewPager)findViewById(0x7f0c01ee);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(0x7f0a01c6));
        String s = getResources().getString(0x7f0e020b);
        String s1 = getResources().getString(0x7f0e021e);
        String s2 = getResources().getString(0x7f0e0216);
        pagerAdapter = new ThisDayFragmentAdapter(getSupportFragmentManager(), new String[] {
            s, s1, s2
        });
        pagerAdapter.addFragment(ThisDayFragment.newInstance(0), 0);
        pagerAdapter.addFragment(ThisDayFragment.newInstance(1), 1);
        pagerAdapter.addFragment(ThisDayFragment.newInstance(2), 2);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

            final ThisDayActivity this$0;

            public void onPageScrollStateChanged(int i)
            {
            }

            public void onPageScrolled(int i, float f, int j)
            {
            }

            public void onPageSelected(int i)
            {
                if (firstLoadCompleted)
                {
                    updateActionBarSubTitle(i);
                }
            }

            
            {
                this$0 = ThisDayActivity.this;
                super();
            }
        });
    }

    private void showFirstLoadProgress()
    {
        findViewById(0x7f0c01ef).setVisibility(0);
    }

    private void updateActionBarSubTitle(int i)
    {
        toolbar.setSubtitle(ThisDayUtils.getSubTitleForThisDayCollectionView(this, i));
    }

    protected SyncHandler createSyncHandler()
    {
        return null;
    }

    protected void fetchBeans()
    {
        super.fetchBeans();
        mediaItemDao = (MediaItemDao)getApplicationBean(Keys.MEDIA_ITEM_DAO);
        tagDao = (TagDao)getApplicationBean(Keys.TAG_DAO);
    }

    protected String getAccessibilityDescription()
    {
        return getResources().getString(0x7f0e0164);
    }

    public GridStatus getActivityStatusIndicator()
    {
        return gridStatus;
    }

    public ThisDayMetricsHelper getMetricsHelper()
    {
        return metricsHelper;
    }

    public void loadDataForCollection(int i, boolean flag)
    {
        presenter.loadDataAsync(i, flag);
    }

    public void onCreate(Bundle bundle)
    {
        gridStatus = new GridStatus();
        super.onCreate(bundle);
        setContentView(0x7f0300e2);
        setupNavPane();
        setupActionBar();
        setupDataFragment();
        setupPresenter();
        setupActivityIndicator(gridStatus);
        metricsHelper = new ThisDayMetricsHelper((Profiler)getApplicationBean(Keys.PROFILER));
        if (getIntent().hasExtra("thisDayNotificationIntent"))
        {
            metricsHelper.onOpenFromNotification(getIntent().getIntExtra("thisDayNotificationSubtitle", -1));
        }
        presenter.onViewCreated(bundle);
        if (bundle != null && bundle.getBoolean(KEY_FIRST_LOAD_COMPLETED))
        {
            setupViewPager();
            setupTabLayout();
            int i = bundle.getInt(KEY_FOCUSED_COLLECTION_TYPE);
            tabLayout.getTabAt(i).select();
            firstLoadCompleted = true;
        } else
        {
            showFirstLoadProgress();
            loadDataForCollection(0, true);
        }
        (new ThisDaySharedPrefsManager(this)).setLastVisitedByUserTime(System.currentTimeMillis());
    }

    public void onDataLoaded(ThisDayViewCollection thisdayviewcollection)
    {
        if (firstLoadCompleted) goto _L2; else goto _L1
_L1:
        thisdayviewcollection.collectionType;
        JVM INSTR tableswitch 0 1: default 32
    //                   0 88
    //                   1 102;
           goto _L3 _L4 _L5
_L3:
        int i = 0;
        if (!thisdayviewcollection.isEmpty())
        {
            i = thisdayviewcollection.collectionType;
        }
        hideFirstLoadProgress();
        setupViewPager();
        setupTabLayout();
        tabLayout.getTabAt(i).select();
        updateActionBarSubTitle(thisdayviewcollection.collectionType);
        firstLoadCompleted = true;
_L8:
        reportMetric(thisdayviewcollection);
        return;
_L4:
        if (!thisdayviewcollection.isEmpty()) goto _L3; else goto _L6
_L6:
        loadDataForCollection(1, true);
        return;
_L5:
        if (!thisdayviewcollection.isEmpty()) goto _L3; else goto _L7
_L7:
        loadDataForCollection(2, true);
        return;
_L2:
        if (tabLayout.getSelectedTabPosition() == thisdayviewcollection.collectionType)
        {
            ThisDayFragment thisdayfragment = (ThisDayFragment)pagerAdapter.getItem(thisdayviewcollection.collectionType);
            if (thisdayviewcollection.isEmpty())
            {
                thisdayfragment.displayEmptyState();
            } else
            {
                thisdayfragment.displayData(thisdayviewcollection);
            }
        } else
        {
            ThisDayFragment thisdayfragment1 = (ThisDayFragment)pagerAdapter.getItem(thisdayviewcollection.collectionType);
            if (thisdayfragment1.isAdded() && !thisdayfragment1.isRemoving())
            {
                if (thisdayviewcollection.isEmpty())
                {
                    thisdayfragment1.displayEmptyState();
                } else
                {
                    thisdayfragment1.displayData(thisdayviewcollection);
                }
            }
        }
          goto _L8
    }

    public volatile void onDataLoaded(Object obj)
    {
        onDataLoaded((ThisDayViewCollection)obj);
    }

    public void onDestroy()
    {
        gridStatus.reset();
        presenter.onViewDestroyed();
        activityIndicatorCheckThread.onDestroy();
        navPaneController.onDestroy();
        super.onDestroy();
    }

    public void onEmailOperationCompleted(String s, boolean flag)
    {
        int i;
        if (flag)
        {
            Snackbar.make(findViewById(0x7f0c01eb), getString(0x7f0e00b0, new Object[] {
                s
            }), 0).show();
        } else
        {
            Snackbar.make(findViewById(0x7f0c01eb), getString(0x7f0e00bb), 0).show();
        }
        i = tabLayout.getSelectedTabPosition();
        s = (ThisDayFragment)pagerAdapter.getItem(i);
        if (s.isAdded() && !s.isRemoving())
        {
            s.onEmailOperationCompleted();
        }
    }

    public void onPause()
    {
        presenter.onViewPaused();
        super.onPause();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        drawerToggle.syncState();
    }

    public void onResume()
    {
        super.onResume();
        navPaneController.onResume();
        navPane.select(0x7f0c0269);
        presenter.onViewResumed();
        if (firstLoadCompleted && tabLayout != null)
        {
            updateActionBarSubTitle(tabLayout.getSelectedTabPosition());
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(KEY_FIRST_LOAD_COMPLETED, firstLoadCompleted);
        if (firstLoadCompleted)
        {
            bundle.putInt(KEY_FOCUSED_COLLECTION_TYPE, tabLayout.getSelectedTabPosition());
        }
        dataFragment.saveState(presenter);
    }

    public void onStartLoadData()
    {
    }

    public void startEmailOperation(String s)
    {
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(com/amazon/gallery/thor/thisday/ThisDayEmailFragment.getSimpleName());
        if (fragment != null)
        {
            fragmenttransaction.remove(fragment);
        }
        fragmenttransaction.addToBackStack(null);
        ThisDayEmailFragment.newInstance(s).show(fragmenttransaction, com/amazon/gallery/thor/thisday/ThisDayEmailFragment.getSimpleName());
    }




}
