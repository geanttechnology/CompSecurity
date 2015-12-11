// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;

public class apf
    implements android.os.Parcelable.Creator
{

    public apf()
    {
    }

    public static void a(PolygonOptions polygonoptions, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, polygonoptions.a());
        rq.b(parcel, 2, polygonoptions.c(), false);
        rq.c(parcel, 3, polygonoptions.b(), false);
        rq.a(parcel, 4, polygonoptions.d());
        rq.a(parcel, 5, polygonoptions.e());
        rq.a(parcel, 6, polygonoptions.f());
        rq.a(parcel, 7, polygonoptions.g());
        rq.a(parcel, 8, polygonoptions.h());
        rq.a(parcel, 9, polygonoptions.i());
        rq.a(parcel, i);
    }

    public PolygonOptions a(Parcel parcel)
    {
        float f = 0.0F;
        boolean flag = false;
        int l = ro.b(parcel);
        ArrayList arraylist = null;
        ArrayList arraylist1 = new ArrayList();
        boolean flag1 = false;
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
                    arraylist = ro.c(parcel, i1, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    ro.a(parcel, i1, arraylist1, getClass().getClassLoader());
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
                    flag1 = ro.c(parcel, i1);
                    break;

                case 9: // '\t'
                    flag = ro.c(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new PolygonOptions(k, arraylist, arraylist1, f1, j, i, f, flag1, flag);
            }
        } while (true);
    }

    public PolygonOptions[] a(int i)
    {
        return new PolygonOptions[i];
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
