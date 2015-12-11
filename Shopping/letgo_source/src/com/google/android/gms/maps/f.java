// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import android.support.v7.ll;
import android.support.v7.yr;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.e;

public final class f
{

    private final yr a;

    f(yr yr1)
    {
        a = yr1;
    }

    public Point a(LatLng latlng)
    {
        try
        {
            latlng = (Point)ll.a(a.a(latlng));
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new e(latlng);
        }
        return latlng;
    }

    public LatLng a(Point point)
    {
        try
        {
            point = a.a(ll.a(point));
        }
        // Misplaced declaration of an exception variable
        catch (Point point)
        {
            throw new e(point);
        }
        return point;
    }
}
