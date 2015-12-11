// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpResponseInterceptor;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.protocol:
//            HttpProcessor, HttpContext

public final class ImmutableHttpProcessor
    implements HttpProcessor
{

    private final HttpRequestInterceptor requestInterceptors[];
    private final HttpResponseInterceptor responseInterceptors[];

    public ImmutableHttpProcessor(HttpRequestInterceptor ahttprequestinterceptor[], HttpResponseInterceptor ahttpresponseinterceptor[])
    {
        if (ahttprequestinterceptor != null)
        {
            int k = ahttprequestinterceptor.length;
            requestInterceptors = new HttpRequestInterceptor[k];
            for (int i = 0; i < k; i++)
            {
                requestInterceptors[i] = ahttprequestinterceptor[i];
            }

        } else
        {
            requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (ahttpresponseinterceptor != null)
        {
            int l = ahttpresponseinterceptor.length;
            responseInterceptors = new HttpResponseInterceptor[l];
            for (int j = 0; j < l; j++)
            {
                responseInterceptors[j] = ahttpresponseinterceptor[j];
            }

        } else
        {
            responseInterceptors = new HttpResponseInterceptor[0];
        }
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, HttpException
    {
        for (int i = 0; i < requestInterceptors.length; i++)
        {
            requestInterceptors[i].process(httprequest, httpcontext);
        }

    }

    public void process(HttpResponse httpresponse, HttpContext httpcontext)
        throws IOException, HttpException
    {
        for (int i = 0; i < responseInterceptors.length; i++)
        {
            responseInterceptors[i].process(httpresponse, httpcontext);
        }

    }
}
