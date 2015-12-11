// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.framework.security.EnhancedApacheSSLSocketFactory;
import com.amazon.identity.auth.device.utils.StreamUtils;
import com.amazon.identity.auth.request.HttpRequestAdapter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            AuthenticatedHttpRequest, AuthenticationMethod, AuthenticationType

public class AuthenticationAwareHttpClient
    implements HttpClient
{
    private static class WrappedHttpEntity
        implements Cloneable, HttpEntity
    {

        private static Object sSyncObj[] = new Object[0];
        private byte mContentBytes[];
        private final HttpEntity mInnerHttpEntity;

        public Object clone()
            throws CloneNotSupportedException
        {
            if (!(mInnerHttpEntity instanceof Cloneable))
            {
                return super.clone();
            }
            HttpEntity httpentity;
            try
            {
                httpentity = (HttpEntity)mInnerHttpEntity.getClass().getMethod("clone", new Class[0]).invoke(mInnerHttpEntity, new Object[0]);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                return super.clone();
            }
            catch (SecurityException securityexception)
            {
                return super.clone();
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                return super.clone();
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                return super.clone();
            }
            catch (NoSuchMethodException nosuchmethodexception)
            {
                return super.clone();
            }
            return new WrappedHttpEntity(httpentity, mContentBytes);
        }

        public void consumeContent()
            throws IOException
        {
            mInnerHttpEntity.consumeContent();
        }

        public InputStream getContent()
            throws IOException
        {
label0:
            {
                InputStream inputstream;
                synchronized (sSyncObj)
                {
                    if (!isRepeatable())
                    {
                        break label0;
                    }
                    inputstream = mInnerHttpEntity.getContent();
                }
                return inputstream;
            }
            ByteArrayInputStream bytearrayinputstream;
            if (mContentBytes == null)
            {
                mContentBytes = StreamUtils.readInputStream(mInnerHttpEntity.getContent());
            }
            bytearrayinputstream = new ByteArrayInputStream(mContentBytes);
            aobj;
            JVM INSTR monitorexit ;
            return bytearrayinputstream;
            exception;
            throw exception;
        }

        public Header getContentEncoding()
        {
            return mInnerHttpEntity.getContentEncoding();
        }

        public long getContentLength()
        {
            return mInnerHttpEntity.getContentLength();
        }

        public Header getContentType()
        {
            return mInnerHttpEntity.getContentType();
        }

        public boolean isChunked()
        {
            return mInnerHttpEntity.isChunked();
        }

        public boolean isRepeatable()
        {
            return mInnerHttpEntity.isRepeatable();
        }

        public boolean isStreaming()
        {
            return mInnerHttpEntity.isStreaming();
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            mInnerHttpEntity.writeTo(outputstream);
        }


        public WrappedHttpEntity(HttpEntity httpentity)
        {
            mInnerHttpEntity = httpentity;
        }

        private WrappedHttpEntity(HttpEntity httpentity, byte abyte0[])
        {
            mInnerHttpEntity = httpentity;
            mContentBytes = abyte0;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/api/AuthenticationAwareHttpClient.getName();
    private final HttpClient mInnerHttpClient;

    public AuthenticationAwareHttpClient()
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        BasicHttpParams basichttpparams;
        try
        {
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", EnhancedApacheSSLSocketFactory.getInstance(), 443));
        }
        catch (GeneralSecurityException generalsecurityexception)
        {
            throw new RuntimeException(generalsecurityexception);
        }
        catch (IOException ioexception)
        {
            throw new RuntimeException(ioexception);
        }
        basichttpparams = new BasicHttpParams();
        mInnerHttpClient = new DefaultHttpClient(new SingleClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    public AuthenticationAwareHttpClient(HttpClient httpclient)
    {
        mInnerHttpClient = httpclient;
    }

    private void onConnectionRequested(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        Object obj = null;
        AuthenticationMethod authenticationmethod = null;
        if (httprequest instanceof AuthenticatedHttpRequest)
        {
            authenticationmethod = ((AuthenticatedHttpRequest)httprequest).getAuthenticationMethod();
        }
        if (authenticationmethod != null)
        {
            AuthenticationType authenticationtype = AuthenticationType.parse(authenticationmethod.getAuthenticationType());
            boolean flag;
            if (httphost != null)
            {
                obj = httphost.getSchemeName();
                String s = httphost.getHostName();
                httphost = ((HttpHost) (obj));
                obj = s;
            } else
            if (httprequest instanceof HttpUriRequest)
            {
                obj = ((HttpUriRequest)httprequest).getURI();
                httphost = ((URI) (obj)).getScheme();
                obj = ((URI) (obj)).getHost();
            } else
            {
                httphost = null;
            }
            if (httphost != null && httphost.toLowerCase(Locale.US).equals("https"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                if (authenticationtype != null && authenticationtype.requireHttps())
                {
                    throw new SecurityException(String.format("The authentication type %s can only be used over HTTPS. ", new Object[] {
                        authenticationmethod.getAuthenticationType()
                    }));
                }
                httphost = TAG;
                (new StringBuilder("Using http for ")).append(((String) (obj))).append(" with auth type ").append(authenticationtype).toString();
            }
            authenticationmethod.authenticateConnection(new HttpRequestAdapter(httprequest));
        }
    }

    private HttpRequest wrapHttpRequest(HttpRequest httprequest)
    {
        if (httprequest instanceof HttpEntityEnclosingRequestBase)
        {
            HttpEntityEnclosingRequestBase httpentityenclosingrequestbase = (HttpEntityEnclosingRequestBase)httprequest;
            HttpEntity httpentity = httpentityenclosingrequestbase.getEntity();
            if (httpentity != null)
            {
                httpentityenclosingrequestbase.setEntity(new WrappedHttpEntity(httpentity));
                return httprequest;
            }
        }
        return httprequest;
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException
    {
        httprequest = wrapHttpRequest(httprequest);
        onConnectionRequested(httphost, httprequest);
        return mInnerHttpClient.execute(httphost, httprequest, responsehandler);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        httprequest = wrapHttpRequest(httprequest);
        onConnectionRequested(httphost, httprequest);
        return mInnerHttpClient.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException
    {
        httpurirequest = (HttpUriRequest)wrapHttpRequest(httpurirequest);
        onConnectionRequested(null, httpurirequest);
        return mInnerHttpClient.execute(httpurirequest, responsehandler);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        httpurirequest = (HttpUriRequest)wrapHttpRequest(httpurirequest);
        onConnectionRequested(null, httpurirequest);
        return mInnerHttpClient.execute(httpurirequest, responsehandler, httpcontext);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        httprequest = wrapHttpRequest(httprequest);
        onConnectionRequested(httphost, httprequest);
        return mInnerHttpClient.execute(httphost, httprequest);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        httprequest = wrapHttpRequest(httprequest);
        onConnectionRequested(httphost, httprequest);
        return mInnerHttpClient.execute(httphost, httprequest, httpcontext);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException
    {
        httpurirequest = (HttpUriRequest)wrapHttpRequest(httpurirequest);
        onConnectionRequested(null, httpurirequest);
        return mInnerHttpClient.execute(httpurirequest);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        httpurirequest = (HttpUriRequest)wrapHttpRequest(httpurirequest);
        onConnectionRequested(null, httpurirequest);
        return mInnerHttpClient.execute(httpurirequest, httpcontext);
    }

    public ClientConnectionManager getConnectionManager()
    {
        return mInnerHttpClient.getConnectionManager();
    }

    public HttpParams getParams()
    {
        return mInnerHttpClient.getParams();
    }

}
