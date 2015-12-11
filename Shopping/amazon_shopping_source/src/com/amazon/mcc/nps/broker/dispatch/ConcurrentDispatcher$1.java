// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.dispatch;

import com.amazon.mcc.nps.Message;
import com.amazon.mcc.nps.Topic;
import java.util.List;

// Referenced classes of package com.amazon.mcc.nps.broker.dispatch:
//            ConcurrentDispatcher

class val.message
    implements Runnable
{

    final ConcurrentDispatcher this$0;
    final Message val$message;
    final List val$observers;
    final Topic val$topic;

    public void run()
    {
        ConcurrentDispatcher.access$001(ConcurrentDispatcher.this, val$observers, val$topic, val$message);
    }

    ()
    {
        this$0 = final_concurrentdispatcher;
        val$observers = list;
        val$topic = topic1;
        val$message = Message.this;
        super();
    }
}
