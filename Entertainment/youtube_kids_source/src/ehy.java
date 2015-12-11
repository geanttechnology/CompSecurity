// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

final class ehy extends eiu
{

    private ehx a;

    ehy(ehx ehx1)
    {
        a = ehx1;
        super();
    }

    final boolean a()
    {
        return true;
    }

    public final elm b()
    {
        return ejj.a(ehx.a(a).keySet().iterator());
    }

    public final boolean contains(Object obj)
    {
        return ehx.a(a).containsKey(obj);
    }

    public final Iterator iterator()
    {
        return b();
    }

    public final int size()
    {
        return a.size();
    }
}
