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

    static List g()
    {
        return new <init>();
    }

    private <init> h()
    {
        <init> <init>1 = new <init>();
        <init> <init>2 = i();
        if (<init>2 == i())
        {
            return <init>1;
        }
        if (!i(<init>2).isEmpty())
        {
            if (<init>1.c.isEmpty())
            {
                <init>1.c = c(<init>2);
                <init>1.b = <init>1.b & -2;
            } else
            {
                <init>1.j();
                <init>1.c.addAll(c(<init>2));
            }
        }
        <init>1.c = ((c) (<init>1)).c.a(c(<init>2));
        return <init>1;
    }

    private c i()
    {
        c c1 = new nit>(this, (byte)0);
        int k = b;
        if ((b & 1) == 1)
        {
            c = Collections.unmodifiableList(c);
            b = b & -2;
        }
        b(c1, c);
        return c1;
    }

    private void j()
    {
        if ((b & 1) != 1)
        {
            c = new ArrayList(c);
            b = b | 1;
        }
    }

    public final b a()
    {
        return h();
    }

    public final h a(h h1)
    {
        if (h1 == null)
        {
            throw new NullPointerException();
        } else
        {
            j();
            c.add(h1);
            return this;
        }
    }

    public final c b()
    {
        return h();
    }

    public final Object clone()
    {
        return h();
    }

    public final boolean d()
    {
        for (int k = 0; k < f(); k++)
        {
            if (!((f)c.get(k)).c())
            {
                return false;
            }
        }

        return true;
    }

    public final c e()
    {
        c c1 = i();
        if (!c1.i())
        {
            throw new ec();
        } else
        {
            return c1;
        }
    }

    public final int f()
    {
        return c.size();
    }

    private ion()
    {
        c = Collections.emptyList();
    }
}
