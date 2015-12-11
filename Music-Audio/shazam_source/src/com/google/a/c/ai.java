// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Iterator;

// Referenced classes of package com.google.a.c:
//            z, ae, aj, aq, 
//            ap, bk, ad, x

final class ai extends z
{

    private final ae a;

    ai(ae ae1)
    {
        a = ae1;
    }

    public final bk a()
    {
        return aq.a(a.b().a());
    }

    public final boolean contains(Object obj)
    {
        return obj != null && ap.a(a(), obj);
    }

    final boolean e()
    {
        return true;
    }

    final ad f()
    {
        return new x(a.b().b()) {

            final ad b;
            final ai c;

            final z c()
            {
                return c;
            }

            public final Object get(int i)
            {
                return ((java.util.Map.Entry)b.get(i)).getValue();
            }

            
            {
                c = ai.this;
                b = ad1;
                super();
            }
        };
    }

    public final Iterator iterator()
    {
        return a();
    }

    public final int size()
    {
        return a.size();
    }
}
