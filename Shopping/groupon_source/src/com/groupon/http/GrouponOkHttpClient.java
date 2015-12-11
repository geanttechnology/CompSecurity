// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import com.groupon.util.Function0;
import com.groupon.util.Function3;
import com.groupon.util.GrouponRoboAsyncTask;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.http:
//            CacheBustResponseInterceptor, SharedPreferencesCookieStore, ErrorHttpResponseInterceptor, LoggingHttpRequestResponseInterceptor, 
//            LoginHttpRequestInterceptor, LogoutOnSessionExpireHttpResponseInterceptor, ProxyHeaderHttpRequestInterceptor, UserAgentRequestInterceptor

public class GrouponOkHttpClient extends OkHttpClient
{
    private class ConfigureProxyAddressAsyncTask extends GrouponRoboAsyncTask
    {

        private Function3 exceptionListener;
        private String proxyIpAddress;
        private String proxyPort;
        private Function0 successListener;
        final GrouponOkHttpClient this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            configureProxy(proxyIpAddress, proxyPort);
            return null;
        }

        protected void onException(Exception exception)
        {
            if (exceptionListener != null)
            {
                exceptionListener.execute(exception, proxyIpAddress, proxyPort);
                return;
            } else
            {
                super.onException(exception);
                return;
            }
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((Void)obj);
        }

        protected void onSuccess(Void void1)
            throws Exception
        {
            super.onSuccess(void1);
            if (successListener != null)
            {
                successListener.execute();
            }
        }

        protected ConfigureProxyAddressAsyncTask(Context context, String s, String s1, Function0 function0, Function3 function3)
        {
            this$0 = GrouponOkHttpClient.this;
            super(context);
            proxyIpAddress = s;
            proxyPort = s1;
            successListener = function0;
            exceptionListener = function3;
        }
    }

    private static class TrustAllHostsHostnameVerifier
        implements HostnameVerifier
    {

        public boolean verify(String s, SSLSession sslsession)
        {
            return true;
        }

        private TrustAllHostsHostnameVerifier()
        {
        }

    }

    private static class TrustsAllClientsAndServersX509TrustManager
        implements X509TrustManager
    {

        public void checkClientTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
        {
        }

        public void checkServerTrusted(X509Certificate ax509certificate[], String s)
            throws CertificateException
        {
        }

        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        private TrustsAllClientsAndServersX509TrustManager()
        {
        }

    }


    public static final String DEFAULT_PROXY_PORT = "3128";
    public static final String PROTOCOL_TLS = "TLS";
    protected Application application;
    protected CacheBustResponseInterceptor cacheBust;
    protected SharedPreferencesCookieStore cookieHandler;
    protected ErrorHttpResponseInterceptor err;
    protected PackageInfo info;
    protected LoggingHttpRequestResponseInterceptor log;
    protected LoginHttpRequestInterceptor login;
    protected LogoutOnSessionExpireHttpResponseInterceptor logoutOnSessionExpire;
    protected SharedPreferences prefs;
    protected ProxyHeaderHttpRequestInterceptor proxyHeader;
    protected SSLSocketFactory sslSocketFactory;
    protected UserAgentRequestInterceptor userAgent;

    public GrouponOkHttpClient()
    {
    }

    private void configureProxy(String s, String s1)
        throws UnknownHostException, NoSuchAlgorithmException, KeyManagementException
    {
        if (Strings.notEmpty(s))
        {
            InetAddress inetaddress = InetAddress.getByName(s);
            setProxy(new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(inetaddress, Integer.parseInt(s1))));
        } else
        {
            setProxy(null);
        }
        if (Strings.notEmpty(s) || Ln.isDebugEnabled())
        {
            s = SSLContext.getInstance("TLS");
            s.init(null, new TrustManager[] {
                new TrustsAllClientsAndServersX509TrustManager()
            }, null);
            setSslSocketFactory(s.getSocketFactory());
            setHostnameVerifier(new TrustAllHostsHostnameVerifier());
            return;
        } else
        {
            setSslSocketFactory(sslSocketFactory);
            setHostnameVerifier(OkHostnameVerifier.INSTANCE);
            return;
        }
    }

    public void configureProxyAsync(String s, String s1, Function0 function0, Function3 function3)
    {
        (new ConfigureProxyAddressAsyncTask(application, s, s1, function0, function3)).execute();
    }

    protected void init()
    {
        setCookieHandler(cookieHandler);
        Object obj = prefs.getString("proxyIp", null);
        String s = prefs.getString("proxyPort", "3128");
        try
        {
            configureProxy(((String) (obj)), s);
        }
        catch (UnknownHostException unknownhostexception)
        {
            Ln.e(unknownhostexception);
        }
        catch (Exception exception)
        {
            throw new RuntimeException(exception);
        }
        obj = networkInterceptors();
        ((List) (obj)).add(logoutOnSessionExpire);
        ((List) (obj)).add(userAgent);
        ((List) (obj)).add(login);
        ((List) (obj)).add(proxyHeader);
        ((List) (obj)).add(err);
        ((List) (obj)).add(cacheBust);
        ((List) (obj)).add(log);
    }

}
