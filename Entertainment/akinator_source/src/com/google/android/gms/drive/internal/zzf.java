// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            ChangeResourceParentsRequest

public class zzf
    implements android.os.Parcelable.Creator
{

    public zzf()
    {
    }

    static void zza(ChangeResourceParentsRequest changeresourceparentsrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, changeresourceparentsrequest.mVersionCode);
        zzb.zza(parcel, 2, changeresourceparentsrequest.zzajY, i, false);
        zzb.zzc(parcel, 3, changeresourceparentsrequest.zzajZ, false);
        zzb.zzc(parcel, 4, changeresourceparentsrequest.zzaka, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaV(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcC(i);
    }

    public ChangeResourceParentsRequest zzaV(Parcel parcel)
    {
        java.util.ArrayList arraylist;
        Object obj;
        Object obj1;
        int i;
        int j;
        arraylist = null;
        j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        i = 0;
        obj1 = null;
        obj = null;
_L7:
        int k;
        if (parcel.dataPosition() >= j)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
        com.google.android.gms.common.internal.safeparcel.zza.zzbM(k);
        JVM INSTR tableswitch 1 4: default 68
    //                   1 97
    //                   2 118
    //                   3 142
    //                   4 162;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_162;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
        Object obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L8:
        Object obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        DriveId driveid = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DriveId.CREATOR);
        obj = obj1;
        obj1 = driveid;
          goto _L8
_L4:
        java.util.ArrayList arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DriveId.CREATOR);
        obj1 = obj;
        obj = arraylist1;
          goto _L8
        arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DriveId.CREATOR);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L8
        if (parcel.dataPosition() != j)
        {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
        } else
        {
            return new ChangeResourceParentsRequest(i, ((DriveId) (obj)), ((java.util.List) (obj1)), arraylist);
        }
    }

    public ChangeResourceParentsRequest[] zzcC(int i)
    {
        return new ChangeResourceParentsRequest[i];
    }
}
