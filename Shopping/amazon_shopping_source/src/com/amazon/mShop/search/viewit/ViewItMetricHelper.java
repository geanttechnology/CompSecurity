// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.net.CountMetricObserver;
import com.amazon.mShop.net.PageMetricsObserver;
import com.amazon.mShop.util.Util;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity

public class ViewItMetricHelper
{

    private ViewItActivity mActivity;
    private Map mCountMetricsPerSessionMap;
    private PageMetricsObserver mFlowBarcodeFailObserver;
    private PageMetricsObserver mFlowBarcodeNoMatchesObserver;
    private PageMetricsObserver mFlowBarcodeSuccessObserver;
    private PageMetricsObserver mFlowImageFailObserver;
    private PageMetricsObserver mFlowImageSuccessObserver;
    private PageMetricsObserver mFlowSessionDurationObserver;
    private PageMetricsObserver mFlowTimeToSuccessObserver;

    public ViewItMetricHelper(ViewItActivity viewitactivity)
    {
        mCountMetricsPerSessionMap = new ConcurrentHashMap();
        mActivity = viewitactivity;
    }

    public void cancelFlowBarcodeFailObserver()
    {
        if (mFlowBarcodeFailObserver != null)
        {
            mFlowBarcodeFailObserver.onCancelled();
            mFlowBarcodeFailObserver = null;
        }
    }

    public void cancelFlowBarcodeNoMatchesObserver()
    {
        if (mFlowBarcodeNoMatchesObserver != null)
        {
            mFlowBarcodeNoMatchesObserver.onCancelled();
            mFlowBarcodeNoMatchesObserver = null;
        }
    }

    public void cancelFlowBarcodeSuccessObserver()
    {
        if (mFlowBarcodeSuccessObserver != null)
        {
            mFlowBarcodeSuccessObserver.onCancelled();
            mFlowBarcodeSuccessObserver = null;
        }
    }

    public void cancelFlowImageFailObserver()
    {
        if (mFlowImageFailObserver != null)
        {
            mFlowImageFailObserver.onCancelled();
            mFlowImageFailObserver = null;
        }
    }

    public void cancelFlowImageSuccessObserver()
    {
        if (mFlowImageSuccessObserver != null)
        {
            mFlowImageSuccessObserver.onCancelled();
            mFlowImageSuccessObserver = null;
        }
    }

    public void cancelFlowTimeToSuccessObserver()
    {
        if (mFlowTimeToSuccessObserver != null)
        {
            mFlowTimeToSuccessObserver.onCancelled();
            mFlowTimeToSuccessObserver = null;
        }
    }

    public void finishFlowBarcodeFailObserver()
    {
        if (mFlowBarcodeFailObserver != null)
        {
            mFlowBarcodeFailObserver.completeForObject("Scan-barcode-failure");
            mFlowBarcodeFailObserver = null;
        }
    }

    public void finishFlowBarcodeNoMatchesObserver()
    {
        if (mFlowBarcodeNoMatchesObserver != null)
        {
            mFlowBarcodeNoMatchesObserver.completeForObject("Scan-barcode-nomatches");
            mFlowBarcodeNoMatchesObserver = null;
        }
    }

    public void finishFlowBarcodeSuccessObserver()
    {
        if (mFlowBarcodeSuccessObserver != null)
        {
            mFlowBarcodeSuccessObserver.completeForObject("Scan-barcode-success");
            mFlowBarcodeSuccessObserver = null;
        }
    }

    public void finishFlowImageFailObserver()
    {
        if (mFlowImageFailObserver != null)
        {
            mFlowImageFailObserver.completeForObject("Scan-product-failure");
            mFlowImageFailObserver = null;
        }
    }

    public void finishFlowImageSuccessObserver()
    {
        if (mFlowImageSuccessObserver != null)
        {
            mFlowImageSuccessObserver.completeForObject("Scan-product-success");
            mFlowImageSuccessObserver = null;
        }
    }

