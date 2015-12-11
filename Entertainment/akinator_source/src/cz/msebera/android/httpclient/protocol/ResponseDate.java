// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.protocol:
//            HttpDateGenerator, HttpContext

public class ResponseDate
    implements HttpResponseInterceptor
{

    private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();

    public ResponseDate()
    {
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        if (httpresponse.getStatusLine().getStatusCode() >= 200 && !httpresponse.containsHeader("Date"))
        {
            httpresponse.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        }
    }

}
