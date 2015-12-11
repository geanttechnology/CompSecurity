// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            cb

public final class dn
    implements android.os.Parcelable.Creator
{

    public dn()
    {
    }

    public static cb a(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
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
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 4: // '\004'
                    arraylist2 = com.google.android.gms.common.internal.safeparcel.a.r(parcel, i1);
                    break;

                case 5: // '\005'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 6: // '\006'
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.a.r(parcel, i1);
                    break;

                case 7: // '\007'
                    l3 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 9: // '\t'
                    l2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 10: // '\n'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.r(parcel, i1);
                    break;

                case 11: // '\013'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 12: // '\f'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 13: // '\r'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new cb(k, s2, s1, arraylist2, j, arraylist1, l3, flag, l2, arraylist, l1, i, s);
            }
        } while (true);
    }

    static void a(cb cb1, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.b(parcel, 1, cb1.a);
        c.a(parcel, 2, cb1.b, false);
        c.a(parcel, 3, cb1.c, false);
        c.a(parcel, 4, cb1.d, false);
        c.b(parcel, 5, cb1.e);
        c.a(parcel, 6, cb1.f, false);
        c.a(parcel, 7, cb1.g);
        c.a(parcel, 8, cb1.h);
        c.a(parcel, 9, cb1.i);
        c.a(parcel, 10, cb1.j, false);
        c.a(parcel, 11, cb1.k);
        c.b(parcel, 12, cb1.l);
        c.a(parcel, 13, cb1.m, false);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new cb[i];
    }
}
