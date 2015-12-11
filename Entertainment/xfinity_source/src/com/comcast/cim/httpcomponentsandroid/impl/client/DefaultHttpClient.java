// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpVersion;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestAddCookies;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestAuthCache;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestClientConnControl;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestDefaultHeaders;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestProxyAuthentication;
import com.comcast.cim.httpcomponentsandroid.client.protocol.RequestTargetAuthentication;
import com.comcast.cim.httpcomponentsandroid.client.protocol.ResponseAuthCache;
import com.comcast.cim.httpcomponentsandroid.client.protocol.ResponseProcessCookies;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionManager;
import com.comcast.cim.httpcomponentsandroid.params.HttpConnectionParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import com.comcast.cim.httpcomponentsandroid.params.SyncBasicHttpParams;
import com.comcast.cim.httpcomponentsandroid.protocol.BasicHttpProcessor;
import com.comcast.cim.httpcomponentsandroid.protocol.RequestContent;
import com.comcast.cim.httpcomponentsandroid.protocol.RequestExpectContinue;
import com.comcast.cim.httpcomponentsandroid.protocol.RequestTargetHost;
import com.comcast.cim.httpcomponentsandroid.protocol.RequestUserAgent;
import com.comcast.cim.httpcomponentsandroid.util.VersionInfo;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.client:
//            AbstractHttpClient

public class DefaultHttpClient extends AbstractHttpClient
{

    public DefaultHttpClient()
    {
        super(null, null);
    }

    public DefaultHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        super(clientconnectionmanager, httpparams);
    }

    public static void setDefaultHttpParams(HttpParams httpparams)
    {
        HttpProtocolParams.setVersion(httpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(httpparams, "ISO-8859-1");
        HttpConnectionParams.setTcpNoDelay(httpparams, true);
        HttpConnectionParams.setSocketBufferSize(httpparams, 8192);
        Object obj = VersionInfo.loadVersionInfo("com.comcast.cim.httpcomponentsandroid.client", com/comcast/cim/httpcomponentsandroid/impl/client/DefaultHttpClient.getClassLoader());
        if (obj != null)
        {
            obj = ((VersionInfo) (obj)).getRelease();
        } else
        {
            obj = "UNAVAILABLE";
        }
        HttpProtocolParams.setUserAgent(httpparams, (new StringBuilder()).append("Apache-HttpClient/").append(((String) (obj))).append(" (java 1.5)").toString());
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
        basichttpprocessor.addInterceptor(new ResponseAuthCache());
        basichttpprocessor.addInterceptor(new RequestTargetAuthentication());
        basichttpprocessor.addInterceptor(new RequestProxyAuthentication());
        return basichttpprocessor;
    }
}
