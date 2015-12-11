// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ForwardingCollection, TreeRangeSet, Sets

final class delegate extends ForwardingCollection
    implements Set
{

    final Collection _flddelegate;
    final TreeRangeSet this$0;

    protected volatile Object _mthdelegate()
    {
        return _mthdelegate();
    }

    protected Collection _mthdelegate()
    {
        return _flddelegate;
    }

    public boolean equals(Object obj)
    {
        return Sets.equalsImpl(this, obj);
    }

    public int hashCode()
    {
        return Sets.hashCodeImpl(this);
    }

    (Collection collection)
    {
        this$0 = TreeRangeSet.this;
        super();
        _flddelegate = collection;
    }
}
