// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.navigation;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.goldbox.GoldboxLaunchParamters;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ExitConfirmationDialogHelper;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.WebUtils;
import java.util.Map;

public class AppNavigator
{
    public static final class Target extends Enum
    {

        private static final Target $VALUES[];
        public static final Target aiv_gateway;
        public static final Target aiv_help;
        public static final Target aiv_settings;
        public static final Target aiv_webview;
        public static final Target appstore_default;
        public static final Target back_up_your_photos;
        public static final Target change_country;
        public static final Target charity;
        public static final Target contact_us;
        public static final Target deals;
        public static final Target exit;
        public static final Target gift_cards;
        public static final Target help;
        public static final Target home;
        public static final Target login;
        public static final Target logout;
        public static final Target mas_all_categories;
        public static final Target mas_best_sellers;
        public static final Target mas_coins;
        public static final Target mas_entertainment;
        public static final Target mas_games;
        public static final Target mas_gateway;
        public static final Target mas_help;
        public static final Target mas_new_releases;
        public static final Target mas_recommended;
        public static final Target mas_settings;
        public static final Target mas_subscriptions;
        public static final Target mas_your_apps;
        public static final Target notifications;
        public static final Target prime_upsell;
        public static final Target shop_by_department;
        public static final Target webview;
        public static final Target your_account;
        public static final Target your_orders;
        public static final Target your_recently_viewed_items;
        public static final Target your_recommendations;
        public static final Target your_subscribe_and_save;
        public static final Target your_wish_list;

