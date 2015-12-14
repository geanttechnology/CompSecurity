// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzfj;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            AdSizeParcel, zzm, zzn, zzt, 
//            zzu, AdRequestParcel

public interface zzr
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

    public abstract void zza(zzm zzm);

    public abstract void zza(zzn zzn);

    public abstract void zza(zzt zzt);

    public abstract void zza(zzu zzu);

    public abstract void zza(zzci zzci);

    public abstract void zza(zzff zzff);

    public abstract void zza(zzfj zzfj, String s);

    public abstract boolean zza(AdRequestParcel adrequestparcel);

    public abstract zzd zzaM();

    public abstract AdSizeParcel zzaN();

    public abstract void zzaP();
}
