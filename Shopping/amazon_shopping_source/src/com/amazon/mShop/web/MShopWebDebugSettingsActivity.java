// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mash.AmazonMASHTestActivity;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.primeupsell.PrimeUpsellDebugSettingsActivity;
import com.amazon.mShop.social.SocialConnectDebugSettingsActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebDebugSwitchNativeVSHTMLRow, DebugHtmlSandboxSettingsActivity, WeinreDebugSettingsView

public class MShopWebDebugSettingsActivity extends AmazonActivity
    implements MShopWebDebugSwitchNativeVSHTMLRow.OnSelectionChangedListener
{

    private EditText mCancelOrderUrlEditText;
    private EditText mCartUrlEditText;
    private EditText mCheckOutUrlEditText;
    private EditText mContactUsUrlEditText;
    private EditText mDealsUrlEditText;
    private EditText mHTMLNotifications;
    private EditText mHtmlGatewaySetting;
    private EditText mHtmlRecommendationsEditText;
    private EditText mOneClickSetting;
    private EditText mOrdersDetailUrlEditText;
    private EditText mSNSDetailUrlEditText;
    private EditText mSNSMysUrlEditText;
    private EditText mUdpUrlEditText;
    private EditText mWishlistUrlEditText;
    private EditText mYourAccountUrlEditText;
    private EditText mYourOrdersUrlEditText;

    public MShopWebDebugSettingsActivity()
    {
    }

    private MShopWebDebugSwitchNativeVSHTMLRow createFeatureItem(int i, String s)
    {
        MShopWebDebugSwitchNativeVSHTMLRow mshopwebdebugswitchnativevshtmlrow = (MShopWebDebugSwitchNativeVSHTMLRow)View.inflate(this, com.amazon.mShop.android.lib.R.layout.debug_switch_native_vs_html_row, null);
        mshopwebdebugswitchnativevshtmlrow.setFeatureName(getString(i));
        mshopwebdebugswitchnativevshtmlrow.setFeatureKey(s);
        mshopwebdebugswitchnativevshtmlrow.setSelectedFeatureValue(getSetting(s));
        mshopwebdebugswitchnativevshtmlrow.setOnSelectionChangeListener(this);
        return mshopwebdebugswitchnativevshtmlrow;
    }

    private View getDebugSettingsEntryView()
    {
        View view = View.inflate(this, com.amazon.mShop.android.lib.R.layout.web_debug_settings_entry, null);
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.html_sandbox_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                view1 = ActivityUtils.getStartActivityIntent(MShopWebDebugSettingsActivity.this, com/amazon/mShop/web/DebugHtmlSandboxSettingsActivity, -1);
                startActivity(view1);
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.html_feature_env_debug_settings_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                pushView(getHTMLFeatureEnvSettingsView());
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.weinre_debug_settings_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                pushView(new WeinreDebugSettingsView(MShopWebDebugSettingsActivity.this, null));
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.mash_api_test_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                view1 = ActivityUtils.getStartActivityIntent(MShopWebDebugSettingsActivity.this, com/amazon/mShop/mash/AmazonMASHTestActivity, -1);
                startActivity(view1);
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.prime_upsell_settings_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                view1 = ActivityUtils.getStartActivityIntent(MShopWebDebugSettingsActivity.this, com/amazon/mShop/primeupsell/PrimeUpsellDebugSettingsActivity, -1);
                startActivity(view1);
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.social_connect_settings_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                view1 = ActivityUtils.getStartActivityIntent(MShopWebDebugSettingsActivity.this, com/amazon/mShop/social/SocialConnectDebugSettingsActivity, -1);
                startActivity(view1);
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        return view;
    }

    private View getHTMLFeatureEnvSettingsView()
    {
        View view = View.inflate(this, com.amazon.mShop.android.lib.R.layout.web_debug_settings, null);
        TableLayout tablelayout = (TableLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.debug_settings_feature_version_switch_table);
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_spinner_control, "debugSpinnerDismissLogicSwitch"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_flow, "switchFlow"));
        tablelayout = (TableLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.debug_settings_feature_switch_table);
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_contact_us_switch_setting, "switchContactUs"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.check_out_debug_switch, "switchCheckOut"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_cart, "switchCart"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_one_click_setting, "switchOneClickSetting"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_gateway, "debugHTMLGateway"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_block_http, "debugShouldBlockHttp"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_html_notifications, "DEBUG_SWITCH_NOTIFICATIONS_PAGE"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_html_recommendations, "switchRecommendations"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_amazon_smile, "smile"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.deals_debug_title, "switchDeals"));
        tablelayout.addView(createFeatureItem(com.amazon.mShop.android.lib.R.string.debug_enable_sns_in_ca, "debugEnableSnSInCA"));
        mSNSDetailUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.sns_detail_url_edit_text);
        mSNSMysUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.sns_mys_url_edit_text);
        mCartUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.cart_url_edit_text);
        mDealsUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.deals_url_edit_text);
        mWishlistUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.wishlist_url_edit_text);
        mUdpUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.udp_url_edit_text);
        mContactUsUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.debug_contact_us_url_edit_text);
        mCheckOutUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.checkout_url_edit_text);
        mOneClickSetting = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.one_click_setting_url_edit_text);
        mHtmlGatewaySetting = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.html_gateway_setting_url_edit_text);
        mYourAccountUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.your_account_url_edit_text);
        mYourOrdersUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.your_orders_url_edit_text);
        mOrdersDetailUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.order_detail_url_edit_text);
        mCancelOrderUrlEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.cancel_order_url_edit_text);
        mSNSDetailUrlEditText.setText(getSetting("currentSnsDetail", com.amazon.mShop.android.lib.R.string.sns_detail_webpage));
        mSNSMysUrlEditText.setText(getSetting("currentSnsMys", com.amazon.mShop.android.lib.R.string.sns_mys_page));
        mCartUrlEditText.setText(getSetting("currentCart", com.amazon.mShop.android.lib.R.string.web_cart_page));
        mUdpUrlEditText.setText(getSetting("currentUdpUrl", com.amazon.mShop.android.lib.R.string.product_details_web_page_url));
        mDealsUrlEditText.setText(getSetting("currentDealsUrl", com.amazon.mShop.android.lib.R.string.deals_web_page_url));
        mWishlistUrlEditText.setText(getSetting("currentWishlistUrl", com.amazon.mShop.android.lib.R.string.wishlist_web_page_url));
        mContactUsUrlEditText.setText(getSetting("currentContactUsUrl", com.amazon.mShop.android.lib.R.string.contact_us_web_page_url));
        mCheckOutUrlEditText.setText(getSetting("currentCheckOutUrl", com.amazon.mShop.android.lib.R.string.web_check_out));
        mYourAccountUrlEditText.setText(getSetting("currentYourAccountUrl", com.amazon.mShop.android.lib.R.string.your_account_web_page_url));
        mYourOrdersUrlEditText.setText(getSetting("currentYourOrdersUrl", com.amazon.mShop.android.lib.R.string.your_orders_web_page_url));
        mOrdersDetailUrlEditText.setText(getSetting("currentOrderDetailUrl", com.amazon.mShop.android.lib.R.string.order_detail_web_page_url));
        mCancelOrderUrlEditText.setText(getSetting("currentCancelOrderUrl", com.amazon.mShop.android.lib.R.string.cancel_order_web_page_url));
        mOneClickSetting.setText(getSetting("currentOneClickSettingUrl", com.amazon.mShop.android.lib.R.string.one_click_settings_web_page_url));
        mHtmlGatewaySetting.setText(getSetting("currentGatewayUrl", com.amazon.mShop.android.lib.R.string.gateway_web_page_url));
        mHTMLNotifications = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.html_notifications_setting_url_edit_text);
        mHTMLNotifications.setText(getSetting("CURRENT_HTML_NOTIFICATIONS_SETTING_DEBUG_URL", com.amazon.mShop.android.lib.R.string.html_notifications_settings_web_page_url));
        mHtmlRecommendationsEditText = (EditText)view.findViewById(com.amazon.mShop.android.lib.R.id.html_recommendations_setting_url_edit_text);
        mHtmlRecommendationsEditText.setText(getSetting("currentRecommendationsUrl", com.amazon.mShop.android.lib.R.string.html_recommendations_web_page_url));
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.set_new_sns_service_url_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final MShopWebDebugSettingsActivity this$0;

            public void onClick(View view1)
            {
                recordEditedSettings();
                AppUtils.restartApp();
            }

            
            {
                this$0 = MShopWebDebugSettingsActivity.this;
                super();
            }
        });
        return view;
    }

    private String getSetting(String s)
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString(s);
    }

    private String getSetting(String s, int i)
    {
        String s1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString(s);
        s = s1;
        if (Util.isEmpty(s1))
        {
            s = getResources().getString(i);
        }
        return s;
    }

    private void recordEditedSettings()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("currentSnsDetail", mSNSDetailUrlEditText);
        hashmap.put("currentSnsMys", mSNSMysUrlEditText);
        hashmap.put("currentCart", mCartUrlEditText);
        hashmap.put("currentUdpUrl", mUdpUrlEditText);
        hashmap.put("currentWishlistUrl", mWishlistUrlEditText);
        hashmap.put("currentContactUsUrl", mContactUsUrlEditText);
        hashmap.put("currentDealsUrl", mDealsUrlEditText);
        hashmap.put("currentCheckOutUrl", mCheckOutUrlEditText);
        hashmap.put("currentOneClickSettingUrl", mOneClickSetting);
        hashmap.put("currentGatewayUrl", mHtmlGatewaySetting);
        hashmap.put("CURRENT_HTML_NOTIFICATIONS_SETTING_DEBUG_URL", mHTMLNotifications);
        hashmap.put("currentYourAccountUrl", mYourAccountUrlEditText);
        hashmap.put("currentYourOrdersUrl", mYourOrdersUrlEditText);
        hashmap.put("currentOrderDetailUrl", mOrdersDetailUrlEditText);
        hashmap.put("currentCancelOrderUrl", mCancelOrderUrlEditText);
        hashmap.put("currentRecommendationsUrl", mHtmlRecommendationsEditText);
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            EditText edittext = (EditText)hashmap.get(s);
            if (edittext != null)
            {
                saveEditSetting(s, edittext.getText().toString().trim());
            }
        } while (true);
    }

    private void saveEditSetting(String s, String s1)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString(s, s1);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pushView(getDebugSettingsEntryView());
    }

    public void onSelectionChanged(String s, String s1)
    {
        saveEditSetting(s1, s);
    }


}
