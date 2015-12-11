// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;


// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavDelegateImpl

private static final class  extends Enum
{

    private static final push_notification_settings $VALUES[];
    public static final push_notification_settings add_on_interstitial;
    public static final push_notification_settings add_to_cart;
    public static final push_notification_settings add_to_wishlist;
    public static final push_notification_settings browse;
    public static final push_notification_settings browse_history;
    public static final push_notification_settings browser_view;
    public static final push_notification_settings buy_now;
    public static final push_notification_settings cancel_order;
    public static final push_notification_settings cart;
    public static final push_notification_settings checkout;
    public static final push_notification_settings deal_page;
    public static final push_notification_settings deals;
    public static final push_notification_settings detail;
    public static final push_notification_settings external;
    public static final push_notification_settings friend_app;
    public static final push_notification_settings go_back;
    public static final push_notification_settings home;
    public static final push_notification_settings image_gallery;
    public static final push_notification_settings login;
    public static final push_notification_settings logout;
    public static final push_notification_settings mobileads_user_preferences;
    public static final push_notification_settings more_buying_choices;
    public static final push_notification_settings one_click_settings;
    public static final push_notification_settings order_history;
    public static final push_notification_settings push_notification_settings;
    public static final push_notification_settings recommendations;
    public static final push_notification_settings scan_it;
    public static final push_notification_settings search;
    public static final push_notification_settings share;
    public static final push_notification_settings snap_it;
    public static final push_notification_settings track_order;
    public static final push_notification_settings update_cart;
    public static final push_notification_settings video;
    public static final push_notification_settings view_order;
    public static final push_notification_settings webview;
    public static final push_notification_settings wishlist;
    public static final push_notification_settings your_account;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        scan_it = new <init>("scan_it", 0);
        snap_it = new <init>("snap_it", 1);
        add_to_cart = new <init>("add_to_cart", 2);
        cart = new <init>("cart", 3);
        add_to_wishlist = new <init>("add_to_wishlist", 4);
        wishlist = new <init>("wishlist", 5);
        checkout = new <init>("checkout", 6);
        buy_now = new <init>("buy_now", 7);
        detail = new <init>("detail", 8);
        deal_page = new <init>("deal_page", 9);
        browse = new <init>("browse", 10);
        browse_history = new <init>("browse_history", 11);
        search = new <init>("search", 12);
        your_account = new <init>("your_account", 13);
        order_history = new <init>("order_history", 14);
        cancel_order = new <init>("cancel_order", 15);
        view_order = new <init>("view_order", 16);
        track_order = new <init>("track_order", 17);
        one_click_settings = new <init>("one_click_settings", 18);
        recommendations = new <init>("recommendations", 19);
        deals = new <init>("deals", 20);
        login = new <init>("login", 21);
        logout = new <init>("logout", 22);
        video = new <init>("video", 23);
        image_gallery = new <init>("image_gallery", 24);
        external = new <init>("external", 25);
        share = new <init>("share", 26);
        friend_app = new <init>("friend_app", 27);
        home = new <init>("home", 28);
        more_buying_choices = new <init>("more_buying_choices", 29);
        add_on_interstitial = new <init>("add_on_interstitial", 30);
        mobileads_user_preferences = new <init>("mobileads_user_preferences", 31);
        webview = new <init>("webview", 32);
        browser_view = new <init>("browser_view", 33);
        update_cart = new <init>("update_cart", 34);
        go_back = new <init>("go_back", 35);
        push_notification_settings = new <init>("push_notification_settings", 36);
        $VALUES = (new .VALUES[] {
            scan_it, snap_it, add_to_cart, cart, add_to_wishlist, wishlist, checkout, buy_now, detail, deal_page, 
            browse, browse_history, search, your_account, order_history, cancel_order, view_order, track_order, one_click_settings, recommendations, 
            deals, login, logout, video, image_gallery, external, share, friend_app, home, more_buying_choices, 
            add_on_interstitial, mobileads_user_preferences, webview, browser_view, update_cart, go_back, push_notification_settings
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
