// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

// Referenced classes of package rx.internal.operators:
//            OperatorTake

class val.producer
    implements Producer
{

    final AtomicLong requested = new AtomicLong(0L);
    final <init> this$1;
    final Producer val$producer;

    public void request(long l)
    {
        if (l <= 0L || mpleted) goto _L2; else goto _L1
_L1:
        long l1;
        long l2;
        l1 = requested.get();
        l2 = Math.min(l, (long)limit - l1);
        if (l2 != 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return;
        if (!requested.compareAndSet(l1, l1 + l2)) goto _L1; else goto _L3
_L3:
        val$producer.request(l2);
        return;
    }

    mpleted()
    {
        this$1 = final_mpleted;
        val$producer = Producer.this;
        super();
    }

    // Unreferenced inner class rx/internal/operators/OperatorTake$1

/* anonymous class */
    class OperatorTake._cls1 extends Subscriber
    {

        boolean completed;
        int count;
        final OperatorTake this$0;
        final Subscriber val$child;

        public void onCompleted()
        {
            if (!completed)
            {
                child.onCompleted();
            }
        }

        public void onError(Throwable throwable)
        {
            if (!completed)
            {
                child.onError(throwable);
            }
        }

        public void onNext(Object obj)
        {
            if (!isUnsubscribed())
            {
                int i = count + 1;
                count = i;
                if (i >= limit)
                {
                    completed = true;
                }
                child.onNext(obj);
                if (completed)
                {
                    child.onCompleted();
                    unsubscribe();
                }
            }
        }

        public void setProducer(Producer producer1)
        {
            child.setProducer(producer1. new OperatorTake._cls1._cls1());
        }

            
            {
                this$0 = final_operatortake;
                child = Subscriber.this;
                super();
                count = 0;
                completed = false;
            }
    }

}
