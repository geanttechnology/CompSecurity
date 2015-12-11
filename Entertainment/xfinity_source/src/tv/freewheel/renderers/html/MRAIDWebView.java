// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.html;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Message;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.VideoView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.URIUtil;

// Referenced classes of package tv.freewheel.renderers.html:
//            MRAIDCustomViewBackgroundView, HTMLRenderer, Parameters, MRAIDBackgroundView

final class MRAIDWebView extends WebView
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{
    private static interface ILoggerBridge
    {
    }

    private class downloadHTMLContentTask extends AsyncTask
    {

        private Boolean fail;
        private String script;
        final MRAIDWebView this$0;
        private String url;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            Object obj;
            String s1;
            int i;
            script = as[1];
            obj = as[0];
            s1 = "";
            as = "";
            if (!URLUtil.isValidUrl(((String) (obj))))
            {
                break MISSING_BLOCK_LABEL_341;
            }
            url = ((String) (obj));
            i = 0;
_L6:
            String as1[];
            String as2[];
            Object obj1;
            obj1 = null;
            as1 = as;
            as2 = as;
            obj = (HttpURLConnection)(HttpURLConnection)(new URL(((String) (obj)))).openConnection();
            as1 = as;
            obj1 = obj;
            as2 = as;
            ((HttpURLConnection) (obj)).setInstanceFollowRedirects(false);
            as1 = as;
            obj1 = obj;
            as2 = as;
            ((HttpURLConnection) (obj)).connect();
            as1 = as;
            obj1 = obj;
            as2 = as;
            if (((HttpURLConnection) (obj)).getResponseCode() == 302) goto _L2; else goto _L1
_L1:
            as1 = as;
            obj1 = obj;
            as2 = as;
            Object obj2 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L4:
            as1 = as;
            obj1 = obj;
            as2 = as;
            String s2 = ((BufferedReader) (obj2)).readLine();
            if (s2 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            as1 = as;
            obj1 = obj;
            as2 = as;
            as = (new StringBuilder()).append(as).append(s2).append("\n").toString();
            if (true) goto _L4; else goto _L3
_L3:
            as1 = as;
            obj1 = obj;
            as2 = as;
            ((BufferedReader) (obj2)).close();
            as1 = as;
            obj1 = obj;
            as2 = as;
            fail = Boolean.valueOf(false);
            obj = s1;
_L7:
            int j;
            if (fail.booleanValue())
            {
                return ((String) (obj));
            } else
            {
                return as;
            }
_L2:
            as1 = as;
            obj1 = obj;
            as2 = as;
            obj2 = ((HttpURLConnection) (obj)).getHeaderField("Location");
            j = i + 1;
            as1 = as;
            obj1 = obj;
            as2 = as;
            ((HttpURLConnection) (obj)).disconnect();
            i = j;
            obj = obj2;
            if (j <= 3) goto _L6; else goto _L5
_L5:
            obj = s1;
              goto _L7
            as;
            obj = as.toString();
            as = as1;
              goto _L7
            as;
            String s = (new StringBuilder()).append("Failed to get content from creative url.").append(as.toString()).toString();
            obj = s;
            as = as2;
            if (obj1 != null)
            {
                ((HttpURLConnection) (obj1)).disconnect();
                obj = s;
                as = as2;
            }
              goto _L7
            obj = (new StringBuilder()).append("Invalid url:").append(((String) (obj))).toString();
              goto _L7
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            if (fail.booleanValue())
            {
                logger.error(s);
                bridge.mraidLoadFail(100, s);
                return;
            } else
            {
                s = injectScriptToHTML(s, "");
                loadDataWithBaseURL(url, s, "text/html", "utf8", null);
                return;
            }
        }

        private downloadHTMLContentTask()
        {
            this$0 = MRAIDWebView.this;
            super();
            fail = Boolean.valueOf(true);
            script = "";
            url = "";
        }

    }


    private final String BRIDGE_NAME_IN_JS = "FW_MRAID_RENDERER";
    private final String LOGGER_BRIDGE_NAME_IN_JS = "FW_LOGGER";
    private Activity activity;
    private String baseURL;
    private HTMLRenderer bridge;
    private VideoView customVideoView;
    private View customView;
    private boolean enableMRAID;
    private MRAIDBackgroundView fullScreenBackgroundView;
    private boolean isFullScreen;
    private Logger logger;
    private final ILoggerBridge loggerBridge = new ILoggerBridge() {

        final MRAIDWebView this$0;

            
            {
                this$0 = MRAIDWebView.this;
                super();
            }
    };
    private boolean pageLoaded;
    private boolean pageShown;
    private WebChromeClient webChromeClient;
    private boolean withLoadedCallBack;

    public MRAIDWebView(Activity activity1, HTMLRenderer htmlrenderer, boolean flag, boolean flag1)
    {
        super(activity1);
        baseURL = "";
        bridge = null;
        withLoadedCallBack = true;
        isFullScreen = false;
        enableMRAID = true;
        pageLoaded = false;
        pageShown = false;
        activity = null;
        webChromeClient = null;
        fullScreenBackgroundView = null;
        customView = null;
        customVideoView = null;
        logger = Logger.getLogger(this);
        activity = activity1;
        withLoadedCallBack = flag;
        enableMRAID = flag1;
        init(htmlrenderer);
    }

    private void init(final HTMLRenderer bridge)
    {
        this.bridge = bridge;
        setFocusable(true);
        setFocusableInTouchMode(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSaveFormData(false);
        getSettings().setSavePassword(false);
        getSettings().setSupportZoom(false);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setAllowFileAccess(false);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        getSettings().setGeolocationEnabled(false);
        webChromeClient = new WebChromeClient() {

            private SurfaceView customSurfaceView;
            private android.webkit.WebChromeClient.CustomViewCallback customViewCallback;
            private ViewGroup holder;
            final MRAIDWebView this$0;

            public View getVideoLoadingProgressView()
            {
                logger.debug("getVideoLoadingProgressView");
                return new ProgressBar(getContext());
            }

            public void onConsoleMessage(String s, int i, String s1)
            {
                logger.debug((new StringBuilder()).append(s).append(" -- From line ").append(i).append(" of ").append(s1).toString());
            }

            public void onHideCustomView()
            {
                logger.debug("onHideCustomView");
                if (customView == null)
                {
                    return;
                }
                setVisibility(0);
                customViewCallback.onCustomViewHidden();
                if (holder != null)
                {
                    holder.removeView(customView);
                }
                customView = null;
                customVideoView = null;
                holder = null;
                customViewCallback = null;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    fullScreenBackgroundView.hideFullScreenBackground();
                }
                requestFocus();
            }

            public void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
            {
                logger.debug("onShowCustomView");
                super.onShowCustomView(view, customviewcallback);
                if (customVideoView != null)
                {
                    logger.debug("The custom video is alive, no need to show it again");
                    return;
                }
                if (view instanceof FrameLayout)
                {
                    FrameLayout framelayout = (FrameLayout)view;
                    View view1 = framelayout.getFocusedChild();
                    int i;
                    if (view1 instanceof VideoView)
                    {
                        customVideoView = (VideoView)framelayout.getFocusedChild();
                        customVideoView.setOnCompletionListener(MRAIDWebView.this);
                        customVideoView.setOnErrorListener(MRAIDWebView.this);
                    } else
                    {
                        if (view1 instanceof SurfaceView)
                        {
                            logger.debug("The custom view is surface view.");
                            customSurfaceView = (SurfaceView)view1;
                            customSurfaceView.setZOrderMediaOverlay(true);
                        } else
                        {
                            customSurfaceView = null;
                        }
                        customVideoView = null;
                    }
                } else
                {
                    customVideoView = null;
                }
                customView = view;
                customViewCallback = customviewcallback;
                holder = (ViewGroup)getParent();
                i = 1;
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    fullScreenBackgroundView.showFullScreenBackground();
                    holder = fullScreenBackgroundView;
                    i = 0;
                }
                customviewcallback = new android.widget.FrameLayout.LayoutParams(-1, -1);
                setVisibility(4);
                holder.addView(view, i, customviewcallback);
                holder.bringToFront();
            }

            
            {
                this$0 = MRAIDWebView.this;
                super();
                holder = null;
                customViewCallback = null;
                customSurfaceView = null;
            }
        };
        setWebChromeClient(webChromeClient);
        Boolean boolean1;
        if (enableMRAID)
        {
            fullScreenBackgroundView = new MRAIDCustomViewBackgroundView(activity, webChromeClient);
        } else
        {
            fullScreenBackgroundView = new MRAIDBackgroundView(activity);
        }
        if (enableMRAID)
        {
            logger.debug("enabling MRAID for the webView");
            addJavascriptInterface(loggerBridge, "FW_LOGGER");
            addJavascriptInterface(this.bridge, "FW_MRAID_RENDERER");
        }
        boolean1 = bridge.parameters().shouldBackgroundTransparent;
        if (boolean1 != null && boolean1.booleanValue())
        {
            logger.debug((new StringBuilder()).append("enabling transparent: ").append(bridge.parameters().bootstrap).toString());
            setBackgroundColor(0);
            setBackgroundDrawable(null);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                try
                {
                    android/view/View.getMethod("setLayerType", new Class[] {
                        Integer.TYPE, android/graphics/Paint
                    }).invoke(this, new Object[] {
                        Integer.valueOf(1), new Paint()
                    });
                }
                catch (Exception exception) { }
            }
        }
        setWebViewClient(new WebViewClient() {

            final MRAIDWebView this$0;
            final HTMLRenderer val$bridge;

            public void onLoadResource(WebView webview, String s)
            {
                logger.debug((new StringBuilder()).append("onLoadResource, url:").append(s).toString());
                super.onLoadResource(webview, s);
            }

            public void onPageFinished(WebView webview, String s)
            {
                logger.debug((new StringBuilder()).append("onPageFinished, url=").append(s).append(", withLoadedCallBack=").append(withLoadedCallBack).toString());
                super.onPageFinished(webview, s);
                pageLoaded = true;
                setBaseURL(s);
                tryTriggerLoaded();
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                logger.debug((new StringBuilder()).append("onPageStarted, url=").append(s).toString());
                pageLoaded = false;
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                logger.error((new StringBuilder()).append("onReceivedError, failingUrl:").append(s1).append(", description:").append(s).toString());
                super.onReceivedError(webview, i, s, s1);
                if (!pageLoaded)
                {
                    bridge.mraidLoadFail(i, s);
                }
            }

            public void onScaleChanged(WebView webview, float f, float f1)
            {
                logger.debug((new StringBuilder()).append("onScaleChanged, oldScale=").append(f).append(", newScale=").append(f1).toString());
                super.onScaleChanged(webview, f, f1);
            }

            public void onTooManyRedirects(WebView webview, Message message, Message message1)
            {
                logger.debug((new StringBuilder()).append("onTooManyRedirects, cancel message:").append(message).toString());
                super.onTooManyRedirects(webview, message, message1);
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                logger.debug((new StringBuilder()).append("shouldOverrideUrlLoading, url=").append(s).toString());
                return bridge.shouldOverrideUrlLoading(webview, s);
            }

            
            {
                this$0 = MRAIDWebView.this;
                bridge = htmlrenderer;
                super();
            }
        });
        if (withLoadedCallBack)
        {
            getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final MRAIDWebView this$0;

                public void onGlobalLayout()
                {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    pageShown = true;
                    tryTriggerLoaded();
                }

            
            {
                this$0 = MRAIDWebView.this;
                super();
            }
            });
        }
    }

    private String injectScriptToHTML(String s, String s1)
    {
        logger.debug((new StringBuilder()).append("Inject script into html: ").append(s).toString());
        String s3 = "";
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        s1 = s3;
        if (enableMRAID)
        {
            s1 = (new StringBuilder()).append("(function(){window.mraid=new function(){this.expandProperties={width:0,height:0,useCustomClose:!1,isModal:!0};this.maxSize={width:0,height:0};this.screenSize={width:0,height:0};this.defaultPosition={x:0,y:0,width:0,height:0};this.currentPosition={x:0,y:0,width:0,height:0};this.supportsFeatures={sms:!1,tel:!1,calendar:!1,storePicture:!1,inlineVideo:!1};this.resizeProperties={};this.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\"};this.state=\"loading\";this.placementType=null; \nthis.listeners={};this.viewable=!0;this._Update=function(a,b,c,d,e,h,i,j,f,k){var g=this.state,l=b!=this.viewable,f=JSON.parse(f),m=f.width!=this.currentPosition.width||f.height!=this.currentPosition.height;this.state=a;this.viewable=b;this.placementType=c;this.expandProperties=JSON.parse(d);this.resizeProperties=JSON.parse(e);this.maxSize=JSON.parse(h);this.screenSize=JSON.parse(i);this.defaultPosition=JSON.parse(j);this.currentPosition=f;\"loading\"==g&&\"default\"==a&&this.dispatchEvent(\"ready\");l&& \nthis.dispatchEvent(\"viewableChange\",b);\"loading\"!=g&&\"hidden\"!=a&&m&&this.dispatchEvent(\"sizeChange\",f.width,f.height);(g!=a||\"resized\"==a&&\"resized\"==g&&k)&&this.dispatchEvent(\"stateChange\",a)};this._setSupportingFeatures=function(a,b,c,d,e){this.supportsFeatures={sms:a,tel:b,calendar:c,storePicture:d,inlineVideo:e}};this._log=function(a){try{FW_LOGGER.log(a)}catch(b){void 0!==window.console&&window.console.log(a+\", error:\"+b)}};this._debug=function(a){try{FW_LOGGER.debug(a)}catch(b){void 0!==window.console&& \nwindow.console.log(a+\", error:\"+b)}};this.addEventListener=function(a,b){void 0===this.listeners[a]&&(this.listeners[a]=[]);this.listeners[a].push(b)};this.removeEventListener=function(a,b){if(this.listeners[a]instanceof Array){var c=this.listeners[a],d,e;if(null!==c){e=c.length;for(d=0;d<e;d++)if(c[d]===b){c.splice(d,1);break}}}};this.dispatchEvent=function(a){if(void 0!==a&&this.listeners[a]instanceof Array){var b=this.listeners[a],c,d;d=b.length;for(c=0;c<d;c++)try{b[c]&&b[c].apply(this,Array.prototype.slice.call(arguments, \n1))}catch(e){this._debug(\"Exception in dispatchEvent:event=\"+a+\", exception=\"+e.toString())}}};this.onError=function(a,b){this._debug(\"onError: message=\"+a+\", action=\"+b)};this.open=function(a){try{FW_MRAID_RENDERER.mraidOpen(encodeURI(a.toString()))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"open\")}};this.close=function(){try{FW_MRAID_RENDERER.mraidClose()}catch(a){this.dispatchEvent(\"error\",\"\"+a,\"close\")}};this.useCustomClose=function(a){this.expandProperties.useCustomClose=!!a;try{FW_MRAID_RENDERER.mraidUseCustomClose(this.expandProperties.useCustomClose)}catch(b){this.dispatchEvent(\"error\", \n\"\"+b,\"close\")}};this.expand=function(a){try{void 0===a?FW_MRAID_RENDERER.mraidExpand():FW_MRAID_RENDERER.mraidExpand(encodeURI(a.toString()))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"expand\")}};this.setExpandProperties=function(a){this.expandProperties.width=\"undefined\"===typeof a||\"undefined\"===typeof a.width?0:Math.round(a.width);this.expandProperties.height=\"undefined\"===typeof a||\"undefined\"===typeof a.height?0:Math.round(a.height);this.expandProperties.useCustomClose=\"undefined\"===typeof a|| \n\"undefined\"===typeof a.useCustomClose?!1:!!a.useCustomClose;try{FW_MRAID_RENDERER.setExpandProperties(JSON.stringify(this.expandProperties))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"setExpandProperties\")}};this.detachBridgeInterface=function(){this.open=this.close=this.expand=this.setExpandProperties=function(){};this._log=this._debug=function(){}};this.getExpandProperties=function(){return this.expandProperties};this.isViewable=function(){return this.viewable};this.getState=function(){return this.state}; \nthis.getVersion=function(){return\"2.0\"};this.getPlacementType=function(){return this.placementType};this.createCalendarEvent=function(a){try{FW_MRAID_RENDERER.createCalendarEvent(JSON.stringify(a))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"createCalendarEvent\")}};this.getOrientationProperties=function(){return this.orientationProperties};this.setOrientationProperties=function(){this.dispatchEvent(\"error\",\"Not supported\",\"setOrientationProperties\")};this.getCurrentPosition=function(){return this.currentPosition}; \nthis.getDefaultPosition=function(){return this.defaultPosition};this.getMaxSize=function(){return this.maxSize};this.getResizeProperties=function(){return this.resizeProperties};this.setResizeProperties=function(a){if(\"undefined\"===typeof a||\"undefined\"===typeof a.width||\"undefined\"===typeof a.height||\"undefined\"===typeof a.offsetX||\"undefined\"===typeof a.offsetY)this.dispatchEvent(\"error\",\"Missing required parameters\",\"setResizeProperties\");else{this.resizeProperties.width=Math.round(a.width);this.resizeProperties.height= \nMath.round(a.height);this.resizeProperties.offsetX=Math.round(a.offsetX);this.resizeProperties.offsetY=Math.round(a.offsetY);this.resizeProperties.customClosePosition=\"undefined\"===typeof a.customClosePosition?\"top-right\":a.customClosePosition;this.resizeProperties.allowOffscreen=\"undefined\"!==typeof a.allowOffscreen&&!1===a.allowOffscreen?!1:!0;try{FW_MRAID_RENDERER.setResizeProperties(JSON.stringify(this.resizeProperties))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"setResizeProperties\")}}};this.resize= \nfunction(){try{FW_MRAID_RENDERER.mraidResize()}catch(a){this.dispatchEvent(\"error\",\"\"+a,\"resize\")}};this.getScreenSize=function(){return this.screenSize};this.playVideo=function(a){try{FW_MRAID_RENDERER.playVideo(encodeURI(a.toString()))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"playVideo\")}};this.storePicture=function(){this.dispatchEvent(\"error\",\"Not supported\",\"storePicture\")};this.supports=function(a){return!!this.supportsFeatures[a]};this.addEventListener(\"error\",this.onError)}})(); \n\n").append(s2).append("\n").toString();
        }
        s2 = s1;
        if (bridge.parameters().bootstrap != null)
        {
            s2 = s1;
            if (bridge.parameters().bootstrap.length() > 0)
            {
                logger.debug((new StringBuilder()).append("bootstrap js code: ").append(bridge.parameters().bootstrap).toString());
                s2 = (new StringBuilder()).append(s1).append(bridge.parameters().bootstrap).toString();
            }
        }
        s1 = (new StringBuilder()).append("<script type=\"text/javascript\">").append(s2).append("</script>\n").toString();
        int i = s.indexOf("<head>");
        if (i < 0)
        {
            i = s.indexOf("<script>");
            if (i < 0)
            {
                i = 0;
            } else
            {
                i--;
            }
        } else
        {
            i += 6;
        }
        if (i == 0)
        {
            return (new StringBuilder()).append(s1).append(s).toString();
        } else
        {
            return (new StringBuilder()).append(s.substring(0, i)).append(s1).append(s.substring(i)).toString();
        }
    }

    private void setBaseURL(String s)
    {
        Object obj;
        logger.debug((new StringBuilder()).append("setBaseURL(").append(s).append(")").toString());
        while (s == null || s.trim().length() == 0 || !URLUtil.isHttpUrl(s) && !URLUtil.isHttpsUrl(s)) 
        {
            return;
        }
        StringBuilder stringbuilder;
        try
        {
            obj = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.debug(s.toString());
            return;
        }
        if (obj == null || ((URL) (obj)).getProtocol() == null) goto _L2; else goto _L1
_L1:
        baseURL = ((URL) (obj)).getProtocol();
        baseURL = (new StringBuilder()).append(baseURL).append("://").toString();
        stringbuilder = (new StringBuilder()).append(baseURL);
        if (((URL) (obj)).getAuthority() != null)
        {
            s = ((URL) (obj)).getAuthority();
        } else
        {
            s = "";
        }
        baseURL = stringbuilder.append(s).toString();
        obj = ((URL) (obj)).getPath();
        if (obj != null) goto _L4; else goto _L3
_L3:
        s = "";
_L6:
        baseURL = (new StringBuilder()).append(baseURL).append(s).append("/").toString();
_L2:
        logger.debug((new StringBuilder()).append("base url:").append(baseURL).toString());
        return;
_L4:
        int i = ((String) (obj)).lastIndexOf("/");
        s = ((String) (obj));
        if (i >= 0)
        {
            s = ((String) (obj)).substring(0, i);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void tryTriggerLoaded()
    {
        this;
        JVM INSTR monitorenter ;
        if (withLoadedCallBack && enableMRAID && pageLoaded && pageShown)
        {
            bridge.mraidLoaded();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    String URLWithBaseURL(String s)
    {
        String s1 = null;
        if (s != null && s.trim().length() != 0) goto _L2; else goto _L1
_L1:
        s1 = baseURL;
_L4:
        return s1;
_L2:
        Object obj;
        String s3;
        logger.debug((new StringBuilder()).append("URLWithBaseURL: url passed in: ").append(s).toString());
        s3 = s.trim();
        obj = null;
        s = new URI(s3);
_L5:
        if (s != null)
        {
            if (s.isAbsolute())
            {
                return s.toString();
            }
            break MISSING_BLOCK_LABEL_145;
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        String s2 = URIUtil.getFixedString(s3);
        s = s2;
        if (s2 != null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        s = (new URI(null, null, s3, null)).toString();
        s = new URI(s);
          goto _L5
        s;
        logger.debug(s.getMessage());
        s = obj;
          goto _L5
        try
        {
            s = (new URL(new URL(baseURL), s.toString())).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logger.debug(s.getMessage());
            return null;
        }
        return s;
    }

    public void closeCustomView()
    {
        logger.debug("closeCustomView");
        try
        {
            if (customVideoView != null)
            {
                customVideoView.stopPlayback();
            }
            if (customView != null)
            {
                webChromeClient.onHideCustomView();
            }
            return;
        }
        catch (Throwable throwable)
        {
            logger.debug(throwable.toString());
        }
    }

    public void dispose()
    {
        logger.debug("dispose");
        setWebChromeClient(null);
        setWebViewClient(null);
        runJavaScript("window.mraid.detachBridgeInterface();");
        super.loadUrl("about:blank");
    }

    public void loadCreativeWithScript(String s, String s1, String s2)
    {
        logger.debug((new StringBuilder()).append("load creative url: ").append(s).append(" or content: ").append(s1).append(" with script:").append(s2).toString());
        if (s == null || s.trim().length() == 0)
        {
            loadDataWithBaseURL(null, injectScriptToHTML(s1, s2), "text/html", "utf8", null);
            return;
        } else
        {
            (new downloadHTMLContentTask()).execute(new String[] {
                s, s2
            });
            return;
        }
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        String s5;
label0:
        {
            logger.debug("loadDataWithBaseURL");
            if (s != null)
            {
                s5 = s;
                if (s.trim().length() != 0)
                {
                    break label0;
                }
            }
            s5 = "http://m1.fwmrm.net/ad/mraid/start/";
        }
        baseURL = (new StringBuilder()).append(s5).append("/").toString();
        super.loadDataWithBaseURL(s5, s1, s2, s3, s4);
    }

    protected void onAttachedToWindow()
    {
        logger.debug("onAttachedToWindow");
        super.onAttachedToWindow();
        boolean flag = supportsInlineVideo();
        logger.info((new StringBuilder()).append("Android API level ").append(android.os.Build.VERSION.SDK_INT).append(", hardware acceleration ").append(flag).toString());
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        logger.debug("onCompletion ot the video");
        webChromeClient.onHideCustomView();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        logger.debug((new StringBuilder()).append("onError ot the video what=").append(i).append(",extra=").append(j).toString());
        webChromeClient.onHideCustomView();
        return false;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        logger.debug((new StringBuilder()).append("onKeyDown,keyCode:").append(i).append(", isFullScreen:").append(isFullScreen).toString());
        if (!isFullScreen)
        {
            return false;
        }
        if (i == 4)
        {
            bridge.mraidClose();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void runJavaScript(String s)
    {
        logger.debug((new StringBuilder()).append("runJavaScript(").append(s).append(")").toString());
        if (s != null && s.length() != 0)
        {
            super.loadUrl((new StringBuilder()).append("javascript:").append(s).toString());
        }
    }

    void setFullScreen(boolean flag)
    {
        isFullScreen = flag;
    }

    public boolean supportsInlineVideo()
    {
        Object obj3;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return false;
        }
        obj3 = null;
        flag1 = false;
        Object obj = getClass().getMethod("isHardwareAccelerated", (Class[])null);
        Object obj4 = ((Method) (obj)).invoke(this, (Object[])null);
        boolean flag;
        obj = obj3;
        flag = flag1;
        if (!(obj4 instanceof Boolean))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        flag = ((Boolean)obj4).booleanValue();
        obj = obj3;
_L1:
        if (obj != null)
        {
            logger.debug(((String) (obj)));
        }
        Object obj1;
        if (flag)
        {
            logger.debug("using HardWare Acceleration");
            return flag;
        } else
        {
            logger.warn("No HardWare Acceleration, the inline video is not supported");
            return flag;
        }
        obj1;
        obj1 = ((IllegalArgumentException) (obj1)).toString();
        flag = flag1;
          goto _L1
        obj1;
        obj1 = ((IllegalAccessException) (obj1)).toString();
        flag = flag1;
          goto _L1
        obj1;
        obj1 = ((InvocationTargetException) (obj1)).toString();
        flag = flag1;
          goto _L1
        Object obj2;
        obj2;
        obj2 = ((SecurityException) (obj2)).toString();
        if (obj2 != null)
        {
            logger.debug(((String) (obj2)));
        }
        if (false)
        {
            logger.debug("using HardWare Acceleration");
            return false;
        } else
        {
            logger.warn("No HardWare Acceleration, the inline video is not supported");
            return false;
        }
        obj2;
        obj2 = ((NoSuchMethodException) (obj2)).toString();
        if (obj2 != null)
        {
            logger.debug(((String) (obj2)));
        }
        if (false)
        {
            logger.debug("using HardWare Acceleration");
            return false;
        } else
        {
            logger.warn("No HardWare Acceleration, the inline video is not supported");
            return false;
        }
        obj2;
        if (false)
        {
            logger.debug(null);
        }
        if (false)
        {
            logger.debug("using HardWare Acceleration");
        } else
        {
            logger.warn("No HardWare Acceleration, the inline video is not supported");
        }
        throw obj2;
    }





/*
    static VideoView access$102(MRAIDWebView mraidwebview, VideoView videoview)
    {
        mraidwebview.customVideoView = videoview;
        return videoview;
    }

*/



/*
    static View access$202(MRAIDWebView mraidwebview, View view)
    {
        mraidwebview.customView = view;
        return view;
    }

*/




/*
    static boolean access$402(MRAIDWebView mraidwebview, boolean flag)
    {
        mraidwebview.pageLoaded = flag;
        return flag;
    }

*/





/*
    static boolean access$802(MRAIDWebView mraidwebview, boolean flag)
    {
        mraidwebview.pageShown = flag;
        return flag;
    }

*/

}
