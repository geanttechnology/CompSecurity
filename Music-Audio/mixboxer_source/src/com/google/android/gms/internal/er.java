// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class er
    implements android.os.Parcelable.Creator
{

    public er()
    {
    }

    static void a(ep.a a1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, a1.versionCode);
        b.a(parcel, 2, a1.qg, false);
        b.c(parcel, 3, a1.qh);
        b.D(parcel, i);
    }

    public ep.a[] Q(int i)
    {
        return new ep.a[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return s(parcel);
    }

    public Object[] newArray(int i)
    {
        return Q(i);
    }

    public ep.a s(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        String s1 = null;
        int i = 0;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ep.a(i, s1, j);
            }
        } while (true);
    }
}
