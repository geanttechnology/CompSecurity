// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadStatus, QueueType

public class UploadStatusEvent
{

    private final Map uploadStatus;

    public UploadStatusEvent(Map map)
    {
        uploadStatus = map;
    }

    public UploadStatus getUploadStatus(QueueType queuetype)
    {
        return (UploadStatus)uploadStatus.get(queuetype);
    }
}
