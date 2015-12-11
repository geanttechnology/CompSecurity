// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            gt, do, ec

public static final class List extends List
    implements List
{

    private int b;
    private List c;

    static List f()
    {
        return new <init>();
    }

    private <init> g()
    {
        <init> <init>1 = new <init>();
        <init> <init>2 = h();
        if (<init>2 == h())
        {
            return <init>1;
        }
        if (!h(<init>2).isEmpty())
        {
            if (<init>1.c.isEmpty())
            {
                <init>1.c = c(<init>2);
                <init>1.b = <init>1.b & -2;
            } else
            {
                <init>1.i();
                <init>1.c.addAll(c(<init>2));
            }
        }
        <init>1.c = ((c) (<init>1)).c.a(c(<init>2));
        return <init>1;
    }

    private c h()
    {
        c c1 = new nit>(this, (byte)0);
        int j = b;
        if ((b & 1) == 1)
        {
            c = Collections.unmodifiableList(c);
            b = b & -2;
        }
        b(c1, c);
        return c1;
    }

    private void i()
    {
        if ((b & 1) != 1)
        {
            c = new ArrayList(c);
            b = b | 1;
        }
    }

    public final b a()
    {
        return g();
    }

    public final g a(Iterable iterable)
    {
        i();
        i(iterable, c);
        return this;
    }

    public final c b()
    {
        return g();
    }

    public final Object clone()
    {
        return g();
    }

    public final boolean d()
    {
        for (int j = 0; j < c.size(); j++)
        {
            if (!((c)c.get(j)).c())
            {
                return false;
            }
        }

        return true;
    }

    public final c e()
    {
        c c1 = h();
        if (!c1.h())
        {
            throw new ec();
        } else
        {
            return c1;
        }
    }

    private ()
    {
        c = Collections.emptyList();
    }
}
