// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;


public final class AnalyticsBuilderInterfaces
{
    public static interface ActivityNameView
    {

        public abstract BaseAnalyticsBuilder withActivityName(String s);
    }

    public static interface AppAsinView
    {

        public abstract AppVersionView withAppAsin(String s);
    }

    public static interface AppVersionView
    {

        public abstract ContentIdView withAppVersion(String s);
    }

    public static interface BaseAnalyticsBuilder
        extends PackageNameView
    {
    }

    public static interface ContentIdView
    {

        public abstract MarketplaceIdView withContentId(String s);
    }

    public static interface FinallyRecord
    {

        public abstract void record();
    }

    public static interface IAPTypeBuilder
        extends InAppAsinView
    {
    }

    public static interface InAppAsinView
    {

        public abstract InAppVersionView withInAppAsin(String s);
    }

    public static interface InAppPurchaseAmount
    {

        public abstract InAppPurchaseCurrency withInAppPurchaseAmount(double d);
    }

    public static interface InAppPurchaseCurrency
    {

        public abstract IsCoinsUsed withInAppPurchaseCurrency(String s);
    }

    public static interface InAppSkuView
    {

        public abstract InAppPurchaseAmount withInAppSku(String s);
    }

    public static interface InAppVersionView
    {

        public abstract InAppSkuView withInAppVersion(String s);
    }

    public static interface IsCoinsUsed
    {

        public abstract IsOrderSuccessful withIsCoinsUsed(boolean flag);
    }

    public static interface IsOrderSuccessful
    {

        public abstract BaseAnalyticsBuilder withIsOrderSuccessful(boolean flag);
    }

    public static interface MASVersionView
    {

        public abstract AppAsinView withMASVersion(String s);
    }

    public static interface MarketplaceIdView
    {

        public abstract TimestampView withMarketplaceId(String s);
    }

    public static interface PackageNameView
    {

        public abstract MASVersionView withPackageName(String s);
    }

    public static interface SessionTypeBuilder
        extends ActivityNameView
    {
    }

    public static interface TimestampView
    {

        public abstract FinallyRecord withTimestamp(long l);
    }


    private AnalyticsBuilderInterfaces()
    {
    }
}
