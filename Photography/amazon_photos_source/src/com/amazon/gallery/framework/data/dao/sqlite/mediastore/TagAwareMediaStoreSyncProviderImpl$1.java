// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            TagAwareMediaStoreSyncProviderImpl

class val.reconcileAllowed
    implements Runnable
{

    final TagAwareMediaStoreSyncProviderImpl this$0;
    final boolean val$reconcileAllowed;

    public void run()
    {
        try
        {
            GLogger.v(TagAwareMediaStoreSyncProviderImpl.access$100(), (new StringBuilder()).append("Running asynchronously with reconcileAllowed: ").append(val$reconcileAllowed).toString(), new Object[0]);
            executor.execute(new ncRunnable(TagAwareMediaStoreSyncProviderImpl.this, val$reconcileAllowed, true));
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            GLogger.d(TagAwareMediaStoreSyncProviderImpl.access$100(), "Duplicate Request. Request already pending execution", new Object[0]);
        }
    }

    ncRunnable()
    {
        this$0 = final_tagawaremediastoresyncproviderimpl;
        val$reconcileAllowed = Z.this;
        super();
    }
}
