// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;

public class asy
    implements android.os.Parcelable.Creator
{

    public asy()
    {
    }

    public static void a(WalletFragmentInitParams walletfragmentinitparams, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, walletfragmentinitparams.a);
        rq.a(parcel, 2, walletfragmentinitparams.a(), false);
        rq.a(parcel, 3, walletfragmentinitparams.b(), i, false);
        rq.a(parcel, 4, walletfragmentinitparams.c());
        rq.a(parcel, 5, walletfragmentinitparams.d(), i, false);
        rq.a(parcel, j);
    }

    public WalletFragmentInitParams a(Parcel parcel)
    {
        MaskedWallet maskedwallet = null;
        int k = ro.b(parcel);
        int j = 0;
        int i = -1;
        MaskedWalletRequest maskedwalletrequest = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, l);
                    break;

                case 3: // '\003'
                    maskedwalletrequest = (MaskedWalletRequest)ro.a(parcel, l, MaskedWalletRequest.CREATOR);
                    break;

                case 4: // '\004'
                    i = ro.f(parcel, l);
                    break;

                case 5: // '\005'
                    maskedwallet = (MaskedWallet)ro.a(parcel, l, MaskedWallet.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new WalletFragmentInitParams(j, s, maskedwalletrequest, i, maskedwallet);
            }
        } while (true);
    }

    public WalletFragmentInitParams[] a(int i)
    {
        return new WalletFragmentInitParams[i];
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
