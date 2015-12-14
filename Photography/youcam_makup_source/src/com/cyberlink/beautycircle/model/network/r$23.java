// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            r, NetworkManager

final class b extends j
{

    final long a;
    final Long b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.queryProdInfo == null)
        {
            b(rkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.product.queryProdInfo);
            networkmanager.a("productId", Long.valueOf(a));
            networkmanager.a("userId", b);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    rkManager(long l, Long long1)
    {
        a = l;
        b = long1;
        super();
    }
}
