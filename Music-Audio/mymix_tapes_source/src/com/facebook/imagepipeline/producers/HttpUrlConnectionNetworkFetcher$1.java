// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            HttpUrlConnectionNetworkFetcher, FetchState

class val.callback
    implements Runnable
{

    final HttpUrlConnectionNetworkFetcher this$0;
    final val.callback val$callback;
    final FetchState val$fetchState;

    public void run()
    {
        Object obj;
        Object obj3;
        Object obj4;
        obj = null;
        obj4 = val$fetchState.getUri().getScheme();
        obj3 = val$fetchState.getUri().toString();
_L7:
        Object obj2 = obj;
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(((String) (obj3)))).openConnection();
        obj2 = httpurlconnection;
        obj = httpurlconnection;
        Object obj5 = httpurlconnection.getHeaderField("Location");
        if (obj5 != null) goto _L2; else goto _L1
_L1:
        obj3 = null;
_L6:
        if (obj5 == null) goto _L4; else goto _L3
_L3:
        obj2 = httpurlconnection;
        obj = httpurlconnection;
        if (!((String) (obj3)).equals(obj4)) goto _L5; else goto _L4
_L4:
        obj2 = httpurlconnection;
        obj = httpurlconnection;
        obj3 = httpurlconnection.getInputStream();
        obj2 = httpurlconnection;
        obj = httpurlconnection;
        val$callback.(((java.io.InputStream) (obj3)), -1);
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
_L9:
        return;
_L2:
        obj2 = httpurlconnection;
        obj = httpurlconnection;
        obj3 = Uri.parse(((String) (obj5))).getScheme();
          goto _L6
_L5:
        obj2 = obj5;
        obj5 = obj3;
        obj = httpurlconnection;
        obj4 = obj5;
        obj3 = obj2;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            obj = httpurlconnection;
            obj4 = obj5;
            obj3 = obj2;
        }
          goto _L7
        Object obj1;
        obj1;
        obj = obj2;
        val$callback.callback(((Throwable) (obj1)));
        if (obj2 == null) goto _L9; else goto _L8
_L8:
        ((HttpURLConnection) (obj2)).disconnect();
        return;
        obj1;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw obj1;
          goto _L6
    }

    ()
    {
        this$0 = final_httpurlconnectionnetworkfetcher;
        val$fetchState = fetchstate;
        val$callback = val.callback.this;
        super();
    }
}
