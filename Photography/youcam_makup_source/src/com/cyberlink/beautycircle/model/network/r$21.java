// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            r, NetworkManager

final class e extends j
{

    final int a;
    final int b;
    final long c;
    final long d;
    final long e;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.listProducts == null)
        {
            b(rkManager.NetworkErrorCode.c.a());
            networkmanager = null;
        } else
        {
            u u1 = new u(networkmanager.e.product.listProducts);
            u1.a("offset", Integer.valueOf(a));
            u1.a("limit", Integer.valueOf(b));
            if (c > 0L)
            {
                u1.a("brandId", Long.valueOf(c));
            }
            if (d > 0L)
            {
                u1.a("typeId", Long.valueOf(d));
            }
            networkmanager = u1;
            if (e > 0L)
            {
                u1.a("priceRangeId", Long.valueOf(e));
                return u1;
            }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    rkManager(int i, int k, long l, long l1, long l2)
    {
        a = i;
        b = k;
        c = l;
        d = l1;
        e = l2;
        super();
    }
}
