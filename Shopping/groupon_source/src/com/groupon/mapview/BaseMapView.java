// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.groupon.debug.DebugQualityTools;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.GeoPoint;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class BaseMapView extends MapView
{
    public static interface OnMarkerClickListener
    {

        public abstract boolean onMarkerClicked(Marker marker);
    }

    public static interface OnMyLocationChangeListener
    {

        public abstract void onMyLocationChanged();
    }


    public static final double DEF_SEARCH_RADIUS = 15D;
    private static final int DELAY_BETWEEN_TWO_CAMERA_MOVE = 500;
    public static final int NON_SELECTED_MARKER = -1;
    public static final int USE_DEFAULT_ANIMATION_TIME = -1;
    protected com.google.android.gms.maps.model.LatLngBounds.Builder boundsBuilder;
    private CurrentDivisionManager currentDivisionManager;
    protected int currentMarkerIndex;
    protected boolean enableMapGestures;
    protected boolean enableMyLocation;
    protected boolean enableMyLocationButton;
    protected volatile GoogleMap googleMap;
    protected com.google.android.gms.maps.GoogleMap.CancelableCallback lastCallback;
    protected CameraUpdate lastCameraUpdate;
    protected LatLng lastCenterPosition;
    private LocationService locationService;
    protected List markerList;
    protected boolean needMoveCameraToFitMarkers;
    private OnMarkerClickListener onMarkerClickListener;
    private OnMyLocationChangeListener onMyLocationChangeListener;
    protected double radius;

    public BaseMapView(Context context)
    {
        this(context, null, 0);
    }

    public BaseMapView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public BaseMapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        enableMyLocation = false;
        enableMyLocationButton = false;
        enableMapGestures = true;
        init(context);
    }

    public BaseMapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context, googlemapoptions);
        enableMyLocation = false;
        enableMyLocationButton = false;
        enableMapGestures = true;
        init(context);
    }

    private BitmapDescriptor createMarkerIconFromView(View view)
    {
        view.setDrawingCacheEnabled(true);
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        view = BitmapDescriptorFactory.fromBitmap(bitmap);
        bitmap.recycle();
        return view;
    }

    private float getZoomLevelByRadius(double d)
    {
        float f1 = Math.round(Math.log(24859.733479999999D / (d * 2D)) / Math.log(2D) + 1.0D);
        float f = f1;
        if (f1 > 21F)
        {
            f = 21F;
        }
        f1 = f;
        if (f < 1.0F)
        {
            f1 = 1.0F;
        }
        return f1;
    }

    public void clearMap()
    {
        if (markerList != null)
        {
            for (Iterator iterator = markerList.iterator(); iterator.hasNext(); ((Marker)iterator.next()).remove()) { }
            markerList.clear();
        }
        if (googleMap != null)
        {
            googleMap.clear();
        }
        boundsBuilder = LatLngBounds.builder();
        currentMarkerIndex = -1;
    }

    public int getAnimationDurationTime()
    {
        return -1;
    }

    public LatLng getCurrentLocationOrDivisionLatLng()
    {
        Location location = locationService.getLocation();
        if (location != null)
        {
            return new LatLng(location.getLatitude(), location.getLongitude());
        } else
        {
            GeoPoint geopoint = currentDivisionManager.getCurrentDivision().geoPoint;
            return new LatLng(geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees());
        }
    }

    public Point getCurrentLocationOrDivisionScreenPoint()
    {
        if (googleMap != null)
        {
            return googleMap.getProjection().toScreenLocation(getCurrentLocationOrDivisionLatLng());
        } else
        {
            return null;
        }
    }

    public Point getMapCenterScreenPoint()
    {
        if (googleMap != null)
        {
            return googleMap.getProjection().toScreenLocation(googleMap.getCameraPosition().target);
        } else
        {
            return null;
        }
    }

    protected void init(Context context)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        radius = 15D;
        markerList = new ArrayList();
        getMapAsync(new OnMapReadyCallback() {

            final BaseMapView this$0;

            public void onMapReady(GoogleMap googlemap)
            {
                initMap(googlemap);
            }

            
            {
                this$0 = BaseMapView.this;
                super();
            }
        });
    }

    protected void initMap(GoogleMap googlemap)
    {
        googleMap = googlemap;
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(false);
        googleMap.getUiSettings().setMyLocationButtonEnabled(enableMyLocationButton);
        googleMap.getUiSettings().setZoomGesturesEnabled(enableMapGestures);
        googleMap.getUiSettings().setScrollGesturesEnabled(enableMapGestures);
        googleMap.setMyLocationEnabled(enableMyLocation);
        googleMap.setOnMarkerClickListener(new com.google.android.gms.maps.GoogleMap.OnMarkerClickListener() {

            final BaseMapView this$0;

            public boolean onMarkerClick(Marker marker)
            {
                if (onMarkerClickListener != null)
                {
                    return onMarkerClickListener.onMarkerClicked(marker);
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = BaseMapView.this;
                super();
            }
        });
        googleMap.setOnMyLocationChangeListener(new com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener() {

            final BaseMapView this$0;

            public void onMyLocationChange(Location location)
            {
                Object obj;
label0:
                {
                    if (onMyLocationChangeListener != null)
                    {
                        location = googleMap.getCameraPosition().target;
                        obj = new DecimalFormat("###.##");
                        if (lastCenterPosition != null)
                        {
                            break label0;
                        }
                        lastCenterPosition = location;
                    }
                    return;
                }
                String s = ((DecimalFormat) (obj)).format(((LatLng) (location)).latitude);
                String s1 = ((DecimalFormat) (obj)).format(((LatLng) (location)).longitude);
                String s2 = ((DecimalFormat) (obj)).format(lastCenterPosition.latitude);
                obj = ((DecimalFormat) (obj)).format(lastCenterPosition.longitude);
                if (!s.equals(s2) || !s1.equals(obj))
                {
                    onMyLocationChangeListener.onMyLocationChanged();
                }
                lastCenterPosition = location;
            }

            
            {
                this$0 = BaseMapView.this;
                super();
            }
        });
        boundsBuilder = LatLngBounds.builder();
        currentMarkerIndex = -1;
        if (lastCameraUpdate != null)
        {
            moveCamera(lastCameraUpdate, false, lastCallback);
        }
    }

    public void moveCamera(CameraUpdate cameraupdate, boolean flag, final com.google.android.gms.maps.GoogleMap.CancelableCallback callback)
    {
        if (cameraupdate == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        lastCameraUpdate = null;
        lastCallback = null;
        if (googleMap == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        googleMap.setOnCameraChangeListener(null);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (-1 == getAnimationDurationTime())
        {
            googleMap.animateCamera(cameraupdate, callback);
            return;
        }
        try
        {
            googleMap.animateCamera(cameraupdate, getAnimationDurationTime(), callback);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final com.google.android.gms.maps.GoogleMap.CancelableCallback callback)
        {
            lastCameraUpdate = cameraupdate;
        }
        googleMap.setOnCameraChangeListener(new com.google.android.gms.maps.GoogleMap.OnCameraChangeListener() {

            final BaseMapView this$0;

            public void onCameraChange(CameraPosition cameraposition)
            {
                if (googleMap != null)
                {
                    if (lastCameraUpdate != null)
                    {
                        googleMap.moveCamera(lastCameraUpdate);
                    }
                    lastCameraUpdate = null;
                    googleMap.setOnCameraChangeListener(null);
                }
            }

            
            {
                this$0 = BaseMapView.this;
                super();
            }
        });
        return;
        googleMap.moveCamera(cameraupdate);
        if (callback == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        postDelayed(new Runnable() {

            final BaseMapView this$0;
            final com.google.android.gms.maps.GoogleMap.CancelableCallback val$callback;

            public void run()
            {
                callback.onFinish();
            }

            
            {
                this$0 = BaseMapView.this;
                callback = cancelablecallback;
                super();
            }
        }, 500L);
        return;
        lastCameraUpdate = cameraupdate;
        lastCallback = callback;
    }

    public void moveCameraFitMapRadius(LatLng latlng, boolean flag, com.google.android.gms.maps.GoogleMap.CancelableCallback cancelablecallback)
    {
        moveCameraToCenterWithRadius(latlng, radius, flag, cancelablecallback);
    }

    public void moveCameraToCenterWithRadius(LatLng latlng, double d, boolean flag, com.google.android.gms.maps.GoogleMap.CancelableCallback cancelablecallback)
    {
        moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, getZoomLevelByRadius(d)), flag, cancelablecallback);
    }

    public void moveCameraToFitMarkersCenter(boolean flag, com.google.android.gms.maps.GoogleMap.CancelableCallback cancelablecallback)
    {
        if (boundsBuilder != null && markerList != null && markerList.size() > 0)
        {
            moveCameraToCenterWithRadius(boundsBuilder.build().getCenter(), radius, flag, cancelablecallback);
            return;
        } else
        {
            needMoveCameraToFitMarkers = true;
            lastCallback = cancelablecallback;
            return;
        }
    }

    protected void onMarkerSelected(Marker marker)
    {
    }

    protected void onMarkerUnselected(Marker marker)
    {
    }

    public void release()
    {
        clearMap();
        onMarkerClickListener = null;
        onMyLocationChangeListener = null;
        lastCallback = null;
        if (googleMap != null)
        {
            googleMap.setInfoWindowAdapter(null);
            googleMap.setOnInfoWindowClickListener(null);
            googleMap.setOnMarkerClickListener(null);
            googleMap.setOnMapClickListener(null);
            googleMap.setOnCameraChangeListener(null);
            googleMap.setLocationSource(null);
            googleMap.setOnMapLongClickListener(null);
            googleMap.setOnMyLocationChangeListener(null);
            googleMap.clear();
            googleMap = null;
        }
        removeAllViews();
        onDestroy();
        DebugQualityTools.verifyGC(this);
    }

    public void scrollCamera(float f, float f1, boolean flag, com.google.android.gms.maps.GoogleMap.CancelableCallback cancelablecallback)
    {
        moveCamera(CameraUpdateFactory.scrollBy(f, f1), flag, cancelablecallback);
    }

    public void setMapGesturesEnabled(boolean flag)
    {
        if (googleMap != null)
        {
            googleMap.getUiSettings().setZoomGesturesEnabled(flag);
            googleMap.getUiSettings().setScrollGesturesEnabled(flag);
        }
        enableMapGestures = flag;
    }

    protected void setMarkerIconByView(Marker marker, View view)
    {
        BitmapDescriptor bitmapdescriptor = createMarkerIconFromView(view);
        int i = view.getMeasuredWidth();
        int j = view.getMeasuredHeight();
        int k = Math.max(i, j);
        float f = (float)i / (float)k / 2.0F;
        float f1 = (float)j / (float)k;
        marker.setIcon(bitmapdescriptor);
        marker.setAnchor(f, f1);
    }

    public void setMyLocationEnabled(boolean flag)
    {
        if (googleMap != null)
        {
            googleMap.setMyLocationEnabled(flag);
        }
        enableMyLocation = flag;
    }

    public void setOnMarkerClickListener(OnMarkerClickListener onmarkerclicklistener)
    {
        onMarkerClickListener = onmarkerclicklistener;
    }

    public void setOnMyLocationChangeListener(OnMyLocationChangeListener onmylocationchangelistener)
    {
        onMyLocationChangeListener = onmylocationchangelistener;
    }

    public void setSelectedMarker(int i, boolean flag, boolean flag1)
    {
        if (markerList == null || markerList.isEmpty() || markerList.size() <= i || currentMarkerIndex == i)
        {
            return;
        }
        if (currentMarkerIndex != -1 && currentMarkerIndex < markerList.size())
        {
            onMarkerUnselected((Marker)markerList.get(currentMarkerIndex));
        }
        if (i != -1)
        {
            Object obj = (Marker)markerList.get(i);
            onMarkerSelected(((Marker) (obj)));
            if (flag1)
            {
                obj = CameraUpdateFactory.newLatLngZoom(((Marker) (obj)).getPosition(), getZoomLevelByRadius(15D));
            } else
            {
                obj = CameraUpdateFactory.newLatLng(((Marker) (obj)).getPosition());
            }
            if (googleMap != null)
            {
                if (flag)
                {
                    if (-1 == getAnimationDurationTime())
                    {
                        googleMap.animateCamera(((CameraUpdate) (obj)));
                    } else
                    {
                        googleMap.animateCamera(((CameraUpdate) (obj)), getAnimationDurationTime(), null);
                    }
                } else
                {
                    googleMap.moveCamera(((CameraUpdate) (obj)));
                }
            } else
            {
                lastCameraUpdate = ((CameraUpdate) (obj));
            }
        }
        currentMarkerIndex = i;
    }


}
