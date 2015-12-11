// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;

// Referenced classes of package com.google.android.gms.drive.internal:
//            GetChangesRequest

public class zzah
    implements android.os.Parcelable.Creator
{

    public zzah()
    {
    }

    static void zza(GetChangesRequest getchangesrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, getchangesrequest.mVersionCode);
        zzb.zza(parcel, 2, getchangesrequest.zzalA, i, false);
        zzb.zzc(parcel, 3, getchangesrequest.zzalB);
        zzb.zzc(parcel, 4, getchangesrequest.zzajA, false);
        zzb.zza(parcel, 5, getchangesrequest.zzalC);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbj(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcV(i);
    }

    public GetChangesRequest zzbj(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        boolean flag = false;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        ChangeSequenceNumber changesequencenumber = null;
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
                    changesequencenumber = (ChangeSequenceNumber)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, ChangeSequenceNumber.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 4: // '\004'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, DriveSpace.CREATOR);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GetChangesRequest(j, changesequencenumber, i, arraylist, flag);
            }
        } while (true);
    }

    public GetChangesRequest[] zzcV(int i)
    {
        return new GetChangesRequest[i];
    }
}
