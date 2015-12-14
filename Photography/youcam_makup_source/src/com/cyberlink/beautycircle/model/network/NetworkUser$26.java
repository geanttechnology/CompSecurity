// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser, NetworkManager

final class c extends j
{

    final String a;
    final Long b;
    final String c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.user.reportUser == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.user.reportUser);
            networkmanager.a("token", a);
            networkmanager.a("targetId", b);
            networkmanager.a("reason", c);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, Long long1, String s1)
    {
        a = s;
        b = long1;
        c = s1;
        super();
    }
}
