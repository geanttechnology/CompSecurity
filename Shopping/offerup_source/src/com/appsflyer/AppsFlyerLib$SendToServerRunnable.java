// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.appsflyer.cache.CacheManager;
import com.appsflyer.cache.RequestCacheData;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.appsflyer:
//            AppsFlyerLib, AppsFlyerProperties, HashUtils

class <init>
    implements Runnable
{

    private WeakReference ctxReference;
    boolean isLaunch;
    Map params;
    private String urlString;

    public void run()
    {
        String s1 = AppsFlyerLib.access$300(params);
        Object obj = (Context)ctxReference.get();
        if (obj == null) goto _L2; else goto _L1
_L1:
        String s = AppsFlyerProperties.getInstance().getReferrer(((Context) (obj)));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (s.length() > 0 && params.get("referrer") == null)
        {
            params.put("referrer", s);
        }
        Map map;
        boolean flag1;
        flag1 = "true".equals(((Context) (obj)).getSharedPreferences("appsflyer-data", 0).getString("sentSuccessfully", ""));
        s = (String)params.get("eventName");
        map = params;
        Object obj1;
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map.put("counter", Integer.toString(AppsFlyerLib.access$400(((Context) (obj)), flag)));
        map = params;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        map.put("iaecounter", Integer.toString(AppsFlyerLib.access$500(((Context) (obj)), flag)));
        flag = flag1;
_L5:
        obj = params;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Map) (obj)).put("isFirstCall", Boolean.toString(flag));
        s = (String)params.get("appsflyerKey");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        if (s.length() != 0)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        Log.d(s1, "Not sending data yet, waiting for dev key");
        return;
        obj = (new HashUtils()).getHashCode(params);
        params.put("af_v", obj);
        obj = AppsFlyerLib.access$600(params);
        try
        {
            AppsFlyerLib.access$700(urlString, ((String) (obj)), s, ctxReference, null, s1, isLaunch);
            return;
        }
        catch (IOException ioexception)
        {
            s = ((String) (obj));
            obj1 = ioexception;
        }
_L3:
        if (s != null && ctxReference != null && !urlString.contains("&isCachedRequest=true"))
        {
            Log.e(s1, ((IOException) (obj1)).getMessage(), ((Throwable) (obj1)));
            CacheManager.getInstance().cacheRequest(new RequestCacheData(urlString, s, "1.17"), (Context)ctxReference.get());
            return;
        } else
        {
            return;
        }
        obj1;
        Log.e(s1, ((Throwable) (obj1)).getMessage(), ((Throwable) (obj1)));
        return;
        obj1;
        s = null;
          goto _L3
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private (String s, Map map, Context context, boolean flag)
    {
        ctxReference = null;
        urlString = s;
        params = map;
        ctxReference = new WeakReference(context);
        isLaunch = flag;
    }

    isLaunch(String s, Map map, Context context, boolean flag, isLaunch islaunch)
    {
        this(s, map, context, flag);
    }
}
