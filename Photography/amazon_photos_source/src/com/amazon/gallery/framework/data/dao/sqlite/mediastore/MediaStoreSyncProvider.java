// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import com.amazon.gallery.framework.data.account.AccountChangeListener;

public interface MediaStoreSyncProvider
    extends android.media.MediaScannerConnection.MediaScannerConnectionClient, AccountChangeListener
{
    public static interface SyncCompletedListener
    {

        public abstract void onSyncCompleted();
    }


    public abstract void addSyncCompletedListener(SyncCompletedListener synccompletedlistener);

    public abstract boolean isCurrentlySyncing();

    public abstract void removeSyncCompletedListener(SyncCompletedListener synccompletedlistener);

    public abstract void start();

    public abstract void syncMediaStore(boolean flag);

    public abstract void syncMediaStore(boolean flag, boolean flag1);

    public abstract void syncMediaStoreAsync();

    public abstract void syncMediaStoreAsync(boolean flag);
}
