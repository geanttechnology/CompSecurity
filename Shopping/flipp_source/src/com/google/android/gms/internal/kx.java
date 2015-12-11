// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.internal:
//            ai, v

public final class kx
    implements android.os.Parcelable.Creator
{

    public kx()
    {
    }

    public static v a(Parcel parcel)
    {
        Location location = null;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        long l1 = 0L;
        ai ai1 = null;
        String s = null;
        int i = 0;
        boolean flag1 = false;
        java.util.ArrayList arraylist = null;
        int j = 0;
        android.os.Bundle bundle = null;
        int k = 0;
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
                    l1 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, i1);
                    break;

                case 3: // '\003'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.m(parcel, i1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 5: // '\005'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.r(parcel, i1);
                    break;

                case 6: // '\006'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 9: // '\t'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
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
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new v(k, l1, bundle, j, arraylist, flag1, i, flag, s, ai1, location);
            }
        } while (true);
    }

    static void a(v v1, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, v1.a);
        c.a(parcel, 2, v1.b);
        c.a(parcel, 3, v1.c);
        c.b(parcel, 4, v1.d);
        c.a(parcel, 5, v1.e, false);
        c.a(parcel, 6, v1.f);
        c.b(parcel, 7, v1.g);
        c.a(parcel, 8, v1.h);
        c.a(parcel, 9, v1.i, false);
        c.a(parcel, 10, v1.j, i, false);
        c.a(parcel, 11, v1.k, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new v[i];
    }
}
