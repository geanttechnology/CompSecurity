// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;
import com.amazon.geo.mapsv2.internal.IMapDelegate;
import com.amazon.geo.mapsv2.model.CameraPosition;
import com.amazon.geo.mapsv2.model.Circle;
import com.amazon.geo.mapsv2.model.CircleOptions;
import com.amazon.geo.mapsv2.model.GroundOverlay;
import com.amazon.geo.mapsv2.model.GroundOverlayOptions;
import com.amazon.geo.mapsv2.model.IndoorBuilding;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.geo.mapsv2.model.MarkerOptions;
import com.amazon.geo.mapsv2.model.Polygon;
import com.amazon.geo.mapsv2.model.PolygonOptions;
import com.amazon.geo.mapsv2.model.Polyline;
import com.amazon.geo.mapsv2.model.PolylineOptions;
import com.amazon.geo.mapsv2.model.TileOverlay;
import com.amazon.geo.mapsv2.model.TileOverlayOptions;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.IIndoorBuildingDelegate;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import com.amazon.geo.mapsv2.pvt.PrimitiveBase;
import com.amazon.geo.mapsv2.pvt.Wrappers;

// Referenced classes of package com.amazon.geo.mapsv2:
//            WrapperCreators, Projection, UiSettings, CameraUpdate, 
//            LocationSource

public final class AmazonMap
{
    public static interface CancelableCallback
    {

        public abstract void onCancel();

        public abstract void onFinish();
    }

    private static class CancelableCallbackDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.ICancelableCallbackDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.ICancelableCallbackDelegate create(CancelableCallback cancelablecallback)
        {
            if (cancelablecallback == null)
            {
                return null;
            } else
            {
                return new CancelableCallbackDelegate(cancelablecallback);
            }
        }

        public void onCancel()
        {
            ((CancelableCallback)get()).onCancel();
        }

        public void onFinish()
        {
            ((CancelableCallback)get()).onFinish();
        }


