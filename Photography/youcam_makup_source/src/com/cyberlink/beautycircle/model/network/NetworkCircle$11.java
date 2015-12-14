// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkCircle, NetworkManager

final class e extends j
{

    final String a;
    final String b;
    final String c;
    final Long d;
    final Boolean e;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.circle.createCircle == null)
        {
            b(tworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.circle.createCircle);
            networkmanager.a("token", a);
            networkmanager.a("circleName", b);
            networkmanager.a("description", c);
            networkmanager.a("circleTypeId", d);
            networkmanager.a("isSecret", e);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode(String s, String s1, String s2, Long long1, Boolean boolean1)
    {
        a = s;
        b = s1;
        c = s2;
        d = long1;
        e = boolean1;
        super();
    }
}
