// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.internal.nn;
import com.google.android.gms.location.GeofencingRequest;

public class aib
    implements android.os.Parcelable.Creator
{

    public aib()
    {
    }

    public static void a(GeofencingRequest geofencingrequest, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.b(parcel, 1, geofencingrequest.b(), false);
        rq.a(parcel, 1000, geofencingrequest.a());
        rq.a(parcel, 2, geofencingrequest.c());
        rq.a(parcel, i);
    }

    public GeofencingRequest a(Parcel parcel)
    {
        int j = 0;
        int k = ro.b(parcel);
        java.util.ArrayList arraylist = null;
        int i = 0;
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
                    arraylist = ro.c(parcel, l, nn.CREATOR);
                    break;

                case 1000: 
                    i = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    j = ro.f(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GeofencingRequest(i, arraylist, j);
            }
        } while (true);
    }

    public GeofencingRequest[] a(int i)
    {
        return new GeofencingRequest[i];
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
