// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oc;
import com.google.android.gms.maps.model.LatLng;

public class afs
    implements android.os.Parcelable.Creator
{

    public afs()
    {
    }

    public static void a(oc oc1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, oc1.a(), false);
        rq.a(parcel, 1000, oc1.a);
        rq.a(parcel, 2, oc1.b(), i, false);
        rq.a(parcel, 3, oc1.c(), false);
        rq.b(parcel, 4, oc1.d(), false);
        rq.a(parcel, 5, oc1.e(), false);
        rq.a(parcel, 6, oc1.f(), false);
        rq.a(parcel, j);
    }

    public oc a(Parcel parcel)
    {
        String s = null;
        int j = ro.b(parcel);
        int i = 0;
        String s1 = null;
        java.util.ArrayList arraylist = null;
        String s2 = null;
        LatLng latlng = null;
        String s3 = null;
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
                    s3 = ro.k(parcel, k);
                    break;

                case 1000: 
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    latlng = (LatLng)ro.a(parcel, k, LatLng.CREATOR);
                    break;

                case 3: // '\003'
                    s2 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    arraylist = ro.c(parcel, k, oa.CREATOR);
                    break;

                case 5: // '\005'
                    s1 = ro.k(parcel, k);
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
                return new oc(i, s3, latlng, s2, arraylist, s1, s);
            }
        } while (true);
    }

    public oc[] a(int i)
    {
        return new oc[i];
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
