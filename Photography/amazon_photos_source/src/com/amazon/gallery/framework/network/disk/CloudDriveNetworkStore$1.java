// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.disk;

import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
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
    final com.amazon.gallery.framework.data.store.ontentLoadFailure val$assetType;
    final ContentLoadCallback val$callback;
    final int val$height;
    final MediaItem val$item;
    final ScaleMode val$scaleMode;
    final long val$startTime;
    final long val$threadId;
    final Timer val$timer;
    final int val$width;

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
        void1 = CloudDriveNetworkStore.access$000(CloudDriveNetworkStore.this).storeAsset(val$threadId, val$item, val$width, val$height, val$assetType, val$scaleMode);
        if (void1 != null && void1.exists())
        {
            val$timer.stop();
            GLogger.t(CloudDriveNetworkStore.access$100(), val$startTime, "loadContent network request for %s", new Object[] {
                val$item.getObjectId()
            });
            val$callback.onContentLoadSuccess();
            return;
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
        val$threadId = l;
        val$item = mediaitem;
        val$width = i;
        val$height = j;
        val$assetType = _pcls1;
        val$scaleMode = scalemode;
        val$timer = timer1;
        val$startTime = l1;
        val$callback = ContentLoadCallback.this;
        super();
    }
}
