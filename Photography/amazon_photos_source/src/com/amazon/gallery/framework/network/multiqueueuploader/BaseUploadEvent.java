// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            QueueType, UploadStrategy

public abstract class BaseUploadEvent
{

    private final List items;
    private final QueueType queueType;
    private final String uploadSource;
    private final UploadStrategy uploadStrategy;

    public BaseUploadEvent(List list, QueueType queuetype, UploadStrategy uploadstrategy, String s)
    {
        items = list;
        queueType = queuetype;
        uploadStrategy = uploadstrategy;
        uploadSource = s;
        if (queuetype == null)
        {
            throw new IllegalArgumentException("Must give a queue type");
        }
        if (list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("Must give at least one item for uploading");
        }
        if (queuetype != QueueType.AUTO_SAVE && uploadstrategy == null)
        {
            throw new IllegalArgumentException("Must have upload strategy for non-auto-saving uploads");
        } else
        {
            return;
        }
    }

    public List getItems()
    {
        return items;
    }

    public QueueType getQueueType()
    {
        return queueType;
    }

    public String getUploadSource()
    {
        return uploadSource;
    }

    public UploadStrategy getUploadStrategy()
    {
        return uploadStrategy;
    }
}
