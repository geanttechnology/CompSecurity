// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, BaseProducerContext, 
//            BaseProducerContextCallbacks, BaseConsumer

public abstract class MultiplexProducer
    implements Producer
{
    class Multiplexer
    {

        private final CopyOnWriteArraySet mConsumerContextPairs = Sets.newCopyOnWriteArraySet();
        private ForwardingConsumer mForwardingConsumer;
        private final Object mKey;
        private Closeable mLastIntermediateResult;
        private float mLastProgress;
        private BaseProducerContext mMultiplexProducerContext;
        final MultiplexProducer this$0;

        private void addCallbacks(Pair pair, ProducerContext producercontext)
        {
            producercontext.addCallbacks(pair. new BaseProducerContextCallbacks() {

                final Multiplexer this$1;
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
                    Multiplexer multiplexer = Multiplexer.this;
                    multiplexer;
                    JVM INSTR monitorenter ;
                    boolean flag = mConsumerContextPairs.remove(consumerContextPair);
                    BaseProducerContext baseproducercontext;
                    List list;
                    List list1;
                    List list2;
                    baseproducercontext = obj;
                    list = obj3;
                    list1 = obj1;
                    list2 = obj2;
                    if (!flag) goto _L2; else goto _L1
_L1:
                    if (!mConsumerContextPairs.isEmpty()) goto _L4; else goto _L3
_L3:
                    baseproducercontext = mMultiplexProducerContext;
                    list2 = obj2;
                    list1 = obj1;
                    list = obj3;
_L2:
                    multiplexer;
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
                        ((Consumer)consumerContextPair.first).onCancellation();
                    }
                    return;
_L4:
                    list1 = updateIsPrefetch();
                    list2 = updatePriority();
                    list = updateIsIntermediateResultExpected();
                    baseproducercontext = obj;
                    if (true) goto _L2; else goto _L5
_L5:
                    Exception exception;
                    exception;
                    multiplexer;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

                public void onIsIntermediateResultExpectedChanged()
                {
                    BaseProducerContext.callOnIsIntermediateResultExpectedChanged(updateIsIntermediateResultExpected());
                }

                public void onIsPrefetchChanged()
                {
                    BaseProducerContext.callOnIsPrefetchChanged(updateIsPrefetch());
                }

                public void onPriorityChanged()
                {
                    BaseProducerContext.callOnPriorityChanged(updatePriority());
                }

            
            {
                this$1 = final_multiplexer;
                consumerContextPair = Pair.this;
                super();
            }
            });
        }

        private void closeSafely(Closeable closeable)
        {
            if (closeable == null)
            {
                break MISSING_BLOCK_LABEL_10;
            }
            closeable.close();
            return;
            closeable;
            throw new RuntimeException(closeable);
        }

        private boolean computeIsIntermediateResultExpected()
        {
            this;
            JVM INSTR monitorenter ;
            Iterator iterator = mConsumerContextPairs.iterator();
_L4:
            if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            boolean flag = ((ProducerContext)((Pair)iterator.next()).second).isIntermediateResultExpected();
            if (!flag) goto _L4; else goto _L3
_L3:
            flag = true;
_L6:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = false;
            if (true) goto _L6; else goto _L5
_L5:
            Exception exception;
            exception;
            throw exception;
        }

        private boolean computeIsPrefetch()
        {
            this;
            JVM INSTR monitorenter ;
            Iterator iterator = mConsumerContextPairs.iterator();
_L4:
            if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
            boolean flag = ((ProducerContext)((Pair)iterator.next()).second).isPrefetch();
            if (flag) goto _L4; else goto _L3
_L3:
            flag = false;
_L6:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            flag = true;
            if (true) goto _L6; else goto _L5
_L5:
            Exception exception;
            exception;
            throw exception;
        }

        private Priority computePriority()
        {
            this;
            JVM INSTR monitorenter ;
            Priority priority;
            priority = Priority.LOW;
            for (Iterator iterator = mConsumerContextPairs.iterator(); iterator.hasNext();)
            {
                priority = Priority.getHigherPriority(priority, ((ProducerContext)((Pair)iterator.next()).second).getPriority());
            }

            this;
            JVM INSTR monitorexit ;
            return priority;
            Exception exception;
            exception;
            throw exception;
        }

        private void startNextProducerIfHasAttachedConsumers()
        {
            boolean flag1 = true;
            this;
            JVM INSTR monitorenter ;
            Object obj;
            Exception exception;
            ForwardingConsumer forwardingconsumer;
            boolean flag;
            if (mMultiplexProducerContext == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            if (mForwardingConsumer == null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            if (!mConsumerContextPairs.isEmpty())
            {
                break MISSING_BLOCK_LABEL_57;
            }
            removeMultiplexer(mKey, this);
            this;
            JVM INSTR monitorexit ;
            return;
            obj = (ProducerContext)((Pair)mConsumerContextPairs.iterator().next()).second;
            mMultiplexProducerContext = new BaseProducerContext(((ProducerContext) (obj)).getImageRequest(), ((ProducerContext) (obj)).getId(), ((ProducerContext) (obj)).getListener(), ((ProducerContext) (obj)).getCallerContext(), ((ProducerContext) (obj)).getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
            mForwardingConsumer = new ForwardingConsumer();
            obj = mMultiplexProducerContext;
            forwardingconsumer = mForwardingConsumer;
            this;
            JVM INSTR monitorexit ;
            mNextProducer.produceResults(forwardingconsumer, ((ProducerContext) (obj)));
            return;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private List updateIsIntermediateResultExpected()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = mMultiplexProducerContext;
            if (obj != null) goto _L2; else goto _L1
_L1:
            obj = null;
_L4:
            this;
            JVM INSTR monitorexit ;
            return ((List) (obj));
_L2:
            obj = mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private List updateIsPrefetch()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = mMultiplexProducerContext;
            if (obj != null) goto _L2; else goto _L1
_L1:
            obj = null;
_L4:
            this;
            JVM INSTR monitorexit ;
            return ((List) (obj));
_L2:
            obj = mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        private List updatePriority()
        {
            this;
            JVM INSTR monitorenter ;
            Object obj = mMultiplexProducerContext;
            if (obj != null) goto _L2; else goto _L1
_L1:
            obj = null;
_L4:
            this;
            JVM INSTR monitorexit ;
            return ((List) (obj));
_L2:
            obj = mMultiplexProducerContext.setPriorityNoCallbacks(computePriority());
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public boolean addNewConsumer(Consumer consumer, ProducerContext producercontext)
        {
            Pair pair = Pair.create(consumer, producercontext);
            this;
            JVM INSTR monitorenter ;
            if (getExistingMultiplexer(mKey) == this)
            {
                break MISSING_BLOCK_LABEL_28;
            }
            this;
            JVM INSTR monitorexit ;
            return false;
            float f;
            Object obj;
            Closeable closeable;
            List list;
            List list1;
            mConsumerContextPairs.add(pair);
            obj = updateIsPrefetch();
            list = updatePriority();
            list1 = updateIsIntermediateResultExpected();
            closeable = mLastIntermediateResult;
            f = mLastProgress;
            this;
            JVM INSTR monitorexit ;
            BaseProducerContext.callOnIsPrefetchChanged(((List) (obj)));
            BaseProducerContext.callOnPriorityChanged(list);
            BaseProducerContext.callOnIsIntermediateResultExpectedChanged(list1);
            pair;
            JVM INSTR monitorenter ;
            this;
            JVM INSTR monitorenter ;
            if (closeable == mLastIntermediateResult) goto _L2; else goto _L1
_L1:
            obj = null;
_L4:
            this;
            JVM INSTR monitorexit ;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_136;
            }
            if (f <= 0.0F)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            consumer.onProgressUpdate(f);
            consumer.onNewResult(obj, false);
            closeSafely(((Closeable) (obj)));
            pair;
            JVM INSTR monitorexit ;
            addCallbacks(pair, producercontext);
            return true;
            consumer;
            this;
            JVM INSTR monitorexit ;
            throw consumer;
_L2:
            obj = closeable;
            if (closeable == null) goto _L4; else goto _L3
_L3:
            obj = cloneOrNull(closeable);
              goto _L4
            consumer;
            this;
            JVM INSTR monitorexit ;
            throw consumer;
            consumer;
            pair;
            JVM INSTR monitorexit ;
            throw consumer;
        }

        public void onCancelled(ForwardingConsumer forwardingconsumer)
        {
            this;
            JVM INSTR monitorenter ;
            if (mForwardingConsumer == forwardingconsumer)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            mForwardingConsumer = null;
            mMultiplexProducerContext = null;
            closeSafely(mLastIntermediateResult);
            mLastIntermediateResult = null;
            this;
            JVM INSTR monitorexit ;
            startNextProducerIfHasAttachedConsumers();
            return;
            forwardingconsumer;
            this;
            JVM INSTR monitorexit ;
            throw forwardingconsumer;
        }

        public void onFailure(ForwardingConsumer forwardingconsumer, Throwable throwable)
        {
            this;
            JVM INSTR monitorenter ;
            if (mForwardingConsumer == forwardingconsumer)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Iterator iterator;
            iterator = mConsumerContextPairs.iterator();
            mConsumerContextPairs.clear();
            removeMultiplexer(mKey, this);
            closeSafely(mLastIntermediateResult);
            mLastIntermediateResult = null;
            this;
            JVM INSTR monitorexit ;
            while (iterator.hasNext()) 
            {
                synchronized ((Pair)iterator.next())
                {
                    ((Consumer)((Pair) (forwardingconsumer)).first).onFailure(throwable);
                }
            }
            break MISSING_BLOCK_LABEL_104;
            throwable;
            forwardingconsumer;
            JVM INSTR monitorexit ;
            throw throwable;
            forwardingconsumer;
            this;
            JVM INSTR monitorexit ;
            throw forwardingconsumer;
        }

        public void onNextResult(ForwardingConsumer forwardingconsumer, Closeable closeable, boolean flag)
        {
            this;
            JVM INSTR monitorenter ;
            if (mForwardingConsumer == forwardingconsumer)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Iterator iterator;
            closeSafely(mLastIntermediateResult);
            mLastIntermediateResult = null;
            iterator = mConsumerContextPairs.iterator();
            if (flag)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            mLastIntermediateResult = cloneOrNull(closeable);
_L1:
            this;
            JVM INSTR monitorexit ;
            while (iterator.hasNext()) 
            {
                synchronized ((Pair)iterator.next())
                {
                    ((Consumer)((Pair) (forwardingconsumer)).first).onNewResult(closeable, flag);
                }
            }
            break MISSING_BLOCK_LABEL_127;
            closeable;
            forwardingconsumer;
            JVM INSTR monitorexit ;
            throw closeable;
            mConsumerContextPairs.clear();
            removeMultiplexer(mKey, this);
              goto _L1
            forwardingconsumer;
            this;
            JVM INSTR monitorexit ;
            throw forwardingconsumer;
        }

        public void onProgressUpdate(ForwardingConsumer forwardingconsumer, float f)
        {
            this;
            JVM INSTR monitorenter ;
            if (mForwardingConsumer == forwardingconsumer)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            Iterator iterator;
            mLastProgress = f;
            iterator = mConsumerContextPairs.iterator();
            this;
            JVM INSTR monitorexit ;
            while (iterator.hasNext()) 
            {
                synchronized ((Pair)iterator.next())
                {
                    ((Consumer)((Pair) (forwardingconsumer)).first).onProgressUpdate(f);
                }
            }
            break MISSING_BLOCK_LABEL_77;
            exception;
            forwardingconsumer;
            JVM INSTR monitorexit ;
            throw exception;
            forwardingconsumer;
            this;
            JVM INSTR monitorexit ;
            throw forwardingconsumer;
        }







        public Multiplexer(Object obj)
        {
            this$0 = MultiplexProducer.this;
            super();
            mKey = obj;
        }
    }

    private class Multiplexer.ForwardingConsumer extends BaseConsumer
    {

        final Multiplexer this$1;

        protected void onCancellationImpl()
        {
            onCancelled(this);
        }

        protected void onFailureImpl(Throwable throwable)
        {
            onFailure(this, throwable);
        }

        protected void onNewResultImpl(Closeable closeable, boolean flag)
        {
            onNextResult(this, closeable, flag);
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((Closeable)obj, flag);
        }

        protected void onProgressUpdateImpl(float f)
        {
            onProgressUpdate(this, f);
        }

        private Multiplexer.ForwardingConsumer()
        {
            this$1 = Multiplexer.this;
            super();
        }

    }


    final Map mMultiplexers = new HashMap();
    private final Producer mNextProducer;

    protected MultiplexProducer(Producer producer)
    {
        mNextProducer = producer;
    }

    private Multiplexer createAndPutNewMultiplexer(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Multiplexer multiplexer;
        multiplexer = new Multiplexer(obj);
        mMultiplexers.put(obj, multiplexer);
        this;
        JVM INSTR monitorexit ;
        return multiplexer;
        obj;
        throw obj;
    }

    private Multiplexer getExistingMultiplexer(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        obj = (Multiplexer)mMultiplexers.get(obj);
        this;
        JVM INSTR monitorexit ;
        return ((Multiplexer) (obj));
        obj;
        throw obj;
    }

    private void removeMultiplexer(Object obj, Multiplexer multiplexer)
    {
        this;
        JVM INSTR monitorenter ;
        if (mMultiplexers.get(obj) == multiplexer)
        {
            mMultiplexers.remove(obj);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    protected abstract Closeable cloneOrNull(Closeable closeable);

    protected abstract Object getKey(ProducerContext producercontext);

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        Object obj = getKey(producercontext);
_L2:
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Multiplexer multiplexer1 = getExistingMultiplexer(obj);
        Multiplexer multiplexer;
        multiplexer = multiplexer1;
        if (multiplexer1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        multiplexer = createAndPutNewMultiplexer(obj);
        flag = true;
        this;
        JVM INSTR monitorexit ;
        if (!multiplexer.addNewConsumer(consumer, producercontext)) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            multiplexer.startNextProducerIfHasAttachedConsumers();
        }
        return;
        consumer;
        this;
        JVM INSTR monitorexit ;
        throw consumer;
    }



}
