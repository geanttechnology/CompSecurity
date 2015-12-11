// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.ByteString;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpEngine, Response, RetryableSink, HttpMethod, 
//            Headers, HttpAuthenticator, Request, OkHeaders, 
//            HttpDate

public class HttpURLConnectionImpl extends HttpURLConnection
{
    static final class Retry extends Enum
    {

        private static final Retry $VALUES[];
        public static final Retry DIFFERENT_CONNECTION;
        public static final Retry NONE;
        public static final Retry SAME_CONNECTION;

        public static Retry valueOf(String s)
        {
            return (Retry)Enum.valueOf(com/squareup/okhttp/internal/http/HttpURLConnectionImpl$Retry, s);
        }

        public static Retry[] values()
        {
            return (Retry[])$VALUES.clone();
        }

        static 
        {
            NONE = new Retry("NONE", 0);
            SAME_CONNECTION = new Retry("SAME_CONNECTION", 1);
            DIFFERENT_CONNECTION = new Retry("DIFFERENT_CONNECTION", 2);
            $VALUES = (new Retry[] {
                NONE, SAME_CONNECTION, DIFFERENT_CONNECTION
            });
        }

        private Retry(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int MAX_REDIRECTS = 20;
    final OkHttpClient client;
    private long fixedContentLength;
    Handshake handshake;
    protected HttpEngine httpEngine;
    protected IOException httpEngineFailure;
    private int redirectionCount;
    private Headers.Builder requestHeaders;
    private Route route;

    public HttpURLConnectionImpl(URL url, OkHttpClient okhttpclient)
    {
        super(url);
        requestHeaders = new Headers.Builder();
        fixedContentLength = -1L;
        client = okhttpclient;
    }

    private boolean execute(boolean flag)
        throws IOException
    {
        Handshake handshake1;
        httpEngine.sendRequest();
        route = httpEngine.getRoute();
        if (httpEngine.getConnection() == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        handshake1 = httpEngine.getConnection().getHandshake();
_L1:
        handshake = handshake1;
        if (flag)
        {
            try
            {
                httpEngine.readResponse();
            }
            catch (IOException ioexception)
            {
                HttpEngine httpengine = httpEngine.recover(ioexception);
                if (httpengine != null)
                {
                    httpEngine = httpengine;
                    return false;
                } else
                {
                    httpEngineFailure = ioexception;
                    throw ioexception;
                }
            }
        }
        return true;
        handshake1 = null;
          goto _L1
    }

    private HttpEngine getResponse()
        throws IOException
    {
        initHttpEngine();
        if (httpEngine.hasResponse())
        {
            return httpEngine;
        }
        do
        {
            while (!execute(true)) ;
            Retry retry = processResponseHeaders();
            if (retry == Retry.NONE)
            {
                httpEngine.releaseConnection();
                return httpEngine;
            }
            String s = method;
            com.squareup.okhttp.internal.okio.Sink sink = httpEngine.getRequestBody();
            int i = httpEngine.getResponse().code();
            if (i == 300 || i == 301 || i == 302 || i == 303)
            {
                s = "GET";
                requestHeaders.removeAll("Content-Length");
                sink = null;
            }
            if (sink != null && !(sink instanceof RetryableSink))
            {
                throw new HttpRetryException("Cannot retry streamed HTTP body", i);
            }
            if (retry == Retry.DIFFERENT_CONNECTION)
            {
                httpEngine.releaseConnection();
            }
            httpEngine = newHttpEngine(s, httpEngine.close(), (RetryableSink)sink);
        } while (true);
    }

    private void initHttpEngine()
        throws IOException
    {
        if (httpEngineFailure != null)
        {
            throw httpEngineFailure;
        }
        if (httpEngine != null)
        {
            return;
        }
        connected = true;
        if (!doOutput) goto _L2; else goto _L1
_L1:
        if (!method.equals("GET")) goto _L4; else goto _L3
_L3:
        method = "POST";
_L2:
        httpEngine = newHttpEngine(method, null, null);
        return;
        IOException ioexception;
        ioexception;
        httpEngineFailure = ioexception;
        throw ioexception;
_L4:
        if (HttpMethod.hasRequestBody(method)) goto _L2; else goto _L5
_L5:
        throw new ProtocolException((new StringBuilder()).append(method).append(" does not support writing").toString());
    }

    private HttpEngine newHttpEngine(String s, Connection connection, RetryableSink retryablesink)
    {
        Object obj = (new Request.Builder()).url(getURL()).method(s, null);
        Object obj1 = requestHeaders.build();
        for (int i = 0; i < ((Headers) (obj1)).size(); i++)
        {
            ((Request.Builder) (obj)).addHeader(((Headers) (obj1)).name(i), ((Headers) (obj1)).value(i));
        }

        boolean flag1 = false;
        boolean flag = flag1;
        if (HttpMethod.hasRequestBody(s))
        {
            if (fixedContentLength != -1L)
            {
                ((Request.Builder) (obj)).header("Content-Length", Long.toString(fixedContentLength));
                flag = flag1;
            } else
            if (chunkLength > 0)
            {
                ((Request.Builder) (obj)).header("Transfer-Encoding", "chunked");
                flag = flag1;
            } else
            {
                flag = true;
            }
        }
        obj1 = ((Request.Builder) (obj)).build();
        obj = client;
        s = ((String) (obj));
        if (((OkHttpClient) (obj)).getOkResponseCache() != null)
        {
            s = ((String) (obj));
            if (!getUseCaches())
            {
                s = client.clone().setOkResponseCache(null);
            }
        }
        return new HttpEngine(s, ((Request) (obj1)), flag, connection, null, retryablesink);
    }

    private Retry processResponseHeaders()
        throws IOException
    {
        Object obj = httpEngine.getConnection();
        int i;
        if (obj != null)
        {
            obj = ((Connection) (obj)).getRoute().getProxy();
        } else
        {
            obj = client.getProxy();
        }
        i = getResponseCode();
        switch (i)
        {
        default:
            return Retry.NONE;

        case 407: 
            if (((Proxy) (obj)).type() != java.net.Proxy.Type.HTTP)
            {
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            // fall through

        case 401: 
            obj = HttpAuthenticator.processAuthHeader(client.getAuthenticator(), httpEngine.getResponse(), ((Proxy) (obj)));
            if (obj == null)
            {
                return Retry.NONE;
            } else
            {
                requestHeaders = ((Request) (obj)).getHeaders().newBuilder();
                return Retry.SAME_CONNECTION;
            }

        case 300: 
        case 301: 
        case 302: 
        case 303: 
        case 307: 
            break;
        }
        if (!getInstanceFollowRedirects())
        {
            return Retry.NONE;
        }
        int j = redirectionCount + 1;
        redirectionCount = j;
        if (j > 20)
        {
            throw new ProtocolException((new StringBuilder()).append("Too many redirects: ").append(redirectionCount).toString());
        }
        if (i == 307 && !method.equals("GET") && !method.equals("HEAD"))
        {
            return Retry.NONE;
        }
        obj = getHeaderField("Location");
        if (obj == null)
        {
            return Retry.NONE;
        }
        URL url = this.url;
        this.url = new URL(url, ((String) (obj)));
        if (!this.url.getProtocol().equals("https") && !this.url.getProtocol().equals("http"))
        {
            return Retry.NONE;
        }
        boolean flag = url.getProtocol().equals(this.url.getProtocol());
        if (!flag && !client.getFollowProtocolRedirects())
        {
            return Retry.NONE;
        }
        boolean flag1 = url.getHost().equals(this.url.getHost());
        if (Util.getEffectivePort(url) == Util.getEffectivePort(this.url))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag1 && i && flag)
        {
            return Retry.SAME_CONNECTION;
        } else
        {
            return Retry.DIFFERENT_CONNECTION;
        }
    }

    private void setProtocols(String s, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.addAll(client.getProtocols());
        }
        s = s.split(",", -1);
        int j = s.length;
        int i = 0;
        while (i < j) 
        {
            String s1 = s[i];
            try
            {
                arraylist.add(Util.getProtocol(ByteString.encodeUtf8(s1)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new IllegalStateException(s);
            }
            i++;
        }
        client.setProtocols(arraylist);
    }

    public final void addRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            Platform.get().logW((new StringBuilder()).append("Ignoring header ").append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s) || "X-Android-Protocols".equals(s))
        {
            setProtocols(s1, true);
            return;
        } else
        {
            requestHeaders.add(s, s1);
            return;
        }
    }

    public final void connect()
        throws IOException
    {
        initHttpEngine();
        while (!execute(false)) ;
    }

    public final void disconnect()
    {
        if (httpEngine == null)
        {
            return;
        }
        try
        {
            httpEngine.disconnect();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public int getConnectTimeout()
    {
        return client.getConnectTimeout();
    }

    public final InputStream getErrorStream()
    {
        Object obj = null;
        InputStream inputstream;
        HttpEngine httpengine;
        try
        {
            httpengine = getResponse();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        inputstream = obj;
        if (!httpengine.hasResponseBody())
        {
            break MISSING_BLOCK_LABEL_36;
        }
        inputstream = obj;
        if (httpengine.getResponse().code() >= 400)
        {
            inputstream = httpengine.getResponseBodyBytes();
        }
        return inputstream;
    }

    public final String getHeaderField(int i)
    {
        String s;
        try
        {
            s = getResponse().getResponse().headers().value(i);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final String getHeaderField(String s)
    {
        Response response;
        try
        {
            response = getResponse().getResponse();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        return response.statusLine();
        s = response.headers().get(s);
        return s;
    }

    public final String getHeaderFieldKey(int i)
    {
        String s;
        try
        {
            s = getResponse().getResponse().headers().name(i);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final Map getHeaderFields()
    {
        Object obj;
        try
        {
            obj = getResponse().getResponse();
            obj = OkHeaders.toMultimap(((Response) (obj)).headers(), ((Response) (obj)).statusLine());
        }
        catch (IOException ioexception)
        {
            return Collections.emptyMap();
        }
        return ((Map) (obj));
    }

    public final InputStream getInputStream()
        throws IOException
    {
        if (!doInput)
        {
            throw new ProtocolException("This protocol does not support input");
        }
        Object obj = getResponse();
        if (getResponseCode() >= 400)
        {
            throw new FileNotFoundException(url.toString());
        }
        obj = ((HttpEngine) (obj)).getResponseBodyBytes();
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder()).append("No response body exists; responseCode=").append(getResponseCode()).toString());
        } else
        {
            return ((InputStream) (obj));
        }
    }

    public final OutputStream getOutputStream()
        throws IOException
    {
        connect();
        BufferedSink bufferedsink = httpEngine.getBufferedRequestBody();
        if (bufferedsink == null)
        {
            throw new ProtocolException((new StringBuilder()).append("method does not support a request body: ").append(method).toString());
        }
        if (httpEngine.hasResponse())
        {
            throw new ProtocolException("cannot write request body after response has been read");
        } else
        {
            return bufferedsink.outputStream();
        }
    }

    public final Permission getPermission()
        throws IOException
    {
        String s = getURL().getHost();
        int i = Util.getEffectivePort(getURL());
        if (usingProxy())
        {
            InetSocketAddress inetsocketaddress = (InetSocketAddress)client.getProxy().address();
            s = inetsocketaddress.getHostName();
            i = inetsocketaddress.getPort();
        }
        return new SocketPermission((new StringBuilder()).append(s).append(":").append(i).toString(), "connect, resolve");
    }

    public int getReadTimeout()
    {
        return client.getReadTimeout();
    }

    public final Map getRequestProperties()
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        } else
        {
            return OkHeaders.toMultimap(requestHeaders.build(), null);
        }
    }

    public final String getRequestProperty(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return requestHeaders.get(s);
        }
    }

    public final int getResponseCode()
        throws IOException
    {
        return getResponse().getResponse().code();
    }

    public String getResponseMessage()
        throws IOException
    {
        return getResponse().getResponse().statusMessage();
    }

    public void setConnectTimeout(int i)
    {
        client.setConnectTimeout(i, TimeUnit.MILLISECONDS);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        if (super.connected)
        {
            throw new IllegalStateException("Already connected");
        }
        if (chunkLength > 0)
        {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("contentLength < 0");
        } else
        {
            fixedContentLength = l;
            super.fixedContentLength = (int)Math.min(l, 0x7fffffffL);
            return;
        }
    }

    public void setIfModifiedSince(long l)
    {
        super.setIfModifiedSince(l);
        if (ifModifiedSince != 0L)
        {
            requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(ifModifiedSince)));
            return;
        } else
        {
            requestHeaders.removeAll("If-Modified-Since");
            return;
        }
    }

    public void setReadTimeout(int i)
    {
        client.setReadTimeout(i, TimeUnit.MILLISECONDS);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        if (!HttpMethod.METHODS.contains(s))
        {
            throw new ProtocolException((new StringBuilder()).append("Expected one of ").append(HttpMethod.METHODS).append(" but was ").append(s).toString());
        } else
        {
            method = s;
            return;
        }
    }

    public final void setRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            Platform.get().logW((new StringBuilder()).append("Ignoring header ").append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s) || "X-Android-Protocols".equals(s))
        {
            setProtocols(s1, false);
            return;
        } else
        {
            requestHeaders.set(s, s1);
            return;
        }
    }

    public final boolean usingProxy()
    {
        Proxy proxy;
        if (route != null)
        {
            proxy = route.getProxy();
        } else
        {
            proxy = client.getProxy();
        }
        return proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT;
    }
}
