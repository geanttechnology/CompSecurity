// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.b.f;
import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.u;
import com.google.b.x;

// Referenced classes of package com.google.b.b.a:
//            m

static final class er extends x
{

    public final Object a(a a1)
    {
        b b1 = a1.f();
        switch (com.google.b.b.a..a[b1.ordinal()])
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            throw new u((new StringBuilder("Expecting number, got: ")).append(b1).toString());

        case 4: // '\004'
            a1.k();
            return null;

        case 1: // '\001'
            return new f(a1.i());
        }
    }

    public final volatile void a(c c1, Object obj)
    {
        c1.a((Number)obj);
    }

    er()
    {
    }
}
