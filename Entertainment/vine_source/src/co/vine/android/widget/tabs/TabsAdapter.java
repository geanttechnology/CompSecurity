// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.tabs;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import co.vine.android.BaseArrayListFragment;
import co.vine.android.BaseControllerActionBarActivity;
import co.vine.android.BaseFragment;
import co.vine.android.widget.OnTabChangedListener;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android.widget.tabs:
//            DummyTabFactory, TabInfo, TabIndicator, TabScrollListener, 
//            ViewPagerScrollBar, IconTabHost, TabSavedState

public class TabsAdapter extends FragmentPagerAdapter
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private final BaseControllerActionBarActivity mActivity;
    private final ViewPagerScrollBar mScrollBar;
    private boolean mSetActionBarColorOnPageSelectedEnabled;
    private final DummyTabFactory mTabFactory;
    private final TabHost mTabHost;
    private final ArrayList mTabs = new ArrayList();
    private final ViewPager mViewPager;
    public int previousTab;

    public TabsAdapter(BaseControllerActionBarActivity basecontrolleractionbaractivity, TabHost tabhost, ViewPager viewpager, ViewPagerScrollBar viewpagerscrollbar)
    {
        super(basecontrolleractionbaractivity.getSupportFragmentManager());
        mSetActionBarColorOnPageSelectedEnabled = true;
        mActivity = basecontrolleractionbaractivity;
        mTabHost = tabhost;
        mViewPager = viewpager;
        mViewPager.setAdapter(this);
        mViewPager.setOnPageChangeListener(this);
        mScrollBar = viewpagerscrollbar;
        mTabFactory = new DummyTabFactory(mActivity);
    }

    public void addTab(android.widget.TabHost.TabSpec tabspec, Class class1, Bundle bundle)
    {
        class1 = new TabInfo(class1, bundle, tabspec.getTag());
        tabspec.setContent(mTabFactory);
        mTabs.add(class1);
        mTabHost.addTab(tabspec);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return mTabs.size();
    }

    public Fragment getCurrentFragment()
    {
        TabInfo tabinfo = getTab(mTabHost.getCurrentTab());
        if (tabinfo != null)
        {
            return tabinfo.fragment();
        } else
        {
            return null;
        }
    }

    public TabIndicator getIndicator(int i)
    {
        TabWidget tabwidget = mTabHost.getTabWidget();
        if (tabwidget != null)
        {
            return (TabIndicator)tabwidget.getChildTabViewAt(i);
        } else
        {
            return null;
        }
    }

    public Fragment getItem(int i)
    {
        return Fragment.instantiate(mActivity, ((TabInfo)mTabs.get(i)).clss.getName(), ((TabInfo)mTabs.get(i)).bundle);
    }

    public int getItemPosition(Object obj)
    {
        boolean flag1 = false;
        Iterator iterator = mTabs.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            if (((TabInfo)iterator.next()).fragment() != obj)
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return !flag ? -2 : -1;
    }

    public ImageView getNewIndicatorForTab(int i)
    {
        TabIndicator tabindicator = getIndicator(i);
        if (tabindicator != null)
        {
            return tabindicator.getNewIndicator();
        } else
        {
            return null;
        }
    }

    public TabInfo getTab(int i)
    {
        return (TabInfo)mTabs.get(i);
    }

    public ArrayList getTabs()
    {
        return mTabs;
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (Fragment)super.instantiateItem(viewgroup, i);
        ((TabInfo)mTabs.get(i)).setFragment(viewgroup);
        if (viewgroup instanceof BaseArrayListFragment)
        {
            ((BaseArrayListFragment)viewgroup).setScrollListener(new TabScrollListener(mActivity, i));
        }
        return viewgroup;
    }

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (mViewPager.getCurrentItem() < i && mScrollBar != null)
        {
            mScrollBar.scroll(i, -j);
        } else
        if (mScrollBar != null)
        {
            mScrollBar.scroll(i, j);
            return;
        }
    }

    public void onPageSelected(int i)
    {
        TabWidget tabwidget = mTabHost.getTabWidget();
        int j = tabwidget.getDescendantFocusability();
        tabwidget.setDescendantFocusability(0x60000);
        if (i != previousTab)
        {
            ((IconTabHost)mTabHost).setTabExplicit(i);
            Fragment fragment = ((TabInfo)mTabs.get(previousTab)).fragment();
            if (fragment != null && (fragment instanceof OnTabChangedListener))
            {
                ((OnTabChangedListener)fragment).onMoveAway(i);
            }
            fragment = ((TabInfo)mTabs.get(i)).fragment();
            if (fragment != null && (fragment instanceof OnTabChangedListener))
            {
                ((OnTabChangedListener)fragment).onMoveTo(previousTab);
            }
            if (fragment != null && mSetActionBarColorOnPageSelectedEnabled)
            {
                ((BaseFragment)fragment).setActionBarColor();
            }
        }
        previousTab = mTabHost.getCurrentTab();
        if (mScrollBar != null)
        {
            mScrollBar.setPageColor(i);
        }
        tabwidget.setDescendantFocusability(j);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classloader)
    {
        parcelable = ((TabSavedState)parcelable).tags;
        for (int i = 0; i < parcelable.length; i++)
        {
            classloader = parcelable[i];
            classloader = mActivity.getSupportFragmentManager().findFragmentByTag(classloader);
            if (classloader == null)
            {
                continue;
            }
            ((TabInfo)mTabs.get(i)).setFragment(classloader);
            if (classloader instanceof BaseArrayListFragment)
            {
                ((BaseArrayListFragment)classloader).setScrollListener(new TabScrollListener(mActivity, i));
            }
        }

    }

    public Parcelable saveState()
    {
        return new TabSavedState(mTabs);
    }

    public void setNew(int i, boolean flag)
    {
        TabIndicator tabindicator = getIndicator(i);
        if (tabindicator != null)
        {
            tabindicator.setNew(flag);
        }
    }

    public void setSetActionBarColorOnPageSelectedEnabled(boolean flag)
    {
        mSetActionBarColorOnPageSelectedEnabled = flag;
    }

    public ArrayList tabs()
    {
        return mTabs;
    }
}
