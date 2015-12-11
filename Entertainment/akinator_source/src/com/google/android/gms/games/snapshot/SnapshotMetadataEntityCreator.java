// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

// Referenced classes of package com.google.android.gms.games.snapshot:
//            SnapshotMetadataEntity

public class SnapshotMetadataEntityCreator
    implements android.os.Parcelable.Creator
{

    public SnapshotMetadataEntityCreator()
    {
    }

    static void zza(SnapshotMetadataEntity snapshotmetadataentity, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, snapshotmetadataentity.getGame(), i, false);
        zzb.zzc(parcel, 1000, snapshotmetadataentity.getVersionCode());
        zzb.zza(parcel, 2, snapshotmetadataentity.getOwner(), i, false);
        zzb.zza(parcel, 3, snapshotmetadataentity.getSnapshotId(), false);
        zzb.zza(parcel, 5, snapshotmetadataentity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 6, snapshotmetadataentity.getCoverImageUrl(), false);
        zzb.zza(parcel, 7, snapshotmetadataentity.getTitle(), false);
        zzb.zza(parcel, 8, snapshotmetadataentity.getDescription(), false);
        zzb.zza(parcel, 9, snapshotmetadataentity.getLastModifiedTimestamp());
        zzb.zza(parcel, 10, snapshotmetadataentity.getPlayedTime());
        zzb.zza(parcel, 11, snapshotmetadataentity.getCoverImageAspectRatio());
        zzb.zza(parcel, 12, snapshotmetadataentity.getUniqueName(), false);
        zzb.zza(parcel, 13, snapshotmetadataentity.hasChangePending());
        zzb.zza(parcel, 14, snapshotmetadataentity.getProgressValue());
        zzb.zza(parcel, 15, snapshotmetadataentity.getDeviceName(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeq(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgx(i);
    }

    public SnapshotMetadataEntity zzeq(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        GameEntity gameentity = null;
        PlayerEntity playerentity = null;
        String s5 = null;
        Uri uri = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        long l2 = 0L;
        long l1 = 0L;
        float f = 0.0F;
        String s1 = null;
        boolean flag = false;
        long l = 0L;
        String s = null;
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
                    gameentity = (GameEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, GameEntity.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    playerentity = (PlayerEntity)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, PlayerEntity.CREATOR);
                    break;

                case 3: // '\003'
                    s5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 5: // '\005'
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Uri.CREATOR);
                    break;

                case 6: // '\006'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 7: // '\007'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 8: // '\b'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 9: // '\t'
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 10: // '\n'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 11: // '\013'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, k);
                    break;

                case 12: // '\f'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 13: // '\r'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 14: // '\016'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 15: // '\017'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new SnapshotMetadataEntity(i, gameentity, playerentity, s5, uri, s4, s3, s2, l2, l1, f, s1, flag, l, s);
            }
        } while (true);
    }

    public SnapshotMetadataEntity[] zzgx(int i)
    {
        return new SnapshotMetadataEntity[i];
    }
}
