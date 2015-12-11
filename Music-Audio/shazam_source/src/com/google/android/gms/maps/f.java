// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.b.d;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public final class f
{

    private final com.google.android.gms.maps.a.f a;

    f(com.google.android.gms.maps.a.f f1)
    {
        a = f1;
    }

    public final Point a(LatLng latlng)
    {
        try
        {
            latlng = (Point)d.a(a.a(latlng));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new com.google.android.gms.maps.model.d(latlng);
        }
        return latlng;
    }

    public final VisibleRegion a()
    {
        VisibleRegion visibleregion;
        try
        {
            visibleregion = a.a();
        }
        catch (RemoteException remoteexception)
        {
            throw new com.google.android.gms.maps.model.d(remoteexception);
        }
        return visibleregion;
    }
}
