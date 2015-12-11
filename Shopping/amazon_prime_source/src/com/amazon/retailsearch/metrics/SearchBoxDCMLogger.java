// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.debug.RetailSearchDebug;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.PersonalizedSuggestionsServiceCall;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            BaseAbstractDCMLogger, RetailSearchLoggingConfig, SourceName, MetricName

public class SearchBoxDCMLogger extends BaseAbstractDCMLogger
    implements SearchBoxLogger
{

    private MetricEvent currentISSEvent;

    public SearchBoxDCMLogger(Context context, RetailSearchLoggingConfig retailsearchloggingconfig)
    {
        super(context, retailsearchloggingconfig);
        currentISSEvent = null;
    }

    private MetricEvent getIssConcurrentMetricEvent(SourceName sourcename)
    {
        return getConcurrentMetricEvent(config.getSearchProgramName(), sourcename);
    }

    private MetricEvent getIssMetricEvent(SourceName sourcename)
    {
        return getMetricEvent(config.getIssProgramName(), sourcename);
    }

    private MetricEvent getSearchConcurrentMetricEvent(SourceName sourcename)
    {
        return getConcurrentMetricEvent(config.getSearchProgramName(), sourcename);
    }

    private MetricEvent getSearchMetricEvent(SourceName sourcename)
    {
        return getMetricEvent(config.getSearchProgramName(), sourcename);
    }

    public void recordEntryVoiceInvoked()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.EntryVoiceInvoked.name(), 1);
    }

    public void recordFlowInvoked(boolean flag)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.Search);
        String s;
        if (flag)
        {
            s = MetricName.FlowInvokedT2.name();
        } else
        {
            s = MetricName.FlowInvokedT1.name();
        }
        recordCounter(metricevent, s, 1);
    }

    public void recordQueryBuilderUsage()
    {
        recordCounter(getIssMetricEvent(SourceName.Engagement), MetricName.QueryBuilder.name(), 1);
    }

    public void recordRecentSearchCleared()
    {
        recordCounter(getIssMetricEvent(SourceName.Engagement), MetricName.RecentSearchesClear.name(), 1);
    }

    public void recordScanItInvoked()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.BarcodeInvoked.name(), 1);
    }

    public void recordSnapItInvoked()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.ImageInvoked.name(), 1);
    }

    public void searchSRDSPersonalizedISSError(String s, Throwable throwable, PersonalizedSuggestionsServiceCall personalizedsuggestionsservicecall)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.PersonalizedISSSRDSRequest);
        addEventInfo(metricevent, s, throwable);
        if (personalizedsuggestionsservicecall != null)
        {
            addServiceCallInfo(metricevent, personalizedsuggestionsservicecall);
        }
        recordCounter(metricevent, getErrorMetric(throwable), 1);
    }

    public void searchSuggestionsEngagment(Map map)
    {
        if (map == null)
        {
            return;
        }
        MetricEvent metricevent = getIssConcurrentMetricEvent(SourceName.Engagement);
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            String s1 = (String)map.get(s);
            if (!TextUtils.isEmpty(s1))
            {
                metricevent.addString(s, s1);
            }
        } while (true);
        RetailSearchDebug.logMetricEvent(metricevent);
        metricsFactory.record(metricevent);
    }

    public void searchSuggestionsFirstEntryShowed()
    {
        if (currentISSEvent == null)
        {
            log.warn("An attempt was made to log ISS latency without a valid metric event");
            return;
        } else
        {
            currentISSEvent.stopTimer(MetricName.TimeToFirstSuggestion.name());
            RetailSearchDebug.logMetricEvent(currentISSEvent);
            metricsFactory.record(currentISSEvent);
            currentISSEvent = null;
            return;
        }
    }

    public void searchSuggestionsFirstKeyStroke()
    {
        currentISSEvent = getIssConcurrentMetricEvent(SourceName.ISS);
        currentISSEvent.startTimer(MetricName.TimeToFirstSuggestion.name());
    }
}
