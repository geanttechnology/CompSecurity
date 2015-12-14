// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.app.ProgressDialog;
import android.os.Handler;
import com.aviary.android.feather.library.MonitoredActivity;

public final class ThreadUtils
{
    private static class BackgroundJob extends com.aviary.android.feather.library.MonitoredActivity.LifeCycleAdapter
        implements Runnable
    {

        private final MonitoredActivity mActivity;
        private final Runnable mCleanupRunner = new _cls1();
        private final ProgressDialog mDialog;
        private final Handler mHandler;
        private final Runnable mJob;

        public void onActivityDestroyed(MonitoredActivity monitoredactivity)
        {
            mCleanupRunner.run();
            mHandler.removeCallbacks(mCleanupRunner);
        }

        public void onActivityStarted(MonitoredActivity monitoredactivity)
        {
            mDialog.show();
        }

        public void onActivityStopped(MonitoredActivity monitoredactivity)
        {
            mDialog.hide();
        }

        public void run()
        {
            mJob.run();
            mHandler.post(mCleanupRunner);
            return;
            Exception exception;
            exception;
            mHandler.post(mCleanupRunner);
            throw exception;
        }



        public BackgroundJob(MonitoredActivity monitoredactivity, Runnable runnable, ProgressDialog progressdialog, Handler handler)
        {
            mActivity = monitoredactivity;
            mDialog = progressdialog;
            mJob = runnable;
            mActivity.addLifeCycleListener(this);
            mHandler = handler;
        }
    }


    private ThreadUtils()
    {
    }

    public static void startBackgroundJob(MonitoredActivity monitoredactivity, String s, String s1, Runnable runnable, Handler handler)
    {
        (new Thread(new BackgroundJob(monitoredactivity, runnable, ProgressDialog.show(monitoredactivity, s, s1, true, false), handler))).start();
    }

    // Unreferenced inner class com/aviary/android/feather/sdk/utils/ThreadUtils$BackgroundJob$1

/* anonymous class */
    class BackgroundJob._cls1
        implements Runnable
    {

        final BackgroundJob this$0;

        public void run()
        {
            mActivity.removeLifeCycleListener(BackgroundJob.this);
            if (mDialog.getWindow() != null)
            {
                mDialog.dismiss();
            }
        }

            
            {
                this$0 = BackgroundJob.this;
                super();
            }
    }

}
