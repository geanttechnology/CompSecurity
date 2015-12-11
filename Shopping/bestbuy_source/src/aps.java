// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.VisibleRegion;

public class aps
{

    public static void a(VisibleRegion visibleregion, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, visibleregion.a());
        rq.a(parcel, 2, visibleregion.a, i, false);
        rq.a(parcel, 3, visibleregion.b, i, false);
        rq.a(parcel, 4, visibleregion.c, i, false);
        rq.a(parcel, 5, visibleregion.d, i, false);
        rq.a(parcel, 6, visibleregion.e, i, false);
        rq.a(parcel, j);
    }
}
