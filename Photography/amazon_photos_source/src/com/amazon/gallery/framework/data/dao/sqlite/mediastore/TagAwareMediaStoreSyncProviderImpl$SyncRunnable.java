// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.content.Context;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.TruthDataMigrationUtilities;
import com.amazon.gallery.framework.kindle.Keys;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediastore:
//            TagAwareMediaStoreSyncProviderImpl

private class notify
    implements Runnable
{

    private final CountDownLatch countDownLatch = null;
    private final boolean notify;
    private final boolean reconcileAllowed;
    final TagAwareMediaStoreSyncProviderImpl this$0;

    public void run()
    {
        boolean flag;
        int i;
        flag = false;
        i = 3;
_L2:
        int j;
        j = i - 1;
        if (i <= 0 || flag)
        {
            break; /* Loop/switch isn't completed */
        }
        TagAwareMediaStoreSyncProviderImpl.access$200(TagAwareMediaStoreSyncProviderImpl.this).lock();
        TruthDataMigrationUtilities truthdatamigrationutilities;
        TagAwareMediaStoreSyncProviderImpl.access$300(TagAwareMediaStoreSyncProviderImpl.this, reconcileAllowed, notify);
        TagAwareMediaStoreSyncProviderImpl.access$400(TagAwareMediaStoreSyncProviderImpl.this);
        TagAwareMediaStoreSyncProviderImpl.access$502(TagAwareMediaStoreSyncProviderImpl.this, true);
        truthdatamigrationutilities = (TruthDataMigrationUtilities)((BeanAwareApplication)TagAwareMediaStoreSyncProviderImpl.access$600(TagAwareMediaStoreSyncProviderImpl.this).getApplicationContext()).getBeanFactory().getBean(Keys.TRUTH_MIGRATION_UTILS);
        if (truthdatamigrationutilities == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        truthdatamigrationutilities.startTruthUploadQueueMigration();
        flag = true;
        TagAwareMediaStoreSyncProviderImpl.access$200(TagAwareMediaStoreSyncProviderImpl.this).unlock();
_L3:
        i = j;
        if (true) goto _L2; else goto _L1
        Object obj;
        obj;
        GLogger.ex(TagAwareMediaStoreSyncProviderImpl.access$100(), (new StringBuilder()).append("Can't complete media store sync. Retry. ").append(j).append(" attempts left.").toString(), ((Throwable) (obj)));
        TagAwareMediaStoreSyncProviderImpl.access$200(TagAwareMediaStoreSyncProviderImpl.this).unlock();
          goto _L3
        obj;
        TagAwareMediaStoreSyncProviderImpl.access$200(TagAwareMediaStoreSyncProviderImpl.this).unlock();
        throw obj;
_L1:
        if (countDownLatch != null)
        {
            countDownLatch.countDown();
        }
        return;
    }

    public (boolean flag, boolean flag1)
    {
        this$0 = TagAwareMediaStoreSyncProviderImpl.this;
        super();
        reconcileAllowed = flag;
        notify = flag1;
    }
}
