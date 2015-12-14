// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.disk.ContentLoadCallback;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.gallery.view.android:
//            GifPlayerWebView

class val.mediaItem
    implements ContentLoadCallback
{

    final GifPlayerWebView this$0;
    final MediaItem val$mediaItem;

    public void onContentLoadFailure()
    {
        GLogger.w(GifPlayerWebView.TAG, "Cannot retrieve original GIF from cloud for MediaItem %s", new Object[] {
            val$mediaItem.toString()
        });
    }

    public void onContentLoadSuccess()
    {
        File file = GifPlayerWebView.access$400(GifPlayerWebView.this).getOriginal(val$mediaItem);
        if (file.exists())
        {
            setImageUri(Uri.parse(file.toString()));
        }
    }

    ()
    {
        this$0 = final_gifplayerwebview;
        val$mediaItem = MediaItem.this;
        super();
    }
}
