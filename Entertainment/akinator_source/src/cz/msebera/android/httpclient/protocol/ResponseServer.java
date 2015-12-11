// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpContext

public class ResponseServer
    implements HttpResponseInterceptor
{

    private final String originServer;

    public ResponseServer()
    {
        this(null);
    }

    public ResponseServer(String s)
    {
        originServer = s;
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        if (!httpresponse.containsHeader("Server") && originServer != null)
        {
            httpresponse.addHeader("Server", originServer);
        }
    }
}
