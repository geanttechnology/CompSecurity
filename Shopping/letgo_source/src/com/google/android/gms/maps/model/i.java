// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

// Referenced classes of package com.google.android.gms.maps.model:
//            GroundOverlayOptions, LatLng, LatLngBounds

public class i
    implements android.os.Parcelable.Creator
{

    public i()
    {
    }

    static void a(GroundOverlayOptions groundoverlayoptions, Parcel parcel, int j)
    {
        int k = b.a(parcel);
        b.a(parcel, 1, groundoverlayoptions.b());
        b.a(parcel, 2, groundoverlayoptions.a(), false);
        b.a(parcel, 3, groundoverlayoptions.c(), j, false);
        b.a(parcel, 4, groundoverlayoptions.d());
        b.a(parcel, 5, groundoverlayoptions.e());
        b.a(parcel, 6, groundoverlayoptions.f(), j, false);
        b.a(parcel, 7, groundoverlayoptions.g());
        b.a(parcel, 8, groundoverlayoptions.h());
        b.a(parcel, 9, groundoverlayoptions.l());
        b.a(parcel, 10, groundoverlayoptions.i());
        b.a(parcel, 11, groundoverlayoptions.j());
        b.a(parcel, 12, groundoverlayoptions.k());
        b.a(parcel, k);
    }

    public GroundOverlayOptions a(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int j = 0;
        android.os.IBinder ibinder = null;
        LatLng latlng = null;
        float f6 = 0.0F;
        float f5 = 0.0F;
        LatLngBounds latlngbounds = null;
        float f4 = 0.0F;
        float f3 = 0.0F;
        boolean flag = false;
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = 0.0F;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.a(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, l);
                    break;

                case 2: // '\002'
                    ibinder = com.google.android.gms.common.internal.safeparcel.a.l(parcel, l);
                    break;

                case 3: // '\003'
                    latlng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, LatLng.CREATOR);
                    break;

                case 4: // '\004'
                    f6 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;

                case 5: // '\005'
                    f5 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;

                case 6: // '\006'
                    latlngbounds = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, LatLngBounds.CREATOR);
                    break;

                case 7: // '\007'
                    f4 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;

                case 8: // '\b'
                    f3 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;

                case 9: // '\t'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l);
                    break;

                case 10: // '\n'
                    f2 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;

                case 11: // '\013'
                    f1 = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;

                case 12: // '\f'
                    f = com.google.android.gms.common.internal.safeparcel.a.i(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GroundOverlayOptions(j, ibinder, latlng, f6, f5, latlngbounds, f4, f3, flag, f2, f1, f);
            }
        } while (true);
    }

    public GroundOverlayOptions[] a(int j)
    {
        return new GroundOverlayOptions[j];
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
