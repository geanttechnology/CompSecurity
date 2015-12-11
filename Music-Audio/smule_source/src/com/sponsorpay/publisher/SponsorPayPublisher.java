// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.publisher.currency.SPCurrencyServerListener;
import com.sponsorpay.publisher.currency.SPVirtualCurrencyConnector;
import com.sponsorpay.publisher.interstitial.SPInterstitialClient;
import com.sponsorpay.publisher.interstitial.SPInterstitialRequestListener;
import com.sponsorpay.publisher.mbe.SPBrandEngageClient;
import com.sponsorpay.publisher.mbe.SPBrandEngageRequest;
import com.sponsorpay.publisher.mbe.SPBrandEngageRequestListener;
import com.sponsorpay.publisher.ofw.SPOfferWallActivity;
import com.sponsorpay.utils.HostInfo;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class SponsorPayPublisher
{

    public static final String PREFERENCES_FILENAME = "SponsorPayPublisherState";
    private static EnumMap sUIStrings;

    public SponsorPayPublisher()
    {
    }

    public static void displayNotificationForSuccessfullCoinRequest(boolean flag)
    {
        SPVirtualCurrencyConnector.shouldShowToastNotification(flag);
    }

    public static boolean getIntentForInterstitialActivity(Activity activity, SPInterstitialRequestListener spinterstitialrequestlistener)
    {
        return getIntentForInterstitialActivity(SponsorPay.getCurrentCredentials().getCredentialsToken(), activity, spinterstitialrequestlistener);
    }

    public static boolean getIntentForInterstitialActivity(String s, Activity activity, SPInterstitialRequestListener spinterstitialrequestlistener)
    {
        return getIntentForInterstitialActivity(s, activity, spinterstitialrequestlistener, null);
    }

    public static boolean getIntentForInterstitialActivity(String s, Activity activity, SPInterstitialRequestListener spinterstitialrequestlistener, Map map)
    {
        SPInterstitialClient spinterstitialclient = SPInterstitialClient.INSTANCE;
        boolean flag = spinterstitialclient.canRequestAds();
        if (flag)
        {
            s = SponsorPay.getCredentials(s);
            spinterstitialclient.setRequestListener(spinterstitialrequestlistener);
            spinterstitialclient.setCustomParameters(map);
            spinterstitialclient.requestAds(s, activity);
        }
        return flag;
    }

    public static boolean getIntentForMBEActivity(Activity activity, SPBrandEngageRequestListener spbrandengagerequestlistener)
    {
        return getIntentForMBEActivity(SponsorPay.getCurrentCredentials().getCredentialsToken(), activity, spbrandengagerequestlistener);
    }

    public static boolean getIntentForMBEActivity(Activity activity, SPBrandEngageRequestListener spbrandengagerequestlistener, SPCurrencyServerListener spcurrencyserverlistener)
    {
        return getIntentForMBEActivity(SponsorPay.getCurrentCredentials().getCredentialsToken(), activity, spbrandengagerequestlistener, null, null, spcurrencyserverlistener);
    }

    public static boolean getIntentForMBEActivity(String s, Activity activity, SPBrandEngageRequestListener spbrandengagerequestlistener)
    {
        return getIntentForMBEActivity(s, activity, spbrandengagerequestlistener, null, null, null);
    }

    public static boolean getIntentForMBEActivity(String s, Activity activity, SPBrandEngageRequestListener spbrandengagerequestlistener, String s1, Map map, SPCurrencyServerListener spcurrencyserverlistener)
    {
        SPBrandEngageClient spbrandengageclient = SPBrandEngageClient.INSTANCE;
        boolean flag = spbrandengageclient.canRequestOffers();
        if (flag)
        {
            s = SponsorPay.getCredentials(s);
            spbrandengageclient.setCurrencyName(s1);
            spbrandengageclient.setCustomParameters(map);
            spbrandengageclient.setCurrencyListener(spcurrencyserverlistener);
            (new SPBrandEngageRequest(s, activity, spbrandengageclient, spbrandengagerequestlistener)).askForOffers();
        }
        return flag;
    }

    public static Intent getIntentForOfferWallActivity(Context context, Boolean boolean1)
    {
        return getIntentForOfferWallActivity(SponsorPay.getCurrentCredentials().getCredentialsToken(), context, boolean1, null, null);
    }

    public static Intent getIntentForOfferWallActivity(Context context, Boolean boolean1, String s, HashMap hashmap)
    {
        return getIntentForOfferWallActivity(SponsorPay.getCurrentCredentials().getCredentialsToken(), context, boolean1, s, hashmap);
    }

    public static Intent getIntentForOfferWallActivity(String s, Context context, Boolean boolean1, String s1, HashMap hashmap)
    {
        context = new Intent(context, com/sponsorpay/publisher/ofw/SPOfferWallActivity);
        if (HostInfo.isDeviceSupported())
        {
            context.putExtra("EXTRA_CREDENTIALS_TOKEN_KEY", SponsorPay.getCredentials(s).getCredentialsToken());
            context.putExtra("EXTRA_SHOULD_REMAIN_OPEN_KEY", boolean1);
            context.putExtra("EXTRA_CURRENCY_NAME_KEY", s1);
            context.putExtra("EXTRA_KEY_VALUES_MAP", hashmap);
        }
        return context;
    }

    public static String getUIString(UIStringIdentifier uistringidentifier)
    {
        if (sUIStrings == null)
        {
            initUIStrings();
        }
        return (String)sUIStrings.get(uistringidentifier);
    }

    private static void initUIStrings()
    {
        sUIStrings = new EnumMap(com/sponsorpay/publisher/SponsorPayPublisher$UIStringIdentifier);
        sUIStrings.put(UIStringIdentifier.ERROR_DIALOG_TITLE, "Error");
        sUIStrings.put(UIStringIdentifier.DISMISS_ERROR_DIALOG, "Dismiss");
        sUIStrings.put(UIStringIdentifier.GENERIC_ERROR, "An error happened when performing this operation");
        sUIStrings.put(UIStringIdentifier.ERROR_LOADING_OFFERWALL, "An error happened when loading the offer wall");
        sUIStrings.put(UIStringIdentifier.ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION, "An error happened when loading the offer wall (no internet connection)");
        sUIStrings.put(UIStringIdentifier.LOADING_INTERSTITIAL, "Loading...");
        sUIStrings.put(UIStringIdentifier.LOADING_OFFERWALL, "Loading...");
        sUIStrings.put(UIStringIdentifier.ERROR_PLAY_STORE_UNAVAILABLE, "You don't have the Google Play Store application on your device to complete App Install offers.");
        sUIStrings.put(UIStringIdentifier.MBE_REWARD_NOTIFICATION, "Thanks! Your reward will be paid out shortly");
        sUIStrings.put(UIStringIdentifier.VCS_COINS_NOTIFICATION, "Congratulations! You've earned %.0f %s!");
        sUIStrings.put(UIStringIdentifier.VCS_DEFAULT_CURRENCY, "coins");
        sUIStrings.put(UIStringIdentifier.MBE_ERROR_DIALOG_TITLE, "Error");
        sUIStrings.put(UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_DEFAULT, "We're sorry, something went wrong. Please try again.");
        sUIStrings.put(UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_OFFLINE, "Your Internet connection has been lost. Please try again later.");
        sUIStrings.put(UIStringIdentifier.MBE_ERROR_DIALOG_BUTTON_TITLE_DISMISS, "Dismiss");
        sUIStrings.put(UIStringIdentifier.MBE_FORFEIT_DIALOG_TITLE, "");
    }

    public static void requestNewCoins(Context context, SPCurrencyServerListener spcurrencyserverlistener)
    {
        requestNewCoins(context, spcurrencyserverlistener, null);
    }

    public static void requestNewCoins(Context context, SPCurrencyServerListener spcurrencyserverlistener, String s)
    {
        requestNewCoins(SponsorPay.getCurrentCredentials().getCredentialsToken(), context, spcurrencyserverlistener, null, null, s);
    }

    public static void requestNewCoins(String s, Context context, SPCurrencyServerListener spcurrencyserverlistener, String s1, Map map, String s2)
    {
        s = new SPVirtualCurrencyConnector(context, s, spcurrencyserverlistener);
        s.setCustomParameters(map);
        s.setCurrency(s2);
        s.fetchDeltaOfCoinsForCurrentUserSinceTransactionId(s1);
    }

    public static void setCustomUIString(UIStringIdentifier uistringidentifier, int i, Context context)
    {
        setCustomUIString(uistringidentifier, context.getString(i));
    }

    public static void setCustomUIString(UIStringIdentifier uistringidentifier, String s)
    {
        if (sUIStrings == null)
        {
            initUIStrings();
        }
        sUIStrings.put(uistringidentifier, s);
    }

    public static void setCustomUIStrings(EnumMap enummap)
    {
        UIStringIdentifier auistringidentifier[] = UIStringIdentifier.values();
        int j = auistringidentifier.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            UIStringIdentifier uistringidentifier = auistringidentifier[i];
            if (enummap.containsKey(uistringidentifier))
            {
                setCustomUIString(uistringidentifier, (String)enummap.get(uistringidentifier));
            }
            i++;
        } while (true);
    }

    public static void setCustomUIStrings(EnumMap enummap, Context context)
    {
        UIStringIdentifier auistringidentifier[] = UIStringIdentifier.values();
        int j = auistringidentifier.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            UIStringIdentifier uistringidentifier = auistringidentifier[i];
            if (enummap.containsKey(uistringidentifier))
            {
                setCustomUIString(uistringidentifier, ((Integer)enummap.get(uistringidentifier)).intValue(), context);
            }
            i++;
        } while (true);
    }

    private class UIStringIdentifier extends Enum
    {

        public static final UIStringIdentifier DISMISS_ERROR_DIALOG;
        private static final UIStringIdentifier ENUM$VALUES[];
        public static final UIStringIdentifier ERROR_DIALOG_TITLE;
        public static final UIStringIdentifier ERROR_LOADING_OFFERWALL;
        public static final UIStringIdentifier ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION;
        public static final UIStringIdentifier ERROR_PLAY_STORE_UNAVAILABLE;
        public static final UIStringIdentifier GENERIC_ERROR;
        public static final UIStringIdentifier LOADING_INTERSTITIAL;
        public static final UIStringIdentifier LOADING_OFFERWALL;
        public static final UIStringIdentifier MBE_ERROR_DIALOG_BUTTON_TITLE_DISMISS;
        public static final UIStringIdentifier MBE_ERROR_DIALOG_MESSAGE_DEFAULT;
        public static final UIStringIdentifier MBE_ERROR_DIALOG_MESSAGE_OFFLINE;
        public static final UIStringIdentifier MBE_ERROR_DIALOG_TITLE;
        public static final UIStringIdentifier MBE_FORFEIT_DIALOG_TITLE;
        public static final UIStringIdentifier MBE_REWARD_NOTIFICATION;
        public static final UIStringIdentifier VCS_COINS_NOTIFICATION;
        public static final UIStringIdentifier VCS_DEFAULT_CURRENCY;

        public static UIStringIdentifier valueOf(String s)
        {
            return (UIStringIdentifier)Enum.valueOf(com/sponsorpay/publisher/SponsorPayPublisher$UIStringIdentifier, s);
        }

        public static UIStringIdentifier[] values()
        {
            UIStringIdentifier auistringidentifier[] = ENUM$VALUES;
            int i = auistringidentifier.length;
            UIStringIdentifier auistringidentifier1[] = new UIStringIdentifier[i];
            System.arraycopy(auistringidentifier, 0, auistringidentifier1, 0, i);
            return auistringidentifier1;
        }

        static 
        {
            ERROR_DIALOG_TITLE = new UIStringIdentifier("ERROR_DIALOG_TITLE", 0);
            DISMISS_ERROR_DIALOG = new UIStringIdentifier("DISMISS_ERROR_DIALOG", 1);
            GENERIC_ERROR = new UIStringIdentifier("GENERIC_ERROR", 2);
            ERROR_LOADING_OFFERWALL = new UIStringIdentifier("ERROR_LOADING_OFFERWALL", 3);
            ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION = new UIStringIdentifier("ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION", 4);
            LOADING_INTERSTITIAL = new UIStringIdentifier("LOADING_INTERSTITIAL", 5);
            LOADING_OFFERWALL = new UIStringIdentifier("LOADING_OFFERWALL", 6);
            ERROR_PLAY_STORE_UNAVAILABLE = new UIStringIdentifier("ERROR_PLAY_STORE_UNAVAILABLE", 7);
            MBE_REWARD_NOTIFICATION = new UIStringIdentifier("MBE_REWARD_NOTIFICATION", 8);
            VCS_COINS_NOTIFICATION = new UIStringIdentifier("VCS_COINS_NOTIFICATION", 9);
            VCS_DEFAULT_CURRENCY = new UIStringIdentifier("VCS_DEFAULT_CURRENCY", 10);
            MBE_ERROR_DIALOG_TITLE = new UIStringIdentifier("MBE_ERROR_DIALOG_TITLE", 11);
            MBE_ERROR_DIALOG_MESSAGE_DEFAULT = new UIStringIdentifier("MBE_ERROR_DIALOG_MESSAGE_DEFAULT", 12);
            MBE_ERROR_DIALOG_MESSAGE_OFFLINE = new UIStringIdentifier("MBE_ERROR_DIALOG_MESSAGE_OFFLINE", 13);
            MBE_ERROR_DIALOG_BUTTON_TITLE_DISMISS = new UIStringIdentifier("MBE_ERROR_DIALOG_BUTTON_TITLE_DISMISS", 14);
            MBE_FORFEIT_DIALOG_TITLE = new UIStringIdentifier("MBE_FORFEIT_DIALOG_TITLE", 15);
            ENUM$VALUES = (new UIStringIdentifier[] {
                ERROR_DIALOG_TITLE, DISMISS_ERROR_DIALOG, GENERIC_ERROR, ERROR_LOADING_OFFERWALL, ERROR_LOADING_OFFERWALL_NO_INTERNET_CONNECTION, LOADING_INTERSTITIAL, LOADING_OFFERWALL, ERROR_PLAY_STORE_UNAVAILABLE, MBE_REWARD_NOTIFICATION, VCS_COINS_NOTIFICATION, 
                VCS_DEFAULT_CURRENCY, MBE_ERROR_DIALOG_TITLE, MBE_ERROR_DIALOG_MESSAGE_DEFAULT, MBE_ERROR_DIALOG_MESSAGE_OFFLINE, MBE_ERROR_DIALOG_BUTTON_TITLE_DISMISS, MBE_FORFEIT_DIALOG_TITLE
            });
        }

        private UIStringIdentifier(String s, int i)
        {
            super(s, i);
        }
    }

}
