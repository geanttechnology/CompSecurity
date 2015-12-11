// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class ik
    implements android.os.Parcelable.Creator
{

    public ik()
    {
    }

    static void a(ig.b.a a1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        Set set = a1.fa();
        if (set.contains(Integer.valueOf(1)))
        {
            b.c(parcel, 1, a1.getVersionCode());
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.c(parcel, 2, a1.getLeftImageOffset());
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.c(parcel, 3, a1.getTopImageOffset());
        }
        b.D(parcel, i);
    }

    public ig.b.a ax(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        int i = 0;
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
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
                }
                return new ig.b.a(hashset, i, j, k);
            }
        } while (true);
    }

    public ig.b.a[] bp(int i)
    {
        return new ig.b.a[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ax(parcel);
    }

    public Object[] newArray(int i)
    {
        return bp(i);
    }
}
