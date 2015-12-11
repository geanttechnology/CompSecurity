// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.OfferWalletObject;

public class ate
    implements android.os.Parcelable.Creator
{

    public ate()
    {
    }

    public static void a(MaskedWallet maskedwallet, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, maskedwallet.a());
        rq.a(parcel, 2, maskedwallet.a, false);
        rq.a(parcel, 3, maskedwallet.b, false);
        rq.a(parcel, 4, maskedwallet.c, false);
        rq.a(parcel, 5, maskedwallet.d, false);
        rq.a(parcel, 6, maskedwallet.e, i, false);
        rq.a(parcel, 7, maskedwallet.f, i, false);
        rq.a(parcel, 8, maskedwallet.g, i, false);
        rq.a(parcel, 9, maskedwallet.h, i, false);
        rq.a(parcel, 10, maskedwallet.i, i, false);
        rq.a(parcel, 11, maskedwallet.j, i, false);
        rq.a(parcel, 12, maskedwallet.k, i, false);
        rq.a(parcel, j);
    }

    public MaskedWallet a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        String s2 = null;
        String s1 = null;
        String as[] = null;
        String s = null;
        Address address1 = null;
        Address address = null;
        LoyaltyWalletObject aloyaltywalletobject[] = null;
        OfferWalletObject aofferwalletobject[] = null;
        UserAddress useraddress1 = null;
        UserAddress useraddress = null;
        InstrumentInfo ainstrumentinfo[] = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = ro.a(parcel);
                switch (ro.a(k))
                {
                default:
                    ro.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    s2 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    as = ro.o(parcel, k);
                    break;

                case 5: // '\005'
                    s = ro.k(parcel, k);
                    break;

                case 6: // '\006'
                    address1 = (Address)ro.a(parcel, k, Address.CREATOR);
                    break;

                case 7: // '\007'
                    address = (Address)ro.a(parcel, k, Address.CREATOR);
                    break;

                case 8: // '\b'
                    aloyaltywalletobject = (LoyaltyWalletObject[])ro.b(parcel, k, LoyaltyWalletObject.CREATOR);
                    break;

                case 9: // '\t'
                    aofferwalletobject = (OfferWalletObject[])ro.b(parcel, k, OfferWalletObject.CREATOR);
                    break;

                case 10: // '\n'
                    useraddress1 = (UserAddress)ro.a(parcel, k, UserAddress.CREATOR);
                    break;

                case 11: // '\013'
                    useraddress = (UserAddress)ro.a(parcel, k, UserAddress.CREATOR);
                    break;

                case 12: // '\f'
                    ainstrumentinfo = (InstrumentInfo[])ro.b(parcel, k, InstrumentInfo.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new MaskedWallet(i, s2, s1, as, s, address1, address, aloyaltywalletobject, aofferwalletobject, useraddress1, useraddress, ainstrumentinfo);
            }
        } while (true);
    }

    public MaskedWallet[] a(int i)
    {
        return new MaskedWallet[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
