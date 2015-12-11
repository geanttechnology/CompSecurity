// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import commonlib.service.WakeLockExecutorService;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import roboguice.inject.Lazy;
import roboguice.util.Ln;

public abstract class SyncManager
{
    protected static class AutomaticSyncRunnable extends UpdateRunnable
    {

        protected void performSync()
            throws Exception
        {
            SyncManager syncmanager = (SyncManager)syncManagerRef.get();
            if (syncmanager != null)
            {
                syncmanager.doSync(this);
            }
        }

        public void run()
        {
            super.run();
            SyncManager syncmanager = (SyncManager)syncManagerRef.get();
            if (syncmanager != null)
            {
                syncmanager.scheduleNextSync(this, syncmanager.timeBetweenRefreshWhenActive);
            }
            return;
            Exception exception;
            exception;
            SyncManager syncmanager1 = (SyncManager)syncManagerRef.get();
            if (syncmanager1 != null)
            {
                syncmanager1.scheduleNextSync(this, syncmanager1.timeBetweenRefreshWhenActive);
            }
            throw exception;
        }

        public AutomaticSyncRunnable(SyncUiCallbacks syncuicallbacks, Object obj, SyncManager syncmanager)
        {
            super(syncuicallbacks, obj, syncmanager);
        }
    }

    protected static class RetryQueueV2
        implements Iterable
    {

        private ArrayList queue;

        public void add(Runnable runnable)
        {
            queue.add(runnable);
        }

        public void clear()
        {
            queue.clear();
        }

        public Iterator iterator()
        {
            return queue.iterator();
        }

        public int size()
        {
            return queue.size();
        }

        protected RetryQueueV2()
        {
            queue = new ArrayList();
        }
    }

    public static interface SyncUiCallbacks
    {

        public abstract void enableSyncProgressIndicator(boolean flag);

        public abstract void handleSyncError(Runnable runnable, Exception exception);
    }

    public static class UpdateRunnable
        implements Runnable
    {

        private WeakReference callbacksRef;
        protected Object info;
        protected WeakReference syncManagerRef;

        protected void performSync()
            throws Exception
        {
            SyncManager syncmanager = (SyncManager)syncManagerRef.get();
            if (syncmanager != null)
            {
                syncmanager.doSync(this);
            }
        }

        public void run()
        {
            SyncManager syncmanager = (SyncManager)syncManagerRef.get();
            if (syncmanager == null)
            {
                return;
            } else
            {
                syncmanager.execute(new Runnable() {

                    final UpdateRunnable this$0;

                    public void run()
                    {
                        final SyncUiCallbacks cb;
                        SyncManager syncmanager;
                        syncmanager = (SyncManager)syncManagerRef.get();
                        if (syncmanager == null)
                        {
                            return;
                        }
                        if (callbacksRef.get() != null)
                        {
                            cb = (SyncUiCallbacks)callbacksRef.get();
                        } else
                        {
                            cb = SyncManager.NULL_CALLBACKS;
                        }
                        syncmanager.handler.post(cb. new Runnable() {

                            final UpdateRunnable._cls1 this$1;
                            final SyncUiCallbacks val$cb;

                            public void run()
                            {
                                cb.enableSyncProgressIndicator(true);
                            }

            
            {
                this$1 = final__pcls1;
                cb = SyncUiCallbacks.this;
                super();
            }
                        });
                        performSync();
                        syncmanager.onSuccess(info);
                        syncmanager.onFinally(info);
                        syncmanager.handler.post(cb. new Runnable() {

                            final UpdateRunnable._cls1 this$1;
                            final SyncUiCallbacks val$cb;

                            public void run()
                            {
                                cb.enableSyncProgressIndicator(false);
                            }

            
            {
                this$1 = final__pcls1;
                cb = SyncUiCallbacks.this;
                super();
            }
                        });
                        return;
                        Object obj;
                        obj;
                        if (!(obj instanceof IOException))
                        {
                            Ln.e(((Throwable) (obj)));
                        }
                        syncmanager.onException(info, ((Exception) (obj)));
                        if (!cb.equals(SyncManager.NULL_CALLBACKS) && (!(syncmanager.context instanceof Activity) || syncmanager.shouldShowErrorAfterAdd(this)))
                        {
                            syncmanager.handler.post(((_cls2) (obj)). new Runnable() {

                                final UpdateRunnable._cls1 this$1;
                                final SyncUiCallbacks val$cb;
                                final Exception val$e;

                                public void run()
                                {
                                    cb.handleSyncError(_fld0, e);
                                }

            
            {
                this$1 = final__pcls1;
                cb = syncuicallbacks;
                e = Exception.this;
                super();
            }
                            });
                        }
                        syncmanager.onFinally(info);
                        syncmanager.handler.post(cb. new _cls3());
                        return;
                        obj;
                        syncmanager.onFinally(info);
                        syncmanager.handler.post(cb. new _cls3());
                        throw obj;
                    }

            
            {
                this$0 = UpdateRunnable.this;
                super();
            }
                });
                return;
            }
        }


        public UpdateRunnable(SyncUiCallbacks syncuicallbacks, Object obj, SyncManager syncmanager)
        {
            info = obj;
            callbacksRef = new WeakReference(syncuicallbacks);
            syncManagerRef = new WeakReference(syncmanager);
        }
    }


    private static final long DEFAULT_TIME_BETWEEN_REFRESH_WHEN_ACTIVE_MS = 0x493e0L;
    protected static final SyncUiCallbacks NULL_CALLBACKS = new SyncUiCallbacks() {

        public void enableSyncProgressIndicator(boolean flag)
        {
        }

        public void handleSyncError(Runnable runnable, Exception exception)
        {
        }

    };
    private static ExecutorService masterExecutor = Executors.newSingleThreadExecutor();
    private AutomaticSyncRunnable automaticSyncRunnable;
    protected Context context;
    protected ExecutorService executor;
    private Handler handler;
    private Lazy retryQueue;
    private long timeBetweenRefreshWhenActive;

