// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import java.util.Date;
import java.util.concurrent.Callable;
import roboguice.util.Ln;

// Referenced classes of package commonlib.manager:
//            SyncManager

class tomaticSyncRunnable
    implements Callable
{

    final SyncManager this$0;
    final long val$firstDelay;
    final tomaticSyncRunnable val$tmp;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        long l1 = System.currentTimeMillis();
        long l = lastUpdated();
        l1 = Math.max(val$firstDelay, (SyncManager.access$000(SyncManager.this) - l1) + l);
        Ln.d("lastUpdated %s; timeBetweenRefresh %ss", new Object[] {
            new Date(l), Long.valueOf(SyncManager.access$000(SyncManager.this) / 1000L)
        });
        scheduleNextSync(val$tmp, l1);
        return null;
    }

    tomaticSyncRunnable()
    {
        this$0 = final_syncmanager;
        val$firstDelay = l;
        val$tmp = tomaticSyncRunnable.this;
        super();
    }
}
