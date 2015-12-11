// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class ehs extends ehr
{

    private final Object a[];

    ehs(Object aobj[])
    {
        a = aobj;
    }

    final boolean a()
    {
        return false;
    }

    public final elm b()
    {
        return ejj.a(a);
    }

    final eic f()
    {
        if (a.length == 1)
        {
            return new eky(a[0]);
        } else
        {
            return new ekl(a);
        }
    }

    public final boolean isEmpty()
    {
        return false;
    }

    public final Iterator iterator()
    {
        return ejj.a(a);
    }

    public final int size()
    {
        return a.length;
    }
}
