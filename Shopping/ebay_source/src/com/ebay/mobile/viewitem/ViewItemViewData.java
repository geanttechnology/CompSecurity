// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.EbayIdentity;
import java.util.ArrayList;

public class ViewItemViewData extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ViewItemViewData createFromParcel(Parcel parcel)
        {
            return (ViewItemViewData)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/viewitem/ViewItemViewData);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ViewItemViewData[] newArray(int i)
        {
            return new ViewItemViewData[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String PARAM_VIEW_DATA = "view_item_view_data";
    public Treatment adsExperimentState;
    public boolean buyAnother;
    public int defaultForegroundColorId;
    public boolean feedbackLeft;
    public boolean finalized;
    public boolean isLoadSprAfterInventoryCall;
    public boolean isLoadStoreAvailabilities;
    public boolean isTransactionLookupIndicated;
    public ViewItemDataManager.KeyParams keyParams;
    public com.ebay.common.ConstantsCommon.ItemKind kind;
    public MyEbayListItem myEbayListItem;
    public ArrayList nameValueList;
    public ItemCurrency originalRetailPrice;
    public String pricingTreatment;
    public Address primaryAddress;
    public int savingsRate;
    public boolean searchOtherCountries;
    public String searchRefinedPostalCode;
    public int searchRefinedShopLocallyFlag;
    public PostalCodeSpecification shippingCostsPostalCode;
    public final String trackingCorrelationId;
    public boolean useEventTimeHack;
    public boolean useRealtimeShipmentTracking;
    public boolean waitForBidding;

    public ViewItemViewData()
    {
        nameValueList = new ArrayList();
        kind = com.ebay.common.ConstantsCommon.ItemKind.Unknown;
        searchOtherCountries = false;
        isTransactionLookupIndicated = true;
        trackingCorrelationId = EbayIdentity.generateRequestCorrelationId();
        useEventTimeHack = false;
        useEventTimeHack = DeviceConfiguration.getAsync().get(DcsBoolean.viewItemEventTimeHack);
    }

    public ViewItemViewData(Context context)
    {
        this();
        defaultForegroundColorId = ThemeUtil.resolveThemeForegroundColorResId(context.getTheme(), 0x7f01004e);
    }

    public String toString()
    {
        Object obj1 = null;
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = stringbuilder.append("itemId=");
        Object obj;
        if (keyParams != null)
        {
            obj = Long.valueOf(keyParams.itemId);
        } else
        {
            obj = null;
        }
        stringbuilder1.append(obj);
        stringbuilder1 = stringbuilder.append(";shippingCostsPostalCode=");
        obj = obj1;
        if (shippingCostsPostalCode != null)
        {
            obj = shippingCostsPostalCode.toString();
        }
        stringbuilder1.append(((String) (obj)));
        return stringbuilder.toString();
    }

}
