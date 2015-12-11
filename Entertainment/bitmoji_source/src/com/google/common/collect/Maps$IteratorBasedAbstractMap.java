// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Maps, Iterators

static abstract class _cls1.this._cls0 extends AbstractMap
{

    public void clear()
    {
        Iterators.clear(entryIterator());
    }

    abstract Iterator entryIterator();

    public Set entrySet()
    {
        return new Maps.EntrySet() {

            final Maps.IteratorBasedAbstractMap this$0;

            public Iterator iterator()
            {
                return entryIterator();
            }

            Map map()
            {
                return Maps.IteratorBasedAbstractMap.this;
            }

            
            {
                this$0 = Maps.IteratorBasedAbstractMap.this;
                super();
            }
        };
    }

    public abstract int size();

    _cls1.this._cls0()
    {
    }
}
