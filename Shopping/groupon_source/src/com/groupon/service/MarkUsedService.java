// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Intent;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.receiver.MarkUsedReceiver;

// Referenced classes of package com.groupon.service:
//            MarkUsedManager

public class MarkUsedService extends BaseIntentService
{

    MarkUsedManager markUsedManager;

    public MarkUsedService()
    {
        super(com/groupon/service/MarkUsedService.getCanonicalName());
    }

    protected void onHandleIntent(Intent intent)
    {
        markUsedManager.processQueueSync();
        MarkUsedReceiver.completeWakefulIntent(intent);
        return;
        Exception exception;
        exception;
        MarkUsedReceiver.completeWakefulIntent(intent);
        throw exception;
    }
}
