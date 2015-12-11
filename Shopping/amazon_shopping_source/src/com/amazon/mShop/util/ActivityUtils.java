// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.about.MShopAboutActivity;
import com.amazon.mShop.account.LoginActivity;
import com.amazon.mShop.account.LogoutActivity;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.aiv.AIVGatewayActivity;
import com.amazon.mShop.aiv.AIVMShopWebActivity;
import com.amazon.mShop.aiv.AIVSettingsActivity;
import com.amazon.mShop.appstore.AppstoreActivity;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.cart.web.WebCartActivity;
import com.amazon.mShop.categoryBrowse.CategoryBrowseActivity;
import com.amazon.mShop.categoryBrowse.CategoryMetadata;
import com.amazon.mShop.clouddrive.CloudDriveUploadActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.customclientfields.RefmarkerClientField;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.details.web.WebProductDetailsActivity;
import com.amazon.mShop.fastBrowse.FastBrowseActivity;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.feature.WeblabCsmUtils;
import com.amazon.mShop.goldbox.GoldboxLaunchParamters;
import com.amazon.mShop.goldbox.WebGoldboxActivity;
import com.amazon.mShop.help.HelpActivity;
import com.amazon.mShop.help.web.WebContactUsActivity;
import com.amazon.mShop.history.HistoryActivity;
import com.amazon.mShop.history.HistoryContentProvider;
import com.amazon.mShop.home.GatewayActivity;
import com.amazon.mShop.home.GatewayWeblabUtil;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.localeswitch.LocaleSwitchActivity;
import com.amazon.mShop.mobileads.AdsWebActivity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.net.ErrorExceptionMetricsObserver;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.opl.PurchaseParams;
import com.amazon.mShop.opl.web.WebPurchaseActivity;
import com.amazon.mShop.order.web.WebViewOrderActivity;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.primeupsell.PrimeUpsellActivity;
import com.amazon.mShop.publicurl.PublicURLActivity;
import com.amazon.mShop.pushnotification.NotificationContentActivity;
import com.amazon.mShop.pushnotification.NotificationSettingActivity;
import com.amazon.mShop.pushnotification.PushNotificationManager;
import com.amazon.mShop.pushnotification.WebNotificationsSettingsActivity;
import com.amazon.mShop.recommendations.RecommendationsActivity;
import com.amazon.mShop.recommendations.web.WebRecommendationsActivity;
import com.amazon.mShop.search.ScopedSearch;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.image.SnapItActivity;
import com.amazon.mShop.search.viewit.ViewItScanEntryActivity;
import com.amazon.mShop.sns.SnsManageYourSubscribesActivity;
import com.amazon.mShop.social.SocialConnectActivity;
import com.amazon.mShop.social.SocialConnectDatabaseHelper;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.sso.SigninPromptActivity;
import com.amazon.mShop.startup.StartupSetCountryActivity;
import com.amazon.mShop.web.MShopModalWebActivity;
import com.amazon.mShop.wishlist.web.WebWishListActivity;
import com.amazon.mShop.youraccount.OneClickSettingsActivity;
import com.amazon.mShop.youraccount.OneClickSettingsView;
import com.amazon.mShop.youraccount.web.WebOneClickSettingsActivity;
import com.amazon.mShop.youraccount.web.WebYourAccountActivity;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import com.amazon.venezia.mShop.AppstoreNavigation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.util.EncodingUtils;

// Referenced classes of package com.amazon.mShop.util:
//            AttributionUtils, Util, Maps, MShopPushNotificationUtils, 
//            ConfigUtils, UIUtils, DBException, AppUtils, 
//            LocaleUtils

public class ActivityUtils
{

    public static final HashSet ASIN_AMAZON_COINS = new HashSet(Arrays.asList(new String[] {
        "B0096E8CQA", "B0096E8DAU", "B0096E8DSM", "B0096E8EC2", "B0096E8EPY", "B00ESJDO66", "B00ESJDP9W", "B00ESJDQ8M", "B00ESJDR9A", "B00ESJDS62", 
        "B00FA49T6M", "B00FA49URU", "B00FA49WCI", "B00FA49XX6", "B00FA49ZIO"
    }));
    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final ArrayList EXCLUDED_MODEL_FOR_HTML_GATEWAY_HA_OFF = new ArrayList(Arrays.asList(new String[] {
        "One X", "S720e"
    }));

    public ActivityUtils()
    {
    }

