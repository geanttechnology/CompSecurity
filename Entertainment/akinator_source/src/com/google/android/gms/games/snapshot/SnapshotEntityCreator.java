// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotEntity, SnapshotMetadataEntity, SnapshotContentsEntity

public class SnapshotEntityCreator
    implements android.os.Parcelable.Creator
{

    public SnapshotEntityCreator()
    {
    }

    static void zza(SnapshotEntity snapshotentity, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, snapshotentity.getMetadata(), i, false);
        zzb.zzc(parcel, 1000, snapshotentity.getVersionCode());
        zzb.zza(parcel, 3, snapshotentity.getSnapshotContents(), i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeo(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgv(i);
    }

    public SnapshotEntity zzeo(Parcel parcel)
    {
        SnapshotContentsEntity snapshotcontentsentity = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        SnapshotMetadataEntity snapshotmetadataentity = null;
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
                    snapshotmetadataentity = (SnapshotMetadataEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, SnapshotMetadataEntity.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 3: // '\003'
                    snapshotcontentsentity = (SnapshotContentsEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, SnapshotContentsEntity.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SnapshotEntity(i, snapshotmetadataentity, snapshotcontentsentity);
            }
        } while (true);
    }

    public SnapshotEntity[] zzgv(int i)
    {
        return new SnapshotEntity[i];
    }
}
