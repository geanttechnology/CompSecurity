// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            z, am

public class aa
    implements android.os.Parcelable.Creator
{

    public aa()
    {
    }

    static void a(z z1, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.b.p(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, z1.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, z1.le);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, z1.extras, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, z1.lf);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, z1.lg, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, z1.lh);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, z1.tagForChildDirectedTreatment);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, z1.li);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, z1.lj, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, z1.lk, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, z1.ll, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 12, z1.lm, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, j);
    }

    public z a(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int k = 0;
        long l1 = 0L;
        android.os.Bundle bundle = null;
        int j = 0;
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        int i = 0;
        boolean flag = false;
        String s1 = null;
        am am1 = null;
        Location location = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, i1);
                    break;

                case 3: // '\003'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.o(parcel, i1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 5: // '\005'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.y(parcel, i1);
                    break;

                case 6: // '\006'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 9: // '\t'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 10: // '\n'
                    am1 = (am)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, am.CREATOR);
                    break;

                case 11: // '\013'
                    location = (Location)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, Location.CREATOR);
                    break;

                case 12: // '\f'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new z(k, l1, bundle, j, arraylist, flag1, i, flag, s1, am1, location, s);
            }
        } while (true);
    }

    public z[] b(int i)
    {
        return new z[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return b(i);
    }
}
