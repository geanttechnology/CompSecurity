// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.util.Iterator;

// Referenced classes of package com.shazam.android.ae:
//            t

final class a
    implements Iterator
{

    final t a;

    public final boolean hasNext()
    {
        return t.a(a) < t.b(a).length();
    }

    public final Object next()
    {
        if (!hasNext())
        {
            return null;
        }
        t.a(a, t.a(a));
        int i = Math.min(t.c(a) + t.d(a), t.b(a).length());
        if (i == t.c(a))
        {
            return null;
        }
        if (t.e(a))
        {
            int j = t.b(a).lastIndexOf('\n', i);
            t t1 = a;
            if (j > t.c(a))
            {
                i = j + 1;
            }
            t.b(t1, i);
        } else
        {
            t.b(a, i);
        }
        return t.b(a).substring(t.c(a), t.a(a));
    }

    public final void remove()
    {
        throw new UnsupportedOperationException("Remove not allowed on this iterator!");
    }

    tionException(t t1)
    {
        a = t1;
        super();
    }
}
