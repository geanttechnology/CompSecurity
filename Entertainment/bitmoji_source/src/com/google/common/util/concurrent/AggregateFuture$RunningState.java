// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.util.concurrent:
//            AggregateFutureState, AggregateFuture, Uninterruptibles, ListenableFuture, 
//            MoreExecutors

abstract class collectsValues extends AggregateFutureState
    implements Runnable
{

    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private ImmutableCollection futures;
    final AggregateFuture this$0;

    private void decrementCountAndMaybeComplete()
    {
        int i = decrementRemainingAndGet();
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "Less than 0 remaining futures");
        if (i == 0)
        {
            processCompleted();
        }
    }

    private void handleException(Throwable throwable)
    {
        Preconditions.checkNotNull(throwable);
        boolean flag1 = false;
        boolean flag3 = true;
        boolean flag2 = flag3;
        boolean flag;
        if (allMustSucceed)
        {
            flag1 = setException(throwable);
            boolean flag4;
            if (flag1)
            {
                releaseResourcesAfterFailure();
                flag2 = flag3;
            } else
            {
                flag2 = AggregateFuture.access$400(getOrInitSeenExceptions(), throwable);
            }
        }
        flag3 = throwable instanceof Error;
        flag4 = allMustSucceed;
        if (!flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag & flag4 & flag2 | flag3)
        {
            String s;
            if (throwable instanceof Error)
            {
                s = "Input Future failed with Error";
            } else
            {
                s = "Got more than one input Future failure. Logging failures after the first";
            }
            AggregateFuture.access$500().log(Level.SEVERE, s, throwable);
        }
    }

    private void handleOneInputDone(int i, Future future)
    {
        boolean flag = false;
        if (allMustSucceed || !isDone() || isCancelled())
        {
            flag = true;
        }
        Preconditions.checkState(flag, "Future was done before all dependencies completed");
        Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
        if (!allMustSucceed)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (future.isCancelled())
        {
            AggregateFuture.access$601(AggregateFuture.this, false);
            return;
        }
        try
        {
            future = ((Future) (Uninterruptibles.getUninterruptibly(future)));
            if (collectsValues)
            {
                collectOneValue(allMustSucceed, i, future);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            handleException(future.getCause());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Future future)
        {
            handleException(future);
        }
        break MISSING_BLOCK_LABEL_143;
        if (collectsValues && !future.isCancelled())
        {
            collectOneValue(allMustSucceed, i, Uninterruptibles.getUninterruptibly(future));
            return;
        }
    }

    private void init()
    {
        if (!futures.isEmpty()) goto _L2; else goto _L1
_L1:
        handleAllCompleted();
_L4:
        return;
_L2:
        if (!allMustSucceed)
        {
            break; /* Loop/switch isn't completed */
        }
        final int index = 0;
        com.google.common.collect.UnmodifiableIterator unmodifiableiterator = futures.iterator();
        while (unmodifiableiterator.hasNext()) 
        {
            final ListenableFuture listenable = (ListenableFuture)unmodifiableiterator.next();
            listenable.addListener(new Runnable() {

                final AggregateFuture.RunningState this$1;
                final int val$index;
                final ListenableFuture val$listenable;

                public void run()
                {
                    handleOneInputDone(index, listenable);
                    decrementCountAndMaybeComplete();
                    return;
                    Exception exception;
                    exception;
                    decrementCountAndMaybeComplete();
                    throw exception;
                }

            
            {
                this$1 = AggregateFuture.RunningState.this;
                index = i;
                listenable = listenablefuture;
                super();
            }
            }, MoreExecutors.directExecutor());
            index++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        com.google.common.collect.UnmodifiableIterator unmodifiableiterator1 = futures.iterator();
        while (unmodifiableiterator1.hasNext()) 
        {
            ((ListenableFuture)unmodifiableiterator1.next()).addListener(this, MoreExecutors.directExecutor());
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private void processCompleted()
    {
        boolean flag = collectsValues;
        int i;
        if (!allMustSucceed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i & flag)
        {
            i = 0;
            for (com.google.common.collect.UnmodifiableIterator unmodifiableiterator = futures.iterator(); unmodifiableiterator.hasNext();)
            {
                handleOneInputDone(i, (ListenableFuture)unmodifiableiterator.next());
                i++;
            }

        }
        handleAllCompleted();
    }

    final void addInitialException(Set set)
    {
        if (!isCancelled())
        {
            AggregateFuture.access$400(set, trustedGetException());
        }
    }

    abstract void collectOneValue(boolean flag, int i, Object obj);

    abstract void handleAllCompleted();

    void interruptTask()
    {
    }

    void releaseResourcesAfterFailure()
    {
        futures = null;
    }

    public final void run()
    {
        decrementCountAndMaybeComplete();
    }





    _cls1.val.listenable(ImmutableCollection immutablecollection, boolean flag, boolean flag1)
    {
        this$0 = AggregateFuture.this;
        super(immutablecollection.size());
        futures = (ImmutableCollection)Preconditions.checkNotNull(immutablecollection);
        allMustSucceed = flag;
        collectsValues = flag1;
    }
}
