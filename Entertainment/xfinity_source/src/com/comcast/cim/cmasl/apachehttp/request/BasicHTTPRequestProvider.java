// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.request;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.NameValuePair;
import com.comcast.cim.httpcomponentsandroid.client.entity.UrlEncodedFormEntity;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpDelete;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpGet;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpPost;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpPut;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.client.utils.URIUtils;
import com.comcast.cim.httpcomponentsandroid.client.utils.URLEncodedUtils;
import com.comcast.cim.httpcomponentsandroid.message.BasicNameValuePair;
import com.comcast.cim.httpcomponentsandroid.params.HttpConnectionParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicHTTPRequestProvider
    implements RequestProvider
{

    private final List headers;
    private final List httpEntityParams;
    private String method;
    private final List queryParams;
    private Long socketTimeoutInMillis;
    private URI uri;

    public BasicHTTPRequestProvider(String s)
    {
        this(URI.create(s));
    }

    public BasicHTTPRequestProvider(String s, String s1)
    {
        this(URI.create(s), s1);
    }

    public BasicHTTPRequestProvider(URI uri1)
    {
        this(uri1, null);
    }

    public BasicHTTPRequestProvider(URI uri1, String s)
    {
        queryParams = new ArrayList(10);
        httpEntityParams = new ArrayList(10);
        headers = new ArrayList(10);
        uri = uri1;
        uri1 = s;
        if (s == null)
        {
            uri1 = "GET";
        }
        method = uri1;
    }

    private void addEntityParamsToRequest(HttpEntityEnclosingRequest httpentityenclosingrequest, List list)
    {
        try
        {
            httpentityenclosingrequest.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntityEnclosingRequest httpentityenclosingrequest)
        {
            throw new CimException(httpentityenclosingrequest);
        }
    }

    public void addHeader(String s, String s1)
    {
        headers.add(new BasicNameValuePair(s, s1));
    }

    public void addHttpEntityParameter(String s, String s1)
    {
        httpEntityParams.add(new BasicNameValuePair(s, s1));
    }

    public void addQueryParameter(String s, String s1)
    {
        queryParams.add(new BasicNameValuePair(s, s1));
    }

    public HttpUriRequest createRequest()
    {
        Object obj;
        obj = new ArrayList();
        ((List) (obj)).addAll(URLEncodedUtils.parse(uri, "UTF-8"));
        ((List) (obj)).addAll(queryParams);
        if (!((List) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_215;
        }
        obj = null;
_L1:
        try
        {
            uri = URIUtils.createURI(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), ((String) (obj)), uri.getFragment());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new CimException(((Throwable) (obj)));
        }
        if (method.equals("POST"))
        {
            obj = new HttpPost(uri);
            addEntityParamsToRequest(((HttpEntityEnclosingRequest) (obj)), httpEntityParams);
            onHttpEntityEnclosingRequestCreated(((HttpEntityEnclosingRequest) (obj)));
        } else
        if (method.equals("PUT"))
        {
            obj = new HttpPut(uri);
            addEntityParamsToRequest(((HttpEntityEnclosingRequest) (obj)), httpEntityParams);
            onHttpEntityEnclosingRequestCreated(((HttpEntityEnclosingRequest) (obj)));
        } else
        if (method.equals("DELETE"))
        {
            obj = new HttpDelete(uri);
        } else
        {
            obj = new HttpGet(uri);
        }
        ((HttpUriRequest) (obj)).getParams().setBooleanParameter("http.protocol.expect-continue", false);
        if (socketTimeoutInMillis != null)
        {
            HttpConnectionParams.setSoTimeout(((HttpUriRequest) (obj)).getParams(), socketTimeoutInMillis.intValue());
        }
        NameValuePair namevaluepair;
        for (Iterator iterator = headers.iterator(); iterator.hasNext(); ((HttpUriRequest) (obj)).addHeader(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)iterator.next();
        }

        break MISSING_BLOCK_LABEL_318;
        obj = URLEncodedUtils.format(((List) (obj)), "UTF-8");
          goto _L1
        return ((HttpUriRequest) (obj));
    }

    public volatile Object createRequest()
    {
        return createRequest();
    }

    protected void onHttpEntityEnclosingRequestCreated(HttpEntityEnclosingRequest httpentityenclosingrequest)
    {
    }

    public void setSocketTimeout(long l)
    {
        socketTimeoutInMillis = Long.valueOf(l);
    }
}
