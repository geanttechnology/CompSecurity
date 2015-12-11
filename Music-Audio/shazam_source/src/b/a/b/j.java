// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import com.google.b.d.a;
import com.google.b.d.b;
import com.google.b.d.c;
import com.google.b.x;

public final class j extends x
{

    private final x a;

    public j(x x1)
    {
        a = x1;
    }

    public final Object a(a a1)
    {
        if (a1.f() == b.i)
        {
            a1.k();
            return null;
        } else
        {
            return a.a(a1);
        }
    }

    public final void a(c c1, Object obj)
    {
        if (obj == null)
        {
            c1.f();
            return;
        } else
        {
            a.a(c1, obj);
            return;
        }
    }
}
