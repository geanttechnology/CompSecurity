// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            b, NetworkManager

final class b extends j
{

    final int a;
    final int b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.campaign.listGroup == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.campaign.listGroup);
            networkmanager.a("offset", Integer.valueOf(a));
            networkmanager.a("limit", Integer.valueOf(b));
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(int i, int k)
    {
        a = i;
        b = k;
        super();
    }
}
