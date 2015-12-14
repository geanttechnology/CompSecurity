// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.http.senna.SennaSyncListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSUtil, MetadataProcessingService

class SyncNotificationObserver extends ContentObserver
{
    private class SyncRunnable
        implements Runnable
    {

        final SyncNotificationObserver this$0;
        private final Uri uri;

        public void run()
        {
            if (!eventsUri.equals(uri) || !sharedPreferences.getBoolean("coldBootStatus", false)) goto _L2; else goto _L1
_L1:
            executeSync(SyncState.INCREMENTAL);
_L4:
            if (!firstSyncCompleted.getAndSet(true))
            {
                firstSyncListener.onFirstSyncCompleted();
            }
            return;
_L2:
            if (accountStateUri.equals(uri))
            {
                executeSync(SyncState.COLDBOOT);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public SyncRunnable(Uri uri1)
        {
            this$0 = SyncNotificationObserver.this;
            super();
            uri = uri1;
        }
    }

    private static final class SyncState extends Enum
    {

        private static final SyncState $VALUES[];
        public static final SyncState COLDBOOT;
        public static final SyncState INCREMENTAL;

        public static SyncState valueOf(String s)
        {
            return (SyncState)Enum.valueOf(com/amazon/gallery/thor/cds/SyncNotificationObserver$SyncState, s);
        }

        public static SyncState[] values()
        {
            return (SyncState[])$VALUES.clone();
        }

        static 
        {
            COLDBOOT = new SyncState("COLDBOOT", 0);
            INCREMENTAL = new SyncState("INCREMENTAL", 1);
            $VALUES = (new SyncState[] {
                COLDBOOT, INCREMENTAL
            });
        }

        private SyncState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/cds/SyncNotificationObserver.getName();
    private final Uri accountStateUri;
    private final Context context;
    private final Uri eventsUri;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final AtomicBoolean firstSyncCompleted = new AtomicBoolean();
    private final SennaSyncListener firstSyncListener;
    private final SharedPreferences sharedPreferences;

    public SyncNotificationObserver(Context context1, Handler handler, SennaSyncListener sennasynclistener, Uri uri, Uri uri1)
    {
        super(handler);
        context = context1;
        firstSyncListener = sennasynclistener;
        accountStateUri = uri;
        eventsUri = uri1;
        sharedPreferences = context1.getSharedPreferences("galleryKindleSharedPrefs", 0);
        onChange(false, uri);
    }

    private void executeSync(SyncState syncstate)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState[];

            static 
            {
                $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState = new int[SyncState.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState[SyncState.COLDBOOT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$cds$SyncNotificationObserver$SyncState[SyncState.INCREMENTAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.thor.cds.SyncNotificationObserver.SyncState[syncstate.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 152;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        syncstate = null;
        ContentProviderClient contentproviderclient = context.getContentResolver().acquireContentProviderClient(accountStateUri);
        syncstate = contentproviderclient;
        String s = CDSUtil.getAccountState(contentproviderclient, accountStateUri);
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        if (s == null || "PARTIAL_SYNC".equals(s)) goto _L1; else goto _L4
_L4:
        GLogger.i(TAG, "Running coldBoot. Current state: %s", new Object[] {
            s
        });
        if (!"READY".equals(s) && sharedPreferences.getBoolean("partialSyncStatus", false)) goto _L1; else goto _L5
_L5:
        GLogger.i(TAG, "Starting migration of content", new Object[0]);
        processMetadata();
        return;
        Exception exception;
        exception;
        if (syncstate != null)
        {
            syncstate.release();
        }
        throw exception;
_L3:
        processMetadata();
        return;
    }

    private void processMetadata()
    {
        Intent intent = new Intent(context, com/amazon/gallery/thor/cds/MetadataProcessingService);
        context.startService(intent);
    }

    public void onChange(boolean flag)
    {
        if (!sharedPreferences.getBoolean("partialSyncStatus", false) || !sharedPreferences.getBoolean("coldBootStatus", false))
        {
            executor.execute(new SyncRunnable(accountStateUri));
            return;
        } else
        {
            executor.execute(new SyncRunnable(eventsUri));
            return;
        }
    }

    public void onChange(boolean flag, Uri uri)
    {
        executor.execute(new SyncRunnable(uri));
    }







}
