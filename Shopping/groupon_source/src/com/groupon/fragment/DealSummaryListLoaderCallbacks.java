// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.models.EndlessList;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import commonlib.loader.ListLoaderCallbacks;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealCardListLoader, DealCardListFragment, DealCardEndlessAdapter

public class DealSummaryListLoaderCallbacks extends ListLoaderCallbacks
{

    private DealCardListFragment dealCardListFragment;

    public DealSummaryListLoaderCallbacks(JavaListAdapter javalistadapter, DealCardListFragment dealcardlistfragment)
    {
        super(javalistadapter);
        dealCardListFragment = dealcardlistfragment;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        bundle = new DealCardListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, dealCardListFragment.getActivity(), dealCardListFragment.pagerChannelAndSubchannel);
        bundle.setForceDownload(dealCardListFragment.isForceDownload);
        return bundle;
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (list != null)
        {
            loader = (EndlessList)list;
            dealCardListFragment.dealCardEndlessAdapter.setTotalSize(loader.getTotalSize());
            listAdapter.setList(list);
            dealCardListFragment.lastDealSubsetAttrs = (DealSubsetAttribute)loader.getAttr();
            loader = listAdapter.getListCopy();
            dealCardListFragment.populateHeaderView(loader.size());
            dealCardListFragment.afterOnLoadFinished(loader);
        }
    }

    public void onLoaderReset(Loader loader)
    {
        dealCardListFragment.dealCardEndlessAdapter.enableAppending(true);
        dealCardListFragment.dealCardEndlessAdapter.setTotalSize(0);
        super.onLoaderReset(loader);
        dealCardListFragment.populateHeaderView(0);
    }
}
