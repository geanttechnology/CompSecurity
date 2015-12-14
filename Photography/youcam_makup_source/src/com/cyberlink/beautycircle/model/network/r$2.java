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

    final int a;
    final int b;
    final String c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.product.listProdByText == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.product.listProdByText);
            networkmanager.a("offset", Integer.valueOf(a));
            networkmanager.a("limit", Integer.valueOf(b));
            networkmanager.a("keyword", c);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(int i, int k, String s)
    {
        a = i;
        b = k;
        c = s;
        super();
    }
}
