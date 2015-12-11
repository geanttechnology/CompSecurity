// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ForwardingCollection, Maps

static class entries extends ForwardingCollection
{

    private final Collection entries;

    protected volatile Object _mthdelegate()
    {
        return _mthdelegate();
    }

    protected Collection _mthdelegate()
    {
        return entries;
    }

    public Iterator iterator()
    {
        return Maps.unmodifiableEntryIterator(entries.iterator());
    }

    public Object[] toArray()
    {
        return standardToArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return standardToArray(aobj);
    }

    (Collection collection)
    {
        entries = collection;
    }
}
