// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Iterator;

public abstract class dc
    implements Iterator
{

    protected dc()
    {
    }

    public final void remove()
    {
        throw new UnsupportedOperationException();
    }
}
