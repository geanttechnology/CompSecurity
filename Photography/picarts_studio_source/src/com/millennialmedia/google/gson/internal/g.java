// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.millennialmedia.google.gson.internal:
//            LinkedHashTreeMap, h, i

final class g extends AbstractSet
{

    final LinkedHashTreeMap a;

    g(LinkedHashTreeMap linkedhashtreemap)
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
        return a.containsKey(obj);
    }

    public final Iterator iterator()
    {
        return new h() {

            public final Object next()
            {
                return a().f;
            }

        };
    }

    public final boolean remove(Object obj)
    {
        return a.removeInternalByKey(obj) != null;
    }

    public final int size()
    {
        return a.size;
    }
}
