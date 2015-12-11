// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.CircleOptions;

public class anr
{

    public static void a(CircleOptions circleoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, circleoptions.a());
        rq.a(parcel, 2, circleoptions.b(), i, false);
        rq.a(parcel, 3, circleoptions.c());
        rq.a(parcel, 4, circleoptions.d());
        rq.a(parcel, 5, circleoptions.e());
        rq.a(parcel, 6, circleoptions.f());
        rq.a(parcel, 7, circleoptions.g());
        rq.a(parcel, 8, circleoptions.h());
        rq.a(parcel, j);
    }
}
