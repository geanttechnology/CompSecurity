// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amazon.mobile.mash.util.Util;
import java.net.URISyntaxException;
import java.util.Locale;

// Referenced classes of package com.amazon.mobile.mash.nav:
//            MASHNavDelegate

public class MASHNavDelegateImpl
    implements MASHNavDelegate
{
    private static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action add_on_interstitial;
        public static final Action add_to_cart;
        public static final Action add_to_wishlist;
        public static final Action browse;
        public static final Action browse_history;
        public static final Action browser_view;
        public static final Action buy_now;
        public static final Action cancel_order;
        public static final Action cart;
        public static final Action checkout;
        public static final Action deal_page;
        public static final Action deals;
        public static final Action detail;
        public static final Action external;
        public static final Action friend_app;
        public static final Action go_back;
        public static final Action home;
        public static final Action image_gallery;
        public static final Action login;
        public static final Action logout;
        public static final Action mobileads_user_preferences;
        public static final Action more_buying_choices;
        public static final Action one_click_settings;
        public static final Action order_history;
        public static final Action push_notification_settings;
        public static final Action recommendations;
        public static final Action scan_it;
        public static final Action search;
        public static final Action share;
        public static final Action snap_it;
        public static final Action track_order;
        public static final Action update_cart;
        public static final Action video;
        public static final Action view_order;
        public static final Action webview;
        public static final Action wishlist;
        public static final Action your_account;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(com/amazon/mobile/mash/nav/MASHNavDelegateImpl$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            scan_it = new Action("scan_it", 0);
            snap_it = new Action("snap_it", 1);
            add_to_cart = new Action("add_to_cart", 2);
            cart = new Action("cart", 3);
            add_to_wishlist = new Action("add_to_wishlist", 4);
            wishlist = new Action("wishlist", 5);
            checkout = new Action("checkout", 6);
            buy_now = new Action("buy_now", 7);
            detail = new Action("detail", 8);
            deal_page = new Action("deal_page", 9);
            browse = new Action("browse", 10);
            browse_history = new Action("browse_history", 11);
            search = new Action("search", 12);
            your_account = new Action("your_account", 13);
            order_history = new Action("order_history", 14);
            cancel_order = new Action("cancel_order", 15);
            view_order = new Action("view_order", 16);
            track_order = new Action("track_order", 17);
            one_click_settings = new Action("one_click_settings", 18);
            recommendations = new Action("recommendations", 19);
            deals = new Action("deals", 20);
            login = new Action("login", 21);
            logout = new Action("logout", 22);
            video = new Action("video", 23);
            image_gallery = new Action("image_gallery", 24);
            external = new Action("external", 25);
            share = new Action("share", 26);
            friend_app = new Action("friend_app", 27);
            home = new Action("home", 28);
            more_buying_choices = new Action("more_buying_choices", 29);
            add_on_interstitial = new Action("add_on_interstitial", 30);
            mobileads_user_preferences = new Action("mobileads_user_preferences", 31);
            webview = new Action("webview", 32);
            browser_view = new Action("browser_view", 33);
            update_cart = new Action("update_cart", 34);
            go_back = new Action("go_back", 35);
            push_notification_settings = new Action("push_notification_settings", 36);
            $VALUES = (new Action[] {
                scan_it, snap_it, add_to_cart, cart, add_to_wishlist, wishlist, checkout, buy_now, detail, deal_page, 
                browse, browse_history, search, your_account, order_history, cancel_order, view_order, track_order, one_click_settings, recommendations, 
                deals, login, logout, video, image_gallery, external, share, friend_app, home, more_buying_choices, 
                add_on_interstitial, mobileads_user_preferences, webview, browser_view, update_cart, go_back, push_notification_settings
            });
        }

        private Action(String s, int i)
        {
            super(s, i);
        }
    }


    public MASHNavDelegateImpl()
    {
    }

    private boolean handleAppAction(Action action, Uri uri, Context context)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[];

            static 
            {
                $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action = new int[Action.values().length];
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.add_to_cart.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror36) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.add_to_wishlist.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror35) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.browse.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror34) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.browse_history.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror33) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.browser_view.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror32) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.buy_now.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.cancel_order.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.checkout.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.deal_page.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.deals.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.detail.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.external.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.friend_app.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.home.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.image_gallery.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.login.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.logout.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.more_buying_choices.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.one_click_settings.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.order_history.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.push_notification_settings.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.recommendations.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.scan_it.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.search.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.share.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.snap_it.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.track_order.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.update_cart.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.video.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.cart.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.view_order.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.wishlist.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.your_account.ordinal()] = 33;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.add_on_interstitial.ordinal()] = 34;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.mobileads_user_preferences.ordinal()] = 35;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.webview.ordinal()] = 36;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mobile$mash$nav$MASHNavDelegateImpl$Action[Action.go_back.ordinal()] = 37;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.mobile.mash.nav.MASHNavDelegateImpl.Action[action.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
            return handleAddToCart(uri, context);

        case 2: // '\002'
            return handleAddToWishlist(uri, context);

        case 3: // '\003'
            return handleBrowse(uri, context);

        case 4: // '\004'
            return handleBrowseHistory(uri, context);

        case 5: // '\005'
            return handleBrowserView(uri, context);

        case 6: // '\006'
            return handleBuyNow(uri, context);

        case 7: // '\007'
            return handleCancelOrder(uri, context);

        case 8: // '\b'
            return handleCheckout(uri, context);

        case 9: // '\t'
            return handleDealPage(uri, context);

        case 10: // '\n'
            return handleDeals(uri, context);

        case 11: // '\013'
            return handleDetailPage(uri, context);

        case 12: // '\f'
            return handleExternal(uri, context);

        case 13: // '\r'
            return handleFriendApp(uri, context);

        case 14: // '\016'
            return handleHome(uri, context);

        case 15: // '\017'
            return handleImageGallery(uri, context);

        case 16: // '\020'
            return handleLogin(uri, context);

        case 17: // '\021'
            return handleLogout(uri, context);

        case 18: // '\022'
            return handleMoreBuyingChoices(uri, context);

        case 19: // '\023'
            return handleOneClickSettings(uri, context);

        case 20: // '\024'
            return handleOrderHistory(uri, context);

        case 21: // '\025'
            return handlePushNotificationSettings(uri, context);

        case 22: // '\026'
            return handleRecommendations(uri, context);

        case 23: // '\027'
            return handleScanIt(uri, context);

        case 24: // '\030'
            return handleSearch(uri, context);

        case 25: // '\031'
            return handleShare(uri, context);

        case 26: // '\032'
            return handleSnapIt(uri, context);

        case 27: // '\033'
            return handleTrackOrder(uri, context);

        case 28: // '\034'
            return handleUpdateCart(uri, context);

        case 29: // '\035'
            return handleVideo(uri, context);

        case 30: // '\036'
            return handleViewCart(uri, context);

        case 31: // '\037'
            return handleViewOrder(uri, context);

        case 32: // ' '
            return handleViewWishlist(uri, context);

        case 33: // '!'
            return handleYourAccount(uri, context);

        case 34: // '"'
            return handleAddOnInterstitial(uri, context);

        case 35: // '#'
            return handleMobileAdsUserPreferences(uri, context);

        case 36: // '$'
            return handleWebView(uri, context);

        case 37: // '%'
            return handleGoBack(uri, context);
        }
    }

    protected boolean handleAddOnInterstitial(Uri uri, Context context)
    {
        return unsupportedAction(uri, context);
    }

    protected boolean handleAddToCart(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleAddToWishlist(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleAmznappScheme(Context context, Uri uri)
    {
        return false;
    }

    protected boolean handleBrowse(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleBrowseHistory(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleBrowserView(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleBuyNow(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleCancelOrder(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleCheckout(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleDealPage(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleDeals(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleDefault(Uri uri, Context context)
    {
        return false;
    }

    protected boolean handleDetailPage(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleDigitalStore(Uri uri, Context context)
    {
        return false;
    }

    protected boolean handleExternal(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleFriendApp(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleGoBack(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleHome(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleImageGallery(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleIntent(Uri uri, Context context)
        throws URISyntaxException
    {
        uri = Intent.parseUri(uri.toString(), 1);
        if (context.getPackageManager().resolveActivity(uri, 0x10000) != null)
        {
            context.startActivity(uri);
        }
        return true;
    }

    protected boolean handleLogin(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleLogout(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleMobileAdsUserPreferences(Uri uri, Context context)
    {
        return unsupportedAction(uri, context);
    }

    protected boolean handleModal(Uri uri, Context context)
    {
        return unsupportedAction(uri, context);
    }

    protected boolean handleMoreBuyingChoices(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleOneClickSettings(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleOrderHistory(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handlePushNotificationSettings(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleRecommendations(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleScanIt(Uri uri, Context context)
    {
        return unsupportedAction(uri, context);
    }

    protected boolean handleSearch(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleShare(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleSnapIt(Uri uri, Context context)
    {
        return unsupportedAction(uri, context);
    }

    protected boolean handleTrackOrder(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleUpdateCart(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleVideo(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleViewCart(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleViewOrder(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleViewWishlist(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    protected boolean handleWebView(Uri uri, Context context)
    {
        return unsupportedAction(uri, context);
    }

    protected boolean handleYourAccount(Uri uri, Context context)
    {
        return handleDefault(uri, context);
    }

    public boolean navigate(String s, Context context)
    {
        s = Uri.parse(s);
        String s1 = s.getScheme();
        if (context != null && s1 != null)
        {
            if ("intent".equalsIgnoreCase(s1))
            {
                boolean flag;
                try
                {
                    flag = handleIntent(s, context);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return false;
                }
                return flag;
            }
            if (s.isHierarchical())
            {
                if ("amznapp".equalsIgnoreCase(s1))
                {
                    return handleAmznappScheme(context, s);
                }
                s1 = s.getPath();
                if (!Util.isEmpty(s1) && s1.contains("/ap/signin"))
                {
                    return handleLogin(s, context);
                }
                if ("modal".equalsIgnoreCase(s.getQueryParameter("app-nav-type")))
                {
                    return handleModal(s, context);
                }
                s1 = s.getQueryParameter("app-action");
                if (!Util.isEmpty(s1))
                {
                    boolean flag1;
                    try
                    {
                        flag1 = handleAppAction(Action.valueOf(s1.toLowerCase(Locale.US).replaceAll("-", "_")), s, context);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        return false;
                    }
                    return flag1;
                } else
                {
                    return handleDigitalStore(s, context);
                }
            }
        }
        return false;
    }

    protected boolean unsupportedAction(Uri uri, Context context)
    {
        return false;
    }
}
