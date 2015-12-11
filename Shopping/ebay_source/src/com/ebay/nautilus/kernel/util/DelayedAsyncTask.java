// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

public abstract class DelayedAsyncTask extends AsyncTask
{

    private volatile boolean _canceled;
    private final Handler _handler = new Handler(Looper.getMainLooper());
    private Object _params[];
    private volatile boolean _pendingStart;
    private final Runnable _starter = new Runnable() {

        final DelayedAsyncTask this$0;

        public void run()
        {
            if (_pendingStart)
            {
                _pendingStart = false;
                if (!_canceled)
                {
                    executeOnThreadPool(_params);
                }
            }
        }

            
            {
                this$0 = DelayedAsyncTask.this;
                super();
            }
    };

    public DelayedAsyncTask()
    {
        _pendingStart = false;
        _canceled = false;
    }

    private void cancelCallbacks()
    {
        _canceled = true;
        if (_pendingStart)
        {
            _handler.removeCallbacks(_starter);
            _pendingStart = false;
        }
    }

    private void executeOnThreadPool(Object aobj[])
    {
        executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, aobj);
    }

    private boolean isMainThread()
    {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public boolean cancelDelayedTask(boolean flag)
    {
        if (_canceled)
        {
            return false;
        } else
        {
            cancelCallbacks();
            return cancel(flag);
        }
    }

    public transient DelayedAsyncTask executeDelayedTask(long l, Object aobj[])
    {
        if (_pendingStart || _canceled || getStatus() != android.os.AsyncTask.Status.PENDING)
        {
            throw new IllegalStateException("Cannot execute task: the task has already been run or scheduled to run.");
        }
        l = Math.max(0L, l);
        if (l == 0L && isMainThread())
        {
            executeOnThreadPool(aobj);
            return this;
        } else
        {
            _pendingStart = true;
            _params = aobj;
            _handler.postDelayed(_starter, l);
            return this;
        }
    }

    protected void onCancelled()
    {
        super.onCancelled();
        cancelCallbacks();
    }

    public boolean runImmediate()
    {
        if (!_pendingStart || _canceled || getStatus() != android.os.AsyncTask.Status.PENDING)
        {
            return false;
        }
        _handler.removeCallbacks(_starter);
        if (isMainThread())
        {
            _starter.run();
        } else
        {
            _handler.postDelayed(_starter, 0L);
        }
        return true;
    }



/*
    static boolean access$002(DelayedAsyncTask delayedasynctask, boolean flag)
    {
        delayedasynctask._pendingStart = flag;
        return flag;
    }

*/



}
