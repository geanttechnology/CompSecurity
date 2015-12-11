// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.retailsearch.android.api.log.CategoryBrowseLogger;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            BaseAbstractDCMLogger, RetailSearchLoggingConfig, SourceName, MetricName

public class CategoryBrowseDCMLogger extends BaseAbstractDCMLogger
    implements CategoryBrowseLogger
{

    private static final String TAG = com/amazon/retailsearch/metrics/CategoryBrowseDCMLogger.getSimpleName();
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/metrics/CategoryBrowseDCMLogger);
    private MetricEvent currentCategoryBrowseMetricEvent;

    public CategoryBrowseDCMLogger(Context context, RetailSearchLoggingConfig retailsearchloggingconfig)
    {
        super(context, retailsearchloggingconfig);
        currentCategoryBrowseMetricEvent = null;
    }

    private MetricEvent getBrowseConcurrentMetricEvent(SourceName sourcename)
    {
        return getConcurrentMetricEvent(config.getBrowseProgramName(), sourcename);
    }

    private MetricEvent getBrowseMetricEvent(SourceName sourcename)
    {
        return getMetricEvent(config.getBrowseProgramName(), sourcename);
    }

    public void recordDeparmentMenuClickInNav()
    {
        recordCounter(getBrowseMetricEvent(SourceName.Engagement), MetricName.NavActivityRefinementMenuClicked.name(), 1);
    }

    public void recordDepartmentMenuClickInBrowse()
    {
        recordCounter(getBrowseMetricEvent(SourceName.Engagement), MetricName.BrowseActivityRefinementMenuClicked.name(), 1);
    }

    public void recordPageLoaded()
    {
        recordCounter(getBrowseMetricEvent(SourceName.Engagement), MetricName.BrowsePageLoaded.name(), 1);
    }

}
