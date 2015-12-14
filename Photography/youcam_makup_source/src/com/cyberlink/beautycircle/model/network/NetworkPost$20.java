// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class h extends j
{

    final Long a;
    final Long b;
    final String c;
    final String d;
    final String e;
    final Long f;
    final Integer g;
    final Integer h;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.listPostByCircle == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.post.listPostByCircle);
        if (Globals.j())
        {
            networkmanager.a("postStatus", "Published");
            networkmanager.a("postStatus", "Auditing");
        }
        networkmanager.a("circleId", a);
        networkmanager.a("circleTypeId", b);
        networkmanager.a("postStatus", c);
        networkmanager.a("defaultType", d);
        networkmanager.a("sortBy", e);
        networkmanager.a("curUserId", f);
        networkmanager.a("offset", Integer.valueOf(g.intValue()));
        networkmanager.a("limit", h);
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(Long long1, Long long2, String s, String s1, String s2, Long long3, Integer integer, 
            Integer integer1)
    {
        a = long1;
        b = long2;
        c = s;
        d = s1;
        e = s2;
        f = long3;
        g = integer;
        h = integer1;
        super();
    }
}
