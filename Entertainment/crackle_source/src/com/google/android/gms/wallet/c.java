// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.wallet:
//            CountrySpecification

public class c
    implements android.os.Parcelable.Creator
{

    public c()
    {
    }

    static void a(CountrySpecification countryspecification, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, countryspecification.getVersionCode());
        b.a(parcel, 2, countryspecification.id, false);
        b.D(parcel, i);
    }

    public CountrySpecification aG(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
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
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new CountrySpecification(i, s);
            }
        } while (true);
    }

    public CountrySpecification[] by(int i)
    {
        return new CountrySpecification[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aG(parcel);
    }

    public Object[] newArray(int i)
    {
        return by(i);
    }
}
