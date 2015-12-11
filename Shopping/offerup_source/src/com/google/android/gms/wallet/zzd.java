// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wallet:
//            CreateWalletObjectsRequest, LoyaltyWalletObject, OfferWalletObject, GiftCardWalletObject

public class zzd
    implements android.os.Parcelable.Creator
{

    public zzd()
    {
    }

    static void zza(CreateWalletObjectsRequest createwalletobjectsrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, createwalletobjectsrequest.getVersionCode());
        zzb.zza(parcel, 2, createwalletobjectsrequest.zzbcm, i, false);
        zzb.zza(parcel, 3, createwalletobjectsrequest.zzbcn, i, false);
        zzb.zza(parcel, 4, createwalletobjectsrequest.zzbco, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgZ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzkc(i);
    }

    public CreateWalletObjectsRequest zzgZ(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        OfferWalletObject offerwalletobject = null;
        LoyaltyWalletObject loyaltywalletobject = null;
        int i = 0;
        GiftCardWalletObject giftcardwalletobject = null;
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
                    loyaltywalletobject = (LoyaltyWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, LoyaltyWalletObject.CREATOR);
                    break;

                case 3: // '\003'
                    offerwalletobject = (OfferWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, OfferWalletObject.CREATOR);
                    break;

                case 4: // '\004'
                    giftcardwalletobject = (GiftCardWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, GiftCardWalletObject.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new CreateWalletObjectsRequest(i, loyaltywalletobject, offerwalletobject, giftcardwalletobject);
            }
        } while (true);
    }

    public CreateWalletObjectsRequest[] zzkc(int i)
    {
        return new CreateWalletObjectsRequest[i];
    }
}
