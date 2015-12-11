// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.util;

import android.os.Handler;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

// Referenced classes of package roboguice.util:
//            Ln, AndroidCallable

public abstract class SafeAsyncTask
    implements Callable
{
    public class SafeAsyncTaskAndroidCallable extends AndroidCallable
    {

        final SafeAsyncTask this$0;

        public Object doInBackground()
            throws Exception
        {
            return call();
        }

        public void onException(Exception exception)
        {
            SafeAsyncTask.this.onException(exception);
        }

        public void onFinally()
        {
            SafeAsyncTask.this.onFinally();
        }

        public void onPreCall()
        {
            try
            {
                onPreExecute();
                return;
            }
            catch (Exception exception)
            {
                throw new RuntimeException(exception);
            }
        }

        public void onSuccess(Object obj)
        {
            try
            {
                SafeAsyncTask.this.onSuccess(obj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
        }

        public SafeAsyncTaskAndroidCallable()
        {
            this$0 = SafeAsyncTask.this;
            super();
        }
    }


    protected static final Executor DEFAULT_EXECUTOR = Executors.newFixedThreadPool(25);
    public static final int DEFAULT_POOL_SIZE = 25;
    protected Executor executor;
    protected FutureTask future;
    protected Handler handler;

    public SafeAsyncTask()
    {
        executor = DEFAULT_EXECUTOR;
    }

    public SafeAsyncTask(Handler handler1)
    {
        handler = handler1;
        executor = DEFAULT_EXECUTOR;
    }

    public SafeAsyncTask(Handler handler1, Executor executor1)
    {
        handler = handler1;
        executor = executor1;
    }

    public SafeAsyncTask(Executor executor1)
    {
        executor = executor1;
    }

    public boolean cancel(boolean flag)
    {
        if (future == null)
        {
            throw new UnsupportedOperationException("You cannot cancel this task before calling future()");
        } else
        {
            return future.cancel(flag);
        }
    }

    public void execute()
    {
        StackTraceElement astacktraceelement[];
        if (Ln.isDebugEnabled())
        {
            astacktraceelement = Thread.currentThread().getStackTrace();
        } else
        {
            astacktraceelement = null;
        }
        execute(astacktraceelement);
    }

    protected void execute(StackTraceElement astacktraceelement[])
    {
        executor.execute(future());
    }

    public Executor executor()
    {
        return executor;
    }

    public SafeAsyncTask executor(Executor executor1)
    {
        executor = executor1;
        return this;
    }

    public FutureTask future()
    {
        future = new FutureTask(newTask(), null);
        return future;
    }

    public Handler handler()
    {
        return handler;
    }

    public SafeAsyncTask handler(Handler handler1)
    {
        handler = handler1;
        return this;
    }

    public boolean isCancelled()
    {
        if (future == null)
        {
            return false;
        } else
        {
            return future.isCancelled();
        }
    }

    protected Runnable newTask()
    {
        return new SafeAsyncTaskAndroidCallable();
    }

    protected void onException(Exception exception)
        throws RuntimeException
    {
        onThrowable(exception);
    }

    protected void onFinally()
        throws RuntimeException
    {
    }

    protected void onInterrupted(Exception exception)
    {
        onException(exception);
    }

    protected void onPreExecute()
        throws Exception
    {
    }

    protected void onSuccess(Object obj)
        throws Exception
    {
    }

    protected void onThrowable(Throwable throwable)
        throws RuntimeException
    {
        Log.e("roboguice", "Throwable caught during background processing", throwable);
    }

}
