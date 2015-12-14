// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.camera;

import com.amazon.gallery.foundation.utils.BasicPathProvider;
import com.amazon.gallery.foundation.utils.UserUtils;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;

public class SystemPathProvider
{

    private FreeTime freeTime;
    private RemovableStorageManager removableStorageManager;

    public SystemPathProvider(FreeTime freetime, RemovableStorageManager removablestoragemanager)
    {
        freeTime = freetime;
        removableStorageManager = removablestoragemanager;
    }

    public String getAttachmentsPath()
    {
        return BasicPathProvider.getAttachmentsPath();
    }

    public String getCameraDirPath()
    {
        if (freeTime != null && freeTime.isFreeTimeFeatureEnabled() && freeTime.isFreeTime())
        {
            return freeTime.getMyFreeTimeLocation();
        } else
        {
            return BasicPathProvider.getCameraDirPath();
        }
    }

    public String getRemovableCameraDirPath()
    {
        if (freeTime != null && freeTime.isFreeTimeFeatureEnabled() && freeTime.isFreeTime())
        {
            return freeTime.getMyFreeTimeRemovableStorageLocation(removableStorageManager);
        }
        File file = removableStorageManager.getRemovableStorageRootDirectory();
        if (file == null)
        {
            return null;
        } else
        {
            return (new File(new File(file, "/DCIM/Camera"), Integer.toString(UserUtils.getCurrentUserId()))).getAbsolutePath();
        }
    }

    public String getScreenshotsPath()
    {
        return BasicPathProvider.getScreenshotsPath();
    }
}
