// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.b;
import com.bumptech.glide.load.e;
import java.security.MessageDigest;
import java.util.Map;
import myobfuscated.f.m;

public final class w
    implements b
{

    private final Object b;
    private final int c;
    private final int d;
    private final Class e;
    private final Class f;
    private final b g;
    private final Map h;
    private final e i;
    private int j;

    public w(Object obj, b b1, int k, int l, Map map, Class class1, Class class2, 
            e e1)
    {
        b = m.a(obj, "Argument must not be null");
        g = (b)m.a(b1, "Signature must not be null");
        c = k;
        d = l;
        h = (Map)m.a(map, "Argument must not be null");
        e = (Class)m.a(class1, "Resource class must not be null");
        f = (Class)m.a(class2, "Transcode class must not be null");
        i = (e)m.a(e1, "Argument must not be null");
    }

    public final void a(MessageDigest messagedigest)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof w)
        {
            obj = (w)obj;
            flag = flag1;
            if (b.equals(((w) (obj)).b))
            {
                flag = flag1;
                if (g.equals(((w) (obj)).g))
                {
                    flag = flag1;
                    if (d == ((w) (obj)).d)
                    {
                        flag = flag1;
                        if (c == ((w) (obj)).c)
                        {
                            flag = flag1;
                            if (h.equals(((w) (obj)).h))
                            {
                                flag = flag1;
                                if (e.equals(((w) (obj)).e))
                                {
                                    flag = flag1;
                                    if (f.equals(((w) (obj)).f))
                                    {
                                        flag = flag1;
                                        if (i.equals(((w) (obj)).i))
                                        {
                                            flag = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        if (j == 0)
        {
            j = b.hashCode();
            j = j * 31 + g.hashCode();
            j = j * 31 + c;
            j = j * 31 + d;
            j = j * 31 + h.hashCode();
            j = j * 31 + e.hashCode();
            j = j * 31 + f.hashCode();
            j = j * 31 + i.hashCode();
        }
        return j;
    }

    public final String toString()
    {
        return (new StringBuilder("EngineKey{model=")).append(b).append(", width=").append(c).append(", height=").append(d).append(", resourceClass=").append(e).append(", transcodeClass=").append(f).append(", signature=").append(g).append(", hashCode=").append(j).append(", transformations=").append(h).append(", options=").append(i).append('}').toString();
    }
}
