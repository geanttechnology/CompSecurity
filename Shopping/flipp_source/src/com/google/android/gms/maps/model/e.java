// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLng, LatLngBounds

public final class e
    implements android.os.Parcelable.Creator
{

    public e()
    {
    }

    public static LatLngBounds a(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        LatLng latlng = null;
        int i = 0;
        LatLng latlng1 = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = parcel.readInt();
                switch (0xffff & k)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, k);
                    break;

                case 2: // '\002'
                    latlng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    latlng1 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LatLng.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new LatLngBounds(i, latlng, latlng1);
            }
        } while (true);
    }

    static void a(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.b(parcel, 1, latlngbounds.a);
        c.a(parcel, 2, latlngbounds.b, i, false);
        c.a(parcel, 3, latlngbounds.c, i, false);
        c.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new LatLngBounds[i];
    }
}
