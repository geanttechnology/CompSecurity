// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

// Referenced classes of package com.groupon.activity:
//            Cities, GrouponActivity

public class yListHeadersListView extends ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, Cities cities, Object obj)
    {
        super.bind(ewbinder, cities, obj);
        cities.progress = (ProgressBar)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f1001a0, "field 'progress'"), 0x7f1001a0, "field 'progress'");
        cities.listView = (StickyListHeadersListView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f10019e, "field 'listView'"), 0x7f10019e, "field 'listView'");
        cities.content = (LinearLayout)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f100132, "field 'content'"), 0x7f100132, "field 'content'");
        cities.emptyView = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f10019f, "field 'emptyView'"), 0x7f10019f, "field 'emptyView'");
        cities.countryButton = (TextView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f10019b, "field 'countryButton'"), 0x7f10019b, "field 'countryButton'");
        cities.autocompleteListView = (ListView)ewbinder.castView((View)ewbinder.findRequiredView(obj, 0x7f10019d, "field 'autocompleteListView'"), 0x7f10019d, "field 'autocompleteListView'");
        cities.autocompleteContainer = (View)ewbinder.findRequiredView(obj, 0x7f10019c, "field 'autocompleteContainer'");
        cities.CURRENT_LOCATION = ewbinder.getContext(obj).getResources().getString(0x7f0801fa);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (Cities)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Cities)obj, obj1);
    }

    public void unbind(Cities cities)
    {
        super.unbind(cities);
        cities.progress = null;
        cities.listView = null;
        cities.content = null;
        cities.emptyView = null;
        cities.countryButton = null;
        cities.autocompleteListView = null;
        cities.autocompleteContainer = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((Cities)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((Cities)obj);
    }

    public yListHeadersListView()
    {
    }
}
