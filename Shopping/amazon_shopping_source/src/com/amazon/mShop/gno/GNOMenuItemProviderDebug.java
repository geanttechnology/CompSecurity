// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import amazon.android.dexload.SupplementalDexLoader;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.debug.DebugSettingsActivity;
import com.amazon.mShop.kiang.KiangDebugSettingsActivity;
import com.amazon.mShop.mobileads.DebugSettingsActivityForAds;
import com.amazon.mShop.search.SearchDebugSettingsActivity;
import com.amazon.mShop.sso.SSODebugSettingsActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.DebugUtil;
import com.amazon.mShop.web.MShopWebDebugSettingsActivity;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProvider, GNODrawerItemGroup, GNODrawerItemSimple, GNODebugSettingsActivity, 
//            GNODrawerItem, GNODrawer

public class GNOMenuItemProviderDebug extends GNOMenuItemProvider
{

    private Map mMenuItems;

    public GNOMenuItemProviderDebug(Context context)
    {
        buildItems(context);
    }

    private void buildItems(Context context)
    {
        mMenuItems = new LinkedHashMap();
        if (DebugSettings.isDebugEnabled())
        {
            mMenuItems.put("android:debug", ((GNODrawerItemGroup.Builder)((GNODrawerItemGroup.Builder)GNODrawerItemGroup.builder(context, "android:debug").withText(com.amazon.mShop.android.lib.R.string.debug_title)).withListener(startActivity(com/amazon/mShop/debug/DebugSettingsActivity))).withChild(GNODrawerItemSimple.builder(context, "android:debug/ads_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.debug_mobile_ads_title).withListener(startActivity(com/amazon/mShop/mobileads/DebugSettingsActivityForAds)).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/amazon_web_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.menu_more_html_debug_settings).withListener(startActivity(com/amazon/mShop/web/MShopWebDebugSettingsActivity)).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/weblab_overrides").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.menu_more_set_weblab).withListener(new GNODrawerItemSimple.GNOItemOnClickListener() {

                final GNOMenuItemProviderDebug this$0;

                public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
                {
                    DebugUtil.overrideWeblabAssignment(amazonactivity);
                }

            
            {
                this$0 = GNOMenuItemProviderDebug.this;
                super();
            }
            }).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/gno_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.debug_gno_settings).withListener(startActivity(com/amazon/mShop/gno/GNODebugSettingsActivity)).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/sso_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.sso_debug_settings_title).withListener(startActivity(com/amazon/mShop/sso/SSODebugSettingsActivity)).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/appstore_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText("MAS Debug").withListener(new GNODrawerItemSimple.GNOItemOnClickListener() {

                final GNOMenuItemProviderDebug this$0;

                public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
                {
                    SupplementalDexLoader.getInstance().waitForLoad();
                    amazonactivity.startActivity(new Intent(amazonactivity, SupplementalDexLoader.getInstance().loadClass("com.amazon.venezia.web.BaseUrlOverrideActivity")));
                }

            
            {
                this$0 = GNOMenuItemProviderDebug.this;
                super();
            }
            }).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/search_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.search_debug_menu_title).withListener(startActivity(com/amazon/mShop/search/SearchDebugSettingsActivity)).build()).withChild(GNODrawerItemSimple.builder(context, "android:debug/kiang_debug").withType(GNODrawerItem.Type.SUB_ITEM).withText(com.amazon.mShop.android.lib.R.string.debug_kiang_settings).withListener(startActivity(com/amazon/mShop/kiang/KiangDebugSettingsActivity)).build()).build());
        }
    }

    private static GNODrawerItemSimple.GNOItemOnClickListener startActivity(Class class1)
    {
        return new GNODrawerItemSimple.GNOItemOnClickListener(class1) {

            final Class val$clazz;

            public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
            {
                amazonactivity.startActivity(ActivityUtils.getStartActivityIntent(amazonactivity, clazz, -1));
            }

            
            {
                clazz = class1;
                super();
            }
        };
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
