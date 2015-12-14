// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class c extends j
{

    final String a;
    final String b;
    final long c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.unlike == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.post.unlike);
            networkmanager.a("token", a);
            networkmanager.a("targetType", b);
            networkmanager.a("targetId", Long.valueOf(c));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    (String s, String s1, long l)
    {
        a = s;
        b = s1;
        c = l;
        super();
    }
}
