// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzbc;
import com.google.android.gms.internal.zzdr;
import com.google.android.gms.internal.zzdv;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            AdSizeParcel, zzl, zzm, zzp, 
//            zzq, AdRequestParcel

public interface zzn
    extends IInterface
{

    public abstract void destroy();

    public abstract String getMediationAdapterClassName();

    public abstract boolean isReady();

    public abstract void pause();

    public abstract void resume();

    public abstract void showInterstitial();

    public abstract void stopLoading();

    public abstract void zza(AdSizeParcel adsizeparcel);

    public abstract void zza(zzl zzl);

    public abstract void zza(zzm zzm);

    public abstract void zza(zzp zzp);

    public abstract void zza(zzq zzq);

    public abstract void zza(zzbc zzbc);

    public abstract void zza(zzdr zzdr);

    public abstract void zza(zzdv zzdv, String s);

    public abstract boolean zza(AdRequestParcel adrequestparcel);

    public abstract zzd zzag();

    public abstract AdSizeParcel zzah();

    public abstract void zzar();
}
