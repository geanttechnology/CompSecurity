// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            aj, ad, ae, bk, 
//            x, z

final class ah extends aj
{

    private final ae a;

    ah(ae ae1)
    {
        a = ae1;
    }

    public final bk a()
    {
        return b().a();
    }

    public final boolean contains(Object obj)
    {
        return a.containsKey(obj);
    }

    final boolean e()
    {
        return true;
    }

    final ad f()
    {
        return new x(a.b().b()) {

            final ad b;
            final ah c;

            final z c()
            {
                return c;
            }

            public final Object get(int i)
            {
                return ((java.util.Map.Entry)b.get(i)).getKey();
            }

            
            {
                c = ah.this;
                b = ad1;
                super();
            }
        };
    }

    public final Iterator iterator()
    {
        return b().a();
    }

    public final int size()
    {
        return a.size();
    }
}
