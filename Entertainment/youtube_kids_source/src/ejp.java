// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;

final class ejp extends elm
{

    private Iterator a;

    ejp(Iterator iterator)
    {
        a = iterator;
        super();
    }

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        return a.next();
    }
}
