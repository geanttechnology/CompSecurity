// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn.tsccm:
//            RouteSpecificPool

class this._cls0
    implements ConnPerRoute
{

    final RouteSpecificPool this$0;

    public int getMaxForRoute(HttpRoute httproute)
    {
        return maxEntries;
    }

    ()
    {
        this$0 = RouteSpecificPool.this;
        super();
    }
}