        public static Target from(String s)
        {
            Target target = valueOf(s);
            return target;
            Object obj;
            obj;
            Log.e(AppNavigator.TAG, (new StringBuilder()).append("Unknown target : ").append(s).toString());
_L2:
            return null;
            obj;
            Log.v(AppNavigator.TAG, (new StringBuilder()).append("Unknown target : ").append(s).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

        public static Target valueOf(String s)
        {
            return (Target)Enum.valueOf(com/amazon/mShop/navigation/AppNavigator$Target, s);
        }

        public static Target[] values()
        {
            return (Target[])$VALUES.clone();
        }

        static 
        {
            home = new Target("home", 0);
            shop_by_department = new Target("shop_by_department", 1);
            deals = new Target("deals", 2);
            gift_cards = new Target("gift_cards", 3);
            your_recently_viewed_items = new Target("your_recently_viewed_items", 4);
            charity = new Target("charity", 5);
            your_wish_list = new Target("your_wish_list", 6);
            your_orders = new Target("your_orders", 7);
            your_account = new Target("your_account", 8);
            your_recommendations = new Target("your_recommendations", 9);
            your_subscribe_and_save = new Target("your_subscribe_and_save", 10);
            back_up_your_photos = new Target("back_up_your_photos", 11);
            change_country = new Target("change_country", 12);
            notifications = new Target("notifications", 13);
            contact_us = new Target("contact_us", 14);
            help = new Target("help", 15);
            login = new Target("login", 16);
            logout = new Target("logout", 17);
            webview = new Target("webview", 18);
            aiv_webview = new Target("aiv_webview", 19);
            aiv_settings = new Target("aiv_settings", 20);
            aiv_help = new Target("aiv_help", 21);
            aiv_gateway = new Target("aiv_gateway", 22);
            prime_upsell = new Target("prime_upsell", 23);
            appstore_default = new Target("appstore_default", 24);
            mas_gateway = new Target("mas_gateway", 25);
            mas_recommended = new Target("mas_recommended", 26);
            mas_new_releases = new Target("mas_new_releases", 27);
            mas_best_sellers = new Target("mas_best_sellers", 28);
            mas_coins = new Target("mas_coins", 29);
            mas_games = new Target("mas_games", 30);
            mas_entertainment = new Target("mas_entertainment", 31);
            mas_all_categories = new Target("mas_all_categories", 32);
            mas_your_apps = new Target("mas_your_apps", 33);
            mas_subscriptions = new Target("mas_subscriptions", 34);
            mas_settings = new Target("mas_settings", 35);
            mas_help = new Target("mas_help", 36);
            exit = new Target("exit", 37);
            $VALUES = (new Target[] {
                home, shop_by_department, deals, gift_cards, your_recently_viewed_items, charity, your_wish_list, your_orders, your_account, your_recommendations, 
                your_subscribe_and_save, back_up_your_photos, change_country, notifications, contact_us, help, login, logout, webview, aiv_webview, 
                aiv_settings, aiv_help, aiv_gateway, prime_upsell, appstore_default, mas_gateway, mas_recommended, mas_new_releases, mas_best_sellers, mas_coins, 
                mas_games, mas_entertainment, mas_all_categories, mas_your_apps, mas_subscriptions, mas_settings, mas_help, exit
            });
        }

        private Target(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/mShop/navigation/AppNavigator.getSimpleName();

    public AppNavigator()
    {
    }

    public static void navigate(Context context, Target target)
    {
        navigate(context, target, null);
    }

    public static void navigate(Context context, Target target, Map map)
    {
        Object obj = null;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[];

            static 
            {
                $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target = new int[Target.values().length];
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.home.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror37) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.shop_by_department.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.deals.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.gift_cards.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.your_recently_viewed_items.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.charity.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.your_wish_list.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.your_orders.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.your_account.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.your_recommendations.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.your_subscribe_and_save.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.back_up_your_photos.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.change_country.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.notifications.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.contact_us.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.help.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.login.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.logout.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.webview.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.aiv_webview.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.aiv_settings.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.aiv_help.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_gateway.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_recommended.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_new_releases.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_best_sellers.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_coins.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_games.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_entertainment.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_all_categories.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_your_apps.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_subscriptions.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_settings.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.mas_help.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.appstore_default.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.aiv_gateway.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.prime_upsell.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$navigation$AppNavigator$Target[Target.exit.ordinal()] = 38;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.mShop.navigation.AppNavigator.Target[target.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            ActivityUtils.startHomeActivity(context);
            return;

        case 2: // '\002'
            ActivityUtils.startCategoryBrowseActivity(context);
            return;

        case 3: // '\003'
            ActivityUtils.startDealsActivity(context, (GoldboxLaunchParamters)Maps.get(map, "goldBoxLaunchParameters", com/amazon/mShop/goldbox/GoldboxLaunchParamters), (String)Maps.get(map, "clickStreamOrigin", java/lang/String), Maps.of("ref", Maps.get(map, "refMarker", java/lang/String)), ((Boolean)Maps.get(map, "isReorderToFront", java/lang/Boolean, Boolean.valueOf(true))).booleanValue());
            return;

        case 4: // '\004'
            WebUtils.openWebview(context, context.getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card_url));
            return;

        case 5: // '\005'
            ActivityUtils.startRecentlyViewedItemsActivity(context);
            return;

        case 6: // '\006'
            WebUtils.openWebview(context, context.getString(com.amazon.mShop.android.lib.R.string.smile_url), "smi_ac_menu_yc_cycsc");
            return;

        case 7: // '\007'
            ActivityUtils.startWishListActivity(context, (String)Maps.get(map, "clickStreamOrigin", java/lang/String), Maps.of("ref", Maps.get(map, "refMarker", java/lang/String)), ((Integer)Maps.get(map, "extraFlag", java/lang/Integer, Integer.valueOf(-1))).intValue());
            return;

        case 8: // '\b'
            ActivityUtils.startYourOrdersActivity(context, (String)Maps.get(map, "orderId", java/lang/String), (String)Maps.get(map, "orderActionKey", java/lang/String), ((Integer)Maps.get(map, "shipmentIndex", java/lang/Integer, Integer.valueOf(-1))).intValue(), (String)Maps.get(map, "refMarker", java/lang/String), ((Boolean)Maps.get(map, "isReorderToFront", java/lang/Boolean, Boolean.valueOf(true))).booleanValue(), ((Integer)Maps.get(map, "extraFlag", java/lang/Integer, Integer.valueOf(-1))).intValue());
            return;

        case 9: // '\t'
            ActivityUtils.startYourAccountActivity(context);
            return;

        case 10: // '\n'
            ActivityUtils.startRecommendationsActivity(context);
            return;

        case 11: // '\013'
            ActivityUtils.startSnsManageYourSubscribesActivity(context);
            return;

        case 12: // '\f'
            ActivityUtils.startBackupYourPhotosActivity(context);
            return;

        case 13: // '\r'
            ActivityUtils.startLocaleSwitchActivity(context, new int[0]);
            return;

        case 14: // '\016'
            ActivityUtils.startNotificationSettingActivity(context, (String)Maps.get(map, "category", java/lang/String));
            return;

        case 15: // '\017'
            ActivityUtils.startContactUsActivity(context);
            return;

        case 16: // '\020'
            ActivityUtils.startHelpActivity(context);
            return;

        case 17: // '\021'
            ActivityUtils.startLoginActivity(context, null, true, null, new int[0]);
            return;

        case 18: // '\022'
            ActivityUtils.startLogoutActivity(context);
            return;

        case 19: // '\023'
            WebUtils.openWebview(context, (String)Maps.get(map, "url", java/lang/String));
            return;

        case 20: // '\024'
            ActivityUtils.startAIVWebActivity(context, (String)Maps.get(map, "url", java/lang/String), ((Boolean)Maps.get(map, "forceClearHistory", java/lang/Boolean)).booleanValue());
            return;

        case 21: // '\025'
            ActivityUtils.startAIVSettingsActivity(context);
            return;

        case 22: // '\026'
            ActivityUtils.startHelpActivityWithAIVHelpPage(context);
            return;

        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
            ActivityUtils.startAppstoreActivity(context, target.toString(), true);
            return;

        case 36: // '$'
            if (map == null)
            {
                target = null;
            } else
            {
                target = (String)Maps.get(map, "url", java/lang/String);
            }
            ActivityUtils.startAIVGatewayActivity(context, null, -1, target);
            return;

        case 37: // '%'
            if (map == null)
            {
                target = obj;
            } else
            {
                target = (String)Maps.get(map, "url", java/lang/String);
            }
            ActivityUtils.startPrimeUpsellActivity(context, -1, target);
            return;

        case 38: // '&'
            ExitConfirmationDialogHelper.create(context, "hm_exit_ok", "hm_exit_cancel").show();
            return;
        }
    }


}
