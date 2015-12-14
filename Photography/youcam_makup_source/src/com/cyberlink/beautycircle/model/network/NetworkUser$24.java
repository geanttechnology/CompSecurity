// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser, NetworkManager

final class d extends j
{

    final ArrayList a;
    final Long b;
    final int c;
    final int d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.user.listByType == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.user.listByType);
        if (a != null)
        {
            for (Iterator iterator = a.iterator(); iterator.hasNext(); networkmanager.a("userType", (String)iterator.next())) { }
        }
        networkmanager.a("curUserId", b);
        networkmanager.a("offset", Integer.valueOf(c));
        networkmanager.a("limit", Integer.valueOf(d));
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(ArrayList arraylist, Long long1, int i, int k)
    {
        a = arraylist;
        b = long1;
        c = i;
        d = k;
        super();
    }
}
