// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            r, NetworkManager

final class d extends j
{

    final int a;
    final int b;
    final long c;
    final Long d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.listComment == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.product.listComment);
            networkmanager.a("offset", Integer.valueOf(a));
            networkmanager.a("limit", Integer.valueOf(b));
            networkmanager.a("productId", Long.valueOf(c));
            networkmanager.a("userId", d);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(int i, int k, long l, Long long1)
    {
        a = i;
        b = k;
        c = l;
        d = long1;
        super();
    }
}
