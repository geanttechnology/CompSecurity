// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ForwardingSet, MapConstraints, Maps, MapConstraint, 
//            TransformedIterator

static class constraint extends ForwardingSet
{

    private final MapConstraint constraint;
    private final Set entries;

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

    protected volatile Collection _mthdelegate()
    {
        return _mthdelegate();
    }

    protected Set _mthdelegate()
    {
        return entries;
    }

    public boolean equals(Object obj)
    {
        return standardEquals(obj);
    }

    public int hashCode()
    {
        return standardHashCode();
    }

    public Iterator iterator()
    {
        return new TransformedIterator(entries.iterator()) {

            final MapConstraints.ConstrainedAsMapEntries this$0;

            volatile Object transform(Object obj)
            {
                return transform((java.util.Map.Entry)obj);
            }

            java.util.Map.Entry transform(java.util.Map.Entry entry)
            {
                return MapConstraints.access$700(entry, constraint);
            }

            
            {
                this$0 = MapConstraints.ConstrainedAsMapEntries.this;
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


    _cls1.this._cls0(Set set, MapConstraint mapconstraint)
    {
        entries = set;
        constraint = mapconstraint;
    }
}
