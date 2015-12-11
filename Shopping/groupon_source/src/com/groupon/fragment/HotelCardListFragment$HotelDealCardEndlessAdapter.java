// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

// Referenced classes of package com.groupon.fragment:
//            DealCardEndlessAdapter, HotelCardListFragment

public class ManagerProvider extends DealCardEndlessAdapter
{

    final HotelCardListFragment this$0;

    public View createPendingView(ViewGroup viewgroup)
    {
        viewgroup = super.createPendingView(viewgroup);
        if (isHotelsMap1503USCA)
        {
            viewgroup.setBackgroundColor(getResources().getColor(0x7f0e00e2));
        }
        return viewgroup;
    }

    public ManagerProvider(ManagerProvider managerprovider, commonlib.manager.yncManagerProvider yncmanagerprovider, BaseAdapter baseadapter)
    {
        this$0 = HotelCardListFragment.this;
        super(managerprovider, yncmanagerprovider, baseadapter);
    }
}
