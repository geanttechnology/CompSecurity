// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse.signpost.commonshttp;

import com.parse.signpost.AbstractOAuthProvider;
import com.parse.signpost.http.HttpRequest;
import com.parse.signpost.http.HttpResponse;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.parse.signpost.commonshttp:
//            HttpRequestAdapter, HttpResponseAdapter

public class CommonsHttpOAuthProvider extends AbstractOAuthProvider
{

    private static final long serialVersionUID = 1L;
    private transient HttpClient httpClient;

    public CommonsHttpOAuthProvider(String s, String s1, String s2)
    {
        super(s, s1, s2);
        httpClient = new DefaultHttpClient();
    }

    public CommonsHttpOAuthProvider(String s, String s1, String s2, HttpClient httpclient)
    {
        super(s, s1, s2);
        httpClient = httpclient;
    }

    protected void closeConnection(HttpRequest httprequest, HttpResponse httpresponse)
        throws Exception
    {
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        httprequest = ((org.apache.http.HttpResponse)httpresponse.unwrap()).getEntity();
        if (httprequest == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        httprequest.consumeContent();
        return;
        httprequest;
        httprequest.printStackTrace();
        return;
    }

    protected HttpRequest createRequest(String s)
        throws Exception
    {
        return new HttpRequestAdapter(new HttpPost(s));
    }

    protected HttpResponse sendRequest(HttpRequest httprequest)
        throws Exception
    {
        return new HttpResponseAdapter(httpClient.execute((HttpUriRequest)httprequest.unwrap()));
    }

    public void setHttpClient(HttpClient httpclient)
    {
        httpClient = httpclient;
    }
}
