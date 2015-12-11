// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.net:
//            BaseMetricsObserver, PageMetricsEventListener, MetricsAggregator, NetInfo, 
//            MShopAggregatedClientMetrics, AggregatedMetrics

public class PageMetricsObserver extends BaseMetricsObserver
{

    private static boolean LOG_TEST_METRICS = false;
    static final MetricsAggregator METRICS_AGGREGATOR = new MetricsAggregator() {

        public AggregatedMetrics aggregate(List list)
        {
            ArrayList arraylist;
            String s;
            Iterator iterator;
            arraylist = new ArrayList();
            s = NetInfo.getCurrentCarrierName();
            iterator = list.iterator();
_L2:
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_204;
                }
                list = (MetricsAggregator.MetricEvent)iterator.next();
            } while (!(list instanceof PageMetricsObserver));
            PageMetricsObserver pagemetricsobserver = (PageMetricsObserver)list;
            pagemetricsobserver;
            JVM INSTR monitorenter ;
            Object obj = pagemetricsobserver.getPageIdentifier();
            if (pagemetricsobserver.isStatusFailed())
            {
                list = "Failed";
            } else
            {
                list = "Latency";
            }
            list = String.format("%s/%s:%s", new Object[] {
                s, list, obj
            });
            if (PageMetricsObserver.LOG_TEST_METRICS)
            {
                Log.i("PageLatencyTest", (new StringBuilder()).append(list).append(":").append(String.valueOf(pagemetricsobserver.getTotalTime())).toString());
            }
            obj = new ClientMetric();
            ((ClientMetric) (obj)).setName(list);
            ((ClientMetric) (obj)).setCount(Integer.valueOf(1));
            ((ClientMetric) (obj)).setTime(Integer.valueOf(pagemetricsobserver.getTotalTime()));
            arraylist.add(obj);
            pagemetricsobserver;
            JVM INSTR monitorexit ;
            if (true) goto _L2; else goto _L1
_L1:
            list;
            pagemetricsobserver;
            JVM INSTR monitorexit ;
            throw list;
            list = new MShopAggregatedClientMetrics();
            list.setMetrics(arraylist);
            return list;
        }

    };
    private PageMetricsEventListener mEventListener;
    private Map mObjectsRefCounters;
    private String mPageIdentifier;

    public PageMetricsObserver(String s)
    {
        mObjectsRefCounters = new HashMap();
        mPageIdentifier = s;
    }

    public static PageMetricsObserver start(String s)
    {
        s = new PageMetricsObserver(s);
        s.onStart();
        return s;
    }

    public void completeForObject(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = mObjectsRefCounters.containsKey(s);
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (isFinished()) goto _L1; else goto _L3
_L3:
        int i = ((Integer)mObjectsRefCounters.get(s)).intValue() - 1;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        mObjectsRefCounters.remove(s);
_L4:
        if (mObjectsRefCounters.isEmpty())
        {
            onComplete();
        }
          goto _L1
        s;
        throw s;
        mObjectsRefCounters.put(s, Integer.valueOf(i));
          goto _L4
    }

    public MetricsAggregator getAggregator()
    {
        return METRICS_AGGREGATOR;
    }

    public MetricsAggregator.Type getEventAggregatorType()
    {
        return MetricsAggregator.Type.PageMetric;
    }

    public String getPageIdentifier()
    {
        return mPageIdentifier;
    }

    protected void notifyListenerOnComplete()
    {
        if (mEventListener != null)
        {
            mEventListener.onPageComplete(this, mPageIdentifier);
            mEventListener = null;
        }
    }

    protected void notifyListenerOnPageCancelled()
    {
        if (mEventListener != null)
        {
            mEventListener.onPageCancelled(this, mPageIdentifier);
            mEventListener = null;
        }
    }

    protected void notifyListenerOnStart()
    {
        if (mEventListener != null)
        {
            mEventListener.onPageStart(this, mPageIdentifier);
        }
    }

    public void onCancelled()
    {
        this;
        JVM INSTR monitorenter ;
        onFinished(BaseMetricsObserver.Status.Canceled);
        notifyListenerOnPageCancelled();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onComplete()
    {
        this;
        JVM INSTR monitorenter ;
        super.onComplete();
        notifyListenerOnComplete();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onFailed(String s)
    {
        this;
        JVM INSTR monitorenter ;
        super.onFailed(s);
        notifyListenerOnComplete();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void onStart()
    {
        this;
        JVM INSTR monitorenter ;
        super.onStart();
        notifyListenerOnStart();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setEventListener(PageMetricsEventListener pagemetricseventlistener)
    {
        mEventListener = pagemetricseventlistener;
    }

    public void startForObject(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = Util.isEmpty(s);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (isFinished()) goto _L1; else goto _L3
_L3:
        if (getStatus() == BaseMetricsObserver.Status.Unknown)
        {
            onStart();
        }
        if (mObjectsRefCounters.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_71;
        }
        mObjectsRefCounters.put(s, Integer.valueOf(1));
          goto _L1
        s;
        throw s;
        int i = ((Integer)mObjectsRefCounters.get(s)).intValue();
        mObjectsRefCounters.put(s, Integer.valueOf(i + 1));
          goto _L1
    }


}
