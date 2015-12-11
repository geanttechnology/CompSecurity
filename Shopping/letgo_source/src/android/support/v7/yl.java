// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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

// Referenced classes of package android.support.v7:
//            yk, ve, lo

public class yl
    implements yk
{
    public static interface a
    {

        public abstract String a(String s);
    }


    private final a a;
    private final SSLSocketFactory b;

    public yl()
    {
        this(null);
    }

    public yl(a a1)
    {
        this(a1, null);
    }

    public yl(a a1, SSLSocketFactory sslsocketfactory)
    {
        a = a1;
        b = sslsocketfactory;
    }

    private HttpURLConnection a(URL url, ve ve1)
        throws IOException
    {
        HttpURLConnection httpurlconnection = a(url);
        int i = ve1.r();
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

    static void a(HttpURLConnection httpurlconnection, ve ve1)
        throws IOException, lo
    {
        switch (ve1.b())
        {
        default:
            throw new IllegalStateException("Unknown method type.");

        case -1: 
            byte abyte0[] = ve1.k();
            if (abyte0 != null)
            {
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.addRequestProperty("Content-Type", ve1.j());
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
            b(httpurlconnection, ve1);
            return;

        case 2: // '\002'
            httpurlconnection.setRequestMethod("PUT");
            b(httpurlconnection, ve1);
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
            b(httpurlconnection, ve1);
            return;
        }
    }

    private static void b(HttpURLConnection httpurlconnection, ve ve1)
        throws IOException, lo
    {
        byte abyte0[] = ve1.o();
        if (abyte0 != null)
        {
            httpurlconnection.setDoOutput(true);
            httpurlconnection.addRequestProperty("Content-Type", ve1.n());
            httpurlconnection = new DataOutputStream(httpurlconnection.getOutputStream());
            httpurlconnection.write(abyte0);
            httpurlconnection.close();
        }
    }

    protected HttpURLConnection a(URL url)
        throws IOException
    {
        return (HttpURLConnection)url.openConnection();
    }

    public HttpResponse a(ve ve1, Map map)
        throws IOException, lo
    {
        String s = ve1.d();
        HashMap hashmap = new HashMap();
        hashmap.putAll(ve1.a());
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
        map = a(new URL(map), ve1);
        String s2;
        for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); map.addRequestProperty(s2, (String)hashmap.get(s2)))
        {
            s2 = (String)iterator.next();
        }

        a(((HttpURLConnection) (map)), ve1);
        ve1 = new ProtocolVersion("HTTP", 1, 1);
        if (map.getResponseCode() == -1)
        {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        ve1 = new BasicHttpResponse(new BasicStatusLine(ve1, map.getResponseCode(), map.getResponseMessage()));
        ve1.setEntity(a(((HttpURLConnection) (map))));
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
                ve1.addHeader(new BasicHeader((String)entry.getKey(), (String)((List)entry.getValue()).get(0)));
            }
        } while (true);
        return ve1;
    }
}
