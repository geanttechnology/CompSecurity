// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CreateFolderRequest

public class zzo
    implements android.os.Parcelable.Creator
{

    public zzo()
    {
    }

    static void zza(CreateFolderRequest createfolderrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createfolderrequest.mVersionCode);
        zzb.zza(parcel, 2, createfolderrequest.zzakq, i, false);
        zzb.zza(parcel, 3, createfolderrequest.zzako, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbd(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcL(i);
    }

    public CreateFolderRequest zzbd(Parcel parcel)
    {
        MetadataBundle metadatabundle = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        DriveId driveid = null;
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
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    metadatabundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, MetadataBundle.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new CreateFolderRequest(i, driveid, metadatabundle);
            }
        } while (true);
    }

    public CreateFolderRequest[] zzcL(int i)
    {
        return new CreateFolderRequest[i];
    }
}
