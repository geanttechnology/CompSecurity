// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.location:
//            d

public class e
    implements android.os.Parcelable.Creator
{

    public e()
    {
    }

    static void a(d d1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, d1.xG);
        b.c(parcel, 1000, d1.getVersionCode());
        b.c(parcel, 2, d1.xH);
        b.a(parcel, 3, d1.xI);
        b.D(parcel, i);
    }

    public d[] aS(int i)
    {
        return new d[i];
    }

    public d af(Parcel parcel)
    {
        int i = 1;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int k = 0;
        long l1 = 0L;
        int j = 1;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 1000: 
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 2: // '\002'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new d(k, j, i, l1);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return af(parcel);
    }

    public Object[] newArray(int i)
    {
        return aS(i);
    }
}
