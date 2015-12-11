// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b.a;

import com.google.b.a.b;
import com.google.b.b.c;
import com.google.b.b.h;
import com.google.b.c.a;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;

public final class d
    implements y
{

    private final c a;

    public d(c c1)
    {
        a = c1;
    }

    static x a(c c1, f f, a a1, b b1)
    {
        b1 = b1.a();
        if (com/google/b/x.isAssignableFrom(b1))
        {
            return (x)c1.a(com.google.b.c.a.a(b1)).a();
        }
        if (com/google/b/y.isAssignableFrom(b1))
        {
            return ((y)c1.a(com.google.b.c.a.a(b1)).a()).a(f, a1);
        } else
        {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
        }
    }

    public final x a(f f, a a1)
    {
        b b1 = (b)a1.a.getAnnotation(com/google/b/a/b);
        if (b1 == null)
        {
            return null;
        } else
        {
            return a(a, f, a1, b1);
        }
    }
}
