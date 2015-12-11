// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import android.util.Log;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.debug.RetailSearchDebug;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.metrics.impressions.AsinImpression;
import com.amazon.searchapp.retailsearch.client.AssetsServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchServiceCall;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            BaseAbstractDCMLogger, RetailSearchLoggingConfig, SourceName, MetricName, 
//            DetailPageType, SearchMetricsListenerInvoker, SearchMetricEvent

public class RetailSearchDCMLogger extends BaseAbstractDCMLogger
    implements RetailSearchLogger
{

    private static final String TAG = com/amazon/retailsearch/metrics/RetailSearchDCMLogger.getSimpleName();
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/metrics/RetailSearchDCMLogger);
    private MetricEvent currentFilterMenuEvent;
    private MetricEvent currentSRDSAssetsEvent;
    private MetricEvent currentSRDSSearchEvent;
    private SearchMetricEvent currentSearchEvent;
    private MetricEvent searchInitTimer;
    SearchMetricsListenerInvoker searchMetricsListenerInvoker;

    public RetailSearchDCMLogger(Context context, RetailSearchLoggingConfig retailsearchloggingconfig)
    {
        super(context, retailsearchloggingconfig);
        currentSearchEvent = null;
        currentSRDSSearchEvent = null;
        searchInitTimer = null;
        currentSRDSAssetsEvent = null;
        currentFilterMenuEvent = null;
        RetailSearchDaggerGraphController.inject(this);
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

    private void recordSearchInitTime()
    {
        if (searchInitTimer != null)
        {
            metricsFactory.record(searchInitTimer);
            searchInitTimer = null;
        }
    }

    public void error(String s, Throwable throwable)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.Search);
        addEventInfo(metricevent, s, throwable);
        recordCounter(metricevent, getErrorMetric(throwable), 1);
