// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

// Referenced classes of package com.groupon.activity:
//            FavoriteDealTypes, GrouponListActivity

public class r extends r
{

    public void bind(butterknife.ewBinder ewbinder, FavoriteDealTypes favoritedealtypes, Object obj)
    {
        super.bind(ewbinder, favoritedealtypes, obj);
        favoritedealtypes.listView = (ListView)ewbinder.tView((View)ewbinder.dView(obj, 0x102000a, "field 'listView'"), 0x102000a, "field 'listView'");
        favoritedealtypes.seePersonalizedDeals = (Button)ewbinder.PersonalizedDeals((View)ewbinder.dView(obj, 0x7f100288, "field 'seePersonalizedDeals'"), 0x7f100288, "field 'seePersonalizedDeals'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponListActivity grouponlistactivity, Object obj)
    {
        bind(ewbinder, (FavoriteDealTypes)grouponlistactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (FavoriteDealTypes)obj, obj1);
    }

    public void unbind(FavoriteDealTypes favoritedealtypes)
    {
        super.unbind(favoritedealtypes);
        favoritedealtypes.listView = null;
        favoritedealtypes.seePersonalizedDeals = null;
    }

    public volatile void unbind(GrouponListActivity grouponlistactivity)
    {
        unbind((FavoriteDealTypes)grouponlistactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((FavoriteDealTypes)obj);
    }

    public r()
    {
    }
}
