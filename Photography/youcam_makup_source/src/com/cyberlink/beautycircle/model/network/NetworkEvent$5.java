// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkEvent, NetworkManager

final class b extends j
{

    final String a;
    final inEventParam b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.event.joinEvent == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        }
        if (a == null || b == null)
        {
            b(NetworkErrorCode.b.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.event.joinEvent);
            networkmanager.a("token", a);
            networkmanager.a(b);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    inEventParam(String s, inEventParam ineventparam)
    {
        a = s;
        b = ineventparam;
        super();
    }
}
