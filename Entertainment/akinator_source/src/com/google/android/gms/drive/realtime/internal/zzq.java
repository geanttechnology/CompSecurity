// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal:
//            ParcelableCollaborator

public class zzq
    implements android.os.Parcelable.Creator
{

    public zzq()
    {
    }

    static void zza(ParcelableCollaborator parcelablecollaborator, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parcelablecollaborator.mVersionCode);
        zzb.zza(parcel, 2, parcelablecollaborator.zzaox);
        zzb.zza(parcel, 3, parcelablecollaborator.zzaoy);
        zzb.zza(parcel, 4, parcelablecollaborator.zzHP, false);
        zzb.zza(parcel, 5, parcelablecollaborator.zzGY, false);
        zzb.zza(parcel, 6, parcelablecollaborator.zzTa, false);
        zzb.zza(parcel, 7, parcelablecollaborator.zzaoz, false);
        zzb.zza(parcel, 8, parcelablecollaborator.zzaoA, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcr(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzee(i);
    }

    public ParcelableCollaborator zzcr(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        boolean flag1 = false;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ParcelableCollaborator(i, flag1, flag, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public ParcelableCollaborator[] zzee(int i)
    {
        return new ParcelableCollaborator[i];
    }
}
