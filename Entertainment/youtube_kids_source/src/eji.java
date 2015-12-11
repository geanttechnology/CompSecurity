// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

public final class eji extends ehj
{

    private Iterable a;
    private efx b;

    public eji(Iterable iterable, efx efx)
    {
        a = iterable;
        b = efx;
        super();
    }

    public final Iterator iterator()
    {
        return ejj.a(a.iterator(), b);
    }
}
