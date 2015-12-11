// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.ProtocolException;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            gl, ju, gn, gk, 
//            fy, gx, gq, gi, 
//            fl, ki, gs, kz, 
//            kr, gu, gw

final class jx
    implements gl
{

    private final int a;
    private final gq b;
    private int c;
    private ju d;

    jx(ju ju1, int i, gq gq1)
    {
        d = ju1;
        super();
        a = i;
        b = gq1;
    }

    public final gq a()
    {
        return b;
    }

    public final gu a(gq gq1)
    {
        c = c + 1;
        if (a > 0)
        {
            gk gk1 = (gk)d.a.v().get(a - 1);
            fl fl1 = ju.a(d).b().a;
            if (!gq1.a().g().equals(fl1.a) || gq1.a().h() != fl1.b)
            {
                throw new IllegalStateException((new StringBuilder("network interceptor ")).append(gk1).append(" must retain the same host and port").toString());
            }
            if (c > 1)
            {
                throw new IllegalStateException((new StringBuilder("network interceptor ")).append(gk1).append(" must call proceed() exactly once").toString());
            }
        }
        if (a >= d.a.v().size()) goto _L2; else goto _L1
_L1:
        jx jx1 = new jx(d, a + 1, gq1);
        gk gk2 = (gk)d.a.v().get(a);
        gq1 = gk2.a(jx1);
        if (jx1.c != 1)
        {
            throw new IllegalStateException((new StringBuilder("network interceptor ")).append(gk2).append(" must call proceed() exactly once").toString());
        }
_L4:
        return gq1;
_L2:
        gu gu1;
        int i;
        ju.b(d).a(gq1);
        ju.a(d, gq1);
        if (d.c() && gq1.f() != null)
        {
            kr kr1 = kz.a(ju.b(d).a(gq1, gq1.f().b()));
            gq1.f().a(kr1);
            kr1.close();
        }
        gu1 = ju.c(d);
        i = gu1.c();
        if (i == 204)
        {
            break; /* Loop/switch isn't completed */
        }
        gq1 = gu1;
        if (i != 205) goto _L4; else goto _L3
_L3:
        gq1 = gu1;
        if (gu1.h().b() > 0L)
        {
            throw new ProtocolException((new StringBuilder("HTTP ")).append(i).append(" had non-zero Content-Length: ").append(gu1.h().b()).toString());
        }
        if (true) goto _L4; else goto _L5
_L5:
    }
}
