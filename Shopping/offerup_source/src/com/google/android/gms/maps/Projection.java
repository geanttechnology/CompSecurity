// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection
{

    private final IProjectionDelegate zzaJb;

    Projection(IProjectionDelegate iprojectiondelegate)
    {
        zzaJb = iprojectiondelegate;
    }

    public final LatLng fromScreenLocation(Point point)
    {
        try
        {
            point = zzaJb.fromScreenLocation(zze.zzy(point));
        }
        // Misplaced declaration of an exception variable
        catch (Point point)
        {
            throw new RuntimeRemoteException(point);
        }
        return point;
    }

    public final VisibleRegion getVisibleRegion()
    {
        VisibleRegion visibleregion;
        try
        {
            visibleregion = zzaJb.getVisibleRegion();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return visibleregion;
    }

    public final Point toScreenLocation(LatLng latlng)
    {
        try
        {
            latlng = (Point)zze.zzp(zzaJb.toScreenLocation(latlng));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new RuntimeRemoteException(latlng);
        }
        return latlng;
    }
}
