// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.metrics.AbstractProfiler;
import com.amazon.gallery.foundation.metrics.AggregatedCounter;
import com.amazon.gallery.foundation.metrics.MetricName;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

// Referenced classes of package com.amazon.gallery.foundation.metrics.customer:
//            CustomerMetric, CustomerMetricEvent, CustomerMetricsInfo, MetricsPublisher

public class CustomerMetricsProfiler
{

    public static final DateFormat METRIC_DATETIME_FORMATTER;
    private static final String TAG = com/amazon/gallery/foundation/metrics/customer/CustomerMetricsProfiler.getName();
    private final CustomerMetricsInfo info;
    private String launchSource;
    private List list;
    private Set noneAggregatedEvents;
    private final MetricsPublisher publisher;
    private String sessionId;
    private Date sessionStartDate;

    public CustomerMetricsProfiler(MetricsPublisher metricspublisher, CustomerMetricsInfo customermetricsinfo)
    {
        list = new ArrayList();
        noneAggregatedEvents = new HashSet();
        publisher = metricspublisher;
        info = customermetricsinfo;
    }

    private String getUTCTime(Date date)
    {
        this;
        JVM INSTR monitorenter ;
        date = METRIC_DATETIME_FORMATTER.format(date);
        this;
        JVM INSTR monitorexit ;
        return date;
        date;
        throw date;
    }

    private void publishImmediateEventMetric(final List metrics)
    {
        (new AsyncTask() {

            final CustomerMetricsProfiler this$0;
            final List val$metrics;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                if (!publisher.send(metrics))
                {
                    GLogger.d(CustomerMetricsProfiler.TAG, "Failed to publish metrics, will save for later.", new Object[0]);
                }
                info.reset();
                return null;
            }

            
            {
                this$0 = CustomerMetricsProfiler.this;
                metrics = list1;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void endSession()
    {
        this;
        JVM INSTR monitorenter ;
        list.add((new CustomerMetric(CustomerMetric.Type.SESSION, info, sessionId)).setEventName(CustomerMetricEvent.APP_LAUNCHED.getEventName()).setEventTag(launchSource).setStartDateUtc(getUTCTime(sessionStartDate)).setEndDateUtc(getUTCTime(new Date())).setEventCount(1));
        launchSource = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void record(Collection collection, Collection collection1)
    {
        this;
        JVM INSTR monitorenter ;
        if (sessionId != null && sessionStartDate != null) goto _L2; else goto _L1
_L1:
        DebugAssert.assertMsg("Session is not started");
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        collection1 = getUTCTime(new Date());
        collection = collection.iterator();
_L4:
        AggregatedCounter aggregatedcounter;
        MetricName metricname;
        String s;
        do
        {
            if (!collection.hasNext())
            {
                break MISSING_BLOCK_LABEL_161;
            }
            aggregatedcounter = (AggregatedCounter)collection.next();
            metricname = aggregatedcounter.getName();
            s = CustomerMetricEvent.getCustomerMetricEventName(metricname.getEvent());
        } while (s == null);
        if (noneAggregatedEvents.contains(s)) goto _L4; else goto _L3
_L3:
        list.add((new CustomerMetric(CustomerMetric.Type.EVENT, info, sessionId)).setStartDateUtc(collection1).setEndDateUtc(collection1).setEventName(s).setPageName(metricname.getPageName()).setEventCount(aggregatedcounter.get()));
          goto _L4
        collection;
        throw collection;
        if (!info.getAppFirstStartRecorded())
        {
            list.add((new CustomerMetric(CustomerMetric.Type.FIRST_START, info, sessionId)).setEventName(CustomerMetricEvent.CLIENT_FIRST_START.getEventName()).setEventCount(1));
            info.setAppFirstStartRecorded();
            GLogger.i(TAG, "Added new FirstStart metric", new Object[0]);
        }
        publishImmediateEventMetric(list);
        list = new ArrayList();
          goto _L5
    }

    public void setLaunchSource(String s)
    {
        launchSource = s;
    }

    public void startSession()
    {
        this;
        JVM INSTR monitorenter ;
        sessionStartDate = new Date();
        sessionId = UUID.randomUUID().toString();
        launchSource = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void trackEvent(String s, String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        trackEvent(s, s1, map, 1);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void trackEvent(String s, String s1, Map map, int i)
    {
        this;
        JVM INSTR monitorenter ;
        String s2;
        String s3;
        s3 = CustomerMetricEvent.getCustomerMetricEventName(s1);
        s2 = AbstractProfiler.getPageNameFromExtras(map);
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        List list1;
        Object obj;
        obj = getUTCTime(new Date());
        list1 = list;
        obj = (new CustomerMetric(CustomerMetric.Type.EVENT, info, sessionId)).setStartDateUtc(((String) (obj))).setEndDateUtc(((String) (obj))).setEventName(s3);
        if (s2 != null)
        {
            s = s2;
        }
        list1.add(((CustomerMetric) (obj)).setPageName(s).setExtra(map).setEventCount(i));
        noneAggregatedEvents.add(s1);
        noneAggregatedEvents.add(s3);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void trackTimer(String s, String s1, long l, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        String s2;
        String s3;
        s3 = CustomerMetricEvent.getCustomerMetricEventName(s1);
        s2 = AbstractProfiler.getPageNameFromExtras(map);
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        List list1;
        Object obj;
        obj = new Date();
        list1 = list;
        obj = (new CustomerMetric(CustomerMetric.Type.EVENT, info, sessionId)).setStartDateUtc(getUTCTime(new Date(((Date) (obj)).getTime() - l))).setEndDateUtc(getUTCTime(((Date) (obj)))).setEventName(s3);
        if (s2 != null)
        {
            s = s2;
        }
        list1.add(((CustomerMetric) (obj)).setPageName(s).setExtra(map));
        noneAggregatedEvents.add(s1);
        noneAggregatedEvents.add(s3);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    static 
    {
        METRIC_DATETIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss");
        METRIC_DATETIME_FORMATTER.setTimeZone(TimeZone.getTimeZone("gmt"));
    }



}
