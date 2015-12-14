// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            GalleryDownloadManager

class val.diskStore
    implements sultFileGenerator
{

    final GalleryDownloadManager this$0;
    final DiskStore val$diskStore;

    public File generateResultFile(MediaItem mediaitem)
    {
        return val$diskStore.getOriginal(mediaitem);
    }

    sultFileGenerator()
    {
        this$0 = final_gallerydownloadmanager;
        val$diskStore = DiskStore.this;
        super();
    }
}
