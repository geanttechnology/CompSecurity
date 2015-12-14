// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            GalleryDownloadManager, CustomDownloadId

class this._cls0
    implements stomDownloadIdGenerator
{

    final GalleryDownloadManager this$0;

    public CustomDownloadId generateId(MediaItem mediaitem)
    {
        mediaitem = new CustomDownloadId(mediaitem.getObjectId());
        mediaitem.setMediaType(MediaType.PHOTO);
        mediaitem.setRequestType(ype.ORIGINAL);
        return mediaitem;
    }

    ype()
    {
        this$0 = GalleryDownloadManager.this;
        super();
    }
}
