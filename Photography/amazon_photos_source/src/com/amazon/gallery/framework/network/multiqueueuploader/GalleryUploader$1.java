// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;

import android.os.AsyncTask;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.network.multiqueueuploader:
//            GalleryUploader

class val.mediaItem extends AsyncTask
{

    final GalleryUploader this$0;
    final MediaItem val$mediaItem;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        (new File(val$mediaItem.getLocalPath())).delete();
        GalleryUploader.access$000(GalleryUploader.this).deleteLocalFields(val$mediaItem, true, false);
        return null;
    }

    ()
    {
        this$0 = final_galleryuploader;
        val$mediaItem = MediaItem.this;
        super();
    }
}
