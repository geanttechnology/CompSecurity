// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;

// Referenced classes of package com.google.android.gms.drive.internal:
//            GetPermissionsResponse

public class zzal
    implements android.os.Parcelable.Creator
{

    public zzal()
    {
    }

    static void zza(GetPermissionsResponse getpermissionsresponse, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, getpermissionsresponse.mVersionCode);
        zzb.zzc(parcel, 2, getpermissionsresponse.zzalG, false);
        zzb.zzc(parcel, 3, getpermissionsresponse.zzxM);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzbn(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcZ(i);
    }

    public GetPermissionsResponse zzbn(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        int i = 0;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, Permission.CREATOR);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GetPermissionsResponse(i, arraylist, j);
            }
        } while (true);
    }

    public GetPermissionsResponse[] zzcZ(int i)
    {
        return new GetPermissionsResponse[i];
    }
}
