// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            am

final class Route
    implements ConnPerRoute
{

    public int getMaxForRoute(HttpRoute httproute)
    {
        return 5;
    }

    Route()
    {
    }
}
