// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            f, NetworkManager

final class d extends j
{

    final Long a;
    final int b;
    final int c;
    final Integer d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.feed.listMyFeed == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.feed.listMyFeed);
        if (Globals.j())
        {
            networkmanager.a("postStatus", "Published");
            networkmanager.a("postStatus", "Auditing");
        }
        networkmanager.a("userId", a);
        networkmanager.a("offset", Integer.valueOf(b));
        networkmanager.a("limit", Integer.valueOf(c));
        networkmanager.a("init", d);
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(Long long1, int i, int k, Integer integer)
    {
        a = long1;
        b = i;
        c = k;
        d = integer;
        super();
    }
}
