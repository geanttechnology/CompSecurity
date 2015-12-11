// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.atomic.AtomicBoolean;

final class akr
    implements cfv
{

    private cgw a;
    private akt b;
    private akq c;

    akr(akq akq1, cgw cgw1, akt akt1)
    {
        c = akq1;
        a = cgw1;
        b = akt1;
        super();
    }

    public final void a(cgw cgw1)
    {
        akj.a(c.a).a("Trying to wake-up %s with id %s, found: %s with id %s ", new Object[] {
            a.c, a.g, cgw1.c, cgw1.g
        });
        if (cgw1.g.equals(a.g) && !b.b.getAndSet(true))
        {
            akj.a(c.a);
            String s = String.valueOf(cgw1.c);
            if (s.length() != 0)
            {
                "Successful wake-up of ".concat(s);
            } else
            {
                new String("Successful wake-up of ");
            }
            akj.a(c.a, new als(cgw1));
            c.a.a(cgw1, b.a);
        }
    }
}
