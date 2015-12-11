// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.Handler;
import java.io.InterruptedIOException;
import java.util.concurrent.Executor;
import roboguice.util.Ln;
import roboguice.util.SafeAsyncTask;

public abstract class GrouponSafeAsyncTask extends SafeAsyncTask
{
    protected class GrouponSafeAsyncTaskAndroidCallable extends roboguice.util.SafeAsyncTask.SafeAsyncTaskAndroidCallable
    {

        final GrouponSafeAsyncTask this$0;

        public void onException(Exception exception)
        {
            if ((exception instanceof InterruptedException) || (exception instanceof InterruptedIOException))
            {
                onInterrupted(exception);
                return;
            }
            try
            {
                super.onException(exception);
                Ln.w(exception, "May or may not indicate a problem", new Object[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                Ln.w(exception, "May or may not indicate a problem", new Object[0]);
            }
            return;
        }

        public void onFinally()
        {
            try
            {
                super.onFinally();
                return;
            }
            catch (Exception exception)
            {
                Ln.w(exception, "May or may not indicate a problem", new Object[0]);
            }
        }

        public void onSuccess(Object obj)
        {
            try
            {
                super.onSuccess(obj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Ln.w(((Throwable) (obj)), "May or may not indicate a problem", new Object[0]);
            }
        }

        protected GrouponSafeAsyncTaskAndroidCallable()
        {
            this$0 = GrouponSafeAsyncTask.this;
            super(GrouponSafeAsyncTask.this);
        }
    }


    protected GrouponSafeAsyncTask()
    {
    }

    protected GrouponSafeAsyncTask(Handler handler)
    {
        super(handler);
    }

    protected GrouponSafeAsyncTask(Handler handler, Executor executor)
    {
        super(handler, executor);
    }

    protected GrouponSafeAsyncTask(Executor executor)
    {
        super(executor);
    }

    protected Runnable newTask()
    {
        return new GrouponSafeAsyncTaskAndroidCallable();
    }

}
