// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;

final class azo
    implements Runnable
{

    private String a;
    private String b;
    private azk c;

    azo(azk azk1, String s, String s1)
    {
        c = azk1;
        a = s;
        b = s1;
        super();
    }

    public final void run()
    {
        auo auo1;
        synchronized (azh.f(c.b))
        {
            auo1 = (auo)azh.f(c.b).get(a);
        }
        if (auo1 != null)
        {
            auo1.a(azh.g(c.b), a, b);
            return;
        } else
        {
            azh.j().a("Discarded message for unknown namespace '%s'", new Object[] {
                a
            });
            return;
        }
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
