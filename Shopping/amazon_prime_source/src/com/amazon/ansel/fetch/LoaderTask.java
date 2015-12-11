// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.cache.ResourceCache;
import com.amazon.ansel.fetch.cache.ResourceCacheValue;
import com.amazon.ansel.fetch.log.AppLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.ansel.fetch:
//            MutablePrioritized, LoaderContext, ThreadUtil, LoaderException, 
//            ResourceLoader

public abstract class LoaderTask
    implements MutablePrioritized, Comparable, Runnable
{
    public static class AbstractListener
        implements Listener
    {

        public void done()
        {
        }

        public void error(Throwable throwable)
        {
        }

        public void result(Object obj)
        {
        }

        public AbstractListener()
        {
        }
    }

    public static interface Listener
    {

        public abstract void done();

        public abstract void error(Throwable throwable);

        public abstract void result(Object obj);
    }

    public static class State
    {

        public static final int Aborted = 8;
        public static final int Active = 1;
        public static final int Cancelled = 4;
        public static final int Done = 2;

        public State()
        {
        }
    }


    private static final String TAG = com/amazon/ansel/fetch/LoaderTask.getSimpleName();
    private final LoaderContext context;
    private AtomicBoolean disposed;
    private final List loaders = new CopyOnWriteArrayList();
    private volatile long priority;
    private final Object resourceKey;
    private volatile int state;
    private Object stateLock;
    private volatile boolean submitted;

    public LoaderTask(LoaderContext loadercontext, Object obj, long l)
    {
        state = 1;
        stateLock = new Object();
        priority = 0L;
        disposed = new AtomicBoolean(false);
        context = loadercontext;
        resourceKey = obj;
        priority = l;
    }

    private void dispose()
    {
        if (!disposed.compareAndSet(false, true))
        {
            return;
        }
        removeFromTaskMap();
        getContext().getExecutor().remove(this);
        sendDone();
        synchronized (loaders)
        {
            loaders.clear();
        }
        return;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void log(String s)
    {
        if (AppLog.isLoggable(TAG, 2))
        {
            AppLog.v(TAG, (new StringBuilder()).append(s).append(" (resource: ").append(getResourceKey()).append(", thread: [").append(ThreadUtil.infoString()).append("])").toString());
        }
    }

    public void abort()
    {
        if ((state & 5) == 0)
        {
            return;
        }
        synchronized (stateLock)
        {
            if ((state & 5) != 0)
            {
                break MISSING_BLOCK_LABEL_34;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        state = 8;
        obj;
        JVM INSTR monitorexit ;
        abortTask();
        dispose();
        return;
    }

    protected void abortTask()
    {
    }

    public boolean addLoader(ResourceLoader resourceloader)
    {
        if (state != 1)
        {
            return false;
        }
        synchronized (stateLock)
        {
            if (state == 1)
            {
                break MISSING_BLOCK_LABEL_34;
            }
        }
        return false;
        resourceloader;
        obj;
        JVM INSTR monitorexit ;
        throw resourceloader;
        loaders.add(resourceloader);
        obj;
        JVM INSTR monitorexit ;
        update();
        return true;
    }

    public void addToTaskMap()
    {
        synchronized (getContext().getTasks())
        {
            context.getTasks().put(resourceKey, this);
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancel()
    {
        if (state != 1)
        {
            return;
        }
        synchronized (stateLock)
        {
            if (state == 1)
            {
                break MISSING_BLOCK_LABEL_32;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        state = 4;
        obj;
        JVM INSTR monitorexit ;
        dispose();
        return;
    }

    public int compareTo(LoaderTask loadertask)
    {
        if (priority < loadertask.priority)
        {
            return -1;
        }
        return priority != loadertask.priority ? 1 : 0;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((LoaderTask)obj);
    }

    public Object execute()
    {
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        int i;
        log((new StringBuilder()).append("Executing with priority ").append(priority).toString());
        i = state;
        if (i == 1) goto _L2; else goto _L1
_L1:
        boolean flag;
        removeFromTaskMap();
        flag = false;
        Object obj = stateLock;
        obj;
        JVM INSTR monitorenter ;
        if (state != 1)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        state = 2;
        flag = true;
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            Exception exception;
            if (false)
            {
                sendError(null);
            } else
            {
                sendResult(null);
            }
            dispose();
        }
        obj1 = null;
_L6:
        return obj1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        ResourceCacheValue resourcecachevalue = executeTask();
        Throwable throwable;
        throwable = obj2;
        obj = obj1;
        if (resourcecachevalue == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        putInPrimaryCache(resourcecachevalue);
        obj = resourcecachevalue.getValue();
        throwable = obj2;
_L4:
        removeFromTaskMap();
        flag = false;
        obj1 = stateLock;
        obj1;
        JVM INSTR monitorenter ;
        if (state != 1)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        state = 2;
        flag = true;
        obj1;
        JVM INSTR monitorexit ;
        obj1 = obj;
        if (flag)
        {
            if (throwable != null)
            {
                sendError(throwable);
            } else
            {
                sendResult(obj);
            }
            dispose();
            return obj;
        }
        continue; /* Loop/switch isn't completed */
        throwable;
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception1;
        exception1;
        removeFromTaskMap();
        flag = false;
        obj = stateLock;
        obj;
        JVM INSTR monitorenter ;
        if (state != 1)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        state = 2;
        flag = true;
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            if (false)
            {
                sendError(null);
            } else
            {
                sendResult(null);
            }
            dispose();
        }
        throw exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected abstract ResourceCacheValue executeTask()
        throws LoaderException;

    public LoaderContext getContext()
    {
        return context;
    }

    public long getPriority()
    {
        return priority;
    }

    public Object getResourceKey()
    {
        return resourceKey;
    }

    public int getState()
    {
        return state;
    }

    protected void putInPrimaryCache(ResourceCacheValue resourcecachevalue)
    {
        if (getContext().getUseCache() && getContext().getWriteCache() && getContext().getUsePrimaryCache() && getContext().getWritePrimaryCache() && getContext().getPrimaryCache() != null)
        {
            log("Putting in cache");
            getContext().getPrimaryCache().put(getResourceKey(), resourcecachevalue);
        }
    }

    public void removeFromTaskMap()
    {
        synchronized (getContext().getTasks())
        {
            if ((LoaderTask)map.get(resourceKey) == this)
            {
                map.remove(resourceKey);
            }
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeLoader(ResourceLoader resourceloader, boolean flag)
    {
label0:
        {
            loaders.remove(resourceloader);
            if (loaders.isEmpty())
            {
                if (!flag)
                {
                    break label0;
                }
                abort();
            }
            return;
        }
        cancel();
    }

    public void run()
    {
        execute();
    }

    protected void sendDone()
    {
        log("Done");
        for (Iterator iterator = loaders.iterator(); iterator.hasNext(); ((ResourceLoader)iterator.next()).getTaskListener().done()) { }
    }

    protected void sendError(Throwable throwable)
    {
        log((new StringBuilder()).append("Error: ").append(throwable.getMessage()).toString());
        for (Iterator iterator = loaders.iterator(); iterator.hasNext(); ((ResourceLoader)iterator.next()).getTaskListener().error(throwable)) { }
    }

    protected void sendResult(Object obj)
    {
        log("Sending result");
        for (Iterator iterator = loaders.iterator(); iterator.hasNext(); ((ResourceLoader)iterator.next()).getTaskListener().result(obj)) { }
    }

    public void setExecutionPriority(long l)
    {
        if (priority == l)
        {
            return;
        }
        if (state != 1 || !submitted || !getContext().getExecutor().remove(this))
        {
            priority = l;
            return;
        } else
        {
            priority = l;
            submit();
            return;
        }
    }

    public void setPriority(long l)
    {
        priority = l;
    }

    public void submit()
    {
        submitted = true;
        context.getExecutor().execute(this);
    }

    protected void update()
    {
        long l = 0x8000000000000000L;
        if (!loaders.isEmpty()) goto _L2; else goto _L1
_L1:
        long l1 = 0L;
_L4:
        setExecutionPriority(l1);
        return;
_L2:
        Iterator iterator = loaders.iterator();
        do
        {
            l1 = l;
            if (!iterator.hasNext())
            {
                continue;
            }
            ResourceLoader resourceloader = (ResourceLoader)iterator.next();
            if (resourceloader.getPriority() > l)
            {
                l = resourceloader.getPriority();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
