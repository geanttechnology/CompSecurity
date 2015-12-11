// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationSettingsResult;

final class zzaFC extends zzaFC
{

    private com.google.android.gms.internal. zzaFC;

    public final void zza(LocationSettingsResult locationsettingsresult)
    {
        zzaFC.zzp(locationsettingsresult);
        zzaFC = null;
    }

    public esult(com.google.android.gms.internal. )
    {
        boolean flag;
        if ( != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "listener can't be null.");
        zzaFC = ;
    }
}
