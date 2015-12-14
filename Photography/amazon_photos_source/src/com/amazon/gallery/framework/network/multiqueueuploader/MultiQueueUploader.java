// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.framework.network.exceptions.AccountLockedException;
import com.amazon.gallery.framework.network.exceptions.CloudStorageLimitException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadListener, QueueType, UploadPermission, UploadError, 
//            UploadStrategy

public interface MultiQueueUploader
{

    public abstract void addUploadListener(UploadListener uploadlistener);

    public abstract boolean allowUpload(QueueType queuetype, boolean flag);

    public abstract void clearQueue(QueueType queuetype);

    public abstract Map getUploadStatusForAllQueues();

    public abstract boolean isEmpty(QueueType queuetype);

    public abstract void onUploadCancelled(QueueType queuetype);

    public abstract void onUploadScheduled(QueueType queuetype, UploadPermission uploadpermission, String s, AtomicBoolean atomicboolean)
        throws AccountLockedException, CloudStorageLimitException;

    public abstract void refreshQueue(QueueType queuetype);

    public abstract void removeUploadListener(UploadListener uploadlistener);

    public abstract void updateErrorState(UploadError uploaderror, QueueType queuetype);

    public abstract void uploadMediaItems(List list, QueueType queuetype, UploadStrategy uploadstrategy);

    public abstract void uploadTags(List list, QueueType queuetype, UploadStrategy uploadstrategy);
}
