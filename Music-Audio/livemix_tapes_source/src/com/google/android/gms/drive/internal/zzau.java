// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnChangesResponse

public class zzau
    implements android.os.Parcelable.Creator
{

    public zzau()
    {
    }

    static void zza(OnChangesResponse onchangesresponse, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, onchangesresponse.mVersionCode);
        zzb.zza(parcel, 2, onchangesresponse.zzajE, i, false);
        zzb.zzc(parcel, 3, onchangesresponse.zzajF, false);
        zzb.zza(parcel, 4, onchangesresponse.zzajG, i, false);
        zzb.zza(parcel, 5, onchangesresponse.zzajH);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbi(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcW(i);
    }

    public OnChangesResponse zzbi(Parcel parcel)
    {
        boolean flag = false;
        ChangeSequenceNumber changesequencenumber = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        java.util.ArrayList arraylist = null;
        DataHolder dataholder = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    dataholder = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataHolder.CREATOR);
                    break;

                case 3: // '\003'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DriveId.CREATOR);
                    break;

                case 4: // '\004'
                    changesequencenumber = (ChangeSequenceNumber)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, ChangeSequenceNumber.CREATOR);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnChangesResponse(i, dataholder, arraylist, changesequencenumber, flag);
            }
        } while (true);
    }

    public OnChangesResponse[] zzcW(int i)
    {
        return new OnChangesResponse[i];
    }
}
