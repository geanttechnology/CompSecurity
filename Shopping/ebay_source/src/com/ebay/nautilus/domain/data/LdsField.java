// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            LdsOption

public class LdsField
    implements Parcelable
{

    public static final String ACCEPTED_PAYMENT_METHOD = "Listing.PaymentInfo.AcceptedPaymentMethod";
    public static final String APPEND_TO_DESCRIPTION = "Listing.Item.AddToDescription";
    public static final String APP_NAME = "Metadata.ApplicationInfo.AppName";
    public static final String AUTO_RELIST_COUNT = "Metadata.Listing.AutoRelistCount";
    public static final String AUTO_RELIST_ENABLED = "Listing.AutoRelistInfo.AutoRelistEnabled";
    public static final String AUTO_RELIST_FEE_SETTING = "Metadata.Fees.AutoRelistFeeSetting";
    public static final String AUTO_RELIST_MAX_RELIST = "Metadata.Listing.MaxAutoRelist";
    public static final String BEST_OFFER_AUTO_ACCEPT = "Listing.BestOffer.AutoAccept";
    public static final String BEST_OFFER_AUTO_ACCEPT_AMOUNT = "Listing.BestOffer.AutoAcceptAmount";
    public static final String BEST_OFFER_AUTO_DECLINE = "Listing.BestOffer.AutoDecline";
    public static final String BEST_OFFER_AUTO_DECLINE_AMOUNT = "Listing.BestOffer.AutodeclineAmount";
    public static final String BEST_OFFER_ENABLED = "Listing.BestOffer.BestOfferEnabled";
    public static final String CATEGORY = "Listing.CategoryInfo[0].Id";
    public static final String CATEGORY_ID_PATH = "Metadata.CategoryInfo[0].IdPath";
    public static final String CATEGORY_NAME_PATH = "Metadata.CategoryInfo[0].Name";
    public static final String CHARITY_DONATION_PERCENT = "Listing.CharityInfo.DonationPercent";
    public static final String CHARITY_INFO = "Listing.CharityInfo.CharityId";
    public static final String CITY_STATE = "Listing.ItemLocation.CityState";
    public static final String CONDITION = "Listing.Condition";
    public static final String CONDITION_DESCRIPTION = "Listing.ConditionDescription";
    public static final String CONDITION_SET_ID = "Metadata.ConditionInfo.ValueSetId";
    public static final String COUNTRY_CODE = "Listing.ItemLocation.CountryCode";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public LdsField createFromParcel(Parcel parcel)
        {
            return new LdsField(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public LdsField[] newArray(int i)
        {
            return new LdsField[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String CURRENCY = "Listing.ListingCurrency";
    public static final String DESCRIPTION = "Listing.Item.Description";
    public static final String DURATION = "Listing.Duration";
    public static final String EXTENDED_HANDLING_DURATION = "Metadata.ShippingInfo.ExtendedHandlingDuration";
    public static final String FEE_ON_TOTAL_COST = "Metadata.Fees.FeeOnTotalCost";
    public static final String FORMAT = "Listing.Format";
    public static final String GLOBAL_SHIPPING = "Listing.ShippingInfo.GlobalShipping";
    public static final String GUARANTEE_PROVIDED = "Metadata.Listing.PriceInfo.GuaranteeProvided";
    public static final String GUARANTEE_SALE_PRICE = "Metadata.Listing.PriceInfo.GuaranteeSalePrice";
    public static final String GUARANTEE_START_PRICE = "Metadata.Listing.PriceInfo.GuaranteeStartPrice";
    public static final String GUARANTEE_TERMS = "Metadata.Listing.PriceInfo.GuaranteeTerms";
    public static final String HANDLING_TIME = "Listing.ShippingInfo.HandlingDuration";
    public static final String IMMEDIATE_PAY = "Listing.PaymentInfo.ImmediatePay";
    public static final String INTL_SHIPPING_TYPE = "Listing.ShippingInfo.IntlShippingType";
    public static final String INTL_SHIP_FEE_1 = "Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee";
    public static final String INTL_SHIP_FEE_2 = "Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee";
    public static final String INTL_SHIP_FEE_3 = "Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee";
    public static final String INTL_SHIP_FEE_4 = "Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee";
    public static final String INTL_SHIP_FEE_5 = "Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee";
    public static final String INTL_SHIP_SERVICE_1 = "Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode";
    public static final String INTL_SHIP_SERVICE_2 = "Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode";
    public static final String INTL_SHIP_SERVICE_3 = "Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode";
    public static final String INTL_SHIP_SERVICE_4 = "Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode";
    public static final String INTL_SHIP_SERVICE_5 = "Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode";
    public static final String INTL_SHIP_TO_LOCATION_1 = "Listing.ShippingInfo.IntlItemShippingService[0].ShipToLocation";
    public static final String INTL_SHIP_TO_LOCATION_2 = "Listing.ShippingInfo.IntlItemShippingService[1].ShipToLocation";
    public static final String INTL_SHIP_TO_LOCATION_3 = "Listing.ShippingInfo.IntlItemShippingService[2].ShipToLocation";
    public static final String INTL_SHIP_TO_LOCATION_4 = "Listing.ShippingInfo.IntlItemShippingService[3].ShipToLocation";
    public static final String INTL_SHIP_TO_LOCATION_5 = "Listing.ShippingInfo.IntlItemShippingService[4].ShipToLocation";
    public static final String INTL_SHIP_TO_REGION_1 = "Listing.ShippingInfo.IntlItemShippingService[0].ShipToRegion";
    public static final String INTL_SHIP_TO_REGION_2 = "Listing.ShippingInfo.IntlItemShippingService[1].ShipToRegion";
    public static final String INTL_SHIP_TO_REGION_3 = "Listing.ShippingInfo.IntlItemShippingService[2].ShipToRegion";
    public static final String INTL_SHIP_TO_REGION_4 = "Listing.ShippingInfo.IntlItemShippingService[3].ShipToRegion";
    public static final String INTL_SHIP_TO_REGION_5 = "Listing.ShippingInfo.IntlItemShippingService[4].ShipToRegion";
    public static final String ITEM_SPECIFIC = "Listing.Item.ItemSpecific";
    public static final String LAST_MODIFIED = "Listing.LastModified";
    public static final String ORIGINAL_ITEM_ID = "Metadata.ItemInfo.OriginalItemId";
    public static final String PACKAGE_DEPTH = "Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value";
    public static final String PACKAGE_IRREGULAR = "Listing.ShippingInfo.IrregularPackage";
    public static final String PACKAGE_LENGTH = "Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value";
    public static final String PACKAGE_TYPE = "Listing.ShippingInfo.ShippingPackageDetails.PackageType";
    public static final String PACKAGE_UNIT_OF_MEASURE = "Listing.PkgUnitOfMeasure";
    public static final String PACKAGE_WEIGHT_ESTIMATED = "Listing.ShippingPackageDetails.EstimatedWeight";
    public static final String PACKAGE_WEIGHT_MAJOR = "Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value";
    public static final String PACKAGE_WEIGHT_MINOR = "Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value";
    public static final String PACKAGE_WIDTH = "Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value";
    public static final String PAYPAL_EMAIL_ADDRESS = "Listing.PaymentInfo.PaypalEmailAddress";
    public static final String PAYPAL_EMAIL_ADDRESS_KNOWN = "Metadata.PaymentInfo.RegisteredPaypalEmailAddreses";
    public static final String PICTURE = "Listing.Item.Picture";
    public static final String PICTURE_MAX_FREE = "Metadata.PictureInfo.MaxFreePictures";
    public static final String PICTURE_MAX_REMAINING = "Metadata.PictureInfo.MaxPicturesRemaining";
    public static final String POLICY_DETAILS = "Listing.ReturnPolicy.PolicyDetails";
    public static final String PRICE = "Listing.Price";
    public static final String PRODUCT_ID = "Listing.Item.ProductInfo.ProductId";
    public static final String PRODUCT_REFERENCE_ID = "Listing.Item.ProductInfo.ProductReferenceId";
    public static final String PRODUCT_SPECIFIC = "Listing.Item.ProductInfo.ProductSpecific";
    public static final String PRODUCT_STOCK_PHOTO = "Listing.Item.ProductInfo.StockPhoto";
    public static final String PRODUCT_TITLE = "Metadata.ProductInfo.Title";
    public static final String QUANTITY = "Listing.Quantity";
    public static final String REFUND_METHOD = "Listing.ReturnPolicy.RefundMethod";
    public static final String REFUND_SHIPMENT_PAYEE = "Listing.ReturnPolicy.RefundShipmentPayee";
    public static final String RESERVE_PRICE = "Listing.AuctionReservePrice";
    public static final String RESTOCKING_FEE = "Listing.ReturnPolicy.RestockingFeeValue";
    public static final String RETURNS_ACCEPTED = "Listing.ReturnPolicy.ReturnsAccepted";
    public static final String RETURN_PERIOD = "Listing.ReturnPolicy.ReturnPeriod";
    public static final String SCHEDULED_LISTING = "Listing.ScheduledListing";
    public static final String SHIPPING_FREE = "Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping";
    public static final String SHIPPING_SERVICE_1 = "Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode";
    public static final String SHIPPING_SERVICE_1_FEE = "Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee";
    public static final String SHIPPING_SERVICE_2 = "Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode";
    public static final String SHIPPING_SERVICE_2_FEE = "Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee";
    public static final String SHIPPING_SERVICE_3 = "Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode";
    public static final String SHIPPING_SERVICE_3_FEE = "Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee";
    public static final String SHIPPING_SERVICE_4 = "Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode";
    public static final String SHIPPING_SERVICE_4_FEE = "Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee";
    public static final String SHIPPING_SERVICE_LOCAL_PICKUP = "Listing.LocalPickupInfo.LocalPickup";
    public static final String SHIPPING_TYPE = "Listing.ShippingInfo.DomesticShippingType";
    public static final String SHIP_TO_LOCATION = "Listing.ShippingInfo.ShipToLocation";
    public static final String SIMILAR_LISTING_PRICE_MAX = "Metadata.SimilarListings.Listing.Price.Max";
    public static final String SIMILAR_LISTING_PRICE_MIN = "Metadata.SimilarListings.Listing.Price.Min";
    public static final String SIMILAR_LISTING_START_PRICE_MAX = "Metadata.SimilarListings.Listing.StartPrice.Max";
    public static final String SIMILAR_LISTING_START_PRICE_MIN = "Metadata.SimilarListings.Listing.StartPrice.Min";
    public static final String START_DATE = "Listing.StartDate";
    public static final String START_DATE_DAY = "Listing.StartDateDay";
    public static final String START_PRICE = "Listing.StartPrice";
    public static final String SUBTITLE = "Listing.EnhancementInfo.SubTitle";
    public static final String TITLE = "Listing.Item.Title";
    public static final String VARIATION_ITEM = "Listing.Item.VariationItem";
    public static final String ZIP_CODE = "Listing.ItemLocation.ZipCode";
    private String bmode;
    public String caption;
    public String id;
    public final ArrayList options;
    private final ArrayList selectedValues;

    public LdsField()
    {
        options = new ArrayList();
        selectedValues = new ArrayList();
    }

    private LdsField(Parcel parcel)
    {
        options = new ArrayList();
        selectedValues = new ArrayList();
        id = parcel.readString();
        bmode = parcel.readString();
        caption = parcel.readString();
        parcel.readStringList(selectedValues);
        parcel.readTypedList(options, LdsOption.CREATOR);
    }


    public static String getCaptionInt(LdsField ldsfield, int i)
    {
        if (ldsfield != null && i != 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        LdsOption ldsoption;
        ldsfield = ldsfield.options.iterator();
        do
        {
            if (!ldsfield.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            ldsoption = (LdsOption)ldsfield.next();
        } while (i != ldsoption.getIntValue());
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return ldsoption.caption;
    }

    public static String getLocalPickupString(int i, List list)
    {
        i;
        JVM INSTR lookupswitch 5: default 52
    //                   3: 116
    //                   71: 120
    //                   186: 128
    //                   203: 124
    //                   205: 132;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        list = list.iterator();
_L10:
        if (!list.hasNext()) goto _L8; else goto _L7
_L7:
        LdsOption ldsoption = (LdsOption)list.next();
        if (ldsoption.value == null || !ldsoption.value.contains("Pickup") && !ldsoption.value.contains("LocalPickUpOnly")) goto _L10; else goto _L9
_L9:
        return ldsoption.value;
_L2:
        return "UK_CollectInPerson";
_L3:
        return "FR_RemiseEnMainPropre";
_L5:
        return "IN_FlatRateCOD";
_L4:
        return "ES_PickUp";
_L6:
        return "IE_CollectionInPersonInternational";
_L8:
        return "Pickup";
    }

    public static String getStringValueSafe(LdsField ldsfield)
    {
        if (ldsfield != null)
        {
            return ldsfield.getStringValue();
        } else
        {
            return null;
        }
    }

    public void addSelectedValue(String s)
    {
        selectedValues.add(s);
    }

    public void clearSelections()
    {
        selectedValues.clear();
    }

    public int describeContents()
    {
        return 0;
    }

    public String getBmode()
    {
        return bmode;
    }

    public boolean getBooleanValue()
    {
        boolean flag = false;
        if (hasSelection())
        {
            flag = Boolean.parseBoolean((String)getSelectedValues().get(0));
        }
        return flag;
    }

    public Date getDateValue()
    {
        Object obj;
        if (!hasSelection())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        obj = (String)getSelectedValues().get(0);
        obj = EbayDateUtils.parse(((String) (obj)));
        return ((Date) (obj));
        ParseException parseexception;
        parseexception;
        return null;
    }

    public double getDoubleValue()
    {
        String s;
        if (!hasSelection())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        s = (String)getSelectedValues().get(0);
        double d = Double.parseDouble(s);
        return d;
        NumberFormatException numberformatexception;
        numberformatexception;
        return 0.0D;
    }

    public String getIdIndex()
    {
        int i = id.lastIndexOf("[");
        int j = id.lastIndexOf("]");
        if (i != -1 && j != -1 && i < j)
        {
            return id.substring(i + 1, j);
        } else
        {
            return null;
        }
    }

    public int getIntValue()
    {
        int i = 0;
        if (hasSelection())
        {
            String s = (String)getSelectedValues().get(0);
            try
            {
                i = Integer.parseInt(s);
            }
            catch (NumberFormatException numberformatexception)
            {
                return 0;
            }
        }
        return i;
    }

    public String getSelectedCaption()
    {
        if (!hasSelection()) goto _L2; else goto _L1
_L1:
        String s = (String)getSelectedValues().get(0);
        if (s != null && !s.equals("NotSelected")) goto _L3; else goto _L2
_L2:
        return null;
_L3:
        LdsOption ldsoption;
        Iterator iterator = options.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            ldsoption = (LdsOption)iterator.next();
        } while (!s.equals(ldsoption.value));
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L4
_L4:
        return ldsoption.caption;
    }

    public ArrayList getSelectedCaptions()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getSelectedValues().iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (s == null || s.equals("NotSelected"))
            {
                continue;
            }
            Iterator iterator1 = options.iterator();
            LdsOption ldsoption;
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
                ldsoption = (LdsOption)iterator1.next();
                if (ldsoption.value != null && ldsoption.value.equals("None"))
                {
                    continue label0;
                }
            } while (!s.equals(ldsoption.value));
            arraylist.add(ldsoption.caption);
        } while (true);
        return arraylist;
    }

    public ArrayList getSelectedStringValues()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = getSelectedValues().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (s != null && !s.equals("NotSelected"))
            {
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }

    public ArrayList getSelectedValues()
    {
        return new ArrayList(selectedValues);
    }

    public String getStringValue()
    {
        if (hasSelection())
        {
            return (String)getSelectedValues().get(0);
        } else
        {
            return null;
        }
    }

    public boolean hasSelection()
    {
        return selectedValues.size() > 0;
    }

    public boolean isEnabled()
    {
        return bmode.equals("ENABLE");
    }

    public void replaceSelectedValue(String s)
    {
        selectedValues.clear();
        selectedValues.add(s);
    }

    public void replaceSelectedValues(ArrayList arraylist)
    {
        selectedValues.clear();
        selectedValues.addAll(arraylist);
    }

    public void setBmode(String s)
    {
        bmode = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append(id).append(" ").append(getStringValue()).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeString(bmode);
        parcel.writeString(caption);
        parcel.writeStringList(selectedValues);
        parcel.writeTypedList(options);
    }

}
