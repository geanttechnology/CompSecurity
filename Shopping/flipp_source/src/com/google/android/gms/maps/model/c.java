// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            CircleOptions, LatLng

public final class c
    implements android.os.Parcelable.Creator
{

    public c()
    {
    }

    static void a(CircleOptions circleoptions, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.c.a(parcel, 20293);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 1, circleoptions.a);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 2, circleoptions.b, i, false);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 3, circleoptions.c);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 4, circleoptions.d);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 5, circleoptions.e);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, 6, circleoptions.f);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 7, circleoptions.g);
        com.google.android.gms.common.internal.safeparcel.c.a(parcel, 8, circleoptions.h);
        com.google.android.gms.common.internal.safeparcel.c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        float f = 0.0F;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        LatLng latlng = null;
        double d = 0.0D;
        int i = 0;
        int j = 0;
        float f1 = 0.0F;
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
                    latlng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    d = com.google.android.gms.common.internal.safeparcel.a.i(parcel, i1);
                    break;

                case 4: // '\004'
                    f1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, i1);
                    break;

                case 5: // '\005'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 7: // '\007'
                    f = com.google.android.gms.common.internal.safeparcel.a.h(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new CircleOptions(k, latlng, d, f1, j, i, f, flag);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new CircleOptions[i];
    }
}
