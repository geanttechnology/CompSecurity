// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class apj
    implements android.os.Parcelable.Creator
{

    public apj()
    {
    }

    public static void a(StreetViewPanoramaCamera streetviewpanoramacamera, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, streetviewpanoramacamera.a());
        rq.a(parcel, 2, streetviewpanoramacamera.a);
        rq.a(parcel, 3, streetviewpanoramacamera.b);
        rq.a(parcel, 4, streetviewpanoramacamera.c);
        rq.a(parcel, i);
    }

    public StreetViewPanoramaCamera a(Parcel parcel)
    {
        float f2 = 0.0F;
        int j = ro.b(parcel);
        float f = 0.0F;
        int i = 0;
        float f1 = 0.0F;
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

                case 4: // '\004'
                    f2 = ro.i(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new StreetViewPanoramaCamera(i, f, f1, f2);
            }
        } while (true);
    }

    public StreetViewPanoramaCamera[] a(int i)
    {
        return new StreetViewPanoramaCamera[i];
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
