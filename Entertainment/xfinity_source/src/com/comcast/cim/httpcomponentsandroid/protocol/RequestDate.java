// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
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
        if (httprequest == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null.");
        }
        if ((httprequest instanceof HttpEntityEnclosingRequest) && !httprequest.containsHeader("Date"))
        {
            httprequest.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        }
    }

}
