// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.maps.a.l;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanoramaOptions

public final class h
    implements android.os.Parcelable.Creator
{

    public h()
    {
    }

    public static StreetViewPanoramaOptions a(Parcel parcel)
    {
        byte byte0 = 0;
        int j = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        byte byte1 = 0;
        byte byte2 = 0;
        byte byte3 = 0;
        byte byte4 = 0;
        Integer integer = null;
        LatLng latlng = null;
        String s = null;
        StreetViewPanoramaCamera streetviewpanoramacamera = null;
        int i = 0;
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
                    streetviewpanoramacamera = (StreetViewPanoramaCamera)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, StreetViewPanoramaCamera.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, k);
                    break;

                case 4: // '\004'
                    latlng = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, LatLng.CREATOR);
                    break;

                case 5: // '\005'
                    k = com.google.android.gms.common.internal.safeparcel.a.a(parcel, k);
                    if (k == 0)
                    {
                        integer = null;
                    } else
                    {
                        if (k != 4)
                        {
                            throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Expected size 4 got ")).append(k).append(" (0x").append(Integer.toHexString(k)).append(")").toString(), parcel);
                        }
                        integer = Integer.valueOf(parcel.readInt());
                    }
                    break;

                case 6: // '\006'
                    byte4 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, k);
                    break;

                case 7: // '\007'
                    byte3 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, k);
                    break;

                case 8: // '\b'
                    byte2 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, k);
                    break;

                case 9: // '\t'
                    byte1 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, k);
                    break;

                case 10: // '\n'
                    byte0 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaOptions(i, streetviewpanoramacamera, s, latlng, integer, byte4, byte3, byte2, byte1, byte0);
            }
        } while (true);
    }

    static void a(StreetViewPanoramaOptions streetviewpanoramaoptions, Parcel parcel, int i)
    {
        int j = b.a(parcel, 20293);
        b.b(parcel, 1, streetviewpanoramaoptions.a);
        b.a(parcel, 2, streetviewpanoramaoptions.b, i, false);
        b.a(parcel, 3, streetviewpanoramaoptions.c, false);
        b.a(parcel, 4, streetviewpanoramaoptions.d, i, false);
        Integer integer = streetviewpanoramaoptions.e;
        if (integer != null)
        {
            b.a(parcel, 5, 4);
            parcel.writeInt(integer.intValue());
        }
        b.a(parcel, 6, l.a(streetviewpanoramaoptions.f));
        b.a(parcel, 7, l.a(streetviewpanoramaoptions.g));
        b.a(parcel, 8, l.a(streetviewpanoramaoptions.h));
        b.a(parcel, 9, l.a(streetviewpanoramaoptions.i));
        b.a(parcel, 10, l.a(streetviewpanoramaoptions.j));
        b.b(parcel, j);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return new StreetViewPanoramaOptions[i];
    }
}
