// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class ano
    implements android.os.Parcelable.Creator
{

    public ano()
    {
    }

    public static void a(CameraPosition cameraposition, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, cameraposition.a());
        rq.a(parcel, 2, cameraposition.a, i, false);
        rq.a(parcel, 3, cameraposition.b);
        rq.a(parcel, 4, cameraposition.c);
        rq.a(parcel, 5, cameraposition.d);
        rq.a(parcel, j);
    }

    public CameraPosition a(Parcel parcel)
    {
        float f = 0.0F;
        int j = ro.b(parcel);
        int i = 0;
        LatLng latlng = null;
        float f1 = 0.0F;
        float f2 = 0.0F;
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
                    latlng = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    f2 = ro.i(parcel, k);
                    break;

                case 4: // '\004'
                    f1 = ro.i(parcel, k);
                    break;

                case 5: // '\005'
                    f = ro.i(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new CameraPosition(i, latlng, f2, f1, f);
            }
        } while (true);
    }

    public CameraPosition[] a(int i)
    {
        return new CameraPosition[i];
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
