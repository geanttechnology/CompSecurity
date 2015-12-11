// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.c;
import c.f;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.g.b.a.d:
//            f, d

static final class a
{

    private final c a;

    private void a(int i, int j)
    {
        if (i < j)
        {
            a.b(i | 0);
            return;
        }
        a.b(j | 0);
        for (i -= j; i >= 128; i >>>= 7)
        {
            a.b(i & 0x7f | 0x80);
        }

        a.b(i);
    }

    private void a(f f1)
    {
        a(f1.c.length, 127);
        a.a(f1);
    }

    final void a(List list)
    {
        int j = list.size();
        int i = 0;
        while (i < j) 
        {
            f f1 = ((d)list.get(i)).h.c();
            Integer integer = (Integer)f.b().get(f1);
            if (integer != null)
            {
                a(integer.intValue() + 1, 15);
                a(((d)list.get(i)).i);
            } else
            {
                a.b(0);
                a(f1);
                a(((d)list.get(i)).i);
            }
            i++;
        }
    }

    r(c c1)
    {
        a = c1;
    }
}
