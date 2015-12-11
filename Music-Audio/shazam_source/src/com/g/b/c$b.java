// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import c.e;
import c.i;
import c.m;
import c.s;

// Referenced classes of package com.g.b:
//            y, c

private static final class c extends y
{

    private final com.g.b.a.ng a;
    private final e b;
    private final String c;
    private final String d;

    static com.g.b.a.close a(c c1)
    {
        return c1.a;
    }

    public final long a()
    {
        long l = -1L;
        try
        {
            if (d != null)
            {
                l = Long.parseLong(d);
            }
        }
        catch (NumberFormatException numberformatexception)
        {
            return -1L;
        }
        return l;
    }

    public final e b()
    {
        return b;
    }

    public (com.g.b.a.ng ng, String s, String s1)
    {
        a = ng;
        c = s;
        d = s1;
        b = m.a(new i(ng.c[1], ng) {

            final com.g.b.a.b.c a;
            final c.b b;

            public final void close()
            {
                a.close();
                super.close();
            }

            
            {
                b = c.b.this;
                a = c1;
                super(s);
            }
        });
    }
}
