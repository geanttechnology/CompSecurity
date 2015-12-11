// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.BaseAdapter;
import com.groupon.util.MultiColumnListAdapter;

// Referenced classes of package com.groupon.fragment:
//            DealsAndMyGrouponsBaseEndlessAdapter

public class DealCardEndlessAdapter extends DealsAndMyGrouponsBaseEndlessAdapter
{

    public DealCardEndlessAdapter(DealsAndMyGrouponsBaseEndlessAdapter.PaginatedSyncManagerProvider paginatedsyncmanagerprovider, commonlib.manager.SyncManager.SyncUiCallbacks syncuicallbacks, BaseAdapter baseadapter)
    {
        super(paginatedsyncmanagerprovider, syncuicallbacks, baseadapter);
    }

    public int getTotalSize()
    {
        int i = ((MultiColumnListAdapter)getWrappedAdapter()).getNumColumns();
        return ((totalSize + i) - 1) / i;
    }
}
