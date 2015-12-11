// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.util.concurrent.Semaphore;

// Referenced classes of package net.singular.sdk:
//            SingularLog

class PostableWorker
{

    private final SingularLog log;
    private final Handler my_handler;
    private final HandlerThread my_thread;
    private Semaphore runnable_semaphore;

    public PostableWorker(final String name, final SingularLog log)
    {
        this.log = log;
        my_thread = new HandlerThread(name);
        my_thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            final PostableWorker this$0;
            final SingularLog val$log;
            final String val$name;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                if (log != null)
                {
                    log.e("singular_sdk", String.format("%s background thread had died.", new Object[] {
                        name
                    }), throwable);
                    return;
                } else
                {
                    Log.e("singular_sdk", String.format("%s background thread had died.", new Object[] {
                        name
                    }), throwable);
                    return;
                }
            }

            
            {
                this$0 = PostableWorker.this;
                log = singularlog;
                name = s;
                super();
            }
        });
        my_thread.start();
        my_handler = new Handler(my_thread.getLooper());
        blockThreadUntilStarted();
    }

    private void blockThreadUntilStarted()
    {
        runnable_semaphore = new Semaphore(1);
        try
        {
            runnable_semaphore.acquire();
        }
        catch (InterruptedException interruptedexception) { }
        my_handler.post(new Runnable() {

            final PostableWorker this$0;

            public void run()
            {
                try
                {
                    runnable_semaphore.acquire();
                    runnable_semaphore.release();
                    return;
                }
                catch (InterruptedException interruptedexception1)
                {
                    return;
                }
            }

            
            {
                this$0 = PostableWorker.this;
                super();
            }
        });
    }

    public void interruptThread()
    {
        my_thread.interrupt();
    }

    public boolean postDelayed(Runnable runnable, long l)
    {
        return my_handler.postDelayed(runnable, l);
    }

    public boolean postNow(Runnable runnable)
    {
        return postDelayed(runnable, 0L);
    }

    public void removeCallback(Runnable runnable)
    {
        my_handler.removeCallbacks(runnable);
    }

    public void start()
    {
        runnable_semaphore.release();
    }

}
