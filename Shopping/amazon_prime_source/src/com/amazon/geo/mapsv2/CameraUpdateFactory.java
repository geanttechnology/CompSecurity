// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.graphics.Point;
import com.amazon.geo.mapsv2.internal.ICameraUpdateDelegate;
import com.amazon.geo.mapsv2.internal.ICameraUpdateFactoryDelegate;
import com.amazon.geo.mapsv2.internal.IMapEngineDelegate;
import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.model.CameraPosition;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.LatLngBounds;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import com.amazon.geo.mapsv2.pvt.RemoteContextUtils;
import com.amazon.geo.mapsv2.pvt.Wrappers;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtil;

// Referenced classes of package com.amazon.geo.mapsv2:
//            CameraUpdate

public final class CameraUpdateFactory
{

    private static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator CAMERAUPDATE_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public CameraUpdate newWrapper(ICameraUpdateDelegate icameraupdatedelegate)
        {
            return new CameraUpdate(icameraupdatedelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((ICameraUpdateDelegate)iobjectdelegate);
        }

    };

    private CameraUpdateFactory()
    {
    }

    private static CameraUpdate createCameraUpdate(ICameraUpdateDelegate icameraupdatedelegate)
    {
        return (CameraUpdate)Wrappers.create(icameraupdatedelegate, CAMERAUPDATE_CREATOR);
    }

    private static ICameraUpdateFactoryDelegate getFactory()
    {
        IMapEngineDelegate imapenginedelegate = null;
        android.content.Context context = AmazonMapsRuntimeUtil.getRemoteContext(null);
        if (context != null)
        {
            imapenginedelegate = RemoteContextUtils.getMapEngine(context);
        }
        if (imapenginedelegate == null)
        {
            throw new NullPointerException("CameraUpdateFactory is not initialized");
        } else
        {
            return imapenginedelegate.getCameraUpdateFactory();
        }
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraposition)
    {
        return createCameraUpdate(getFactory().newCameraPosition(Primitives.create(cameraposition)));
    }

    public static CameraUpdate newLatLng(LatLng latlng)
    {
        return createCameraUpdate(getFactory().newLatLng(Primitives.create(latlng)));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latlngbounds, int i)
    {
        return createCameraUpdate(getFactory().newLatLngBounds(Primitives.create(latlngbounds), i));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latlngbounds, int i, int j, int k)
    {
        return createCameraUpdate(getFactory().newLatLngBounds(Primitives.create(latlngbounds), i, j, k));
    }

    public static CameraUpdate newLatLngZoom(LatLng latlng, float f)
    {
        return createCameraUpdate(getFactory().newLatLngZoom(Primitives.create(latlng), f));
    }

    public static CameraUpdate scrollBy(float f, float f1)
    {
        return createCameraUpdate(getFactory().scrollBy(f, f1));
    }

    public static CameraUpdate zoomBy(float f)
    {
        return createCameraUpdate(getFactory().zoomBy(f));
    }

    public static CameraUpdate zoomBy(float f, Point point)
    {
        return createCameraUpdate(getFactory().zoomBy(f, point));
    }

    public static CameraUpdate zoomIn()
    {
        return createCameraUpdate(getFactory().zoomIn());
    }

    public static CameraUpdate zoomOut()
    {
        return createCameraUpdate(getFactory().zoomOut());
    }

    public static CameraUpdate zoomTo(float f)
    {
        return createCameraUpdate(getFactory().zoomTo(f));
    }

}
