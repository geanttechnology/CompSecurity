// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.util.Message;
import com.amazon.device.analytics.log.Logger;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.amazon.analytics.session:
//            PriorityQueue

private class <init>
    implements Runnable
{

    final PriorityQueue this$0;

    private boolean canContinue(long l, Message message)
    {
        if (message == null)
        {
            PriorityQueue.access$100().d("Cannot continue.... head is empty");
        } else
        {
            message = (Long)message.getExtras().get("TimeStamp");
            if (message == null)
            {
                PriorityQueue.access$100().d("Cannot continue.... timestamp is empty");
                return false;
            }
            Long long1 = Long.valueOf(l - message.longValue());
            PriorityQueue.access$100().d((new StringBuilder()).append("Can we continue???? delta is ").append(long1.toString()).append(" message timestamp ").append(message).toString());
            l = PriorityQueue.access$200(PriorityQueue.this);
            if (long1.longValue() >= l)
            {
                return true;
            }
        }
        return false;
    }

    public void run()
    {
        Object obj = null;
_L7:
        PriorityQueue.access$300(PriorityQueue.this).lock();
        Message message;
        Object obj1;
        Object obj2;
        InterruptedException interruptedexception1;
        long l;
        boolean flag;
        if (obj != null)
        {
            try
            {
                PriorityQueue.access$400(PriorityQueue.this).put(obj);
            }
            catch (InterruptedException interruptedexception) { }
        }
        PriorityQueue.access$100().d("Running sweeper");
        l = System.currentTimeMillis();
_L5:
        flag = canContinue(l, (Message)PriorityQueue.access$400(PriorityQueue.this).peek());
        if (!flag) goto _L2; else goto _L1
_L1:
        message = null;
        obj2 = (Message)PriorityQueue.access$400(PriorityQueue.this).take();
        message = ((Message) (obj2));
_L9:
        if (message == null) goto _L4; else goto _L3
_L3:
        obj2 = (Long)message.getExtras().get("TimeStamp");
        PriorityQueue.access$100().d((new StringBuilder()).append("Dequeing message with timestamp ").append(obj2).toString());
        PriorityQueue.access$100().d((new StringBuilder()).append("Remaining queue size ").append(PriorityQueue.access$400(PriorityQueue.this).size()).toString());
        PriorityQueue.access$500(PriorityQueue.this, message);
        PriorityQueue.access$600(PriorityQueue.this).set(((Long) (obj2)).longValue());
          goto _L5
        obj1;
        PriorityQueue.access$100().e("Error dequeuing message", ((Throwable) (obj1)));
          goto _L5
        obj1;
        PriorityQueue.access$100().e("An error occurred in the sweeper", ((Throwable) (obj1)));
        PriorityQueue.access$300(PriorityQueue.this).unlock();
_L6:
        PriorityQueue.access$100().d("Finished running through queue... Waiting for message maturity");
        obj1 = (Message)PriorityQueue.access$400(PriorityQueue.this).take();
        obj = obj1;
        break MISSING_BLOCK_LABEL_258;
_L4:
        PriorityQueue.access$100().d("breaking out of loop");
_L2:
        PriorityQueue.access$300(PriorityQueue.this).unlock();
          goto _L6
        obj;
        PriorityQueue.access$300(PriorityQueue.this).unlock();
        throw obj;
_L8:
        if (Thread.interrupted())
        {
            PriorityQueue.access$100().w("Sweeper thread is being interrupted. This will stop the processing of session events");
            return;
        }
        PriorityQueue.access$700(PriorityQueue.this, ((Message) (obj)));
          goto _L7
        obj1;
          goto _L8
        interruptedexception1;
          goto _L9
    }

    private ()
    {
        this$0 = PriorityQueue.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
