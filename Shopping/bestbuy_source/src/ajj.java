// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.GoogleMapOptions;

public class ajj
{

    public static void a(GoogleMapOptions googlemapoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, googlemapoptions.a());
        rq.a(parcel, 2, googlemapoptions.b());
        rq.a(parcel, 3, googlemapoptions.c());
        rq.a(parcel, 4, googlemapoptions.l());
        rq.a(parcel, 5, googlemapoptions.m(), i, false);
        rq.a(parcel, 6, googlemapoptions.d());
        rq.a(parcel, 7, googlemapoptions.e());
        rq.a(parcel, 8, googlemapoptions.f());
        rq.a(parcel, 9, googlemapoptions.g());
        rq.a(parcel, 10, googlemapoptions.h());
        rq.a(parcel, 11, googlemapoptions.i());
        rq.a(parcel, j);
    }
}
