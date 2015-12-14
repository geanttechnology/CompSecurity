// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.disk;

import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.network.disk:
//            CloudDriveNetworkStore, ContentLoadCallback

class val.callback
    implements com.amazon.gallery.framework.network.dler
{

    final CloudDriveNetworkStore this$0;
    final File val$assetFile;
    final ContentLoadCallback val$callback;
    final MediaItem val$item;
    final Timer val$timer;

    public void onFailure(TerminalException terminalexception)
    {
        val$timer.remove();
        val$callback.onContentLoadFailure();
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((Void)obj);
    }

    public void onSuccess(Void void1)
    {
        if (val$assetFile != null)
        {
            void1 = CloudDriveNetworkStore.access$000(CloudDriveNetworkStore.this).storeOriginal(val$item);
            if (void1 != null && void1.exists())
            {
                val$timer.stop();
                val$callback.onContentLoadSuccess();
                return;
            } else
            {
                val$timer.remove();
                val$callback.onContentLoadFailure();
                return;
            }
        } else
        {
            val$timer.remove();
            val$callback.onContentLoadFailure();
            return;
        }
    }

    ()
    {
        this$0 = final_clouddrivenetworkstore;
        val$assetFile = file;
        val$item = mediaitem;
        val$timer = timer1;
        val$callback = ContentLoadCallback.this;
        super();
    }
}
