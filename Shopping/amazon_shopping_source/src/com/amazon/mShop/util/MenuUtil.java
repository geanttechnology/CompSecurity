// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.actionBar.ActionBarCartView;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.debug.DebugSettingsActivity;
import com.amazon.mShop.gno.GNODebugSettingsActivity;
import com.amazon.mShop.mash.AmazonMASHTestActivity;
import com.amazon.mShop.mash.nav.AmazonNavManager;
import com.amazon.mShop.mobileads.DebugSettingsActivityForAds;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mShop.sso.SSODebugSettingsActivity;
import com.amazon.mShop.web.MShopWebDebugSettingsActivity;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.util:
//            UIUtils, ConfigUtils, Util, MShopPushNotificationUtils, 
//            ActivityUtils, DebugUtil, ExitConfirmationDialogHelper, BuildUtils, 
//            EmailUtils

public class MenuUtil
{

    private static final Map sRefMarkerMappings;

    public MenuUtil()
    {
    }

    private static MenuItem addMenuItem(int i, Menu menu, int j, int k, Intent intent, Character character, AmazonActivity amazonactivity)
    {
        return addMenuItem(i, menu, j, amazonactivity.getResources().getDrawable(k), intent, character);
    }

    private static MenuItem addMenuItem(int i, Menu menu, int j, Drawable drawable, Intent intent, Character character)
    {
        MenuItem menuitem = menu.add(0, i, 0, j);
        if (drawable != null)
        {
            menuitem.setIcon(drawable);
        }
        if (intent != null)
        {
            menuitem.setIntent(intent);
        }
        if (character != null)
        {
            menuitem.setAlphabeticShortcut(character.charValue());
        }
        if (!(menu instanceof SubMenu))
        {
            menuitem.setTitle(getMenuItemTitle(j));
        }
        return menuitem;
    }

    private static CharSequence getMenuItemTitle(int i)
    {
        if (i > 0)
        {
            Resources resources = ((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()).getResources();
            String s = resources.getString(i);
            SpannableString spannablestring = new SpannableString(s);
            spannablestring.setSpan(new AbsoluteSizeSpan(resources.getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.menu_title_size), false), 0, s.length(), 33);
            return spannablestring;
        } else
        {
            return null;
        }
    }

