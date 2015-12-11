// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.groupon.mapview.DealsMapView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment, AbstractDealsAndWidgetsBaseFragment

public class ewBinder extends ewBinder
{

    public volatile void bind(butterknife.ewBinder ewbinder, AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment, Object obj)
    {
        bind(ewbinder, (GlobalSearchResultFragment)abstractdealsandwidgetsbasefragment, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, GlobalSearchResultFragment globalsearchresultfragment, Object obj)
    {
        super.bind(ewbinder, globalsearchresultfragment, obj);
        globalsearchresultfragment.searchListSection = (View)ewbinder.rchListSection(obj, 0x7f100322, "field 'searchListSection'");
        globalsearchresultfragment.searchMapSection = (View)ewbinder.rchMapSection(obj, 0x7f10031f, "field 'searchMapSection'");
        globalsearchresultfragment.searchMapView = (DealsMapView)ewbinder.rchMapView((View)ewbinder.rchMapView(obj, 0x7f100320, "field 'searchMapView'"), 0x7f100320, "field 'searchMapView'");
        globalsearchresultfragment.globalSearchMapRefreshButton = (SpinnerButton)ewbinder.balSearchMapRefreshButton((View)ewbinder.balSearchMapRefreshButton(obj, 0x7f100321, "field 'globalSearchMapRefreshButton'"), 0x7f100321, "field 'globalSearchMapRefreshButton'");
        globalsearchresultfragment.NO_DEALS_TEXT = ewbinder.DEALS_TEXT(obj).getResources().getString(0x7f0801fe);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GlobalSearchResultFragment)obj, obj1);
    }

    public volatile void unbind(AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment)
    {
        unbind((GlobalSearchResultFragment)abstractdealsandwidgetsbasefragment);
    }

    public void unbind(GlobalSearchResultFragment globalsearchresultfragment)
    {
        super.unbind(globalsearchresultfragment);
        globalsearchresultfragment.searchListSection = null;
        globalsearchresultfragment.searchMapSection = null;
        globalsearchresultfragment.searchMapView = null;
        globalsearchresultfragment.globalSearchMapRefreshButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GlobalSearchResultFragment)obj);
    }

    public ewBinder()
    {
    }
}
