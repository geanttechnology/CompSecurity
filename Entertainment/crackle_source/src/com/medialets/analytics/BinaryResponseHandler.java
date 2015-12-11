// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class BinaryResponseHandler
    implements ResponseHandler
{

    public BinaryResponseHandler()
    {
    }

    public volatile Object handleResponse(HttpResponse httpresponse)
        throws ClientProtocolException, IOException
    {
        return handleResponse(httpresponse);
    }

    public byte[] handleResponse(HttpResponse httpresponse)
        throws HttpResponseException, IOException
    {
        StatusLine statusline = httpresponse.getStatusLine();
        if (statusline.getStatusCode() >= 300)
        {
            throw new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase());
        }
        httpresponse = httpresponse.getEntity();
        if (httpresponse == null)
        {
            return null;
        } else
        {
            return EntityUtils.toByteArray(httpresponse);
        }
    }
}
