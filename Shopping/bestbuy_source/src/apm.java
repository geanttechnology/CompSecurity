// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class apm
    implements android.os.Parcelable.Creator
{

    public apm()
    {
    }

    public static void a(StreetViewPanoramaOrientation streetviewpanoramaorientation, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, streetviewpanoramaorientation.a());
        rq.a(parcel, 2, streetviewpanoramaorientation.a);
        rq.a(parcel, 3, streetviewpanoramaorientation.b);
        rq.a(parcel, i);
    }

    public StreetViewPanoramaOrientation a(Parcel parcel)
    {
        float f1 = 0.0F;
        int j = ro.b(parcel);
        int i = 0;
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
                    f = ro.i(parcel, k);
                    break;

                case 3: // '\003'
                    f1 = ro.i(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaOrientation(i, f, f1);
            }
        } while (true);
    }

    public StreetViewPanoramaOrientation[] a(int i)
    {
        return new StreetViewPanoramaOrientation[i];
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
