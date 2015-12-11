// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            hb, hd

public class hc
    implements android.os.Parcelable.Creator
{

    public hc()
    {
    }

    static void a(hb hb1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.a(parcel, 1, hb1.dU(), i, false);
        b.c(parcel, 1000, hb1.kg);
        b.a(parcel, 2, hb1.dV(), false);
        b.a(parcel, 3, hb1.getTimestampMillis());
        b.D(parcel, j);
    }

    public hb an(Parcel parcel)
    {
        float af[] = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        long l = 0L;
        hd ahd[] = null;
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
                    ahd = (hd[])com.google.android.gms.common.internal.safeparcel.a.b(parcel, k, hd.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    af = com.google.android.gms.common.internal.safeparcel.a.u(parcel, k);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.a.h(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new hb(i, ahd, af, l);
            }
        } while (true);
    }

    public hb[] bc(int i)
    {
        return new hb[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return an(parcel);
    }

    public Object[] newArray(int i)
    {
        return bc(i);
    }
}
