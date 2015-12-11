// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            ReferenceShiftedDetails

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(ReferenceShiftedDetails referenceshifteddetails, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, referenceshifteddetails.mVersionCode);
        zzb.zza(parcel, 2, referenceshifteddetails.zzaoZ, false);
        zzb.zza(parcel, 3, referenceshifteddetails.zzapa, false);
        zzb.zzc(parcel, 4, referenceshifteddetails.zzapb);
        zzb.zzc(parcel, 5, referenceshifteddetails.zzapc);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcx(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzek(i);
    }

    public ReferenceShiftedDetails zzcx(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int j = 0;
        String s1 = null;
        int k = 0;
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
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new ReferenceShiftedDetails(k, s1, s, j, i);
            }
        } while (true);
    }

    public ReferenceShiftedDetails[] zzek(int i)
    {
        return new ReferenceShiftedDetails[i];
    }
}
