// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class hw
    implements android.os.Parcelable.Creator
{

    public hw()
    {
    }

    static void a(hx.a a1, Parcel parcel, int i)
    {
        i = b.p(parcel);
        b.a(parcel, 1, a1.gt(), false);
        b.c(parcel, 1000, a1.wj);
        b.a(parcel, 2, a1.getTag(), false);
        b.a(parcel, 3, a1.gH(), false);
        b.c(parcel, 4, a1.gI());
        b.D(parcel, i);
    }

    public hx.a aA(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        String s1 = null;
        String s2 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new hx.a(j, s2, s1, s, i);
            }
        } while (true);
    }

    public hx.a[] bu(int i)
    {
        return new hx.a[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aA(parcel);
    }

    public Object[] newArray(int i)
    {
        return bu(i);
    }
}
