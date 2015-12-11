// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.d;

import com.google.b.b.e;
import com.google.b.r;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.b.d:
//            a, b

static final class lder extends e
{

    public final void a(a a1)
    {
        if (a1 instanceof com.google.b.b.a.e)
        {
            a1 = (com.google.b.b.a.e)a1;
            a1.a(com.google.b.d.b.e);
            java.util.Entry entry = (java.util.Entry)((Iterator)a1.g()).next();
            ((com.google.b.b.a.e) (a1)).a.add(entry.getValue());
            ((com.google.b.b.a.e) (a1)).a.add(new r((String)entry.getKey()));
            return;
        }
        int j = com.google.b.d.a.a(a1);
        int i = j;
        if (j == 0)
        {
            i = com.google.b.d.a.b(a1);
        }
        if (i == 13)
        {
            com.google.b.d.a.a(a1, 9);
            return;
        }
        if (i == 12)
        {
            com.google.b.d.a.a(a1, 8);
            return;
        }
        if (i == 14)
        {
            com.google.b.d.a.a(a1, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Expected a name but was ")).append(a1.f()).append("  at line ").append(com.google.b.d.a.c(a1)).append(" column ").append(com.google.b.d.a.d(a1)).append(" path ").append(a1.p()).toString());
        }
    }

    lder()
    {
    }
}
