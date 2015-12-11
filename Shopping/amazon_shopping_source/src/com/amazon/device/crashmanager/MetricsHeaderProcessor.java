// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.dp.logger.DPLogger;
import java.io.Writer;

// Referenced classes of package com.amazon.device.crashmanager:
//            AmazonPackageLookup

class MetricsHeaderProcessor
    implements com.amazon.device.utils.DetUtil.HeaderProcessor
{

    private static final DPLogger log = new DPLogger("MetricsHeaderProcessor");
    private final AmazonPackageLookup mAmazonPackageLookup;
    private final MetricEvent mMetricEvent;
    private final com.amazon.device.utils.DetUtil.HeaderProcessor mNextProcessor;
    private String mProcessName;
    private String mTag;

    public MetricsHeaderProcessor(com.amazon.device.utils.DetUtil.HeaderProcessor headerprocessor, AmazonPackageLookup amazonpackagelookup, MetricEvent metricevent)
    {
        mTag = null;
        mProcessName = null;
        if (headerprocessor == null)
        {
            throw new IllegalArgumentException("Next processor must not be null.");
        }
        if (amazonpackagelookup == null)
        {
            throw new IllegalArgumentException("Package lookup must not be null");
        }
        if (metricevent == null)
        {
            throw new IllegalArgumentException("Metric Event must not be null");
        } else
        {
            mNextProcessor = headerprocessor;
            mAmazonPackageLookup = amazonpackagelookup;
            mMetricEvent = metricevent;
            return;
        }
    }

    public String getProcessName()
    {
        return mProcessName;
    }

    public void process(String s, String s1, Writer writer)
        throws Exception
    {
        if (s == null || s1 == null) goto _L2; else goto _L1
_L1:
        if (!s.equals("Process") || mTag == null) goto _L4; else goto _L3
_L3:
        mProcessName = s1;
        mMetricEvent.addCounter((new StringBuilder()).append(mAmazonPackageLookup.generateFriendlyName(mProcessName)).append(".").append(mTag).toString(), 1.0D);
_L2:
        mNextProcessor.process(s, s1, writer);
        return;
_L4:
        if (s.equals("hasForegroundActivities") && mProcessName != null && mTag != null)
        {
            if (Boolean.valueOf(s1).booleanValue())
            {
                mMetricEvent.addCounter((new StringBuilder()).append(mAmazonPackageLookup.generateFriendlyName(mProcessName)).append(".").append(mTag).append(".foreground").toString(), 1.0D);
            }
        } else
        {
            log.error("MetricsHeaderProcessor.process", "unknown header. cannot process ", new Object[] {
                "header", s
            });
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setProcessTag(String s)
    {
        mTag = s;
    }

}
