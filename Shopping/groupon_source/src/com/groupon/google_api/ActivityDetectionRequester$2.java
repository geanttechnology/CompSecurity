// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.google_api:
//            ActivityDetectionRequester

class this._cls0
    implements ResultCallback
{

    final ActivityDetectionRequester this$0;

    public volatile void onResult(Result result)
    {
        onResult((Status)result);
    }

    public void onResult(Status status)
    {
        if (status.isSuccess())
        {
            Ln.d("Proximity_Notifications - ActivityDetectionRequester: Removed activity updates successfully.", new Object[0]);
            return;
        } else
        {
            Ln.d("Proximity_Notifications - ActivityDetectionRequester: Removed activity updates unsuccessfully.", new Object[0]);
            return;
        }
    }

    _cls9()
    {
        this$0 = ActivityDetectionRequester.this;
        super();
    }
}
