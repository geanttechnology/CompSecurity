// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkEvent, NetworkManager

final class b extends j
{

    final Long a;
    final String b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.event.listBrandEvent == null)
        {
            b(NetworkErrorCode.c.a());
            networkmanager = null;
        } else
        {
            u u1 = new u(networkmanager.e.event.listBrandEvent);
            u1.a("curUserId", a);
            networkmanager = u1;
            if (b != null)
            {
                u1.b("locale");
                u1.a("locale", b);
                return u1;
            }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(Long long1, String s)
    {
        a = long1;
        b = s;
        super();
    }
}
