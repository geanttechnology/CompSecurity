// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            o, NetworkManager

final class c extends j
{

    final long a;
    final long b;
    final String c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.notify.setNotifyReaded == null)
        {
            b(rkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.notify.setNotifyReaded);
            networkmanager.a("userId", Long.valueOf(a));
            networkmanager.a("createTime", Long.valueOf(b));
            networkmanager.a("type", c);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    rkManager(long l, long l1, String s)
    {
        a = l;
        b = l1;
        c = s;
        super();
    }
}
