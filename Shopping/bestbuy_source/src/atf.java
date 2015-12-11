// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class atf
    implements android.os.Parcelable.Creator
{

    public atf()
    {
    }

    public static void a(MaskedWalletRequest maskedwalletrequest, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, maskedwalletrequest.a());
        rq.a(parcel, 2, maskedwalletrequest.a, false);
        rq.a(parcel, 3, maskedwalletrequest.b);
        rq.a(parcel, 4, maskedwalletrequest.c);
        rq.a(parcel, 5, maskedwalletrequest.d);
        rq.a(parcel, 6, maskedwalletrequest.e, false);
        rq.a(parcel, 7, maskedwalletrequest.f, false);
        rq.a(parcel, 8, maskedwalletrequest.g, false);
        rq.a(parcel, 9, maskedwalletrequest.h, i, false);
        rq.a(parcel, 10, maskedwalletrequest.i);
        rq.a(parcel, 11, maskedwalletrequest.j);
        rq.a(parcel, 12, maskedwalletrequest.k, i, false);
        rq.a(parcel, 13, maskedwalletrequest.l);
        rq.a(parcel, 14, maskedwalletrequest.m);
        rq.b(parcel, 15, maskedwalletrequest.n, false);
        rq.a(parcel, j);
    }

    public MaskedWalletRequest a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        String s3 = null;
        boolean flag6 = false;
        boolean flag5 = false;
        boolean flag4 = false;
        String s2 = null;
        String s1 = null;
        String s = null;
        Cart cart = null;
        boolean flag3 = false;
        boolean flag2 = false;
        CountrySpecification acountryspecification[] = null;
        boolean flag1 = true;
        boolean flag = true;
        java.util.ArrayList arraylist = null;
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
                    s3 = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    flag6 = ro.c(parcel, k);
                    break;

                case 4: // '\004'
                    flag5 = ro.c(parcel, k);
                    break;

                case 5: // '\005'
                    flag4 = ro.c(parcel, k);
                    break;

                case 6: // '\006'
                    s2 = ro.k(parcel, k);
                    break;

                case 7: // '\007'
                    s1 = ro.k(parcel, k);
                    break;

                case 8: // '\b'
                    s = ro.k(parcel, k);
                    break;

                case 9: // '\t'
                    cart = (Cart)ro.a(parcel, k, Cart.CREATOR);
                    break;

                case 10: // '\n'
                    flag3 = ro.c(parcel, k);
                    break;

                case 11: // '\013'
                    flag2 = ro.c(parcel, k);
                    break;

                case 12: // '\f'
                    acountryspecification = (CountrySpecification[])ro.b(parcel, k, CountrySpecification.CREATOR);
                    break;

                case 13: // '\r'
                    flag1 = ro.c(parcel, k);
                    break;

                case 14: // '\016'
                    flag = ro.c(parcel, k);
                    break;

                case 15: // '\017'
                    arraylist = ro.c(parcel, k, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new MaskedWalletRequest(i, s3, flag6, flag5, flag4, s2, s1, s, cart, flag3, flag2, acountryspecification, flag1, flag, arraylist);
            }
        } while (true);
    }

    public MaskedWalletRequest[] a(int i)
    {
        return new MaskedWalletRequest[i];
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
