// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.events:
//            ProgressEvent

public class zzh
    implements android.os.Parcelable.Creator
{

    public zzh()
    {
    }

    static void zza(ProgressEvent progressevent, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, progressevent.mVersionCode);
        zzb.zza(parcel, 2, progressevent.zzags, i, false);
        zzb.zzc(parcel, 3, progressevent.zzxJ);
        zzb.zza(parcel, 4, progressevent.zzahF);
        zzb.zza(parcel, 5, progressevent.zzahG);
        zzb.zzc(parcel, 6, progressevent.zzUS);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaI(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcq(i);
    }

    public ProgressEvent zzaI(Parcel parcel)
    {
        long l1 = 0L;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        DriveId driveid = null;
        long l2 = 0L;
        int j = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(i1))
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
                    l2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i1);
                    break;

                case 5: // '\005'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i1);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new ProgressEvent(k, driveid, j, l2, l1, i);
            }
        } while (true);
    }

    public ProgressEvent[] zzcq(int i)
    {
        return new ProgressEvent[i];
    }
}
