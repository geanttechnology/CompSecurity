// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;

public class ShippingCosts extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShippingCosts createFromParcel(Parcel parcel)
        {
            return (ShippingCosts)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/ShippingCosts);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShippingCosts[] newArray(int i)
        {
            return new ShippingCosts[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public ItemCurrency detailsCodCost;
    public ArrayList detailsExcludeShipToLocations;
    public boolean detailsGetItFast;
    public ItemCurrency detailsInsuranceCost;
    public String detailsInsuranceOption;
    public ArrayList detailsInternationShippingOptions;
    public ItemCurrency detailsInternationalInsuranceCost;
    public String detailsInternationalInsuranceOption;
    public ArrayList detailsShippingOptions;
    public String logisticsPlanType;
    public ItemCurrency salesTaxAmount;
    public float salesTaxPercent;
    public boolean salesTaxShippingIncludedInTax;
    public String salesTaxState;
    public String shippingRateErrorMessage;
    public ItemCurrency summaryListedShippingServiceCost;
    public ItemCurrency summaryShippingServiceCost;
    public String summaryShippingServiceName;
    public String summaryShippingType;
    public ArrayList taxTable;
    public String version;

    public ShippingCosts()
    {
        detailsExcludeShipToLocations = new ArrayList();
        detailsInternationShippingOptions = new ArrayList();
        detailsShippingOptions = new ArrayList();
        taxTable = new ArrayList();
    }

    public int getNumShippingOptions()
    {
        return detailsInternationShippingOptions.size() + detailsShippingOptions.size();
    }

    public ArrayList getShippingOptions()
    {
        if (detailsShippingOptions.size() > 0)
        {
            return detailsShippingOptions;
        } else
        {
            return detailsInternationShippingOptions;
        }
    }

}
