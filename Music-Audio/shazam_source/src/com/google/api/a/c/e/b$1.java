// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.c.e;

import com.google.api.a.d.p;
import com.google.api.a.d.s;
import com.google.api.a.d.u;

// Referenced classes of package com.google.api.a.c.e:
//            b

final class b
    implements u
{

    final u a;
    final p b;
    final b c;

    public final void a(s s1)
    {
        if (a != null)
        {
            a.a(s1);
        }
        if (!s1.a() && b.o)
        {
            throw c.newExceptionOnError(s1);
        } else
        {
            return;
        }
    }

    (b b1, u u1, p p1)
    {
        c = b1;
        a = u1;
        b = p1;
        super();
    }
}
