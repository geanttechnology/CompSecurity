// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.MarkerOptions;

public class ape
{

    public static void a(MarkerOptions markeroptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, markeroptions.a());
        rq.a(parcel, 2, markeroptions.c(), i, false);
        rq.a(parcel, 3, markeroptions.d(), false);
        rq.a(parcel, 4, markeroptions.e(), false);
        rq.a(parcel, 5, markeroptions.b(), false);
        rq.a(parcel, 6, markeroptions.f());
        rq.a(parcel, 7, markeroptions.g());
        rq.a(parcel, 8, markeroptions.h());
        rq.a(parcel, 9, markeroptions.i());
        rq.a(parcel, j);
    }
}
