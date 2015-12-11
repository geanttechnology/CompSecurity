// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.groupon.db.dao.DaoLocation;
import com.groupon.db.models.Location;
import com.groupon.service.AddressService;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class ShowOnMap extends GrouponActivity
{

    private AddressService addressService;
    private com.google.android.gms.maps.model.LatLngBounds.Builder boundsBuilder;
    private GoogleMap googleMap;
    int index;
    double lat;
    double lng;
    private DaoLocation locationDao;
    long locationIds[];
    MapView mapView;
    private List markers;
    String vendorName;

    public ShowOnMap()
    {
        lat = 0.0D;
        lng = 0.0D;
    }

    protected static Drawable boundLeftBottom(Drawable drawable, int i, int j)
    {
        drawable.setBounds(i, -drawable.getIntrinsicHeight() + j, drawable.getIntrinsicWidth() + i, j);
        return drawable;
    }

    private void setUpMapIfNeeded()
    {
        if (googleMap != null) goto _L2; else goto _L1
_L1:
        googleMap = mapView.getMap();
        if (googleMap == null) goto _L2; else goto _L3
_L3:
        android.graphics.Bitmap bitmap;
        googleMap.setInfoWindowAdapter(new com.google.android.gms.maps.GoogleMap.InfoWindowAdapter() {

            final ShowOnMap this$0;

            public View getInfoContents(Marker marker)
            {
                View view = getLayoutInflater().inflate(0x7f0301ff, null);
                TextView textview = (TextView)view.findViewById(0x7f100522);
                TextView textview1 = (TextView)view.findViewById(0x7f100523);
                textview.setText(marker.getTitle());
                textview1.setText(marker.getSnippet());
                return view;
            }

            public View getInfoWindow(Marker marker)
            {
                return null;
            }

            
            {
                this$0 = ShowOnMap.this;
                super();
            }
        });
        googleMap.setOnInfoWindowClickListener(new com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener() {

            final ShowOnMap this$0;

            public void onInfoWindowClick(Marker marker)
            {
                marker = String.format("geo:%s,%s?q=%s", new Object[] {
                    Double.valueOf(marker.getPosition().latitude), Double.valueOf(marker.getPosition().longitude), URLEncoder.encode(marker.getSnippet())
                });
                Ln.d((new StringBuilder()).append("Loading map for address with URI: ").append(marker).toString(), new Object[0]);
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(marker)));
            }

            
            {
                this$0 = ShowOnMap.this;
                super();
            }
        });
        boundsBuilder = LatLngBounds.builder();
        markers = new ArrayList();
        int i = (int)getApplicationContext().getResources().getDimension(0x7f0b0007);
        int k = (int)getApplicationContext().getResources().getDimension(0x7f0b0008);
        bitmap = ((BitmapDrawable)boundLeftBottom(getApplicationContext().getResources().getDrawable(0x7f02017f), i, k)).getBitmap();
        if (locationIds == null) goto _L5; else goto _L4
_L4:
        Object obj;
        obj = new ArrayList();
        long al[] = locationIds;
        int l = al.length;
        for (int j = 0; j < l; j++)
        {
            ((ArrayList) (obj)).add(Long.valueOf(al[j]));
        }

        Iterator iterator = locationDao.queryBuilder().where().in("_id", ((Iterable) (obj))).query().iterator();
_L7:
        double d;
        double d1;
        String s;
        String s1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_385;
            }
            obj = (Location)iterator.next();
            d = ((Location) (obj)).lat;
            d1 = ((Location) (obj)).lng;
            s1 = addressService.getAddressFromLocation(((Location) (obj)));
            s = ((Location) (obj)).name;
        } while (d == 0.0D || d1 == 0.0D);
        MarkerOptions markeroptions = (new MarkerOptions()).position(new LatLng(d, d1));
        obj = s;
        if (Strings.isEmpty(s))
        {
            obj = vendorName;
        }
        obj = markeroptions.title(((String) (obj))).snippet(s1).icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        markers.add(googleMap.addMarker(((MarkerOptions) (obj))));
        boundsBuilder.include(((MarkerOptions) (obj)).getPosition());
        if (true) goto _L7; else goto _L6
_L6:
        SQLException sqlexception;
        sqlexception;
        Ln.w(sqlexception);
_L9:
        googleMap.setOnCameraChangeListener(new com.google.android.gms.maps.GoogleMap.OnCameraChangeListener() {

            final ShowOnMap this$0;

            public void onCameraChange(CameraPosition cameraposition)
            {
                if (markers.size() > 0)
                {
                    if (index >= 0)
                    {
                        cameraposition = (Marker)markers.get(index);
                        cameraposition.showInfoWindow();
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraposition.getPosition(), 14F));
                    } else
                    {
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 50));
                    }
                }
                googleMap.setOnCameraChangeListener(null);
            }

            
            {
                this$0 = ShowOnMap.this;
                super();
            }
        });
_L2:
        return;
_L5:
        Object obj1 = new Location();
        obj1.lat = lat;
        obj1.lng = lng;
        obj1 = addressService.getAddressFromLocation(((Location) (obj1)));
        if (lat != 0.0D && lng != 0.0D)
        {
            obj1 = (new MarkerOptions()).position(new LatLng(lat, lng)).title(vendorName).snippet(((String) (obj1))).icon(BitmapDescriptorFactory.fromBitmap(bitmap));
            markers.add(googleMap.addMarker(((MarkerOptions) (obj1))));
            boundsBuilder.include(((MarkerOptions) (obj1)).getPosition());
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301fe);
        MapsInitializer.initialize(this);
        mapView.onCreate(bundle);
        setUpMapIfNeeded();
    }

    public void onDestroy()
    {
        markers.clear();
        mapView.onDestroy();
        super.onDestroy();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    protected void onPause()
    {
        super.onPause();
        mapView.onPause();
    }

    protected void onResume()
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) != 0)
        {
            Toast.makeText(this, 0x7f080199, 0).show();
            finish();
        }
        super.onResume();
        mapView.onResume();
        setUpMapIfNeeded();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mapView.onSaveInstanceState(bundle);
    }



}
