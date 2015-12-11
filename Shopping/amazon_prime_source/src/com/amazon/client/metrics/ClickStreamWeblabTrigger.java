// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.clickstream.WeblabInfo;

// Referenced classes of package com.amazon.client.metrics:
//            AbstractClickStreamMetricEvent

public class ClickStreamWeblabTrigger extends AbstractClickStreamMetricEvent
{

    public ClickStreamWeblabTrigger(String s, String s1)
    {
        super(s, s1);
    }

    public ClickStreamWeblabTrigger(String s, String s1, String s2, String s3)
    {
        super(s, s1);
        setWeblabInfo(new WeblabInfo(s2, s3));
    }

    public void setWeblabInfo(WeblabInfo weblabinfo)
    {
        if (weblabinfo == null)
        {
            removeClickStreamInfo(com/amazon/client/metrics/clickstream/WeblabInfo);
            return;
        } else
        {
            addClickStreamInfo(weblabinfo);
            return;
        }
    }
}
