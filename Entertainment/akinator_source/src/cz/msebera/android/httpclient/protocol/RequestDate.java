// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpDateGenerator, HttpContext

public class RequestDate
    implements HttpRequestInterceptor
{

    private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();

    public RequestDate()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        if ((httprequest instanceof HttpEntityEnclosingRequest) && !httprequest.containsHeader("Date"))
        {
            httprequest.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        }
    }

}