    public void finishFlowSessionDurationObserver()
    {
        if (mFlowSessionDurationObserver != null)
        {
            mFlowSessionDurationObserver.completeForObject("Scan-session-duration");
            mFlowSessionDurationObserver = null;
        }
    }

    public void finishFlowTimeToSuccessObserver()
    {
        if (mFlowTimeToSuccessObserver != null)
        {
            mFlowTimeToSuccessObserver.completeForObject("Scan-time-to-success");
            mFlowTimeToSuccessObserver = null;
        }
    }

    public void logCountMetricsPerSession(String s, int i)
    {
        if (!Util.isEmpty(s) && i > 0)
        {
            Integer integer = (Integer)mCountMetricsPerSessionMap.get(s);
            int j = i;
            if (integer != null)
            {
                j = i + integer.intValue();
            }
            mCountMetricsPerSessionMap.put(s, Integer.valueOf(j));
        }
    }

    public void postCountMetricsPerSession()
    {
        if (!mCountMetricsPerSessionMap.isEmpty())
        {
            String s;
            Object obj;
            for (Iterator iterator = mCountMetricsPerSessionMap.entrySet().iterator(); iterator.hasNext(); CountMetricObserver.logCountMetrics(com.amazon.mShop.net.CountMetricObserver.MetricType.FLOW_SCAN, s, ((Integer) (obj)).intValue()))
            {
                obj = (java.util.Map.Entry)iterator.next();
                s = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = (Integer)((java.util.Map.Entry) (obj)).getValue();
            }

            mCountMetricsPerSessionMap.clear();
        }
    }

    public void startFlowBarcodeFailObserver()
    {
        if (mFlowBarcodeFailObserver != null)
        {
            mFlowBarcodeFailObserver.onCancelled();
        }
        mFlowBarcodeFailObserver = new PageMetricsObserver("Scan-barcode-failure");
        mFlowBarcodeFailObserver.startForObject("Scan-barcode-failure");
    }

    public void startFlowBarcodeNoMatchesObserver()
    {
        if (mFlowBarcodeNoMatchesObserver != null)
        {
            mFlowBarcodeNoMatchesObserver.onCancelled();
        }
        mFlowBarcodeNoMatchesObserver = new PageMetricsObserver("Scan-barcode-nomatches");
        mFlowBarcodeNoMatchesObserver.startForObject("Scan-barcode-nomatches");
    }

    public void startFlowBarcodeSuccessObserver()
    {
        if (mFlowBarcodeSuccessObserver != null)
        {
            mFlowBarcodeSuccessObserver.onCancelled();
        }
        mFlowBarcodeSuccessObserver = new PageMetricsObserver("Scan-barcode-success");
        mFlowBarcodeSuccessObserver.startForObject("Scan-barcode-success");
    }

    public void startFlowImageFailObserver()
    {
        if (mFlowImageFailObserver != null)
        {
            mFlowImageFailObserver.onCancelled();
        }
        mFlowImageFailObserver = new PageMetricsObserver("Scan-product-failure");
        mFlowImageFailObserver.startForObject("Scan-product-failure");
    }

    public void startFlowImageSuccessObserver()
    {
        if (mFlowImageSuccessObserver != null)
        {
            mFlowImageSuccessObserver.onCancelled();
        }
        mFlowImageSuccessObserver = new PageMetricsObserver("Scan-product-success");
        mFlowImageSuccessObserver.startForObject("Scan-product-success");
    }

    public void startFlowSessionDurationObserver()
    {
        if (mFlowSessionDurationObserver != null)
        {
            mFlowSessionDurationObserver.onCancelled();
        }
        mFlowSessionDurationObserver = new PageMetricsObserver("Scan-session-duration");
        mFlowSessionDurationObserver.startForObject("Scan-session-duration");
    }

    public void startFlowTimeToSuccessObserver()
    {
        if (mFlowTimeToSuccessObserver != null)
        {
            mFlowTimeToSuccessObserver.onCancelled();
        }
        mFlowTimeToSuccessObserver = new PageMetricsObserver("Scan-time-to-success");
        mFlowTimeToSuccessObserver.startForObject("Scan-time-to-success");
    }
}
