// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            ShowPropertyParam

public class ApiGenerateShowParamBuilder
{
    public static class Merchant
    {

        public static final String MERCHANT = "merchant";
        public static final String MERCHANT_PROFILE_HTML = "profileHtml";
        public static final String MERCHANT_RECOMMENDATION = "recommendations";
        public static final String MERCHANT_TIPS = "tips";

        private Merchant()
        {
        }
    }

    public static class OldValues
    {

        public static final String END_REDEMPTION_AT = "endRedemptionAt";
        public static final String IMAGES = "images";
        public static final String IS_MULTIOPTION = "isMultiOption";
        public static final String LOCATIONS = "locations";
        public static final String PRICE_SUMMARY = "priceSummary";
        public static final String RECOMMENDATION = "recommendation";
        public static final String START_REDEMPTION_AT = "startRedemptionAt";

        private OldValues()
        {
        }
    }

    public static class Option
    {

        public static final String BOOKABLE_SEGMENTS = "bookableSegments";
        public static final String CATEGORY_INTENT = "category_intent";
        public static final String CHANNELS = "channels";
        public static final String DEFAULT = "default";
        public static final String GIFT_WRAPPING_CHARGE = "giftWrappingCharge";
        public static final String IMAGES = "images";
        public static final String INVENTORY_SERVICE = "inventoryService";
        public static final String SCHEDULER_OPTIONS = "schedulerOptions";
        public static final String SHIPPING_OPTIONS = "shippingOptions";
        public static final String UUID = "uuid";

        private Option()
        {
        }
    }


    public static final String BADGES = "badges";
    public static final String CATEGORIZATIONS = "categorizations";
    public static final String DEAL_TYPE_MERCHANT_PERSONA = "dealTypeMerchantPersona";
    public static final String DEAL_VIDEOS = "videos";
    public static final String DEFAULT = "default";
    public static final String EXTERNAL_DEAL_PROVIDER = "externalDealProvider";
    public static final String IMAGES = "images";
    public static final String INCENTIVES = "incentives";
    public static final String LEGAL_DISCLOSURES = "legalDisclosures";
    public static final String OPTIONS = "options";
    public static final String SPECIFIC_ATTRIBUTES = "specificAttributes";
    public static final String TRAITS = "traits";
    public static final String UI_TREATMENT = "uiTreatment";
    private boolean includeBadges;
    private boolean includeBookingUpdatesSchedulerOptions;
    private boolean includeCategorizations;
    private boolean includeChannels;
    private boolean includeDealOptionGiftWrappingCharge;
    private boolean includeDealSpecificAttributes;
    private boolean includeDealVideos;
    private boolean includeExternalDealProvider;
    private boolean includeImages;
    private boolean includeIncentives;
    private boolean includeInventoryService;
    private boolean includeLegalDisclosure;
    private boolean includeMerchantPersona;
    private boolean includeOldValues;
    private boolean includeRecommendation;
    private boolean includeTips;
    private boolean includeUiTreatments;
    private boolean isDealCard;
    private String showParamId;

    public ApiGenerateShowParamBuilder()
    {
        showParamId = "";
    }

    public ApiGenerateShowParamBuilder(String s)
    {
        showParamId = s;
    }

    private ShowPropertyParam generateMerchantShowParameterValue(boolean flag, boolean flag1, boolean flag2)
    {
        ShowPropertyParam showpropertyparam = new ShowPropertyParam("merchant");
        if (flag1)
        {
            showpropertyparam.addField(new ShowPropertyParam("recommendations"));
        }
        if (!flag)
        {
            showpropertyparam.addField(new ShowPropertyParam("profileHtml"));
            if (flag2)
            {
                showpropertyparam.addField(new ShowPropertyParam("tips"));
            }
        }
        return showpropertyparam;
    }

