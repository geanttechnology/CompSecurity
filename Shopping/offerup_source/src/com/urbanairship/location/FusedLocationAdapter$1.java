// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import com.google.android.gms.common.ConnectionResult;
import com.urbanairship.Logger;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.urbanairship.location:
//            FusedLocationAdapter

class val.semaphore
    implements com.google.android.gms.common.api.ctionFailedListener
{

    final FusedLocationAdapter this$0;
    final Semaphore val$semaphore;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        Logger.verbose("FusedLocationAdapter - Google Play services failed to connect for fused location.");
        val$semaphore.release();
    }

    .OnConnectionFailedListener()
    {
        this$0 = final_fusedlocationadapter;
        val$semaphore = Semaphore.this;
        super();
    }
}
