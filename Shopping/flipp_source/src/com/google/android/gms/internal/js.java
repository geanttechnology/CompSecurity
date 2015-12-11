// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            ig

public final class js
    implements android.os.Parcelable.Creator
{

    public js()
    {
    }

    static void a(ig ig1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        Set set = ig1.a;
        if (set.contains(Integer.valueOf(1)))
        {
            c.b(parcel, 1, ig1.b);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            c.a(parcel, 2, ig1.c, true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            c.a(parcel, 3, ig1.d, i, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            c.a(parcel, 4, ig1.e, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            c.a(parcel, 5, ig1.f, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            c.b(parcel, 6, ig1.g);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            c.a(parcel, 7, ig1.h, i, true);
        }
        if (set.contains(Integer.valueOf(8)))
        {
            c.a(parcel, 8, ig1.i, true);
        }
        if (set.contains(Integer.valueOf(9)))
        {
            c.a(parcel, 9, ig1.j, true);
        }
        if (set.contains(Integer.valueOf(12)))
        {
            c.b(parcel, 12, ig1.k);
        }
        if (set.contains(Integer.valueOf(14)))
        {
            c.a(parcel, 14, ig1.l, true);
        }
        if (set.contains(Integer.valueOf(15)))
        {
            c.a(parcel, 15, ig1.m, i, true);
        }
        if (set.contains(Integer.valueOf(16)))
        {
            c.a(parcel, 16, ig1.n);
        }
        if (set.contains(Integer.valueOf(19)))
        {
            c.a(parcel, 19, ig1.p, i, true);
        }
        if (set.contains(Integer.valueOf(18)))
        {
            c.a(parcel, 18, ig1.o, true);
        }
        if (set.contains(Integer.valueOf(21)))
        {
            c.b(parcel, 21, ig1.r);
        }
        if (set.contains(Integer.valueOf(20)))
        {
            c.a(parcel, 20, ig1.q, true);
        }
        if (set.contains(Integer.valueOf(23)))
        {
            c.b(parcel, 23, ig1.t, true);
        }
        if (set.contains(Integer.valueOf(22)))
        {
            c.b(parcel, 22, ig1.s, true);
        }
        if (set.contains(Integer.valueOf(25)))
        {
            c.b(parcel, 25, ig1.v);
        }
        if (set.contains(Integer.valueOf(24)))
        {
            c.b(parcel, 24, ig1.u);
        }
        if (set.contains(Integer.valueOf(27)))
        {
            c.a(parcel, 27, ig1.x, true);
        }
        if (set.contains(Integer.valueOf(26)))
        {
            c.a(parcel, 26, ig1.w, true);
        }
        if (set.contains(Integer.valueOf(29)))
        {
            c.a(parcel, 29, ig1.z);
        }
        if (set.contains(Integer.valueOf(28)))
        {
            c.b(parcel, 28, ig1.y, true);
        }
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k1 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        HashSet hashset = new HashSet();
        int j1 = 0;
        String s9 = null;
        ig.a a1 = null;
        String s8 = null;
        String s7 = null;
        int i1 = 0;
        ig.b b1 = null;
        String s6 = null;
        String s5 = null;
        int l = 0;
        String s4 = null;
        ig.c c1 = null;
        boolean flag1 = false;
        String s3 = null;
        ig.d d = null;
        String s2 = null;
        int k = 0;
        java.util.ArrayList arraylist2 = null;
        java.util.ArrayList arraylist1 = null;
        int j = 0;
        int i = 0;
        String s1 = null;
        String s = null;
        java.util.ArrayList arraylist = null;
        boolean flag = false;
        do
        {
            if (parcel.dataPosition() < k1)
            {
                int l1 = parcel.readInt();
                switch (0xffff & l1)
                {
                case 10: // '\n'
                case 11: // '\013'
                case 13: // '\r'
                case 17: // '\021'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l1);
                    break;

                case 1: // '\001'
                    j1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    s9 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    a1 = (ig.a)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l1, ig.a.CREATOR);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s8 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s7 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    i1 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l1);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    b1 = (ig.b)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l1, ig.b.CREATOR);
                    hashset.add(Integer.valueOf(7));
                    break;

                case 8: // '\b'
                    s6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(8));
                    break;

                case 9: // '\t'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(9));
                    break;

                case 12: // '\f'
                    l = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l1);
                    hashset.add(Integer.valueOf(12));
                    break;

                case 14: // '\016'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(14));
                    break;

                case 15: // '\017'
                    c1 = (ig.c)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l1, ig.c.CREATOR);
                    hashset.add(Integer.valueOf(15));
                    break;

                case 16: // '\020'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l1);
                    hashset.add(Integer.valueOf(16));
                    break;

                case 19: // '\023'
                    d = (ig.d)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l1, ig.d.CREATOR);
                    hashset.add(Integer.valueOf(19));
                    break;

                case 18: // '\022'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(18));
                    break;

                case 21: // '\025'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l1);
                    hashset.add(Integer.valueOf(21));
                    break;

                case 20: // '\024'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(20));
                    break;

                case 23: // '\027'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l1, ig.g.CREATOR);
                    hashset.add(Integer.valueOf(23));
                    break;

                case 22: // '\026'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l1, ig.f.CREATOR);
                    hashset.add(Integer.valueOf(22));
                    break;

                case 25: // '\031'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l1);
                    hashset.add(Integer.valueOf(25));
                    break;

                case 24: // '\030'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l1);
                    hashset.add(Integer.valueOf(24));
                    break;

                case 27: // '\033'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(27));
                    break;

                case 26: // '\032'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l1);
                    hashset.add(Integer.valueOf(26));
                    break;

                case 29: // '\035'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l1);
                    hashset.add(Integer.valueOf(29));
                    break;

                case 28: // '\034'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l1, ig.h.CREATOR);
                    hashset.add(Integer.valueOf(28));
                    break;
                }
            } else
            if (parcel.dataPosition() != k1)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(k1).toString(), parcel);
            } else
            {
                return new ig(hashset, j1, s9, a1, s8, s7, i1, b1, s6, s5, l, s4, c1, flag1, s3, d, s2, k, arraylist2, arraylist1, j, i, s1, s, arraylist, flag);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ig[i];
    }
}
