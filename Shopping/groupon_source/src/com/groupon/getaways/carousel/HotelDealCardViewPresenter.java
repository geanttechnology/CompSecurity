// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import com.groupon.db.models.MarketRateResult;
import com.groupon.service.LocationService;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.ImageUrl;
import com.groupon.view.dealcards.DealCardView;
import roboguice.util.Strings;

public class HotelDealCardViewPresenter
{

    private static final double MAXIMUM_DISTANCE_MILES = 50D;
    private final CurrencyFormatter currencyFormatter;
    private GeoUtils geoUtils;
    private boolean isRaOOfferEnabled;
    private LocationService locationService;

    public HotelDealCardViewPresenter(CurrencyFormatter currencyformatter)
    {
        currencyFormatter = currencyformatter;
    }

    private void appendDistanceToAddressIfPossible(MarketRateResult marketrateresult, StringBuilder stringbuilder)
    {
        if (locationService != null && geoUtils != null)
        {
            Object obj;
            if (locationService.isAGpsProviderEnabled())
            {
                obj = locationService.getLocation();
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                obj = new GeoPoint(((android.location.Location) (obj)));
                marketrateresult = new GeoPoint((int)(marketrateresult.derivedAddressLat * 1000000D), (int)(marketrateresult.derivedAddressLng * 1000000D));
                if (geoUtils.milesBetween(((GeoPoint) (obj)), marketrateresult) <= 50D)
                {
                    stringbuilder.append(" \u2022 ");
                    stringbuilder.append(geoUtils.distanceBetweenAsString(((GeoPoint) (obj)), marketrateresult));
                    return;
                }
            }
        }
    }

    private void setGBucksIfNecessary(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        boolean flag = true;
        double d = marketrateresult.bucksPercentage;
        boolean flag1 = Strings.equalsIgnoreCase(marketrateresult.productType, "lastMinute");
        int i;
        if (isRaOOfferEnabled && marketrateresult.hasRaO)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (d == 0.0D || flag1 || i != 0)
        {
            flag = false;
        }
        if (flag)
        {
            i = (int)Math.round((d / 100D) * (double)marketrateresult.derivedAvgMinPriceNet);
            dealcardview.setGBucks(currencyFormatter.format(i, currencyFormatter.getCurrencySymbol(marketrateresult.derivedAvgMinPriceCurrencyCode), com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always));
        }
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.G_BUCKS, flag);
    }

    private void setImage(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        dealcardview.setImage(new ImageUrl(marketrateresult.derivedImageUrl));
    }

    private void setLocation(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        String s;
        String s1;
        StringBuilder stringbuilder;
        if (Strings.notEmpty(marketrateresult.derivedAddressState))
        {
            s = marketrateresult.derivedAddressState;
        } else
        {
            s = marketrateresult.derivedAddressCountry;
        }
        s1 = marketrateresult.derivedAddressCity;
        stringbuilder = new StringBuilder();
        if (Strings.notEmpty(s1))
        {
            stringbuilder.append(s1);
            if (Strings.notEmpty(s))
            {
                stringbuilder.append(", ");
                stringbuilder.append(s);
            }
        } else
        {
            stringbuilder.append(s);
        }
        appendDistanceToAddressIfPossible(marketrateresult, stringbuilder);
        dealcardview.setLocation(stringbuilder.toString());
    }

    private void setMobileOnlyLabelIfNecessary(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        boolean flag = Strings.equalsIgnoreCase(marketrateresult.productType, "lastMinute");
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.MOBILE_ONLY, flag);
    }

    private void setPrice(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        dealcardview.setPrice(currencyFormatter.format(marketrateresult.derivedAvgMinPriceNet, currencyFormatter.getCurrencySymbol(marketrateresult.derivedAvgMinPriceCurrencyCode), com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always));
        boolean flag;
        if (isRaOOfferEnabled && marketrateresult.hasRaO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dealcardview.strikePrice(flag);
    }

    private void setRaOOfferFlagIfNecessary(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        boolean flag;
        if (isRaOOfferEnabled && marketrateresult.hasRaO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.RAO_OFFER, flag);
        dealcardview.displayOption(com.groupon.view.dealcards.DealCardView.DisplayOption.RAO_DISCOUNT, flag);
    }

    private void setRatingIfExists(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        dealcardview.setRating(marketrateresult.hotelRating);
        com.groupon.view.dealcards.DealCardView.DisplayOption displayoption = com.groupon.view.dealcards.DealCardView.DisplayOption.RATING;
        boolean flag;
        if (marketrateresult.hotelRating != 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dealcardview.displayOption(displayoption, flag);
    }

    private void setReferencePriceIfExists(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        boolean flag2 = false;
        dealcardview.setReferencePrice(currencyFormatter.format(marketrateresult.derivedDisplayValueAmount, currencyFormatter.getCurrencySymbol(marketrateresult.derivedDisplayValueCurrencyCode), com.groupon.util.CurrencyFormatter.DecimalStripBehavior.Always));
        com.groupon.view.dealcards.DealCardView.DisplayOption displayoption;
        boolean flag;
        boolean flag1;
        if (isRaOOfferEnabled && marketrateresult.hasRaO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        displayoption = com.groupon.view.dealcards.DealCardView.DisplayOption.REFERENCE_PRICE;
        flag1 = flag2;
        if (marketrateresult.derivedDisplayValueAmount != 0)
        {
            flag1 = flag2;
            if (!flag)
            {
                flag1 = true;
            }
        }
        dealcardview.displayOption(displayoption, flag1);
        dealcardview.strikeReferencePrice(true);
    }

    private void setTitle(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        String s1 = marketrateresult.announcementTitle;
        String s = s1;
        if (Strings.isEmpty(s1))
        {
            s = marketrateresult.title;
        }
        dealcardview.setTitle(s);
    }

    public void present(DealCardView dealcardview, MarketRateResult marketrateresult)
    {
        setTitle(dealcardview, marketrateresult);
        setImage(dealcardview, marketrateresult);
        setLocation(dealcardview, marketrateresult);
        setPrice(dealcardview, marketrateresult);
        setReferencePriceIfExists(dealcardview, marketrateresult);
        setRatingIfExists(dealcardview, marketrateresult);
        setGBucksIfNecessary(dealcardview, marketrateresult);
        setMobileOnlyLabelIfNecessary(dealcardview, marketrateresult);
        setRaOOfferFlagIfNecessary(dealcardview, marketrateresult);
    }

    public HotelDealCardViewPresenter setIsRaoOffer(boolean flag)
    {
        isRaOOfferEnabled = flag;
        return this;
    }

    public HotelDealCardViewPresenter setLocationProviders(LocationService locationservice, GeoUtils geoutils)
    {
        locationService = locationservice;
        geoUtils = geoutils;
        return this;
    }
}
