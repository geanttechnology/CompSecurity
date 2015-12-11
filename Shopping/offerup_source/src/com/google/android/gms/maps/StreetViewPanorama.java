// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{

    private final IStreetViewPanoramaDelegate zzaJc;

    protected StreetViewPanorama(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
    {
        zzaJc = (IStreetViewPanoramaDelegate)zzx.zzw(istreetviewpanoramadelegate);
    }

    public void animateTo(StreetViewPanoramaCamera streetviewpanoramacamera, long l)
    {
        try
        {
            zzaJc.animateTo(streetviewpanoramacamera, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (StreetViewPanoramaCamera streetviewpanoramacamera)
        {
            throw new RuntimeRemoteException(streetviewpanoramacamera);
        }
    }

    public StreetViewPanoramaLocation getLocation()
    {
        StreetViewPanoramaLocation streetviewpanoramalocation;
        try
        {
            streetviewpanoramalocation = zzaJc.getStreetViewPanoramaLocation();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return streetviewpanoramalocation;
    }

    public StreetViewPanoramaCamera getPanoramaCamera()
    {
        StreetViewPanoramaCamera streetviewpanoramacamera;
        try
        {
            streetviewpanoramacamera = zzaJc.getPanoramaCamera();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return streetviewpanoramacamera;
    }

    public boolean isPanningGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJc.isPanningGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isStreetNamesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJc.isStreetNamesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isUserNavigationEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJc.isUserNavigationEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isZoomGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJc.isZoomGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation streetviewpanoramaorientation)
    {
        try
        {
            streetviewpanoramaorientation = zzaJc.orientationToPoint(streetviewpanoramaorientation);
        }
        // Misplaced declaration of an exception variable
        catch (StreetViewPanoramaOrientation streetviewpanoramaorientation)
        {
            throw new RuntimeRemoteException(streetviewpanoramaorientation);
        }
        if (streetviewpanoramaorientation == null)
        {
            return null;
        }
        streetviewpanoramaorientation = (Point)zze.zzp(streetviewpanoramaorientation);
        return streetviewpanoramaorientation;
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point)
    {
        try
        {
            point = zzaJc.pointToOrientation(zze.zzy(point));
        }
        // Misplaced declaration of an exception variable
        catch (Point point)
        {
            throw new RuntimeRemoteException(point);
        }
        return point;
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener onstreetviewpanoramacamerachangelistener)
    {
        if (onstreetviewpanoramacamerachangelistener == null)
        {
            try
            {
                zzaJc.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnStreetViewPanoramaCameraChangeListener onstreetviewpanoramacamerachangelistener)
            {
                throw new RuntimeRemoteException(onstreetviewpanoramacamerachangelistener);
            }
        }
        zzaJc.setOnStreetViewPanoramaCameraChangeListener(new _cls2(onstreetviewpanoramacamerachangelistener));
        return;
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener onstreetviewpanoramachangelistener)
    {
        if (onstreetviewpanoramachangelistener == null)
        {
            try
            {
                zzaJc.setOnStreetViewPanoramaChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnStreetViewPanoramaChangeListener onstreetviewpanoramachangelistener)
            {
                throw new RuntimeRemoteException(onstreetviewpanoramachangelistener);
            }
        }
        zzaJc.setOnStreetViewPanoramaChangeListener(new _cls1(onstreetviewpanoramachangelistener));
        return;
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener onstreetviewpanoramaclicklistener)
    {
        if (onstreetviewpanoramaclicklistener == null)
        {
            try
            {
                zzaJc.setOnStreetViewPanoramaClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnStreetViewPanoramaClickListener onstreetviewpanoramaclicklistener)
            {
                throw new RuntimeRemoteException(onstreetviewpanoramaclicklistener);
            }
        }
        zzaJc.setOnStreetViewPanoramaClickListener(new _cls3(onstreetviewpanoramaclicklistener));
        return;
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener onstreetviewpanoramalongclicklistener)
    {
        if (onstreetviewpanoramalongclicklistener == null)
        {
            try
            {
                zzaJc.setOnStreetViewPanoramaLongClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnStreetViewPanoramaLongClickListener onstreetviewpanoramalongclicklistener)
            {
                throw new RuntimeRemoteException(onstreetviewpanoramalongclicklistener);
            }
        }
        zzaJc.setOnStreetViewPanoramaLongClickListener(new _cls4(onstreetviewpanoramalongclicklistener));
        return;
    }

    public void setPanningGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJc.enablePanning(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setPosition(LatLng latlng)
    {
        try
        {
            zzaJc.setPosition(latlng);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new RuntimeRemoteException(latlng);
        }
    }

    public void setPosition(LatLng latlng, int i)
    {
        try
        {
            zzaJc.setPositionWithRadius(latlng, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LatLng latlng)
        {
            throw new RuntimeRemoteException(latlng);
        }
    }

    public void setPosition(String s)
    {
        try
        {
            zzaJc.setPositionWithID(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeRemoteException(s);
        }
    }

    public void setStreetNamesEnabled(boolean flag)
    {
        try
        {
            zzaJc.enableStreetNames(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setUserNavigationEnabled(boolean flag)
    {
        try
        {
            zzaJc.enableUserNavigation(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setZoomGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJc.enableZoom(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    IStreetViewPanoramaDelegate zzxN()
    {
        return zzaJc;
    }

    private class _cls2 extends com.google.android.gms.maps.internal.zzr.zza
    {

        final StreetViewPanorama zzaJe;
        final OnStreetViewPanoramaCameraChangeListener zzaJf;

        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetviewpanoramacamera)
        {
            zzaJf.onStreetViewPanoramaCameraChange(streetviewpanoramacamera);
        }

        _cls2(OnStreetViewPanoramaCameraChangeListener onstreetviewpanoramacamerachangelistener)
        {
            zzaJe = StreetViewPanorama.this;
            zzaJf = onstreetviewpanoramacamerachangelistener;
            super();
        }

        private class OnStreetViewPanoramaCameraChangeListener
        {

            public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetviewpanoramacamera);
        }

    }


    private class _cls1 extends com.google.android.gms.maps.internal.zzs.zza
    {

        final OnStreetViewPanoramaChangeListener zzaJd;
        final StreetViewPanorama zzaJe;

        public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetviewpanoramalocation)
        {
            zzaJd.onStreetViewPanoramaChange(streetviewpanoramalocation);
        }

        _cls1(OnStreetViewPanoramaChangeListener onstreetviewpanoramachangelistener)
        {
            zzaJe = StreetViewPanorama.this;
            zzaJd = onstreetviewpanoramachangelistener;
            super();
        }

        private class OnStreetViewPanoramaChangeListener
        {

            public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetviewpanoramalocation);
        }

    }


    private class _cls3 extends com.google.android.gms.maps.internal.zzt.zza
    {

        final StreetViewPanorama zzaJe;
        final OnStreetViewPanoramaClickListener zzaJg;

        public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetviewpanoramaorientation)
        {
            zzaJg.onStreetViewPanoramaClick(streetviewpanoramaorientation);
        }

        _cls3(OnStreetViewPanoramaClickListener onstreetviewpanoramaclicklistener)
        {
            zzaJe = StreetViewPanorama.this;
            zzaJg = onstreetviewpanoramaclicklistener;
            super();
        }

        private class OnStreetViewPanoramaClickListener
        {

            public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetviewpanoramaorientation);
        }

    }


    private class _cls4 extends com.google.android.gms.maps.internal.zzu.zza
    {

        final StreetViewPanorama zzaJe;
        final OnStreetViewPanoramaLongClickListener zzaJh;

        public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetviewpanoramaorientation)
        {
            zzaJh.onStreetViewPanoramaLongClick(streetviewpanoramaorientation);
        }

        _cls4(OnStreetViewPanoramaLongClickListener onstreetviewpanoramalongclicklistener)
        {
            zzaJe = StreetViewPanorama.this;
            zzaJh = onstreetviewpanoramalongclicklistener;
            super();
        }

        private class OnStreetViewPanoramaLongClickListener
        {

            public abstract void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetviewpanoramaorientation);
        }

    }

}