    public SyncManager(Context context1)
    {
        this(context1, 0x493e0L, masterExecutor);
    }

    public SyncManager(Context context1, long l, ExecutorService executorservice)
    {
        handler = new Handler(Looper.getMainLooper());
        context = context1;
        timeBetweenRefreshWhenActive = l;
        retryQueue = new Lazy(context1) {

            final SyncManager this$0;

            
            {
                this$0 = SyncManager.this;
                super(context1);
            }
        };
        if (!(context1 instanceof Activity))
        {
            executorservice = new WakeLockExecutorService(context1, masterExecutor);
        }
        executor = executorservice;
    }

    public SyncManager(Context context1, ExecutorService executorservice)
    {
        this(context1, 0x493e0L, executorservice);
    }

    public void clearRetryTasks()
    {
        synchronized (retryQueue)
        {
            ((RetryQueueV2)retryQueue.get()).clear();
        }
        return;
        exception;
        lazy;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected AutomaticSyncRunnable createAutomaticSyncRunnable(SyncUiCallbacks syncuicallbacks, Object obj)
    {
        return new AutomaticSyncRunnable(syncuicallbacks, obj, this);
    }

    protected UpdateRunnable createOneShotSyncRunnable(SyncUiCallbacks syncuicallbacks, Object obj)
    {
        return new UpdateRunnable(syncuicallbacks, obj, this);
    }

    protected void doSync(UpdateRunnable updaterunnable)
        throws Exception
    {
        doSync(updaterunnable.info);
    }

    protected abstract void doSync(Object obj)
        throws Exception;

    public void execute(Runnable runnable)
    {
        executor.execute(runnable);
    }

    protected abstract long lastUpdated()
        throws Exception;

    protected void onException(Object obj, Exception exception)
    {
    }

    protected void onFinally(Object obj)
    {
    }

    protected void onSuccess(Object obj)
    {
    }

    public void requestSync(SyncUiCallbacks syncuicallbacks, Object obj)
    {
        submit(createOneShotSyncRunnable(syncuicallbacks, obj));
    }

    public void retryTasks()
    {
        if (executor.isTerminated() || executor.isShutdown()) goto _L2; else goto _L1
_L1:
        Lazy lazy = retryQueue;
        lazy;
        JVM INSTR monitorenter ;
        for (Iterator iterator = ((RetryQueueV2)retryQueue.get()).iterator(); iterator.hasNext(); execute((Runnable)iterator.next())) { }
        break MISSING_BLOCK_LABEL_75;
        Exception exception;
        exception;
        lazy;
        JVM INSTR monitorexit ;
        throw exception;
        ((RetryQueueV2)retryQueue.get()).clear();
        lazy;
        JVM INSTR monitorexit ;
_L2:
    }

    protected void scheduleNextSync(AutomaticSyncRunnable automaticsyncrunnable, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (automaticSyncRunnable != null && automaticSyncRunnable.equals(automaticsyncrunnable))
        {
            Ln.d("Time until next sync for %s: %ss", new Object[] {
                this, Long.valueOf(l / 1000L)
            });
            handler.postDelayed(automaticsyncrunnable, l);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        automaticsyncrunnable;
        throw automaticsyncrunnable;
    }

    public boolean shouldShowErrorAfterAdd(Runnable runnable)
    {
        Lazy lazy = retryQueue;
        lazy;
        JVM INSTR monitorenter ;
        ((RetryQueueV2)retryQueue.get()).add(runnable);
        boolean flag;
        if (((RetryQueueV2)retryQueue.get()).size() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lazy;
        JVM INSTR monitorexit ;
        return flag;
        runnable;
        lazy;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public void startAutomaticSyncs(SyncUiCallbacks syncuicallbacks, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        startAutomaticSyncs(syncuicallbacks, obj, 0L);
        this;
        JVM INSTR monitorexit ;
        return;
        syncuicallbacks;
        throw syncuicallbacks;
    }

    public void startAutomaticSyncs(final SyncUiCallbacks tmp, Object obj, final long firstDelay)
    {
        this;
        JVM INSTR monitorenter ;
        stopAutomaticSyncs();
        tmp = createAutomaticSyncRunnable(tmp, obj);
        automaticSyncRunnable = tmp;
        submit(new Callable() {

            final SyncManager this$0;
            final long val$firstDelay;
            final AutomaticSyncRunnable val$tmp;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                long l1 = System.currentTimeMillis();
                long l = lastUpdated();
                l1 = Math.max(firstDelay, (timeBetweenRefreshWhenActive - l1) + l);
                Ln.d("lastUpdated %s; timeBetweenRefresh %ss", new Object[] {
                    new Date(l), Long.valueOf(timeBetweenRefreshWhenActive / 1000L)
                });
                scheduleNextSync(tmp, l1);
                return null;
            }

            
            {
                this$0 = SyncManager.this;
                firstDelay = l;
                tmp = automaticsyncrunnable;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        tmp;
        throw tmp;
    }

    public void stopAutomaticSyncs()
    {
        this;
        JVM INSTR monitorenter ;
        if (automaticSyncRunnable != null)
        {
            handler.removeCallbacks(automaticSyncRunnable);
            automaticSyncRunnable = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void submit(Runnable runnable)
    {
        executor.submit(runnable);
    }

    public void submit(Callable callable)
    {
        executor.submit(callable);
    }



}
