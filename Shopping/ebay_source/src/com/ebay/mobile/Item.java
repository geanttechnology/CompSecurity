// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import com.ebay.common.CurrencyConversionCache;
import com.ebay.common.Preferences;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.UserDispute;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.model.inventory.InventoryInfo;
import com.ebay.common.model.local.AvailabilityIdentifier;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.viewitem.ViewItemDataManager;
import com.ebay.mobile.viewitem.ViewItemShippingInfo;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.BaseItem;
import com.ebay.nautilus.domain.data.BestOffer;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EnergyEfficiencyRating;
import com.ebay.nautilus.domain.data.ItemCompatibilty;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.ItemWeight;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.data.ProductListingDetails;
import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.mobile:
//            MyApp, Vehicle, ItemViewPayPalable

public class Item extends BaseItem
{
    public static class BidBounds
    {

        public boolean allowLowerBound;
        public CurrencyAmount lowerBound;

        public BidBounds()
        {
            this(new CurrencyAmount(0.0D, "USD"), true);
        }

        public BidBounds(CurrencyAmount currencyamount, boolean flag)
        {
            lowerBound = currencyamount;
            allowLowerBound = flag;
        }
    }

    public static final class PaidStatus extends Enum
    {

        private static final PaidStatus $VALUES[];
        public static final PaidStatus NOT_PAID;
        public static final PaidStatus PAID;
        public static final PaidStatus PENDING;
        public static final PaidStatus REFUNDED;
        public static final PaidStatus UNKNOWN;

        public static PaidStatus valueOf(String s)
        {
            return (PaidStatus)Enum.valueOf(com/ebay/mobile/Item$PaidStatus, s);
        }

