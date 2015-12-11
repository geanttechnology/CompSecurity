// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

public class BasicResponseHandler
    implements ResponseHandler
{

    public BasicResponseHandler()
    {
    }

    public volatile Object handleResponse(HttpResponse httpresponse)
        throws ClientProtocolException, IOException
    {
        return handleResponse(httpresponse);
    }

    public String handleResponse(HttpResponse httpresponse)
        throws HttpResponseException, IOException
    {
        StatusLine statusline = httpresponse.getStatusLine();
        httpresponse = httpresponse.getEntity();
        if (statusline.getStatusCode() >= 300)
        {
            EntityUtils.consume(httpresponse);
            throw new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase());
        }
        if (httpresponse == null)
        {
            return null;
        } else
        {
            return EntityUtils.toString(httpresponse);
        }
    }
}
