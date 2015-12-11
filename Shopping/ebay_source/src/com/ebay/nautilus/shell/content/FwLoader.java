// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.content;

import android.content.Context;
import com.ebay.nautilus.kernel.NautilusKernel;

// Referenced classes of package com.ebay.nautilus.shell.content:
//            FwAsyncTask

public abstract class FwLoader
{
    public static interface Callback
    {

        public abstract void onCanceled(FwLoader fwloader);

        public abstract void onTaskComplete(FwLoader fwloader);
    }

    private static final class LoaderTask extends FwAsyncTask
    {

        private final Callback cb;
        public final FwLoader loader;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            loader.doInBackground();
            return null;
        }

        protected void onCancelled()
        {
            loader.canceled = true;
            loader.task = null;
            loader.onCanceled();
            cb.onCanceled(loader);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            loader.task = null;
            cb.onTaskComplete(loader);
            loader.status = android.os.AsyncTask.Status.FINISHED;
        }

        public LoaderTask(FwLoader fwloader, Callback callback, int i)
        {
            super(i);
            loader = fwloader;
            cb = callback;
        }
    }


    boolean canceled;
    private final Context context;
    android.os.AsyncTask.Status status;
    LoaderTask task;

    protected FwLoader(Context context1)
    {
        canceled = false;
        task = null;
        status = android.os.AsyncTask.Status.PENDING;
        context = context1.getApplicationContext();
    }

    public final boolean cancel(boolean flag)
    {
        if (!canceled)
        {
            LoaderTask loadertask = task;
            if (loadertask != null)
            {
                canceled = loadertask.cancel(flag);
            }
        }
        return canceled;
    }

    protected abstract void doInBackground();

    public final void execute(Callback callback)
    {
        execute(callback, 1);
    }

    public final void execute(Callback callback, int i)
    {
        if (callback == null)
        {
            throw new NullPointerException("callback");
        }
        if (status != android.os.AsyncTask.Status.PENDING)
        {
            throw new IllegalStateException("You cannot run a loader more than once.");
        } else
        {
            status = android.os.AsyncTask.Status.RUNNING;
            task = new LoaderTask(this, callback, i);
            task.execute(new Void[0]);
            return;
        }
    }

    public final void executeImmediate()
    {
        NautilusKernel.verifyNotMain();
        if (status != android.os.AsyncTask.Status.PENDING)
        {
            throw new IllegalStateException("You cannot run a loader more than once.");
        } else
        {
            status = android.os.AsyncTask.Status.RUNNING;
            doInBackground();
            status = android.os.AsyncTask.Status.FINISHED;
            return;
        }
    }

    protected final Context getContext()
    {
        return context;
    }

    public final android.os.AsyncTask.Status getStatus()
    {
        return status;
    }

    public final boolean isCanceled()
    {
        return canceled;
    }

    protected void onCanceled()
    {
    }
}
