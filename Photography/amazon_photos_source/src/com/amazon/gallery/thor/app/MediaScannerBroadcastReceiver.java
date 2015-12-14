// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.kindle.Keys;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication

public class MediaScannerBroadcastReceiver extends BroadcastReceiver
{

    private static final String TAG = com/amazon/gallery/thor/app/MediaScannerBroadcastReceiver.getName();

    public MediaScannerBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        GLogger.i(TAG, "#onReceive(intent = %s)", new Object[] {
            intent
        });
        context = (MediaStoreSyncProvider)ThorGalleryApplication.getBean(Keys.MEDIA_STORE_SYNC_PROVIDER);
        if ("android.hardware.action.NEW_PICTURE".equals(intent.getAction()) || "android.hardware.action.NEW_VIDEO".equals(intent.getAction()))
        {
            context.syncMediaStoreAsync(false);
            return;
        } else
        {
            context.syncMediaStoreAsync();
            return;
        }
    }

}
