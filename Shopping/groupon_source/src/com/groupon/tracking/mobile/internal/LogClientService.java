// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import android.content.Intent;
import android.os.IBinder;
import com.groupon.foundations.service.BaseIntentService;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.tracking.mobile.internal:
//            LogClient, LogClientUploader

public class LogClientService extends BaseIntentService
{

    private LogClient logClient;
    private LogClientUploader logClientUploader;

    public LogClientService()
    {
        super(com/groupon/tracking/mobile/internal/LogClientService.getSimpleName());
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    protected void onHandleIntent(Intent intent)
    {
        Ln.d("NST LogClientService %s", new Object[] {
            intent
        });
        logClient.closeLog();
        logClientUploader.uploadFilesSynchronously();
    }
}
