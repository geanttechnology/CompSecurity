// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            AdRequestInfoParcel, CapabilityParcel

public class zzf
    implements android.os.Parcelable.Creator
{

    public zzf()
    {
    }

    static void zza(AdRequestInfoParcel adrequestinfoparcel, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, adrequestinfoparcel.versionCode);
        zzb.zza(parcel, 2, adrequestinfoparcel.zzEm, false);
        zzb.zza(parcel, 3, adrequestinfoparcel.zzEn, i, false);
        zzb.zza(parcel, 4, adrequestinfoparcel.zzqn, i, false);
        zzb.zza(parcel, 5, adrequestinfoparcel.zzqh, false);
        zzb.zza(parcel, 6, adrequestinfoparcel.applicationInfo, i, false);
        zzb.zza(parcel, 7, adrequestinfoparcel.zzEo, i, false);
        zzb.zza(parcel, 8, adrequestinfoparcel.zzEp, false);
        zzb.zza(parcel, 9, adrequestinfoparcel.zzEq, false);
        zzb.zza(parcel, 10, adrequestinfoparcel.zzEr, false);
        zzb.zza(parcel, 11, adrequestinfoparcel.zzqj, i, false);
        zzb.zza(parcel, 12, adrequestinfoparcel.zzEs, false);
        zzb.zzc(parcel, 13, adrequestinfoparcel.zzEt);
        zzb.zzb(parcel, 14, adrequestinfoparcel.zzqD, false);
        zzb.zza(parcel, 15, adrequestinfoparcel.zzEu, false);
        zzb.zza(parcel, 17, adrequestinfoparcel.zzEw, i, false);
        zzb.zza(parcel, 16, adrequestinfoparcel.zzEv);
        zzb.zzc(parcel, 19, adrequestinfoparcel.zzEy);
        zzb.zzc(parcel, 18, adrequestinfoparcel.zzEx);
        zzb.zza(parcel, 21, adrequestinfoparcel.zzEA, false);
        zzb.zza(parcel, 20, adrequestinfoparcel.zzEz);
        zzb.zza(parcel, 25, adrequestinfoparcel.zzEB);
        zzb.zzb(parcel, 27, adrequestinfoparcel.zzED, false);
        zzb.zza(parcel, 26, adrequestinfoparcel.zzEC, false);
        zzb.zza(parcel, 29, adrequestinfoparcel.zzqB, i, false);
        zzb.zza(parcel, 28, adrequestinfoparcel.zzqg, false);
        zzb.zza(parcel, 31, adrequestinfoparcel.zzEF);
        zzb.zzb(parcel, 30, adrequestinfoparcel.zzEE, false);
        zzb.zza(parcel, 32, adrequestinfoparcel.zzEG, i, false);
        zzb.zza(parcel, 33, adrequestinfoparcel.zzEH, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzi(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzD(i);
    }

    public AdRequestInfoParcel[] zzD(int i)
    {
        return new AdRequestInfoParcel[i];
    }

    public AdRequestInfoParcel zzi(Parcel parcel)
    {
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int l = 0;
        android.os.Bundle bundle2 = null;
        AdRequestParcel adrequestparcel = null;
        AdSizeParcel adsizeparcel = null;
        String s7 = null;
        ApplicationInfo applicationinfo = null;
        PackageInfo packageinfo = null;
        String s6 = null;
        String s5 = null;
        String s4 = null;
        VersionInfoParcel versioninfoparcel = null;
        android.os.Bundle bundle1 = null;
        int k = 0;
        java.util.ArrayList arraylist2 = null;
        android.os.Bundle bundle = null;
        boolean flag = false;
        Messenger messenger = null;
        int j = 0;
        int i = 0;
        float f = 0.0F;
        String s3 = null;
        long l2 = 0L;
        String s2 = null;
        java.util.ArrayList arraylist1 = null;
        String s1 = null;
        NativeAdOptionsParcel nativeadoptionsparcel = null;
        java.util.ArrayList arraylist = null;
        long l1 = 0L;
        CapabilityParcel capabilityparcel = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(j1))
                {
                case 22: // '\026'
                case 23: // '\027'
                case 24: // '\030'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    bundle2 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, j1);
                    break;

                case 3: // '\003'
                    adrequestparcel = (AdRequestParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, AdRequestParcel.CREATOR);
                    break;

                case 4: // '\004'
                    adsizeparcel = (AdSizeParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, AdSizeParcel.CREATOR);
                    break;

                case 5: // '\005'
                    s7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 6: // '\006'
                    applicationinfo = (ApplicationInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, ApplicationInfo.CREATOR);
                    break;

                case 7: // '\007'
                    packageinfo = (PackageInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, PackageInfo.CREATOR);
                    break;

                case 8: // '\b'
                    s6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 9: // '\t'
                    s5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 10: // '\n'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 11: // '\013'
                    versioninfoparcel = (VersionInfoParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, VersionInfoParcel.CREATOR);
                    break;

                case 12: // '\f'
                    bundle1 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, j1);
                    break;

                case 13: // '\r'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 14: // '\016'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, j1);
                    break;

                case 15: // '\017'
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, j1);
                    break;

                case 17: // '\021'
                    messenger = (Messenger)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, Messenger.CREATOR);
                    break;

                case 16: // '\020'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, j1);
                    break;

                case 19: // '\023'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 18: // '\022'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 21: // '\025'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 20: // '\024'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, j1);
                    break;

                case 25: // '\031'
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 27: // '\033'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, j1);
                    break;

                case 26: // '\032'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 29: // '\035'
                    nativeadoptionsparcel = (NativeAdOptionsParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, NativeAdOptionsParcel.CREATOR);
                    break;

                case 28: // '\034'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 31: // '\037'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 30: // '\036'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, j1);
                    break;

                case 32: // ' '
                    capabilityparcel = (CapabilityParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, CapabilityParcel.CREATOR);
                    break;

                case 33: // '!'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new AdRequestInfoParcel(l, bundle2, adrequestparcel, adsizeparcel, s7, applicationinfo, packageinfo, s6, s5, s4, versioninfoparcel, bundle1, k, arraylist2, bundle, flag, messenger, j, i, f, s3, l2, s2, arraylist1, s1, nativeadoptionsparcel, arraylist, l1, capabilityparcel, s);
            }
        } while (true);
    }
}
