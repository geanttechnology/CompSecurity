// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.activity.CouponDetails;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.Location;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.service.AddressService;
import com.groupon.service.LocationService;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.util.RedemptionUtils;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            MapSlice

public class CouponMapSlice extends MapSlice
{

    private String couponId;
    LoggingUtils loggingUtils;

    public CouponMapSlice(Context context)
    {
        super(context);
    }

    public CouponMapSlice(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onAddressContainerClicked()
    {
        if (Strings.notEmpty(couponId))
        {
            CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
            coupongenericmetadata.pageId = com/groupon/activity/CouponDetails.getSimpleName();
            coupongenericmetadata.couponId = couponId;
            loggingUtils.logClickWithMetadata("", "directions_click", Channel.COUPONS.toString(), coupongenericmetadata);
        }
    }

    protected void onMapViewClicked()
    {
        if (Strings.notEmpty(couponId))
        {
            CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
            coupongenericmetadata.pageId = com/groupon/activity/CouponDetails.getSimpleName();
            coupongenericmetadata.couponId = couponId;
            loggingUtils.logClickWithMetadata("", "map_click", Channel.COUPONS.toString(), coupongenericmetadata);
        }
    }

    protected void onPhoneContainerClicked()
    {
        if (Strings.notEmpty(couponId))
        {
            CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
            coupongenericmetadata.pageId = com/groupon/activity/CouponDetails.getSimpleName();
            coupongenericmetadata.couponId = couponId;
            loggingUtils.logClickWithMetadata("", "phone_number_click", Channel.COUPONS.toString(), coupongenericmetadata);
        }
    }

    protected void onUrlContainerClicked()
    {
        if (Strings.notEmpty(couponId))
        {
            CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
            coupongenericmetadata.pageId = com/groupon/activity/CouponDetails.getSimpleName();
            coupongenericmetadata.couponId = couponId;
            loggingUtils.logClickWithMetadata("", "website_click", Channel.COUPONS.toString(), coupongenericmetadata);
        }
    }

    public void setCouponId(String s)
    {
        couponId = s;
    }

    public void setLocationAndVendorInfo(Location location, String s)
    {
        setLocation(location);
        setLocationAndVendorInfo(addressService.getAddressFromLocation(location), location.phoneNumber, s, false);
    }

    public void setMapLocationsContainer(final CouponMerchant couponMerchant)
    {
        final List merchantLocations = couponMerchant.getMerchantLocations();
        Object obj = locationService.getLocation();
        Object obj1 = redemptionUtils;
        View view;
        final int closest;
        int i;
        boolean flag;
        if (obj != null)
        {
            obj = new GeoPoint((int)(((android.location.Location) (obj)).getLatitude() * 1000000D), (int)(((android.location.Location) (obj)).getLongitude() * 1000000D));
        } else
        {
            obj = null;
        }
        closest = ((RedemptionUtils) (obj1)).findClosestLocationTo(((GeoPoint) (obj)), merchantLocations);
        if (merchantLocations.size() > 0)
        {
            obj = Double.valueOf(((Location)merchantLocations.get(closest)).lat);
        } else
        {
            obj = null;
        }
        if (merchantLocations.size() > 0)
        {
            obj1 = Double.valueOf(((Location)merchantLocations.get(closest)).lng);
        } else
        {
            obj1 = null;
        }
        view = locationsContainer;
        if (obj != null && obj1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setEnabled(flag);
        obj = new android.view.View.OnClickListener() {

            final CouponMapSlice this$0;
            final int val$closest;
            final CouponMerchant val$couponMerchant;
            final List val$merchantLocations;

            public void onClick(View view1)
            {
                onMapViewClicked();
                getContext().startActivity(intentFactory.newShowOnMapIntent(merchantLocations, couponMerchant.name, closest));
            }

            
            {
                this$0 = CouponMapSlice.this;
                merchantLocations = list;
                couponMerchant = couponmerchant;
                closest = i;
                super();
            }
        };
        locationsContainer.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        imageContainer.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        i = merchantLocations.size();
        if (couponMerchant.homepageUrl == null)
        {
            couponMerchant = "";
        } else
        {
            couponMerchant = couponMerchant.homepageUrl;
        }
        if (i > 0)
        {
            mapLocations.setText(getContext().getString(0x7f08027c, new Object[] {
                Integer.valueOf(merchantLocations.size())
            }));
            useLargeSlice = true;
            setLocationAndVendorInfo((Location)merchantLocations.get(closest), couponMerchant);
            setExpanded(true);
        } else
        if (Strings.notEmpty(couponMerchant))
        {
            setAnimated(false);
            setLocationAndVendorInfo(null, null, couponMerchant, false);
        }
        obj = locationsContainer;
        if (i > 1)
        {
            closest = 0;
        } else
        {
            closest = 8;
        }
        ((View) (obj)).setVisibility(closest);
        if (i > 0 || Strings.notEmpty(couponMerchant))
        {
            closest = 0;
        } else
        {
            closest = 8;
        }
        setVisibility(closest);
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        toggleMapViewVisibility(flag);
    }
}
