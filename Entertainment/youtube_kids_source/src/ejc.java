// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;

final class ejc extends eil
{

    private static final long serialVersionUID = 0L;
    private final Comparator a;

    ejc(eiz eiz1)
    {
        super(eiz1);
        a = eiz1.comparator();
    }

    final Object readResolve()
    {
        return a(new ejb(a));
    }
}
