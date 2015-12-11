// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.SSLSessionCache;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseOkHttpClient, PLog, ParseURLConnectionHttpClient, ParseApacheHttpClient

abstract class ParseHttpClient
{
    private class ParseNetworkInterceptorChain
        implements com.parse.http.ParseNetworkInterceptor.Chain
    {

        private final int externalIndex;
        private final int internalIndex;
        private final ParseHttpRequest request;
        final ParseHttpClient this$0;

        public ParseHttpRequest getRequest()
        {
            return request;
        }

        public ParseHttpResponse proceed(ParseHttpRequest parsehttprequest)
            throws IOException
        {
            if (internalInterceptors != null && internalIndex < internalInterceptors.size())
            {
                parsehttprequest = new ParseNetworkInterceptorChain(internalIndex + 1, externalIndex, parsehttprequest);
                return ((ParseNetworkInterceptor)internalInterceptors.get(internalIndex)).intercept(parsehttprequest);
            }
            if (externalInterceptors != null && externalIndex < externalInterceptors.size())
            {
                parsehttprequest = new ParseNetworkInterceptorChain(internalIndex, externalIndex + 1, parsehttprequest);
                return ((ParseNetworkInterceptor)externalInterceptors.get(externalIndex)).intercept(parsehttprequest);
            } else
            {
                return executeInternal(parsehttprequest);
            }
        }

        ParseNetworkInterceptorChain(int i, int j, ParseHttpRequest parsehttprequest)
        {
            this$0 = ParseHttpClient.this;
            super();
            internalIndex = i;
            externalIndex = j;
            request = parsehttprequest;
        }
    }


    private static final String APACHE_HTTPCLIENT_NAME = "org.apache.http";
    private static final String KEEP_ALIVE_PROPERTY_NAME = "http.keepAlive";
    private static final String MAX_CONNECTIONS_PROPERTY_NAME = "http.maxConnections";
    private static final String OKHTTPCLIENT_PATH = "com.h.b.s";
    private static final String OKHTTP_NAME = "com.squareup.okhttp";
    private static final String TAG = "com.parse.ParseHttpClient";
    private static final String URLCONNECTION_NAME = "net.java.URLConnection";
    private List externalInterceptors;
    private boolean hasExecuted;
    private List internalInterceptors;

    ParseHttpClient()
    {
    }

    public static ParseHttpClient createClient(int i, SSLSessionCache sslsessioncache)
    {
        String s;
        if (hasOkHttpOnClasspath())
        {
            s = "com.squareup.okhttp";
            sslsessioncache = new ParseOkHttpClient(i, sslsessioncache);
        } else
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            s = "net.java.URLConnection";
            sslsessioncache = new ParseURLConnectionHttpClient(i, sslsessioncache);
        } else
        {
            s = "org.apache.http";
            sslsessioncache = new ParseApacheHttpClient(i, sslsessioncache);
        }
        PLog.i("com.parse.ParseHttpClient", (new StringBuilder()).append("Using ").append(s).append(" library for networking communication.").toString());
        return sslsessioncache;
    }

    private static boolean hasOkHttpOnClasspath()
    {
        try
        {
            Class.forName("com.h.b.s");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }

    public static void setKeepAlive(boolean flag)
    {
        System.setProperty("http.keepAlive", String.valueOf(flag));
    }

    public static void setMaxConnections(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("Max connections should be large than 0");
        } else
        {
            System.setProperty("http.maxConnections", String.valueOf(i));
            return;
        }
    }

    void addExternalInterceptor(ParseNetworkInterceptor parsenetworkinterceptor)
    {
        if (externalInterceptors == null)
        {
            externalInterceptors = new ArrayList();
        }
        externalInterceptors.add(parsenetworkinterceptor);
    }

    void addInternalInterceptor(ParseNetworkInterceptor parsenetworkinterceptor)
    {
        if (hasExecuted)
        {
            throw new IllegalStateException("`ParseHttpClient#addInternalInterceptor(ParseNetworkInterceptor)` can only be invoked before `ParseHttpClient` execute any request");
        }
        if (internalInterceptors == null)
        {
            internalInterceptors = new ArrayList();
        }
        internalInterceptors.add(parsenetworkinterceptor);
    }

    boolean disableHttpLibraryAutoDecompress()
    {
        return externalInterceptors != null && externalInterceptors.size() > 0;
    }

    public final ParseHttpResponse execute(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        if (!hasExecuted)
        {
            hasExecuted = true;
        }
        return (new ParseNetworkInterceptorChain(0, 0, parsehttprequest)).proceed(parsehttprequest);
    }

    abstract ParseHttpResponse executeInternal(ParseHttpRequest parsehttprequest)
        throws IOException;

    abstract Object getRequest(ParseHttpRequest parsehttprequest)
        throws IOException;

    abstract ParseHttpResponse getResponse(Object obj)
        throws IOException;


}
