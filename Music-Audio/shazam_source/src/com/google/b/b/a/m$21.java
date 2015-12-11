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
    final x b;

    public final x a(f f, a a1)
    {
        if (a1.a == a)
        {
            return b;
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Factory[type=")).append(a.getName()).append(",adapter=").append(b).append("]").toString();
    }

    r(Class class1, x x)
    {
        a = class1;
        b = x;
        super();
    }
}
