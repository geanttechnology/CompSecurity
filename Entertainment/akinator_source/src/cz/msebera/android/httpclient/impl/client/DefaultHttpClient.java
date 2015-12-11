// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import cz.msebera.android.httpclient.client.protocol.RequestProxyAuthentication;
import cz.msebera.android.httpclient.client.protocol.RequestTargetAuthentication;
import cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.params.SyncBasicHttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestExpectContinue;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import java.nio.charset.Charset;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            AbstractHttpClient, HttpClientBuilder

public class DefaultHttpClient extends AbstractHttpClient
{

    public DefaultHttpClient()
    {
        super(null, null);
    }

    public DefaultHttpClient(ClientConnectionManager clientconnectionmanager)
    {
        super(clientconnectionmanager, null);
    }

    public DefaultHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        super(clientconnectionmanager, httpparams);
    }

    public DefaultHttpClient(HttpParams httpparams)
    {
        super(null, httpparams);
    }

    public static void setDefaultHttpParams(HttpParams httpparams)
    {
        HttpProtocolParams.setVersion(httpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(httpparams, HTTP.DEF_CONTENT_CHARSET.name());
        HttpConnectionParams.setTcpNoDelay(httpparams, true);
        HttpConnectionParams.setSocketBufferSize(httpparams, 8192);
        HttpProtocolParams.setUserAgent(httpparams, HttpClientBuilder.DEFAULT_USER_AGENT);
    }

    protected HttpParams createHttpParams()
    {
        SyncBasicHttpParams syncbasichttpparams = new SyncBasicHttpParams();
        setDefaultHttpParams(syncbasichttpparams);
        return syncbasichttpparams;
    }

    protected BasicHttpProcessor createHttpProcessor()
    {
        BasicHttpProcessor basichttpprocessor = new BasicHttpProcessor();
        basichttpprocessor.addInterceptor(new RequestDefaultHeaders());
        basichttpprocessor.addInterceptor(new RequestContent());
        basichttpprocessor.addInterceptor(new RequestTargetHost());
        basichttpprocessor.addInterceptor(new RequestClientConnControl());
        basichttpprocessor.addInterceptor(new RequestUserAgent());
        basichttpprocessor.addInterceptor(new RequestExpectContinue());
        basichttpprocessor.addInterceptor(new RequestAddCookies());
        basichttpprocessor.addInterceptor(new ResponseProcessCookies());
        basichttpprocessor.addInterceptor(new RequestAuthCache());
        basichttpprocessor.addInterceptor(new RequestTargetAuthentication());
        basichttpprocessor.addInterceptor(new RequestProxyAuthentication());
        return basichttpprocessor;
    }
}
