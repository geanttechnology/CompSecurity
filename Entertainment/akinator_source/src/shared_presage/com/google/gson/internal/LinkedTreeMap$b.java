// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            LinkedTreeMap, p

final class a extends AbstractSet
{

    final LinkedTreeMap a;

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
        return new p(this);
    }

    public final boolean remove(Object obj)
    {
        return a.removeInternalByKey(obj) != null;
    }

    public final int size()
    {
        return a.size;
    }

    (LinkedTreeMap linkedtreemap)
    {
        a = linkedtreemap;
        super();
    }
}
