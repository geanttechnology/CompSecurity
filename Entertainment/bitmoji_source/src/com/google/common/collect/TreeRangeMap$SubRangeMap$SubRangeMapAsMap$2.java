// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.common.collect:
//            TreeRangeMap, Iterators

class this._cls2 extends this._cls2
{

    final iterator this$2;

    public boolean isEmpty()
    {
        return !iterator().hasNext();
    }

    public Iterator iterator()
    {
        return tryIterator();
    }

    Map map()
    {
        return this._cls2.this;
    }

    public boolean retainAll(Collection collection)
    {
        return cess._mth300(this._cls2.this, Predicates.not(Predicates.in(collection)));
    }

    public int size()
    {
        return Iterators.size(iterator());
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
