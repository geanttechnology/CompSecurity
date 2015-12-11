// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableMap, ImmutableSet, UnmodifiableIterator, ImmutableMapEntrySet

static abstract class _cls1EntrySetImpl.this._cls0 extends ImmutableMap
{
    class _cls1EntrySetImpl extends ImmutableMapEntrySet
    {

        final ImmutableMap.IteratorBasedImmutableMap this$0;

        public UnmodifiableIterator iterator()
        {
            return entryIterator();
        }

        public volatile Iterator iterator()
        {
            return iterator();
        }

        ImmutableMap map()
        {
            return ImmutableMap.IteratorBasedImmutableMap.this;
        }

        _cls1EntrySetImpl()
        {
            this$0 = ImmutableMap.IteratorBasedImmutableMap.this;
            super();
        }
    }


    ImmutableSet createEntrySet()
    {
        return new _cls1EntrySetImpl();
    }

    abstract UnmodifiableIterator entryIterator();

    public volatile Set entrySet()
    {
        return super.entrySet();
    }

    public volatile Set keySet()
    {
        return super.keySet();
    }

    public volatile Collection values()
    {
        return super.values();
    }

    _cls1EntrySetImpl.this._cls0()
    {
    }
}
