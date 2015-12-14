// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.Tags;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class e extends j
{

    final String a;
    final String b;
    final long c;
    final String d;
    final Tags e;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.createComment == null)
        {
            b(NetworkErrorCode.c.a());
            networkmanager = null;
        } else
        {
            u u1 = new u(networkmanager.e.post.createComment);
            u1.a("token", a);
            u1.a("targetType", b);
            u1.a("targetId", Long.valueOf(c));
            u1.a("comment", d);
            networkmanager = u1;
            if (e != null)
            {
                u1.a("tags", e.toString());
                return u1;
            }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, String s1, long l, String s2, Tags tags)
    {
        a = s;
        b = s1;
        c = l;
        d = s2;
        e = tags;
        super();
    }
}
