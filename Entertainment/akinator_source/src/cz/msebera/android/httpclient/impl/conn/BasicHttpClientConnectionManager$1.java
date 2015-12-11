// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import java.util.concurrent.TimeUnit;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            BasicHttpClientConnectionManager

class val.state
    implements ConnectionRequest
{

    final BasicHttpClientConnectionManager this$0;
    final HttpRoute val$route;
    final Object val$state;

    public boolean cancel()
    {
        return false;
    }

    public HttpClientConnection get(long l, TimeUnit timeunit)
    {
        return getConnection(val$route, val$state);
    }

    ()
    {
        this$0 = final_basichttpclientconnectionmanager;
        val$route = httproute;
        val$state = Object.this;
        super();
    }
}
