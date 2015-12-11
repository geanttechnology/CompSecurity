// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.google_api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.google_api:
//            GeofenceSetter

class this._cls0
    implements ResultCallback
{

    final GeofenceSetter this$0;

    public volatile void onResult(Result result)
    {
        onResult((Status)result);
    }

    public void onResult(Status status)
    {
        Ln.d((new StringBuilder()).append("Proximity_Notifications - GeofenceSetter: Added geofences : ").append(status.isSuccess()).toString(), new Object[0]);
        onAddGeofencesResult(status.getStatusCode(), null);
    }

    ()
    {
        this$0 = GeofenceSetter.this;
        super();
    }
}
