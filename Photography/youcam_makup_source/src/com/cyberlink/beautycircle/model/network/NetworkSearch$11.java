// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkSearch, NetworkManager

final class tworkErrorCode extends j
{

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.search.listTopPostKeyword == null)
        {
            b(tworkErrorCode.c.a());
            return null;
        } else
        {
            return new u(networkmanager.e.search.listTopPostKeyword);
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    tworkErrorCode()
    {
    }
}
