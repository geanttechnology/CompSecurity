// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.InvitationEntity;

// Referenced classes of package com.google.android.gms.games.internal.multiplayer:
//            ZInvitationCluster

public class InvitationClusterCreator
    implements android.os.Parcelable.Creator
{

    public InvitationClusterCreator()
    {
    }

    static void zza(ZInvitationCluster zinvitationcluster, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, zinvitationcluster.zzvq(), false);
        zzb.zzc(parcel, 1000, zinvitationcluster.getVersionCode());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeb(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgf(i);
    }

    public ZInvitationCluster zzeb(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, InvitationEntity.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ZInvitationCluster(i, arraylist);
            }
        } while (true);
    }

    public ZInvitationCluster[] zzgf(int i)
    {
        return new ZInvitationCluster[i];
    }
}
