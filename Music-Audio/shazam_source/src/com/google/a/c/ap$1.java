// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.NoSuchElementException;

// Referenced classes of package com.google.a.c:
//            bl, ap

static final class entException extends bl
{

    public final boolean hasNext()
    {
        return false;
    }

    public final boolean hasPrevious()
    {
        return false;
    }

    public final Object next()
    {
        throw new NoSuchElementException();
    }

    public final int nextIndex()
    {
        return 0;
    }

    public final Object previous()
    {
        throw new NoSuchElementException();
    }

    public final int previousIndex()
    {
        return -1;
    }

    entException()
    {
    }
}
