// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.os.StrictMode;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class AsyncCursorList extends AbstractList
{
    protected class AsyncLoader
        implements Callable
    {

        private int limit;
        private int startToken;
        final AsyncCursorList this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public List call()
            throws Exception
        {
            return backQuery(startToken, limit);
        }

        public AsyncLoader(int i, int j)
        {
            this$0 = AsyncCursorList.this;
            super();
            startToken = i;
            limit = j;
        }
    }

    protected class FakeFuture
        implements Future
    {

        private List result;
        final AsyncCursorList this$0;

        public boolean cancel(boolean flag)
        {
            return false;
        }

        public volatile Object get()
            throws InterruptedException, ExecutionException
        {
            return get();
        }

        public volatile Object get(long l, TimeUnit timeunit)
            throws InterruptedException, ExecutionException, TimeoutException
        {
            return get(l, timeunit);
        }

        public List get()
            throws InterruptedException, ExecutionException
        {
            return result;
        }

        public List get(long l, TimeUnit timeunit)
            throws InterruptedException, ExecutionException, TimeoutException
        {
            return get();
        }

        public boolean isCancelled()
        {
            return false;
        }

        public boolean isDone()
        {
            return true;
        }

        protected FakeFuture(List list1)
        {
            this$0 = AsyncCursorList.this;
            super();
            result = list1;
        }
    }

    private class Itr
        implements Iterator
    {

        Object e;
        int ePos;
        int pos;
        final AsyncCursorList this$0;

        public boolean hasNext()
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (pos + 1 < size())
            {
                try
                {
                    ePos = pos + 1;
                    e = get(ePos);
                }
                catch (IndexOutOfBoundsException indexoutofboundsexception)
                {
                    return false;
                }
                flag = flag1;
                if (e != null)
                {
                    flag = true;
                }
            }
            return flag;
        }

        public Object next()
        {
            Object obj;
            try
            {
                pos = pos + 1;
                if (ePos == pos)
                {
                    return e;
                }
                obj = get(pos);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                throw new NoSuchElementException();
            }
            return obj;
        }

        public void remove()
        {
            throw new RuntimeException("Operation is not supported");
        }

        private Itr()
        {
            this$0 = AsyncCursorList.this;
            super();
            pos = -1;
            ePos = -1;
        }

    }


    public static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/AsyncCursorList.getName();
    private List currentWindow;
    protected final int cursorSize;
    protected int endPosition;
    private boolean initialized;
    protected Future list[];
    protected int startPosition;
    private int windowIndex;
    protected final int windowSize;

    public AsyncCursorList(int i, int j)
    {
        initialized = false;
        cursorSize = i;
        windowSize = j;
    }

    private void init(int i)
    {
        startPosition = Math.max(0, i - windowSize / 2);
        endPosition = startPosition + windowSize;
        list = (Future[])new Future[3];
        windowIndex = 0;
        currentWindow = null;
        initialized = true;
    }

    public void add(int i, Object obj)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public boolean add(Object obj)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public boolean addAll(int i, Collection collection)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public boolean addAll(Collection collection)
    {
        throw new RuntimeException("Operation is not supported");
    }

    protected abstract List backQuery(int i, int j);

    protected abstract Future enqueueRequest(AsyncLoader asyncloader);

    public Object get(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        if (i < cursorSize)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        GLogger.w(TAG, "position %d, cursor size %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(cursorSize)
        });
        throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append(i).append(" is requested for cursor size of ").append(cursorSize).toString());
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (!initialized || i < startPosition || i >= endPosition) goto _L2; else goto _L1
_L1:
        Object obj1 = currentWindow.get(i - startPosition);
_L5:
        this;
        JVM INSTR monitorexit ;
        return obj1;
_L2:
        if (initialized) goto _L4; else goto _L3
_L3:
        init(i);
        int k = 1;
        int j = windowSize;
_L8:
        Future future = list[windowIndex % 3];
        obj1 = future;
        if (future != null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        StrictMode.noteSlowCall("db_access");
        GLogger.v(TAG, "sync cursor request position:%d, length:%d, thread:%s", new Object[] {
            Integer.valueOf(startPosition), Integer.valueOf(j), Thread.currentThread().getName()
        });
        obj1 = new FakeFuture(backQuery(startPosition, j));
        list[windowIndex % 3] = ((Future) (obj1));
        if (!((Future) (obj1)).isDone())
        {
            StrictMode.noteSlowCall("db_access");
            GLogger.v(TAG, "Blocked request position:%d, thread:%s", new Object[] {
                Integer.valueOf(i), Thread.currentThread().getName()
            });
        }
        currentWindow = (List)((Future) (obj1)).get();
        scheduleBackQuery(k);
        obj1 = currentWindow.get(i - startPosition);
          goto _L5
_L4:
label0:
        {
            if (i < endPosition + windowSize && i >= startPosition - windowSize)
            {
                break label0;
            }
            initialized = false;
            GLogger.v(TAG, "Reset for position:%d, thread:%s", new Object[] {
                Integer.valueOf(i), Thread.currentThread().getName()
            });
            obj1 = get(i);
        }
          goto _L5
        if (i < endPosition) goto _L7; else goto _L6
_L6:
        k = 1;
        startPosition = endPosition;
        j = Math.min(windowSize, cursorSize - endPosition);
        endPosition = endPosition + j;
_L9:
        windowIndex = nextWindowIndex(k);
          goto _L8
_L7:
        k = -1;
        endPosition = startPosition;
        j = Math.min(windowSize, startPosition);
        startPosition = startPosition - j;
          goto _L9
        InterruptedException interruptedexception;
        interruptedexception;
        ((Future) (obj1)).cancel(true);
        Thread.currentThread().interrupt();
        obj1 = null;
          goto _L5
        obj1;
        GLogger.ex(TAG, "Can't query for new window", ((Throwable) (obj1)));
        throw new RuntimeException(((ExecutionException) (obj1)).getMessage());
          goto _L5
    }

    public Iterator iterator()
    {
        return new Itr();
    }

    public ListIterator listIterator()
    {
        throw new RuntimeException("Operation is not supported");
    }

    public ListIterator listIterator(int i)
    {
        throw new RuntimeException("Operation is not supported");
    }

    protected int nextWindowIndex(int i)
    {
        int j = windowIndex + i;
        if (j == -1)
        {
            i = 2;
        } else
        {
            i = j;
            if (j == 3)
            {
                return 0;
            }
        }
        return i;
    }

    public Object remove(int i)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public boolean remove(Object obj)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public boolean removeAll(Collection collection)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public boolean retainAll(Collection collection)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public void scheduleBackQuery(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i <= 0) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        k = endPosition;
        j = Math.min(windowSize, cursorSize - endPosition);
_L7:
        if (j == 0) goto _L4; else goto _L3
_L3:
        int l = cursorSize;
        if (k < l) goto _L5; else goto _L4
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        j = Math.min(windowSize, startPosition);
        k = startPosition - j;
        continue; /* Loop/switch isn't completed */
_L5:
        GLogger.v(TAG, "async cursor request position:%d, length:%d, thread:%s", new Object[] {
            Integer.valueOf(k), Integer.valueOf(j), Thread.currentThread().getName()
        });
        Future future = enqueueRequest(new AsyncLoader(k, j));
        i = nextWindowIndex(i);
        list[i % 3] = future;
          goto _L4
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Object set(int i, Object obj)
    {
        throw new RuntimeException("Operation is not supported");
    }

    public int size()
    {
        return cursorSize;
    }

    public List subList(int i, int j)
    {
        throw new RuntimeException("Operation is not supported");
    }

}
