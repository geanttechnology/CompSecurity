// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.DownloadStatusEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.RevertContentObserverEvent;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.gallery.messaging.DownloadStatusContentFetcher;
import com.amazon.gallery.framework.kindle.Keys;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ThorGalleryApplication

public class ContentChangeListener extends ContentObserver
{
    private static final class ForcedState extends Enum
    {

        private static final ForcedState $VALUES[];
        public static final ForcedState FORCED_OFF;
        public static final ForcedState FORCED_ON;
        public static final ForcedState NONE;

        public static ForcedState valueOf(String s)
        {
            return (ForcedState)Enum.valueOf(com/amazon/gallery/thor/app/ContentChangeListener$ForcedState, s);
        }

        public static ForcedState[] values()
        {
            return (ForcedState[])$VALUES.clone();
        }

        static 
        {
            NONE = new ForcedState("NONE", 0);
            FORCED_ON = new ForcedState("FORCED_ON", 1);
            FORCED_OFF = new ForcedState("FORCED_OFF", 2);
            $VALUES = (new ForcedState[] {
                NONE, FORCED_ON, FORCED_OFF
            });
        }

        private ForcedState(String s, int i)
        {
            super(s, i);
        }
    }


    private static Uri FOLDER_MODIFICATION_URI = Uri.parse("content://media/external/object");
    private static final String TAG = com/amazon/gallery/thor/app/ContentChangeListener.getName();
    private final Executor contentExecutor = Executors.newSingleThreadExecutor();
    private DownloadStatusContentFetcher contentFetcher;
    private final AtomicInteger forcedState;
    private MediaStoreSyncProvider mediaStoreSyncProvider;
    private final AtomicBoolean shouldHandleChange = new AtomicBoolean(false);
    private final Runnable syncIfDownloadsInactive = new Runnable() {

        final ContentChangeListener this$0;

        public void run()
        {
            if (!((DownloadStatusEvent)contentFetcher.getContentFromProducer()).isActive())
            {
                mediaStoreSyncProvider.syncMediaStoreAsync();
            }
        }

            
            {
                this$0 = ContentChangeListener.this;
                super();
            }
    };

    public ContentChangeListener(ContentResolver contentresolver, Handler handler)
    {
        super(handler);
        forcedState = new AtomicInteger(ForcedState.NONE.ordinal());
        mediaStoreSyncProvider = (MediaStoreSyncProvider)ThorGalleryApplication.getBean(Keys.MEDIA_STORE_SYNC_PROVIDER);
        contentFetcher = new DownloadStatusContentFetcher();
        contentresolver.registerContentObserver(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this);
        contentresolver.registerContentObserver(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, this);
        contentresolver.registerContentObserver(FOLDER_MODIFICATION_URI, true, this);
        GlobalMessagingBus.register(this);
    }

    private boolean isNotifyingChanges()
    {
        return shouldHandleChange.get() && forcedState.get() == ForcedState.NONE.ordinal() || forcedState.get() == ForcedState.FORCED_ON.ordinal();
    }

    private void notifyOnChangeIfNeeded(boolean flag, boolean flag1)
    {
        if (!flag && flag1)
        {
            onChange(true);
        }
    }

    public void onChange(boolean flag)
    {
        onChange(flag, null);
    }

    public void onChange(boolean flag, Uri uri)
    {
        if (isNotifyingChanges())
        {
            contentExecutor.execute(syncIfDownloadsInactive);
        }
    }

    public void onRevertContentObserverEvent(RevertContentObserverEvent revertcontentobserverevent)
    {
        boolean flag = isNotifyingChanges();
        forcedState.set(ForcedState.NONE.ordinal());
        boolean flag1 = isNotifyingChanges();
        String s = TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("Content observer is ");
        if (flag1)
        {
            revertcontentobserverevent = "on";
        } else
        {
            revertcontentobserverevent = "off";
        }
        GLogger.i(s, stringbuilder.append(revertcontentobserverevent).toString(), new Object[0]);
        notifyOnChangeIfNeeded(flag, flag1);
    }

    public void onToggleContentObserverEvent(ToggleContentObserverEvent togglecontentobserverevent)
    {
        boolean flag = isNotifyingChanges();
        if (togglecontentobserverevent.isForce())
        {
            Object obj = forcedState;
            StringBuilder stringbuilder;
            int i;
            boolean flag1;
            if (togglecontentobserverevent.isEnabled())
            {
                i = ForcedState.FORCED_ON.ordinal();
            } else
            {
                i = ForcedState.FORCED_OFF.ordinal();
            }
            ((AtomicInteger) (obj)).set(i);
        } else
        if (forcedState.get() == ForcedState.NONE.ordinal())
        {
            shouldHandleChange.set(togglecontentobserverevent.isEnabled());
        } else
        {
            GLogger.i(TAG, (new StringBuilder()).append("Not allowing unforced toggles. Current is ").append(shouldHandleChange).toString(), new Object[0]);
        }
        flag1 = isNotifyingChanges();
        obj = TAG;
        stringbuilder = (new StringBuilder()).append("Content observer is ");
        if (flag1)
        {
            togglecontentobserverevent = "on";
        } else
        {
            togglecontentobserverevent = "off";
        }
        GLogger.i(((String) (obj)), stringbuilder.append(togglecontentobserverevent).toString(), new Object[0]);
        notifyOnChangeIfNeeded(flag, flag1);
    }



}
