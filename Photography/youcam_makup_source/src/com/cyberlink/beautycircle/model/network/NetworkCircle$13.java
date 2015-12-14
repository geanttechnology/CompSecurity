// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkCircle, NetworkManager

final class e extends j
{

    final long a;
    final long b;
    final Long c;
    final int d;
    final int e;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.circle.listFollowerByCircle == null)
        {
            b(tworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.circle.listFollowerByCircle);
            networkmanager.a("circleId", Long.valueOf(a));
            networkmanager.a("circleCreatorId", Long.valueOf(b));
            networkmanager.a("curUserId", c);
            networkmanager.a("offset", Integer.valueOf(d));
            networkmanager.a("limit", Integer.valueOf(e));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode(long l, long l1, Long long1, int i, int k)
    {
        a = l;
        b = l1;
        c = long1;
        d = i;
        e = k;
        super();
    }
}
