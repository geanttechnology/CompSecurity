// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.removablestorage;

import android.app.Activity;
import java.io.File;

// Referenced classes of package com.amazon.gallery.thor.removablestorage:
//            RemovableStorageStateListener, StorageLocationPreference

public interface RemovableStorageManager
    extends RemovableStorageStateListener
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent LocalStorageSetAsPreference;
        public static final MetricsEvent MediaBadRemoval;
        public static final MetricsEvent MediaMounted;
        public static final MetricsEvent MediaUnmounted;
        public static final MetricsEvent RemovableStorageSetAsPreference;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/thor/removablestorage/RemovableStorageManager$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            MediaMounted = new MetricsEvent("MediaMounted", 0);
            MediaBadRemoval = new MetricsEvent("MediaBadRemoval", 1);
            MediaUnmounted = new MetricsEvent("MediaUnmounted", 2);
            LocalStorageSetAsPreference = new MetricsEvent("LocalStorageSetAsPreference", 3);
            RemovableStorageSetAsPreference = new MetricsEvent("RemovableStorageSetAsPreference", 4);
            $VALUES = (new MetricsEvent[] {
                MediaMounted, MediaBadRemoval, MediaUnmounted, LocalStorageSetAsPreference, RemovableStorageSetAsPreference
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract boolean addListener(RemovableStorageStateListener removablestoragestatelistener);

    public abstract File getRemovableStorageDownloadDirectory();

    public abstract File getRemovableStorageRootDirectory();

    public abstract StorageLocationPreference getStorageLocationPreference();

    public abstract boolean isFileInReadOnlyRemovableStorageLocation(File file);

    public abstract boolean isFileOnRemovableStorage(File file);

    public abstract boolean isRemovableStorageMounted();

    public abstract boolean promptForStoragePreferenceIfNeeded(Activity activity);
}
