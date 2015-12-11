// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;

public class anp
{

    public static void a(CameraPosition cameraposition, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, cameraposition.a());
        rq.a(parcel, 2, cameraposition.a, i, false);
        rq.a(parcel, 3, cameraposition.b);
        rq.a(parcel, 4, cameraposition.c);
        rq.a(parcel, 5, cameraposition.d);
        rq.a(parcel, j);
    }
}
