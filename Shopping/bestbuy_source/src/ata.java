// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public class ata
    implements android.os.Parcelable.Creator
{

    public ata()
    {
    }

    public static void a(WalletFragmentStyle walletfragmentstyle, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, walletfragmentstyle.a);
        rq.a(parcel, 2, walletfragmentstyle.b, false);
        rq.a(parcel, 3, walletfragmentstyle.c);
        rq.a(parcel, i);
    }

    public WalletFragmentStyle a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        android.os.Bundle bundle = null;
        int i = 0;
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
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    bundle = ro.m(parcel, l);
                    break;

                case 3: // '\003'
                    j = ro.f(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new WalletFragmentStyle(i, bundle, j);
            }
        } while (true);
    }

    public WalletFragmentStyle[] a(int i)
    {
        return new WalletFragmentStyle[i];
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
