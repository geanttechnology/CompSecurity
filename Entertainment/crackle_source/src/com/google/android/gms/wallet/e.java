// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            FullWalletRequest, Cart

public class e
    implements android.os.Parcelable.Creator
{

    public e()
    {
    }

    static void a(FullWalletRequest fullwalletrequest, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, fullwalletrequest.getVersionCode());
        b.a(parcel, 2, fullwalletrequest.Gn, false);
        b.a(parcel, 3, fullwalletrequest.Go, false);
        b.a(parcel, 4, fullwalletrequest.Gu, i, false);
        b.D(parcel, j);
    }

    public FullWalletRequest aI(Parcel parcel)
    {
        Cart cart = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    break;

                case 4: // '\004'
                    cart = (Cart)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Cart.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new FullWalletRequest(i, s, s1, cart);
            }
        } while (true);
    }

    public FullWalletRequest[] bA(int i)
    {
        return new FullWalletRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aI(parcel);
    }

    public Object[] newArray(int i)
    {
        return bA(i);
    }
}
