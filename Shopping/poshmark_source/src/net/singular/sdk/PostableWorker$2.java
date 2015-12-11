// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import java.util.concurrent.Semaphore;

// Referenced classes of package net.singular.sdk:
//            PostableWorker

class this._cls0
    implements Runnable
{

    final PostableWorker this$0;

    public void run()
    {
        try
        {
            PostableWorker.access$000(PostableWorker.this).acquire();
            PostableWorker.access$000(PostableWorker.this).release();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    ()
    {
        this$0 = PostableWorker.this;
        super();
    }
}
