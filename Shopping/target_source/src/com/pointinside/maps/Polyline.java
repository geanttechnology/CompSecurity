// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.internal.utils.LogUtils;
import com.pointinside.maps.model.PolylineOptions;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.pointinside.maps:
//            Location, PIMap, PIMGL, PIMGLRouteAttrs, 
//            PIMGLColor

public final class Polyline
{

    private static final String TAG = LogUtils.makeLogTag(com/pointinside/maps/Polyline.getSimpleName());
    private final PIMap mMap;
    private PolylineOptions mOptions;
    private IntByReference mReference;
    private final float mWidth;

    Polyline(PIMap pimap, float f, PolylineOptions polylineoptions)
    {
        mMap = pimap;
        mWidth = f;
        mOptions = polylineoptions;
    }

    Polyline addPoint(Location location)
    {
        mOptions.add(Location.copy(location));
        return this;
    }

    Polyline addPoints(List list)
    {
        mOptions.addAll(new LinkedList(list));
        return this;
    }

    Polyline color(int i)
    {
        mOptions.color(i);
        return this;
    }

    public int getColor()
    {
        return mOptions.getColor();
    }

    public List getPoints()
    {
        return Collections.unmodifiableList(mOptions.getPoints());
    }

    IntByReference getRef()
    {
        return mReference;
    }

    public boolean isVisible()
    {
        return mOptions.isVisible();
    }

    public void remove()
    {
        if (mReference != null)
        {
            mMap.removePolyline(this);
            PIMGL.route_delete(mMap.getPIMGLContext(), mReference);
            mReference = null;
            return;
        } else
        {
            LogUtils.logW(TAG, "Polyline has already been removed from map. Discarding remove request!");
            return;
        }
    }

    public void update()
    {
        PIMGLContext pimglcontext = mMap.getPIMGLContext();
        if (mReference != null)
        {
            PIMGL.route_delete(pimglcontext, mReference);
        }
        mReference = new IntByReference();
        PIMGL.ref_create(pimglcontext, new PointerByReference(mReference.getPointer()));
        Object obj = new PIMGLRouteAttrs();
        obj.mColor = PIMGLColor.fromColor(mOptions.getColor());
        obj.mLineWidth = mWidth;
        float f;
        if (mOptions.isVisible())
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        obj.mPercentVisible = f;
        PIMGL.route_create(pimglcontext, mReference, ((PIMGLRouteAttrs) (obj)));
        obj = mOptions.getPoints();
        if (!((List) (obj)).isEmpty())
        {
            Location location;
            IntByReference intbyreference;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); PIMGL.route_addPoint(pimglcontext, mReference, intbyreference, location))
            {
                location = (Location)((Iterator) (obj)).next();
                intbyreference = mMap.getZoneRefFromUUID(location.zone);
            }

        }
        PIMGL.route_finishRoute(pimglcontext, mReference, Pointer.NULL);
    }

    Polyline visible(boolean flag)
    {
        mOptions.visible(flag);
        return this;
    }

}
