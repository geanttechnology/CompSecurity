// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;
import co.vine.android.util.BuildUtil;
import co.vine.android.widget.OnTabChangedListener;
import co.vine.android.widget.tabs.IconTabHost;
import co.vine.android.widget.tabs.TabInfo;
import co.vine.android.widget.tabs.TabsAdapter;
import co.vine.android.widget.tabs.ViewPagerScrollBar;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            BaseControllerActionBarActivity

public class FindFriendsBaseActivity extends BaseControllerActionBarActivity
    implements android.widget.TabHost.OnTabChangeListener, co.vine.android.widget.tabs.IconTabHost.OnTabClickedListener
{

    public static final String EXTRA_IS_TWITTER_REG = "is_twitter_reg";
    private static final String STATE_CURRENT_TAB = "currentTab";
    public static final String TAG_ADDRESS_BOOK = "address";
    public static final String TAG_SEARCH = "search";
    public static final String TAG_TWITTER = "twitter";
    protected ViewPagerScrollBar mScrollBar;
    protected IconTabHost mTabHost;
    protected TabsAdapter mTabsAdapter;
    protected ViewPager mViewPager;

    public FindFriendsBaseActivity()
    {
    }

    private void setupTabs()
    {
        mTabHost = (IconTabHost)findViewById(0x1020012);
        if (mTabHost == null)
        {
            throw new RuntimeException("Your content must have a TabHost whose id attribute is 'android.R.id.tabhost'");
        } else
        {
            mTabHost.setup();
            mViewPager = (ViewPager)findViewById(0x7f0a00da);
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 2: default 24
    //                   1 25
    //                   2 25;
           goto _L1 _L2 _L2
_L1:
        Fragment fragment;
        return;
_L2:
        if ((fragment = mTabsAdapter.getTab(1).fragment()) != null)
        {
            fragment.onActivityResult(i, j, intent);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030053, true);
        if (BuildUtil.isExplore())
        {
            setupTabs();
        }
        mScrollBar = (ViewPagerScrollBar)findViewById(0x7f0a011c);
        bundle = getIntent();
        if (bundle != null && bundle.getBooleanExtra("is_twitter_reg", false))
        {
            mScrollBar.setColorIds(0x7f070001);
        }
        mViewPager = (ViewPager)findViewById(0x7f0a00da);
        mViewPager.setPageMargin(getResources().getDimensionPixelSize(0x7f0b0054));
        mViewPager.setPageMarginDrawable(0x7f09000e);
    }

    public void onCurrentTabClicked()
    {
    }

    protected void onDestroy()
    {
        super.onDestroy();
        int i = mTabHost.getCurrentTab();
        Fragment fragment = ((TabInfo)mTabsAdapter.getTabs().get(i)).fragment();
        if (fragment instanceof OnTabChangedListener)
        {
            ((OnTabChangedListener)fragment).onMoveAway(i);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        bundle = bundle.getString("currentTab");
        if (bundle != null)
        {
            setCurrentTabByTag(bundle);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        String s = mTabHost.getCurrentTabTag();
        if (s != null)
        {
            bundle.putString("currentTab", s);
        }
    }

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        if (!BuildUtil.isExplore())
        {
            setupTabs();
        }
    }

    public void onTabChanged(String s)
    {
        mViewPager.setCurrentItem(mTabHost.getCurrentTab());
    }

    void setCurrentTabByTag(String s)
    {
        IconTabHost icontabhost = mTabHost;
        if (!s.equals(icontabhost.getCurrentTabTag()))
        {
            icontabhost.setCurrentTabByTag(s);
        }
        mScrollBar.setPosition(mViewPager.getCurrentItem());
    }
}
