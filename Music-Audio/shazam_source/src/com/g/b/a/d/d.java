// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import c.f;

public final class d
{

    public static final f a = c.f.a(":status");
    public static final f b = c.f.a(":method");
    public static final f c = c.f.a(":path");
    public static final f d = c.f.a(":scheme");
    public static final f e = c.f.a(":authority");
    public static final f f = c.f.a(":host");
    public static final f g = c.f.a(":version");
    public final f h;
    public final f i;
    final int j;

    public d(f f1, f f2)
    {
        h = f1;
        i = f2;
        j = f1.c.length + 32 + f2.c.length;
    }

    public d(f f1, String s)
    {
        this(f1, c.f.a(s));
    }

    public d(String s, String s1)
    {
        this(c.f.a(s), c.f.a(s1));
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof d)
        {
            obj = (d)obj;
            flag = flag1;
            if (h.equals(((d) (obj)).h))
            {
                flag = flag1;
                if (i.equals(((d) (obj)).i))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (h.hashCode() + 527) * 31 + i.hashCode();
    }

    public final String toString()
    {
        return String.format("%s: %s", new Object[] {
            h.a(), i.a()
        });
    }

}
