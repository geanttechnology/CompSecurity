// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            LoadRealtimeRequest

public class zzar
    implements android.os.Parcelable.Creator
{

    public zzar()
    {
    }

    static void zza(LoadRealtimeRequest loadrealtimerequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, loadrealtimerequest.mVersionCode);
        zzb.zza(parcel, 2, loadrealtimerequest.zzaiA, i, false);
        zzb.zza(parcel, 3, loadrealtimerequest.zzalI);
        zzb.zzb(parcel, 4, loadrealtimerequest.zzalJ, false);
        zzb.zza(parcel, 5, loadrealtimerequest.zzalK);
        zzb.zza(parcel, 6, loadrealtimerequest.zzalL, i, false);
        zzb.zza(parcel, 7, loadrealtimerequest.zzalM, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbp(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdb(i);
    }

    public LoadRealtimeRequest zzbp(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DataHolder dataholder = null;
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        DriveId driveid = null;
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
                    driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DriveId.CREATOR);
                    break;

                case 3: // '\003'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 6: // '\006'
                    dataholder = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataHolder.CREATOR);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LoadRealtimeRequest(i, driveid, flag1, arraylist, flag, dataholder, s);
            }
        } while (true);
    }

    public LoadRealtimeRequest[] zzdb(int i)
    {
        return new LoadRealtimeRequest[i];
    }
}
