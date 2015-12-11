// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.i;
import c.s;

// Referenced classes of package com.g.b.a.d:
//            j

final class a extends i
{

    final j a;

    public final long a(c c, long l)
    {
        if (a.a != 0)
        {
            if ((l = super.a(c, Math.min(l, a.a))) != -1L)
            {
                a.a = (int)((long)a.a - l);
                return l;
            }
        }
        return -1L;
    }

    (j j1, s s)
    {
        a = j1;
        super(s);
    }
}
