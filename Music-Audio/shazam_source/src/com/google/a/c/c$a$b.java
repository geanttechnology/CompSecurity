// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            c, aq

final class r
    implements Iterator
{

    final Iterator a;
    Collection b;
    final clear c;

    public final boolean hasNext()
    {
        return a.hasNext();
    }

    public final Object next()
    {
        java.util.try try1 = (java.util.try)a.next();
        b = (Collection)try1.getValue();
        sNext snext = c;
        Object obj = try1.getKey();
        return aq.a(obj, snext.etKey.a(obj, (Collection)try1.getValue()));
    }

    public final void remove()
    {
        a.remove();
        com.google.a.c.c.b(c.c, b.size());
        b.clear();
    }

    ( )
    {
        c = ;
        super();
        a = c.c.entrySet().iterator();
    }
}
