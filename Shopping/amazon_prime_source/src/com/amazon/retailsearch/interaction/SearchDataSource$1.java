// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.metrics.IssLogger;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchDataSource

class ner extends com.amazon.retailsearch.data.skListener
{

    final SearchDataSource this$0;
    final Map val$issEngagementData;

    public void trackingInfo(TrackingInfo trackinginfo)
    {
        super.trackingInfo(trackinginfo);
        IssLogger isslogger = new IssLogger(val$issEngagementData);
        isslogger.setRequestId(trackinginfo.getRid());
        isslogger.submitLog();
    }

    ner()
    {
        this$0 = final_searchdatasource;
        val$issEngagementData = Map.this;
        super();
    }
}
