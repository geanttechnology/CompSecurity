// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.graphics.Point;
import com.amazon.geo.mapsv2.internal.IProjectionDelegate;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.VisibleRegion;
import com.amazon.geo.mapsv2.model.pvt.Primitives;

public final class Projection
{

    private final IProjectionDelegate mProjectionDelegate;

    Projection(IProjectionDelegate iprojectiondelegate)
    {
        mProjectionDelegate = iprojectiondelegate;
        mProjectionDelegate.setWrapper(this);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (Projection)obj;
        if (mProjectionDelegate != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Projection) (obj)).mProjectionDelegate == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mProjectionDelegate.equals(((Projection) (obj)).mProjectionDelegate)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public LatLng fromScreenLocation(Point point)
    {
        return Primitives.create(mProjectionDelegate.fromScreenLocation(point));
    }

    public VisibleRegion getVisibleRegion()
    {
        return Primitives.create(mProjectionDelegate.getVisibleRegion());
    }

    public int hashCode()
    {
        int i;
        if (mProjectionDelegate == null)
        {
            i = 0;
        } else
        {
            i = mProjectionDelegate.hashCode();
        }
        return i + 31;
    }

    public Point toScreenLocation(LatLng latlng)
    {
        return mProjectionDelegate.toScreenLocation(Primitives.create(latlng));
    }
}
