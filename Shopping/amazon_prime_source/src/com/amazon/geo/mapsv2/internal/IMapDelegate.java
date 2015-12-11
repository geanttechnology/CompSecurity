// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.View;
import com.amazon.geo.mapsv2.model.internal.ICameraPositionPrimitive;
import com.amazon.geo.mapsv2.model.internal.ICircleDelegate;
import com.amazon.geo.mapsv2.model.internal.ICircleOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayDelegate;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IIndoorBuildingDelegate;
import com.amazon.geo.mapsv2.model.internal.ILatLngPrimitive;
import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;
import com.amazon.geo.mapsv2.model.internal.IMarkerOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IPolygonDelegate;
import com.amazon.geo.mapsv2.model.internal.IPolygonOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.IPolylineDelegate;
import com.amazon.geo.mapsv2.model.internal.IPolylineOptionsPrimitive;
import com.amazon.geo.mapsv2.model.internal.ITileOverlayDelegate;
import com.amazon.geo.mapsv2.model.internal.ITileOverlayOptionsPrimitive;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            IObjectDelegate, ICameraUpdateDelegate, IProjectionDelegate, IUiSettingsDelegate, 
//            ILocationSourcePrimitive, IMapOptionsPrimitive

public interface IMapDelegate
    extends IObjectDelegate
{
    public static interface ICancelableCallbackDelegate
    {

        public abstract void onCancel();

        public abstract void onFinish();
    }

    public static interface IInfoWindowAdapterDelegate
    {

        public abstract View getInfoContents(IMarkerDelegate imarkerdelegate);

        public abstract View getInfoWindow(IMarkerDelegate imarkerdelegate);
    }

    public static interface IOnCameraChangeListenerDelegate
    {

        public abstract void onCameraChange(ICameraPositionPrimitive icamerapositionprimitive);
    }

    public static interface IOnIndoorStateChangeListenerDelegate
    {

        public abstract void onIndoorBuildingsFocused();

        public abstract void onIndoorLevelActivated(IIndoorBuildingDelegate iindoorbuildingdelegate);
    }

    public static interface IOnInfoWindowClickListenerDelegate
    {

        public abstract void onInfoWindowClick(IMarkerDelegate imarkerdelegate);
    }

    public static interface IOnMapClickListenerDelegate
    {

        public abstract void onMapClick(ILatLngPrimitive ilatlngprimitive);
    }

    public static interface IOnMapLoadedCallbackDelegate
    {

        public abstract void onMapLoaded();
    }

    public static interface IOnMapLongClickListenerDelegate
    {

        public abstract void onMapLongClick(ILatLngPrimitive ilatlngprimitive);
    }

    public static interface IOnMarkerClickListenerDelegate
    {

        public abstract boolean onMarkerClick(IMarkerDelegate imarkerdelegate);
    }

    public static interface IOnMarkerDragListenerDelegate
    {

        public abstract void onMarkerDrag(IMarkerDelegate imarkerdelegate);

        public abstract void onMarkerDragEnd(IMarkerDelegate imarkerdelegate);

        public abstract void onMarkerDragStart(IMarkerDelegate imarkerdelegate);
    }

    public static interface IOnMyLocationButtonClickListenerDelegate
    {

        public abstract boolean onMyLocationButtonClick();
    }

    public static interface IOnMyLocationChangeListenerDelegate
    {

        public abstract void onMyLocationChange(Location location);
    }

    public static interface ISnapshotReadyCallbackDelegate
    {

        public abstract void onSnapshotReady(Bitmap bitmap);
    }

    public static interface OnUiSettingsUpdateListener
    {

        public abstract void onSetCompass(boolean flag);

        public abstract void onSetMapToolbarEnabled(boolean flag);

        public abstract void onSetMyLocationButton(boolean flag);

        public abstract void onSetRotateGestures(boolean flag);

        public abstract void onSetScrollGestures(boolean flag);

        public abstract void onSetTiltGestures(boolean flag);

        public abstract void onSetZoomControls(boolean flag);

        public abstract void onSetZoomGestures(boolean flag);
    }


    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;

    public abstract ICircleDelegate addCircle(ICircleOptionsPrimitive icircleoptionsprimitive);

    public abstract IGroundOverlayDelegate addGroundOverlay(IGroundOverlayOptionsPrimitive igroundoverlayoptionsprimitive);

    public abstract IMarkerDelegate addMarker(IMarkerOptionsPrimitive imarkeroptionsprimitive);

    public abstract IPolygonDelegate addPolygon(IPolygonOptionsPrimitive ipolygonoptionsprimitive);

    public abstract IPolylineDelegate addPolyline(IPolylineOptionsPrimitive ipolylineoptionsprimitive);

    public abstract ITileOverlayDelegate addTileOverlay(ITileOverlayOptionsPrimitive itileoverlayoptionsprimitive);

    public abstract void animateCamera(ICameraUpdateDelegate icameraupdatedelegate);

    public abstract void animateCamera(ICameraUpdateDelegate icameraupdatedelegate, int i, ICancelableCallbackDelegate icancelablecallbackdelegate);

    public abstract void animateCamera(ICameraUpdateDelegate icameraupdatedelegate, ICancelableCallbackDelegate icancelablecallbackdelegate);

    public abstract void clear();

    public abstract ICameraPositionPrimitive getCameraPosition();

    public abstract Context getContext();

    public abstract IIndoorBuildingDelegate getFocusedBuilding();

    public abstract int getMapType();

    public abstract float getMaxZoomLevel();

    public abstract float getMinZoomLevel();

    public abstract Location getMyLocation();

    public abstract IProjectionDelegate getProjection();

    public abstract IUiSettingsDelegate getUiSettings();

    public abstract boolean isBuildingsEnabled();

    public abstract boolean isIndoorEnabled();

    public abstract boolean isMyLocationEnabled();

    public abstract boolean isTrafficEnabled();

    public abstract void moveCamera(ICameraUpdateDelegate icameraupdatedelegate);

    public abstract void setBuildingsEnabled(boolean flag);

    public abstract boolean setIndoorEnabled(boolean flag);

    public abstract void setInfoWindowAdapter(IInfoWindowAdapterDelegate iinfowindowadapterdelegate);

    public abstract void setLocationSource(ILocationSourcePrimitive ilocationsourceprimitive);

    public abstract void setMapOptions(IMapOptionsPrimitive imapoptionsprimitive);

    public abstract void setMapType(int i);

    public abstract void setMyLocationButtonEnabled(boolean flag);

    public abstract void setMyLocationEnabled(boolean flag);

    public abstract void setOnCameraChangeListener(IOnCameraChangeListenerDelegate ioncamerachangelistenerdelegate);

    public abstract void setOnIndoorStateChangeListener(IOnIndoorStateChangeListenerDelegate ionindoorstatechangelistenerdelegate);

    public abstract void setOnInfoWindowClickListener(IOnInfoWindowClickListenerDelegate ioninfowindowclicklistenerdelegate);

    public abstract void setOnMapClickListener(IOnMapClickListenerDelegate ionmapclicklistenerdelegate);

    public abstract void setOnMapLoadedCallback(IOnMapLoadedCallbackDelegate ionmaploadedcallbackdelegate);

    public abstract void setOnMapLongClickListener(IOnMapLongClickListenerDelegate ionmaplongclicklistenerdelegate);

    public abstract void setOnMarkerClickListener(IOnMarkerClickListenerDelegate ionmarkerclicklistenerdelegate);

    public abstract void setOnMarkerDragListener(IOnMarkerDragListenerDelegate ionmarkerdraglistenerdelegate);

    public abstract void setOnMyLocationButtonClickListener(IOnMyLocationButtonClickListenerDelegate ionmylocationbuttonclicklistenerdelegate);

    public abstract void setOnMyLocationChangeListener(IOnMyLocationChangeListenerDelegate ionmylocationchangelistenerdelegate);

    public abstract void setOnUiSettingsUpdateListener(OnUiSettingsUpdateListener onuisettingsupdatelistener);

    public abstract void setPadding(int i, int j, int k, int l);

    public abstract void setTrafficEnabled(boolean flag);

    public abstract void snapshot(ISnapshotReadyCallbackDelegate isnapshotreadycallbackdelegate);

    public abstract void snapshot(ISnapshotReadyCallbackDelegate isnapshotreadycallbackdelegate, Bitmap bitmap);

    public abstract void stopAnimation();
}
