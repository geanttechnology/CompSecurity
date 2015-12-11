// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.os.Parcel;
import android.text.Html;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.BaseListingType;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.image.ZoomImageId;
import com.ebay.nautilus.kernel.util.DelimitedStringBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Listing extends BaseListingType
{
    public static final class ApplicableTax
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Region jurisdiction;
        public List properties;
        public Boolean salesTaxAppliedToShipping;
        public com.ebay.nautilus.domain.data.BaseCommonType.Region state;
        public double taxRate;
        public TaxTypeEnum taxType;

        public ApplicableTax()
        {
        }
    }

    public static final class AvailabilityStatusEnum extends Enum
    {

        private static final AvailabilityStatusEnum $VALUES[];
        public static final AvailabilityStatusEnum IN_STOCK;
        public static final AvailabilityStatusEnum LIMITED_STOCK;
        public static final AvailabilityStatusEnum OUT_OF_STOCK;

        public static AvailabilityStatusEnum valueOf(String s)
        {
            return (AvailabilityStatusEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$AvailabilityStatusEnum, s);
        }

        public static AvailabilityStatusEnum[] values()
        {
            return (AvailabilityStatusEnum[])$VALUES.clone();
        }

        static 
        {
            IN_STOCK = new AvailabilityStatusEnum("IN_STOCK", 0);
            LIMITED_STOCK = new AvailabilityStatusEnum("LIMITED_STOCK", 1);
            OUT_OF_STOCK = new AvailabilityStatusEnum("OUT_OF_STOCK", 2);
            $VALUES = (new AvailabilityStatusEnum[] {
                IN_STOCK, LIMITED_STOCK, OUT_OF_STOCK
            });
        }

        private AvailabilityStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AvatarImage
    {

        public String imageURL;

        public AvatarImage()
        {
        }
    }

    public static final class BestOfferSettings
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount autoAcceptOfferPrice;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount autoDeclineOfferPrice;
        public int bestOfferCount;
        public boolean bestOfferEnabled;

        public BestOfferSettings()
        {
        }
    }

    public static final class BrandDetail
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text brandName;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text description;
        public Map logoURLs;
        public List notes;

        public BrandDetail()
        {
        }
    }

    public static final class BusinessUserExtension
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text additionalContactInformation;
        public String additionalEmailAddress;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text businessName;
        public String fax;
        public Boolean legalInvoiceAvailable;
        public com.ebay.nautilus.domain.data.BaseCommonType.Address registeredAddress;
        public Phone registeredPhone;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text termsAndConditions;
        public String tradeRegistrationNumber;
        public String vatId;
        public String vatIssuingCountryId;
        public Double vatPercent;

        public BusinessUserExtension()
        {
        }
    }

    public static final class BuyerProtectionPolicy
    {

        public BuyerProtectionProgramEnum buyerProtectionProgram;
        public com.ebay.nautilus.domain.data.BaseCommonType.Property buyerProtectionProperties;
        public BuyerProtectionStatusEnum buyerProtectionStatus;

        public BuyerProtectionPolicy()
        {
        }
    }

    public static final class BuyerProtectionProgramEnum extends Enum
    {

        private static final BuyerProtectionProgramEnum $VALUES[];
        public static final BuyerProtectionProgramEnum EBAY_BUYER_PROTECTION;
        public static final BuyerProtectionProgramEnum EBAY_VEHICLE_PURCHASE_PROTECTION;
        public static final BuyerProtectionProgramEnum PAYPAL_BUYER_PROTECTION;

        public static BuyerProtectionProgramEnum valueOf(String s)
        {
            return (BuyerProtectionProgramEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$BuyerProtectionProgramEnum, s);
        }

        public static BuyerProtectionProgramEnum[] values()
        {
            return (BuyerProtectionProgramEnum[])$VALUES.clone();
        }

        static 
        {
            EBAY_BUYER_PROTECTION = new BuyerProtectionProgramEnum("EBAY_BUYER_PROTECTION", 0);
            PAYPAL_BUYER_PROTECTION = new BuyerProtectionProgramEnum("PAYPAL_BUYER_PROTECTION", 1);
            EBAY_VEHICLE_PURCHASE_PROTECTION = new BuyerProtectionProgramEnum("EBAY_VEHICLE_PURCHASE_PROTECTION", 2);
            $VALUES = (new BuyerProtectionProgramEnum[] {
                EBAY_BUYER_PROTECTION, PAYPAL_BUYER_PROTECTION, EBAY_VEHICLE_PURCHASE_PROTECTION
            });
        }

        private BuyerProtectionProgramEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class BuyerProtectionStatusEnum extends Enum
    {

        private static final BuyerProtectionStatusEnum $VALUES[];
        public static final BuyerProtectionStatusEnum ELIGIBLE;
        public static final BuyerProtectionStatusEnum NOT_ELIGIBLE;
        public static final BuyerProtectionStatusEnum NO_COVERAGE;

        public static BuyerProtectionStatusEnum valueOf(String s)
        {
            return (BuyerProtectionStatusEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$BuyerProtectionStatusEnum, s);
        }

        public static BuyerProtectionStatusEnum[] values()
        {
            return (BuyerProtectionStatusEnum[])$VALUES.clone();
        }

        static 
        {
            ELIGIBLE = new BuyerProtectionStatusEnum("ELIGIBLE", 0);
            NOT_ELIGIBLE = new BuyerProtectionStatusEnum("NOT_ELIGIBLE", 1);
            NO_COVERAGE = new BuyerProtectionStatusEnum("NO_COVERAGE", 2);
            $VALUES = (new BuyerProtectionStatusEnum[] {
                ELIGIBLE, NOT_ELIGIBLE, NO_COVERAGE
            });
        }

        private BuyerProtectionStatusEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class BuyerRestrictions
    {

        public Frequency buyerPolicyViolationThreshold;
        public Integer minFeedbackScore;
        public List purchaseRestrictions;
        public Boolean requirePayPalAccount;
        public Boolean resideInShipToLocation;
        public Frequency unpaidTransactionStrikesThreshold;
        public Boolean verifiedUser;

        public BuyerRestrictions()
        {
        }
    }

    public static final class Category
    {

        public String categoryId;
        public List categorySpecificAspect;
        public List categorySpecificConditions;
        public List children;
        public boolean leafCategory;
        public int level;
        public com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum marketplaceId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text name;
        public Category parent;
        public com.ebay.nautilus.domain.data.BaseCommonType.NameValues properties;

        public Category()
        {
        }
    }

    public static final class CategoryIdentifier
    {

        public long categoryId;
        public Integer level;
        public com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum marketplaceId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text name;

        public CategoryIdentifier()
        {
        }
    }

    public static final class CategoryPathFromRoot
    {

        public List categoryIdentifier;
        public List consolidatedCategoryProperties;

        public CategoryPathFromRoot()
        {
        }
    }

    public static final class CategorySpecificAspect
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text abbreviatedName;
        public List categorySpecificAspectValue;
        public String globalIdentifier;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text name;

        public CategorySpecificAspect()
        {
        }
    }

    public static final class CategorySpecificAspectValue
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text value;

        public CategorySpecificAspectValue()
        {
        }
    }

    public static final class CharityTerms
    {

        public String charityId;
        public String charityNumber;
        public String charityWebsite;
        public Double donationPercentage;
        public String logoURL;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text missionStatement;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text name;

        public CharityTerms()
        {
        }
    }

    public static final class Code
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text displayName;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text displayNameSuperscript;
        public String value;

        public Code()
        {
        }
    }

    public static final class CompatibilityDetail
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public CompatibilityItem createFromParcel(Parcel parcel)
            {
                return (CompatibilityItem)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/net/api/viewlisting/Listing$CompatibilityItem);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public CompatibilityItem[] newArray(int i)
            {
                return new CompatibilityItem[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public List compatibilityProperties;
        public int totalCompatibilityCount;


        public CompatibilityDetail()
        {
        }
    }

    public static final class CompatibilityItem extends LinkedHashMap
    {

        public CompatibilityItem()
        {
        }
    }

    public static final class Condition
    {

        public String conditionHelpId;
        public String conditionId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text description;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text name;

        public Condition()
        {
        }
    }

    public static final class DataTypeEnum extends Enum
    {

        private static final DataTypeEnum $VALUES[];
        public static final DataTypeEnum DATE;
        public static final DataTypeEnum DOUBLE;
        public static final DataTypeEnum INT;
        public static final DataTypeEnum LONG;
        public static final DataTypeEnum STRING;

        public static DataTypeEnum valueOf(String s)
        {
            return (DataTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$DataTypeEnum, s);
        }

        public static DataTypeEnum[] values()
        {
            return (DataTypeEnum[])$VALUES.clone();
        }

        static 
        {
            INT = new DataTypeEnum("INT", 0);
            LONG = new DataTypeEnum("LONG", 1);
            DOUBLE = new DataTypeEnum("DOUBLE", 2);
            DATE = new DataTypeEnum("DATE", 3);
            STRING = new DataTypeEnum("STRING", 4);
            $VALUES = (new DataTypeEnum[] {
                INT, LONG, DOUBLE, DATE, STRING
            });
        }

        private DataTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class DeliveryEstimate
    {

        public List estimateTreatment;
        public TimeEstimate timeEstimate;

        public DeliveryEstimate()
        {
        }
    }

    public static final class DeliveryEstimateTreatmentEnum extends Enum
    {

        private static final DeliveryEstimateTreatmentEnum $VALUES[];
        public static final DeliveryEstimateTreatmentEnum ANALYTICAL_TWO_DAY_SHIPPING;
        public static final DeliveryEstimateTreatmentEnum EBAY_NOW_IMMEDIATE;
        public static final DeliveryEstimateTreatmentEnum EBAY_NOW_NEXT_DAY;
        public static final DeliveryEstimateTreatmentEnum EBAY_NOW_SAME_DAY;
        public static final DeliveryEstimateTreatmentEnum EBAY_NOW_SCHEDULED;
        public static final DeliveryEstimateTreatmentEnum FAST_AND_FREE;
        public static final DeliveryEstimateTreatmentEnum GURANTEED_HOLIDAY_DELIVERY;
        public static final DeliveryEstimateTreatmentEnum NONE;
        public static final DeliveryEstimateTreatmentEnum ONE_DAY_DISPATCH;
        public static final DeliveryEstimateTreatmentEnum SHIPMENT_DELIVERY_ESTIMATE_ACCURACY;
        public static final DeliveryEstimateTreatmentEnum TWO_DAY_SHIPPING;
        public static final DeliveryEstimateTreatmentEnum UNKNOWN;

        public static DeliveryEstimateTreatmentEnum valueOf(String s)
        {
            return (DeliveryEstimateTreatmentEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$DeliveryEstimateTreatmentEnum, s);
        }

        public static DeliveryEstimateTreatmentEnum[] values()
        {
            return (DeliveryEstimateTreatmentEnum[])$VALUES.clone();
        }

        static 
        {
            NONE = new DeliveryEstimateTreatmentEnum("NONE", 0);
            GURANTEED_HOLIDAY_DELIVERY = new DeliveryEstimateTreatmentEnum("GURANTEED_HOLIDAY_DELIVERY", 1);
            FAST_AND_FREE = new DeliveryEstimateTreatmentEnum("FAST_AND_FREE", 2);
            SHIPMENT_DELIVERY_ESTIMATE_ACCURACY = new DeliveryEstimateTreatmentEnum("SHIPMENT_DELIVERY_ESTIMATE_ACCURACY", 3);
            ONE_DAY_DISPATCH = new DeliveryEstimateTreatmentEnum("ONE_DAY_DISPATCH", 4);
            TWO_DAY_SHIPPING = new DeliveryEstimateTreatmentEnum("TWO_DAY_SHIPPING", 5);
            ANALYTICAL_TWO_DAY_SHIPPING = new DeliveryEstimateTreatmentEnum("ANALYTICAL_TWO_DAY_SHIPPING", 6);
            EBAY_NOW_IMMEDIATE = new DeliveryEstimateTreatmentEnum("EBAY_NOW_IMMEDIATE", 7);
            EBAY_NOW_SCHEDULED = new DeliveryEstimateTreatmentEnum("EBAY_NOW_SCHEDULED", 8);
            EBAY_NOW_NEXT_DAY = new DeliveryEstimateTreatmentEnum("EBAY_NOW_NEXT_DAY", 9);
            EBAY_NOW_SAME_DAY = new DeliveryEstimateTreatmentEnum("EBAY_NOW_SAME_DAY", 10);
            UNKNOWN = new DeliveryEstimateTreatmentEnum("UNKNOWN", 11);
            $VALUES = (new DeliveryEstimateTreatmentEnum[] {
                NONE, GURANTEED_HOLIDAY_DELIVERY, FAST_AND_FREE, SHIPMENT_DELIVERY_ESTIMATE_ACCURACY, ONE_DAY_DISPATCH, TWO_DAY_SHIPPING, ANALYTICAL_TWO_DAY_SHIPPING, EBAY_NOW_IMMEDIATE, EBAY_NOW_SCHEDULED, EBAY_NOW_NEXT_DAY, 
                EBAY_NOW_SAME_DAY, UNKNOWN
            });
        }

        private DeliveryEstimateTreatmentEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static class DeliveryEstimateTreatmentEnum.Deserializer
        implements JsonDeserializer
    {

        public DeliveryEstimateTreatmentEnum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            if (!TextUtils.isEmpty(jsonelement))
            {
                type = DeliveryEstimateTreatmentEnum.values();
                int j = type.length;
                for (int i = 0; i < j; i++)
                {
                    jsondeserializationcontext = type[i];
                    if (TextUtils.equals(jsondeserializationcontext.name(), jsonelement))
                    {
                        return jsondeserializationcontext;
                    }
                }

            }
            if ("EBAY_FAST_AND_FREE".equals(jsonelement))
            {
                return DeliveryEstimateTreatmentEnum.FAST_AND_FREE;
            } else
            {
                return DeliveryEstimateTreatmentEnum.UNKNOWN;
            }
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public DeliveryEstimateTreatmentEnum.Deserializer()
        {
        }
    }

    public static final class DigitalMedia
    {

        public Image image;

        public DigitalMedia()
        {
        }
    }

    public static class DiscountPrice
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount discountAmount;
        public Double discountPercentage;
        public DiscountPriceTypeEnum discountPriceType;
        protected transient Map discountPropertiesMap;
        public List properties;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount suggestedRetailPrice;

        public Map getDiscountProperties()
        {
            if (discountPropertiesMap == null)
            {
                discountPropertiesMap = new HashMap();
                if (properties != null)
                {
                    Iterator iterator = properties.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        com.ebay.nautilus.domain.data.BaseCommonType.Property property = (com.ebay.nautilus.domain.data.BaseCommonType.Property)iterator.next();
                        if (property != null)
                        {
                            discountPropertiesMap.put(property.propertyName, property.propertyValues);
                        }
                    } while (true);
                }
            }
            return discountPropertiesMap;
        }

        public DiscountPrice()
        {
        }
    }

    public static final class DiscountPriceTypeEnum extends Enum
    {

        private static final DiscountPriceTypeEnum $VALUES[];
        public static final DiscountPriceTypeEnum CATEGORY_DEALS_PRICE;
        public static final DiscountPriceTypeEnum DAILY_DEALS_PRICE;
        public static final DiscountPriceTypeEnum MADE_FOR_OUTLET_PRICE;
        public static final DiscountPriceTypeEnum MARK_DOWN_MANAGER_PRICE;
        public static final DiscountPriceTypeEnum MINIMUM_ADVERTISED_PRICE;
        public static final DiscountPriceTypeEnum ORIGINAL_PRICE;
        public static final DiscountPriceTypeEnum STRIKE_THROUGH_PRICE;

        public static DiscountPriceTypeEnum valueOf(String s)
        {
            return (DiscountPriceTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$DiscountPriceTypeEnum, s);
        }

        public static DiscountPriceTypeEnum[] values()
        {
            return (DiscountPriceTypeEnum[])$VALUES.clone();
        }

        static 
        {
            STRIKE_THROUGH_PRICE = new DiscountPriceTypeEnum("STRIKE_THROUGH_PRICE", 0);
            MINIMUM_ADVERTISED_PRICE = new DiscountPriceTypeEnum("MINIMUM_ADVERTISED_PRICE", 1);
            ORIGINAL_PRICE = new DiscountPriceTypeEnum("ORIGINAL_PRICE", 2);
            MADE_FOR_OUTLET_PRICE = new DiscountPriceTypeEnum("MADE_FOR_OUTLET_PRICE", 3);
            MARK_DOWN_MANAGER_PRICE = new DiscountPriceTypeEnum("MARK_DOWN_MANAGER_PRICE", 4);
            DAILY_DEALS_PRICE = new DiscountPriceTypeEnum("DAILY_DEALS_PRICE", 5);
            CATEGORY_DEALS_PRICE = new DiscountPriceTypeEnum("CATEGORY_DEALS_PRICE", 6);
            $VALUES = (new DiscountPriceTypeEnum[] {
                STRIKE_THROUGH_PRICE, MINIMUM_ADVERTISED_PRICE, ORIGINAL_PRICE, MADE_FOR_OUTLET_PRICE, MARK_DOWN_MANAGER_PRICE, DAILY_DEALS_PRICE, CATEGORY_DEALS_PRICE
            });
        }

        private DiscountPriceTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EbayStore
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text displayName;
        public boolean hideListingDuringVacation;
        public StoreLevelEnum level;
        public String name;
        public boolean onVacation;
        public List storeCategories;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text vacationMessage;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime vacationReturnDate;

        public EbayStore()
        {
        }
    }

    public static final class EndReasonEnum extends Enum
    {

        private static final EndReasonEnum $VALUES[];
        public static final EndReasonEnum ENDED_BY_ADMIN;
        public static final EndReasonEnum ENDED_BY_SELLER;
        public static final EndReasonEnum ENDED_WITH_AUCTION;
        public static final EndReasonEnum ENDED_WITH_BEST_OFFER;
        public static final EndReasonEnum ENDED_WITH_BUY_IT_NOW;
        public static final EndReasonEnum ENDED_WITH_EXPIRATION;

        public static EndReasonEnum valueOf(String s)
        {
            return (EndReasonEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$EndReasonEnum, s);
        }

        public static EndReasonEnum[] values()
        {
            return (EndReasonEnum[])$VALUES.clone();
        }

        static 
        {
            ENDED_BY_ADMIN = new EndReasonEnum("ENDED_BY_ADMIN", 0);
            ENDED_BY_SELLER = new EndReasonEnum("ENDED_BY_SELLER", 1);
            ENDED_WITH_EXPIRATION = new EndReasonEnum("ENDED_WITH_EXPIRATION", 2);
            ENDED_WITH_AUCTION = new EndReasonEnum("ENDED_WITH_AUCTION", 3);
            ENDED_WITH_BEST_OFFER = new EndReasonEnum("ENDED_WITH_BEST_OFFER", 4);
            ENDED_WITH_BUY_IT_NOW = new EndReasonEnum("ENDED_WITH_BUY_IT_NOW", 5);
            $VALUES = (new EndReasonEnum[] {
                ENDED_BY_ADMIN, ENDED_BY_SELLER, ENDED_WITH_EXPIRATION, ENDED_WITH_AUCTION, ENDED_WITH_BEST_OFFER, ENDED_WITH_BUY_IT_NOW
            });
        }

        private EndReasonEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ExecutorTypeEnum extends Enum
    {

        private static final ExecutorTypeEnum $VALUES[];
        public static final ExecutorTypeEnum BUYER;
        public static final ExecutorTypeEnum EBAY;
        public static final ExecutorTypeEnum SELLER;

        public static ExecutorTypeEnum valueOf(String s)
        {
            return (ExecutorTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ExecutorTypeEnum, s);
        }

        public static ExecutorTypeEnum[] values()
        {
            return (ExecutorTypeEnum[])$VALUES.clone();
        }

        static 
        {
            BUYER = new ExecutorTypeEnum("BUYER", 0);
            SELLER = new ExecutorTypeEnum("SELLER", 1);
            EBAY = new ExecutorTypeEnum("EBAY", 2);
            $VALUES = (new ExecutorTypeEnum[] {
                BUYER, SELLER, EBAY
            });
        }

        private ExecutorTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ExposureEnhancementDetail
    {

        public List enhancements;

        public ExposureEnhancementDetail()
        {
        }
    }

    public static final class ExternalProductIdentifierTypeEnum extends Enum
    {

        private static final ExternalProductIdentifierTypeEnum $VALUES[];
        public static final ExternalProductIdentifierTypeEnum ASIN;
        public static final ExternalProductIdentifierTypeEnum BUY;
        public static final ExternalProductIdentifierTypeEnum GOOG;
        public static final ExternalProductIdentifierTypeEnum GTIN;

        public static ExternalProductIdentifierTypeEnum valueOf(String s)
        {
            return (ExternalProductIdentifierTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ExternalProductIdentifierTypeEnum, s);
        }

        public static ExternalProductIdentifierTypeEnum[] values()
        {
            return (ExternalProductIdentifierTypeEnum[])$VALUES.clone();
        }

        static 
        {
            ASIN = new ExternalProductIdentifierTypeEnum("ASIN", 0);
            GOOG = new ExternalProductIdentifierTypeEnum("GOOG", 1);
            BUY = new ExternalProductIdentifierTypeEnum("BUY", 2);
            GTIN = new ExternalProductIdentifierTypeEnum("GTIN", 3);
            $VALUES = (new ExternalProductIdentifierTypeEnum[] {
                ASIN, GOOG, BUY, GTIN
            });
        }

        private ExternalProductIdentifierTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ExternalProductIdentity
    {

        public String externalProductId;
        public ExternalProductIdentifierTypeEnum externalProductIdentifierType;
        public GTINTypeEnum globalTradeItemNumberType;

        public ExternalProductIdentity()
        {
        }
    }

    public static final class FreightStepExtension extends LogisticsStepExtension
    {

        public boolean destinationPickupInside;
        public LogisticsLocation destiniationPickupLocation;
        public String freightItemType;
        public String freightService;
        public boolean originPickupInside;
        public LogisticsLocation originPickupLocation;
        public boolean packagingHelpRequired;
        public int rank;
        public LogisticsOptionRankScopeEnum rankScope;

        public FreightStepExtension()
        {
        }
    }

    public static final class Frequency
    {

        public int count;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration period;

        public Frequency()
        {
        }
    }

    public static final class GTINTypeEnum extends Enum
    {

        private static final GTINTypeEnum $VALUES[];
        public static final GTINTypeEnum EAN;
        public static final GTINTypeEnum GTIN;
        public static final GTINTypeEnum ISBN;
        public static final GTINTypeEnum UPC;

        public static GTINTypeEnum valueOf(String s)
        {
            return (GTINTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$GTINTypeEnum, s);
        }

        public static GTINTypeEnum[] values()
        {
            return (GTINTypeEnum[])$VALUES.clone();
        }

        static 
        {
            GTIN = new GTINTypeEnum("GTIN", 0);
            UPC = new GTINTypeEnum("UPC", 1);
            EAN = new GTINTypeEnum("EAN", 2);
            ISBN = new GTINTypeEnum("ISBN", 3);
            $VALUES = (new GTINTypeEnum[] {
                GTIN, UPC, EAN, ISBN
            });
        }

        private GTINTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class HandlingPolicy
    {

        public boolean businessDaysOnly;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount handlingCost;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration handlingTime;
        public Date sameDayCutOff;
        public Long sameDayCutOffTime;
        public boolean sameDayHandling;

        public HandlingPolicy()
        {
        }
    }

    public static final class Image
    {

        public ImageEncodingEnum encoding;
        public String hostingPlatform;
        public String imageURL;
        public ImageURLElements imageURLElements;
        public String imageURLType;
        public String origin;
        public ImageSize originalSize;
        public ImageSize size;
        public String uploadMethod;

        public ZoomImageId getZoomImageId()
        {
            while (imageURLElements == null || TextUtils.isEmpty(imageURLElements.zoomGuid) && TextUtils.isEmpty(imageURLElements.md5Hash)) 
            {
                return null;
            }
            return new ZoomImageId(imageURLElements.zoomGuid, imageURLElements.md5Hash);
        }

        public Image()
        {
        }
    }

    public static final class ImageEncodingEnum extends Enum
    {

        private static final ImageEncodingEnum $VALUES[];
        public static final ImageEncodingEnum GIF;
        public static final ImageEncodingEnum GMP;
        public static final ImageEncodingEnum JPEG;
        public static final ImageEncodingEnum PNG;
        public static final ImageEncodingEnum WEBP;

        public static ImageEncodingEnum valueOf(String s)
        {
            return (ImageEncodingEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ImageEncodingEnum, s);
        }

        public static ImageEncodingEnum[] values()
        {
            return (ImageEncodingEnum[])$VALUES.clone();
        }

        static 
        {
            JPEG = new ImageEncodingEnum("JPEG", 0);
            GIF = new ImageEncodingEnum("GIF", 1);
            PNG = new ImageEncodingEnum("PNG", 2);
            GMP = new ImageEncodingEnum("GMP", 3);
            WEBP = new ImageEncodingEnum("WEBP", 4);
            $VALUES = (new ImageEncodingEnum[] {
                JPEG, GIF, PNG, GMP, WEBP
            });
        }

        private ImageEncodingEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ImageOriginEnum extends Enum
    {

        private static final ImageOriginEnum $VALUES[];
        public static final ImageOriginEnum EBAY_CATALOG;
        public static final ImageOriginEnum SELLER;

        public static ImageOriginEnum valueOf(String s)
        {
            return (ImageOriginEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ImageOriginEnum, s);
        }

        public static ImageOriginEnum[] values()
        {
            return (ImageOriginEnum[])$VALUES.clone();
        }

        static 
        {
            SELLER = new ImageOriginEnum("SELLER", 0);
            EBAY_CATALOG = new ImageOriginEnum("EBAY_CATALOG", 1);
            $VALUES = (new ImageOriginEnum[] {
                SELLER, EBAY_CATALOG
            });
        }

        private ImageOriginEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ImageSize
    {

        public Integer height;
        public Float sizeInKB;
        public Integer width;

        public ImageSize()
        {
        }
    }

    public static final class ImageURLElements
    {

        public String md5Hash;
        public String zoomGuid;

        public ImageURLElements()
        {
        }
    }

    public static final class ItemVariation
    {

        public List aspects;
        public BestOfferSettings bestOfferSettings;
        public List images;
        public String itemVariationId;
        public ItemVariationTradingSummary itemVariationTradingSummary;
        public PriceSettings priceSettings;
        public Product product;
        public PurchasingQuantityTerms purchasingQuantityTerms;
        public List quantityAndAvailabilityByLogisticsPlans;
        private transient Integer quantityAvailable;
        private transient Integer quantitySold;
        public String sellerProvidedSKU;
        public UserToItemVariationRelationshipSummary userToItemVariationRelationshipSummary;
        public String variationId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text variationTitle;

        private void computeQuantities()
        {
            int j = 0;
            int i = 0;
            Iterator iterator = quantityAndAvailabilityByLogisticsPlans.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                QuantityAndAvailabilityByLogisticsPlans quantityandavailabilitybylogisticsplans = (QuantityAndAvailabilityByLogisticsPlans)iterator.next();
                if (quantityandavailabilitybylogisticsplans.quantityAndAvailability != null)
                {
                    int k = j;
                    if (quantityandavailabilitybylogisticsplans.quantityAndAvailability.soldQuantity != null)
                    {
                        k = j + quantityandavailabilitybylogisticsplans.quantityAndAvailability.soldQuantity.intValue();
                    }
                    j = k;
                    if (quantityandavailabilitybylogisticsplans.quantityAndAvailability.availableQuantity != null)
                    {
                        i += quantityandavailabilitybylogisticsplans.quantityAndAvailability.availableQuantity.intValue();
                        j = k;
                    }
                }
            } while (true);
            quantitySold = Integer.valueOf(j);
            quantityAvailable = Integer.valueOf(i);
        }

        public int getQuantityAvailable()
        {
            if (quantityAvailable == null)
            {
                computeQuantities();
            }
            return quantityAvailable.intValue();
        }

        public int getQuantitySold()
        {
            if (quantitySold == null)
            {
                computeQuantities();
            }
            return quantitySold.intValue();
        }

        public ItemVariation()
        {
        }
    }

    public static final class ItemVariationTradingSummary
    {

        public Boolean auctionReservePriceSet;
        public Integer bidCount;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount currentBidPrice;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount currentBidPriceWithoutVAT;
        public String highBidderUsername;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount minNextBidPrice;
        public Integer pendingOfferCount;
        public List quickBidOptions;
        public Boolean reservePriceMet;
        public Integer retractedBidCount;
        public Integer uniqueBidderCount;
        public Integer watchCount;

        public ItemVariationTradingSummary()
        {
        }
    }

    public static final class ListingAncestry
    {

        public List childrenListingIds;
        public ListingModeEnum creationMode;
        public String parentListingId;

        public ListingAncestry()
        {
        }
    }

    public static final class ListingClassification
    {

        public ListingCondition generalCondition;
        public boolean inAdultCategory;
        public List leafCategories;
        public ListingRankedCategory leafStoreCategories;
        public Product product;
        public boolean productIdentifiedByeBay;
        public List sellerSpecifiedAspect;

        public ListingClassification()
        {
        }
    }

    public static final class ListingCondition
    {

        public Condition condition;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text sellerProvidedDescription;

        public ListingCondition()
        {
        }
    }

    public static final class ListingDurationEnum extends Enum
    {

        private static final ListingDurationEnum $VALUES[];
        public static final ListingDurationEnum DAYS_1;
        public static final ListingDurationEnum DAYS_10;
        public static final ListingDurationEnum DAYS_120;
        public static final ListingDurationEnum DAYS_14;
        public static final ListingDurationEnum DAYS_21;
        public static final ListingDurationEnum DAYS_3;
        public static final ListingDurationEnum DAYS_30;
        public static final ListingDurationEnum DAYS_5;
        public static final ListingDurationEnum DAYS_60;
        public static final ListingDurationEnum DAYS_7;
        public static final ListingDurationEnum DAYS_90;
        public static final ListingDurationEnum GTC;

        public static ListingDurationEnum valueOf(String s)
        {
            return (ListingDurationEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ListingDurationEnum, s);
        }

        public static ListingDurationEnum[] values()
        {
            return (ListingDurationEnum[])$VALUES.clone();
        }

        static 
        {
            DAYS_1 = new ListingDurationEnum("DAYS_1", 0);
            DAYS_3 = new ListingDurationEnum("DAYS_3", 1);
            DAYS_5 = new ListingDurationEnum("DAYS_5", 2);
            DAYS_7 = new ListingDurationEnum("DAYS_7", 3);
            DAYS_10 = new ListingDurationEnum("DAYS_10", 4);
            DAYS_14 = new ListingDurationEnum("DAYS_14", 5);
            DAYS_21 = new ListingDurationEnum("DAYS_21", 6);
            DAYS_30 = new ListingDurationEnum("DAYS_30", 7);
            DAYS_60 = new ListingDurationEnum("DAYS_60", 8);
            DAYS_90 = new ListingDurationEnum("DAYS_90", 9);
            DAYS_120 = new ListingDurationEnum("DAYS_120", 10);
            GTC = new ListingDurationEnum("GTC", 11);
            $VALUES = (new ListingDurationEnum[] {
                DAYS_1, DAYS_3, DAYS_5, DAYS_7, DAYS_10, DAYS_14, DAYS_21, DAYS_30, DAYS_60, DAYS_90, 
                DAYS_120, GTC
            });
        }

        private ListingDurationEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ListingLifecycle
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime actualEndDate;
        public List ancestry;
        public boolean autoRelist;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime creationDate;
        public EndReasonEnum endReason;
        public boolean goodTillCancelled;
        public boolean keepOutOfStockItemAlive;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime lastDescriptionModifiedDate;
        public ListingDurationEnum listingDuration;
        public List listingRevisions;
        public com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum listingStatus;
        public Integer revisionCount;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime scheduledEndDate;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime scheduledStartDate;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration timeRemaining;
        public int versionCount;

        public ListingLifecycle()
        {
            listingStatus = com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ACTIVE;
        }
    }

    public static final class ListingModeEnum extends Enum
    {

        private static final ListingModeEnum $VALUES[];
        public static final ListingModeEnum ADD;
        public static final ListingModeEnum RELIST;
        public static final ListingModeEnum SELL_ONE_LIKE;
        public static final ListingModeEnum SELL_SIMILAR;

        public static ListingModeEnum valueOf(String s)
        {
            return (ListingModeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ListingModeEnum, s);
        }

        public static ListingModeEnum[] values()
        {
            return (ListingModeEnum[])$VALUES.clone();
        }

        static 
        {
            ADD = new ListingModeEnum("ADD", 0);
            RELIST = new ListingModeEnum("RELIST", 1);
            SELL_SIMILAR = new ListingModeEnum("SELL_SIMILAR", 2);
            SELL_ONE_LIKE = new ListingModeEnum("SELL_ONE_LIKE", 3);
            $VALUES = (new ListingModeEnum[] {
                ADD, RELIST, SELL_SIMILAR, SELL_ONE_LIKE
            });
        }

        private ListingModeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static abstract class ListingRankedAspect
        implements Comparable
    {

        public boolean chosenBySellerToShowImages;
        public int rank;
        public boolean sameValueForAllItemVariations;

        public int compareTo(ListingRankedAspect listingrankedaspect)
        {
            return rank - listingrankedaspect.rank;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ListingRankedAspect)obj);
        }

        public ListingRankedAspect()
        {
        }
    }

    public static class ListingRankedAspectValue
        implements Comparable
    {

        public List images;
        public int rank;

        public int compareTo(ListingRankedAspectValue listingrankedaspectvalue)
        {
            return rank - listingrankedaspectvalue.rank;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ListingRankedAspectValue)obj);
        }

        public ListingRankedAspectValue()
        {
        }
    }

    public static final class ListingRankedCategory
        implements Comparable
    {

        public Category category;
        public List categoryAspects;
        public CategoryPathFromRoot categoryPathFromRoot;
        public ListingCondition categorySpecificCondition;
        public int rank;

        public int compareTo(ListingRankedCategory listingrankedcategory)
        {
            return rank - listingrankedcategory.rank;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ListingRankedCategory)obj);
        }

        public ListingRankedCategory()
        {
        }
    }

    public static final class ListingRevision
    {

        public Long listingVersion;
        public List revisedFields;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime revisionDate;

        public ListingRevision()
        {
        }
    }

    public static final class ListingVisibilityEnum extends Enum
    {

        private static final ListingVisibilityEnum $VALUES[];
        public static final ListingVisibilityEnum Friends;
        public static final ListingVisibilityEnum InvitationOnly;
        public static final ListingVisibilityEnum Public;

        public static ListingVisibilityEnum valueOf(String s)
        {
            return (ListingVisibilityEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ListingVisibilityEnum, s);
        }

        public static ListingVisibilityEnum[] values()
        {
            return (ListingVisibilityEnum[])$VALUES.clone();
        }

        static 
        {
            Public = new ListingVisibilityEnum("Public", 0);
            InvitationOnly = new ListingVisibilityEnum("InvitationOnly", 1);
            Friends = new ListingVisibilityEnum("Friends", 2);
            $VALUES = (new ListingVisibilityEnum[] {
                Public, InvitationOnly, Friends
            });
        }

        private ListingVisibilityEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LogisticsLocation
    {

        public String instructions;
        public com.ebay.nautilus.domain.data.BaseCommonType.Location location;
        public String locationType;
        public String zone;

        public LogisticsLocation()
        {
        }
    }

    public static final class LogisticsOptionRankScopeEnum extends Enum
    {

        private static final LogisticsOptionRankScopeEnum $VALUES[];
        public static final LogisticsOptionRankScopeEnum ALL_PLANS;
        public static final LogisticsOptionRankScopeEnum STEP;

        public static LogisticsOptionRankScopeEnum valueOf(String s)
        {
            return (LogisticsOptionRankScopeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$LogisticsOptionRankScopeEnum, s);
        }

        public static LogisticsOptionRankScopeEnum[] values()
        {
            return (LogisticsOptionRankScopeEnum[])$VALUES.clone();
        }

        static 
        {
            STEP = new LogisticsOptionRankScopeEnum("STEP", 0);
            ALL_PLANS = new LogisticsOptionRankScopeEnum("ALL_PLANS", 1);
            $VALUES = (new LogisticsOptionRankScopeEnum[] {
                STEP, ALL_PLANS
            });
        }

        private LogisticsOptionRankScopeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LogisticsPlan
    {

        public HandlingPolicy handlingPolicy;
        public LogisticsLocation locationUsedForEstimate;
        public DeliveryEstimate maxDeliveryEstimate;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount maxTotalCostToBuyer;
        public DeliveryEstimate minDeliveryEstimate;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount minTotalCostToBuyer;
        public PlanDirectionEnum planDirection;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text planName;
        public LogisticsPlanTypeEnum planType;
        public List steps;

        public LogisticsPlan()
        {
        }
    }

    public static final class LogisticsPlanTypeEnum extends Enum
    {

        private static final LogisticsPlanTypeEnum $VALUES[];
        public static final LogisticsPlanTypeEnum EBN;
        public static final LogisticsPlanTypeEnum GSP;
        public static final LogisticsPlanTypeEnum ISPU;
        public static final LogisticsPlanTypeEnum LOCAL_PICKUP;
        public static final LogisticsPlanTypeEnum PICKUP_DROP_OFF;
        public static final LogisticsPlanTypeEnum PUDO;
        public static final LogisticsPlanTypeEnum SHIP_TO_HOME;

        public static LogisticsPlanTypeEnum valueOf(String s)
        {
            return (LogisticsPlanTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$LogisticsPlanTypeEnum, s);
        }

        public static LogisticsPlanTypeEnum[] values()
        {
            return (LogisticsPlanTypeEnum[])$VALUES.clone();
        }

        static 
        {
            SHIP_TO_HOME = new LogisticsPlanTypeEnum("SHIP_TO_HOME", 0);
            ISPU = new LogisticsPlanTypeEnum("ISPU", 1);
            EBN = new LogisticsPlanTypeEnum("EBN", 2);
            GSP = new LogisticsPlanTypeEnum("GSP", 3);
            LOCAL_PICKUP = new LogisticsPlanTypeEnum("LOCAL_PICKUP", 4);
            PICKUP_DROP_OFF = new LogisticsPlanTypeEnum("PICKUP_DROP_OFF", 5);
            PUDO = new LogisticsPlanTypeEnum("PUDO", 6);
            $VALUES = (new LogisticsPlanTypeEnum[] {
                SHIP_TO_HOME, ISPU, EBN, GSP, LOCAL_PICKUP, PICKUP_DROP_OFF, PUDO
            });
        }

        private LogisticsPlanTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class LogisticsStep
    {

        public String executorReference;
        public ExecutorTypeEnum executorType;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text instructions;
        public boolean intermediated;
        public Integer sequence;
        public LogisticsStepExtension stepExtension;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text stepName;
        public StepTypeEnum stepType;

        public LogisticsStep()
        {
        }
    }

    public static class LogisticsStepExtension
    {

        public LogisticsStepExtension()
        {
        }
    }

    public static class LogisticsStepExtension.Deserializer
        implements JsonDeserializer
    {

        public LogisticsStepExtension deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            type = jsonelement.getAsJsonObject().get("type");
            if (type != null)
            {
                if ("FreightStepExtension".equals(type.getAsString()))
                {
                    return (LogisticsStepExtension)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/net/api/viewlisting/Listing$FreightStepExtension);
                }
                if ("ShippingStepExtension".equals(type.getAsString()))
                {
                    return (LogisticsStepExtension)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/net/api/viewlisting/Listing$ShippingStepExtension);
                }
                if ("PickupStepExtension".equals(type.getAsString()))
                {
                    return (LogisticsStepExtension)jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/net/api/viewlisting/Listing$PickupStepExtension);
                }
            }
            return null;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public LogisticsStepExtension.Deserializer()
        {
        }
    }

    public static final class LogisticsTerms
    {

        public Boolean PUDOLogisticsPlanOnly;
        public Boolean buyerResponsibleForLogistics;
        public Boolean ebnLogisticsPlanOnly;
        public Boolean freeShippingAvailable;
        public Boolean gsplogisticsPlanSupported;
        public Boolean ispuLogisticsPlanOnly;
        public Boolean localLogisticsPlanOnly;
        public List logisticsPlan;
        public PackageSpec packageSpec;
        public Boolean s2HLogisticsPlanOnly;
        public com.ebay.nautilus.domain.data.BaseCommonType.RegionSet supportedLogisticsRegions;

        public LogisticsTerms()
        {
        }
    }

    public static final class MinimumRemnantSetTreatmentEnum extends Enum
    {

        private static final MinimumRemnantSetTreatmentEnum $VALUES[];
        public static final MinimumRemnantSetTreatmentEnum MONEY_BACK;

        public static MinimumRemnantSetTreatmentEnum valueOf(String s)
        {
            return (MinimumRemnantSetTreatmentEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$MinimumRemnantSetTreatmentEnum, s);
        }

        public static MinimumRemnantSetTreatmentEnum[] values()
        {
            return (MinimumRemnantSetTreatmentEnum[])$VALUES.clone();
        }

        static 
        {
            MONEY_BACK = new MinimumRemnantSetTreatmentEnum("MONEY_BACK", 0);
            $VALUES = (new MinimumRemnantSetTreatmentEnum[] {
                MONEY_BACK
            });
        }

        private MinimumRemnantSetTreatmentEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class OfferMessageDetail
    {

        public String htmlMessage;
        public String textMessage;

        public OfferMessageDetail()
        {
        }
    }

    public static final class OfferURLDetail
    {

        public String url;
        public String urlTitle;
        public String urlType;

        public OfferURLDetail()
        {
        }
    }

    public static final class PackageSpec
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Dimension dimension;
        public boolean irregularPackage;
        public String packageType;
        public com.ebay.nautilus.domain.data.BaseCommonType.Weight weight;

        public PackageSpec()
        {
        }
    }

    public static final class PaymentInstallment
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount installmentAmount;
        public TimeRestriction paymentDue;
        public Double percentageOfTotal;
        public int sequence;

        public PaymentInstallment()
        {
        }
    }

    public static final class PaymentMethodDetail
    {

        public String paymentMethod;
        public List properties;
        public boolean safePaymentSupported;

        public PaymentMethodDetail()
        {
        }
    }

    public static final class PaymentTerms
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount depositAmount;
        public TimeRestriction depositDue;
        public List depositMethods;
        public Boolean depositRefundable;
        public Boolean depositRequired;
        public boolean immediatePay;
        public boolean payPalAccepted;
        public List paymentInstallments;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text paymentInstructions;
        public List paymentMethods;
        public List properties;
        public boolean safePaymentsSupported;

        public PaymentTerms()
        {
        }
    }

    public static final class Phone
    {

        public String phoneNumber;

        public Phone()
        {
        }
    }

    public static final class PickupStepExtension extends LogisticsStepExtension
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount additionalUnitPickupCost;
        public DeliveryEstimate deliveryEstimate;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount pickupCost;
        public LogisticsLocation pickupLocation;
        public int rank;
        public LogisticsOptionRankScopeEnum rankScope;

        public PickupStepExtension()
        {
        }
    }

    public static final class PlanDirectionEnum extends Enum
    {

        private static final PlanDirectionEnum $VALUES[];
        public static final PlanDirectionEnum FORWARD;
        public static final PlanDirectionEnum REVERSE;

        public static PlanDirectionEnum valueOf(String s)
        {
            return (PlanDirectionEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$PlanDirectionEnum, s);
        }

        public static PlanDirectionEnum[] values()
        {
            return (PlanDirectionEnum[])$VALUES.clone();
        }

        static 
        {
            FORWARD = new PlanDirectionEnum("FORWARD", 0);
            REVERSE = new PlanDirectionEnum("REVERSE", 1);
            $VALUES = (new PlanDirectionEnum[] {
                FORWARD, REVERSE
            });
        }

        private PlanDirectionEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PriceSettings
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount auctionReservePrice;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount buyItNowPrice;
        public List discountPrice;
        public Boolean includedVATInPrices;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount price;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount priceWithoutVAT;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount startingBidPrice;
        public String unitOfMeasure;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount unitPrice;

        public PriceSettings()
        {
        }
    }

    public static final class Product
    {

        public Float averageRating;
        public Category category;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text copyrightText;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text description;
        public String epId;
        public List externalIdentities;
        public List images;
        public List properties;
        public long referenceCount;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;
        public long version;

        public Product()
        {
        }
    }

    public static final class ProductReviewSummary
    {

        public float averageRating;
        public long reviewCount;
        public boolean showReviews;
        public String subjectReferenceId;

        public ProductReviewSummary()
        {
        }
    }

    public static final class PurchaseOptionEnum extends Enum
    {

        private static final PurchaseOptionEnum $VALUES[];
        public static final PurchaseOptionEnum ADD_TO_CART;
        public static final PurchaseOptionEnum AUCTION;
        public static final PurchaseOptionEnum BEST_OFFER;
        public static final PurchaseOptionEnum BUY_IT_NOW;

        public static PurchaseOptionEnum valueOf(String s)
        {
            return (PurchaseOptionEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$PurchaseOptionEnum, s);
        }

        public static PurchaseOptionEnum[] values()
        {
            return (PurchaseOptionEnum[])$VALUES.clone();
        }

        static 
        {
            AUCTION = new PurchaseOptionEnum("AUCTION", 0);
            BUY_IT_NOW = new PurchaseOptionEnum("BUY_IT_NOW", 1);
            BEST_OFFER = new PurchaseOptionEnum("BEST_OFFER", 2);
            ADD_TO_CART = new PurchaseOptionEnum("ADD_TO_CART", 3);
            $VALUES = (new PurchaseOptionEnum[] {
                AUCTION, BUY_IT_NOW, BEST_OFFER, ADD_TO_CART
            });
        }

        private PurchaseOptionEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class PurchaseRestrictions
    {

        public Integer minimumFeedbackScore;
        public Integer quantityLimitPerBuyer;

        public PurchaseRestrictions()
        {
        }
    }

    public static final class PurchasingQuantityTerms
    {

        public Integer lotSize;
        public Integer minRemnantSet;
        public MinimumRemnantSetTreatmentEnum minimumRemnantSetTreatment;

        public PurchasingQuantityTerms()
        {
        }
    }

    public static final class QuantityAndAvailability
    {

        public AvailabilityStatusEnum availabilityStatus;
        public Integer availableQuantity;
        public Integer listedQuantity;
        public Integer reservedQuantity;
        public Integer soldQuantity;

        public QuantityAndAvailability()
        {
        }
    }

    public static final class QuantityAndAvailabilityByLogisticsPlans
    {

        public List applicableLogisticsPlans;
        public QuantityAndAvailability quantityAndAvailability;

        public QuantityAndAvailabilityByLogisticsPlans()
        {
        }
    }

    public static final class QuantityAvailableHint extends Enum
    {

        private static final QuantityAvailableHint $VALUES[];
        public static final QuantityAvailableHint LIMITED;
        public static final QuantityAvailableHint MORE_THAN;
        public static final QuantityAvailableHint NONE;

        public static QuantityAvailableHint valueOf(String s)
        {
            return (QuantityAvailableHint)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$QuantityAvailableHint, s);
        }

        public static QuantityAvailableHint[] values()
        {
            return (QuantityAvailableHint[])$VALUES.clone();
        }

        static 
        {
            NONE = new QuantityAvailableHint("NONE", 0);
            MORE_THAN = new QuantityAvailableHint("MORE_THAN", 1);
            LIMITED = new QuantityAvailableHint("LIMITED", 2);
            $VALUES = (new QuantityAvailableHint[] {
                NONE, MORE_THAN, LIMITED
            });
        }

        private QuantityAvailableHint(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class QuestionAndAnswer
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text answer;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime answerDate;
        public boolean published;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text question;

        public QuestionAndAnswer()
        {
        }
    }

    public static final class RankedCategoryAspect extends ListingRankedAspect
    {

        public List aspectValues;
        public CategorySpecificAspect categorySpecificAspect;

        public RankedCategoryAspect()
        {
        }
    }

    public static final class RankedPaymentMethod
        implements Comparable
    {

        public PaymentMethodDetail paymentMethodDetail;
        public int rank;

        public int compareTo(RankedPaymentMethod rankedpaymentmethod)
        {
            return rank - rankedpaymentmethod.rank;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((RankedPaymentMethod)obj);
        }

        public RankedPaymentMethod()
        {
        }
    }

    public static final class RankedSellerAspect extends ListingRankedAspect
    {

        public List aspectValues;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text name;

        public int compareTo(RankedSellerAspect rankedselleraspect)
        {
            return super.compareTo(rankedselleraspect);
        }

        public String getValuesAsString()
        {
            Object obj = new DelimitedStringBuilder(", ");
            for (Iterator iterator = aspectValues.iterator(); iterator.hasNext(); ((DelimitedStringBuilder) (obj)).append(((RankedSellerAspectValue)iterator.next()).value.getSourceContent())) { }
            String s = ((DelimitedStringBuilder) (obj)).toString();
            obj = s;
            if (!TextUtils.isEmpty(s))
            {
                obj = Html.fromHtml(s).toString();
            }
            return ((String) (obj));
        }

        public RankedSellerAspect()
        {
        }
    }

    public static final class RankedSellerAspectValue extends ListingRankedAspectValue
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Text value;

        public RankedSellerAspectValue()
        {
        }
    }

    public static final class RefundMethodEnum extends Enum
    {

        private static final RefundMethodEnum $VALUES[];
        public static final RefundMethodEnum EXCHANGE;
        public static final RefundMethodEnum MERCHANDISE_CREDIT;
        public static final RefundMethodEnum MONEY_BACK;
        public static final RefundMethodEnum MONEY_BACK_OR_EXCHANGE;
        public static final RefundMethodEnum REPLACEMENT;

        public static RefundMethodEnum valueOf(String s)
        {
            return (RefundMethodEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$RefundMethodEnum, s);
        }

        public static RefundMethodEnum[] values()
        {
            return (RefundMethodEnum[])$VALUES.clone();
        }

        static 
        {
            MONEY_BACK = new RefundMethodEnum("MONEY_BACK", 0);
            EXCHANGE = new RefundMethodEnum("EXCHANGE", 1);
            MERCHANDISE_CREDIT = new RefundMethodEnum("MERCHANDISE_CREDIT", 2);
            REPLACEMENT = new RefundMethodEnum("REPLACEMENT", 3);
            MONEY_BACK_OR_EXCHANGE = new RefundMethodEnum("MONEY_BACK_OR_EXCHANGE", 4);
            $VALUES = (new RefundMethodEnum[] {
                MONEY_BACK, EXCHANGE, MERCHANDISE_CREDIT, REPLACEMENT, MONEY_BACK_OR_EXCHANGE
            });
        }

        private RefundMethodEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ReturnShipmentPayeeEnum extends Enum
    {

        private static final ReturnShipmentPayeeEnum $VALUES[];
        public static final ReturnShipmentPayeeEnum BUYER;
        public static final ReturnShipmentPayeeEnum BUYER_PAYS_CONDITIONALLY;
        public static final ReturnShipmentPayeeEnum SELLER;
        public static final ReturnShipmentPayeeEnum SELLER_RIGHT_TO_CANCEL;
        public static final ReturnShipmentPayeeEnum SELLER_RIGHT_TO_RETURN;

        public static ReturnShipmentPayeeEnum valueOf(String s)
        {
            return (ReturnShipmentPayeeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ReturnShipmentPayeeEnum, s);
        }

        public static ReturnShipmentPayeeEnum[] values()
        {
            return (ReturnShipmentPayeeEnum[])$VALUES.clone();
        }

        static 
        {
            BUYER = new ReturnShipmentPayeeEnum("BUYER", 0);
            SELLER = new ReturnShipmentPayeeEnum("SELLER", 1);
            BUYER_PAYS_CONDITIONALLY = new ReturnShipmentPayeeEnum("BUYER_PAYS_CONDITIONALLY", 2);
            SELLER_RIGHT_TO_CANCEL = new ReturnShipmentPayeeEnum("SELLER_RIGHT_TO_CANCEL", 3);
            SELLER_RIGHT_TO_RETURN = new ReturnShipmentPayeeEnum("SELLER_RIGHT_TO_RETURN", 4);
            $VALUES = (new ReturnShipmentPayeeEnum[] {
                BUYER, SELLER, BUYER_PAYS_CONDITIONALLY, SELLER_RIGHT_TO_CANCEL, SELLER_RIGHT_TO_RETURN
            });
        }

        private ReturnShipmentPayeeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ReturnTerms
    {

        public Boolean eBayReturnCenterOptedIn;
        public List properties;
        protected transient Map propertiesMap;
        public List refundMethod;
        public Double restockingFeePercent;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text returnInstructions;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration returnPeriod;
        public ReturnShipmentPayeeEnum returnShipmentPayee;
        public boolean returnsAccepted;
        public boolean returnsSpecifiedBySeller;

        public Map getProperties()
        {
            if (propertiesMap == null)
            {
                propertiesMap = new HashMap();
                if (properties != null)
                {
                    Iterator iterator = properties.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        com.ebay.nautilus.domain.data.BaseCommonType.Property property = (com.ebay.nautilus.domain.data.BaseCommonType.Property)iterator.next();
                        if (property != null)
                        {
                            propertiesMap.put(property.propertyName, property.propertyValues);
                        }
                    } while (true);
                }
            }
            return propertiesMap;
        }

        public ReturnTerms()
        {
        }
    }

    public static final class RevisedField
    {

        public List currentValues;
        public DataTypeEnum dataType;
        public String fieldPath;
        public List previousValues;

        public RevisedField()
        {
        }
    }

    public static final class Seller extends User
    {

        public AvatarImage avatarImage;
        public List brandsOwned;
        public boolean businessSeller;
        public boolean customerSupportContactAvailable;
        public EbayStore eBayStore;
        public int feedbackBasedSegment;
        public boolean hasImage;
        public boolean hasStore;
        public boolean powerSeller;
        public boolean privateSaleAuthorized;
        public String sellingState;
        public boolean specialtyPrivateSeller;
        public String specialtySellerErrorReturnURL;
        public boolean vehicelDealer;
        public int volumeBasedSegment;

        public Seller()
        {
        }
    }

    public static final class SellerOffer
        implements Comparable
    {

        public String id;
        public List offerImage;
        public OfferMessageDetail offerMessageDetail;
        public String offerSellerName;
        public List offerURLDetail;
        public int priority;
        public SellerOfferTypeEnum type;

        public int compareTo(SellerOffer selleroffer)
        {
            return priority - selleroffer.priority;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((SellerOffer)obj);
        }

        public SellerOffer()
        {
        }
    }

    public static final class SellerOfferTypeEnum extends Enum
    {

        private static final SellerOfferTypeEnum $VALUES[];
        public static final SellerOfferTypeEnum BundleOffer;
        public static final SellerOfferTypeEnum OrderSubTotalOffer;
        public static final SellerOfferTypeEnum PromotionalShipping;
        public static final SellerOfferTypeEnum SaleAndClearence;
        public static final SellerOfferTypeEnum SaleEvent;
        public static final SellerOfferTypeEnum TargetedOffer;
        public static final SellerOfferTypeEnum Unknown;

        public static SellerOfferTypeEnum valueOf(String s)
        {
            return (SellerOfferTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$SellerOfferTypeEnum, s);
        }

        public static SellerOfferTypeEnum[] values()
        {
            return (SellerOfferTypeEnum[])$VALUES.clone();
        }

        static 
        {
            Unknown = new SellerOfferTypeEnum("Unknown", 0);
            BundleOffer = new SellerOfferTypeEnum("BundleOffer", 1);
            OrderSubTotalOffer = new SellerOfferTypeEnum("OrderSubTotalOffer", 2);
            SaleEvent = new SellerOfferTypeEnum("SaleEvent", 3);
            PromotionalShipping = new SellerOfferTypeEnum("PromotionalShipping", 4);
            SaleAndClearence = new SellerOfferTypeEnum("SaleAndClearence", 5);
            TargetedOffer = new SellerOfferTypeEnum("TargetedOffer", 6);
            $VALUES = (new SellerOfferTypeEnum[] {
                Unknown, BundleOffer, OrderSubTotalOffer, SaleEvent, PromotionalShipping, SaleAndClearence, TargetedOffer
            });
        }

        private SellerOfferTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static class SellerOfferTypeEnum.Deserializer
        implements JsonDeserializer
    {

        public SellerOfferTypeEnum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            if (!TextUtils.isEmpty(jsonelement))
            {
                type = SellerOfferTypeEnum.values();
                int j = type.length;
                for (int i = 0; i < j; i++)
                {
                    jsondeserializationcontext = type[i];
                    if (jsondeserializationcontext.name().equals(jsonelement))
                    {
                        return jsondeserializationcontext;
                    }
                }

            }
            return SellerOfferTypeEnum.Unknown;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public SellerOfferTypeEnum.Deserializer()
        {
        }
    }

    public static final class ShippingCostPlan
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount additionalUnitShippingCost;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount cashOnDeliveryFee;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount convenienceFee;
        public String costPlanSource;
        public String costPlanType;
        public ShippingDiscount discount;
        public boolean freeShipping;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount importCharges;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount minDeliveredValueToWaiveCF;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount overrideFee;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount shippingCost;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount surchargeFee;

        public ShippingCostPlan()
        {
        }
    }

    public static final class ShippingDiscount
    {

        public List communicatedAsMessage;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount deliveredValueRequirement;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount discountAmountPerDeliveredItem;
        public List discountVariationsId;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount discountedShippingCost;
        public int numberOfDeliveredItemsRequirement;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount promoShippingCost;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount savingsAmountPerDeliveredItem;
        public double savingsPercentPerDeliveredItem;

        public ShippingDiscount()
        {
        }
    }

    public static final class ShippingInsurance
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.Amount insuranceCost;
        public ShippingInsuranceOptionEnum insuranceOption;
        public String insuranceStatus;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount insuredValue;

        public ShippingInsurance()
        {
        }
    }

    public static final class ShippingInsuranceOptionEnum extends Enum
    {

        private static final ShippingInsuranceOptionEnum $VALUES[];
        public static final ShippingInsuranceOptionEnum INCLUDED;
        public static final ShippingInsuranceOptionEnum NOT_OFFERED;
        public static final ShippingInsuranceOptionEnum OPTIONAL;
        public static final ShippingInsuranceOptionEnum REQUIRED;

        public static ShippingInsuranceOptionEnum valueOf(String s)
        {
            return (ShippingInsuranceOptionEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ShippingInsuranceOptionEnum, s);
        }

        public static ShippingInsuranceOptionEnum[] values()
        {
            return (ShippingInsuranceOptionEnum[])$VALUES.clone();
        }

        static 
        {
            INCLUDED = new ShippingInsuranceOptionEnum("INCLUDED", 0);
            OPTIONAL = new ShippingInsuranceOptionEnum("OPTIONAL", 1);
            REQUIRED = new ShippingInsuranceOptionEnum("REQUIRED", 2);
            NOT_OFFERED = new ShippingInsuranceOptionEnum("NOT_OFFERED", 3);
            $VALUES = (new ShippingInsuranceOptionEnum[] {
                INCLUDED, OPTIONAL, REQUIRED, NOT_OFFERED
            });
        }

        private ShippingInsuranceOptionEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ShippingMethod
    {

        public Code carrier;
        public Integer carrierDiscountPercentage;
        public String domesticOrInternational;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration maxDeliverySLA;
        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration minDeliverySLA;
        public Code shippingMethodCategory;
        public Code shippingMethodCode;

        public ShippingMethod()
        {
        }
    }

    public static final class ShippingOption
        implements Comparable
    {

        public DeliveryEstimate deliveryEstimate;
        public HandlingPolicy handlingPolicyOverride;
        public ShippingInsurance insurance;
        public boolean promotionalShipping;
        public List properties;
        public int rank;
        public LogisticsOptionRankScopeEnum rankScope;
        public ShippingCostPlan shippingCostPlan;
        public ShippingMethod shippingMethod;
        public com.ebay.nautilus.domain.data.BaseCommonType.RegionSet supportedShipToRegions;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount totalCostToBuyer;

        public int compareTo(ShippingOption shippingoption)
        {
            return rank - shippingoption.rank;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ShippingOption)obj);
        }

        public ShippingOption()
        {
        }
    }

    public static final class ShippingStepExtension extends LogisticsStepExtension
    {

        public boolean freeShippingAvailable;
        public boolean internationalShippingAvailable;
        public LogisticsLocation originLocation;
        public List shippingOption;
        public com.ebay.nautilus.domain.data.BaseCommonType.RegionSet supportedShipToRegions;

        public ShippingStepExtension()
        {
        }
    }

    public static final class StepTypeEnum extends Enum
    {

        private static final StepTypeEnum $VALUES[];
        public static final StepTypeEnum DROPOFF;
        public static final StepTypeEnum PICKUP;
        public static final StepTypeEnum SHIPPING;

        public static StepTypeEnum valueOf(String s)
        {
            return (StepTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$StepTypeEnum, s);
        }

        public static StepTypeEnum[] values()
        {
            return (StepTypeEnum[])$VALUES.clone();
        }

        static 
        {
            SHIPPING = new StepTypeEnum("SHIPPING", 0);
            PICKUP = new StepTypeEnum("PICKUP", 1);
            DROPOFF = new StepTypeEnum("DROPOFF", 2);
            $VALUES = (new StepTypeEnum[] {
                SHIPPING, PICKUP, DROPOFF
            });
        }

        private StepTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class StoreLevelEnum extends Enum
    {

        private static final StoreLevelEnum $VALUES[];
        public static final StoreLevelEnum ANCHOR;
        public static final StoreLevelEnum BASIC;
        public static final StoreLevelEnum PROFESSIONAL;

        public static StoreLevelEnum valueOf(String s)
        {
            return (StoreLevelEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$StoreLevelEnum, s);
        }

        public static StoreLevelEnum[] values()
        {
            return (StoreLevelEnum[])$VALUES.clone();
        }

        static 
        {
            BASIC = new StoreLevelEnum("BASIC", 0);
            PROFESSIONAL = new StoreLevelEnum("PROFESSIONAL", 1);
            ANCHOR = new StoreLevelEnum("ANCHOR", 2);
            $VALUES = (new StoreLevelEnum[] {
                BASIC, PROFESSIONAL, ANCHOR
            });
        }

        private StoreLevelEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class TaxTypeEnum extends Enum
    {

        private static final TaxTypeEnum $VALUES[];
        public static final TaxTypeEnum Municipal;
        public static final TaxTypeEnum Region;
        public static final TaxTypeEnum State;
        public static final TaxTypeEnum VAT;

        public static TaxTypeEnum valueOf(String s)
        {
            return (TaxTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$TaxTypeEnum, s);
        }

        public static TaxTypeEnum[] values()
        {
            return (TaxTypeEnum[])$VALUES.clone();
        }

        static 
        {
            Municipal = new TaxTypeEnum("Municipal", 0);
            State = new TaxTypeEnum("State", 1);
            Region = new TaxTypeEnum("Region", 2);
            VAT = new TaxTypeEnum("VAT", 3);
            $VALUES = (new TaxTypeEnum[] {
                Municipal, State, Region, VAT
            });
        }

        private TaxTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class TermsAndPolicies
    {

        public List applicableTax;
        public List availableOnOtherMarketplaces;
        public BuyerProtectionPolicy buyerProtectionPolicy;
        public BuyerRestrictions buyerRestrictions;
        public CharityTerms charityTerms;
        public boolean eligibleForGuestCheckout;
        public boolean hideBuyerIdentity;
        public ListingVisibilityEnum listingVisibility;
        public LogisticsTerms logisticsTerms;
        public PaymentTerms paymentTerms;
        public ReturnTerms returnTerms;
        public TrustBadgeEnum trustBadges;
        public WarrantyTerms warrantyTerms;

        public TermsAndPolicies()
        {
        }
    }

    public static final class TimeEstimate
    {

        public Date maxDate;
        public int maxDays;
        public Date minDate;
        public int minDays;
        public Boolean supportNonBusinessDays;

        public TimeEstimate()
        {
        }
    }

    public static final class TimeRestriction
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration gracePeriod;
        public boolean immediate;

        public TimeRestriction()
        {
        }
    }

    public static final class TrustBadgeEnum extends Enum
    {

        private static final TrustBadgeEnum $VALUES[];
        public static final TrustBadgeEnum TOP_RATED_PLUS_LISTING;
        public static final TrustBadgeEnum TOP_RATED_SELLER;

        public static TrustBadgeEnum valueOf(String s)
        {
            return (TrustBadgeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$TrustBadgeEnum, s);
        }

        public static TrustBadgeEnum[] values()
        {
            return (TrustBadgeEnum[])$VALUES.clone();
        }

        static 
        {
            TOP_RATED_SELLER = new TrustBadgeEnum("TOP_RATED_SELLER", 0);
            TOP_RATED_PLUS_LISTING = new TrustBadgeEnum("TOP_RATED_PLUS_LISTING", 1);
            $VALUES = (new TrustBadgeEnum[] {
                TOP_RATED_SELLER, TOP_RATED_PLUS_LISTING
            });
        }

        private TrustBadgeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UploadMethodEnum extends Enum
    {

        private static final UploadMethodEnum $VALUES[];
        public static final UploadMethodEnum COPIED_FROM_SELLER_HOSTING;
        public static final UploadMethodEnum EBAY_CATALOG_REFERENCE;
        public static final UploadMethodEnum SELLER_UPLOADED;

        public static UploadMethodEnum valueOf(String s)
        {
            return (UploadMethodEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$UploadMethodEnum, s);
        }

        public static UploadMethodEnum[] values()
        {
            return (UploadMethodEnum[])$VALUES.clone();
        }

        static 
        {
            SELLER_UPLOADED = new UploadMethodEnum("SELLER_UPLOADED", 0);
            COPIED_FROM_SELLER_HOSTING = new UploadMethodEnum("COPIED_FROM_SELLER_HOSTING", 1);
            EBAY_CATALOG_REFERENCE = new UploadMethodEnum("EBAY_CATALOG_REFERENCE", 2);
            $VALUES = (new UploadMethodEnum[] {
                SELLER_UPLOADED, COPIED_FROM_SELLER_HOSTING, EBAY_CATALOG_REFERENCE
            });
        }

        private UploadMethodEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static class User
    {

        public String accountType;
        public boolean businessUser;
        public BusinessUserExtension businessUserExtension;
        public com.ebay.nautilus.domain.data.BaseCommonType.Address contactAddress;
        public String countryOfResidence;
        public String designation;
        public String emailAddress;
        public Integer feedbackScore;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text firstname;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text lastname;
        public String lifeCycleState;
        public Double positiveFeedbackPercentage;
        public Phone primaryPhone;
        public boolean privateFeedbackProfile;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime registrationDate;
        public com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum registrationMarketplaceId;
        public Phone secondaryPhone;
        public com.ebay.nautilus.domain.data.BaseListingType.UserIdentifier userIdentifier;

        public User()
        {
        }
    }

    public static final class UserToItemVariationRelationshipSummary
    {

        public boolean addedToCart;
        public Boolean bidding;
        public User buyer;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text buyerCollectionNamesHoldingListing;
        public boolean collecting;
        public boolean followingSeller;
        public Boolean madeOffer;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount maxBidPrice;
        public Boolean offerAccepted;
        public Boolean offerDeclined;
        public Boolean outbidded;
        public Boolean receivedCounterOffer;
        public boolean watching;

        public UserToItemVariationRelationshipSummary()
        {
        }
    }

    public static final class UserToListingRelationshipEnum extends Enum
    {

        private static final UserToListingRelationshipEnum $VALUES[];
        public static final UserToListingRelationshipEnum BEST_OFFER_BUYER;
        public static final UserToListingRelationshipEnum HIGH_BIDDER;
        public static final UserToListingRelationshipEnum MULTI_BUYER;
        public static final UserToListingRelationshipEnum NONE;
        public static final UserToListingRelationshipEnum OUT_BIDDER;
        public static final UserToListingRelationshipEnum SELLER;
        public static final UserToListingRelationshipEnum SINGLE_BUYER;
        public static final UserToListingRelationshipEnum WIN_POST_OWNER;

        public static UserToListingRelationshipEnum valueOf(String s)
        {
            return (UserToListingRelationshipEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$UserToListingRelationshipEnum, s);
        }

        public static UserToListingRelationshipEnum[] values()
        {
            return (UserToListingRelationshipEnum[])$VALUES.clone();
        }

        static 
        {
            NONE = new UserToListingRelationshipEnum("NONE", 0);
            SELLER = new UserToListingRelationshipEnum("SELLER", 1);
            HIGH_BIDDER = new UserToListingRelationshipEnum("HIGH_BIDDER", 2);
            SINGLE_BUYER = new UserToListingRelationshipEnum("SINGLE_BUYER", 3);
            MULTI_BUYER = new UserToListingRelationshipEnum("MULTI_BUYER", 4);
            OUT_BIDDER = new UserToListingRelationshipEnum("OUT_BIDDER", 5);
            WIN_POST_OWNER = new UserToListingRelationshipEnum("WIN_POST_OWNER", 6);
            BEST_OFFER_BUYER = new UserToListingRelationshipEnum("BEST_OFFER_BUYER", 7);
            $VALUES = (new UserToListingRelationshipEnum[] {
                NONE, SELLER, HIGH_BIDDER, SINGLE_BUYER, MULTI_BUYER, OUT_BIDDER, WIN_POST_OWNER, BEST_OFFER_BUYER
            });
        }

        private UserToListingRelationshipEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class UserToListingRelationshipSummary
    {

        public boolean collecting;
        public boolean followingSeller;
        public UserToListingRelationshipEnum userToListingRelationship;
        public List userToListingStatusMessages;

        public UserToListingRelationshipSummary()
        {
        }
    }

    public static final class UserToListingStatusMessage
    {

        public List actions;
        public List properties;
        public List rank;
        public String statusMessageCode;

        public UserToListingStatusMessage()
        {
        }
    }

    public static final class VisitCounterTypeEnum extends Enum
    {

        private static final VisitCounterTypeEnum $VALUES[];
        public static final VisitCounterTypeEnum BASIC_STYLE;
        public static final VisitCounterTypeEnum GREEN_LED;
        public static final VisitCounterTypeEnum HIDDEN;
        public static final VisitCounterTypeEnum HIDDEN_STYLE;
        public static final VisitCounterTypeEnum HONESTY_STYLE;
        public static final VisitCounterTypeEnum NO_HIT_COUNTER;
        public static final VisitCounterTypeEnum RETRO_STYLE;

        public static VisitCounterTypeEnum valueOf(String s)
        {
            return (VisitCounterTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$VisitCounterTypeEnum, s);
        }

        public static VisitCounterTypeEnum[] values()
        {
            return (VisitCounterTypeEnum[])$VALUES.clone();
        }

        static 
        {
            NO_HIT_COUNTER = new VisitCounterTypeEnum("NO_HIT_COUNTER", 0);
            HONESTY_STYLE = new VisitCounterTypeEnum("HONESTY_STYLE", 1);
            GREEN_LED = new VisitCounterTypeEnum("GREEN_LED", 2);
            HIDDEN = new VisitCounterTypeEnum("HIDDEN", 3);
            BASIC_STYLE = new VisitCounterTypeEnum("BASIC_STYLE", 4);
            RETRO_STYLE = new VisitCounterTypeEnum("RETRO_STYLE", 5);
            HIDDEN_STYLE = new VisitCounterTypeEnum("HIDDEN_STYLE", 6);
            $VALUES = (new VisitCounterTypeEnum[] {
                NO_HIT_COUNTER, HONESTY_STYLE, GREEN_LED, HIDDEN, BASIC_STYLE, RETRO_STYLE, HIDDEN_STYLE
            });
        }

        private VisitCounterTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class WarrantyTerms
    {

        public com.ebay.nautilus.domain.data.BaseCommonType.TimeDuration duration;
        public WarrantyTypeEnum type;

        public WarrantyTerms()
        {
        }
    }

    public static final class WarrantyTypeEnum extends Enum
    {

        private static final WarrantyTypeEnum $VALUES[];
        public static final WarrantyTypeEnum DealerWarranty;
        public static final WarrantyTypeEnum ManufacturerWarranty;
        public static final WarrantyTypeEnum ReplacementWarranty;

        public static WarrantyTypeEnum valueOf(String s)
        {
            return (WarrantyTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$WarrantyTypeEnum, s);
        }

        public static WarrantyTypeEnum[] values()
        {
            return (WarrantyTypeEnum[])$VALUES.clone();
        }

        static 
        {
            ReplacementWarranty = new WarrantyTypeEnum("ReplacementWarranty", 0);
            DealerWarranty = new WarrantyTypeEnum("DealerWarranty", 1);
            ManufacturerWarranty = new WarrantyTypeEnum("ManufacturerWarranty", 2);
            $VALUES = (new WarrantyTypeEnum[] {
                ReplacementWarranty, DealerWarranty, ManufacturerWarranty
            });
        }

        private WarrantyTypeEnum(String s, int i)
        {
            super(s, i);
        }
    }


    public List authorizedByBrand;
    public CompatibilityDetail compatibilityDetails;
    public com.ebay.nautilus.domain.data.BaseCommonType.Text description;
    public ExposureEnhancementDetail exposureEnhancementDetail;
    public com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum format;
    public List images;
    public List inventoryLocations;
    public List itemVariations;
    public ListingClassification listingClassification;
    public String listingId;
    public ListingLifecycle listingLifecycle;
    public String listingLocale;
    public List listingProperties;
    protected transient Map listingPropertiesMap;
    public com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum marketplaceListedOn;
    public boolean multipleVariationsListed;
    public List offers;
    public com.ebay.nautilus.domain.data.BaseCommonType.Amount price;
    public List purchaseOptions;
    public ProductReviewSummary review;
    public Seller seller;
    public String sellerSKU;
    public com.ebay.nautilus.domain.data.BaseCommonType.Text shortDescription;
    public com.ebay.nautilus.domain.data.BaseCommonType.Text subtitle;
    public TermsAndPolicies termsAndPolicies;
    public com.ebay.nautilus.domain.data.BaseCommonType.Text title;
    public TradingSummary tradingSummary;
    public UserToListingRelationshipSummary userToListingRelationshipSummary;
    public Long version;
    public VisitCounterTypeEnum visitCounterType;

    public Listing()
    {
    }

    public Map getListingProperties()
    {
        if (listingPropertiesMap == null)
        {
            listingPropertiesMap = new HashMap();
            com.ebay.nautilus.domain.data.BaseCommonType.Property property;
            for (Iterator iterator = listingProperties.iterator(); iterator.hasNext(); listingPropertiesMap.put(property.propertyName, property.propertyValues))
            {
                property = (com.ebay.nautilus.domain.data.BaseCommonType.Property)iterator.next();
            }

        }
        return listingPropertiesMap;
    }

    public boolean isAuctionOnly()
    {
        return com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(format) && !tradingSummary.purchaseOptions.contains(PurchaseOptionEnum.BUY_IT_NOW);
    }

    public boolean isAuctionWithBuyItNow()
    {
        return com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.AUCTION.equals(format) && tradingSummary.purchaseOptions.contains(PurchaseOptionEnum.BUY_IT_NOW);
    }

    public boolean isBuyItNowOnly()
    {
        return com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum.FIXED_PRICE.equals(format);
    }

}
