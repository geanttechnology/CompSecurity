// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.accounts.Account;
import android.content.Context;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            SyncAccount

public abstract class SyncScheduler
{
    private class SyncTask
        implements Runnable
    {

        private Context context;
        final SyncScheduler this$0;

        public void run()
        {
            syncNow(context);
        }

        public SyncTask(Context context1)
        {
            this$0 = SyncScheduler.this;
            super();
            context = context1;
        }
    }


    private static final String TAG = com/amazon/gallery/thor/syncframework/SyncScheduler.getName();
    private boolean allowForegroundSyncs;
    private String authority;
    private ScheduledExecutorService foregroundSyncScheduler;
    private Account syncAccount;

    protected SyncScheduler(Context context, String s, String s1)
    {
        this(context, s, s1, true);
    }

    protected SyncScheduler(Context context, String s, String s1, boolean flag)
    {
        authority = s1;
        syncAccount = SyncAccount.getSyncAccount(context, s, s1);
        allowForegroundSyncs = flag;
    }

    public String getAuthority()
    {
        return authority;
    }

    public Account getSyncAccount()
    {
        return syncAccount;
    }

    public abstract void scheduleBackgroundSync(Context context, long l, TimeUnit timeunit);

    public void scheduleForegroundSync(Context context, long l, TimeUnit timeunit, boolean flag)
    {
        GLogger.d(TAG, "Schedule foreground sync", new Object[0]);
        stopScheduledSyncs(context);
        if (allowForegroundSyncs)
        {
            if (foregroundSyncScheduler == null)
            {
                foregroundSyncScheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("ForegroundSync", 3));
            }
            ScheduledExecutorService scheduledexecutorservice = foregroundSyncScheduler;
            context = new SyncTask(context);
            long l1;
            if (flag)
            {
                l1 = 0L;
            } else
            {
                l1 = l;
            }
            scheduledexecutorservice.scheduleAtFixedRate(context, l1, l, timeunit);
        }
    }

    protected abstract void stopBackgroundSync(Context context);

    protected void stopForegroundSync()
    {
        GLogger.d(TAG, "Stop foreground sync", new Object[0]);
        if (allowForegroundSyncs && foregroundSyncScheduler != null)
        {
            foregroundSyncScheduler.shutdown();
            foregroundSyncScheduler = null;
        }
    }

    public void stopScheduledSyncs(Context context)
    {
        stopForegroundSync();
        stopBackgroundSync(context);
    }

    public abstract void syncNow(Context context);

}
