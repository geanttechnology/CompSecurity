// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import com.groupon.Channel;
import com.groupon.fragment.CouponInstoreOnlineView;
import com.groupon.fragment.CouponInstoreView;
import com.groupon.fragment.CouponOnlineView;
import com.groupon.util.ActionBarUtil;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, LoggingPageChangeManager, IntentFactory

public class CouponInstoreOnlinePage extends GrouponActivity
{
    public class MyPagerAdapter extends FragmentPagerAdapter
    {

        final CouponInstoreOnlinePage this$0;

        public int getCount()
        {
            return titles.length;
        }

        public Fragment getItem(int i)
        {
            return (Fragment)pages.get(i);
        }

        public CharSequence getPageTitle(int i)
        {
            return titles[i];
        }

        public MyPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = CouponInstoreOnlinePage.this;
            super(fragmentmanager);
        }
    }

    public static final class PageType extends Enum
    {

        private static final PageType $VALUES[];
        public static final PageType INSTORE;
        public static final PageType ONLINE;

        public static PageType valueOf(String s)
        {
            return (PageType)Enum.valueOf(com/groupon/activity/CouponInstoreOnlinePage$PageType, s);
        }

        public static PageType[] values()
        {
            return (PageType[])$VALUES.clone();
        }

        static 
        {
            INSTORE = new PageType("INSTORE", 0);
            ONLINE = new PageType("ONLINE", 1);
            $VALUES = (new PageType[] {
                INSTORE, ONLINE
            });
        }

        private PageType(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final String CURRENT_ITEM = "current_item";
    protected static final String PAGER_TITLE = "pager_title";
    protected String couponSlug;
    protected String filterId;
    protected com.groupon.v3.view.list_view.CouponListItemType.ListItemType freebieListItemType;
    IntentFactory intentFactory;
    protected boolean isDeeplinkd;
    private LoggingPageChangeManager loggingPageChangeManager;
    protected MyPagerAdapter myPagerAdapter;
    protected PagerSlidingTabStrip pagerSlidingTabStrip;
    protected String pagerTitle;
    protected List pages;
    protected PageType starterTab;
    protected String titles[];
    Toolbar toolbar;
    protected GrouponViewPager viewPager;

    public CouponInstoreOnlinePage()
    {
        starterTab = PageType.INSTORE;
        isDeeplinkd = false;
        pages = new ArrayList();
    }

    private CouponInstoreOnlineView getResultListFragment(PageType pagetype)
    {
        if (pagetype.equals(PageType.INSTORE))
        {
            return new CouponInstoreView(filterId, Channel.COUPONS, freebieListItemType, couponSlug, pagerTitle);
        } else
        {
            return new CouponOnlineView(filterId, Channel.COUPONS, freebieListItemType, couponSlug, pagerTitle);
        }
    }

    protected String getCount(int i)
    {
        if (i > 999)
        {
            return " (999+)";
        } else
        {
            return String.format(" (%d)", new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(pagerTitle);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        onNavigationUpPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        onRestoreInstanceState(bundle);
        pagerSlidingTabStrip.setShouldExpand(true);
        titles = (new String[] {
            getString(0x7f0800ec), getString(0x7f080466)
        });
        myPagerAdapter = new MyPagerAdapter(getFragmentManager());
        if (bundle == null)
        {
            pages.add(getResultListFragment(PageType.INSTORE));
            pages.add(getResultListFragment(PageType.ONLINE));
        }
        viewPager.setAdapter(myPagerAdapter);
        pagerSlidingTabStrip.setViewPager(viewPager);
        loggingPageChangeManager.init(viewPager);
        viewPager.setCurrentItem(starterTab.ordinal());
        viewPager.addOnPageChangeListener(loggingPageChangeManager);
    }

    public void onDestroy()
    {
        loggingPageChangeManager.destroy();
        super.onDestroy();
    }

    protected boolean onNavigationUpPressed()
    {
        if (isDeeplinkd)
        {
            ActionBarUtil.navigateUpTo(this, Channel.COUPONS, intentFactory.newCarouselIntent(), null);
        }
        return true;
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        if (bundle != null)
        {
            pagerTitle = bundle.getString("pager_title", "");
            viewPager.setCurrentItem(bundle.getInt("current_item", 0));
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("pager_title", pagerTitle);
        bundle.putInt("current_item", viewPager.getCurrentItem());
    }

    public void setInstoreCount(int i)
    {
        titles[0] = (new StringBuilder()).append(getString(0x7f0800ec)).append(getCount(i)).toString();
        pagerSlidingTabStrip.notifyDataSetChanged();
    }

    public void setOnlineCount(int i)
    {
        titles[1] = (new StringBuilder()).append(getString(0x7f080466)).append(getCount(i)).toString();
        pagerSlidingTabStrip.notifyDataSetChanged();
    }

    public void setTitle(String s)
    {
        pagerTitle = s;
        for (Iterator iterator = pages.iterator(); iterator.hasNext(); ((CouponInstoreOnlineView)iterator.next()).setTitle(s)) { }
        getSupportActionBar().setTitle(s);
    }

    public void updateDeeplinkSelection(int i, int j)
    {
        if (j == 0 && i != 0 && isDeeplinkd)
        {
            viewPager.setCurrentItem(PageType.ONLINE.ordinal());
        }
    }
}
