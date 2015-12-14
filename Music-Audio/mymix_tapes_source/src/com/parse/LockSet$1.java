// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Comparator;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.parse:
//            LockSet

class it>
    implements Comparator
{

    final LockSet this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Lock)obj, (Lock)obj1);
    }

    public int compare(Lock lock, Lock lock1)
    {
        return LockSet.access$000(lock).compareTo(LockSet.access$000(lock1));
    }

    .locks.Lock()
    {
        this$0 = LockSet.this;
        super();
    }
}
