// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class ant
{

    public static void a(GroundOverlayOptions groundoverlayoptions, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, groundoverlayoptions.b());
        rq.a(parcel, 2, groundoverlayoptions.a(), false);
        rq.a(parcel, 3, groundoverlayoptions.c(), i, false);
        rq.a(parcel, 4, groundoverlayoptions.d());
        rq.a(parcel, 5, groundoverlayoptions.e());
        rq.a(parcel, 6, groundoverlayoptions.f(), i, false);
        rq.a(parcel, 7, groundoverlayoptions.g());
        rq.a(parcel, 8, groundoverlayoptions.h());
        rq.a(parcel, 9, groundoverlayoptions.l());
        rq.a(parcel, 10, groundoverlayoptions.i());
        rq.a(parcel, 11, groundoverlayoptions.j());
        rq.a(parcel, 12, groundoverlayoptions.k());
        rq.a(parcel, j);
    }
}
