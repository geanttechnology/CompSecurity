// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.drive:
//            Contents, DriveId

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(Contents contents, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, contents.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, contents.zzadS, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, contents.zzaiy);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, contents.zzaiz);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, contents.zzaiA, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, contents.zzaiB);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, contents.zzrW, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaD(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcf(i);
    }

    public Contents zzaD(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DriveId driveid = null;
        int i = 0;
        int j = 0;
        ParcelFileDescriptor parcelfiledescriptor = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                case 6: // '\006'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    parcelfiledescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, ParcelFileDescriptor.CREATOR);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 5: // '\005'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, DriveId.CREATOR);
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new Contents(k, parcelfiledescriptor, j, i, driveid, flag, s);
            }
        } while (true);
    }

    public Contents[] zzcf(int i)
    {
        return new Contents[i];
    }
}
