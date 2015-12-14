// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkCircle, NetworkManager

final class b extends j
{

    final Integer a;
    final Integer b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.circle.listCircleType == null)
        {
            b(tworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.circle.listCircleType);
            networkmanager.a("offset", a);
            networkmanager.a("limit", b);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode(Integer integer, Integer integer1)
    {
        a = integer;
        b = integer1;
        super();
    }
}
