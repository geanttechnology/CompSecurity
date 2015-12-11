// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            bk, ab, aq, ag, 
//            ae

final class  extends bk
{

    final tValue a;
    private final Iterator b;

    public final boolean hasNext()
    {
        return b.hasNext();
    }

    public final Object next()
    {
        java.util.ry ry = (java.util.ry)b.next();
        return aq.a(ry.getKey(), ry.getValue());
    }

    t>(t> t>)
    {
        a = t>;
        super();
        b = ab.a(a.a).entrySet().iterator();
    }

    // Unreferenced inner class com/google/a/c/ab$2

/* anonymous class */
    final class ab._cls2 extends ag
    {

        final ab a;

        public final bk a()
        {
            return new ab._cls2._cls1(this);
        }

        final ae d()
        {
            return a;
        }

        public final Iterator iterator()
        {
            return a();
        }

            
            {
                a = ab1;
                super();
            }
    }

}
