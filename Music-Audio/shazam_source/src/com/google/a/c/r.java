// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            ap

public abstract class r
    implements Iterable
{

    public final Iterable a;

    protected r()
    {
        a = this;
    }

    r(Iterable iterable)
    {
        a = (Iterable)g.a(iterable);
    }

    public static r a(Iterable iterable)
    {
        if (iterable instanceof r)
        {
            return (r)iterable;
        } else
        {
            return new r(iterable, iterable) {

                final Iterable b;

                public final Iterator iterator()
                {
                    return b.iterator();
                }

            
            {
                b = iterable1;
                super(iterable);
            }
            };
        }
    }

    public String toString()
    {
        return ap.b(a.iterator());
    }
}
