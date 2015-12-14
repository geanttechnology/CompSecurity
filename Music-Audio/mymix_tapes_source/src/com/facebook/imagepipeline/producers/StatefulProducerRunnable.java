// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            ProducerListener, Consumer

public abstract class StatefulProducerRunnable extends StatefulRunnable
{

    private final Consumer mConsumer;
    private final ProducerListener mProducerListener;
    private final String mProducerName;
    private final String mRequestId;

    public StatefulProducerRunnable(Consumer consumer, ProducerListener producerlistener, String s, String s1)
    {
        mConsumer = consumer;
        mProducerListener = producerlistener;
        mProducerName = s;
        mRequestId = s1;
        mProducerListener.onProducerStart(mRequestId, mProducerName);
    }

    protected abstract void disposeResult(Object obj);

    protected Map getExtraMapOnCancellation()
    {
        return null;
    }

    protected Map getExtraMapOnFailure(Exception exception)
    {
        return null;
    }

    protected Map getExtraMapOnSuccess(Object obj)
    {
        return null;
    }

    protected void onCancellation()
    {
        ProducerListener producerlistener = mProducerListener;
        String s = mRequestId;
        String s1 = mProducerName;
        Map map;
        if (mProducerListener.requiresExtraMap(mRequestId))
        {
            map = getExtraMapOnCancellation();
        } else
        {
            map = null;
        }
        producerlistener.onProducerFinishWithCancellation(s, s1, map);
        mConsumer.onCancellation();
    }

    protected void onFailure(Exception exception)
    {
        ProducerListener producerlistener = mProducerListener;
        String s = mRequestId;
        String s1 = mProducerName;
        Map map;
        if (mProducerListener.requiresExtraMap(mRequestId))
        {
            map = getExtraMapOnFailure(exception);
        } else
        {
            map = null;
        }
        producerlistener.onProducerFinishWithFailure(s, s1, exception, map);
        mConsumer.onFailure(exception);
    }

    protected void onSuccess(Object obj)
    {
        ProducerListener producerlistener = mProducerListener;
        String s = mRequestId;
        String s1 = mProducerName;
        Map map;
        if (mProducerListener.requiresExtraMap(mRequestId))
        {
            map = getExtraMapOnSuccess(obj);
        } else
        {
            map = null;
        }
        producerlistener.onProducerFinishWithSuccess(s, s1, map);
        mConsumer.onNewResult(obj, true);
    }
}
