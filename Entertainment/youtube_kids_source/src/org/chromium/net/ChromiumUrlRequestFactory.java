// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import java.nio.channels.WritableByteChannel;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package org.chromium.net:
//            HttpUrlRequestFactory, UrlRequestContextConfig, ChromiumUrlRequestContext, UserAgent, 
//            ChromiumUrlRequest, HttpUrlRequestListener, HttpUrlRequest

public class ChromiumUrlRequestFactory extends HttpUrlRequestFactory
{

    private ChromiumUrlRequestContext a;

    public ChromiumUrlRequestFactory(Context context, UrlRequestContextConfig urlrequestcontextconfig)
    {
        if (a())
        {
            System.loadLibrary(urlrequestcontextconfig.a.optString("NATIVE_LIBRARY_NAME", "cronet"));
            a = new ChromiumUrlRequestContext(context.getApplicationContext(), UserAgent.a(context), urlrequestcontextconfig.toString());
        }
    }

    public final HttpUrlRequest a(String s, int i, Map map, WritableByteChannel writablebytechannel, HttpUrlRequestListener httpurlrequestlistener)
    {
        return new ChromiumUrlRequest(a, s, 3, map, writablebytechannel, httpurlrequestlistener);
    }

    public final boolean a()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    public final String b()
    {
        return (new StringBuilder("Chromium/")).append(ChromiumUrlRequestContext.a()).toString();
    }
}
