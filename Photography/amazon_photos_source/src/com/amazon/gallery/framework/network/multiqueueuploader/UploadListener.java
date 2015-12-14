// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadStatus, UploadError, QueueType

public interface UploadListener
{

    public abstract void onUploadError(UploadStatus uploadstatus, UploadError uploaderror, QueueType queuetype);

    public abstract void onUploadFailed(UploadStatus uploadstatus, QueueType queuetype, Exception exception);

    public abstract void onUploadProgressChanged(UploadStatus uploadstatus, MediaItem mediaitem, QueueType queuetype, int i, int j);

    public abstract void onUploadQueued(UploadStatus uploadstatus, List list, QueueType queuetype);

    public abstract void onUploadSuccessful(UploadStatus uploadstatus, QueueType queuetype);
}
