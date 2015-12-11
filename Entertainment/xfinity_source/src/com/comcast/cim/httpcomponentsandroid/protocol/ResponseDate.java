// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
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
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP response may not be null.");
        }
        if (httpresponse.getStatusLine().getStatusCode() >= 200 && !httpresponse.containsHeader("Date"))
        {
            httpresponse.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        }
    }

}
