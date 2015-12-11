// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.appsflyer:
//            AttributionIDNotReady, AppsFlyerLib, LogMessages

abstract class executorService
    implements Runnable
{

    private static AtomicInteger currentRequestsCounter = new AtomicInteger(0);
    private String appsFlyerDevKey;
    private WeakReference ctxReference;
    private ScheduledExecutorService executorService;

    protected abstract void callback(Map map);

    protected abstract void callbackFailure(String s);

    public abstract String getUrl();

    public void run()
    {
        Object obj5;
        obj5 = null;
        if (appsFlyerDevKey == null || appsFlyerDevKey.length() == 0)
        {
            return;
        }
        currentRequestsCounter.incrementAndGet();
        Context context = (Context)ctxReference.get();
        if (context == null)
        {
            currentRequestsCounter.decrementAndGet();
            return;
        }
        Object obj2 = AppsFlyerLib.access$1000(context, AppsFlyerLib.access$900(context));
        Object obj;
        obj = "";
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj = (new StringBuilder("-")).append(((String) (obj2))).toString();
        Object obj3;
        obj2 = (new StringBuilder()).append(getUrl()).append(context.getPackageName()).append(((String) (obj))).append("?devkey=").append(appsFlyerDevKey).append("&device_id=").append(AppsFlyerLib.getAppsFlyerUID(context));
        if (AppsFlyerLib.access$1100(context))
        {
            LogMessages.logMessageMaskKey((new StringBuilder("Calling server for attribution url: ")).append(((StringBuilder) (obj2)).toString()).toString());
        }
        obj3 = (HttpURLConnection)(new URL(((StringBuilder) (obj2)).toString())).openConnection();
        obj = obj3;
        ((HttpURLConnection) (obj3)).setRequestMethod("GET");
        obj = obj3;
        ((HttpURLConnection) (obj3)).setConnectTimeout(10000);
        obj = obj3;
        ((HttpURLConnection) (obj3)).setRequestProperty("Connection", "close");
        obj = obj3;
        ((HttpURLConnection) (obj3)).connect();
        obj = obj3;
        if (((HttpURLConnection) (obj3)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        obj = obj3;
        StringBuilder stringbuilder = new StringBuilder();
        Object obj4 = new InputStreamReader(((HttpURLConnection) (obj3)).getInputStream());
        obj2 = new BufferedReader(((java.io.Reader) (obj4)));
_L5:
        obj = ((BufferedReader) (obj2)).readLine();
        if (obj == null) goto _L4; else goto _L3
_L3:
        stringbuilder.append(((String) (obj))).append('\n');
          goto _L5
        obj;
        obj5 = obj2;
        obj2 = obj;
_L18:
        if (obj5 == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        obj = obj3;
        ((BufferedReader) (obj5)).close();
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        obj = obj3;
        ((InputStreamReader) (obj4)).close();
        obj = obj3;
        android.content.ecutorService ecutorservice;
        int i;
        try
        {
            throw obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj2 = obj3;
        }
        finally
        {
            obj2 = obj;
        }
        obj3 = obj;
_L16:
        obj = obj2;
        if (AppsFlyerLib.access$800() == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        obj = obj2;
        callbackFailure(((Throwable) (obj3)).getMessage());
        obj = obj2;
        Log.e("AppsFlyer_1.17", ((Throwable) (obj3)).getMessage(), ((Throwable) (obj3)));
        currentRequestsCounter.decrementAndGet();
        if (obj2 != null)
        {
            ((HttpURLConnection) (obj2)).disconnect();
        }
_L10:
        executorService.shutdown();
        return;
_L4:
        obj = obj3;
        ((BufferedReader) (obj2)).close();
        obj = obj3;
        ((InputStreamReader) (obj4)).close();
        obj = obj3;
        if (!AppsFlyerLib.access$1100(context))
        {
            break MISSING_BLOCK_LABEL_434;
        }
        obj = obj3;
        LogMessages.logMessageMaskKey((new StringBuilder("Attribution data: ")).append(stringbuilder.toString()).toString());
        obj = obj3;
        if (stringbuilder.length() <= 0 || context == null) goto _L7; else goto _L6
_L6:
        obj = obj3;
        obj2 = AppsFlyerLib.access$1200(stringbuilder.toString());
        obj = obj3;
        obj4 = (String)((Map) (obj2)).get("iscache");
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_492;
        }
        obj = obj3;
        if (!"true".equals(obj4))
        {
            break MISSING_BLOCK_LABEL_576;
        }
        obj = obj3;
        ecutorservice = context.getSharedPreferences("appsflyer-data", 0).edit();
        obj = obj3;
        ecutorservice.("attributionId", stringbuilder.toString());
        obj = obj3;
        ecutorservice.();
        obj = obj3;
        if (!AppsFlyerLib.access$1100(context))
        {
            break MISSING_BLOCK_LABEL_576;
        }
        obj = obj3;
        Log.d("AppsFlyer_1.17", (new StringBuilder("iscache=")).append(((String) (obj4))).append(" caching conversion data").toString());
        obj = obj3;
        if (AppsFlyerLib.access$800() == null) goto _L7; else goto _L8
_L8:
        obj = obj3;
        i = currentRequestsCounter.intValue();
        if (i > 1) goto _L7; else goto _L9
_L9:
        obj = obj3;
        obj4 = AppsFlyerLib.getConversionData(context);
        obj2 = obj4;
_L11:
        obj = obj3;
        callback(((Map) (obj2)));
_L7:
        currentRequestsCounter.decrementAndGet();
        if (obj3 != null)
        {
            ((HttpURLConnection) (obj3)).disconnect();
        }
          goto _L10
        obj;
          goto _L11
_L2:
        obj = obj3;
        if (AppsFlyerLib.access$800() == null)
        {
            break MISSING_BLOCK_LABEL_675;
        }
        obj = obj3;
        callbackFailure((new StringBuilder("Error connection to server: ")).append(((HttpURLConnection) (obj3)).getResponseCode()).toString());
        obj = obj3;
        if (!AppsFlyerLib.access$1100(context)) goto _L7; else goto _L12
_L12:
        obj = obj3;
        LogMessages.logMessageMaskKey((new StringBuilder("AttributionIdFetcher response code: ")).append(((HttpURLConnection) (obj3)).getResponseCode()).append("  url: ").append(obj2).toString());
          goto _L7
        Object obj1 = obj3;
_L14:
        currentRequestsCounter.decrementAndGet();
        if (obj2 != null)
        {
            ((HttpURLConnection) (obj2)).disconnect();
        }
        throw obj1;
        obj1;
        obj2 = null;
        if (true) goto _L14; else goto _L13
_L13:
        obj3;
        obj2 = null;
        if (true) goto _L16; else goto _L15
_L15:
        obj2;
        obj4 = null;
        continue; /* Loop/switch isn't completed */
        obj2;
        if (true) goto _L18; else goto _L17
_L17:
    }


    public (Context context, String s, ScheduledExecutorService scheduledexecutorservice)
    {
        ctxReference = null;
        ctxReference = new WeakReference(context);
        appsFlyerDevKey = s;
        executorService = scheduledexecutorservice;
    }
}
