// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class b extends j
{

    final long a;
    final Long b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.queryCompletePostById == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.post.queryCompletePostById);
            networkmanager.a("postId", Long.valueOf(a));
            networkmanager.a("curUserId", b);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    (long l, Long long1)
    {
        a = l;
        b = long1;
        super();
    }
}
