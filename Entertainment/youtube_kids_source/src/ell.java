// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

abstract class ell
    implements Iterator
{

    private Iterator a;

    ell(Iterator iterator)
    {
        a = (Iterator)f.b(iterator);
    }

    abstract Object a(Object obj);

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        return a(a.next());
    }

    public final void remove()
    {
        a.remove();
    }
}
