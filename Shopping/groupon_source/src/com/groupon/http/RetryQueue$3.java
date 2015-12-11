// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import com.groupon.events.activity.OnDestroyEvent;
import com.squareup.otto.Bus;

// Referenced classes of package com.groupon.http:
//            RetryQueue

class this._cls0
{

    final RetryQueue this$0;

    public void onEvent(OnDestroyEvent ondestroyevent)
    {
        RetryQueue.access$000(RetryQueue.this);
        RetryQueue.access$100(RetryQueue.this).unregister(this);
    }

    DestroyEvent()
    {
        this$0 = RetryQueue.this;
        super();
    }
}
