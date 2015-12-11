// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class eu
    implements android.os.Parcelable.Creator
{

    public eu()
    {
    }

    static void a(ev.b b1, Parcel parcel, int i)
    {
        int j = b.o(parcel);
        b.c(parcel, 1, b1.versionCode);
        b.a(parcel, 2, b1.qw, false);
        b.a(parcel, 3, b1.qx, i, false);
        b.D(parcel, j);
    }

    public ev.b[] S(int i)
    {
        return new ev.b[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return u(parcel);
    }

    public Object[] newArray(int i)
    {
        return S(i);
    }

    public ev.b u(Parcel parcel)
    {
        es.a a1 = null;
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

                case 3: // '\003'
                    a1 = (es.a)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, es.a.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ev.b(i, s, a1);
            }
        } while (true);
    }
}
