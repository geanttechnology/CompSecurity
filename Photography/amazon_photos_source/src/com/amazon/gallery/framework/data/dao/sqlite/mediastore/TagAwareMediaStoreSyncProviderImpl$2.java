// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            TagAwareMediaStoreSyncProviderImpl

class this._cls0
    implements Runnable
{

    final TagAwareMediaStoreSyncProviderImpl this$0;

    public void run()
    {
        if (executor.getActiveCount() + TagAwareMediaStoreSyncProviderImpl.access$700(TagAwareMediaStoreSyncProviderImpl.this).get() <= 1)
        {
            for (Iterator iterator = TagAwareMediaStoreSyncProviderImpl.access$800(TagAwareMediaStoreSyncProviderImpl.this).iterator(); iterator.hasNext(); ((istener)iterator.next()).onSyncCompleted()) { }
        }
    }

    istener()
    {
        this$0 = TagAwareMediaStoreSyncProviderImpl.this;
        super();
    }
}
