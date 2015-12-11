// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            IncentiveTickets, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (IncentiveTickets)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, IncentiveTickets incentivetickets, Object obj)
    {
        super.ind(ewbinder, incentivetickets, obj);
        incentivetickets.incentiveTicketsListView = (ListView)ewbinder.entiveTicketsListView((View)ewbinder.edView(obj, 0x7f1003cf, "field 'incentiveTicketsListView'"), 0x7f1003cf, "field 'incentiveTicketsListView'");
        incentivetickets.loadingView = (ProgressBar)ewbinder.dingView((View)ewbinder.edView(obj, 0x7f1000df, "field 'loadingView'"), 0x7f1000df, "field 'loadingView'");
        incentivetickets.emptyView = (TextView)ewbinder.tyView((View)ewbinder.edView(obj, 0x7f10019f, "field 'emptyView'"), 0x7f10019f, "field 'emptyView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (IncentiveTickets)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((IncentiveTickets)grouponactivity);
    }

    public void unbind(IncentiveTickets incentivetickets)
    {
        super.nbind(incentivetickets);
        incentivetickets.incentiveTicketsListView = null;
        incentivetickets.loadingView = null;
        incentivetickets.emptyView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((IncentiveTickets)obj);
    }

    public ()
    {
    }
}
