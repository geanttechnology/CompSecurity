// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableSet, ImmutableList, UnmodifiableIterator, ImmutableAsList, 
//            ImmutableCollection

static abstract class > extends ImmutableSet
{

    ImmutableList createAsList()
    {
        return new ImmutableAsList() {

            final ImmutableSet.Indexed this$0;

            volatile ImmutableCollection delegateCollection()
            {
                return delegateCollection();
            }

            ImmutableSet.Indexed delegateCollection()
            {
                return ImmutableSet.Indexed.this;
            }

            public Object get(int i)
            {
                return ImmutableSet.Indexed.this.get(i);
            }

            
            {
                this$0 = ImmutableSet.Indexed.this;
                super();
            }
        };
    }

    abstract Object get(int i);

    public UnmodifiableIterator iterator()
    {
        return asList().iterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    >()
    {
    }
}
