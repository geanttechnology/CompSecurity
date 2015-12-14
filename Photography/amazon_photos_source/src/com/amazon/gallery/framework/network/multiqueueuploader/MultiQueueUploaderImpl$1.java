// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            UploadProgressCallback, MultiQueueUploaderImpl, QueueType

class val.queueType
    implements UploadProgressCallback
{

    final MultiQueueUploaderImpl this$0;
    final MediaItem val$mediaItem;
    final QueueType val$queueType;

    public void onUploadProgressChanged(int i, int j)
    {
        i = (int)(((double)i / (double)j) * 100D);
        MultiQueueUploaderImpl.access$000(MultiQueueUploaderImpl.this, val$mediaItem, val$queueType, i, 100);
    }

    ()
    {
        this$0 = final_multiqueueuploaderimpl;
        val$mediaItem = mediaitem;
        val$queueType = QueueType.this;
        super();
    }
}
