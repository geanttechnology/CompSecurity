// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import com.amazon.analytics.util.Preconditions;
import com.amazon.device.analytics.events.Event;

// Referenced classes of package com.amazon.analytics.eventbuilder:
//            AnalyticsEventBuilder

public abstract class IAPEventTypeBuilder extends AnalyticsEventBuilder
    implements AnalyticsBuilderInterfaces.IAPTypeBuilder, AnalyticsBuilderInterfaces.InAppAsinView, AnalyticsBuilderInterfaces.InAppPurchaseAmount, AnalyticsBuilderInterfaces.InAppPurchaseCurrency, AnalyticsBuilderInterfaces.InAppSkuView, AnalyticsBuilderInterfaces.InAppVersionView, AnalyticsBuilderInterfaces.IsCoinsUsed, AnalyticsBuilderInterfaces.IsOrderSuccessful
{
    public static class IAPBuilder extends IAPEventTypeBuilder
    {

        String getType()
        {
            return "iap";
        }

        public IAPBuilder()
        {
        }
    }


    String inAppAsin;
    double inAppPurchaseAmount;
    String inAppPurchaseCurrency;
    String inAppSku;
    String inAppVersion;
    boolean isCoinsUsed;
    boolean isOrderSuccessful;

    private IAPEventTypeBuilder()
    {
    }


    void setupEventAttributesAndMetrics(Event event)
    {
        super.setupEventAttributesAndMetrics(event);
        event.addAttribute("ia", inAppAsin);
        event.addAttribute("iv", inAppVersion);
        event.addAttribute("as", inAppSku);
        event.addAttribute("ap", (new StringBuilder()).append(String.valueOf(inAppPurchaseAmount)).append(inAppPurchaseCurrency).toString());
        event.addMetric("apa", Double.valueOf(inAppPurchaseAmount));
        event.addAttribute("apc", inAppPurchaseCurrency);
        event.addAttribute("coins", String.valueOf(isCoinsUsed));
        event.addAttribute("ou", String.valueOf(isOrderSuccessful));
    }

    public AnalyticsBuilderInterfaces.InAppVersionView withInAppAsin(String s)
    {
        inAppAsin = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.InAppPurchaseCurrency withInAppPurchaseAmount(double d)
    {
        boolean flag;
        if (d >= 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        inAppPurchaseAmount = d;
        return this;
    }

    public AnalyticsBuilderInterfaces.IsCoinsUsed withInAppPurchaseCurrency(String s)
    {
        inAppPurchaseCurrency = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.InAppPurchaseAmount withInAppSku(String s)
    {
        inAppSku = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.InAppSkuView withInAppVersion(String s)
    {
        inAppVersion = (String)Preconditions.checkNotNull(s);
        return this;
    }

    public AnalyticsBuilderInterfaces.IsOrderSuccessful withIsCoinsUsed(boolean flag)
    {
        isCoinsUsed = flag;
        return this;
    }

    public AnalyticsBuilderInterfaces.BaseAnalyticsBuilder withIsOrderSuccessful(boolean flag)
    {
        isOrderSuccessful = flag;
        return this;
    }
}
