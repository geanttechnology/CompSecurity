// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.configuration;

import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.http.HttpClient;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.system.Connectivity;
import com.amazon.insights.core.system.Preferences;
import com.amazon.insights.core.system.System;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.core.configuration:
//            HttpCachingConfiguration

class this._cls0
    implements Runnable
{

    final HttpCachingConfiguration this$0;

    public void run()
    {
        String s = null;
        com.amazon.insights.core.http.ration ration;
        if (!HttpCachingConfiguration.access$000(HttpCachingConfiguration.this).getSystem().getConnectivity().isConnected())
        {
            break MISSING_BLOCK_LABEL_382;
        }
        ration = createHttpRequest();
        Object obj = s;
        if (ration == null) goto _L2; else goto _L1
_L1:
        Integer integer = Integer.valueOf(1);
        obj = integer;
        String s1;
        if (!HttpCachingConfiguration.access$100(HttpCachingConfiguration.this).containsKey("configRequestRetries"))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        s1 = (String)HttpCachingConfiguration.access$100(HttpCachingConfiguration.this).get("configRequestRetries");
        obj = integer;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        obj = Integer.decode(s1);
_L5:
        int i;
        obj = HttpCachingConfiguration.access$300(HttpCachingConfiguration.this).getHttpClient().execute(ration, ((Integer) (obj)));
        i = ((com.amazon.insights.core.http.ration) (obj)).();
        if (i != 200) goto _L4; else goto _L3
_L3:
        obj = new JSONObject(((com.amazon.insights.core.http.) (obj)).onse());
_L2:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        s = ((JSONObject) (obj)).toString();
        if (HttpCachingConfiguration.access$200().isLoggingEnabled(com.amazon.insights.core.log.uration.access._fld200))
        {
            HttpCachingConfiguration.access$200().v((new StringBuilder()).append("AppIntelligence config: ").append(s).toString());
        }
        HttpCachingConfiguration.access$300(HttpCachingConfiguration.this).getSystem().getPreferences().putString("configuration", s);
        HttpCachingConfiguration.access$400(HttpCachingConfiguration.this, ((JSONObject) (obj)));
_L6:
        long l = System.currentTimeMillis();
        setLastSync(l);
        HttpCachingConfiguration.access$500(HttpCachingConfiguration.this).set(false);
        return;
        obj;
        HttpCachingConfiguration.access$200().e(String.format("Could not get the http request retry value", new Object[0]), ((Throwable) (obj)));
        obj = integer;
          goto _L5
        obj;
        HttpCachingConfiguration.access$200().e("There was an error while attempting to sync the configuration", ((Throwable) (obj)));
        HttpCachingConfiguration.access$500(HttpCachingConfiguration.this).set(false);
        return;
        obj;
        HttpCachingConfiguration.access$200().e("error parsing service response", ((Throwable) (obj)));
        obj = s;
          goto _L2
        obj;
        HttpCachingConfiguration.access$500(HttpCachingConfiguration.this).set(false);
        throw obj;
_L4:
        HttpCachingConfiguration.access$200().e((new StringBuilder()).append("service error: ").append(((com.amazon.insights.core.http.ration.access._cls200) (obj)).age()).append("(").append(((com.amazon.insights.core.http.age) (obj)).()).append(")").toString());
        obj = s;
          goto _L2
        HttpCachingConfiguration.access$200().v("Device not connected to sync config");
          goto _L6
    }

    ()
    {
        this$0 = HttpCachingConfiguration.this;
        super();
    }
}
