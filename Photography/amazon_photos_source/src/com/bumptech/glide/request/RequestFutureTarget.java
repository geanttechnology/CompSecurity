// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.bumptech.glide.request:
//            FutureTarget, Request

public class RequestFutureTarget
    implements FutureTarget, Runnable
{
    static class Waiter
    {

        public void notifyAll(Object obj)
        {
            obj.notifyAll();
        }

        public void waitForTimeout(Object obj, long l)
            throws InterruptedException
        {
            obj.wait(l);
        }

        Waiter()
        {
        }
    }


    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final Handler mainHandler;
    private Request request;
    private Object resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    public RequestFutureTarget(Handler handler, int i, int j)
    {
        this(handler, i, j, true, DEFAULT_WAITER);
    }

    RequestFutureTarget(Handler handler, int i, int j, boolean flag, Waiter waiter1)
    {
        mainHandler = handler;
        width = i;
        height = j;
        assertBackgroundThread = flag;
        waiter = waiter1;
    }

    private Object doGet(Long long1)
        throws ExecutionException, InterruptedException, TimeoutException
    {
        this;
        JVM INSTR monitorenter ;
        if (assertBackgroundThread)
        {
            Util.assertBackgroundThread();
        }
        if (isCancelled)
        {
            throw new CancellationException();
        }
        break MISSING_BLOCK_LABEL_32;
        long1;
        this;
        JVM INSTR monitorexit ;
        throw long1;
        if (exceptionReceived)
        {
            throw new ExecutionException(exception);
        }
        if (!resultReceived) goto _L2; else goto _L1
_L1:
        long1 = ((Long) (resource));
_L7:
        this;
        JVM INSTR monitorexit ;
        return long1;
_L2:
        if (long1 != null) goto _L4; else goto _L3
_L3:
        waiter.waitForTimeout(this, 0L);
_L6:
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (long1.longValue() > 0L)
        {
            waiter.waitForTimeout(this, long1.longValue());
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (exceptionReceived)
        {
            throw new ExecutionException(exception);
        }
        if (isCancelled)
        {
            throw new CancellationException();
        }
        if (!resultReceived)
        {
            throw new TimeoutException();
        }
        long1 = ((Long) (resource));
          goto _L7
    }

    public boolean cancel(boolean flag)
    {
        flag = true;
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag2 = isCancelled;
        if (!flag2) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L2:
        Exception exception1;
        if (isDone())
        {
            flag = false;
        }
        flag1 = flag;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        isCancelled = true;
        clear();
        waiter.notifyAll(this);
        flag1 = flag;
        if (true) goto _L1; else goto _L3
_L3:
        exception1;
        throw exception1;
    }

    public void clear()
    {
        mainHandler.post(this);
    }

    public Object get()
        throws InterruptedException, ExecutionException
    {
        Object obj;
        try
        {
            obj = doGet(null);
        }
        catch (TimeoutException timeoutexception)
        {
            throw new AssertionError(timeoutexception);
        }
        return obj;
    }

    public Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return doGet(Long.valueOf(timeunit.toMillis(l)));
    }

    public Request getRequest()
    {
        return request;
    }

    public void getSize(SizeReadyCallback sizereadycallback)
    {
        sizereadycallback.onSizeReady(width, height);
    }

    public boolean isCancelled()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isCancelled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception1;
        exception1;
        throw exception1;
    }

    public boolean isDone()
    {
        this;
        JVM INSTR monitorenter ;
        if (isCancelled) goto _L2; else goto _L1
_L1:
        boolean flag = resultReceived;
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception1;
        exception1;
        throw exception1;
    }

    public void onDestroy()
    {
    }

    public void onLoadCleared(Drawable drawable)
    {
    }

    public void onLoadFailed(Exception exception1, Drawable drawable)
    {
        this;
        JVM INSTR monitorenter ;
        exceptionReceived = true;
        exception = exception1;
        waiter.notifyAll(this);
        this;
        JVM INSTR monitorexit ;
        return;
        exception1;
        throw exception1;
    }

    public void onLoadStarted(Drawable drawable)
    {
    }

    public void onResourceReady(Object obj, GlideAnimation glideanimation)
    {
        this;
        JVM INSTR monitorenter ;
        resultReceived = true;
        resource = obj;
        waiter.notifyAll(this);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void run()
    {
        request.clear();
    }

    public void setRequest(Request request1)
    {
        request = request1;
    }

}
