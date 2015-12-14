// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;

public class zzd
{

    private zza zzow;
    private boolean zzox;
    private boolean zzoy;

    public zzd()
    {
        zzoy = ((Boolean)zzbz.zztI.get()).booleanValue();
    }

    public zzd(boolean flag)
    {
        zzoy = flag;
    }

    public void recordClick()
    {
        zzox = true;
    }

    public void zza(zza zza1)
    {
        zzow = zza1;
    }

    public boolean zzbd()
    {
        return !zzoy || zzox;
    }

    public void zzo(String s)
    {
        zzb.zzay("Action was blocked because no click was detected.");
        if (zzow != null)
        {
            zzow.zzp(s);
        }
    }

    private class zza
    {

        public abstract void zzp(String s);
    }

}
