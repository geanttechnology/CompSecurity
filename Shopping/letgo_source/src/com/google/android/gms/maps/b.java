// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import android.support.v7.ym;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.e;

// Referenced classes of package com.google.android.gms.maps:
//            a

public final class b
{

    private static ym a;

    private static ym a()
    {
        return (ym)x.a(a, "CameraUpdateFactory is not initialized");
    }

    public static a a(LatLng latlng)
    {
        try
        {
            latlng = new a(a().a(latlng));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new e(latlng);
        }
        return latlng;
    }

    public static a a(LatLng latlng, float f)
    {
        try
        {
            latlng = new a(a().a(latlng, f));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new e(latlng);
        }
        return latlng;
    }

    public static void a(ym ym1)
    {
        a = (ym)x.a(ym1);
    }
}
