// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.camerasettings;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.digimarc.dms.camerasettings:
//            DMSKBDownload

public class DMSKBScheduler
{

    static final String TAG = "DMSSchedulerKB";
    private final int kIntervalSecs = 0x15180;
    private Context mContext;
    private ScheduledFuture mPollerHandle;
    private ScheduledExecutorService mScheduler;
    private boolean mStopped;

    public DMSKBScheduler(Context context)
    {
        mScheduler = null;
        mPollerHandle = null;
        mStopped = true;
        mContext = null;
        mContext = context;
    }

    public void reset()
    {
        stop();
        start();
    }

    public void start()
    {
        mScheduler = Executors.newScheduledThreadPool(1);
        (new Thread() {

            final DMSKBScheduler this$0;

            public void run()
            {
                DMSKBDownload.getInstance(mContext).readKB();
                try
                {
                    if (mStopped)
                    {
                        DMSKBDownload dmskbdownload = DMSKBDownload.getInstance(mContext);
                        mPollerHandle = mScheduler.scheduleAtFixedRate(dmskbdownload, 0L, 0x15180L, TimeUnit.SECONDS);
                    }
                    mStopped = false;
                    return;
                }
                catch (RejectedExecutionException rejectedexecutionexception)
                {
                    return;
                }
            }

            
            {
                this$0 = DMSKBScheduler.this;
                super();
            }
        }).start();
    }

    public void stop()
    {
        if (!mStopped)
        {
            mScheduler.schedule(new Runnable() {

                final DMSKBScheduler this$0;

                public void run()
                {
                    mPollerHandle.cancel(true);
                }

            
            {
                this$0 = DMSKBScheduler.this;
                super();
            }
            }, 0L, TimeUnit.SECONDS);
            mScheduler.shutdown();
            mStopped = true;
        }
    }




/*
    static boolean access$102(DMSKBScheduler dmskbscheduler, boolean flag)
    {
        dmskbscheduler.mStopped = flag;
        return flag;
    }

*/



/*
    static ScheduledFuture access$202(DMSKBScheduler dmskbscheduler, ScheduledFuture scheduledfuture)
    {
        dmskbscheduler.mPollerHandle = scheduledfuture;
        return scheduledfuture;
    }

*/

}
