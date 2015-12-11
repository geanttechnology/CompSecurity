// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Business;
import com.groupon.db.models.Location;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.AddressService;
import com.groupon.service.LocationService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.GeoPoint;
import com.groupon.util.RedemptionUtils;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.view:
//            MapSlice

public class BusinessMapDetailedSlice extends MapSlice
{

    private Business business;
    private Logger logger;

    public BusinessMapDetailedSlice(Context context)
    {
        super(context);
    }

    public BusinessMapDetailedSlice(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onAddressContainerClicked()
    {
        if (business != null)
        {
            logger.logClick("", "mp_address_click", business.remoteId, "");
        }
    }

    protected void onMapViewClicked()
    {
        if (business != null)
        {
            logger.logClick("", "mp_map_click", business.remoteId, "");
        }
    }

    protected void onPhoneContainerClicked()
    {
        if (business != null)
        {
            logger.logClick("", "mp_phone_click", business.remoteId, "");
        }
    }

    protected void onUrlContainerClicked()
    {
        if (business != null)
        {
            logger.logClick("", "mp_website_click", business.remoteId, "");
        }
    }

    public void setLocationAndVendorInfo(Location location, String s)
    {
        Location location1 = new Location();
        double d = location.lat;
        double d1 = location.lng;
        location1.lat = Double.valueOf(d).doubleValue();
        location1.lng = Double.valueOf(d1).doubleValue();
        this.location = location1;
        setLocationAndVendorInfo(addressService.getAddressFromLocation(location), location.phoneNumber, s, false);
    }

    public void setMapLocationsContainerForBusiness(final Business business, final List redemptionLocations)
    {
        this.business = business;
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
        closest = ((RedemptionUtils) (obj1)).findClosestLocationTo(((GeoPoint) (obj)), redemptionLocations);
        if (redemptionLocations.size() > 0)
        {
            obj = Double.valueOf(((Location)redemptionLocations.get(closest)).lat);
        } else
        {
            obj = null;
        }
        if (redemptionLocations.size() > 0)
        {
            obj1 = Double.valueOf(((Location)redemptionLocations.get(closest)).lng);
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

            final BusinessMapDetailedSlice this$0;
            final Business val$business;
            final int val$closest;
            final List val$redemptionLocations;

            public void onClick(View view1)
            {
                onMapViewClicked();
                Context context = getContext();
                IntentFactory intentfactory = intentFactory;
                List list = redemptionLocations;
                if (business.name == null)
                {
                    view1 = "";
                } else
                {
                    view1 = business.name;
                }
                context.startActivity(intentfactory.newShowOnMapIntent(list, view1, closest));
            }

            
            {
                this$0 = BusinessMapDetailedSlice.this;
                redemptionLocations = list;
                business = business1;
                closest = i;
                super();
            }
        };
        locationsContainer.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        imageContainer.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        i = redemptionLocations.size();
        if (i > 0)
        {
            mapLocations.setText(getContext().getString(0x7f08027c, new Object[] {
                Integer.valueOf(redemptionLocations.size())
            }));
            useLargeSlice = true;
            ((Location)redemptionLocations.get(closest)).phoneNumber = business.phoneNumber;
            setLocationAndVendorInfo((Location)redemptionLocations.get(closest), business.website);
            setExpanded(true);
            if (!Strings.isEmpty(business.website))
            {
                logger.logImpression("", "mp_website", business.remoteId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            }
            if (!Strings.isEmpty(((Location)redemptionLocations.get(closest)).phoneNumber))
            {
                logger.logImpression("", "mp_phone", business.remoteId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            }
            logger.logImpression("", "mp_address", business.remoteId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        }
        logger.logImpression("", "mp_map", business.remoteId, "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        business = locationsContainer;
        if (i > 1)
        {
            closest = 0;
        } else
        {
            closest = 8;
        }
        business.setVisibility(closest);
        if (i > 0)
        {
            closest = 0;
        } else
        {
            closest = 8;
        }
        setVisibility(closest);
        toggleMapViewVisibility(true);
    }
}
