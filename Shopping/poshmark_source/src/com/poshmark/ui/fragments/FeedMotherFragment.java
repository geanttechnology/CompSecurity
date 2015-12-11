// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.notifications.SynchronousBroadcastListener;
import com.poshmark.notifications.SynchronousBroadcastManager;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.FragmentPagerAdapter;
import com.poshmark.utils.ViewUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MyLikesFragment, FeedFragment, FindPeopleFragment

public class FeedMotherFragment extends PMFragment
    implements PMNotificationListener, SynchronousBroadcastListener
{
    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter
    {

        private static final int NUM_PAGES = 3;
        final FeedMotherFragment this$0;

        public int getCount()
        {
            return 3;
        }

        public Fragment getCurrentVisibleFragment()
        {
            return super.getCurrentVisibleFragment();
        }

        public Fragment getItem(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
                myLikesFragment = (PMFragment)Fragment.instantiate(getActivity(), com/poshmark/ui/fragments/MyLikesFragment.getName());
                myLikesFragment.setUserVisibleHint(false);
                return myLikesFragment;

            case 1: // '\001'
                feedFragment = (PMFragment)Fragment.instantiate(getActivity(), com/poshmark/ui/fragments/FeedFragment.getName());
                feedFragment.setUserVisibleHint(false);
                return feedFragment;

            case 2: // '\002'
                peopleFragment = (PMFragment)Fragment.instantiate(getActivity(), com/poshmark/ui/fragments/FindPeopleFragment.getName());
                break;
            }
            peopleFragment.setUserVisibleHint(false);
            return peopleFragment;
        }

        public ScreenSlidePagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = FeedMotherFragment.this;
            super(fragmentmanager);
        }
    }


    private boolean bMyLikesTrackingCallFired;
    private int currentTabIndex;
    PMFragment feedFragment;
    PMTextView feedTextView;
    private ViewPager mPager;
    private ScreenSlidePagerAdapter mPagerAdapter;
    private TabHost mTabHost;
    PMFragment myLikesFragment;
    PMTextView myLikesTextView;
    PMFragment peopleFragment;
    PMTextView peopleTextView;

    public FeedMotherFragment()
    {
        currentTabIndex = 1;
        bMyLikesTrackingCallFired = false;
    }

    private PMTextView getTabTextViewWithTitle(String s, boolean flag)
    {
        PMTextView pmtextview = new PMTextView(getActivity(), null);
        pmtextview.setTextSize(2, 14F);
        pmtextview.setHeight((int)ViewUtils.dipToPixels(getActivity(), 40F));
        pmtextview.setBackgroundResource(0x7f020001);
        pmtextview.setText(s);
        pmtextview.setGravity(17);
        setTabTextViewSelected(pmtextview, flag);
        return pmtextview;
    }

    private void initialiseTabHost()
    {
        mTabHost.setup();
        String s = getString(0x7f0601b3);
        android.widget.TabHost.TabSpec tabspec = mTabHost.newTabSpec(s).setContent(0x7f0c0049);
        myLikesTextView = getTabTextViewWithTitle(s, false);
        tabspec.setIndicator(myLikesTextView);
        mTabHost.addTab(tabspec);
        s = getString(0x7f06010f);
        tabspec = mTabHost.newTabSpec(s).setContent(0x7f0c0049);
        feedTextView = getTabTextViewWithTitle(s, true);
        tabspec.setIndicator(feedTextView);
        mTabHost.addTab(tabspec);
        s = getString(0x7f0601fd);
        tabspec = mTabHost.newTabSpec(s).setContent(0x7f0c0049);
        peopleTextView = getTabTextViewWithTitle(s, false);
        tabspec.setIndicator(peopleTextView);
        mTabHost.addTab(tabspec);
        mTabHost.setOnTabChangedListener(new android.widget.TabHost.OnTabChangeListener() {

            final FeedMotherFragment this$0;

            public void onTabChanged(String s1)
            {
                int i = mTabHost.getCurrentTab();
                i;
                JVM INSTR tableswitch 0 2: default 40
            //                           0 116
            //                           1 164
            //                           2 212;
                   goto _L1 _L2 _L3 _L4
_L1:
                break; /* Loop/switch isn't completed */
_L4:
                break MISSING_BLOCK_LABEL_212;
_L5:
                int j = mPager.getCurrentItem();
                if (i != currentTabIndex)
                {
                    if (i == 0 && !bMyLikesTrackingCallFired)
                    {
                        PMApi.getViewTrackingInfo("mlk");
                        bMyLikesTrackingCallFired = true;
                    } else
                    {
                        bMyLikesTrackingCallFired = false;
                    }
                }
                if (j != i)
                {
                    mPager.setCurrentItem(i);
                    currentTabIndex = i;
                }
                return;
_L2:
                setTabTextViewSelected(myLikesTextView, true);
                setTabTextViewSelected(feedTextView, false);
                setTabTextViewSelected(peopleTextView, false);
                  goto _L5
_L3:
                setTabTextViewSelected(myLikesTextView, false);
                setTabTextViewSelected(feedTextView, true);
                setTabTextViewSelected(peopleTextView, false);
                  goto _L5
                setTabTextViewSelected(myLikesTextView, false);
                setTabTextViewSelected(feedTextView, false);
                setTabTextViewSelected(peopleTextView, true);
                  goto _L5
            }

            
            {
                this$0 = FeedMotherFragment.this;
                super();
            }
        });
    }

    private void setTabTextViewSelected(PMTextView pmtextview, boolean flag)
    {
        if (flag)
        {
            pmtextview.setTextColor(getResources().getColor(0x7f09003c));
            pmtextview.setTypeface(Typeface.SANS_SERIF, 1);
            return;
        } else
        {
            pmtextview.setTextColor(getResources().getColor(0x7f090038));
            pmtextview.setTypeface(Typeface.SANS_SERIF, 0);
            return;
        }
    }

    private void setupViewPager()
    {
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            final FeedMotherFragment this$0;

            public void onPageSelected(int i)
            {
                if (mTabHost.getCurrentTab() != i)
                {
                    mTabHost.setCurrentTab(i);
                    currentTabIndex = i;
                }
            }

            
            {
                this$0 = FeedMotherFragment.this;
                super();
            }
        });
    }

    public boolean handleBack()
    {
        myLikesFragment.handleBack();
        feedFragment.handleBack();
        peopleFragment.handleBack();
        return false;
    }

    public void handleNotification(Intent intent)
    {
label0:
        {
            if (intent.getAction().equals("com.poshmark.intents.LISTING_CREATED"))
            {
                if (!isAdded() || mTabHost == null)
                {
                    break label0;
                }
                currentTabIndex = 1;
                mTabHost.setCurrentTab(currentTabIndex);
            }
            return;
        }
        currentTabIndex = 1;
    }

    public void handleSynchronousBroadcastMsg(String s, Object obj)
    {
        if (s.equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            currentTabIndex = 1;
        }
    }

    public void logScreenTracking()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        initialiseTabHost();
        setupViewPager();
        if (currentTabIndex == 0)
        {
            int i = currentTabIndex;
            mTabHost.setCurrentTab(1);
            mTabHost.setCurrentTab(i);
            return;
        } else
        {
            mTabHost.setCurrentTab(currentTabIndex);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030051, viewgroup, false);
        layoutinflater.getRootView().setBackgroundColor(getResources().getColor(0x7f090015));
        mPager = (ViewPager)layoutinflater.findViewById(0x7f0c0049);
        mTabHost = (TabHost)layoutinflater.findViewById(0x7f0c0139);
        mPagerAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPager = null;
        mTabHost = null;
    }

    public void onPMResume()
    {
        super.onPMResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LISTING_CREATED", this);
        SynchronousBroadcastManager.getSyncronousBroadcastManager().registerSynchronousBroadcastListener("com.poshmark.intents.LOGOUT_COMPLETE", this);
        if (currentTabIndex != mTabHost.getCurrentTab())
        {
            mTabHost.setCurrentTab(currentTabIndex);
        }
    }

    public void onPause()
    {
        super.onPause();
        SynchronousBroadcastManager.getSyncronousBroadcastManager().unregisterSynchronousBroadcastListener("com.poshmark.intents.LOGOUT_COMPLETE", this);
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void setViewNameForAnalytics()
    {
    }




/*
    static int access$102(FeedMotherFragment feedmotherfragment, int i)
    {
        feedmotherfragment.currentTabIndex = i;
        return i;
    }

*/





/*
    static boolean access$402(FeedMotherFragment feedmotherfragment, boolean flag)
    {
        feedmotherfragment.bMyLikesTrackingCallFired = flag;
        return flag;
    }

*/
}
