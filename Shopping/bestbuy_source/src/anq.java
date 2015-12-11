// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class anq
    implements android.os.Parcelable.Creator
{

    public anq()
    {
    }

    public static void a(CircleOptions circleoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, circleoptions.a());
        rq.a(parcel, 2, circleoptions.b(), i, false);
        rq.a(parcel, 3, circleoptions.c());
        rq.a(parcel, 4, circleoptions.d());
        rq.a(parcel, 5, circleoptions.e());
        rq.a(parcel, 6, circleoptions.f());
        rq.a(parcel, 7, circleoptions.g());
        rq.a(parcel, 8, circleoptions.h());
        rq.a(parcel, j);
    }

    public CircleOptions a(Parcel parcel)
    {
        float f = 0.0F;
        boolean flag = false;
        int l = ro.b(parcel);
        LatLng latlng = null;
        double d = 0.0D;
        int i = 0;
        int j = 0;
        float f1 = 0.0F;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = ro.a(parcel);
                switch (ro.a(i1))
                {
                default:
                    ro.b(parcel, i1);
                    break;

                case 1: // '\001'
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    latlng = (LatLng)ro.a(parcel, i1, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    d = ro.j(parcel, i1);
                    break;

                case 4: // '\004'
                    f1 = ro.i(parcel, i1);
                    break;

                case 5: // '\005'
                    j = ro.f(parcel, i1);
                    break;

                case 6: // '\006'
                    i = ro.f(parcel, i1);
                    break;

                case 7: // '\007'
                    f = ro.i(parcel, i1);
                    break;

                case 8: // '\b'
                    flag = ro.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new CircleOptions(k, latlng, d, f1, j, i, f, flag);
            }
        } while (true);
    }

    public CircleOptions[] a(int i)
    {
        return new CircleOptions[i];
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
