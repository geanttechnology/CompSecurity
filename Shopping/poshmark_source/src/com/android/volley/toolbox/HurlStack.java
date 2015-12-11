// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
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
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

// Referenced classes of package com.android.volley.toolbox:
//            HttpStack

public class HurlStack
    implements HttpStack
{
    public static interface UrlRewriter
    {

        public abstract String rewriteUrl(String s);
    }


    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    public HurlStack()
    {
        this(null);
    }

    public HurlStack(UrlRewriter urlrewriter)
    {
        this(urlrewriter, null);
    }

    public HurlStack(UrlRewriter urlrewriter, SSLSocketFactory sslsocketfactory)
    {
        mUrlRewriter = urlrewriter;
        mSslSocketFactory = sslsocketfactory;
    }

    private static void addBodyIfExists(HttpURLConnection httpurlconnection, Request request)
        throws IOException, AuthFailureError
    {
        byte abyte0[] = request.getBody();
        if (abyte0 != null)
        {
            httpurlconnection.setDoOutput(true);
            httpurlconnection.addRequestProperty("Content-Type", request.getBodyContentType());
            httpurlconnection = new DataOutputStream(httpurlconnection.getOutputStream());
            httpurlconnection.write(abyte0);
            httpurlconnection.close();
        }
    }

    private static HttpEntity entityFromConnection(HttpURLConnection httpurlconnection)
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

    private static boolean hasResponseBody(int i, int j)
    {
        return i != 4 && (100 > j || j >= 200) && j != 204 && j != 304;
    }

    private HttpURLConnection openConnection(URL url, Request request)
        throws IOException
    {
        HttpURLConnection httpurlconnection = createConnection(url);
        int i = request.getTimeoutMs();
        httpurlconnection.setConnectTimeout(i);
        httpurlconnection.setReadTimeout(i);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && mSslSocketFactory != null)
        {
            ((HttpsURLConnection)httpurlconnection).setSSLSocketFactory(mSslSocketFactory);
        }
        return httpurlconnection;
    }

    static void setConnectionParametersForRequest(HttpURLConnection httpurlconnection, Request request)
        throws IOException, AuthFailureError
    {
        switch (request.getMethod())
        {
        default:
            throw new IllegalStateException("Unknown method type.");

        case -1: 
            byte abyte0[] = request.getPostBody();
            if (abyte0 != null)
            {
                httpurlconnection.setDoOutput(true);
                httpurlconnection.setRequestMethod("POST");
                httpurlconnection.addRequestProperty("Content-Type", request.getPostBodyContentType());
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
            addBodyIfExists(httpurlconnection, request);
            return;

        case 2: // '\002'
            httpurlconnection.setRequestMethod("PUT");
            addBodyIfExists(httpurlconnection, request);
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
            addBodyIfExists(httpurlconnection, request);
            return;
        }
    }

    protected HttpURLConnection createConnection(URL url)
        throws IOException
    {
        return (HttpURLConnection)HttpInstrumentation.openConnection(url.openConnection());
    }

    public HttpResponse performRequest(Request request, Map map)
        throws IOException, AuthFailureError
    {
        Object obj = request.getUrl();
        Object obj1 = new HashMap();
        ((HashMap) (obj1)).putAll(request.getHeaders());
        ((HashMap) (obj1)).putAll(map);
        map = ((Map) (obj));
        if (mUrlRewriter != null)
        {
            map = mUrlRewriter.rewriteUrl(((String) (obj)));
            if (map == null)
            {
                throw new IOException((new StringBuilder()).append("URL blocked by rewriter: ").append(((String) (obj))).toString());
            }
        }
        map = openConnection(new URL(map), request);
        String s;
        for (obj = ((HashMap) (obj1)).keySet().iterator(); ((Iterator) (obj)).hasNext(); map.addRequestProperty(s, (String)((HashMap) (obj1)).get(s)))
        {
            s = (String)((Iterator) (obj)).next();
        }

        setConnectionParametersForRequest(map, request);
        obj = new ProtocolVersion("HTTP", 1, 1);
        if (map.getResponseCode() == -1)
        {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        obj1 = new BasicStatusLine(((ProtocolVersion) (obj)), map.getResponseCode(), map.getResponseMessage());
        obj = new BasicHttpResponse(((StatusLine) (obj1)));
        if (hasResponseBody(request.getMethod(), ((StatusLine) (obj1)).getStatusCode()))
        {
            ((BasicHttpResponse) (obj)).setEntity(entityFromConnection(map));
        }
        request = map.getHeaderFields().entrySet().iterator();
        do
        {
            if (!request.hasNext())
            {
                break;
            }
            map = (java.util.Map.Entry)request.next();
            if (map.getKey() != null)
            {
                ((BasicHttpResponse) (obj)).addHeader(new BasicHeader((String)map.getKey(), (String)((List)map.getValue()).get(0)));
            }
        } while (true);
        return ((HttpResponse) (obj));
    }
}
