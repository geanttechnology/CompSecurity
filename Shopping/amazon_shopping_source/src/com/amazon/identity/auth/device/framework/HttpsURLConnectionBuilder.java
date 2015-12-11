// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            HttpURLConnectionBuilder

public class HttpsURLConnectionBuilder extends HttpURLConnectionBuilder
{

    private final HttpsURLConnection mInnerConnectionStore;

    public HttpsURLConnectionBuilder(URL url)
        throws IOException
    {
        super(url);
        url = getInnerStore();
        if (!(url instanceof HttpsURLConnection))
        {
            throw new IllegalArgumentException("url must be https");
        } else
        {
            mInnerConnectionStore = (HttpsURLConnection)url;
            return;
        }
    }

    public volatile void addRequestProperty(String s, String s1)
    {
        super.addRequestProperty(s, s1);
    }

    public volatile boolean getAllowUserInteraction()
    {
        return super.getAllowUserInteraction();
    }

    public String getCipherSuite()
    {
        return mInnerConnectionStore.getCipherSuite();
    }

    public volatile int getConnectTimeout()
    {
        return super.getConnectTimeout();
    }

    public volatile boolean getDefaultUseCaches()
    {
        return super.getDefaultUseCaches();
    }

    public volatile boolean getDoInput()
    {
        return super.getDoInput();
    }

    public volatile boolean getDoOutput()
    {
        return super.getDoOutput();
    }

    public HostnameVerifier getHostnameVerifier()
    {
        return mInnerConnectionStore.getHostnameVerifier();
    }

    public volatile long getIfModifiedSince()
    {
        return super.getIfModifiedSince();
    }

    public volatile boolean getInstanceFollowRedirects()
    {
        return super.getInstanceFollowRedirects();
    }

    public Certificate[] getLocalCertificates()
    {
        return mInnerConnectionStore.getLocalCertificates();
    }

    public Principal getLocalPrincipal()
    {
        return mInnerConnectionStore.getLocalPrincipal();
    }

    public volatile OutputStream getOutputStream()
    {
        return super.getOutputStream();
    }

    public Principal getPeerPrincipal()
        throws SSLPeerUnverifiedException
    {
        return mInnerConnectionStore.getPeerPrincipal();
    }

    public volatile int getReadTimeout()
    {
        return super.getReadTimeout();
    }

    public volatile String getRequestMethod()
    {
        return super.getRequestMethod();
    }

    public volatile Map getRequestProperties()
    {
        return super.getRequestProperties();
    }

    public volatile String getRequestProperty(String s)
    {
        return super.getRequestProperty(s);
    }

    public SSLSocketFactory getSSLSocketFactory()
    {
        return mInnerConnectionStore.getSSLSocketFactory();
    }

    public Certificate[] getServerCertificates()
        throws SSLPeerUnverifiedException
    {
        return mInnerConnectionStore.getServerCertificates();
    }

    public volatile URL getURL()
    {
        return super.getURL();
    }

    public volatile boolean getUseCaches()
    {
        return super.getUseCaches();
    }

    protected void populateConnectionAttributes(HttpURLConnection httpurlconnection)
    {
        super.populateConnectionAttributes(httpurlconnection);
        if (!(httpurlconnection instanceof HttpsURLConnection))
        {
            return;
        } else
        {
            httpurlconnection = (HttpsURLConnection)httpurlconnection;
            httpurlconnection.setSSLSocketFactory(mInnerConnectionStore.getSSLSocketFactory());
            httpurlconnection.setHostnameVerifier(mInnerConnectionStore.getHostnameVerifier());
            return;
        }
    }

    public volatile void setAllowUserInteraction(boolean flag)
    {
        super.setAllowUserInteraction(flag);
    }

    public volatile void setChunkedStreamingMode(int i)
    {
        super.setChunkedStreamingMode(i);
    }

    public volatile void setConnectTimeout(int i)
    {
        super.setConnectTimeout(i);
    }

    public volatile void setDefaultUseCaches(boolean flag)
    {
        super.setDefaultUseCaches(flag);
    }

    public volatile void setDoInput(boolean flag)
    {
        super.setDoInput(flag);
    }

    public volatile void setDoOutput(boolean flag)
    {
        super.setDoOutput(flag);
    }

    public volatile void setFixedLengthStreamingMode(long l)
    {
        super.setFixedLengthStreamingMode(l);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameverifier)
    {
        mInnerConnectionStore.setHostnameVerifier(hostnameverifier);
    }

    public volatile void setIfModifiedSince(long l)
    {
        super.setIfModifiedSince(l);
    }

    public volatile void setInstanceFollowRedirects(boolean flag)
    {
        super.setInstanceFollowRedirects(flag);
    }

    public volatile void setReadTimeout(int i)
    {
        super.setReadTimeout(i);
    }

    public volatile void setRequestMethod(String s)
        throws ProtocolException
    {
        super.setRequestMethod(s);
    }

    public volatile void setRequestProperty(String s, String s1)
    {
        super.setRequestProperty(s, s1);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        mInnerConnectionStore.setSSLSocketFactory(sslsocketfactory);
    }

    public volatile void setUseCaches(boolean flag)
    {
        super.setUseCaches(flag);
    }

    public volatile String toString()
    {
        return super.toString();
    }

    public volatile boolean usingProxy()
    {
        return super.usingProxy();
    }
}
