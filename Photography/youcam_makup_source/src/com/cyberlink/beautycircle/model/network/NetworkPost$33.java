// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class e extends j
{

    final long a;
    final String b;
    final Long c;
    final Integer d;
    final Integer e;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.listRelatedPost == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.post.listRelatedPost);
        networkmanager.a("postStatus", "Published");
        if (Globals.j())
        {
            networkmanager.a("postStatus", "Auditing");
        }
        networkmanager.a("postId", Long.valueOf(a));
        networkmanager.a("postStatus", b);
        networkmanager.a("curUserId", c);
        networkmanager.a("offset", d);
        networkmanager.a("limit", e);
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(long l, String s, Long long1, Integer integer, Integer integer1)
    {
        a = l;
        b = s;
        c = long1;
        d = integer;
        e = integer1;
        super();
    }
}
