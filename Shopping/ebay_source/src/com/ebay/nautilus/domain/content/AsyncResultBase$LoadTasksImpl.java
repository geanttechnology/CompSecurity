// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import android.os.AsyncTask;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            AsyncLoadTasks, AsyncResultBase, AsyncLoadTask

private final class <init>
    implements AsyncLoadTasks, Runnable
{
    final class LoadAsyncTask extends AsyncTask
    {

        private Object result;
        private final AsyncLoadTask task;
        final AsyncResultBase.LoadTasksImpl this$1;

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
            dispatchOnCanceled(AsyncResultBase.LoadTasksImpl.this, task, result);
        }

        protected void onPostExecute(Object obj)
        {
            remove(this);
            dispatchOnLoadComplete(AsyncResultBase.LoadTasksImpl.this, task, obj);
        }

        public LoadAsyncTask(AsyncLoadTask asyncloadtask)
        {
            this$1 = AsyncResultBase.LoadTasksImpl.this;
            super();
            task = asyncloadtask;
            add(this);
        }
    }


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
            cb.sult(obj);
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

    private LoadAsyncTask()
    {
        this$0 = AsyncResultBase.this;
        super();
        runningTasks = new ArrayList();
    }

    runningTasks(runningTasks runningtasks)
    {
        this();
    }
}
