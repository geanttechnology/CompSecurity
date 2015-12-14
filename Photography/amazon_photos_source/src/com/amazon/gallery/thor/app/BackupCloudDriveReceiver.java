// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.AutoUploadNotification;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.fragment.SettingsFragment;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication

public class BackupCloudDriveReceiver extends BroadcastReceiver
{
    public static final class BackupCloudDriveEvent extends Enum
    {

        private static final BackupCloudDriveEvent $VALUES[];
        public static final BackupCloudDriveEvent FirstTimeAutoUploadDisabled;
        public static final BackupCloudDriveEvent FirstTimeAutoUploadEnabled;

        public static BackupCloudDriveEvent valueOf(String s)
        {
            return (BackupCloudDriveEvent)Enum.valueOf(com/amazon/gallery/thor/app/BackupCloudDriveReceiver$BackupCloudDriveEvent, s);
        }

        public static BackupCloudDriveEvent[] values()
        {
            return (BackupCloudDriveEvent[])$VALUES.clone();
        }

        static 
        {
            FirstTimeAutoUploadEnabled = new BackupCloudDriveEvent("FirstTimeAutoUploadEnabled", 0);
            FirstTimeAutoUploadDisabled = new BackupCloudDriveEvent("FirstTimeAutoUploadDisabled", 1);
            $VALUES = (new BackupCloudDriveEvent[] {
                FirstTimeAutoUploadEnabled, FirstTimeAutoUploadDisabled
            });
        }

        private BackupCloudDriveEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/app/BackupCloudDriveReceiver.getName();

    public BackupCloudDriveReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!(context.getApplicationContext() instanceof ThorGalleryApplication))
        {
            GLogger.e(TAG, "context is not ThorGalleryApplication", new Object[0]);
            return;
        }
        if (intent == null && intent.getExtras() == null)
        {
            GLogger.e(TAG, "intent is not initialized", new Object[0]);
            return;
        }
        ComponentProfiler componentprofiler = new ComponentProfiler((Profiler)((ThorGalleryApplication)context.getApplicationContext()).getBeanFactory().getBean(Keys.PROFILER), com/amazon/gallery/thor/app/BackupCloudDriveReceiver);
        boolean flag = intent.getExtras().getBoolean("PHOTOS", false);
        boolean flag1 = intent.getExtras().getBoolean("VIDEOS", false);
        if (flag || flag1)
        {
            SettingsFragment.setAutoUploadEnabledForPhotos(context, flag, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.OOBE);
            SettingsFragment.setAutoUploadEnabledForVideos(context, flag1, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.OOBE);
            componentprofiler.trackEvent(BackupCloudDriveEvent.FirstTimeAutoUploadEnabled);
            GLogger.d(TAG, "AutoUpload enabled during OOBE, (photos: %b; videos: %b)", new Object[] {
                Boolean.valueOf(flag), Boolean.valueOf(flag1)
            });
        } else
        {
            SettingsFragment.setAutoUploadEnabled(context, false, com.amazon.gallery.framework.kindle.fragment.SettingsFragment.AutoSaveSource.OOBE);
            componentprofiler.trackEvent(BackupCloudDriveEvent.FirstTimeAutoUploadDisabled);
            GLogger.d(TAG, "AutoUpload disabled during OOBE", new Object[0]);
        }
        AutoUploadNotification.shouldNotShowNotification(context, true);
    }

}
