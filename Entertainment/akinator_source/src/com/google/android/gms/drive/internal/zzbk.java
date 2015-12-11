// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OpenContentsRequest

public class zzbk
    implements android.os.Parcelable.Creator
{

    public zzbk()
    {
    }

    static void zza(OpenContentsRequest opencontentsrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, opencontentsrequest.mVersionCode);
        zzb.zza(parcel, 2, opencontentsrequest.zzakc, i, false);
        zzb.zzc(parcel, 3, opencontentsrequest.zzaiz);
        zzb.zzc(parcel, 4, opencontentsrequest.zzamo);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbF(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdr(i);
    }

    public OpenContentsRequest zzbF(Parcel parcel)
    {
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DriveId driveid = null;
        int j = 0;
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
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new OpenContentsRequest(k, driveid, j, i);
            }
        } while (true);
    }

    public OpenContentsRequest[] zzdr(int i)
    {
        return new OpenContentsRequest[i];
    }
}
