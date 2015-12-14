// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;

public class zze
{

    private zza zzoI;
    private boolean zzoJ;
    private boolean zzoK;

    public zze()
    {
        zzoK = ((Boolean)zzby.zzus.get()).booleanValue();
    }

    public zze(boolean flag)
    {
        zzoK = flag;
    }

    public void recordClick()
    {
        zzoJ = true;
    }

    public void zza(zza zza1)
    {
        zzoI = zza1;
    }

    public boolean zzbe()
    {
        return !zzoK || zzoJ;
    }

    public void zzp(String s)
    {
        zzb.zzaF("Action was blocked because no click was detected.");
        if (zzoI != null)
        {
            zzoI.zzq(s);
        }
    }

    private class zza
    {

        public abstract void zzq(String s);
    }

}