_L1:
        return;
        s;
        if (DebugMode.enabled())
        {
            Log.e(TAG, "Error", s);
            return;
        }
          goto _L1
    }

    public void filterMenuClosed()
    {
        if (currentFilterMenuEvent == null)
        {
            log.warn("An attempt was made to log closing the filter menu without a valid metric event. This request will be ignored");
            return;
        } else
        {
            RetailSearchDebug.logMetricEvent(currentFilterMenuEvent);
            metricsFactory.record(currentFilterMenuEvent);
            currentFilterMenuEvent = null;
            return;
        }
    }

    public void filterMenuInvoked(String s)
    {
        currentFilterMenuEvent = getSearchConcurrentMetricEvent(SourceName.Filter);
        currentFilterMenuEvent.addString(MetricName.MenuInvoked.name(), s.toLowerCase());
        currentFilterMenuEvent.addCounter(MetricName.SearchesPerFilterAccess.name(), 0.0D);
    }

    public void filterMenuSearch()
    {
        if (currentFilterMenuEvent == null)
        {
            log.warn("An attempt was made to log a search using the filter menu without a valid metric event. This request will be ignored");
            return;
        } else
        {
            currentFilterMenuEvent.addCounter(MetricName.SearchesPerFilterAccess.name(), 1.0D);
            return;
        }
    }

    public void recordAsinImpressions(List list)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.Search);
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s = ((AsinImpression)list.next()).toLoggingFormat();
            if (s != null)
            {
                metricevent.addString(MetricName.ClientVisibleImpression.name(), s);
            }
        } while (true);
        if (metricevent.getAsDataPoints().size() > 0)
        {
            metricsFactory.record(metricevent);
        }
    }

    public void recordDetailPageTransition(String s, DetailPageType detailpagetype)
    {
        Object obj;
        MetricEvent metricevent;
        metricevent = getSearchMetricEvent(SourceName.Search);
        obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType = new int[DetailPageType.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.NEWER_EDITION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.TWISTER.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.FORCED_PRIME.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.MAIN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.retailsearch.metrics.DetailPageType[detailpagetype.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 59
    //                   2 94
    //                   3 129
    //                   4 164;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        s = obj;
_L7:
        recordCounter(metricevent, s, 1);
        return;
_L2:
        s = (new StringBuilder()).append(MetricName.AlternateDetailPageInvokedNeva.name()).append("-").append(s.toLowerCase()).toString();
        continue; /* Loop/switch isn't completed */
_L3:
        s = (new StringBuilder()).append(MetricName.AlternateDetailPageInvokedTwister.name()).append("-").append(s.toLowerCase()).toString();
        continue; /* Loop/switch isn't completed */
_L4:
        s = (new StringBuilder()).append(MetricName.AlternateDetailPageInvokedForcedPrime.name()).append("-").append(s.toLowerCase()).toString();
        continue; /* Loop/switch isn't completed */
_L5:
        s = (new StringBuilder()).append(MetricName.DetailPageInvoked.name()).append("-").append(s.toLowerCase()).toString();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void recordEndOfResults()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.EndOfResults.name(), 1);
    }

    public void recordLayoutSwitch(String s, String s1)
    {
        super.recordCounter(getSearchMetricEvent(SourceName.Search), (new StringBuilder()).append(s.toLowerCase()).append("-").append(s1.toLowerCase()).toString(), 1);
    }

    public void recordRelatedSearchesInvoked()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.RelatedSearchesInvoked.name(), 1);
    }

    public void saveSearchInitTime(long l)
    {
        if (searchInitTimer == null)
        {
            searchInitTimer = getSearchMetricEvent(SourceName.Search);
            searchInitTimer.addTimer(MetricName.InitTime.name(), l);
        }
    }

    public void searchATFReached()
    {
        searchMetricsListenerInvoker.searchATFReached();
        if (currentSearchEvent == null)
        {
            log.warn("An attempt was made to log ATF without a valid metric event");
            return;
        } else
        {
            currentSearchEvent.stopTimer(MetricName.ClientATF.name());
            currentSearchEvent.stopTimer(MetricName.TapToATF.name());
            currentSearchEvent.stopViewTypeMetrics();
            currentSearchEvent.stopConnectionTypeMetrics();
            RetailSearchDebug.logMetricEvent(currentSearchEvent.getEvent());
            metricsFactory.record(currentSearchEvent.getEvent());
            currentSearchEvent = null;
            return;
        }
    }

    public void searchFirstByteReceived()
    {
        if (currentSearchEvent == null)
        {
            log.warn("Retail Search : An attempt was made to log first byte without a valid metric event. This request will be ignored");
            return;
        } else
        {
            currentSearchEvent.stopTimer(MetricName.TapToFirstByte.name());
            currentSearchEvent.startTimer(MetricName.ClientATF.name());
            return;
        }
    }

    public void searchSRDSAssetsCompleted()
    {
        if (currentSRDSAssetsEvent == null)
        {
            log.warn("An attempt was made to log srds assets latency without a valid metric event. This request will be ignored");
            return;
        } else
        {
            currentSRDSAssetsEvent.stopTimer(MetricName.RequestLatency.name());
            RetailSearchDebug.logMetricEvent(currentSRDSAssetsEvent);
            metricsFactory.record(currentSRDSAssetsEvent);
            currentSRDSAssetsEvent = null;
            return;
        }
    }

    public void searchSRDSAssetsError(String s, Throwable throwable, AssetsServiceCall assetsservicecall, AssetFetchType assetfetchtype)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.AssetsSRDSRequest);
        if (assetfetchtype != null)
        {
            metricevent.addString(com.amazon.retailsearch.metrics.MetricName.AssetFetchType.name(), assetfetchtype.toLoggingString());
        }
        addEventInfo(metricevent, s, throwable);
        if (assetsservicecall != null)
        {
            addServiceCallInfo(metricevent, assetsservicecall);
        }
        recordCounter(metricevent, getErrorMetric(throwable), 1);
    }

    public void searchSRDSAssetsStarted(AssetFetchType assetfetchtype)
    {
        currentSRDSAssetsEvent = getSearchConcurrentMetricEvent(SourceName.AssetsSRDSRequest);
        currentSRDSAssetsEvent.startTimer(MetricName.RequestLatency.name());
        if (assetfetchtype != null)
        {
            currentSRDSAssetsEvent.addString(com.amazon.retailsearch.metrics.MetricName.AssetFetchType.name(), assetfetchtype.toLoggingString());
        }
    }

    public void searchSRDSCompleted()
    {
        searchMetricsListenerInvoker.searchSRDSCompleted();
        if (currentSRDSSearchEvent == null)
        {
            log.warn("An attempt was made to log srds latency without a valid metric event. This request will be ignored");
            return;
        } else
        {
            currentSRDSSearchEvent.stopTimer(MetricName.RequestLatency.name());
            RetailSearchDebug.logMetricEvent(currentSRDSSearchEvent);
            metricsFactory.record(currentSRDSSearchEvent);
            currentSRDSSearchEvent = null;
            return;
        }
    }

    public void searchSRDSError(String s, Throwable throwable, SearchServiceCall searchservicecall)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.SRDSRequest);
        addEventInfo(metricevent, s, throwable);
        if (searchservicecall != null)
        {
            addServiceCallInfo(metricevent, searchservicecall);
        }
        recordCounter(metricevent, getErrorMetric(throwable), 1);
    }

    public void searchSRDSResponseBeginParse()
    {
        if (currentSRDSSearchEvent == null)
        {
            log.warn("An attempt was made to log srds parse time (begin) without a valid metric event. This request will be ignored");
            return;
        } else
        {
            currentSRDSSearchEvent.startTimer(MetricName.ResponseParseTime.name());
            return;
        }
    }

    public void searchSRDSResponseEndParse()
    {
        if (currentSRDSSearchEvent == null)
        {
            log.warn("Retail Search : An attempt was made to log srds parse time (end) without a valid metric event. This request will be ignored");
            return;
        } else
        {
            currentSRDSSearchEvent.stopTimer(MetricName.ResponseParseTime.name());
            return;
        }
    }

    public void searchSRDSStarted()
    {
        searchMetricsListenerInvoker.searchSRDSStarted();
        currentSRDSSearchEvent = getSearchConcurrentMetricEvent(SourceName.SRDSRequest);
        currentSRDSSearchEvent.startTimer(MetricName.RequestLatency.name());
    }

    public void searchStarted()
    {
        searchMetricsListenerInvoker.searchStarted();
        recordSearchInitTime();
        currentSearchEvent = new SearchMetricEvent(getSearchConcurrentMetricEvent(SourceName.Search), context);
        currentSearchEvent.startTimer(MetricName.TapToFirstByte.name());
        currentSearchEvent.startTimer(MetricName.TapToATF.name());
        currentSearchEvent.startViewTypeMetrics();
        currentSearchEvent.startConnectionTypeMetrics();
    }

}
