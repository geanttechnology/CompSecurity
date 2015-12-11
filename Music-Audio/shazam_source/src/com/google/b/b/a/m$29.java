// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.u;
import com.google.b.x;

// Referenced classes of package com.google.b.b.a:
//            m

static final class Exception extends x
{

    private static Number b(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        }
        short word0;
        try
        {
            word0 = (short)a1.n();
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            throw new u(a1);
        }
        return Short.valueOf(word0);
    }

    public final Object a(a a1)
    {
        return b(a1);
    }

    public final volatile void a(c c1, Object obj)
    {
        c1.a((Number)obj);
    }

    Exception()
    {
    }
}
