// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.PaymentSession;
import com.ebay.common.net.api.cart.EbayCartApi;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.checkout:
//            CheckoutError

public final class PayPalActivity extends ModalActivity
{
    private class PayPalWebViewClient extends WebViewClient
    {

        ScrollView scrollView;
        final PayPalActivity this$0;

        public void onPageFinished(WebView webview, String s)
        {
            if (isFinishing())
            {
                return;
            }
            if (CheckoutError.logCheckout.isLoggable)
            {
                CheckoutError.logCheckout.log("page finished");
            }
            if (loadingDialog != null && loadingDialog.isShowing())
            {
                loadingDialog.dismiss();
                loadingDialog = null;
            }
            scrollView.scrollTo(0, 0);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            if (isFinishing())
            {
                return;
            }
            if (CheckoutError.logCheckout.isLoggable)
            {
                CheckoutError.logCheckout.log((new StringBuilder()).append("page start: ").append(s).toString());
            }
            boolean flag2 = true;
            boolean flag1 = false;
            byte byte0 = flag2;
            boolean flag = flag1;
            if (s != null)
            {
                if (s.contains("wap.ebay.com/returnurl?"))
                {
                    if (guestXO)
                    {
                        byte0 = 4;
                        flag = flag1;
                    } else
                    {
                        byte0 = 3;
                        flag = flag1;
                    }
                } else
                if (s.contains("wap.ebay.com/cancelurl?") || s.contains("&cancel.x") || s.contains("_wapapp-logout") || s.contains("ebay.com"))
                {
                    byte0 = 0;
                    flag = flag1;
                } else
                if (s.contains("&logout_json=true"))
                {
                    flag = true;
                    byte0 = 2;
                    removeSessionCookies();
                } else
                {
                    byte0 = flag2;
                    flag = flag1;
                    if (s.contains("&op=prepjson"))
                    {
                        flag = true;
                        PayPalActivity paypalactivity = PayPalActivity.this;
                        boolean flag3;
                        if (s.contains("&guest_xo="))
                        {
                            flag3 = true;
                        } else
                        {
                            flag3 = false;
                        }
                        paypalactivity.guestXO = flag3;
                        if (guestXO)
                        {
                            byte0 = 4;
                        } else
                        {
                            byte0 = 3;
                        }
                    }
                }
            }
            if (flag)
            {
                webView.stopLoading();
            }
            if (byte0 != 1)
            {
                finish(byte0, s);
                return;
            } else
            {
                super.onPageStarted(webview, s, bitmap);
                return;
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            Log.e("PayPalActivity", (new StringBuilder()).append((new Exception()).getStackTrace()[0].getMethodName()).append(": errorCode = <").append(i).append(">").append(": description = <").append(s).append(">").append(": failingUrl = <").append(s1).append(">").toString());
            dialogManager.showDynamicAlertDialog(null, s, true);
            finish(0, null);
        }

        PayPalWebViewClient()
        {
            this$0 = PayPalActivity.this;
            super();
            scrollView = (ScrollView)findViewById(0x7f1004ac);
        }
    }

