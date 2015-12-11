// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.location.Location;
import com.groupon.Channel;
import com.groupon.RedirectLogger;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Relevance;
import com.groupon.db.models.WidgetSummary;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.category.Category;
import com.groupon.models.nst.CategoryClickExtraInfo;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.models.nst.DealConfirmationViewExtraInfo;
import com.groupon.models.nst.DealViewExtraInfo;
import com.groupon.models.nst.FinderCardImpressionExtraInfo;
import com.groupon.models.nst.GoogleWalletCardClickExtraInfo;
import com.groupon.models.nst.GoogleWalletDialogClickExtraInfo;
import com.groupon.models.nst.GoogleWalletExtraInfo;
import com.groupon.models.nst.GoogleWalletFutureUseExtraInfo;
import com.groupon.models.nst.HotelsSearchClickMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.MarketRateDealImpressionExtraInfo;
import com.groupon.models.nst.MultiOptionExtraInfo;
import com.groupon.models.nst.PurchaseConfirmationExtraInfo;
import com.groupon.models.nst.PurchaseInitiationExtraInfo;
import com.groupon.models.nst.RedemptionExtraInfo;
import com.groupon.models.nst.ThankYouScreenExtraInfo;
import com.groupon.models.nst.WidgetClickMetadata;
import com.groupon.models.nst.WidgetExtraInfo;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.events.DealImpression;
import com.groupon.tracking.mobile.events.DealSearch;
import com.groupon.tracking.mobile.events.Impression;
import com.groupon.tracking.mobile.events.PageView;
import com.groupon.tracking.mobile.sdk.Logger;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            IncentivesUtil, GeoPoint, GeoUtils, HttpUtil, 
//            Tracking

public class LoggingUtils
{

    private static final String DEAL_IMPRESSION = "ns:dealImpression";
    private static final String EDIT_ORDER_SELECTION = "edit_order_selection";
    private static final String SEE_ALL_DEAL_MODAL = "see_all_deals_modal";
    private static final String SEE_ALL_IMPRESSION = "see_all_button";
    private static final String WIDGET_IMPRESSION = "ns:widgetImpression";
    private DateFormat dtfDateTime;
    private GeoUtils geoUtils;
    private IncentivesUtil incentivesUtil;
    private LocationService locationService;
    private Logger logger;
    private ObjectMapper objectMapper;
    private Channel originatingNstChannel;
    private String presentationContext;
    private RedirectLogger redirectLogger;
    private boolean requiresRedirectLogging;
    private Tracking tracking;

    public LoggingUtils()
    {
        requiresRedirectLogging = true;
        presentationContext = null;
    }

