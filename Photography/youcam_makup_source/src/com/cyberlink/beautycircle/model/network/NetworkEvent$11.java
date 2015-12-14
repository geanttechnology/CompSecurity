// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkEvent, NetworkManager

final class e extends j
{

    final long a;
    final Long b;
    final String c[];
    final Integer d;
    final Integer e;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.event.listEventUser == null)
        {
            b(etworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.event.listEventUser);
        networkmanager.a("brandEventId", Long.valueOf(a));
        networkmanager.a("curUserId", b);
        if (c != null)
        {
            String as[] = c;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                networkmanager.a("eventUserStatus", as[i]);
            }

        }
        networkmanager.a("offset", d);
        networkmanager.a("limit", e);
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(long l, Long long1, String as[], Integer integer, Integer integer1)
    {
        a = l;
        b = long1;
        c = as;
        d = integer;
        e = integer1;
        super();
    }
}
