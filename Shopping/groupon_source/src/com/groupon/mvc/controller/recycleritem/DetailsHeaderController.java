// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.groupon.Channel;
import com.groupon.callbacks.OnDealImageEventListener;
import com.groupon.db.models.CommonOptions;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Image;
import com.groupon.db.models.Option;
import com.groupon.db.models.Price;
import com.groupon.db.models.PricingMetadata;
import com.groupon.models.country.Country;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.mvc.model.DetailsHeader;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.BuyUtils;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.GeoUtils;
import com.groupon.util.ImageUrl;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.LocationsUtil;
import com.groupon.util.UrgencyPricingUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class DetailsHeaderController extends RecyclerItemViewController
{
    private class DefaultOnDealImageEventListener
        implements OnDealImageEventListener
    {

        final DetailsHeaderController this$0;

        public void onImageChange(int i)
        {
            imageCarouselPosition = i;
        }

        public void onUserInteraction()
        {
            imageRotationState = false;
        }

        private DefaultOnDealImageEventListener()
        {
            this$0 = DetailsHeaderController.this;
            super();
        }

    }


    private static final int DEAL_DETAILS_COMPONENT_PADDING_V2 = 12;
    private static final String EMPTY_VALUE_PLACEHOLDER = "---";
    private static final float IMAGE_ASPECT_RATIO = 0.6068182F;
    private static final int SCREEN_HEIGHT_CUTOFF = 450;
    private static final int SCREEN_HEIGHT_OVER_IMAGE_HEIGHT_RATIO = 3;
    private BuyUtils buyUtil;
    private boolean canDisplayExposedMultiOptions;
    private Channel channel;
    private boolean comingFromMyGroupons;
    private CommonOptions commonOptions;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    private int discountPercent;
    private boolean displayBought;
    private boolean displayDiscount;
    private boolean displayLoadingView;
    private boolean displayMobileOnly;
    private GeoUtils geoUtils;
    private boolean goodsConnectedMarketPlace1504Enabled;
    private boolean headerFullyVisible;
    private int imageCarouselPosition;
    private boolean imageRotationState;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;
    private boolean mobileOnly1403USCAEnabled;
    private boolean multiOptions1508INTLEnabled;
    private Option option;
    private String preselectedOptionId;
    private SharedDealInfo sharedDealInfo;
    private boolean shouldShowOptionTitle;
    private boolean urgencyPricingAvailable;
    private com.groupon.util.UrgencyPricingUtils.UrgencyPricingType urgencyPricingOfferType;

    public DetailsHeaderController(Context context)
    {
        super(context);
        imageRotationState = true;
    }

    private float calculateDealImageHeight()
    {
        int i = context.getResources().getInteger(0x7f0d0005);
        int j = context.getResources().getInteger(0x7f0d0006);
        float f = (float)i / (float)(i + j);
        f = (DeviceInfoUtil.getScreenWidthDpi(context) * f - 12F) * 0.6068182F;
        if (context.getResources().getConfiguration().orientation == 1)
        {
            float f1 = DeviceInfoUtil.getScreenHeightDpi(context) / 3F;
            f = f1;
            if (f1 > 450F)
            {
                f = 450F;
            }
        }
        return f;
    }

    private boolean canDisplayConnectedMarketplace()
    {
        return goodsConnectedMarketPlace1504Enabled && deal != null && DealUtils.isConnectedMarketplaceDeal(deal);
    }

    private String computeLocationString()
    {
        Object obj = null;
        if (deal != null)
        {
            obj = new ArrayList();
            if (channel == Channel.GLOBAL_SEARCH || channel == Channel.NEARBY)
            {
                com.groupon.models.Place place = locationAutocompleteServiceWrapper.getLastUsedLocation();
                if (place != null)
                {
                    ((List) (obj)).add(place);
                }
            }
            obj = LocationsUtil.getLocation(currentCountryManager.getCurrentCountry().usesMetricSystem(), currentCountryManager.getCurrentCountry().isJapan(), deal, ((List) (obj)), context.getResources(), geoUtils, true);
        }
        return ((String) (obj));
    }

    private ArrayList createDealImageList()
    {
        Object obj;
        if (deal == null || option == null)
        {
            obj = null;
        } else
        {
            ArrayList arraylist = new ArrayList();
            obj = deal;
            int i;
            boolean flag;
            boolean flag1;
            if (!currentCountryManager.getCurrentCountry().isJapan())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            i = ((Deal) (obj)).optionDimensionsCount(flag1, currentCountryManager.getCurrentCountry().isUSACompatible());
            if (!currentCountryManager.getCurrentCountry().isJapan() && i <= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && buyUtil.showOptionsWithImages(deal, context))
            {
                for (obj = option.images.iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new ImageUrl(((Image)((Iterator) (obj)).next()).url, true))) { }
            }
            if (arraylist.isEmpty())
            {
                for (obj = deal.getImagesList().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new ImageUrl(((Image)((Iterator) (obj)).next()).url, true))) { }
            }
            obj = arraylist;
            if (arraylist.isEmpty())
            {
                arraylist.add(deal.getImageUrl());
                return arraylist;
            }
        }
        return ((ArrayList) (obj));
    }

    private String generateFormattedPrice()
    {
        String s;
        String s1;
        boolean flag;
        if (urgencyPricingAvailable)
        {
            if (option != null)
            {
                s = getDealOptionSaleValues(option.price);
            } else
            {
                s = getDealOptionSaleValues(sharedDealInfo.derivedPriceAmount, sharedDealInfo.derivedPriceCurrencyCode, sharedDealInfo.derivedMinimumPurchaseQuantity);
            }
        } else
        if (deal != null)
        {
            s = getPrice();
        } else
        {
            s = getDealCardPrice();
        }
        if (deal != null)
        {
            flag = deal.isTravelBookableDeal;
        } else
        {
            flag = sharedDealInfo.isTravelBookableDeal;
        }
        s1 = s;
        if (flag)
        {
            s1 = String.format(context.getString(0x7f080078), new Object[] {
                s
            });
        }
        return s1;
    }

    private String generateFormattedRegularPrice()
    {
        if (option != null)
        {
            return getDealOptionSaleValues(option.regularPrice);
        } else
        {
            return getDealOptionSaleValues(sharedDealInfo.derivedRegularPriceAmount, sharedDealInfo.derivedRegularPriceCurrencyCode, sharedDealInfo.derivedMinimumPurchaseQuantity);
        }
    }

    private String generateFormattedValue()
    {
        if (urgencyPricingAvailable)
        {
            if (option != null)
            {
                return getDealOptionSaleValues(option.value);
            } else
            {
                return getDealOptionSaleValues(sharedDealInfo.derivedValueAmount, sharedDealInfo.derivedValueCurrencyCode, sharedDealInfo.derivedMinimumPurchaseQuantity);
            }
        }
        if (deal != null)
        {
            return getDealValueWithoutDiscount();
        } else
        {
            return getDealCardValue();
        }
    }

    private String generateUrgencyPricingNowPriceHtml()
    {
        String s;
        if (option != null && option.pricingMetadata != null)
        {
            s = option.pricingMetadata.offerLabel;
        } else
        if (sharedDealInfo != null)
        {
            s = sharedDealInfo.derivedPricingMetadataOfferLabel;
        } else
        {
            s = "";
        }
        return context.getString(0x7f080513, new Object[] {
            generateFormattedPrice(), s
        });
    }

    private String getAcceptedPaymentMethods()
    {
        if (currentCountryManager.getCurrentCountry().isJapan() && option != null)
        {
            return option.paymentMethods;
        } else
        {
            return null;
        }
    }

    private String getDealCardPrice()
    {
        return currencyFormatter.formatWithQuantity(sharedDealInfo.derivedPriceAmount, sharedDealInfo.derivedPriceCurrencyCode, sharedDealInfo.derivedMinimumPurchaseQuantity, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
    }

    private String getDealCardValue()
    {
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            return String.format(context.getResources().getString(0x7f080134), new Object[] {
                Integer.valueOf(sharedDealInfo.derivedDiscountPercent)
            });
        } else
        {
            return currencyFormatter.formatWithQuantity(sharedDealInfo.derivedValueAmount, sharedDealInfo.derivedValueCurrencyCode, sharedDealInfo.derivedMinimumPurchaseQuantity, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        }
    }

    private String getDealId()
    {
        if (deal != null)
        {
            return deal.remoteId;
        } else
        {
            return sharedDealInfo.remoteId;
        }
    }

    private String getDealOptionSaleValues(int i, String s, int j)
    {
        return currencyFormatter.formatWithQuantity(i, s, j, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
    }

    private String getDealOptionSaleValues(Price price)
    {
        if (price != null)
        {
            return getDealOptionSaleValues(price.amount, price.currencyCode, option.getMinimumPurchaseQuantity());
        } else
        {
            return null;
        }
    }

    private String getDealValueWithoutDiscount()
    {
        String s1 = "---";
        String s = s1;
        if (commonOptions != null)
        {
            Price price = commonOptions.getValue();
            s = s1;
            if (price != null)
            {
                s = currencyFormatter.formatWithQuantity(price, commonOptions.getMinimumPurchaseQuantity(), true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
            }
        }
        return s;
    }

    private String getDiscount()
    {
        if (discountPercent > 0)
        {
            return String.format(context.getString(0x7f080501), new Object[] {
                Integer.valueOf(discountPercent)
            });
        } else
        {
            return "---";
        }
    }

    private ImageUrl getLargeImageUrl()
    {
        if (sharedDealInfo != null)
        {
            return sharedDealInfo.largeImageUrl;
        } else
        {
            return null;
        }
    }

    private String getPrice()
    {
        while (option == null || option.getPrice() == null) 
        {
            return null;
        }
        return currencyFormatter.formatWithQuantity(option.getPrice(), option.getMinimumPurchaseQuantity(), true, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
    }

    private String getTitle()
    {
        if (shouldShowOptionTitle)
        {
            if (option != null)
            {
                return option.title;
            } else
            {
                return sharedDealInfo.optionTitle;
            }
        }
        if (deal != null)
        {
            return deal.title;
        } else
        {
            return sharedDealInfo.title;
        }
    }

    private String getUrgencyPricingWasPriceLabel()
    {
        Context context = this.context;
        int i;
        if (urgencyPricingOfferType == com.groupon.util.UrgencyPricingUtils.UrgencyPricingType.INTRODUCTORY_PRICE)
        {
            i = 0x7f080446;
        } else
        {
            i = 0x7f08033c;
        }
        return context.getString(i);
    }

    private void initDisplayOptionsValues()
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        if (deal != null)
        {
            flag = deal.getDisplayOption("quantity", true);
        } else
        if (sharedDealInfo == null || sharedDealInfo.displayBought)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayBought = flag;
        if (deal != null)
        {
            flag = deal.getDisplayOption("discount", true);
        } else
        if (sharedDealInfo == null || sharedDealInfo.displayDiscount)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayDiscount = flag;
        if (displayDiscount && discountPercent != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayDiscount = flag;
        if (deal == null) goto _L2; else goto _L1
_L1:
        flag = deal.getDisplayOption("platformExclusive", false);
_L4:
        displayMobileOnly = flag;
        return;
_L2:
        if (sharedDealInfo != null)
        {
            flag = flag1;
            if (sharedDealInfo.displayMobileOnly)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean shouldDisplayDiscount()
    {
        return displayDiscount && !urgencyPricingAvailable;
    }

    private boolean shouldDisplayLoadingView()
    {
        return displayLoadingView && deal == null;
    }

    private boolean shouldDisplayMobileOnly()
    {
        return mobileOnly1403USCAEnabled && displayMobileOnly;
    }

    private boolean shouldDisplayReservationMessage()
    {
        return deal != null && DealUtils.isBookingEngineDeal(deal, true);
    }

    private boolean shouldShowLimitedAvailability()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (deal != null)
            {
                flag = flag1;
                if (option != null)
                {
                    if (!displayBought || !option.isLimitedQuantity || currentCountryManager.getCurrentCountry().isJapan() || shouldDisplayMobileOnly() || deal.isSoldOut() || Strings.equalsIgnoreCase("closed", deal.getStatus()) || urgencyPricingAvailable)
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

    public OnDealImageEventListener getCallback()
    {
        return new DefaultOnDealImageEventListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        boolean flag1 = true;
        Object obj;
        int i;
        boolean flag;
        if (option != null)
        {
            obj = option;
        } else
        {
            obj = deal;
        }
        commonOptions = ((CommonOptions) (obj));
        if (commonOptions != null)
        {
            i = commonOptions.getDiscountPercent();
        } else
        if (sharedDealInfo != null)
        {
            i = sharedDealInfo.derivedDiscountPercent;
        } else
        {
            i = 0;
        }
        discountPercent = i;
        initDisplayOptionsValues();
        if (deal == null)
        {
            flag = Strings.equalsIgnoreCase("closed", sharedDealInfo.status);
            String s;
            String s1;
            DetailsHeader detailsheader;
            if (multiOptions1508INTLEnabled && !sharedDealInfo.isSoldOut && !flag && Strings.notEmpty(sharedDealInfo.optionTitle))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            shouldShowOptionTitle = flag;
            urgencyPricingOfferType = UrgencyPricingUtils.getUrgencyPricingAvailability(sharedDealInfo.derivedPricingMetadataOfferType, sharedDealInfo.derivedPricingMetadataOfferLabelDescriptive, sharedDealInfo.derivedPricingMetadataOfferBeginsAt, sharedDealInfo.derivedPricingMetadataOfferEndsAt);
        } else
        {
            shouldShowOptionTitle = buyUtil.showOptionsWithImages(deal, context);
            if (option != null)
            {
                urgencyPricingOfferType = UrgencyPricingUtils.getUrgencyPricingAvailability(option.regularPrice, option.pricingMetadata);
            }
        }
        urgencyPricingAvailable = UrgencyPricingUtils.isUrgencyPricingAvailable(urgencyPricingOfferType, displayDiscount);
        if (Strings.notEmpty(preselectedOptionId))
        {
            obj = commonOptions;
        } else
        {
            obj = deal;
        }
        if (obj != null)
        {
            i = ((CommonOptions) (obj)).getSoldQuantity();
        } else
        {
            i = sharedDealInfo.soldQuantity;
        }
        if (obj != null)
        {
            obj = ((CommonOptions) (obj)).getSoldQuantityMessage();
        } else
        {
            obj = sharedDealInfo.soldQuantityMessage;
        }
        s = context.getResources().getQuantityString(0x7f0c0002, i);
        if (!Strings.notEmpty(obj))
        {
            obj = Integer.valueOf(i);
        }
        s1 = Strings.toString(obj);
        model = new DetailsHeader();
        ((DetailsHeader)model).dealId = getDealId();
        ((DetailsHeader)model).dealTitle = getTitle();
        ((DetailsHeader)model).dealLocation = computeLocationString();
        obj = (DetailsHeader)model;
        if (canDisplayExposedMultiOptions && !comingFromMyGroupons)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        obj.hideDiscountValueContainer = flag;
        detailsheader = (DetailsHeader)model;
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            obj = "";
        } else
        {
            obj = generateFormattedValue();
        }
        detailsheader.value = ((String) (obj));
        ((DetailsHeader)model).price = generateFormattedPrice();
        ((DetailsHeader)model).regularPrice = generateFormattedRegularPrice();
        ((DetailsHeader)model).wasPriceLabel = getUrgencyPricingWasPriceLabel();
        ((DetailsHeader)model).nowPriceHtml = generateUrgencyPricingNowPriceHtml();
        ((DetailsHeader)model).discount = getDiscount();
        ((DetailsHeader)model).boughtLabel = s;
        ((DetailsHeader)model).boughtCountMessage = s1;
        ((DetailsHeader)model).displayLimitedAvailability = shouldShowLimitedAvailability();
        ((DetailsHeader)model).displayDiscount = shouldDisplayDiscount();
        ((DetailsHeader)model).displayBought = displayBought;
        ((DetailsHeader)model).displayMobileOnly = shouldDisplayMobileOnly();
        ((DetailsHeader)model).displayReservationMessage = shouldDisplayReservationMessage();
        ((DetailsHeader)model).urgencyPricingAvailable = urgencyPricingAvailable;
        ((DetailsHeader)model).displayConnectedMarketplace = canDisplayConnectedMarketplace();
        ((DetailsHeader)model).displayLoadingView = shouldDisplayLoadingView();
        ((DetailsHeader)model).dealImageHeight = calculateDealImageHeight();
        ((DetailsHeader)model).channel = channel;
        ((DetailsHeader)model).largeImageUrl = getLargeImageUrl();
        ((DetailsHeader)model).dealImageList = createDealImageList();
        ((DetailsHeader)model).acceptedPaymentMethods = getAcceptedPaymentMethods();
        processDealImageViewData();
        setState(2);
    }

    public void processDealImageViewData()
    {
        DetailsHeader detailsheader = (DetailsHeader)model;
        boolean flag;
        if (headerFullyVisible && imageRotationState)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        detailsheader.imageRotationState = flag;
        ((DetailsHeader)model).imageCarouselPosition = imageCarouselPosition;
        setState(2);
    }

    public void setCanDisplayExposedMultiOptions(boolean flag)
    {
        setState(1);
        canDisplayExposedMultiOptions = flag;
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setComingFromMyGroupons(boolean flag)
    {
        setState(1);
        comingFromMyGroupons = flag;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setDisplayLoadingView(boolean flag)
    {
        setState(1);
        displayLoadingView = flag;
    }

    public void setGoodsConnectedMarketPlace1504Enabled(boolean flag)
    {
        setState(1);
        goodsConnectedMarketPlace1504Enabled = flag;
    }

    public void setHeaderFullyVisible(boolean flag)
    {
        setState(1);
        headerFullyVisible = flag;
    }

    public void setImageCarouselPosition(int i)
    {
        setState(1);
        imageCarouselPosition = i;
    }

    public void setMobileOnly1403USCAEnabled(boolean flag)
    {
        setState(1);
        mobileOnly1403USCAEnabled = flag;
    }

    public void setMultiOptions1508INTLEnabled(boolean flag)
    {
        setState(1);
        multiOptions1508INTLEnabled = flag;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }

    public void setPreselectedOptionId(String s)
    {
        setState(1);
        preselectedOptionId = s;
    }

    public void setSharedDealInfo(SharedDealInfo shareddealinfo)
    {
        setState(1);
        sharedDealInfo = shareddealinfo;
    }


/*
    static int access$102(DetailsHeaderController detailsheadercontroller, int i)
    {
        detailsheadercontroller.imageCarouselPosition = i;
        return i;
    }

*/


/*
    static boolean access$202(DetailsHeaderController detailsheadercontroller, boolean flag)
    {
        detailsheadercontroller.imageRotationState = flag;
        return flag;
    }

*/
}
