// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.cache.ResourceCache;
import com.amazon.ansel.fetch.cache.ResourceCacheValue;
import com.amazon.ansel.fetch.log.AppLog;
import com.amazon.ansel.fetch.tools.ref.ObjectReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.ansel.fetch:
//            MutablePrioritized, LoaderContext, ThreadUtil, LoaderTask, 
//            ResourceKey, ResourceListener, LoaderListener

public abstract class ResourceLoader
    implements MutablePrioritized
{
    private class Listener extends LoaderTask.AbstractListener
    {

        final ResourceLoader this$0;

        public void done()
        {
            if (state != 1)
            {
                return;
            }
            log("Done");
            synchronized (stateLock)
            {
                if (state == 1)
                {
                    break MISSING_BLOCK_LABEL_50;
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
            state = 2;
            obj;
            JVM INSTR monitorexit ;
            dispose();
            return;
        }

        public void error(Throwable throwable)
        {
            if (state != 1)
            {
                return;
            } else
            {
                log((new StringBuilder()).append("Error: ").append(throwable.getMessage()).toString());
                context.executeCallback(throwable. new Runnable() {

                    final Listener this$1;
                    final Throwable val$error;

                    public void run()
                    {
                        Object obj = getResourceListener();
                        if (obj != null)
                        {
                            ((ResourceListener) (obj)).error(error);
                        }
                        obj = loaderListeners.iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break;
                            }
                            LoaderListener loaderlistener = (LoaderListener)((ObjectReference)((Iterator) (obj)).next()).get();
                            if (loaderlistener != null)
                            {
                                loaderlistener.error(error);
                            }
                        } while (true);
                    }

            
            {
                this$1 = final_listener;
                error = Throwable.this;
                super();
            }
                });
                return;
            }
        }

        public void result(Object obj)
        {
            if (state != 1)
            {
                return;
            } else
            {
                log("Sending result");
                context.executeCallback(((_cls1) (obj)). new Runnable() {

                    final Listener this$1;
                    final Object val$result;

                    public void run()
                    {
                        ResourceListener resourcelistener = getResourceListener();
                        if (resourcelistener == null)
                        {
                            log("Result listener reference is stale");
                            return;
                        } else
                        {
                            context.addReference(getResourceKey(), resourceListenerRef);
                            log("Invoking result callback");
                            resourcelistener.result(result);
                            return;
                        }
                    }

            
            {
                this$1 = final_listener;
                result = Object.this;
                super();
            }
                });
                return;
            }
        }

        private Listener()
        {
            this$0 = ResourceLoader.this;
            super();
        }

    }

    public static class State
    {

        public State()
        {
        }
    }


    public static final int DEFAULT_PRIORITY = 0;
    private static final String TAG = com/amazon/ansel/fetch/ResourceLoader.getSimpleName();
    private final LoaderContext context;
    private AtomicBoolean disposed;
    private List loaderListeners;
    private volatile long priority;
    private volatile Object resourceKey;
    private ObjectReference resourceListenerRef;
    private final Class resultClass;
    private volatile int state;
    private volatile Object stateLock;
    private volatile LoaderTask task;
    private volatile LoaderTask.Listener taskListener;

    public ResourceLoader(LoaderContext loadercontext, Class class1, ResourceListener resourcelistener, long l)
    {
        this(loadercontext, class1, loadercontext.newResourceListenerReference(resourcelistener), l);
    }

    public ResourceLoader(LoaderContext loadercontext, Class class1, ObjectReference objectreference, long l)
    {
        state = 1;
        stateLock = new Object();
        loaderListeners = new CopyOnWriteArrayList();
        disposed = new AtomicBoolean(false);
        context = loadercontext;
        resultClass = class1;
        resourceListenerRef = objectreference;
        priority = l;
        taskListener = new Listener();
    }

    private void dispose()
    {
        if (!disposed.compareAndSet(false, true))
        {
            return;
        } else
        {
            task = null;
            sendDone();
            loaderListeners.clear();
            return;
        }
    }

    private boolean loadFromPrimaryCache()
    {
        final Object key = getResourceKey();
        if (!context.getUseCache() || !context.getReadCache() || !context.getUsePrimaryCache() || !context.getReadPrimaryCache() || context.getPrimaryCache() == null)
        {
            return false;
        }
        final Object result = (ResourceCacheValue)context.getPrimaryCache().get(key);
        if (result == null)
        {
            log("Cache miss");
            return false;
        }
        log("Cache hit");
        if (((ResourceCacheValue) (result)).isExpired())
        {
            log("Cache element expired");
            context.getPrimaryCache().remove(key);
            return false;
        } else
        {
            result = ((ResourceCacheValue) (result)).getValue();
            context.executeCallback(new Runnable() {

                final ResourceLoader this$0;
                final Object val$key;
                final Object val$result;

                public void run()
                {
                    ResourceListener resourcelistener = getResourceListener();
                    if (resourcelistener != null)
                    {
                        context.addReference(key, resourceListenerRef);
                        resourcelistener.result(result);
                    }
                }

            
            {
                this$0 = ResourceLoader.this;
                key = obj;
                result = obj1;
                super();
            }
            });
            return true;
        }
    }

    private boolean loadFromPrimaryCacheAndFinish()
    {
        if (!loadFromPrimaryCache())
        {
            return false;
        }
        synchronized (stateLock)
        {
            if (state == 1)
            {
                break MISSING_BLOCK_LABEL_33;
            }
        }
        return false;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        state = 2;
        obj;
        JVM INSTR monitorexit ;
        dispose();
        return true;
    }

    private void log(String s)
    {
        if (AppLog.isLoggable(TAG, 2))
        {
            AppLog.v(TAG, (new StringBuilder()).append(s).append(" (resource: ").append(getResourceKey()).append(", thread: [").append(ThreadUtil.infoString()).append("])").toString());
        }
    }

    private void sendDone()
    {
        context.executeCallback(new Runnable() {

            final ResourceLoader this$0;

            public void run()
            {
                Object obj = getResourceListener();
                if (obj != null)
                {
                    ((ResourceListener) (obj)).done();
                }
                obj = loaderListeners.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    LoaderListener loaderlistener = (LoaderListener)((ObjectReference)((Iterator) (obj)).next()).get();
                    if (loaderlistener != null)
                    {
                        loaderlistener.done();
                    }
                } while (true);
            }

            
            {
                this$0 = ResourceLoader.this;
                super();
            }
        });
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
        LoaderTask loadertask = task;
        if (loadertask != null)
        {
            loadertask.removeLoader(this, true);
        }
        dispose();
        return;
    }

    public void addListener(ObjectReference objectreference)
    {
        loaderListeners.add(objectreference);
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
        LoaderTask loadertask = task;
        if (loadertask != null)
        {
            loadertask.removeLoader(this, false);
        }
        dispose();
        return;
    }

    public final void execute()
    {
        log("Start execute");
        executeLoader();
        log("End execute");
    }

    protected void executeLoader()
    {
        Object obj;
        while (state != 1 || loadFromPrimaryCacheAndFinish()) 
        {
            return;
        }
        obj = getResourceKey();
        Map map = context.getTasks();
        map;
        JVM INSTR monitorenter ;
        LoaderTask loadertask = (LoaderTask)map.get(obj);
        if (loadertask == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (!loadertask.addLoader(this))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        task = loadertask;
        map;
        JVM INSTR monitorexit ;
        return;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        map;
        JVM INSTR monitorexit ;
        map;
        JVM INSTR monitorenter ;
        obj = (LoaderTask)map.get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        log("Found existing task");
        if (((LoaderTask) (obj)).addLoader(this))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        log("Failed to attach to task");
        log("Creating new task");
        task = newLoaderTask();
        task.addLoader(this);
        task.addToTaskMap();
        map;
        JVM INSTR monitorexit ;
        task.submit();
        return;
        task = ((LoaderTask) (obj));
        map;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected Object generateResourceKey()
    {
        return new ResourceKey(getOperation(), getResourceRequest());
    }

    public LoaderContext getContext()
    {
        return context;
    }

    protected Object getOperation()
    {
        return getClass().getName();
    }

    public long getPriority()
    {
        return priority;
    }

    public Object getResourceKey()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (resourceKey == null)
        {
            resourceKey = generateResourceKey();
        }
        obj = resourceKey;
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    public ResourceListener getResourceListener()
    {
        if (resourceListenerRef != null)
        {
            return (ResourceListener)resourceListenerRef.get();
        } else
        {
            return null;
        }
    }

    public ObjectReference getResourceListenerReference()
    {
        return resourceListenerRef;
    }

    public abstract Object getResourceRequest();

    public Class getResultClass()
    {
        return resultClass;
    }

    public int getState()
    {
        return state;
    }

    public LoaderTask getTask()
    {
        return task;
    }

    protected LoaderTask.Listener getTaskListener()
    {
        return taskListener;
    }

    public abstract LoaderTask newLoaderTask();

    public void removeListener(ObjectReference objectreference)
    {
        loaderListeners.remove(objectreference);
    }

    public void setPriority(long l)
    {
        priority = l;
        if (state == 1 && task != null && task.getPriority() < l)
        {
            task.update();
        }
    }

    protected void setResourceKey(Object obj)
    {
        resourceKey = obj;
    }

    public String toString()
    {
        if (getResourceKey() != null)
        {
            return getResourceKey().toString();
        } else
        {
            return super.toString();
        }
    }







/*
    static int access$402(ResourceLoader resourceloader, int i)
    {
        resourceloader.state = i;
        return i;
    }

*/



}
