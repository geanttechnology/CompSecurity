// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.models.country.Country;
import com.groupon.service.LoginService;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.sso.UserCredential;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.LoginUtil;
import com.groupon.view.SpinnerButton;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory, Login

public class GrouponSSO extends GrouponActivity
{

    private NewCartAbTestHelper cartAbTestHelper;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    String dealId;
    private IntentFactory intentFactory;
    Boolean isComingFromCheckout;
    private Logger logger;
    private LoginService loginService;
    private LoginUtil loginUtil;
    Intent next;
    String optionId;
    private SharedPreferences prefs;
    private ShoppingCartService shoppingCartService;
    boolean shouldGoToCarousel;
    SpinnerButton ssoSignInButton;
    SpinnerButton ssoSwitchUserButton;
    UserCredential userCredentialWrapper;
    TextView viewTerms;

    public GrouponSSO()
    {
    }

    private void startLogin()
    {
        final String username = userCredentialWrapper.getUsername();
        String s = userCredentialWrapper.getPassword();
        if (loginService.hasAccessToken() ^ loginService.hasFacebookSession() && !loginService.isLoggedInViaEmail())
        {
            loginService.logout();
        }
        if (isComingFromCheckout != null && isComingFromCheckout.booleanValue())
        {
            logger.logClick("", "signin_click", "checkout", dealId);
        }
        loginService.login(username, s, new Function0() {

            final GrouponSSO this$0;
            final String val$username;

            public void execute()
            {
                setResult(-1);
                prefs.edit().putString("emailPrefill", username).apply();
                refreshCachedCart();
                loginUtil.startNextActivity(next);
                finish();
                ssoSignInButton.stopSpinning();
            }

            
            {
                this$0 = GrouponSSO.this;
                username = s;
                super();
            }
        }, new Function1() {

            final GrouponSSO this$0;

            public void execute(Exception exception)
            {
                ssoSignInButton.stopSpinning();
                Toast.makeText(getApplicationContext(), getString(0x7f08017d, new Object[] {
                    countryUtil.getDisplayNameByIsoName(currentCountryManager.getCurrentCountry())
                }), 1).show();
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = GrouponSSO.this;
                super();
            }
        }, null);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 10142 && j == -1)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        if (shouldGoToCarousel && next != null)
        {
            startActivity(next);
            finish();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03012a);
        bundle = viewTerms;
        SpinnerButton spinnerbutton;
        String s;
        int i;
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            i = 0x7f080409;
        } else
        {
            i = 0x7f080408;
        }
        bundle.setText(Html.fromHtml(getString(i)));
        viewTerms.setMovementMethod(LinkMovementMethod.getInstance());
        bundle = userCredentialWrapper.getUserFullName();
        spinnerbutton = ssoSignInButton;
        s = getApplicationContext().getString(0x7f0800c4);
        if (Strings.isEmpty(bundle))
        {
            bundle = userCredentialWrapper.getUsername();
        }
        spinnerbutton.setText(String.format(s, new Object[] {
            bundle
        }));
        ssoSignInButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GrouponSSO this$0;

            public void onClick(View view)
            {
                ssoSignInButton.startSpinning();
                Logger logger1 = logger;
                String s1;
                if (isComingFromCheckout != null)
                {
                    view = "checkout";
                } else
                {
                    view = com/groupon/activity/Login.getSimpleName();
                }
                if (dealId != null)
                {
                    s1 = dealId;
                } else
                {
                    s1 = "";
                }
                logger1.logClick("", "sso_continue_click", view, s1);
                startLogin();
            }

            
            {
                this$0 = GrouponSSO.this;
                super();
            }
        });
        ssoSwitchUserButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GrouponSSO this$0;

            public void onClick(View view)
            {
                Logger logger1 = logger;
                String s1;
                if (isComingFromCheckout != null)
                {
                    view = "checkout";
                } else
                {
                    view = com/groupon/activity/GrouponSSO.getSimpleName();
                }
                if (dealId != null)
                {
                    s1 = dealId;
                } else
                {
                    s1 = "";
                }
                logger1.logClick("", "sso_switchuser_click", view, s1);
                startActivityForResult(intentFactory.newLoginIntent(GrouponSSO.this, next, dealId, optionId, isComingFromCheckout), 10142);
            }

            
            {
                this$0 = GrouponSSO.this;
                super();
            }
        });
        if (next != null)
        {
            next.setExtrasClassLoader(getClassLoader());
        }
    }

    protected void refreshCachedCart()
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && cartAbTestHelper.isShoppingCartEnabled())
        {
            shoppingCartService.refreshCachedCart();
        }
    }







}
