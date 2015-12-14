// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.foundation.utils.messaging.DownloadStatusEvent;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.gallery.messaging.DownloadStatusContentFetcher;

// Referenced classes of package com.amazon.gallery.thor.app:
//            ContentChangeListener

class this._cls0
    implements Runnable
{

    final ContentChangeListener this$0;

    public void run()
    {
        if (!((DownloadStatusEvent)ContentChangeListener.access$000(ContentChangeListener.this).getContentFromProducer()).isActive())
        {
            ContentChangeListener.access$100(ContentChangeListener.this).syncMediaStoreAsync();
        }
    }

    ore.MediaStoreSyncProvider()
    {
        this$0 = ContentChangeListener.this;
        super();
    }
}
