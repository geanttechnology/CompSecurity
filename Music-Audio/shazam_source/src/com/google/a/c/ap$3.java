// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.NoSuchElementException;

// Referenced classes of package com.google.a.c:
//            bk, ap

static final class nit> extends bk
{

    boolean a;
    final Object b;

    public final boolean hasNext()
    {
        return !a;
    }

    public final Object next()
    {
        if (a)
        {
            throw new NoSuchElementException();
        } else
        {
            a = true;
            return b;
        }
    }

    entException(Object obj)
    {
        b = obj;
        super();
    }
}
