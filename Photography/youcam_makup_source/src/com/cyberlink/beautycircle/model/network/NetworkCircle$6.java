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

    final long a;
    final long b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.circle.listCircleByUser == null)
        {
            b(etworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.circle.listCircleByUser);
            networkmanager.a("userId", Long.valueOf(a));
            networkmanager.a("curUserId", Long.valueOf(b));
            networkmanager.a("responseType", "Basic");
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(long l, long l1)
    {
        a = l;
        b = l1;
        super();
    }
}
