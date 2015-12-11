// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

// Referenced classes of package co.vine.android.util:
//            UrlResourceCache

private class mOwnerId
    implements Runnable
{

    private final long mOwnerId;
    final UrlResourceCache this$0;

    public void run()
    {
label0:
        {
            synchronized (mLock)
            {
                if (!mQueuedDownload.isEmpty())
                {
                    break label0;
                }
            }
            return;
        }
        HashMap hashmap;
        hashmap = new HashMap(mQueuedDownload.size());
        hashmap.putAll(mQueuedDownload);
        mQueuedDownload.clear();
        ai;
        JVM INSTR monitorexit ;
        UrlResourceCache.sExecutor.execute(new <init>(UrlResourceCache.this, mOwnerId, hashmap));
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public _cls9(long l)
    {
        this$0 = UrlResourceCache.this;
        super();
        mOwnerId = l;
    }
}
