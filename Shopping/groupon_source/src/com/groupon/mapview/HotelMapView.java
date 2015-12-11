// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mapview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.groupon.db.models.MarketRateResult;
import com.groupon.models.GenericAmount;
import com.groupon.util.CurrencyFormatter;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mapview:
//            BaseMapView

public class HotelMapView extends BaseMapView
{
    private static class MapWindowAdapter
        implements com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    {

        private final Context context;

        public View getInfoContents(Marker marker)
        {
            return null;
        }

        public View getInfoWindow(Marker marker)
        {
            marker = new TextView(context);
            marker.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            marker.setText(" ");
            return marker;
        }

        public MapWindowAdapter(Context context1)
        {
            context = context1;
        }
    }

    public static interface OnHotelClickListener
    {

        public abstract void onHotelClicked(int i);
    }


    private static final int HOTEL_MAPVIEW_ANIMATION_TIME = 500;
    private CurrencyFormatter currencyFormatter;
    private List hotels;
    private LayoutInflater inflator;
    private OnHotelClickListener onHotelClickListener;

    public HotelMapView(Context context)
    {
        super(context);
    }

    public HotelMapView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public HotelMapView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    private String getPrice(MarketRateResult marketrateresult)
    {
        GenericAmount genericamount = new GenericAmount();
        genericamount.setAmount(marketrateresult.derivedAvgMinPriceNet);
        genericamount.setCurrencyCode(marketrateresult.derivedAvgMinPriceCurrencyCode);
        return currencyFormatter.format(genericamount, true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always);
    }

    private void updateMarkers()
    {
        clearMap();
        if (googleMap != null && hotels != null)
        {
            if (boundsBuilder == null)
            {
                boundsBuilder = LatLngBounds.builder();
            }
            Iterator iterator = hotels.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (MarketRateResult)iterator.next();
                double d = ((MarketRateResult) (obj)).derivedAddressLat;
                double d1 = ((MarketRateResult) (obj)).derivedAddressLng;
                obj = getPrice(((MarketRateResult) (obj)));
                if (d != 0.0D && d1 != 0.0D)
                {
                    obj = googleMap.addMarker((new MarkerOptions()).position(new LatLng(d, d1)).title(((String) (obj))));
                    onMarkerUnselected(((Marker) (obj)));
                    boundsBuilder.include(((Marker) (obj)).getPosition());
                    markerList.add(obj);
                }
            } while (true);
            if (needMoveCameraToFitMarkers)
            {
                needMoveCameraToFitMarkers = false;
                moveCameraToFitMarkersCenter(false, lastCallback);
                return;
            }
        }
    }

    public int getAnimationDurationTime()
    {
        return 500;
    }

    protected void initMap(GoogleMap googlemap)
    {
        super.initMap(googlemap);
        updateMarkers();
        googleMap.setInfoWindowAdapter(new MapWindowAdapter(getContext()));
        setOnMarkerClickListener(new BaseMapView.OnMarkerClickListener() {

            final HotelMapView this$0;

            public boolean onMarkerClicked(Marker marker)
            {
                marker.showInfoWindow();
                if (onHotelClickListener != null)
                {
                    int i = markerList.indexOf(marker);
                    onHotelClickListener.onHotelClicked(i);
                    setSelectedMarker(i, true, false);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = HotelMapView.this;
                super();
            }
        });
    }

    protected void onMarkerSelected(Marker marker)
    {
        String s = marker.getTitle();
        View view;
        if (Strings.isEmpty(s))
        {
            view = inflator.inflate(0x7f030135, null);
            view.setBackgroundResource(0x7f02005b);
        } else
        {
            view = inflator.inflate(0x7f030136, null);
            view.setBackgroundResource(0x7f02005d);
            ((TextView)view.findViewById(0x7f10007a)).setText(s);
        }
        setMarkerIconByView(marker, view);
        marker.showInfoWindow();
    }

    protected void onMarkerUnselected(Marker marker)
    {
        String s = marker.getTitle();
        View view;
        if (Strings.isEmpty(s))
        {
            view = inflator.inflate(0x7f030135, null);
        } else
        {
            view = inflator.inflate(0x7f030136, null);
            ((TextView)view.findViewById(0x7f10007a)).setText(s);
        }
        setMarkerIconByView(marker, view);
    }

    public void release()
    {
        onHotelClickListener = null;
        super.release();
    }

    public void setHeight(int i)
    {
        getLayoutParams().height = i;
        requestLayout();
    }

    public void setHotels(List list)
    {
        hotels = list;
        updateMarkers();
    }

    public void setOnHotelClickListener(OnHotelClickListener onhotelclicklistener)
    {
        onHotelClickListener = onhotelclicklistener;
    }

}
