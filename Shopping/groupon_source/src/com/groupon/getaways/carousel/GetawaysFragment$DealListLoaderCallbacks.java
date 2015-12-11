// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.content.Loader;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSummary;
import com.groupon.fragment.DealCardListLoader;
import com.groupon.models.EndlessList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.getaways.carousel:
//            GetawaysFragment, DealsRecyclerViewAdapter, EndlessRecyclerViewAdapter

private class <init>
    implements android.app.stLoaderCallbacks
{

    final GetawaysFragment this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new DealCardListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), "GETAWAYS");
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        loader = (EndlessList)list;
        GetawaysFragment getawaysfragment = GetawaysFragment.this;
        boolean flag;
        if (loader.getCurrentOffset() >= 0 && loader.getTotalSize() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        GetawaysFragment.access$1502(getawaysfragment, flag);
        GetawaysFragment.access$2100(GetawaysFragment.this).setDeals(list, false);
        GetawaysFragment.access$1600(GetawaysFragment.this).set(false);
        GetawaysFragment.access$1700(GetawaysFragment.this).setProgressViewVisible(false);
        if (!GetawaysFragment.access$1800(GetawaysFragment.this).get())
        {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public void onLoaderReset(Loader loader)
    {
        GetawaysFragment.access$1502(GetawaysFragment.this, true);
        GetawaysFragment.access$2100(GetawaysFragment.this).setDeals(Collections.emptyList(), false);
    }

    private ()
    {
        this$0 = GetawaysFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
