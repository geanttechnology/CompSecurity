// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import java.util.List;

// Referenced classes of package com.g.b:
//            e, s, q, v, 
//            x

final class d
    implements ject
{

    final e a;
    private final int b;
    private final v c;
    private final boolean d;

    public final x a(v v)
    {
        if (b < a.a.f.size())
        {
            new <init>(a, b + 1, v, d);
            return ((q)a.a.f.get(b)).a();
        } else
        {
            return a.a(v, d);
        }
    }

    st(e e1, int i, v v, boolean flag)
    {
        a = e1;
        super();
        b = i;
        c = v;
        d = flag;
    }
}
