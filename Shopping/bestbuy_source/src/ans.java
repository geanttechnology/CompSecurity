// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class ans
    implements android.os.Parcelable.Creator
{

    public ans()
    {
    }

    public static void a(GroundOverlayOptions groundoverlayoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, groundoverlayoptions.b());
        rq.a(parcel, 2, groundoverlayoptions.a(), false);
        rq.a(parcel, 3, groundoverlayoptions.c(), i, false);
        rq.a(parcel, 4, groundoverlayoptions.d());
        rq.a(parcel, 5, groundoverlayoptions.e());
        rq.a(parcel, 6, groundoverlayoptions.f(), i, false);
        rq.a(parcel, 7, groundoverlayoptions.g());
        rq.a(parcel, 8, groundoverlayoptions.h());
        rq.a(parcel, 9, groundoverlayoptions.l());
        rq.a(parcel, 10, groundoverlayoptions.i());
        rq.a(parcel, 11, groundoverlayoptions.j());
        rq.a(parcel, 12, groundoverlayoptions.k());
        rq.a(parcel, j);
    }

    public GroundOverlayOptions a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
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
                    ibinder = ro.l(parcel, k);
                    break;

                case 3: // '\003'
                    latlng = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 4: // '\004'
                    f6 = ro.i(parcel, k);
                    break;

                case 5: // '\005'
                    f5 = ro.i(parcel, k);
                    break;

                case 6: // '\006'
                    latlngbounds = (LatLngBounds)ro.a(parcel, k, LatLngBounds.CREATOR);
                    break;

                case 7: // '\007'
                    f4 = ro.i(parcel, k);
                    break;

                case 8: // '\b'
                    f3 = ro.i(parcel, k);
                    break;

                case 9: // '\t'
                    flag = ro.c(parcel, k);
                    break;

                case 10: // '\n'
                    f2 = ro.i(parcel, k);
                    break;

                case 11: // '\013'
                    f1 = ro.i(parcel, k);
                    break;

                case 12: // '\f'
                    f = ro.i(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new GroundOverlayOptions(i, ibinder, latlng, f6, f5, latlngbounds, f4, f3, flag, f2, f1, f);
            }
        } while (true);
    }

    public GroundOverlayOptions[] a(int i)
    {
        return new GroundOverlayOptions[i];
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
