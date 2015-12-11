// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public class asz
    implements android.os.Parcelable.Creator
{

    public asz()
    {
    }

    public static void a(WalletFragmentOptions walletfragmentoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, walletfragmentoptions.a);
        rq.a(parcel, 2, walletfragmentoptions.a());
        rq.a(parcel, 3, walletfragmentoptions.b());
        rq.a(parcel, 4, walletfragmentoptions.c(), i, false);
        rq.a(parcel, 5, walletfragmentoptions.d());
        rq.a(parcel, j);
    }

    public WalletFragmentOptions a(Parcel parcel)
    {
        int i = 1;
        int j = 0;
        int i1 = ro.b(parcel);
        WalletFragmentStyle walletfragmentstyle = null;
        int k = 1;
        int l = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = ro.a(parcel);
                switch (ro.a(j1))
                {
                default:
                    ro.b(parcel, j1);
                    break;

                case 1: // '\001'
                    l = ro.f(parcel, j1);
                    break;

                case 2: // '\002'
                    k = ro.f(parcel, j1);
                    break;

                case 3: // '\003'
                    j = ro.f(parcel, j1);
                    break;

                case 4: // '\004'
                    walletfragmentstyle = (WalletFragmentStyle)ro.a(parcel, j1, WalletFragmentStyle.CREATOR);
                    break;

                case 5: // '\005'
                    i = ro.f(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new WalletFragmentOptions(l, k, j, walletfragmentstyle, i);
            }
        } while (true);
    }

    public WalletFragmentOptions[] a(int i)
    {
        return new WalletFragmentOptions[i];
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
