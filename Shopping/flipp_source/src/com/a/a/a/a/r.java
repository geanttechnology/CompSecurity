// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.SecureCacheResponse;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.a.a.a.a:
//            s, h, q

public final class r extends HttpsURLConnection
{

    public final s a;

    public r(URL url, com.a.a.r r1)
    {
        super(url);
        a = new s(this, url, r1, (byte)0);
    }

    private SSLSocket a()
    {
        if (a.c == null || a.c.g == -1L)
        {
            throw new IllegalStateException("Connection has not yet been established");
        }
        if (a.c instanceof q)
        {
            return ((q)a.c).k;
        } else
        {
            return null;
        }
    }

    public final void addRequestProperty(String s1, String s2)
    {
        a.addRequestProperty(s1, s2);
    }

    public final void connect()
    {
        connected = true;
        a.connect();
    }

    public final void disconnect()
    {
        a.disconnect();
    }

    public final boolean getAllowUserInteraction()
    {
        return a.getAllowUserInteraction();
    }

    public final String getCipherSuite()
    {
        Object obj = a.e();
        if (obj != null)
        {
            return ((SecureCacheResponse) (obj)).getCipherSuite();
        }
        obj = a();
        if (obj != null)
        {
            return ((SSLSocket) (obj)).getSession().getCipherSuite();
        } else
        {
            return null;
        }
    }

    public final int getConnectTimeout()
    {
        return a.getConnectTimeout();
    }

    public final Object getContent()
    {
        return a.getContent();
    }

    public final Object getContent(Class aclass[])
    {
        return a.getContent(aclass);
    }

    public final String getContentEncoding()
    {
        return a.getContentEncoding();
    }

    public final int getContentLength()
    {
        return a.getContentLength();
    }

    public final String getContentType()
    {
        return a.getContentType();
    }

    public final long getDate()
    {
        return a.getDate();
    }

    public final boolean getDefaultUseCaches()
    {
        return a.getDefaultUseCaches();
    }

    public final boolean getDoInput()
    {
        return a.getDoInput();
    }

    public final boolean getDoOutput()
    {
        return a.getDoOutput();
    }

    public final InputStream getErrorStream()
    {
        return a.getErrorStream();
    }

    public final long getExpiration()
    {
        return a.getExpiration();
    }

    public final String getHeaderField(int i)
    {
        return a.getHeaderField(i);
    }

    public final String getHeaderField(String s1)
    {
        return a.getHeaderField(s1);
    }

    public final long getHeaderFieldDate(String s1, long l)
    {
        return a.getHeaderFieldDate(s1, l);
    }

    public final int getHeaderFieldInt(String s1, int i)
    {
        return a.getHeaderFieldInt(s1, i);
    }

    public final String getHeaderFieldKey(int i)
    {
        return a.getHeaderFieldKey(i);
    }

    public final Map getHeaderFields()
    {
        return a.getHeaderFields();
    }

    public final HostnameVerifier getHostnameVerifier()
    {
        return a.a.h;
    }

    public final long getIfModifiedSince()
    {
        return a.getIfModifiedSince();
    }

    public final InputStream getInputStream()
    {
        return a.getInputStream();
    }

    public final boolean getInstanceFollowRedirects()
    {
        return a.getInstanceFollowRedirects();
    }

    public final long getLastModified()
    {
        return a.getLastModified();
    }

    public final Certificate[] getLocalCertificates()
    {
        Certificate acertificate[] = null;
        Object obj = a.e();
        if (obj != null)
        {
            obj = ((SecureCacheResponse) (obj)).getLocalCertificateChain();
            if (obj != null)
            {
                acertificate = (Certificate[])((List) (obj)).toArray(new Certificate[((List) (obj)).size()]);
            }
        } else
        {
            SSLSocket sslsocket = a();
            if (sslsocket != null)
            {
                return sslsocket.getSession().getLocalCertificates();
            }
        }
        return acertificate;
    }

    public final Principal getLocalPrincipal()
    {
        Object obj = a.e();
        if (obj != null)
        {
            return ((SecureCacheResponse) (obj)).getLocalPrincipal();
        }
        obj = a();
        if (obj != null)
        {
            return ((SSLSocket) (obj)).getSession().getLocalPrincipal();
        } else
        {
            return null;
        }
    }

    public final OutputStream getOutputStream()
    {
        return a.getOutputStream();
    }

    public final Principal getPeerPrincipal()
    {
        Object obj = a.e();
        if (obj != null)
        {
            return ((SecureCacheResponse) (obj)).getPeerPrincipal();
        }
        obj = a();
        if (obj != null)
        {
            return ((SSLSocket) (obj)).getSession().getPeerPrincipal();
        } else
        {
            return null;
        }
    }

    public final Permission getPermission()
    {
        return a.getPermission();
    }

    public final int getReadTimeout()
    {
        return a.getReadTimeout();
    }

    public final String getRequestMethod()
    {
        return a.getRequestMethod();
    }

    public final Map getRequestProperties()
    {
        return a.getRequestProperties();
    }

    public final String getRequestProperty(String s1)
    {
        return a.getRequestProperty(s1);
    }

    public final int getResponseCode()
    {
        return a.getResponseCode();
    }

    public final String getResponseMessage()
    {
        return a.getResponseMessage();
    }

    public final SSLSocketFactory getSSLSocketFactory()
    {
        return a.a.g;
    }

    public final Certificate[] getServerCertificates()
    {
        Certificate acertificate[] = null;
        Object obj = a.e();
        if (obj != null)
        {
            obj = ((SecureCacheResponse) (obj)).getServerCertificateChain();
            if (obj != null)
            {
                acertificate = (Certificate[])((List) (obj)).toArray(new Certificate[((List) (obj)).size()]);
            }
        } else
        {
            SSLSocket sslsocket = a();
            if (sslsocket != null)
            {
                return sslsocket.getSession().getPeerCertificates();
            }
        }
        return acertificate;
    }

    public final URL getURL()
    {
        return a.getURL();
    }

    public final boolean getUseCaches()
    {
        return a.getUseCaches();
    }

    public final void setAllowUserInteraction(boolean flag)
    {
        a.setAllowUserInteraction(flag);
    }

    public final void setChunkedStreamingMode(int i)
    {
        a.setChunkedStreamingMode(i);
    }

    public final void setConnectTimeout(int i)
    {
        a.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean flag)
    {
        a.setDefaultUseCaches(flag);
    }

    public final void setDoInput(boolean flag)
    {
        a.setDoInput(flag);
    }

    public final void setDoOutput(boolean flag)
    {
        a.setDoOutput(flag);
    }

    public final void setFixedLengthStreamingMode(int i)
    {
        a.setFixedLengthStreamingMode(i);
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameverifier)
    {
        a.a.h = hostnameverifier;
    }

    public final void setIfModifiedSince(long l)
    {
        a.setIfModifiedSince(l);
    }

    public final void setInstanceFollowRedirects(boolean flag)
    {
        a.setInstanceFollowRedirects(flag);
    }

    public final void setReadTimeout(int i)
    {
        a.setReadTimeout(i);
    }

    public final void setRequestMethod(String s1)
    {
        a.setRequestMethod(s1);
    }

    public final void setRequestProperty(String s1, String s2)
    {
        a.setRequestProperty(s1, s2);
    }

    public final void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        a.a.g = sslsocketfactory;
    }

    public final void setUseCaches(boolean flag)
    {
        a.setUseCaches(flag);
    }

    public final String toString()
    {
        return a.toString();
    }

    public final boolean usingProxy()
    {
        return a.usingProxy();
    }
}
