// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.analytics.AnalyticsUtilHelper;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            LookupAvailabilityResponse

public final class LookupAvailabilityRequest extends EbayRequest
{
    public static final class PhysicalLocation
    {

        private static com.ebay.nautilus.kernel.util.FwLog.LogInfo postalCodeGeoLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PostalCodeGeo", 3, "Log postal code geocoding events.");
        private Geocoder geocoder;
        Double latitude;
        Double longitude;
        String postalCode;

        private boolean translatePostalCodeToLatLong(Context context, String s, String s1)
        {
            boolean flag2;
            boolean flag3;
            flag3 = false;
            flag2 = false;
            if (!Geocoder.isPresent()) goto _L2; else goto _L1
_L1:
            if (geocoder == null)
            {
                Locale locale = Locale.getDefault();
                EbaySite ebaysite = EbaySite.getInstanceFromId(s1);
                s1 = locale;
                if (ebaysite != null)
                {
                    s1 = ebaysite.getLocale();
                }
                geocoder = new Geocoder(context, s1);
            }
            boolean flag1 = flag3;
            boolean flag;
            try
            {
                s1 = new Bundle();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return flag1;
            }
            flag1 = flag3;
            s1.putString("eventName", "GeoCodeEvent");
            flag1 = flag3;
            s1.putString("gccount", "1");
            flag1 = flag3;
            AnalyticsUtilHelper.sendTrackingEvent(s1, context);
            flag1 = flag3;
            context = geocoder.getFromLocationName(s, 1);
            flag = flag2;
            if (context == null)
            {
                break MISSING_BLOCK_LABEL_289;
            }
            flag = flag2;
            flag1 = flag3;
            if (context.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_289;
            }
            flag1 = flag3;
            context = (Address)context.get(0);
            flag = flag2;
            flag1 = flag3;
            if (!context.hasLatitude())
            {
                break MISSING_BLOCK_LABEL_289;
            }
            flag = flag2;
            flag1 = flag3;
            if (!context.hasLongitude())
            {
                break MISSING_BLOCK_LABEL_289;
            }
            flag1 = flag3;
            postalCode = null;
            flag1 = flag3;
            latitude = Double.valueOf(context.getLatitude());
            flag1 = flag3;
            longitude = Double.valueOf(context.getLongitude());
            flag3 = true;
            flag2 = true;
            flag = flag2;
            flag1 = flag3;
            if (!postalCodeGeoLogger.isLoggable)
            {
                break MISSING_BLOCK_LABEL_289;
            }
            flag1 = flag3;
            postalCodeGeoLogger.log(String.format("Replacing postal code %s with geocoded lat/long %f, %f.", new Object[] {
                s, latitude, longitude
            }));
            flag = flag2;
_L4:
            return flag;
_L2:
            flag = flag2;
            if (postalCodeGeoLogger.isLoggable)
            {
                postalCodeGeoLogger.logAsWarning("Geocoder not present.");
                return false;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public Double getLatitude()
        {
            return latitude;
        }

        public Double getLongitude()
        {
            return longitude;
        }

        public String getPostalCode()
        {
            return postalCode;
        }

        boolean isPostalCode()
        {
            return postalCode != null;
        }


        public PhysicalLocation(double d, double d1)
        {
            geocoder = null;
            latitude = Double.valueOf(d);
            longitude = Double.valueOf(d1);
            postalCode = null;
        }

        public PhysicalLocation(Context context, String s, String s1)
        {
            geocoder = null;
            if (TextUtils.isEmpty(s))
            {
                throw new IllegalStateException("invalid postal code");
            }
            if (!translatePostalCodeToLatLong(context, s, s1))
            {
                if (postalCodeGeoLogger.isLoggable)
                {
                    postalCodeGeoLogger.logAsWarning(String.format("Unable to geocode postal code. Falling back to using postal code: %s directly.", new Object[] {
                        s
                    }));
                }
                postalCode = s;
                longitude = null;
                latitude = null;
            }
        }
    }

    public static final class Unit extends Enum
    {

        private static final Unit $VALUES[];
        public static final Unit KM;
        public static final Unit MILE;
        private String displayString;

        public static Unit valueOf(String s)
        {
            return (Unit)Enum.valueOf(com/ebay/common/net/api/inventory/LookupAvailabilityRequest$Unit, s);
        }

        public static Unit[] values()
        {
            return (Unit[])$VALUES.clone();
        }

        public String toString()
        {
            return displayString;
        }

        static 
        {
            KM = new Unit("KM", 0, "km");
            MILE = new Unit("MILE", 1, "mi");
            $VALUES = (new Unit[] {
                KM, MILE
            });
        }

        private Unit(String s, int i, String s1)
        {
            super(s, i);
            displayString = s1;
        }
    }


    final String countryCode;
    final Date estimatedDeliveryDate;
    final PhysicalLocation location;
    final com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type logisticsPlanType;
    final Integer radius;
    final String sellerId;
    final String sku;
    final Unit unit;

    public LookupAvailabilityRequest(String s, String s1, PhysicalLocation physicallocation, Integer integer, Unit unit1, String s2, com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type, 
            Date date)
    {
        sellerId = s;
        sku = s1;
        location = physicallocation;
        radius = integer;
        unit = unit1;
        countryCode = s2;
        if (type == null)
        {
            type = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.UNKNOWN;
        }
        logisticsPlanType = type;
        estimatedDeliveryDate = date;
    }

    public URL getRequestUrl()
    {
        Object obj = Uri.parse(ApiSettings.getUrl(EbaySettings.localLookupUrl).toString()).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendPath("availability");
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("SellerID", sellerId);
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("SKU", sku);
        if (location.isPostalCode())
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("PostalCode", location.postalCode);
        } else
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("Latitude", String.valueOf(location.latitude));
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("Longitude", String.valueOf(location.longitude));
        }
        if (radius != null)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("Radius", String.valueOf(radius));
        }
        if (!TextUtils.isEmpty(countryCode))
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("CountryCode", countryCode);
        }
        if (unit != null)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("Unit", unit.name());
        }
        if (logisticsPlanType == com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("Logistics", logisticsPlanType.toString());
        }
        if (estimatedDeliveryDate != null)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("EDD", EbayDateFormat.format(estimatedDeliveryDate));
        }
        try
        {
            obj = new URL(((android.net.Uri.Builder) (obj)).toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return null;
        }
        return ((URL) (obj));
    }

    public LookupAvailabilityResponse getResponse()
    {
        return new LookupAvailabilityResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("Accept", "application/xml");
    }
}
