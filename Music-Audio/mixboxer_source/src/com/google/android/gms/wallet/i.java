// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, Cart, CountrySpecification

public class i
    implements android.os.Parcelable.Creator
{

    public i()
    {
    }

    static void a(MaskedWalletRequest maskedwalletrequest, Parcel parcel, int j)
    {
        int k = b.o(parcel);
        b.c(parcel, 1, maskedwalletrequest.getVersionCode());
        b.a(parcel, 2, maskedwalletrequest.Go, false);
        b.a(parcel, 3, maskedwalletrequest.GK);
        b.a(parcel, 4, maskedwalletrequest.GL);
        b.a(parcel, 5, maskedwalletrequest.GM);
        b.a(parcel, 6, maskedwalletrequest.GN, false);
        b.a(parcel, 7, maskedwalletrequest.Gk, false);
        b.a(parcel, 8, maskedwalletrequest.GO, false);
        b.a(parcel, 9, maskedwalletrequest.Gu, j, false);
        b.a(parcel, 10, maskedwalletrequest.GP);
        b.a(parcel, 11, maskedwalletrequest.GQ);
        b.a(parcel, 12, maskedwalletrequest.GR, j, false);
        b.a(parcel, 13, maskedwalletrequest.GS);
        b.a(parcel, 14, maskedwalletrequest.GT);
        b.D(parcel, k);
    }

    public MaskedWalletRequest aM(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int j = 0;
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
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 3: // '\003'
                    flag6 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 4: // '\004'
                    flag5 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 5: // '\005'
                    flag4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 9: // '\t'
                    cart = (Cart)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, Cart.CREATOR);
                    break;

                case 10: // '\n'
                    flag3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 11: // '\013'
                    flag2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 12: // '\f'
                    acountryspecification = (CountrySpecification[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, l, CountrySpecification.CREATOR);
                    break;

                case 13: // '\r'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 14: // '\016'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new MaskedWalletRequest(j, s3, flag6, flag5, flag4, s2, s1, s, cart, flag3, flag2, acountryspecification, flag1, flag);
            }
        } while (true);
    }

    public MaskedWalletRequest[] bE(int j)
    {
        return new MaskedWalletRequest[j];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aM(parcel);
    }

    public Object[] newArray(int j)
    {
        return bE(j);
    }
}
