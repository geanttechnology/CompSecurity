// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            AdRequestParcel, SearchAdRequestParcel

public class zzg
    implements android.os.Parcelable.Creator
{

    public zzg()
    {
    }

    static void zza(AdRequestParcel adrequestparcel, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, adrequestparcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, adrequestparcel.zzsB);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, adrequestparcel.extras, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, adrequestparcel.zzsC);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 5, adrequestparcel.zzsD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, adrequestparcel.zzsE);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, adrequestparcel.zzsF);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, adrequestparcel.zzsG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, adrequestparcel.zzsH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, adrequestparcel.zzsI, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, adrequestparcel.zzsJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, adrequestparcel.zzsK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, adrequestparcel.zzsL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, adrequestparcel.zzsM, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 15, adrequestparcel.zzsN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, adrequestparcel.zzsP, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, adrequestparcel.zzsO, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzb(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzk(i);
    }

    public AdRequestParcel zzb(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int k = 0;
        long l1 = 0L;
        android.os.Bundle bundle2 = null;
        int j = 0;
        java.util.ArrayList arraylist1 = null;
        boolean flag1 = false;
        int i = 0;
        boolean flag = false;
        String s3 = null;
        SearchAdRequestParcel searchadrequestparcel = null;
        Location location = null;
        String s2 = null;
        android.os.Bundle bundle1 = null;
        android.os.Bundle bundle = null;
        java.util.ArrayList arraylist = null;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i1);
                    break;

                case 3: // '\003'
                    bundle2 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 5: // '\005'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, i1);
                    break;

                case 6: // '\006'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;

                case 9: // '\t'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 10: // '\n'
                    searchadrequestparcel = (SearchAdRequestParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, SearchAdRequestParcel.CREATOR);
                    break;

                case 11: // '\013'
                    location = (Location)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Location.CREATOR);
                    break;

                case 12: // '\f'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 13: // '\r'
                    bundle1 = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i1);
                    break;

                case 14: // '\016'
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, i1);
                    break;

                case 15: // '\017'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, i1);
                    break;

                case 17: // '\021'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 16: // '\020'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new AdRequestParcel(k, l1, bundle2, j, arraylist1, flag1, i, flag, s3, searchadrequestparcel, location, s2, bundle1, bundle, arraylist, s1, s);
            }
        } while (true);
    }

    public AdRequestParcel[] zzk(int i)
    {
        return new AdRequestParcel[i];
    }
}