    public static void gotoEmailGiftCardPage(Context context)
    {
        android.net.Uri.Builder builder = Uri.parse("amznapp://shopping").buildUpon();
        builder.appendQueryParameter("app-action", "webview");
        builder.appendQueryParameter("url", context.getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card_url));
        builder.appendQueryParameter("app-title", context.getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card));
        (new AmazonNavManager()).navigate(builder.build().toString(), context);
    }

    public static void gotoGetAmazonAnroidAppsPage(Context context)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(context.getResources().getString(com.amazon.mShop.android.lib.R.string.more_get_amazon_android_apps_url)));
        intent.setFlags(0x10000000);
        context.startActivity(intent);
    }

    public static void gotoLegalInfoPage(AmazonActivity amazonactivity)
    {
        amazonactivity.pushView(new AmazonBrandedWebView(amazonactivity, amazonactivity.getResources().getString(com.amazon.mShop.android.lib.R.string.legal_info_url_android_with_aiv), amazonactivity.getResources().getString(com.amazon.mShop.android.lib.R.string.legal_info_text)));
    }

    public static boolean onCreateOptionsMenu(Menu menu, AmazonActivity amazonactivity)
    {
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_item_home, menu, com.amazon.mShop.android.lib.R.string.home, com.amazon.mShop.android.lib.R.drawable.android_menu_home, null, null, amazonactivity);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_item_search, menu, com.amazon.mShop.android.lib.R.string.search_menu_item, com.amazon.mShop.android.lib.R.drawable.android_menu_search, null, Character.valueOf('s'), amazonactivity);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_item_cart, menu, com.amazon.mShop.android.lib.R.string.cart, UIUtils.badgedIconForCount(amazonactivity, UIUtils.CART_ICON_RES_ID_FOR_COUNT, UIUtils.CART_ICON_RES_ID_FOR_COUNT_PLUS, ActionBarCartView.getCurrentQuantity()), null, null);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_item_wishlist, menu, com.amazon.mShop.android.lib.R.string.more_wishlist_button, com.amazon.mShop.android.lib.R.drawable.android_menu_wish_list, null, null, amazonactivity);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_item_youraccount, menu, com.amazon.mShop.android.lib.R.string.more_your_account_button, com.amazon.mShop.android.lib.R.drawable.android_menu_your_account, null, null, amazonactivity);
        menu = menu.addSubMenu(0, com.amazon.mShop.android.lib.R.id.menu_item_more, 0, getMenuItemTitle(com.amazon.mShop.android.lib.R.string.more));
        menu.setIcon(com.amazon.mShop.android.lib.R.drawable.android_menu_more);
        if (ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.R.string.config_hasGoldbox))
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_deals, menu, com.amazon.mShop.android.lib.R.string.goldbox, com.amazon.mShop.android.lib.R.drawable.goldbox_icon, null, null, amazonactivity);
        }
        if (SmileHelper.isSmile())
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_your_charity, menu, com.amazon.mShop.android.lib.R.string.your_charity, 0x108003b, null, null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_charity_name, menu, com.amazon.mShop.android.lib.R.string.your_charity, 0x108003b, null, null, amazonactivity);
        }
        if (!Util.isEmpty(amazonactivity.getResources().getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card)) && !Util.isEmpty(amazonactivity.getResources().getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card_url)))
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_email_gift_card, menu, com.amazon.mShop.android.lib.R.string.more_email_gift_card, 0x108003b, null, null, amazonactivity);
        }
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_recently_viewed_items, menu, com.amazon.mShop.android.lib.R.string.history_title, 0x1080045, null, null, amazonactivity);
        if (MShopPushNotificationUtils.isPushNotificationAvailable())
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_notification_setting, menu, com.amazon.mShop.android.lib.R.string.notification_setting, 0x108003b, null, null, amazonactivity);
        }
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_recommendations, menu, com.amazon.mShop.android.lib.R.string.more_recommendations_button, 0x1080045, null, null, amazonactivity);
        if (ActivityUtils.isHTMLSnSEnabled())
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_mys, menu, com.amazon.mShop.android.lib.R.string.menu_more_mys_description, 0x108003b, null, null, amazonactivity);
        }
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_change_country, menu, com.amazon.mShop.android.lib.R.string.amazon_store, 0x108003b, null, null, amazonactivity);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_legal, menu, com.amazon.mShop.android.lib.R.string.legal_info_text, 0x108003b, null, null, amazonactivity);
        if (ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.R.string.config_hasMoreAmazonAppsMenu))
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_get_amazon_android_apps, menu, com.amazon.mShop.android.lib.R.string.more_get_amazon_android_apps, 0x108003b, null, null, amazonactivity);
        }
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_help, menu, com.amazon.mShop.android.lib.R.string.more_help_button, 0x108003b, null, null, amazonactivity);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_contact_us, menu, com.amazon.mShop.android.lib.R.string.help_contact_us_title, 0x108003b, null, null, amazonactivity);
        addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_about, menu, com.amazon.mShop.android.lib.R.string.more_about_button, 0x108003b, null, null, amazonactivity);
        if (ConfigUtils.isEnabled(amazonactivity, com.amazon.mShop.android.lib.R.string.config_hasExitApp))
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_exit_app, menu, com.amazon.mShop.android.lib.R.string.exit, 0x108003b, null, null, amazonactivity);
        }
        if (DebugSettings.isDebugEnabled())
        {
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_mash_api_test, menu, com.amazon.mShop.android.lib.R.string.mash_api_test, 0x1080040, ActivityUtils.getStartActivityIntent(amazonactivity, com/amazon/mShop/mash/AmazonMASHTestActivity, -1), null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_debug, menu, com.amazon.mShop.android.lib.R.string.debug_title, 0x1080040, ActivityUtils.getStartActivityIntent(amazonactivity, com/amazon/mShop/debug/DebugSettingsActivity, -1), null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_debug_mobile_ads, menu, com.amazon.mShop.android.lib.R.string.debug_mobile_ads_title, 0x1080040, ActivityUtils.getStartActivityIntent(amazonactivity, com/amazon/mShop/mobileads/DebugSettingsActivityForAds, -1), null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_html_debug_settings, menu, com.amazon.mShop.android.lib.R.string.menu_more_html_debug_settings, 0x1080040, ActivityUtils.getStartActivityIntent(amazonactivity, com/amazon/mShop/web/MShopWebDebugSettingsActivity, -1), null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_set_weblab, menu, com.amazon.mShop.android.lib.R.string.menu_more_set_weblab, 0x1080040, null, null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_gno_debug_settings, menu, com.amazon.mShop.android.lib.R.string.debug_gno_settings, 0x1080040, ActivityUtils.getStartActivityIntent(amazonactivity, com/amazon/mShop/gno/GNODebugSettingsActivity, -1), null, amazonactivity);
            addMenuItem(com.amazon.mShop.android.lib.R.id.menu_more_sso_debug_settings, menu, com.amazon.mShop.android.lib.R.string.sso_debug_settings_title, 0x1080040, ActivityUtils.getStartActivityIntent(amazonactivity, com/amazon/mShop/sso/SSODebugSettingsActivity, -1), null, amazonactivity);
        }
        return true;
    }

    public static boolean onOptionsItemSelected(MenuItem menuitem, AmazonActivity amazonactivity)
    {
        int i = menuitem.getItemId();
        if (sRefMarkerMappings.containsKey(Integer.valueOf(i)))
        {
            if (com.amazon.mShop.android.lib.R.id.menu_item_cart == i)
            {
                RefMarkerObserver.logRefMarker("crt_html");
            } else
            {
                RefMarkerObserver.logRefMarker((String)sRefMarkerMappings.get(Integer.valueOf(i)));
            }
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_item_home)
        {
            return ActivityUtils.startHomeActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_item_search)
        {
            return ActivityUtils.startSearchActivity(amazonactivity, (new SearchIntentBuilder(amazonactivity)).showSearchEntryView(true).selectInitialQuery(true).clickStreamOrigin(ClickStreamTag.ORIGIN_SEARCH.getTag()).build());
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_item_cart)
        {
            return ActivityUtils.startCartActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_item_wishlist)
        {
            return ActivityUtils.startWishListActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_item_youraccount)
        {
            return ActivityUtils.startYourAccountActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_deals)
        {
            return ActivityUtils.startDealsActivity(amazonactivity, null, null);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_email_gift_card)
        {
            gotoEmailGiftCardPage(amazonactivity);
            return true;
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_recently_viewed_items)
        {
            return ActivityUtils.startRecentlyViewedItemsActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_notification_setting)
        {
            return ActivityUtils.startNotificationSettingActivity(amazonactivity, null);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_recommendations)
        {
            return ActivityUtils.startRecommendationsActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_mys)
        {
            return ActivityUtils.startSnsManageYourSubscribesActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_change_country)
        {
            return ActivityUtils.startLocaleSwitchActivity(amazonactivity, new int[0]);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_legal)
        {
            gotoLegalInfoPage(amazonactivity);
            return true;
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_get_amazon_android_apps)
        {
            gotoGetAmazonAnroidAppsPage(amazonactivity);
            return true;
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_help)
        {
            return ActivityUtils.startHelpActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_contact_us)
        {
            return ActivityUtils.startContactUsActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_about)
        {
            return ActivityUtils.startAboutActivity(amazonactivity);
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_set_weblab)
        {
            DebugUtil.overrideWeblabAssignment(amazonactivity);
            return true;
        }
        if (i == com.amazon.mShop.android.lib.R.id.menu_more_exit_app)
        {
            ExitConfirmationDialogHelper.create(amazonactivity, "mr_exit_ok", "mr_exit_cancel").show();
            return true;
        } else
        {
            return false;
        }
    }

    public static void provideFeedBack(Context context)
    {
        String s1 = AppLocale.getInstance().getDefaultLocale();
        String s = context.getResources().getString(com.amazon.mShop.android.lib.R.string.provide_feedback_to_address_android);
        String s2 = BuildUtils.getVersionName(context);
        s2 = String.format(context.getResources().getString(com.amazon.mShop.android.lib.R.string.about_version), new Object[] {
            s2
        });
        s1 = ConfigUtils.getStringForSpecificLocale(context, com.amazon.mShop.android.lib.R.string.config_marketplace_id, s1);
        EmailUtils.composeEmail(context, s, (new StringBuilder()).append(context.getResources().getString(com.amazon.mShop.android.lib.R.string.provide_feedback_subject_android)).append("(").append(s2).append(" - ").append(s1).append(")").toString(), null);
    }

    static 
    {
        sRefMarkerMappings = new HashMap();
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_item_home), "hm");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_item_search), "sr");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_item_cart), "crt_html");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_item_wishlist), "wl_html");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_item_youraccount), "ya");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_item_more), "mr");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_deals), "mr_deal");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_email_gift_card), "mr_em_gc");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_recently_viewed_items), "mr_rvi");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_recommendations), "mr_recs");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_mys), "mr_sns");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_notification_setting), "mr_notify");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_change_country), "cc");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_legal), "mr_legal");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_remembers), "mr_rem");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_get_amazon_android_apps), "mr_get_aaa");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_contact_us), "mr_cs");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_help), "mr_help");
        sRefMarkerMappings.put(Integer.valueOf(com.amazon.mShop.android.lib.R.id.menu_more_about), "mr_about");
    }
}