        public static PaidStatus[] values()
        {
            return (PaidStatus[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new PaidStatus("UNKNOWN", 0);
            PAID = new PaidStatus("PAID", 1);
            NOT_PAID = new PaidStatus("NOT_PAID", 2);
            PENDING = new PaidStatus("PENDING", 3);
            REFUNDED = new PaidStatus("REFUNDED", 4);
            $VALUES = (new PaidStatus[] {
                UNKNOWN, PAID, NOT_PAID, PENDING, REFUNDED
            });
        }

        private PaidStatus(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PaymentReminderState extends Enum
    {

        private static final PaymentReminderState $VALUES[];
        public static final PaymentReminderState STATE_DISABLED;
        public static final PaymentReminderState STATE_ENABLED;
        public static final PaymentReminderState STATE_SENT;

        public static PaymentReminderState valueOf(String s)
        {
            return (PaymentReminderState)Enum.valueOf(com/ebay/mobile/Item$PaymentReminderState, s);
        }

        public static PaymentReminderState[] values()
        {
            return (PaymentReminderState[])$VALUES.clone();
        }

        static 
        {
            STATE_DISABLED = new PaymentReminderState("STATE_DISABLED", 0);
            STATE_ENABLED = new PaymentReminderState("STATE_ENABLED", 1);
            STATE_SENT = new PaymentReminderState("STATE_SENT", 2);
            $VALUES = (new PaymentReminderState[] {
                STATE_DISABLED, STATE_ENABLED, STATE_SENT
            });
        }

        private PaymentReminderState(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ShippingDiscountProfile extends BaseDataMapped
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ShippingDiscountProfile createFromParcel(Parcel parcel)
            {
                return (ShippingDiscountProfile)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/Item$ShippingDiscountProfile);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ShippingDiscountProfile[] newArray(int i)
            {
                return new ShippingDiscountProfile[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public ItemCurrency eachAdditionalAmount;
        public ItemCurrency eachAdditionalAmountOff;
        public Float eachAdditionalPercentOff;
        public String id;
        public String mappedId;
        public String name;
        public ItemWeight weightOff;


        public ShippingDiscountProfile()
        {
        }
    }


    public static final String BUSINESS_TYPE_COMMERCIAL = "Commercial";
    public static final String BUSINESS_TYPE_PRIVATE = "Private";
    public static final String CATEGORY_CARS_TRUCKS = "6001";
    public static final String CATEGORY_MOTORCYCLES = "6024";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Item createFromParcel(Parcel parcel)
        {
            return (Item)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/Item);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Item[] newArray(int i)
        {
            return new Item[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String ITEM_SPECIFIC_DEPOSIT_AMOUNT = "Deposit amount";
    public static final String LISTING_STATUS_COMPLETED = "Completed";
    public static final String LISTING_STATUS_ENDED = "Ended";
    public static final String US_PROTECTORATES = "US Protectorates";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Item", 3, "Items");
    private static String mskuNotSelectedStrings[];
    public static final HashMap shippingRegions = setupShippingRegions();
    public boolean addToRecentlyViewed;
    public AllBiddersData allBidders;
    public boolean autoPay;
    public boolean availableForEbayNow;
    public boolean availableForPickupAndDropoff;
    public boolean availableForPickupInStore;
    public String availablePaymentMethods;
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
    public String bsVatSite;
    public String bucksRewards;
    public String buyerAddress;
    public String buyerCountryCode;
    public String buyerLocation;
    public PostalCodeSpecification buyerPostalCodeSpec;
    public boolean buyerResponsibleForLogistics;
    public String buyingOptionsVerbiage;
    public String cartCountry;
    public com.ebay.nautilus.domain.net.api.viewlisting.Listing.CharityTerms charity;
    public String conditionDescription;
    public String conditionDisplayName;
    public long conditionId;
    public ItemCurrency convertedStartPrice;
    public String country;
    public String countryCode;
    public String coupons;
    public ItemCurrency depositAmount;
    public String depositAmountString;
    public String description;
    public String displayBuyerResponsibleForLogistics;
    public String displayCurrentPrice;
    public String displayCurrentPriceConverted;
    public String displayEbayPlusItemCard;
    public String displayEbayPlusItemCardWithEndTime;
    public String displayEbayPlusSignupDescription;
    public String displayHotnessCharityKeyString;
    public String displayHotnessCharityValueString;
    public String displayPrice;
    public int displayPriceColor;
    public String displayPriceConverted;
    public ItemCurrency displayPriceConvertedCurrency;
    public ItemCurrency displayPriceCurrency;
    public String displayPriceImportCharges;
    public String displayPriceImportChargesConverted;
    public ItemCurrency displayPriceImportChargesCurrency;
    public String displayPriceOriginal;
    public String displayPriceOriginalConverted;
    public ItemCurrency displayPriceOriginalConvertedCurrency;
    public ItemCurrency displayPriceOriginalCurrency;
    public String displayPricePerUnit;
    public String displayPricePerUnitConverted;
    public String displayPricePercentOff;
    public String displayPriceShipping;
    public String displayPriceShippingConverted;
    public ItemCurrency displayPriceShippingConvertedCurrency;
    public String displayPriceShippingConvertedRaw;
    public ItemCurrency displayPriceShippingCurrency;
    public String displayPriceShippingRaw;
    public String displayPriceShippingTerse;
    public String displayShippingAmountConvertedItemCard;
    public String displayShippingAmountItemCard;
    public String displayShippingEstimateItemCard;
    public String displayShippingLabelItemCard;
    public ItemCurrency dpiMinimumAdvertisedPrice;
    public String dpiMinimumAdvertisedPriceExposure;
    public boolean dpiSoldOffEbay;
    public boolean dpiSoldOnEbay;
    public Date eBayPlusOrderTodayEndTime;
    public ShippingCostsShippingOption eBayPlusShippingOption;
    public boolean ebayPaymentProcessEnabled;
    public boolean eligibleForPickupInStore;
    public boolean embeddedMobileCheckoutEnabled;
    public String endItemEarlyUrl;
    public List excludeShipToLocations;
    public List excludeShipToRegions;
    public String fastAndFreeText;
    public boolean feedbackLeft;
    public boolean finalized;
    public String freightErrorMessage;
    public String galleryUrl;
    public boolean globalShipping;
    public String gspTermsAndConditionsUrl;
    public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration handlingTime;
    public boolean hasReservePrice;
    public String highBidderUserId;
    public int hitCount;
    public Date holidayReturnsDate;
    public long hotnessEndTime;
    public ItemCurrency hotnessMeanPrice;
    public ItemCurrency hotnessMeanPriceConverted;
    public Integer hotnessQuantityCount;
    public long hotnessTimeLeft;
    public ItemTransaction iTransaction;
    public String idForDraftSource;
    public boolean ignoreQuantity;
    public ItemCurrency importCharges;
    public ItemCurrency importChargesConverted;
    public boolean inCart;
    public String internationalShippingDiscountName;
    public ArrayList internationalShippingDiscountProfiles;
    public InventoryInfo inventoryInfo;
    public boolean isActive;
    public boolean isAuctionEnded;
    public boolean isAutopayUnavailable;
    public boolean isAvailableForPickupAndDropoff;
    public boolean isAvailableForPickupInStore;
    public boolean isBidOnly;
    public boolean isBidWithBin;
    public boolean isBinOnly;
    public boolean isBopisable;
    public boolean isBopisableAndPurchasedViaBopis;
    public boolean isBsRestrictedToBusiness;
    public boolean isBuyable;
    public boolean isBuyerProtectionEligible;
    public boolean isCartable;
    public boolean isDelivered;
    public boolean isDisplayPriceCurrencyCode;
    public boolean isEbayNowAvailable;
    public boolean isEbayPlusEligible;
    public boolean isEbayPlusInWindow;
    public boolean isEbayPlusLogoShown;
    public boolean isEbayPlusMember;
    public boolean isEbnOnly;
    public boolean isFreight;
    public boolean isFreightButExcluded;
    public boolean isGTC;
    public boolean isGspItem;
    public boolean isHandlingTimeSameDayAvailable;
    public boolean isHideTimeLeft;
    public boolean isHolidayReturns;
    public boolean isHotnessAlmostGone;
    public boolean isHotnessAutoIdentified;
    public boolean isHotnessCharity;
    public boolean isHotnessCharityAll;
    public boolean isHotnessCountdownUrgency;
    public boolean isHotnessDealTimer;
    public boolean isHotnessLastOne;
    public boolean isHotnessOverXSold;
    public boolean isHotnessQuantitySoldOneHour;
    public boolean isHotnessQuantitySoldTotal;
    public boolean isHotnessQuantitySoldTwentyFourHours;
    public boolean isInventoryCallFail;
    public boolean isIspuOnly;
    public boolean isListingCartable;
    public boolean isListingTypeBid;
    public boolean isListingTypeBin;
    public boolean isLiveAuction;
    public boolean isLocalOptionsOnly;
    public boolean isLocalPickup;
    public boolean isLocalPickupOnly;
    public boolean isMap;
    public boolean isMotors;
    public boolean isMotorsVehicle;
    public boolean isMultiSku;
    public boolean isMultiSkuSelectable;
    public boolean isOutbid;
    public boolean isPaid;
    public boolean isPartOfOrder;
    public boolean isPaymentReminderActivationTimeElaspsed;
    public boolean isProductReviewsAvailable;
    public boolean isPudoable;
    public boolean isPudoableAndPurchasedViaPudo;
    public boolean isRefunded;
    public boolean isReserveMet;
    public boolean isReturnsAccepted;
    public boolean isReturnsNotAccepted;
    public boolean isSalesTaxAppliedToShipping;
    public boolean isScheduled;
    public boolean isSeller;
    public boolean isSellerAcceptsPayPal;
    public boolean isSellerRequirePayPal;
    public boolean isSellingSupported;
    public boolean isShipToFundItem;
    public boolean isShipped;
    public boolean isShipsToUser;
    public boolean isShowAddToCart;
    public boolean isShowBidAmount;
    public boolean isShowBuyAnother;
    public boolean isShowBuyItNow;
    public boolean isShowBuyingOptions;
    public boolean isShowConditionDescription;
    public boolean isShowCreateShippingLabel;
    public boolean isShowEbayNow;
    public boolean isShowEbayPlusPromo;
    public boolean isShowEndItem;
    public boolean isShowEnterTrackingNumber;
    public boolean isShowFastAndFree;
    public boolean isShowIncreaseBid;
    public boolean isShowItemCard;
    public boolean isShowItemCardSingle;
    public boolean isShowLeaveFeedback;
    public boolean isShowMakeOffer;
    public boolean isShowMarkAsPaid;
    public boolean isShowMarkAsShipped;
    public boolean isShowMarkAsUnPaid;
    public boolean isShowMarkAsUnShipped;
    public boolean isShowPayNow;
    public boolean isShowPaymentOptions;
    public boolean isShowPaymentReminder;
    public boolean isShowPlaceBid;
    public boolean isShowRelist;
    public boolean isShowReviewBid;
    public boolean isShowRevise;
    public boolean isShowSellLike;
    public boolean isShowSellSimilar;
    public boolean isShowSellerVacationNote;
    public boolean isShowShare;
    public boolean isShowSimilar;
    public boolean isShowTitleBidFlow;
    public boolean isShowTopRatedListing;
    public boolean isShowTrackPackage;
    public boolean isShowUnwatch;
    public boolean isShowViewInCart;
    public boolean isShowViewRelistedItem;
    public boolean isShowWatch;
    public boolean isSmeOfferAvailable;
    public boolean isStp;
    public boolean isStpButMarkdown;
    public boolean isTotalAmountRefunded;
    public boolean isTransacted;
    public boolean isTransactedAsBin;
    public boolean isTransactedViaEbn;
    public boolean isUserConsentRequired;
    public boolean isUserHighBidder;
    public boolean isVatIncludedInPrice;
    public boolean isWorldwideShipping;
    public List itemCompatibiltyList;
    public ArrayList itemSpecifics;
    public String listingDuration;
    public String listingStatus;
    public String listingType;
    public Locale locale;
    public String location;
    public Integer lotSize;
    public ItemCurrency maxVariationPrice;
    public ItemCurrency maxVariationPriceConverted;
    public ItemCurrency minVariationPrice;
    public ItemCurrency minVariationPriceConverted;
    public BidBounds minimumToBid;
    public ArrayList mskuSelections;
    public String nectarRewards;
    public ArrayList offers;
    public String orderId;
    public String paidStatus;
    public String paymentInstructions;
    public ArrayList paymentMethods;
    public String paymentReminderSentDate;
    public PaymentReminderState paymentReminderState;
    public ArrayList pictureUrls;
    public List pictureZoomIds;
    public List powerBidValues;
    public long primaryCategoryId;
    public String primaryCategoryIdPath;
    public String primaryCategoryName;
    public boolean privateListing;
    public String productDescription;
    public EnergyEfficiencyRating productEnergyEfficiencyRating;
    public String productId;
    public String productIdType;
    public ProductListingDetails productListingDetails;
    public String productRefId;
    public float productReviewAverageRating;
    public long productReviewCount;
    public String productReviewSubjectReferenceId;
    public Date promotionalSaleEndTime;
    public ItemCurrency promotionalSaleOriginalPrice;
    public Date promotionalSaleStartTime;
    public boolean promotionalShippingDiscount;
    public String promotionalShippingDiscountDesc;
    public String psddDiscountName;
    public int psddItemCount;
    public ItemCurrency psddOrderAmount;
    public ItemCurrency psddShippingCost;
    public int quantity;
    public com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAvailableHint quantityAvailableHint;
    public Integer quantityAvailableThreshold;
    public int quantityPurchased;
    public int quantitySold;
    public String relistedId;
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
    public String salesTaxPercent;
    public String secondChanceOriginalItemId;
    public long secondaryCategoryId;
    public String secondaryCategoryIdPath;
    public String secondaryCategoryName;
    public String sellerAvatarUrl;
    public String sellerFeedbackRatingStar;
    public int sellerFeedbackScore;
    public float sellerPositiveFeedbackPercent;
    public String sellerProductId;
    public ArrayList sellerShippingOptions;
    public String sellerUserId;
    public String sellerVacationNote;
    public List shipToLocations;
    public List shipToRegions;
    public PostalCodeSpecification shippingCostsPostalCode;
    public String shippingDiscountDesc;
    public String shippingDiscountName;
    public ArrayList shippingDiscountProfiles;
    public ViewItemShippingInfo shippingInfo;
    public ViewItemShippingInfo shippingInfoUpdated;
    public String shippingType;
    public String shortDescription;
    public String site;
    public String sku;
    public String smeOfferId;
    public String smeOfferMsg;
    public String smeOfferType;
    public String smeSellerName;
    public Date startDate;
    public ItemCurrency startPrice;
    public int storesWithItem;
    public String stpSavingsWasLabel;
    public com.ebay.nautilus.domain.data.BaseCommonType.Text subTitle;
    public boolean thirdPartyCheckout;
    public URL thumbnailImage;
    public Duration timeLeft;
    public boolean topRatedListing;
    public boolean topRatedSeller;
    public ShipmentTracking tracking;
    public String user;
    public List userDisputes;
    public ArrayList variationIds;
    public ArrayList variationPictureSets;
    public String variationPicturesSpecificName;
    public ArrayList variationSpecifics;
    public ArrayList variations;
    public ArrayList vehicles;
    public String version;
    public String viewItemUrlForNaturalSearch;
    public String vin;
    public String vlsResponseTrackingCorrelationId;
    public String vlsResponseTrackingData;
    public int watchCount;
    public boolean watched;
    public int year;

    public Item()
    {
        primaryCategoryId = -1L;
        secondaryCategoryId = -1L;
        shippingType = "NotSpecified";
        autoPay = false;
        shipToLocations = new ArrayList();
        excludeShipToLocations = new ArrayList();
        shipToRegions = new ArrayList();
        excludeShipToRegions = new ArrayList();
        privateListing = false;
        minimumToBid = new BidBounds();
        isReserveMet = true;
        hasReservePrice = false;
        shippingDiscountProfiles = new ArrayList();
        internationalShippingDiscountProfiles = new ArrayList();
        topRatedListing = false;
        topRatedSeller = false;
        variationIds = new ArrayList();
        itemSpecifics = new ArrayList();
        variations = new ArrayList();
        variationPictureSets = new ArrayList();
        variationSpecifics = new ArrayList();
        paymentMethods = new ArrayList();
        pictureUrls = new ArrayList();
        pictureZoomIds = new ArrayList();
        embeddedMobileCheckoutEnabled = true;
        globalShipping = false;
        bsDetailsExists = false;
        rpAccepted = null;
        offers = new ArrayList();
        sellerShippingOptions = new ArrayList();
        itemCompatibiltyList = new ArrayList();
        quantityAvailableHint = com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAvailableHint.NONE;
        quantityAvailableThreshold = Integer.valueOf(10);
        iTransaction = null;
        feedbackLeft = false;
        paidStatus = null;
        finalized = false;
        allBidders = null;
        userDisputes = new ArrayList();
        inCart = false;
        storesWithItem = -1;
        isSmeOfferAvailable = false;
        isHotnessCountdownUrgency = false;
        isHotnessAlmostGone = false;
        isHotnessLastOne = false;
        isHotnessQuantitySoldOneHour = false;
        isHotnessQuantitySoldTwentyFourHours = false;
        isHotnessQuantitySoldTotal = false;
        isHotnessDealTimer = false;
        isHotnessOverXSold = false;
        isHotnessAutoIdentified = false;
        isHotnessCharity = false;
        isHotnessCharityAll = false;
        isProductReviewsAvailable = false;
        productReviewCount = 0L;
        productReviewAverageRating = 0.0F;
        isGTC = false;
        addToRecentlyViewed = false;
        vehicles = new ArrayList();
        mskuSelections = new ArrayList();
        isTransactedAsBin = false;
        paymentReminderState = PaymentReminderState.STATE_DISABLED;
        paymentReminderSentDate = "";
        isBuyerProtectionEligible = false;
        isListingCartable = false;
        isUserConsentRequired = false;
        isLiveAuction = false;
        isEbayPlusMember = false;
        isEbayPlusEligible = false;
        isShowEbayPlusPromo = false;
        shippingInfo = new ViewItemShippingInfo();
    }

    private String addBsfVat(Resources resources, ItemCurrency itemcurrency, int i)
    {
        String s = EbayCurrencyUtil.formatDisplay(itemcurrency, i);
        itemcurrency = s;
        if (isVatIncluded())
        {
            itemcurrency = resources.getString(0x7f07047e, new Object[] {
                s
            });
        }
        return itemcurrency;
    }

    private void buildConvertedRangePrice(Context context, ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        if (itemcurrency != null && itemcurrency1 != null)
        {
            int i = getCurrencyUtilFlag();
            displayPriceConverted = context.getString(0x7f070638, new Object[] {
                EbayCurrencyUtil.formatDisplay(itemcurrency, i), EbayCurrencyUtil.formatDisplay(itemcurrency1, i)
            });
        }
    }

    public static void clearNotSelectedStrings(Context context)
    {
        mskuNotSelectedStrings = null;
        getNotSelectedStrings(context);
    }

    public static int computeDisplayPriceColor(Item item, int i, com.ebay.common.ConstantsCommon.ItemKind itemkind, boolean flag)
    {
        return i;
    }

    public static ItemCurrency convertCurrency(EbayContext ebaycontext, ItemCurrency itemcurrency)
    {
        return convertCurrency(ebaycontext, itemcurrency, null);
    }

    public static ItemCurrency convertCurrency(EbayContext ebaycontext, ItemCurrency itemcurrency, CurrencyConversionRate currencyconversionrate)
    {
        ItemCurrency itemcurrency1 = null;
        if (itemcurrency != null)
        {
            itemcurrency1 = getCachedCurrencyPrice(ebaycontext, itemcurrency, currencyconversionrate);
        }
        return itemcurrency1;
    }

    public static String convertDepositAmountToString(Item item)
    {
        Object obj = Util.makeCommaDelimitedString(item.getItemSpecficByName("Deposit amount"));
        String s = ((String) (obj));
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj = new CurrencyAmount(((String) (obj)), item.currentPrice.code);
            s = EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), 0);
            item.depositAmount = ((CurrencyAmount) (obj)).toItemCurrency();
        }
        return s;
    }

    public static SpannableStringBuilder getApproximateString(Context context, ItemCurrency itemcurrency)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (itemcurrency != null)
        {
            spannablestringbuilder.append(context.getString(0x7f070170, new Object[] {
                EbayCurrencyUtil.formatDisplay(itemcurrency, 1)
            }));
        }
        return spannablestringbuilder;
    }

    public static AvailabilityIdentifier getAvailabilityId(Item item, ViewItemViewData viewitemviewdata)
    {
        Object obj1 = null;
        String s;
        String s1;
        Object obj;
        if (!TextUtils.isEmpty(viewitemviewdata.searchRefinedPostalCode))
        {
            s = MyApp.getPrefs().getCurrentCountry().getCountryCode();
            s1 = viewitemviewdata.searchRefinedPostalCode;
        } else
        if (MyApp.getPrefs().isSignedIn())
        {
            s = MyApp.getPrefs().getPostalCode().countryCode;
            s1 = MyApp.getPrefs().getPostalCode().postalCode;
        } else
        {
            s = null;
            s1 = null;
        }
        obj = obj1;
        if (!TextUtils.isEmpty(s))
        {
            obj = obj1;
            if (!TextUtils.isEmpty(s1))
            {
                obj = item.sellerUserId;
                if (item.isMultiSku)
                {
                    item = item.getVariationSKU(viewitemviewdata.nameValueList);
                } else
                {
                    item = item.sku;
                }
                obj = new AvailabilityIdentifier(s, s1, ((String) (obj)), item);
            }
        }
        return ((AvailabilityIdentifier) (obj));
    }

    private String getBinPriceString(EbayContext ebaycontext, ViewItemViewData viewitemviewdata)
    {
        ItemCurrency itemcurrency;
        Object obj;
        Object obj1;
        Object obj2;
        Context context;
        obj2 = null;
        obj1 = null;
        context = (Context)ebaycontext.getExtension(android/content/Context);
        itemcurrency = obj2;
        obj = obj1;
        if (isTransacted) goto _L2; else goto _L1
_L1:
        if (!isMultiSku) goto _L4; else goto _L3
_L3:
        itemcurrency = getMinVariationPrice(mskuSelections);
        obj = getMaxVariationPrice(mskuSelections);
_L2:
        if (obj == null || itemcurrency.equals(obj))
        {
            obj = new SpannableStringBuilder();
            if (computeDisplayPrice(context.getResources(), ((SpannableStringBuilder) (obj)), itemcurrency, null, null, null, true, computeDisplayPriceColor(this, -1, null, isBidWithBin), true, null, null))
            {
                if (promotionalSaleOriginalPrice != null)
                {
                    showSavings(context, viewitemviewdata, convertCurrency(ebaycontext, promotionalSaleOriginalPrice), convertedCurrentPrice);
                }
                return ((SpannableStringBuilder) (obj)).toString();
            } else
            {
                return "";
            }
        } else
        {
            ebaycontext = new SpannableStringBuilder();
            computeDisplayPrice(context.getResources(), ebaycontext, itemcurrency, ((ItemCurrency) (obj)), null, null, true, computeDisplayPriceColor(this, -1, null, false), true, null, null);
            return ebaycontext.toString();
        }
_L4:
        if (isListingTypeBin) goto _L6; else goto _L5
_L5:
        itemcurrency = obj2;
        obj = obj1;
        if (!isBidWithBin) goto _L2; else goto _L6
_L6:
        if (buyItNowPrice != null)
        {
            itemcurrency = buyItNowPrice;
        } else
        {
            itemcurrency = currentPrice;
        }
        obj = obj1;
          goto _L2
    }

    public static ItemCurrency getCachedCurrencyPrice(EbayContext ebaycontext, ItemCurrency itemcurrency, CurrencyConversionRate currencyconversionrate)
    {
        if (itemcurrency != null)
        {
            CurrencyConversionRate currencyconversionrate1 = currencyconversionrate;
            if (currencyconversionrate == null)
            {
                currencyconversionrate1 = CurrencyConversionCache.getConversionRate(ebaycontext, itemcurrency.code);
            }
            if (currencyconversionrate1 != null && currencyconversionrate1.isExchangeRateAvailable)
            {
                ebaycontext = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
                return (new CurrencyAmount(itemcurrency.value, ebaycontext)).multiplyBy(currencyconversionrate1.conversionFactor).toItemCurrency();
            }
        }
        return null;
    }

    private ItemCurrency getCurrentPrice(EbayContext ebaycontext, ViewItemViewData viewitemviewdata)
    {
        Object obj = null;
        if (isTransacted)
        {
            ebaycontext = obj;
            if (iTransaction != null)
            {
                ebaycontext = obj;
                if (iTransaction.transactionPrice != null)
                {
                    ebaycontext = (new CurrencyAmount(iTransaction.transactionPrice)).multiplyBy(iTransaction.quantityPurchased).toItemCurrency();
                }
            }
            return ebaycontext;
        } else
        {
            return currentPriceForType(ebaycontext, viewitemviewdata);
        }
    }

    private String getCurrentPriceString(EbayContext ebaycontext, ViewItemViewData viewitemviewdata)
    {
        Context context = (Context)ebaycontext.getExtension(android/content/Context);
        if (isTransacted)
        {
            return getTransactionPriceString();
        } else
        {
            ebaycontext = currentPriceForType(ebaycontext, viewitemviewdata);
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
            computeDisplayPrice(context.getResources(), spannablestringbuilder, ebaycontext, null, null, null, true, computeDisplayPriceColor(this, -1, viewitemviewdata.kind, false), true, null, null);
            return spannablestringbuilder.toString();
        }
    }

    private ItemCurrency[] getEbnShippingCost(List list)
    {
        ItemCurrency aitemcurrency[] = new ItemCurrency[2];
        aitemcurrency[0] = null;
        aitemcurrency[1] = null;
        ItemCurrency itemcurrency = null;
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
label0:
        do
        {
            ItemCurrency itemcurrency1;
            ShippingCostsShippingOption shippingcostsshippingoption;
            CurrencyAmount currencyamount;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                shippingcostsshippingoption = (ShippingCostsShippingOption)iterator.next();
                if (shippingcostsshippingoption.logisticsPlanType == null || shippingcostsshippingoption.logisticsPlanType != com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN)
                {
                    continue;
                }
                currencyamount = new CurrencyAmount(shippingcostsshippingoption.shippingServiceCost);
                if (itemcurrency != null)
                {
                    itemcurrency1 = itemcurrency;
                    if ((new CurrencyAmount(itemcurrency)).compareTo(currencyamount) <= 0)
                    {
                        break label1;
                    }
                }
                itemcurrency1 = shippingcostsshippingoption.shippingServiceCost;
            }
            if (list != null)
            {
                itemcurrency = itemcurrency1;
                if ((new CurrencyAmount(list)).compareTo(currencyamount) >= 0)
                {
                    continue;
                }
            }
            list = shippingcostsshippingoption.shippingServiceCost;
            itemcurrency = itemcurrency1;
        } while (true);
        aitemcurrency[0] = itemcurrency;
        aitemcurrency[1] = list;
        return aitemcurrency;
    }

    public static String getFastAndFreeText()
    {
        switch (MyApp.getPrefs().getCurrentCountry().getSiteId())
        {
        default:
            return null;

        case 0: // '\0'
        case 15: // '\017'
            return "FAST 'N FREE";

        case 3: // '\003'
            return "FAST & FREE";

        case 77: // 'M'
            return "Kostenlos & Schnell";
        }
    }

    private ShippingCostsShippingOption getFastestEbnShippingOption(List list)
    {
        Object obj = null;
        Date date = null;
        Iterator iterator = list.iterator();
        list = obj;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)iterator.next();
            if (shippingcostsshippingoption.logisticsPlanType != null && shippingcostsshippingoption.logisticsPlanType == com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN && (date == null || date.after(shippingcostsshippingoption.estimatedDeliveryMaxTime)))
            {
                list = shippingcostsshippingoption;
                date = shippingcostsshippingoption.estimatedDeliveryMaxTime;
            }
        } while (true);
        return list;
    }

    private String getLocation(com.ebay.nautilus.domain.data.BaseCommonType.Region region)
    {
        String s1 = region.regionName;
        String s = s1;
        if (com.ebay.nautilus.domain.data.BaseCommonType.RegionTypeEnum.COUNTRY.equals(region.regionType))
        {
            s = s1;
            if (!TextUtils.isEmpty(region.regionId))
            {
                s = region.regionId;
            }
        }
        if (TextUtils.isEmpty(s))
        {
            Log.w("VLS Item Mapper", (new StringBuilder()).append("No region name regionId=").append(region.regionId).append(";regionName=").append(region.regionName).append(";regionType=").append(region.regionType).toString());
        }
        return s;
    }

    public static ArrayList getMatchingVehicles(Item item)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = item.vehicles.iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Vehicle vehicle = (Vehicle)iterator.next();
            Iterator iterator1 = item.itemCompatibiltyList.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
            } while (!((ItemCompatibilty)iterator1.next()).matches(vehicle.attributes));
            arraylist.add(vehicle);
        } while (true);
        return arraylist;
    }

    public static String[] getNotSelectedStrings(Context context)
    {
        if (mskuNotSelectedStrings == null || mskuNotSelectedStrings.length == 0)
        {
            mskuNotSelectedStrings = (new String[] {
                "", context.getString(0x7f07027c), context.getString(0x7f07099b), context.getString(0x7f070682)
            });
        }
        return mskuNotSelectedStrings;
    }

    public static String getObfuscatedQuantityAvailable(Context context, Item item, com.ebay.common.ConstantsCommon.ItemKind itemkind, ArrayList arraylist)
    {
        int i = item.getQuantityAvailable(arraylist);
        if (!item.isSeller)
        {
            itemkind = context.getResources();
            if (item.quantityAvailableHint == com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAvailableHint.MORE_THAN && i > item.quantityAvailableThreshold.intValue())
            {
                return itemkind.getQuantityString(0x7f08001a, item.quantityAvailableThreshold.intValue(), new Object[] {
                    item.quantityAvailableThreshold
                });
            }
            if (item.quantityAvailableHint == com.ebay.nautilus.domain.net.api.viewlisting.Listing.QuantityAvailableHint.LIMITED)
            {
                return context.getString(0x7f0704c6);
            } else
            {
                return itemkind.getQuantityString(0x7f08001c, i, new Object[] {
                    Integer.valueOf(i)
                });
            }
        } else
        {
            return (new StringBuilder()).append("").append(i).toString();
        }
    }

    public static PaidStatus getPaidStatus(Item item)
    {
        PaidStatus paidstatus = PaidStatus.UNKNOWN;
        String s1 = item.paidStatus;
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = s1;
            if (item.iTransaction != null)
            {
                s = item.iTransaction.completeStatus;
            }
        }
        if ("Complete".equals(s) || "MarkedAsPaid".equals(s) || "Paid".equals(s) || "PaidCOD".equals(s) || "PaidWithEscrow".equals(s) || "PaidWithPaisaPay".equals(s) || "PaidWithPaisaPayEscrow".equals(s) || "PaidWithPayPal".equals(s))
        {
            item = PaidStatus.PAID;
        } else
        {
            if ("Incomplete".equals(s) || "BuyerHasNotCompletedCheckout".equals(s) || "EscrowPaymentCancelled".equals(s) || "NotPaid".equals(s) || "PaisaPayNotPaid".equals(s))
            {
                return PaidStatus.NOT_PAID;
            }
            if ("Pending".equals(s) || "PaymentPending".equals(s) || "PaymentPendingWithEscrow".equals(s) || "PaymentPendingWithPaisaPay".equals(s) || "PaymentPendingWithPaisaPayEscrow".equals(s) || "PaymentPendingWithPayPal".equals(s) || "WaitingForCODPayment".equals(s))
            {
                return PaidStatus.PENDING;
            }
            item = paidstatus;
            if ("Refunded".equals(s))
            {
                return PaidStatus.REFUNDED;
            }
        }
        return item;
    }

    public static String getSavingsPercentString(Context context, ViewItemViewData viewitemviewdata)
    {
        switch (MyApp.getPrefs().getCurrentCountry().getSiteId())
        {
        default:
            return String.format(context.getString(0x7f070ba9), new Object[] {
                Integer.valueOf(viewitemviewdata.savingsRate)
            });

        case 2: // '\002'
        case 210: 
            return String.format(context.getString(0x7f070baa), new Object[] {
                Integer.valueOf(viewitemviewdata.savingsRate)
            });
        }
    }

    public static ItemCurrency getShipping(Context context, Item item)
    {
        Object obj = null;
        context = obj;
        if (!item.isLocalPickupOnly)
        {
            context = obj;
            if (item.shippingInfo.shippingServiceCost != null)
            {
                item = item.shippingInfo.shippingServiceCost;
                context = obj;
                if (!(new CurrencyAmount(item)).isZero())
                {
                    context = item;
                }
            }
        }
        return context;
    }

    public static String getShippingString(Context context, Item item)
    {
        SpannableStringBuilder spannablestringbuilder;
        if (item.isLiveAuction && item.buyerResponsibleForLogistics && DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_liveAuctionsShipping))
        {
            return null;
        }
        spannablestringbuilder = new SpannableStringBuilder();
        if (item.isLocalPickupOnly)
        {
            spannablestringbuilder.append(context.getString(0x7f0700b7));
            return spannablestringbuilder.toString();
        }
        if (item.shippingInfo.shippingServiceCost == null) goto _L2; else goto _L1
