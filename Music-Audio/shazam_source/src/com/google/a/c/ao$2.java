// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.c;
import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            r, ao, ap

public static final class it> extends r
{

    final Iterable b;
    final c c;

    public final Iterator iterator()
    {
        return ap.a(b.iterator(), c);
    }

    public (Iterable iterable, c c1)
    {
        b = iterable;
        c = c1;
        super();
    }
}
