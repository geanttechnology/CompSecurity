// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Html;
import com.groupon.db.models.Badge;
import com.groupon.db.models.DealSummary;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.DealUtils;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.ImageUrl;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LocationsUtil;
import com.groupon.util.UrgencyPricingUtils;
import com.groupon.view.dealcards.DealCardView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class DealCardViewPresenter
{

    private final CurrencyFormatter currencyFormatter;
    private final String dealEndedText;
    private final int dealPriceColor;
    private final GeoUtils geoUtils;
    private final int greyDarkColor;
    private final IncentivesUtil incentivesUtil;
    private boolean isGoodsConnectedMarketPlace1504;
    private final boolean isJapan;
    private boolean isMobileOnly1403USCA;
    private boolean isSmallDealCard;
    private final int orangeAlertColor;
    private List places;
    private final Resources resources;
    private final String soldOutText;
    private final boolean useMetricSystem;

    public DealCardViewPresenter(Context context, CurrentCountryManager currentcountrymanager, AbTestService abtestservice, IncentivesUtil incentivesutil, CurrencyFormatter currencyformatter, GeoUtils geoutils)
    {
        boolean flag1 = true;
        super();
        incentivesUtil = incentivesutil;
        currencyFormatter = currencyformatter;
        geoUtils = geoutils;
        setupABTests(abtestservice);
        boolean flag;
        if (currentcountrymanager.getCurrentCountry() != null && currentcountrymanager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isJapan = flag;
        if (currentcountrymanager.getCurrentCountry() != null && currentcountrymanager.getCurrentCountry().usesMetricSystem())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        useMetricSystem = flag;
        soldOutText = context.getString(0x7f0803b3);
        dealEndedText = context.getString(0x7f080125);
        resources = context.getResources();
        orangeAlertColor = resources.getColor(0x7f0e0144);
        dealPriceColor = resources.getColor(0x7f0e019a);
        greyDarkColor = resources.getColor(0x7f0e00ee);
    }

    private void setBadges(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
label0:
        {
            dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.BADGES, flag);
            if (!flag)
            {
                break label0;
            }
            dealsummary = dealsummary.badges.iterator();
            Badge badge;
            do
            {
                if (!dealsummary.hasNext())
                {
                    break label0;
                }
                badge = (Badge)dealsummary.next();
            } while (!DealUtils.isBadgeValid(badge));
            dealcardview.setBadges(badge.text, Color.parseColor(badge.secondaryColor), Color.parseColor(badge.primaryColor));
        }
    }

    private void setBoughts(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        if (flag)
        {
            int i = dealsummary.soldQuantity;
            dealsummary = dealsummary.soldQuantityMessage;
            if (!isJapan)
            {
                Resources resources1 = resources;
                if (i < 100 || !Strings.notEmpty(dealsummary))
                {
                    dealsummary = Integer.valueOf(i);
                }
                dealsummary = resources1.getQuantityString(0x7f0c0001, i, new Object[] {
                    dealsummary
                });
            }
            dealcardview.setBoughts(dealsummary);
        }
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.BOUGHTS, flag);
    }

    private void setGBucks(DealCardView dealcardview)
    {
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.G_BUCKS, false);
    }

    private void setGoodsConnectedMarketPlace(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.GOODS_CONNECTED_MARKETPLACE, flag);
        if (flag)
        {
            dealsummary = dealsummary.connectedMarketPlaceDisplayText;
            dealcardview.setPriceColor(greyDarkColor);
            dealcardview.setGoodsConnectedMarketPlaceText(dealsummary);
        }
    }

    private void setImage(DealCardView dealcardview, DealSummary dealsummary)
    {
        if (Strings.notEmpty(dealsummary.derivedImageUrl))
        {
            dealsummary = new ImageUrl(dealsummary.derivedImageUrl, true);
        } else
        {
            dealsummary = new ImageUrl(dealsummary.largeImageUrl, false);
        }
        dealcardview.setImage(dealsummary);
    }

    private void setIncentive(DealCardView dealcardview, DealSummary dealsummary, boolean flag, boolean flag1)
    {
        dealcardview.setIncentiveText(incentivesUtil.getIncentiveShortTitle(dealsummary, flag));
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.INCENTIVE, flag1);
    }

    private void setLocation(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        boolean flag1 = true;
        String s = LocationsUtil.getLocation(useMetricSystem, isJapan, dealsummary, places, resources, geoUtils, true);
        dealsummary = s;
        if (s.contains("null"))
        {
            dealsummary = "";
        }
        dealcardview.setLocation(dealsummary);
        dealsummary = com.groupon.view.dealcards.DealCardView.DisplayOption.LOCATION;
        if (!flag)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        dealcardview.displayOption(dealsummary, flag);
    }

    private void setMobileOnly(DealCardView dealcardview, boolean flag)
    {
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.MOBILE_ONLY, flag);
    }

    private void setPrice(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        String s = currencyFormatter.formatWithQuantity(dealsummary.derivedPriceAmount, dealsummary.derivedPriceCurrencyCode, dealsummary.derivedMinimumPurchaseQuantity, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        int i;
        if (dealsummary.isTravelBookableDeal && !isJapan)
        {
            dealcardview.setPrice(Html.fromHtml(resources.getString(0x7f080121, new Object[] {
                s
            })));
        } else
        {
            dealcardview.setPrice(s);
        }
        if (flag)
        {
            i = orangeAlertColor;
        } else
        {
            i = dealPriceColor;
        }
        dealcardview.setPriceColor(i);
    }

    private void setReferencePrice(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        if (isJapan)
        {
            dealsummary = resources.getString(0x7f080134, new Object[] {
                Integer.valueOf(dealsummary.derivedDiscountPercent)
            });
        } else
        {
            dealsummary = currencyFormatter.formatWithQuantity(dealsummary.derivedValueAmount, dealsummary.derivedValueCurrencyCode, dealsummary.derivedMinimumPurchaseQuantity, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        }
        dealcardview.setReferencePrice(dealsummary);
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.REFERENCE_PRICE, flag);
        if (!isJapan)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dealcardview.strikeReferencePrice(flag);
    }

    private void setSoldOut(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        if (dealsummary.isSoldOut)
        {
            dealsummary = soldOutText;
        } else
        {
            dealsummary = dealEndedText;
        }
        dealcardview.setSoldOutText(dealsummary);
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.SOLD_OUT, flag);
    }

    private void setTitle(DealCardView dealcardview, DealSummary dealsummary)
    {
        if (Strings.notEmpty(dealsummary.announcementTitle))
        {
            dealsummary = dealsummary.announcementTitle;
        } else
        {
            dealsummary = dealsummary.title;
        }
        dealcardview.setTitle(dealsummary);
    }

    private void setUrgentInfo(DealCardView dealcardview, DealSummary dealsummary, boolean flag)
    {
        dealcardview.setUrgentInfo(dealsummary.derivedPricingMetadataOfferLabelDescriptive);
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.URGENT_INFO, flag);
    }

    private void setupABTests(AbTestService abtestservice)
    {
        isMobileOnly1403USCA = abtestservice.isVariantEnabledAndUSCA("mobileOnly1403USCA", "on");
        isGoodsConnectedMarketPlace1504 = abtestservice.isVariantEnabledAndUSCA("goodsConnectedMarketplaceUSCA1504", "on");
    }

    private boolean shouldDisplayBadges(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        boolean flag4;
        if (!dealsummary.badges.isEmpty() && dealsummary.getBooleanAttr("is_show_badge_ab_test_on").booleanValue() && !flag)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        flag = validateBadgeAttribute(dealsummary);
        if (!isSmallDealCard) goto _L2; else goto _L1
_L1:
        if (!flag4 || !flag || flag1 || flag2 || flag3) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (!flag4 || !flag)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private boolean shouldDisplayBought(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        return dealsummary.getDisplayOption("quantity", true) && dealsummary.soldQuantity != 0 && (flag || !flag1 && !flag2 && !flag3 && !isSmallDealCard);
    }

    private boolean shouldDisplayDiscount(DealSummary dealsummary)
    {
        return dealsummary.getDisplayOption("discount", true) && dealsummary.derivedDiscountPercent > 0;
    }

    private boolean shouldDisplayGoodsConnectedMarketplace(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2)
    {
        return isGoodsConnectedMarketPlace1504 && dealsummary.isConnectedMarketPlaceDeal && Strings.notEmpty(dealsummary.connectedMarketPlaceDisplayText) && !flag && !flag1 && !flag2 && !isSmallDealCard;
    }

    private boolean shouldDisplayIncentive(DealSummary dealsummary, boolean flag, boolean flag1, boolean flag2)
    {
        return !flag1 && !flag2 && Strings.notEmpty(incentivesUtil.getIncentiveShortTitle(dealsummary, flag));
    }

    private boolean shouldDisplayMobileOnly(DealSummary dealsummary)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (isMobileOnly1403USCA)
        {
            flag = flag1;
            if (dealsummary.getDisplayOption("platformExclusive", false))
            {
                flag = true;
            }
        }
        return flag;
    }

    private boolean shouldDisplayUrgencyPricing(DealSummary dealsummary, boolean flag, boolean flag1)
    {
        return !flag1 && flag && UrgencyPricingUtils.getUrgencyPricingAvailability(dealsummary) != null;
    }

    private boolean validateBadgeAttribute(DealSummary dealsummary)
    {
        dealsummary = dealsummary.badges.iterator();
_L2:
        Badge badge;
        if (!dealsummary.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        badge = (Badge)dealsummary.next();
        if (!DealUtils.isBadgeValid(badge))
        {
            continue; /* Loop/switch isn't completed */
        }
        Color.parseColor(badge.primaryColor);
        Color.parseColor(badge.secondaryColor);
        return true;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
        return false;
    }

    public void present(DealCardView dealcardview, DealSummary dealsummary)
    {
        boolean flag = DealUtils.isGoodsShoppingDeal(dealsummary);
        boolean flag1 = shouldDisplayMobileOnly(dealsummary);
        boolean flag2 = shouldDisplayDiscount(dealsummary);
        boolean flag3 = shouldDisplayUrgencyPricing(dealsummary, flag2, flag1);
        boolean flag4 = DealUtils.isSoldOutOrClosed(dealsummary);
        boolean flag5 = shouldDisplayIncentive(dealsummary, flag4, flag1, flag3);
        boolean flag6 = shouldDisplayBadges(dealsummary, flag4, flag1, flag3, flag5);
        boolean flag7 = shouldDisplayBought(dealsummary, flag, flag3, flag5, flag1);
        boolean flag8 = shouldDisplayGoodsConnectedMarketplace(dealsummary, flag3, flag5, flag1);
        setTitle(dealcardview, dealsummary);
        setImage(dealcardview, dealsummary);
        setSoldOut(dealcardview, dealsummary, flag4);
        setBoughts(dealcardview, dealsummary, flag7);
        setPrice(dealcardview, dealsummary, flag3);
        setReferencePrice(dealcardview, dealsummary, flag2);
        setLocation(dealcardview, dealsummary, flag);
        setIncentive(dealcardview, dealsummary, flag4, flag5);
        setUrgentInfo(dealcardview, dealsummary, flag3);
        setMobileOnly(dealcardview, flag1);
        setGBucks(dealcardview);
        setGoodsConnectedMarketPlace(dealcardview, dealsummary, flag8);
        setBadges(dealcardview, dealsummary, flag6);
    }

    public void setPlace(GeoPoint geopoint)
    {
        ArrayList arraylist = new ArrayList();
        if (geopoint != null)
        {
            arraylist.add(new Place("", geopoint.getLatitudeDegrees(), geopoint.getLongitudeDegrees()));
        }
        setPlaces(arraylist);
    }

    public void setPlaces(List list)
    {
        places = list;
    }

    public void setSmallDealCardModeEnabled(boolean flag)
    {
        isSmallDealCard = flag;
    }
}
