// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import java.util.concurrent.Semaphore;

// Referenced classes of package com.urbanairship.push:
//            IncomingPushServiceDelegate

class val.semaphore
    implements com.urbanairship.richpush.sCallback
{

    final IncomingPushServiceDelegate this$0;
    final Semaphore val$semaphore;

    public void onRefreshMessages(boolean flag)
    {
        val$semaphore.release();
    }

    sagesCallback()
    {
        this$0 = final_incomingpushservicedelegate;
        val$semaphore = Semaphore.this;
        super();
    }
}
