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

    final String a;
    final long b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.deleteComment == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.product.deleteComment);
            networkmanager.a("token", a);
            networkmanager.a("commentId", Long.valueOf(b));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(String s, long l)
    {
        a = s;
        b = l;
        super();
    }
}
