// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            WalletObjectMessage, TimeInterval, UriData

public class zzi
    implements android.os.Parcelable.Creator
{

    public zzi()
    {
    }

    static void zza(WalletObjectMessage walletobjectmessage, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, walletobjectmessage.getVersionCode());
        zzb.zza(parcel, 2, walletobjectmessage.zzaYE, false);
        zzb.zza(parcel, 3, walletobjectmessage.body, false);
        zzb.zza(parcel, 4, walletobjectmessage.zzaYH, i, false);
        zzb.zza(parcel, 5, walletobjectmessage.zzaYI, i, false);
        zzb.zza(parcel, 6, walletobjectmessage.zzaYJ, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzhk(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzks(i);
    }

    public WalletObjectMessage zzhk(Parcel parcel)
    {
        UriData uridata = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        UriData uridata1 = null;
        TimeInterval timeinterval = null;
        String s = null;
        String s1 = null;
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
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    timeinterval = (TimeInterval)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, TimeInterval.CREATOR);
                    break;

                case 5: // '\005'
                    uridata1 = (UriData)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, UriData.CREATOR);
                    break;

                case 6: // '\006'
                    uridata = (UriData)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, UriData.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new WalletObjectMessage(i, s1, s, timeinterval, uridata1, uridata);
            }
        } while (true);
    }

    public WalletObjectMessage[] zzks(int i)
    {
        return new WalletObjectMessage[i];
    }
}
