// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;

// Referenced classes of package com.google.b:
//            x, f

final class nit> extends x
{

    final f a;

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        } else
        {
            return Long.valueOf(a1.m());
        }
    }

    public final void a(c c1, Object obj)
    {
        obj = (Number)obj;
        if (obj == null)
        {
            c1.f();
            return;
        } else
        {
            c1.b(obj.toString());
            return;
        }
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
