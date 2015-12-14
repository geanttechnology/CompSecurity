// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, MultiplexProducer, BaseProducerContext, Consumer

class it> extends BaseProducerContextCallbacks
{

    final this._cls1 this$1;
    final Pair val$consumerContextPair;

    public void onCancellationRequested()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj = null;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        it> it> = this._cls1.this;
        it>;
        JVM INSTR monitorenter ;
        boolean flag = cess._mth200(this._cls1.this).remove(val$consumerContextPair);
        BaseProducerContext baseproducercontext;
        java.util.List list;
        java.util.List list1;
        java.util.List list2;
        baseproducercontext = obj;
        list = obj3;
        list1 = obj1;
        list2 = obj2;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (!cess._mth200(this._cls1.this).isEmpty()) goto _L4; else goto _L3
_L3:
        baseproducercontext = cess._mth300(this._cls1.this);
        list2 = obj2;
        list1 = obj1;
        list = obj3;
_L2:
        it>;
        JVM INSTR monitorexit ;
        BaseProducerContext.callOnIsPrefetchChanged(list1);
        BaseProducerContext.callOnPriorityChanged(list2);
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(list);
        if (baseproducercontext != null)
        {
            baseproducercontext.cancel();
        }
        if (flag)
        {
            ((Consumer)val$consumerContextPair.first).onCancellation();
        }
        return;
_L4:
        list1 = cess._mth400(this._cls1.this);
        list2 = cess._mth500(this._cls1.this);
        list = cess._mth600(this._cls1.this);
        baseproducercontext = obj;
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        it>;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onIsIntermediateResultExpectedChanged()
    {
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(cess._mth600(this._cls1.this));
    }

    public void onIsPrefetchChanged()
    {
        BaseProducerContext.callOnIsPrefetchChanged(cess._mth400(this._cls1.this));
    }

    public void onPriorityChanged()
    {
        BaseProducerContext.callOnPriorityChanged(cess._mth500(this._cls1.this));
    }

    ()
    {
        this$1 = final_;
        val$consumerContextPair = Pair.this;
        super();
    }
}
