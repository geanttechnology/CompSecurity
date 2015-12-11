// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.util.BuyUtils;
import com.groupon.util.GeoPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            AbstractDeal, CommonOptions, Image, Badge, 
//            Trait, Option, InventoryService, Price, 
//            PricingMetadata, Location, BookableSegments, Merchant, 
//            Recommendation, Incentive, CategorizationItem, ShippingOption, 
//            SchedulerOption, DealType, Division, ExternalDealProvider, 
//            LegalDisclosure, UiTreatment, Video, Business, 
//            WidgetSummary

public class Deal extends AbstractDeal
    implements CommonOptions
{
    protected static class Channel
    {

        public String id;
        public String name;

        protected Channel()
        {
            id = "";
            name = "";
        }
    }

    protected static class DealTypeMerchantPersona
    {

        public String description;
        public String id;
        public String name;

        protected DealTypeMerchantPersona()
        {
            id = "";
            name = "";
        }
    }

    protected static class Dimensions
    {

        public List platformExclusive;

        protected Dimensions()
        {
        }
    }

    protected static class DisplayOption
    {

        public Dimensions dimensions;
        public boolean enabled;
        public String name;

        protected DisplayOption()
        {
        }
    }

    protected static class SpecificAttribute
    {

        public String amenitiesHtml;
        public String howToGetThereHtml;
        public String reservationsHtml;
        public String travelersTipsHtml;
        public String whatYouGetHtml;

        protected SpecificAttribute()
        {
        }
    }


    private static final String CONNECTED_MARKETPLACE_GOODS_DEALS = "connected-marketplace-goods-deals";
    private static final String DISPLAY_MARKETING_CONTROLS = "marketingControls";
    private static final String PLATFORM_ANDROID = "android";
    protected List _badges;
    protected List _channels;
    protected List _dealTypeMerchantPersona;
    protected List _displayOptions;
    protected SpecificAttribute _specificAttribute;
    protected List _traits;
    public boolean allowedInCart;
    protected Collection categorizations;
    protected volatile ArrayList categorizationsList;
    protected Collection dealTypes;
    protected volatile ArrayList dealTypesList;
    public String dealUrl;
    public Price discount;
    public int discountPercent;
    public Division division;
    public Date expiresAt;
    public ExternalDealProvider externalDealProvider;
    public String fulfillmentMethod;
    public String highlightsHtml;
    protected Collection images;
    protected volatile ArrayList imagesList;
    protected Collection incentives;
    protected volatile ArrayList incentivesList;
    public boolean isApplyButton;
    public boolean isGiftable;
    public boolean isOptionListComplete;
    protected volatile ArrayList legalDisclosureList;
    protected Collection legalDisclosures;
    public int maximumPurchaseQuantity;
    public Merchant merchant;
    public int minimumPurchaseQuantity;
    public Date modificationDate;
    protected Collection options;
    protected volatile ArrayList optionsList;
    public Business parentBusiness;
    public WidgetSummary parentWidgetSummary;
    public String pitchHtml;
    public Price price;
    public Long primaryKey;
    public int remainingQuantity;
    public String remoteId;
    public boolean shippingAddressRequired;
    public boolean shouldDisplayLocation;
    public boolean shouldDisplayMap;
    public String specificAttributesAmenitiesHtml;
    public String specificAttributesHowToGetThereHtml;
    public String specificAttributesReservationsHtml;
    public String specificAttributesTravelersTipsHtml;
    public String specificAttributesWhatYouGetHtml;
    public Date startRedemptionAt;
    public int timezoneOffsetInSeconds;
    public HashMap traitPositionMap;
    protected Collection uiTreatment;
    protected volatile ArrayList uiTreatmentsList;
    public Price value;
    protected volatile ArrayList videoList;
    protected Collection videos;

    public Deal()
    {
        pitchHtml = "";
        highlightsHtml = "";
        shippingAddressRequired = false;
        specificAttributesWhatYouGetHtml = "";
        specificAttributesHowToGetThereHtml = "";
        specificAttributesTravelersTipsHtml = "";
        specificAttributesAmenitiesHtml = "";
        specificAttributesReservationsHtml = "";
        isApplyButton = false;
        expiresAt = null;
        startRedemptionAt = null;
        timezoneOffsetInSeconds = 0;
        maximumPurchaseQuantity = 10;
        minimumPurchaseQuantity = 1;
        remainingQuantity = -1;
        discountPercent = 0;
        allowedInCart = false;
        shouldDisplayMap = true;
        shouldDisplayLocation = true;
        dealUrl = "";
        isOptionListComplete = true;
        isGiftable = false;
        fulfillmentMethod = "";
        _displayOptions = Collections.emptyList();
        _traits = Collections.emptyList();
        _dealTypeMerchantPersona = Collections.emptyList();
        _channels = Collections.emptyList();
        _badges = Collections.emptyList();
        _specificAttribute = new SpecificAttribute();
        traitPositionMap = new HashMap();
        options = Collections.emptyList();
        dealTypes = Collections.emptyList();
        categorizations = Collections.emptyList();
        incentives = Collections.emptyList();
        videos = Collections.emptyList();
        legalDisclosures = Collections.emptyList();
        images = Collections.emptyList();
        uiTreatment = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor(BuyUtils buyutils)
    {
        afterJsonDeserializationPostProcessor(buyutils, Collections.EMPTY_MAP);
    }

    public void afterJsonDeserializationPostProcessor(BuyUtils buyutils, Map map)
    {
        if (_specificAttribute != null)
        {
            specificAttributesHowToGetThereHtml = _specificAttribute.howToGetThereHtml;
            specificAttributesTravelersTipsHtml = _specificAttribute.travelersTipsHtml;
            specificAttributesWhatYouGetHtml = _specificAttribute.whatYouGetHtml;
            specificAttributesAmenitiesHtml = _specificAttribute.amenitiesHtml;
            specificAttributesReservationsHtml = _specificAttribute.reservationsHtml;
        }
        if (images != null && !images.isEmpty())
        {
            derivedImageUrl = ((Image)images.iterator().next()).url;
        }
        Iterator iterator = _displayOptions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DisplayOption displayoption = (DisplayOption)iterator.next();
            if (Strings.equals(displayoption.name, "marketingControls"))
            {
                if (displayoption.dimensions != null)
                {
                    displayOptions.put("platformExclusive", Boolean.valueOf(displayoption.dimensions.platformExclusive.contains("android")));
                }
            } else
            {
                displayOptions.put(displayoption.name, Boolean.valueOf(displayoption.enabled));
            }
        } while (true);
        Channel channel;
        for (Iterator iterator1 = _channels.iterator(); iterator1.hasNext(); channels.add(channel.id))
        {
            channel = (Channel)iterator1.next();
        }

        if (_badges == null)
        {
            _badges = Collections.emptyList();
        }
        Badge badge;
        for (Iterator iterator2 = _badges.iterator(); iterator2.hasNext(); badges.add(badge))
        {
            badge = (Badge)iterator2.next();
            badge.afterJsonDeserializationPostProcessor();
        }

        Trait trait;
        for (Iterator iterator3 = _traits.iterator(); iterator3.hasNext(); traitPositionMap.put(trait.position, trait.name))
        {
            trait = (Trait)iterator3.next();
        }

        derivedOptionsCount = options.size();
        if (!options.isEmpty())
        {
            Option option = (Option)options.iterator().next();
            int i = 0x7fffffff;
            Iterator iterator4 = options.iterator();
            do
            {
                if (!iterator4.hasNext())
                {
                    break;
                }
                Option option1 = (Option)iterator4.next();
                option1.afterJsonDeserializationPostProcessor();
                if (!option1.isSoldOutOrExpired())
                {
                    Option option2 = option;
                    int j = i;
                    if (!map.isEmpty())
                    {
                        Integer integer = (Integer)map.get(option1.remoteId);
                        option2 = option;
                        j = i;
                        if (integer != null)
                        {
                            option2 = option;
                            j = i;
                            if (integer.intValue() < i)
                            {
                                j = integer.intValue();
                                defaultOptionId = option1.remoteId;
                                option2 = option1;
                            }
                        }
                    }
                    option = option2;
                    i = j;
                    if (defaultOptionId == null)
                    {
                        defaultOptionId = option1.remoteId;
                        option = option1;
                        i = j;
                    }
                }
            } while (true);
            if (defaultOptionId == null)
            {
                defaultOptionId = option.remoteId;
            }
            optionDimensionsCount = generateOptionDimensionsCount();
            hasImagesForOptions = generateImagesForOptions();
            derivedHasBookableOrSchedulableOptions = hasAtLeasOneBookableOrSchedulableOption();
            derivedHasHasExternalUrl = hasExternalUrl();
            map = option.inventoryService;
            if (map != null && ((InventoryService) (map)).id != null && ((InventoryService) (map)).id.equals("glive"))
            {
                derivedIsGLiveDeal = true;
            }
            derivedMinimumPurchaseQuantity = option.minimumPurchaseQuantity;
            derivedDiscountPercent = option.discountPercent;
            derivedOptionEndRedemptionAt = option.getEndRedemptionAt();
            if (option.value != null)
            {
                derivedValueAmount = option.value.amount;
                derivedValueCurrencyCode = option.value.currencyCode;
                derivedValueFormattedAmount = option.value.formattedAmount;
            }
            if (option.price != null)
            {
                derivedPriceAmount = option.price.amount;
                derivedPriceCurrencyCode = option.price.currencyCode;
                derivedPriceFormattedAmount = option.price.formattedAmount;
            }
            map = option.regularPrice;
            if (map != null)
            {
                derivedRegularPriceAmount = ((Price) (map)).amount;
                derivedRegularPriceFormattedAmount = ((Price) (map)).formattedAmount;
                derivedRegularPriceCurrencyCode = ((Price) (map)).currencyCode;
            }
            if (option.pricingMetadata != null)
            {
                if (option.pricingMetadata.offerLabelDescriptive != null)
                {
                    derivedPricingMetadataOfferLabelDescriptive = option.pricingMetadata.offerLabelDescriptive;
                }
                if (option.pricingMetadata.offerLabel != null)
                {
                    derivedPricingMetadataOfferLabel = option.pricingMetadata.offerLabel;
                }
                if (option.pricingMetadata.offerBeginsAt != null)
                {
                    derivedPricingMetadataOfferBeginsAt = option.pricingMetadata.offerBeginsAt;
                }
                if (option.pricingMetadata.offerEndsAt != null)
                {
                    derivedPricingMetadataOfferEndsAt = option.pricingMetadata.offerEndsAt;
                }
                if (option.pricingMetadata.offerType != null)
                {
                    derivedPricingMetadataOfferType = option.pricingMetadata.offerType;
                }
            }
            optionLocationCount = option.redemptionLocations.size();
            if (!option.redemptionLocations.isEmpty())
            {
                map = (Location)option.redemptionLocations.iterator().next();
                derivedLocationCity = ((Location) (map)).city;
                derivedLocationNeighborhood = ((Location) (map)).neighborhood;
                derivedLocationName = ((Location) (map)).name;
            }
            for (buyutils = buyutils.getOptionWithMinimumPrice(this).redemptionLocations.iterator(); buyutils.hasNext(); derivedRedemptionLocations.add(new GeoPoint((int)(((Location) (map)).lat * 1000000D), (int)(((Location) (map)).lng * 1000000D))))
            {
                map = (Location)buyutils.next();
            }

            firstOptionTitle = option.getTitle();
            for (buyutils = option.bookableSegmentsList.iterator(); buyutils.hasNext(); bookableSegments.add(map))
            {
                map = (BookableSegments)buyutils.next();
                map.afterJsonDeserializationPostProcessor();
            }

            Collections.sort(bookableSegments);
        }
        if (merchant != null)
        {
            derivedMerchantName = merchant.name;
            for (buyutils = merchant.recommendations.iterator(); buyutils.hasNext();)
            {
                map = (Recommendation)buyutils.next();
                derivedMerchantRecommendationPercentMessage = ((Recommendation) (map)).percentMessage;
                derivedMerchantRecommendationTotalMessage = ((Recommendation) (map)).totalMessage;
            }

        }
        if (incentives.size() > 0)
        {
            buyutils = (Incentive)getIncentives().get(0);
            incentivePromotionType = ((Incentive) (buyutils)).promotionType;
            incentivePromoCode = ((Incentive) (buyutils)).promotionCode;
            incentiveShortMessage = ((Incentive) (buyutils)).shortMessage;
            incentiveLongMessage = ((Incentive) (buyutils)).longMessage;
            incentiveExpiryDate = ((Incentive) (buyutils)).expiresAt;
        }
        buyutils = _dealTypeMerchantPersona.iterator();
        do
        {
            if (!buyutils.hasNext())
            {
                break;
            }
            map = (DealTypeMerchantPersona)buyutils.next();
            if (!Strings.equals(((DealTypeMerchantPersona) (map)).id, "connected-marketplace-goods-deals"))
            {
                continue;
            }
            isConnectedMarketPlaceDeal = true;
            if (((DealTypeMerchantPersona) (map)).description != null)
            {
                buyutils = ((DealTypeMerchantPersona) (map)).description;
            } else
            {
                buyutils = "";
            }
            connectedMarketPlaceDisplayText = buyutils;
            break;
        } while (true);
        buyutils = getCategorizations();
        if (buyutils != null && !buyutils.isEmpty())
        {
            map = new HashSet();
            if (buyutils.get(0) != null)
            {
                buyutils = (CategorizationItem)buyutils.get(0);
            } else
            {
                buyutils = null;
            }
            if (buyutils != null)
            {
                buyutils = buyutils.getChildren();
            } else
            {
                buyutils = null;
            }
            if (buyutils != null && buyutils.size() > 0)
            {
                for (buyutils = buyutils.iterator(); buyutils.hasNext(); map.add(((CategorizationItem)buyutils.next()).id)) { }
            }
            secondLevelDealCategories = map;
        }
    }

    public boolean allOptionsAreFreeShipping()
    {
        if (options.size() != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Iterator iterator = options.iterator();
_L5:
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        obj = ((Option)iterator.next()).shippingOptions;
        if (((Collection) (obj)).size() == 0) goto _L1; else goto _L3
_L3:
        obj = ((Collection) (obj)).iterator();
        ShippingOption shippingoption;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            shippingoption = (ShippingOption)((Iterator) (obj)).next();
        } while (shippingoption.price == null || shippingoption.price.amount == 0);
        break; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L4
_L4:
        return false;
        return true;
    }

    public boolean generateImagesForOptions()
    {
        for (Iterator iterator = options.iterator(); iterator.hasNext();)
        {
            if (((Option)iterator.next()).images.size() == 0)
            {
                return false;
            }
        }

        return true;
    }

    public int generateOptionDimensionsCount()
    {
        HashSet hashset;
        Iterator iterator;
        hashset = new HashSet();
        iterator = _traits.iterator();
_L15:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (Trait)iterator.next();
        if (!Strings.isEmpty(((Trait) (obj)).name)) goto _L4; else goto _L3
_L3:
        return -1;
_L4:
        hashset.add(((Trait) (obj)).name);
        continue; /* Loop/switch isn't completed */
_L2:
        if (options.size() < 2) goto _L3; else goto _L5
_L5:
        int i = _traits.size();
        if (i == 0) goto _L3; else goto _L6
_L6:
        iterator = options.iterator();
_L10:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_252;
        }
        obj = (Option)iterator.next();
        if (((Option) (obj)).images.size() == 0) goto _L3; else goto _L7
_L7:
        boolean flag;
        boolean flag1 = false;
        Iterator iterator1 = ((Option) (obj)).images.iterator();
        do
        {
            flag = flag1;
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
        } while (Strings.isEmpty(((Image)iterator1.next()).url));
        flag = true;
        if (!flag || i != ((Option) (obj)).traits.size()) goto _L3; else goto _L8
_L8:
        obj = ((Option) (obj)).traits.iterator();
_L13:
        if (!((Iterator) (obj)).hasNext()) goto _L10; else goto _L9
_L9:
        String s = ((Trait)((Iterator) (obj)).next()).name;
        if (Strings.isEmpty(s)) goto _L3; else goto _L11
_L11:
        if (hashset.contains(s)) goto _L13; else goto _L12
_L12:
        return -1;
        return hashset.size();
        if (true) goto _L15; else goto _L14
_L14:
    }

    public ArrayList getCategorizations()
    {
        if (categorizationsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (categorizationsList == null)
        {
            categorizationsList = new ArrayList(categorizations);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return categorizationsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ArrayList getDealTypes()
    {
        if (dealTypesList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (dealTypesList == null)
        {
            dealTypesList = new ArrayList(dealTypes);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return dealTypesList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Price getDiscount()
    {
        return discount;
    }

    public int getDiscountPercent()
    {
        return discountPercent;
    }

    public Date getEndAt()
    {
        return endAt;
    }

    public Date getEndRedemptionAt()
    {
        return endRedemptionAt;
    }

    public Date getExpiresAt()
    {
        return expiresAt;
    }

    public ArrayList getImagesList()
    {
        if (imagesList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (imagesList == null)
        {
            imagesList = new ArrayList(images);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return imagesList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ArrayList getIncentives()
    {
        if (incentivesList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (incentivesList == null)
        {
            incentivesList = new ArrayList(incentives);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return incentivesList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ArrayList getLegalDisclosures()
    {
        if (legalDisclosureList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (legalDisclosureList == null)
        {
            legalDisclosureList = new ArrayList(legalDisclosures);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return legalDisclosureList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int getMinimumPurchaseQuantity()
    {
        return minimumPurchaseQuantity;
    }

    public ArrayList getOptions()
    {
        if (optionsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (optionsList == null)
        {
            optionsList = new ArrayList(options);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return optionsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Price getPrice()
    {
        return price;
    }

    public int getSoldQuantity()
    {
        return soldQuantity;
    }

    public String getSoldQuantityMessage()
    {
        return soldQuantityMessage;
    }

    public String getStatus()
    {
        return status;
    }

    public String getTitle()
    {
        return title;
    }

    public String getTrait(String s)
    {
        return (String)traitPositionMap.get(s);
    }

    public ArrayList getUiTreatment()
    {
        if (uiTreatmentsList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (uiTreatmentsList == null)
        {
            uiTreatmentsList = new ArrayList(uiTreatment);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return uiTreatmentsList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Price getValue()
    {
        return value;
    }

    public String getVerticalTraitName()
    {
        return getTrait("1");
    }

    public ArrayList getVideos()
    {
        if (videoList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (videoList == null)
        {
            videoList = new ArrayList(videos);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return videoList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean hasAtLeasOneBookableOrSchedulableOption()
    {
        for (Iterator iterator = options.iterator(); iterator.hasNext();)
        {
            Option option = (Option)iterator.next();
            if (option.schedulerOptions != null)
            {
                String s = option.schedulerOptions.bookingType;
                boolean flag;
                if (Strings.notEmpty(s) && Strings.equalsIgnoreCase(s, "booking_engine"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (option.bookable || flag)
                {
                    return true;
                }
            }
        }

        return false;
    }

    protected boolean hasExternalUrl()
    {
        for (Iterator iterator = options.iterator(); iterator.hasNext();)
        {
            if (Strings.notEmpty(((Option)iterator.next()).externalUrl))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isSoldOut()
    {
        return isSoldOut;
    }

    public void setCategorizations(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((CategorizationItem)collection.next()).parentDeal = this;
        }

        categorizations = ((Collection) (obj));
    }

    public void setDealTypes(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((DealType)collection.next()).parentDeal = this;
        }

        dealTypes = ((Collection) (obj));
    }

    public void setDiscount(Price price1)
    {
        if (price1 != null)
        {
            price1.parentDeal = this;
        }
        discount = price1;
    }

    public void setDivision(Division division1)
    {
        if (division1 != null)
        {
            division1.parentDeal = this;
        }
        division = division1;
    }

    public void setExternalDealProvider(ExternalDealProvider externaldealprovider)
    {
        if (externaldealprovider != null)
        {
            externaldealprovider.parentDeal = this;
        }
        externalDealProvider = externaldealprovider;
    }

    public void setImages(Collection collection)
    {
        if (collection == null)
        {
            images = Collections.emptyList();
        } else
        {
            images = collection;
            collection = collection.iterator();
            while (collection.hasNext()) 
            {
                Image image = (Image)collection.next();
                image.afterJsonDeserializationPostProcessor();
                image.parentDeal = this;
            }
        }
    }

    public void setIncentives(Collection collection)
    {
        if (collection != null) goto _L2; else goto _L1
_L1:
        Object obj = Collections.emptyList();
_L4:
        incentives = ((Collection) (obj));
        return;
_L2:
        Iterator iterator = collection.iterator();
        do
        {
            obj = collection;
            if (!iterator.hasNext())
            {
                continue;
            }
            ((Incentive)iterator.next()).parentDeal = this;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setLegalDisclosures(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((LegalDisclosure)collection.next()).parentDeal = this;
        }

        legalDisclosures = ((Collection) (obj));
    }

    public void setMerchant(Merchant merchant1)
    {
        if (merchant1 != null)
        {
            merchant1.parentDeal = this;
        }
        merchant = merchant1;
    }

    public void setOptions(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Option)collection.next()).parentDeal = this;
        }

        options = ((Collection) (obj));
    }

    public void setPrice(Price price1)
    {
        if (price1 != null)
        {
            price1.parentDeal = this;
        }
        price = price1;
    }

    public void setUiTreatment(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((UiTreatment)collection.next()).parentDeal = this;
        }

        uiTreatment = ((Collection) (obj));
    }

    public void setValue(Price price1)
    {
        if (price1 != null)
        {
            price1.parentDeal = this;
        }
        value = price1;
    }

    public void setVideos(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Video)collection.next()).parentDeal = this;
        }

        videos = ((Collection) (obj));
    }

    protected void set_channels(List list)
    {
        List list1 = list;
        if (list == null)
        {
            list1 = Collections.emptyList();
        }
        _channels = list1;
    }

    protected void set_displayOptions(List list)
    {
        List list1 = list;
        if (list == null)
        {
            list1 = Collections.emptyList();
        }
        _displayOptions = list1;
    }

    protected void set_traits(List list)
    {
        List list1 = list;
        if (list == null)
        {
            list1 = Collections.emptyList();
        }
        _traits = list1;
    }
}
