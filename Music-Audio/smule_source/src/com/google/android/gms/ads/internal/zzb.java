// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzap;
import com.google.android.gms.internal.zzat;

public class zzb
{

    private zza zznl;
    private boolean zznm;
    private boolean zznn;

    public zzb()
    {
        zznn = ((Boolean)zzat.zzrm.get()).booleanValue();
    }

    public zzb(boolean flag)
    {
        zznn = flag;
    }

    public void recordClick()
    {
        zznm = true;
    }

    public void zza(zza zza1)
    {
        zznl = zza1;
    }

    public boolean zzaF()
    {
        return !zznn || zznm;
    }

    public void zze(String s)
    {
        com.google.android.gms.ads.internal.util.client.zzb.zzaj("Action was blocked because no click was detected.");
        if (zznl != null)
        {
            zznl.zzf(s);
        }
    }

    private class zza
    {

        public abstract void zzf(String s);
    }

}
