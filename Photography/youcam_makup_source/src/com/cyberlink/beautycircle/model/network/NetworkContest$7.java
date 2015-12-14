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

    final String a;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.contest.contestList == null)
        {
            b(tworkErrorCode.c.a());
            networkmanager = null;
        } else
        {
            u u1 = new u(networkmanager.e.contest.contestList);
            networkmanager = u1;
            if (a != null)
            {
                u1.b("locale");
                u1.a("locale", a);
                return u1;
            }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode(String s)
    {
        a = s;
        super();
    }
}
