// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ForwardingCollection, MapConstraints, Maps, MapConstraint, 
//            TransformedIterator

private static class constraint extends ForwardingCollection
{

    final MapConstraint constraint;
    final Collection entries;

    public boolean contains(Object obj)
    {
        return Maps.containsEntryImpl(_mthdelegate(), obj);
    }

    public boolean containsAll(Collection collection)
    {
        return standardContainsAll(collection);
    }

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
        return new TransformedIterator(entries.iterator()) {

            final MapConstraints.ConstrainedEntries this$0;

            volatile Object transform(Object obj)
            {
                return transform((java.util.Map.Entry)obj);
            }

            java.util.Map.Entry transform(java.util.Map.Entry entry)
            {
                return MapConstraints.access$500(entry, constraint);
            }

            
            {
                this$0 = MapConstraints.ConstrainedEntries.this;
                super(iterator1);
            }
        };
    }

    public boolean remove(Object obj)
    {
        return Maps.removeEntryImpl(_mthdelegate(), obj);
    }

    public boolean removeAll(Collection collection)
    {
        return standardRemoveAll(collection);
    }

    public boolean retainAll(Collection collection)
    {
        return standardRetainAll(collection);
    }

    public Object[] toArray()
    {
        return standardToArray();
    }

    public Object[] toArray(Object aobj[])
    {
        return standardToArray(aobj);
    }

    _cls1.this._cls0(Collection collection, MapConstraint mapconstraint)
    {
        entries = collection;
        constraint = mapconstraint;
    }
}
