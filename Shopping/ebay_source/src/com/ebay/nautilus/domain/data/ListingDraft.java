// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            LdsError, LdsFee, LdsField, CurrencyAmount

public class ListingDraft
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ListingDraft createFromParcel(Parcel parcel)
        {
            return new ListingDraft(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ListingDraft[] newArray(int i)
        {
            return new ListingDraft[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public LdsField appName;
    public LdsField appendToDescription;
    public LdsField autoRelistCount;
    public LdsField autoRelistEnabled;
    public LdsField autoRelistFeeSetting;
    public LdsField autoRelistMaxRelist;
    public LdsField bestOfferAutoAccept;
    public LdsField bestOfferAutoAcceptValue;
    public LdsField bestOfferAutoDecline;
    public LdsField bestOfferAutoDeclineValue;
    public LdsField bestOfferEnabled;
    public LdsField category;
    public LdsField categoryIdPath;
    public LdsField categoryNamePath;
    public LdsField charityDonationPercent;
    public LdsField charityId;
    public LdsField condition;
    public LdsField conditionDescription;
    public LdsField conditionSetId;
    private LdsField currency;
    public LdsField description;
    public LdsField duration;
    public final ArrayList errors;
    public LdsField extendedHandlingDuration;
    public LdsField feeOnTotalCost;
    public final ArrayList fees;
    public String feesCurrencyCode;
    public LdsField format;
    public LdsField globalShipping;
    public LdsField guaranteeProvided;
    public LdsField guaranteeSalePrice;
    public LdsField guaranteeStartPrice;
    public LdsField guaranteeTerms;
    public LdsField handlingTime;
    public String id;
    public LdsField immediatePay;
    public LdsField intlShipToLocation1;
    public LdsField intlShipToLocation2;
    public LdsField intlShipToLocation3;
    public LdsField intlShipToLocation4;
    public LdsField intlShipToLocation5;
    public LdsField intlShipToRegion1;
    public LdsField intlShipToRegion2;
    public LdsField intlShipToRegion3;
    public LdsField intlShipToRegion4;
    public LdsField intlShipToRegion5;
    public LdsField intlShippingFee1;
    public LdsField intlShippingFee2;
    public LdsField intlShippingFee3;
    public LdsField intlShippingFee4;
    public LdsField intlShippingFee5;
    public LdsField intlShippingService1;
    public LdsField intlShippingService2;
    public LdsField intlShippingService3;
    public LdsField intlShippingService4;
    public LdsField intlShippingService5;
    public LdsField intlShippingType;
    public String itemId;
    public LdsField itemSpecifics;
    public LdsField lastModified;
    public String listingMode;
    public LdsField localPickup;
    public LdsField locationCityState;
    public LdsField locationCountry;
    public LdsField locationPostalCode;
    public final ArrayList lookupFees;
    public LdsField originalItemId;
    public LdsField packageDepth;
    public LdsField packageIrregular;
    public LdsField packageLength;
    public LdsField packageType;
    public LdsField packageUnitOfMeasure;
    public LdsField packageWeightEstimated;
    public LdsField packageWeightMajor;
    public LdsField packageWeightMinor;
    public LdsField packageWidth;
    public final ArrayList paymentMethods;
    public LdsField paypalEmailAddress;
    public LdsField paypalEmailAddressKnown;
    public LdsField pictureMaxFree;
    public LdsField pictureMaxRemaining;
    public final ArrayList pictureUrls;
    public LdsField price;
    public LdsField productId;
    public LdsField productReferenceId;
    public final ArrayList productSpecifics;
    public LdsField productStockPhoto;
    public LdsField productTitle;
    public LdsField quantity;
    public LdsField recommendedDuration;
    public LdsField recommendedFormat;
    public LdsField recommendedPrice;
    public LdsField recommendedStartPrice;
    public LdsField refundMethod;
    public LdsField refundPolicyDetails;
    public LdsField refundRestockingFee;
    public LdsField refundReturnPeriod;
    public LdsField refundReturnsAccepted;
    public LdsField refundShipmentPayee;
    public LdsField reservePrice;
    public final ArrayList selectedItemSpecifics;
    public LdsField shippingFree;
    public LdsField shippingService1;
    public LdsField shippingService1fee;
    public LdsField shippingService2;
    public LdsField shippingService2fee;
    public LdsField shippingService3;
    public LdsField shippingService3fee;
    public LdsField shippingService4;
    public LdsField shippingService4fee;
    public LdsField shippingType;
    public LdsField similarListingPriceMax;
    public LdsField similarListingPriceMin;
    public LdsField similarListingStartPriceMax;
    public LdsField similarListingStartPriceMin;
    public int siteId;
    public LdsField startDate;
    public LdsField startDateEnabled;
    public LdsField startPrice;
    public LdsField subtitle;
    public LdsField title;
    public final ArrayList variationItems;
    public final ArrayList warnings;

    public ListingDraft()
    {
        errors = new ArrayList();
        warnings = new ArrayList();
        fees = new ArrayList();
        lookupFees = new ArrayList();
        pictureUrls = new ArrayList();
        paymentMethods = new ArrayList();
        selectedItemSpecifics = new ArrayList();
        productSpecifics = new ArrayList();
        variationItems = new ArrayList();
    }

    private ListingDraft(Parcel parcel)
    {
        errors = new ArrayList();
        warnings = new ArrayList();
        fees = new ArrayList();
        lookupFees = new ArrayList();
        pictureUrls = new ArrayList();
        paymentMethods = new ArrayList();
        selectedItemSpecifics = new ArrayList();
        productSpecifics = new ArrayList();
        variationItems = new ArrayList();
        id = parcel.readString();
        parcel.readTypedList(errors, LdsError.CREATOR);
        parcel.readTypedList(warnings, LdsError.CREATOR);
        parcel.readTypedList(fees, LdsFee.CREATOR);
        parcel.readTypedList(lookupFees, LdsFee.CREATOR);
        feesCurrencyCode = parcel.readString();
        itemId = parcel.readString();
        siteId = parcel.readInt();
        listingMode = parcel.readString();
        ClassLoader classloader = getClass().getClassLoader();
        title = (LdsField)parcel.readParcelable(classloader);
        subtitle = (LdsField)parcel.readParcelable(classloader);
        category = (LdsField)parcel.readParcelable(classloader);
        categoryNamePath = (LdsField)parcel.readParcelable(classloader);
        categoryIdPath = (LdsField)parcel.readParcelable(classloader);
        description = (LdsField)parcel.readParcelable(classloader);
        appendToDescription = (LdsField)parcel.readParcelable(classloader);
        condition = (LdsField)parcel.readParcelable(classloader);
        conditionSetId = (LdsField)parcel.readParcelable(classloader);
        duration = (LdsField)parcel.readParcelable(classloader);
        format = (LdsField)parcel.readParcelable(classloader);
        startPrice = (LdsField)parcel.readParcelable(classloader);
        price = (LdsField)parcel.readParcelable(classloader);
        reservePrice = (LdsField)parcel.readParcelable(classloader);
        quantity = (LdsField)parcel.readParcelable(classloader);
        shippingType = (LdsField)parcel.readParcelable(classloader);
        shippingService1 = (LdsField)parcel.readParcelable(classloader);
        shippingService2 = (LdsField)parcel.readParcelable(classloader);
        shippingService3 = (LdsField)parcel.readParcelable(classloader);
        shippingService4 = (LdsField)parcel.readParcelable(classloader);
        shippingFree = (LdsField)parcel.readParcelable(classloader);
        shippingService1fee = (LdsField)parcel.readParcelable(classloader);
        shippingService2fee = (LdsField)parcel.readParcelable(classloader);
        shippingService3fee = (LdsField)parcel.readParcelable(classloader);
        shippingService4fee = (LdsField)parcel.readParcelable(classloader);
        packageType = (LdsField)parcel.readParcelable(classloader);
        packageLength = (LdsField)parcel.readParcelable(classloader);
        packageWidth = (LdsField)parcel.readParcelable(classloader);
        packageDepth = (LdsField)parcel.readParcelable(classloader);
        packageIrregular = (LdsField)parcel.readParcelable(classloader);
        packageUnitOfMeasure = (LdsField)parcel.readParcelable(classloader);
        packageWeightEstimated = (LdsField)parcel.readParcelable(classloader);
        packageWeightMajor = (LdsField)parcel.readParcelable(classloader);
        packageWeightMinor = (LdsField)parcel.readParcelable(classloader);
        intlShippingType = (LdsField)parcel.readParcelable(classloader);
        intlShippingService1 = (LdsField)parcel.readParcelable(classloader);
        intlShippingService2 = (LdsField)parcel.readParcelable(classloader);
        intlShippingService3 = (LdsField)parcel.readParcelable(classloader);
        intlShippingService4 = (LdsField)parcel.readParcelable(classloader);
        intlShippingService5 = (LdsField)parcel.readParcelable(classloader);
        intlShippingFee1 = (LdsField)parcel.readParcelable(classloader);
        intlShippingFee2 = (LdsField)parcel.readParcelable(classloader);
        intlShippingFee3 = (LdsField)parcel.readParcelable(classloader);
        intlShippingFee4 = (LdsField)parcel.readParcelable(classloader);
        intlShippingFee5 = (LdsField)parcel.readParcelable(classloader);
        intlShipToRegion1 = (LdsField)parcel.readParcelable(classloader);
        intlShipToRegion2 = (LdsField)parcel.readParcelable(classloader);
        intlShipToRegion3 = (LdsField)parcel.readParcelable(classloader);
        intlShipToRegion4 = (LdsField)parcel.readParcelable(classloader);
        intlShipToRegion5 = (LdsField)parcel.readParcelable(classloader);
        intlShipToLocation1 = (LdsField)parcel.readParcelable(classloader);
        intlShipToLocation2 = (LdsField)parcel.readParcelable(classloader);
        intlShipToLocation3 = (LdsField)parcel.readParcelable(classloader);
        intlShipToLocation4 = (LdsField)parcel.readParcelable(classloader);
        intlShipToLocation5 = (LdsField)parcel.readParcelable(classloader);
        paypalEmailAddress = (LdsField)parcel.readParcelable(classloader);
        paypalEmailAddressKnown = (LdsField)parcel.readParcelable(classloader);
        currency = (LdsField)parcel.readParcelable(classloader);
        productTitle = (LdsField)parcel.readParcelable(classloader);
        productStockPhoto = (LdsField)parcel.readParcelable(classloader);
        productId = (LdsField)parcel.readParcelable(classloader);
        productReferenceId = (LdsField)parcel.readParcelable(classloader);
        startDate = (LdsField)parcel.readParcelable(classloader);
        startDateEnabled = (LdsField)parcel.readParcelable(classloader);
        itemSpecifics = (LdsField)parcel.readParcelable(classloader);
        bestOfferEnabled = (LdsField)parcel.readParcelable(classloader);
        bestOfferAutoAccept = (LdsField)parcel.readParcelable(classloader);
        bestOfferAutoAcceptValue = (LdsField)parcel.readParcelable(classloader);
        bestOfferAutoDecline = (LdsField)parcel.readParcelable(classloader);
        bestOfferAutoDeclineValue = (LdsField)parcel.readParcelable(classloader);
        handlingTime = (LdsField)parcel.readParcelable(classloader);
        extendedHandlingDuration = (LdsField)parcel.readParcelable(classloader);
        refundPolicyDetails = (LdsField)parcel.readParcelable(classloader);
        refundMethod = (LdsField)parcel.readParcelable(classloader);
        refundShipmentPayee = (LdsField)parcel.readParcelable(classloader);
        refundReturnsAccepted = (LdsField)parcel.readParcelable(classloader);
        refundReturnPeriod = (LdsField)parcel.readParcelable(classloader);
        refundRestockingFee = (LdsField)parcel.readParcelable(classloader);
        locationCountry = (LdsField)parcel.readParcelable(classloader);
        locationCityState = (LdsField)parcel.readParcelable(classloader);
        locationPostalCode = (LdsField)parcel.readParcelable(classloader);
        immediatePay = (LdsField)parcel.readParcelable(classloader);
        pictureMaxRemaining = (LdsField)parcel.readParcelable(classloader);
        pictureMaxFree = (LdsField)parcel.readParcelable(classloader);
        lastModified = (LdsField)parcel.readParcelable(classloader);
        appName = (LdsField)parcel.readParcelable(classloader);
        globalShipping = (LdsField)parcel.readParcelable(classloader);
        originalItemId = (LdsField)parcel.readParcelable(classloader);
        autoRelistEnabled = (LdsField)parcel.readParcelable(classloader);
        autoRelistFeeSetting = (LdsField)parcel.readParcelable(classloader);
        autoRelistMaxRelist = (LdsField)parcel.readParcelable(classloader);
        autoRelistCount = (LdsField)parcel.readParcelable(classloader);
        similarListingPriceMin = (LdsField)parcel.readParcelable(classloader);
        similarListingPriceMax = (LdsField)parcel.readParcelable(classloader);
        similarListingStartPriceMin = (LdsField)parcel.readParcelable(classloader);
        similarListingStartPriceMax = (LdsField)parcel.readParcelable(classloader);
        feeOnTotalCost = (LdsField)parcel.readParcelable(classloader);
        charityDonationPercent = (LdsField)parcel.readParcelable(classloader);
        charityId = (LdsField)parcel.readParcelable(classloader);
        conditionDescription = (LdsField)parcel.readParcelable(classloader);
        localPickup = (LdsField)parcel.readParcelable(classloader);
        guaranteeStartPrice = (LdsField)parcel.readParcelable(classloader);
        guaranteeSalePrice = (LdsField)parcel.readParcelable(classloader);
        guaranteeTerms = (LdsField)parcel.readParcelable(classloader);
        guaranteeProvided = (LdsField)parcel.readParcelable(classloader);
        recommendedPrice = (LdsField)parcel.readParcelable(classloader);
        recommendedStartPrice = (LdsField)parcel.readParcelable(classloader);
        recommendedFormat = (LdsField)parcel.readParcelable(classloader);
        recommendedDuration = (LdsField)parcel.readParcelable(classloader);
        parcel.readTypedList(pictureUrls, LdsField.CREATOR);
        parcel.readTypedList(paymentMethods, LdsField.CREATOR);
        parcel.readTypedList(selectedItemSpecifics, LdsField.CREATOR);
        parcel.readTypedList(variationItems, LdsField.CREATOR);
        parcel.readTypedList(productSpecifics, LdsField.CREATOR);
    }


    public static String getDimensionsUnitString(ListingDraft listingdraft)
    {
        if ("IMPERIAL".equals(listingdraft.packageUnitOfMeasure.getStringValue()))
        {
            return "inches";
        } else
        {
            return "cm";
        }
    }

    public static double getWeightDouble(ListingDraft listingdraft)
    {
        LdsField ldsfield = listingdraft.packageUnitOfMeasure;
        LdsField ldsfield1 = listingdraft.packageWeightMajor;
        listingdraft = listingdraft.packageWeightMinor;
        double d1 = 0.0D;
        double d = d1;
        if (ldsfield1 != null)
        {
            d = d1;
            if (ldsfield1.hasSelection())
            {
                d = ldsfield1.getIntValue();
            }
        }
        if ("IMPERIAL".equals(ldsfield.getStringValue()))
        {
            d *= 16D;
        } else
        {
            d *= 1000D;
        }
        d1 = d;
        if (listingdraft != null)
        {
            d1 = d;
            if (listingdraft.hasSelection())
            {
                d1 = d + (double)listingdraft.getIntValue();
            }
        }
        return d1;
    }

    public static String getWeightUnitString(ListingDraft listingdraft)
    {
        if ("IMPERIAL".equals(listingdraft.packageUnitOfMeasure.getStringValue()))
        {
            return "oz";
        } else
        {
            return "gram";
        }
    }

    public static boolean serviceIsSelected(LdsField ldsfield)
    {
        return ldsfield != null && ldsfield.hasSelection() && !"NotSelected".equals(ldsfield.getStringValue());
    }

    public ListingDraft cloneFromParcel()
    {
        Parcel parcel = Parcel.obtain();
        writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ListingDraft listingdraft = (ListingDraft)CREATOR.createFromParcel(parcel);
        parcel.recycle();
        return listingdraft;
    }

    public int describeContents()
    {
        return 0;
    }

    public CurrencyAmount feeTotal()
    {
        CurrencyAmount currencyamount = new CurrencyAmount("0", feesCurrencyCode);
        for (Iterator iterator = fees.iterator(); iterator.hasNext();)
        {
            currencyamount = currencyamount.add(new CurrencyAmount(((LdsFee)iterator.next()).value, feesCurrencyCode));
        }

        return currencyamount;
    }

    public String getCurrencyCode()
    {
        if (currency == null)
        {
            return EbaySite.getInstanceFromId(siteId).getCurrency().getCurrencyCode();
        } else
        {
            return currency.getStringValue();
        }
    }

    public LdsField getCurrencyUnsafe()
    {
        return currency;
    }

    public int getDomesticShippingCount()
    {
        int j = 0;
        if (serviceIsSelected(shippingService1))
        {
            j = 0 + 1;
        }
        int i = j;
        if (serviceIsSelected(shippingService2))
        {
            i = j + 1;
        }
        j = i;
        if (serviceIsSelected(shippingService3))
        {
            j = i + 1;
        }
        i = j;
        if (serviceIsSelected(shippingService4))
        {
            i = j + 1;
        }
        return i;
    }

    public String getGuaranteeTerms()
    {
        String s = LdsField.getStringValueSafe(guaranteeTerms);
        try
        {
            new URL(s);
        }
        catch (MalformedURLException malformedurlexception)
        {
            return null;
        }
        return s;
    }

    public int getIntlShippingCount()
    {
        int j = 0;
        if (serviceIsSelected(intlShippingService1))
        {
            j = 0 + 1;
        }
        int i = j;
        if (serviceIsSelected(intlShippingService2))
        {
            i = j + 1;
        }
        j = i;
        if (serviceIsSelected(intlShippingService3))
        {
            j = i + 1;
        }
        i = j;
        if (serviceIsSelected(intlShippingService4))
        {
            i = j + 1;
        }
        j = i;
        if (serviceIsSelected(intlShippingService5))
        {
            j = i + 1;
        }
        return j;
    }

    public ArrayList getModifiablePaymentMethods()
    {
        if (!paymentMethods.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ArrayList) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        Iterator iterator = paymentMethods.iterator();
        do
        {
            obj = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (LdsField)iterator.next();
            if (((LdsField) (obj)).isEnabled())
            {
                arraylist.add(obj);
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getPrimaryPhotoUrl()
    {
        if (pictureUrls.isEmpty())
        {
            if (productStockPhoto != null && productStockPhoto.getStringValue() != null)
            {
                return productStockPhoto.getStringValue();
            } else
            {
                return null;
            }
        } else
        {
            return ((LdsField)pictureUrls.get(0)).getStringValue();
        }
    }

    public LdsField getShippingFieldForId(String s)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 23: default 200
    //                   -2054689084: 640
    //                   -1819650879: 592
    //                   -1732918401: 496
    //                   -1329987705: 325
    //                   -1227359776: 480
    //                   -1189439095: 355
    //                   -829390680: 528
    //                   -721801151: 464
    //                   -701379387: 656
    //                   -688842070: 560
    //                   -466341182: 608
    //                   -216242526: 448
    //                   147394657: 416
    //                   289316099: 432
    //                   652953282: 400
    //                   747221638: 310
    //                   886968515: 624
    //                   887770248: 340
    //                   1158511907: 385
    //                   1247818663: 512
    //                   1388367273: 544
    //                   1528915883: 576
    //                   1664070532: 370;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24
_L1:
        break; /* Loop/switch isn't completed */
_L10:
        break MISSING_BLOCK_LABEL_656;
_L25:
        switch (byte0)
        {
        default:
            return null;

        case 0: // '\0'
            return shippingService1;

        case 1: // '\001'
            return shippingService2;

        case 2: // '\002'
            return shippingService3;

        case 3: // '\003'
            return shippingService4;

        case 4: // '\004'
            return shippingService1fee;

        case 5: // '\005'
            return shippingService2fee;

        case 6: // '\006'
            return shippingService3fee;

        case 7: // '\007'
            return shippingService4fee;

        case 8: // '\b'
            return intlShippingFee1;

        case 9: // '\t'
            return intlShippingFee2;

        case 10: // '\n'
            return intlShippingFee3;

        case 11: // '\013'
            return intlShippingFee4;

        case 12: // '\f'
            return intlShippingFee5;

        case 13: // '\r'
            return intlShippingService1;

        case 14: // '\016'
            return intlShippingService2;

        case 15: // '\017'
            return intlShippingService3;

        case 16: // '\020'
            return intlShippingService4;

        case 17: // '\021'
            return intlShippingService5;

        case 18: // '\022'
            return intlShipToLocation1;

        case 19: // '\023'
            return intlShipToLocation2;

        case 20: // '\024'
            return intlShipToLocation3;

        case 21: // '\025'
            return intlShipToLocation4;

        case 22: // '\026'
            return intlShipToLocation5;
        }
_L17:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode"))
        {
            byte0 = 0;
        }
          goto _L25
_L5:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode"))
        {
            byte0 = 1;
        }
          goto _L25
_L19:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode"))
        {
            byte0 = 2;
        }
          goto _L25
_L7:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode"))
        {
            byte0 = 3;
        }
          goto _L25
_L24:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee"))
        {
            byte0 = 4;
        }
          goto _L25
_L20:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee"))
        {
            byte0 = 5;
        }
          goto _L25
_L16:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee"))
        {
            byte0 = 6;
        }
          goto _L25
_L14:
        if (s.equals("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee"))
        {
            byte0 = 7;
        }
          goto _L25
_L15:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee"))
        {
            byte0 = 8;
        }
          goto _L25
_L13:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee"))
        {
            byte0 = 9;
        }
          goto _L25
_L9:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee"))
        {
            byte0 = 10;
        }
          goto _L25
_L6:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee"))
        {
            byte0 = 11;
        }
          goto _L25
_L4:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].ShippingFee"))
        {
            byte0 = 12;
        }
          goto _L25
_L21:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode"))
        {
            byte0 = 13;
        }
          goto _L25
_L8:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode"))
        {
            byte0 = 14;
        }
          goto _L25
_L22:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode"))
        {
            byte0 = 15;
        }
          goto _L25
_L11:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode"))
        {
            byte0 = 16;
        }
          goto _L25
_L23:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode"))
        {
            byte0 = 17;
        }
          goto _L25
_L3:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[0].ShipToLocation"))
        {
            byte0 = 18;
        }
          goto _L25
_L12:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[1].ShipToLocation"))
        {
            byte0 = 19;
        }
          goto _L25
_L18:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[2].ShipToLocation"))
        {
            byte0 = 20;
        }
          goto _L25
_L2:
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[3].ShipToLocation"))
        {
            byte0 = 21;
        }
          goto _L25
        if (s.equals("Listing.ShippingInfo.IntlItemShippingService[4].ShipToLocation"))
        {
            byte0 = 22;
        }
          goto _L25
    }

    public Date getStartDateValue()
    {
        Date date1 = startDate.getDateValue();
        Date date = date1;
        if (date1 == null)
        {
            date = new Date();
        }
        return date;
    }

    public boolean isFreeShipping()
    {
        if (shippingType != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s;
        s = shippingType.getStringValue();
        if (!"FLAT_RATE".equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (shippingService1fee == null || shippingService1fee.getDoubleValue() != 0.0D) goto _L1; else goto _L3
_L3:
        return true;
        if (!"ACTUAL_RATE".equals(s)) goto _L1; else goto _L4
_L4:
        return shippingFree.getBooleanValue();
    }

    public boolean isGuaranteeAvailable()
    {
        while (!DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.B.guarantee) || !isRecommendedFormatAuction() || guaranteeSalePrice == null || guaranteeSalePrice.getStringValue() == null || guaranteeStartPrice == null || guaranteeStartPrice.getStringValue() == null || guaranteeTerms == null || guaranteeTerms.getStringValue() == null || recommendedDuration == null || recommendedDuration.getStringValue() == null || title == null || title.getStringValue() == null || condition == null || condition.getStringValue() == null) 
        {
            return false;
        }
        return true;
    }

    public boolean isRecommendedFormatAuction()
    {
        if (!listingMode.equals("ReviseItem")) goto _L2; else goto _L1
_L1:
        if (format == null || format.getStringValue() == null || !format.getStringValue().equals("ChineseAuction")) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (recommendedFormat == null || recommendedFormat.getStringValue() == null || !recommendedFormat.getStringValue().equals("ChineseAuction"))
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void setCurrency(LdsField ldsfield)
    {
        currency = ldsfield;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(id);
        parcel.writeTypedList(errors);
        parcel.writeTypedList(warnings);
        parcel.writeTypedList(fees);
        parcel.writeTypedList(lookupFees);
        parcel.writeString(feesCurrencyCode);
        parcel.writeString(itemId);
        parcel.writeInt(siteId);
        parcel.writeString(listingMode);
        parcel.writeParcelable(title, i);
        parcel.writeParcelable(subtitle, i);
        parcel.writeParcelable(category, i);
        parcel.writeParcelable(categoryNamePath, i);
        parcel.writeParcelable(categoryIdPath, i);
        parcel.writeParcelable(description, i);
        parcel.writeParcelable(appendToDescription, i);
        parcel.writeParcelable(condition, i);
        parcel.writeParcelable(conditionSetId, i);
        parcel.writeParcelable(duration, i);
        parcel.writeParcelable(format, i);
        parcel.writeParcelable(startPrice, i);
        parcel.writeParcelable(price, i);
        parcel.writeParcelable(reservePrice, i);
        parcel.writeParcelable(quantity, i);
        parcel.writeParcelable(shippingType, i);
        parcel.writeParcelable(shippingService1, i);
        parcel.writeParcelable(shippingService2, i);
        parcel.writeParcelable(shippingService3, i);
        parcel.writeParcelable(shippingService4, i);
        parcel.writeParcelable(shippingFree, i);
        parcel.writeParcelable(shippingService1fee, i);
        parcel.writeParcelable(shippingService2fee, i);
        parcel.writeParcelable(shippingService3fee, i);
        parcel.writeParcelable(shippingService4fee, i);
        parcel.writeParcelable(packageType, i);
        parcel.writeParcelable(packageLength, i);
        parcel.writeParcelable(packageWidth, i);
        parcel.writeParcelable(packageDepth, i);
        parcel.writeParcelable(packageIrregular, i);
        parcel.writeParcelable(packageUnitOfMeasure, i);
        parcel.writeParcelable(packageWeightEstimated, i);
        parcel.writeParcelable(packageWeightMajor, i);
        parcel.writeParcelable(packageWeightMinor, i);
        parcel.writeParcelable(intlShippingType, i);
        parcel.writeParcelable(intlShippingService1, i);
        parcel.writeParcelable(intlShippingService2, i);
        parcel.writeParcelable(intlShippingService3, i);
        parcel.writeParcelable(intlShippingService4, i);
        parcel.writeParcelable(intlShippingService5, i);
        parcel.writeParcelable(intlShippingFee1, i);
        parcel.writeParcelable(intlShippingFee2, i);
        parcel.writeParcelable(intlShippingFee3, i);
        parcel.writeParcelable(intlShippingFee4, i);
        parcel.writeParcelable(intlShippingFee5, i);
        parcel.writeParcelable(intlShipToRegion1, i);
        parcel.writeParcelable(intlShipToRegion2, i);
        parcel.writeParcelable(intlShipToRegion3, i);
        parcel.writeParcelable(intlShipToRegion4, i);
        parcel.writeParcelable(intlShipToRegion5, i);
        parcel.writeParcelable(intlShipToLocation1, i);
        parcel.writeParcelable(intlShipToLocation2, i);
        parcel.writeParcelable(intlShipToLocation3, i);
        parcel.writeParcelable(intlShipToLocation4, i);
        parcel.writeParcelable(intlShipToLocation5, i);
        parcel.writeParcelable(paypalEmailAddress, i);
        parcel.writeParcelable(paypalEmailAddressKnown, i);
        parcel.writeParcelable(currency, i);
        parcel.writeParcelable(productTitle, i);
        parcel.writeParcelable(productStockPhoto, i);
        parcel.writeParcelable(productId, i);
        parcel.writeParcelable(productReferenceId, i);
        parcel.writeParcelable(startDate, i);
        parcel.writeParcelable(startDateEnabled, i);
        parcel.writeParcelable(itemSpecifics, i);
        parcel.writeParcelable(bestOfferEnabled, i);
        parcel.writeParcelable(bestOfferAutoAccept, i);
        parcel.writeParcelable(bestOfferAutoAcceptValue, i);
        parcel.writeParcelable(bestOfferAutoDecline, i);
        parcel.writeParcelable(bestOfferAutoDeclineValue, i);
        parcel.writeParcelable(handlingTime, i);
        parcel.writeParcelable(extendedHandlingDuration, i);
        parcel.writeParcelable(refundPolicyDetails, i);
        parcel.writeParcelable(refundMethod, i);
        parcel.writeParcelable(refundShipmentPayee, i);
        parcel.writeParcelable(refundReturnsAccepted, i);
        parcel.writeParcelable(refundReturnPeriod, i);
        parcel.writeParcelable(refundRestockingFee, i);
        parcel.writeParcelable(locationCountry, i);
        parcel.writeParcelable(locationCityState, i);
        parcel.writeParcelable(locationPostalCode, i);
        parcel.writeParcelable(immediatePay, i);
        parcel.writeParcelable(pictureMaxRemaining, i);
        parcel.writeParcelable(pictureMaxFree, i);
        parcel.writeParcelable(lastModified, i);
        parcel.writeParcelable(appName, i);
        parcel.writeParcelable(globalShipping, i);
        parcel.writeParcelable(originalItemId, i);
        parcel.writeParcelable(autoRelistEnabled, i);
        parcel.writeParcelable(autoRelistFeeSetting, i);
        parcel.writeParcelable(autoRelistMaxRelist, i);
        parcel.writeParcelable(autoRelistCount, i);
        parcel.writeParcelable(similarListingPriceMin, i);
        parcel.writeParcelable(similarListingPriceMax, i);
        parcel.writeParcelable(similarListingStartPriceMin, i);
        parcel.writeParcelable(similarListingStartPriceMax, i);
        parcel.writeParcelable(feeOnTotalCost, i);
        parcel.writeParcelable(charityDonationPercent, i);
        parcel.writeParcelable(charityId, i);
        parcel.writeParcelable(conditionDescription, i);
        parcel.writeParcelable(localPickup, i);
        parcel.writeParcelable(guaranteeStartPrice, i);
        parcel.writeParcelable(guaranteeSalePrice, i);
        parcel.writeParcelable(guaranteeTerms, i);
        parcel.writeParcelable(guaranteeProvided, i);
        parcel.writeParcelable(recommendedPrice, i);
        parcel.writeParcelable(recommendedStartPrice, i);
        parcel.writeParcelable(recommendedFormat, i);
        parcel.writeParcelable(recommendedDuration, i);
        parcel.writeTypedList(pictureUrls);
        parcel.writeTypedList(paymentMethods);
        parcel.writeTypedList(selectedItemSpecifics);
        parcel.writeTypedList(variationItems);
        parcel.writeTypedList(productSpecifics);
    }

}
