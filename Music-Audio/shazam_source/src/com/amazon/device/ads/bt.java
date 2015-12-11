// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.amazon.device.ads:
//            dy, cn

class bt extends dy
{

    private static final String s = com/amazon/device/ads/bt.getSimpleName();
    private HttpClient t;

    bt()
    {
    }

    private dy.g a(HttpResponse httpresponse)
    {
        dy.g g = new dy.g(this);
        g.a = httpresponse.getStatusLine().getStatusCode();
        g.b = httpresponse.getStatusLine().getReasonPhrase();
        if (g.a == 200)
        {
            httpresponse = httpresponse.getEntity();
            if (httpresponse != null && httpresponse.getContentLength() != 0L)
            {
                try
                {
                    g.a(httpresponse.getContent());
                }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse)
                {
                    super.r.d("IOException while reading the input stream from response: %s", new Object[] {
                        httpresponse.getMessage()
                    });
                    throw new dy.c(this, dy.f.a, "IOException while reading the input stream from response", httpresponse);
                }
            }
        }
        return g;
    }

    private void a(HttpPost httppost)
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (Iterator iterator = l.entrySet().iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        try
        {
            httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpPost httppost)
        {
            super.r.d("Unsupported character encoding used while creating the request: %s", new Object[] {
                httppost.getMessage()
            });
        }
        throw new dy.c(this, dy.f.e, "Unsupported character encoding used while creating the request", httppost);
    }

    private HttpRequestBase b(URL url)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[dy.a.values().length];
                try
                {
                    a[dy.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[dy.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        URI uri;
        try
        {
            uri = url.toURI();
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Problem with URI syntax: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.c, "Problem with URI syntax", url);
        }
        _cls1.a[super.f.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 161
    //                   2 174;
           goto _L1 _L2 _L3
_L1:
        url = null;
_L5:
        Iterator iterator = j.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (entry.getValue() != null && !((String)entry.getValue()).equals(""))
            {
                url.addHeader((String)entry.getKey(), (String)entry.getValue());
            }
        } while (true);
        break; /* Loop/switch isn't completed */
_L2:
        url = new HttpGet(uri);
        continue; /* Loop/switch isn't completed */
_L3:
        url = new HttpPost(uri);
        HttpPost httppost = (HttpPost)url;
        String s1 = d;
        Object obj = s1;
        if (s1 == null)
        {
            obj = "UTF-8";
        }
        String s2 = c;
        s1 = s2;
        if (s2 == null)
        {
            s1 = "text/plain";
        }
        if (a != null)
        {
            try
            {
                obj = new StringEntity(a, ((String) (obj)));
                ((StringEntity) (obj)).setContentType(s1);
                httppost.setEntity(((HttpEntity) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (URL url)
            {
                super.r.d("Unsupported character encoding used while creating the request. ", new Object[] {
                    url.getMessage()
                });
                throw new dy.c(this, dy.f.e, "Unsupported character encoding used while creating the request.", url);
            }
        } else
        {
            a(httppost);
        }
        if (true) goto _L5; else goto _L4
_L4:
        a(uri.toString());
        if (m && g() != null)
        {
            super.r.b("Request Body: %s", new Object[] {
                g()
            });
        }
        return url;
    }

    protected final dy.g a(URL url)
    {
        url = b(url);
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, super.g);
        HttpConnectionParams.setSoTimeout(basichttpparams, super.g);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        if (t != null)
        {
            a();
        }
        t = new DefaultHttpClient(basichttpparams);
        try
        {
            url = t.execute(url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("Invalid client protocol: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.d, "Invalid client protocol", url);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            super.r.d("IOException during client execution: %s", new Object[] {
                url.getMessage()
            });
            throw new dy.c(this, dy.f.a, "IOException during client execution", url);
        }
        return a(((HttpResponse) (url)));
    }

    protected final void a()
    {
        if (t != null)
        {
            t.getConnectionManager().closeIdleConnections(0L, TimeUnit.MILLISECONDS);
            t.getConnectionManager().closeExpiredConnections();
            t = null;
        }
    }

    protected final String b()
    {
        return s;
    }

}
