// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nd;
import com.google.android.gms.internal.nl;
import com.google.android.gms.location.LocationRequest;

public class afh
    implements android.os.Parcelable.Creator
{

    public afh()
    {
    }

    public static void a(nl nl1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, nl1.b, i, false);
        rq.a(parcel, 1000, nl1.a());
        rq.a(parcel, 2, nl1.c);
        rq.a(parcel, 3, nl1.d);
        rq.a(parcel, 4, nl1.e);
        rq.b(parcel, 5, nl1.f, false);
        rq.a(parcel, 6, nl1.g, false);
        rq.a(parcel, j);
    }

    public nl a(Parcel parcel)
    {
        String s = null;
        boolean flag = true;
        boolean flag2 = false;
        int j = ro.b(parcel);
        Object obj = nl.a;
        boolean flag1 = true;
        LocationRequest locationrequest = null;
        int i = 0;
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
                    locationrequest = (LocationRequest)ro.a(parcel, k, LocationRequest.CREATOR);
                    break;

                case 1000: 
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    flag2 = ro.c(parcel, k);
                    break;

                case 3: // '\003'
                    flag1 = ro.c(parcel, k);
                    break;

                case 4: // '\004'
                    flag = ro.c(parcel, k);
                    break;

                case 5: // '\005'
                    obj = ro.c(parcel, k, nd.CREATOR);
                    break;

                case 6: // '\006'
                    s = ro.k(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new nl(i, locationrequest, flag2, flag1, flag, ((java.util.List) (obj)), s);
            }
        } while (true);
    }

    public nl[] a(int i)
    {
        return new nl[i];
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
