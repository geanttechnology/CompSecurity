// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

// Referenced classes of package com.smule.android.network.core:
//            b

final class ute
    implements ConnPerRoute
{

    public int getMaxForRoute(HttpRoute httproute)
    {
        return 10;
    }

    ute()
    {
    }
}
