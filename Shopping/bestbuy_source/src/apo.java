// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

public class apo
{

    public static void a(Tile tile, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, tile.a());
        rq.a(parcel, 2, tile.a);
        rq.a(parcel, 3, tile.b);
        rq.a(parcel, 4, tile.c, false);
        rq.a(parcel, i);
    }
}
