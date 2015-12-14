// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.net.Uri;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.AbstractMediaStoreSyncProvider;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            SimpleDownloadManager

class this._cls0
    implements android.media.nScanCompletedListener
{

    final SimpleDownloadManager this$0;

    public void onScanCompleted(String s, Uri uri)
    {
        if (SimpleDownloadManager.access$000(SimpleDownloadManager.this).decrementAndGet() == 0)
        {
            mediaStoreSyncProvider.syncMediaStore(false);
        }
    }

    toreSyncProvider()
    {
        this$0 = SimpleDownloadManager.this;
        super();
    }
}
