// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

public final class ail
{

    private static ajl a;

    public static aik a(LatLng latlng, float f)
    {
        try
        {
            latlng = new aik(a().a(latlng, f));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new anl(latlng);
        }
        return latlng;
    }

    private static ajl a()
    {
        return (ajl)ady.a(a, "CameraUpdateFactory is not initialized");
    }

    public static void a(ajl ajl1)
    {
        a = (ajl)ady.a(ajl1);
    }
}
