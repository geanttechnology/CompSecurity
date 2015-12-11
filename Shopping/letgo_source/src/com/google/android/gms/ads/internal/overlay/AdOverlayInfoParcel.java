// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v7.lk;
import android.support.v7.ll;
import android.support.v7.ou;
import android.support.v7.oz;
import android.support.v7.ul;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            zzf, zzg, zzn, AdLauncherIntentInfoParcel

public final class AdOverlayInfoParcel
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final AdLauncherIntentInfoParcel zzAO;
    public final zza zzAP;
    public final zzg zzAQ;
    public final ul zzAR;
    public final ou zzAS;
    public final String zzAT;
    public final boolean zzAU;
    public final String zzAV;
    public final zzn zzAW;
    public final int zzAX;
    public final oz zzAY;
    public final String zzAZ;
    public final InterstitialAdParameterParcel zzBa;
    public final VersionInfoParcel zzqb;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adlauncherintentinfoparcel, IBinder ibinder, IBinder ibinder1, IBinder ibinder2, IBinder ibinder3, String s, 
            boolean flag, String s1, IBinder ibinder4, int j, int k, String s2, VersionInfoParcel versioninfoparcel, 
            IBinder ibinder5, String s3, InterstitialAdParameterParcel interstitialadparameterparcel)
    {
        versionCode = i;
        zzAO = adlauncherintentinfoparcel;
        zzAP = (zza)ll.a(android.support.v7.lk.a.a(ibinder));
        zzAQ = (zzg)ll.a(android.support.v7.lk.a.a(ibinder1));
        zzAR = (ul)ll.a(android.support.v7.lk.a.a(ibinder2));
        zzAS = (ou)ll.a(android.support.v7.lk.a.a(ibinder3));
        zzAT = s;
        zzAU = flag;
        zzAV = s1;
        zzAW = (zzn)ll.a(android.support.v7.lk.a.a(ibinder4));
        orientation = j;
        zzAX = k;
        url = s2;
        zzqb = versioninfoparcel;
        zzAY = (oz)ll.a(android.support.v7.lk.a.a(ibinder5));
        zzAZ = s3;
        zzBa = interstitialadparameterparcel;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, ou ou1, zzn zzn1, ul ul1, boolean flag, int i, 
            String s, VersionInfoParcel versioninfoparcel, oz oz1)
    {
        versionCode = 4;
        zzAO = null;
        zzAP = zza1;
        zzAQ = zzg1;
        zzAR = ul1;
        zzAS = ou1;
        zzAT = null;
        zzAU = flag;
        zzAV = null;
        zzAW = zzn1;
        orientation = i;
        zzAX = 3;
        url = s;
        zzqb = versioninfoparcel;
        zzAY = oz1;
        zzAZ = null;
        zzBa = null;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, ou ou1, zzn zzn1, ul ul1, boolean flag, int i, 
            String s, String s1, VersionInfoParcel versioninfoparcel, oz oz1)
    {
        versionCode = 4;
        zzAO = null;
        zzAP = zza1;
        zzAQ = zzg1;
        zzAR = ul1;
        zzAS = ou1;
        zzAT = s1;
        zzAU = flag;
        zzAV = s;
        zzAW = zzn1;
        orientation = i;
        zzAX = 3;
        url = null;
        zzqb = versioninfoparcel;
        zzAY = oz1;
        zzAZ = null;
        zzBa = null;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, zzn zzn1, ul ul1, int i, VersionInfoParcel versioninfoparcel, String s, 
            InterstitialAdParameterParcel interstitialadparameterparcel)
    {
        versionCode = 4;
        zzAO = null;
        zzAP = zza1;
        zzAQ = zzg1;
        zzAR = ul1;
        zzAS = null;
        zzAT = null;
        zzAU = false;
        zzAV = null;
        zzAW = zzn1;
        orientation = i;
        zzAX = 1;
        url = null;
        zzqb = versioninfoparcel;
        zzAY = null;
        zzAZ = s;
        zzBa = interstitialadparameterparcel;
    }

    public AdOverlayInfoParcel(zza zza1, zzg zzg1, zzn zzn1, ul ul1, boolean flag, int i, VersionInfoParcel versioninfoparcel)
    {
        versionCode = 4;
        zzAO = null;
        zzAP = zza1;
        zzAQ = zzg1;
        zzAR = ul1;
        zzAS = null;
        zzAT = null;
        zzAU = flag;
        zzAV = null;
        zzAW = zzn1;
        orientation = i;
        zzAX = 2;
        url = null;
        zzqb = versioninfoparcel;
        zzAY = null;
        zzAZ = null;
        zzBa = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adlauncherintentinfoparcel, zza zza1, zzg zzg1, zzn zzn1, VersionInfoParcel versioninfoparcel)
    {
        versionCode = 4;
        zzAO = adlauncherintentinfoparcel;
        zzAP = zza1;
        zzAQ = zzg1;
        zzAR = null;
        zzAS = null;
        zzAT = null;
        zzAU = false;
        zzAV = null;
        zzAW = zzn1;
        orientation = -1;
        zzAX = 4;
        url = null;
        zzqb = versioninfoparcel;
        zzAY = null;
        zzAZ = null;
        zzBa = null;
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

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.ads.internal.overlay.zzf.zza(this, parcel, i);
    }

    IBinder zzeE()
    {
        return ll.a(zzAP).asBinder();
    }

    IBinder zzeF()
    {
        return ll.a(zzAQ).asBinder();
    }

    IBinder zzeG()
    {
        return ll.a(zzAR).asBinder();
    }

    IBinder zzeH()
    {
        return ll.a(zzAS).asBinder();
    }

    IBinder zzeI()
    {
        return ll.a(zzAY).asBinder();
    }

    IBinder zzeJ()
    {
        return ll.a(zzAW).asBinder();
    }

}
