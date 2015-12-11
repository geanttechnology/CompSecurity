// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive:
//            RealtimeDocumentSyncRequest

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(RealtimeDocumentSyncRequest realtimedocumentsyncrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, realtimedocumentsyncrequest.mVersionCode);
        zzb.zzb(parcel, 2, realtimedocumentsyncrequest.zzajp, false);
        zzb.zzb(parcel, 3, realtimedocumentsyncrequest.zzajq, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaJ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzcp(i);
    }

    public RealtimeDocumentSyncRequest zzaJ(Parcel parcel)
    {
        java.util.ArrayList arraylist1 = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 3: // '\003'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new RealtimeDocumentSyncRequest(i, arraylist, arraylist1);
            }
        } while (true);
    }

    public RealtimeDocumentSyncRequest[] zzcp(int i)
    {
        return new RealtimeDocumentSyncRequest[i];
    }
}
