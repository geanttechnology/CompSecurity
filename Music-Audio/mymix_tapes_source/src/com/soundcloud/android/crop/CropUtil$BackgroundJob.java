// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.android.crop;

import android.app.ProgressDialog;
import android.os.Handler;

// Referenced classes of package com.soundcloud.android.crop:
//            CropUtil, MonitoredActivity

private static class mHandler extends ycleAdapter
    implements Runnable
{

    private final MonitoredActivity mActivity;
    private final Runnable mCleanupRunner = new Runnable() {

        final CropUtil.BackgroundJob this$0;

        public void run()
        {
            mActivity.removeLifeCycleListener(CropUtil.BackgroundJob.this);
            if (mDialog.getWindow() != null)
            {
                mDialog.dismiss();
            }
        }

            
            {
                this$0 = CropUtil.BackgroundJob.this;
                super();
            }
    };
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



    public ycleListener(MonitoredActivity monitoredactivity, Runnable runnable, ProgressDialog progressdialog, Handler handler)
    {
        mActivity = monitoredactivity;
        mDialog = progressdialog;
        mJob = runnable;
        mActivity.addLifeCycleListener(this);
        mHandler = handler;
    }
}
