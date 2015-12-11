// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.cookies.CookieFactory;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.foundations.activity.BaseActionBarActivity;
import com.groupon.http.NameValuePair;
import com.groupon.models.division.Division;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.LocationService;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.HttpUtil;
import com.groupon.util.WebViewHelper;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            IntentFactory

public class GrouponWebView extends BaseActionBarActivity
    implements GrouponDialogListener
{
    private class MyWebChromeClient extends WebChromeClient
    {

        final GrouponWebView this$0;

        public void onReceivedTitle(WebView webview, String s)
        {
            super.onReceivedTitle(webview, s);
            GrouponWebView grouponwebview = GrouponWebView.this;
            webview = s;
            if (Strings.equals(s, "about:blank"))
            {
                webview = "";
            }
            grouponwebview.setActionBarTitle(webview);
        }

        private MyWebChromeClient()
        {
            this$0 = GrouponWebView.this;
            super();
        }

    }

    private class MyWebViewClient extends WebViewClient
    {

        final GrouponWebView this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            progressBar.setVisibility(8);
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                String s1 = webview.getTitle();
                s = GrouponWebView.this;
                if (Strings.equals(s1, "about:blank"))
                {
                    webview = "";
                } else
                {
                    webview = webview.getTitle();
                }
                s.setActionBarTitle(webview);
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            progressBar.setVisibility(0);
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            progressBar.setVisibility(8);
            webview.loadUrl("about:blank");
            displayWebViewErrorDialog();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
label0:
            {
label1:
                {
                    if (s.startsWith("groupon:login"))
                    {
                        progressBar.setVisibility(0);
                        getQueryParams(s);
                        getWindowDataAndLogin();
                        return true;
                    }
                    if (!deepLinkUtil.isDeepLink(s))
                    {
                        break label0;
                    }
                    try
                    {
                        webview = deepLinkUtil.getDeepLink(s);
                        if (!deepLinkManager.isDirectlyFollowable(webview))
                        {
                            break label1;
                        }
                        deepLinkManager.followDeepLink(GrouponWebView.this, webview);
                    }
                    // Misplaced declaration of an exception variable
                    catch (WebView webview)
                    {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            if (s.startsWith("groupon:show_close_button"))
            {
                exitWebviewOnBackPressed = true;
                return true;
            }
            if (s.startsWith("groupon:show_start_shopping_button"))
            {
                exitWebviewOnBackPressed = true;
                return true;
            }
            if (s.startsWith("groupon:start_shopping"))
            {
                startActivity(intentFactory.newCarouselIntent());
                return true;
            } else
            {
                return false;
            }
        }

        private MyWebViewClient()
        {
            this$0 = GrouponWebView.this;
            super();
        }

    }

    private class WindowDataJavascriptInterface
    {

        final GrouponWebView this$0;

        public void setData(String s)
        {
            windowData = s;
            login();
        }

        private WindowDataJavascriptInterface()
        {
            this$0 = GrouponWebView.this;
            super();
        }

    }


    private static final String CONSUMER_ID_FOR_POINTS = "consumer_ID";
    private static final String COOKIES = "cookies";
    private static final String OAUTH_TOKEN = "oauthToken";
    private final String ABOUT_BLANK = "about:blank";
    private final String COOKIES_FORMAT = "s=%1$s;b=%2$s;l=%3$s";
    private final String GROUPON_LOGIN = "groupon:login";
    private final String GROUPON_SHOW_CLOSE_BUTTON = "groupon:show_close_button";
    private final String GROUPON_SHOW_START_SHOPPING_BUTTON = "groupon:show_start_shopping_button";
    private final String GROUPON_START_SHOPPING_BUTTON = "groupon:start_shopping";
    private final String GTG_COOKIES = "s=%1$s;b=%2$s;division=%3$s";
    private final String LOAD_WINDOW_DATA_JAVASCRIPT = "javascript:window.Android.setData(JSON.stringify(%s));";
    private final String LOGIN_CANCELED = "login_canceled";
    private final String LOGIN_SUCCESS = "login_success";
    private final String QUERY_FAILURE_URL = "failureURL";
    private final String QUERY_SUCCESS_URL = "successURL";
    private final String QUERY_WINDOW_DATA = "windowData";
    private final String WEBVIEW_ERROR_DIALOG = "webview_error_dialog";
    private CookieFactory cookieFactory;
    private CurrentDivisionManager currentDivisionManager;
    private DeepLinkManager deepLinkManager;
    private DeepLinkUtil deepLinkUtil;
    protected DialogManager dialogManager;
    private boolean exitWebviewOnBackPressed;
    private String failureUrl;
    private WebView grouponWebView;
    FrameLayout grouponWebViewPlaceholder;
    boolean hideHeader;
    private IntentFactory intentFactory;
    boolean isDeepLinked;
    private LocationService locationService;
    private LoginService loginService;
    boolean needsLocation;
    boolean needsXCookies;
    protected SharedPreferences prefs;
    ProgressBar progressBar;
    private String successUrl;
    Toolbar toolbar;
    String url;
    private String windowData;
    private String windowDataPropertyName;

    public GrouponWebView()
    {
    }

    private void displayWebViewErrorDialog()
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0801a5), Integer.valueOf(0x104000a), false);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "webview_error_dialog");
    }

    private Map getHeaderNameValuePairs()
    {
        HashMap hashmap = new HashMap();
        if (url.startsWith("https") && loginService.isLoggedIn())
        {
            hashmap.put("Authorization", String.format("OAuth %s", new Object[] {
                loginService.getAccessToken()
            }));
        }
        hashmap.put("cookie", getCookies());
        if (needsXCookies)
        {
            hashmap.put("x-cookies", getGtgCookies());
        }
        return hashmap;
    }

    private List getInitialUrlQueryNameValuePairs()
    {
        ArrayList arraylist = new ArrayList();
        if (loginService.isLoggedIn())
        {
            arraylist.add(new NameValuePair("user_id", loginService.getUserId()));
        }
        if (loginService.isLoggedIn())
        {
            arraylist.add(new NameValuePair("consumer_ID", loginService.getConsumerId()));
        }
        if (needsLocation)
        {
            Object obj = locationService.getLocation();
            String s;
            if (obj != null)
            {
                s = String.valueOf(((Location) (obj)).getLatitude());
            } else
            {
                s = "";
            }
            if (obj != null)
            {
                obj = String.valueOf(((Location) (obj)).getLongitude());
            } else
            {
                obj = "";
            }
            if (Strings.notEmpty(s) && Strings.notEmpty(obj))
            {
                arraylist.add(new NameValuePair("lat", s));
                arraylist.add(new NameValuePair("lng", ((String) (obj))));
            }
        }
        if (hideHeader)
        {
            arraylist.add(new NameValuePair("hide_header", "true"));
        }
        return arraylist;
    }

    private void getQueryParams(String s)
    {
        s = getQueryNameValuePairs(s).iterator();
_L7:
        NameValuePair namevaluepair;
        String s1;
        byte byte0;
        if (!s.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        namevaluepair = (NameValuePair)s.next();
        s1 = namevaluepair.name;
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 76
    //                   -733649300: 133
    //                   1036661637: 118
    //                   1862059962: 148;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_148;
_L5:
        switch (byte0)
        {
        case 0: // '\0'
            failureUrl = namevaluepair.value;
            break;

        case 1: // '\001'
            successUrl = namevaluepair.value;
            break;

        case 2: // '\002'
            windowDataPropertyName = namevaluepair.value;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (s1.equals("failureURL"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s1.equals("successURL"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s1.equals("windowData"))
        {
            byte0 = 2;
        }
          goto _L5
        if (true) goto _L7; else goto _L6
_L6:
    }

    private String getUrlWithAppendedQuery(String s, List list)
    {
        s = new com.groupon.http.Uris.Builder(s);
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (NameValuePair)list.next();
            String s1 = ((NameValuePair) (obj)).name;
            obj = ((NameValuePair) (obj)).value;
            if (Strings.notEmpty(s1) && Strings.notEmpty(obj))
            {
                s.appendQueryParameter(s1, ((String) (obj)));
            }
        } while (true);
        return s.build().toString();
    }

    private void getWindowDataAndLogin()
    {
        if (Strings.notEmpty(windowDataPropertyName))
        {
            grouponWebView.loadUrl(String.format("javascript:window.Android.setData(JSON.stringify(%s));", new Object[] {
                windowDataPropertyName
            }));
        }
    }

    private void setupWebView()
    {
        if (grouponWebView == null)
        {
            grouponWebView = new WebView(this);
            WebViewHelper.addInAppUserAgent(grouponWebView);
            grouponWebView.getSettings().setJavaScriptEnabled(true);
            grouponWebView.getSettings().setDomStorageEnabled(true);
            grouponWebView.setWebViewClient(new MyWebViewClient());
            grouponWebView.setWebChromeClient(new MyWebChromeClient());
            grouponWebView.addJavascriptInterface(new WindowDataJavascriptInterface(), "Android");
            List list = getInitialUrlQueryNameValuePairs();
            Map map = getHeaderNameValuePairs();
            if (list.size() > 0)
            {
                url = getUrlWithAppendedQuery(url, list);
            }
            if (map.size() > 0)
            {
                grouponWebView.loadUrl(url, map);
            } else
            {
                grouponWebView.loadUrl(url);
            }
        }
        grouponWebViewPlaceholder.addView(grouponWebView);
    }

    protected String getCookies()
    {
        return String.format("s=%1$s;b=%2$s;l=%3$s", new Object[] {
            cookieFactory.getSessionCookie(), cookieFactory.getBrowserCookie(), cookieFactory.getUserPermalinkCookie()
        });
    }

    protected String getGtgCookies()
    {
        return String.format("s=%1$s;b=%2$s;division=%3$s", new Object[] {
            cookieFactory.getSessionCookie(), cookieFactory.getBrowserCookie(), currentDivisionManager.getCurrentDivision().name
        });
    }

    protected List getQueryNameValuePairs(String s)
    {
        try
        {
            s = HttpUtil.extractNameValuePairs(new URI((new StringBuilder()).append("http://").append(s).toString()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new ArrayList();
        }
        return s;
    }

    protected void login()
    {
        progressBar.post(new Runnable() {

            final GrouponWebView this$0;

            public void run()
            {
                progressBar.setVisibility(8);
            }

            
            {
                this$0 = GrouponWebView.this;
                super();
            }
        });
        startActivityForResult(intentFactory.newLoginIntent(this), 10110);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 10110)
        {
            String s;
            if (j == -1)
            {
                s = "login_success";
            } else
            {
                s = "login_canceled";
            }
            onLoginResult(s);
        }
        super.onActivityResult(i, j, intent);
    }

    public void onBackPressed()
    {
        if (grouponWebView.canGoBack() && !exitWebviewOnBackPressed)
        {
            grouponWebView.goBack();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (grouponWebView != null)
        {
            grouponWebViewPlaceholder.removeView(grouponWebView);
        }
        super.onConfigurationChanged(configuration);
        setupWebView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03012b);
        ButterKnife.bind(this);
        Dart.inject(this);
        setToolbar();
        setupWebView();
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "webview_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void onLoginResult(String s)
    {
        if (Strings.equals(s, "login_success") && Strings.notEmpty(successUrl))
        {
            s = successUrl;
        } else
        if (Strings.equals(s, "login_canceled") && Strings.notEmpty(failureUrl))
        {
            s = failureUrl;
        } else
        {
            s = "";
        }
        if (Strings.notEmpty(s))
        {
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList(1);
            arraylist.add(new NameValuePair("oauthToken", loginService.getAccessToken()));
            arraylist.add(new NameValuePair("cookies", getGtgCookies()));
            arraylist1.add(new NameValuePair("user_id", loginService.getUserId()));
            if (Strings.notEmpty(windowData))
            {
                arraylist.add(new NameValuePair("order", windowData));
            }
            String s1 = s;
            if (arraylist1.size() > 0)
            {
                s1 = getUrlWithAppendedQuery(s, arraylist1);
            }
            postDataToUrl(s1, arraylist);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            break;
        }
        if (grouponWebView.canGoBack() && !exitWebviewOnBackPressed)
        {
            grouponWebView.goBack();
        } else
        if (isDeepLinked)
        {
            startActivity(intentFactory.newCarouselIntent());
        } else
        {
            finish();
        }
        return true;
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        exitWebviewOnBackPressed = bundle.getBoolean("exit_on_back_pressed");
        grouponWebView.restoreState(bundle);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("gdt_thanks_page_reached", exitWebviewOnBackPressed);
        grouponWebView.saveState(bundle);
    }

    protected void postDataToUrl(String s, List list)
    {
        list = HttpUtil.urlEncode(list);
        grouponWebView.postUrl(s, HttpUtil.convertToBytes(list));
    }

    protected void setActionBarTitle(String s)
    {
        getSupportActionBar().setTitle(s);
    }

    protected void setToolbar()
    {
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(null);
        actionbar.setDisplayShowTitleEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
    }


/*
    static String access$1002(GrouponWebView grouponwebview, String s)
    {
        grouponwebview.windowData = s;
        return s;
    }

*/






/*
    static boolean access$702(GrouponWebView grouponwebview, boolean flag)
    {
        grouponwebview.exitWebviewOnBackPressed = flag;
        return flag;
    }

*/


}
