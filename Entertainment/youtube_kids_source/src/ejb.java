// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Comparator;

public final class ejb extends eik
{

    private final Comparator b;

    public ejb(Comparator comparator)
    {
        b = (Comparator)f.b(comparator);
    }

    public final eij a()
    {
        eiz.a(a, b);
        eiz.b(a, b);
        return eiz.a(b, a);
    }

    public final eik a(Object obj, Object obj1)
    {
        a.add(eij.a(obj, obj1));
        return this;
    }
}
