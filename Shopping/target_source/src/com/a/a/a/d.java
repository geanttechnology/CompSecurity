// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.a;
import com.a.a.m;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.a.a.a:
//            f

public class d
    implements f
{
    public static final class a extends HttpEntityEnclosingRequestBase
    {

        public String getMethod()
        {
            return "PATCH";
        }

        public a()
        {
        }

        public a(String s)
        {
            setURI(URI.create(s));
        }
    }


    protected final HttpClient a;

    public d(HttpClient httpclient)
    {
        a = httpclient;
    }

    private static void a(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase, m m1)
        throws com.a.a.a
    {
        m1 = m1.getBody();
        if (m1 != null)
        {
            httpentityenclosingrequestbase.setEntity(new ByteArrayEntity(m1));
        }
    }

    private static void a(HttpUriRequest httpurirequest, Map map)
    {
        String s;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); httpurirequest.setHeader(s, (String)map.get(s)))
        {
            s = (String)iterator.next();
        }

    }

    static HttpUriRequest b(m m1, Map map)
        throws com.a.a.a
    {
        switch (m1.getMethod())
        {
        default:
            throw new IllegalStateException("Unknown request method.");

        case -1: 
            map = m1.getPostBody();
            if (map != null)
            {
                HttpPost httppost = new HttpPost(m1.getUrl());
                httppost.addHeader("Content-Type", m1.getPostBodyContentType());
                httppost.setEntity(new ByteArrayEntity(map));
                return httppost;
            } else
            {
                return new HttpGet(m1.getUrl());
            }

        case 0: // '\0'
            return new HttpGet(m1.getUrl());

        case 3: // '\003'
            return new HttpDelete(m1.getUrl());

        case 1: // '\001'
            map = new HttpPost(m1.getUrl());
            map.addHeader("Content-Type", m1.getBodyContentType());
            a(map, m1);
            return map;

        case 2: // '\002'
            map = new HttpPut(m1.getUrl());
            map.addHeader("Content-Type", m1.getBodyContentType());
            a(map, m1);
            return map;

        case 4: // '\004'
            return new HttpHead(m1.getUrl());

        case 5: // '\005'
            return new HttpOptions(m1.getUrl());

        case 6: // '\006'
            return new HttpTrace(m1.getUrl());

        case 7: // '\007'
            map = new a(m1.getUrl());
            map.addHeader("Content-Type", m1.getBodyContentType());
            a(map, m1);
            return map;
        }
    }

    public HttpResponse a(m m1, Map map)
        throws IOException, com.a.a.a
    {
        HttpUriRequest httpurirequest = b(m1, map);
        a(httpurirequest, map);
        a(httpurirequest, m1.getHeaders());
        a(httpurirequest);
        map = httpurirequest.getParams();
        int i = m1.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(map, 5000);
        HttpConnectionParams.setSoTimeout(map, i);
        m1 = a;
        if (!(m1 instanceof HttpClient))
        {
            return m1.execute(httpurirequest);
        } else
        {
            return HttpInstrumentation.execute((HttpClient)m1, httpurirequest);
        }
    }

    protected void a(HttpUriRequest httpurirequest)
        throws IOException
    {
    }
}
