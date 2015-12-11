// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.os.Handler;
import java.io.InterruptedIOException;
import java.util.concurrent.Executor;
import roboguice.util.Ln;
import roboguice.util.RoboAsyncTask;

public abstract class GrouponRoboAsyncTask extends RoboAsyncTask
{
    protected class GrouponRoboSafeAsyncTaskAndroidCallable extends roboguice.util.SafeAsyncTask.SafeAsyncTaskAndroidCallable
    {

        final GrouponRoboAsyncTask this$0;

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

        protected GrouponRoboSafeAsyncTaskAndroidCallable()
        {
            this$0 = GrouponRoboAsyncTask.this;
            super(GrouponRoboAsyncTask.this);
        }
    }


    protected GrouponRoboAsyncTask(Context context)
    {
        super(context);
    }

    protected GrouponRoboAsyncTask(Context context, Handler handler)
    {
        super(context, handler);
    }

    protected GrouponRoboAsyncTask(Context context, Handler handler, Executor executor)
    {
        super(context, handler, executor);
    }

    protected GrouponRoboAsyncTask(Context context, Executor executor)
    {
        super(context, executor);
    }

    protected Runnable newTask()
    {
        return new GrouponRoboSafeAsyncTaskAndroidCallable();
    }

}
