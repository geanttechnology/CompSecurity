// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.util.Iterator;

// Referenced classes of package com.google.common.eventbus:
//            Dispatcher, Subscriber

private static final class  extends Dispatcher
{

    private static final  INSTANCE = new <init>();

    void dispatch(Object obj, Iterator iterator)
    {
        Preconditions.checkNotNull(obj);
        for (; iterator.hasNext(); ((Subscriber)iterator.next()).dispatchEvent(obj)) { }
    }



    private ()
    {
    }
}
