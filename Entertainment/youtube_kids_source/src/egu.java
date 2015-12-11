// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import java.util.ListIterator;

final class egu extends egs
    implements ListIterator
{

    private egt b;

    egu(egt egt1)
    {
        b = egt1;
        super(egt1);
    }

    public egu(egt egt1, int i)
    {
        b = egt1;
        super(egt1, egt1.d().listIterator(i));
    }

    private ListIterator b()
    {
        a();
        return (ListIterator)super.a;
    }

    public final void add(Object obj)
    {
        boolean flag = b.isEmpty();
        b().add(obj);
        egi.c(b.e);
        if (flag)
        {
            b.c();
        }
    }

    public final boolean hasPrevious()
    {
        return b().hasPrevious();
    }

    public final int nextIndex()
    {
        return b().nextIndex();
    }

    public final Object previous()
    {
        return b().previous();
    }

    public final int previousIndex()
    {
        return b().previousIndex();
    }

    public final void set(Object obj)
    {
        b().set(obj);
    }
}
