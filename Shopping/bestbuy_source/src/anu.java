// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class anu
    implements android.os.Parcelable.Creator
{

    public anu()
    {
    }

    public static void a(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, latlngbounds.a());
        rq.a(parcel, 2, latlngbounds.a, i, false);
        rq.a(parcel, 3, latlngbounds.b, i, false);
        rq.a(parcel, j);
    }

    public LatLngBounds a(Parcel parcel)
    {
        LatLng latlng = null;
        int j = ro.b(parcel);
        int i = 0;
        LatLng latlng1 = null;
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
                    latlng1 = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    latlng = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LatLngBounds(i, latlng1, latlng);
            }
        } while (true);
    }

    public LatLngBounds[] a(int i)
    {
        return new LatLngBounds[i];
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
