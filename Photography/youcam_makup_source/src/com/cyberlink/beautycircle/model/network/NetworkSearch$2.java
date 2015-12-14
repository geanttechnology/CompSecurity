// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkSearch, NetworkManager

final class b extends j
{

    final String a;
    final Long b;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.search.listRecentKeywordByUserId == null)
        {
            b(etworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.search.listRecentKeywordByUserId);
            networkmanager.a("type", a);
            networkmanager.a("curUserId", b);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(String s, Long long1)
    {
        a = s;
        b = long1;
        super();
    }
}
