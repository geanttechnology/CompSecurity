// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

final class eia extends elm
{

    private final Iterator a;
    private ehz b;

    eia(ehz ehz1)
    {
        b = ehz1;
        super();
        a = ehx.a(b.a).entrySet().iterator();
    }

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        java.util.Map.Entry entry = (java.util.Map.Entry)a.next();
        return ejr.a(entry.getKey(), entry.getValue());
    }
}
