// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.a;
import com.a.a.m;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

// Referenced classes of package com.a.a.a:
//            f

public class g
    implements f
{
    public static interface a
    {

        public abstract String a(String s);
    }


    private final a a;
    private final SSLSocketFactory b;

    public g()
    {
        this(null);
    }

    public g(a a1)
    {
        this(a1, null);
    }

    public g(a a1, SSLSocketFactory sslsocketfactory)
    {
        a = a1;
        b = sslsocketfactory;
    }

    private HttpURLConnection a(URL url, m m1)
        throws IOException
    {
        HttpURLConnection httpurlconnection = a(url);
        int i = m1.getTimeoutMs();
        httpurlconnection.setConnectTimeout(i);
        httpurlconnection.setReadTimeout(i);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && b != null)
        {
            ((HttpsURLConnection)httpurlconnection).setSSLSocketFactory(b);
        }
        return httpurlconnection;
    }

    private static HttpEntity a(HttpURLConnection httpurlconnection)
    {
        BasicHttpEntity basichttpentity = new BasicHttpEntity();
        java.io.InputStream inputstream;
        try
        {
            inputstream = httpurlconnection.getInputStream();
        }
        catch (IOException ioexception)
        {
            ioexception = httpurlconnection.getErrorStream();
        }
        basichttpentity.setContent(inputstream);
        basichttpentity.setContentLength(httpurlconnection.getContentLength());
        basichttpentity.setContentEncoding(httpurlconnection.getContentEncoding());
        basichttpentity.setContentType(httpurlconnection.getContentType());
        return basichttpentity;
    }

    static void a(HttpURLConnection httpurlconnection, m m1)
        throws IOException, com.a.a.a
    {
        switch (m1.getMethod())
        {
        default:
            throw new IllegalStateException("Unknown method type.");

        case -1: 
            byte abyte0[] = m1.getPostBody();
            if (abyte0 != null)
            {
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.addRequestProperty("Content-Type", m1.getPostBodyContentType());
                httpurlconnection = new DataOutputStream(httpurlconnection.getOutputStream());
                httpurlconnection.write(abyte0);
                httpurlconnection.close();
            }
            return;

        case 0: // '\0'
            httpurlconnection.setRequestMethod("GET");
            return;

        case 3: // '\003'
            httpurlconnection.setRequestMethod("DELETE");
            return;

        case 1: // '\001'
            httpurlconnection.setRequestMethod("POST");
            b(httpurlconnection, m1);
            return;

        case 2: // '\002'
            httpurlconnection.setRequestMethod("PUT");
            b(httpurlconnection, m1);
            return;

        case 4: // '\004'
            httpurlconnection.setRequestMethod("HEAD");
            return;

        case 5: // '\005'
            httpurlconnection.setRequestMethod("OPTIONS");
            return;

        case 6: // '\006'
            httpurlconnection.setRequestMethod("TRACE");
            return;

        case 7: // '\007'
            httpurlconnection.setRequestMethod("PATCH");
            b(httpurlconnection, m1);
            return;
        }
    }

    private static void b(HttpURLConnection httpurlconnection, m m1)
        throws IOException, com.a.a.a
    {
        byte abyte0[] = m1.getBody();
        if (abyte0 != null)
        {
            httpurlconnection.setDoOutput(true);
            httpurlconnection.addRequestProperty("Content-Type", m1.getBodyContentType());
            httpurlconnection = new DataOutputStream(httpurlconnection.getOutputStream());
            httpurlconnection.write(abyte0);
            httpurlconnection.close();
        }
    }

    protected HttpURLConnection a(URL url)
        throws IOException
    {
        return (HttpURLConnection)HttpInstrumentation.openConnection(url.openConnection());
    }

    public HttpResponse a(m m1, Map map)
        throws IOException, com.a.a.a
    {
        String s = m1.getUrl();
        HashMap hashmap = new HashMap();
        hashmap.putAll(m1.getHeaders());
        hashmap.putAll(map);
        if (a != null)
        {
            String s1 = a.a(s);
            map = s1;
            if (s1 == null)
            {
                throw new IOException((new StringBuilder()).append("URL blocked by rewriter: ").append(s).toString());
            }
        } else
        {
            map = s;
        }
        map = a(new URL(map), m1);
        String s2;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); map.addRequestProperty(s2, (String)hashmap.get(s2)))
        {
            s2 = (String)iterator.next();
        }

        a(((HttpURLConnection) (map)), m1);
        m1 = new ProtocolVersion("HTTP", 1, 1);
        if (map.getResponseCode() == -1)
        {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        m1 = new BasicHttpResponse(new BasicStatusLine(m1, map.getResponseCode(), map.getResponseMessage()));
        m1.setEntity(a(((HttpURLConnection) (map))));
        map = map.getHeaderFields().entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (entry.getKey() != null)
            {
                m1.addHeader(new BasicHeader((String)entry.getKey(), (String)((List)entry.getValue()).get(0)));
            }
        } while (true);
        return m1;
    }
}
