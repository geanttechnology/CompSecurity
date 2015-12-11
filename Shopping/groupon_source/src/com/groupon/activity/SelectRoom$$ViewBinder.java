// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.groupon.activity:
//            SelectRoom, GrouponActivity

public class nder extends nder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (SelectRoom)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, SelectRoom selectroom, Object obj)
    {
        super.bind(ewbinder, selectroom, obj);
        selectroom.roomsListView = (ListView)ewbinder.View((View)ewbinder.RequiredView(obj, 0x7f100510, "field 'roomsListView'"), 0x7f100510, "field 'roomsListView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (SelectRoom)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((SelectRoom)grouponactivity);
    }

    public void unbind(SelectRoom selectroom)
    {
        super.unbind(selectroom);
        selectroom.roomsListView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((SelectRoom)obj);
    }

    public nder()
    {
    }
}
