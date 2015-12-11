// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class apd
    implements android.os.Parcelable.Creator
{

    public apd()
    {
    }

    public static void a(MarkerOptions markeroptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, markeroptions.a());
        rq.a(parcel, 2, markeroptions.c(), i, false);
        rq.a(parcel, 3, markeroptions.d(), false);
        rq.a(parcel, 4, markeroptions.e(), false);
        rq.a(parcel, 5, markeroptions.b(), false);
        rq.a(parcel, 6, markeroptions.f());
        rq.a(parcel, 7, markeroptions.g());
        rq.a(parcel, 8, markeroptions.h());
        rq.a(parcel, 9, markeroptions.i());
        rq.a(parcel, 10, markeroptions.j());
        rq.a(parcel, 11, markeroptions.k());
        rq.a(parcel, 12, markeroptions.l());
        rq.a(parcel, 13, markeroptions.m());
        rq.a(parcel, 14, markeroptions.n());
        rq.a(parcel, j);
    }

    public MarkerOptions a(Parcel parcel)
    {
        int j = ro.b(parcel);
        int i = 0;
        LatLng latlng = null;
        String s1 = null;
        String s = null;
        android.os.IBinder ibinder = null;
        float f5 = 0.0F;
        float f4 = 0.0F;
        boolean flag2 = false;
        boolean flag1 = false;
        boolean flag = false;
        float f3 = 0.0F;
        float f2 = 0.5F;
        float f1 = 0.0F;
        float f = 1.0F;
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
                    s1 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    s = ro.k(parcel, k);
                    break;

                case 5: // '\005'
                    ibinder = ro.l(parcel, k);
                    break;

                case 6: // '\006'
                    f5 = ro.i(parcel, k);
                    break;

                case 7: // '\007'
                    f4 = ro.i(parcel, k);
                    break;

                case 8: // '\b'
                    flag2 = ro.c(parcel, k);
                    break;

                case 9: // '\t'
                    flag1 = ro.c(parcel, k);
                    break;

                case 10: // '\n'
                    flag = ro.c(parcel, k);
                    break;

                case 11: // '\013'
                    f3 = ro.i(parcel, k);
                    break;

                case 12: // '\f'
                    f2 = ro.i(parcel, k);
                    break;

                case 13: // '\r'
                    f1 = ro.i(parcel, k);
                    break;

                case 14: // '\016'
                    f = ro.i(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new MarkerOptions(i, latlng, s1, s, ibinder, f5, f4, flag2, flag1, flag, f3, f2, f1, f);
            }
        } while (true);
    }

    public MarkerOptions[] a(int i)
    {
        return new MarkerOptions[i];
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
