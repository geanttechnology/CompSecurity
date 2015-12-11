// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSummary;
import commonlib.adapter.JavaListAdapter;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealSummaryListLoaderCallbacks, DealSubsetFragment

public class this._cls0 extends DealSummaryListLoaderCallbacks
{

    final DealSubsetFragment this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new this._cls0(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), pagerChannelAndSubchannel);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (DealSubsetFragment.access$000(DealSubsetFragment.this) == DealSubsetFragment.access$100() && list.size() == 0)
        {
            DealSubsetFragment.access$002(DealSubsetFragment.this, DealSubsetFragment.access$200());
            reload();
        } else
        {
            DealSubsetFragment.access$002(DealSubsetFragment.this, DealSubsetFragment.access$300());
        }
        super.onLoadFinished(loader, list);
    }

    public (JavaListAdapter javalistadapter)
    {
        this$0 = DealSubsetFragment.this;
        super(javalistadapter, DealSubsetFragment.this);
    }
}
