// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser, NetworkManager

final class d extends j
{

    final long a;
    final Long b;
    final int c;
    final int d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.user.listFollower == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.user.listFollower);
            networkmanager.a("userId", Long.valueOf(a));
            networkmanager.a("curUserId", b);
            networkmanager.a("offset", Integer.valueOf(c));
            networkmanager.a("limit", Integer.valueOf(d));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    (long l, Long long1, int i, int k)
    {
        a = l;
        b = long1;
        c = i;
        d = k;
        super();
    }
}
