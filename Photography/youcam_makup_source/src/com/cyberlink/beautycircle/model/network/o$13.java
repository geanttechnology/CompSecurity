// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            o, NetworkManager

final class a extends j
{

    final long a;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.notify.getNotifySetting == null)
        {
            b(rkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.notify.getNotifySetting);
            networkmanager.a("userId", Long.valueOf(a));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    rkManager(long l)
    {
        a = l;
        super();
    }
}
