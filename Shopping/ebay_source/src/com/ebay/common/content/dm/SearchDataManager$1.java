// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.net.api.search.SearchResult;
import com.ebay.common.net.api.search.SearchResultState;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

class val.maxItems
    implements erver
{

    final SearchDataManager this$0;
    final int val$maxItems;
    final SearchResultState val$resultState;

    public void onAdsContextReady(List list, equestType equesttype)
    {
    }

    public void onAdsReady(RtmHelper rtmhelper, equestType equesttype)
    {
        if (SearchDataManager.access$000(SearchDataManager.this) == val$resultState)
        {
            val$resultState.setFetchingAds(false);
            if (rtmhelper == null)
            {
                val$resultState.setSearchAds(null);
            } else
            {
                rtmhelper = rtmhelper.getAds();
                rtmhelper = rtmhelper.subList(0, Math.min(val$maxItems, rtmhelper.size()));
                val$resultState.setSearchAds(rtmhelper);
            }
            if (!val$resultState.getResult().resultStatus.hasError())
            {
                ((server)SearchDataManager.access$100(SearchDataManager.this)).onAdsLoaded(val$resultState);
                return;
            }
        }
    }

    e()
    {
        this$0 = final_searchdatamanager;
        val$resultState = searchresultstate;
        val$maxItems = I.this;
        super();
    }
}
