// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.syncframework;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.watchdog.WhisperUploadService;

// Referenced classes of package com.amazon.gallery.thor.syncframework:
//            SyncScheduler

public abstract class WhisperUploadSyncScheduler extends SyncScheduler
{

    private static final String TAG = com/amazon/gallery/thor/syncframework/WhisperUploadSyncScheduler.getName();

    protected WhisperUploadSyncScheduler(Context context, String s)
    {
        super(context, s, context.getResources().getString(0x7f0e0303));
    }

    public abstract void disableSyncForProfile(Object obj, Context context);

    public void syncNow(Context context)
    {
        syncNow(context, TAG);
    }

    public void syncNow(Context context, String s)
    {
        GLogger.d(TAG, "Sync now", new Object[0]);
        Intent intent = new Intent(context, com/amazon/gallery/framework/network/watchdog/WhisperUploadService);
        intent.putExtra("start_source", s);
        context.startService(intent);
    }

}
