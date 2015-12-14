// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.app:
//            FreeTime

public class NoFreeTime
    implements FreeTime
{

    public NoFreeTime()
    {
    }

    public String getFreetimeModeName()
    {
        throw new IllegalStateException("Freetime is not available.");
    }

    public List getFreetimeProfiles()
    {
        throw new IllegalStateException("Freetime is not available.");
    }

    public String getMyFreeTimeLocation()
    {
        throw new IllegalStateException("Freetime is not available.");
    }

    public String getMyFreeTimeRemovableStorageLocation(RemovableStorageManager removablestoragemanager)
    {
        throw new IllegalStateException("Freetime is not available.");
    }

    public String getOwnerName(int i)
    {
        throw new IllegalStateException("Freetime is not available.");
    }

    public boolean isFreeTime()
    {
        return false;
    }

    public boolean isFreeTimeFeatureEnabled()
    {
        return false;
    }

    public void setMediaStoreSyncProvider(MediaStoreSyncProvider mediastoresyncprovider)
    {
    }

    public void syncFreeTimeAsynchronously()
    {
    }
}
