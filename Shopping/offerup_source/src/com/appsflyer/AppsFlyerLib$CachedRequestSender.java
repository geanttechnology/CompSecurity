// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.util.Log;
import com.appsflyer.cache.CacheManager;
import com.appsflyer.cache.RequestCacheData;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.appsflyer:
//            AppsFlyerLib

class ctxReference
    implements Runnable
{

    private WeakReference ctxReference;

    public void run()
    {
        if (!AppsFlyerLib.access$1300()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        AppsFlyerLib.access$1402(System.currentTimeMillis());
        if (ctxReference == null) goto _L1; else goto _L3
_L3:
        AppsFlyerLib.access$1302(true);
        String s = AppsFlyerLib.getProperty("AppsFlyerKey");
        Object obj = ctxReference;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = CacheManager.getInstance().getCachedRequests((Context)ctxReference.get()).iterator();
_L6:
        if (!iterator.hasNext()) goto _L5; else goto _L4
_L4:
        RequestCacheData requestcachedata;
        requestcachedata = (RequestCacheData)iterator.next();
        if (AppsFlyerLib.access$1100((Context)ctxReference.get()))
        {
            Log.i("AppsFlyer_1.17", (new StringBuilder("resending request: ")).append(requestcachedata.getRequestURL()).toString());
        }
        AppsFlyerLib.access$700((new StringBuilder()).append(requestcachedata.getRequestURL()).append("&isCachedRequest=true").toString(), requestcachedata.getPostData(), s, ctxReference, requestcachedata.getCacheKey(), "AppsFlyer_1.17", false);
          goto _L6
        Exception exception2;
        exception2;
        Log.i("AppsFlyer_1.17", "Failed to resend cached request");
          goto _L6
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        Exception exception;
        try
        {
            throw exception1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally
        {
            AppsFlyerLib.access$1302(false);
        }
        Log.e("AppsFlyer_1.17", "failed to check cache.");
        AppsFlyerLib.access$1302(false);
_L8:
        AppsFlyerLib.access$1500().shutdown();
        AppsFlyerLib.access$1502(null);
        return;
_L5:
        obj;
        JVM INSTR monitorexit ;
        AppsFlyerLib.access$1302(false);
        if (true) goto _L8; else goto _L7
_L7:
        throw exception;
    }

    public (Context context)
    {
        ctxReference = null;
        ctxReference = new WeakReference(context);
    }
}
