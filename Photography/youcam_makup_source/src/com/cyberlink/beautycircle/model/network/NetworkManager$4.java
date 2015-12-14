// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.you.u;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager

final class a extends j
{

    final NetworkManager a;

    protected volatile Object a(Object obj)
    {
        return a((String)obj);
    }

    protected Void a(String s)
    {
        NetworkManager.b(a, s);
        u.a(a.e.search.searchPeople);
        return null;
    }

    .Search(NetworkManager networkmanager)
    {
        a = networkmanager;
        super();
    }
}
