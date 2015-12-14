// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkFile, NetworkManager

final class f extends j
{

    final String a;
    final leType b;
    final byte c[];
    final String d;
    final String e;
    final String f;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.file.uploadFile == null)
        {
            b(.NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.file.uploadFile);
            networkmanager.a("token", a);
            networkmanager.a("fileType", b);
            networkmanager.a("fileBean", c, d, e);
            networkmanager.a("metadata", f);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    leType(String s, leType letype, byte abyte0[], String s1, String s2, String s3)
    {
        a = s;
        b = letype;
        c = abyte0;
        d = s1;
        e = s2;
        f = s3;
        super();
    }
}
