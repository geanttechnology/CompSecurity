// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.PolylineOptions;

public class api
{

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
}
