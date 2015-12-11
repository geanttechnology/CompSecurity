// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.groupon.Channel;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;
import com.groupon.callbacks.OnBuyButtonClickListener;
import com.groupon.db.models.CommonOptions;
import com.groupon.db.models.Deal;
import com.groupon.db.models.ExternalDealProvider;
import com.groupon.db.models.Option;
import com.groupon.db.models.PricingMetadata;
import com.groupon.db.models.SchedulerOption;
import com.groupon.goods.shoppingcart.CartSummaryActivity;
import com.groupon.goods.shoppingcart.NewPurchaseCart;
import com.groupon.goods.shoppingcart.ShoppingCartControllerListener;
import com.groupon.goods.shoppingcart.ShoppingCartErrorHelper;
import com.groupon.goods.shoppingcart.ShoppingCartPresenter;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.country.Country;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.mvc.view.DealDetailsBottomBarView;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BookingUtil;
import com.groupon.util.BuyUtils;
import com.groupon.util.Dates;
import com.groupon.util.DealUtils;
import com.groupon.util.UrgencyPricingUtils;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class BottomBarController
{
    public static interface BottomBarControllerListener
    {

        public abstract void onFinish();
    }

    private class BuyButtonAnimationListener
        implements android.view.animation.Animation.AnimationListener
    {

        final BottomBarController this$0;

        public void onAnimationEnd(Animation animation)
        {
            if (animation == buyButtonFadeOutAnimation && !cancelBuyButtonAnimation)
            {
                animation = context.getString(0x7f080054);
                bottomBarView.startBuyButtonTextAnimation(animation, buyButtonFadeInAnimation);
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        private BuyButtonAnimationListener()
        {
            this$0 = BottomBarController.this;
            super();
        }

    }

    private class CartControllerListener
        implements ShoppingCartControllerListener
    {

        final BottomBarController this$0;

        public void onCartCancel()
        {
            cancelBuyButtonAnimation = true;
            updateBuyButtonText();
            updateShoppingCartCounter();
            if (listener != null)
            {
                listener.onFinish();
            }
        }

        public void onCartException(Exception exception, boolean flag)
        {
            cancelBuyButtonAnimation = true;
            updateBuyButtonText();
            updateShoppingCartCounter();
            shoppingCartErrorHelper.shoudDisplayErrorDialog(exception, flag);
        }

        public void onCartReady()
        {
            updateBuyButtonView();
        }

        public void onItemAdded()
        {
            if (cartAbTestHelper.shouldSkipSummary())
            {
                Intent intent = NewPurchaseCart.openPurchaseCartIntent(context).putExtra("coming_from_deal_details", true);
                context.startActivity(intent);
                return;
            } else
            {
                Intent intent1 = CartSummaryActivity.openShoppingCartIntent(context).putExtra("coming_from_deal_details", true);
                context.startActivity(intent1);
                return;
            }
        }

        private CartControllerListener()
        {
            this$0 = BottomBarController.this;
            super();
        }

    }

    private class DateTimeFinderBuyButtonClickListener
        implements android.view.View.OnClickListener
    {

        final BottomBarController this$0;

        private void logDateTimeFinderBuyButtonClick()
        {
            ClickExtraInfo clickextrainfo = new ClickExtraInfo();
            clickextrainfo.type = dateTimeFinderReservationDetails.searchIntentCategory.toTrackingString();
            String s;
            if (dateTimeFinderReservationDetails.partialIntent)
            {
                s = "partial";
            } else
            {
                s = "full";
            }
            clickextrainfo.intent = s;
            logger.logClick("", "book_and_buy_click", channel.name(), JsonEncodedNSTField.NULL_JSON_NST_FIELD, clickextrainfo);
        }

        public void onClick(View view)
        {
            logDateTimeFinderBuyButtonClick();
            boolean flag;
            if (mobileOnly1403USCAEnabled && displayMobileOnly)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view = bookingUtil.createDateTimeFinderSchedulerIntent(dateTimeFinderReservationDetails, deal, option.remoteId, defaultOptionIdForExposedMultiOptions, channel, flag, false);
            context.startActivity(view);
        }

        private DateTimeFinderBuyButtonClickListener()
        {
            this$0 = BottomBarController.this;
            super();
        }

    }

    private class DefaultOnBuyButtonClickListener
        implements OnBuyButtonClickListener
    {

        final BottomBarController this$0;

        public void onBuyButtonClick(View view)
        {
            getBuyButtonListener().onClick(view);
        }

        private DefaultOnBuyButtonClickListener()
        {
            this$0 = BottomBarController.this;
            super();
        }

    }


    private static final int DAYS_LIMIT = 15;
    private static final String DTF_NST_BOOK_AND_BUY_CLICK_TYPE = "book_and_buy_click";
    private static final String DTF_NST_FULL_INTENT = "full";
    private static final String DTF_NST_PARTIAL_INTENT = "partial";
    private static final String GIA_ID_ON = "on";
    private List allOptions;
    private boolean allowedInCart;
    private BookingUtil bookingUtil;
    private DealDetailsBottomBarView bottomBarView;
    private Animation buyButtonFadeInAnimation;
    private Animation buyButtonFadeOutAnimation;
    private BuyUtils buyUtils;
    private boolean canDisplayExposedMultiOptions;
    private boolean cancelBuyButtonAnimation;
    private NewCartAbTestHelper cartAbTestHelper;
    private Channel channel;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean comingFromMyGroupons;
    private boolean comingFromShoppingCart;
    private CommonOptions commonOptions;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    private Deal deal;
    private boolean dealClosed;
    private boolean dealSoldOut;
    private String defaultOptionIdForExposedMultiOptions;
    private boolean displayDiscount;
    private boolean displayMobileOnly;
    private boolean displayTimer;
    private boolean gdt1503USCAEnabled;
    private boolean isDeepLinked;
    private final BottomBarControllerListener listener;
    private Logger logger;
    private boolean mobileOnly1403USCAEnabled;
    private Option option;
    private String preselectedOptionId;
    private ShoppingCartErrorHelper shoppingCartErrorHelper;
    private ShoppingCartPresenter shoppingCartPresenter;
    private ShoppingCartService shoppingCartService;
    private boolean showViewCart;
    private boolean thirdPartyLinkout1509Enabled;
    private DateFormat timeLeftDateFormat;

    public BottomBarController(Context context1, DealDetailsBottomBarView dealdetailsbottombarview, BottomBarControllerListener bottombarcontrollerlistener)
    {
        context = context1;
        bottomBarView = dealdetailsbottombarview;
        bottomBarView.setOnBuyButtonClickListener(new DefaultOnBuyButtonClickListener());
        listener = bottombarcontrollerlistener;
        RoboGuice.getInjector(context1).injectMembers(this);
        if (cartAbTestHelper.isShoppingCartEnabled())
        {
            shoppingCartPresenter.setShoppingCartControllerListener(new CartControllerListener());
            shoppingCartErrorHelper.setShoppingCartPresenter(shoppingCartPresenter);
        }
    }

    private void addItemToCart()
    {
        if (shoppingCartPresenter.addToCartAndOpen(deal, option))
        {
            cancelBuyButtonAnimation = false;
            shoppingCartService.setCartInAppMessageViewed(true);
            String s = generateBuyButtonText(dealSoldOut, dealClosed, allowedInCart, shouldEnableDateTimeFinder());
            bottomBarView.startBuyButtonTextAnimation(s, buyButtonFadeOutAnimation);
            bottomBarView.updateShoppingCartCounter(shoppingCartService.getCartItemsCount() + option.minimumPurchaseQuantity);
            bottomBarView.animateShoppingCartButton();
        }
    }

    private boolean areBookingUpdatesAvailable()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            Object obj = deal.getOptions();
            flag = flag1;
            if (obj == null)
            {
                break label0;
            }
            flag = flag1;
            if (((Collection) (obj)).size() <= 0)
            {
                break label0;
            }
            obj = ((Collection) (obj)).iterator();
            Option option1;
            String s;
            do
            {
                do
                {
                    flag = flag1;
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    option1 = (Option)((Iterator) (obj)).next();
                } while (option1 == null || option1.schedulerOptions == null);
                s = option1.schedulerOptions.bookingType;
            } while (!Strings.notEmpty(s) || !Strings.equalsIgnoreCase(s, "booking_engine") || !option1.bookable);
            flag = true;
        }
        return flag;
    }

    private String generateBottomBarBookingText(boolean flag)
    {
        if (flag)
        {
            if (DealUtils.isFoodAndDrinkDeal(deal))
            {
                return context.getString(0x7f08012a);
            }
            if (DealUtils.isHealthBeautyWellnessDeal(deal))
            {
                return context.getString(0x7f080129);
            } else
            {
                return "";
            }
        } else
        {
            return context.getString(0x7f08012a);
        }
    }

    private String generateBuyButtonText(boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        if (deal == null || flag)
        {
            return context.getString(0x7f0803ba);
        }
        if (flag1)
        {
            return context.getString(0x7f080146);
        }
        if (flag3)
        {
            return context.getString(0x7f080071);
        }
        String s;
        String s1;
        if (option != null)
        {
            s = option.externalUrl;
        } else
        {
            s = "";
        }
        if (deal.externalDealProvider == null)
        {
            s1 = "";
        } else
        {
            s1 = deal.externalDealProvider.name;
        }
        if (thirdPartyLinkout1509Enabled && s != null && Strings.notEmpty(s1))
        {
            bottomBarView.isBuyButtonNormalTypeFace = true;
            return context.getString(0x7f08024e, new Object[] {
                s1
            });
        }
        if (currentCountryManager.getCurrentCountry().isJapan() && s != null && Strings.notEmpty(s))
        {
            return context.getString(0x7f080352);
        }
        if (deal.isApplyButton)
        {
            return context.getString(0x7f08025e);
        }
        if (flag2)
        {
            return context.getString(0x7f08007f);
        }
        if (deal.derivedIsGLiveDeal)
        {
            return context.getString(0x7f0801e7);
        }
        if (deal.isTravelBookableDeal && !currentCountryManager.getCurrentCountry().isJapan())
        {
            Context context1 = context;
            int i;
            if (checkInDate != null && checkOutDate != null)
            {
                i = 0x7f0800c8;
            } else
            {
                i = 0x7f080359;
            }
            return context1.getString(i);
        }
        if (deal.channels.contains(Channel.GETAWAYS.toString().toLowerCase()) && deal.getOptions().size() > 1 && Strings.isEmpty(preselectedOptionId))
        {
            return context.getString(0x7f08035c);
        } else
        {
            return context.getString(0x7f08007f);
        }
    }

    private String generateTimeLeftText(Date date, boolean flag, boolean flag1, boolean flag2)
    {
        if (flag2)
        {
            return generateBottomBarBookingText(true);
        }
        if (deal.derivedIsGLiveDeal)
        {
            return context.getString(0x7f0801e8);
        }
        if (flag)
        {
            return generateBottomBarBookingText(false);
        }
        if (flag1)
        {
            return context.getString(0x7f08024d);
        }
        if (date != null)
        {
            return timeLeftDateFormat.format(date);
        } else
        {
            return null;
        }
    }

    private android.view.View.OnClickListener getBuyButtonListener()
    {
        String s;
        ClickExtraInfo clickextrainfo;
        boolean flag;
        boolean flag1;
        if (allOptions.size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mobileOnly1403USCAEnabled && displayMobileOnly)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (allowedInCart)
        {
            s = logger.encodeAsCSV(new String[] {
                getClass().getSimpleName(), channel.toString()
            });
        } else
        {
            s = channel.toString();
        }
        clickextrainfo = new ClickExtraInfo();
        clickextrainfo.buyAsGift = Boolean.valueOf(false);
        if (buyUtils.showOptionsWithImages(deal, context) && Strings.notEmpty(preselectedOptionId))
        {
            if (allowedInCart)
            {
                return getCartListenerForOptions(deal, option, "click_buy", s, shoppingCartService);
            }
            if (showViewCart)
            {
                return getViewCartListener(deal, option);
            }
            com.groupon.models.nst.CSVEncodedNSTField csvencodednstfield;
            if (Strings.equals("click_buy", "buy_now_click"))
            {
                csvencodednstfield = buyUtils.nstClickMetadata(logger, shoppingCartService, deal, option);
            } else
            {
                csvencodednstfield = buyUtils.nstClickMetadata(logger, deal, option);
            }
            return buyUtils.getListenerForOptions(context, deal, option, defaultOptionIdForExposedMultiOptions, channel, flag1, false, "click_buy", s, csvencodednstfield, clickextrainfo, isDeepLinked);
        }
        if (allowedInCart)
        {
            return getCartListener(deal, option, flag, channel, "click_buy", s, shoppingCartService);
        }
        if (showViewCart)
        {
            return getViewCartListener(deal, null);
        }
        Object obj;
        if (Strings.equals("click_buy", "buy_now_click"))
        {
            BuyUtils buyutils = buyUtils;
            Logger logger1 = logger;
            ShoppingCartService shoppingcartservice = shoppingCartService;
            Deal deal1 = deal;
            if (flag)
            {
                obj = null;
            } else
            {
                obj = option;
            }
            obj = buyutils.nstClickMetadata(logger1, shoppingcartservice, deal1, ((Option) (obj)));
        } else
        if (gdt1503USCAEnabled && !flag)
        {
            obj = getGdtClickMetadata(option);
        } else
        if (deal.derivedIsGLiveDeal)
        {
            obj = getGiaClickMetadata();
        } else
        {
            obj = buyUtils.nstClickMetadata(logger, deal);
        }
        if (shouldEnableDateTimeFinder())
        {
            return new DateTimeFinderBuyButtonClickListener();
        }
        if (canDisplayExposedMultiOptions || Strings.notEmpty(preselectedOptionId))
        {
            return buyUtils.getListenerForOptions(context, deal, option, defaultOptionIdForExposedMultiOptions, channel, flag1, false, "click_buy", s, ((com.groupon.tracking.mobile.EncodedNSTField) (obj)), clickextrainfo, isDeepLinked);
        } else
        {
            return buyUtils.getListener(context, flag, deal, channel, "click_buy", s, ((com.groupon.tracking.mobile.EncodedNSTField) (obj)), checkInDate, checkOutDate, flag1, false, thirdPartyLinkout1509Enabled, isDeepLinked);
        }
    }

    private android.view.View.OnClickListener getCartListenerForOptions(final Deal deal, final Option option, final String nstClickType, final String nstPageId, final ShoppingCartService shoppingCartService)
    {
        return new android.view.View.OnClickListener() {

            final BottomBarController this$0;
            final Deal val$deal;
            final String val$nstClickType;
            final String val$nstPageId;
            final Option val$option;
            final ShoppingCartService val$shoppingCartService;

            public void onClick(View view)
            {
                logger.logClick("", nstClickType, nstPageId, buyUtils.nstClickMetadata(logger, shoppingCartService, deal, option));
                addItemToCart();
            }

            
            {
                this$0 = BottomBarController.this;
                nstClickType = s;
                nstPageId = s1;
                shoppingCartService = shoppingcartservice;
                deal = deal1;
                option = option1;
                super();
            }
        };
    }

    private Date getDealOrOfferEndAt(Date date)
    {
        if (shouldUpdateSaleTimeLeft())
        {
            date = option.pricingMetadata.offerEndsAt;
        }
        return date;
    }

    private android.view.View.OnClickListener getViewCartListener(final Deal deal, final Option option)
    {
        return new android.view.View.OnClickListener() {

            final BottomBarController this$0;
            final Deal val$deal;
            final Option val$option;

            public void onClick(View view)
            {
                logger.logClick("", "view_cart_click", "", buyUtils.nstClickMetadata(logger, shoppingCartService, deal, option));
                context.startActivity(shoppingCartService.getOpenCartIntent());
            }

            
            {
                this$0 = BottomBarController.this;
                deal = deal1;
                option = option1;
                super();
            }
        };
    }

    private boolean hasFreeShipping()
    {
        return currentCountryManager.getCurrentCountry().isUSACompatible() && deal.allOptionsAreFreeShipping() && !dealClosed && !dealSoldOut;
    }

    private boolean isUrgencyPricingAvailable()
    {
        boolean flag = false;
        if (option != null)
        {
            flag = UrgencyPricingUtils.isUrgencyPricingAvailable(UrgencyPricingUtils.getUrgencyPricingAvailability(option.regularPrice, option.pricingMetadata), displayDiscount);
        }
        return flag;
    }

    private boolean shouldDisplayTimeLeft(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4)
    {
        return deal.derivedIsGLiveDeal || !flag && !flag1 && !flag3 && !flag4 && displayTimer && (comingFromShoppingCart || !flag2);
    }

    private boolean shouldDisplayTimeLeftLabel(boolean flag, boolean flag1)
    {
        return !deal.derivedIsGLiveDeal && !flag && !shouldEnableDateTimeFinder() && !flag1 && !shouldUpdateSaleTimeLeft();
    }

    private boolean shouldEnableBuyButton()
    {
        return !dealClosed && !dealSoldOut && (!allowedInCart || shoppingCartPresenter.isCartReady());
    }

    private boolean shouldEnableDateTimeFinder()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = flag1;
            if (DealUtils.isBookingEngineDeal(deal, false))
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean shouldUpdateSaleTimeLeft()
    {
        return isUrgencyPricingAvailable() && Strings.notEmpty(option.pricingMetadata.timerLabel);
    }

    public void displayBottomBar()
    {
        if (!comingFromMyGroupons)
        {
            bottomBarView.setVisibility(0);
        }
    }

    public android.view.View.OnClickListener getCartListener(final Deal deal, final Option option, final boolean multiDeal, Channel channel1, final String nstClickType, final String nstPageId, final ShoppingCartService shoppingCartService)
    {
        return new android.view.View.OnClickListener() {

            final BottomBarController this$0;
            final Deal val$deal;
            final boolean val$multiDeal;
            final String val$nstClickType;
            final String val$nstPageId;
            final Option val$option;
            final ShoppingCartService val$shoppingCartService;

            public void onClick(View view)
            {
                if (multiDeal)
                {
                    logger.logClick("", nstClickType, nstPageId, buyUtils.nstClickMetadata(logger, shoppingCartService, deal, null));
                } else
                {
                    logger.logClick("", nstClickType, nstPageId, buyUtils.nstClickMetadata(logger, shoppingCartService, deal, option));
                }
                addItemToCart();
            }

            
            {
                this$0 = BottomBarController.this;
                multiDeal = flag;
                nstClickType = s;
                nstPageId = s1;
                shoppingCartService = shoppingcartservice;
                deal = deal1;
                option = option1;
                super();
            }
        };
    }

    protected ClickMetadata getGdtClickMetadata(Option option1)
    {
        ClickMetadata clickmetadata = new ClickMetadata();
        if (option1.specificAttributeDelivery || option1.specificAttributeTakeout)
        {
            option1 = "on";
        } else
        {
            option1 = "off";
        }
        clickmetadata.gdtFlag = option1;
        return clickmetadata;
    }

    protected ClickMetadata getGiaClickMetadata()
    {
        ClickMetadata clickmetadata = new ClickMetadata();
        clickmetadata.dealId = deal.remoteId;
        clickmetadata.dealUuid = deal.uuid;
        clickmetadata.giaId = "on";
        return clickmetadata;
    }

    public void onResume()
    {
        if (allowedInCart)
        {
            shoppingCartPresenter.cacheCart();
        }
        updateBuyButtonText();
        updateShoppingCartCounter();
    }

    public void setCanDisplayExposedMultiOptions(boolean flag)
    {
        canDisplayExposedMultiOptions = flag;
    }

    public void setChannel(Channel channel1)
    {
        channel = channel1;
    }

    public void setCheckInDate(Date date)
    {
        checkInDate = date;
    }

    public void setCheckOutDate(Date date)
    {
        checkOutDate = date;
    }

    public void setComingFromMyGroupons(boolean flag)
    {
        comingFromMyGroupons = flag;
    }

    public void setComingFromShoppingCart(boolean flag)
    {
        comingFromShoppingCart = flag;
    }

    public void setDateTimeFinderReservationDetails(DateTimeFinderReservationDetails datetimefinderreservationdetails)
    {
        dateTimeFinderReservationDetails = datetimefinderreservationdetails;
    }

    public void setDealAndOption(Deal deal1, Option option1)
    {
        boolean flag1 = true;
        deal = deal1;
        option = option1;
        Object obj;
        boolean flag;
        if (option1 != null)
        {
            obj = option1;
        } else
        {
            obj = deal1;
        }
        commonOptions = ((CommonOptions) (obj));
        allOptions = deal1.getOptions();
        if (Strings.equalsIgnoreCase("closed", deal1.status) || option1 != null && Strings.equalsIgnoreCase("closed", option1.status))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dealClosed = flag;
        if (deal1.isSoldOut() || option1 != null && option1.isSoldOut())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dealSoldOut = flag;
        displayTimer = deal1.getDisplayOption("timer", true);
        displayDiscount = deal1.getDisplayOption("discount", true);
        displayMobileOnly = deal1.getDisplayOption("platformExclusive", true);
        if (allOptions.size() > 0)
        {
            option1 = ((Option)allOptions.get(0)).externalUrl;
        } else
        {
            option1 = null;
        }
        if (Strings.isEmpty(option1) && deal1.allowedInCart && cartAbTestHelper.isShoppingCartEnabled())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        allowedInCart = flag;
        if (allowedInCart)
        {
            shoppingCartPresenter.cacheCart();
            buyButtonFadeInAnimation = AnimationUtils.loadAnimation(context, 0x7f040009);
            buyButtonFadeOutAnimation = AnimationUtils.loadAnimation(context, 0x7f04000a);
            buyButtonFadeOutAnimation.setAnimationListener(new BuyButtonAnimationListener());
        }
    }

    public void setDefaultOptionIdForExposedMultiOptions(String s)
    {
        defaultOptionIdForExposedMultiOptions = s;
    }

    public void setGdt1503USCAEnabled(boolean flag)
    {
        gdt1503USCAEnabled = flag;
    }

    public void setIsDeepLinked(boolean flag)
    {
        isDeepLinked = flag;
    }

    public void setMobileOnly1403USCAEnabled(boolean flag)
    {
        mobileOnly1403USCAEnabled = flag;
    }

    public void setPreselectedOptionId(String s)
    {
        preselectedOptionId = s;
    }

    public void setShowViewCart(boolean flag)
    {
        showViewCart = flag;
    }

    public void setThirdPartyLinkout1509Enabled(boolean flag)
    {
        thirdPartyLinkout1509Enabled = flag;
    }

    public void slideInBottomBar(OnBottomBarAnimationFinishedListener onbottombaranimationfinishedlistener)
    {
        if (!comingFromMyGroupons)
        {
            bottomBarView.slideInBottomBar(onbottombaranimationfinishedlistener);
        }
    }

    public void slideOutBottomBar(OnBottomBarAnimationFinishedListener onbottombaranimationfinishedlistener)
    {
        bottomBarView.slideOutBottomBar(onbottombaranimationfinishedlistener);
    }

    public void updateBuyButtonText()
    {
        String s = generateBuyButtonText(dealSoldOut, dealClosed, allowedInCart, shouldEnableDateTimeFinder());
        bottomBarView.updateBuyButtonText(s);
    }

    public void updateBuyButtonView()
    {
        int i;
        if (!comingFromShoppingCart && !comingFromMyGroupons)
        {
            Logger logger1 = logger;
            String s1 = deal.remoteId;
            String s;
            boolean flag;
            if (dealSoldOut)
            {
                s = "sold_out";
            } else
            if (dealClosed)
            {
                s = "expired";
            } else
            {
                s = "available";
            }
            logger1.logImpression("", "buy_button_status", s1, s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        }
        s = generateBuyButtonText(dealSoldOut, dealClosed, allowedInCart, shouldEnableDateTimeFinder());
        flag = shouldEnableBuyButton();
        if (allowedInCart && comingFromShoppingCart)
        {
            i = 0x7f0202d4;
        } else
        {
            i = 0x7f0202b8;
        }
        bottomBarView.updateBuyButton(s, i, flag, hasFreeShipping());
    }

    public void updateShoppingCartCounter()
    {
        bottomBarView.updateShoppingCartCounter(shoppingCartService.getCartItemsCount());
    }

    public void updateShoppingCartView()
    {
        bottomBarView.updateShoppingCartVisibility(allowedInCart);
    }

    public void updateTimeLeftView()
    {
        Object obj = commonOptions.getEndRedemptionAt();
        Object obj1 = getDealOrOfferEndAt(deal.getEndAt());
        if (obj1 != null)
        {
            obj = obj1;
        }
        boolean flag = Dates.isDateAfterLimit(((Date) (obj)), 15);
        boolean flag4 = Dates.isTimeInPast(((Date) (obj)), ((Date) (obj1)));
        boolean flag3 = shouldUpdateSaleTimeLeft();
        String s;
        boolean flag1;
        boolean flag2;
        boolean flag5;
        if (flag && !flag3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (buyUtils.supportsPrePurchaseBooking(deal) || areBookingUpdatesAvailable() && !isUrgencyPricingAvailable())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (option != null)
        {
            obj1 = option.externalUrl;
        } else
        {
            obj1 = "";
        }
        if (deal.externalDealProvider == null)
        {
            s = "";
        } else
        {
            s = deal.externalDealProvider.name;
        }
        if (thirdPartyLinkout1509Enabled && obj1 != null && Strings.notEmpty(s))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj = generateTimeLeftText(((Date) (obj)), flag1, flag, shouldEnableDateTimeFinder());
        flag5 = shouldDisplayTimeLeft(dealClosed, dealSoldOut, allowedInCart, flag4, flag2);
        flag1 = shouldDisplayTimeLeftLabel(flag1, flag);
        if (flag2 || (dealSoldOut || dealClosed || flag4 || !displayTimer) && !allowedInCart && !deal.derivedIsGLiveDeal || allowedInCart)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bottomBarView.updateTimeLeft(((String) (obj)), flag5, flag1, flag);
        if (flag3)
        {
            bottomBarView.updateTimeLeftUrgencyPricing(option.pricingMetadata.timerLabel);
        }
    }











/*
    static boolean access$1802(BottomBarController bottombarcontroller, boolean flag)
    {
        bottombarcontroller.cancelBuyButtonAnimation = flag;
        return flag;
    }

*/












}
