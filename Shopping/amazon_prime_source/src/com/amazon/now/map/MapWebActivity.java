// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Property;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.geo.mapsv2.AmazonMap;
import com.amazon.geo.mapsv2.CameraUpdate;
import com.amazon.geo.mapsv2.CameraUpdateFactory;
import com.amazon.geo.mapsv2.MapFragment;
import com.amazon.geo.mapsv2.OnMapReadyCallback;
import com.amazon.geo.mapsv2.model.BitmapDescriptorFactory;
import com.amazon.geo.mapsv2.model.LatLng;
import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.geo.mapsv2.model.MarkerOptions;
import com.amazon.now.ChromeStyle;
import com.amazon.now.location.Location;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.ImageUtil;
import com.amazon.now.web.NowWebView;
import com.amazon.now.web.WebActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.now.map:
//            MapController, MarkerInfo

public class MapWebActivity extends WebActivity
{
    private static class ImageReadyCallback
        implements com.amazon.now.util.ImageUtil.ImageDownloadCallback
    {

        private Marker mMarker;

        public void bitmapReady(Bitmap bitmap)
        {
            mMarker.setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));
            mMarker.setVisible(true);
        }

        public ImageReadyCallback(Marker marker)
        {
            mMarker = marker;
        }
    }


    public static final String INTENT_FROM_EXTERNAL_KEY = "fromExternalRequest";
    public static final String INTENT_RETURN_TO_CART_KEY = "returnToCart";
    private boolean hasZoomed;
    private Map mCourierMarkers;
    private Bitmap mCourierPinBitmap;
    private Marker mDestinationMarker;
    private Marker mLastOpened;
    private LinearLayout mLayout;
    private View mMapBar;
    private TextView mMapBarLeft;
    private TextView mMapBarRight;
    private Map mOriginMarkers;

    public MapWebActivity()
    {
        hasZoomed = false;
    }

    private void animateMarker(Marker marker, LatLng latlng)
    {
        TypeEvaluator typeevaluator = new TypeEvaluator() {

            final MapWebActivity this$0;

            public LatLng evaluate(float f, LatLng latlng1, LatLng latlng2)
            {
                return new LatLng((latlng2.latitude - latlng1.latitude) * (double)f + latlng1.latitude, (latlng2.longitude - latlng1.longitude) * (double)f + latlng1.longitude);
            }

            public volatile Object evaluate(float f, Object obj, Object obj1)
            {
                return evaluate(f, (LatLng)obj, (LatLng)obj1);
            }

            
            {
                this$0 = MapWebActivity.this;
                super();
            }
        };
        marker = ObjectAnimator.ofObject(marker, Property.of(com/amazon/geo/mapsv2/model/Marker, com/amazon/geo/mapsv2/model/LatLng, "position"), typeevaluator, new LatLng[] {
            latlng
        });
        marker.setDuration(3000L);
        marker.start();
    }

    private Bitmap getCourierPin()
    {
        if (mCourierPinBitmap == null)
        {
            Drawable drawable = getResources().getDrawable(0x7f020031);
            mCourierPinBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(mCourierPinBitmap);
            drawable.setBounds(0, 0, mCourierPinBitmap.getWidth(), mCourierPinBitmap.getHeight());
            drawable.draw(canvas);
        }
        return mCourierPinBitmap;
    }

    private void init()
    {
        initMap();
        mDestinationMarker = null;
        mCourierMarkers = new HashMap();
        mOriginMarkers = new HashMap();
        mMapBar.setVisibility(8);
    }

    private void initMap()
    {
        getMapFragment().getMapAsync(new OnMapReadyCallback() {

            final MapWebActivity this$0;

            public void onMapReady(AmazonMap amazonmap)
            {
                amazonmap.moveCamera(CameraUpdateFactory.newLatLngZoom(Location.getMapCenter(), 12F));
                amazonmap.setOnMarkerClickListener(new com.amazon.geo.mapsv2.AmazonMap.OnMarkerClickListener() {

                    final _cls1 this$1;

                    public boolean onMarkerClick(Marker marker)
                    {
                        if (mLastOpened != null)
                        {
                            mLastOpened.hideInfoWindow();
                            if (mLastOpened.equals(marker))
                            {
                                mLastOpened = null;
                                return true;
                            }
                        }
                        marker.showInfoWindow();
                        mLastOpened = marker;
                        return true;
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                amazonmap.setOnMapClickListener(new com.amazon.geo.mapsv2.AmazonMap.OnMapClickListener() {

                    final _cls1 this$1;

                    public void onMapClick(LatLng latlng)
                    {
                        mLastOpened = null;
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = MapWebActivity.this;
                super();
            }
        });
    }

    private void resetMap()
    {
        getMapFragment().getMapAsync(new OnMapReadyCallback() {

            final MapWebActivity this$0;

            public void onMapReady(AmazonMap amazonmap)
            {
                amazonmap.clear();
            }

            
            {
                this$0 = MapWebActivity.this;
                super();
            }
        });
    }

    public static void startActivity(Context context, String s, boolean flag, boolean flag1)
    {
        startActivity(context, s, flag, flag1, false);
    }

    public static void startActivity(Context context, String s, boolean flag, boolean flag1, boolean flag2)
    {
        Intent intent = new Intent(context, com/amazon/now/map/MapWebActivity);
        intent.putExtra("intentUrlKey", s);
        intent.putExtra("returnToCart", flag);
        intent.putExtra("fromExternalRequest", flag1);
        intent.addFlags(0x20000);
        if (flag2)
        {
            NavManager.modifyIntentForNewStack(intent);
        }
        context.startActivity(intent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            if (closeLeftNav())
            {
                return true;
            }
            if (getIntent().getBooleanExtra("returnToCart", false))
            {
                goToCart();
            }
            if (getIntent().getBooleanExtra("fromExternalRequest", false))
            {
                AppUtils.goHome(this);
            }
        }
        return super.dispatchKeyEvent(keyevent);
    }

    public void displayMapBar(String s, String s1, String s2, String s3)
    {
        mMapBar.setVisibility(0);
        mMapBarLeft.setText(s);
        mMapBarLeft.setTextColor(Color.parseColor(s1));
        mMapBarRight.setText(s2);
        mMapBarRight.setTextColor(Color.parseColor(s3));
    }

    protected MapFragment getMapFragment()
    {
        MapFragment mapfragment1 = (MapFragment)getFragmentManager().findFragmentByTag("AmazonMapFragmentTag");
        MapFragment mapfragment = mapfragment1;
        if (mapfragment1 == null)
        {
            mapfragment = MapController.getInstance().getMapFragment();
        }
        return mapfragment;
    }

    public View getWebViewHolder()
    {
        return mLayout;
    }

    public void onCreate(Bundle bundle)
    {
        getIntent().putExtra("intentSkipKey", true);
        super.onCreate(bundle);
        mLayout = (LinearLayout)LayoutInflater.from(this).inflate(0x7f03001a, null);
        mMapBar = mLayout.findViewById(0x7f0e0084);
        mMapBarLeft = (TextView)mLayout.findViewById(0x7f0e0085);
        mMapBarRight = (TextView)mLayout.findViewById(0x7f0e0086);
        getFragmentManager().beginTransaction().replace(0x7f0e0083, getMapFragment(), "AmazonMapFragmentTag").commit();
        init();
        setRootView(mLayout, new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL));
    }

    public void onDestroy()
    {
        super.onDestroy();
        resetMap();
        mLastOpened = null;
        mDestinationMarker = null;
        mCourierMarkers.clear();
        mOriginMarkers.clear();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        init();
        resetMap();
        intent = intent.getStringExtra("intentUrlKey");
        if (!TextUtils.isEmpty(intent))
        {
            loadUrl(intent);
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    public void onWebViewReady(NowWebView nowwebview)
    {
        nowwebview.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
    }

    public void pan()
    {
        final CameraUpdate update = new com.amazon.geo.mapsv2.model.LatLngBounds.Builder();
        if (mDestinationMarker != null || !mCourierMarkers.isEmpty())
        {
            if (!mOriginMarkers.isEmpty() && mCourierMarkers.isEmpty())
            {
                for (Iterator iterator = mOriginMarkers.entrySet().iterator(); iterator.hasNext(); update.include(((Marker)((java.util.Map.Entry)iterator.next()).getValue()).getPosition())) { }
            }
            if (mDestinationMarker != null)
            {
                update.include(mDestinationMarker.getPosition());
            }
            for (Iterator iterator1 = mCourierMarkers.entrySet().iterator(); iterator1.hasNext(); update.include(((Marker)((java.util.Map.Entry)iterator1.next()).getValue()).getPosition())) { }
            update = update.build();
            int i = AppUtils.getPxFromDp(this, 50);
            if (getMapFragment().getView() != null && getMapFragment().getView().getMeasuredHeight() >= i * 2)
            {
                int j = getMapFragment().getView().getMeasuredHeight();
                update = CameraUpdateFactory.newLatLngBounds(update, getMapFragment().getView().getMeasuredWidth(), j, i);
                getMapFragment().getMapAsync(new OnMapReadyCallback() {

                    final MapWebActivity this$0;
                    final CameraUpdate val$update;

                    public void onMapReady(AmazonMap amazonmap)
                    {
                        amazonmap.moveCamera(update);
                    }

            
            {
                this$0 = MapWebActivity.this;
                update = cameraupdate;
                super();
            }
                });
                return;
            }
        }
    }

    public void plotMarkers(List list)
    {
        final MarkerOptions destination = new MarkerOptions();
        final LinkedList couriers = new LinkedList();
        final LinkedList origins = new LinkedList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MarkerInfo markerinfo = (MarkerInfo)list.next();
            static class _cls6
            {

                static final int $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[];

                static 
                {
                    $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType = new int[MarkerInfo.MarkerType.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[MarkerInfo.MarkerType.Destination.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[MarkerInfo.MarkerType.Courier.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[MarkerInfo.MarkerType.Origin.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls6..SwitchMap.com.amazon.now.map.MarkerInfo.MarkerType[markerinfo.getType().ordinal()])
            {
            case 1: // '\001'
                if (mDestinationMarker != null && markerinfo.getCoords() != null)
                {
                    mDestinationMarker.setPosition(markerinfo.getCoords());
                    mDestinationMarker.setTitle(markerinfo.getTitle());
                } else
                {
                    destination.position(markerinfo.getCoords());
                    destination.title(markerinfo.getTitle());
                    destination.icon(BitmapDescriptorFactory.defaultMarker(0.0F));
                    destination.anchor(0.5F, 1.0F);
                }
                break;

            case 2: // '\002'
                if (mCourierMarkers.containsKey(markerinfo.getId()))
                {
                    Marker marker = (Marker)mCourierMarkers.get(markerinfo.getId());
                    if (markerinfo.getCoords() != null)
                    {
                        animateMarker(marker, markerinfo.getCoords());
                    }
                    marker.setTitle(markerinfo.getTitle());
                } else
                {
                    MarkerOptions markeroptions = new MarkerOptions();
                    markeroptions.position(markerinfo.getCoords());
                    markeroptions.title(markerinfo.getTitle());
                    if (AppUtils.isDefined(markerinfo.getImageUrl()))
                    {
                        markeroptions.snippet((new StringBuilder()).append(markerinfo.getId()).append("###").append(markerinfo.getImageUrl()).toString());
                        markeroptions.visible(false);
                    } else
                    {
                        markeroptions.snippet(markerinfo.getId());
                        markeroptions.icon(BitmapDescriptorFactory.fromBitmap(getCourierPin()));
                        markeroptions.anchor(0.5F, 0.5F);
                    }
                    if (markeroptions.getPosition() != null)
                    {
                        couriers.add(markeroptions);
                    }
                }
                break;

            case 3: // '\003'
                if (!mOriginMarkers.containsKey(markerinfo.getTitle()))
                {
                    MarkerOptions markeroptions1 = new MarkerOptions();
                    markeroptions1.position(markerinfo.getCoords());
                    markeroptions1.title(markerinfo.getTitle());
                    if (AppUtils.isDefined(markerinfo.getImageUrl()))
                    {
                        markeroptions1.snippet(markerinfo.getImageUrl());
                        markeroptions1.visible(false);
                    } else
                    {
                        markeroptions1.icon(BitmapDescriptorFactory.defaultMarker(270F));
                        markeroptions1.anchor(0.5F, 1.0F);
                    }
                    if (markeroptions1.getPosition() != null)
                    {
                        origins.add(markeroptions1);
                    }
                }
                break;
            }
        } while (true);
        getMapFragment().getMapAsync(new OnMapReadyCallback() {

            final MapWebActivity this$0;
            final List val$couriers;
            final MarkerOptions val$destination;
            final List val$origins;

            public void onMapReady(AmazonMap amazonmap)
            {
                if (mDestinationMarker == null && destination.getPosition() != null)
                {
                    mDestinationMarker = amazonmap.addMarker(destination);
                }
                if (!couriers.isEmpty())
                {
                    Iterator iterator1 = couriers.iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        MarkerOptions markeroptions3 = (MarkerOptions)iterator1.next();
                        String s3 = markeroptions3.getSnippet();
                        String s = null;
                        Marker marker1 = null;
                        String s2 = marker1;
                        if (!TextUtils.isEmpty(s3))
                        {
                            String as[] = s3.split("###");
                            s3 = as[0];
                            s = s3;
                            s2 = marker1;
                            if (as.length == 2)
                            {
                                s2 = as[1];
                                s = s3;
                            }
                        }
                        markeroptions3.snippet(null);
                        marker1 = amazonmap.addMarker(markeroptions3);
                        mCourierMarkers.put(s, marker1);
                        if (s2 != null)
                        {
                            ImageUtil.setImageFromUrl(new ImageReadyCallback(marker1), s2, -1, -1, true);
                        }
                    } while (true);
                }
                if (!origins.isEmpty())
                {
                    Iterator iterator = origins.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        MarkerOptions markeroptions2 = (MarkerOptions)iterator.next();
                        String s1 = null;
                        if (markeroptions2.getSnippet() != null)
                        {
                            s1 = markeroptions2.getSnippet();
                        }
                        markeroptions2.snippet(null);
                        Marker marker2 = amazonmap.addMarker(markeroptions2);
                        mOriginMarkers.put(markeroptions2.getTitle(), marker2);
                        if (s1 != null)
                        {
                            ImageUtil.setImageFromUrl(new ImageReadyCallback(marker2), s1, -1, -1, true);
                        }
                    } while (true);
                }
                if (!hasZoomed && couriers.isEmpty())
                {
                    pan();
                } else
                if (!hasZoomed && !couriers.isEmpty())
                {
                    pan();
                    hasZoomed = true;
                    return;
                }
            }

            
            {
                this$0 = MapWebActivity.this;
                destination = markeroptions;
                couriers = list;
                origins = list1;
                super();
            }
        });
    }



/*
    static Marker access$002(MapWebActivity mapwebactivity, Marker marker)
    {
        mapwebactivity.mLastOpened = marker;
        return marker;
    }

*/



/*
    static Marker access$102(MapWebActivity mapwebactivity, Marker marker)
    {
        mapwebactivity.mDestinationMarker = marker;
        return marker;
    }

*/





/*
    static boolean access$402(MapWebActivity mapwebactivity, boolean flag)
    {
        mapwebactivity.hasZoomed = flag;
        return flag;
    }

*/
}
