// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.HashSet;
import java.util.Set;

public class im
    implements android.os.Parcelable.Creator
{

    public im()
    {
    }

    static void a(ig.c c, Parcel parcel, int i)
    {
        i = b.o(parcel);
        Set set = c.fa();
        if (set.contains(Integer.valueOf(1)))
        {
            b.c(parcel, 1, c.getVersionCode());
        }
        if (set.contains(Integer.valueOf(2)))
        {
            b.a(parcel, 2, c.getUrl(), true);
        }
        b.D(parcel, i);
    }

    public ig.c az(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        HashSet hashset = new HashSet();
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
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, k);
                    hashset.add(Integer.valueOf(2));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != j)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
                }
                return new ig.c(hashset, i, s);
            }
        } while (true);
    }

    public ig.c[] br(int i)
    {
        return new ig.c[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return az(parcel);
    }

    public Object[] newArray(int i)
    {
        return br(i);
    }
}
