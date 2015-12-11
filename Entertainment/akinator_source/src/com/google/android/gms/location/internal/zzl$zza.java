// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.location.LocationStatusCodes;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl

private static final class zzaFC extends zzaFC
{

    private com.google.android.gms.internal. zzaFC;

    public void zza(int i, PendingIntent pendingintent)
    {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }

    public void zza(int i, String as[])
    {
        if (zzaFC == null)
        {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        } else
        {
            as = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(i));
            zzaFC.zzp(as);
            zzaFC = null;
            return;
        }
    }

    public void zzb(int i, String as[])
    {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }

    public es(com.google.android.gms.internal. )
    {
        zzaFC = ;
    }
}