    private static void appendAssociateTagParameter(android.net.Uri.Builder builder, Map map)
    {
        String s = AttributionUtils.getAssociatesTag(AndroidPlatform.getInstance().getApplicationContext());
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("tag", s);
            removeParam(map, "tag");
        }
    }

    public static void appendParamsToURL(android.net.Uri.Builder builder, Map map)
    {
        if (map != null)
        {
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s = (String)iterator.next();
                if (!Util.isEmpty((String)Maps.get(map, s, java/lang/String)))
                {
                    if (s.equals("ref"))
                    {
                        builder.appendPath((new StringBuilder()).append("ref=").append((String)map.get("ref")).toString());
                    } else
                    {
                        builder.appendQueryParameter(s, (String)map.get(s));
                    }
                }
            } while (true);
        }
    }

    protected static boolean deviceExcludedHtmalGatewayHAOff()
    {
        for (Iterator iterator = EXCLUDED_MODEL_FOR_HTML_GATEWAY_HA_OFF.iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (Build.MODEL.toUpperCase().contains(s.toUpperCase()))
            {
                return true;
            }
        }

        return false;
    }

    public static String getAIVGatewayUrl(Context context)
    {
        return context.getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_url);
    }

    public static String getAccountPhoneNumberOption()
    {
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("accountPhoneNumber");
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = "Account Weblab Control";
        }
        return s;
    }

    private static byte[] getCheckOutPostParams(PurchaseParams purchaseparams)
    {
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        if (purchaseparams != null && !purchaseparams.isCartPurchase())
        {
            String s = purchaseparams.getAsin();
            if (!Util.isEmpty(s))
            {
                builder.appendQueryParameter("asin", s);
            }
            s = purchaseparams.getOfferId();
            if (!Util.isEmpty(s))
            {
                builder.appendQueryParameter("offeringID", s);
            }
            s = purchaseparams.getListId();
            if (!Util.isEmpty(s))
            {
                builder.appendQueryParameter("registryID", s);
            }
            s = purchaseparams.getListItemId();
            if (!Util.isEmpty(s))
            {
                builder.appendQueryParameter("registryItemID", s);
            }
            s = purchaseparams.getOneClickShippingSpeed();
            if (!Util.isEmpty(s))
            {
                builder.appendQueryParameter("shippingSpeed", s);
                builder.appendQueryParameter("oneClick", String.valueOf(1));
            } else
            {
                builder.appendQueryParameter("buyNow", String.valueOf(1));
            }
            purchaseparams = purchaseparams.getClickStreamOrigin();
            if (!Util.isEmpty(purchaseparams))
            {
                builder.appendQueryParameter("clickstreamOrigin", purchaseparams);
            }
        } else
        {
            builder.appendQueryParameter("proceedToCheckout", String.valueOf(1));
            builder.appendQueryParameter("useDefaultCart", String.valueOf(1));
        }
        purchaseparams = CookieBridge.getCurrentSessionId();
        if (!Util.isEmpty(purchaseparams))
        {
            builder.appendQueryParameter("sessionID", purchaseparams);
        }
        builder.appendQueryParameter("timestamp", String.valueOf(System.currentTimeMillis()));
        if (Util.isEmpty(builder.toString()))
        {
            return null;
        } else
        {
            return EncodingUtils.getBytes(builder.toString(), "UTF-8");
        }
    }

    private static String getFullUdpUrl(String s, ProductController productcontroller, Map map)
    {
        android.net.Uri.Builder builder;
        String s1;
        builder = Uri.parse(s).buildUpon();
        s = productcontroller.getListId();
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("colid", s);
            removeParam(map, "colid");
        }
        s = productcontroller.getListItemId();
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("coliid", s);
            removeParam(map, "coliid");
        }
        s = productcontroller.getPendingDealId();
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("di", s);
            removeParam(map, "di");
        }
        s = productcontroller.getPendingDealType();
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("dt", s);
            removeParam(map, "dt");
        }
        s = productcontroller.getMerchantId();
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("m", s);
            removeParam(map, "m");
        }
        s1 = productcontroller.getClickStreamTag().getTag();
        if (ClickStreamTag.ORIGIN_WISHLIST.getTag().equalsIgnoreCase(s1) || ClickStreamTag.ORIGIN_CART.getTag().equalsIgnoreCase(s1))
        {
            builder.appendQueryParameter("vs", "1");
            removeParam(map, "vs");
        }
        appendAssociateTagParameter(builder, map);
        productcontroller = "";
        s = productcontroller;
        if (map != null)
        {
            s = productcontroller;
            if (map.containsKey("ref"))
            {
                s = (String)map.get("ref");
                removeParam(map, "ref");
            }
        }
        if (Util.isEmpty(s)) goto _L2; else goto _L1
_L1:
        builder.appendPath((new StringBuilder()).append("ref=").append(s).toString());
_L4:
        if (!Util.isEmpty(s1))
        {
            builder.appendQueryParameter("clickstream-tag", s1);
        }
        appendParamsToURL(builder, map);
        return builder.build().toString();
_L2:
        if (!Util.isEmpty(s1))
        {
            builder.appendPath((new StringBuilder()).append("ref=").append(ClickStreamTag.createFullClickstreamTag(s1)).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getHTMLGatewayUrl(Context context, Map map)
    {
        String s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentGatewayUrl");
        Object obj = s;
        if (Util.isEmpty(s))
        {
            obj = context.getResources().getString(com.amazon.mShop.android.lib.R.string.gateway_web_page_url);
        }
        obj = Uri.parse(((String) (obj))).buildUpon();
        appendParamsToURL(((android.net.Uri.Builder) (obj)), map);
        boolean flag1 = false;
        boolean flag = flag1;
        if (map != null)
        {
            flag = flag1;
            if (!Util.isEmpty((String)Maps.get(map, "tag", java/lang/String)))
            {
                flag = true;
            }
        }
        if (!flag)
        {
            context = AttributionUtils.getAssociatesTag(context);
            if (!Util.isEmpty(context))
            {
                ((android.net.Uri.Builder) (obj)).appendQueryParameter("tag", context);
            }
        }
        context = ((android.net.Uri.Builder) (obj)).build().toString();
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html gateway URL:").append(context).toString());
        }
        return context;
    }

    public static String getSSONonAuthForceSignInOption()
    {
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("switchSSONonAuthForceSignIn");
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = "Weblab";
        }
        return s;
    }

    public static Intent getStartActivityIntent(Context context, Class class1, int i)
    {
        return getStartActivityIntent(context, class1, true, i);
    }

    public static Intent getStartActivityIntent(Context context, Class class1, boolean flag, int i)
    {
        context = new Intent(context, class1);
        context.setAction("intentActionStartActivity");
        if (flag)
        {
            context.addFlags(0x20000);
        }
        if (i != -1)
        {
            context.addFlags(i);
        }
        return context;
    }

    private static Intent getStartDealsActivityIntent(Context context, GoldboxLaunchParamters goldboxlaunchparamters, String s, Map map, boolean flag)
    {
        return getStartWebActivityIntent(context, com/amazon/mShop/goldbox/WebGoldboxActivity, getWebDealsURL(context, goldboxlaunchparamters, s, map), flag, -1);
    }

    public static Intent getStartWebActivityIntent(Context context, Class class1, String s, int i)
    {
        return getStartWebActivityIntent(context, class1, s, true, i);
    }

    public static Intent getStartWebActivityIntent(Context context, Class class1, String s, boolean flag, int i)
    {
        context = getStartActivityIntent(context, class1, flag, i);
        context.putExtra(WebConstants.getWebViewUrlKey(), s);
        return context;
    }

    public static Intent getStartWebNotificationActivityIntent(Context context, Class class1, Map map, NotificationTarget notificationtarget, int i)
    {
        Object obj;
        class1 = AndroidPlatform.getInstance().getDataStore().getString("CURRENT_HTML_NOTIFICATIONS_SETTING_DEBUG_URL");
        obj = class1;
        if (Util.isEmpty(class1))
        {
            obj = context.getString(com.amazon.mShop.android.lib.R.string.html_notifications_settings_web_page_url);
        }
        class1 = "";
        notificationtarget.getType();
        JVM INSTR tableswitch 0 3: default 72
    //                   0 174
    //                   1 188
    //                   2 181
    //                   3 195;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        obj = Uri.parse(((String) (obj))).buildUpon();
        ((android.net.Uri.Builder) (obj)).appendQueryParameter("d", notificationtarget.getDestination()).appendQueryParameter("a", notificationtarget.getApplicationId()).appendQueryParameter("t", class1);
        appendParamsToURL(((android.net.Uri.Builder) (obj)), map);
        class1 = ((android.net.Uri.Builder) (obj)).build().toString();
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html Notifications URL:").append(class1).toString());
        }
        return getStartWebActivityIntent(context, com/amazon/mShop/pushnotification/WebNotificationsSettingsActivity, class1, shouldReorderActivity(context), -1);
