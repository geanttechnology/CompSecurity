// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(DataHolder dataholder, Parcel parcel, int i)
    {
        int j = zzb.zzM(parcel);
        zzb.zza(parcel, 1, dataholder.zzlr(), false);
        zzb.zzc(parcel, 1000, dataholder.getVersionCode());
        zzb.zza(parcel, 2, dataholder.zzls(), i, false);
        zzb.zzc(parcel, 3, dataholder.getStatusCode());
        zzb.zza(parcel, 4, dataholder.zzlm(), false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzC(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaF(i);
    }

    public DataHolder zzC(Parcel parcel)
    {
        int i = 0;
        android.os.Bundle bundle = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzL(parcel);
        CursorWindow acursorwindow[] = null;
        String as[] = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzK(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaV(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    as = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    acursorwindow = (CursorWindow[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l, CursorWindow.CREATOR);
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 4: // '\004'
                    bundle = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                parcel = new DataHolder(j, as, acursorwindow, i, bundle);
                parcel.zzlq();
                return parcel;
            }
        } while (true);
    }

    public DataHolder[] zzaF(int i)
    {
        return new DataHolder[i];
    }
}
