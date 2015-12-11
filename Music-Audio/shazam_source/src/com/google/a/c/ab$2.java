// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            ag, ab, bk, ae, 
//            aq

final class nit> extends ag
{

    final ab a;

    public final bk a()
    {
        return new bk() {

            final ab._cls2 a;
            private final Iterator b;

            public final boolean hasNext()
            {
                return b.hasNext();
            }

            public final Object next()
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)b.next();
                return aq.a(entry.getKey(), entry.getValue());
            }

            
            {
                a = ab._cls2.this;
                super();
                b = ab.a(a.a).entrySet().iterator();
            }
        };
    }

    final ae d()
    {
        return a;
    }

    public final Iterator iterator()
    {
        return a();
    }

    or(ab ab1)
    {
        a = ab1;
        super();
    }
}
