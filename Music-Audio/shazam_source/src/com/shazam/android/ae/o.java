// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;

import java.util.Iterator;

// Referenced classes of package com.shazam.android.ae:
//            t

final class o
    implements Iterable
{

    private Iterator a;

    private o(t t1)
    {
        a = t1.iterator();
    }

    static Iterable a(String s)
    {
        return new o(new t(s));
    }

    static String a(String s, int i)
    {
        return (new StringBuilder()).append(String.format("(chunk %d):\r\n", new Object[] {
            Integer.valueOf(i)
        })).append(s).toString();
    }

    static Iterator a(o o1)
    {
        return o1.a;
    }

    public final Iterator iterator()
    {
        return new Iterator() {

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

            
            {
                a = o.this;
                super();
                b = 1;
            }
        };
    }
}
