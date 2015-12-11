// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;

// Referenced classes of package com.google.android.gms.maps:
//            CameraUpdate, Projection, UiSettings, LocationSource

public final class GoogleMap
{

    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaIh;
    private UiSettings zzaIi;

    protected GoogleMap(IGoogleMapDelegate igooglemapdelegate)
    {
        zzaIh = (IGoogleMapDelegate)zzx.zzw(igooglemapdelegate);
    }

    public final Circle addCircle(CircleOptions circleoptions)
    {
        try
        {
            circleoptions = new Circle(zzaIh.addCircle(circleoptions));
        }
        // Misplaced declaration of an exception variable
        catch (CircleOptions circleoptions)
        {
            throw new RuntimeRemoteException(circleoptions);
        }
        return circleoptions;
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundoverlayoptions)
    {
        try
        {
            groundoverlayoptions = zzaIh.addGroundOverlay(groundoverlayoptions);
        }
        // Misplaced declaration of an exception variable
        catch (GroundOverlayOptions groundoverlayoptions)
        {
            throw new RuntimeRemoteException(groundoverlayoptions);
        }
        if (groundoverlayoptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        groundoverlayoptions = new GroundOverlay(groundoverlayoptions);
        return groundoverlayoptions;
        return null;
    }

    public final Marker addMarker(MarkerOptions markeroptions)
    {
        try
        {
            markeroptions = zzaIh.addMarker(markeroptions);
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

    public final Polygon addPolygon(PolygonOptions polygonoptions)
    {
        try
        {
            polygonoptions = new Polygon(zzaIh.addPolygon(polygonoptions));
        }
        // Misplaced declaration of an exception variable
        catch (PolygonOptions polygonoptions)
        {
            throw new RuntimeRemoteException(polygonoptions);
        }
        return polygonoptions;
    }

    public final Polyline addPolyline(PolylineOptions polylineoptions)
    {
        try
        {
            polylineoptions = new Polyline(zzaIh.addPolyline(polylineoptions));
        }
        // Misplaced declaration of an exception variable
        catch (PolylineOptions polylineoptions)
        {
            throw new RuntimeRemoteException(polylineoptions);
        }
        return polylineoptions;
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileoverlayoptions)
    {
        try
        {
            tileoverlayoptions = zzaIh.addTileOverlay(tileoverlayoptions);
        }
        // Misplaced declaration of an exception variable
        catch (TileOverlayOptions tileoverlayoptions)
        {
            throw new RuntimeRemoteException(tileoverlayoptions);
        }
        if (tileoverlayoptions == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        tileoverlayoptions = new TileOverlay(tileoverlayoptions);
        return tileoverlayoptions;
        return null;
    }

    public final void animateCamera(CameraUpdate cameraupdate)
    {
        try
        {
            zzaIh.animateCamera(cameraupdate.zzxw());
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
        com.google.android.gms.dynamic.zzd zzd;
        try
        {
            igooglemapdelegate = zzaIh;
            zzd = cameraupdate.zzxw();
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
        com.google.android.gms.dynamic.zzd zzd;
        try
        {
            igooglemapdelegate = zzaIh;
            zzd = cameraupdate.zzxw();
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
            zzaIh.clear();
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
            cameraposition = zzaIh.getCameraPosition();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return cameraposition;
    }

    public final IndoorBuilding getFocusedBuilding()
    {
        Object obj;
        try
        {
            obj = zzaIh.getFocusedBuilding();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        obj = new IndoorBuilding(((com.google.android.gms.maps.model.internal.zzd) (obj)));
        return ((IndoorBuilding) (obj));
        return null;
    }

    public final int getMapType()
    {
        int i;
        try
        {
            i = zzaIh.getMapType();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return i;
    }

    public final float getMaxZoomLevel()
    {
        float f;
        try
        {
            f = zzaIh.getMaxZoomLevel();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final float getMinZoomLevel()
    {
        float f;
        try
        {
            f = zzaIh.getMinZoomLevel();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return f;
    }

    public final Location getMyLocation()
    {
        Location location;
        try
        {
            location = zzaIh.getMyLocation();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return location;
    }

    public final Projection getProjection()
    {
        Projection projection;
        try
        {
            projection = new Projection(zzaIh.getProjection());
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
            if (zzaIi == null)
            {
                zzaIi = new UiSettings(zzaIh.getUiSettings());
            }
            uisettings = zzaIi;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return uisettings;
    }

    public final boolean isBuildingsEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaIh.isBuildingsEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isIndoorEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaIh.isIndoorEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isMyLocationEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaIh.isMyLocationEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isTrafficEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaIh.isTrafficEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final void moveCamera(CameraUpdate cameraupdate)
    {
        try
        {
            zzaIh.moveCamera(cameraupdate.zzxw());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CameraUpdate cameraupdate)
        {
            throw new RuntimeRemoteException(cameraupdate);
        }
    }

    public final void setBuildingsEnabled(boolean flag)
    {
        try
        {
            zzaIh.setBuildingsEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setContentDescription(String s)
    {
        try
        {
            zzaIh.setContentDescription(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeRemoteException(s);
        }
    }

    public final boolean setIndoorEnabled(boolean flag)
    {
        try
        {
            flag = zzaIh.setIndoorEnabled(flag);
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infowindowadapter)
    {
        if (infowindowadapter == null)
        {
            try
            {
                zzaIh.setInfoWindowAdapter(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InfoWindowAdapter infowindowadapter)
            {
                throw new RuntimeRemoteException(infowindowadapter);
            }
        }
        zzaIh.setInfoWindowAdapter(new _cls13(infowindowadapter));
        return;
    }

    public final void setLocationSource(LocationSource locationsource)
    {
        if (locationsource == null)
        {
            try
            {
                zzaIh.setLocationSource(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (LocationSource locationsource)
            {
                throw new RuntimeRemoteException(locationsource);
            }
        }
        zzaIh.setLocationSource(new _cls6(locationsource));
        return;
    }

    public final void setMapType(int i)
    {
        try
        {
            zzaIh.setMapType(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setMyLocationEnabled(boolean flag)
    {
        try
        {
            zzaIh.setMyLocationEnabled(flag);
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
                zzaIh.setOnCameraChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnCameraChangeListener oncamerachangelistener)
            {
                throw new RuntimeRemoteException(oncamerachangelistener);
            }
        }
        zzaIh.setOnCameraChangeListener(new _cls7(oncamerachangelistener));
        return;
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onindoorstatechangelistener)
    {
        if (onindoorstatechangelistener == null)
        {
            try
            {
                zzaIh.setOnIndoorStateChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnIndoorStateChangeListener onindoorstatechangelistener)
            {
                throw new RuntimeRemoteException(onindoorstatechangelistener);
            }
        }
        zzaIh.setOnIndoorStateChangeListener(new _cls1(onindoorstatechangelistener));
        return;
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener oninfowindowclicklistener)
    {
        if (oninfowindowclicklistener == null)
        {
            try
            {
                zzaIh.setOnInfoWindowClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnInfoWindowClickListener oninfowindowclicklistener)
            {
                throw new RuntimeRemoteException(oninfowindowclicklistener);
            }
        }
        zzaIh.setOnInfoWindowClickListener(new _cls12(oninfowindowclicklistener));
        return;
    }

    public final void setOnMapClickListener(OnMapClickListener onmapclicklistener)
    {
        if (onmapclicklistener == null)
        {
            try
            {
                zzaIh.setOnMapClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapClickListener onmapclicklistener)
            {
                throw new RuntimeRemoteException(onmapclicklistener);
            }
        }
        zzaIh.setOnMapClickListener(new _cls8(onmapclicklistener));
        return;
    }

    public final void setOnMapLoadedCallback(OnMapLoadedCallback onmaploadedcallback)
    {
        if (onmaploadedcallback == null)
        {
            try
            {
                zzaIh.setOnMapLoadedCallback(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapLoadedCallback onmaploadedcallback)
            {
                throw new RuntimeRemoteException(onmaploadedcallback);
            }
        }
        zzaIh.setOnMapLoadedCallback(new _cls4(onmaploadedcallback));
        return;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onmaplongclicklistener)
    {
        if (onmaplongclicklistener == null)
        {
            try
            {
                zzaIh.setOnMapLongClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMapLongClickListener onmaplongclicklistener)
            {
                throw new RuntimeRemoteException(onmaplongclicklistener);
            }
        }
        zzaIh.setOnMapLongClickListener(new _cls9(onmaplongclicklistener));
        return;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        if (onmarkerclicklistener == null)
        {
            try
            {
                zzaIh.setOnMarkerClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMarkerClickListener onmarkerclicklistener)
            {
                throw new RuntimeRemoteException(onmarkerclicklistener);
            }
        }
        zzaIh.setOnMarkerClickListener(new _cls10(onmarkerclicklistener));
        return;
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onmarkerdraglistener)
    {
        if (onmarkerdraglistener == null)
        {
            try
            {
                zzaIh.setOnMarkerDragListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMarkerDragListener onmarkerdraglistener)
            {
                throw new RuntimeRemoteException(onmarkerdraglistener);
            }
        }
        zzaIh.setOnMarkerDragListener(new _cls11(onmarkerdraglistener));
        return;
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
    {
        if (onmylocationbuttonclicklistener == null)
        {
            try
            {
                zzaIh.setOnMyLocationButtonClickListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
            {
                throw new RuntimeRemoteException(onmylocationbuttonclicklistener);
            }
        }
        zzaIh.setOnMyLocationButtonClickListener(new _cls3(onmylocationbuttonclicklistener));
        return;
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onmylocationchangelistener)
    {
        if (onmylocationchangelistener == null)
        {
            try
            {
                zzaIh.setOnMyLocationChangeListener(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnMyLocationChangeListener onmylocationchangelistener)
            {
                throw new RuntimeRemoteException(onmylocationchangelistener);
            }
        }
        zzaIh.setOnMyLocationChangeListener(new _cls2(onmylocationchangelistener));
        return;
    }

    public final void setPadding(int i, int j, int k, int l)
    {
        try
        {
            zzaIh.setPadding(i, j, k, l);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setTrafficEnabled(boolean flag)
    {
        try
        {
            zzaIh.setTrafficEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotreadycallback)
    {
        snapshot(snapshotreadycallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotreadycallback, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            bitmap = zze.zzy(bitmap);
        } else
        {
            bitmap = null;
        }
        bitmap = (zze)bitmap;
        try
        {
            zzaIh.snapshot(new _cls5(snapshotreadycallback), bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SnapshotReadyCallback snapshotreadycallback)
        {
            throw new RuntimeRemoteException(snapshotreadycallback);
        }
    }

    public final void stopAnimation()
    {
        try
        {
            zzaIh.stopAnimation();
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    final IGoogleMapDelegate zzxy()
    {
        return zzaIh;
    }

    private class zza extends com.google.android.gms.maps.internal.zzb.zza
    {

        private final CancelableCallback zzaIz;

        public final void onCancel()
        {
            zzaIz.onCancel();
        }

        public final void onFinish()
        {
            zzaIz.onFinish();
        }

        zza(CancelableCallback cancelablecallback)
        {
            zzaIz = cancelablecallback;
        }

        private class CancelableCallback
        {

            public abstract void onCancel();

            public abstract void onFinish();
        }

    }


    private class _cls13 extends com.google.android.gms.maps.internal.zzd.zza
    {

        final GoogleMap zzaIk;
        final InfoWindowAdapter zzaIy;

        public zzd zzf(zzf zzf1)
        {
            return zze.zzy(zzaIy.getInfoWindow(new Marker(zzf1)));
        }

        public zzd zzg(zzf zzf1)
        {
            return zze.zzy(zzaIy.getInfoContents(new Marker(zzf1)));
        }

        _cls13(InfoWindowAdapter infowindowadapter)
        {
            zzaIk = GoogleMap.this;
            zzaIy = infowindowadapter;
            super();
        }

        private class InfoWindowAdapter
        {

            public abstract View getInfoContents(Marker marker);

            public abstract View getInfoWindow(Marker marker);
        }

    }


    private class _cls6 extends com.google.android.gms.maps.internal.ILocationSourceDelegate.zza
    {

        final GoogleMap zzaIk;
        final LocationSource zzaIp;

        public void activate(zzh zzh)
        {
            class _cls1
                implements LocationSource.OnLocationChangedListener
            {

                final zzh zzaIq;
                final _cls6 zzaIr;

                public void onLocationChanged(Location location)
                {
                    try
                    {
                        zzaIq.zzd(location);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Location location)
                    {
                        throw new RuntimeRemoteException(location);
                    }
                }

                _cls1(zzh zzh1)
                {
                    zzaIr = _cls6.this;
                    zzaIq = zzh1;
                    super();
                }
            }

            zzaIp.activate(new _cls1(zzh));
        }

        public void deactivate()
        {
            zzaIp.deactivate();
        }

        _cls6(LocationSource locationsource)
        {
            zzaIk = GoogleMap.this;
            zzaIp = locationsource;
            super();
        }
    }


    private class _cls7 extends com.google.android.gms.maps.internal.zze.zza
    {

        final GoogleMap zzaIk;
        final OnCameraChangeListener zzaIs;

        public void onCameraChange(CameraPosition cameraposition)
        {
            zzaIs.onCameraChange(cameraposition);
        }

        _cls7(OnCameraChangeListener oncamerachangelistener)
        {
            zzaIk = GoogleMap.this;
            zzaIs = oncamerachangelistener;
            super();
        }

        private class OnCameraChangeListener
        {

            public abstract void onCameraChange(CameraPosition cameraposition);
        }

    }


    private class _cls1 extends com.google.android.gms.maps.internal.zzf.zza
    {

        final OnIndoorStateChangeListener zzaIj;
        final GoogleMap zzaIk;

        public void onIndoorBuildingFocused()
        {
            zzaIj.onIndoorBuildingFocused();
        }

        public void zza(com.google.android.gms.maps.model.internal.zzd zzd)
        {
            zzaIj.onIndoorLevelActivated(new IndoorBuilding(zzd));
        }

        _cls1(OnIndoorStateChangeListener onindoorstatechangelistener)
        {
            zzaIk = GoogleMap.this;
            zzaIj = onindoorstatechangelistener;
            super();
        }

        private class OnIndoorStateChangeListener
        {

            public abstract void onIndoorBuildingFocused();

            public abstract void onIndoorLevelActivated(IndoorBuilding indoorbuilding);
        }

    }


    private class _cls12 extends com.google.android.gms.maps.internal.zzg.zza
    {

        final GoogleMap zzaIk;
        final OnInfoWindowClickListener zzaIx;

        public void zze(zzf zzf)
        {
            zzaIx.onInfoWindowClick(new Marker(zzf));
        }

        _cls12(OnInfoWindowClickListener oninfowindowclicklistener)
        {
            zzaIk = GoogleMap.this;
            zzaIx = oninfowindowclicklistener;
            super();
        }

        private class OnInfoWindowClickListener
        {

            public abstract void onInfoWindowClick(Marker marker);
        }

    }


    private class _cls8 extends com.google.android.gms.maps.internal.zzi.zza
    {

        final GoogleMap zzaIk;
        final OnMapClickListener zzaIt;

        public void onMapClick(LatLng latlng)
        {
            zzaIt.onMapClick(latlng);
        }

        _cls8(OnMapClickListener onmapclicklistener)
        {
            zzaIk = GoogleMap.this;
            zzaIt = onmapclicklistener;
            super();
        }

        private class OnMapClickListener
        {

            public abstract void onMapClick(LatLng latlng);
        }

    }


    private class _cls4 extends com.google.android.gms.maps.internal.zzj.zza
    {

        final GoogleMap zzaIk;
        final OnMapLoadedCallback zzaIn;

        public void onMapLoaded()
        {
            zzaIn.onMapLoaded();
        }

        _cls4(OnMapLoadedCallback onmaploadedcallback)
        {
            zzaIk = GoogleMap.this;
            zzaIn = onmaploadedcallback;
            super();
        }

        private class OnMapLoadedCallback
        {

            public abstract void onMapLoaded();
        }

    }


    private class _cls9 extends com.google.android.gms.maps.internal.zzk.zza
    {

        final GoogleMap zzaIk;
        final OnMapLongClickListener zzaIu;

        public void onMapLongClick(LatLng latlng)
        {
            zzaIu.onMapLongClick(latlng);
        }

        _cls9(OnMapLongClickListener onmaplongclicklistener)
        {
            zzaIk = GoogleMap.this;
            zzaIu = onmaplongclicklistener;
            super();
        }

        private class OnMapLongClickListener
        {

            public abstract void onMapLongClick(LatLng latlng);
        }

    }


    private class _cls10 extends com.google.android.gms.maps.internal.zzm.zza
    {

        final GoogleMap zzaIk;
        final OnMarkerClickListener zzaIv;

        public boolean zza(zzf zzf)
        {
            return zzaIv.onMarkerClick(new Marker(zzf));
        }

        _cls10(OnMarkerClickListener onmarkerclicklistener)
        {
            zzaIk = GoogleMap.this;
            zzaIv = onmarkerclicklistener;
            super();
        }

        private class OnMarkerClickListener
        {

            public abstract boolean onMarkerClick(Marker marker);
        }

    }


    private class _cls11 extends com.google.android.gms.maps.internal.zzn.zza
    {

        final GoogleMap zzaIk;
        final OnMarkerDragListener zzaIw;

        public void zzb(zzf zzf)
        {
            zzaIw.onMarkerDragStart(new Marker(zzf));
        }

        public void zzc(zzf zzf)
        {
            zzaIw.onMarkerDragEnd(new Marker(zzf));
        }

        public void zzd(zzf zzf)
        {
            zzaIw.onMarkerDrag(new Marker(zzf));
        }

        _cls11(OnMarkerDragListener onmarkerdraglistener)
        {
            zzaIk = GoogleMap.this;
            zzaIw = onmarkerdraglistener;
            super();
        }

        private class OnMarkerDragListener
        {

            public abstract void onMarkerDrag(Marker marker);

            public abstract void onMarkerDragEnd(Marker marker);

            public abstract void onMarkerDragStart(Marker marker);
        }

    }


    private class _cls3 extends com.google.android.gms.maps.internal.zzo.zza
    {

        final GoogleMap zzaIk;
        final OnMyLocationButtonClickListener zzaIm;

        public boolean onMyLocationButtonClick()
        {
            return zzaIm.onMyLocationButtonClick();
        }

        _cls3(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
        {
            zzaIk = GoogleMap.this;
            zzaIm = onmylocationbuttonclicklistener;
            super();
        }

        private class OnMyLocationButtonClickListener
        {

            public abstract boolean onMyLocationButtonClick();
        }

    }


    private class _cls2 extends com.google.android.gms.maps.internal.zzp.zza
    {

        final GoogleMap zzaIk;
        final OnMyLocationChangeListener zzaIl;

        public void zzq(zzd zzd)
        {
            zzaIl.onMyLocationChange((Location)zze.zzp(zzd));
        }

        _cls2(OnMyLocationChangeListener onmylocationchangelistener)
        {
            zzaIk = GoogleMap.this;
            zzaIl = onmylocationchangelistener;
            super();
        }

        private class OnMyLocationChangeListener
        {

            public abstract void onMyLocationChange(Location location);
        }

    }


    private class _cls5 extends com.google.android.gms.maps.internal.zzw.zza
    {

        final GoogleMap zzaIk;
        final SnapshotReadyCallback zzaIo;

        public void onSnapshotReady(Bitmap bitmap)
        {
            zzaIo.onSnapshotReady(bitmap);
        }

        public void zzr(zzd zzd)
        {
            zzaIo.onSnapshotReady((Bitmap)zze.zzp(zzd));
        }

        _cls5(SnapshotReadyCallback snapshotreadycallback)
        {
            zzaIk = GoogleMap.this;
            zzaIo = snapshotreadycallback;
            super();
        }

        private class SnapshotReadyCallback
        {

            public abstract void onSnapshotReady(Bitmap bitmap);
        }

    }

}
