// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import atz;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.adobe.mobile:
//            WearableDataRequest, RequestHandler

class body extends WearableDataRequest
{

    private static final Object _userAgentMutex = new Object();
    protected static final String logPrefix = "Wearable POST Request Forward";
    private static String userAgent = null;
    protected String body;
    protected String url;

    protected static String getDefaultAcceptLanguage(Context context)
    {
        if (context != null)
        {
            if ((context = context.getResources()) != null && (context = context.getConfiguration()) != null && (context = ((Configuration) (context)).locale) != null)
            {
                return context.toString().replace('_', '-');
            }
        }
        return null;
    }

    protected static String getDefaultUserAgent(Context context)
    {
        synchronized (_userAgentMutex)
        {
            if (userAgent == null)
            {
                userAgent = (new StringBuilder()).append("Mozilla/5.0 (Linux; U; Android ").append(android.os..Post.userAgent).append("; ").append(getDefaultAcceptLanguage(context)).append("; ").append(Build.MODEL).append(" Build/").append(Build.ID).append(")").toString();
            }
            context = userAgent;
        }
        return context;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    protected atz getDataMap()
    {
        atz atz1 = new atz();
        atz1.a("ID", uuid);
        atz1.a("Type", "POST");
        atz1.a("URL", url);
        atz1.a("Timeout", timeOut);
        atz1.a("Body", body);
        return atz1;
    }

    protected String getURL()
    {
        return url;
    }

    protected atz handle(Context context)
    {
        atz atz1 = new atz();
        HashMap hashmap = new HashMap();
        hashmap.put("Accept-Language", getDefaultAcceptLanguage(context));
        hashmap.put("User-Agent", getDefaultUserAgent(context));
        atz1.a("Result", RequestHandler.sendAnalyticsRequest(url, body, hashmap, timeOut, "Wearable POST Request Forward"));
        atz1.a("ID", uuid);
        atz1.a("Type", "POST");
        return atz1;
    }


    protected ()
    {
    }

    protected (atz atz1)
    {
        timeOut = atz1.d("Timeout");
        url = atz1.f("URL");
        body = atz1.f("Body");
        uuid = atz1.f("ID");
    }

    protected uuid(String s, String s1, int i)
    {
        super(i);
        url = s;
        body = s1;
    }
}
