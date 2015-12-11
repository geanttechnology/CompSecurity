// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.location.LocationStatusCodes;

final class zzaFC extends zzaFC
{

    private com.google.android.gms.internal. zzaFC;

    private void zzgZ(int i)
    {
        if (zzaFC == null)
        {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
            return;
        } else
        {
            com.google.android.gms.common.api.Status status = LocationStatusCodes.zzgW(LocationStatusCodes.zzgV(i));
            zzaFC.zzp(status);
            zzaFC = null;
            return;
        }
    }

    public final void zza(int i, PendingIntent pendingintent)
    {
        zzgZ(i);
    }

    public final void zza(int i, String as[])
    {
        Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
    }

    public final void zzb(int i, String as[])
    {
        zzgZ(i);
    }

    public es(com.google.android.gms.internal. )
    {
        zzaFC = ;
    }
}
