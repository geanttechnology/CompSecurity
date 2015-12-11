// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import com.ebay.common.Preferences;
import com.ebay.common.SsoScopeLoader;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.motors.videos.FwContextUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInModalActivity

public class ShowWebViewActivity extends BaseActivity
    implements android.view.View.OnClickListener, android.view.View.OnTouchListener
{
    class ScrollGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final ShowWebViewActivity this$0;

        public boolean onDown(MotionEvent motionevent)
        {
            webview.flingScroll(0, 0);
            return true;
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            webview.flingScroll(0, -(int)f1);
            return true;
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            int i = (int)f1;
            int j = (int)((float)webview.getContentHeight() * webview.getScale());
            int k = webview.getScrollY() + webview.getHeight();
            int l = k + i;
            if (i >= 0 || webview.getScrollY() != 0)
            {
                if (i < 0 && webview.getScrollY() + i < 0)
                {
                    webview.scrollBy(0, -webview.getScrollY());
                    return true;
                }
                if (l > j)
                {
                    webview.scrollBy(0, j - k);
                    return true;
                }
                if (l < j)
                {
                    webview.scrollBy(0, i);
                    return true;
                }
            }
            return true;
        }

        ScrollGestureListener()
        {
            this$0 = ShowWebViewActivity.this;
            super();
        }
    }

    public static interface UrlRewriter
    {

        public abstract String rewriteUri(String s);
    }


    protected static String COMPLETION_EMAIL = "ebay-mobile-email";
    protected static String COMPLETION_ERRORID = "ebay-mobile-errorid";
    protected static String COMPLETION_STATUS = "ebay-mobile-status";
    protected static String COMPLETION_USERID = "ebay-mobile-userid";
    protected static final int DEFAULT_BACKGROUND_COLOR = -1;
    protected static final String DEFAULT_SSO_SCOPE = "//EBAYSSO/EBAYCLASSIC";
    public static final String EXTRA_ADD_DEVICE_ID = "add_device_id";
    public static final String EXTRA_ADD_REDIRECT_URL = "add_redirect_url";
    public static final String EXTRA_BACKGROUND_COLOR = "backgroundColor";
    public static String EXTRA_DONE_PATTERN = "done_pattern";
    public static final String EXTRA_ENABLE_FILE_DOWNLOAD = "enablefileDownload";
    public static final String EXTRA_HEADERS = "headers";
    public static final String EXTRA_IMPRESSION = "impression";
    public static String EXTRA_LAST_PAGE_PATTERN = "last_page_pattern";
    public static final String EXTRA_LAYOUT = "layout";
    public static final String EXTRA_LESS_PROGRESS_SPINNER = "lessProgress";
    public static final String EXTRA_MAX_WIDTH = "maxWidth";
    public static String EXTRA_NUM_HISTORY_TO_SKIP = "num_history_to_skip";
    public static String EXTRA_REQUIRE_AUTH = "requireAuth";
    public static String EXTRA_SCOPE = "extra_scope";
    public static String EXTRA_SHOW_MENU = "show_menu";
    public static final String EXTRA_TITLE = "android.intent.extra.TITLE";
    public static final String EXTRA_TRACKING_TAG = "trackingPair";
    public static final String EXTRA_URL = "url";
    public static final String EXTRA_USE_BACK_STACK = "back";
    public static final String EXTRA_USE_OK_BUTTON = "ok";
    public static final String EXTRA_USE_SSO = "use_sso";
    public static String EXTRA_USE_WIDE_VIEWPORT = "use_wide_viewport";
    public static final int INPUT_FILE_REQUEST_CODE = 2;
    protected static final int LAST_LOADER_ID = 1;
    protected static final int LOADER_ID_SSO_TOKEN = 1;
    public static final String REDIRECT_URL = "http://www.ebay.com/mobile-redirect-done";
    public static String RESULT_VALUE_EMAIL = "email";
    public static String RESULT_VALUE_ERRORID = "errorid";
    public static String RESULT_VALUE_USERID = "userid";
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ShowWebViewActivity", 3, "Show WebView");
    protected volatile boolean ALLOW_PRODUCTION_IGNORE_SSL_ERRORS;
    protected boolean addDeviceId;
    protected boolean addRedirectUrl;
    protected Animation animationSlideUp;
    protected int backgroundColor;
    protected String cachedDeviceId;
    protected String cameraPhotoPath;
    protected Pattern donePattern;
    protected boolean enableFileDownload;
    protected ValueCallback filePathCallback;
    private GestureDetector gDetector;
    protected boolean hasContentSettled;
    protected HashMap headers;
    protected String impression;
    protected boolean isDoneFlag;
    protected boolean isHandlingError;
    protected boolean isLoadingLastPage;
    protected Pattern lastPagePattern;
    protected int layout;
    protected int maxWidth;
    protected int numHistoryToSkip;
    protected View okButtonView;
    protected View progressView;
    protected boolean requireAuth;
    private int resultCode;
    private Intent resultData;
    protected String scope;
    private View scrollContainer;
    private String ssoUrl;
    protected String title;
    protected String trackingTag[];
    protected String url;
    protected UrlRewriter urlRewriter;
    protected boolean useBackStack;
    protected boolean useLessProgressSpinner;
    protected boolean useOkButton;
    protected boolean useSso;
    protected boolean useWideViewPort;
    protected WebView webview;

    public ShowWebViewActivity()
    {
        urlRewriter = null;
        ALLOW_PRODUCTION_IGNORE_SSL_ERRORS = false;
        requireAuth = false;
        isHandlingError = false;
        isLoadingLastPage = false;
        isDoneFlag = false;
        hasContentSettled = false;
    }

    private String addRedirectUrlToUrl(String s)
    {
label0:
        {
            while (TextUtils.isEmpty(s) || s.contains("returnto")) 
            {
                return s;
            }
            String s1 = s.replaceAll("\\bru=[^&]+&?", "");
            String s2 = Uri.parse(s1).getScheme();
            if (!"http".equals(s2))
            {
                s = s1;
                if (!"https".equals(s2))
                {
                    break label0;
                }
            }
            s = Uri.parse(s1).buildUpon().appendQueryParameter("ru", "http://www.ebay.com/mobile-redirect-done").build().toString();
        }
        return s;
    }

    private static Pattern getPatternExtra(Intent intent, String s)
    {
        intent = intent.getStringExtra(s);
        try
        {
            intent = Pattern.compile(intent, 2);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return null;
        }
        return intent;
    }

    protected static void show(View view, boolean flag)
    {
label0:
        {
            if (view != null)
            {
                if (!flag)
                {
                    break label0;
                }
                view.setVisibility(0);
            }
            return;
        }
        view.setVisibility(8);
    }

    public static void start(Activity activity, String s, String s1, String s2)
    {
        start(activity, s, s1, s2, null);
    }

    public static void start(Activity activity, String s, String s1, String s2, Integer integer)
    {
        start(activity, s, s1, s2, integer, false);
    }

    public static void start(Activity activity, String s, String s1, String s2, Integer integer, boolean flag)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/ShowWebViewActivity);
        intent.putExtra("url", s);
        intent.putExtra("android.intent.extra.TITLE", s1);
        if (!TextUtils.isEmpty(s2))
        {
            intent.putExtra("impression", s2);
        }
        if (flag)
        {
            intent.putExtra("use_sso", flag);
        }
        if (integer != null)
        {
            activity.startActivityForResult(intent, integer.intValue());
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    protected void addDeviceIdToUrl()
    {
        url = Uri.parse(url).buildUpon().appendQueryParameter("UUID", cachedDeviceId).build().toString();
    }

    protected File createImageFile()
        throws IOException
    {
        String s = (new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())).format(new Date());
        return File.createTempFile((new StringBuilder()).append("JPEG_").append(s).append("_").toString(), ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    protected void createUI()
    {
        Object obj;
        View view;
        if (title != null)
        {
            obj = title;
        } else
        {
            obj = "";
        }
        setTitle(((CharSequence) (obj)));
        obj = getWindow().getDecorView().getRootView();
        ((View) (obj)).setBackgroundColor(backgroundColor);
        view = findViewById(0x7f1003a5);
        if (view != null)
        {
            ((TextView)view).setText(title);
        }
        view = findViewById(0x7f1003ab);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ShowWebViewActivity this$0;

                public void onClick(View view1)
                {
                    finish();
                }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
            });
        }
        if (maxWidth != -1)
        {
            obj = ((View) (obj)).findViewById(0x7f1007e8);
            if (obj != null && (obj instanceof com.ebay.android.widget.MaxSizeHelper.MaxSizeWidget))
            {
                ((com.ebay.android.widget.MaxSizeHelper.MaxSizeWidget)obj).setMaxWidth(maxWidth);
            }
        }
        progressView = findViewById(0x7f100143);
        webview = (WebView)findViewById(0x7f100316);
        if (useOkButton)
        {
            obj = findViewById(0x7f10064b);
            if (obj == null)
            {
                useOkButton = false;
            } else
            {
                ((View) (obj)).setOnClickListener(this);
                okButtonView = findViewById(0x7f1004b8);
                animationSlideUp = AnimationUtils.loadAnimation(this, 0x7f040016);
            }
        }
        obj = getSharedPreferences("WebViewSettings", 0);
        if (((SharedPreferences) (obj)).getInt("double_tap_toast_count", 1) > 0)
        {
            ((SharedPreferences) (obj)).edit().putInt("double_tap_toast_count", 0).commit();
        }
        obj = webview.getSettings();
        ((WebSettings) (obj)).setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        ((WebSettings) (obj)).setLoadsImagesAutomatically(true);
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        ((WebSettings) (obj)).setJavaScriptCanOpenWindowsAutomatically(false);
        ((WebSettings) (obj)).setSupportZoom(true);
        ((WebSettings) (obj)).setBuiltInZoomControls(true);
        ((WebSettings) (obj)).setDisplayZoomControls(false);
        ((WebSettings) (obj)).setLoadWithOverviewMode(true);
        ((WebSettings) (obj)).setSavePassword(false);
        ((WebSettings) (obj)).setUseWideViewPort(useWideViewPort);
        webview.setFocusable(true);
        webview.setWebChromeClient(new WebChromeClient() {

            final ShowWebViewActivity this$0;

            public void onProgressChanged(WebView webview1, int i)
            {
                boolean flag1 = true;
                boolean flag = true;
                if (useLessProgressSpinner)
                {
                    webview1 = ShowWebViewActivity.this;
                    if (i > 30)
                    {
                        flag = false;
                    }
                    webview1.showProgress(flag);
                    return;
                }
                webview1 = ShowWebViewActivity.this;
                if (i <= 99)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                webview1.showProgress(flag);
            }

            public boolean onShowFileChooser(WebView webview1, ValueCallback valuecallback, android.webkit.WebChromeClient.FileChooserParams filechooserparams)
            {
                if (filePathCallback != null)
                {
                    filePathCallback.onReceiveValue(null);
                }
                filePathCallback = valuecallback;
                filechooserparams = new Intent("android.media.action.IMAGE_CAPTURE");
                webview1 = filechooserparams;
                if (filechooserparams.resolveActivity(getPackageManager()) == null) goto _L2; else goto _L1
_L1:
                webview1 = null;
                valuecallback = createImageFile();
                webview1 = valuecallback;
                filechooserparams.putExtra("PhotoPath", cameraPhotoPath);
                webview1 = valuecallback;
_L3:
                if (webview1 != null)
                {
                    cameraPhotoPath = (new StringBuilder()).append("file:").append(webview1.getAbsolutePath()).toString();
                    filechooserparams.putExtra("output", Uri.fromFile(webview1));
                    webview1 = filechooserparams;
                } else
                {
                    webview1 = null;
                }
_L2:
                filechooserparams = new Intent("android.intent.action.GET_CONTENT");
                filechooserparams.addCategory("android.intent.category.OPENABLE");
                filechooserparams.setType("image/*");
                if (webview1 != null)
                {
                    valuecallback = new Intent[1];
                    valuecallback[0] = webview1;
                    webview1 = valuecallback;
                } else
                {
                    webview1 = new Intent[0];
                }
                valuecallback = new Intent("android.intent.action.CHOOSER");
                valuecallback.putExtra("android.intent.extra.INTENT", filechooserparams);
                valuecallback.putExtra("android.intent.extra.TITLE", "Image Chooser");
                valuecallback.putExtra("android.intent.extra.INITIAL_INTENTS", webview1);
                startActivityForResult(valuecallback, 2);
                return true;
                valuecallback;
                ShowWebViewActivity.log.logAsError("Unable to create Image File", valuecallback);
                  goto _L3
            }

            public void openFileChooser(ValueCallback valuecallback, String s)
            {
                filePathCallback = valuecallback;
                valuecallback = new Intent("android.intent.action.GET_CONTENT");
                valuecallback.addCategory("android.intent.category.OPENABLE");
                valuecallback.setType("*/*");
                startActivityForResult(Intent.createChooser(valuecallback, "File Browser"), 2);
            }

            public void openFileChooser(ValueCallback valuecallback, String s, String s1)
            {
                valuecallback = new Intent("android.intent.action.GET_CONTENT");
                valuecallback.addCategory("android.intent.category.OPENABLE");
                valuecallback.setType("image/*");
                startActivityForResult(Intent.createChooser(valuecallback, "File Chooser"), 2);
            }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
        });
        webview.setWebViewClient(new WebViewClient() {

            final ShowWebViewActivity this$0;

            private String getSslErrorUrl(SslError sslerror)
            {
                return sslerror.getUrl();
            }

            public void onPageFinished(WebView webview1, String s)
            {
                boolean flag1 = true;
                if (!isHandlingError)
                {
                    url = s;
                    hasContentSettled = true;
                    ShowWebViewActivity showwebviewactivity = ShowWebViewActivity.this;
                    boolean flag = flag1;
                    if (!isDoneFlag)
                    {
                        if (isLoadingLastPage)
                        {
                            flag = flag1;
                        } else
                        {
                            flag = false;
                        }
                    }
                    showwebviewactivity.isDoneFlag = flag;
                    if (isDoneFlag && okButtonView != null)
                    {
                        if (animationSlideUp != null)
                        {
                            okButtonView.startAnimation(animationSlideUp);
                        }
                        okButtonView.setVisibility(0);
                    }
                    ShowWebViewActivity.this.onPageFinished(webview1, s);
                }
            }

            public void onPageStarted(WebView webview1, String s, Bitmap bitmap)
            {
                if (isHandlingError) goto _L2; else goto _L1
_L1:
                if (ShowWebViewActivity.log.isLoggable)
                {
                    ShowWebViewActivity.log.log((new StringBuilder()).append("onPageStarted: ").append(s).toString());
                }
                if (!isUrlLastPage(s)) goto _L4; else goto _L3
_L3:
                isLoadingLastPage = true;
_L6:
                if (!isDoneFlag)
                {
                    ShowWebViewActivity.this.onPageStarted(webview1, s, bitmap);
                }
_L2:
                return;
_L4:
                if (isUrlPastLastPage(s))
                {
                    url = s;
                    isDoneFlag = true;
                    onDone();
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public void onReceivedError(WebView webview1, int i, String s, String s1)
            {
                if (isFinishing())
                {
                    return;
                }
                isLoadingLastPage = false;
                isHandlingError = true;
                showProgress(false);
                ShowWebViewActivity.log.logAsError(String.format("Error from webview %s: [%d] \"%s\" while fetching %s", new Object[] {
                    getResources().getResourceName(webview1.getId()), Integer.valueOf(i), s, s1
                }));
                if (Util.hasNetwork())
                {
                    i = 0x7f07014e;
                } else
                {
                    i = 0x7f070151;
                }
                showDialog(i);
            }

            public void onReceivedSslError(WebView webview1, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                if (!isFinishing())
                {
                    isLoadingLastPage = false;
                    isHandlingError = true;
                    showProgress(false);
                    ShowWebViewActivity.log.logAsError(String.format("Error from webview %s: \"%s\" while fetching %s.", new Object[] {
                        getResources().getResourceName(webview1.getId()), sslerror.toString(), getSslErrorUrl(sslerror)
                    }));
                    boolean flag1 = NautilusKernel.isQaMode();
                    boolean flag = flag1;
                    if (ALLOW_PRODUCTION_IGNORE_SSL_ERRORS)
                    {
                        flag = flag1;
                        if (!flag1)
                        {
                            try
                            {
                                webview1 = MyApp.getPrefs().getCurrentCountry().getSiteDomain();
                                flag = Uri.parse(url).getHost().endsWith(webview1);
                            }
                            // Misplaced declaration of an exception variable
                            catch (WebView webview1)
                            {
                                flag = false;
                            }
                        }
                    }
                    if (flag)
                    {
                        ShowWebViewActivity.log.logAsWarning("Ignoring SSL errors.");
                        sslerrorhandler.proceed();
                        return;
                    }
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webview1, String s)
            {
                if (ShowWebViewActivity.log.isLoggable)
                {
                    ShowWebViewActivity.log.log((new StringBuilder()).append("shouldOverrideUrlLoading: ").append(s).toString());
                }
                if (isUrlPastLastPage(s))
                {
                    url = s;
                    isDoneFlag = true;
                    onDone();
                } else
                {
                    String s1 = s;
                    if (!Uri.parse(s).isOpaque())
                    {
                        s1 = rewriteUri(s);
                    }
                    if (ShowWebViewActivity.this.shouldOverrideUrlLoading(webview1, s1))
                    {
                        return true;
                    }
                    Object obj1 = Uri.parse(s1);
                    Intent intent = new Intent("android.intent.action.VIEW", ((Uri) (obj1)));
                    if (!((Uri) (obj1)).isHierarchical())
                    {
                        startActivity(intent);
                        return true;
                    }
                    obj1 = FwContextUtil.getLocalActivity(ShowWebViewActivity.this, intent);
                    if (((Intent) (obj1)).getComponent() != null)
                    {
                        startActivity(((Intent) (obj1)));
                        if (!hasContentSettled)
                        {
                            finish();
                        }
                        return true;
                    }
                    if (super.shouldOverrideUrlLoading(webview1, s))
                    {
                        return true;
                    }
                    if (s1 != s)
                    {
                        webview.loadUrl(s1);
                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
        });
        if (enableFileDownload)
        {
            webview.setDownloadListener(new DownloadListener() {

                final ShowWebViewActivity this$0;

                public void onDownloadStart(String s, String s1, String s2, String s3, long l)
                {
                    if (s != null)
                    {
                        if ("true".equals((s1 = Uri.parse(s)).getQueryParameter("printable")))
                        {
                            s = CookieManager.getInstance().getCookie(s);
                            s1 = new android.app.DownloadManager.Request(s1);
                            s1.addRequestHeader("cookie", s);
                            s1.allowScanningByMediaScanner();
                            s1.setNotificationVisibility(1);
                            s1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "ValetLabel.pdf");
                            ((DownloadManager)getSystemService("download")).enqueue(s1);
                            s = new Intent("android.intent.action.OPEN_DOCUMENT");
                            s.addCategory("android.intent.category.OPENABLE");
                            s.setType("*/*");
                            Toast.makeText(getApplicationContext(), 0x7f070b9d, 1).show();
                            return;
                        }
                    }
                }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
            });
        }
        scrollContainer = findViewById(0x7f1001de);
        if (scrollContainer != null)
        {
            scrollContainer.setOnTouchListener(this);
            gDetector = new GestureDetector(this, new ScrollGestureListener());
        }
    }

    protected void getDeviceIdThenRefresh()
    {
        cachedDeviceId = EbayIdentity.getDeviceIdStringIfAlreadyInitialized();
        if (cachedDeviceId != null)
        {
            addDeviceIdToUrl();
            onRefresh();
            return;
        } else
        {
            showProgress(true);
            (new AsyncTask() {

                final ShowWebViewActivity this$0;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient String doInBackground(Void avoid[])
                {
                    return EbayIdentity.getDeviceIdString(getApplicationContext());
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((String)obj);
                }

                protected void onPostExecute(String s)
                {
                    if (!isFinishing())
                    {
                        cachedDeviceId = s;
                        addDeviceIdToUrl();
                        onRefresh();
                    }
                }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public String getTrackingEventName()
    {
        return impression;
    }

    protected final int getWebViewResultCode()
    {
        return resultCode;
    }

    protected final Intent getWebViewResultData()
    {
        return resultData;
    }

    protected boolean isUrlLastPage(String s)
    {
        while (TextUtils.isEmpty(s) || lastPagePattern == null || !lastPagePattern.matcher(s).matches()) 
        {
            return false;
        }
        return true;
    }

    protected boolean isUrlPastLastPage(String s)
    {
        boolean flag1 = true;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (s.startsWith("http://www.ebay.com/mobile-redirect-done")) goto _L4; else goto _L3
_L3:
        if (donePattern == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (donePattern.matcher(s).matches()) goto _L4; else goto _L5
_L5:
        s = Uri.parse(s);
        return s.isHierarchical() && s.getQueryParameter(COMPLETION_STATUS) != null;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR lookupswitch 2: default 28
    //                   2: 44
    //                   65: 29;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (j == -1)
        {
            onPostCreate();
            return;
        } else
        {
            finish();
            return;
        }
_L2:
        if (filePathCallback == null) goto _L1; else goto _L4
_L4:
        Uri auri[];
        Object obj;
        obj = null;
        auri = obj;
        if (j != -1) goto _L6; else goto _L5
_L5:
        if (intent != null) goto _L8; else goto _L7
_L7:
        auri = obj;
        if (cameraPhotoPath != null)
        {
            auri = new Uri[1];
            auri[0] = Uri.parse(cameraPhotoPath);
        }
_L6:
        filePathCallback.onReceiveValue(auri);
        filePathCallback = null;
        return;
_L8:
        intent = intent.getDataString();
        auri = obj;
        if (intent != null)
        {
            auri = new Uri[1];
            auri[0] = Uri.parse(intent);
        }
        if (true) goto _L6; else goto _L9
_L9:
    }

    public void onBackPressed()
    {
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("onBackPressed() isDoneFlag: ").append(isDoneFlag).toString());
            log.log((new StringBuilder()).append("onBackPressed() useBackStack: ").append(useBackStack).toString());
            log.log((new StringBuilder()).append("onBackPressed() webview.canGoBack(): ").append(webview.canGoBack()).toString());
            log.log((new StringBuilder()).append("onBackPressed() numHistoryToSkip: ").append(numHistoryToSkip).toString());
            log.log((new StringBuilder()).append("onBackPressed() currentIndex: ").append(webview.copyBackForwardList().getCurrentIndex()).toString());
        }
        if (!isDoneFlag && useBackStack && webview.canGoBack() && webview.copyBackForwardList().getCurrentIndex() > numHistoryToSkip)
        {
            webview.goBack();
            return;
        }
        if (webview.canGoBack())
        {
            super.onBackPressed();
            return;
        } else
        {
            onDone();
            return;
        }
    }

    public void onClick(View view)
    {
        int i;
        if (view == null)
        {
            i = -1;
        } else
        {
            i = view.getId();
        }
        if (0x7f10064b == i)
        {
            onDone();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (scrollContainer != null)
        {
            int i = (int)getResources().getDimension(0x7f090007);
            webview.setVisibility(4);
            scrollContainer.setPadding(i, 0, i, 0);
            webview.post(new Runnable() {

                final ShowWebViewActivity this$0;

                public void run()
                {
                    webview.setVisibility(0);
                }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requireAuth = requireAuth | getIntent().getBooleanExtra(EXTRA_REQUIRE_AUTH, false);
        if (requireAuth && !MyApp.getPrefs().isSignedIn())
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 65);
            return;
        } else
        {
            onPostCreate();
            return;
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        android.support.v7.app.AlertDialog.Builder builder;
        switch (i)
        {
        case 2131165519: 
        case 2131165520: 
        default:
            return super.onCreateDialog(i);

        case 2131165518: 
        case 2131165521: 
            builder = new android.support.v7.app.AlertDialog.Builder(this);
            break;
        }
        builder.setMessage(i).setCancelable(false).setTitle(0x7f070130).setPositiveButton(0x7f070920, new android.content.DialogInterface.OnClickListener() {

            final ShowWebViewActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                isHandlingError = false;
                onRefresh();
                dialoginterface.cancel();
            }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
        }).setNegativeButton(0x7f0701cc, new android.content.DialogInterface.OnClickListener() {

            final ShowWebViewActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                onDone();
            }

            
            {
                this$0 = ShowWebViewActivity.this;
                super();
            }
        });
        return builder.create();
    }

    protected void onDone()
    {
        onDone(true);
    }

    protected void onDone(boolean flag)
    {
        Intent intent = new Intent();
        Uri uri;
        String s;
        uri = Uri.parse(url);
        s = uri.getQueryParameter(COMPLETION_STATUS);
        if (!"success".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
_L3:
        boolean flag1;
        try
        {
            s = uri.getQueryParameter(COMPLETION_ERRORID);
            if (!TextUtils.isEmpty(s))
            {
                intent.putExtra(RESULT_VALUE_ERRORID, s);
            }
            s = uri.getQueryParameter(COMPLETION_USERID);
            if (!TextUtils.isEmpty(s))
            {
                intent.putExtra(RESULT_VALUE_USERID, s);
            }
            s = uri.getQueryParameter(COMPLETION_EMAIL);
            if (!TextUtils.isEmpty(s))
            {
                intent.putExtra(RESULT_VALUE_EMAIL, s);
            }
            readAdditionalQueryParameters(uri, intent);
        }
        catch (Exception exception)
        {
            byte0 = 0;
        }
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("onDone() return code: ").append(byte0).toString());
            log.log((new StringBuilder()).append("onDone() final url: ").append(url).toString());
            log.log((new StringBuilder()).append("onDone() finishing: ").append(flag).toString());
        }
        setWebViewResult(byte0, intent);
        if (flag)
        {
            finish();
        }
        return;
_L2:
        if (!"error".equalsIgnoreCase(s))
        {
            break MISSING_BLOCK_LABEL_250;
        }
        byte0 = -1;
          goto _L3
        flag1 = isDoneFlag;
        if (flag1)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
          goto _L3
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }

    protected void onPageFinished(WebView webview1, String s)
    {
    }

    protected void onPageStarted(WebView webview1, String s, Bitmap bitmap)
    {
    }

    protected void onPostCreate()
    {
        readIntent();
        if (addRedirectUrl)
        {
            url = addRedirectUrlToUrl(url);
        }
        setContentView(layout);
        createUI();
        if (addDeviceId)
        {
            getDeviceIdThenRefresh();
            return;
        } else
        {
            onRefresh();
            return;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = super.onPrepareOptionsMenu(menu);
        menu = menu.findItem(0x7f1009e6);
        if (menu != null)
        {
            menu.setVisible(false);
            menu.setEnabled(false);
        }
        return flag;
    }

    protected void onRefresh()
    {
        boolean flag1;
        boolean flag = true;
        Object obj = DeviceConfiguration.getAsync();
        showProgress(true);
        if (!useSso || !((DeviceConfiguration) (obj)).get(DcsBoolean.SSO))
        {
            flag = false;
        }
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        obj = MyApp.getPrefs().getAuthentication();
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        obj = new SsoScopeLoader(getEbayContext(), ((com.ebay.nautilus.domain.app.Authentication) (obj)), scope, url);
        getFwLoaderManager().start(1, ((FwLoader) (obj)), false);
        flag1 = flag;
_L2:
        if (!flag1)
        {
            webview.loadUrl(url, headers);
        }
        return;
        Exception exception;
        exception;
        flag1 = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onResume()
    {
        super.onResume();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        if (trackingTag != null && trackingTag.length > 1)
        {
            trackingdata.addKeyValuePair(trackingTag[0], trackingTag[1]);
        }
        trackingdata.send(this);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        if (isFinishing())
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            fwloader = (SsoScopeLoader)fwloader;
            break;
        }
        if (fwloader.isError())
        {
            if (Util.hasNetwork())
            {
                log.logAsError((new StringBuilder()).append("SSO failed: ").append(((SsoScopeLoader) (fwloader)).errorCode).append(" ").append(((SsoScopeLoader) (fwloader)).errorDescription).toString());
                webview.loadUrl(url, headers);
                return;
            } else
            {
                (new EbayErrorHandler(this)).handleEbayError(null, fwloader);
                finish();
                return;
            }
        } else
        {
            ssoUrl = fwloader.getSsoUrl();
            webview.loadUrl(ssoUrl, headers);
            return;
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return gDetector.onTouchEvent(motionevent);
    }

    protected void readAdditionalQueryParameters(Uri uri, Intent intent)
    {
    }

    protected void readIntent()
    {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("android.intent.extra.TITLE");
        impression = intent.getStringExtra("impression");
        trackingTag = intent.getStringArrayExtra("trackingPair");
        layout = intent.getIntExtra("layout", 0x7f03024b);
        backgroundColor = intent.getIntExtra("backgroundColor", -1);
        maxWidth = intent.getIntExtra("maxWidth", -1);
        useOkButton = intent.getBooleanExtra("ok", false);
        useBackStack = intent.getBooleanExtra("back", false);
        lastPagePattern = getPatternExtra(intent, EXTRA_LAST_PAGE_PATTERN);
        donePattern = getPatternExtra(intent, EXTRA_DONE_PATTERN);
        useMenuHandler = intent.getBooleanExtra(EXTRA_SHOW_MENU, true);
        useWideViewPort = intent.getBooleanExtra(EXTRA_USE_WIDE_VIEWPORT, true);
        useSso = intent.getBooleanExtra("use_sso", false);
        addDeviceId = intent.getBooleanExtra("add_device_id", true);
        addRedirectUrl = intent.getBooleanExtra("add_redirect_url", false);
        numHistoryToSkip = intent.getIntExtra(EXTRA_NUM_HISTORY_TO_SKIP, 0);
        scope = intent.getStringExtra(EXTRA_SCOPE);
        useLessProgressSpinner = intent.getBooleanExtra("lessProgress", false);
        enableFileDownload = intent.getBooleanExtra("enablefileDownload", false);
        if (TextUtils.isEmpty(scope))
        {
            scope = "//EBAYSSO/EBAYCLASSIC";
        }
        headers = (HashMap)intent.getSerializableExtra("headers");
    }

    protected String rewriteUri(String s)
    {
        String s1 = s;
        if (urlRewriter != null)
        {
            s1 = urlRewriter.rewriteUri(s);
        }
        return s1;
    }

    protected final void setWebViewResult(int i, Intent intent)
    {
        resultCode = i;
        resultData = intent;
        setResult(i, intent);
    }

    protected boolean shouldOverrideUrlLoading(WebView webview1, String s)
    {
        return false;
    }

    protected void showProgress(boolean flag)
    {
        show(progressView, flag);
    }

}