_L1:
        Object obj = item.shippingInfo.shippingServiceCost;
        if (obj == null) goto _L4; else goto _L3
_L3:
        if ((new CurrencyAmount(((ItemCurrency) (obj)))).isZero())
        {
            obj = MyApp.getPrefs().getShipToPostalCode();
            if ((MyApp.getPrefs().isSignedIn() || obj != null && !TextUtils.isEmpty(((PostalCodeSpecification) (obj)).postalCode)) && !item.isFreight)
            {
                spannablestringbuilder.append(context.getString(0x7f070422));
            }
        } else
        {
            item.displayPriceShippingCurrency = ((ItemCurrency) (obj));
            item.computeDisplayPrice(context.getResources(), spannablestringbuilder, ((ItemCurrency) (obj)), null, null, null, false, -1, false, null, null, false);
        }
_L2:
        return spannablestringbuilder.toString();
_L4:
        if (item.isFreight && !item.isSeller)
        {
            spannablestringbuilder.append(context.getString(0x7f070175));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private ItemCurrency getTransactionPrice(ViewItemViewData viewitemviewdata)
    {
        Object obj = null;
        viewitemviewdata = obj;
        if (iTransaction != null)
        {
            viewitemviewdata = obj;
            if (iTransaction.transactionPrice != null)
            {
                viewitemviewdata = (new CurrencyAmount(iTransaction.transactionPrice)).multiplyBy(iTransaction.quantityPurchased).toItemCurrency();
            }
        }
        return viewitemviewdata;
    }

    private String getTransactionPriceString()
    {
        boolean flag = false;
        Object obj = null;
        int i;
        if (iTransaction != null && iTransaction.transactionPrice != null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            obj = new SpannableStringBuilder();
            CurrencyAmount currencyamount = (new CurrencyAmount(iTransaction.transactionPrice)).multiplyBy(iTransaction.quantityPurchased);
            if (isDisplayPriceCurrencyCode)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 2;
            }
            ((SpannableStringBuilder) (obj)).append(EbayCurrencyUtil.formatDisplay(currencyamount, i));
            obj = ((SpannableStringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

    private String getUnitPriceString(ItemCurrency itemcurrency)
    {
        Object obj = null;
        String s1 = unitPriceType;
        Double double1 = getUnitQuantity(unitPriceQuantity);
        String s = obj;
        if (!TextUtils.isEmpty(s1))
        {
            s = obj;
            if (double1 != null)
            {
                s = obj;
                if (double1.doubleValue() > 0.0D)
                {
                    try
                    {
                        double d = Double.parseDouble(itemcurrency.value) / double1.doubleValue();
                        itemcurrency = EbayCurrencyUtil.formatDisplay(itemcurrency.code, d, 2);
                        s = (new StringBuilder()).append("(").append(itemcurrency).append(" / ").append(s1).append(")").toString();
                    }
                    // Misplaced declaration of an exception variable
                    catch (ItemCurrency itemcurrency)
                    {
                        logTag.logAsError("computeDisplayPrice, showUnitPrice exception", itemcurrency);
                        return null;
                    }
                }
            }
        }
        return s;
    }

    private Double getUnitQuantity(String s)
    {
label0:
        {
            Double double2 = Double.valueOf(0.0D);
            Double double1 = double2;
            if (!DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE))
            {
                break label0;
            }
            double1 = double2;
            double d;
            try
            {
                if (TextUtils.isEmpty(s))
                {
                    break label0;
                }
                d = Double.parseDouble(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return double2;
            }
            double1 = Double.valueOf(d);
        }
        return double1;
    }

    private int getVariationPosition(List list)
    {
        byte byte0 = -1;
        int j = byte0;
        if (list != null)
        {
            j = byte0;
            if (!list.isEmpty())
            {
                int i = -1;
                Iterator iterator = variations.iterator();
                Variation variation;
                do
                {
                    j = byte0;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    variation = (Variation)iterator.next();
                    j = i + 1;
                    i = j;
                } while (!variation.isMatch(list));
            }
        }
        return j;
    }

    private int getVariationQuantityAvailable(List list)
    {
        int i = getVariationPosition(list);
        if (i >= 0)
        {
            return ((Variation)variations.get(i)).getQuantity() - ((Variation)variations.get(i)).getQuantitySold();
        } else
        {
            return 1;
        }
    }

    private boolean isCountryExcludedViaRegion(String s)
    {
        boolean flag1;
label0:
        {
            flag1 = false;
            Iterator iterator = excludeShipToLocations.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (!shippingRegions.containsKey(s1) || !((HashSet)shippingRegions.get(s1)).contains(s))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            flag1 = flag;
            if (flag)
            {
                break label0;
            }
            iterator = excludeShipToRegions.iterator();
            String s2;
            do
            {
                flag1 = flag;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                s2 = (String)iterator.next();
            } while (!shippingRegions.containsKey(s2) || !((HashSet)shippingRegions.get(s2)).contains(s));
            flag1 = true;
        }
        return flag1;
    }

    public static boolean isValidBid(Item item, double d)
    {
        int i;
label0:
        {
label1:
            {
                boolean flag1 = false;
                boolean flag = flag1;
                if (item != null)
                {
                    flag = flag1;
                    if (item.minimumToBid != null)
                    {
                        flag = flag1;
                        if (item.minimumToBid.lowerBound != null)
                        {
                            CurrencyAmount currencyamount;
                            if (item.currentPrice != null)
                            {
                                currencyamount = new CurrencyAmount(d, item.currentPrice.code);
                            } else
                            {
                                currencyamount = null;
                            }
                            flag = flag1;
                            if (currencyamount != null)
                            {
                                i = currencyamount.compareTo(item.minimumToBid.lowerBound);
                                if (!item.minimumToBid.allowLowerBound)
                                {
                                    break label0;
                                }
                                if (i < 0)
                                {
                                    break label1;
                                }
                                flag = true;
                            }
                        }
                    }
                }
                return flag;
            }
            return false;
        }
        return i > 0;
    }

    private static String modifyShippingPriceStringAccretive(Context context, Item item, String s)
    {
label0:
        {
            String s1 = s;
            String s2 = s1;
            if (!TextUtils.isEmpty(s1))
            {
                if (!item.isFreight && !item.isLocalPickupOnly && !s.equals(context.getString(0x7f070175)))
                {
                    break label0;
                }
                s2 = context.getString(0x7f0707a3, new Object[] {
                    s
                });
            }
            return s2;
        }
        if (item.isEbayNowAvailable && item.ignoreQuantity)
        {
            return context.getString(0x7f0707a1, new Object[] {
                s, ViewItemShippingInfo.getFormattedEbnEstimatedDelivery(context, item)
            });
        }
        if (s.equals(context.getString(0x7f070421)))
        {
            return context.getString(0x7f0707a3, new Object[] {
                context.getString(0x7f070549)
            });
        } else
        {
            return context.getString(0x7f0707a2, new Object[] {
                s
            });
        }
    }

    private void setupBuyerResponsibleForLogisticsString(Context context)
    {
        if (buyerResponsibleForLogistics)
        {
            if (isLiveAuction && DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_liveAuctionsShipping))
            {
                displayBuyerResponsibleForLogistics = context.getString(0x7f070268);
                return;
            } else
            {
                displayBuyerResponsibleForLogistics = context.getString(0x7f070c6e);
                return;
            }
        } else
        {
            displayBuyerResponsibleForLogistics = null;
            return;
        }
    }

    private boolean setupEbayPlusItemCardWording(EbayContext ebaycontext)
    {
        if (eBayPlusShippingOption == null)
        {
            return false;
        }
        String s = Util.getDeliveryDateString((Context)ebaycontext.getExtension(android/content/Context), eBayPlusShippingOption.estimatedDeliveryMinTime, true);
        String s1 = Util.getDeliveryDateString((Context)ebaycontext.getExtension(android/content/Context), eBayPlusShippingOption.estimatedDeliveryMaxTime, true);
        boolean flag;
        long l;
        if (eBayPlusOrderTodayEndTime != null)
        {
            l = eBayPlusOrderTodayEndTime.getTime() - EbayResponse.currentHostTime();
        } else
        {
            l = 0L;
        }
        if (l > 0L && l < 0x5265c00L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (TextUtils.isEmpty(s) && TextUtils.isEmpty(s1))
        {
            return false;
        }
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !s1.equals(s))
        {
            if (isEbayPlusInWindow || flag)
            {
                displayEbayPlusItemCardWithEndTime = String.format(ebaycontext.getString(0x7f070376), new Object[] {
                    s, s1, "%s"
                });
            }
            displayEbayPlusItemCard = String.format(ebaycontext.getString(0x7f070378), new Object[] {
                s, s1
            });
            return true;
        }
        if (TextUtils.isEmpty(s))
        {
            s = s1;
        }
        if (isEbayPlusInWindow || flag)
        {
            displayEbayPlusItemCardWithEndTime = String.format(ebaycontext.getString(0x7f070377), new Object[] {
                s, "%s"
            });
        }
        displayEbayPlusItemCard = String.format(ebaycontext.getString(0x7f070379), new Object[] {
            s
        });
        return true;
    }

    private void setupHotnessCharityString(Context context)
    {
        if (isHotnessCharity && DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_hotnessCharitySignal) && charity != null && !TextUtils.isEmpty(charity.name.decode()))
        {
            displayHotnessCharityKeyString = context.getString(0x7f07022d);
            if (isHotnessCharityAll)
            {
                displayHotnessCharityValueString = String.format(context.getString(0x7f070476), new Object[] {
                    charity.name.decode()
                });
                return;
            } else
            {
                displayHotnessCharityValueString = String.format(context.getString(0x7f070475), new Object[] {
                    Integer.valueOf((int)charity.donationPercentage.floatValue()), charity.name.decode()
                });
                return;
            }
        } else
        {
            isHotnessCharity = false;
            displayHotnessCharityValueString = null;
            displayHotnessCharityKeyString = null;
            isHotnessCharityAll = false;
            return;
        }
    }

    private void setupItemCard(EbayContext ebaycontext)
    {
        if (!isEbnOnly && (!isLocalOptionsOnly || !isEbayNowAvailable)) goto _L2; else goto _L1
_L1:
        String s = null;
        Object obj1 = ViewItemShippingInfo.getEbayNowShippingOptions(this);
        ShippingCostsShippingOption shippingcostsshippingoption = getFastestEbnShippingOption(((List) (obj1)));
        if (shippingcostsshippingoption != null)
        {
            s = ViewItemShippingInfo.getEarliestEbnDelivery((Context)ebaycontext.getExtension(android/content/Context), shippingcostsshippingoption.estimatedDeliveryMaxTime, false);
        }
        ItemCurrency aitemcurrency[] = getEbnShippingCost(((List) (obj1)));
        aitemcurrency = ViewItemShippingInfo.getEbnShippingCost(ebaycontext, this, aitemcurrency[0], aitemcurrency[1], 0).toString();
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(aitemcurrency))
        {
            displayShippingAmountItemCard = aitemcurrency;
            displayShippingLabelItemCard = s;
        } else
        {
            isShowItemCard = false;
        }
_L8:
        if (!isShowItemCard || isShowItemCardSingle) goto _L4; else goto _L3
_L3:
        ebaycontext = ViewItemShippingInfo.getEstimatedShippingDates((Context)ebaycontext.getExtension(android/content/Context), this, true);
        if (TextUtils.isEmpty(ebaycontext)) goto _L6; else goto _L5
_L5:
        displayShippingEstimateItemCard = ebaycontext;
_L4:
        return;
_L2:
        if (isIspuOnly || isLocalOptionsOnly && isBopisable)
        {
            displayShippingAmountItemCard = displayPriceShippingRaw;
            displayShippingLabelItemCard = ebaycontext.getString(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry()));
        } else
        if (isLiveAuction && buyerResponsibleForLogistics && DeviceConfiguration.getAsync().get(DcsBoolean.VI_feature_liveAuctionsShipping))
        {
            isShowItemCard = false;
        } else
        if (isEbayPlusEligible && isEbayPlusMember && setupEbayPlusItemCardWording(ebaycontext))
        {
            isEbayPlusLogoShown = true;
        } else
        if (isEbayPlusEligible && !isEbayPlusMember)
        {
            setupEbayPlusNonMember(ebaycontext, this);
        } else
        if (isLocalPickupOnly || isLocalOptionsOnly && isLocalPickup)
        {
            displayShippingAmountItemCard = ebaycontext.getString(0x7f070421);
            Object obj = shippingInfo.orderedOptions;
            if (obj != null && ((List) (obj)).size() > 0)
            {
                obj = (ShippingCostsShippingOption)((List) (obj)).get(0);
                if (((ShippingCostsShippingOption) (obj)).shippingServiceCost != null && (new CurrencyAmount(((ShippingCostsShippingOption) (obj)).shippingServiceCost)).isGreaterThanZero())
                {
                    displayShippingAmountItemCard = EbayCurrencyUtil.formatDisplay(((ShippingCostsShippingOption) (obj)).shippingServiceCost, getCurrencyUtilFlag());
                }
            }
            if (displayPriceShippingCurrency != null && !(new CurrencyAmount(displayPriceShippingCurrency)).isZero())
            {
                displayShippingAmountItemCard = displayPriceShippingRaw;
            }
            if (isDisplayPriceCurrencyCode && displayPriceShippingConvertedCurrency != null)
            {
                displayShippingAmountConvertedItemCard = EbayCurrencyUtil.formatDisplay(displayPriceShippingConvertedCurrency, getCurrencyUtilFlag());
            }
            displayShippingLabelItemCard = ebaycontext.getString(0x7f0700b7);
        } else
        {
            displayShippingAmountItemCard = displayPriceShippingRaw;
            String s1;
            if (!TextUtils.isEmpty(displayPriceShippingConverted) && isDisplayPriceCurrencyCode)
            {
                s1 = getApproximatelyString(ebaycontext, 0x7f07016d, displayPriceShippingConvertedRaw);
            } else
            {
                s1 = null;
            }
            displayShippingAmountConvertedItemCard = s1;
            displayShippingLabelItemCard = ebaycontext.getString(0x7f070a6e);
            if (TextUtils.isEmpty(displayShippingAmountItemCard))
            {
                isShowItemCard = false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        isShowItemCard = true;
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void setupSTP(EbayContext ebaycontext, ViewItemViewData viewitemviewdata)
    {
        if ((!TextUtils.isEmpty(pricingTreatment) && originalRetailPrice != null || isSavings(viewitemviewdata.originalRetailPrice) || isSavings(promotionalSaleOriginalPrice) || viewitemviewdata.originalRetailPrice != null) && (isMap || isStp || promotionalSaleOriginalPrice != null))
        {
            Object obj = viewitemviewdata.originalRetailPrice;
            viewitemviewdata = ((ViewItemViewData) (obj));
            if (obj == null)
            {
                viewitemviewdata = promotionalSaleOriginalPrice;
            }
            obj = viewitemviewdata;
            if (viewitemviewdata == null)
            {
                obj = originalRetailPrice;
            }
            if (obj != null)
            {
                displayPriceOriginalCurrency = ((ItemCurrency) (obj));
                displayPriceOriginal = EbayCurrencyUtil.formatDisplay(displayPriceOriginalCurrency, getCurrencyUtilFlag());
                displayPriceOriginalConvertedCurrency = convertCurrency(ebaycontext, ((ItemCurrency) (obj)));
                displayPriceOriginalConverted = EbayCurrencyUtil.formatDisplay(displayPriceOriginalConvertedCurrency, getCurrencyUtilFlag());
            }
        }
    }

    public static void setupShippingDisplayPrices(Context context, Item item)
    {
        Resources resources = context.getResources();
        item.displayPriceShipping = getShippingString(context, item);
        item.displayPriceShippingRaw = item.displayPriceShipping;
        if (item.isIspuOnly)
        {
            item.displayPriceShippingRaw = resources.getString(0x7f070421);
        }
        if (!TextUtils.isEmpty(item.displayPriceShipping))
        {
            if (item.displayPriceShipping.equalsIgnoreCase(resources.getString(0x7f070421)))
            {
                item.displayPriceShippingTerse = resources.getString(0x7f070421);
                item.displayPriceShippingRaw = item.displayPriceShippingTerse;
            } else
            {
                item.displayPriceShippingTerse = resources.getString(0x7f0707a3, new Object[] {
                    item.displayPriceShipping
                });
            }
        }
        item.displayPriceShipping = modifyShippingPriceStringAccretive(context, item, item.displayPriceShipping);
    }

    public static void setupShippingDisplayPricesConverted(EbayContext ebaycontext, Item item)
    {
        Context context = (Context)ebaycontext.getExtension(android/content/Context);
        item.displayPriceShippingConvertedCurrency = convertCurrency(ebaycontext, getShipping(context, item));
        if (item.displayPriceShippingConvertedCurrency != null)
        {
            item.displayPriceShippingConverted = EbayCurrencyUtil.formatDisplay(item.displayPriceShippingConvertedCurrency, item.getCurrencyUtilFlag());
            if (item.displayPriceShippingConverted != null)
            {
                item.displayPriceShippingConvertedRaw = item.displayPriceShippingConverted;
                item.displayPriceShippingConverted = modifyShippingPriceStringAccretive(context, item, item.displayPriceShippingConverted);
            }
        }
    }

    public static HashMap setupShippingRegions()
    {
        String as[] = new String[56];
        as[0] = "DZ";
        as[1] = "AO";
        as[2] = "BJ";
        as[3] = "BW";
        as[4] = "BF";
        as[5] = "BI";
        as[6] = "CM";
        as[7] = "CV";
        as[8] = "CF";
        as[9] = "TD";
        as[10] = "KM";
        as[11] = "CD";
        as[12] = "CG";
        as[13] = "CI";
        as[14] = "DJ";
        as[15] = "EG";
        as[16] = "GQ";
        as[17] = "ER";
        as[18] = "ET";
        as[19] = "GA";
        as[20] = "GM";
        as[21] = "GH";
        as[22] = "GN";
        as[23] = "GW";
        as[24] = "KE";
        as[25] = "LS";
        as[26] = "LR";
        as[27] = "LY";
        as[28] = "MG";
        as[29] = "MW";
        as[30] = "ML";
        as[31] = "MR";
        as[32] = "MU";
        as[33] = "YT";
        as[34] = "MA";
        as[35] = "MZ";
        as[36] = "NA";
        as[37] = "NE";
        as[38] = "NG";
        as[39] = "RE";
        as[40] = "RW";
        as[41] = "SH";
        as[42] = "SN";
        as[43] = "SC";
        as[44] = "SL";
        as[45] = "SO";
        as[46] = "ZA";
        as[47] = "SD";
        as[48] = "SZ";
        as[49] = "TZ";
        as[50] = "TG";
        as[51] = "TN";
        as[52] = "UG";
        as[53] = "EH";
        as[54] = "ZM";
        as[55] = "ZW";
        String as1[] = new String[45];
        as1[0] = "AF";
        as1[1] = "AM";
        as1[2] = "AZ";
        as1[3] = "BH";
        as1[4] = "BD";
        as1[5] = "BT";
        as1[6] = "BN";
        as1[7] = "KH";
        as1[8] = "CN";
        as1[9] = "GE";
        as1[10] = "HK";
        as1[11] = "IN";
        as1[12] = "ID";
        as1[13] = "IQ";
        as1[14] = "IL";
        as1[15] = "JP";
        as1[16] = "JO";
        as1[17] = "KZ";
        as1[18] = "KR";
        as1[19] = "KW";
        as1[20] = "KG";
        as1[21] = "LA";
        as1[22] = "LB";
        as1[23] = "MO";
        as1[24] = "MY";
        as1[25] = "MV";
        as1[26] = "MN";
        as1[27] = "NP";
        as1[28] = "OM";
        as1[29] = "PK";
        as1[30] = "PH";
        as1[31] = "QA";
        as1[32] = "RU";
        as1[33] = "SA";
        as1[34] = "SG";
        as1[35] = "LK";
        as1[36] = "TW";
        as1[37] = "TJ";
        as1[38] = "TH";
        as1[39] = "TR";
        as1[40] = "TM";
        as1[41] = "AE";
        as1[42] = "UZ";
        as1[43] = "VN";
        as1[44] = "YE";
        String as2[] = new String[31];
        as2[0] = "AI";
        as2[1] = "AG";
        as2[2] = "AW";
        as2[3] = "BS";
        as2[4] = "BB";
        as2[5] = "BZ";
        as2[6] = "VG";
        as2[7] = "KY";
        as2[8] = "CR";
        as2[9] = "CU";
        as2[10] = "DM";
        as2[11] = "DO";
        as2[12] = "SV";
        as2[13] = "GD";
        as2[14] = "GP";
        as2[15] = "GT";
        as2[16] = "HT";
        as2[17] = "HN";
        as2[18] = "JM";
        as2[19] = "MQ";
        as2[20] = "MS";
        as2[21] = "AN";
        as2[22] = "NI";
        as2[23] = "PA";
        as2[24] = "PR";
        as2[25] = "KN";
        as2[26] = "LC";
        as2[27] = "VC";
        as2[28] = "TT";
        as2[29] = "TC";
        as2[30] = "VI";
        String as3[] = new String[47];
        as3[0] = "AL";
        as3[1] = "AD";
        as3[2] = "AT";
        as3[3] = "BY";
        as3[4] = "BE";
        as3[5] = "BA";
        as3[6] = "BG";
        as3[7] = "HR";
        as3[8] = "CY";
        as3[9] = "CZ";
        as3[10] = "DK";
        as3[11] = "EE";
        as3[12] = "FI";
        as3[13] = "FR";
        as3[14] = "DE";
        as3[15] = "GI";
        as3[16] = "GR";
        as3[17] = "HU";
        as3[18] = "IS";
        as3[19] = "IE";
        as3[20] = "IT";
        as3[21] = "LV";
        as3[22] = "LI";
        as3[23] = "LT";
        as3[24] = "LU";
        as3[25] = "MK";
        as3[26] = "MT";
        as3[27] = "MD";
        as3[28] = "MC";
        as3[29] = "ME";
        as3[30] = "NL";
        as3[31] = "NO";
        as3[32] = "PL";
        as3[33] = "PT";
        as3[34] = "RO";
        as3[35] = "RU";
        as3[36] = "SM";
        as3[37] = "RS";
        as3[38] = "SK";
        as3[39] = "SI";
        as3[40] = "ES";
        as3[41] = "SJ";
        as3[42] = "SE";
        as3[43] = "CH";
        as3[44] = "UA";
        as3[45] = "GB";
        as3[46] = "VA";
        String as4[] = new String[27];
        as4[0] = "AT";
        as4[1] = "BE";
        as4[2] = "BG";
        as4[3] = "CY";
        as4[4] = "CZ";
        as4[5] = "DE";
        as4[6] = "DK";
        as4[7] = "EE";
        as4[8] = "ES";
        as4[9] = "FI";
        as4[10] = "FR";
        as4[11] = "GB";
        as4[12] = "GR";
        as4[13] = "HU";
        as4[14] = "IE";
        as4[15] = "IT";
        as4[16] = "LT";
        as4[17] = "LU";
        as4[18] = "LV";
        as4[19] = "MT";
        as4[20] = "NL";
        as4[21] = "PL";
        as4[22] = "PT";
        as4[23] = "RO";
        as4[24] = "SE";
        as4[25] = "SI";
        as4[26] = "SK";
        String as5[] = new String[14];
        as5[0] = "BH";
        as5[1] = "IR";
        as5[2] = "IQ";
        as5[3] = "IL";
        as5[4] = "JO";
        as5[5] = "KW";
        as5[6] = "LB";
        as5[7] = "OM";
        as5[8] = "QA";
        as5[9] = "SA";
        as5[10] = "SY";
        as5[11] = "TR";
        as5[12] = "AE";
        as5[13] = "YE";
        String as6[] = new String[6];
        as6[0] = "BM";
        as6[1] = "CA";
        as6[2] = "GL";
        as6[3] = "MX";
        as6[4] = "PM";
        as6[5] = "US";
        String as7[] = new String[21];
        as7[0] = "AS";
        as7[1] = "AU";
        as7[2] = "CK";
        as7[3] = "FJ";
        as7[4] = "PF";
        as7[5] = "GU";
        as7[6] = "KI";
        as7[7] = "MH";
        as7[8] = "FM";
        as7[9] = "NR";
        as7[10] = "NC";
        as7[11] = "NZ";
        as7[12] = "NU";
        as7[13] = "PW";
        as7[14] = "PG";
        as7[15] = "SB";
        as7[16] = "TO";
        as7[17] = "TV";
        as7[18] = "VU";
        as7[19] = "WF";
        as7[20] = "WS";
        String as8[] = new String[14];
        as8[0] = "AR";
        as8[1] = "BO";
        as8[2] = "BR";
        as8[3] = "CL";
        as8[4] = "CO";
        as8[5] = "EC";
        as8[6] = "FK";
        as8[7] = "GF";
        as8[8] = "GY";
        as8[9] = "PY";
        as8[10] = "PE";
        as8[11] = "SR";
        as8[12] = "UY";
        as8[13] = "VE";
        HashMap hashmap = new HashMap();
        hashmap.put("Africa", toSet(new String[][] {
            as
        }));
        hashmap.put("Asia", toSet(new String[][] {
            as1
        }));
        hashmap.put("Carribean", toSet(new String[][] {
            as2
        }));
        hashmap.put("Europe", toSet(new String[][] {
            as3
        }));
        hashmap.put("EuropeanUnion", toSet(new String[][] {
            as4
        }));
        hashmap.put("European Union", toSet(new String[][] {
            as4
        }));
        hashmap.put("MiddleEast", toSet(new String[][] {
            as5
        }));
        hashmap.put("Middle East", toSet(new String[][] {
            as5
        }));
        hashmap.put("NorthAmerica", toSet(new String[][] {
            as6
        }));
        hashmap.put("North America", toSet(new String[][] {
            as6
        }));
        hashmap.put("Oceania", toSet(new String[][] {
            as7
        }));
        hashmap.put("SouthAmerica", toSet(new String[][] {
            as8
        }));
        hashmap.put("South America", toSet(new String[][] {
            as8
        }));
        hashmap.put("LatinAmerica", toSet(new String[][] {
            as2, as8
        }));
        hashmap.put("Latin America", toSet(new String[][] {
            as2, as8
        }));
        hashmap.put("Americas", toSet(new String[][] {
            as2, as8, as6
        }));
        hashmap.put("US Protectorates", toSet(new String[][] {
            new String[] {
                "AS", "GU", "MP", "MH", "MN", "PW", "PR", "VI"
            }
        }));
        hashmap.put("AFRICA", toSet(new String[][] {
            as
        }));
        hashmap.put("AMERICAS", toSet(new String[][] {
            as2, as8, as6
        }));
        hashmap.put("ASIA", toSet(new String[][] {
            as1
        }));
        hashmap.put("CARIBBEAN", toSet(new String[][] {
            as2
        }));
        hashmap.put("EUROPE", toSet(new String[][] {
            as3
        }));
        hashmap.put("EUROPEAN_UNION", toSet(new String[][] {
            as4
        }));
        hashmap.put("LATIN_AMERICA", toSet(new String[][] {
            as2, as8
        }));
        hashmap.put("MIDDLE_EAST", toSet(new String[][] {
            as5
        }));
        hashmap.put("NORTH_AMERICA", toSet(new String[][] {
            as6
        }));
        hashmap.put("OCEANIA", toSet(new String[][] {
            as7
        }));
        hashmap.put("SOUTH_AMERICA", toSet(new String[][] {
            as8
        }));
        hashmap.put("CENTRAL_AMERICA_AND_CARIBBEAN", toSet(new String[][] {
            as2, as8
        }));
        return hashmap;
    }

    private void showSavings(Context context, ViewItemViewData viewitemviewdata, ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        if (itemcurrency1 != null && itemcurrency != null)
        {
            CurrencyAmount currencyamount = new CurrencyAmount(itemcurrency1);
            itemcurrency1 = new CurrencyAmount(itemcurrency);
            itemcurrency = (new CurrencyAmount(itemcurrency)).subtract(currencyamount);
            if (viewitemviewdata.savingsRate == 0 && !itemcurrency1.isZero())
            {
                viewitemviewdata.savingsRate = (int)((100D * itemcurrency.getValueAsDouble()) / itemcurrency1.getValueAsDouble());
            }
            if (viewitemviewdata.savingsRate > 0)
            {
                displayPricePercentOff = getSavingsPercentString(context, viewitemviewdata);
            }
        }
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

    public String addBsfVat(Resources resources, String s)
    {
        String s1 = s;
        if (isVatIncluded())
        {
            s1 = resources.getString(0x7f07047e, new Object[] {
                s
            });
        }
        return s1;
    }

    public void addShipToOrExclusion(com.ebay.nautilus.domain.data.BaseCommonType.Region region, boolean flag)
    {
        if (region != null && region.regionType != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$RegionTypeEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$RegionTypeEnum = new int[com.ebay.nautilus.domain.data.BaseCommonType.RegionTypeEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$RegionTypeEnum[com.ebay.nautilus.domain.data.BaseCommonType.RegionTypeEnum.WORLDWIDE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$RegionTypeEnum[com.ebay.nautilus.domain.data.BaseCommonType.RegionTypeEnum.COUNTRY_REGION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseCommonType$RegionTypeEnum[com.ebay.nautilus.domain.data.BaseCommonType.RegionTypeEnum.WORLD_REGION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.ebay.nautilus.domain.data.BaseCommonType.RegionTypeEnum[region.regionType.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 77
    //                   2 96
    //                   3 96;
           goto _L3 _L4 _L5 _L5
_L3:
        region = getLocation(region);
        boolean flag1;
        if (!TextUtils.isEmpty(region))
        {
            if (flag)
            {
                excludeShipToLocations.add(region);
                return;
            } else
            {
                shipToLocations.add(region);
                return;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isWorldwideShipping = flag1;
          goto _L3
_L5:
        if (flag)
        {
            excludeShipToRegions.add(region.regionId);
        } else
        {
            shipToRegions.add(region.regionId);
        }
          goto _L3
    }

    public boolean bestOfferPending(String s)
    {
        boolean flag = true;
        if (offers != null && !offers.isEmpty()) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        BestOffer bestoffer;
        if (!TextUtils.isEmpty(sellerUserId) && s.equalsIgnoreCase(sellerUserId))
        {
            s = offers.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break; /* Loop/switch isn't completed */
                }
            } while (!((BestOffer)s.next()).status.equals("Pending"));
            return true;
        }
        bestoffer = (BestOffer)offers.get(offers.size() - 1);
        if (bestoffer.buyerId.equals(s) && bestoffer.status.equals("Pending")) goto _L4; else goto _L3
_L3:
        return false;
    }

    public boolean canMakeFirstOffer(String s)
    {
        if (bestOfferEnabled)
        {
            if (offers == null || offers.isEmpty())
            {
                return true;
            }
            BestOffer bestoffer = newestBestOffer(s);
            if (bestoffer == null)
            {
                return true;
            }
            if (!bestoffer.buyerId.equals(s))
            {
                return true;
            }
            if (bestoffer.codeType.equals("SellerCounterOffer") && !bestoffer.status.equals("Pending"))
            {
                return true;
            }
            if ((bestoffer.codeType.equals("BuyerBestOffer") || bestoffer.codeType.equals("BuyerCounterOffer")) && (bestoffer.status.equals("Declined") || bestoffer.status.equals("Expired") || bestoffer.status.equals("Accepted")))
            {
                return true;
            }
        }
        return false;
    }

    public boolean computeDisplayPrice(Resources resources, SpannableStringBuilder spannablestringbuilder, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, ItemCurrency itemcurrency2, ItemCurrency itemcurrency3, boolean flag, 
            int i, boolean flag1, String s, Double double1)
    {
        return computeDisplayPrice(resources, spannablestringbuilder, itemcurrency, itemcurrency1, itemcurrency2, itemcurrency3, flag, i, flag1, s, double1, false);
    }

    public boolean computeDisplayPrice(Resources resources, SpannableStringBuilder spannablestringbuilder, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, ItemCurrency itemcurrency2, ItemCurrency itemcurrency3, boolean flag, 
            int i, boolean flag1, String s, Double double1, boolean flag2)
    {
        return computeDisplayPrice(resources, spannablestringbuilder, itemcurrency, itemcurrency1, itemcurrency2, itemcurrency3, flag, i, flag1, s, double1, flag2, false);
    }

    public boolean computeDisplayPrice(Resources resources, SpannableStringBuilder spannablestringbuilder, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, ItemCurrency itemcurrency2, ItemCurrency itemcurrency3, boolean flag, 
            int i, boolean flag1, String s, Double double1, boolean flag2, boolean flag3)
    {
        if (i != -1)
        {
            i = resources.getColor(i);
        } else
        {
            i = -1;
        }
        return computeDisplayPriceUsingTextColor(resources, spannablestringbuilder, itemcurrency, itemcurrency1, itemcurrency2, itemcurrency3, flag, i, flag1, s, double1, flag2, flag3);
    }

    public boolean computeDisplayPriceUsingTextColor(Resources resources, SpannableStringBuilder spannablestringbuilder, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, ItemCurrency itemcurrency2, ItemCurrency itemcurrency3, boolean flag, 
            int i, boolean flag1, String s, Double double1, boolean flag2, boolean flag3)
    {
        char c;
        if (itemcurrency == null)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        int j = 0;
        ItemCurrency itemcurrency8 = itemcurrency;
        ItemCurrency itemcurrency9 = itemcurrency2;
        ItemCurrency itemcurrency10 = itemcurrency1;
        ItemCurrency itemcurrency11 = itemcurrency3;
        ItemCurrency itemcurrency4 = itemcurrency11;
        ItemCurrency itemcurrency5 = itemcurrency9;
        ItemCurrency itemcurrency6 = itemcurrency10;
        ItemCurrency itemcurrency7 = itemcurrency8;
        boolean flag4 = j;
        if (itemcurrency2 != null)
        {
            itemcurrency4 = itemcurrency11;
            itemcurrency5 = itemcurrency9;
            itemcurrency6 = itemcurrency10;
            itemcurrency7 = itemcurrency8;
            flag4 = j;
            if (!TextUtils.equals(itemcurrency.code, itemcurrency2.code))
            {
                boolean flag5 = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode().equals(itemcurrency.code);
                double d;
                int k;
                if (flag5)
                {
                    itemcurrency7 = itemcurrency2;
                } else
                {
                    itemcurrency7 = itemcurrency;
                }
                if (flag5)
                {
                    itemcurrency6 = itemcurrency3;
                } else
                {
                    itemcurrency6 = itemcurrency1;
                }
                if (flag5)
                {
                    itemcurrency5 = itemcurrency;
                } else
                {
                    itemcurrency5 = itemcurrency2;
                }
                if (flag5)
                {
                    itemcurrency4 = itemcurrency1;
                } else
                {
                    itemcurrency4 = itemcurrency3;
                }
                if (!flag5)
                {
                    flag4 = true;
                } else
                {
                    flag4 = false;
                }
            }
        }
        j = getCurrencyUtilFlag();
        itemcurrency2 = itemcurrency6;
        itemcurrency3 = itemcurrency2;
        itemcurrency1 = itemcurrency7;
        if (flag4)
        {
            itemcurrency3 = itemcurrency2;
            itemcurrency1 = itemcurrency7;
            if (!flag3)
            {
                itemcurrency1 = itemcurrency5;
                itemcurrency3 = itemcurrency4;
            }
        }
        if (itemcurrency3 == null)
        {
            if (flag)
            {
                itemcurrency2 = addBsfVat(resources, itemcurrency1, j);
            } else
            {
                itemcurrency2 = EbayCurrencyUtil.formatDisplay(itemcurrency1, j);
            }
        } else
        {
            itemcurrency2 = resources.getString(0x7f070638, new Object[] {
                EbayCurrencyUtil.formatDisplay(itemcurrency1, j), addBsfVat(resources, itemcurrency3, j)
            });
        }
        k = spannablestringbuilder.length();
        spannablestringbuilder.append(itemcurrency2);
        if (flag2)
        {
            spannablestringbuilder.setSpan(new StyleSpan(1), k, spannablestringbuilder.length(), 33);
        }
        if (i != -1)
        {
            spannablestringbuilder.setSpan(new ForegroundColorSpan(i), k, spannablestringbuilder.length(), 33);
        }
        if (flag3 && flag4)
        {
            if (flag1)
            {
                c = '\n';
            } else
            {
                c = ' ';
            }
            spannablestringbuilder.append(c);
            i = spannablestringbuilder.length();
            if (itemcurrency6 == null)
            {
                itemcurrency2 = resources.getString(0x7f070170, new Object[] {
                    EbayCurrencyUtil.formatDisplay(itemcurrency5, 1)
                });
            } else
            {
                itemcurrency2 = resources.getString(0x7f070171, new Object[] {
                    EbayCurrencyUtil.formatDisplay(itemcurrency5, 1), EbayCurrencyUtil.formatDisplay(itemcurrency4, 1)
                });
            }
            spannablestringbuilder.append(itemcurrency2);
            spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d00e7)), i, spannablestringbuilder.length(), 33);
        }
        if (TextUtils.isEmpty(s) || double1 == null || double1.doubleValue() <= 0.0D)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        itemcurrency2 = itemcurrency1;
        if (itemcurrency1 == null)
        {
            itemcurrency2 = itemcurrency;
        }
        d = Double.parseDouble(itemcurrency2.value) / double1.doubleValue();
        itemcurrency1 = EbayCurrencyUtil.formatDisplay(itemcurrency2.code, d, j);
        itemcurrency1 = (new StringBuilder()).append("(").append(itemcurrency1).append(" / ").append(s).append(")").toString();
        if (flag1)
        {
            c = '\n';
        } else
        {
            c = ' ';
        }
        try
        {
            spannablestringbuilder.append(c);
            i = spannablestringbuilder.length();
            spannablestringbuilder.append(itemcurrency1);
            spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x7f0d00e7)), i, spannablestringbuilder.length(), 33);
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            Log.e("ItemView", "computeDisplayPrice, showUnitPrice exception", resources);
        }
        return itemcurrency != null;
    }

    public ItemCurrency currentPriceForType(EbayContext ebaycontext, ViewItemViewData viewitemviewdata)
    {
        return currentPriceForType(ebaycontext, viewitemviewdata, false);
    }

    public ItemCurrency currentPriceForType(EbayContext ebaycontext, ViewItemViewData viewitemviewdata, boolean flag)
    {
        Object obj1 = null;
        if (!isScheduled) goto _L2; else goto _L1
_L1:
        Object obj = startPrice;
_L4:
        viewitemviewdata = ((ViewItemViewData) (obj));
        if (obj == null)
        {
            obj = currentPrice;
            viewitemviewdata = ((ViewItemViewData) (obj));
            if (isBinOnly)
            {
                viewitemviewdata = ((ViewItemViewData) (obj));
                if (buyItNowPrice != null)
                {
                    viewitemviewdata = buyItNowPrice;
                }
            }
        }
        obj = viewitemviewdata;
        if (flag)
        {
            obj = convertCurrency(ebaycontext, viewitemviewdata);
        }
        return ((ItemCurrency) (obj));
_L2:
        obj = obj1;
        if (isMultiSku)
        {
            obj = obj1;
            if (viewitemviewdata != null)
            {
                obj = obj1;
                if (hasMultiSkuValues(viewitemviewdata.nameValueList))
                {
                    obj = getVariationPrice(viewitemviewdata.nameValueList);
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getApproximatelyString(EbayContext ebaycontext, int i, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        return String.format(ebaycontext.getString(i), new Object[] {
            stringbuilder.toString()
        });
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
        if (convertedBuyItNowPrice != null)
        {
            return convertedBuyItNowPrice;
        } else
        {
            return buyItNowPrice;
        }
    }

    public String getCurrencySymbol(EbayCurrency ebaycurrency)
    {
        if (ebaycurrency == null)
        {
            return "";
        }
        ebaycurrency = EbayCurrencyUtil.formatDisplay(new ItemCurrency(ebaycurrency.getCurrencyCode(), "0"), getCurrencyUtilFlag());
        if (ebaycurrency != null)
        {
            return ebaycurrency.replace("0.00", "").replace("0,00", "").replaceAll("0", "").trim();
        } else
        {
            return "";
        }
    }

    public int getCurrencyUtilFlag()
    {
        return getCurrencyUtilFlag(MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode());
    }

    public int getCurrencyUtilFlag(String s)
    {
        while (s == null || isDisplayPriceCurrencyCode || s.equals(EbaySite.CA.getCurrency().getCurrencyCode()) || s.equals(EbaySite.AU.getCurrency().getCurrencyCode())) 
        {
            return 0;
        }
        return 2;
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

    public ArrayList getMatchingVehicles()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = vehicles.iterator();
label0:
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Vehicle vehicle = (Vehicle)iterator.next();
            Iterator iterator1 = itemCompatibiltyList.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
            } while (!((ItemCompatibilty)iterator1.next()).matches(vehicle.attributes));
            arraylist.add(vehicle);
        } while (true);
        return arraylist;
    }

    public ItemCurrency getMaxBid(ViewItemDataManager viewitemdatamanager, List list)
    {
        Object obj = null;
        list = viewitemdatamanager.getMyEbayBidItem(id, list);
        viewitemdatamanager = obj;
        if (list != null)
        {
            viewitemdatamanager = obj;
            if (!ItemCurrency.isEmpty(((MyEbayListItem) (list)).maxBidPrice))
            {
                viewitemdatamanager = ((MyEbayListItem) (list)).maxBidPrice;
            }
        }
        return viewitemdatamanager;
    }

    public ItemCurrency getMaxVariationPrice(List list)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (hasMultiSkuValues(list))
        {
            list = getVariationPrice(list);
            obj = obj1;
            if (list != null)
            {
                obj = new CurrencyAmount(list);
            }
        }
        list = ((List) (obj));
        if (obj == null)
        {
            Iterator iterator = variations.iterator();
            do
            {
                list = ((List) (obj));
                if (!iterator.hasNext())
                {
                    break;
                }
                list = ((Variation)iterator.next()).getStartPrice();
                if (list != null && ((ItemCurrency) (list)).value != null)
                {
                    list = new CurrencyAmount(list);
                    if (obj == null || ((CurrencyAmount) (obj)).compareTo(list) < 0)
                    {
                        obj = list;
                    }
                }
            } while (true);
        }
        if (list != null)
        {
            return new ItemCurrency(list.getCurrencyCode(), list.getValueAsBigDecimal().toString());
        } else
        {
            return null;
        }
    }

    public ItemCurrency getMinVariationPrice(List list)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (hasMultiSkuValues(list))
        {
            list = getVariationPrice(list);
            obj = obj1;
            if (list != null)
            {
                obj = new CurrencyAmount(list);
            }
        }
        list = ((List) (obj));
        if (obj == null)
        {
            Iterator iterator = variations.iterator();
            do
            {
                list = ((List) (obj));
                if (!iterator.hasNext())
                {
                    break;
                }
                list = ((Variation)iterator.next()).getStartPrice();
                if (list != null && ((ItemCurrency) (list)).value != null)
                {
                    list = new CurrencyAmount(list);
                    if (obj == null || ((CurrencyAmount) (obj)).compareTo(list) > 0)
                    {
                        obj = list;
                    }
                }
            } while (true);
        }
        if (list != null)
        {
            return new ItemCurrency(list.getCurrencyCode(), list.getValueAsBigDecimal().toString());
        } else
        {
            return null;
        }
    }

    public int getQuantityAvailable(ArrayList arraylist)
    {
        if (hasMultiSkuValues(arraylist))
        {
            return getVariationQuantityAvailable(arraylist);
        } else
        {
            return quantity - quantitySold;
        }
    }

    public SpannableString getRenderedDate(Context context, com.ebay.common.ConstantsCommon.ItemKind itemkind, Date date, int i, int j, boolean flag, boolean flag1)
    {
        long l = date.getTime() - EbayResponse.currentHostTime();
        boolean flag2;
        if (isScheduled || com.ebay.common.ConstantsCommon.ItemKind.Won == itemkind || com.ebay.common.ConstantsCommon.ItemKind.Sold == itemkind || com.ebay.common.ConstantsCommon.ItemKind.Lost == itemkind || com.ebay.common.ConstantsCommon.ItemKind.Unsold == itemkind)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag && !flag2 && !isAuctionEnded)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            context = Util.formatDayHourMinSec(context, l);
        } else
        {
            itemkind = DateFormat.getMediumDateFormat(context);
            java.text.DateFormat dateformat = DateFormat.getTimeFormat(context);
            context = context.getString(0x7f070048, new Object[] {
                itemkind.format(date), dateformat.format(date)
            });
        }
        itemkind = new SpannableString(context);
        if (i != -1)
        {
            if (isTimeLeftDisplayColorRed(l, flag1))
            {
                i = j;
            }
            itemkind.setSpan(new ForegroundColorSpan(i), 0, context.length(), 0);
        }
        return itemkind;
    }

    public SpannableStringBuilder getShippingMessage(Context context, int i)
    {
        return getShippingMessage(context, i, context.getResources().getColor(0x7f0d0005));
    }

    public SpannableStringBuilder getShippingMessage(Context context, int i, int j)
    {
        String s = ViewItemShippingInfo.getShippingError(context, this);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        boolean flag = false;
        if (s.contains(context.getString(0x7f070175)))
        {
            boolean flag1 = true;
            spannablestringbuilder.append(s);
            flag = flag1;
            if (j > 0)
            {
                String s1 = context.getString(0x7f070175);
                int k = s.indexOf(s1);
                flag = flag1;
                if (k != -1)
                {
                    spannablestringbuilder.setSpan(new ForegroundColorSpan(j), k, s1.length() + k, 33);
                    flag = flag1;
                }
            }
        }
        j = ((flag) ? 1 : 0);
        if (!flag)
        {
            j = ((flag) ? 1 : 0);
            if (s.contains(String.format(context.getString(0x7f07048e), new Object[] {
    ""
})))
            {
                spannablestringbuilder.append(Util.RenderString(s, context.getResources().getColor(0x7f0d0005)));
                j = 1;
            }
        }
        if (j == 0)
        {
            spannablestringbuilder.append(s);
        }
        if (!TextUtils.isEmpty(location))
        {
            spannablestringbuilder.append("\n").append(ViewItemShippingInfo.getLocationAsFrom(context, this, i));
        }
        return spannablestringbuilder;
    }

    public String getVariationId(List list)
    {
        int i = getVariationPosition(list);
        if (i >= 0 && i < variationIds.size())
        {
            return (String)variationIds.get(i);
        } else
        {
            return null;
        }
    }

    public ItemCurrency getVariationPrice(List list)
    {
        int i = getVariationPosition(list);
        if (i >= 0)
        {
            return ((Variation)variations.get(i)).getStartPrice();
        } else
        {
            return null;
        }
    }

    public String getVariationSKU(List list)
    {
        int i = getVariationPosition(list);
        if (i >= 0)
        {
            return ((Variation)variations.get(i)).getSKU();
        } else
        {
            return null;
        }
    }

    public boolean hasAtLeastOneSelection(List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        list = list.iterator();
_L5:
        if (!list.hasNext()) goto _L1; else goto _L3
_L3:
        String s;
        String as[];
        int i;
        boolean flag;
        int k;
        s = ((NameValue)list.next()).getValue();
        flag = false;
        as = mskuNotSelectedStrings;
        k = as.length;
        i = 0;
_L6:
        int j;
        j = ((flag) ? 1 : 0);
        if (i >= k)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!as[i].equals(s))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        j = 0 + 1;
        if (j != 0) goto _L5; else goto _L4
_L4:
        return true;
        i++;
          goto _L6
    }

    public boolean hasMultiSkuValues(List list)
    {
        if (list != null && !list.isEmpty() && mskuNotSelectedStrings != null) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        boolean flag;
        flag = true;
        list = list.iterator();
_L5:
        flag1 = flag;
        if (!list.hasNext()) goto _L4; else goto _L3
_L3:
        NameValue namevalue;
        String as[];
        int i;
        int j;
        namevalue = (NameValue)list.next();
        as = mskuNotSelectedStrings;
        j = as.length;
        i = 0;
_L6:
label0:
        {
            boolean flag2 = flag;
            if (i < j)
            {
                if (!as[i].equals(namevalue.getValue()))
                {
                    break label0;
                }
                flag2 = false;
            }
            flag = flag2;
            if (!flag2)
            {
                return flag2;
            }
        }
          goto _L5
        i++;
          goto _L6
    }

    public boolean isBusinessTypeOkForPurchase()
    {
        String s = MyApp.getPrefs().getUserPref("sellerBusinessType", "Private");
        return !isBsRestrictedToBusiness || s.equals("Commercial");
    }

    public boolean isClassifiedItem()
    {
        return "LeadGeneration".equals(listingType);
    }

    public boolean isHighBidder()
    {
        boolean flag = false;
        if (MyApp.getPrefs().isSignedIn())
        {
            flag = MyApp.getPrefs().getCurrentUser().equals(highBidderUserId);
        }
        return flag;
    }

    public boolean isListingHalfOrLeadGeneration()
    {
        return "Half".equals(listingType) || "LeadGeneration".equals(listingType);
    }

    public boolean isOfferListAllDeclined()
    {
        if (offers != null && offers.size() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1 = true;
        Iterator iterator = offers.iterator();
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!"Declined".equals(((BestOffer)iterator.next()).status))
            {
                return false;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isOfferListAllExpired()
    {
        if (offers != null && offers.size() != 0) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        boolean flag1 = true;
        Iterator iterator = offers.iterator();
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!"Expired".equals(((BestOffer)iterator.next()).status))
            {
                return false;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean isSavings(ItemCurrency itemcurrency)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (currentPrice != null)
            {
                flag = flag1;
                if (itemcurrency != null)
                {
                    if ((new CurrencyAmount(currentPrice)).compareTo(new CurrencyAmount(itemcurrency)) != -1)
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
            return flag;
        }
        return false;
    }

    public boolean isTimeLeftDisplayColorRed(long l, boolean flag)
    {
        boolean flag1 = false;
        long l1;
        if (flag)
        {
            l1 = 0x5265c00L;
        } else
        {
            l1 = 0x36ee80L;
        }
        flag = flag1;
        if (l > 0L)
        {
            flag = flag1;
            if (l < l1)
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isTimeLeftDisplayColorRed(Date date, boolean flag)
    {
        return isTimeLeftDisplayColorRed(date.getTime() - EbayResponse.currentHostTime(), flag);
    }

    public boolean isValidShippingAddress(Address address)
    {
        if (address != null && address.addressFields != null)
        {
            String s = address.addressFields.stateOrProvince;
            if ((!excludeShipToLocations.contains("Alaska/Hawaii") || TextUtils.isEmpty(s) || !s.equals("AK") && !s.equals("HI")) && (!address.isPOBox() || !excludeShipToLocations.contains("PO Box") && !excludeShipToLocations.contains("Packstation")))
            {
                return isValidShippingCountry(address.addressFields.country);
            }
        }
        return false;
    }

    public boolean isValidShippingCountry(String s)
    {
        boolean flag;
        if (site != null && TextUtils.equals(s, EbaySite.getInstanceFromId(site).localeCountry))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!"APO/FPO".equals(s)) goto _L2; else goto _L1
_L1:
        if (!shipToLocations.contains("US") || excludeShipToLocations.contains("US")) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!shipToLocations.contains("Worldwide") && !isWorldwideShipping)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (excludeShipToLocations.contains(s) || !flag && isCountryExcludedViaRegion(s))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
        if (shipToLocations.contains(s) && excludeShipToLocations.contains(s)) goto _L3; else goto _L5
_L5:
        boolean flag1;
        if (shipToLocations.contains(s) && !excludeShipToLocations.contains(s))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
label0:
            {
                Iterator iterator = shipToRegions.iterator();
                boolean flag2;
                do
                {
                    flag2 = flag1;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s1 = (String)iterator.next();
                    if (!shippingRegions.containsKey(s1) || !((HashSet)shippingRegions.get(s1)).contains(s))
                    {
                        continue;
                    }
                    flag2 = true;
                    break;
                } while (true);
                flag1 = flag2;
                if (flag2)
                {
                    break label0;
                }
                iterator = shipToLocations.iterator();
                String s2;
                do
                {
                    flag1 = flag2;
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    s2 = (String)iterator.next();
                } while (!shippingRegions.containsKey(s2) || !((HashSet)shippingRegions.get(s2)).contains(s));
                flag1 = true;
            }
            boolean flag3 = flag1;
            if (flag1)
            {
                flag3 = flag1;
                if (!flag)
                {
                    Iterator iterator1 = excludeShipToRegions.iterator();
                    boolean flag4;
                    do
                    {
                        flag4 = flag1;
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        String s3 = (String)iterator1.next();
                        if (!shippingRegions.containsKey(s3) || !((HashSet)shippingRegions.get(s3)).contains(s))
                        {
                            continue;
                        }
                        flag4 = false;
                        break;
                    } while (true);
                    flag3 = flag4;
                    if (flag4)
                    {
                        if (!excludeShipToLocations.contains(s))
                        {
                            flag3 = true;
                        } else
                        {
                            flag3 = false;
                        }
                    }
                }
            }
            return flag3;
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    public boolean isVatIncluded()
    {
        return isVatIncludedInPrice && ("Germany".equals(site) || "Austria".equals(site) || "Switzerland".equals(site) || "Spain".equals(site));
    }

    public boolean itemHasClosedUnpaidItemDispute()
    {
        boolean flag1 = false;
        Iterator iterator = userDisputes.iterator();
        boolean flag;
        do
        {
            flag = flag1;
            if (!iterator.hasNext())
            {
                break;
            }
            UserDispute userdispute = (UserDispute)iterator.next();
            if (!"Closed".equals(userdispute.state) || id != Long.parseLong(userdispute.itemId) || transactionId == null || !transactionId.equals(Long.valueOf(userdispute.transactionId)))
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    public void mapLogistics(Context context, List list)
    {
        shippingInfo = new ViewItemShippingInfo();
        shippingInfo.initialize(context, list, this);
    }

    public boolean needsToSelectMultiSku(ArrayList arraylist)
    {
        while (!isMultiSku || isTransacted || hasMultiSkuValues(arraylist)) 
        {
            return false;
        }
        return true;
    }

    public BestOffer newestBestOffer(String s)
    {
        if (s != null && offers != null && !offers.isEmpty())
        {
            for (BestOffer bestoffer = (BestOffer)offers.get(offers.size() - 1); s.equalsIgnoreCase(sellerUserId) || s.equals(bestoffer.buyerId);)
            {
                return bestoffer;
            }

        }
        return null;
    }

    public int numberOfPendingBestOffersForSeller()
    {
        int j = 0;
        int i = 0;
        if (offers != null)
        {
            Iterator iterator = offers.iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                BestOffer bestoffer = (BestOffer)iterator.next();
                if ("Pending".equals(bestoffer.status) && ("BuyerBestOffer".equals(bestoffer.codeType) || "BuyerCounterOffer".equals(bestoffer.codeType) || "SellerCounterOffer".equals(bestoffer.codeType)))
                {
                    i++;
                }
            } while (true);
        }
        return j;
    }

    public int numberOfUniqueBuyersWithOffersForSeller()
    {
        HashSet hashset = new HashSet();
        if (offers != null && !offers.isEmpty())
        {
            Iterator iterator = offers.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                BestOffer bestoffer = (BestOffer)iterator.next();
                if (!TextUtils.isEmpty(bestoffer.buyerId))
                {
                    hashset.add(bestoffer.buyerId);
                }
            } while (true);
        }
        return hashset.size();
    }

    public int remainingBestOffersForBuyer(String s)
    {
        int i = 3;
        if (offers == null)
        {
            return 3;
        }
        Iterator iterator = offers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BestOffer bestoffer = (BestOffer)iterator.next();
            if (bestoffer.buyerId.equals(s))
            {
                if (bestoffer.codeType.equals("BuyerBestOffer") || bestoffer.codeType.equals("BuyerCounterOffer"))
                {
                    if (bestoffer.status.equals("Accepted"))
                    {
                        i = 3;
                    } else
                    {
                        i--;
                    }
                } else
                if (bestoffer.codeType.equals("SellerCounterOffer") && bestoffer.status.equals("Accepted"))
                {
                    i = 3;
                }
            }
        } while (true);
        if (i < 0)
        {
            return 0;
        } else
        {
            return i;
        }
    }

    public int remainingBestOffersForSeller(String s)
    {
        int i = 3;
        if (offers == null)
        {
            return 3;
        }
        Iterator iterator = offers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            BestOffer bestoffer = (BestOffer)iterator.next();
            if (bestoffer.buyerId.equals(s))
            {
                if (bestoffer.codeType.equals("SellerCounterOffer"))
                {
                    if (bestoffer.status.equals("Accepted"))
                    {
                        i = 3;
                    } else
                    {
                        i--;
                    }
                } else
                if ((bestoffer.codeType.equals("BuyerBestOffer") || bestoffer.codeType.equals("BuyerCounterOffer")) && bestoffer.status.equals("Accepted"))
                {
                    i = 3;
                }
            }
        } while (true);
        if (i < 0)
        {
            return 0;
        } else
        {
            return i;
        }
    }

    public void setupDisplayStrings(EbayContext ebaycontext, ViewItemViewData viewitemviewdata)
    {
        int i;
        NautilusKernel.verifyMain();
        Context context = (Context)ebaycontext.getExtension(android/content/Context);
        Resources resources = context.getResources();
        Object obj = EbaySite.getInstanceFromId(site);
        String s = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
        boolean flag;
        if (obj != null && ((EbaySite) (obj)).getCurrency() != null && ((EbaySite) (obj)).getCurrency().getCurrencyCode() != null && !((EbaySite) (obj)).getCurrency().getCurrencyCode().equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isDisplayPriceCurrencyCode = flag;
        i = getCurrencyUtilFlag(s);
        if (isDisplayPriceCurrencyCode && buyItNowPrice != null && convertedBuyItNowPrice == null)
        {
            convertedBuyItNowPrice = convertCurrency(ebaycontext, buyItNowPrice);
        }
        if (isMultiSku && isDisplayPriceCurrencyCode)
        {
            if (minVariationPrice != null)
            {
                minVariationPriceConverted = convertCurrency(ebaycontext, minVariationPrice);
            }
            if (maxVariationPrice != null)
            {
                maxVariationPriceConverted = convertCurrency(ebaycontext, maxVariationPrice);
            }
        }
        if (isTransacted)
        {
            obj = addBsfVat(resources, getTransactionPriceString());
        } else
        if (isBidOnly || isClassifiedItem())
        {
            obj = getCurrentPriceString(ebaycontext, viewitemviewdata);
        } else
        {
            obj = getBinPriceString(ebaycontext, viewitemviewdata);
        }
        displayPrice = ((String) (obj));
        if (isTransacted)
        {
            displayPriceCurrency = getTransactionPrice(viewitemviewdata);
        } else
        if (isBidOnly || isClassifiedItem())
        {
            displayPriceCurrency = getCurrentPrice(ebaycontext, viewitemviewdata);
        } else
        if (isMultiSku && !hasMultiSkuValues(viewitemviewdata.nameValueList))
        {
            if (minVariationPrice != null && minVariationPrice.equals(maxVariationPrice))
            {
                displayPriceCurrency = minVariationPrice;
            } else
            {
                buildConvertedRangePrice(context, minVariationPriceConverted, maxVariationPriceConverted);
            }
        } else
        {
            displayPriceCurrency = buyItNowPrice;
        }
        if (isDisplayPriceCurrencyCode && displayPriceCurrency != null && s.equals(displayPriceCurrency.code))
        {
            isDisplayPriceCurrencyCode = false;
        }
        if (isDisplayPriceCurrencyCode && displayPriceCurrency != null)
        {
            displayPriceConvertedCurrency = convertCurrency(ebaycontext, displayPriceCurrency);
            if (displayPriceConvertedCurrency != null)
            {
                displayPriceConverted = addBsfVat(resources, EbayCurrencyUtil.formatDisplay(displayPriceConvertedCurrency, i));
            }
        }
        if ((isBidOnly || isBidWithBin || isClassifiedItem()) && currentPrice != null)
        {
            displayCurrentPrice = addBsfVat(resources, EbayCurrencyUtil.formatDisplay(currentPrice, i));
            convertedCurrentPrice = convertCurrency(ebaycontext, currentPrice);
            if (convertedCurrentPrice != null)
            {
                displayCurrentPriceConverted = addBsfVat(resources, EbayCurrencyUtil.formatDisplay(convertedCurrentPrice, i));
            }
        }
        setupShippingDisplayPrices(context, this);
        setupShippingDisplayPricesConverted(ebaycontext, this);
        setupSTP(ebaycontext, viewitemviewdata);
        if (originalRetailPrice != null || viewitemviewdata.originalRetailPrice != null)
        {
            if (originalRetailPrice != null)
            {
                obj = originalRetailPrice;
            } else
            {
                obj = viewitemviewdata.originalRetailPrice;
            }
            showSavings(context, viewitemviewdata, ((ItemCurrency) (obj)), currentPrice);
        }
        if (!isGspItem || shippingInfo.importCharge == null) goto _L2; else goto _L1
_L1:
        importCharges = shippingInfo.importCharge;
        if (!(new CurrencyAmount(importCharges)).isZero()) goto _L4; else goto _L3
_L3:
        displayPriceImportCharges = context.getString(0x7f070421);
        displayPriceImportChargesConverted = displayPriceImportCharges;
_L2:
        displayPricePerUnit = getUnitPriceString(buyItNowPrice);
        if (convertedBuyItNowPrice != null)
        {
            displayPricePerUnitConverted = getUnitPriceString(convertedBuyItNowPrice);
        }
        if (isShowItemCard)
        {
            setupItemCard(ebaycontext);
        }
        if (isHotnessCharity)
        {
            setupHotnessCharityString(context);
        }
        setupBuyerResponsibleForLogisticsString(context);
        return;
_L4:
        displayPriceImportChargesCurrency = importCharges;
        displayPriceImportCharges = EbayCurrencyUtil.formatDisplay(importCharges, i);
        if (isDisplayPriceCurrencyCode)
        {
            importChargesConverted = convertCurrency(ebaycontext, importCharges);
            if (importChargesConverted != null)
            {
                displayPriceImportChargesConverted = EbayCurrencyUtil.formatDisplay(importChargesConverted, i);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setupEbayPlusNonMember(EbayContext ebaycontext, Item item)
    {
        if (item.isShowEbayPlusPromo)
        {
            boolean flag;
            boolean flag1;
            long l;
            if (eBayPlusOrderTodayEndTime != null)
            {
                l = eBayPlusOrderTodayEndTime.getTime() - EbayResponse.currentHostTime();
            } else
            {
                l = 0L;
            }
            if (l > 0L && l < 0x5265c00L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = false;
            if (eBayPlusOrderTodayEndTime != null)
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(eBayPlusOrderTodayEndTime);
                Calendar calendar1 = Calendar.getInstance();
                if (calendar.get(5) == calendar1.get(5))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            if (item.eBayPlusShippingOption != null && (item.eBayPlusShippingOption.isHandlingTimeSameDayAvailable || flag1 && flag))
            {
                String s;
                if (item.eBayPlusShippingOption.sameDayCutOff != null)
                {
                    s = Util.getFormattedTimeStringFromDate((Context)ebaycontext.getExtension(android/content/Context), item.eBayPlusShippingOption.sameDayCutOff);
                } else
                {
                    s = null;
                }
                if (!TextUtils.isEmpty(s))
                {
                    String s1 = Util.getDeliveryDateString((Context)ebaycontext.getExtension(android/content/Context), item.eBayPlusShippingOption.estimatedDeliveryMinTime, true);
                    String s2 = Util.getDeliveryDateString((Context)ebaycontext.getExtension(android/content/Context), item.eBayPlusShippingOption.estimatedDeliveryMaxTime, true);
                    if (!TextUtils.isEmpty(s1))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!TextUtils.isEmpty(s2))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag && flag1 && !s1.equals(s2))
                    {
                        item.displayEbayPlusSignupDescription = String.format(ebaycontext.getString(0x7f07037d), new Object[] {
                            s1, s2, s
                        });
                    } else
                    {
                        String s3 = ebaycontext.getString(0x7f07037c);
                        if (!flag)
                        {
                            s1 = s2;
                        }
                        item.displayEbayPlusSignupDescription = String.format(s3, new Object[] {
                            s1, s
                        });
                    }
                }
            }
            if (TextUtils.isEmpty(item.displayEbayPlusSignupDescription))
            {
                item.displayEbayPlusSignupDescription = ebaycontext.getString(0x7f07037e);
            }
            isEbayPlusLogoShown = true;
        }
        item.isShowItemCard = false;
    }

    public boolean showBuyAnother(Context context, ViewItemViewData viewitemviewdata)
    {
        return showBuyAnotherWithoutRegardToPayPal(context, viewitemviewdata) && ItemViewPayPalable.canUsePaypal(context, this);
    }

    public boolean showBuyAnotherWithoutRegardToPayPal(Context context, ViewItemViewData viewitemviewdata)
    {
        return isTransacted && !isSeller && !isAuctionEnded && isListingTypeBin && getQuantityAvailable(viewitemviewdata.nameValueList) > 0 && !isListingHalfOrLeadGeneration();
    }

    public void updatePaymentReminderState(boolean flag)
    {
        PaymentReminderState paymentreminderstate;
        if (flag)
        {
            paymentreminderstate = PaymentReminderState.STATE_SENT;
        } else
        if (isPaymentReminderActivationTimeElaspsed)
        {
            paymentreminderstate = PaymentReminderState.STATE_ENABLED;
        } else
        {
            paymentreminderstate = PaymentReminderState.STATE_DISABLED;
        }
        paymentReminderState = paymentreminderstate;
    }

}
