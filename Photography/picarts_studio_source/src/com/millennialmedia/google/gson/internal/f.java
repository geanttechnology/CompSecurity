// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            LinkedHashTreeMap, h

final class f extends AbstractSet
{

    final LinkedHashTreeMap a;

    f(LinkedHashTreeMap linkedhashtreemap)
    {
        a = linkedhashtreemap;
        super();
    }

    public final void clear()
    {
        a.clear();
    }

    public final boolean contains(Object obj)
    {
        return (obj instanceof java.util.Map.Entry) && a.findByEntry((java.util.Map.Entry)obj) != null;
    }

    public final Iterator iterator()
    {
        return new h() {

            public final Object next()
            {
                return a();
            }

        };
    }

    public final boolean remove(Object obj)
    {
        if (obj instanceof java.util.Map.Entry)
        {
            if ((obj = a.findByEntry((java.util.Map.Entry)obj)) != null)
            {
                a.removeInternal(((i) (obj)), true);
                return true;
            }
        }
        return false;
    }

    public final int size()
    {
        return a.size;
    }
}
