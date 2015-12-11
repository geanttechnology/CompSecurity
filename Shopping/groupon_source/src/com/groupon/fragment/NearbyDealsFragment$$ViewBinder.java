// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.view.BrowseByCategoryBar;
import com.groupon.view.FilterBar;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment, AbstractDealsAndWidgetsBaseFragment

public class ent extends ent..ViewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment, Object obj)
    {
        bind(ewbinder, (NearbyDealsFragment)abstractdealsandwidgetsbasefragment, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, NearbyDealsFragment nearbydealsfragment, Object obj)
    {
        super.bind(ewbinder, nearbydealsfragment, obj);
        nearbydealsfragment.filtersBar = (LinearLayout)ewbinder.tersBar((View)ewbinder.iew(obj, 0x7f100459, "field 'filtersBar'"), 0x7f100459, "field 'filtersBar'");
        nearbydealsfragment.dealMapSection = (FrameLayout)ewbinder.lMapSection((View)ewbinder.iew(obj, 0x7f100464, "field 'dealMapSection'"), 0x7f100464, "field 'dealMapSection'");
        nearbydealsfragment.noDealsMessageView = (View)ewbinder.iew(obj, 0x7f100466, "field 'noDealsMessageView'");
        nearbydealsfragment.swipeLayout = (SwipeRefreshLayout)ewbinder.((View)ewbinder.iew(obj, 0x7f1000db, "field 'swipeLayout'"), 0x7f1000db, "field 'swipeLayout'");
        nearbydealsfragment.dealListView = (ListView)ewbinder.lListView((View)ewbinder.iew(obj, 0x102000a, "field 'dealListView'"), 0x102000a, "field 'dealListView'");
        nearbydealsfragment.mapIcon = (RelativeLayout)ewbinder.Icon((View)ewbinder.iew(obj, 0x7f10045c, "field 'mapIcon'"), 0x7f10045c, "field 'mapIcon'");
        nearbydealsfragment.listIcon = (RelativeLayout)ewbinder.tIcon((View)ewbinder.iew(obj, 0x7f100460, "field 'listIcon'"), 0x7f100460, "field 'listIcon'");
        nearbydealsfragment.mapIconText = (TextView)ewbinder.IconText((View)ewbinder.iew(obj, 0x7f10045e, "field 'mapIconText'"), 0x7f10045e, "field 'mapIconText'");
        nearbydealsfragment.listIconText = (TextView)ewbinder.tIconText((View)ewbinder.iew(obj, 0x7f100462, "field 'listIconText'"), 0x7f100462, "field 'listIconText'");
        nearbydealsfragment.iconContainer = (FrameLayout)ewbinder.nContainer((View)ewbinder.iew(obj, 0x7f100374, "field 'iconContainer'"), 0x7f100374, "field 'iconContainer'");
        nearbydealsfragment.browseByCategoryBar = (BrowseByCategoryBar)ewbinder.wseByCategoryBar((View)ewbinder.iew(obj, 0x7f10032b, "field 'browseByCategoryBar'"), 0x7f10032b, "field 'browseByCategoryBar'");
        nearbydealsfragment.browseByCategoryBarFromMap = (BrowseByCategoryBar)ewbinder.wseByCategoryBarFromMap((View)ewbinder.iew(obj, 0x7f10045f, null), 0x7f10045f, "field 'browseByCategoryBarFromMap'");
        nearbydealsfragment.categoryFilter = (FilterBar)ewbinder.egoryFilter((View)ewbinder.iew(obj, 0x7f10045a, "field 'categoryFilter'"), 0x7f10045a, "field 'categoryFilter'");
        nearbydealsfragment.locationFilter = (FilterBar)ewbinder.ationFilter((View)ewbinder.iew(obj, 0x7f10045b, "field 'locationFilter'"), 0x7f10045b, "field 'locationFilter'");
        nearbydealsfragment.mapControls = (FrameLayout)ewbinder.Controls((View)ewbinder.iew(obj, 0x7f100467, "field 'mapControls'"), 0x7f100467, "field 'mapControls'");
        nearbydealsfragment.reloadButton = (SpinnerButton)ewbinder.oadButton((View)ewbinder.iew(obj, 0x7f100468, "field 'reloadButton'"), 0x7f100468, "field 'reloadButton'");
        nearbydealsfragment.nearbyMapRefreshButton = (SpinnerButton)ewbinder.rbyMapRefreshButton((View)ewbinder.iew(obj, 0x7f100465, "field 'nearbyMapRefreshButton'"), 0x7f100465, "field 'nearbyMapRefreshButton'");
        ewbinder = ewbinder.iew(obj).getResources();
        nearbydealsfragment.MAP_LOCATION = ewbinder.getString(0x7f080262);
        nearbydealsfragment.CURRENT_LOCATION = ewbinder.getString(0x7f080118);
        nearbydealsfragment.ALL_DEALS = ewbinder.getString(0x7f08005e);
        nearbydealsfragment.SELECT_CATEGORY = ewbinder.getString(0x7f080356);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (NearbyDealsFragment)obj, obj1);
    }

    public volatile void unbind(AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment)
    {
        unbind((NearbyDealsFragment)abstractdealsandwidgetsbasefragment);
    }

    public void unbind(NearbyDealsFragment nearbydealsfragment)
    {
        super.unbind(nearbydealsfragment);
        nearbydealsfragment.filtersBar = null;
        nearbydealsfragment.dealMapSection = null;
        nearbydealsfragment.noDealsMessageView = null;
        nearbydealsfragment.swipeLayout = null;
        nearbydealsfragment.dealListView = null;
        nearbydealsfragment.mapIcon = null;
        nearbydealsfragment.listIcon = null;
        nearbydealsfragment.mapIconText = null;
        nearbydealsfragment.listIconText = null;
        nearbydealsfragment.iconContainer = null;
        nearbydealsfragment.browseByCategoryBar = null;
        nearbydealsfragment.browseByCategoryBarFromMap = null;
        nearbydealsfragment.categoryFilter = null;
        nearbydealsfragment.locationFilter = null;
        nearbydealsfragment.mapControls = null;
        nearbydealsfragment.reloadButton = null;
        nearbydealsfragment.nearbyMapRefreshButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((NearbyDealsFragment)obj);
    }

    public ent()
    {
    }
}
