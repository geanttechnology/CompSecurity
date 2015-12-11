// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.util.Iterator;

// Referenced classes of package com.shazam.android.ae:
//            o

final class b
    implements Iterator
{

    final o a;
    private int b;

    public final boolean hasNext()
    {
        return o.a(a).hasNext();
    }

    public final Object next()
    {
        String s = (String)o.a(a).next();
        int i = b;
        b = i + 1;
        return o.a(s, i);
    }

    public final void remove()
    {
        o.a(a).remove();
    }

    (o o1)
    {
        a = o1;
        super();
        b = 1;
    }
}
