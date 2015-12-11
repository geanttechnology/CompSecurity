// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.util.SparseArray;

// Referenced classes of package com.amazon.device.ads:
//            Configuration, Settings

abstract class StartUpWaiter
    implements Configuration.ConfigurationListener, Settings.SettingsListener
{

    static final int CALLBACK_ON_MAIN_THREAD = 0;
    static final int DEFAULT = 1;
    private static final SparseArray executors = new SparseArray();
    private int callbackType;

    StartUpWaiter()
    {
        callbackType = 1;
    }

    private static ThreadUtils.RunnableExecutor getExecutor(int i)
    {
        return (ThreadUtils.RunnableExecutor)executors.get(i, executors.get(1));
    }

    private void onFinished(Runnable runnable)
    {
        getExecutor(callbackType).execute(runnable);
    }

    static void putRunnableExecutor(int i, ThreadUtils.RunnableExecutor runnableexecutor)
    {
        if (runnableexecutor == null)
        {
            executors.remove(i);
            return;
        } else
        {
            executors.put(i, runnableexecutor);
            return;
        }
    }

    public void onConfigurationFailure()
    {
        onFinished(new Runnable() {

            final StartUpWaiter this$0;

            public void run()
            {
                startUpFailed();
            }

            
            {
                this$0 = StartUpWaiter.this;
                super();
            }
        });
    }

    public void onConfigurationReady()
    {
        onFinished(new Runnable() {

            final StartUpWaiter this$0;

            public void run()
            {
                startUpReady();
            }

            
            {
                this$0 = StartUpWaiter.this;
                super();
            }
        });
    }

    public void settingsLoaded()
    {
        Configuration.getInstance().queueConfigurationListener(this);
    }

    public void start()
    {
        Settings.getInstance().listenForSettings(this);
    }

    public void startAndCallbackOnMainThread()
    {
        callbackType = 0;
        start();
    }

    protected abstract void startUpFailed();

    protected abstract void startUpReady();

    static 
    {
        putRunnableExecutor(0, new ThreadUtils.MainThreadRunnableExecutor());
        putRunnableExecutor(1, new ThreadUtils.ThreadPoolRunnableExecutor());
    }
}
