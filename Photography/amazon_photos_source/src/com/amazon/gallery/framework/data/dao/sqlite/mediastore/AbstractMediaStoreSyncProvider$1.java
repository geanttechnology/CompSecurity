// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            AbstractMediaStoreSyncProvider

class this._cls0
    implements Runnable
{

    final AbstractMediaStoreSyncProvider this$0;

    public void run()
    {
        try
        {
            AbstractMediaStoreSyncProvider.access$000(AbstractMediaStoreSyncProvider.this).await();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
        }
    }

    ()
    {
        this$0 = AbstractMediaStoreSyncProvider.this;
        super();
    }
}
