// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.zzi;

// Referenced classes of package com.google.android.gms.maps:
//            CameraUpdate, Projection, UiSettings, LocationSource

public final class GoogleMap
{
    public static interface CancelableCallback
    {

        public abstract void onCancel();

        public abstract void onFinish();
    }

    public static interface InfoWindowAdapter
    {

        public abstract View getInfoContents(Marker marker);

        public abstract View getInfoWindow(Marker marker);
    }

    public static interface OnCameraChangeListener
    {

        public abstract void onCameraChange(CameraPosition cameraposition);
    }

    public static interface OnInfoWindowClickListener
    {

        public abstract void onInfoWindowClick(Marker marker);
    }

    public static interface OnMapClickListener
    {

        public abstract void onMapClick(LatLng latlng);
    }

    public static interface OnMapLongClickListener
    {

        public abstract void onMapLongClick(LatLng latlng);
    }

    public static interface OnMarkerClickListener
    {

        public abstract boolean onMarkerClick(Marker marker);
    }

    public static interface OnMyLocationChangeListener
    {

        public abstract void onMyLocationChange(Location location);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza
    {

        private final CancelableCallback zzaBH;

        public void onCancel()
        {
            zzaBH.onCancel();
        }

        public void onFinish()
        {
            zzaBH.onFinish();
        }

        zza(CancelableCallback cancelablecallback)
        {
            zzaBH = cancelablecallback;
        }
    }


    private final IGoogleMapDelegate zzaBp;
    private UiSettings zzaBq;

    protected GoogleMap(IGoogleMapDelegate igooglemapdelegate)
    {
        zzaBp = (IGoogleMapDelegate)zzu.zzu(igooglemapdelegate);
    }

    public final Marker addMarker(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = zzaBp.addMarker(markeroptions);
        }
        // Misplaced declaration of an exception variable
        catch (MarkerOptions markeroptions)
        {
            throw new RuntimeRemoteException(markeroptions);
        }
        if (markeroptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        markeroptions = new Marker(markeroptions);
        return markeroptions;
        return null;
    }

