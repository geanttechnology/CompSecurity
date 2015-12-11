// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.flurry.sdk:
//            je

abstract class <init>
    implements Iterator
{

    e b;
    e c;
    int d;
    final je e;

    final <init> b()
    {
        <init> <init>1 = b;
        if (<init>1 == e.e)
        {
            throw new NoSuchElementException();
        }
        if (e.d != d)
        {
            throw new ConcurrentModificationException();
        } else
        {
            b = <init>1.d;
            c = <init>1;
            return <init>1;
        }
    }

    public final boolean hasNext()
    {
        return b != e.e;
    }

    public final void remove()
    {
        if (c == null)
        {
            throw new IllegalStateException();
        } else
        {
            e.a(c, true);
            c = null;
            d = e.d;
            return;
        }
    }

    private teException(je je1)
    {
        e = je1;
        super();
        b = e.e.d;
        c = null;
        d = e.d;
    }

    e(je je1, e e1)
    {
        this(je1);
    }
}
