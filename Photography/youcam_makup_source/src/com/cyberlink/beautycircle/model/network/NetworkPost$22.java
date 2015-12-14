// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class d extends j
{

    final String a;
    final String b;
    final long c;
    final String d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.reportInappropriate == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.post.reportInappropriate);
            networkmanager.a("token", a);
            networkmanager.a("targetType", b);
            networkmanager.a("targetId", Long.valueOf(c));
            networkmanager.a("reason", d);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, String s1, long l, String s2)
    {
        a = s;
        b = s1;
        c = l;
        d = s2;
        super();
    }
}
