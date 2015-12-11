// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import java.util.Iterator;

// Referenced classes of package com.google.common.eventbus:
//            Dispatcher

private static final class <init>
{

    private final Object event;
    private final Iterator subscribers;



    private (Object obj, Iterator iterator)
    {
        event = obj;
        subscribers = iterator;
    }

    subscribers(Object obj, Iterator iterator, subscribers subscribers1)
    {
        this(obj, iterator);
    }
}
