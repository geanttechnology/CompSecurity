// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadStrategy

public class UploadBatch
{

    private final List mediaItems = new ArrayList();
    private final UploadBatchFactory.UploadBatchType uploadBatchType;
    private final UploadStrategy uploadStrategy;

    public UploadBatch(UploadStrategy uploadstrategy, UploadBatchFactory.UploadBatchType uploadbatchtype)
    {
        uploadStrategy = uploadstrategy;
        uploadBatchType = uploadbatchtype;
    }

    public void addToBatch(MediaItem mediaitem)
    {
        mediaItems.add(mediaitem);
    }

    public List getMediaItems()
    {
        return mediaItems;
    }

    public UploadBatchFactory.UploadBatchType getUploadBatchType()
    {
        return uploadBatchType;
    }

    public UploadStrategy getUploadStrategy()
    {
        return uploadStrategy;
    }
}
