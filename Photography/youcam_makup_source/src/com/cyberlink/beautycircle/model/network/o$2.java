// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            o, NetworkManager

final class b extends j
{

    final String a;
    final ArrayList b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.notify.setNotifySetting == null)
        {
            b(orkManager.NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.notify.setNotifySetting);
        networkmanager.a("token", a);
        if (b != null)
        {
            for (Iterator iterator = b.iterator(); iterator.hasNext(); networkmanager.a("nonNotifyType", (String)iterator.next())) { }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    orkManager(String s, ArrayList arraylist)
    {
        a = s;
        b = arraylist;
        super();
    }
}
