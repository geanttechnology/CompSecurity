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

    final Long a;
    final long b;
    final String c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.user.userInfo == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.user.userInfo);
        if (a == null || b != a.longValue() || c == null)
        {
            networkmanager.a("userId", Long.valueOf(b));
            networkmanager.a("curUserId", a);
            return networkmanager;
        } else
        {
            networkmanager.a("token", c);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    (Long long1, long l, String s)
    {
        a = long1;
        b = l;
        c = s;
        super();
    }
}