    private void doCreateObjectMapper()
    {
        if (objectMapper != null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        this;
        JVM INSTR monitorenter ;
        if (objectMapper == null)
        {
            objectMapper = new ObjectMapper();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String getTrackingChannel(boolean flag, String s)
    {
        String s1;
        if (flag)
        {
            s1 = "bookingDeal";
        } else
        {
            s1 = "getawaysDeal";
        }
        if (Strings.equalsIgnoreCase(s, Channel.GETAWAYS.toString()))
        {
            return s1;
        } else
        {
            return "";
        }
    }

    private String getWidgetNameBasedOnType(WidgetSummary widgetsummary)
    {
        byte byte0;
        widgetsummary = widgetsummary.type;
        byte0 = -1;
        widgetsummary.hashCode();
        JVM INSTR lookupswitch 4: default 52
    //                   -1723349181: 114
    //                   -1653375329: 86
    //                   99895158: 100
    //                   942990366: 128;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_128;
_L6:
        switch (byte0)
        {
        default:
            return null;

        case 0: // '\0'
        case 1: // '\001'
            return "RVD";

        case 2: // '\002'
            return "CAB";

        case 3: // '\003'
            return "CAV";
        }
_L3:
        if (widgetsummary.equals("MegamindWatsonRecentlyViewedDeals_Android"))
        {
            byte0 = 0;
        }
          goto _L6
_L4:
        if (widgetsummary.equals("MegamindRecentlyViewedDeals_PF_NoSeeMore_android"))
        {
            byte0 = 1;
        }
          goto _L6
_L2:
        if (widgetsummary.equals("MegamindCustomersAlsoBought"))
        {
            byte0 = 2;
        }
          goto _L6
        if (widgetsummary.equals("MegamindCustomersAlsoViewedMobile"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public String encodeAsJson(Object obj)
    {
        doCreateObjectMapper();
        try
        {
            obj = objectMapper.writeValueAsString(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException(((Throwable) (obj)));
        }
        return ((String) (obj));
    }

    public JsonEncodedNSTField getDealConfirmationViewExtraInfo(boolean flag, String s, String s1, String s2)
    {
        return new DealConfirmationViewExtraInfo(getTrackingChannel(flag, s), s1, s2);
    }

    public JsonEncodedNSTField getDealViewExtraInfo(AbstractDeal abstractdeal, boolean flag, String s, String s1, String s2, String s3, String s4, 
            DateTimeFinderReservationDetails datetimefinderreservationdetails)
    {
        AbstractDeal abstractdeal1 = null;
        String s5 = incentivesUtil.getIncentivePromoCode(abstractdeal, flag);
        if (Strings.notEmpty(s) || Strings.notEmpty(s5) || Strings.notEmpty(s1) || Strings.notEmpty(s2) || Strings.notEmpty(s3) || Strings.notEmpty(s4))
        {
            abstractdeal = new DealViewExtraInfo(s, s5, s1, abstractdeal.derivedPricingMetadataOfferType, s2, s3, s4);
            abstractdeal1 = abstractdeal;
            if (datetimefinderreservationdetails != null)
            {
                abstractdeal.type = datetimefinderreservationdetails.searchIntentCategory.toTrackingString();
                abstractdeal.DTFValue = dtfDateTime.format(datetimefinderreservationdetails.reservationDate);
                abstractdeal1 = abstractdeal;
            }
        }
        return abstractdeal1;
    }

    public JsonEncodedNSTField getLogExtraInfo(boolean flag, String s, int i, int j, String s1, String s2, String s3)
    {
        return new PurchaseConfirmationExtraInfo(getTrackingChannel(flag, s), Integer.toString(i), Integer.toString(j), s1, s2, s3);
    }

    public Logger getLogger()
    {
        return logger;
    }

    public JsonEncodedNSTField getMarketRateExtraInfoString(String s)
    {
        return new MarketRateDealImpressionExtraInfo(s);
    }

    public JsonEncodedNSTField getMarketRateExtraInfoString(String s, int i, int j, String s1)
    {
        return new MarketRateDealImpressionExtraInfo(s, Integer.toString(i), Integer.toString(j), s1);
    }

    public JsonEncodedNSTField getMarketRateExtraInfoString(String s, boolean flag)
    {
        return new MarketRateDealImpressionExtraInfo(s, flag);
    }

    public String getMultiOptionExtraInfoString(String s, String s1)
    {
        return encodeAsJson(new MultiOptionExtraInfo(s, s1));
    }

    public Channel getOriginatingNstChannel()
    {
        if (originatingNstChannel != null)
        {
            return originatingNstChannel;
        } else
        {
            return Channel.UNKNOWN;
        }
    }

    public JsonEncodedNSTField getPurchaseInitiationExtraInfo(boolean flag, String s, String s1, String s2)
    {
        s = getTrackingChannel(flag, s);
        if (Strings.notEmpty(s) || Strings.notEmpty(s1) || Strings.notEmpty(s2))
        {
            return new PurchaseInitiationExtraInfo(s, s1, s2);
        } else
        {
            return JsonEncodedNSTField.NULL_JSON_NST_FIELD;
        }
    }

    public boolean isRequiresRedirectLogging()
    {
        return requiresRedirectLogging;
    }

    public void logBuyWithGoogleButtonClick(Channel channel, String s, String s1)
    {
        logger.logClick("", "buy_with_google_click", channel.toString(), null, new GoogleWalletExtraInfo(s, s1));
    }

    public void logBuyWithGoogleButtonImpression(Channel channel, String s)
    {
        logger.logImpression("", "buy_with_google", channel.toString(), "bottom", new GoogleWalletExtraInfo(s, null));
    }

    public void logCategoryBarClick(String s, String s1, String s2)
    {
        logger.logClick("", s, s1, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new CategoryClickExtraInfo(s2));
    }

    public void logCategoryCarouselClick(String s, String s1, String s2, Category category)
    {
        logger.logClick("", s, s1, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new CategoryClickExtraInfo(s2, category.friendlyName));
    }

    public void logCategoryClick(String s, String s1, String s2, String s3, Category category)
    {
        logger.logClick("", s, s1, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new CategoryClickExtraInfo(s2, s3, category.friendlyName));
    }

    public void logCategoryClick(String s, String s1, String s2, String s3, String s4, Category category)
    {
        logger.logClick("", s, s1, JsonEncodedNSTField.NULL_JSON_NST_FIELD, new CategoryClickExtraInfo(s2, s3, s4, category.friendlyName));
    }

    public void logClick(String s, String s1, String s2, EncodedNSTField encodednstfield, EncodedNSTField encodednstfield1)
    {
        logger.logClick(s, s1, s2, encodednstfield, encodednstfield1);
    }

    public void logClick(String s, String s1, String s2, String s3)
    {
        logger.logClick(s, s1, s2, s3);
    }

    public void logClick(String s, String s1, String s2, String s3, String s4)
    {
        ClickMetadata clickmetadata = new ClickMetadata();
        if (!Strings.isEmpty(s4))
        {
            s3 = "";
        }
        clickmetadata.dealId = s3;
        clickmetadata.cartId = s4;
        logger.logClick(s, s1, s2, clickmetadata, null);
    }

    public void logClickWithMetadata(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        logger.logClick(s, s1, s2, encodednstfield);
    }

    public void logDealImpression(String s, String s1, DealSummary dealsummary, int i, float f, JsonEncodedNSTField jsonencodednstfield, String s2, 
            boolean flag)
    {
        s = new DealImpression("", s, s1, dealsummary.remoteId, i, f, dealsummary.uuid, jsonencodednstfield);
        if (flag)
        {
            redirectLogger.setKeyString(s2);
            redirectLogger.log(s);
            return;
        } else
        {
            logger.log(s);
            return;
        }
    }

    public void logDealImpressionV1(String s, String s1, DealSummary dealsummary, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1, boolean flag2)
    {
        if (!dealsummary.getBooleanAttr("ns:dealImpression", Boolean.FALSE).booleanValue())
        {
            boolean flag3;
            if (Strings.equals(dealsummary.remoteId, "gtg_mock_promo_deal_summary_remote_id") || Strings.equals(dealsummary.remoteId, "gtg_mock_jumpoff_deal_summary_remote_id"))
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag && !flag3)
            {
                flag = abtestservice.isVariantEnabled("mobileOnly1403USCA", "on");
                boolean flag4 = dealsummary.getDisplayOption("platformExclusive", false);
                if (flag && flag4)
                {
                    logger.logImpression("", "mobile_only_deal", "deal_list", "", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                }
            }
            if (flag2 && !flag3)
            {
                flag = abtestservice.isVariantEnabled("goodsConnectedMarketplaceUSCA1504", "on");
                if (flag && dealsummary.isConnectedMarketPlaceDeal && Strings.notEmpty(dealsummary.connectedMarketPlaceDisplayText))
                {
                    abtestservice = "marketplace_deal";
                } else
                {
                    abtestservice = "";
                }
                if (flag && Strings.notEmpty(abtestservice))
                {
                    logger.logImpression("goods_connected_marketplace", abtestservice, "deal_list", dealsummary.uuid, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                }
            }
            if (flag3)
            {
                flag = Strings.equals(dealsummary.remoteId, "gtg_mock_promo_deal_summary_remote_id");
                if (flag)
                {
                    s = "gtg_on_featured_imp";
                } else
                {
                    s = "finder_card";
                }
                if (flag)
                {
                    s1 = JsonEncodedNSTField.NULL_JSON_NST_FIELD;
                } else
                {
                    s1 = new FinderCardImpressionExtraInfo("gtg_jumpoff");
                }
                logger.logImpression("", s, Channel.FEATURED.toString(), String.valueOf(i), s1);
            } else
            {
                abtestservice = dealsummary.getDoubleAttr("ns:distanceAway", null);
                double d1 = 0.0D;
                double d;
                if (abtestservice == null)
                {
                    abtestservice = locationService.getLocation();
                    d = d1;
                    if (abtestservice != null)
                    {
                        d = d1;
                        if (!dealsummary.derivedRedemptionLocations.isEmpty())
                        {
                            abtestservice = new GeoPoint((int)(abtestservice.getLatitude() * 1000000D), (int)(abtestservice.getLongitude() * 1000000D));
                            d = geoUtils.getClosestDistanceMeters(abtestservice, dealsummary.derivedRedemptionLocations);
                            dealsummary.putAttr("ns:distanceAway", Double.valueOf(d));
                        }
                    }
                } else
                {
                    d = abtestservice.doubleValue();
                }
                logDealImpression(s, s1, dealsummary, i, (float)d, jsonencodednstfield, s2, flag1);
            }
            dealsummary.putAttr("ns:dealImpression", Boolean.TRUE);
        }
    }

    public void logDealSearch(String s, String s1, Object aobj[], String s2, String s3, Relevance relevance, int i, 
            boolean flag)
    {
        relevance = locationService.getLocation();
        float f;
        float f1;
        if (relevance == null)
        {
            f = 0.0F;
        } else
        {
            f = (float)relevance.getLatitude();
        }
        if (relevance == null)
        {
            f1 = 0.0F;
        } else
        {
            f1 = (float)relevance.getLongitude();
        }
        s1 = new DealSearch("", s1, HttpUtil.nvpsToQueryString(aobj), s2, s3, f, f1, "", i, Logger.NULL_NST_FIELD);
        if (flag)
        {
            redirectLogger.log(s, s1);
            return;
        } else
        {
            logger.log(s1);
            return;
        }
    }

    public void logDealSubsetClick(WidgetSummary widgetsummary, String s)
    {
        logger.logClick("", "see_all_click", s, new WidgetExtraInfo(widgetsummary.requestId, widgetsummary.treatment, widgetsummary.campaign));
    }

    public void logEditOrderClick(String s, RedemptionExtraInfo redemptionextrainfo)
    {
        logger.logClick("", "edit_order_selection", s, JsonEncodedNSTField.NULL_JSON_NST_FIELD, redemptionextrainfo);
    }

    public void logGoodsCategoryImpression(String s)
    {
        logger.logImpression("", s, "secondary_goods_carousel", "header", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
    }

    public void logGoogleWalletCardClick(Channel channel, String s)
    {
        logger.logClick("", "google_wallet_dialog", channel.toString(), null, new GoogleWalletCardClickExtraInfo(s, "card"));
    }

    public void logGoogleWalletDialogCancelClick(Channel channel, String s)
    {
        logger.logClick("", "google_wallet_cancel", channel.toString(), null, new GoogleWalletDialogClickExtraInfo(s));
    }

    public void logGoogleWalletDialogContinueClick(Channel channel, String s)
    {
        logger.logClick("", "google_wallet_continue", channel.toString(), null, new GoogleWalletDialogClickExtraInfo(s));
    }

    public void logGoogleWalletDialogImpression(Channel channel, String s)
    {
        logger.logImpression("", "google_wallet_dialog", channel.toString(), "", new GoogleWalletExtraInfo(s, null));
    }

    public void logGoogleWalletPaymentImpression(Channel channel, String s)
    {
        logger.logImpression("", "google_wallet_option", channel.toString(), s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
    }

    public void logGoogleWalletPaymentSelectedClick(Channel channel, String s)
    {
        logger.logClick("", "google_wallet_selection", channel.toString(), null, new GoogleWalletExtraInfo(s, null));
    }

    public void logHotelsSearchClick(String s, String s1, String s2, String s3, String s4)
    {
        s = encodeAsJson(new HotelsSearchClickMetadata(s, s1, s2, s3, s4));
        logger.logClick("", "search_button_click", "market_rate", s);
    }

    public void logImpression(String s, String s1, String s2, String s3, JsonEncodedNSTField jsonencodednstfield)
    {
        logger.logImpression(s, s1, s2, s3, jsonencodednstfield);
    }

    public void logListLoadingPerformance(String s, long l, int i)
    {
        logger.logGeneralEvent("list_loading_performance", String.format("%s,%s", new Object[] {
            s, Long.valueOf(System.currentTimeMillis() - l)
        }), "dealsize", i, Logger.NULL_NST_FIELD);
    }

    public void logMarketRateDealImpression(String s, String s1, int i, String s2)
    {
        logger.logDealImpression("", s, "", s1, i, 0.0F, "", new MarketRateDealImpressionExtraInfo(s2));
    }

    public void logMarketRateDealImpression(String s, String s1, int i, String s2, boolean flag)
    {
        logger.logDealImpression("", s, "", s1, i, 0.0F, "", new MarketRateDealImpressionExtraInfo(s2, flag));
    }

    public void logOnBoardingFinished()
    {
        logger.logGeneralEvent("onboarding_flow", "onboarding_complete", "", 0, Logger.NULL_NST_FIELD);
    }

    public void logPageView(String s, String s1, EncodedNSTField encodednstfield)
    {
        logger.logPageView(s, s1, encodednstfield);
    }

    public void logPageViewed(String s)
    {
        tracking.trackPageView(s);
    }

    public void logPrePurchaseBookingClick(String s, String s1, String s2, Channel channel, String s3)
    {
        ClickExtraInfo clickextrainfo = new ClickExtraInfo();
        clickextrainfo.action = s;
        clickextrainfo.pageId = s3;
        clickextrainfo.dealId = s2;
        logger.logClick("", s1, channel.toString(), null, clickextrainfo);
    }

    public void logTextSearch(String s, String s1, String s2, int i, EncodedNSTField encodednstfield)
    {
        logger.logTextSearch(s, s1, s2, i, encodednstfield);
    }

    public void logThankYouDealSubsetClick(WidgetSummary widgetsummary, String s, String s1)
    {
        ClickMetadata clickmetadata = new ClickMetadata();
        clickmetadata.pageId = s1;
        widgetsummary = new ThankYouScreenExtraInfo(null, null, getWidgetNameBasedOnType(widgetsummary));
        logger.logClick("", "see_all_click", s, clickmetadata, widgetsummary);
    }

    public void logThankYouDealSubsetPageView(final String widgetName)
    {
        logger.logPageView("", "see_all_deals_modal", new EncodedNSTField() {

            final LoggingUtils this$0;
            final String val$widgetName;

            public String toEncodedString()
            {
                return widgetName;
            }

            
            {
                this$0 = LoggingUtils.this;
                widgetName = s;
                super();
            }
        });
    }

    public void logThankYouWidgetDealClick(DealSummary dealsummary, String s, String s1)
    {
        WidgetSummary widgetsummary = dealsummary.parentWidgetSummary;
        s1 = new WidgetClickMetadata(s1, widgetsummary.requestId, widgetsummary.treatment, widgetsummary.campaign, dealsummary.uuid, null, 0);
        dealsummary = new ThankYouScreenExtraInfo(null, null, getWidgetNameBasedOnType(dealsummary.parentWidgetSummary));
        logger.logClick("", "widget_deal_card_click", s, s1, dealsummary);
    }

    public void logThankYouWidgetImpression(String s, DealSummary dealsummary, String s1)
    {
        int i = dealsummary.getIntAttr("ns:DealOffset").intValue();
        ThankYouScreenExtraInfo thankyouscreenextrainfo = new ThankYouScreenExtraInfo(null, null, getWidgetNameBasedOnType(dealsummary.parentWidgetSummary));
        String s2;
        if (Strings.notEmpty(presentationContext))
        {
            s2 = presentationContext;
        } else
        {
            s2 = "";
        }
        logDealImpressionV1(s, s2, dealsummary, i, thankyouscreenextrainfo, s1, null, false, requiresRedirectLogging, false);
    }

    public void logThankYouWidgetSeeAllButton(WidgetSummary widgetsummary, String s, String s1)
    {
        logger.logImpression("", "see_all_button", s, "", new ThankYouScreenExtraInfo(null, s1, getWidgetNameBasedOnType(widgetsummary)));
    }

    public void logWidgetDealClick(DealSummary dealsummary, String s)
    {
        logWidgetDealClick(dealsummary, s, null);
    }

    public void logWidgetDealClick(DealSummary dealsummary, String s, Deal deal)
    {
        if (deal != null)
        {
            deal = deal.uuid;
        } else
        {
            deal = null;
        }
        logWidgetDealClick(dealsummary, s, ((String) (deal)), 0);
    }

    public void logWidgetDealClick(DealSummary dealsummary, String s, String s1, int i)
    {
        WidgetSummary widgetsummary = dealsummary.parentWidgetSummary;
        logger.logClick("", "widget_deal_card_click", s, new WidgetClickMetadata(null, widgetsummary.requestId, widgetsummary.treatment, widgetsummary.campaign, dealsummary.uuid, s1, i));
    }

    public void logWidgetDealImpression(String s, DealSummary dealsummary, String s1)
    {
        int i = dealsummary.getIntAttr("ns:DealOffset").intValue();
        Object obj = dealsummary.parentWidgetSummary;
        WidgetExtraInfo widgetextrainfo = new WidgetExtraInfo(((WidgetSummary) (obj)).requestId, ((WidgetSummary) (obj)).treatment, ((WidgetSummary) (obj)).campaign);
        if (Strings.notEmpty(presentationContext))
        {
            obj = presentationContext;
        } else
        {
            obj = "";
        }
        logDealImpressionV1(s, ((String) (obj)), dealsummary, i, widgetextrainfo, s1, null, false, requiresRedirectLogging, false);
    }

    public void logWidgetDealImpression(String s, DealSummary dealsummary, String s1, int i, int j)
    {
        Object obj = dealsummary.parentWidgetSummary;
        WidgetExtraInfo widgetextrainfo = new WidgetExtraInfo(((WidgetSummary) (obj)).requestId, ((WidgetSummary) (obj)).treatment, ((WidgetSummary) (obj)).campaign, Strings.toString(Integer.valueOf(i)));
        if (Strings.notEmpty(presentationContext))
        {
            obj = presentationContext;
        } else
        {
            obj = "";
        }
        logDealImpressionV1(s, ((String) (obj)), dealsummary, j, widgetextrainfo, s1, null, false, requiresRedirectLogging, false);
    }

    public void logWidgetDealSearch(String s, String s1, String s2, String s3, String s4, String s5, float f, 
            float f1, String s6, int i, boolean flag)
    {
        s1 = new DealSearch(s1, s2, s3, s4, s5, f, f1, s6, i, Logger.NULL_NST_FIELD);
        if (flag)
        {
            redirectLogger.log(s, s1);
            return;
        } else
        {
            logger.log(s1);
            return;
        }
    }

    public void logWidgetImpression(WidgetSummary widgetsummary, String s)
    {
        if (!widgetsummary.getBooleanAttr("ns:widgetImpression", Boolean.FALSE).booleanValue())
        {
            Impression impression = new Impression("", "ns:widgetImpression", "", logger.encodeAsCSV(new String[] {
                Integer.toString(widgetsummary.getIntAttr("ns:widgetOffset", Integer.valueOf(0)).intValue() + 1), Integer.toString(numVisibleDeals(widgetsummary))
            }), new WidgetExtraInfo(widgetsummary.requestId, widgetsummary.treatment, widgetsummary.campaign));
            if (requiresRedirectLogging)
            {
                redirectLogger.log(s, impression);
            } else
            {
                logger.log(impression);
            }
            widgetsummary.putAttr("ns:widgetImpression", Boolean.TRUE);
        }
    }

    public void loggGoogleWalletFutureUseImpression(Channel channel, boolean flag)
    {
        String s;
        if (flag)
        {
            s = "yes";
        } else
        {
            s = "no";
        }
        logger.logImpression("", "google_wallet_future_use_flag", channel.toString(), "", new GoogleWalletFutureUseExtraInfo(s));
    }

    protected int numVisibleDeals(WidgetSummary widgetsummary)
    {
        if (Strings.equals(widgetsummary.viewLayout, "rotating_image_layout"))
        {
            return 0;
        } else
        {
            return widgetsummary.dealSummaries.size();
        }
    }

    public void redirectLogImpression(String s, String s1, String s2, String s3, String s4, JsonEncodedNSTField jsonencodednstfield)
    {
        redirectLogger.log(s, new Impression(s1, s2, s3, s4, jsonencodednstfield));
    }

    public void redirectLogPageView(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        redirectLogger.log(s, new PageView(s1, s2, encodednstfield));
    }

    public void setOriginatingNstChannel(Channel channel)
    {
        originatingNstChannel = channel;
    }

    public void setRequiresRedirectLogging(boolean flag)
    {
        requiresRedirectLogging = flag;
    }
}
