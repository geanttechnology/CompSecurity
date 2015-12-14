// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.service.WhisperUploadManager;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication

public class PackageUpdateReceiver extends BroadcastReceiver
{

    private static final String TAG = com/amazon/gallery/thor/app/PackageUpdateReceiver.getName();

    public PackageUpdateReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        GLogger.i(TAG, "Upgrade detected.", new Object[0]);
        ((WhisperUploadManager)ThorGalleryApplication.getBean(Keys.WHISPER_UPLOAD_MANAGER)).scheduleBackgroundSync();
    }

}
