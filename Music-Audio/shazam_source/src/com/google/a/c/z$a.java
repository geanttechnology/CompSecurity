// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;

// Referenced classes of package com.google.a.c:
//            z, j, av

static abstract class b extends b
{

    Object a[];
    int b;

    public b a(Object obj)
    {
        g.a(obj);
        int i = b + 1;
        if (a.length < i)
        {
            a = av.b(a, a(a.length, i));
        }
        Object aobj[] = a;
        i = b;
        b = i + 1;
        aobj[i] = obj;
        return this;
    }

    public b b(Object obj)
    {
        return a(obj);
    }

    ()
    {
        j.a(4, "initialCapacity");
        a = new Object[4];
        b = 0;
    }
}
