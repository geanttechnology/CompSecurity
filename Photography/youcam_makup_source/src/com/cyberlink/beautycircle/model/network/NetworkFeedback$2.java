// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkFeedback, g, h, NetworkManager

final class b extends j
{

    final String a;
    final g b;

    protected u a(NetworkManager networkmanager)
    {
        if (a == null)
        {
            b(workErrorCode.c.a());
            return null;
        }
        if (b == null)
        {
            b(workErrorCode.b.a());
            return null;
        }
        networkmanager = new u(a);
        networkmanager.a("product", b.a);
        networkmanager.a("version", b.b);
        networkmanager.a("versiontype", b.c);
        networkmanager.a("timezone", b.d);
        networkmanager.a("platform", b.e);
        networkmanager.a("osversion", b.f);
        networkmanager.a("sr", b.g);
        networkmanager.a("lang", b.h);
        networkmanager.a("model", b.i);
        networkmanager.a("vendor", b.j);
        networkmanager.a("resolution", b.k);
        networkmanager.a("hwid", b.l);
        networkmanager.a("phoneid", b.m);
        networkmanager.a("appversion", b.n);
        networkmanager.a("email", b.o);
        networkmanager.a("question", b.p);
        networkmanager.a("umaid", b.r);
        networkmanager.a("codename", b.s);
        networkmanager.a("rooted", b.t);
        if (b.q != null)
        {
            Iterator iterator = b.q.iterator();
            int i = 0;
            h h1;
            StringBuilder stringbuilder;
            for (; iterator.hasNext(); networkmanager.a(stringbuilder.append(i).toString(), h1.e, h1.c, h1.a))
            {
                h1 = (h)iterator.next();
                stringbuilder = (new StringBuilder()).append("attachment");
                i++;
            }

        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    workErrorCode(String s, g g1)
    {
        a = s;
        b = g1;
        super();
    }
}
