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
//            ib

public final class jq
    implements android.os.Parcelable.Creator
{

    public jq()
    {
    }

    static void a(ib ib1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        Set set = ib1.a;
        if (set.contains(Integer.valueOf(1)))
        {
            c.b(parcel, 1, ib1.b);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            c.a(parcel, 2, ib1.c, i, true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            c.a(parcel, 3, ib1.d, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            c.a(parcel, 4, ib1.e, i, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            c.a(parcel, 5, ib1.f, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            c.a(parcel, 6, ib1.g, true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            c.a(parcel, 7, ib1.h, true);
        }
        if (set.contains(Integer.valueOf(8)))
        {
            c.b(parcel, 8, ib1.i, true);
        }
        if (set.contains(Integer.valueOf(9)))
        {
            c.b(parcel, 9, ib1.j);
        }
        if (set.contains(Integer.valueOf(10)))
        {
            c.b(parcel, 10, ib1.k, true);
        }
        if (set.contains(Integer.valueOf(11)))
        {
            c.a(parcel, 11, ib1.l, i, true);
        }
        if (set.contains(Integer.valueOf(12)))
        {
            c.b(parcel, 12, ib1.m, true);
        }
        if (set.contains(Integer.valueOf(13)))
        {
            c.a(parcel, 13, ib1.n, true);
        }
        if (set.contains(Integer.valueOf(14)))
        {
            c.a(parcel, 14, ib1.o, true);
        }
        if (set.contains(Integer.valueOf(15)))
        {
            c.a(parcel, 15, ib1.p, i, true);
        }
        if (set.contains(Integer.valueOf(17)))
        {
            c.a(parcel, 17, ib1.r, true);
        }
        if (set.contains(Integer.valueOf(16)))
        {
            c.a(parcel, 16, ib1.q, true);
        }
        if (set.contains(Integer.valueOf(19)))
        {
            c.b(parcel, 19, ib1.t, true);
        }
        if (set.contains(Integer.valueOf(18)))
        {
            c.a(parcel, 18, ib1.s, true);
        }
        if (set.contains(Integer.valueOf(21)))
        {
            c.a(parcel, 21, ib1.v, true);
        }
        if (set.contains(Integer.valueOf(20)))
        {
            c.a(parcel, 20, ib1.u, true);
        }
        if (set.contains(Integer.valueOf(23)))
        {
            c.a(parcel, 23, ib1.x, true);
        }
        if (set.contains(Integer.valueOf(22)))
        {
            c.a(parcel, 22, ib1.w, true);
        }
        if (set.contains(Integer.valueOf(25)))
        {
            c.a(parcel, 25, ib1.z, true);
        }
        if (set.contains(Integer.valueOf(24)))
        {
            c.a(parcel, 24, ib1.y, true);
        }
        if (set.contains(Integer.valueOf(27)))
        {
            c.a(parcel, 27, ib1.B, true);
        }
        if (set.contains(Integer.valueOf(26)))
        {
            c.a(parcel, 26, ib1.A, true);
        }
        if (set.contains(Integer.valueOf(29)))
        {
            c.a(parcel, 29, ib1.D, i, true);
        }
        if (set.contains(Integer.valueOf(28)))
        {
            c.a(parcel, 28, ib1.C, true);
        }
        if (set.contains(Integer.valueOf(31)))
        {
            c.a(parcel, 31, ib1.F, true);
        }
        if (set.contains(Integer.valueOf(30)))
        {
            c.a(parcel, 30, ib1.E, true);
        }
        if (set.contains(Integer.valueOf(34)))
        {
            c.a(parcel, 34, ib1.I, i, true);
        }
        if (set.contains(Integer.valueOf(32)))
        {
            c.a(parcel, 32, ib1.G, true);
        }
        if (set.contains(Integer.valueOf(33)))
        {
            c.a(parcel, 33, ib1.H, true);
        }
        if (set.contains(Integer.valueOf(38)))
        {
            c.a(parcel, 38, ib1.L);
        }
        if (set.contains(Integer.valueOf(39)))
        {
            c.a(parcel, 39, ib1.M, true);
        }
        if (set.contains(Integer.valueOf(36)))
        {
            c.a(parcel, 36, ib1.J);
        }
        if (set.contains(Integer.valueOf(37)))
        {
            c.a(parcel, 37, ib1.K, i, true);
        }
        if (set.contains(Integer.valueOf(42)))
        {
            c.a(parcel, 42, ib1.P, true);
        }
        if (set.contains(Integer.valueOf(43)))
        {
            c.a(parcel, 43, ib1.Q, true);
        }
        if (set.contains(Integer.valueOf(40)))
        {
            c.a(parcel, 40, ib1.N, i, true);
        }
        if (set.contains(Integer.valueOf(41)))
        {
            c.b(parcel, 41, ib1.O, true);
        }
        if (set.contains(Integer.valueOf(46)))
        {
            c.a(parcel, 46, ib1.T, i, true);
        }
        if (set.contains(Integer.valueOf(47)))
        {
            c.a(parcel, 47, ib1.U, true);
        }
        if (set.contains(Integer.valueOf(44)))
        {
            c.a(parcel, 44, ib1.R, true);
        }
        if (set.contains(Integer.valueOf(45)))
        {
            c.a(parcel, 45, ib1.S, true);
        }
        if (set.contains(Integer.valueOf(51)))
        {
            c.a(parcel, 51, ib1.Y, true);
        }
        if (set.contains(Integer.valueOf(50)))
        {
            c.a(parcel, 50, ib1.X, i, true);
        }
        if (set.contains(Integer.valueOf(49)))
        {
            c.a(parcel, 49, ib1.W, true);
        }
        if (set.contains(Integer.valueOf(48)))
        {
            c.a(parcel, 48, ib1.V, true);
        }
        if (set.contains(Integer.valueOf(55)))
        {
            c.a(parcel, 55, ib1.ac, true);
        }
        if (set.contains(Integer.valueOf(54)))
        {
            c.a(parcel, 54, ib1.ab, true);
        }
        if (set.contains(Integer.valueOf(53)))
        {
            c.a(parcel, 53, ib1.aa, true);
        }
        if (set.contains(Integer.valueOf(52)))
        {
            c.a(parcel, 52, ib1.Z, true);
        }
        if (set.contains(Integer.valueOf(56)))
        {
            c.a(parcel, 56, ib1.ad, true);
        }
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        ib ib10 = null;
        java.util.ArrayList arraylist5 = null;
        ib ib9 = null;
        String s34 = null;
        String s33 = null;
        String s32 = null;
        java.util.ArrayList arraylist4 = null;
        int i = 0;
        java.util.ArrayList arraylist3 = null;
        ib ib8 = null;
        java.util.ArrayList arraylist2 = null;
        String s31 = null;
        String s30 = null;
        ib ib7 = null;
        String s29 = null;
        String s28 = null;
        String s27 = null;
        java.util.ArrayList arraylist1 = null;
        String s26 = null;
        String s25 = null;
        String s24 = null;
        String s23 = null;
        String s22 = null;
        String s21 = null;
        String s20 = null;
        String s19 = null;
        String s18 = null;
        ib ib6 = null;
        String s17 = null;
        String s16 = null;
        String s15 = null;
        String s14 = null;
        ib ib5 = null;
        double d1 = 0.0D;
        ib ib4 = null;
        double d = 0.0D;
        String s13 = null;
        ib ib3 = null;
        java.util.ArrayList arraylist = null;
        String s12 = null;
        String s11 = null;
        String s10 = null;
        String s9 = null;
        ib ib2 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        ib ib1 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = parcel.readInt();
                switch (0xffff & l)
                {
                case 35: // '#'
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    ib10 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    arraylist5 = com.google.android.gms.common.internal.safeparcel.a.r(parcel, l);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    ib9 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s34 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    s33 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    s32 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(7));
                    break;

                case 8: // '\b'
                    arraylist4 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(8));
                    break;

                case 9: // '\t'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, l);
                    hashset.add(Integer.valueOf(9));
                    break;

                case 10: // '\n'
                    arraylist3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(10));
                    break;

                case 11: // '\013'
                    ib8 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(11));
                    break;

                case 12: // '\f'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(12));
                    break;

                case 13: // '\r'
                    s31 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(13));
                    break;

                case 14: // '\016'
                    s30 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(14));
                    break;

                case 15: // '\017'
                    ib7 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(15));
                    break;

                case 17: // '\021'
                    s28 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(17));
                    break;

                case 16: // '\020'
                    s29 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(16));
                    break;

                case 19: // '\023'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(19));
                    break;

                case 18: // '\022'
                    s27 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(18));
                    break;

                case 21: // '\025'
                    s25 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(21));
                    break;

                case 20: // '\024'
                    s26 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(20));
                    break;

                case 23: // '\027'
                    s23 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(23));
                    break;

                case 22: // '\026'
                    s24 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(22));
                    break;

                case 25: // '\031'
                    s21 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(25));
                    break;

                case 24: // '\030'
                    s22 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(24));
                    break;

                case 27: // '\033'
                    s19 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(27));
                    break;

                case 26: // '\032'
                    s20 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(26));
                    break;

                case 29: // '\035'
                    ib6 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(29));
                    break;

                case 28: // '\034'
                    s18 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(28));
                    break;

                case 31: // '\037'
                    s16 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(31));
                    break;

                case 30: // '\036'
                    s17 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(30));
                    break;

                case 34: // '"'
                    ib5 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(34));
                    break;

                case 32: // ' '
                    s15 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(32));
                    break;

                case 33: // '!'
                    s14 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(33));
                    break;

                case 38: // '&'
                    d = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    hashset.add(Integer.valueOf(38));
                    break;

                case 39: // '\''
                    s13 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(39));
                    break;

                case 36: // '$'
                    d1 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    hashset.add(Integer.valueOf(36));
                    break;

                case 37: // '%'
                    ib4 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(37));
                    break;

                case 42: // '*'
                    s12 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(42));
                    break;

                case 43: // '+'
                    s11 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(43));
                    break;

                case 40: // '('
                    ib3 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(40));
                    break;

                case 41: // ')'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(41));
                    break;

                case 46: // '.'
                    ib2 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(46));
                    break;

                case 47: // '/'
                    s8 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(47));
                    break;

                case 44: // ','
                    s10 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(44));
                    break;

                case 45: // '-'
                    s9 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(45));
                    break;

                case 51: // '3'
                    s5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(51));
                    break;

                case 50: // '2'
                    ib1 = (ib)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, ib.CREATOR);
                    hashset.add(Integer.valueOf(50));
                    break;

                case 49: // '1'
                    s6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(49));
                    break;

                case 48: // '0'
                    s7 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(48));
                    break;

                case 55: // '7'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(55));
                    break;

                case 54: // '6'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(54));
                    break;

                case 53: // '5'
                    s3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(53));
                    break;

                case 52: // '4'
                    s4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(52));
                    break;

                case 56: // '8'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, l);
                    hashset.add(Integer.valueOf(56));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != k)
                {
                    throw new b((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
                }
                return new ib(hashset, j, ib10, arraylist5, ib9, s34, s33, s32, arraylist4, i, arraylist3, ib8, arraylist2, s31, s30, ib7, s29, s28, s27, arraylist1, s26, s25, s24, s23, s22, s21, s20, s19, s18, ib6, s17, s16, s15, s14, ib5, d1, ib4, d, s13, ib3, arraylist, s12, s11, s10, s9, ib2, s8, s7, s6, ib1, s5, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public final Object[] newArray(int i)
    {
        return new ib[i];
    }
}
