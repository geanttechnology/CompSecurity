// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.maps.model:
//            PolylineOptions, LatLng

public final class i
    implements android.os.Parcelable.Creator
{

    public i()
    {
    }

    static void a(PolylineOptions polylineoptions, Parcel parcel)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, polylineoptions.a);
        c.b(parcel, 2, polylineoptions.b, false);
        c.a(parcel, 3, polylineoptions.c);
        c.b(parcel, 4, polylineoptions.d);
        c.a(parcel, 5, polylineoptions.e);
        c.a(parcel, 6, polylineoptions.f);
        c.a(parcel, 7, polylineoptions.g);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        float f = 0.0F;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    f1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, i1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 5: // '\005'
                    f = com.google.android.gms.common.internal.safeparcel.a.h(parcel, i1);
                    break;

                case 6: // '\006'
                    flag1 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new PolylineOptions(k, arraylist, f1, j, f, flag1, flag);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int j)
    {
        return new PolylineOptions[j];
    }
}
