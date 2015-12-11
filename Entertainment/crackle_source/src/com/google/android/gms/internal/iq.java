// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class iq
    implements android.os.Parcelable.Creator
{

    public iq()
    {
    }

    static void a(ig.h h, Parcel parcel, int i)
    {
        i = b.o(parcel);
        Set set = h.fa();
        if (set.contains(Integer.valueOf(1)))
        {
            b.c(parcel, 1, h.getVersionCode());
        }
        if (set.contains(Integer.valueOf(3)))
        {
            b.c(parcel, 3, h.fN());
        }
        if (set.contains(Integer.valueOf(4)))
        {
            b.a(parcel, 4, h.getValue(), true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            b.a(parcel, 5, h.getLabel(), true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            b.c(parcel, 6, h.getType());
        }
        b.D(parcel, i);
    }

    public ig.h aD(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        String s1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(i1))
                {
                case 2: // '\002'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    hashset.add(Integer.valueOf(6));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
                }
                return new ig.h(hashset, k, s1, j, s, i);
            }
        } while (true);
    }

    public ig.h[] bv(int i)
    {
        return new ig.h[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return aD(parcel);
    }

    public Object[] newArray(int i)
    {
        return bv(i);
    }
}
