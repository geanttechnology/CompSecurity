// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            r, NetworkManager

final class c extends j
{

    final long a;
    final int b;
    final int c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.listProductFeatureByUser == null)
        {
            b(rkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.product.listProductFeatureByUser);
            networkmanager.a("userId", Long.valueOf(a));
            networkmanager.a("offset", Integer.valueOf(b));
            networkmanager.a("limit", Integer.valueOf(c));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    rkManager(long l, int i, int k)
    {
        a = l;
        b = i;
        c = k;
        super();
    }
}
