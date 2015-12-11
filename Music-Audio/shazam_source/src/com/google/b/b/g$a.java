// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b.b;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.google.b.b:
//            g

final class et extends AbstractSet
{

    final g a;

    public final void clear()
    {
        a.clear();
    }

    public final boolean contains(Object obj)
    {
        return (obj instanceof java.util.Entry) && a.a((java.util.Entry)obj) != null;
    }

    public final Iterator iterator()
    {
        return new g.c() {

            final g.a a;

            public final Object next()
            {
                return a();
            }

            
            {
                a = g.a.this;
                super(g.a.this.a, (byte)0);
            }
        };
    }

    public final boolean remove(Object obj)
    {
        if (obj instanceof java.util.Entry)
        {
            if ((obj = a.a((java.util.Entry)obj)) != null)
            {
                a.a(((a) (obj)), true);
                return true;
            }
        }
        return false;
    }

    public final int size()
    {
        return a.c;
    }

    a(g g1)
    {
        a = g1;
        super();
    }
}
