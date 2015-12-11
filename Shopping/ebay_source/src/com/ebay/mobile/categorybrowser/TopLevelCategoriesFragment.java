// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.shared.ui.TaggedFragmentPagerAdapter;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesTileFragment, BrowseCategoriesFragment

public class TopLevelCategoriesFragment extends BaseFragment
    implements android.app.FragmentManager.OnBackStackChangedListener, ChannelFragment
{

    public static final String EXTRA_HEADER_BACKGROUND_URL = "backgroundUrl";
    public static final String EXTRA_HEADER_TITLE = "title";
    public static final String ROOT_FRAGMENT_TAG = "Level0";
    private String backgroundUrl;
    protected SourceIdentification requestedCategorySid;
    private String title;

    public TopLevelCategoriesFragment()
    {
    }

    public static TopLevelCategoriesFragment create(String s, String s1)
    {
        TopLevelCategoriesFragment toplevelcategoriesfragment = new TopLevelCategoriesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("backgroundUrl", s);
        bundle.putString("title", s1);
        toplevelcategoriesfragment.setArguments(bundle);
        return toplevelcategoriesfragment;
    }

    public void clearSelectedCategory()
    {
        Fragment fragment = getChildFragmentManager().findFragmentByTag("Level0");
        if (fragment instanceof BrowseCategoriesTileFragment)
        {
            ((BrowseCategoriesTileFragment)fragment).clearSelectedCategory();
        }
    }

    public String getDepartmentId()
    {
        return "ALLCATEGORIES";
    }

    public int getPositionInParent()
    {
        Object obj;
        if (getView() == null)
        {
            obj = null;
        } else
        {
            obj = getView().getParent();
        }
        if (obj instanceof ViewPager)
        {
            obj = ((ViewPager)obj).getAdapter();
            if (obj instanceof TaggedFragmentPagerAdapter)
            {
                return ((TaggedFragmentPagerAdapter)obj).getPosition(this);
            }
        }
        return -2;
    }

    public boolean hasCarousel()
    {
        return true;
    }

    public boolean hasScrollOffset()
    {
        Fragment fragment = getChildFragmentManager().findFragmentByTag("Level0");
        if (fragment instanceof BrowseCategoriesTileFragment)
        {
            return ((BrowseCategoriesTileFragment)fragment).hasScrollOffset();
        } else
        {
            return false;
        }
    }

    public boolean hasSubChannels()
    {
        return false;
    }

    public void navigateTo(long l, SourceIdentification sourceidentification)
    {
        Fragment fragment = getChildFragmentManager().findFragmentByTag("Level0");
        if (fragment instanceof BrowseCategoriesTileFragment)
        {
            ((BrowseCategoriesTileFragment)fragment).navigateTo(l);
            requestedCategorySid = sourceidentification;
        }
    }

    public void onBackStackChanged()
    {
        Object obj = getChildFragmentManager();
        if (obj != null)
        {
            int i = ((FragmentManager) (obj)).getBackStackEntryCount();
            if (i > 0)
            {
                android.app.FragmentManager.BackStackEntry backstackentry = ((FragmentManager) (obj)).getBackStackEntryAt(i - 1);
                if (backstackentry != null && !TextUtils.isEmpty(backstackentry.getName()))
                {
                    obj = ((FragmentManager) (obj)).findFragmentByTag(backstackentry.getName());
                    if (obj instanceof BrowseCategoriesFragment)
                    {
                        TrackingData trackingdata1 = new TrackingData("Browse", TrackingType.PAGE_IMPRESSION);
                        trackingdata1.addSourceIdentification(requestedCategorySid);
                        trackingdata1.addKeyValuePair("catlbl", ((BrowseCategoriesFragment)obj).getCategoryLabel());
                        trackingdata1.send(getActivity());
                        requestedCategorySid = null;
                        return;
                    }
                }
            } else
            {
                TrackingData trackingdata = new TrackingData("Browse", TrackingType.PAGE_IMPRESSION);
                trackingdata.addKeyValuePair("catlbl", title);
                trackingdata.send(getActivity());
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            backgroundUrl = bundle.getString("backgroundUrl");
            title = bundle.getString("title");
            return;
        }
        if (getArguments() != null)
        {
            bundle = getArguments();
            backgroundUrl = bundle.getString("backgroundUrl");
            title = bundle.getString("title");
            return;
        } else
        {
            title = getString(0x7f07053e);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300b2, viewgroup, false);
    }

    public void onDestroyView()
    {
        FragmentManager fragmentmanager = getFragmentManager();
        if (fragmentmanager != null)
        {
            fragmentmanager.removeOnBackStackChangedListener(this);
        }
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("backgroundUrl", backgroundUrl);
        bundle.putString("title", title);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = getChildFragmentManager();
        if (view.getBackStackEntryCount() == 0)
        {
            bundle = new Bundle();
            bundle.putString("backgroundUrl", backgroundUrl);
            bundle.putString("title", title);
            bundle = Fragment.instantiate(getActivity(), com/ebay/mobile/categorybrowser/BrowseCategoriesTileFragment.getName(), bundle);
            view.beginTransaction().replace(0x7f1001c9, bundle, "Level0").commit();
        }
        view.addOnBackStackChangedListener(this);
    }

    public void setTitleVisibility(boolean flag)
    {
        Fragment fragment = getChildFragmentManager().findFragmentByTag("Level0");
        if (fragment instanceof BrowseCategoriesTileFragment)
        {
            ((BrowseCategoriesTileFragment)fragment).setTitleVisibility(flag);
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        Object obj = getActivity();
        if (obj != null && !((Activity) (obj)).isFinishing() && !((Activity) (obj)).isDestroyed())
        {
            if ((obj = getChildFragmentManager().findFragmentByTag("Level0")) != null)
            {
                ((Fragment) (obj)).setUserVisibleHint(flag);
                return;
            }
        }
    }
}
