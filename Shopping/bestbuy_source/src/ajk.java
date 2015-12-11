// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class ajk
    implements android.os.Parcelable.Creator
{

    public ajk()
    {
    }

    public static void a(StreetViewPanoramaOptions streetviewpanoramaoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, streetviewpanoramaoptions.a());
        rq.a(parcel, 2, streetviewpanoramaoptions.g(), i, false);
        rq.a(parcel, 3, streetviewpanoramaoptions.j(), false);
        rq.a(parcel, 4, streetviewpanoramaoptions.h(), i, false);
        rq.a(parcel, 5, streetviewpanoramaoptions.i(), false);
        rq.a(parcel, 6, streetviewpanoramaoptions.b());
        rq.a(parcel, 7, streetviewpanoramaoptions.c());
        rq.a(parcel, 8, streetviewpanoramaoptions.d());
        rq.a(parcel, 9, streetviewpanoramaoptions.e());
        rq.a(parcel, 10, streetviewpanoramaoptions.f());
        rq.a(parcel, j);
    }

    public StreetViewPanoramaOptions a(Parcel parcel)
    {
        Integer integer = null;
        byte byte0 = 0;
        int j = ro.b(parcel);
        byte byte1 = 0;
        byte byte2 = 0;
        byte byte3 = 0;
        byte byte4 = 0;
        LatLng latlng = null;
        String s = null;
        StreetViewPanoramaCamera streetviewpanoramacamera = null;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = ro.a(parcel);
                switch (ro.a(k))
                {
                default:
                    ro.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    streetviewpanoramacamera = (StreetViewPanoramaCamera)ro.a(parcel, k, StreetViewPanoramaCamera.CREATOR);
                    break;

                case 3: // '\003'
                    s = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    latlng = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 5: // '\005'
                    integer = ro.g(parcel, k);
                    break;

                case 6: // '\006'
                    byte4 = ro.d(parcel, k);
                    break;

                case 7: // '\007'
                    byte3 = ro.d(parcel, k);
                    break;

                case 8: // '\b'
                    byte2 = ro.d(parcel, k);
                    break;

                case 9: // '\t'
                    byte1 = ro.d(parcel, k);
                    break;

                case 10: // '\n'
                    byte0 = ro.d(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaOptions(i, streetviewpanoramacamera, s, latlng, integer, byte4, byte3, byte2, byte1, byte0);
            }
        } while (true);
    }

    public StreetViewPanoramaOptions[] a(int i)
    {
        return new StreetViewPanoramaOptions[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
