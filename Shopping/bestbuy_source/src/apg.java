// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.PolygonOptions;

public class apg
{

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
}
