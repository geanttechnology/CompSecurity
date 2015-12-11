// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.clouddrive.CloudDriveAvailability;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.smile.SmileHelper;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.Util;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProvider, GNODrawerItemGroup, GNODrawerItemSimple, GNODrawerItemSubHeader, 
//            GNODrawerItemHideable, GNODrawerItemAppstoreHeader, GNODrawerItemSBD, GNODrawerItemSubHeaderHideable, 
//            GNODrawerItemCharity, GNODrawerItemAuthentication, GNODrawerItem, GNODebugSettingsActivity, 
//            GNODrawer

public class GNOMenuItemProviderDefault extends GNOMenuItemProvider
{

    Context context;
    private Map mMenuItems;

    public GNOMenuItemProviderDefault(Context context1)
    {
        context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        buildDefaultMenuItems(context1);
    }

    private GNODrawerItem getAIVItem(Context context1)
    {
        return ((GNODrawerItemGroup.Builder)((GNODrawerItemGroup.Builder)((GNODrawerItemGroup.Builder)GNODrawerItemGroup.builder(context1, "mshop:aiv").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv)).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.aiv_gateway))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!AIVAvailabilityUtils.isAIVAvailable())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        })).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/vh").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_videos_home).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/wl").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_wl).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_wl_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/yvl").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_yvl).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_yvl_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:aiv/prime_tv").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_tv)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/prime_tv_top").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_tv_top).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_tv_top_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/prime_tv_kids").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_kids_tv).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_kids_tv_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context1, "mshop:aiv/hbo_on_prime").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_hbo_prime)).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_hbo_prime_url))).withType(GNODrawerItem.Type.SUB_ITEM)).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!"en_US".equals(AppLocale.getInstance().getCurrentLocaleName()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        }).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/prime_tv_genres").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_prime_genres).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_prime_genres_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:aiv/prime_mov").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_mov)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/prime_mov_top").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_mov_top).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_mov_top_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/prime_mov_kids").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_kids_mov).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_prime_kids_mov_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/prime_movie_genres").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_movie_prime_genres).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_movie_prime_genres_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:aiv/tv").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/tv_latest").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_latest).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_latest_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/tv_pop").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_pop).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_pop_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/tv_kids").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_kids).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_kids_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/tv_genres").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_genres).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_tv_genres_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:aiv/mov").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/mov_new").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov_new).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov_new_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/mov_pop").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov_pop).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov_pop_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/mov_kids").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov_kids).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_mov_kids_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/movie_genres").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_movie_genres).withListener(navigateToAIVUrlOnClick(context1, com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_movie_genres_url)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:aiv/more").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_more)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/more_settings").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_more_settings).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.aiv_settings)).withType(GNODrawerItem.Type.SUB_ITEM).build()).withChild(GNODrawerItemSimple.builder(context1, "mshop:aiv/more_help").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_more_help).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.aiv_help)).withType(GNODrawerItem.Type.SUB_ITEM).build()).build();
    }

    private GNODrawerItem getAppstoreItem(Context context1)
    {
        return ((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)((GNODrawerItemAppstoreHeader.Builder)GNODrawerItemAppstoreHeader.builder(context1, "mshop:appstore").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore)).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_gateway))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!AppstoreUtils.isAppstoreAvailable())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        })).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/recommended").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_recommended).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_recommended)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/new_releases").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_new_releases).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_new_releases)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/best_sellers").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_best_sellers).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_best_sellers)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context1, "mshop:appstore/coins").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_coins)).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_coins))).withType(GNODrawerItem.Type.SUB_ITEM)).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                return Boolean.valueOf(true);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        }).build())).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:appstore/categories").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_categories)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/games").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_games).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_games)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/entertainment").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_entertainment).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_entertainment)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/all_categories").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_all_categories).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_all_categories)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:appstore/library").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_library)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/your_applications").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_your_applications).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_your_apps)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/subscriptions").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_manage_subscriptions).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_subscriptions)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(((GNODrawerItemSubHeader.Builder)((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context1, "mshop:appstore/more").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_more)).withType(GNODrawerItem.Type.SUB_SUB_HEADER)).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/settings").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_settings).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_settings)).withType(GNODrawerItem.Type.SUB_ITEM).build())).withChild(GNODrawerItemSimple.builder(context1, "mshop:appstore/help").withText(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_appstore_help).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.mas_help)).withType(GNODrawerItem.Type.SUB_ITEM).build())).build();
    }

    private GNODrawerItemSimple.GNOItemOnClickListener navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target target)
    {
        return navigateOnClick(target, null);
    }

    private GNODrawerItemSimple.GNOItemOnClickListener navigateOnClick(final com.amazon.mShop.navigation.AppNavigator.Target target, final Map params)
    {
        return new GNODrawerItemSimple.GNOItemOnClickListener() {

            final GNOMenuItemProviderDefault this$0;
            final Map val$params;
            final com.amazon.mShop.navigation.AppNavigator.Target val$target;

            public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
            {
                AppNavigator.navigate(amazonactivity, target, params);
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                target = target1;
                params = map;
                super();
            }
        };
    }

    private GNODrawerItemSimple.GNOItemOnClickListener navigateToAIVUrlOnClick(final Context context, final int stringId)
    {
        return new GNODrawerItemSimple.GNOItemOnClickListener() {

            private Resources mRes;
            final GNOMenuItemProviderDefault this$0;
            final Context val$context;
            final int val$stringId;

            public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
            {
                String s = mRes.getString(stringId);
                gnodrawer = s;
                if (DebugSettings.isDebugEnabled())
                {
                    s = GNODebugSettingsActivity.getTargetUrlOverride(s);
                    gnodrawer = s;
                    if (GNODebugSettingsActivity.isUrlToastEnabled().booleanValue())
                    {
                        Toast.makeText(amazonactivity.getApplicationContext(), s, 0).show();
                        gnodrawer = s;
                    }
                }
                AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.aiv_webview, Maps.of("url", gnodrawer, "forceClearHistory", Boolean.valueOf(false)));
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                context = context1;
                stringId = i;
                super();
                mRes = context.getResources();
            }
        };
    }

    private GNODrawerItemSimple.GNOItemOnClickListener navigateToUrlOnClick(final Context context, final int stringId)
    {
        return new GNODrawerItemSimple.GNOItemOnClickListener() {

            Resources res;
            final GNOMenuItemProviderDefault this$0;
            final Context val$context;
            final int val$stringId;

            public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
            {
                String s = res.getString(stringId);
                gnodrawer = s;
                if (DebugSettings.isDebugEnabled())
                {
                    s = GNODebugSettingsActivity.getTargetUrlOverride(s);
                    gnodrawer = s;
                    if (GNODebugSettingsActivity.isUrlToastEnabled().booleanValue())
                    {
                        Toast.makeText(amazonactivity.getApplicationContext(), s, 0).show();
                        gnodrawer = s;
                    }
                }
                AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.webview, Maps.of("url", gnodrawer));
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                context = context1;
                stringId = i;
                super();
                res = context.getResources();
            }
        };
    }

    public void buildDefaultMenuItems(final Context context)
    {
        mMenuItems = new LinkedHashMap();
        mMenuItems.put("mshop:home", GNODrawerItemSimple.builder(context, "mshop:home").withText(com.amazon.mShop.android.lib.R.string.home).withRefMarker("gno_hm").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.home)).build());
        mMenuItems.put("mshop:your_recently_viewed_items_post_5_0", GNODrawerItemSimple.builder(context, "mshop:your_recently_viewed_items_post_5_0").withText(com.amazon.mShop.android.lib.R.string.history_title).withRefMarker("gno_rvi").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.your_recently_viewed_items)).build());
        mMenuItems.put("mshop:shop_by_department", ((GNODrawerItemSBD.Builder)((GNODrawerItemSBD.Builder)((GNODrawerItemSBD.Builder)GNODrawerItemSBD.builder(context, "mshop:shop_by_department").withText(com.amazon.mShop.android.lib.R.string.shop_by_department_text)).withRefMarker("gno_br")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.shop_by_department))).build());
        mMenuItems.put("mshop:aiv", getAIVItem(context));
        mMenuItems.put("mshop:appstore", getAppstoreItem(context));
        mMenuItems.put("mshop:deals", ((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context, "mshop:deals").withText(com.amazon.mShop.android.lib.R.string.goldbox)).withRefMarker("gno_deal")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.deals))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;
            final Context val$context;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!ConfigUtils.isEnabled(context, com.amazon.mShop.android.lib.R.string.config_hasGoldbox))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                context = context1;
                super();
            }
        }).build());
        mMenuItems.put("mshop:gift_cards", ((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context, "mshop:gift_cards").withText(com.amazon.mShop.android.lib.R.string.more_email_gift_card)).withRefMarker("gno_gc")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.gift_cards))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;
            final Context val$context;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (Util.isEmpty(context.getResources().getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card)) || Util.isEmpty(context.getResources().getString(com.amazon.mShop.android.lib.R.string.more_email_gift_card_url)))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                context = context1;
                super();
            }
        }).build());
        Callable callable = new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!SmileHelper.isSmile())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        };
        mMenuItems.put("mshop:your_charity_header", ((GNODrawerItemSubHeaderHideable.Builder)GNODrawerItemSubHeaderHideable.builder(context, "mshop:your_charity_header").withText(com.amazon.mShop.android.lib.R.string.your_charity)).withIsHiddenCallable(callable).build());
        mMenuItems.put("mshop:your_charity", new GNODrawerItemCharity(context, "mshop:your_charity", callable));
        mMenuItems.put("mshop:your_account_sub_header", ((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context, "mshop:your_account_sub_header").withText(com.amazon.mShop.android.lib.R.string.youraccount)).build());
        mMenuItems.put("mshop:your_wish_list", GNODrawerItemSimple.builder(context, "mshop:your_wish_list").withText(com.amazon.mShop.android.lib.R.string.wishlist_default_title).withRefMarker("gno_wl").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.your_wish_list)).build());
        mMenuItems.put("mshop:your_orders", GNODrawerItemSimple.builder(context, "mshop:your_orders").withText(com.amazon.mShop.android.lib.R.string.youraccount_your_orders).withRefMarker("gno_yo").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.your_orders)).build());
        mMenuItems.put("mshop:your_account", GNODrawerItemSimple.builder(context, "mshop:your_account").withText(com.amazon.mShop.android.lib.R.string.youraccount).withRefMarker("gno_ta").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.your_account)).build());
        mMenuItems.put("mshop:your_recommendations", GNODrawerItemSimple.builder(context, "mshop:your_recommendations").withText(com.amazon.mShop.android.lib.R.string.recommendations_title).withRefMarker("gno_recs").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.your_recommendations)).build());
        mMenuItems.put("mshop:your_subscribe_and_save", ((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context, "mshop:your_subscribe_and_save").withText(com.amazon.mShop.android.lib.R.string.menu_more_mys_description)).withRefMarker("gno_sns")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.your_subscribe_and_save))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!ActivityUtils.isHTMLSnSEnabled())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        }).build());
        mMenuItems.put("mshop:cloud_drive", ((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context, "mshop:cloud_drive").withText(com.amazon.mShop.android.lib.R.string.ya_backup_your_photos)).withRefMarker("gno_cd")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.back_up_your_photos))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!CloudDriveAvailability.getInstance().isCloudDriveAvailable())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        }).build());
        mMenuItems.put("mshop:more_sub_header", ((GNODrawerItemSubHeader.Builder)GNODrawerItemSubHeader.builder(context, "mshop:more_sub_header").withText(com.amazon.mShop.android.lib.R.string.more)).build());
        mMenuItems.put("mshop:change_country", GNODrawerItemSimple.builder(context, "mshop:change_country").withText(com.amazon.mShop.android.lib.R.string.amazon_store).withRefMarker("gno_cc").withSubView(com.amazon.mShop.android.lib.R.layout.gno_drawer_item_flag).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.change_country)).build());
        mMenuItems.put("mshop:notifications", ((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context, "mshop:notifications").withText(com.amazon.mShop.android.lib.R.string.notification_setting)).withRefMarker("gno_notify")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.notifications))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!MShopPushNotificationUtils.isPushNotificationAvailable() || !MShopPushNotificationUtils.isMarketplaceSupportsNotification())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                super();
            }
        }).build());
        mMenuItems.put("mshop:contact_us", GNODrawerItemSimple.builder(context, "mshop:contact_us").withText(com.amazon.mShop.android.lib.R.string.contact_us_title).withRefMarker("gno_cu").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.contact_us)).build());
        mMenuItems.put("mshop:legal_with_aiv", GNODrawerItemSimple.builder(context, "mshop:legal_with_aiv").withText(com.amazon.mShop.android.lib.R.string.legal_info_text).withRefMarker("gno_legal").withListener(navigateToUrlOnClick(context, com.amazon.mShop.android.lib.R.string.legal_info_url_android_with_aiv)).build());
        mMenuItems.put("mshop:help", GNODrawerItemSimple.builder(context, "mshop:help").withText(com.amazon.mShop.android.lib.R.string.help_and_about_title).withRefMarker("gno_help").withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.help)).build());
        mMenuItems.put("mshop:authentication", new GNODrawerItemAuthentication(context));
        mMenuItems.put("mshop:exit", ((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)((GNODrawerItemHideable.Builder)GNODrawerItemHideable.builder(context, "mshop:exit").withText(com.amazon.mShop.android.lib.R.string.exit)).withRefMarker("gno_exit")).withListener(navigateOnClick(com.amazon.mShop.navigation.AppNavigator.Target.exit))).withIsHiddenCallable(new Callable() {

            final GNOMenuItemProviderDefault this$0;
            final Context val$context;

            public Boolean call()
                throws Exception
            {
                boolean flag;
                if (!ConfigUtils.isEnabled(context, com.amazon.mShop.android.lib.R.string.config_hasExitApp))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return Boolean.valueOf(flag);
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = GNOMenuItemProviderDefault.this;
                context = context1;
                super();
            }
        }).build());
    }

    public GNODrawerItem getItem(String s)
    {
        return (GNODrawerItem)mMenuItems.get(s);
    }

    public Collection getItems()
    {
        return mMenuItems.values();
    }
}
