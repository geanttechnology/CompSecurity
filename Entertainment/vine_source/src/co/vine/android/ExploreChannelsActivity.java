// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;
import co.vine.android.api.VineChannel;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.tabs.IconTabHost;
import co.vine.android.widget.tabs.ScrollAwayTabWidget;
import co.vine.android.widget.tabs.TabIndicator;
import co.vine.android.widget.tabs.TabsAdapter;
import co.vine.android.widget.tabs.ViewPagerScrollBar;
import com.twitter.android.widget.TopScrollable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package co.vine.android:
//            BaseTimelineActivity, BaseTimelineFragment, ExploreChannelsFragment, BaseArrayListFragment

public class ExploreChannelsActivity extends BaseTimelineActivity
    implements android.widget.TabHost.OnTabChangeListener, co.vine.android.widget.tabs.IconTabHost.OnTabClickedListener
{
    class ExploreChannelsAppSessionListener extends AppSessionListener
    {

        final ExploreChannelsActivity this$0;

        public void onGetChannelsComplete(String s, int i, String s1, ArrayList arraylist)
        {
            if (i == 200 && !TextUtils.isEmpty(mChannelId))
            {
                long l = Long.valueOf(mChannelId).longValue();
                s1 = arraylist.iterator();
                do
                {
                    if (!s1.hasNext())
                    {
                        break;
                    }
                    s = (VineChannel)s1.next();
                    if (l == ((VineChannel) (s)).channelId)
                    {
                        boolean flag = Util.isHighRes(ExploreChannelsActivity.this);
                        arraylist = ExploreChannelsActivity.this;
                        if (flag)
                        {
                            s = ((VineChannel) (s)).retinaIconFullUrl;
                        } else
                        {
                            s = ((VineChannel) (s)).iconFullUrl;
                        }
                        arraylist.setIconImage(s);
                    }
                } while (true);
            }
        }

        public void onPhotoImageLoaded(HashMap hashmap)
        {
            if (!hashmap.isEmpty() && mIconImageKey != null)
            {
                hashmap = (UrlImage)hashmap.get(mIconImageKey);
                if (hashmap != null && hashmap.isValid() && ((UrlImage) (hashmap)).bitmap != null)
                {
                    setIconImage(((UrlImage) (hashmap)).bitmap);
                }
            }
        }

        ExploreChannelsAppSessionListener()
        {
            this$0 = ExploreChannelsActivity.this;
            super();
        }
    }


    public static final int LOADER_ID_ICON_PATH = 0;
    public static final String PARAM_ICON_PATH = "icon";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_NAV_RGB = "navRGB";
    public static final String PARAM_SHOW_RECENT = "showRecent";
    public static final String PARAM_TITLE_RGB = "titleRGB";
    public static final int PATH_SEGMENT_CHANNEL_ID = 0;
    public static final String SORT_POPULAR = "popular";
    public static final String SORT_RECENT = "recent";
    public static final String TAG_POPULAR = "popular";
    public static final String TAG_RECENT = "recent";
    private String mChannelId;
    private ImageKey mIconImageKey;
    private ViewPagerScrollBar mScrollBar;
    private IconTabHost mTabHost;
    private TabsAdapter mTabsAdapter;
    private ViewPager mViewPager;

    public ExploreChannelsActivity()
    {
    }

    private void setIconImage(Bitmap bitmap)
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            int i = getResources().getDimensionPixelSize(0x7f0b0011);
            bitmap = Bitmap.createScaledBitmap(bitmap, i, i, true);
            actionbar.setIcon(new BitmapDrawable(getResources(), bitmap));
        }
    }

    private void setIconImage(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            mIconImageKey = new ImageKey((new StringBuilder()).append(BuildUtil.getWebsiteUrl(this)).append(s).toString());
            s = mAppController.getPhotoBitmap(mIconImageKey);
            if (s != null)
            {
                setIconImage(((Bitmap) (s)));
            }
        }
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

    protected BaseTimelineFragment getCurrentTimeLineFragment()
    {
        Fragment fragment = mTabsAdapter.getCurrentFragment();
        if (fragment instanceof BaseTimelineFragment)
        {
            return (BaseTimelineFragment)fragment;
        } else
        {
            return null;
        }
    }

    public boolean hasTabs()
    {
        return mTabHost.getTabWidget().getVisibility() == 0;
    }

    public boolean isShowing(String s)
    {
        return s != null && s.equals(mTabHost.getCurrentTabTag());
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        BaseTimelineFragment basetimelinefragment = getCurrentTimeLineFragment();
        if (basetimelinefragment != null)
        {
            basetimelinefragment.onActivityResult(i, j, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030052, true);
        if (BuildUtil.isExplore())
        {
            setupTabs();
        }
        mAppSessionListener = new ExploreChannelsAppSessionListener();
        Object obj1 = getIntent();
        if (obj1 == null || ((Intent) (obj1)).getData() == null)
        {
            throw new IllegalAccessError("Intent data is null. You must provide a URI in order to view a video list.");
        }
        bundle = ((Intent) (obj1)).getData();
        String s = (String)bundle.getPathSegments().get(0);
        String s1 = bundle.getQueryParameter("icon");
        String s2 = (new StringBuilder()).append("#").append(bundle.getQueryParameter("navRGB")).toString();
        Object obj2 = (new StringBuilder()).append("#").append(bundle.getQueryParameter("titleRGB")).toString();
        boolean flag = bundle.getBooleanQueryParameter("showRecent", false);
        Object obj = bundle.getQueryParameter("name");
        bundle = ((Bundle) (obj));
        if (obj != null)
        {
            bundle = ((String) (obj)).replace('+', ' ');
        }
        int i;
        int j;
        int k;
        try
        {
            i = Color.parseColor(s2);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            i = getResources().getColor(0x7f090096);
        }
        try
        {
            j = Color.parseColor(((String) (obj2)));
        }
        catch (IllegalArgumentException illegalargumentexception1)
        {
            j = getResources().getColor(0x7f090083);
        }
        setupActionBar(Boolean.valueOf(true), Boolean.valueOf(true), null, Boolean.valueOf(true));
        obj = getSupportActionBar();
        if (obj != null)
        {
            ((ActionBar) (obj)).setTitle(bundle);
            ((ActionBar) (obj)).setBackgroundDrawable(new ColorDrawable(i));
        }
        k = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        if (k > 0)
        {
            bundle = (TextView)findViewById(k);
            if (bundle != null)
            {
                bundle.setTextColor(j);
            }
        }
        mScrollBar = (ViewPagerScrollBar)findViewById(0x7f0a011c);
        mScrollBar.setLineColor(i);
        mScrollBar.setRange(2);
        mScrollBar.setVisibility(0);
        mViewPager = (ViewPager)findViewById(0x7f0a00da);
        mViewPager.setPageMargin(getResources().getDimensionPixelSize(0x7f0b0054));
        mViewPager.setPageMarginDrawable(0x7f09000e);
        mViewPager.setOffscreenPageLimit(1);
        bundle = mTabHost;
        mTabsAdapter = new TabsAdapter(this, bundle, mViewPager, mScrollBar);
        mTabsAdapter.setSetActionBarColorOnPageSelectedEnabled(false);
        obj = LayoutInflater.from(this);
        bundle.setOnTabChangedListener(this);
        bundle.setOnTabClickedListener(this);
        obj2 = ExploreChannelsFragment.prepareArguments(((Intent) (obj1)), true, s, "popular", "popular", i);
        ((Bundle) (obj2)).putInt("empty_desc", 0x7f0e00da);
        mTabsAdapter.addTab(bundle.newTabSpec("popular").setIndicator(TabIndicator.newTextIndicator(((LayoutInflater) (obj)), 0x7f03003a, bundle, 0x7f0e023b, true)), co/vine/android/ExploreChannelsFragment, ((Bundle) (obj2)));
        if (flag)
        {
            obj1 = ExploreChannelsFragment.prepareArguments(((Intent) (obj1)), true, s, "recent", "recent", i);
            ((Bundle) (obj1)).putInt("empty_desc", 0x7f0e00da);
            mTabsAdapter.addTab(bundle.newTabSpec("recent").setIndicator(TabIndicator.newTextIndicator(((LayoutInflater) (obj)), 0x7f03003a, bundle, 0x7f0e023d, true)), co/vine/android/ExploreChannelsFragment, ((Bundle) (obj1)));
        } else
        {
            mTabHost.getTabWidget().setVisibility(8);
            mScrollBar.setVisibility(8);
        }
        mChannelId = s;
        setIconImage(s1);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100005, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onCurrentTabClicked()
    {
        scrollTop();
    }

    protected void onResume()
    {
        super.onResume();
        mTabsAdapter.previousTab = mTabHost.getCurrentTab();
    }

    public void onScroll(int i)
    {
        if (hasTabs())
        {
            ScrollAwayTabWidget scrollawaytabwidget = (ScrollAwayTabWidget)mTabHost.getTabWidget();
            scrollawaytabwidget.onScroll(i);
            Fragment fragment = mTabsAdapter.getCurrentFragment();
            if (fragment instanceof BaseArrayListFragment)
            {
                i = scrollawaytabwidget.getNavBottom();
                ((BaseArrayListFragment)fragment).setNavBottom(i);
                mScrollBar.setNavOffset(i);
            }
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

    public void resetNav()
    {
        if (mTabHost != null)
        {
            ScrollAwayTabWidget scrollawaytabwidget = (ScrollAwayTabWidget)mTabHost.getTabWidget();
            if (scrollawaytabwidget != null)
            {
                scrollawaytabwidget.resetScroll();
                scrollawaytabwidget.invalidate();
                int i = scrollawaytabwidget.getNavBottom();
                if (mTabsAdapter != null)
                {
                    Fragment fragment = mTabsAdapter.getCurrentFragment();
                    if (fragment != null)
                    {
                        ((BaseArrayListFragment)fragment).setNavBottom(i);
                        mScrollBar.setNavOffset(i);
                    }
                }
            }
        }
    }

    public void scrollTop()
    {
        Fragment fragment;
        fragment = mTabsAdapter.getCurrentFragment();
        break MISSING_BLOCK_LABEL_8;
        if ((fragment instanceof BaseArrayListFragment) && fragment != null)
        {
            Object obj = fragment.getView();
            if (obj != null)
            {
                obj = (TopScrollable)((View) (obj)).findViewById(0x102000a);
                if (obj != null && !((TopScrollable) (obj)).scrollTop())
                {
                    ((BaseArrayListFragment)fragment).invokeScrollFirstItem();
                    return;
                }
            }
        }
        return;
    }




}
