// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.ofw;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.sponsorpay.SponsorPay;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.HostInfo;
import com.sponsorpay.utils.SponsorPayBaseUrlProvider;
import com.sponsorpay.utils.SponsorPayLogger;
import com.sponsorpay.utils.StringUtils;
import com.sponsorpay.utils.UrlBuilder;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.publisher.ofw:
//            ActivityOfferWebClient

public class SPOfferWallActivity extends Activity
{

    private static final String APPID_KEY = "app.id.key";
    public static final String EXTRA_CREDENTIALS_TOKEN_KEY = "EXTRA_CREDENTIALS_TOKEN_KEY";
    public static final String EXTRA_CURRENCY_NAME_KEY = "EXTRA_CURRENCY_NAME_KEY";
    public static final String EXTRA_KEYS_VALUES_MAP_KEY = "EXTRA_KEY_VALUES_MAP";
    public static final String EXTRA_SHOULD_STAY_OPEN_KEY = "EXTRA_SHOULD_REMAIN_OPEN_KEY";
    private static final String OFW_URL_KEY = "ofw";
    public static final int RESULT_CODE_NO_STATUS_CODE = -10;
    private static final String SECURITY_TOKEN_KEY = "security.token.key";
    private static final String UID_KEY = "user.id.key";
    private ActivityOfferWebClient mActivityOfferWebClient;
    private SPCredentials mCredentials;
    private String mCurrencyName;
    protected Map mCustomKeysValues;
    private AlertDialog mErrorDialog;
    private ProgressDialog mProgressDialog;
    private boolean mShouldStayOpen;
    protected WebView mWebView;

    public SPOfferWallActivity()
    {
    }

    private String buildUrl()
    {
        return UrlBuilder.newBuilder(SponsorPayBaseUrlProvider.getBaseUrl("ofw"), mCredentials).setCurrency(mCurrencyName).addExtraKeysValues(mCustomKeysValues).addScreenMetrics().buildUrl();
    }

    private void deleteCredentialsValues()
    {
        android.content.SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.clear();
        editor.commit();
    }

    private void restoreCredentialsValues()
    {
        SharedPreferences sharedpreferences = getPreferences(0);
        SponsorPay.start(sharedpreferences.getString("app.id.key", ""), sharedpreferences.getString("user.id.key", ""), sharedpreferences.getString("security.token.key", ""), this);
        mCredentials = SponsorPay.getCurrentCredentials();
    }

    private void storeCrendentialsValues()
    {
        android.content.SharedPreferences.Editor editor = getPreferences(0).edit();
        editor.putString("app.id.key", mCredentials.getAppId());
        editor.putString("user.id.key", mCredentials.getUserId());
        editor.putString("security.token.key", mCredentials.getSecurityToken());
        editor.commit();
    }

    protected void fetchPassedExtras()
    {
        Object obj = getIntent().getStringExtra("EXTRA_CREDENTIALS_TOKEN_KEY");
        try
        {
            mCredentials = SponsorPay.getCredentials(((String) (obj)));
        }
        catch (RuntimeException runtimeexception)
        {
            restoreCredentialsValues();
            deleteCredentialsValues();
        }
        mShouldStayOpen = getIntent().getBooleanExtra("EXTRA_SHOULD_REMAIN_OPEN_KEY", shouldStayOpenByDefault());
        obj = getIntent().getSerializableExtra("EXTRA_KEY_VALUES_MAP");
        if (obj instanceof HashMap)
        {
            mCustomKeysValues = (HashMap)obj;
        }
        obj = getIntent().getStringExtra("EXTRA_CURRENCY_NAME_KEY");
        if (StringUtils.notNullNorEmpty(((String) (obj))))
        {
            mCurrencyName = ((String) (obj));
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (HostInfo.isDeviceSupported())
        {
            getWindow().requestFeature(1);
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setOwnerActivity(this);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.LOADING_OFFERWALL));
            mProgressDialog.show();
            fetchPassedExtras();
            mWebView = new WebView(getApplicationContext());
            mWebView.setScrollBarStyle(0);
            setContentView(mWebView);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setPluginsEnabled(true);
            mActivityOfferWebClient = new ActivityOfferWebClient(this, mShouldStayOpen);
            mWebView.setWebViewClient(mActivityOfferWebClient);
            mWebView.setWebChromeClient(new WebChromeClient() {

                final SPOfferWallActivity this$0;

                public void onProgressChanged(WebView webview, int i)
                {
                    if (i > 50 && mProgressDialog != null)
                    {
                        mProgressDialog.dismiss();
                        mProgressDialog = null;
                    }
                    super.onProgressChanged(webview, i);
                }

            
            {
                this$0 = SPOfferWallActivity.this;
                super();
            }
            });
            return;
        } else
        {
            setResult(-20);
            finish();
            return;
        }
    }

    protected void onPause()
    {
        if (mErrorDialog != null)
        {
            mErrorDialog.dismiss();
            mErrorDialog = null;
        }
        if (mProgressDialog != null)
        {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        storeCrendentialsValues();
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            String s = buildUrl();
            SponsorPayLogger.d(getClass().getSimpleName(), (new StringBuilder("Offerwall request url: ")).append(s).toString());
            mWebView.loadUrl(s);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            SponsorPayLogger.e(getClass().getSimpleName(), "An exception occurred when launching the Offer Wall", runtimeexception);
            mActivityOfferWebClient.showDialog(runtimeexception.getMessage());
            return;
        }
    }

    public boolean shouldStayOpenByDefault()
    {
        return true;
    }


}
