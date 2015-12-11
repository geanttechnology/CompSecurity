// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class eio extends eiu
{

    private final eij a;

    eio(eij eij1)
    {
        a = eij1;
    }

    final boolean a()
    {
        return true;
    }

    public final elm b()
    {
        return c().b();
    }

    public final boolean contains(Object obj)
    {
        return a.containsKey(obj);
    }

    final eic f()
    {
        return new eip(this, a.b().c());
    }

    public final Iterator iterator()
    {
        return c().b();
    }

    public final int size()
    {
        return a.size();
    }

    final Object writeReplace()
    {
        return new eiq(a);
    }
}
