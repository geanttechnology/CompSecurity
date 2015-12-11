// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location.places:
//            NearbyAlertRequest, PlaceFilter, NearbyAlertFilter

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(NearbyAlertRequest nearbyalertrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, nearbyalertrequest.zzwK());
        zzb.zzc(parcel, 1000, nearbyalertrequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyalertrequest.zzwN());
        zzb.zza(parcel, 3, nearbyalertrequest.zzwO(), i, false);
        zzb.zza(parcel, 4, nearbyalertrequest.zzwP(), i, false);
        zzb.zza(parcel, 5, nearbyalertrequest.zzwQ());
        zzb.zzc(parcel, 6, nearbyalertrequest.zzwR());
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeN(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhi(i);
    }

    public NearbyAlertRequest zzeN(Parcel parcel)
    {
        NearbyAlertFilter nearbyalertfilter = null;
        int i = 0;
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int j = -1;
        boolean flag = false;
        PlaceFilter placefilter = null;
        int k = 0;
        int l = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 1000: 
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 3: // '\003'
                    placefilter = (PlaceFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, PlaceFilter.CREATOR);
                    break;

                case 4: // '\004'
                    nearbyalertfilter = (NearbyAlertFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, NearbyAlertFilter.CREATOR);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, j1);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new NearbyAlertRequest(l, k, j, placefilter, nearbyalertfilter, flag, i);
            }
        } while (true);
    }

    public NearbyAlertRequest[] zzhi(int i)
    {
        return new NearbyAlertRequest[i];
    }
}
