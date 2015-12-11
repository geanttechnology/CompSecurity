// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            a

final class a
    implements ConnPerRoute
{

    final a a;

    public final int getMaxForRoute(HttpRoute httproute)
    {
        return 5;
    }

    g.HttpRoute(a a1)
    {
        a = a1;
        super();
    }
}
