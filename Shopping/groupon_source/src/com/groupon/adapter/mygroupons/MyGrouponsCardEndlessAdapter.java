// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter.mygroupons;

import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.groupon.fragment.DealsAndMyGrouponsBaseEndlessAdapter;

public class MyGrouponsCardEndlessAdapter extends DealsAndMyGrouponsBaseEndlessAdapter
{

    public MyGrouponsCardEndlessAdapter(com.groupon.fragment.DealsAndMyGrouponsBaseEndlessAdapter.PaginatedSyncManagerProvider paginatedsyncmanagerprovider, commonlib.manager.SyncManager.SyncUiCallbacks syncuicallbacks, BaseAdapter baseadapter)
    {
        super(paginatedsyncmanagerprovider, syncuicallbacks, baseadapter);
    }

    public boolean isEnabled(int i)
    {
        return i < getWrappedAdapter().getCount() && getWrappedAdapter().isEnabled(i);
    }
}
