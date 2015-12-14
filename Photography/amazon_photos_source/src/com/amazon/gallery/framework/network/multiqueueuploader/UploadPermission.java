// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.exceptions.NoStorageInfoAvailableException;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadStrategy, QueueType, UploadError

public interface UploadPermission
{

    public abstract UploadError getUploadPermission(MediaItem mediaitem, String s, UploadStrategy uploadstrategy, QueueType queuetype)
        throws NoStorageInfoAvailableException;

    public abstract void notifyUploaded(MediaItem mediaitem)
        throws NoStorageInfoAvailableException;
}
