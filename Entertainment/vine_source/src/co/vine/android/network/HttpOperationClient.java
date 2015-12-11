// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import android.content.Context;
import android.content.SharedPreferences;
import co.vine.android.network.ssl.PinningSSLSocketFactory;
import co.vine.android.util.Util;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package co.vine.android.network:
//            ShortKeepAliveStrategy

public abstract class HttpOperationClient
{
    private static class HttpProxyInfo
    {

        public final boolean enabled;
        public final HttpHost httpHost;

        public HttpProxyInfo(boolean flag, String s, String s1)
        {
            s = s.trim();
            if (s.length() == 0)
            {
                flag = false;
            }
            int i;
            try
            {
                i = Integer.parseInt(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                i = -1;
                flag = false;
            }
            httpHost = new HttpHost(s, i, "http");
            enabled = flag;
        }
    }


    private static final int CONNECT_TIMEOUT = 20000;
    public static final String PREF_PROXY_ENABLED = "proxy_enabled";
    public static final String PREF_PROXY_HOST = "proxy_host";
    public static final String PREF_PROXY_PORT = "proxy_port";
    private static final int READ_TIMEOUT = 0x15f90;

    public HttpOperationClient()
    {
    }

    private HttpProxyInfo getProxyInfo(Context context)
    {
        context = Util.getDefaultSharedPrefs(context);
        return new HttpProxyInfo(context.getBoolean("proxy_enabled", false), context.getString("proxy_host", ""), context.getString("proxy_port", ""));
    }

    public abstract HttpClient getHttpClient();

    protected HttpClient initializeHttpClient(Context context, ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        clientconnectionmanager = new DefaultHttpClient(clientconnectionmanager, httpparams);
        clientconnectionmanager.removeRequestInterceptorByClass(org/apache/http/client/protocol/RequestAddCookies);
        clientconnectionmanager.removeResponseInterceptorByClass(org/apache/http/client/protocol/ResponseProcessCookies);
        clientconnectionmanager.setKeepAliveStrategy(new ShortKeepAliveStrategy());
        context = getProxyInfo(context);
        if (((HttpProxyInfo) (context)).enabled)
        {
            clientconnectionmanager.getParams().setParameter("http.route.default-proxy", ((HttpProxyInfo) (context)).httpHost);
        }
        return clientconnectionmanager;
    }

    protected HttpParams initializeHttpParams()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setSoTimeout(basichttpparams, 0x15f90);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        return basichttpparams;
    }

    protected SchemeRegistry initializeSchemeRegistry(Context context)
    {
        SchemeRegistry schemeregistry;
        try
        {
            schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", new PinningSSLSocketFactory(context), 443));
            schemeregistry.register(new Scheme("https+blob", new PinningSSLSocketFactory(context), 443));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new AssertionError(context);
        }
        return schemeregistry;
    }

    public abstract void restart();

    public abstract void shutdown();
}
