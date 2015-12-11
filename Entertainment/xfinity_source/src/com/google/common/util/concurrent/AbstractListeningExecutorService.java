// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.common.util.concurrent:
//            ListeningExecutorService, ListenableFutureTask, ListenableFuture

abstract class AbstractListeningExecutorService
    implements ListeningExecutorService
{

    AbstractListeningExecutorService()
    {
    }

    private Object doInvokeAny(Collection collection, boolean flag, long l)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        Object obj;
        ArrayList arraylist;
        ExecutorCompletionService executorcompletionservice;
        int i;
        int j;
        int k;
        int i1;
        long l1;
        long l2;
        long l3;
        i = collection.size();
        Future future;
        Iterator iterator;
        boolean flag1;
        if (i > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Preconditions.checkArgument(flag1);
        arraylist = new ArrayList(i);
        executorcompletionservice = new ExecutorCompletionService(this);
        if (!flag) goto _L2; else goto _L1
_L1:
        l1 = System.nanoTime();
_L9:
        iterator = collection.iterator();
        arraylist.add(executorcompletionservice.submit((Callable)iterator.next()));
        i1 = i - 1;
        i = 1;
        collection = null;
_L14:
        future = executorcompletionservice.poll();
        j = i;
        obj = future;
        k = i1;
        l2 = l1;
        l3 = l;
        if (future != null) goto _L4; else goto _L3
_L3:
        if (i1 <= 0) goto _L6; else goto _L5
_L5:
        k = i1 - 1;
        arraylist.add(executorcompletionservice.submit((Callable)iterator.next()));
        j = i + 1;
        l3 = l;
        l2 = l1;
        obj = future;
_L4:
        if (obj == null) goto _L8; else goto _L7
_L7:
        i = j - 1;
        collection = ((Collection) (((Future) (obj)).get()));
        break MISSING_BLOCK_LABEL_194;
_L2:
        l1 = 0L;
          goto _L9
_L6:
        if (i != 0) goto _L11; else goto _L10
_L10:
        if (collection != null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        collection = new ExecutionException(null);
        throw collection;
        collection;
          goto _L12
_L11:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        obj = executorcompletionservice.poll(l, TimeUnit.NANOSECONDS);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_333;
        }
        throw new TimeoutException();
        l2 = System.nanoTime();
        l3 = l - (l2 - l1);
        j = i;
        k = i1;
          goto _L4
        obj = executorcompletionservice.take();
        j = i;
        k = i1;
        l2 = l1;
        l3 = l;
          goto _L4
        collection;
        collection = new ExecutionException(collection);
        break MISSING_BLOCK_LABEL_415;
_L12:
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); ((Future)((Iterator) (obj)).next()).cancel(true)) { }
        throw collection;
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); ((Future)((Iterator) (obj)).next()).cancel(true)) { }
        return collection;
_L8:
        i = j;
        break MISSING_BLOCK_LABEL_415;
        collection;
        if (true) goto _L12; else goto _L13
