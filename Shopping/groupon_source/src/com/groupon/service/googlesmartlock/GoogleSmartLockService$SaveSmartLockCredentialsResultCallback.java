// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.googlesmartlock;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.groupon.service.googlesmartlock:
//            GoogleSmartLockService

private class <init>
    implements ResultCallback
{

    final GoogleSmartLockService this$0;

    public volatile void onResult(Result result)
    {
        onResult((Status)result);
    }

    public void onResult(Status status)
    {
        if (GoogleSmartLockService.access$500(GoogleSmartLockService.this) != null)
        {
            if (status.isSuccess())
            {
                GoogleSmartLockService.access$500(GoogleSmartLockService.this).SaveCompleted(true);
                return;
            }
            if (status.hasResolution())
            {
                if (!GoogleSmartLockService.access$300(GoogleSmartLockService.this) && GoogleSmartLockService.access$400(GoogleSmartLockService.this) != null)
                {
                    try
                    {
                        status.startResolutionForResult(GoogleSmartLockService.access$400(GoogleSmartLockService.this), 10154);
                        GoogleSmartLockService.access$302(GoogleSmartLockService.this, true);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Status status)
                    {
                        GoogleSmartLockService.access$500(GoogleSmartLockService.this).SaveCompleted(false);
                    }
                    return;
                }
            } else
            {
                GoogleSmartLockService.access$500(GoogleSmartLockService.this).SaveCompleted(false);
                return;
            }
        }
    }

    private ()
    {
        this$0 = GoogleSmartLockService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
