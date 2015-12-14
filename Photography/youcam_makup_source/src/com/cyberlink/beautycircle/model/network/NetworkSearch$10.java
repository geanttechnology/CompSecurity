// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkSearch, NetworkManager

final class d extends j
{

    final String a;
    final Integer b;
    final Integer c;
    final Long d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.search.searchPost == null)
        {
            b(tworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.search.searchPost);
            networkmanager.a("keyword", a);
            networkmanager.a("offset", b);
            networkmanager.a("limit", c);
            networkmanager.a("curUserId", d);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode(String s, Integer integer, Integer integer1, Long long1)
    {
        a = s;
        b = integer;
        c = integer1;
        d = long1;
        super();
    }
}
