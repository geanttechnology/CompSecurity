// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

public class anw
    implements android.os.Parcelable.Creator
{

    public anw()
    {
    }

    public static void a(LatLng latlng, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, latlng.a());
        rq.a(parcel, 2, latlng.a);
        rq.a(parcel, 3, latlng.b);
        rq.a(parcel, i);
    }

    public LatLng a(Parcel parcel)
    {
        double d = 0.0D;
        int j = ro.b(parcel);
        int i = 0;
        double d1 = 0.0D;
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
                    d1 = ro.j(parcel, k);
                    break;

                case 3: // '\003'
                    d = ro.j(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LatLng(i, d1, d);
            }
        } while (true);
    }

    public LatLng[] a(int i)
    {
        return new LatLng[i];
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
