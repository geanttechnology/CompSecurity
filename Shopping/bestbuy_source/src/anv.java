// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLngBounds;

public class anv
{

    public static void a(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, latlngbounds.a());
        rq.a(parcel, 2, latlngbounds.a, i, false);
        rq.a(parcel, 3, latlngbounds.b, i, false);
        rq.a(parcel, j);
    }
}
