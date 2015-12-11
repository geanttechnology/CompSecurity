// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.navigation;

import android.util.Log;

// Referenced classes of package com.amazon.mShop.navigation:
//            AppNavigator

public static final class  extends Enum
{

    private static final exit $VALUES[];
    public static final exit aiv_gateway;
    public static final exit aiv_help;
    public static final exit aiv_settings;
    public static final exit aiv_webview;
    public static final exit appstore_default;
    public static final exit back_up_your_photos;
    public static final exit change_country;
    public static final exit charity;
    public static final exit contact_us;
    public static final exit deals;
    public static final exit exit;
    public static final exit gift_cards;
    public static final exit help;
    public static final exit home;
    public static final exit login;
    public static final exit logout;
    public static final exit mas_all_categories;
    public static final exit mas_best_sellers;
    public static final exit mas_coins;
    public static final exit mas_entertainment;
    public static final exit mas_games;
    public static final exit mas_gateway;
    public static final exit mas_help;
    public static final exit mas_new_releases;
    public static final exit mas_recommended;
    public static final exit mas_settings;
    public static final exit mas_subscriptions;
    public static final exit mas_your_apps;
    public static final exit notifications;
    public static final exit prime_upsell;
    public static final exit shop_by_department;
    public static final exit webview;
    public static final exit your_account;
    public static final exit your_orders;
    public static final exit your_recently_viewed_items;
    public static final exit your_recommendations;
    public static final exit your_subscribe_and_save;
    public static final exit your_wish_list;

    public static  from(String s)
    {
          = valueOf(s);
        return ;
        Object obj;
        obj;
        Log.e(AppNavigator.access$000(), (new StringBuilder()).append("Unknown target : ").append(s).toString());
_L2:
        return null;
        obj;
        Log.v(AppNavigator.access$000(), (new StringBuilder()).append("Unknown target : ").append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static _cls000 valueOf(String s)
    {
        return (_cls000)Enum.valueOf(com/amazon/mShop/navigation/AppNavigator$Target, s);
    }

    public static _cls000[] values()
    {
        return (_cls000[])$VALUES.clone();
    }

    static 
    {
        home = new <init>("home", 0);
        shop_by_department = new <init>("shop_by_department", 1);
        deals = new <init>("deals", 2);
        gift_cards = new <init>("gift_cards", 3);
        your_recently_viewed_items = new <init>("your_recently_viewed_items", 4);
        charity = new <init>("charity", 5);
        your_wish_list = new <init>("your_wish_list", 6);
        your_orders = new <init>("your_orders", 7);
        your_account = new <init>("your_account", 8);
        your_recommendations = new <init>("your_recommendations", 9);
        your_subscribe_and_save = new <init>("your_subscribe_and_save", 10);
        back_up_your_photos = new <init>("back_up_your_photos", 11);
        change_country = new <init>("change_country", 12);
        notifications = new <init>("notifications", 13);
        contact_us = new <init>("contact_us", 14);
        help = new <init>("help", 15);
        login = new <init>("login", 16);
        logout = new <init>("logout", 17);
        webview = new <init>("webview", 18);
        aiv_webview = new <init>("aiv_webview", 19);
        aiv_settings = new <init>("aiv_settings", 20);
        aiv_help = new <init>("aiv_help", 21);
        aiv_gateway = new <init>("aiv_gateway", 22);
        prime_upsell = new <init>("prime_upsell", 23);
        appstore_default = new <init>("appstore_default", 24);
        mas_gateway = new <init>("mas_gateway", 25);
        mas_recommended = new <init>("mas_recommended", 26);
        mas_new_releases = new <init>("mas_new_releases", 27);
        mas_best_sellers = new <init>("mas_best_sellers", 28);
        mas_coins = new <init>("mas_coins", 29);
        mas_games = new <init>("mas_games", 30);
        mas_entertainment = new <init>("mas_entertainment", 31);
        mas_all_categories = new <init>("mas_all_categories", 32);
        mas_your_apps = new <init>("mas_your_apps", 33);
        mas_subscriptions = new <init>("mas_subscriptions", 34);
        mas_settings = new <init>("mas_settings", 35);
        mas_help = new <init>("mas_help", 36);
        exit = new <init>("exit", 37);
        $VALUES = (new .VALUES[] {
            home, shop_by_department, deals, gift_cards, your_recently_viewed_items, charity, your_wish_list, your_orders, your_account, your_recommendations, 
            your_subscribe_and_save, back_up_your_photos, change_country, notifications, contact_us, help, login, logout, webview, aiv_webview, 
            aiv_settings, aiv_help, aiv_gateway, prime_upsell, appstore_default, mas_gateway, mas_recommended, mas_new_releases, mas_best_sellers, mas_coins, 
            mas_games, mas_entertainment, mas_all_categories, mas_your_apps, mas_subscriptions, mas_settings, mas_help, exit
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
