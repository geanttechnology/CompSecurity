// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.groupon.fragment:
//            HotelsSearchResult, AbstractDealsAndWidgetsBaseFragment, HotelCardListFragment

public class ment extends er
{

    public volatile void bind(butterknife.ewBinder ewbinder, AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment, Object obj)
    {
        bind(ewbinder, (HotelsSearchResult)abstractdealsandwidgetsbasefragment, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, HotelCardListFragment hotelcardlistfragment, Object obj)
    {
        bind(ewbinder, (HotelsSearchResult)hotelcardlistfragment, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, HotelsSearchResult hotelssearchresult, Object obj)
    {
        super.bind(ewbinder, hotelssearchresult, obj);
        hotelssearchresult.list = (ListView)ewbinder.t((View)ewbinder.View(obj, 0x102000a, "field 'list'"), 0x102000a, "field 'list'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (HotelsSearchResult)obj, obj1);
    }

    public volatile void unbind(AbstractDealsAndWidgetsBaseFragment abstractdealsandwidgetsbasefragment)
    {
        unbind((HotelsSearchResult)abstractdealsandwidgetsbasefragment);
    }

    public volatile void unbind(HotelCardListFragment hotelcardlistfragment)
    {
        unbind((HotelsSearchResult)hotelcardlistfragment);
    }

    public void unbind(HotelsSearchResult hotelssearchresult)
    {
        super.unbind(hotelssearchresult);
        hotelssearchresult.list = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((HotelsSearchResult)obj);
    }

    public ment()
    {
    }
}
