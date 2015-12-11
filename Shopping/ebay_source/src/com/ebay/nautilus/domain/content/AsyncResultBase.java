// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            AsyncResult, AsyncLoadTask, AsyncLoadTasks

public abstract class AsyncResultBase
    implements AsyncResult
{
    private final class LoadTasksImpl
        implements AsyncLoadTasks, Runnable
    {

        boolean deliverCalled;
        final ArrayList runningTasks;
        boolean safeToDeliverOrStart;
        final AsyncResultBase this$0;
        boolean waiting;

        final void add(LoadAsyncTask loadasynctask)
        {
            runningTasks.add(loadasynctask);
        }

        final boolean cancel(boolean flag)
        {
            NautilusKernel.verifyMain();
            if (runningTasks.isEmpty())
            {
                return false;
            }
            boolean flag1 = true;
            for (Iterator iterator = (new ArrayList(runningTasks)).iterator(); iterator.hasNext();)
            {
                if (((LoadAsyncTask)iterator.next()).cancel(flag) && flag1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            }

            return flag1;
        }

        public void deliverResult(Object obj)
        {
            if (!safeToDeliverOrStart)
            {
                throw new IllegalArgumentException("Result cannot be delivered!");
            } else
            {
                deliverCalled = true;
                cb.deliverResult(obj);
                return;
            }
        }

        final void remove(LoadAsyncTask loadasynctask)
        {
            int j = runningTasks.size();
            int i = 0;
            do
            {
label0:
                {
                    if (i < j)
                    {
                        if (runningTasks.get(i) != loadasynctask)
                        {
                            break label0;
                        }
                        runningTasks.remove(i);
                    }
                    return;
                }
                i++;
            } while (true);
        }

        public void run()
        {
            waiting = false;
            executePendingTask();
        }

        public void start(AsyncLoadTask asyncloadtask)
        {
            NautilusKernel.verifyMain();
            if (!safeToDeliverOrStart)
            {
                throw new IllegalArgumentException("Task cannot be started!");
            } else
            {
                (new LoadAsyncTask(asyncloadtask)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[])null);
                return;
            }
        }

        private LoadTasksImpl()
        {
            this$0 = AsyncResultBase.this;
            super();
            runningTasks = new ArrayList();
        }

    }

    final class LoadTasksImpl.LoadAsyncTask extends AsyncTask
    {

        private Object result;
        private final AsyncLoadTask task;
        final LoadTasksImpl this$1;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Object doInBackground(Void avoid[])
        {
            result = task.loadInBackground();
            return result;
        }

        protected void onCancelled()
        {
            remove(this);
            dispatchOnCanceled(LoadTasksImpl.this, task, result);
        }

        protected void onPostExecute(Object obj)
        {
            remove(this);
            dispatchOnLoadComplete(LoadTasksImpl.this, task, obj);
        }

        public LoadTasksImpl.LoadAsyncTask(AsyncLoadTask asyncloadtask)
        {
            this$1 = LoadTasksImpl.this;
            super();
            task = asyncloadtask;
            add(this);
        }
    }


    static final boolean DEBUG = false;
    static final String TAG = "AsyncResultBase";
    protected final AsyncResult.Callback cb;
    volatile LoadTasksImpl mCancelingTask;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile LoadTasksImpl mTask;
    long mUpdateThrottle;

    public AsyncResultBase(AsyncResult.Callback callback)
    {
        mLastLoadCompleteTime = -10000L;
        cb = callback;
    }

    public boolean cancelLoad()
    {
        return cancelLoad(false);
    }

    public boolean cancelLoad(boolean flag)
    {
label0:
        {
            if (mTask != null)
            {
                if (mCancelingTask == null)
                {
                    break label0;
                }
                if (mTask.waiting)
                {
                    mTask.waiting = false;
                    mHandler.removeCallbacks(mTask);
                }
                mTask = null;
            }
            return false;
        }
        if (mTask.waiting)
        {
            mTask.waiting = false;
            mHandler.removeCallbacks(mTask);
            mTask = null;
            return false;
        }
        flag = mTask.cancel(flag);
        if (flag)
        {
            mCancelingTask = mTask;
        }
        mTask = null;
        return flag;
    }

    void dispatchOnCanceled(LoadTasksImpl loadtasksimpl, AsyncLoadTask asyncloadtask, Object obj)
    {
        asyncloadtask.dispatchOnCanceled(loadtasksimpl, obj);
        if (loadtasksimpl.runningTasks.isEmpty())
        {
            onCanceled(null);
            if (mCancelingTask == loadtasksimpl)
            {
                mLastLoadCompleteTime = SystemClock.uptimeMillis();
                mCancelingTask = null;
                executePendingTask();
            }
        }
    }

    void dispatchOnLoadComplete(LoadTasksImpl loadtasksimpl, AsyncLoadTask asyncloadtask, Object obj)
    {
        if (mTask == loadtasksimpl) goto _L2; else goto _L1
_L1:
        dispatchOnCanceled(loadtasksimpl, asyncloadtask, obj);
_L4:
        return;
_L2:
        if (cb.isAbandoned())
        {
            asyncloadtask.dispatchOnCanceled(loadtasksimpl, obj);
            return;
        }
        mLastLoadCompleteTime = SystemClock.uptimeMillis();
        mTask.safeToDeliverOrStart = true;
        mTask.deliverCalled = false;
        asyncloadtask.dispatchOnLoadComplete(loadtasksimpl, obj);
        mTask.safeToDeliverOrStart = false;
        if (!mTask.runningTasks.isEmpty()) goto _L4; else goto _L3
_L3:
        if (!mTask.deliverCalled)
        {
            throw new RuntimeException("Need to start at least one task or deliver a result!");
        } else
        {
            mTask = null;
            return;
        }
        loadtasksimpl;
        mTask.safeToDeliverOrStart = false;
        if (mTask.runningTasks.isEmpty())
        {
            if (!mTask.deliverCalled)
            {
                throw new RuntimeException("Need to start at least one task or deliver a result!");
            }
            mTask = null;
        }
        throw loadtasksimpl;
    }

    void executePendingTask()
    {
        if (mCancelingTask != null || mTask == null) goto _L2; else goto _L1
_L1:
        if (mTask.waiting)
        {
            mTask.waiting = false;
            mHandler.removeCallbacks(mTask);
        }
        if (mUpdateThrottle <= 0L || SystemClock.uptimeMillis() >= mLastLoadCompleteTime + mUpdateThrottle) goto _L4; else goto _L3
_L3:
        mTask.waiting = true;
        mHandler.postAtTime(mTask, mLastLoadCompleteTime + mUpdateThrottle);
_L2:
        return;
_L4:
        mTask.safeToDeliverOrStart = true;
        mTask.deliverCalled = false;
        startLoad(mTask);
        mTask.safeToDeliverOrStart = false;
        if (!mTask.runningTasks.isEmpty()) goto _L2; else goto _L5
_L5:
        if (!mTask.deliverCalled)
        {
            throw new RuntimeException("Need to start at least one task or deliver a result!");
        } else
        {
            mTask = null;
            return;
        }
        Exception exception;
        exception;
        mTask.safeToDeliverOrStart = false;
        if (mTask.runningTasks.isEmpty())
        {
            if (!mTask.deliverCalled)
            {
                throw new RuntimeException("Need to start at least one task or deliver a result!");
            }
            mTask = null;
        }
        throw exception;
    }

    public void onCanceled(Object obj)
    {
        cb.onCanceled(obj);
    }

    public void setUpdateThrottle(long l)
    {
        mUpdateThrottle = l;
        if (l != 0L)
        {
            mHandler = new Handler();
        }
    }

    public final void startLoad()
    {
        cancelLoad();
        mTask = new LoadTasksImpl();
        executePendingTask();
    }

    protected abstract void startLoad(AsyncLoadTasks asyncloadtasks);
}
