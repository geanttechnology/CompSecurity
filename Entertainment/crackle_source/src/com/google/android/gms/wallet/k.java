// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            OfferWalletObject

public class k
    implements android.os.Parcelable.Creator
{

    public k()
    {
    }

    static void a(OfferWalletObject offerwalletobject, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, offerwalletobject.getVersionCode());
        b.a(parcel, 2, offerwalletobject.GA, false);
        b.a(parcel, 3, offerwalletobject.GX, false);
        b.D(parcel, i);
    }

    public OfferWalletObject aO(Parcel parcel)
    {
        String s1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OfferWalletObject(i, s, s1);
            }
        } while (true);
    }

    public OfferWalletObject[] bG(int i)
    {
        return new OfferWalletObject[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aO(parcel);
    }

    public Object[] newArray(int i)
    {
        return bG(i);
    }
}
