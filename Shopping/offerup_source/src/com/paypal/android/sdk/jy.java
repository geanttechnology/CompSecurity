// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Proxy;

// Referenced classes of package com.paypal.android.sdk:
//            ki, ju, jl, kb, 
//            gu, kz, jz, gq, 
//            fy, gx, ji, gw, 
//            lh, kd, gv

public final class jy
    implements ki
{

    private final ju a;
    private final jl b;

    public jy(ju ju1, jl jl1)
    {
        a = ju1;
        b = jl1;
    }

    public final gw a(gu gu1)
    {
        lj lj;
        if (!ju.a(gu1))
        {
            lj = b.b(0L);
        } else
        if ("chunked".equalsIgnoreCase(gu1.a("Transfer-Encoding")))
        {
            lj = b.a(a);
        } else
        {
            long l = jz.a(gu1);
            if (l != -1L)
            {
                lj = b.b(l);
            } else
            {
                lj = b.i();
            }
        }
        return new kb(gu1.g(), kz.a(lj));
    }

    public final lh a(gq gq1, long l)
    {
        if ("chunked".equalsIgnoreCase(gq1.a("Transfer-Encoding")))
        {
            return b.h();
        }
        if (l != -1L)
        {
            return b.a(l);
        } else
        {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public final void a()
    {
        b.d();
    }

    public final void a(gq gq1)
    {
        a.b();
        Object obj = a.f().b().b.type();
        gp gp = a.f().k();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(gq1.d());
        stringbuilder.append(' ');
        boolean flag;
        if (!gq1.j() && obj == java.net.Proxy.Type.HTTP)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            stringbuilder.append(gq1.a());
        } else
        {
            stringbuilder.append(ji.a(gq1.a()));
        }
        stringbuilder.append(' ');
        stringbuilder.append(ji.a(gp));
        obj = stringbuilder.toString();
        b.a(gq1.e(), ((String) (obj)));
    }

    public final void a(ju ju1)
    {
        b.a(ju1);
    }

    public final void a(kd kd)
    {
        b.a(kd);
    }

    public final gv b()
    {
        return b.g();
    }

    public final void c()
    {
        if (d())
        {
            b.a();
            return;
        } else
        {
            b.b();
            return;
        }
    }

    public final boolean d()
    {
        while ("close".equalsIgnoreCase(a.d().a("Connection")) || "close".equalsIgnoreCase(a.e().a("Connection")) || b.c()) 
        {
            return false;
        }
        return true;
    }
}
