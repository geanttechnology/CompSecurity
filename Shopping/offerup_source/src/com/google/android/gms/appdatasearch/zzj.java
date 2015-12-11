// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            UsageInfo, DocumentId, DocumentContents

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(UsageInfo usageinfo, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, usageinfo.zzQU, i, false);
        zzb.zzc(parcel, 1000, usageinfo.mVersionCode);
        zzb.zza(parcel, 2, usageinfo.zzQV);
        zzb.zzc(parcel, 3, usageinfo.zzQW);
        zzb.zza(parcel, 4, usageinfo.zzub, false);
        zzb.zza(parcel, 5, usageinfo.zzQX, i, false);
        zzb.zza(parcel, 6, usageinfo.zzQY);
        zzb.zzc(parcel, 7, usageinfo.zzQZ);
        zzb.zzc(parcel, 8, usageinfo.zzRa);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzy(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzap(i);
    }

    public UsageInfo[] zzap(int i)
    {
        return new UsageInfo[i];
    }

    public UsageInfo zzy(Parcel parcel)
    {
        DocumentContents documentcontents = null;
        int i = 0;
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        long l1 = 0L;
        int j = -1;
        boolean flag = false;
        String s = null;
        int k = 0;
        DocumentId documentid = null;
        int l = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    documentid = (DocumentId)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, DocumentId.CREATOR);
                    break;

                case 1000: 
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, j1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, j1);
                    break;

                case 5: // '\005'
                    documentcontents = (DocumentContents)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, DocumentContents.CREATOR);
                    break;

                case 6: // '\006'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, j1);
                    break;

                case 7: // '\007'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 8: // '\b'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(i1).toString(), parcel);
            } else
            {
                return new UsageInfo(l, documentid, l1, k, s, documentcontents, flag, j, i);
            }
        } while (true);
    }
}
