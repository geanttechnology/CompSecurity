// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.server_requests;

import android.content.Intent;
import com.ebay.nautilus.shell.app.BaseIntentService;

// Referenced classes of package com.ebay.server_requests:
//            InstallTracking

public static final class  extends BaseIntentService
{

    protected void onHandleIntent(Intent intent)
    {
        if ("com.ebay.server_requests.Install".equals(intent.getAction()))
        {
            InstallTracking.access$100(this, intent.getData(), false);
        }
    }

    public ()
    {
        super(com/ebay/server_requests/InstallTracking$InstallTrackingService.getSimpleName());
    }
}
