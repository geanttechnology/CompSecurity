// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.location.LocationRequest;

public class aii
    implements android.os.Parcelable.Creator
{

    public aii()
    {
    }

    public static void a(LocationRequest locationrequest, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, locationrequest.a);
        rq.a(parcel, 1000, locationrequest.b());
        rq.a(parcel, 2, locationrequest.b);
        rq.a(parcel, 3, locationrequest.c);
        rq.a(parcel, 4, locationrequest.d);
        rq.a(parcel, 5, locationrequest.e);
        rq.a(parcel, 6, locationrequest.f);
        rq.a(parcel, 7, locationrequest.g);
        rq.a(parcel, 8, locationrequest.h);
        rq.a(parcel, i);
    }

    public LocationRequest a(Parcel parcel)
    {
        int l = ro.b(parcel);
        int k = 0;
        int j = 102;
        long l4 = 0x36ee80L;
        long l3 = 0x927c0L;
        boolean flag = false;
        long l2 = 0x7fffffffffffffffL;
        int i = 0x7fffffff;
        float f = 0.0F;
        long l1 = 0L;
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
                    j = ro.f(parcel, i1);
                    break;

                case 1000: 
                    k = ro.f(parcel, i1);
                    break;

                case 2: // '\002'
                    l4 = ro.h(parcel, i1);
                    break;

                case 3: // '\003'
                    l3 = ro.h(parcel, i1);
                    break;

                case 4: // '\004'
                    flag = ro.c(parcel, i1);
                    break;

                case 5: // '\005'
                    l2 = ro.h(parcel, i1);
                    break;

                case 6: // '\006'
                    i = ro.f(parcel, i1);
                    break;

                case 7: // '\007'
                    f = ro.i(parcel, i1);
                    break;

                case 8: // '\b'
                    l1 = ro.h(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new LocationRequest(k, j, l4, l3, flag, l2, i, f, l1);
            }
        } while (true);
    }

    public LocationRequest[] a(int i)
    {
        return new LocationRequest[i];
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
