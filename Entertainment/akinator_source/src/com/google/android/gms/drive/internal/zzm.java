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
//            CreateFileIntentSenderRequest

public class zzm
    implements android.os.Parcelable.Creator
{

    public zzm()
    {
    }

    static void zza(CreateFileIntentSenderRequest createfileintentsenderrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createfileintentsenderrequest.mVersionCode);
        zzb.zza(parcel, 2, createfileintentsenderrequest.zzako, i, false);
        zzb.zzc(parcel, 3, createfileintentsenderrequest.zzaiy);
        zzb.zza(parcel, 4, createfileintentsenderrequest.zzajf, false);
        zzb.zza(parcel, 5, createfileintentsenderrequest.zzaji, i, false);
        zzb.zza(parcel, 6, createfileintentsenderrequest.zzakp, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbb(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcJ(i);
    }

    public CreateFileIntentSenderRequest zzbb(Parcel parcel)
    {
        int i = 0;
        Integer integer = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DriveId driveid = null;
        String s = null;
        MetadataBundle metadatabundle = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    metadatabundle = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, MetadataBundle.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 5: // '\005'
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, DriveId.CREATOR);
                    break;

                case 6: // '\006'
                    integer = com.google.android.gms.common.internal.safeparcel.zza.zzh(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new CreateFileIntentSenderRequest(j, metadatabundle, i, s, driveid, integer);
            }
        } while (true);
    }

    public CreateFileIntentSenderRequest[] zzcJ(int i)
    {
        return new CreateFileIntentSenderRequest[i];
    }
}
