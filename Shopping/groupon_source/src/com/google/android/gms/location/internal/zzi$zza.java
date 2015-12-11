// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzi

private static class ity extends com.google.android.gms.location..zzi.zza
{

    private Handler zzayO;

    private void zzb(int i, Object obj)
    {
        if (zzayO == null)
        {
            Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
            return;
        } else
        {
            Message message = Message.obtain();
            message.what = i;
            message.obj = obj;
            zzayO.sendMessage(message);
            return;
        }
    }

    public void onLocationAvailability(LocationAvailability locationavailability)
    {
        zzb(1, locationavailability);
    }

    public void onLocationResult(LocationResult locationresult)
    {
        zzb(0, locationresult);
    }
}
