// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            NewPromotionSyncScheduler

public class NewPromotionSAFSyncScheduler extends NewPromotionSyncScheduler
{

    private static final String TAG = com/amazon/gallery/thor/syncframework/NewPromotionSAFSyncScheduler.getName();

    protected NewPromotionSAFSyncScheduler(Context context, String s)
    {
        super(context, s);
    }

    public void scheduleBackgroundSync(Context context, long l, TimeUnit timeunit)
    {
        if (getSyncAccount() == null)
        {
            GLogger.e(TAG, "Cannot schedule background sync. No sync account.", new Object[0]);
            return;
        } else
        {
            GLogger.d(TAG, "Schedule background sync", new Object[0]);
            stopForegroundSync();
            ContentResolver.addPeriodicSync(getSyncAccount(), getAuthority(), Bundle.EMPTY, timeunit.toSeconds(l));
            return;
        }
    }

    protected void stopBackgroundSync(Context context)
    {
        if (getSyncAccount() == null)
        {
            GLogger.e(TAG, "Cannot stop background sync. No sync account.", new Object[0]);
            return;
        } else
        {
            GLogger.d(TAG, "Stop background sync", new Object[0]);
            ContentResolver.removePeriodicSync(getSyncAccount(), getAuthority(), Bundle.EMPTY);
            return;
        }
    }

}
