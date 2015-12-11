// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class apr
    implements android.os.Parcelable.Creator
{

    public apr()
    {
    }

    public static void a(VisibleRegion visibleregion, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, visibleregion.a());
        rq.a(parcel, 2, visibleregion.a, i, false);
        rq.a(parcel, 3, visibleregion.b, i, false);
        rq.a(parcel, 4, visibleregion.c, i, false);
        rq.a(parcel, 5, visibleregion.d, i, false);
        rq.a(parcel, 6, visibleregion.e, i, false);
        rq.a(parcel, j);
    }

    public VisibleRegion a(Parcel parcel)
    {
        LatLngBounds latlngbounds = null;
        int j = ro.b(parcel);
        int i = 0;
        LatLng latlng = null;
        LatLng latlng1 = null;
        LatLng latlng2 = null;
        LatLng latlng3 = null;
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
                    latlng3 = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    latlng2 = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 4: // '\004'
                    latlng1 = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 5: // '\005'
                    latlng = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 6: // '\006'
                    latlngbounds = (LatLngBounds)ro.a(parcel, k, LatLngBounds.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new VisibleRegion(i, latlng3, latlng2, latlng1, latlng, latlngbounds);
            }
        } while (true);
    }

    public VisibleRegion[] a(int i)
    {
        return new VisibleRegion[i];
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
