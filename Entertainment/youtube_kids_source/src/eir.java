// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class eir extends ehr
{

    private final eij a;

    eir(eij eij1)
    {
        a = eij1;
    }

    final boolean a()
    {
        return true;
    }

    public final elm b()
    {
        return ejr.a(a.b().b());
    }

    public final boolean contains(Object obj)
    {
        return a.containsValue(obj);
    }

    final eic f()
    {
        return new eis(this, a.b().c());
    }

    public final Iterator iterator()
    {
        return b();
    }

    public final int size()
    {
        return a.size();
    }

    final Object writeReplace()
    {
        return new eit(a);
    }
}
