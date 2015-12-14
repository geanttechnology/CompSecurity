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

    final long a;
    final long b;
    final int c;
    final int d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.notify.listNotifyReference == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.notify.listNotifyReference);
            networkmanager.a("nId", Long.valueOf(a));
            networkmanager.a("curUserId", Long.valueOf(b));
            networkmanager.a("offset", Integer.valueOf(c));
            networkmanager.a("limit", Integer.valueOf(d));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(long l, long l1, int i, int k)
    {
        a = l;
        b = l1;
        c = i;
        d = k;
        super();
    }
}
