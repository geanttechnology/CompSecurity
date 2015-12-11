// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public final class zzch extends zzcj.zza
{

    private final zzg zzvW;
    private final String zzvX;
    private final String zzvY;

    public zzch(zzg zzg1, String s, String s1)
    {
        zzvW = zzg1;
        zzvX = s;
        zzvY = s1;
    }

    public String getContent()
    {
        return zzvY;
    }

    public void recordClick()
    {
        zzvW.recordClick();
    }

    public void recordImpression()
    {
        zzvW.recordImpression();
    }

    public void zza(zzd zzd)
    {
        if (zzd == null)
        {
            return;
        } else
        {
            zzvW.zzc((View)zze.zzp(zzd));
            return;
        }
    }

    public String zzdr()
    {
        return zzvX;
    }
}
