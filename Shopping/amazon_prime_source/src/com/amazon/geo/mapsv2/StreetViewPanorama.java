// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.graphics.Point;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.StreetViewPanoramaCamera;
import com.amazon.geo.mapsv2.model.StreetViewPanoramaLocation;
import com.amazon.geo.mapsv2.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{
    public static interface OnStreetViewPanoramaCameraChangeListener
    {

        public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetviewpanoramacamera);
    }

    public static interface OnStreetViewPanoramaChangeListener
    {

        public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetviewpanoramalocation);
    }

    public static interface OnStreetViewPanoramaClickListener
    {

        public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetviewpanoramaorientation);
    }

    public static interface OnStreetViewPanoramaLongClickListener
    {

        public abstract void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetviewpanoramaorientation);
    }


    private StreetViewPanorama()
    {
        throw new UnsupportedOperationException("The street view API is not supported.");
    }

    public void animateTo(StreetViewPanoramaCamera streetviewpanoramacamera, long l)
    {
    }

    public StreetViewPanoramaLocation getLocation()
    {
        return null;
    }

    public StreetViewPanoramaCamera getPanoramaCamera()
    {
        return null;
    }

    public boolean isPanningGesturesEnabled()
    {
        return false;
    }

    public boolean isStreetNamesEnabled()
    {
        return false;
    }

    public boolean isUserNavigationEnabled()
    {
        return false;
    }

    public boolean isZoomGesturesEnabled()
    {
        return false;
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        return null;
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point)
    {
        return null;
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onstreetviewpanoramacamerachangelistener)
    {
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onstreetviewpanoramachangelistener)
    {
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onstreetviewpanoramaclicklistener)
    {
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener onstreetviewpanoramalongclicklistener)
    {
    }

    public void setPanningGesturesEnabled(boolean flag)
    {
    }

    public void setPosition(LatLng latlng)
    {
    }

    public void setPosition(LatLng latlng, int i)
    {
    }

    public void setPosition(String s)
    {
    }

    public void setStreetNamesEnabled(boolean flag)
    {
    }

    public void setUserNavigationEnabled(boolean flag)
    {
    }

    public void setZoomGesturesEnabled(boolean flag)
    {
    }
}