        private CancelableCallbackDelegate(CancelableCallback cancelablecallback)
        {
            super(cancelablecallback);
        }
    }

    public static interface InfoWindowAdapter
    {

        public abstract View getInfoContents(Marker marker);

        public abstract View getInfoWindow(Marker marker);
    }

    private static class InfoWindowAdapterDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IInfoWindowAdapterDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IInfoWindowAdapterDelegate create(InfoWindowAdapter infowindowadapter)
        {
            if (infowindowadapter == null)
            {
                return null;
            } else
            {
                return new InfoWindowAdapterDelegate(infowindowadapter);
            }
        }

        public View getInfoContents(IMarkerDelegate imarkerdelegate)
        {
            return ((InfoWindowAdapter)get()).getInfoContents((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }

        public View getInfoWindow(IMarkerDelegate imarkerdelegate)
        {
            return ((InfoWindowAdapter)get()).getInfoWindow((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }


        private InfoWindowAdapterDelegate(InfoWindowAdapter infowindowadapter)
        {
            super(infowindowadapter);
        }
    }

    public static interface OnCameraChangeListener
    {

        public abstract void onCameraChange(CameraPosition cameraposition);
    }

    private static class OnCameraChangeListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnCameraChangeListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnCameraChangeListenerDelegate create(OnCameraChangeListener oncamerachangelistener)
        {
            if (oncamerachangelistener == null)
            {
                return null;
            } else
            {
                return new OnCameraChangeListenerDelegate(oncamerachangelistener);
            }
        }

        public void onCameraChange(ICameraPositionPrimitive icamerapositionprimitive)
        {
            ((OnCameraChangeListener)get()).onCameraChange(Primitives.create(icamerapositionprimitive));
        }


        public OnCameraChangeListenerDelegate(OnCameraChangeListener oncamerachangelistener)
        {
            super(oncamerachangelistener);
        }
    }

    public static interface OnIndoorStateChangeListener
    {

        public abstract void onIndoorBuildingsFocused();

        public abstract void onIndoorLevelActivated(IndoorBuilding indoorbuilding);
    }

    private static class OnIndoorStateChangeListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnIndoorStateChangeListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnIndoorStateChangeListenerDelegate create(OnIndoorStateChangeListener onindoorstatechangelistener)
        {
            if (onindoorstatechangelistener == null)
            {
                return null;
            } else
            {
                return new OnIndoorStateChangeListenerDelegate(onindoorstatechangelistener);
            }
        }

        public void onIndoorBuildingsFocused()
        {
            ((OnIndoorStateChangeListener)get()).onIndoorBuildingsFocused();
        }

        public void onIndoorLevelActivated(IIndoorBuildingDelegate iindoorbuildingdelegate)
        {
            ((OnIndoorStateChangeListener)get()).onIndoorLevelActivated((IndoorBuilding)Wrappers.unwrapAs(iindoorbuildingdelegate, com/amazon/geo/mapsv2/model/IndoorBuilding));
        }


        OnIndoorStateChangeListenerDelegate(OnIndoorStateChangeListener onindoorstatechangelistener)
        {
            super(onindoorstatechangelistener);
        }
    }

    public static interface OnInfoWindowClickListener
    {

        public abstract void onInfoWindowClick(Marker marker);
    }

    private static class OnInfoWindowClickListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnInfoWindowClickListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnInfoWindowClickListenerDelegate create(OnInfoWindowClickListener oninfowindowclicklistener)
        {
            if (oninfowindowclicklistener == null)
            {
                return null;
            } else
            {
                return new OnInfoWindowClickListenerDelegate(oninfowindowclicklistener);
            }
        }

        public void onInfoWindowClick(IMarkerDelegate imarkerdelegate)
        {
            ((OnInfoWindowClickListener)get()).onInfoWindowClick((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }


        OnInfoWindowClickListenerDelegate(OnInfoWindowClickListener oninfowindowclicklistener)
        {
            super(oninfowindowclicklistener);
        }
    }

    public static interface OnMapClickListener
    {

        public abstract void onMapClick(LatLng latlng);
    }

    private static class OnMapClickListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMapClickListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMapClickListenerDelegate create(OnMapClickListener onmapclicklistener)
        {
            if (onmapclicklistener == null)
            {
                return null;
            } else
            {
                return new OnMapClickListenerDelegate(onmapclicklistener);
            }
        }

        public void onMapClick(ILatLngPrimitive ilatlngprimitive)
        {
            ((OnMapClickListener)get()).onMapClick(Primitives.create(ilatlngprimitive));
        }


        public OnMapClickListenerDelegate(OnMapClickListener onmapclicklistener)
        {
            super(onmapclicklistener);
        }
    }

    public static interface OnMapLoadedCallback
    {

        public abstract void onMapLoaded();
    }

    private static class OnMapLoadedCallbackDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMapLoadedCallbackDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMapLoadedCallbackDelegate create(OnMapLoadedCallback onmaploadedcallback)
        {
            if (onmaploadedcallback == null)
            {
                return null;
            } else
            {
                return new OnMapLoadedCallbackDelegate(onmaploadedcallback);
            }
        }

        public void onMapLoaded()
        {
            ((OnMapLoadedCallback)get()).onMapLoaded();
        }


        public OnMapLoadedCallbackDelegate(OnMapLoadedCallback onmaploadedcallback)
        {
            super(onmaploadedcallback);
        }
    }

    public static interface OnMapLongClickListener
    {

        public abstract void onMapLongClick(LatLng latlng);
    }

    private static class OnMapLongClickListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMapLongClickListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMapLongClickListenerDelegate create(OnMapLongClickListener onmaplongclicklistener)
        {
            if (onmaplongclicklistener == null)
            {
                return null;
            } else
            {
                return new OnMapLongClickListenerDelegate(onmaplongclicklistener);
            }
        }

        public void onMapLongClick(ILatLngPrimitive ilatlngprimitive)
        {
            ((OnMapLongClickListener)get()).onMapLongClick(Primitives.create(ilatlngprimitive));
        }


        public OnMapLongClickListenerDelegate(OnMapLongClickListener onmaplongclicklistener)
        {
            super(onmaplongclicklistener);
        }
    }

    public static interface OnMarkerClickListener
    {

        public abstract boolean onMarkerClick(Marker marker);
    }

    private static class OnMarkerClickListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMarkerClickListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMarkerClickListenerDelegate create(OnMarkerClickListener onmarkerclicklistener)
        {
            if (onmarkerclicklistener == null)
            {
                return null;
            } else
            {
                return new OnMarkerClickListenerDelegate(onmarkerclicklistener);
            }
        }

        public boolean onMarkerClick(IMarkerDelegate imarkerdelegate)
        {
            return ((OnMarkerClickListener)get()).onMarkerClick((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }


        private OnMarkerClickListenerDelegate(OnMarkerClickListener onmarkerclicklistener)
        {
            super(onmarkerclicklistener);
        }
    }

    public static interface OnMarkerDragListener
    {

        public abstract void onMarkerDrag(Marker marker);

        public abstract void onMarkerDragEnd(Marker marker);

        public abstract void onMarkerDragStart(Marker marker);
    }

    private static class OnMarkerDragListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMarkerDragListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMarkerDragListenerDelegate create(OnMarkerDragListener onmarkerdraglistener)
        {
            if (onmarkerdraglistener == null)
            {
                return null;
            } else
            {
                return new OnMarkerDragListenerDelegate(onmarkerdraglistener);
            }
        }

        public void onMarkerDrag(IMarkerDelegate imarkerdelegate)
        {
            ((OnMarkerDragListener)get()).onMarkerDrag((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }

        public void onMarkerDragEnd(IMarkerDelegate imarkerdelegate)
        {
            ((OnMarkerDragListener)get()).onMarkerDragEnd((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }

        public void onMarkerDragStart(IMarkerDelegate imarkerdelegate)
        {
            ((OnMarkerDragListener)get()).onMarkerDragStart((Marker)Wrappers.unwrapAs(imarkerdelegate, com/amazon/geo/mapsv2/model/Marker));
        }


        private OnMarkerDragListenerDelegate(OnMarkerDragListener onmarkerdraglistener)
        {
            super(onmarkerdraglistener);
        }
    }

    public static interface OnMyLocationButtonClickListener
    {

        public abstract boolean onMyLocationButtonClick();
    }

    private static class OnMyLocationButtonClickListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMyLocationButtonClickListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMyLocationButtonClickListenerDelegate create(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
        {
            if (onmylocationbuttonclicklistener == null)
            {
                return null;
            } else
            {
                return new OnMyLocationButtonClickListenerDelegate(onmylocationbuttonclicklistener);
            }
        }

        public boolean onMyLocationButtonClick()
        {
            return ((OnMyLocationButtonClickListener)get()).onMyLocationButtonClick();
        }


        public OnMyLocationButtonClickListenerDelegate(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
        {
            super(onmylocationbuttonclicklistener);
        }
    }

    public static interface OnMyLocationChangeListener
    {

        public abstract void onMyLocationChange(Location location);
    }

    private static class OnMyLocationChangeListenerDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMyLocationChangeListenerDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.IOnMyLocationChangeListenerDelegate create(OnMyLocationChangeListener onmylocationchangelistener)
        {
            if (onmylocationchangelistener == null)
            {
                return null;
            } else
            {
                return new OnMyLocationChangeListenerDelegate(onmylocationchangelistener);
            }
        }

        public void onMyLocationChange(Location location)
        {
            ((OnMyLocationChangeListener)get()).onMyLocationChange(location);
        }


        public OnMyLocationChangeListenerDelegate(OnMyLocationChangeListener onmylocationchangelistener)
        {
            super(onmylocationchangelistener);
        }
    }

    public static interface SnapshotReadyCallback
    {

        public abstract void onSnapshotReady(Bitmap bitmap);
    }

    private static class SnapshotReadyCallbackDelegate extends PrimitiveBase
        implements com.amazon.geo.mapsv2.internal.IMapDelegate.ISnapshotReadyCallbackDelegate
    {

        private static com.amazon.geo.mapsv2.internal.IMapDelegate.ISnapshotReadyCallbackDelegate create(SnapshotReadyCallback snapshotreadycallback)
        {
            if (snapshotreadycallback == null)
            {
                return null;
            } else
            {
                return new SnapshotReadyCallbackDelegate(snapshotreadycallback);
            }
        }

        public void onSnapshotReady(Bitmap bitmap)
        {
            ((SnapshotReadyCallback)get()).onSnapshotReady(bitmap);
        }


        public SnapshotReadyCallbackDelegate(SnapshotReadyCallback snapshotreadycallback)
        {
            super(snapshotreadycallback);
        }
    }


    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IMapDelegate mMapControl;

    AmazonMap(IMapDelegate imapdelegate)
    {
        mMapControl = imapdelegate;
        mMapControl.setWrapper(this);
    }

    public final Circle addCircle(CircleOptions circleoptions)
    {
        return (Circle)Wrappers.create(mMapControl.addCircle(Primitives.create(circleoptions)), WrapperCreators.CIRCLE_CREATOR);
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundoverlayoptions)
    {
        return (GroundOverlay)Wrappers.create(mMapControl.addGroundOverlay(Primitives.create(groundoverlayoptions)), WrapperCreators.GROUNDOVERLAY_CREATOR);
    }

    public final Marker addMarker(MarkerOptions markeroptions)
    {
        return (Marker)Wrappers.create(mMapControl.addMarker(Primitives.create(markeroptions)), WrapperCreators.MARKER_CREATOR);
    }

    public final Polygon addPolygon(PolygonOptions polygonoptions)
    {
        return (Polygon)Wrappers.create(mMapControl.addPolygon(Primitives.create(polygonoptions)), WrapperCreators.POLYGON_CREATOR);
    }

    public final Polyline addPolyline(PolylineOptions polylineoptions)
    {
        return (Polyline)Wrappers.create(mMapControl.addPolyline(Primitives.create(polylineoptions)), WrapperCreators.POLYLINE_CREATOR);
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileoverlayoptions)
    {
        return (TileOverlay)Wrappers.create(mMapControl.addTileOverlay(Primitives.create(tileoverlayoptions)), WrapperCreators.TILEOVERLAY_CREATOR);
    }

    public final void animateCamera(CameraUpdate cameraupdate)
    {
        mMapControl.animateCamera(Primitives.unwrap(cameraupdate));
    }

    public final void animateCamera(CameraUpdate cameraupdate, int i, CancelableCallback cancelablecallback)
    {
        mMapControl.animateCamera(Primitives.unwrap(cameraupdate), i, CancelableCallbackDelegate.create(cancelablecallback));
    }

    public final void animateCamera(CameraUpdate cameraupdate, CancelableCallback cancelablecallback)
    {
        mMapControl.animateCamera(Primitives.unwrap(cameraupdate), CancelableCallbackDelegate.create(cancelablecallback));
    }

    public final void clear()
    {
        mMapControl.clear();
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
        obj = (AmazonMap)obj;
        if (mMapControl != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((AmazonMap) (obj)).mMapControl == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mMapControl.equals(((AmazonMap) (obj)).mMapControl)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public final CameraPosition getCameraPosition()
    {
        return Primitives.create(mMapControl.getCameraPosition());
    }

    public final IndoorBuilding getFocusedBuilding()
    {
        return (IndoorBuilding)Wrappers.create(mMapControl.getFocusedBuilding(), WrapperCreators.INDOORBUILDING_CREATOR);
    }

    public final int getMapType()
    {
        return mMapControl.getMapType();
    }

    public final float getMaxZoomLevel()
    {
        return mMapControl.getMaxZoomLevel();
    }

    public final float getMinZoomLevel()
    {
        return mMapControl.getMinZoomLevel();
    }

    public final Location getMyLocation()
    {
        return mMapControl.getMyLocation();
    }

    public final Projection getProjection()
    {
        return (Projection)Wrappers.create(mMapControl.getProjection(), WrapperCreators.PROJECTION_CREATOR);
    }

    public final UiSettings getUiSettings()
    {
        return (UiSettings)Wrappers.create(mMapControl.getUiSettings(), WrapperCreators.UISETTINGS_CREATOR);
    }

    public int hashCode()
    {
        int i;
        if (mMapControl == null)
        {
            i = 0;
        } else
        {
            i = mMapControl.hashCode();
        }
        return i + 31;
    }

    Object im()
    {
        return mMapControl;
    }

    public final boolean isBuildingsEnabled()
    {
        return mMapControl.isBuildingsEnabled();
    }

    public final boolean isIndoorEnabled()
    {
        return mMapControl.isIndoorEnabled();
    }

    public final boolean isMyLocationEnabled()
    {
        return mMapControl.isMyLocationEnabled();
    }

    public final boolean isTrafficEnabled()
    {
        return mMapControl.isTrafficEnabled();
    }

    public final void moveCamera(CameraUpdate cameraupdate)
    {
        mMapControl.moveCamera(Primitives.unwrap(cameraupdate));
    }

    public final void setBuildingsEnabled(boolean flag)
    {
        mMapControl.setBuildingsEnabled(flag);
    }

    public final boolean setIndoorEnabled(boolean flag)
    {
        return mMapControl.setIndoorEnabled(flag);
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infowindowadapter)
    {
        mMapControl.setInfoWindowAdapter(InfoWindowAdapterDelegate.create(infowindowadapter));
    }

    public final void setLocationSource(LocationSource locationsource)
    {
        mMapControl.setLocationSource(Primitives.create(locationsource));
    }

    public final void setMapType(int i)
    {
        mMapControl.setMapType(i);
    }

    public final void setMyLocationEnabled(boolean flag)
    {
        mMapControl.setMyLocationEnabled(flag);
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener oncamerachangelistener)
    {
        mMapControl.setOnCameraChangeListener(OnCameraChangeListenerDelegate.create(oncamerachangelistener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onindoorstatechangelistener)
    {
        mMapControl.setOnIndoorStateChangeListener(OnIndoorStateChangeListenerDelegate.create(onindoorstatechangelistener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener oninfowindowclicklistener)
    {
        mMapControl.setOnInfoWindowClickListener(OnInfoWindowClickListenerDelegate.create(oninfowindowclicklistener));
    }

    public final void setOnMapClickListener(OnMapClickListener onmapclicklistener)
    {
        mMapControl.setOnMapClickListener(OnMapClickListenerDelegate.create(onmapclicklistener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onmaploadedcallback)
    {
        mMapControl.setOnMapLoadedCallback(OnMapLoadedCallbackDelegate.create(onmaploadedcallback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onmaplongclicklistener)
    {
        mMapControl.setOnMapLongClickListener(OnMapLongClickListenerDelegate.create(onmaplongclicklistener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        mMapControl.setOnMarkerClickListener(OnMarkerClickListenerDelegate.create(onmarkerclicklistener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onmarkerdraglistener)
    {
        mMapControl.setOnMarkerDragListener(OnMarkerDragListenerDelegate.create(onmarkerdraglistener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onmylocationbuttonclicklistener)
    {
        mMapControl.setOnMyLocationButtonClickListener(OnMyLocationButtonClickListenerDelegate.create(onmylocationbuttonclicklistener));
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onmylocationchangelistener)
    {
        mMapControl.setOnMyLocationChangeListener(OnMyLocationChangeListenerDelegate.create(onmylocationchangelistener));
    }

    public final void setPadding(int i, int j, int k, int l)
    {
        mMapControl.setPadding(i, j, k, l);
    }

    public final void setTrafficEnabled(boolean flag)
    {
        mMapControl.setTrafficEnabled(flag);
    }

    public final void snapshot(SnapshotReadyCallback snapshotreadycallback)
    {
        mMapControl.snapshot(SnapshotReadyCallbackDelegate.create(snapshotreadycallback));
    }

    public final void snapshot(SnapshotReadyCallback snapshotreadycallback, Bitmap bitmap)
    {
        mMapControl.snapshot(SnapshotReadyCallbackDelegate.create(snapshotreadycallback), bitmap);
    }

    public final void stopAnimation()
    {
        mMapControl.stopAnimation();
    }
}
