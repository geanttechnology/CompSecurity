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
    final Long b;
    final Integer c;
    final Integer d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.search.searchCircle == null)
        {
            b(etworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.search.searchCircle);
            networkmanager.a("keyword", a);
            networkmanager.a("curUserId", b);
            networkmanager.a("offset", c);
            networkmanager.a("limit", d);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(String s, Long long1, Integer integer, Integer integer1)
    {
        a = s;
        b = long1;
        c = integer;
        d = integer1;
        super();
    }
}
