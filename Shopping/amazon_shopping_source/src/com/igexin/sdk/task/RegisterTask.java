// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.task;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.SdkService;
import java.io.PrintStream;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.task:
//            HttpTask

public class RegisterTask extends HttpTask
{

    public RegisterTask(String s, byte abyte0[], CallbackListener callbacklistener, boolean flag)
    {
        super(s, abyte0, callbacklistener, flag);
    }

    public void parseData(byte abyte0[])
    {
        MetricEvent metricevent;
        abyte0 = new String(abyte0, "utf-8");
        System.out.println((new StringBuilder()).append("RegisterTast parseData result:").append(abyte0).toString());
        Object obj = new JSONObject(abyte0);
        abyte0 = SdkService.getInstance().getMetricsFactory();
        metricevent = abyte0.createMetricEvent("MShopAndroidGetuiLib", getClass().getSimpleName());
        if (!"ok".equals(((JSONObject) (obj)).get("result")))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        metricevent.incrementCounter("PUSH:GETUI:VCIDRegister:Succeeded", 1.0D);
        obj = ((JSONObject) (obj)).getString("vcid");
        if (callbackListener != null)
        {
            callbackListener.getCallbackData(obj);
        }
_L1:
        abyte0.record(metricevent);
        return;
        try
        {
            metricevent.incrementCounter("PUSH:GETUI:VCIDRegister:Failed", 1.0D);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return;
        }
          goto _L1
    }
}
