// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.view.LoadingBar;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;
import java.lang.reflect.Method;

// Referenced classes of package com.sina.weibo.sdk.component:
//            BrowserRequestCallBack, WeiboCallbackManager, BrowserLauncher, AuthRequestParam, 
//            ShareRequestParam, WidgetRequestParam, GameRequestParam, BrowserRequestParamBase, 
//            AuthWeiboWebViewClient, WeiboWebViewClient, ShareWeiboWebViewClient, WeiboGameClient, 
//            WidgetWeiboWebViewClient

public class WeiboSdkBrowser extends Activity
    implements BrowserRequestCallBack
{

    public static final String BROWSER_CLOSE_SCHEME = "sinaweibo://browser/close";
    public static final String BROWSER_WIDGET_SCHEME = "sinaweibo://browser/datatransfer";
    private static final String CANCEL_EN = "Close";
    private static final String CANCEL_ZH_CN = "\u5173\u95ED";
    private static final String CANCEL_ZH_TW = "\u5173\u95ED";
    private static final String CHANNEL_DATA_ERROR_EN = "channel_data_error";
    private static final String CHANNEL_DATA_ERROR_ZH_CN = "\u91CD\u65B0\u52A0\u8F7D";
    private static final String CHANNEL_DATA_ERROR_ZH_TW = "\u91CD\u65B0\u8F09\u5165";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_EN = "A network error occurs, please tap the button to reload";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_CN = "\u7F51\u7EDC\u51FA\u9519\u5566\uFF0C\u8BF7\u70B9\u51FB\u6309\u94AE\u91CD\u65B0\u52A0\u8F7D";
    private static final String EMPTY_PROMPT_BAD_NETWORK_UI_ZH_TW = "\u7DB2\u8DEF\u51FA\u932F\u5566\uFF0C\u8ACB\u9EDE\u64CA\u6309\u9215\u91CD\u65B0\u8F09\u5165";
    private static final String LOADINFO_EN = "Loading....";
    private static final String LOADINFO_ZH_CN = "\u52A0\u8F7D\u4E2D....";
    private static final String LOADINFO_ZH_TW = "\u8F09\u5165\u4E2D....";
    private static final String TAG = com/sina/weibo/sdk/component/WeiboSdkBrowser.getName();
    private static final String WEIBOBROWSER_NO_TITLE_EN = "No Title";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_CN = "\u65E0\u6807\u9898";
    private static final String WEIBOBROWSER_NO_TITLE_ZH_TW = "\u7121\u6A19\u984C";
    private boolean isErrorPage;
    private Boolean isFromGame;
    private boolean isLoading;
    private String mHtmlTitle;
    private TextView mLeftBtn;
    private Button mLoadErrorRetryBtn;
    private LinearLayout mLoadErrorView;
    private LoadingBar mLoadingBar;
    private BrowserRequestParamBase mRequestParam;
    private String mSpecifyTitle;
    private TextView mTitleText;
    private String mUrl;
    private WebView mWebView;
    private WeiboWebViewClient mWeiboWebViewClient;

    public WeiboSdkBrowser()
    {
        isFromGame = Boolean.valueOf(false);
    }

    public static void closeBrowser(Activity activity, String s, String s1)
    {
        WeiboCallbackManager weibocallbackmanager = WeiboCallbackManager.getInstance(activity.getApplicationContext());
        if (!TextUtils.isEmpty(s))
        {
            weibocallbackmanager.removeWeiboAuthListener(s);
            activity.finish();
        }
        if (!TextUtils.isEmpty(s1))
        {
            weibocallbackmanager.removeWidgetRequestCallback(s1);
            activity.finish();
        }
    }

    private BrowserRequestParamBase createBrowserRequestParam(Bundle bundle)
    {
        isFromGame = Boolean.valueOf(false);
        Object obj = (BrowserLauncher)bundle.getSerializable("key_launcher");
        if (obj == BrowserLauncher.AUTH)
        {
            obj = new AuthRequestParam(this);
            ((AuthRequestParam) (obj)).setupRequestParam(bundle);
            installAuthWeiboWebViewClient(((AuthRequestParam) (obj)));
            return ((BrowserRequestParamBase) (obj));
        }
        if (obj == BrowserLauncher.SHARE)
        {
            obj = new ShareRequestParam(this);
            ((ShareRequestParam) (obj)).setupRequestParam(bundle);
            installShareWeiboWebViewClient(((ShareRequestParam) (obj)));
            return ((BrowserRequestParamBase) (obj));
        }
        if (obj == BrowserLauncher.WIDGET)
        {
            obj = new WidgetRequestParam(this);
            ((WidgetRequestParam) (obj)).setupRequestParam(bundle);
            installWidgetWeiboWebViewClient(((WidgetRequestParam) (obj)));
            return ((BrowserRequestParamBase) (obj));
        }
        if (obj == BrowserLauncher.GAME)
        {
            isFromGame = Boolean.valueOf(true);
            GameRequestParam gamerequestparam = new GameRequestParam(this);
            gamerequestparam.setupRequestParam(bundle);
            installWeiboWebGameClient(gamerequestparam);
            return gamerequestparam;
        } else
        {
            return null;
        }
    }

    private void handleReceivedError(WebView webview, int i, String s, String s1)
    {
        if (!s1.startsWith("sinaweibo"))
        {
            isErrorPage = true;
            promptError();
        }
    }

    private void hiddenErrorPrompt()
    {
        mLoadErrorView.setVisibility(8);
        mWebView.setVisibility(0);
    }

    private boolean initDataFromIntent(Intent intent)
    {
        Object obj = intent.getExtras();
        mRequestParam = createBrowserRequestParam(((Bundle) (obj)));
        if (mRequestParam != null)
        {
            mUrl = mRequestParam.getUrl();
            mSpecifyTitle = mRequestParam.getSpecifyTitle();
        } else
        {
            intent = ((Bundle) (obj)).getString("key_url");
            obj = ((Bundle) (obj)).getString("key_specify_title");
            if (!TextUtils.isEmpty(intent) && intent.startsWith("http"))
            {
                mUrl = intent;
                mSpecifyTitle = ((String) (obj));
            }
        }
        if (TextUtils.isEmpty(mUrl))
        {
            return false;
        } else
        {
            LogUtil.d(TAG, (new StringBuilder("LOAD URL : ")).append(mUrl).toString());
            return true;
        }
    }

    private View initTitleBar()
    {
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, ResourceManager.dp2px(this, 45)));
        relativelayout.setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_navigationbar_background.9.png"));
        mLeftBtn = new TextView(this);
        mLeftBtn.setClickable(true);
        mLeftBtn.setTextSize(2, 17F);
        mLeftBtn.setTextColor(ResourceManager.createColorStateList(-32256, 0x66ff8200));
        mLeftBtn.setText(ResourceManager.getString(this, "Close", "\u5173\u95ED", "\u5173\u95ED"));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(5);
        layoutparams.addRule(15);
        layoutparams.leftMargin = ResourceManager.dp2px(this, 10);
        layoutparams.rightMargin = ResourceManager.dp2px(this, 10);
        mLeftBtn.setLayoutParams(layoutparams);
        relativelayout.addView(mLeftBtn);
        mTitleText = new TextView(this);
        mTitleText.setTextSize(2, 18F);
        mTitleText.setTextColor(0xff525252);
        mTitleText.setEllipsize(android.text.TextUtils.TruncateAt.END);
        mTitleText.setSingleLine(true);
        mTitleText.setGravity(17);
        mTitleText.setMaxWidth(ResourceManager.dp2px(this, 160));
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(13);
        mTitleText.setLayoutParams(layoutparams);
        relativelayout.addView(mTitleText);
        return relativelayout;
    }

    private void initWebView()
    {
        mWebView.getSettings().setJavaScriptEnabled(true);
        if (isWeiboShareRequestParam(mRequestParam))
        {
            mWebView.getSettings().setUserAgentString(Utility.generateUA(this));
        }
        mWebView.getSettings().setSavePassword(false);
        mWebView.setWebViewClient(mWeiboWebViewClient);
        mWebView.setWebChromeClient(new WeiboChromeClient(null));
        mWebView.requestFocus();
        mWebView.setScrollBarStyle(0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
            return;
        } else
        {
            removeJavascriptInterface(mWebView);
            return;
        }
    }

    private void installAuthWeiboWebViewClient(AuthRequestParam authrequestparam)
    {
        mWeiboWebViewClient = new AuthWeiboWebViewClient(this, authrequestparam);
        mWeiboWebViewClient.setBrowserRequestCallBack(this);
    }

    private void installShareWeiboWebViewClient(ShareRequestParam sharerequestparam)
    {
        sharerequestparam = new ShareWeiboWebViewClient(this, sharerequestparam);
        sharerequestparam.setBrowserRequestCallBack(this);
        mWeiboWebViewClient = sharerequestparam;
    }

    private void installWeiboWebGameClient(GameRequestParam gamerequestparam)
    {
        gamerequestparam = new WeiboGameClient(this, gamerequestparam);
        gamerequestparam.setBrowserRequestCallBack(this);
        mWeiboWebViewClient = gamerequestparam;
    }

    private void installWidgetWeiboWebViewClient(WidgetRequestParam widgetrequestparam)
    {
        widgetrequestparam = new WidgetWeiboWebViewClient(this, widgetrequestparam);
        widgetrequestparam.setBrowserRequestCallBack(this);
        mWeiboWebViewClient = widgetrequestparam;
    }

    private boolean isWeiboCustomScheme(String s)
    {
        while (TextUtils.isEmpty(s) || !"sinaweibo".equalsIgnoreCase(Uri.parse(s).getAuthority())) 
        {
            return false;
        }
        return true;
    }

    private boolean isWeiboShareRequestParam(BrowserRequestParamBase browserrequestparambase)
    {
        return browserrequestparambase != null && browserrequestparambase.getLauncher() == BrowserLauncher.SHARE;
    }

    private void openUrl(String s)
    {
        mWebView.loadUrl(s);
    }

    private void promptError()
    {
        mLoadErrorView.setVisibility(0);
        mWebView.setVisibility(8);
    }

    private void setContentView()
    {
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        relativelayout.setBackgroundColor(-1);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setId(1);
        linearlayout.setOrientation(1);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
        Object obj = initTitleBar();
        Object obj1 = new TextView(this);
        ((TextView) (obj1)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 2)));
        ((TextView) (obj1)).setBackgroundDrawable(ResourceManager.getNinePatchDrawable(this, "weibosdk_common_shadow_top.9.png"));
        mLoadingBar = new LoadingBar(this);
        mLoadingBar.setBackgroundColor(0);
        mLoadingBar.drawProgress(0);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, ResourceManager.dp2px(this, 3));
        mLoadingBar.setLayoutParams(layoutparams);
        linearlayout.addView(((View) (obj)));
        linearlayout.addView(((View) (obj1)));
        linearlayout.addView(mLoadingBar);
        mWebView = new WebView(this);
        mWebView.setBackgroundColor(-1);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, 1);
        mWebView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mLoadErrorView = new LinearLayout(this);
        mLoadErrorView.setVisibility(8);
        mLoadErrorView.setOrientation(1);
        mLoadErrorView.setGravity(17);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(3, 1);
        mLoadErrorView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new ImageView(this);
        ((ImageView) (obj)).setImageDrawable(ResourceManager.getDrawable(this, "weibosdk_empty_failed.png"));
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        int i = ResourceManager.dp2px(this, 8);
        obj1.bottomMargin = i;
        obj1.rightMargin = i;
        obj1.topMargin = i;
        obj1.leftMargin = i;
        ((ImageView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        mLoadErrorView.addView(((View) (obj)));
        obj = new TextView(this);
        ((TextView) (obj)).setGravity(1);
        ((TextView) (obj)).setTextColor(0xffbdbdbd);
        ((TextView) (obj)).setTextSize(2, 14F);
        ((TextView) (obj)).setText(ResourceManager.getString(this, "A network error occurs, please tap the button to reload", "\u7F51\u7EDC\u51FA\u9519\u5566\uFF0C\u8BF7\u70B9\u51FB\u6309\u94AE\u91CD\u65B0\u52A0\u8F7D", "\u7DB2\u8DEF\u51FA\u932F\u5566\uFF0C\u8ACB\u9EDE\u64CA\u6309\u9215\u91CD\u65B0\u8F09\u5165"));
        ((TextView) (obj)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
        mLoadErrorView.addView(((View) (obj)));
        mLoadErrorRetryBtn = new Button(this);
        mLoadErrorRetryBtn.setGravity(17);
        mLoadErrorRetryBtn.setTextColor(0xff787878);
        mLoadErrorRetryBtn.setTextSize(2, 16F);
        mLoadErrorRetryBtn.setText(ResourceManager.getString(this, "channel_data_error", "\u91CD\u65B0\u52A0\u8F7D", "\u91CD\u65B0\u8F09\u5165"));
        mLoadErrorRetryBtn.setBackgroundDrawable(ResourceManager.createStateListDrawable(this, "weibosdk_common_button_alpha.9.png", "weibosdk_common_button_alpha_highlighted.9.png"));
        obj = new android.widget.LinearLayout.LayoutParams(ResourceManager.dp2px(this, 142), ResourceManager.dp2px(this, 46));
        obj.topMargin = ResourceManager.dp2px(this, 10);
        mLoadErrorRetryBtn.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        mLoadErrorRetryBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final WeiboSdkBrowser this$0;

            public void onClick(View view)
            {
                openUrl(mUrl);
                isErrorPage = false;
            }

            
            {
                this$0 = WeiboSdkBrowser.this;
                super();
            }
        });
        mLoadErrorView.addView(mLoadErrorRetryBtn);
        relativelayout.addView(linearlayout);
        relativelayout.addView(mWebView);
        relativelayout.addView(mLoadErrorView);
        setContentView(((View) (relativelayout)));
        setTopNavTitle();
    }

    private void setTopNavTitle()
    {
        mTitleText.setText(mSpecifyTitle);
        mLeftBtn.setOnClickListener(new android.view.View.OnClickListener() {

            final WeiboSdkBrowser this$0;

            public void onClick(View view)
            {
                if (mRequestParam != null)
                {
                    mRequestParam.execRequest(WeiboSdkBrowser.this, 3);
                }
                finish();
            }

            
            {
                this$0 = WeiboSdkBrowser.this;
                super();
            }
        });
    }

    private void setViewLoading()
    {
        mTitleText.setText(ResourceManager.getString(this, "Loading....", "\u52A0\u8F7D\u4E2D....", "\u8F09\u5165\u4E2D...."));
        mLoadingBar.setVisibility(0);
    }

    private void setViewNormal()
    {
        updateTitleName();
        mLoadingBar.setVisibility(8);
    }

    public static void startAuth(Context context, String s, AuthInfo authinfo, WeiboAuthListener weiboauthlistener)
    {
        AuthRequestParam authrequestparam = new AuthRequestParam(context);
        authrequestparam.setLauncher(BrowserLauncher.AUTH);
        authrequestparam.setUrl(s);
        authrequestparam.setAuthInfo(authinfo);
        authrequestparam.setAuthListener(weiboauthlistener);
        s = new Intent(context, com/sina/weibo/sdk/component/WeiboSdkBrowser);
        s.putExtras(authrequestparam.createRequestParamBundle());
        context.startActivity(s);
    }

    private void startShare()
    {
        LogUtil.d(TAG, "Enter startShare()............");
        final ShareRequestParam req = (ShareRequestParam)mRequestParam;
        if (req.hasImage())
        {
            LogUtil.d(TAG, "loadUrl hasImage............");
            WeiboParameters weiboparameters = req.buildUploadPicParam(new WeiboParameters(req.getAppKey()));
            (new AsyncWeiboRunner(this)).requestAsync("http://service.weibo.com/share/mobilesdk_uppic.php", weiboparameters, "POST", new RequestListener() {

                final WeiboSdkBrowser this$0;
                private final ShareRequestParam val$req;

                public void onComplete(String s)
                {
                    LogUtil.d(WeiboSdkBrowser.TAG, (new StringBuilder("post onComplete : ")).append(s).toString());
                    s = ShareRequestParam.UploadPicResult.parse(s);
                    if (s != null && s.getCode() == 1 && !TextUtils.isEmpty(s.getPicId()))
                    {
                        openUrl(req.buildUrl(s.getPicId()));
                        return;
                    } else
                    {
                        req.sendSdkErrorResponse(WeiboSdkBrowser.this, "upload pic faild");
                        finish();
                        return;
                    }
                }

                public void onWeiboException(WeiboException weiboexception)
                {
                    LogUtil.d(WeiboSdkBrowser.TAG, (new StringBuilder("post onWeiboException ")).append(weiboexception.getMessage()).toString());
                    req.sendSdkErrorResponse(WeiboSdkBrowser.this, weiboexception.getMessage());
                    finish();
                }

            
            {
                this$0 = WeiboSdkBrowser.this;
                req = sharerequestparam;
                super();
            }
            });
            return;
        } else
        {
            openUrl(mUrl);
            return;
        }
    }

    public static void startShared(Context context, String s, AuthInfo authinfo, WeiboAuthListener weiboauthlistener)
    {
    }

    private void updateTitleName()
    {
        String s = "";
        if (TextUtils.isEmpty(mHtmlTitle)) goto _L2; else goto _L1
_L1:
        s = mHtmlTitle;
_L4:
        mTitleText.setText(s);
        return;
_L2:
        if (!TextUtils.isEmpty(mSpecifyTitle))
        {
            s = mSpecifyTitle;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!initDataFromIntent(getIntent()))
        {
            finish();
            return;
        }
        setContentView();
        initWebView();
        if (isWeiboShareRequestParam(mRequestParam))
        {
            startShare();
            return;
        } else
        {
            openUrl(mUrl);
            return;
        }
    }

    protected void onDestroy()
    {
        NetworkHelper.clearCookies(this);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (mRequestParam != null)
            {
                mRequestParam.execRequest(this, 3);
            }
            finish();
            return true;
        } else
        {
            return super.onKeyUp(i, keyevent);
        }
    }

    public void onPageFinishedCallBack(WebView webview, String s)
    {
        LogUtil.d(TAG, (new StringBuilder("onPageFinished URL: ")).append(s).toString());
        if (isErrorPage)
        {
            promptError();
            return;
        } else
        {
            isErrorPage = false;
            hiddenErrorPrompt();
            return;
        }
    }

    public void onPageStartedCallBack(WebView webview, String s, Bitmap bitmap)
    {
        LogUtil.d(TAG, (new StringBuilder("onPageStarted URL: ")).append(s).toString());
        mUrl = s;
        if (!isWeiboCustomScheme(s))
        {
            mHtmlTitle = "";
        }
    }

    public void onReceivedErrorCallBack(WebView webview, int i, String s, String s1)
    {
        LogUtil.d(TAG, (new StringBuilder("onReceivedError: errorCode = ")).append(i).append(", description = ").append(s).append(", failingUrl = ").append(s1).toString());
        handleReceivedError(webview, i, s, s1);
    }

    public void onReceivedSslErrorCallBack(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        LogUtil.d(TAG, "onReceivedSslErrorCallBack.........");
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void refreshAllViews()
    {
        if (isLoading)
        {
            setViewLoading();
            return;
        } else
        {
            setViewNormal();
            return;
        }
    }

    public void removeJavascriptInterface(WebView webview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        webview.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
        return;
        webview;
        LogUtil.e(TAG, webview.toString());
        return;
    }

    public boolean shouldOverrideUrlLoadingCallBack(WebView webview, String s)
    {
        LogUtil.i(TAG, (new StringBuilder("shouldOverrideUrlLoading URL: ")).append(s).toString());
        return false;
    }














    private class WeiboChromeClient extends WebChromeClient
    {

        final WeiboSdkBrowser this$0;

        public void onProgressChanged(WebView webview, int i)
        {
            mLoadingBar.drawProgress(i);
            if (i == 100)
            {
                isLoading = false;
                refreshAllViews();
            } else
            if (!isLoading)
            {
                isLoading = true;
                refreshAllViews();
                return;
            }
        }

        public void onReceivedTitle(WebView webview, String s)
        {
            if (!isWeiboCustomScheme(mUrl) && !isFromGame.booleanValue())
            {
                mHtmlTitle = s;
                updateTitleName();
            }
        }

        private WeiboChromeClient()
        {
            this$0 = WeiboSdkBrowser.this;
            super();
        }

        WeiboChromeClient(WeiboChromeClient weibochromeclient)
        {
            this();
        }
    }

}
