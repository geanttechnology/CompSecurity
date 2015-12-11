// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class apq
{

    public static void a(TileOverlayOptions tileoverlayoptions, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, tileoverlayoptions.a());
        rq.a(parcel, 2, tileoverlayoptions.b(), false);
        rq.a(parcel, 3, tileoverlayoptions.d());
        rq.a(parcel, 4, tileoverlayoptions.c());
        rq.a(parcel, i);
    }
}
