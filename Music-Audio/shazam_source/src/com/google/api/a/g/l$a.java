// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.api.a.g:
//            l

final class knownFields
    implements Iterator
{

    final l a;
    private boolean b;
    private final Iterator c;
    private final Iterator d;

    public final boolean hasNext()
    {
        return c.hasNext() || d.hasNext();
    }

    public final Object next()
    {
        if (!b)
        {
            if (c.hasNext())
            {
                return (java.util.Entry)c.next();
            }
            b = true;
        }
        return (java.util.Entry)d.next();
    }

    public final void remove()
    {
        if (b)
        {
            d.remove();
        }
        c.remove();
    }

    (l l1,  )
    {
        a = l1;
        super();
        c = .a();
        d = l1.unknownFields.entrySet().iterator();
    }
}
