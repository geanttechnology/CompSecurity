// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.os.AsyncTask;
import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.params.BasicHttpParams;

// Referenced classes of package com.flurry.android:
//            FlurryAppCloud, EasySSLSocketFactory, AppCloudResponseHandler, AppCloudResponseRequestManagerHandler

abstract class a extends AsyncTask
{

    protected HttpClient a;
    protected HttpHost b;
    protected AppCloudResponseHandler c;
    protected AppCloudResponseRequestManagerHandler d;
    protected HashMap e;

    protected a()
        throws Exception
    {
        a = null;
        b = null;
        d = null;
        e = null;
        try
        {
            b = new HttpHost(FlurryAppCloud.I(), 443, "https");
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("https", new EasySSLSocketFactory(), 443));
            BasicHttpParams basichttpparams = new BasicHttpParams();
            a = new DefaultHttpClient(new SingleClientConnManager(basichttpparams, schemeregistry), basichttpparams);
            return;
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    protected static void a(AbstractHttpMessage abstracthttpmessage, HashMap hashmap)
    {
        abstracthttpmessage.setHeader("Authorization", (String)hashmap.get("auth"));
        abstracthttpmessage.setHeader("APPCLOUD-USER-SESSION", (String)hashmap.get("session"));
    }

}
