// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.c.a;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;

// Referenced classes of package com.google.b.b.a:
//            m

static final class >
    implements y
{

    final Class a;
    final Class b;
    final x c;

    public final x a(f f, a a1)
    {
        f = a1.a;
        if (f == a || f == b)
        {
            return c;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(b.getName()).append("+").append(a.getName()).append(",adapter=").append(c).append("]").toString();
    }

    r(Class class1, Class class2, x x)
    {
        a = class1;
        b = class2;
        c = x;
        super();
    }
}
