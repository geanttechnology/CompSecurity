// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class il
    implements android.os.Parcelable.Creator
{

    public il()
    {
    }

    static void a(ig.b.b b1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        Set set = b1.fa();
        if (set.contains(Integer.valueOf(1)))
        {
            b.c(parcel, 1, b1.getVersionCode());
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.c(parcel, 2, b1.getHeight());
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.a(parcel, 3, b1.getUrl(), true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            b.c(parcel, 4, b1.getWidth());
        }
        b.D(parcel, i);
    }

    public ig.b.b ay(Parcel parcel)
    {
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        HashSet hashset = new HashSet();
        String s = null;
        int j = 0;
        int k = 0;
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
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(4));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
                }
                return new ig.b.b(hashset, k, j, s, i);
            }
        } while (true);
    }

    public ig.b.b[] bq(int i)
    {
        return new ig.b.b[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return ay(parcel);
    }

    public Object[] newArray(int i)
    {
        return bq(i);
    }
}