_L13:
        collection;
        i1 = k;
        l1 = l2;
        l = l3;
          goto _L14
    }

    public List invokeAll(Collection collection)
        throws InterruptedException
    {
        Object obj;
        if (collection == null)
        {
            throw new NullPointerException();
        }
        obj = new ArrayList(collection.size());
        ListenableFutureTask listenablefuturetask;
        for (collection = collection.iterator(); collection.hasNext(); execute(listenablefuturetask))
        {
            listenablefuturetask = ListenableFutureTask.create((Callable)collection.next());
            ((List) (obj)).add(listenablefuturetask);
        }

        collection = ((List) (obj)).iterator();
_L1:
        Future future;
        boolean flag;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        future = (Future)collection.next();
        flag = future.isDone();
        if (!flag)
        {
            try
            {
                future.get();
            }
            catch (CancellationException cancellationexception) { }
            catch (ExecutionException executionexception) { }
            finally
            {
                if (true)
                {
                    for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((Future)((Iterator) (obj)).next()).cancel(true)) { }
                }
            }
        }
          goto _L1
        if (false)
        {
            for (collection = ((List) (obj)).iterator(); collection.hasNext(); ((Future)collection.next()).cancel(true)) { }
        }
        break MISSING_BLOCK_LABEL_209;
        throw collection;
        return ((List) (obj));
    }

    public List invokeAll(Collection collection, long l, TimeUnit timeunit)
        throws InterruptedException
    {
        long l1;
        if (collection == null || timeunit == null)
        {
            throw new NullPointerException();
        }
        l1 = timeunit.toNanos(l);
        timeunit = new ArrayList(collection.size());
        for (collection = collection.iterator(); collection.hasNext(); timeunit.add(ListenableFutureTask.create((Callable)collection.next()))) { }
        break MISSING_BLOCK_LABEL_123;
        collection;
          goto _L1
        l = System.nanoTime();
        collection = timeunit.iterator();
_L5:
        if (!collection.hasNext()) goto _L3; else goto _L2
_L2:
        execute((Runnable)(Runnable)collection.next());
        l3 = System.nanoTime();
        l2 = l1 - (l3 - l);
        l = l3;
        l1 = l2;
        if (l2 > 0L) goto _L5; else goto _L4
_L4:
        if (true)
        {
            for (collection = timeunit.iterator(); collection.hasNext(); ((Future)collection.next()).cancel(true)) { }
        }
          goto _L6
_L3:
        collection = timeunit.iterator();
_L10:
        if (!collection.hasNext()) goto _L8; else goto _L7
_L7:
        future = (Future)collection.next();
        flag = future.isDone();
        if (flag) goto _L10; else goto _L9
_L9:
        if (l1 > 0L) goto _L12; else goto _L11
_L11:
        if (true)
        {
            for (collection = timeunit.iterator(); collection.hasNext(); ((Future)collection.next()).cancel(true)) { }
        }
          goto _L6
_L12:
        future.get(l1, TimeUnit.NANOSECONDS);
_L13:
        l2 = System.nanoTime();
        l1 -= l2 - l;
        l = l2;
          goto _L10
        collection;
        if (true)
        {
            for (collection = timeunit.iterator(); collection.hasNext(); ((Future)collection.next()).cancel(true)) { }
        }
          goto _L6
_L8:
        if (false)
        {
            for (collection = timeunit.iterator(); collection.hasNext(); ((Future)collection.next()).cancel(true)) { }
        }
          goto _L6
_L1:
        Future future;
        long l2;
        long l3;
        boolean flag;
        if (true)
        {
            for (timeunit = timeunit.iterator(); timeunit.hasNext(); ((Future)timeunit.next()).cancel(true)) { }
        }
        throw collection;
_L6:
        return timeunit;
        Object obj;
        obj;
          goto _L13
        obj;
          goto _L13
    }

    public Object invokeAny(Collection collection)
        throws InterruptedException, ExecutionException
    {
        try
        {
            collection = ((Collection) (doInvokeAny(collection, false, 0L)));
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            throw new AssertionError();
        }
        return collection;
    }

    public Object invokeAny(Collection collection, long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return doInvokeAny(collection, true, timeunit.toNanos(l));
    }

    public ListenableFuture submit(Runnable runnable)
    {
        runnable = ListenableFutureTask.create(runnable, null);
        execute(runnable);
        return runnable;
    }

    public ListenableFuture submit(Runnable runnable, Object obj)
    {
        runnable = ListenableFutureTask.create(runnable, obj);
        execute(runnable);
        return runnable;
    }

    public ListenableFuture submit(Callable callable)
    {
        callable = ListenableFutureTask.create(callable);
        execute(callable);
        return callable;
    }

    public volatile Future submit(Runnable runnable)
    {
        return submit(runnable);
    }

    public volatile Future submit(Runnable runnable, Object obj)
    {
        return submit(runnable, obj);
    }

    public volatile Future submit(Callable callable)
    {
        return submit(callable);
    }
}
