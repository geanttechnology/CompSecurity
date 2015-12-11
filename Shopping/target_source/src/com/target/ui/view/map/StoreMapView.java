// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.pointinside.maps.CameraAnimation;
import com.pointinside.maps.Location;
import com.pointinside.maps.MapFeatureSettings;
import com.pointinside.maps.MapView;
import com.pointinside.maps.Marker;
import com.pointinside.maps.PIMap;
import com.pointinside.maps.PIMapError;
import com.pointinside.maps.UiSettings;
import com.pointinside.maps.model.CameraPosition;
import com.pointinside.maps.model.FeatureStyle;
import com.pointinside.maps.model.MarkerOptions;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.ui.fragment.map.a.b;
import com.target.ui.model.BlackFridayDealDetails;
import com.target.ui.model.MapDisplayableItem;
import com.target.ui.util.af;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.e.a;
import com.target.ui.util.q;
import com.target.ui.util.s;
import com.target.ui.view.DepartmentBadgeView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.target.ui.view.map:
//            ZoneSelectionView

public class StoreMapView extends RelativeLayout
    implements com.target.ui.fragment.map.a.b
{
    private class a
    {

        private MapDisplayableItem mMapDisplayableItem;
        private Drawable mSelectedDrawable;
        private Drawable mUnselectedDrawable;
        final StoreMapView this$0;

        static MapDisplayableItem a(a a1)
        {
            return a1.mMapDisplayableItem;
        }

        static Drawable b(a a1)
        {
            return a1.mSelectedDrawable;
        }

        static Drawable c(a a1)
        {
            return a1.mUnselectedDrawable;
        }

        public a(MapDisplayableItem mapdisplayableitem, Drawable drawable, Drawable drawable1)
        {
            this$0 = StoreMapView.this;
            super();
            mMapDisplayableItem = mapdisplayableitem;
            mUnselectedDrawable = drawable;
            mSelectedDrawable = drawable1;
        }
    }

    public static interface b
    {

        public abstract void c(MapDisplayableItem mapdisplayableitem);

        public abstract void d(MapDisplayableItem mapdisplayableitem);
    }

    private class c
    {

        ImageView arrowDown;
        ImageView arrowLeft;
        ImageView arrowRight;
        ImageView arrowUp;
        MapView mapView;
        View progress;
        final StoreMapView this$0;
        View translucentOverlay;
        ZoneSelectionView zoneSelector;

        public c(View view)
        {
            this$0 = StoreMapView.this;
            super();
            translucentOverlay = view.findViewById(0x7f100452);
            mapView = (MapView)view.findViewById(0x7f10044c);
            zoneSelector = (ZoneSelectionView)view.findViewById(0x7f10044d);
            progress = view.findViewById(0x7f100171);
            arrowLeft = (ImageView)view.findViewById(0x7f10044f);
            arrowRight = (ImageView)view.findViewById(0x7f10044e);
            arrowUp = (ImageView)view.findViewById(0x7f100450);
            arrowDown = (ImageView)view.findViewById(0x7f100451);
        }
    }


    private static final String LOG_TAG = com/target/ui/view/map/StoreMapView.getSimpleName();
    private static final String MAP_FEATURE_COPYRIGHT = "Copyright";
    private static final int SELECTED_DEAL_LABEL_MAX_LENGTH = 30;
    private android.view.View.OnClickListener arrowClickListener = new android.view.View.OnClickListener() {

        final StoreMapView this$0;

        public void onClick(View view)
        {
            StoreMapView.l(StoreMapView.this).G();
        }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
    };
    private Location mBlueDotLocation;
    private Marker mBlueDotMarker;
    private com.pointinside.maps.PIMap.CameraCallback mCameraCallback;
    private PIMap mMap;
    private Map mMarkers;
    private com.target.ui.fragment.map.a.b.a mOnCameraMoveListener;
    private com.target.ui.fragment.map.a.b.c mOnDirectionArrowClickListener;
    private com.target.ui.fragment.map.a.b.d mOnGuestLocationNotAvailableListener;
    private com.target.ui.fragment.map.a.b.e mOnMapDragListener;
    private b mOnMapItemClickListener;
    private com.target.ui.fragment.map.a.b.f mOnMarkerScreenLocationListener;
    private com.pointinside.maps.PIMap.OnZoneLoadCallback mOnZoneLoadCallback;
    private com.target.ui.fragment.map.a.b.g mOnZoomedToMarkerListener;
    private Marker mSelectedMarker;
    private c mViews;
    private boolean markersSelectable;

    public StoreMapView(Context context)
    {
        super(context);
        mMarkers = new HashMap();
        markersSelectable = false;
        a(context);
    }

    public StoreMapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMarkers = new HashMap();
        markersSelectable = false;
        a(context);
    }

    public StoreMapView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        mMarkers = new HashMap();
        markersSelectable = false;
        a(context);
    }

    private int a(int i1, float f1)
    {
        int k1 = (int)f1 / 90;
        int j1 = k1;
        if (f1 % 90F > 45F)
        {
            j1 = k1 + 1;
        }
        boolean flag = false;
        k1 = i1;
        for (i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
        {
            k1 = b(k1);
        }

        return k1;
    }

    private int a(Location location)
    {
        if (mSelectedMarker != null)
        {
            Location location1 = mSelectedMarker.getLocation();
            float f1 = location.x - location1.x;
            float f2 = location.y - location1.y;
            if (f1 != 0.0F || f2 != 0.0F)
            {
                boolean flag;
                byte byte0;
                if (f1 > 0.0F)
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (f2 < 0.0F)
                {
                    byte0 = 3;
                } else
                {
                    byte0 = 2;
                }
                if (Math.abs(f1) > Math.abs(f2))
                {
                    byte0 = flag;
                }
                return a(byte0, mMap.getCameraPosition().rotation);
            }
        }
        return 4;
    }

    static Marker a(StoreMapView storemapview, Marker marker)
    {
        storemapview.mSelectedMarker = marker;
        return marker;
    }

    static com.target.ui.fragment.map.a.b.g a(StoreMapView storemapview)
    {
        return storemapview.mOnZoomedToMarkerListener;
    }

    private void a(Context context)
    {
        mViews = new c(LayoutInflater.from(context).inflate(0x7f030164, this, true));
        mMap = mViews.mapView.getMap();
        mMap.getUiSettings().setRotateGestureToRotateEnabled(true);
        mViews.mapView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final StoreMapView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 2 && com.target.ui.view.map.StoreMapView.e(StoreMapView.this) != null)
                {
                    com.target.ui.view.map.StoreMapView.e(StoreMapView.this).E();
                }
                return false;
            }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
        });
        mMap.setCompanyLogoMapLocation(com.pointinside.maps.PIMap.CompanyBrandLogoMapLocation.NONE);
        mViews.mapView.setBackgroundColor(getResources().getColor(0x7f0f00ef));
        mMap.setOnZoneLoadCallback(new com.pointinside.maps.PIMap.OnZoneLoadCallback() {

            final StoreMapView this$0;

            public void postZoneLoad(String s1, int i1, int j1)
            {
                if (StoreMapView.f(StoreMapView.this) != null)
                {
                    StoreMapView.f(StoreMapView.this).postZoneLoad(s1, i1, j1);
                }
            }

            public void preZoneLoad(String s1, int i1, int j1)
            {
                if (StoreMapView.f(StoreMapView.this) != null)
                {
                    StoreMapView.f(StoreMapView.this).preZoneLoad(s1, i1, j1);
                }
            }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
        });
        mViews.translucentOverlay.setOnClickListener(new android.view.View.OnClickListener() {

            final StoreMapView this$0;

            public void onClick(View view)
            {
                if (StoreMapView.g(StoreMapView.this) != null)
                {
                    StoreMapView.g(StoreMapView.this).zoneSelector.a();
                }
            }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
        });
    }

    private void a(final Location location, final float angleDegrees, final float zoomPercent)
    {
        (new Handler()).post(new Runnable() {

            final StoreMapView this$0;
            final float val$angleDegrees;
            final Location val$location;
            final float val$zoomPercent;

            public void run()
            {
                StoreMapView.i(StoreMapView.this).moveCamera((new com.pointinside.maps.model.CameraPosition.Builder(StoreMapView.i(StoreMapView.this).getCameraPosition())).pointInZone(location.getMapPoint()).rotation(angleDegrees).zoomPercent(zoomPercent).build(), new com.pointinside.maps.PIMap.CameraCallback() {

                    final _cls2 this$1;

                    public void onCameraSet()
                    {
                        if (StoreMapView.k(_fld0) != null)
                        {
                            StoreMapView.k(_fld0).C();
                        }
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            
            {
                this$0 = StoreMapView.this;
                location = location1;
                angleDegrees = f1;
                zoomPercent = f2;
                super();
            }
        });
    }

    private void a(final Location location, final float zoomPercent, final CameraAnimation cameraAnimation)
    {
        (new Handler()).post(new Runnable() {

            final StoreMapView this$0;
            final CameraAnimation val$cameraAnimation;
            final Location val$location;
            final float val$zoomPercent;

            public void run()
            {
                StoreMapView.i(StoreMapView.this).animateCamera((new com.pointinside.maps.model.CameraPosition.Builder(StoreMapView.i(StoreMapView.this).getCameraPosition())).pointInZone(location.getMapPoint()).zoomPercent(zoomPercent).build(), new com.pointinside.maps.PIMap.CameraCallback() {

                    final _cls12 this$1;

                    public void onCameraSet()
                    {
                        StoreMapView.j(_fld0);
                    }

            
            {
                this$1 = _cls12.this;
                super();
            }
                }, cameraAnimation);
            }

            
            {
                this$0 = StoreMapView.this;
                location = location1;
                zoomPercent = f1;
                cameraAnimation = cameraanimation;
                super();
            }
        });
    }

    private void a(Location location, long l1)
    {
        location = (new MarkerOptions()).location(location).markerDrawable(getResources().getDrawable(0x7f020161), com.pointinside.maps.model.MarkerOptions.AnchorPoint.CENTER_BOTTOM);
        if (mBlueDotMarker == null)
        {
            mBlueDotMarker = mMap.addMarker(location, null, com.pointinside.maps.PIMap.AddMarkerAnimation.FADE);
            (new Handler()).postDelayed(new Runnable() {

                final StoreMapView this$0;

                public void run()
                {
                    if (StoreMapView.m(StoreMapView.this) != null)
                    {
                        StoreMapView.m(StoreMapView.this).remove();
                        com.target.ui.view.map.StoreMapView.b(StoreMapView.this, null);
                    }
                }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
            }, l1);
        }
    }

    private void a(Location location, Drawable drawable, Drawable drawable1, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        MarkerOptions markeroptions = (new MarkerOptions()).location(location);
        if (flag)
        {
            location = drawable;
        } else
        {
            location = drawable1;
        }
        location = markeroptions.markerDrawable(location, com.pointinside.maps.model.MarkerOptions.AnchorPoint.CENTER_BOTTOM).shadowDrawable(getResources().getDrawable(0x7f0201c1), com.pointinside.maps.model.MarkerOptions.AnchorPoint.CENTER_BOTTOM);
        if (!mMap.getCurrentVenue().getUUID().equals(location.getLocation().venue))
        {
            return;
        }
        location = mMap.addMarker(location, null, com.pointinside.maps.PIMap.AddMarkerAnimation.DROP);
        if (flag)
        {
            mSelectedMarker = location;
        }
        drawable = new a(mapdisplayableitem, drawable1, drawable);
        mMarkers.put(location, drawable);
    }

    private void a(Marker marker, boolean flag)
    {
        a a1 = (a)mMarkers.get(marker);
        if (a1 == null)
        {
            return;
        }
        if (flag)
        {
            marker.markerDrawable(com.target.ui.view.map.a.b(a1));
        } else
        {
            marker.markerDrawable(a.c(a1));
        }
        marker.update(com.pointinside.maps.PIMap.UpdateMarkerAnimation.NONE);
    }

    private void a(String s1, String s2, float f1, float f2, float f3, float f4, float f5, 
            boolean flag)
    {
        s1 = (new com.pointinside.maps.Location.Builder()).x(f1).y(f2).zone(s2).venue(s1).build();
        mMap.setBlueDotRange(f4);
        if (mBlueDotLocation == null) goto _L2; else goto _L1
_L1:
        mMap.moveBlueDot(s1);
_L4:
        mBlueDotLocation = s1;
        f();
        return;
_L2:
        mMap.addBlueDot(s1, 1);
        if (flag)
        {
            a(((Location) (s1)), 4000L);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int b(int i1)
    {
        switch (i1)
        {
        default:
            return 4;

        case 0: // '\0'
            return 2;

        case 2: // '\002'
            return 1;

        case 1: // '\001'
            return 3;

        case 3: // '\003'
            return 0;
        }
    }

    static Marker b(StoreMapView storemapview)
    {
        return storemapview.mSelectedMarker;
    }

    static Marker b(StoreMapView storemapview, Marker marker)
    {
        storemapview.mBlueDotMarker = marker;
        return marker;
    }

    static Map c(StoreMapView storemapview)
    {
        return storemapview.mMarkers;
    }

    private void c()
    {
        mMap.setOnMarkerClickListener(new com.pointinside.maps.PIMap.OnMarkerClickListener() {

            final StoreMapView this$0;

            public void onMarkerClick(Marker marker, PointF pointf, PointF pointf1)
            {
label0:
                {
                    if (StoreMapView.h(StoreMapView.this) != null)
                    {
                        pointf = (a)StoreMapView.c(StoreMapView.this).get(marker);
                        if (com.target.ui.view.map.StoreMapView.b(StoreMapView.this) != marker)
                        {
                            break label0;
                        }
                        com.target.ui.view.map.StoreMapView.a(StoreMapView.this, null);
                        StoreMapView.h(StoreMapView.this).d(com.target.ui.view.map.a.a(pointf));
                    }
                    return;
                }
                com.target.ui.view.map.StoreMapView.a(StoreMapView.this, marker);
                StoreMapView.h(StoreMapView.this).c(com.target.ui.view.map.a.a(pointf));
            }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
        });
    }

    static com.pointinside.maps.PIMap.CameraCallback d(StoreMapView storemapview)
    {
        return storemapview.mCameraCallback;
    }

    private void d()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            al.a(new View[] {
                mViews.arrowDown, mViews.arrowUp, mViews.arrowLeft, mViews.arrowRight
            });
            return;
        }
    }

    static com.target.ui.fragment.map.a.b.e e(StoreMapView storemapview)
    {
        return storemapview.mOnMapDragListener;
    }

    private boolean e()
    {
        float f1 = mMap.getCameraPosition().visibleMapWidth;
        PointF pointf = getSelectedMarkerDistanceFromCenter();
        return Math.abs(pointf.y) <= f1 / 2.0F && Math.abs(pointf.x) <= f1 / 2.0F;
    }

    static com.pointinside.maps.PIMap.OnZoneLoadCallback f(StoreMapView storemapview)
    {
        return storemapview.mOnZoneLoadCallback;
    }

    private void f()
    {
        while (mOnMarkerScreenLocationListener == null || mBlueDotLocation == null || mSelectedMarker == null || !mSelectedMarker.getLocation().zone.equals(mBlueDotLocation.zone)) 
        {
            return;
        }
        if (e())
        {
            mOnMarkerScreenLocationListener.F();
            return;
        } else
        {
            int i1 = a(mBlueDotLocation);
            mOnMarkerScreenLocationListener.c(i1);
            return;
        }
    }

    static c g(StoreMapView storemapview)
    {
        return storemapview.mViews;
    }

    private PointF getSelectedMarkerDistanceFromCenter()
    {
        PointF pointf = mMap.getCameraPosition().pointInZone;
        Location location = mSelectedMarker.getLocation();
        float f1 = location.y;
        float f2 = pointf.y;
        return new PointF(location.x - pointf.x, f1 - f2);
    }

    static b h(StoreMapView storemapview)
    {
        return storemapview.mOnMapItemClickListener;
    }

    static PIMap i(StoreMapView storemapview)
    {
        return storemapview.mMap;
    }

    static void j(StoreMapView storemapview)
    {
        storemapview.f();
    }

    static com.target.ui.fragment.map.a.b.a k(StoreMapView storemapview)
    {
        return storemapview.mOnCameraMoveListener;
    }

    static com.target.ui.fragment.map.a.b.c l(StoreMapView storemapview)
    {
        return storemapview.mOnDirectionArrowClickListener;
    }

    static Marker m(StoreMapView storemapview)
    {
        return storemapview.mBlueDotMarker;
    }

    public void A()
    {
        com.target.ui.util.e.a.a(this);
    }

    public void a()
    {
        if (mViews != null && mViews.mapView != null)
        {
            mViews.mapView.onPause();
        }
    }

    public void a(float f1)
    {
        if (mSelectedMarker == null)
        {
            return;
        } else
        {
            Location location = mSelectedMarker.getLocation();
            mMap.animateCamera((new com.pointinside.maps.model.CameraPosition.Builder(mMap.getCameraPosition())).pointInZone(location.getMapPoint()).zoomPercent(f1).build(), new com.pointinside.maps.PIMap.CameraCallback() {

                final StoreMapView this$0;

                public void onCameraSet()
                {
                    if (com.target.ui.view.map.StoreMapView.a(StoreMapView.this) != null && (a)StoreMapView.c(StoreMapView.this).get(com.target.ui.view.map.StoreMapView.b(StoreMapView.this)) != null)
                    {
                        com.target.ui.view.map.StoreMapView.a(StoreMapView.this).D();
                    }
                }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
            });
            return;
        }
    }

    public void a(int i1)
    {
        if (mViews == null)
        {
            return;
        }
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            al.a(mViews.arrowLeft, new View[] {
                mViews.arrowUp, mViews.arrowDown, mViews.arrowRight
            });
            mViews.arrowLeft.setOnClickListener(arrowClickListener);
            return;

        case 4: // '\004'
            d();
            return;

        case 3: // '\003'
            al.a(mViews.arrowDown, new View[] {
                mViews.arrowUp, mViews.arrowLeft, mViews.arrowRight
            });
            mViews.arrowDown.setOnClickListener(arrowClickListener);
            return;

        case 2: // '\002'
            al.a(mViews.arrowUp, new View[] {
                mViews.arrowDown, mViews.arrowLeft, mViews.arrowRight
            });
            mViews.arrowUp.setOnClickListener(arrowClickListener);
            return;

        case 1: // '\001'
            al.a(mViews.arrowRight, new View[] {
                mViews.arrowUp, mViews.arrowLeft, mViews.arrowDown
            });
            mViews.arrowRight.setOnClickListener(arrowClickListener);
            return;
        }
    }

    public void a(Location location, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        Drawable drawable1 = getResources().getDrawable(0x7f0201bf);
        Drawable drawable;
        if (markersSelectable)
        {
            drawable = getResources().getDrawable(0x7f0201c0);
        } else
        {
            drawable = drawable1;
        }
        a(location, drawable, drawable1, mapdisplayableitem, flag);
    }

    public void a(Location location, com.target.ui.view.DepartmentBadgeView.a a1, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        int i1 = getResources().getColor(0x7f0f00eb);
        int j1 = getResources().getColor(0x7f0f00f9);
        android.graphics.drawable.BitmapDrawable bitmapdrawable = s.a(getContext(), 0x7f0201bf, DepartmentBadgeView.a(a1), j1);
        if (markersSelectable)
        {
            a1 = s.a(getContext(), 0x7f0201c0, DepartmentBadgeView.a(a1), i1);
        } else
        {
            a1 = bitmapdrawable;
        }
        a(location, ((Drawable) (a1)), ((Drawable) (bitmapdrawable)), mapdisplayableitem, flag);
    }

    public void a(Location location, String s1, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        android.graphics.drawable.BitmapDrawable bitmapdrawable = s.a(getContext(), 0x7f0201bf, s1, 0x7f0f00f9);
        if (markersSelectable)
        {
            s1 = s.a(getContext(), 0x7f0201c0, s1, 0x7f0f00eb);
        } else
        {
            s1 = bitmapdrawable;
        }
        a(location, ((Drawable) (s1)), ((Drawable) (bitmapdrawable)), mapdisplayableitem, flag);
    }

    public void a(Venue venue, Zone zone)
    {
        al.b(mViews.zoneSelector);
        mViews.zoneSelector.setVenue(venue);
        mViews.zoneSelector.a(zone);
    }

    public void a(Venue venue, Zone zone, com.target.ui.fragment.map.a.b.b b1)
    {
        if (venue.getAllZones().size() > 1)
        {
            mViews.mapView.setPadding(mViews.mapView.getPaddingLeft(), getResources().getDimensionPixelSize(0x7f0a01f8), mViews.mapView.getRight(), mViews.mapView.getBottom());
        }
        mMap.initCamera(venue, CameraPosition.createWith(zone).tilt(30F).build(), null, new com.pointinside.maps.PIMap.CameraCallback() {

            final StoreMapView this$0;

            public void onCameraSet()
            {
                if (StoreMapView.d(StoreMapView.this) != null)
                {
                    StoreMapView.d(StoreMapView.this).onCameraSet();
                }
            }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
        });
    }

    public void a(Zone zone, float f1)
    {
        mMap.animateCamera((new com.pointinside.maps.model.CameraPosition.Builder(mMap.getCameraPosition())).pointInZone(zone.getCenter()).zoomPercent(f1).build(), new com.pointinside.maps.PIMap.CameraCallback() {

            final StoreMapView this$0;

            public void onCameraSet()
            {
            }

            
            {
                this$0 = StoreMapView.this;
                super();
            }
        });
    }

    public void a(Zone zone, final com.target.ui.fragment.map.a.b.h listener)
    {
        mMap.animateCameraWithZoneSelector((new com.pointinside.maps.model.CameraPosition.Builder(mMap.getCameraPosition())).zone(zone).build(), new com.pointinside.maps.PIMap.CameraCallback() {

            final StoreMapView this$0;
            final com.target.ui.fragment.map.a.b.h val$listener;

            public void onCameraSet()
            {
                if (listener == null)
                {
                    return;
                } else
                {
                    listener.a();
                    return;
                }
            }

            
            {
                this$0 = StoreMapView.this;
                listener = h1;
                super();
            }
        });
    }

    public void a(MapDisplayableItem mapdisplayableitem)
    {
        if (mMarkers != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Iterator iterator;
        java.util.Map.Entry entry;
        iterator = mMarkers.entrySet().iterator();
        a a1;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            entry = (java.util.Map.Entry)iterator.next();
            a1 = (a)entry.getValue();
        } while (mapdisplayableitem.b() == null || !mapdisplayableitem.b().equals(com.target.ui.view.map.a.a(a1).b()));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        mapdisplayableitem = (Marker)entry.getKey();
        mapdisplayableitem.remove();
        mapdisplayableitem.update(com.pointinside.maps.PIMap.UpdateMarkerAnimation.MOVING_CROSS_FADE);
        iterator.remove();
        return;
    }

    public void a(String s1, String s2, float f1, float f2, float f3, float f4, float f5, 
            boolean flag, float f6)
    {
        a(s1, s2, f1, f2, f3, f4, f5, true);
        if (flag)
        {
            a(mBlueDotLocation, f5, f6);
        }
    }

    public void a(boolean flag)
    {
        mViews.zoneSelector.a(flag);
    }

    public void b()
    {
        if (mViews != null && mViews.mapView != null)
        {
            mViews.mapView.onResume();
        }
    }

    public void b(float f1)
    {
        if (mBlueDotLocation == null)
        {
            if (mOnGuestLocationNotAvailableListener != null)
            {
                mOnGuestLocationNotAvailableListener.H();
            }
            return;
        } else
        {
            a(mBlueDotLocation, f1, CameraAnimation.EaseIn);
            return;
        }
    }

    public void b(Location location, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        Object obj = af.b(mapdisplayableitem.a(), 30);
        Object obj1 = ((BlackFridayDealDetails)mapdisplayableitem.e().c()).a();
        obj1 = s.a(getContext(), 0x7f020195, ((String) (obj1)), 0x7f0f00f1);
        if (markersSelectable)
        {
            obj = s.b(getContext(), 0x7f0201dc, ((String) (obj)), 0x7f0f00f9);
        } else
        {
            obj = obj1;
        }
        a(location, ((Drawable) (obj)), ((Drawable) (obj1)), mapdisplayableitem, flag);
    }

    public void b(MapDisplayableItem mapdisplayableitem)
    {
        Iterator iterator = mMarkers.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            a a1 = (a)entry.getValue();
            if (mapdisplayableitem.b() == null || !mapdisplayableitem.b().equals(com.target.ui.view.map.a.a(a1).b()))
            {
                continue;
            }
            a((Marker)entry.getKey(), false);
            break;
        } while (true);
    }

    public void d(boolean flag)
    {
        View view = mViews.progress;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }

    public void f(String s1)
    {
        MapFeatureSettings mapfeaturesettings = mMap.getMapFeatureSettings();
        try
        {
            s1 = mMap.getCurrentVenue().findZoneByUUID(s1);
            FeatureStyle featurestyle = mapfeaturesettings.getFeatureStyle("Copyright", s1);
            featurestyle.visibilty(false);
            mapfeaturesettings.setFeatureStyle("Copyright", s1, featurestyle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.target.ui.util.q.a(LOG_TAG, (new StringBuilder()).append("Error setting zone features: ").append(s1.getMessage()).toString());
        }
    }

    public void j(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.translucentOverlay);
            aj.a(mViews.translucentOverlay, 0.7F);
            return;
        } else
        {
            aj.g(mViews.translucentOverlay);
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mViews = null;
    }

    public void q()
    {
        mBlueDotLocation = null;
        mMap.removeBlueDot();
    }

    public void setCameraCallback(com.pointinside.maps.PIMap.CameraCallback cameracallback)
    {
        mCameraCallback = cameracallback;
    }

    public void setMarkersSelectable(boolean flag)
    {
        markersSelectable = flag;
    }

    public void setOnCameraMoveListener(com.target.ui.fragment.map.a.b.a a1)
    {
        mOnCameraMoveListener = a1;
    }

    public void setOnDirectionArrowClickListener(com.target.ui.fragment.map.a.b.c c1)
    {
        mOnDirectionArrowClickListener = c1;
    }

    public void setOnGuestLocationNotAvailableListener(com.target.ui.fragment.map.a.b.d d1)
    {
        mOnGuestLocationNotAvailableListener = d1;
    }

    public void setOnMapDragListener(com.target.ui.fragment.map.a.b.e e1)
    {
        mOnMapDragListener = e1;
    }

    public void setOnMapProductClickListener(b b1)
    {
        mOnMapItemClickListener = b1;
    }

    public void setOnMarkerOffScreenListener(com.target.ui.fragment.map.a.b.f f1)
    {
        mOnMarkerScreenLocationListener = f1;
    }

    public void setOnZoneLoadCallback(com.pointinside.maps.PIMap.OnZoneLoadCallback onzoneloadcallback)
    {
        mOnZoneLoadCallback = onzoneloadcallback;
    }

    public void setOnZoomedToMarkerListener(com.target.ui.fragment.map.a.b.g g1)
    {
        mOnZoomedToMarkerListener = g1;
    }

    public void setSelectedMarker(MapDisplayableItem mapdisplayableitem)
    {
        if (mMarkers != null)
        {
            Iterator iterator = mMarkers.entrySet().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (java.util.Map.Entry)iterator.next();
                a a1 = (a)((java.util.Map.Entry) (obj)).getValue();
                obj = (Marker)((java.util.Map.Entry) (obj)).getKey();
                if (mapdisplayableitem.b() != null && mapdisplayableitem.b().equals(com.target.ui.view.map.a.a(a1).b()))
                {
                    mSelectedMarker = ((Marker) (obj));
                    a(mSelectedMarker, true);
                } else
                {
                    a(((Marker) (obj)), false);
                }
            }
        }
    }

    public void setZoneSelectorStateListener(ZoneSelectionView.c c1)
    {
        mViews.zoneSelector.a(c1);
    }

    public void u()
    {
        c();
    }

    public void x()
    {
        TextView textview = (TextView)findViewById(0x7f100453);
        if (textview != null)
        {
            textview.setText(getResources().getString(0x7f0903b6));
        }
    }

    public void y()
    {
        al.c(mViews.translucentOverlay);
        mViews.translucentOverlay.setAlpha(0.0F);
    }

    public void z()
    {
        al.b(mViews.translucentOverlay);
        mViews.translucentOverlay.setAlpha(1.0F);
    }

}
