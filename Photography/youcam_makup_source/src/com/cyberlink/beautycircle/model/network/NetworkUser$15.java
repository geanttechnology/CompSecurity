// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkUser, NetworkManager

final class n extends j
{

    final String a;
    final String b;
    final Long c;
    final Long d;
    final String e;
    final String f;
    final String g;
    final String h;
    final String i;
    final String j;
    final String k;
    final String l;
    final String m;
    final String n;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.user.updateUser == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        } else
        {
            networkmanager = new u(networkmanager.e.user.updateUser);
            networkmanager.a("token", a);
            networkmanager.a("displayName", b);
            networkmanager.a("avatarId", c);
            networkmanager.a("coverId", d);
            networkmanager.a("description", e);
            networkmanager.a("gender", f);
            networkmanager.a("region", g);
            networkmanager.a("birthDay", h);
            networkmanager.a("attrs", i);
            networkmanager.a("name", j);
            networkmanager.a("phone", k);
            networkmanager.a("receiveEmail", l);
            networkmanager.a("address", m);
            networkmanager.a("websiteUrl", n);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, String s1, Long long1, Long long2, String s2, String s3, String s4, 
            String s5, String s6, String s7, String s8, String s9, String s10, String s11)
    {
        a = s;
        b = s1;
        c = long1;
        d = long2;
        e = s2;
        f = s3;
        g = s4;
        h = s5;
        i = s6;
        j = s7;
        k = s8;
        l = s9;
        m = s10;
        n = s11;
        super();
    }
}
