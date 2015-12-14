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

    final Long a[];
    final Long b;
    final String c;
    final int d;
    final int e;

    protected u a(NetworkManager networkmanager)
    {
        int i = 0;
        if (networkmanager.e.post.listPostByUser == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.post.listPostByUser);
        networkmanager.a("postStatus", "Published");
        if (Globals.j())
        {
            networkmanager.a("postStatus", "Auditing");
        }
        if (a != null)
        {
            if (b != null && a.length == 1 && a[0] != null && a[0].equals(b))
            {
                networkmanager.a("postStatus", "Drafted");
            }
            Long along[] = a;
            for (int k = along.length; i < k; i++)
            {
                networkmanager.a("userId", along[i]);
            }

        }
        networkmanager.a("postStatus", c);
        networkmanager.a("curUserId", b);
        networkmanager.a("offset", Integer.valueOf(d));
        networkmanager.a("limit", Integer.valueOf(e));
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    (Long along[], Long long1, String s, int i, int k)
    {
        a = along;
        b = long1;
        c = s;
        d = i;
        e = k;
        super();
    }
}
