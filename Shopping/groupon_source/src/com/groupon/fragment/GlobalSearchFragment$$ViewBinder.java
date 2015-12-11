// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.groupon.view.ClearableEditText;
import org.apmem.tools.layouts.FlowLayout;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, GlobalSearchFragment globalsearchfragment, Object obj)
    {
        globalsearchfragment.autocompleteListView = (ListView)ewbinder.ocompleteListView((View)ewbinder.ew(obj, 0x7f10019d, "field 'autocompleteListView'"), 0x7f10019d, "field 'autocompleteListView'");
        globalsearchfragment.searchLocationContainer = (View)ewbinder.ew(obj, 0x7f100309, "field 'searchLocationContainer'");
        globalsearchfragment.recentBox = (LinearLayout)ewbinder.entBox((View)ewbinder.ew(obj, 0x7f100310, "field 'recentBox'"), 0x7f100310, "field 'recentBox'");
        globalsearchfragment.recentList = (FlowLayout)ewbinder.entList((View)ewbinder.ew(obj, 0x7f100312, "field 'recentList'"), 0x7f100312, "field 'recentList'");
        globalsearchfragment.popularBox = (LinearLayout)ewbinder.ularBox((View)ewbinder.ew(obj, 0x7f100313, "field 'popularBox'"), 0x7f100313, "field 'popularBox'");
        globalsearchfragment.popularList = (FlowLayout)ewbinder.ularList((View)ewbinder.ew(obj, 0x7f100315, "field 'popularList'"), 0x7f100315, "field 'popularList'");
        globalsearchfragment.tagsSection = (ScrollView)ewbinder.sSection((View)ewbinder.ew(obj, 0x7f10030f, "field 'tagsSection'"), 0x7f10030f, "field 'tagsSection'");
        globalsearchfragment.categoriesSection = (ListView)ewbinder.egoriesSection((View)ewbinder.ew(obj, 0x7f10030d, "field 'categoriesSection'"), 0x7f10030d, "field 'categoriesSection'");
        globalsearchfragment.categoriesProgress = (ProgressBar)ewbinder.egoriesProgress((View)ewbinder.ew(obj, 0x7f10030e, "field 'categoriesProgress'"), 0x7f10030e, "field 'categoriesProgress'");
        globalsearchfragment.popularSearchLabel = (TextView)ewbinder.ularSearchLabel((View)ewbinder.ew(obj, 0x7f100314, "field 'popularSearchLabel'"), 0x7f100314, "field 'popularSearchLabel'");
        globalsearchfragment.spinner = (ProgressBar)ewbinder.nner((View)ewbinder.ew(obj, 0x7f10010b, "field 'spinner'"), 0x7f10010b, "field 'spinner'");
        globalsearchfragment.locationSearchView = (ClearableEditText)ewbinder.ationSearchView((View)ewbinder.ew(obj, 0x7f10030a, "field 'locationSearchView'"), 0x7f10030a, "field 'locationSearchView'");
        globalsearchfragment.globalSearch = (LinearLayout)ewbinder.balSearch((View)ewbinder.ew(obj, 0x7f1002fe, "field 'globalSearch'"), 0x7f1002fe, "field 'globalSearch'");
        globalsearchfragment.CURRENT_LOCATION = ewbinder.RENT_LOCATION(obj).getResources().getString(0x7f0801fa);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (GlobalSearchFragment)obj, obj1);
    }

    public void unbind(GlobalSearchFragment globalsearchfragment)
    {
        globalsearchfragment.autocompleteListView = null;
        globalsearchfragment.searchLocationContainer = null;
        globalsearchfragment.recentBox = null;
        globalsearchfragment.recentList = null;
        globalsearchfragment.popularBox = null;
        globalsearchfragment.popularList = null;
        globalsearchfragment.tagsSection = null;
        globalsearchfragment.categoriesSection = null;
        globalsearchfragment.categoriesProgress = null;
        globalsearchfragment.popularSearchLabel = null;
        globalsearchfragment.spinner = null;
        globalsearchfragment.locationSearchView = null;
        globalsearchfragment.globalSearch = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GlobalSearchFragment)obj);
    }

    public ()
    {
    }
}
