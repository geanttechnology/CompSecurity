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

    final String a;
    final long b;
    final String c;
    final float d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.updateComment == null)
        {
            b(rkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.product.updateComment);
            networkmanager.a("token", a);
            networkmanager.a("productId", Long.valueOf(b));
            networkmanager.a("comment", c);
            networkmanager.a("rating", Float.valueOf(d));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    rkManager(String s, long l, String s1, float f)
    {
        a = s;
        b = l;
        c = s1;
        d = f;
        super();
    }
}
