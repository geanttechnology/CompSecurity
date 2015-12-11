// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.internal:
//            v, ai

public class w
    implements android.os.Parcelable.Creator
{

    public w()
    {
    }

    static void a(v v1, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.b.o(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, v1.versionCode);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, v1.ex);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, v1.extras, false);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 4, v1.ey);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, v1.ez, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 6, v1.eA);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 7, v1.tagForChildDirectedTreatment);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 8, v1.eB);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 9, v1.eC, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 10, v1.eD, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 11, v1.eE, i, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, j);
    }

    public v a(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int k = 0;
        long l1 = 0L;
        android.os.Bundle bundle = null;
        int j = 0;
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        int i = 0;
        boolean flag = false;
        String s = null;
        ai ai1 = null;
        Location location = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 10: // '\n'
                    ai1 = (ai)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, ai.CREATOR);
                    break;

                case 11: // '\013'
                    location = (Location)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, Location.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new v(k, l1, bundle, j, arraylist, flag1, i, flag, s, ai1, location);
            }
        } while (true);
    }

    public v[] b(int i)
    {
        return new v[i];
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
