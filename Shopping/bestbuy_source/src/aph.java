// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class aph
    implements android.os.Parcelable.Creator
{

    public aph()
    {
    }

    public static void a(PolylineOptions polylineoptions, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, polylineoptions.a());
        rq.b(parcel, 2, polylineoptions.b(), false);
        rq.a(parcel, 3, polylineoptions.c());
        rq.a(parcel, 4, polylineoptions.d());
        rq.a(parcel, 5, polylineoptions.e());
        rq.a(parcel, 6, polylineoptions.f());
        rq.a(parcel, 7, polylineoptions.g());
        rq.a(parcel, i);
    }

    public PolylineOptions a(Parcel parcel)
    {
        float f = 0.0F;
        boolean flag = false;
        int k = ro.b(parcel);
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        int i = 0;
        float f1 = 0.0F;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    arraylist = ro.c(parcel, l, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    f1 = ro.i(parcel, l);
                    break;

                case 4: // '\004'
                    i = ro.f(parcel, l);
                    break;

                case 5: // '\005'
                    f = ro.i(parcel, l);
                    break;

                case 6: // '\006'
                    flag1 = ro.c(parcel, l);
                    break;

                case 7: // '\007'
                    flag = ro.c(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new PolylineOptions(j, arraylist, f1, i, f, flag1, flag);
            }
        } while (true);
    }

    public PolylineOptions[] a(int i)
    {
        return new PolylineOptions[i];
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
