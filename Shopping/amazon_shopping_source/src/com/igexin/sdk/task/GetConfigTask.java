// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.task;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.data.DynamicConfig;
import java.io.PrintStream;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.task:
//            HttpTask

public class GetConfigTask extends HttpTask
{

    public GetConfigTask(String s, byte abyte0[], CallbackListener callbacklistener)
    {
        super(s, abyte0, callbacklistener);
    }

    public void parseData(byte abyte0[])
    {
        String s;
        MetricsFactory metricsfactory;
        MetricEvent metricevent;
        s = "";
        metricsfactory = SdkService.getInstance().getMetricsFactory();
        metricevent = metricsfactory.createMetricEvent("MShopAndroidGetuiLib", getClass().getSimpleName());
        abyte0 = new String(abyte0, "utf-8");
        Object obj = new JSONObject(abyte0);
        if (!((JSONObject) (obj)).has("result") || !"ok".equals(((JSONObject) (obj)).getString("result"))) goto _L2; else goto _L1
_L1:
        DynamicConfig dynamicconfig = new DynamicConfig();
        if (!((JSONObject) (obj)).has("config")) goto _L4; else goto _L3
_L3:
        obj = ((JSONObject) (obj)).getString("config");
        if (obj == null) goto _L4; else goto _L5
_L5:
        if (((String) (obj)).equals("") || ((String) (obj)).equals("null")) goto _L4; else goto _L6
_L6:
        boolean flag = false;
        JSONObject jsonobject;
        jsonobject = new JSONObject(((String) (obj)));
        if (jsonobject.has("sdk.encrypt.enable"))
        {
            flag = jsonobject.getBoolean("sdk.encrypt.enable");
        }
        obj = null;
        if (jsonobject.has("sdk.messagemanager.url"))
        {
            obj = jsonobject.getString("sdk.messagemanager.url");
            System.out.println((new StringBuilder()).append("sdk.messagemanager.url = ").append(((String) (obj))).toString());
        }
        s = null;
        if (jsonobject.has("sdk.messagemanager.appid"))
        {
            s = jsonobject.getString("sdk.messagemanager.appid");
            System.out.println((new StringBuilder()).append("sdk.messagemanager.appid = ").append(s).toString());
        }
        String s1 = null;
        if (jsonobject.has("sdk.messagemanager.pkgname"))
        {
            s1 = jsonobject.getString("sdk.messagemanager.pkgname");
            System.out.println((new StringBuilder()).append("sdk.messagemanager.pkgname = ").append(s1).toString());
        }
        String s2 = null;
        if (jsonobject.has("sdk.messagemanager.startaction"))
        {
            s2 = jsonobject.getString("sdk.messagemanager.startaction");
            System.out.println((new StringBuilder()).append("sdk.messagemanager.startaction = ").append(s2).toString());
        }
        dynamicconfig.setEncrypt(flag);
        dynamicconfig.setDownloadUrl(((String) (obj)));
        dynamicconfig.setMasterAppID(s);
        dynamicconfig.setMasterPkgName(s1);
        dynamicconfig.setMasterServiceAction(s2);
_L4:
        metricevent.incrementCounter("PUSH:GETUI:GetConfig:Succeeded", 1.0D);
        metricsfactory.record(metricevent);
        if (callbackListener != null)
        {
            callbackListener.getCallbackData(dynamicconfig);
        }
_L8:
        return;
_L2:
        metricevent.incrementCounter("PUSH:GETUI:GetConfig:Failed", 1.0D);
        metricsfactory.record(metricevent);
        if (callbackListener == null) goto _L8; else goto _L7
_L7:
        callbackListener.exceptionHandler(new Exception((new StringBuilder()).append("parseData failed! Data is ").append(abyte0).toString()));
        return;
        Exception exception;
        exception;
        abyte0 = s;
_L9:
        exception.printStackTrace();
          goto _L2
        exception;
          goto _L9
    }
}
