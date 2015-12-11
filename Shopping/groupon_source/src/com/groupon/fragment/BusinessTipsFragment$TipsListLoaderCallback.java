// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.BusinessTipsUpdateEvent;
import com.groupon.db.models.Tip;
import com.groupon.models.EndlessList;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import commonlib.loader.ListLoaderCallbacks;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            BusinessTipsFragment

private class paginationChannelId extends ListLoaderCallbacks
{

    private String paginationChannelId;
    final BusinessTipsFragment this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new paginationChannelId(com/groupon/db/models/Tip, com/groupon/db/events/BusinessTipsUpdateEvent, getActivity(), paginationChannelId);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (list.size() == 0)
        {
            return;
        } else
        {
            loader = (EndlessList)list;
            BusinessTipsFragment.access$100(BusinessTipsFragment.this).otalSize(loader.getTotalSize());
            listAdapter.setList(list);
            return;
        }
    }

    public void onLoaderReset(Loader loader)
    {
        BusinessTipsFragment.access$100(BusinessTipsFragment.this).leAppending(true);
        BusinessTipsFragment.access$100(BusinessTipsFragment.this).otalSize(0);
        super.onLoaderReset(loader);
    }

    public (JavaListAdapter javalistadapter, String s)
    {
        this$0 = BusinessTipsFragment.this;
        super(javalistadapter);
        paginationChannelId = s;
    }
}
