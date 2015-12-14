// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkCircle, NetworkManager

final class c extends j
{

    final Long a;
    final Long b;
    final Long c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.circle.getCircleInfo == null)
        {
            b(etworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.circle.getCircleInfo);
            networkmanager.a("circleId", a);
            networkmanager.a("circleCreatorId", b);
            networkmanager.a("curUserId", c);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(Long long1, Long long2, Long long3)
    {
        a = long1;
        b = long2;
        c = long3;
        super();
    }
}
