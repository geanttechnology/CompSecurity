// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.text.TextUtils;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbaySearchListItem, ItemCurrency, NameValue, Variation, 
//            VariationPictureSet, BestOffer, ShippingCostsShippingOption, ItemCompatibilty, 
//            ShipmentTracking, ProductListingDetails, ItemWeight

public class EbayItem extends EbaySearchListItem
{
    public class ShippingDiscountProfile
    {

        public ItemCurrency eachAdditionalAmount;
        public ItemCurrency eachAdditionalAmountOff;
        public Float eachAdditionalPercentOff;
        public String id;
        public String mappedId;
        public String name;
        final EbayItem this$0;
        public ItemWeight weightOff;

        public void readFromParcel(Parcel parcel, ClassLoader classloader)
        {
            id = parcel.readString();
            name = parcel.readString();
            eachAdditionalAmount = (ItemCurrency)parcel.readParcelable(classloader);
            eachAdditionalAmountOff = (ItemCurrency)parcel.readParcelable(classloader);
            if (1 == parcel.readInt())
            {
                eachAdditionalPercentOff = Float.valueOf(parcel.readFloat());
            }
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(id);
            parcel.writeString(name);
            parcel.writeParcelable(eachAdditionalAmount, i);
            parcel.writeParcelable(eachAdditionalAmountOff, i);
            if (eachAdditionalPercentOff != null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
            if (eachAdditionalPercentOff != null)
            {
                parcel.writeFloat(eachAdditionalPercentOff.floatValue());
            }
        }

        public ShippingDiscountProfile()
        {
            this$0 = EbayItem.this;
            super();
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayItem createFromParcel(Parcel parcel)
        {
            return new EbayItem(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayItem[] newArray(int i)
        {
            return new EbayItem[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String LISTING_STATUS_COMPLETED = "Completed";
    public static final String LISTING_STATUS_ENDED = "Ended";
    public static final HashMap shippingRegions = setupShippingRegions();
    public boolean autoPay;
    public boolean availableForEbayNow;
    public boolean availableForPickupInStore;
    public int bestOfferCount;
    public String bsAdditionalContactInformation;
    public String bsCityName;
    public String bsCompanyName;
    public String bsCountryName;
    public boolean bsDetailsExists;
    public String bsEmail;
    public String bsFax;
    public String bsFirstName;
    public String bsLastName;
    public boolean bsLegalInvoice;
    public String bsName;
    public String bsPhone;
    public String bsPostalCode;
    public String bsStateOrProvince;
    public String bsStreet1;
    public String bsStreet2;
    public String bsTermsAndConditions;
    public String bsTradeRegistrationNumber;
    public String bsVatId;
    public double bsVatPercent;
    public String bsVatSite;
    public String bucksRewards;
    public float charityDonationPercent;
    public int charityId;
    public String charityLogoUrl;
    public String charityMission;
    public String charityName;
    public int charityNumber;
    public String charityStatus;
    public String conditionDescription;
    public String conditionDisplayName;
    public long conditionId;
    public ItemCurrency convertedStartPrice;
    public String country;
    public String coupons;
    public String description;
    public ItemCurrency dpiMinimumAdvertisedPrice;
    public String dpiMinimumAdvertisedPriceExposure;
    public boolean dpiSoldOffEbay;
    public boolean dpiSoldOnEbay;
    public boolean ebayPaymentProcessEnabled;
    public boolean eligibleForPickupInStore;
    public boolean embeddedMobileCheckoutEnabled;
    public ArrayList excludeShipToLocations;
    public String galleryUrl;
    public boolean globalShipping;
    public Integer handlingTime;
    public boolean hasReservePrice;
    public String highBidderUserId;
    public int hitCount;
    public boolean ignoreQuantity;
    public String internationalShippingDiscountName;
    public ArrayList internationalShippingDiscountProfiles;
    public boolean isBsRestrictedToBusiness;
    public boolean isLocalPickup;
    public List itemCompatibiltyList;
    public ArrayList itemSpecifics;
    public String listingDuration;
    public String listingStatus;
    public String listingType;
    public String location;
    public Integer lotSize;
    public ItemCurrency minimumToBid;
    public String nectarRewards;
    public ArrayList offers;
    public String paymentInstructions;
    public ArrayList paymentMethods;
    public ArrayList pictureUrls;
    public long primaryCategoryId;
    public String primaryCategoryIdPath;
    public String primaryCategoryName;
    public boolean privateListing;
    public String productDescription;
    public String productId;
    public String productIdType;
    public ProductListingDetails productListingDetails;
    public String productRefId;
    public Date promotionalSaleEndTime;
    public ItemCurrency promotionalSaleOriginalPrice;
    public Date promotionalSaleStartTime;
    public boolean promotionalShippingDiscount;
    public String psddDiscountName;
    public int psddItemCount;
    public ItemCurrency psddOrderAmount;
    public ItemCurrency psddShippingCost;
    public int quantity;
    public int quantitySold;
    public int quantitySoldByPickupInStore;
    public String relistedId;
    public boolean reserveMet;
    public Boolean rpAccepted;
    public String rpDescription;
    public String rpEAN;
    public String rpRefund;
    public String rpRestockingFee;
    public String rpReturnsAccepted;
    public String rpReturnsWithin;
    public String rpShippingCostPaidBy;
    public String rpWarrantyDuration;
    public String rpWarrantyOffered;
    public String rpWarrantyType;
    public String secondChanceOriginalItemId;
    public long secondaryCategoryId;
    public String secondaryCategoryIdPath;
    public String secondaryCategoryName;
    public String sellerFeedbackRatingStar;
    public int sellerFeedbackScore;
    public float sellerPositiveFeedbackPercent;
    public String sellerProductId;
    public ArrayList sellerShippingOptions;
    public String sellerUserId;
    public String sellerVacationNote;
    public ArrayList shipToLocations;
    public String shippingDiscountName;
    public ArrayList shippingDiscountProfiles;
    public String shippingType;
    public String site;
    public String sku;
    public boolean soldAsBin;
    public Date startDate;
    public ItemCurrency startPrice;
    public String subTitle;
    public boolean thirdPartyCheckout;
    public Duration timeLeft;
    public boolean topRatedListing;
    public ShipmentTracking tracking;
    public String unitPriceQuantity;
    public String unitPriceType;
    public ArrayList variationIds;
    public ArrayList variationPictureSets;
    public String variationPicturesSpecificName;
    public ArrayList variationSpecifics;
    public ArrayList variations;
    public String version;
    public String viewItemUrlForNaturalSearch;
    public int watchCount;
    public boolean watched;

    public EbayItem()
    {
        primaryCategoryId = -1L;
        secondaryCategoryId = -1L;
        shippingType = "NotSpecified";
        autoPay = false;
        shipToLocations = new ArrayList();
        excludeShipToLocations = new ArrayList();
        privateListing = false;
        minimumToBid = new ItemCurrency("USD", "0.0");
        reserveMet = true;
        hasReservePrice = false;
        shippingDiscountProfiles = new ArrayList();
        internationalShippingDiscountProfiles = new ArrayList();
        topRatedListing = false;
        variationIds = new ArrayList();
        itemSpecifics = new ArrayList();
        variations = new ArrayList();
        variationPictureSets = new ArrayList();
        variationSpecifics = new ArrayList();
        paymentMethods = new ArrayList();
        pictureUrls = new ArrayList();
        embeddedMobileCheckoutEnabled = true;
        globalShipping = false;
        bsDetailsExists = false;
        rpAccepted = null;
        offers = new ArrayList();
        charityId = 0;
        charityNumber = 0;
        charityDonationPercent = 0.0F;
        sellerShippingOptions = new ArrayList();
        itemCompatibiltyList = new ArrayList();
    }

    EbayItem(Parcel parcel)
    {
        super(parcel);
        primaryCategoryId = -1L;
        secondaryCategoryId = -1L;
        shippingType = "NotSpecified";
        autoPay = false;
        shipToLocations = new ArrayList();
        excludeShipToLocations = new ArrayList();
        privateListing = false;
        minimumToBid = new ItemCurrency("USD", "0.0");
        reserveMet = true;
        hasReservePrice = false;
        shippingDiscountProfiles = new ArrayList();
        internationalShippingDiscountProfiles = new ArrayList();
        topRatedListing = false;
        variationIds = new ArrayList();
        itemSpecifics = new ArrayList();
        variations = new ArrayList();
        variationPictureSets = new ArrayList();
        variationSpecifics = new ArrayList();
        paymentMethods = new ArrayList();
        pictureUrls = new ArrayList();
        embeddedMobileCheckoutEnabled = true;
        globalShipping = false;
        bsDetailsExists = false;
        rpAccepted = null;
        offers = new ArrayList();
        charityId = 0;
        charityNumber = 0;
        charityDonationPercent = 0.0F;
        sellerShippingOptions = new ArrayList();
        itemCompatibiltyList = new ArrayList();
        ClassLoader classloader = getClass().getClassLoader();
        listingType = parcel.readString();
        site = parcel.readString();
        subTitle = parcel.readString();
        primaryCategoryId = parcel.readLong();
        primaryCategoryIdPath = parcel.readString();
        primaryCategoryName = parcel.readString();
        secondaryCategoryId = parcel.readLong();
        secondaryCategoryIdPath = parcel.readString();
        secondaryCategoryName = parcel.readString();
        productId = parcel.readString();
        productIdType = parcel.readString();
        productDescription = parcel.readString();
        conditionId = parcel.readLong();
        parcel.readStringList(shipToLocations);
        parcel.readStringList(excludeShipToLocations);
        listingStatus = parcel.readString();
        sellerUserId = parcel.readString();
        conditionDisplayName = parcel.readString();
        conditionDescription = parcel.readString();
        shippingType = parcel.readString();
        int l;
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ebayPaymentProcessEnabled = flag;
        listingDuration = parcel.readString();
        variationIds = parcel.readArrayList(classloader);
        startPrice = (ItemCurrency)parcel.readParcelable(classloader);
        convertedStartPrice = (ItemCurrency)parcel.readParcelable(classloader);
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        autoPay = flag;
        highBidderUserId = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        privateListing = flag;
        hitCount = parcel.readInt();
        watchCount = parcel.readInt();
        minimumToBid = (ItemCurrency)parcel.readParcelable(classloader);
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        reserveMet = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasReservePrice = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        thirdPartyCheckout = flag;
        if (1 == parcel.readInt())
        {
            timeLeft = new Duration(parcel.readLong());
        }
        if (1 == parcel.readInt())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        watched = flag;
        relistedId = parcel.readString();
        shippingDiscountName = parcel.readString();
        l = parcel.readInt();
        for (int i = 0; i < l; i++)
        {
            ShippingDiscountProfile shippingdiscountprofile = new ShippingDiscountProfile();
            shippingdiscountprofile.readFromParcel(parcel, classloader);
            shippingDiscountProfiles.add(shippingdiscountprofile);
        }

        internationalShippingDiscountName = parcel.readString();
        l = parcel.readInt();
        for (int j = 0; j < l; j++)
        {
            ShippingDiscountProfile shippingdiscountprofile1 = new ShippingDiscountProfile();
            shippingdiscountprofile1.readFromParcel(parcel, classloader);
            internationalShippingDiscountProfiles.add(shippingdiscountprofile1);
        }

        Object obj;
        long l1;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        promotionalShippingDiscount = flag;
        psddDiscountName = parcel.readString();
        psddItemCount = parcel.readInt();
        psddOrderAmount = (ItemCurrency)parcel.readParcelable(classloader);
        psddShippingCost = (ItemCurrency)parcel.readParcelable(classloader);
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        topRatedListing = flag;
        description = parcel.readString();
        parcel.readStringList(variationIds);
        parcel.readTypedList(itemSpecifics, NameValue.CREATOR);
        parcel.readTypedList(variations, Variation.CREATOR);
        variationPicturesSpecificName = parcel.readString();
        parcel.readTypedList(variationPictureSets, VariationPictureSet.CREATOR);
        parcel.readTypedList(variationSpecifics, NameValue.CREATOR);
        l1 = parcel.readLong();
        if (l1 != -1L)
        {
            obj = new Date(l1);
        } else
        {
            obj = null;
        }
        startDate = ((Date) (obj));
        location = parcel.readString();
        parcel.readStringList(paymentMethods);
        galleryUrl = parcel.readString();
        parcel.readStringList(pictureUrls);
        quantity = parcel.readInt();
        quantitySold = parcel.readInt();
        viewItemUrlForNaturalSearch = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        embeddedMobileCheckoutEnabled = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        globalShipping = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bsDetailsExists = flag;
        bsAdditionalContactInformation = parcel.readString();
        bsCityName = parcel.readString();
        bsCompanyName = parcel.readString();
        bsFirstName = parcel.readString();
        bsLastName = parcel.readString();
        bsName = parcel.readString();
        bsPhone = parcel.readString();
        bsPostalCode = parcel.readString();
        bsStateOrProvince = parcel.readString();
        bsCountryName = parcel.readString();
        bsStreet1 = parcel.readString();
        bsStreet2 = parcel.readString();
        bsEmail = parcel.readString();
        bsFax = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bsLegalInvoice = flag;
        bsTermsAndConditions = parcel.readString();
        bsTradeRegistrationNumber = parcel.readString();
        bsVatId = parcel.readString();
        bsVatSite = parcel.readString();
        bsVatPercent = parcel.readDouble();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isBsRestrictedToBusiness = flag;
        rpDescription = parcel.readString();
        rpEAN = parcel.readString();
        rpRestockingFee = parcel.readString();
        rpRefund = parcel.readString();
        if (1 == parcel.readInt())
        {
            int k;
            int i1;
            if (parcel.readInt() == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            rpAccepted = Boolean.valueOf(flag);
        }
        rpReturnsAccepted = parcel.readString();
        rpReturnsWithin = parcel.readString();
        rpShippingCostPaidBy = parcel.readString();
        rpWarrantyDuration = parcel.readString();
        rpWarrantyOffered = parcel.readString();
        rpWarrantyType = parcel.readString();
        sellerFeedbackRatingStar = parcel.readString();
        sellerFeedbackScore = parcel.readInt();
        sellerPositiveFeedbackPercent = parcel.readFloat();
        dpiMinimumAdvertisedPrice = (ItemCurrency)parcel.readParcelable(classloader);
        dpiMinimumAdvertisedPriceExposure = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dpiSoldOffEbay = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dpiSoldOnEbay = flag;
        promotionalSaleOriginalPrice = (ItemCurrency)parcel.readParcelable(classloader);
        if (1 == parcel.readInt())
        {
            promotionalSaleStartTime = new Date(parcel.readLong());
        }
        if (1 == parcel.readInt())
        {
            promotionalSaleEndTime = new Date(parcel.readLong());
        }
        version = parcel.readString();
        country = parcel.readString();
        parcel.readTypedList(offers, BestOffer.CREATOR);
        if (1 == parcel.readInt())
        {
            obj = Integer.valueOf(parcel.readInt());
        } else
        {
            obj = null;
        }
        handlingTime = ((Integer) (obj));
        sellerVacationNote = parcel.readString();
        charityId = parcel.readInt();
        charityName = parcel.readString();
        charityNumber = parcel.readInt();
        charityDonationPercent = parcel.readFloat();
        charityLogoUrl = parcel.readString();
        charityMission = parcel.readString();
        charityStatus = parcel.readString();
        bucksRewards = parcel.readString();
        nectarRewards = parcel.readString();
        coupons = parcel.readString();
        secondChanceOriginalItemId = parcel.readString();
        parcel.readTypedList(sellerShippingOptions, ShippingCostsShippingOption.CREATOR);
        paymentInstructions = parcel.readString();
        bestOfferCount = parcel.readInt();
        i1 = parcel.readInt();
        itemCompatibiltyList.clear();
        for (k = 0; k < i1; k++)
        {
            obj = new ItemCompatibilty(parcel);
            itemCompatibiltyList.add(obj);
        }

        unitPriceType = parcel.readString();
        unitPriceQuantity = parcel.readString();
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eligibleForPickupInStore = flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        availableForPickupInStore = flag;
        sellerProductId = parcel.readString();
        quantitySoldByPickupInStore = parcel.readInt();
        sku = parcel.readString();
        if (parcel.readInt() == 1)
        {
            tracking = (ShipmentTracking)ShipmentTracking.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        availableForEbayNow = flag;
        if (parcel.readInt() == 1)
        {
            productListingDetails = (ProductListingDetails)ProductListingDetails.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        soldAsBin = flag;
        if (parcel.readInt() == 1)
        {
            lotSize = Integer.valueOf(parcel.readInt());
        }
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isLocalPickup = flag;
    }

    public static HashMap setupShippingRegions()
    {
        String as[] = new String[31];
        as[0] = "AI";
        as[1] = "AG";
        as[2] = "AW";
        as[3] = "BS";
        as[4] = "BB";
        as[5] = "BZ";
        as[6] = "VG";
        as[7] = "KY";
        as[8] = "CR";
        as[9] = "CU";
        as[10] = "DM";
        as[11] = "DO";
        as[12] = "SV";
        as[13] = "GD";
        as[14] = "GP";
        as[15] = "GT";
        as[16] = "HT";
        as[17] = "HN";
        as[18] = "JM";
        as[19] = "MQ";
        as[20] = "MS";
        as[21] = "AN";
        as[22] = "NI";
        as[23] = "PA";
        as[24] = "PR";
        as[25] = "KN";
        as[26] = "LC";
        as[27] = "VC";
        as[28] = "TT";
        as[29] = "TC";
        as[30] = "VI";
        String as1[] = new String[6];
        as1[0] = "BM";
        as1[1] = "CA";
        as1[2] = "GL";
        as1[3] = "MX";
        as1[4] = "PM";
        as1[5] = "US";
        String as2[] = new String[14];
        as2[0] = "AR";
        as2[1] = "BO";
        as2[2] = "BR";
        as2[3] = "CL";
        as2[4] = "CO";
        as2[5] = "EC";
        as2[6] = "FK";
        as2[7] = "GF";
        as2[8] = "GY";
        as2[9] = "PY";
        as2[10] = "PE";
        as2[11] = "SR";
        as2[12] = "UY";
        as2[13] = "VE";
        HashMap hashmap = new HashMap();
        hashmap.put("Africa", toSet(new String[][] {
            new String[] {
                "DZ", "AO", "BJ", "BW", "BF", "BI", "CM", "CV", "CF", "TD", 
                "KM", "CD", "CG", "CI", "DJ", "EG", "GQ", "ER", "ET", "GA", 
                "GM", "GH", "GN", "GW", "KE", "LS", "LR", "LY", "MG", "MW", 
                "ML", "MR", "MU", "YT", "MA", "MZ", "NA", "NE", "NG", "RE", 
                "RW", "SH", "SN", "SC", "SL", "SO", "ZA", "SD", "SZ", "TZ", 
                "TG", "TN", "UG", "EH", "ZM", "ZW"
            }
        }));
        hashmap.put("Asia", toSet(new String[][] {
            new String[] {
                "AF", "AM", "AZ", "BH", "BD", "BT", "BN", "KH", "CN", "GE", 
                "HK", "IN", "ID", "IQ", "IL", "JP", "JO", "KZ", "KR", "KW", 
                "KG", "LA", "LB", "MO", "MY", "MV", "MN", "NP", "OM", "PK", 
                "PH", "QA", "RU", "SA", "SG", "LK", "TW", "TJ", "TH", "TR", 
                "TM", "AE", "UZ", "VN", "YE"
            }
        }));
        hashmap.put("Carribean", toSet(new String[][] {
            as
        }));
        hashmap.put("Europe", toSet(new String[][] {
            new String[] {
                "AL", "AD", "AT", "BY", "BE", "BA", "BG", "HR", "CY", "CZ", 
                "DK", "EE", "FI", "FR", "DE", "GI", "GR", "HU", "IS", "IE", 
                "IT", "LV", "LI", "LT", "LU", "MK", "MT", "MD", "MC", "ME", 
                "NL", "NO", "PL", "PT", "RO", "RU", "SM", "RS", "SK", "SI", 
                "ES", "SJ", "SE", "CH", "UA", "GB", "VA"
            }
        }));
        hashmap.put("EuropeanUnion", toSet(new String[][] {
            new String[] {
                "AT", "BE", "BG", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", 
                "FR", "GB", "GR", "HU", "IE", "IT", "LT", "LU", "LV", "MT", 
                "NL", "PL", "PT", "RO", "SE", "SI", "SK"
            }
        }));
        hashmap.put("MiddleEast", toSet(new String[][] {
            new String[] {
                "BH", "IR", "IQ", "IL", "JO", "KW", "LB", "OM", "QA", "SA", 
                "SY", "TR", "AE", "YE"
            }
        }));
        hashmap.put("NorthAmerica", toSet(new String[][] {
            as1
        }));
        hashmap.put("Oceania", toSet(new String[][] {
            new String[] {
                "AS", "AU", "CK", "FJ", "PF", "GU", "KI", "MH", "FM", "NR", 
                "NC", "NZ", "NU", "PW", "PG", "SB", "TO", "TV", "VU", "WF", 
                "WS"
            }
        }));
        hashmap.put("SouthAmerica", toSet(new String[][] {
            as2
        }));
        hashmap.put("LatinAmerica", toSet(new String[][] {
            as, as2
        }));
        hashmap.put("Americas", toSet(new String[][] {
            as, as2, as1
        }));
        return hashmap;
    }

    private static transient HashSet toSet(String as[][])
    {
        HashSet hashset = new HashSet();
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            String as1[] = as[i];
            int l = as1.length;
            for (int j = 0; j < l; j++)
            {
                hashset.add(as1[j]);
            }

        }

        return hashset;
    }

    public long getAuctionTimeRemainingMs()
    {
        long l = 0L;
        if (endDate != null)
        {
            l = endDate.getTime() - EbayResponse.currentHostTime();
        }
        return l;
    }

    public ItemCurrency getBinPrice()
    {
        if (buyItNowPrice != null)
        {
            return buyItNowPrice;
        } else
        {
            return currentPrice;
        }
    }

    public ItemCurrency getConvertedBinPrice()
    {
        if (convertedBuyItNowPrice != null)
        {
            return convertedBuyItNowPrice;
        } else
        {
            return convertedCurrentPrice;
        }
    }

    public String getIdString()
    {
        return String.valueOf(id);
    }

    public List getItemSpecficByName(String s)
    {
        Object obj;
label0:
        {
            ArrayList arraylist = new ArrayList();
            obj = arraylist;
            if (TextUtils.isEmpty(s))
            {
                break label0;
            }
            Iterator iterator = itemSpecifics.iterator();
            do
            {
                obj = arraylist;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (NameValue)iterator.next();
            } while (!s.equals(((NameValue) (obj)).getName()));
            obj = ((NameValue) (obj)).getValues();
        }
        return ((List) (obj));
    }

    public boolean isActive()
    {
        return "Active".equals(listingStatus);
    }

    public boolean isBidOnly()
    {
        return isListingTypeBid() && !isListingTypeBin();
    }

    public boolean isBidWithBinAvailable()
    {
        return isListingTypeBid() && buyItNowAvailable;
    }

    public boolean isBinOnly()
    {
        return isListingTypeBin() && !isBidWithBinAvailable();
    }

    public boolean isListingTypeBid()
    {
        return "Chinese".equals(listingType) || "Auction".equals(listingType);
    }

    public boolean isListingTypeBin()
    {
        return "FixedPriceItem".equals(listingType) || "StoresFixedPrice".equals(listingType) || "AuctionWithBIN".equals(listingType) || "FixedPrice".equals(listingType) || "StoreInventory".equals(listingType) || "PersonalOffer".equals(listingType);
    }

    public boolean isLocalPickupOnly()
    {
        return 1 == shipToLocations.size() && "None".equals(shipToLocations.get(0));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        super.writeToParcel(parcel, i);
        parcel.writeString(listingType);
        parcel.writeString(site);
        parcel.writeString(subTitle);
        parcel.writeLong(primaryCategoryId);
        parcel.writeString(primaryCategoryIdPath);
        parcel.writeString(primaryCategoryName);
        parcel.writeLong(secondaryCategoryId);
        parcel.writeString(secondaryCategoryIdPath);
        parcel.writeString(secondaryCategoryName);
        parcel.writeString(productId);
        parcel.writeString(productIdType);
        parcel.writeString(productDescription);
        parcel.writeLong(conditionId);
        parcel.writeStringList(shipToLocations);
        parcel.writeStringList(excludeShipToLocations);
        parcel.writeString(listingStatus);
        parcel.writeString(sellerUserId);
        parcel.writeString(conditionDisplayName);
        parcel.writeString(conditionDescription);
        parcel.writeString(shippingType);
        int j;
        if (ebayPaymentProcessEnabled)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(listingDuration);
        parcel.writeList(variationIds);
        parcel.writeParcelable(startPrice, i);
        parcel.writeParcelable(convertedStartPrice, i);
        if (autoPay)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(highBidderUserId);
        if (privateListing)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeInt(hitCount);
        parcel.writeInt(watchCount);
        parcel.writeParcelable(minimumToBid, 0);
        if (reserveMet)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (hasReservePrice)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (thirdPartyCheckout)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (timeLeft != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (timeLeft != null)
        {
            parcel.writeLong(timeLeft.timeInSeconds);
        }
        if (watched)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(relistedId);
        parcel.writeString(shippingDiscountName);
        parcel.writeInt(shippingDiscountProfiles.size());
        for (Iterator iterator = shippingDiscountProfiles.iterator(); iterator.hasNext(); ((ShippingDiscountProfile)iterator.next()).writeToParcel(parcel, i)) { }
        parcel.writeString(internationalShippingDiscountName);
        parcel.writeInt(internationalShippingDiscountProfiles.size());
        for (Iterator iterator1 = internationalShippingDiscountProfiles.iterator(); iterator1.hasNext(); ((ShippingDiscountProfile)iterator1.next()).writeToParcel(parcel, i)) { }
        long l;
        if (promotionalShippingDiscount)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(psddDiscountName);
        parcel.writeInt(psddItemCount);
        parcel.writeParcelable(psddOrderAmount, i);
        parcel.writeParcelable(psddShippingCost, i);
        if (topRatedListing)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(description);
        parcel.writeStringList(variationIds);
        parcel.writeTypedList(itemSpecifics);
        parcel.writeTypedList(variations);
        parcel.writeString(variationPicturesSpecificName);
        parcel.writeTypedList(variationPictureSets);
        parcel.writeTypedList(variationSpecifics);
        if (startDate == null)
        {
            l = -1L;
        } else
        {
            l = startDate.getTime();
        }
        parcel.writeLong(l);
        parcel.writeString(location);
        parcel.writeStringList(paymentMethods);
        parcel.writeString(galleryUrl);
        parcel.writeStringList(pictureUrls);
        parcel.writeInt(quantity);
        parcel.writeInt(quantitySold);
        parcel.writeString(viewItemUrlForNaturalSearch);
        if (embeddedMobileCheckoutEnabled)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (globalShipping)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (bsDetailsExists)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(bsAdditionalContactInformation);
        parcel.writeString(bsCityName);
        parcel.writeString(bsCompanyName);
        parcel.writeString(bsFirstName);
        parcel.writeString(bsLastName);
        parcel.writeString(bsName);
        parcel.writeString(bsPhone);
        parcel.writeString(bsPostalCode);
        parcel.writeString(bsStateOrProvince);
        parcel.writeString(bsCountryName);
        parcel.writeString(bsStreet1);
        parcel.writeString(bsStreet2);
        parcel.writeString(bsEmail);
        parcel.writeString(bsFax);
        if (bsLegalInvoice)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(bsTermsAndConditions);
        parcel.writeString(bsTradeRegistrationNumber);
        parcel.writeString(bsVatId);
        parcel.writeString(bsVatSite);
        parcel.writeDouble(bsVatPercent);
        if (isBsRestrictedToBusiness)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(rpDescription);
        parcel.writeString(rpEAN);
        parcel.writeString(rpRestockingFee);
        parcel.writeString(rpRefund);
        if (rpAccepted != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (rpAccepted != null)
        {
            Iterator iterator2;
            if (rpAccepted.booleanValue())
            {
                j = 1;
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
        }
        parcel.writeString(rpReturnsAccepted);
        parcel.writeString(rpReturnsWithin);
        parcel.writeString(rpShippingCostPaidBy);
        parcel.writeString(rpWarrantyDuration);
        parcel.writeString(rpWarrantyOffered);
        parcel.writeString(rpWarrantyType);
        parcel.writeString(sellerFeedbackRatingStar);
        parcel.writeInt(sellerFeedbackScore);
        parcel.writeFloat(sellerPositiveFeedbackPercent);
        parcel.writeParcelable(dpiMinimumAdvertisedPrice, i);
        parcel.writeString(dpiMinimumAdvertisedPriceExposure);
        if (dpiSoldOffEbay)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (dpiSoldOnEbay)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeParcelable(promotionalSaleOriginalPrice, i);
        if (promotionalSaleStartTime != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (promotionalSaleStartTime != null)
        {
            parcel.writeLong(promotionalSaleStartTime.getTime());
        }
        if (promotionalSaleEndTime != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (promotionalSaleEndTime != null)
        {
            parcel.writeLong(promotionalSaleEndTime.getTime());
        }
        parcel.writeString(version);
        parcel.writeString(country);
        parcel.writeTypedList(offers);
        if (handlingTime != null)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (handlingTime != null)
        {
            parcel.writeInt(handlingTime.intValue());
        }
        parcel.writeString(sellerVacationNote);
        parcel.writeInt(charityId);
        parcel.writeString(charityName);
        parcel.writeInt(charityNumber);
        parcel.writeFloat(charityDonationPercent);
        parcel.writeString(charityLogoUrl);
        parcel.writeString(charityMission);
        parcel.writeString(charityStatus);
        parcel.writeString(bucksRewards);
        parcel.writeString(nectarRewards);
        parcel.writeString(coupons);
        parcel.writeString(secondChanceOriginalItemId);
        parcel.writeTypedList(sellerShippingOptions);
        parcel.writeString(paymentInstructions);
        parcel.writeInt(bestOfferCount);
        parcel.writeInt(itemCompatibiltyList.size());
        for (iterator2 = itemCompatibiltyList.iterator(); iterator2.hasNext(); ((ItemCompatibilty)iterator2.next()).writeToParcel(parcel, i)) { }
        parcel.writeString(unitPriceType);
        parcel.writeString(unitPriceQuantity);
        if (eligibleForPickupInStore)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (availableForPickupInStore)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        parcel.writeString(sellerProductId);
        parcel.writeInt(quantitySoldByPickupInStore);
        parcel.writeString(sku);
        if (tracking == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeInt(j);
        if (tracking != null)
        {
            tracking.writeToParcel(parcel, i);
        }
        if (availableForEbayNow)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeInt(j);
        if (productListingDetails == null)
        {
            j = 0;
        } else
        {
            j = 1;
        }
        parcel.writeInt(j);
        if (productListingDetails != null)
        {
            productListingDetails.writeToParcel(parcel, i);
        }
        if (soldAsBin)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (lotSize != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (lotSize != null)
        {
            parcel.writeInt(lotSize.intValue());
        }
        if (isLocalPickup)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }

}
