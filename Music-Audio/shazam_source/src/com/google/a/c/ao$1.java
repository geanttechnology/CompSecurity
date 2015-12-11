// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.h;
import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            r, ao, ap

static final class it> extends r
{

    final Iterable b;
    final h c;

    public final Iterator iterator()
    {
        return ap.a(b.iterator(), c);
    }

    (Iterable iterable, h h)
    {
        b = iterable;
        c = h;
        super();
    }
}
