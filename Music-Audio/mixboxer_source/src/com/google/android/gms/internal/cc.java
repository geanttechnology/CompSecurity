// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            cb

public class cc
    implements android.os.Parcelable.Creator
{

    public cc()
    {
    }

    static void a(cb cb1, Parcel parcel, int i)
    {
        i = b.o(parcel);
        b.c(parcel, 1, cb1.versionCode);
        b.a(parcel, 2, cb1.gL, false);
        b.a(parcel, 3, cb1.hw, false);
        b.a(parcel, 4, cb1.fK, false);
        b.c(parcel, 5, cb1.errorCode);
        b.a(parcel, 6, cb1.fL, false);
        b.a(parcel, 7, cb1.hx);
        b.a(parcel, 8, cb1.hy);
        b.a(parcel, 9, cb1.hz);
        b.a(parcel, 10, cb1.hA, false);
        b.a(parcel, 11, cb1.fO);
        b.c(parcel, 12, cb1.orientation);
        b.a(parcel, 13, cb1.hB, false);
        b.D(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return g(parcel);
    }

    public cb g(Parcel parcel)
    {
        int i1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int k = 0;
        String s2 = null;
        String s1 = null;
        java.util.ArrayList arraylist2 = null;
        int j = 0;
        java.util.ArrayList arraylist1 = null;
        long l3 = 0L;
        boolean flag = false;
        long l2 = 0L;
        java.util.ArrayList arraylist = null;
        long l1 = 0L;
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, j1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;

                case 4: // '\004'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.a.y(parcel, j1);
                    break;

                case 5: // '\005'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 6: // '\006'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.a.y(parcel, j1);
                    break;

                case 7: // '\007'
                    l3 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, j1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, j1);
                    break;

                case 9: // '\t'
                    l2 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, j1);
                    break;

                case 10: // '\n'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.y(parcel, j1);
                    break;

                case 11: // '\013'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, j1);
                    break;

                case 12: // '\f'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, j1);
                    break;

                case 13: // '\r'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new cb(k, s2, s1, arraylist2, j, arraylist1, l3, flag, l2, arraylist, l1, i, s);
            }
        } while (true);
    }

    public cb[] l(int i)
    {
        return new cb[i];
    }

    public Object[] newArray(int i)
    {
        return l(i);
    }
}
