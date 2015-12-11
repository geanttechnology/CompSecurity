// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.huc.CacheAdapter;
import com.squareup.okhttp.internal.huc.HttpURLConnectionImpl;
import com.squareup.okhttp.internal.huc.HttpsURLConnectionImpl;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

// Referenced classes of package com.squareup.okhttp:
//            OkHttpClient

public final class OkUrlFactory
    implements URLStreamHandlerFactory, Cloneable
{

    private final OkHttpClient client;

    public OkUrlFactory(OkHttpClient okhttpclient)
    {
        client = okhttpclient;
    }

    public OkHttpClient client()
    {
        return client;
    }

    public OkUrlFactory clone()
    {
        return new OkUrlFactory(client.clone());
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public URLStreamHandler createURLStreamHandler(final String protocol)
    {
        if (!protocol.equals("http") && !protocol.equals("https"))
        {
            return null;
        } else
        {
            return new URLStreamHandler() {

                final OkUrlFactory this$0;
                final String val$protocol;

                protected int getDefaultPort()
                {
                    if (protocol.equals("http"))
                    {
                        return 80;
                    }
                    if (protocol.equals("https"))
                    {
                        return 443;
                    } else
                    {
                        throw new AssertionError();
                    }
                }

                protected URLConnection openConnection(URL url)
                {
                    return open(url);
                }

                protected URLConnection openConnection(URL url, Proxy proxy)
                {
                    return open(url, proxy);
                }

            
            {
                this$0 = OkUrlFactory.this;
                protocol = s;
                super();
            }
            };
        }
    }

    ResponseCache getResponseCache()
    {
        com.squareup.okhttp.internal.InternalCache internalcache = client.internalCache();
        if (internalcache instanceof CacheAdapter)
        {
            return ((CacheAdapter)internalcache).getDelegate();
        } else
        {
            return null;
        }
    }

    public HttpURLConnection open(URL url)
    {
        return open(url, client.getProxy());
    }

    HttpURLConnection open(URL url, Proxy proxy)
    {
        String s = url.getProtocol();
        OkHttpClient okhttpclient = client.copyWithDefaults();
        okhttpclient.setProxy(proxy);
        if (s.equals("http"))
        {
            return new HttpURLConnectionImpl(url, okhttpclient);
        }
        if (s.equals("https"))
        {
            return new HttpsURLConnectionImpl(url, okhttpclient);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected protocol: ").append(s).toString());
        }
    }

    OkUrlFactory setResponseCache(ResponseCache responsecache)
    {
        OkHttpClient okhttpclient = client;
        if (responsecache != null)
        {
            responsecache = new CacheAdapter(responsecache);
        } else
        {
            responsecache = null;
        }
        okhttpclient.setInternalCache(responsecache);
        return this;
    }
}
