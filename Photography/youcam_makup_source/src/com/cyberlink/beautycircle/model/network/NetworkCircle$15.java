// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkCircle, NetworkManager

final class f extends j
{

    final String a;
    final Long b;
    final String c;
    final String d;
    final Long e;
    final Boolean f;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.circle.updateCircle == null)
        {
            b(tworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.circle.updateCircle);
            networkmanager.a("token", a);
            networkmanager.a("circleId", b);
            networkmanager.a("circleName", c);
            networkmanager.a("description", d);
            networkmanager.a("circleTypeId", e);
            networkmanager.a("isSecret", f);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode(String s, Long long1, String s1, String s2, Long long2, Boolean boolean1)
    {
        a = s;
        b = long1;
        c = s1;
        d = s2;
        e = long2;
        f = boolean1;
        super();
    }
}
