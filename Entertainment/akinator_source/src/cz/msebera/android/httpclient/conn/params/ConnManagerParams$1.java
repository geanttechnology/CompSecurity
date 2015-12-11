// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.params;

import cz.msebera.android.httpclient.conn.routing.HttpRoute;

// Referenced classes of package cz.msebera.android.httpclient.conn.params:
//            ConnPerRoute, ConnManagerParams

static final class 
    implements ConnPerRoute
{

    public int getMaxForRoute(HttpRoute httproute)
    {
        return 2;
    }

    ()
    {
    }
}
