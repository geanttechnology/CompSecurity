// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.location:
//            LocationAvailability

public class i
    implements android.os.Parcelable.Creator
{

    public i()
    {
    }

    static void a(LocationAvailability locationavailability, Parcel parcel, int j)
    {
        j = b.a(parcel);
        b.a(parcel, 1, locationavailability.a);
        b.a(parcel, 1000, locationavailability.b());
        b.a(parcel, 2, locationavailability.b);
        b.a(parcel, 3, locationavailability.c);
        b.a(parcel, 4, locationavailability.d);
        b.a(parcel, j);
    }

    public LocationAvailability a(Parcel parcel)
    {
        int j = 1;
        int j1 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i1 = 0;
        int l = 1000;
        long l1 = 0L;
        int k = 1;
        do
        {
            if (parcel.dataPosition() < j1)
            {
                int k1 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.a(k1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.a.f(parcel, k1);
                    break;

                case 1000: 
                    i1 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, k1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, k1);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, k1);
                    break;

                case 4: // '\004'
                    l = com.google.android.gms.common.internal.safeparcel.a.f(parcel, k1);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j1).toString(), parcel);
            } else
            {
                return new LocationAvailability(i1, l, k, j, l1);
            }
        } while (true);
    }

    public LocationAvailability[] a(int j)
    {
        return new LocationAvailability[j];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int j)
    {
        return a(j);
    }
}
