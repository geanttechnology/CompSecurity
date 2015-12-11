// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

public class apc
{

    public static void a(LatLng latlng, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, latlng.a());
        rq.a(parcel, 2, latlng.a);
        rq.a(parcel, 3, latlng.b);
        rq.a(parcel, i);
    }
}
