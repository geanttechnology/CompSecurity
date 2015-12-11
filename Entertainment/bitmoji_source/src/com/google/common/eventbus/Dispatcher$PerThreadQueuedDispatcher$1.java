// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.eventbus;

import com.google.common.collect.Queues;
import java.util.Queue;

// Referenced classes of package com.google.common.eventbus:
//            Dispatcher

class this._cls0 extends ThreadLocal
{

    final initialValue this$0;

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Queue initialValue()
    {
        return Queues.newArrayDeque();
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
