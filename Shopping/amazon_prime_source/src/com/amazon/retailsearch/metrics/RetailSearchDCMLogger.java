// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.Context;
import android.util.Log;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.android.api.log.LogEventHandler;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.debug.RetailSearchDebug;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.metrics.impressions.AsinImpression;
import com.amazon.searchapp.retailsearch.client.AssetsServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchServiceCall;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            BaseAbstractDCMLogger, RetailSearchLoggingConfig, SourceName, MetricName, 
//            DetailPageType, SearchMetricsListenerInvoker, SearchMetricEvent, DCMLogEventHandler

public class RetailSearchDCMLogger extends BaseAbstractDCMLogger
    implements RetailSearchLogger
{

    private static final String TAG = com/amazon/retailsearch/metrics/RetailSearchDCMLogger.getSimpleName();
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/metrics/RetailSearchDCMLogger);
    private MetricEvent currentFilterMenuEvent;
    FeatureConfiguration featureConfig;
    Lazy latencyAdaptiveManager;
    private MetricEvent searchInitTimer;
    SearchMetricsListenerInvoker searchMetricsListenerInvoker;

    public RetailSearchDCMLogger(Context context, RetailSearchLoggingConfig retailsearchloggingconfig)
    {
        super(context, retailsearchloggingconfig);
        searchInitTimer = null;
        currentFilterMenuEvent = null;
        RetailSearchDaggerGraphController.inject(this);
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

    public void recordCacheHit()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.CacheHit.name(), 1);
    }

    public void recordDetailPageTransition(String s, DetailPageType detailpagetype)
    {
        MetricEvent metricevent = getSearchMetricEvent(SourceName.Search);
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
                    $SwitchMap$com$amazon$retailsearch$metrics$DetailPageType[DetailPageType.VIEW_OPTIONS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.retailsearch.metrics.DetailPageType[detailpagetype.ordinal()];
        JVM INSTR tableswitch 1 4: default 48
    //                   1 88
    //                   2 123
    //                   3 158
    //                   4 193;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        s = (new StringBuilder()).append(MetricName.DetailPageInvoked.name()).append("-").append(s.toLowerCase()).toString();
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
        s = (new StringBuilder()).append(MetricName.AlternateDetailPageInvokedViewOptions.name()).append("-").append(s.toLowerCase()).toString();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void recordEndOfResults()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.EndOfResults.name(), 1);
    }

    public void recordInlineAddToCartInvoked()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.AddToCart.name(), 1);
    }

    public void recordLayoutSwitch(String s, String s1)
    {
        super.recordCounter(getSearchMetricEvent(SourceName.Search), (new StringBuilder()).append(s.toLowerCase()).append("-").append(s1.toLowerCase()).toString(), 1);
    }

    public void recordPrefetching()
    {
        recordCounter(getSearchMetricEvent(SourceName.Prefetching), MetricName.Prefetched.name(), 1);
    }

    public void recordPrefetchingCacheHit()
    {
        recordCounter(getSearchMetricEvent(SourceName.Prefetching), MetricName.CacheHit.name(), 1);
    }

    public void recordRelatedSearchesInvoked()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.RelatedSearchesInvoked.name(), 1);
    }

    public void recordSimInteraction()
    {
        recordCounter(getSearchMetricEvent(SourceName.Search), MetricName.SimInteraction.name(), 1);
    }

    public void saveSearchInitTime(long l)
    {
        if (searchInitTimer == null)
        {
            searchInitTimer = getSearchMetricEvent(SourceName.Search);
            searchInitTimer.addTimer(MetricName.InitTime.name(), l);
        }
    }

    public void searchATFReached(LogEventHandler logeventhandler)
    {
        searchMetricsListenerInvoker.searchATFReached();
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("An attempt was made to log ATF without a valid metric event");
            return;
        }
        SearchMetricEvent searchmetricevent = (SearchMetricEvent)logeventhandler.getEvent();
        searchmetricevent.stopTimer(MetricName.ClientATF.name());
        searchmetricevent.stopTimer(MetricName.clickToATF.name());
        searchmetricevent.stopResultLayoutTypeMetrics();
        searchmetricevent.stopConnectionTypeMetrics();
        RetailSearchDebug.logMetricEvent(searchmetricevent.getEvent());
        if ("T1".equals(FeatureStateUtil.getAdaptiveSearchWeblab(featureConfig)))
        {
            ((LatencyAdaptiveManager)latencyAdaptiveManager.get()).addData(searchmetricevent.getEvent());
        }
        metricsFactory.record(searchmetricevent.getEvent());
        logeventhandler.clearEvent();
    }

    public void searchFirstByteReceived(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("Retail Search : An attempt was made to log first byte without a valid metric event. This request will be ignored");
            return;
        } else
        {
            logeventhandler = (SearchMetricEvent)logeventhandler.getEvent();
            logeventhandler.stopTimer(MetricName.ClickToFirstByte.name());
            logeventhandler.startTimer(MetricName.ClientATF.name());
            return;
        }
    }

    public void searchSRDSAssetsCompleted(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("An attempt was made to log srds assets latency without a valid metric event. This request will be ignored");
            return;
        } else
        {
            logeventhandler = (MetricEvent)logeventhandler.getEvent();
            logeventhandler.stopTimer(MetricName.RequestLatency.name());
            RetailSearchDebug.logMetricEvent(logeventhandler);
            metricsFactory.record(logeventhandler);
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

    public LogEventHandler searchSRDSAssetsStarted(AssetFetchType assetfetchtype)
    {
        MetricEvent metricevent = getSearchConcurrentMetricEvent(SourceName.AssetsSRDSRequest);
        metricevent.startTimer(MetricName.RequestLatency.name());
        if (assetfetchtype != null)
        {
            metricevent.addString(com.amazon.retailsearch.metrics.MetricName.AssetFetchType.name(), assetfetchtype.toLoggingString());
        }
        return new DCMLogEventHandler(metricevent);
    }

    public void searchSRDSCompleted(LogEventHandler logeventhandler)
    {
        searchMetricsListenerInvoker.searchSRDSCompleted();
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("An attempt was made to log srds latency without a valid metric event. This request will be ignored");
            return;
        } else
        {
            MetricEvent metricevent = (MetricEvent)logeventhandler.getEvent();
            metricevent.stopTimer(MetricName.RequestLatency.name());
            RetailSearchDebug.logMetricEvent(metricevent);
            metricsFactory.record(metricevent);
            logeventhandler.clearEvent();
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

    public void searchSRDSFirstByteReceived(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("Retail Search : An attempt was made to log srds first byte without a valid metric event. This request will be ignored");
            return;
        } else
        {
            ((MetricEvent)logeventhandler.getEvent()).stopTimer(MetricName.FirstByte.name());
            return;
        }
    }

    public void searchSRDSRefinementsEndParse(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("An attempt was made to log srds parse time (begin) without a valid metric event. This request will be ignored");
            return;
        } else
        {
            ((MetricEvent)logeventhandler.getEvent()).stopTimer(MetricName.StreamingRefinementsLatency.name());
            return;
        }
    }

    public void searchSRDSResponseBeginParse(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("An attempt was made to log srds parse time (begin) without a valid metric event. This request will be ignored");
            return;
        } else
        {
            logeventhandler = (MetricEvent)logeventhandler.getEvent();
            logeventhandler.startTimer(MetricName.ResponseParseTime.name());
            logeventhandler.startTimer(MetricName.StreamingRefinementsLatency.name());
            return;
        }
    }

    public void searchSRDSResponseEndParse(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("Retail Search : An attempt was made to log srds parse time (end) without a valid metric event. This request will be ignored");
            return;
        } else
        {
            ((MetricEvent)logeventhandler.getEvent()).stopTimer(MetricName.ResponseParseTime.name());
            return;
        }
    }

    public volatile LogEventHandler searchSRDSStarted()
    {
        return searchSRDSStarted();
    }

    public DCMLogEventHandler searchSRDSStarted()
    {
        searchMetricsListenerInvoker.searchSRDSStarted();
        MetricEvent metricevent = getSearchConcurrentMetricEvent(SourceName.SRDSRequest);
        metricevent.startTimer(MetricName.RequestLatency.name());
        metricevent.startTimer(MetricName.FirstByte.name());
        return new DCMLogEventHandler(metricevent);
    }

    public volatile LogEventHandler searchStarted()
    {
        return searchStarted();
    }

    public DCMLogEventHandler searchStarted()
    {
        searchMetricsListenerInvoker.searchStarted();
        recordSearchInitTime();
        SearchMetricEvent searchmetricevent = new SearchMetricEvent(getSearchConcurrentMetricEvent(SourceName.Search), context);
        searchmetricevent.startTimer(MetricName.ClickToFirstByte.name());
        searchmetricevent.startTimer(MetricName.clickToATF.name());
        searchmetricevent.startResultLayoutTypeMetrics();
        searchmetricevent.startConnectionTypeMetrics();
        return new DCMLogEventHandler(searchmetricevent);
    }

    public void trueSearchATFReached(LogEventHandler logeventhandler)
    {
        if (logeventhandler == null || logeventhandler.getEvent() == null)
        {
            log.warn("An attempt was made to log trueClickToATF without a valid metric event");
            return;
        } else
        {
            SearchMetricEvent searchmetricevent = (SearchMetricEvent)logeventhandler.getEvent();
            searchmetricevent.stopTimer(MetricName.trueClickToATF.name());
            RetailSearchDebug.logMetricEvent(searchmetricevent.getEvent());
            metricsFactory.record(searchmetricevent.getEvent());
            logeventhandler.clearEvent();
            return;
        }
    }

    public LogEventHandler trueSearchStarted()
    {
        SearchMetricEvent searchmetricevent = new SearchMetricEvent(getSearchConcurrentMetricEvent(SourceName.Search), context);
        searchmetricevent.startTimer(MetricName.trueClickToATF.name());
        return new DCMLogEventHandler(searchmetricevent);
    }

}
