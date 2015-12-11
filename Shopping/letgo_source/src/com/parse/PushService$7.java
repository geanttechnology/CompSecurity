// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Intent;

// Referenced classes of package com.parse:
//            PushService, ServiceUtils

class val.startId
    implements Runnable
{

    final PushService this$0;
    final Intent val$intent;
    final int val$startId;

    public void run()
    {
        PushService.access$000(PushService.this, val$intent);
        ServiceUtils.completeWakefulIntent(val$intent);
        stopSelf(val$startId);
        return;
        Exception exception;
        exception;
        ServiceUtils.completeWakefulIntent(val$intent);
        stopSelf(val$startId);
        throw exception;
    }

    ()
    {
        this$0 = final_pushservice;
        val$intent = intent1;
        val$startId = I.this;
        super();
    }
}
