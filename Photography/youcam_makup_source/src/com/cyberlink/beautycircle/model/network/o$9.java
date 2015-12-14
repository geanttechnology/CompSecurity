// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            o, NetworkManager

final class d extends j
{

    final String a;
    final String b;
    final int c;
    final int d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.notify.listNotify == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.notify.listNotify);
            networkmanager.a("token", a);
            networkmanager.a("type", b);
            networkmanager.a("offset", Integer.valueOf(c));
            networkmanager.a("limit", Integer.valueOf(d));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(String s, String s1, int i, int k)
    {
        a = s;
        b = s1;
        c = i;
        d = k;
        super();
    }
}
