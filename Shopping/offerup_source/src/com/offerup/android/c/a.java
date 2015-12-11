// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.c;


public class a
{

    public static String addCardButtonTextPaymentsPromoScreen = "Setup now to save time";
    public static String disclaimerPaymentsPromoScreen = "Card only charged when you pickup item.";
    public static String exitButtonTextPaymentsPromoScreen = "Not Now";
    public static boolean itemDetailUseNewScreen = false;
    public static String itemDetailsLayout = "itemDetailDefaultComponentOrder";
    public static boolean itemPostMultiplePhotosEnabled = false;
    public static String line1BulletPaymentsPromoScreen = "Save time and skip the cash.";
    public static String line2BulletPaymentsPromoScreen = "Finalize payment when you meet.";
    public static String line3BulletPaymentsPromoScreen = "";
    public static String line4BulletPaymentsPromoScreen = "";
    public static String offerSentText = "Offer Sent!";
    public static boolean ratingsUseInAppRatings = false;
    public static boolean showCheckbox = true;
    public static boolean showCreditCardsPaymentsPromoScreen = true;
    public static String titlePaymentsPromoScreen = "New! You can now pay with your credit card.";
    public static boolean useItemShareSheet = false;
    public static boolean useNewAppInvites = false;

    public a()
    {
    }

    public static int a()
    {
        return !itemPostMultiplePhotosEnabled ? 1 : 5;
    }

}
