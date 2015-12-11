// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.VisibleRegion;
import com.groupon.adapter.DealClickListener;
import com.groupon.db.models.DealSummary;
import com.groupon.debug.DebugQualityTools;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.ImageUrl;
import com.groupon.view.DealsMapRating;
import com.groupon.view.UrlImageView;
import com.squareup.picasso.Callback;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class DealsMapView extends MapView
{
    protected static class DealSummaryMarkerContainer
    {

        private DealSummary dealSummary;
        private Marker marker;


        public DealSummaryMarkerContainer(Marker marker1, DealSummary dealsummary)
        {
            marker = marker1;
            dealSummary = dealsummary;
        }
    }

    public static interface InfoWindowImageLoadedListener
    {

        public abstract void onImageLoaded(Marker marker);
    }

    public class MerchantMapDetail extends FrameLayout
    {

        int bottomHitOffset;
        int bottomOffset;
        int heightPx;
        LayoutInflater inflater;
        InfoWindowImageLoadedListener listener;
        Marker marker;
        final DealsMapView this$0;
        int widthPx;

        public void getHitRect(Rect rect)
        {
            super.getHitRect(rect);
            rect.bottom = rect.bottom - bottomHitOffset;
        }

        public void setData(Marker marker1)
        {
            marker = marker1;
            Object obj = (DealSummaryMarkerContainer)markerDealSummaryHashMap.get(marker1.getTitle());
            marker1 = null;
            if (obj != null)
            {
                marker1 = ((DealSummaryMarkerContainer) (obj)).dealSummary;
            }
            int i;
            if (marker1 != null)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            setVisibility(i);
            if (marker1 == null)
            {
                return;
            }
            Object obj1 = (UrlImageView)findViewById(0x7f100121);
            ((UrlImageView) (obj1)).setCallback(new Callback() {

                final MerchantMapDetail this$1;

                public void onError(ImageView imageview)
                {
                }

                public void onSuccess(ImageView imageview)
                {
                    if (listener != null)
                    {
                        listener.onImageLoaded(marker);
                    }
                }

            
            {
                this$1 = MerchantMapDetail.this;
                super();
            }
            });
            int j;
            boolean flag;
            boolean flag1;
            if (Strings.notEmpty(((DealSummary) (marker1)).derivedImageUrl))
            {
                obj = new ImageUrl(((DealSummary) (marker1)).derivedImageUrl, true);
            } else
            {
                obj = new ImageUrl(((DealSummary) (marker1)).sidebarImageUrl, false);
            }
            ((UrlImageView) (obj1)).setImageUrl(((ImageUrl) (obj)), widthPx, heightPx);
            obj1 = (TextView)findViewById(0x7f1003ed);
            if (((DealSummary) (marker1)).derivedOptionEndRedemptionAt == null)
            {
                obj = ((DealSummary) (marker1)).endRedemptionAt;
            } else
            {
                obj = ((DealSummary) (marker1)).derivedOptionEndRedemptionAt;
            }
            if (obj != null && (new Date()).after(((Date) (obj))))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            flag = ((DealSummary) (marker1)).isSoldOut;
            flag1 = Strings.equalsIgnoreCase("closed", ((DealSummary) (marker1)).status);
            if (i != 0 || flag || flag1)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj1)).setVisibility(i);
            if (flag)
            {
                i = 0x7f0803b4;
            } else
            {
                i = 0x7f080124;
            }
            ((TextView) (obj1)).setText(i);
            ((TextView)findViewById(0x7f1003ee)).setText(((DealSummary) (marker1)).derivedMerchantName);
            ((TextView)findViewById(0x7f1003f0)).setText(((DealSummary) (marker1)).announcementTitle);
            i = ((DealSummary) (marker1)).derivedMinimumPurchaseQuantity;
            j = ((DealSummary) (marker1)).derivedPriceAmount;
            if (j == 0)
            {
                obj = "";
            } else
            {
                obj = currencyFormatter.formatWithQuantity(j, ((DealSummary) (marker1)).derivedPriceCurrencyCode, i, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
            }
            flag = marker1.getDisplayOption("discount", true);
            obj1 = (TextView)findViewById(0x7f1003f1);
            if (flag)
            {
                if (currentCountryManager.getCurrentCountry().isJapan())
                {
                    ((TextView) (obj1)).setText(generateFormattedDiscount(((DealSummary) (marker1)).derivedDiscountPercent));
                } else
                {
                    ((TextView) (obj1)).setText(generateFormattedValue(marker1, i));
                    ((TextView) (obj1)).setPaintFlags(((TextView) (obj1)).getPaintFlags() | 0x10);
                }
            } else
            {
                ((TextView) (obj1)).setVisibility(8);
            }
            ((TextView)findViewById(0x7f1003f2)).setText(((CharSequence) (obj)));
            obj = (DealsMapRating)findViewById(0x7f1003ef);
            if (((DealSummary) (marker1)).grouponRating != 0.0D)
            {
                ((DealsMapRating) (obj)).setRating(((DealSummary) (marker1)).grouponRating);
                ((DealsMapRating) (obj)).setVisibility(0);
                return;
            } else
            {
                ((DealsMapRating) (obj)).setVisibility(8);
                return;
            }
        }

        public void setListener(InfoWindowImageLoadedListener infowindowimageloadedlistener)
        {
            listener = infowindowimageloadedlistener;
        }

        public MerchantMapDetail(Context context)
        {
            this$0 = DealsMapView.this;
            super(context);
            widthPx = getResources().getDimensionPixelSize(0x7f0b01c1);
            heightPx = getResources().getDimensionPixelSize(0x7f0b01c0);
            bottomOffset = (int)context.getResources().getDimension(0x7f0b0009);
            bottomHitOffset = bottomOffset + (int)context.getResources().getDimension(0x7f0b000a);
            RoboGuice.getInjector(context).injectMembers(this);
            dealsmapview = (LinearLayout)inflater.inflate(0x7f030158, null);
            context = new android.widget.FrameLayout.LayoutParams(-2, -2);
            context.gravity = 0;
            addView(DealsMapView.this, context);
        }
    }

    public static interface OnChangeListener
    {

        public abstract void onChange();
    }


    public static final double DEF_SEARCH_RADIUS = 15D;
    public static final double MAX_SEARCH_RADIUS = 69D;
    public static final double MIN_SEARCH_RADIUS = 2D;
    private com.google.android.gms.maps.model.LatLngBounds.Builder boundsBuilder;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private Marker currentMarker;
    private DealClickListener dealClickListener;
    private List dealMarkers;
    private Marker defaultMarker;
    private GeoUtils geoUtils;
    private volatile GoogleMap googleMap;
    private final Object googleMapLock;
    private Drawable grouponPin;
    private CameraUpdate lastCameraUpdate;
    private LocationService locationService;
    private HashMap markerDealSummaryHashMap;
    private android.view.View.OnTouchListener onTouchListener;
    private double radius;

    public DealsMapView(Context context)
    {
        super(context);
        googleMapLock = new Object();
        currentMarker = null;
        RoboGuice.getInjector(context).injectMembers(this);
        init();
    }

    public DealsMapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        googleMapLock = new Object();
        currentMarker = null;
        RoboGuice.getInjector(context).injectMembers(this);
        init();
    }

    public DealsMapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        googleMapLock = new Object();
        currentMarker = null;
        RoboGuice.getInjector(context).injectMembers(this);
        init();
    }

    public DealsMapView(Context context, GoogleMapOptions googlemapoptions)
    {
        super(context, googlemapoptions);
        googleMapLock = new Object();
        currentMarker = null;
        RoboGuice.getInjector(context).injectMembers(this);
        init();
    }

    private static Drawable boundLeftBottom(Drawable drawable, int i, int j)
    {
        drawable.setBounds(i, -drawable.getIntrinsicHeight() + j, drawable.getIntrinsicWidth() + i, j);
        return drawable;
    }

    private String generateFormattedDiscount(int i)
    {
        if (i == 0)
        {
            return "";
        } else
        {
            return getResources().getString(0x7f080134, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    private String generateFormattedValue(DealSummary dealsummary, int i)
    {
        if (dealsummary.derivedPriceAmount == 0 || dealsummary.derivedValueAmount == 0)
        {
            return "";
        } else
        {
            return currencyFormatter.formatWithQuantity(dealsummary.derivedValueAmount, dealsummary.derivedValueCurrencyCode, i, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        }
    }

    private void init()
    {
        setRadius(15D);
        int i = (int)getContext().getResources().getDimension(0x7f0b0007);
        int j = (int)getContext().getResources().getDimension(0x7f0b0008);
        grouponPin = boundLeftBottom(getContext().getResources().getDrawable(0x7f02017f), i, j);
    }

    private void setRadius(double d)
    {
        radius = d;
    }

    public void addDeals(List list, GeoPoint geopoint)
    {
        if (list != null && !list.isEmpty())
        {
            if (dealMarkers == null)
            {
                dealMarkers = new ArrayList();
                markerDealSummaryHashMap = new HashMap();
                boundsBuilder = LatLngBounds.builder();
                currentMarker = null;
                defaultMarker = null;
            }
            Iterator iterator1 = list.iterator();
            while (iterator1.hasNext()) 
            {
                DealSummary dealsummary = (DealSummary)iterator1.next();
                ArrayList arraylist = dealsummary.derivedRedemptionLocations;
                GoogleMap googlemap = getGoogleMap();
                Object obj1 = null;
                list = null;
                double d = 1.7976931348623157E+308D;
                Object obj = obj1;
                if (arraylist != null)
                {
                    obj = obj1;
                    if (googlemap != null)
                    {
                        obj = obj1;
                        if (!markerDealSummaryHashMap.containsKey(dealsummary.remoteId))
                        {
                            Iterator iterator = arraylist.iterator();
                            do
                            {
                                obj = list;
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                GeoPoint geopoint1 = (GeoPoint)iterator.next();
                                float f = geopoint1.getLatitudeDegrees();
                                float f1 = geopoint1.getLongitudeDegrees();
                                if ((double)f != 0.0D && (double)f1 != 0.0D)
                                {
                                    obj = googlemap.addMarker((new MarkerOptions()).position(new LatLng(f, f1)).icon(BitmapDescriptorFactory.fromBitmap(((BitmapDrawable)grouponPin).getBitmap())));
                                    ((Marker) (obj)).setTitle(dealsummary.remoteId);
                                    dealMarkers.add(obj);
                                    markerDealSummaryHashMap.put(dealsummary.remoteId, new DealSummaryMarkerContainer(((Marker) (obj)), dealsummary));
                                    boundsBuilder.include(((Marker) (obj)).getPosition());
                                    if (defaultMarker == null)
                                    {
                                        double d1 = geoUtils.distanceBetween(geopoint, geopoint1);
                                        if (d1 < d)
                                        {
                                            d = d1;
                                            list = ((List) (obj));
                                        }
                                    }
                                }
                            } while (true);
                        }
                    }
                }
                if (defaultMarker == null && obj != null)
                {
                    defaultMarker = ((Marker) (obj));
                }
            }
        }
    }

    public void clearDeals()
    {
        if (dealMarkers != null)
        {
            for (Iterator iterator = dealMarkers.iterator(); iterator.hasNext(); iterator.remove())
            {
                ((Marker)iterator.next()).remove();
            }

            if (markerDealSummaryHashMap != null)
            {
                markerDealSummaryHashMap.clear();
            }
            boundsBuilder = LatLngBounds.builder();
            currentMarker = null;
            defaultMarker = null;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (onTouchListener != null)
        {
            onTouchListener.onTouch(getRootView(), motionevent);
        }
        return super.dispatchTouchEvent(motionevent);
    }

    public void enableMapDealDetails(boolean flag)
    {
        if (dealMarkers != null && dealMarkers.size() > 0)
        {
            if (!flag)
            {
                for (Iterator iterator = dealMarkers.iterator(); iterator.hasNext(); ((Marker)iterator.next()).hideInfoWindow()) { }
            } else
            {
                defaultMarker.showInfoWindow();
            }
        }
    }

    public LatLng getCenterCoordinates()
    {
        if (googleMap != null)
        {
            return googleMap.getCameraPosition().target;
        } else
        {
            return new LatLng(0.0D, 0.0D);
        }
    }

    public GoogleMap getGoogleMap()
    {
        if (googleMap == null)
        {
            synchronized (googleMapLock)
            {
                if (googleMap == null)
                {
                    googleMap = getMap();
                    if (googleMap != null)
                    {
                        initMap();
                    }
                }
            }
        }
        return googleMap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getRadius()
    {
        return (int)(radius + 0.5D);
    }

    public void initMap()
    {
        googleMap.setOnInfoWindowClickListener(new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

            final DealsMapView this$0;

            public void onInfoWindowClick(Marker marker)
            {
                if (dealClickListener != null)
                {
                    marker = (DealSummaryMarkerContainer)markerDealSummaryHashMap.get(marker.getTitle());
                    if (marker != null && ((DealSummaryMarkerContainer) (marker)).dealSummary != null)
                    {
                        dealClickListener.onDealClicked(-1, ((DealSummaryMarkerContainer) (marker)).dealSummary);
                    }
                }
            }

            
            {
                this$0 = DealsMapView.this;
                super();
            }
        });
        googleMap.setInfoWindowAdapter(new com.google.android.gms.maps.GoogleMap.InfoWindowAdapter() {

            final DealsMapView this$0;

            public View getInfoContents(Marker marker)
            {
                return null;
            }

            public View getInfoWindow(Marker marker)
            {
                MerchantMapDetail merchantmapdetail = new MerchantMapDetail(getContext());
                if (currentMarker == null || !currentMarker.equals(marker))
                {
                    merchantmapdetail.setListener(new InfoWindowImageLoadedListener() {

                        final _cls2 this$1;

                        public void onImageLoaded(Marker marker)
                        {
                            if (marker.isInfoWindowShown())
                            {
                                marker.hideInfoWindow();
                                marker.showInfoWindow();
                            }
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
                merchantmapdetail.setData(marker);
                currentMarker = marker;
                return merchantmapdetail;
            }

            
            {
                this$0 = DealsMapView.this;
                super();
            }
        });
        googleMap.getUiSettings().setZoomControlsEnabled(false);
    }

    public void measureMapSpan(boolean flag)
    {
        Object obj = getGoogleMap();
        double d;
        if (flag || obj == null)
        {
            d = 15D;
        } else
        {
            obj = ((GoogleMap) (obj)).getProjection().getVisibleRegion();
            d = Math.min(geoUtils.milesBetween(new GeoPoint((int)(((VisibleRegion) (obj)).farLeft.latitude * 1000000D), (int)(((VisibleRegion) (obj)).farLeft.longitude * 1000000D)), new GeoPoint((int)(((VisibleRegion) (obj)).farRight.latitude * 1000000D), (int)(((VisibleRegion) (obj)).farRight.longitude * 1000000D))), geoUtils.milesBetween(new GeoPoint((int)(((VisibleRegion) (obj)).farLeft.latitude * 1000000D), (int)(((VisibleRegion) (obj)).farLeft.longitude * 1000000D)), new GeoPoint((int)(((VisibleRegion) (obj)).nearLeft.latitude * 1000000D), (int)(((VisibleRegion) (obj)).nearLeft.longitude * 1000000D))));
            if (d > 0.0D)
            {
                d = Math.min(69D, Math.max(2D, 0.5D * d));
            } else
            {
                d = 15D;
            }
        }
        setRadius(d);
    }

    public void moveCamera(CameraUpdate cameraupdate, boolean flag)
    {
        GoogleMap googlemap;
        if (cameraupdate == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        googlemap = getGoogleMap();
        lastCameraUpdate = null;
        if (googlemap == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        googlemap.setOnCameraChangeListener(null);
        if (flag)
        {
            try
            {
                googlemap.animateCamera(cameraupdate);
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                lastCameraUpdate = cameraupdate;
            }
            break MISSING_BLOCK_LABEL_46;
        }
        googlemap.moveCamera(cameraupdate);
        return;
        googlemap.setOnCameraChangeListener(new com.google.android.gms.maps.GoogleMap.OnCameraChangeListener() {

            final DealsMapView this$0;

            public void onCameraChange(CameraPosition cameraposition)
            {
                cameraposition = getGoogleMap();
                if (cameraposition != null && getHeight() > 0 && getWidth() > 0)
                {
                    if (lastCameraUpdate != null)
                    {
                        cameraposition.moveCamera(lastCameraUpdate);
                    }
                    lastCameraUpdate = null;
                    cameraposition.setOnCameraChangeListener(null);
                }
            }

            
            {
                this$0 = DealsMapView.this;
                super();
            }
        });
    }

    public void moveCamera(LatLng latlng)
    {
        moveCamera(CameraUpdateFactory.newLatLng(latlng), true);
    }

    public void moveCamera(LatLng latlng, double d, boolean flag)
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
        moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, f1), flag);
    }

    public void moveCameraFitMapRadius(LatLng latlng, boolean flag)
    {
        moveCamera(latlng, getRadius(), flag);
    }

    public void moveCameraToFitDeals()
    {
        if (boundsBuilder != null && dealMarkers != null && dealMarkers.size() > 0)
        {
            moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 50), true);
        }
    }

    public void release()
    {
        clearDeals();
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

    public void resetCamera()
    {
        Object obj = locationService.getLocation();
        if (obj != null)
        {
            obj = new LatLng(((Location) (obj)).getLatitude(), ((Location) (obj)).getLongitude());
        } else
        {
            obj = currentDivisionManager.getCurrentDivision().geoPoint;
            obj = new LatLng(((GeoPoint) (obj)).getLatitudeDegrees(), ((GeoPoint) (obj)).getLongitudeDegrees());
        }
        moveCameraFitMapRadius(((LatLng) (obj)), false);
    }

    public void resetInternalStates()
    {
        clearDeals();
        setRadius(15D);
        lastCameraUpdate = null;
        GoogleMap googlemap = getGoogleMap();
        if (googlemap != null)
        {
            googlemap.setOnCameraChangeListener(null);
        }
        dealClickListener = null;
        resetCamera();
    }

    public void setDealClickListener(DealClickListener dealclicklistener)
    {
        dealClickListener = dealclicklistener;
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
        onTouchListener = ontouchlistener;
    }

    public int size()
    {
        if (dealMarkers == null)
        {
            return 0;
        } else
        {
            return dealMarkers.size();
        }
    }





/*
    static Marker access$302(DealsMapView dealsmapview, Marker marker)
    {
        dealsmapview.currentMarker = marker;
        return marker;
    }

*/



/*
    static CameraUpdate access$402(DealsMapView dealsmapview, CameraUpdate cameraupdate)
    {
        dealsmapview.lastCameraUpdate = cameraupdate;
        return cameraupdate;
    }

*/




}
