// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.TextUtils;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, IdentityType, DistributedSSOLoginActivity, MShopCheckLogin

public class SSOSplashScreenView extends ScrollView
{

    private AmazonActivity mActivity;
    private TextView mConditionsOfUse;
    private Button mContinueUseApp;
    private TextView mCookiesAndInternetAdvertising;
    private TextView mExplicitAccept;
    private TextView mPrivacyNotice;
    private Button mUseDifferentAccount;
    private TextView mWelcomeUser;

    public SSOSplashScreenView(Context context)
    {
        super(context);
        mActivity = (AmazonActivity)context;
        addView((ViewGroup)LayoutInflater.from(context).inflate(com.amazon.mShop.android.lib.R.layout.sso_splash_screen, null));
        initSplashScreen();
    }

    private void handleLinkTextAction(String s, String s1)
    {
        mActivity.pushView(new AmazonBrandedWebView(mActivity, s, s1, true));
    }

    private void initSplashScreen()
    {
        mWelcomeUser = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.sso_welcome);
        mContinueUseApp = (Button)findViewById(com.amazon.mShop.android.lib.R.id.sso_continue);
        mExplicitAccept = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.sso_explicit_accept);
        mUseDifferentAccount = (Button)findViewById(com.amazon.mShop.android.lib.R.id.sso_use_different_account);
        mConditionsOfUse = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.sso_conditions_of_use);
        mPrivacyNotice = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.sso_privacy_notice);
        mCookiesAndInternetAdvertising = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.sso_cookies_and_internet_advertising);
        String s = SSOUtil.peekCustomerAttribute(getContext(), "com.amazon.dcp.sso.property.username");
        s = getContext().getString(com.amazon.mShop.android.lib.R.string.sso_welcome_user, new Object[] {
            s
        });
        mWelcomeUser.setText(s);
        mContinueUseApp.setOnClickListener(new android.view.View.OnClickListener() {

            final SSOSplashScreenView this$0;

            public void onClick(View view)
            {
                mActivity.finish();
                if (SSOUtil.isAppstoreInstalledWithSpecificVersion(mActivity))
                {
                    RefMarkerObserver.logRefMarker("sso_wl_continue_wappstore");
                    return;
                } else
                {
                    RefMarkerObserver.logRefMarker("sso_wl_continue");
                    return;
                }
            }

            
            {
                this$0 = SSOSplashScreenView.this;
                super();
            }
        });
        if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasAppstore))
        {
            String s1 = getResources().getString(com.amazon.mShop.android.lib.R.string.sso_explicit_accept_text);
            mExplicitAccept.setText(TextUtils.fromHtmlToSpannedUsingEmbeddedBrowser(s1, false));
            mExplicitAccept.setMovementMethod(LinkMovementMethod.getInstance());
        } else
        {
            mExplicitAccept.setVisibility(8);
        }
        mUseDifferentAccount.setOnClickListener(new android.view.View.OnClickListener() {

            final SSOSplashScreenView this$0;

            public void onClick(View view)
            {
                mActivity.finish();
                view = new Intent(mActivity, com/amazon/mShop/sso/DistributedSSOLoginActivity);
                view.putExtra("force_signin", true);
                mActivity.startActivity(view);
                if (SSOUtil.isAppstoreInstalledWithSpecificVersion(mActivity))
                {
                    RefMarkerObserver.logRefMarker("sso_wl_switch_account_wappstore");
                } else
                {
                    RefMarkerObserver.logRefMarker("sso_wl_switch_account");
                }
                MShopCheckLogin.savePendingNotification(null);
            }

            
            {
                this$0 = SSOSplashScreenView.this;
                super();
            }
        });
        mConditionsOfUse.setOnClickListener(new android.view.View.OnClickListener() {

            final SSOSplashScreenView this$0;

            public void onClick(View view)
            {
                view = mActivity.getString(com.amazon.mShop.android.lib.R.string.sso_conditions_of_use_link_url);
                String s2 = mActivity.getString(com.amazon.mShop.android.lib.R.string.sso_conditions_of_use);
                handleLinkTextAction(view, s2);
            }

            
            {
                this$0 = SSOSplashScreenView.this;
                super();
            }
        });
        mPrivacyNotice.setOnClickListener(new android.view.View.OnClickListener() {

            final SSOSplashScreenView this$0;

            public void onClick(View view)
            {
                view = mActivity.getString(com.amazon.mShop.android.lib.R.string.sso_privacy_notice_link_url);
                String s2 = mActivity.getString(com.amazon.mShop.android.lib.R.string.sso_privacy_notice);
                handleLinkTextAction(view, s2);
            }

            
            {
                this$0 = SSOSplashScreenView.this;
                super();
            }
        });
        if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_need_cookie_terms))
        {
            mCookiesAndInternetAdvertising.setOnClickListener(new android.view.View.OnClickListener() {

                final SSOSplashScreenView this$0;

                public void onClick(View view)
                {
                    view = mActivity.getString(com.amazon.mShop.android.lib.R.string.sso_cookies_and_internet_advertising_url);
                    String s2 = mActivity.getString(com.amazon.mShop.android.lib.R.string.sso_cookies_and_internet_advertising);
                    handleLinkTextAction(view, s2);
                }

            
            {
                this$0 = SSOSplashScreenView.this;
                super();
            }
            });
        } else
        {
            mCookiesAndInternetAdvertising.setVisibility(8);
        }
        if (IdentityType.CENTRAL_SSO_TYPE == SSOUtil.getCurrentIdentityType())
        {
            findViewById(com.amazon.mShop.android.lib.R.id.sso_not_the_user_layout_group).setVisibility(4);
            mUseDifferentAccount.setVisibility(4);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }


}
