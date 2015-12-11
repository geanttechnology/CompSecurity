// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.data.search.SearchLoader;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchDataCache

class ener extends com.amazon.retailsearch.data.askListener
{

    final SearchDataCache this$0;
    final RetailSearchQuery val$query;

    public void trackingInfo(TrackingInfo trackinginfo)
    {
        super.trackingInfo(trackinginfo);
        if (!val$query.isPrefetchingAccepted())
        {
            val$query.setPrefetchingAccepted(true);
            val$query.setRrid(trackinginfo.getRid());
            (new SearchLoader(AndroidRetailSearchClient.getClient(), val$query.toSearchRequest(), null)).load();
        }
    }

    Query()
    {
        this$0 = final_searchdatacache;
        val$query = RetailSearchQuery.this;
        super();
    }
}
