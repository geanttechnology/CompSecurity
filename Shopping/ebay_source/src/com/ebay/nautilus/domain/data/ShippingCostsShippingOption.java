// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;
import java.util.Date;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ItemCurrency, ShippingPackageInfo

public class ShippingCostsShippingOption extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShippingCostsShippingOption createFromParcel(Parcel parcel)
        {
            return (ShippingCostsShippingOption)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/ShippingCostsShippingOption);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingCostsShippingOption[] newArray(int i)
        {
            return new ShippingCostsShippingOption[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Date estimatedDeliveryMaxTime;
    public Date estimatedDeliveryMinTime;
    public boolean expeditedService;
    public boolean fastAndFree;
    public ItemCurrency importCharge;
    public boolean isEligibleForEbayPlusPromo;
    public boolean isHandlingTimeSameDayAvailable;
    public com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum logisticsPlanType;
    public transient String logisticsPlanTypeString;
    public Date sameDayCutOff;
    public ItemCurrency shippingInsuranceCost;
    public ShippingPackageInfo shippingPackageInfo;
    public ItemCurrency shippingServiceAdditionalCost;
    public ItemCurrency shippingServiceCost;
    public String shippingServiceName;
    public String shippingServiceNameValue;
    public int shippingServicePriority;
    public ItemCurrency shippingSurcharge;
    public int shippingTimeMax;
    public int shippingTimeMin;
    public ArrayList shipsToLocations;

    public ShippingCostsShippingOption()
    {
        fastAndFree = false;
        shipsToLocations = new ArrayList();
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof ShippingCostsShippingOption))
        {
            return false;
        }
        obj = (ShippingCostsShippingOption)obj;
        if (expeditedService != ((ShippingCostsShippingOption) (obj)).expeditedService || fastAndFree != ((ShippingCostsShippingOption) (obj)).fastAndFree || shippingServicePriority != ((ShippingCostsShippingOption) (obj)).shippingServicePriority || shippingTimeMax != ((ShippingCostsShippingOption) (obj)).shippingTimeMax || shippingTimeMin != ((ShippingCostsShippingOption) (obj)).shippingTimeMin)
        {
            return false;
        }
        if ((estimatedDeliveryMaxTime != null || ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMaxTime != null) && (estimatedDeliveryMaxTime == null && ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMaxTime != null || estimatedDeliveryMaxTime != null && ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMaxTime == null || estimatedDeliveryMaxTime.getTime() != ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMaxTime.getTime()))
        {
            return false;
        }
        if ((estimatedDeliveryMinTime != null || ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMinTime != null) && (estimatedDeliveryMinTime == null && ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMinTime != null || estimatedDeliveryMinTime != null && ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMinTime == null || estimatedDeliveryMinTime.getTime() != ((ShippingCostsShippingOption) (obj)).estimatedDeliveryMinTime.getTime()))
        {
            return false;
        }
        if ((shippingInsuranceCost != null || ((ShippingCostsShippingOption) (obj)).shippingInsuranceCost != null) && (shippingInsuranceCost == null && ((ShippingCostsShippingOption) (obj)).shippingInsuranceCost != null || shippingInsuranceCost != null && ((ShippingCostsShippingOption) (obj)).shippingInsuranceCost == null || !shippingInsuranceCost.equals(((ShippingCostsShippingOption) (obj)).shippingInsuranceCost)))
        {
            return false;
        }
        if ((shippingServiceAdditionalCost != null || ((ShippingCostsShippingOption) (obj)).shippingServiceAdditionalCost != null) && (shippingServiceAdditionalCost == null && ((ShippingCostsShippingOption) (obj)).shippingServiceAdditionalCost != null || shippingServiceAdditionalCost != null && ((ShippingCostsShippingOption) (obj)).shippingServiceAdditionalCost == null || !shippingServiceAdditionalCost.equals(((ShippingCostsShippingOption) (obj)).shippingServiceAdditionalCost)))
        {
            return false;
        }
        if ((shippingServiceCost != null || ((ShippingCostsShippingOption) (obj)).shippingServiceCost != null) && (shippingServiceCost == null && ((ShippingCostsShippingOption) (obj)).shippingServiceCost != null || shippingServiceCost != null && ((ShippingCostsShippingOption) (obj)).shippingServiceCost == null || !shippingServiceCost.equals(((ShippingCostsShippingOption) (obj)).shippingServiceCost)))
        {
            return false;
        }
        if ((importCharge != null || ((ShippingCostsShippingOption) (obj)).importCharge != null) && (importCharge == null && ((ShippingCostsShippingOption) (obj)).importCharge != null || importCharge != null && ((ShippingCostsShippingOption) (obj)).importCharge == null || !importCharge.equals(((ShippingCostsShippingOption) (obj)).importCharge)))
        {
            return false;
        }
        if ((shippingServiceName != null || ((ShippingCostsShippingOption) (obj)).shippingServiceName != null) && (shippingServiceName == null && ((ShippingCostsShippingOption) (obj)).shippingServiceName != null || shippingServiceName != null && ((ShippingCostsShippingOption) (obj)).shippingServiceName == null || !shippingServiceName.equals(((ShippingCostsShippingOption) (obj)).shippingServiceName)))
        {
            return false;
        }
        if ((logisticsPlanType != null || ((ShippingCostsShippingOption) (obj)).logisticsPlanType != null) && (logisticsPlanType == null && ((ShippingCostsShippingOption) (obj)).logisticsPlanType != null || logisticsPlanType != null && ((ShippingCostsShippingOption) (obj)).logisticsPlanType == null || logisticsPlanType != ((ShippingCostsShippingOption) (obj)).logisticsPlanType))
        {
            return false;
        }
        if ((shippingSurcharge != null || ((ShippingCostsShippingOption) (obj)).shippingSurcharge != null) && (shippingSurcharge == null && ((ShippingCostsShippingOption) (obj)).shippingSurcharge != null || shippingSurcharge != null && ((ShippingCostsShippingOption) (obj)).shippingSurcharge == null || !shippingSurcharge.equals(((ShippingCostsShippingOption) (obj)).shippingSurcharge)))
        {
            return false;
        }
        if ((shipsToLocations != null || ((ShippingCostsShippingOption) (obj)).shipsToLocations != null) && (shipsToLocations == null && ((ShippingCostsShippingOption) (obj)).shipsToLocations != null || shipsToLocations != null && ((ShippingCostsShippingOption) (obj)).shipsToLocations == null || shipsToLocations.size() != ((ShippingCostsShippingOption) (obj)).shipsToLocations.size()))
        {
            return false;
        }
        for (int i = 0; i < shipsToLocations.size(); i++)
        {
            if (!((String)shipsToLocations.get(i)).equals(((ShippingCostsShippingOption) (obj)).shipsToLocations.get(i)))
            {
                return false;
            }
        }

        return shippingPackageInfo == null && ((ShippingCostsShippingOption) (obj)).shippingPackageInfo == null || (shippingPackageInfo != null || ((ShippingCostsShippingOption) (obj)).shippingPackageInfo == null) && (shippingPackageInfo == null || ((ShippingCostsShippingOption) (obj)).shippingPackageInfo != null);
    }

}
