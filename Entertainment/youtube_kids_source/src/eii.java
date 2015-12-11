// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class eii extends eic
{

    private transient int a;
    private transient int c;
    private eic d;

    eii(eic eic1, int i, int j)
    {
        d = eic1;
        super();
        a = i;
        c = j;
    }

    public final eic a(int i, int j)
    {
        f.a(i, j, c);
        return d.a(a + i, a + j);
    }

    final boolean a()
    {
        return true;
    }

    public final Object get(int i)
    {
        f.a(i, c);
        return d.get(a + i);
    }

    public final Iterator iterator()
    {
        return super.b();
    }

    public final ListIterator listIterator()
    {
        return super.d();
    }

    public final ListIterator listIterator(int i)
    {
        return super.a(i);
    }

    public final int size()
    {
        return c;
    }

    public final List subList(int i, int j)
    {
        return a(i, j);
    }
}
