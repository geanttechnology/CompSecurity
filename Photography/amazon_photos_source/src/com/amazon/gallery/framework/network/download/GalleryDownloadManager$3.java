// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            GalleryDownloadManager, CustomDownloadId

class val.height
    implements stomDownloadIdGenerator
{

    final GalleryDownloadManager this$0;
    final int val$height;
    final int val$width;

    public CustomDownloadId generateId(MediaItem mediaitem)
    {
        mediaitem = new CustomDownloadId(mediaitem.getObjectId());
        mediaitem.setMediaType(MediaType.PHOTO);
        mediaitem.setRequestType(ype.ASSET);
        mediaitem.setDesiredWidth(val$width);
        mediaitem.setDesiredHeight(val$height);
        return mediaitem;
    }

    ype()
    {
        this$0 = final_gallerydownloadmanager;
        val$width = i;
        val$height = I.this;
        super();
    }
}
