// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            PartialDriveId

public class zzm
    implements android.os.Parcelable.Creator
{

    public zzm()
    {
    }

    static void zza(PartialDriveId partialdriveid, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, partialdriveid.mVersionCode);
        zzb.zza(parcel, 2, partialdriveid.zzagC, false);
        zzb.zza(parcel, 3, partialdriveid.zzagD);
        zzb.zzc(parcel, 4, partialdriveid.zzagE);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbO(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdC(i);
    }

    public PartialDriveId zzbO(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int j = 0;
        String s = null;
        long l1 = 0L;
        int i = -1;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new PartialDriveId(j, s, l1, i);
            }
        } while (true);
    }

    public PartialDriveId[] zzdC(int i)
    {
        return new PartialDriveId[i];
    }
}
