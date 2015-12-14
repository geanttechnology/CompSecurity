// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.util.List;

public interface FreeTime
{

    public abstract String getFreetimeModeName();

    public abstract List getFreetimeProfiles();

    public abstract String getMyFreeTimeLocation();

    public abstract String getMyFreeTimeRemovableStorageLocation(RemovableStorageManager removablestoragemanager);

    public abstract String getOwnerName(int i);

    public abstract boolean isFreeTime();

    public abstract boolean isFreeTimeFeatureEnabled();

    public abstract void setMediaStoreSyncProvider(MediaStoreSyncProvider mediastoresyncprovider);

    public abstract void syncFreeTimeAsynchronously();
}
