// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.framework.security.EnhancedURLConnectionFactory;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.request.AuthenticatedUrlConnectionAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpsURLConnection, AuthenticationMethod, AuthenticationType, AuthenticatedHttpURLConnection

public class AuthenticatedURLConnection extends HttpsURLConnection
{
    public static class NoCredentialsException extends IOException
    {

        private static final long serialVersionUID = 1L;

        public NoCredentialsException(String s)
        {
            super(s);
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/api/AuthenticatedURLConnection.getName();
    private final AuthenticatedHttpsURLConnection mInnerHttpsUrlConnection;

    public AuthenticatedURLConnection(URL url, AuthenticationMethod authenticationmethod)
        throws IOException
    {
        super(url);
        mInnerHttpsUrlConnection = (AuthenticatedHttpsURLConnection)openConnection(url, authenticationmethod);
    }

    public static HttpURLConnection openConnection(HttpURLConnection httpurlconnection, AuthenticationMethod authenticationmethod)
        throws IOException
    {
        if (httpurlconnection == null)
        {
            throw new IllegalArgumentException("Must Specify a URL");
        }
        if (authenticationmethod == null)
        {
            throw new IllegalArgumentException("Must Specify an Authentication Method");
        }
        AuthenticationType authenticationtype = AuthenticationType.parse(authenticationmethod.mAuthTypeString);
        if (httpurlconnection instanceof HttpsURLConnection)
        {
            if (authenticationtype == AuthenticationType.OAuth && !ThreadUtils.isRunningOnMainThread())
            {
                authenticationmethod.authenticateConnection(new AuthenticatedUrlConnectionAdapter(httpurlconnection) {

                    public byte[] getBody()
                    {
                        return new byte[0];
                    }

                });
                return httpurlconnection;
            } else
            {
                return new AuthenticatedHttpsURLConnection((HttpsURLConnection)httpurlconnection, authenticationmethod);
            }
        }
        if (authenticationtype != null && authenticationtype.requireHttps())
        {
            throw new SecurityException(String.format("The authentication type %s can only be used over HTTPS. ", new Object[] {
                authenticationmethod.mAuthTypeString
            }));
        }
        Object obj = httpurlconnection.getURL();
        if (obj != null)
        {
            obj = ((URL) (obj)).getHost();
        } else
        {
            obj = null;
        }
        (new StringBuilder("Using http for ")).append(((String) (obj))).append(" with auth type ").append(authenticationtype);
        return new AuthenticatedHttpURLConnection(httpurlconnection, authenticationmethod);
    }

    public static HttpURLConnection openConnection(URL url, AuthenticationMethod authenticationmethod)
        throws IOException
    {
        if (url == null)
        {
            throw new IllegalArgumentException("Must Specify a URL");
        }
        if (authenticationmethod == null)
        {
            throw new IllegalArgumentException("Must Specify an Authentication Method");
        }
        url = EnhancedURLConnectionFactory.createURLConnection(url);
        if (!(url instanceof HttpURLConnection))
        {
            throw new IllegalArgumentException("Url must be an Https or Http Url");
        } else
        {
            return openConnection((HttpURLConnection)url, authenticationmethod);
        }
    }

    public void addRequestProperty(String s, String s1)
    {
        mInnerHttpsUrlConnection.addRequestProperty(s, s1);
    }

    public void connect()
        throws IOException
    {
        mInnerHttpsUrlConnection.connect();
    }

    public void disconnect()
    {
        mInnerHttpsUrlConnection.disconnect();
    }

    public boolean getAllowUserInteraction()
    {
        return mInnerHttpsUrlConnection.getAllowUserInteraction();
    }

    public String getCipherSuite()
    {
        return mInnerHttpsUrlConnection.getCipherSuite();
    }

    public int getConnectTimeout()
    {
        return mInnerHttpsUrlConnection.getConnectTimeout();
    }

    public Object getContent()
        throws IOException
    {
        return mInnerHttpsUrlConnection.getContent();
    }

    public Object getContent(Class aclass[])
        throws IOException
    {
        return mInnerHttpsUrlConnection.getContent(aclass);
    }

    public String getContentEncoding()
    {
        return mInnerHttpsUrlConnection.getContentEncoding();
    }

    public int getContentLength()
    {
        return mInnerHttpsUrlConnection.getContentLength();
    }

    public String getContentType()
    {
        return mInnerHttpsUrlConnection.getContentType();
    }

    public long getDate()
    {
        return mInnerHttpsUrlConnection.getDate();
    }

    public boolean getDefaultUseCaches()
    {
        return mInnerHttpsUrlConnection.getDefaultUseCaches();
    }

    public boolean getDoInput()
    {
        return mInnerHttpsUrlConnection.getDoInput();
    }

    public boolean getDoOutput()
    {
        return mInnerHttpsUrlConnection.getDoOutput();
    }

    public InputStream getErrorStream()
    {
        return mInnerHttpsUrlConnection.getErrorStream();
    }

    public long getExpiration()
    {
        return mInnerHttpsUrlConnection.getExpiration();
    }

    public String getHeaderField(int i)
    {
        return mInnerHttpsUrlConnection.getHeaderField(i);
    }

    public String getHeaderField(String s)
    {
        return mInnerHttpsUrlConnection.getHeaderField(s);
    }

    public long getHeaderFieldDate(String s, long l)
    {
        return mInnerHttpsUrlConnection.getHeaderFieldDate(s, l);
    }

    public int getHeaderFieldInt(String s, int i)
    {
        return mInnerHttpsUrlConnection.getHeaderFieldInt(s, i);
    }

    public String getHeaderFieldKey(int i)
    {
        return mInnerHttpsUrlConnection.getHeaderFieldKey(i);
    }

    public Map getHeaderFields()
    {
        return mInnerHttpsUrlConnection.getHeaderFields();
    }

    public HostnameVerifier getHostnameVerifier()
    {
        return mInnerHttpsUrlConnection.getHostnameVerifier();
    }

    public long getIfModifiedSince()
    {
        return mInnerHttpsUrlConnection.getIfModifiedSince();
    }

    public InputStream getInputStream()
        throws IOException
    {
        return mInnerHttpsUrlConnection.getInputStream();
    }

    public boolean getInstanceFollowRedirects()
    {
        return mInnerHttpsUrlConnection.getInstanceFollowRedirects();
    }

    public long getLastModified()
    {
        return mInnerHttpsUrlConnection.getLastModified();
    }

    public Certificate[] getLocalCertificates()
    {
        return mInnerHttpsUrlConnection.getLocalCertificates();
    }

    public Principal getLocalPrincipal()
    {
        return mInnerHttpsUrlConnection.getLocalPrincipal();
    }

    public OutputStream getOutputStream()
        throws IOException
    {
        return mInnerHttpsUrlConnection.getOutputStream();
    }

    public Principal getPeerPrincipal()
        throws SSLPeerUnverifiedException
    {
        return mInnerHttpsUrlConnection.getPeerPrincipal();
    }

    public Permission getPermission()
        throws IOException
    {
        return mInnerHttpsUrlConnection.getPermission();
    }

    public int getReadTimeout()
    {
        return mInnerHttpsUrlConnection.getReadTimeout();
    }

    public String getRequestMethod()
    {
        return mInnerHttpsUrlConnection.getRequestMethod();
    }

    public Map getRequestProperties()
    {
        return mInnerHttpsUrlConnection.getRequestProperties();
    }

    public String getRequestProperty(String s)
    {
        return mInnerHttpsUrlConnection.getRequestProperty(s);
    }

    public int getResponseCode()
        throws IOException
    {
        return mInnerHttpsUrlConnection.getResponseCode();
    }

    public String getResponseMessage()
        throws IOException
    {
        return mInnerHttpsUrlConnection.getResponseMessage();
    }

    public SSLSocketFactory getSSLSocketFactory()
    {
        return mInnerHttpsUrlConnection.getSSLSocketFactory();
    }

    public Certificate[] getServerCertificates()
        throws SSLPeerUnverifiedException
    {
        return mInnerHttpsUrlConnection.getServerCertificates();
    }

    public URL getURL()
    {
        return mInnerHttpsUrlConnection.getURL();
    }

    public boolean getUseCaches()
    {
        return mInnerHttpsUrlConnection.getUseCaches();
    }

    public void setAllowUserInteraction(boolean flag)
    {
        mInnerHttpsUrlConnection.setAllowUserInteraction(flag);
    }

    public void setChunkedStreamingMode(int i)
    {
        mInnerHttpsUrlConnection.setChunkedStreamingMode(i);
    }

    public void setConnectTimeout(int i)
    {
        mInnerHttpsUrlConnection.setConnectTimeout(i);
    }

    public void setDefaultUseCaches(boolean flag)
    {
        mInnerHttpsUrlConnection.setDefaultUseCaches(flag);
    }

    public void setDoInput(boolean flag)
    {
        mInnerHttpsUrlConnection.setDoInput(flag);
    }

    public void setDoOutput(boolean flag)
    {
        mInnerHttpsUrlConnection.setDoOutput(flag);
    }

    public void setFixedLengthStreamingMode(int i)
    {
        mInnerHttpsUrlConnection.setFixedLengthStreamingMode(i);
    }

    public void setHostnameVerifier(HostnameVerifier hostnameverifier)
    {
        mInnerHttpsUrlConnection.setHostnameVerifier(hostnameverifier);
    }

    public void setIfModifiedSince(long l)
    {
        mInnerHttpsUrlConnection.setIfModifiedSince(l);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        mInnerHttpsUrlConnection.setInstanceFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        mInnerHttpsUrlConnection.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
        throws ProtocolException
    {
        mInnerHttpsUrlConnection.setRequestMethod(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        mInnerHttpsUrlConnection.setRequestProperty(s, s1);
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        mInnerHttpsUrlConnection.setSSLSocketFactory(sslsocketfactory);
    }

    public void setUseCaches(boolean flag)
    {
        mInnerHttpsUrlConnection.setUseCaches(flag);
    }

    public String toString()
    {
        return mInnerHttpsUrlConnection.toString();
    }

    public boolean usingProxy()
    {
        return mInnerHttpsUrlConnection.usingProxy();
    }

}
