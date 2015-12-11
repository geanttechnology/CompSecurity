// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TabHost;
import co.vine.android.client.AppSessionListener;
import co.vine.android.widget.tabs.IconTabHost;
import co.vine.android.widget.tabs.TabIndicator;
import co.vine.android.widget.tabs.TabsAdapter;
import co.vine.android.widget.tabs.ViewPagerScrollBar;

// Referenced classes of package co.vine.android:
//            FindFriendsBaseActivity, FindFriendsAddressFragment, FindFriendsTwitterFragment, FindFriendsSearchFragment

public class FindFriendsActivity extends FindFriendsBaseActivity
    implements co.vine.android.widget.tabs.IconTabHost.OnTabClickedListener
{
    private class FindFriendsListener extends AppSessionListener
    {

        final FindFriendsActivity this$0;

        private FindFriendsListener()
        {
            this$0 = FindFriendsActivity.this;
            super();
        }

    }


    public FindFriendsActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), 0x7f0e00de, Boolean.valueOf(true));
        mAppSessionListener = new FindFriendsListener();
        bundle = mTabHost;
        mScrollBar.setRange(3);
        mViewPager.setOffscreenPageLimit(2);
        mTabsAdapter = new TabsAdapter(this, bundle, mViewPager, mScrollBar);
        LayoutInflater layoutinflater = LayoutInflater.from(this);
        bundle.setOnTabChangedListener(this);
        bundle.setOnTabClickedListener(this);
        Bundle bundle1 = new Bundle();
        bundle1.putInt("empty_desc", 0x7f0e00e1);
        mTabsAdapter.addTab(bundle.newTabSpec("address").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f03003f, bundle, 0x7f02011b, 0)), co/vine/android/FindFriendsAddressFragment, bundle1);
        bundle1 = new Bundle();
        bundle1.putInt("empty_desc", 0x7f0e00ef);
        mTabsAdapter.addTab(bundle.newTabSpec("twitter").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f03003f, bundle, 0x7f02011d, 0)), co/vine/android/FindFriendsTwitterFragment, bundle1);
        bundle1 = new Bundle();
        bundle1.putInt("layout", 0x7f03003e);
        mTabsAdapter.addTab(bundle.newTabSpec("search").setIndicator(TabIndicator.newIconIndicator(layoutinflater, 0x7f03003f, bundle, 0x7f02011c, 0)), co/vine/android/FindFriendsSearchFragment, bundle1);
    }

    public void onCurrentTabClicked()
    {
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
