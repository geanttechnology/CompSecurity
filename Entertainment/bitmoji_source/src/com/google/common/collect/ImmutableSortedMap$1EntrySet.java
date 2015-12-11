// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableMapEntrySet, ImmutableSortedMap, ImmutableList, UnmodifiableIterator, 
//            ImmutableMap, ImmutableAsList, RegularImmutableSortedSet, Maps, 
//            ImmutableCollection

class this._cls0 extends ImmutableMapEntrySet
{

    final ImmutableSortedMap this$0;

    ImmutableList createAsList()
    {
        return new ImmutableAsList() {

            final ImmutableSortedMap._cls1EntrySet this$1;

            ImmutableCollection delegateCollection()
            {
                return ImmutableSortedMap._cls1EntrySet.this;
            }

            public volatile Object get(int i)
            {
                return get(i);
            }

            public java.util.Map.Entry get(int i)
            {
                return Maps.immutableEntry(ImmutableSortedMap.access$200(this$0).asList().get(i), ImmutableSortedMap.access$300(this$0).get(i));
            }

            
            {
                this$1 = ImmutableSortedMap._cls1EntrySet.this;
                super();
            }
        };
    }

    public UnmodifiableIterator iterator()
    {
        return asList().iterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    ImmutableMap map()
    {
        return ImmutableSortedMap.this;
    }

    _cls1.this._cls1()
    {
        this$0 = ImmutableSortedMap.this;
        super();
    }
}
