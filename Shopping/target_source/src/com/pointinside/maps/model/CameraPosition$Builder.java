// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;

import android.graphics.PointF;
import com.pointinside.model.Zone;

// Referenced classes of package com.pointinside.maps.model:
//            CameraPosition

public static final class tilt
{

    private PointF pointInZone;
    private float rotation;
    private float tilt;
    private float visibleMapWidth;
    private Zone zone;

    public CameraPosition build()
    {
        return new CameraPosition(this, null);
    }

    public tilt pointInZone(PointF pointf)
    {
        pointInZone = pointf;
        return this;
    }

    public pointInZone rotation(float f)
    {
        rotation = f;
        return this;
    }

    public rotation tilt(float f)
    {
        if (0.0F <= f && f <= 90F)
        {
            tilt = f;
        }
        return this;
    }

    public tilt visibleMapWidth(float f)
    {
        if (f > 0.0F)
        {
            visibleMapWidth = f;
        }
        return this;
    }

    public visibleMapWidth zone(Zone zone1)
    {
        zone = zone1;
        return this;
    }

    public zone zoomPercent(float f)
    {
        if (zone != null && f > 0.0F)
        {
            visibleMapWidth = zone.getImageSizeInMapUnits().x / f;
        }
        return this;
    }






    public ()
    {
        visibleMapWidth = 0.0F;
    }

    public visibleMapWidth(CameraPosition cameraposition)
    {
        zone = cameraposition.zone;
        pointInZone = new PointF(cameraposition.pointInZone.x, cameraposition.pointInZone.y);
        rotation = cameraposition.rotation;
        visibleMapWidth = cameraposition.visibleMapWidth;
        tilt = cameraposition.tilt;
    }
}
