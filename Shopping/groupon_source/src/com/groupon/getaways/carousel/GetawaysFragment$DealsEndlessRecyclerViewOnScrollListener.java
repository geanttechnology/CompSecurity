// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import com.groupon.manager.GetawaysSyncManager;

// Referenced classes of package com.groupon.getaways.carousel:
//            EndlessRecyclerViewOnScrollListener, GetawaysFragment, EndlessRecyclerViewAdapter

private class setVisibleThreshold extends EndlessRecyclerViewOnScrollListener
{

    final GetawaysFragment this$0;

    public void onLoadMore()
    {
        if (GetawaysFragment.access$1500(GetawaysFragment.this))
        {
            GetawaysFragment.access$1700(GetawaysFragment.this).setProgressViewVisible(true);
            GetawaysFragment.access$1100(GetawaysFragment.this).requestSyncNextPage(GetawaysFragment.access$2900(GetawaysFragment.this), null);
        }
    }

    public (android.support.v7.widget.ner ner)
    {
        this$0 = GetawaysFragment.this;
        super(ner);
        setVisibleThreshold(3);
    }
}
