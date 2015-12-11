// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpContext

public class ResponseServer
    implements HttpResponseInterceptor
{

    public ResponseServer()
    {
    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (!httpresponse.containsHeader("Server"))
        {
            httpcontext = (String)httpresponse.getParams().getParameter("http.origin-server");
            if (httpcontext != null)
            {
                httpresponse.addHeader("Server", httpcontext);
            }
        }
    }
}
