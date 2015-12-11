// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.Context;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

// Referenced classes of package org.chromium.net:
//            HttpUrlRequestFactory, HttpUrlConnectionUrlRequest, Version, HttpUrlRequestListener, 
//            HttpUrlRequest

class HttpUrlConnectionUrlRequestFactory extends HttpUrlRequestFactory
{

    private final Context a;

    public HttpUrlConnectionUrlRequestFactory(Context context)
    {
        a = context.getApplicationContext();
    }

    public final HttpUrlRequest a(String s, int i, Map map, WritableByteChannel writablebytechannel, HttpUrlRequestListener httpurlrequestlistener)
    {
        return new HttpUrlConnectionUrlRequest(a, s, map, writablebytechannel, httpurlrequestlistener);
    }

    public final boolean a()
    {
        return true;
    }

    public final String b()
    {
        return (new StringBuilder("HttpUrlConnection/")).append(Version.a()).toString();
    }
}
