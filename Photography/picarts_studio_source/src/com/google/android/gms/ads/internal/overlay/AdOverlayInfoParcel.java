// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zziz;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzf, zzg, zzn, AdLauncherIntentInfoParcel

public final class AdOverlayInfoParcel
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final AdLauncherIntentInfoParcel zzBA;
    public final zza zzBB;
    public final zzg zzBC;
    public final zziz zzBD;
    public final zzdg zzBE;
    public final String zzBF;
    public final boolean zzBG;
    public final String zzBH;
    public final zzn zzBI;
    public final int zzBJ;
    public final zzdm zzBK;
    public final String zzBL;
    public final InterstitialAdParameterParcel zzBM;
    public final VersionInfoParcel zzqj;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adlauncherintentinfoparcel, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3, String s, 
            boolean flag, String s1, IBinder ibinder4, int j, int k, String s2, VersionInfoParcel versioninfoparcel, 
            IBinder ibinder5, String s3, InterstitialAdParameterParcel interstitialadparameterparcel)
    {
        versionCode = i;
        zzBA = adlauncherintentinfoparcel;
        zzBB = (zza)zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder));
        zzBC = (zzg)zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder1));
        zzBD = (zziz)zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder2));
        zzBE = (zzdg)zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder3));
        zzBF = s;
        zzBG = flag;
        zzBH = s1;
        zzBI = (zzn)zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder4));
        orientation = j;
        zzBJ = k;
        url = s2;
        zzqj = versioninfoparcel;
        zzBK = (zzdm)zze.zzp(com.google.android.gms.dynamic.zzd.zza.zzbk(ibinder5));
        zzBL = s3;
        zzBM = interstitialadparameterparcel;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, zzn zzn1, zziz zziz1, int i, VersionInfoParcel versioninfoparcel, String s, 
            InterstitialAdParameterParcel interstitialadparameterparcel)
    {
        versionCode = 4;
        zzBA = null;
        zzBB = zza1;
        zzBC = zzg1;
        zzBD = zziz1;
        zzBE = null;
        zzBF = null;
        zzBG = false;
        zzBH = null;
        zzBI = zzn1;
        orientation = i;
        zzBJ = 1;
        url = null;
        zzqj = versioninfoparcel;
        zzBK = null;
        zzBL = s;
        zzBM = interstitialadparameterparcel;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, zzn zzn1, zziz zziz1, boolean flag, int i, VersionInfoParcel versioninfoparcel)
    {
        versionCode = 4;
        zzBA = null;
        zzBB = zza1;
        zzBC = zzg1;
        zzBD = zziz1;
        zzBE = null;
        zzBF = null;
        zzBG = flag;
        zzBH = null;
        zzBI = zzn1;
        orientation = i;
        zzBJ = 2;
        url = null;
        zzqj = versioninfoparcel;
        zzBK = null;
        zzBL = null;
        zzBM = null;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, zzdg zzdg1, zzn zzn1, zziz zziz1, boolean flag, int i, 
            String s, VersionInfoParcel versioninfoparcel, zzdm zzdm1)
    {
        versionCode = 4;
        zzBA = null;
        zzBB = zza1;
        zzBC = zzg1;
        zzBD = zziz1;
        zzBE = zzdg1;
        zzBF = null;
        zzBG = flag;
        zzBH = null;
        zzBI = zzn1;
        orientation = i;
        zzBJ = 3;
        url = s;
        zzqj = versioninfoparcel;
        zzBK = zzdm1;
        zzBL = null;
        zzBM = null;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, zzdg zzdg1, zzn zzn1, zziz zziz1, boolean flag, int i, 
            String s, String s1, VersionInfoParcel versioninfoparcel, zzdm zzdm1)
    {
        versionCode = 4;
        zzBA = null;
        zzBB = zza1;
        zzBC = zzg1;
        zzBD = zziz1;
        zzBE = zzdg1;
        zzBF = s1;
        zzBG = flag;
        zzBH = s;
        zzBI = zzn1;
        orientation = i;
        zzBJ = 3;
        url = null;
        zzqj = versioninfoparcel;
        zzBK = zzdm1;
        zzBL = null;
        zzBM = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adlauncherintentinfoparcel, zza zza1, zzg zzg1, zzn zzn1, VersionInfoParcel versioninfoparcel)
    {
        versionCode = 4;
        zzBA = adlauncherintentinfoparcel;
        zzBB = zza1;
        zzBC = zzg1;
        zzBD = null;
        zzBE = null;
        zzBF = null;
        zzBG = false;
        zzBH = null;
        zzBI = zzn1;
        orientation = -1;
        zzBJ = 4;
        url = null;
        zzqj = versioninfoparcel;
        zzBK = null;
        zzBL = null;
        zzBM = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adoverlayinfoparcel)
    {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adoverlayinfoparcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent)
    {
        try
        {
            intent = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            intent.setClassLoader(com/google/android/gms/ads/internal/overlay/AdOverlayInfoParcel.getClassLoader());
            intent = (AdOverlayInfoParcel)intent.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.ads.internal.overlay.zzf.zza(this, parcel, i);
    }

    final IBinder zzeK()
    {
        return zze.zzy(zzBB).asBinder();
    }

    final IBinder zzeL()
    {
        return zze.zzy(zzBC).asBinder();
    }

    final IBinder zzeM()
    {
        return zze.zzy(zzBD).asBinder();
    }

    final IBinder zzeN()
    {
        return zze.zzy(zzBE).asBinder();
    }

    final IBinder zzeO()
    {
        return zze.zzy(zzBK).asBinder();
    }

    final IBinder zzeP()
    {
        return zze.zzy(zzBI).asBinder();
    }

}
