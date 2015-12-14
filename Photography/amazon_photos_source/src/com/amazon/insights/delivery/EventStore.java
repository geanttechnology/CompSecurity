// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import java.util.Iterator;

// Referenced classes of package com.amazon.insights.delivery:
//            EventStoreException

public interface EventStore
{
    public static interface EventIterator
        extends Iterator
    {

        public abstract String peek();

        public abstract void removeReadEvents();
    }


    public abstract EventIterator iterator();

    public abstract boolean put(String s)
        throws EventStoreException;
}
