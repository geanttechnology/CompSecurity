// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.i;

import com.shazam.h.a;
import com.shazam.h.aa;
import com.shazam.h.e;
import com.shazam.h.g;
import com.shazam.i.b.ah.f;

public final class b
{

    private static final e a;

    public static e a()
    {
        return a;
    }

    public static e b()
    {
        return c().a();
    }

    private static com.shazam.h.e.a c()
    {
        com.shazam.h.e.a a1 = (new com.shazam.h.e.a()).a(new aa());
        a1.a = 40000;
        a1.b = 60000;
        a1.c = true;
        a1.g = new com.shazam.h.c.b();
        a1.d = false;
        return a1;
    }

    static 
    {
        com.shazam.h.e.a a1 = c().a(new g("Content-Language", f.a().h("pk_locale"))).a(new a(com.shazam.i.b.ah.b.a.a(), com.shazam.i.b.m.a.a(), com.shazam.i.b.n.b.s()));
        a1.h = "A3r_ISAAC_eQeY2Bh";
        a = a1.a();
    }
}