    public ApiGenerateShowParamBuilder badges(boolean flag)
    {
        includeBadges = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder bookingUpdatesSchedulerOptions(boolean flag)
    {
        includeBookingUpdatesSchedulerOptions = flag;
        return this;
    }

    public String build()
    {
        return buildParams().fieldsAsString();
    }

    public ShowPropertyParam buildParams()
    {
        ShowPropertyParam showpropertyparam = new ShowPropertyParam(showParamId);
        if (includeDealSpecificAttributes || includeDealVideos || includeDealOptionGiftWrappingCharge || includeBookingUpdatesSchedulerOptions || !isDealCard && includeRecommendation && includeTips || isDealCard && includeRecommendation || includeIncentives || includeInventoryService || includeLegalDisclosure || includeMerchantPersona || includeImages || includeCategorizations || includeChannels || includeExternalDealProvider || includeBadges || includeUiTreatments)
        {
            ShowPropertyParam showpropertyparam1 = new ShowPropertyParam("options");
            showpropertyparam.addField(new ShowPropertyParam("default"));
            showpropertyparam.addField(generateMerchantShowParameterValue(isDealCard, includeRecommendation, includeTips));
            if (includeImages)
            {
                showpropertyparam.addField(new ShowPropertyParam("images"));
            }
            if (includeDealSpecificAttributes)
            {
                showpropertyparam.addField(new ShowPropertyParam("specificAttributes"));
            }
            if (includeDealVideos)
            {
                showpropertyparam.addField(new ShowPropertyParam("videos"));
            }
            if (includeBadges)
            {
                showpropertyparam.addField(new ShowPropertyParam("badges"));
            }
            if (includeDealOptionGiftWrappingCharge)
            {
                showpropertyparam1.addField(new ShowPropertyParam("default")).addField(new ShowPropertyParam("images")).addField(new ShowPropertyParam("giftWrappingCharge")).addField(new ShowPropertyParam("shippingOptions")).addField(new ShowPropertyParam("uuid"));
                showpropertyparam.addField(new ShowPropertyParam("traits"));
            }
            if (includeChannels)
            {
                showpropertyparam1.addField(new ShowPropertyParam("channels"));
            }
            if (includeInventoryService)
            {
                showpropertyparam1.addField(new ShowPropertyParam("inventoryService"));
            }
            if (includeBookingUpdatesSchedulerOptions)
            {
                showpropertyparam1.addField(new ShowPropertyParam("schedulerOptions"));
            }
            if (includeIncentives)
            {
                showpropertyparam.addField(new ShowPropertyParam("incentives"));
            }
            if (includeMerchantPersona)
            {
                showpropertyparam.addField(new ShowPropertyParam("dealTypeMerchantPersona"));
            }
            if (includeCategorizations)
            {
                showpropertyparam.addField(new ShowPropertyParam("categorizations"));
            }
            if (includeLegalDisclosure)
            {
                showpropertyparam.addField(new ShowPropertyParam("legalDisclosures"));
            }
            if (includeExternalDealProvider)
            {
                showpropertyparam.addField(new ShowPropertyParam("externalDealProvider"));
            }
            if (includeUiTreatments)
            {
                showpropertyparam.addField(new ShowPropertyParam("uiTreatment"));
            }
            if (showpropertyparam1.fieldCount() > 0)
            {
                showpropertyparam.addField(showpropertyparam1);
            }
        }
        if (includeOldValues)
        {
            showpropertyparam.addField(new ShowPropertyParam("recommendation")).addField(new ShowPropertyParam("locations")).addField(new ShowPropertyParam("priceSummary")).addField(new ShowPropertyParam("startRedemptionAt")).addField(new ShowPropertyParam("endRedemptionAt")).addField(new ShowPropertyParam("isMultiOption")).addField(new ShowPropertyParam("images"));
        }
        return showpropertyparam;
    }

    public ApiGenerateShowParamBuilder categorizations(boolean flag)
    {
        includeCategorizations = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder channels(boolean flag)
    {
        includeChannels = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder connectedMarketPlace(boolean flag)
    {
        includeMerchantPersona = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder dealCard(boolean flag)
    {
        isDealCard = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder dealOptionGiftWrappingCharge(boolean flag)
    {
        includeDealOptionGiftWrappingCharge = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder dealSpecificAttributes(boolean flag)
    {
        includeDealSpecificAttributes = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder images(boolean flag)
    {
        includeImages = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder incentives(boolean flag)
    {
        includeIncentives = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder includeExternalDealProvider(boolean flag)
    {
        includeExternalDealProvider = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder includeLegalDisclosure(boolean flag)
    {
        includeLegalDisclosure = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder includeOldValues(boolean flag)
    {
        includeOldValues = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder includeUiTreatments(boolean flag)
    {
        includeUiTreatments = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder inventoryService(boolean flag)
    {
        includeInventoryService = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder recommendations(boolean flag)
    {
        includeRecommendation = flag;
        return this;
    }

    public ApiGenerateShowParamBuilder tips(boolean flag)
    {
        includeTips = flag;
        return this;
    }
}
