// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.util.SparseArray;

// Referenced classes of package com.amazon.device.ads.identity:
//            Configuration, Settings

abstract class StartUpWaiter
    implements Configuration.ConfigurationListener, Settings.SettingsListener
{

    private static final SparseArray executors = new SparseArray();
    private int callbackType;
    private final Configuration configuration;
    private final Settings settings;

    public StartUpWaiter(Settings settings1, Configuration configuration1)
    {
        callbackType = 1;
        settings = settings1;
        configuration = configuration1;
    }

    private void onFinished(Runnable runnable)
    {
        int i = callbackType;
        ((ThreadUtils.RunnableExecutor)executors.get(i, executors.get(1))).execute(runnable);
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
        configuration.queueConfigurationListener(this);
    }

    protected abstract void startUpFailed();

    protected abstract void startUpReady();

    static 
    {
        putRunnableExecutor(0, new ThreadUtils.MainThreadRunnableExecutor());
        putRunnableExecutor(1, new ThreadUtils.ThreadPoolRunnableExecutor());
    }
}
