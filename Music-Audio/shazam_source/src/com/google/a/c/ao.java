// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.c;
import com.google.a.a.g;
import com.google.a.a.h;
import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            ap, r

public final class ao
{

    public static Iterable a(Iterable iterable, h h)
    {
        g.a(iterable);
        g.a(h);
        return new r(iterable, h) {

            final Iterable b;
            final h c;

            public final Iterator iterator()
            {
                return ap.a(b.iterator(), c);
            }

            
            {
                b = iterable;
                c = h;
                super();
            }
        };
    }

    public static Object a(Iterable iterable)
    {
        return com.google.a.c.ap.c(iterable.iterator());
    }

    public static Object b(Iterable iterable)
    {
        return ap.d(iterable.iterator());
    }

    // Unreferenced inner class com/google/a/c/ao$2

/* anonymous class */
    public static final class _cls2 extends r
    {

        final Iterable b;
        final c c;

        public final Iterator iterator()
        {
            return ap.a(b.iterator(), c);
        }

            public 
            {
                b = iterable;
                c = c1;
                super();
            }
    }

}
