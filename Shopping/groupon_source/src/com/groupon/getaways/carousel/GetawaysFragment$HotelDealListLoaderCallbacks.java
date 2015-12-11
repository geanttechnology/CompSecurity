// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.content.Loader;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.MarketRateResult;
import com.groupon.fragment.HotelCardListLoader;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment, GetawaysWidgetRecyclerViewAdapter

private class <init>
    implements android.app.stLoaderCallbacks
{

    final GetawaysFragment this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new HotelCardListLoader(com/groupon/db/models/MarketRateResult, com/groupon/db/events/ChannelUpdateEvent, getActivity(), "HOTELS");
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        GetawaysFragment.access$2000(GetawaysFragment.this).setDeals(list);
        GetawaysFragment.access$1800(GetawaysFragment.this).set(false);
        if (!GetawaysFragment.access$1600(GetawaysFragment.this).get())
        {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public void onLoaderReset(Loader loader)
    {
        GetawaysFragment.access$2000(GetawaysFragment.this).setDeals(Collections.emptyList());
    }

    private Q()
    {
        this$0 = GetawaysFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