    public final void animateCamera(CameraUpdate cameraupdate)
    {
        try
        {
            zzaBp.animateCamera(cameraupdate.zzvg());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
    }

    public final void animateCamera(CameraUpdate cameraupdate, int i, CancelableCallback cancelablecallback)
    {
        IGoogleMapDelegate igooglemapdelegate;
        zzd zzd;
        try
        {
            igooglemapdelegate = zzaBp;
            zzd = cameraupdate.zzvg();
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
        if (cancelablecallback != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        cameraupdate = null;
        igooglemapdelegate.animateCameraWithDurationAndCallback(zzd, i, cameraupdate);
        return;
        cameraupdate = new zza(cancelablecallback);
        break MISSING_BLOCK_LABEL_18;
    }

    public final void animateCamera(CameraUpdate cameraupdate, CancelableCallback cancelablecallback)
    {
        IGoogleMapDelegate igooglemapdelegate;
        zzd zzd;
        try
        {
            igooglemapdelegate = zzaBp;
            zzd = cameraupdate.zzvg();
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
        if (cancelablecallback != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        cameraupdate = null;
        igooglemapdelegate.animateCameraWithCallback(zzd, cameraupdate);
        return;
        cameraupdate = new zza(cancelablecallback);
        break MISSING_BLOCK_LABEL_17;
    }

    public final void clear()
    {
        try
        {
            zzaBp.clear();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final CameraPosition getCameraPosition()
    {
        CameraPosition cameraposition;
        try
        {
            cameraposition = zzaBp.getCameraPosition();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return cameraposition;
    }

    public final Projection getProjection()
    {
        Projection projection;
        try
        {
            projection = new Projection(zzaBp.getProjection());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return projection;
    }

    public final UiSettings getUiSettings()
    {
        UiSettings uisettings;
        try
        {
            if (zzaBq == null)
            {
                zzaBq = new UiSettings(zzaBp.getUiSettings());
            }
            uisettings = zzaBq;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return uisettings;
    }

    public final void moveCamera(CameraUpdate cameraupdate)
    {
        try
        {
            zzaBp.moveCamera(cameraupdate.zzvg());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infowindowadapter)
    {
        if (infowindowadapter == null)
        {
            try
            {
                zzaBp.setInfoWindowAdapter(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InfoWindowAdapter infowindowadapter)
            {
                throw new RuntimeRemoteException(infowindowadapter);
            }
        }
        zzaBp.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza(infowindowadapter) {

            final InfoWindowAdapter zzaBG;
            final GoogleMap zzaBs;

            public zzd zzf(zzi zzi)
            {
                return zze.zzw(zzaBG.getInfoWindow(new Marker(zzi)));
            }

            public zzd zzg(zzi zzi)
            {
                return zze.zzw(zzaBG.getInfoContents(new Marker(zzi)));
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBG = infowindowadapter;
                super();
            }
        });
        return;
    }

    public final void setLocationSource(LocationSource locationsource)
    {
        if (locationsource == null)
        {
            try
            {
                zzaBp.setLocationSource(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LocationSource locationsource)
            {
                throw new RuntimeRemoteException(locationsource);
            }
        }
        zzaBp.setLocationSource(new com.google.android.gms.maps.internal.ILocationSourceDelegate.zza(locationsource) {

            final GoogleMap zzaBs;
            final LocationSource zzaBx;

            public void activate(com.google.android.gms.maps.internal.zzi zzi)
            {
                zzaBx.activate(new LocationSource.OnLocationChangedListener(this, zzi) {

                    final com.google.android.gms.maps.internal.zzi zzaBy;
                    final _cls6 zzaBz;

            
            {
                zzaBz = _pcls6;
                zzaBy = zzi;
                super();
            }
                });
            }

            public void deactivate()
            {
                zzaBx.deactivate();
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBx = locationsource;
                super();
            }
        });
        return;
    }

    public final void setMyLocationEnabled(boolean flag)
    {
        try
        {
            zzaBp.setMyLocationEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener oncamerachangelistener)
    {
        if (oncamerachangelistener == null)
        {
            try
            {
                zzaBp.setOnCameraChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnCameraChangeListener oncamerachangelistener)
            {
                throw new RuntimeRemoteException(oncamerachangelistener);
            }
        }
        zzaBp.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zzf.zza(oncamerachangelistener) {

            final OnCameraChangeListener zzaBA;
            final GoogleMap zzaBs;

            public void onCameraChange(CameraPosition cameraposition)
            {
                zzaBA.onCameraChange(cameraposition);
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBA = oncamerachangelistener;
                super();
            }
        });
        return;
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener oninfowindowclicklistener)
    {
        if (oninfowindowclicklistener == null)
        {
            try
            {
                zzaBp.setOnInfoWindowClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnInfoWindowClickListener oninfowindowclicklistener)
            {
                throw new RuntimeRemoteException(oninfowindowclicklistener);
            }
        }
        zzaBp.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.zzh.zza(oninfowindowclicklistener) {

            final OnInfoWindowClickListener zzaBF;
            final GoogleMap zzaBs;

            public void zze(zzi zzi)
            {
                zzaBF.onInfoWindowClick(new Marker(zzi));
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBF = oninfowindowclicklistener;
                super();
            }
        });
        return;
    }

    public final void setOnMapClickListener(OnMapClickListener onmapclicklistener)
    {
        if (onmapclicklistener == null)
        {
            try
            {
                zzaBp.setOnMapClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapClickListener onmapclicklistener)
            {
                throw new RuntimeRemoteException(onmapclicklistener);
            }
        }
        zzaBp.setOnMapClickListener(new com.google.android.gms.maps.internal.zzj.zza(onmapclicklistener) {

            final OnMapClickListener zzaBB;
            final GoogleMap zzaBs;

            public void onMapClick(LatLng latlng)
            {
                zzaBB.onMapClick(latlng);
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBB = onmapclicklistener;
                super();
            }
        });
        return;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onmaplongclicklistener)
    {
        if (onmaplongclicklistener == null)
        {
            try
            {
                zzaBp.setOnMapLongClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapLongClickListener onmaplongclicklistener)
            {
                throw new RuntimeRemoteException(onmaplongclicklistener);
            }
        }
        zzaBp.setOnMapLongClickListener(new com.google.android.gms.maps.internal.zzl.zza(onmaplongclicklistener) {

            final OnMapLongClickListener zzaBC;
            final GoogleMap zzaBs;

            public void onMapLongClick(LatLng latlng)
            {
                zzaBC.onMapLongClick(latlng);
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBC = onmaplongclicklistener;
                super();
            }
        });
        return;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        if (onmarkerclicklistener == null)
        {
            try
            {
                zzaBp.setOnMarkerClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMarkerClickListener onmarkerclicklistener)
            {
                throw new RuntimeRemoteException(onmarkerclicklistener);
            }
        }
        zzaBp.setOnMarkerClickListener(new com.google.android.gms.maps.internal.zzn.zza(onmarkerclicklistener) {

            final OnMarkerClickListener zzaBD;
            final GoogleMap zzaBs;

            public boolean zza(zzi zzi)
            {
                return zzaBD.onMarkerClick(new Marker(zzi));
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBD = onmarkerclicklistener;
                super();
            }
        });
        return;
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onmylocationchangelistener)
    {
        if (onmylocationchangelistener == null)
        {
            try
            {
                zzaBp.setOnMyLocationChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMyLocationChangeListener onmylocationchangelistener)
            {
                throw new RuntimeRemoteException(onmylocationchangelistener);
            }
        }
        zzaBp.setOnMyLocationChangeListener(new com.google.android.gms.maps.internal.zzq.zza(onmylocationchangelistener) {

            final GoogleMap zzaBs;
            final OnMyLocationChangeListener zzaBt;

            public void zzc(Location location)
            {
                zzaBt.onMyLocationChange(location);
            }

            public void zzo(zzd zzd)
            {
                zzaBt.onMyLocationChange((Location)zze.zzn(zzd));
            }

            
            {
                zzaBs = GoogleMap.this;
                zzaBt = onmylocationchangelistener;
                super();
            }
        });
        return;
    }
}
