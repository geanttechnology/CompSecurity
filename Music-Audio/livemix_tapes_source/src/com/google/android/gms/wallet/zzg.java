// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

// Referenced classes of package com.google.android.gms.wallet:
//            GiftCardWalletObject

public class zzg
    implements android.os.Parcelable.Creator
{

    public zzg()
    {
    }

    static void zza(GiftCardWalletObject giftcardwalletobject, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, giftcardwalletobject.getVersionCode());
        zzb.zza(parcel, 2, giftcardwalletobject.zzaWv, i, false);
        zzb.zza(parcel, 3, giftcardwalletobject.zzaWw, false);
        zzb.zza(parcel, 4, giftcardwalletobject.pin, false);
        zzb.zza(parcel, 5, giftcardwalletobject.zzaWx, false);
        zzb.zza(parcel, 6, giftcardwalletobject.zzaWy);
        zzb.zza(parcel, 7, giftcardwalletobject.zzaWz, false);
        zzb.zza(parcel, 8, giftcardwalletobject.zzaWA);
        zzb.zza(parcel, 9, giftcardwalletobject.zzaWB, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgK(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjP(i);
    }

    public GiftCardWalletObject zzgK(Parcel parcel)
    {
        long l = 0L;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s1 = null;
        long l1 = 0L;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        CommonWalletObject commonwalletobject = null;
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
                    commonwalletobject = (CommonWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, CommonWalletObject.CREATOR);
                    break;

                case 3: // '\003'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 5: // '\005'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 6: // '\006'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 8: // '\b'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 9: // '\t'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new GiftCardWalletObject(i, commonwalletobject, s4, s3, s2, l1, s1, l, s);
            }
        } while (true);
    }

    public GiftCardWalletObject[] zzjP(int i)
    {
        return new GiftCardWalletObject[i];
    }
}
