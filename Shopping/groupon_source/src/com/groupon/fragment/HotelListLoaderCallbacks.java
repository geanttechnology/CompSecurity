// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.MarketRateResult;
import com.groupon.models.EndlessList;
import commonlib.adapter.JavaAdapter;
import commonlib.loader.ListLoaderCallbacks;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListLoader, HotelCardListFragment, DealCardEndlessAdapter

public class HotelListLoaderCallbacks extends ListLoaderCallbacks
{

    private HotelCardListFragment hotelCardListFragment;

    public HotelListLoaderCallbacks(JavaAdapter javaadapter, HotelCardListFragment hotelcardlistfragment)
    {
        super(javaadapter);
        hotelCardListFragment = hotelcardlistfragment;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new HotelCardListLoader(com/groupon/db/models/MarketRateResult, com/groupon/db/events/ChannelUpdateEvent, hotelCardListFragment.getActivity(), hotelCardListFragment.getOriginatingChannel());
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        loader = (EndlessList)list;
        hotelCardListFragment.dealCardEndlessAdapter.setTotalSize(loader.getTotalSize());
        listAdapter.setList(list);
        loader = listAdapter.getListCopy();
        hotelCardListFragment.populateHeaderView(loader.size());
        if (list.size() > 0)
        {
            hotelCardListFragment.showLoadingView(false);
        }
    }

    public void onLoaderReset(Loader loader)
    {
        hotelCardListFragment.dealCardEndlessAdapter.enableAppending(true);
        hotelCardListFragment.dealCardEndlessAdapter.setTotalSize(0);
        super.onLoaderReset(loader);
        hotelCardListFragment.populateHeaderView(0);
        hotelCardListFragment.showLoadingView(true);
    }
}