    private class PayPalWebViewOnTouchListener
        implements android.view.View.OnTouchListener
    {

        final PayPalActivity this$0;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            motionevent.getAction();
            JVM INSTR tableswitch 0 1: default 28
        //                       0 30
        //                       1 30;
               goto _L1 _L2 _L2
_L1:
            return false;
_L2:
            if (!view.hasFocus())
            {
                view.requestFocus();
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        private PayPalWebViewOnTouchListener()
        {
            this$0 = PayPalActivity.this;
            super();
        }

    }


    static final String EXTRA_GUEST_XO = "guestXO";
    static final String EXTRA_PP_APP_ID = "app_id";
    static final String EXTRA_PP_FS_ID = "fs_id";
    static final String EXTRA_PP_RISK_PAYLOAD = "risk_payload";
    static final String EXTRA_PP_RM_TOKEN = "rm_token";
    static final String EXTRA_PP_SESSION_ID = "session_id";
    static final String EXTRA_PP_VISITOR_ID = "visitor_id";
    static final String EXTRA_URL = "url";
    public static final int RESULT_AUTHENTICATED = 3;
    public static final int RESULT_GUEST_XO = 4;
    public static final int RESULT_LOGOUT = 2;
    public static final int RESULT_NONE = 1;
    private static final String TAG = "PayPalActivity";
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    boolean guestXO;
    EbayCartApi handle;
    ProgressDialog loadingDialog;
    WebView webView;

    public PayPalActivity()
    {
    }

    private void finish(int i, String s)
    {
        webView.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("guestXO", getIntent().getBooleanExtra("guestXO", false));
        if (!TextUtils.isEmpty(s))
        {
            intent.putExtra("url", PaymentSession.shortCircuitRedirect(s));
        }
        setResult(i, intent);
        finish();
    }

    private void removeSessionCookies()
    {
        CookieManager.getInstance().removeSessionCookie();
        CookieSyncManager.getInstance().sync();
    }

    protected void createUI(boolean flag)
    {
        setContentView(0x7f030197);
        Object obj = DeviceConfiguration.getAsync();
        if (((DeviceConfiguration) (obj)).get(DcsBoolean.MecGuestXo))
        {
            if (flag)
            {
                if (((DeviceConfiguration) (obj)).get(DcsBoolean.MecBankTransfer))
                {
                    setTitle(0x7f070c62);
                } else
                {
                    setTitle(0x7f070c63);
                }
            } else
            {
                setTitle(0x7f070c64);
            }
        }
        webView = (WebView)findViewById(0x7f1004ad);
        webView.setFocusable(true);
        webView.requestFocus(130);
        webView.setOnTouchListener(new PayPalWebViewOnTouchListener());
        obj = webView.getSettings();
        ((WebSettings) (obj)).setLoadsImagesAutomatically(true);
        ((WebSettings) (obj)).setJavaScriptCanOpenWindowsAutomatically(true);
        ((WebSettings) (obj)).setSupportZoom(true);
        ((WebSettings) (obj)).setBuiltInZoomControls(true);
        ((WebSettings) (obj)).setDisplayZoomControls(false);
        ((WebSettings) (obj)).setLoadWithOverviewMode(true);
        ((WebSettings) (obj)).setUseWideViewPort(true);
        ((WebSettings) (obj)).setJavaScriptEnabled(false);
        webView.setWebViewClient(new PayPalWebViewClient());
        ((WebSettings) (obj)).setUserAgentString(handle.payPalUserAgent());
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
    }

    public void onBackPressed()
    {
        setResult(0);
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = MyApp.getPrefs().getAuthentication();
        if (bundle == null)
        {
            finish();
        } else
        {
            handle = EbayApiUtil.getCartApi(this, bundle);
            bundle = getIntent();
            guestXO = bundle.getBooleanExtra("guestXO", false);
            createUI(guestXO);
            loadingDialog = ProgressDialog.show(this, "", getString(0x7f070c5a), true);
            CookieSyncManager.createInstance(this);
            if (guestXO)
            {
                removeSessionCookies();
            }
            bundle = Uri.parse(bundle.getStringExtra("url")).buildUpon();
            bundle.appendQueryParameter("showTopPanel", "false");
            Intent intent = getIntent();
            HashMap hashmap = new HashMap();
            if (intent.hasExtra("app_id"))
            {
                hashmap.put("x-paypal-app-id", intent.getStringExtra("app_id"));
            }
            if (intent.hasExtra("rm_token"))
            {
                hashmap.put("x-paypal-rm-token", intent.getStringExtra("rm_token"));
            }
            if (intent.hasExtra("visitor_id"))
            {
                hashmap.put("x-paypal-visitor-id", intent.getStringExtra("visitor_id"));
            }
            if (intent.hasExtra("session_id"))
            {
                hashmap.put("x-paypal-session-id", intent.getStringExtra("session_id"));
            }
            if (intent.hasExtra("fs_id"))
            {
                hashmap.put("x-paypal-fs-id", intent.getStringExtra("fs_id"));
            }
            if (intent.hasExtra("risk_payload"))
            {
                hashmap.put("x-paypal-dyson-data", intent.getStringExtra("risk_payload"));
            }
            webView.loadUrl(bundle.build().toString(), hashmap);
        }
        hideCloseButton();
        showBackButton();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (loadingDialog != null && loadingDialog.isShowing())
        {
            loadingDialog.dismiss();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            setResult(0);
        }
        return super.onOptionsItemSelected(menuitem);
    }

    protected void onPause()
    {
        CookieSyncManager.getInstance().stopSync();
        super.onPause();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }

    protected void onResume()
    {
        CookieSyncManager.getInstance().startSync();
        super.onResume();
    }


}