_L2:
        class1 = "APNS";
        continue; /* Loop/switch isn't completed */
_L4:
        class1 = "ADM";
        continue; /* Loop/switch isn't completed */
_L3:
        class1 = "GCM";
        continue; /* Loop/switch isn't completed */
_L5:
        class1 = "GETUI";
        if (true) goto _L1; else goto _L6
_L6:
    }

    public static Intent getStartWishListActivityIntent(Context context, Map map, int i)
    {
        String s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentWishlistUrl");
        Object obj = s;
        if (Util.isEmpty(s))
        {
            obj = context.getResources().getString(com.amazon.mShop.android.lib.R.string.wishlist_web_page_url);
        }
        obj = Uri.parse(((String) (obj))).buildUpon();
        appendAssociateTagParameter(((android.net.Uri.Builder) (obj)), map);
        appendParamsToURL(((android.net.Uri.Builder) (obj)), map);
        map = ((android.net.Uri.Builder) (obj)).build().toString();
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html wishlist URL:").append(map).toString());
        }
        return getStartWebActivityIntent(context, com/amazon/mShop/wishlist/web/WebWishListActivity, map, shouldReorderActivity(context), i);
    }

    public static Intent getStartYourAccountActivity(Context context, Map map)
    {
        String s = AndroidPlatform.getInstance().getDataStore().getString("currentYourAccountUrl");
        Object obj = s;
        if (Util.isEmpty(s))
        {
            obj = context.getString(com.amazon.mShop.android.lib.R.string.your_account_web_page_url);
        }
        obj = Uri.parse(((String) (obj))).buildUpon();
        appendParamsToURL(((android.net.Uri.Builder) (obj)), map);
        map = ((android.net.Uri.Builder) (obj)).build().toString();
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html Your Account URL:").append(map).toString());
        }
        return getStartWebActivityIntent(context, com/amazon/mShop/youraccount/web/WebYourAccountActivity, map, shouldReorderActivity(context), -1);
    }

    private static String getWebDealsURL(Context context, GoldboxLaunchParamters goldboxlaunchparamters, String s, Map map)
    {
        String s2 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentDealsUrl");
        String s1 = s2;
        if (Util.isEmpty(s2))
        {
            s1 = context.getString(com.amazon.mShop.android.lib.R.string.deals_web_page_url);
        }
        s2 = context.getString(com.amazon.mShop.android.lib.R.string.goldbox);
        android.net.Uri.Builder builder = Uri.parse(s1).buildUpon();
        s1 = s2;
        if (goldboxlaunchparamters != null)
        {
            s1 = s2;
            if ("LD".equals(goldboxlaunchparamters.getDealType()))
            {
                builder.appendPath("lightning-deals");
                s1 = goldboxlaunchparamters.getCategory();
                if (!Util.isEmpty(s1))
                {
                    builder.appendPath((new StringBuilder()).append("/").append(s1).append("/").toString());
                    s1 = goldboxlaunchparamters.getTitle();
                } else
                {
                    s1 = context.getString(com.amazon.mShop.android.lib.R.string.dp_deal_row_title);
                }
            }
        }
        if (!Util.isEmpty(s1))
        {
            builder.appendQueryParameter("app-title", s1);
        }
        if (MShopPushNotificationUtils.isPushNotificationAvailable() && MShopPushNotificationUtils.isMarketplaceSupportsNotification() && ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasNotificationForDeals))
        {
            builder.appendQueryParameter("isSupportNotification", String.valueOf(1));
        }
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("clickstream-tag", s);
        }
        appendParamsToURL(builder, map);
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html deals URL:").append(builder.build().toString()).toString());
        }
        return builder.build().toString();
    }

    public static boolean goToUdp(Context context, ProductController productcontroller, Map map, int i)
    {
        String s2 = productcontroller.getAsin();
        ClickStreamTag clickstreamtag = productcontroller.getClickStreamTag();
        String s = (String)Maps.get(map, "ref", java/lang/String);
        if (productcontroller.isMobileApp() && AppstoreUtils.isAppstoreAvailable())
        {
            startAppstoreActivityWithAsin(context, s2, s, null, null);
            return true;
        }
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentUdpUrl");
        s = s1;
        if (Util.isEmpty(s1))
        {
            s = context.getResources().getString(com.amazon.mShop.android.lib.R.string.product_details_web_page_url);
        }
        productcontroller = getFullUdpUrl((new StringBuilder()).append(s).append(s2).toString(), productcontroller, map);
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html Product Detail Page URL:").append(s).toString());
        }
        return goToUdp(context, ((String) (productcontroller)), clickstreamtag, i);
    }

    public static boolean goToUdp(Context context, String s, ClickStreamTag clickstreamtag, int i)
    {
        Intent intent = new Intent(context, com/amazon/mShop/details/web/WebProductDetailsActivity);
        intent.setAction("intentActionStartActivity");
        intent.putExtra(WebConstants.getWebViewUrlKey(), s);
        intent.putExtra("clickStreamOrigin", clickstreamtag.getTag());
        if (i != -1)
        {
            intent.setFlags(i);
        }
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("Go to UDP, url:").append(s).toString());
        }
        intent.putExtra("Launch_From_Public_Url", context instanceof PublicURLActivity);
        context.startActivity(intent);
        return true;
    }

    public static boolean isAccountPhoneNumber()
    {
        Context context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        if (DEBUG)
        {
            String s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("accountPhoneNumber");
            if ("Email".equals(s))
            {
                return false;
            }
            if ("Email or Phone Number".equals(s))
            {
                return true;
            } else
            {
                return ConfigUtils.isEnabled(context, com.amazon.mShop.android.lib.R.string.config_account_phone_number_support);
            }
        } else
        {
            return ConfigUtils.isEnabled(context, com.amazon.mShop.android.lib.R.string.config_account_phone_number_support);
        }
    }

    public static boolean isBlockHttpEnabled()
    {
        boolean flag1 = true;
        boolean flag = flag1;
        if (DEBUG)
        {
            flag = flag1;
            if ("featureNative".equals(com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("debugShouldBlockHttp")))
            {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean isDebugSettingEnabled(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!DEBUG)
            {
                break label0;
            }
            s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString(s);
            if (!"fatureHTML".equals(s))
            {
                flag = flag1;
                if (!"featureNative".equals(s))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean isFlowEnabled(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && ConfigUtils.isEnabled(context, com.amazon.mShop.android.lib.R.string.config_hasFlow))
        {
            return isWebFeatureEnabled("Android_ShopAppFlow", true, "switchFlow");
        } else
        {
            return false;
        }
    }

    public static boolean isGoToWebOneClickSetting()
    {
        return isWebFeatureEnabled("Android_ShopAppOneClickSetting", true, "switchOneClickSetting");
    }

    public static boolean isHTMLGatewayEnabled()
    {
        return isWebFeatureEnabled("Android_ShopAppHTMLGateway", true, "debugHTMLGateway");
    }

    public static boolean isHTMLRecommendationsEnabled()
    {
        return isWebFeatureEnabled("Android_ShopAppHTMLRecommendations", true, "switchRecommendations");
    }

    public static boolean isHTMLSnSEnabled()
    {
        return ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasSns) || isWebFeatureEnabled("Android_Enable_Sns_CA", true, "debugEnableSnSInCA");
    }

    public static boolean isHtmlGatewayWebViewHAOff()
    {
        return android.os.Build.VERSION.SDK_INT >= 11 && Features.getInstance().isFeatureActivated("Android_ShopAppHtmlGatewayHA") && !deviceExcludedHtmalGatewayHAOff();
    }

    public static boolean isPublicURLDealsEnabled()
    {
        return isWebFeatureEnabled("Android_Deals", true, "switchDeals");
    }

    public static boolean isSignInPrompt()
    {
        if (DEBUG)
        {
            String s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("switchSSONonAuthForceSignIn");
            if ("Normal".equals(s))
            {
                return false;
            }
            if ("Force".equals(s))
            {
                return true;
            } else
            {
                return Features.getInstance().isFeatureActivated("Android_ShopAppSigninPrompt");
            }
        } else
        {
            return Features.getInstance().isFeatureActivated("Android_ShopAppSigninPrompt");
        }
    }

    public static boolean isSmileEnabled()
    {
        return isWebFeatureEnabled("Android_AmazonSmile", true, "smile");
    }

    public static boolean isSpinnerV2Enabled()
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return false;
        } else
        {
            return isWebFeatureEnabled("Android_ShopAppSpinnerHardwareAcc", true, "debugSpinnerDismissLogicSwitch");
        }
    }

    private static boolean isWebFeatureEnabled(String s, boolean flag, String s1)
    {
        if (DEBUG)
        {
            s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString(s1);
            if ("fatureHTML".equals(s1))
            {
                return true;
            }
            if ("featureNative".equals(s1))
            {
                return false;
            }
            return flag && Features.getInstance().isFeatureActivated(s);
        }
        return flag && Features.getInstance().isFeatureActivated(s);
    }

    public static boolean isWebNotificationsPage()
    {
        return isWebFeatureEnabled("Android_HTMLNotificationsPage", true, "DEBUG_SWITCH_NOTIFICATIONS_PAGE");
    }

    public static boolean launchDetailsPage(Context context, ProductController productcontroller, Map map, int i)
    {
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("asin:").append(productcontroller.getAsin()).append(" clickStreamTag:").append(productcontroller.getClickStreamTag().getTag()).toString());
        }
        if (Util.isEmpty(productcontroller.getAsin()))
        {
            UIUtils.info(context, com.amazon.mShop.android.lib.R.string.error_can_not_find_product);
            return false;
        } else
        {
            return goToUdp(context, productcontroller, map, i);
        }
    }

    public static transient boolean launchDetailsPage(Context context, ProductController productcontroller, int ai[])
    {
        int i;
        if (ai.length > 0)
        {
            i = ai[0];
        } else
        {
            i = -1;
        }
        return launchDetailsPage(context, productcontroller, null, i);
    }

    public static void logViewHistory(Context context, String s)
    {
        try
        {
            ContentValues contentvalues = new ContentValues();
            contentvalues.put("asin", s);
            context.getContentResolver().insert(HistoryContentProvider.PRODUCT_URI, contentvalues);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.i("ActivityUtils", context.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ErrorExceptionMetricsObserver.logMetric(context);
        }
        Log.i("ActivityUtils", context.getMessage());
    }

    public static void logWeblabTrigger(String s, String s1)
    {
        if (!isDebugSettingEnabled(s1))
        {
            WeblabCsmUtils.postFeatureTrigger(s);
        }
    }

    public static void notifyUserSignedin()
    {
        if (User.getUser() != null)
        {
            User.userSignedIn(User.getUser());
        }
    }

    public static void postSignInPromptFeatureTrigger()
    {
        if (DEBUG)
        {
            String s = getSSONonAuthForceSignInOption();
            if ("Normal".equals(s) || "Force".equals(s))
            {
                return;
            }
        }
        WeblabCsmUtils.postFeatureTrigger("Android_ShopAppSigninPrompt");
    }

    public static void reloadHomeActivity(AmazonActivity amazonactivity)
    {
        amazonactivity.finish();
        startHomeActivity(amazonactivity);
    }

    private static void removeParam(Map map, String s)
    {
        if (map != null && map.containsKey(s))
        {
            map.remove(s);
        }
    }

    public static boolean shouldBrowseRedirect(Context context, Uri uri)
    {
        uri = uri.getQueryParameter("node");
        if (AIVAvailabilityUtils.isAIVAvailable() && CategoryBrowseController.shouldLaunchAIVBrowse(uri))
        {
            AppNavigator.navigate(context, com.amazon.mShop.navigation.AppNavigator.Target.aiv_webview, Maps.of("url", context.getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_url), "forceClearHistory", Boolean.valueOf(false)));
            return true;
        }
        if (AppstoreUtils.isAppstoreAvailable() && CategoryBrowseController.shouldLaunchAppStoreBrowse(uri))
        {
            startAppstoreActivity(context, com.amazon.mShop.navigation.AppNavigator.Target.mas_gateway.name());
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean shouldReorderActivity(Context context)
    {
        return !(context instanceof NotificationContentActivity);
    }

    public static boolean startAIVGatewayActivity(Context context, String s, int i)
    {
        return startAIVGatewayActivity(context, s, i, getAIVGatewayUrl(context));
    }

    public static boolean startAIVGatewayActivity(Context context, String s, int i, String s1)
    {
        if (context != null)
        {
            if (Util.isEmpty(s1))
            {
                s1 = context.getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_url);
            }
            android.net.Uri.Builder builder = Uri.parse(s1).buildUpon();
            if (!Util.isEmpty(s))
            {
                builder.appendPath((new StringBuilder()).append("ref=").append(s).toString());
            }
            builder.build().toString();
            s = getStartWebActivityIntent(context, com/amazon/mShop/aiv/AIVGatewayActivity, s1, i);
            if (s != null)
            {
                context.startActivity(s);
                return true;
            }
        }
        return false;
    }

    public static boolean startAIVSettingsActivity(Context context)
    {
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/aiv/AIVSettingsActivity, -1));
        return true;
    }

    public static void startAIVWebActivity(Context context, String s, boolean flag)
    {
        s = getStartWebActivityIntent(context, com/amazon/mShop/aiv/AIVMShopWebActivity, s, -1);
        s.putExtra("ForceClearHistory", flag);
        s.putExtra("CallingClassName", context.getClass().getSimpleName());
        context.startActivity(s);
    }

    public static boolean startAboutActivity(Context context)
    {
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/about/MShopAboutActivity, -1));
        return true;
    }

    public static boolean startAdsWebActivity(Context context, Uri uri)
    {
        Intent intent = new Intent(context, com/amazon/mShop/mobileads/AdsWebActivity);
        if (uri != null && uri.isHierarchical())
        {
            uri = uri.getQueryParameter("url");
            intent.putExtra(WebConstants.getWebViewUrlKey(), uri);
        }
        context.startActivity(intent);
        return true;
    }

    public static boolean startAdsWebActivity(Context context, String s)
    {
        if (!Util.isEmpty(s))
        {
            Intent intent = new Intent(context, com/amazon/mShop/mobileads/AdsWebActivity);
            intent.putExtra(WebConstants.getWebViewUrlKey(), s);
            context.startActivity(intent);
        }
        return true;
    }

    public static void startAppstoreActivity(Context context, String s)
    {
        startAppstoreActivity(context, s, false);
    }

    public static void startAppstoreActivity(Context context, String s, boolean flag)
    {
        s = AppstoreNavigation.createIntentForTarget(s, flag);
        s.setClass(context, com/amazon/mShop/appstore/AppstoreActivity);
        context.startActivity(s);
    }

    public static void startAppstoreActivityToBuyCoins(Context context, String s)
    {
        s = AppstoreNavigation.createIntentToBuyCoins(s);
        s.setClass(context, com/amazon/mShop/appstore/AppstoreActivity);
        context.startActivity(s);
    }

    public static void startAppstoreActivityWithAsin(Context context, String s, String s1, String s2, String s3)
    {
        s = AppstoreNavigation.createIntentForAsin(s, s1, s2, s3);
        s.setClass(context, com/amazon/mShop/appstore/AppstoreActivity);
        context.startActivity(s);
    }

    public static void startAppstoreActivityWithAsinAndFlag(Context context, String s, String s1, String s2, String s3, int i)
    {
        s = AppstoreNavigation.createIntentForAsin(s, s1, s2, s3);
        s.setClass(context, com/amazon/mShop/appstore/AppstoreActivity);
        s.addFlags(i);
        context.startActivity(s);
    }

    public static boolean startBackupYourPhotosActivity(Context context)
    {
        context.startActivity(new Intent(context, com/amazon/mShop/clouddrive/CloudDriveUploadActivity));
        return true;
    }

    public static void startBarcodeActivity(AmazonActivity amazonactivity, String s)
    {
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/search/viewit/ViewItScanEntryActivity);
        intent.addFlags(0x20000);
        amazonactivity.startActivityForResult(intent, 4);
        if (!Util.isEmpty(s))
        {
            RefMarkerObserver.logRefMarker(s);
        }
    }

    public static boolean startCartActivity(Context context)
    {
        return startCartActivity(context, null, -1);
    }

    public static boolean startCartActivity(Context context, Map map, int i)
    {
        if (context == null)
        {
            return false;
        }
        String s = AndroidPlatform.getInstance().getDataStore().getString("currentCart");
        Object obj = s;
        if (Util.isEmpty(s))
        {
            obj = context.getString(com.amazon.mShop.android.lib.R.string.web_cart_page);
        }
        obj = Uri.parse(((String) (obj))).buildUpon();
        appendParamsToURL(((android.net.Uri.Builder) (obj)), map);
        map = ((android.net.Uri.Builder) (obj)).build().toString();
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("HTML Cart URL:").append(map).toString());
        }
        map = getStartWebActivityIntent(context, com/amazon/mShop/cart/web/WebCartActivity, map, shouldReorderActivity(context), i);
        if (map != null)
        {
            map.putExtra("Launch_From_Public_Url", context instanceof PublicURLActivity);
        }
        context.startActivity(map);
        return true;
    }

    public static boolean startCategoryBrowseActivity(Context context)
    {
        return startCategoryBrowseActivity(context, Uri.parse("/s/browse?node=aps"));
    }

    public static boolean startCategoryBrowseActivity(Context context, Uri uri)
    {
        uri = CategoryBrowseController.buildCategoryBrowseLink(uri);
        if (shouldBrowseRedirect(context, Uri.parse(uri)))
        {
            return true;
        }
        Features.getInstance().getFeatureState("SX_mShop_Android_Fast_Browse");
        if (Features.getInstance().isFeatureActivated("SX_mShop_Android_Fast_Browse"))
        {
            uri = getStartWebActivityIntent(context, com/amazon/mShop/fastBrowse/FastBrowseActivity, uri, false, -1);
        } else
        {
            uri = getStartWebActivityIntent(context, com/amazon/mShop/categoryBrowse/CategoryBrowseActivity, uri, false, -1);
        }
        context.startActivity(uri);
        return true;
    }

    public static boolean startContactUsActivity(Context context)
    {
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentContactUsUrl");
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = context.getString(com.amazon.mShop.android.lib.R.string.contact_us_web_page_url);
        }
        context.startActivity(getStartWebActivityIntent(context, com/amazon/mShop/help/web/WebContactUsActivity, s, -1));
        return true;
    }

    public static boolean startDealsActivity(Context context, GoldboxLaunchParamters goldboxlaunchparamters, String s)
    {
        return startDealsActivity(context, goldboxlaunchparamters, s, null, true);
    }

    public static boolean startDealsActivity(Context context, GoldboxLaunchParamters goldboxlaunchparamters, String s, Map map, boolean flag)
    {
        context.startActivity(getStartDealsActivityIntent(context, goldboxlaunchparamters, s, map, flag));
        return true;
    }

    public static void startFlowActivity(AmazonActivity amazonactivity, String s, String s1)
    {
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/search/viewit/ViewItScanEntryActivity);
        intent.addFlags(0x20000);
        intent.putExtra("MODULE_TYPE_IS_IMAGE_SEARCH", true);
        intent.putExtra("clickStreamOrigin", s);
        amazonactivity.startActivityForResult(intent, 18);
        if (!Util.isEmpty(s1))
        {
            RefMarkerObserver.logRefMarker(s1);
        }
    }

    public static boolean startHelpActivity(Context context)
    {
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/help/HelpActivity, -1));
        return true;
    }

    public static boolean startHelpActivityWithAIVHelpPage(Context context)
    {
        Intent intent = getStartActivityIntent(context, com/amazon/mShop/help/HelpActivity, -1);
        intent.putExtra("source", "aiv_help");
        context.startActivity(intent);
        return true;
    }

    public static boolean startHomeActivity(Context context)
    {
        return startHomeActivity(context, null, -1, false);
    }

    public static boolean startHomeActivity(Context context, Map map, int i, boolean flag)
    {
        com.amazon.mShop.feature.Features.FeatureStateChangeType featurestatechangetype = GatewayWeblabUtil.getInstance().updateGatewayWeblabState();
        String s = (String)Maps.get(map, "ref", java/lang/String);
        if (com.amazon.mShop.feature.Features.FeatureStateChangeType.TREATMENT_CHANGE == featurestatechangetype && !(context instanceof StartupActivity))
        {
            AppUtils.restartApp();
            return true;
        }
        if (isHTMLGatewayEnabled())
        {
            map = getStartWebActivityIntent(context, com/amazon/mShop/home/web/MShopWebGatewayActivity, getHTMLGatewayUrl(context, map), shouldReorderActivity(context), i);
        } else
        {
            map = getStartActivityIntent(context, com/amazon/mShop/home/GatewayActivity, false, i);
            RefmarkerClientField.logServiceMethodNameAndRefmarker("home_v38", s);
        }
        map.addFlags(0x4000000);
        if (flag)
        {
            map.addFlags(0x10000000);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                map.addFlags(32768);
            }
        }
        if (context instanceof GatewayActivity)
        {
            map.putExtra("newIntentOrigin", "home");
        }
        if (!Util.isEmpty(s))
        {
            RefmarkerClientField.logServiceMethodNameAndRefmarker("home_v38", s);
        }
        GatewayWeblabUtil.getInstance().postGatewayFeatureTrigger(false);
        context.startActivity(map);
        return true;
    }

    public static transient boolean startLocaleSwitchActivity(Context context, int ai[])
    {
        int i;
        if (ai.length > 0)
        {
            i = ai[0];
        } else
        {
            i = -1;
        }
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/localeswitch/LocaleSwitchActivity, i));
        return true;
    }

    public static boolean startLocaleSwitchActivityWhenNecessary(Activity activity, String s)
    {
        boolean flag = false;
        Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (((DataStore) (obj)).getBoolean("needToSelectLocale"))
        {
            ((DataStore) (obj)).putBoolean("needToSelectLocale", false);
            LocaleUtils.setCurrentAppLocale(AttributionUtils.readStringFromRawResourceFile(activity, com.amazon.mShop.android.lib.R.raw.default_locale).trim());
            obj = new Intent(activity, com/amazon/mShop/startup/StartupSetCountryActivity);
            if (!(activity instanceof Activity))
            {
                ((Intent) (obj)).addFlags(0x10000000);
            }
            StartupActivity.startActivityForStartup(activity, ((Intent) (obj)), s);
            flag = true;
        }
        return flag;
    }

    public static transient boolean startLoginActivity(Context context, String s, boolean flag, String s1, int ai[])
    {
        int i;
        if (ai.length > 0)
        {
            i = ai[0];
        } else
        {
            i = -1;
        }
        ai = getStartActivityIntent(context, com/amazon/mShop/account/LoginActivity, i);
        ai.putExtra("USER_INITIATED_LOGIN", flag);
        ai.putExtra("LOGIN_ORIGIN_KEY", s);
        ai.putExtra("REFMARKER", s1);
        context.startActivity(ai);
        return true;
    }

    public static boolean startLoginActivityForResult(Context context, int i, String s, boolean flag, boolean flag1, boolean flag2, String s1)
    {
        Intent intent = getStartActivityIntent(context, com/amazon/mShop/account/LoginActivity, -1);
        intent.putExtra("LOGIN_ORIGIN_KEY", s);
        intent.putExtra("USER_INITIATED_LOGIN", flag);
        intent.putExtra("FORCE_SIGN_IN", flag1);
        intent.putExtra("IS_CREATE_NEW_ACCOUNT", flag2);
        intent.putExtra("REFMARKER", s1);
        ((Activity)context).startActivityForResult(intent, i);
        return true;
    }

    public static boolean startLogoutActivity(Context context)
    {
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/account/LogoutActivity, -1));
        return true;
    }

    public static boolean startMShopModalWebActivity(Activity activity, Uri uri)
    {
        uri = uri.buildUpon();
        uri.appendQueryParameter("app-nav-type", null);
        Intent intent = new Intent(activity, com/amazon/mShop/web/MShopModalWebActivity);
        intent.putExtra(WebConstants.getWebViewUrlKey(), uri.toString());
        activity.startActivityForResult(intent, 17);
        return true;
    }

    public static boolean startNotificationSettingActivity(Context context, String s)
    {
        return startNotificationSettingActivity(context, s, null);
    }

    public static boolean startNotificationSettingActivity(Context context, String s, Map map)
    {
        if (!MShopPushNotificationUtils.isPushNotificationAvailable())
        {
            return true;
        }
        NotificationTarget notificationtarget = PushNotificationManager.getInstance().getNewNotificationTarget(null);
        String s1 = (String)Maps.get(map, "ref", java/lang/String);
        if (!isWebNotificationsPage() || notificationtarget == null)
        {
            map = new Intent(context, com/amazon/mShop/pushnotification/NotificationSettingActivity);
            if ("deal".equals(s))
            {
                map.putExtra("DefaultExpandedGroupId", "TD");
            } else
            if ("shipment".equals(s))
            {
                map.putExtra("DefaultExpandedGroupId", "ST");
            }
            RefmarkerClientField.logServiceMethodNameAndRefmarker("get_notification_subscriptions_v35", s1);
            s = map;
        } else
        {
            s = getStartWebNotificationActivityIntent(context, com/amazon/mShop/pushnotification/WebNotificationsSettingsActivity, map, notificationtarget, -1);
        }
        if (s != null)
        {
            logWeblabTrigger("Android_HTMLNotificationsPage", "DEBUG_SWITCH_NOTIFICATIONS_PAGE");
            context.startActivity(s);
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean startOneClickSettingActivity(Context context, int i)
    {
        Intent intent = new Intent(context, com/amazon/mShop/youraccount/OneClickSettingsActivity);
        intent.addFlags(0x10000000);
        context.startActivity(intent);
        return true;
    }

    public static boolean startOneClickSettingActivity(Context context, boolean flag, boolean flag1)
    {
        if (isGoToWebOneClickSetting())
        {
            String s1 = AndroidPlatform.getInstance().getDataStore().getString("currentOneClickSettingUrl");
            String s = s1;
            if (Util.isEmpty(s1))
            {
                s = context.getString(com.amazon.mShop.android.lib.R.string.one_click_settings_web_page_url);
            }
            context.startActivity(getStartWebActivityIntent(context, com/amazon/mShop/youraccount/web/WebOneClickSettingsActivity, s, -1));
        } else
        {
            new OneClickSettingsView((AmazonActivity)context, flag, flag1);
        }
        return true;
    }

    public static void startPrimeUpsellActivity(Context context, int i, String s)
    {
        if (Util.isEmpty(s))
        {
            s = context.getResources().getString(com.amazon.mShop.android.lib.R.string.help_prime_instant_video_button_url);
        }
        context.startActivity(getStartWebActivityIntent(context, com/amazon/mShop/primeupsell/PrimeUpsellActivity, s, i));
    }

    public static void startPurchaseActivity(Context context, PurchaseParams purchaseparams)
    {
        Intent intent = new Intent(context, com/amazon/mShop/opl/web/WebPurchaseActivity);
        String s1 = AndroidPlatform.getInstance().getDataStore().getString("currentCheckOutUrl");
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = context.getString(com.amazon.mShop.android.lib.R.string.web_check_out);
        }
        if (purchaseparams != null && !Util.isEmpty(purchaseparams.getCheckoutUrl()))
        {
            s = purchaseparams.getCheckoutUrl();
        } else
        {
            intent.putExtra("postParams", getCheckOutPostParams(purchaseparams));
        }
        intent.putExtra(WebConstants.getWebViewUrlKey(), s);
        if (purchaseparams != null)
        {
            intent.putExtra("isCartPurchase", purchaseparams.isCartPurchase());
        }
        if (purchaseparams != null)
        {
            boolean flag;
            if (!Util.isEmpty(purchaseparams.getOneClickShippingSpeed()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            intent.putExtra("oneClick", flag);
        }
        context.startActivity(intent);
    }

    public static boolean startRecentlyViewedItemsActivity(Context context)
    {
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/history/HistoryActivity, -1));
        return true;
    }

    public static boolean startRecommendationsActivity(Context context)
    {
        return startRecommendationsActivity(context, null);
    }

    public static boolean startRecommendationsActivity(Context context, Map map)
    {
        Object obj;
        String s;
        String s1;
        obj = (String)Maps.get(map, "ref", java/lang/String);
        s = (String)Maps.get(map, "node", java/lang/String);
        s1 = (String)Maps.get(map, "category_display_name", java/lang/String);
        if (!isHTMLRecommendationsEnabled()) goto _L2; else goto _L1
_L1:
        s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentRecommendationsUrl");
        obj = s;
        if (Util.isEmpty(s))
        {
            obj = context.getResources().getString(com.amazon.mShop.android.lib.R.string.html_recommendations_web_page_url);
        }
        obj = Uri.parse(((String) (obj))).buildUpon();
        appendParamsToURL(((android.net.Uri.Builder) (obj)), map);
        map = ((android.net.Uri.Builder) (obj)).build().toString();
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html RECS URL:").append(map).toString());
        }
        map = getStartWebActivityIntent(context, com/amazon/mShop/recommendations/web/WebRecommendationsActivity, map, -1);
_L4:
        logWeblabTrigger("Android_ShopAppHTMLRecommendations", "switchRecommendations");
        context.startActivity(map);
        return true;
_L2:
        if (!Util.isEmpty(((String) (obj))))
        {
            RefmarkerClientField.logServiceMethodNameAndRefmarker("get_recommended_items_v32", ((String) (obj)));
        }
        obj = getStartActivityIntent(context, com/amazon/mShop/recommendations/RecommendationsActivity, shouldReorderActivity(context), -1);
        map = ((Map) (obj));
        if (!Util.isEmpty(s))
        {
            ((Intent) (obj)).putExtra("BROWSE_NODE", s);
            ((Intent) (obj)).putExtra("CATEGORY_DISPLAY_NAME", s1);
            map = ((Map) (obj));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean startSearchActivity(AmazonActivity amazonactivity, Intent intent)
    {
        String s2 = null;
        if (amazonactivity == null || intent == null)
        {
            return false;
        }
        if (amazonactivity instanceof ScopedSearch)
        {
            ScopedSearch scopedsearch = (ScopedSearch)amazonactivity;
            CategoryMetadata categorymetadata = scopedsearch.getCategoryMetadata();
            String s;
            String s1;
            if (categorymetadata != null)
            {
                s = categorymetadata.title;
            } else
            {
                s = null;
            }
            if (categorymetadata != null)
            {
                s1 = categorymetadata.searchUrl;
            } else
            {
                s1 = null;
            }
            if (categorymetadata != null)
            {
                s2 = categorymetadata.searchAlias;
            }
            if (!Util.isEmpty(s) && !Util.isEmpty(s1) && !Util.isEmpty(s2))
            {
                intent.putExtra("CATEGORY_NAME", s);
                intent.putExtra("CATEGORY_URL", s1);
                intent.putExtra("CATEGORY_ALIAS", s2);
            }
            if ((scopedsearch instanceof FastBrowseActivity) || (scopedsearch instanceof CategoryBrowseActivity))
            {
                RefMarkerObserver.logRefMarker(String.format("br_quit_%1$d_sr", new Object[] {
                    Integer.valueOf(scopedsearch.getCurrentDepartmentDepth())
                }));
            }
        }
        intent.putExtra("Launch_From_Public_Url", amazonactivity instanceof PublicURLActivity);
        if (amazonactivity instanceof SearchActivity)
        {
            ((SearchActivity)amazonactivity).showSearchEntryView(intent, false);
            return true;
        } else
        {
            amazonactivity.startActivity(intent);
            return true;
        }
    }

    public static void startSigninPromptActivity(Context context)
    {
        context.startActivity(getStartActivityIntent(context, com/amazon/mShop/sso/SigninPromptActivity, -1));
    }

    public static void startSnapItActivity(AmazonActivity amazonactivity, String s)
    {
        RefMarkerObserver.logRefMarker("sr_snap");
        Intent intent = new Intent(amazonactivity, com/amazon/mShop/search/image/SnapItActivity);
        intent.addFlags(0x20000);
        amazonactivity.startActivityForResult(intent, 10);
        if (!Util.isEmpty(s))
        {
            RefMarkerObserver.logRefMarker(s);
        }
    }

    public static boolean startSnsDispatchActivity(Context context, String s, String s1, String s2)
    {
        s1 = new Intent(context, com/amazon/mShop/sns/SnsManageYourSubscribesActivity);
        android.net.Uri.Builder builder = Uri.parse(context.getResources().getString(com.amazon.mShop.android.lib.R.string.sns_dispatch_page)).buildUpon();
        if (!Util.isEmpty(s2))
        {
            builder.appendPath((new StringBuilder()).append("ref=").append(s2).toString());
        }
        if (!Util.isEmpty(s))
        {
            builder.appendQueryParameter("data", s);
        }
        s = builder.build().toString();
        s1.putExtra(WebConstants.getWebViewUrlKey(), s);
        context.startActivity(s1);
        return true;
    }

    public static boolean startSnsManageYourSubscribesActivity(Context context)
    {
        Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("currentSnsMys");
        String s = ((String) (obj));
        if (Util.isEmpty(((String) (obj))))
        {
            s = context.getResources().getString(com.amazon.mShop.android.lib.R.string.sns_mys_page);
        }
        obj = new Intent(context, com/amazon/mShop/sns/SnsManageYourSubscribesActivity);
        ((Intent) (obj)).putExtra(WebConstants.getWebViewUrlKey(), s);
        context.startActivity(((Intent) (obj)));
        return true;
    }

    public static void startSocialConnectActivity(Activity activity, String s)
    {
        Object obj1 = AndroidPlatform.getInstance().getDataStore().getString("socialConnectDebugUrl");
        Object obj = obj1;
        if (Util.isEmpty(((String) (obj1))))
        {
            obj = activity.getResources().getString(com.amazon.mShop.android.lib.R.string.social_connect_url);
        }
        obj1 = Uri.parse(((String) (obj))).buildUpon();
        obj = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        String s1 = SSOUtil.getCurrentAccount(((Context) (obj)));
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("app", ((Context) (obj)).getPackageName());
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("last_shown", SocialConnectDatabaseHelper.getInstance().getLastShown(s1));
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("times_shown", (new StringBuilder()).append(SocialConnectDatabaseHelper.getInstance().getNumberTimesShown(s1)).append("").toString());
        if (SocialConnectDatabaseHelper.getInstance().getDoNotShowAgain(s1))
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        ((android.net.Uri.Builder) (obj1)).appendQueryParameter("do_not_show_again", ((String) (obj)));
        StartupActivity.startActivityForStartup(activity, getStartWebActivityIntent(activity, com/amazon/mShop/social/SocialConnectActivity, ((android.net.Uri.Builder) (obj1)).build().toString(), -1), s);
    }

    public static boolean startWishListActivity(Context context)
    {
        return startWishListActivity(context, null, null, -1);
    }

    public static boolean startWishListActivity(Context context, String s, Map map, int i)
    {
        if (context != null)
        {
            if ((map = getStartWishListActivityIntent(context, map, i)) != null)
            {
                map.putExtra("Launch_From_Public_Url", context instanceof PublicURLActivity);
                map.putExtra("clickStreamOrigin", s);
                context.startActivity(map);
                return true;
            }
        }
        return false;
    }

    public static boolean startYourAccountActivity(Context context)
    {
        return startYourAccountActivity(context, null);
    }

    public static boolean startYourAccountActivity(Context context, Map map)
    {
        context.startActivity(getStartYourAccountActivity(context, map));
        return true;
    }

    public static boolean startYourOrdersActivity(Context context)
    {
        return startYourOrdersActivity(context, null, null, null, -1);
    }

    public static boolean startYourOrdersActivity(Context context, String s, String s1, int i, String s2, boolean flag, int j)
    {
        return startYourOrdersActivity(context, Maps.of(com.amazon.mShop.order.WebViewOrderHelper.OrderActionParams.ORDER_ID, s), s1, i, Maps.of("ref", s2), flag, j);
    }

    public static boolean startYourOrdersActivity(Context context, String s, String s1, String s2, int i)
    {
        return startYourOrdersActivity(context, s, s1, -1, s2, true, i);
    }

    public static boolean startYourOrdersActivity(Context context, Map map, String s, int i, Map map1, boolean flag, int j)
    {
        if ("order_to_view".equals(s))
        {
            s = com.amazon.mShop.order.WebViewOrderHelper.OrderAction.VIEW_ORDER;
        } else
        if ("order_to_cancel".equals(s))
        {
            s = com.amazon.mShop.order.WebViewOrderHelper.OrderAction.CANCEL_ORDER;
        } else
        if ("ORDER_TO_TRACK".equals(s))
        {
            s = com.amazon.mShop.order.WebViewOrderHelper.OrderAction.TRACK_PACKAGE;
        } else
        {
            s = com.amazon.mShop.order.WebViewOrderHelper.OrderAction.VIEW_ALL_ORDERS;
        }
        s = s.getUrl(context, map, map1);
        map = s;
        if (!DEBUG)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        Log.v("ActivityUtils", (new StringBuilder()).append("html Order URL:").append(s).toString());
        map = s;
_L2:
        map = getStartWebActivityIntent(context, com/amazon/mShop/order/web/WebViewOrderActivity, map, flag, j);
        if (context instanceof PublicURLActivity)
        {
            map.putExtra("Launch_From_Public_Url", true);
        }
        context.startActivity(map);
        return true;
        map;
        Log.e("ActivityUtils", "Could not retrieve view order url", map);
        s = com.amazon.mShop.order.WebViewOrderHelper.OrderAction.VIEW_ALL_ORDERS.getUrl(context, null, map1);
        map = s;
        if (DEBUG)
        {
            Log.v("ActivityUtils", (new StringBuilder()).append("html Order:View all orders URL:").append(s).toString());
            map = s;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

}
