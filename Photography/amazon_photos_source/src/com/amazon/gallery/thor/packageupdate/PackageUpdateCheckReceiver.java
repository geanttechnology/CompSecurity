// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.packageupdate;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.packageupdate:
//            PackageUpdateService

public class PackageUpdateCheckReceiver extends BroadcastReceiver
{

    public static final String TAG = com/amazon/gallery/thor/packageupdate/PackageUpdateCheckReceiver.getName();
    public static final long TRIGGER_MS;

    public PackageUpdateCheckReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction() != null && intent.getAction().equals("com.amazon.photos.action.ACTION_UPGRADE_CHECK_ALARM"))
        {
            GLogger.d(TAG, "Starting update check service", new Object[0]);
            context.startService(new Intent(context, com/amazon/gallery/thor/packageupdate/PackageUpdateService));
        } else
        {
            GLogger.d(TAG, "Setting up repeating update check alarm", new Object[0]);
            intent = new Intent(context, com/amazon/gallery/thor/packageupdate/PackageUpdateCheckReceiver);
            intent.setAction("com.amazon.photos.action.ACTION_UPGRADE_CHECK_ALARM");
            if (PendingIntent.getBroadcast(context, 0, intent, 0x20000000) == null)
            {
                intent = PendingIntent.getBroadcast(context, 0, intent, 0);
                ((AlarmManager)context.getSystemService("alarm")).setInexactRepeating(3, SystemClock.elapsedRealtime() + TRIGGER_MS, 0x5265c00L, intent);
                return;
            }
        }
    }

    static 
    {
        TRIGGER_MS = TimeUnit.MINUTES.toMillis(2L);
    }
}
