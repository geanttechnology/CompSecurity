// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkContest, NetworkManager

final class a extends j
{

    final Long a;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.contest.deletePost == null)
        {
            b(workErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.contest.deletePost);
            networkmanager.a("postId", a);
            networkmanager.a("isDelete", Integer.valueOf(1));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    workErrorCode(Long long1)
    {
        a = long1;
        super();
    }
}
