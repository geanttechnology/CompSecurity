// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils.os;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.aviary.android.feather.common.utils.ApiHelper;
import java.util.concurrent.RejectedExecutionException;

public abstract class AviaryAsyncTask extends AsyncTask
{

    private static final Handler S_HANDLER = new Handler(Looper.getMainLooper());

    public AviaryAsyncTask()
    {
    }

    private boolean isUiThread()
    {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    protected abstract void doPostExecute(Object obj);

    protected abstract void doPreExecute();

    protected transient void doProgressUpdate(Object aobj[])
    {
    }

    public final transient AsyncTask executeInParallel(Object aobj[])
    {
        if (ApiHelper.AT_LEAST_11)
        {
            AsyncTask asynctask;
            try
            {
                asynctask = executeOnExecutor(THREAD_POOL_EXECUTOR, aobj);
            }
            catch (RejectedExecutionException rejectedexecutionexception)
            {
                return execute(aobj);
            }
            return asynctask;
        } else
        {
            return execute(aobj);
        }
    }

    protected final void onPostExecute(final Object result)
    {
        if (isUiThread())
        {
            doPostExecute(result);
            return;
        } else
        {
            S_HANDLER.post(new Runnable() {

                final AviaryAsyncTask this$0;
                final Object val$result;

                public void run()
                {
                    doPostExecute(result);
                }

            
            {
                this$0 = AviaryAsyncTask.this;
                result = obj;
                super();
            }
            });
            return;
        }
    }

    protected void onPreExecute()
    {
        if (isUiThread())
        {
            doPreExecute();
            return;
        } else
        {
            S_HANDLER.post(new Runnable() {

                final AviaryAsyncTask this$0;

                public void run()
                {
                    doPreExecute();
                }

            
            {
                this$0 = AviaryAsyncTask.this;
                super();
            }
            });
            return;
        }
    }

    protected transient void onProgressUpdate(final Object values[])
    {
        if (isUiThread())
        {
            doProgressUpdate(values);
            return;
        } else
        {
            S_HANDLER.post(new Runnable() {

                final AviaryAsyncTask this$0;
                final Object val$values[];

                public void run()
                {
                    doProgressUpdate(values);
                }

            
            {
                this$0 = AviaryAsyncTask.this;
                values = aobj;
                super();
            }
            });
            return;
        }
    }

}
