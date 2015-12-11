// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            r

static final class nit> extends r
{

    final Iterable b;

    public final Iterator iterator()
    {
        return b.iterator();
    }

    (Iterable iterable, Iterable iterable1)
    {
        b = iterable1;
        super(iterable);
    }
}
