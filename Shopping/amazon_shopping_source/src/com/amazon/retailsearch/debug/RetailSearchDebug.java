// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.debug;

import android.content.Context;
import android.widget.Toast;
import com.amazon.client.metrics.DataPoint;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.retailsearch.android.api.init.DebugMode;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.util.Iterator;
import java.util.List;

public class RetailSearchDebug
{

    private static final MessageLogger LOGGER = AppLog.getLog(com/amazon/retailsearch/debug/RetailSearchDebug);

    public RetailSearchDebug()
    {
    }

    public static void log(String s)
    {
        if (!DebugMode.enabled())
        {
            return;
        } else
        {
            LOGGER.debug(s);
            return;
        }
    }

    public static void logMetricEvent(MetricEvent metricevent)
    {
        if (DebugMode.enabled())
        {
            Iterator iterator = metricevent.getAsDataPoints().iterator();
            while (iterator.hasNext()) 
            {
                DataPoint datapoint = (DataPoint)iterator.next();
                LOGGER.debug((new StringBuilder()).append(metricevent.getSource()).append(".").append(datapoint.getName()).append(" : ").append(datapoint.getValue()).append(" ; ").append(datapoint.toString()).toString());
            }
        }
    }

    public static void toast(Context context, String s)
    {
        if (!DebugMode.enabled())
        {
            return;
        } else
        {
            Toast.makeText(context, s, 1).show();
            return;
        }
    }

}
