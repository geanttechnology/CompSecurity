// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import org.apmem.tools.layouts.FlowLayout;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchFragment

public class 
    implements butterknife.ent..ViewBinder
{

    public void bind(butterknife.ent..ViewBinder viewbinder, GetawaysSearchFragment getawayssearchfragment, Object obj)
    {
        getawayssearchfragment.datesSelector = (View)viewbinder.(obj, 0x7f1002a7, "field 'datesSelector'");
        getawayssearchfragment.datesSelectorTextView = (TextView)viewbinder.datesSelectorTextView((View)viewbinder.(obj, 0x7f1003bb, "field 'datesSelectorTextView'"), 0x7f1003bb, "field 'datesSelectorTextView'");
        getawayssearchfragment.autocompleteListView = (ListView)viewbinder.autocompleteListView((View)viewbinder.(obj, 0x7f10019d, "field 'autocompleteListView'"), 0x7f10019d, "field 'autocompleteListView'");
        getawayssearchfragment.recentSearchesScrollView = (ScrollView)viewbinder.recentSearchesScrollView((View)viewbinder.(obj, 0x7f1002a8, "field 'recentSearchesScrollView'"), 0x7f1002a8, "field 'recentSearchesScrollView'");
        getawayssearchfragment.recentSearchesContainer = (View)viewbinder.(obj, 0x7f1002a9, "field 'recentSearchesContainer'");
        getawayssearchfragment.recentSearchesView = (FlowLayout)viewbinder.recentSearchesView((View)viewbinder.(obj, 0x7f1002ab, "field 'recentSearchesView'"), 0x7f1002ab, "field 'recentSearchesView'");
        getawayssearchfragment.oldRecentSearchesContainer = (View)viewbinder.(obj, 0x7f1002ac, "field 'oldRecentSearchesContainer'");
        getawayssearchfragment.oldRecentSearchesView = (LinearLayout)viewbinder.oldRecentSearchesView((View)viewbinder.(obj, 0x7f1004aa, "field 'oldRecentSearchesView'"), 0x7f1004aa, "field 'oldRecentSearchesView'");
        viewbinder = viewbinder.(obj).getResources();
        getawayssearchfragment.selectDates = viewbinder.getString(0x7f080359);
        getawayssearchfragment.optional = viewbinder.getString(0x7f0802cb);
    }

    public volatile void bind(butterknife.ent..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (GetawaysSearchFragment)obj, obj1);
    }

    public void unbind(GetawaysSearchFragment getawayssearchfragment)
    {
        getawayssearchfragment.datesSelector = null;
        getawayssearchfragment.datesSelectorTextView = null;
        getawayssearchfragment.autocompleteListView = null;
        getawayssearchfragment.recentSearchesScrollView = null;
        getawayssearchfragment.recentSearchesContainer = null;
        getawayssearchfragment.recentSearchesView = null;
        getawayssearchfragment.oldRecentSearchesContainer = null;
        getawayssearchfragment.oldRecentSearchesView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GetawaysSearchFragment)obj);
    }

    public ()
    {
    }
}
