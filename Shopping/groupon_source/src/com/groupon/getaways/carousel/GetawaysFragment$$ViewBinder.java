// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment

public class 
    implements butterknife.gment..ViewBinder
{

    public void bind(butterknife.gment..ViewBinder viewbinder, GetawaysFragment getawaysfragment, Object obj)
    {
        getawaysfragment.swipeRefreshLayout = (SwipeRefreshLayout)viewbinder.out((View)viewbinder.edView(obj, 0x7f1000db, "field 'swipeRefreshLayout'"), 0x7f1000db, "field 'swipeRefreshLayout'");
        getawaysfragment.recyclerView = (RecyclerView)viewbinder.recyclerView((View)viewbinder.edView(obj, 0x7f1000dc, "field 'recyclerView'"), 0x7f1000dc, "field 'recyclerView'");
    }

    public volatile void bind(butterknife.gment..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (GetawaysFragment)obj, obj1);
    }

    public void unbind(GetawaysFragment getawaysfragment)
    {
        getawaysfragment.swipeRefreshLayout = null;
        getawaysfragment.recyclerView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GetawaysFragment)obj);
    }

    public ()
    {
    }
}
