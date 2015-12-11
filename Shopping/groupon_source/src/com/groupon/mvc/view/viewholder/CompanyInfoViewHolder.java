// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.callbacks.OnCompanyInfoEventListener;
import com.groupon.callbacks.OnMapSliceClickListener;
import com.groupon.mvc.model.CompanyInfo;
import com.groupon.view.DealDetailsRating;
import com.groupon.view.MapSliceImprovedView;

// Referenced classes of package com.groupon.mvc.view.viewholder:
//            RecyclerItemViewHolder

public class CompanyInfoViewHolder extends RecyclerItemViewHolder
{
    private class MapSliceClickListener
        implements OnMapSliceClickListener
    {

        private String address;
        private double lat;
        private double lng;
        private String phone;
        final CompanyInfoViewHolder this$0;
        private String vendorName;

        public void onViewClicked(View view, com.groupon.view.MapSliceImprovedView.MapSliceViewType mapsliceviewtype)
        {
            if (callback == null) goto _L2; else goto _L1
_L1:
            static class _cls1
            {

                static final int $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType[];

                static 
                {
                    $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType = new int[com.groupon.view.MapSliceImprovedView.MapSliceViewType.values().length];
                    try
                    {
                        $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType[com.groupon.view.MapSliceImprovedView.MapSliceViewType.MAP.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType[com.groupon.view.MapSliceImprovedView.MapSliceViewType.ADDRESS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType[com.groupon.view.MapSliceImprovedView.MapSliceViewType.MULTIPLE_LOCATIONS.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType[com.groupon.view.MapSliceImprovedView.MapSliceViewType.PHONE.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$MapSliceImprovedView$MapSliceViewType[com.groupon.view.MapSliceImprovedView.MapSliceViewType.WEBSITE.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.groupon.view.MapSliceImprovedView.MapSliceViewType[mapsliceviewtype.ordinal()];
            JVM INSTR tableswitch 1 5: default 52
        //                       1 53
        //                       2 82
        //                       3 103
        //                       4 120
        //                       5 141;
               goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
            return;
_L3:
            ((OnCompanyInfoEventListener)callback).onMapViewClick(view, lat, lng, vendorName);
            return;
_L4:
            ((OnCompanyInfoEventListener)callback).onAddressClick(view, address);
            return;
_L5:
            ((OnCompanyInfoEventListener)callback).onMultipleLocationsClick(view);
            return;
_L6:
            ((OnCompanyInfoEventListener)callback).onPhoneClick(view, phone);
            return;
_L7:
            ((OnCompanyInfoEventListener)callback).onWebsiteClick(view);
            return;
        }

        public MapSliceClickListener(double d, double d1, String s, String s1, 
                String s2)
        {
            this$0 = CompanyInfoViewHolder.this;
            super();
            lat = d;
            lng = d1;
            vendorName = s;
            address = s1;
            phone = s2;
        }
    }


    MapSliceImprovedView mapSlice;
    LinearLayout ratingsContainer;
    TextView vendorNameView;

    public CompanyInfoViewHolder(View view)
    {
        super(view);
    }

    public void populateViews()
    {
        vendorNameView.setText(((CompanyInfo)model).vendorName);
        Object obj = vendorNameView;
        com.groupon.db.models.Rating arating[];
        int i;
        if (((CompanyInfo)model).shouldShowVendorName)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj)).setVisibility(i);
        ratingsContainer.removeAllViews();
        arating = ((CompanyInfo)model).vendorRatings;
        if (arating != null && arating.length > 0)
        {
            int j = arating.length;
            for (i = 0; i < j; i++)
            {
                com.groupon.db.models.Rating rating = arating[i];
                DealDetailsRating dealdetailsrating = new DealDetailsRating(itemView.getContext());
                dealdetailsrating.setRating(rating);
                if (ratingsContainer.getChildCount() == arating.length - 1)
                {
                    dealdetailsrating.hideRatingSeparator();
                }
                ratingsContainer.addView(dealdetailsrating);
            }

        }
        arating = ratingsContainer;
        double d;
        double d1;
        String s;
        String s1;
        if (ratingsContainer.getChildCount() > 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        arating.setVisibility(i);
        d = ((CompanyInfo)model).lat;
        d1 = ((CompanyInfo)model).lng;
        arating = ((CompanyInfo)model).vendorName;
        s = ((CompanyInfo)model).address;
        s1 = ((CompanyInfo)model).phone;
        mapSlice.setLocationCoordinates(((CompanyInfo)model).lat, ((CompanyInfo)model).lng);
        mapSlice.setLocationAddress(((CompanyInfo)model).address);
        mapSlice.setLocationsCount(((CompanyInfo)model).locationsCount);
        mapSlice.setVendorInfo(((CompanyInfo)model).phone, ((CompanyInfo)model).website);
        mapSlice.setShouldShowMapView(((CompanyInfo)model).shouldShowMapView);
        mapSlice.setUseLargeSlice(((CompanyInfo)model).shouldUseLargeSliceMap);
        mapSlice.setDeviceScreenDensity(((CompanyInfo)model).deviceScreenDensity);
        mapSlice.setOnMapSliceClickListener(new MapSliceClickListener(d, d1, arating, s, s1));
        mapSlice.show();
    }
}
