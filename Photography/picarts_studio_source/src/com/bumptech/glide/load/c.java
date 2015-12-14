// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;

import java.security.MessageDigest;
import myobfuscated.f.m;

// Referenced classes of package com.bumptech.glide.load:
//            d

public final class c
{

    private static final d e = new d() {

        public final void a(byte abyte0[], Object obj, MessageDigest messagedigest)
        {
        }

    };
    final Object a;
    final d b;
    final String c;
    volatile byte d[];

    private c(String s, Object obj, d d1)
    {
        c = m.b(s);
        a = obj;
        b = (d)m.a(d1, "Argument must not be null");
    }

    public static c a(String s)
    {
        return new c(s, null, e);
    }

    public static c a(String s, Object obj)
    {
        return new c(s, obj, e);
    }

    public static c a(String s, Object obj, d d1)
    {
        return new c(s, obj, d1);
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof c)
        {
            obj = (c)obj;
            return c.equals(((c) (obj)).c);
        } else
        {
            return false;
        }
    }

    public final int hashCode()
    {
        return c.hashCode();
    }

    public final String toString()
    {
        return (new StringBuilder("Option{key='")).append(c).append('\'').append('}').toString();
    }

}
