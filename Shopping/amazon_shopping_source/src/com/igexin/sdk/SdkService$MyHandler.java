// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.igexin.sdk.action.PushMessageAction;

// Referenced classes of package com.igexin.sdk:
//            SdkService, Consts

static class ion extends Handler
{

    public void handleMessage(Message message)
    {
        if (message.what == Consts.MESSAGE_RECEIVER_INTERNAL)
        {
            message = (Intent)message.obj;
            SdkService.access$500(SdkService.getInstance(), message);
        } else
        if (message.what == 11000)
        {
            SdkService.access$600(SdkService.getInstance());
            message = (Intent)message.obj;
            if ("com.igexin.sdk.payloadreceived".equals(message.getAction()))
            {
                MetricsFactory metricsfactory = SdkService.getInstance().getMetricsFactory();
                MetricEvent metricevent = metricsfactory.createMetricEvent("MShopAndroidGetuiLib", SdkService.getInstance().getClass().getSimpleName());
                metricevent.incrementCounter("PUSH:GETUI:MessagesReceived", 1.0D);
                metricsfactory.record(metricevent);
                PushMessageAction.getInstance().doPushMessageAction(message);
                return;
            }
        }
    }

    ion()
    {
    }
}
