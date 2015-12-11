// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.wallet:
//            MaskedWalletRequest, Cart, CountrySpecification

public final class i
    implements android.os.Parcelable.Creator
{

    public i()
    {
    }

    static void a(MaskedWalletRequest maskedwalletrequest, Parcel parcel, int j)
    {
        int k = c.a(parcel, 20293);
        c.b(parcel, 1, maskedwalletrequest.a);
        c.a(parcel, 2, maskedwalletrequest.b, false);
        c.a(parcel, 3, maskedwalletrequest.c);
        c.a(parcel, 4, maskedwalletrequest.d);
        c.a(parcel, 5, maskedwalletrequest.e);
        c.a(parcel, 6, maskedwalletrequest.f, false);
        c.a(parcel, 7, maskedwalletrequest.g, false);
        c.a(parcel, 8, maskedwalletrequest.h, false);
        c.a(parcel, 9, maskedwalletrequest.i, j, false);
        c.a(parcel, 10, maskedwalletrequest.j);
        c.a(parcel, 11, maskedwalletrequest.k);
        c.a(parcel, 12, maskedwalletrequest.l, j);
        c.a(parcel, 13, maskedwalletrequest.m);
        c.a(parcel, 14, maskedwalletrequest.n);
        c.b(parcel, k);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
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
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    break;

                case 2: // '\002'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
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
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 7: // '\007'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
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
                throw new b((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new MaskedWalletRequest(j, s3, flag6, flag5, flag4, s2, s1, s, cart, flag3, flag2, acountryspecification, flag1, flag);
            }
        } while (true);
    }

    public final Object[] newArray(int j)
    {
        return new MaskedWalletRequest[j];
    }
}
