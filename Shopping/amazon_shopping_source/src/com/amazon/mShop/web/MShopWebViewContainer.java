// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonProgressDialog;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.error.AmazonErrorBox;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.ui.BottomToolBar;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.WebUtils;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebActivity, MShopWebView, MShopWebViewClient, MShopWebChromeClient, 
//            MShopWebViewJavaScriptClient, MShopWebViewTransitionManager

public class MShopWebViewContainer extends FrameLayout
    implements TitleProvider, com.amazon.mShop.ui.BottomToolBar.ToolBarParent
{
    private class BottomButton extends com.amazon.mShop.ui.BottomToolBar.ToolBarItem
    {

        private String mOnTouchCallbackId;
        final MShopWebViewContainer this$0;

        public String getOnTouchCallbackId()
        {
            return mOnTouchCallbackId;
        }

        public void setOnTouchCallbackId(String s)
        {
            mOnTouchCallbackId = s;
        }

        public BottomButton(int i, String s, boolean flag)
        {
            this$0 = MShopWebViewContainer.this;
            super(i, s, flag);
        }
    }


    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private boolean hasContentHeightChanged;
    private boolean hasUpdatedVisitedHistory;
    private boolean hasWebviewAnimated;
    private boolean isPageFinished;
    private final BottomToolBar mBottomToolBar;
    private int mCurrHistIndex;
    private final Runnable mDismissSpinnerJob;
    private boolean mDismissSpinnerOnNonWebviewAnimation;
    private AmazonErrorBox mErrorBox;
    private final Handler mHandler;
    private boolean mIsHTTPBlockedErrorShown;
    private boolean mIsPageLoadHandledNatively;
    private volatile boolean mIsShowingSpinner;
    private boolean mIsUrlReloading;
    private BottomButton mLeftButton;
    private BottomButton mOldLeftButton;
    private BottomButton mOldRightButton;
    private boolean mPageHasStarted;
    private int mPendingIndex;
    private final View mProgressBarContainer;
    private AmazonProgressDialog mProgressDialog;
    private int mProgressHideSpinner;
    private int mProgressSpinnerInjectThreshold;
    private BottomButton mRightButton;
    private boolean mShouldClearHistory;
    private boolean mShouldDelayTransition;
    private boolean mShouldInjectAnimation;
    private Long mSpinnerAppearTimeStamp;
    private String mStartLoadingUrl;
    private final Object mSyncLockSpinner;
    private CharSequence mTitle;
    private final MShopWebViewTransitionManager mTransitionManager;
    private final MShopWebView mWebView;

    public MShopWebViewContainer(Context context)
    {
        this(context, null);
    }

    public MShopWebViewContainer(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, ((MShopWebActivity)context).createWebViewClient(), null);
    }

    public MShopWebViewContainer(Context context, AttributeSet attributeset, MShopWebViewClient mshopwebviewclient, MShopWebViewTransitionManager mshopwebviewtransitionmanager)
    {
        super(context, attributeset);
        mHandler = new Handler();
        mProgressHideSpinner = 50;
        mPendingIndex = -1;
        mSyncLockSpinner = new Object();
        mIsShowingSpinner = false;
        mProgressSpinnerInjectThreshold = 25;
        mCurrHistIndex = -1;
        hasUpdatedVisitedHistory = false;
        isPageFinished = false;
        hasWebviewAnimated = false;
        hasContentHeightChanged = false;
        mShouldInjectAnimation = false;
        mPageHasStarted = false;
        mIsUrlReloading = false;
        mDismissSpinnerJob = new Runnable() {

            final MShopWebViewContainer this$0;

            public void run()
            {
                if (mWebView != null && !mWebView.isDestroyed())
                {
                    if (MShopWebViewContainer.DEBUG)
                    {
                        Log.w("MShopWebViewContainer", "spinner removed by watchdog timer");
                    }
                    hideSpinner();
                }
            }

            
            {
                this$0 = MShopWebViewContainer.this;
                super();
            }
        };
        mSpinnerAppearTimeStamp = Long.valueOf(0L);
        mDismissSpinnerOnNonWebviewAnimation = false;
        mShouldDelayTransition = false;
        mIsPageLoadHandledNatively = false;
        mTransitionManager = mshopwebviewtransitionmanager;
        attributeset = new RelativeLayout(context);
        attributeset.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        mWebView = ((MShopWebActivity)context).createWebView();
        mWebView.setWebViewContainer(this);
        mshopwebviewclient.setWebViewContainer(this);
        mWebView.setWebViewClient(mshopwebviewclient);
        mshopwebviewclient.setWebView(mWebView);
        mshopwebviewtransitionmanager = new MShopWebChromeClient(this, (CordovaInterface)context, mWebView);
        mWebView.setWebChromeClient(mshopwebviewtransitionmanager);
        mshopwebviewtransitionmanager.setWebView(mWebView);
        mWebView.exposeJavaScriptClient(new MShopWebViewJavaScriptClient(context, this, mshopwebviewclient.getMASHNavDelegate()));
        mProgressBarContainer = View.inflate(context, com.amazon.mShop.android.lib.R.layout.progress_bar, null);
        mshopwebviewclient = new android.widget.FrameLayout.LayoutParams(-1, -1);
        mProgressBarContainer.setLayoutParams(mshopwebviewclient);
        boolean flag = ActivityUtils.isSpinnerV2Enabled();
        mshopwebviewclient = mProgressBarContainer;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        mshopwebviewclient.setVisibility(i);
        mBottomToolBar = (BottomToolBar)View.inflate(context, com.amazon.mShop.android.lib.R.layout.bottom_toolbar, null);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.addRule(2, mBottomToolBar.getId());
        mWebView.setLayoutParams(context);
        mWebView.setVerticalFadingEdgeEnabled(false);
        mWebView.setFadingEdgeLength(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.fading_edge_length));
        mWebView.setScrollBarStyle(0);
        context = new android.widget.RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.bottom_toolbar_height));
        context.addRule(12);
        mBottomToolBar.setLayoutParams(context);
        mBottomToolBar.setToolBarParent(this);
        mBottomToolBar.setVisibility(8);
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        attributeset.addView(mWebView);
        attributeset.addView(mBottomToolBar);
        addView(attributeset);
        addView(mProgressBarContainer);
        if (flag)
        {
            showSpinner();
        }
    }

    public MShopWebViewContainer(MShopWebActivity mshopwebactivity)
    {
        this(((Context) (mshopwebactivity)), null, mshopwebactivity.createWebViewClient(), ((MShopWebViewTransitionManager) (mshopwebactivity)));
    }

    private void applyOrientationToErrorBox(int i, int j)
    {
        Configuration configuration = new Configuration(getContext().getResources().getConfiguration());
        if (i <= j)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        configuration.orientation = i;
        mErrorBox.handleConfigurationChanged(configuration);
    }

    private void clearBottomToolBar()
    {
        mBottomToolBar.removeAllViews();
        mBottomToolBar.setVisibility(8);
        mOldLeftButton = null;
        mOldRightButton = null;
        if (mLeftButton != null)
        {
            mOldLeftButton = new BottomButton(0, mLeftButton.getItemName(), mLeftButton.isEnabled());
            mOldLeftButton.setOnTouchCallbackId(mLeftButton.getOnTouchCallbackId());
            mLeftButton = null;
        }
        if (mRightButton != null)
        {
            mOldRightButton = new BottomButton(1, mRightButton.getItemName(), mRightButton.isEnabled());
            mOldRightButton.setOnTouchCallbackId(mRightButton.getOnTouchCallbackId());
            mRightButton = null;
        }
    }

    private void clearError()
    {
        if (mErrorBox != null)
        {
            setErrorBox(null);
            mWebView.setVisibility(0);
        }
    }

    private void executeJavaScript(final String script)
    {
        mHandler.post(new Runnable() {

            final MShopWebViewContainer this$0;
            final String val$script;

            public void run()
            {
                if (mWebView != null && !mWebView.isDestroyed())
                {
                    mWebView.loadUrl((new StringBuilder()).append("javascript:").append(script).toString());
                }
            }

            
            {
                this$0 = MShopWebViewContainer.this;
                script = s;
                super();
            }
        });
    }

    private BottomButton getMShopButtonById(int i)
    {
        if (i == 0)
        {
            if (mLeftButton == null)
            {
                mLeftButton = new BottomButton(0, null, false);
            }
            return mLeftButton;
        }
        if (mRightButton == null)
        {
            mRightButton = new BottomButton(1, null, false);
        }
        return mRightButton;
    }

    private void injectJavaScriptAnimation(String s)
    {
        if (ActivityUtils.isSpinnerV2Enabled() && !isInEmbeddedBrowserMode() && notHtmlGatewayIfItsWebViewHAOff())
        {
            mDismissSpinnerOnNonWebviewAnimation = false;
            String s1 = String.format("var _aaaap;var spinnerInterval;(function(){    var currentUrl = decodeURIComponent(\"%s\");    var locationHref = decodeURIComponent(location.href);    var anim = function() {        if (_aaaap===1) {            return;        } else if  (locationHref !== currentUrl) {             %s.finishSpinnerOnNonWebviewAnimation();            return;        }        try {            var div = document.createElement('div');            div.id = 'aaap';            div.style.position = 'fixed';            div.style.zIndex = 99;            div.style.left = '0px';            div.style.width = '1px';            div.style.top = '0px';            div.style.height = '1px';            div.style.background = 'white';            div.style.setProperty('-webkit-transform', 'translate3d(0,0,0)');            document.body.appendChild(div);            div.addEventListener('webkitTransitionEnd',               function(e) {               try{                   window.clearInterval(spinnerInterval);                   spinnerInterval = null;                   document.body.removeChild(div);                   _aaaap = 0;                   %s.finishSpinnerWebviewAnimated(decodeURIComponent(location.href));               }catch(e){}              }            );                        spinnerInterval = window.setInterval(function(){               try{                 div.style.setProperty('-webkit-transform', 'translate3d(1px,0,0)');                 div.style.setProperty('-webkit-transition-duration', '1ms');               }catch(e){}            }, 32);        } catch(e) {}        _aaaap = 1;    };    if(document.body !== null) {        anim();    } else {        document.addEventListener('DOMContentLoaded', function(event) {anim();});    }})();", new Object[] {
                s, "webclient", "webclient"
            });
            if (DEBUG)
            {
                Log.d("MShopWebViewContainer", (new StringBuilder()).append("spinner injecting into: ").append(s).toString());
            }
            executeJavaScript(s1);
        }
    }

    private void injectJavaScriptAnimationRemoval()
    {
        if (ActivityUtils.isSpinnerV2Enabled() && !isInEmbeddedBrowserMode() && notHtmlGatewayIfItsWebViewHAOff())
        {
            if (DEBUG)
            {
                Log.d("MShopWebViewContainer", "spinner injectJavaScriptAnimationRemoval ");
            }
            executeJavaScript("(function() {try{    if( document.body !== null){       var div = document.getElementById('aaap');       if ((typeof(div) !== 'undefined') && (div !== null)){           div.style.setProperty('-webkit-transform', '');           div.style.setProperty('-webkit-transition', '');           document.body.removeChild(div);           _aaaap = 0;           if ((typeof(spinnerInterval) !== 'undefined') && (spinnerInterval !== null)){               window.clearInterval(spinnerInterval);               spinnerInterval = null;           }       }    }} catch(e) {}})();");
        }
    }

    private boolean isInEmbeddedBrowserMode()
    {
        if (mWebView != null)
        {
            return mWebView.isInEmbeddedBrowserMode();
        } else
        {
            return false;
        }
    }

    private boolean isReload(String s)
    {
        while (Util.isEmpty(s) || !mShouldClearHistory && !s.equalsIgnoreCase(mWebView.getUrl()) && !s.equalsIgnoreCase(mWebView.getOriginalUrl())) 
        {
            return false;
        }
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", "spinnner: reload");
        }
        return true;
    }

    private boolean isURLFormat(String s)
    {
        if (!Util.isEmpty(s))
        {
            try
            {
                new URL(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
        }
        return true;
    }

    private boolean notHtmlGatewayIfItsWebViewHAOff()
    {
        return !ActivityUtils.isHtmlGatewayWebViewHAOff() || !(mTransitionManager instanceof MShopWebGatewayActivity);
    }

    private void restoreOldBottomToolBar()
    {
        mLeftButton = mOldLeftButton;
        mRightButton = mOldRightButton;
        updateBottomToolBar();
    }

    private void setErrorBox(AmazonErrorBox amazonerrorbox)
    {
        if (mErrorBox != null)
        {
            removeView(mErrorBox);
        }
        mErrorBox = amazonerrorbox;
        if (mErrorBox != null)
        {
            applyOrientationToErrorBox(getWidth(), getHeight());
            addView(mErrorBox, 0);
        }
    }

    private boolean shouldNavigate(String s)
    {
        if (!Util.isEmpty(s))
        {
            if (!(s = s.toLowerCase(Locale.US)).startsWith("https://") && !s.startsWith("http://"))
            {
                return false;
            }
        }
        return true;
    }

    private boolean shouldPreventBackWhenWebPageIsScrolling()
    {
        if (android.os.Build.VERSION.SDK_INT > 10 || android.os.Build.VERSION.SDK_INT < 9 || !WebUtils.isFragmentUrl(mWebView.getUrl()))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        boolean flag;
        Field field = android/webkit/WebView.getDeclaredField("mScroller");
        field.setAccessible(true);
        flag = ((OverScroller)field.get(mWebView)).isFinished();
        return !flag;
        Exception exception;
        exception;
        Log.w("MShopWebViewContainer", (new StringBuilder()).append("Access private field mScroller fail.").append(exception.getMessage()).toString());
        return false;
    }

    private void showErrorBox(int i, String s, android.view.View.OnClickListener onclicklistener)
    {
        i;
        JVM INSTR tableswitch 1 5: default 36
    //                   1 152
    //                   2 36
    //                   3 160
    //                   4 36
    //                   5 168;
           goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
        int j = com.amazon.mShop.android.lib.R.string.error_network_fail_access_amazon_message;
_L6:
        String s1 = UIUtils.formatErrorMessage(getContext().getString(j), i);
        AmazonErrorBox amazonerrorbox = new AmazonErrorBox(getContext());
        amazonerrorbox.setMessage(s1);
        if (s != null)
        {
            amazonerrorbox.setButtonText(1, s);
        }
        amazonerrorbox.setButtonOnClick(1, onclicklistener);
        setErrorBox(amazonerrorbox);
        mHandler.removeCallbacks(mDismissSpinnerJob);
        mWebView.setVisibility(4);
        mProgressBarContainer.setVisibility(8);
        injectJavaScriptAnimationRemoval();
        mIsShowingSpinner = false;
        mPageHasStarted = false;
        mDismissSpinnerOnNonWebviewAnimation = true;
        clearBottomToolBar();
        return;
_L2:
        j = com.amazon.mShop.android.lib.R.string.error_network_no_connection_message;
        continue; /* Loop/switch isn't completed */
_L3:
        j = com.amazon.mShop.android.lib.R.string.error_something_wrong_will_fix_message;
        continue; /* Loop/switch isn't completed */
_L4:
        j = com.amazon.mShop.android.lib.R.string.error_something_wrong_will_fix_message;
        mIsHTTPBlockedErrorShown = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void tryRemoveSpinner()
    {
        boolean flag1;
        int i;
        if (mTransitionManager != null)
        {
            mTransitionManager.doTransitionAnimation();
        }
        i = mWebView.getProgress();
        flag1 = false;
        if (ActivityUtils.isSpinnerV2Enabled() && !isInEmbeddedBrowserMode() && notHtmlGatewayIfItsWebViewHAOff()) goto _L2; else goto _L1
_L1:
        boolean flag;
        flag = flag1;
        if (i >= mProgressHideSpinner)
        {
            if (DEBUG)
            {
                Log.d("MShopWebViewContainer", (new StringBuilder()).append("Spinner, v1 try to hide the spinner on progress ").append(i).toString());
            }
            hideSpinner();
            flag = true;
        }
_L4:
        if (flag && isShowingAmazonProgressDialog())
        {
            hideProgressDialog();
        }
        return;
_L2:
        doUpdateVisitedHistory(false);
        flag = flag1;
        if (!hasUpdatedVisitedHistory)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!hasWebviewAnimated)
        {
            flag = flag1;
            if (!mDismissSpinnerOnNonWebviewAnimation)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (i < 100 && !isPageFinished)
            {
                flag = flag1;
                if (!hasContentHeightChanged)
                {
                    continue; /* Loop/switch isn't completed */
                }
                flag = flag1;
                if (i < mProgressHideSpinner)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        if (DEBUG && isShowingSpinner())
        {
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("spinner ").append(mWebView.getProgress()).append("% hasUpdatedVisitedHistory: ").append(hasUpdatedVisitedHistory).append(", isFinished: ").append(isPageFinished).append(", hasWebviewAnimated: ").append(hasWebviewAnimated).append(", hasContentHeightChanged: ").append(hasContentHeightChanged).append(", mDismissSpinnerOnNonWebviewAnimation: ").append(mDismissSpinnerOnNonWebviewAnimation).append(", currHistIndex: ").append(mWebView.copyBackForwardList().getCurrentIndex()).toString());
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("spinner: progress ").append(i).append("%").toString());
            if (isPageFinished)
            {
                Log.i("MShopWebViewContainer", "spinner: pagefinished");
            }
            if (hasWebviewAnimated)
            {
                Log.i("MShopWebViewContainer", "spinner: hasWebviewAnimated");
            }
            if (hasContentHeightChanged)
            {
                Log.i("MShopWebViewContainer", "spinner: hasContentHeightChanged");
            }
        }
        hideSpinner();
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void updateBottomToolBar()
    {
        mBottomToolBar.removeAllViews();
        if (isShowingSpinner())
        {
            mBottomToolBar.setVisibility(8);
            return;
        }
        ArrayList arraylist = new ArrayList();
        if (mLeftButton != null && !Util.isEmpty(mLeftButton.getItemName()))
        {
            arraylist.add(mLeftButton);
        }
        if (mRightButton != null && !Util.isEmpty(mRightButton.getItemName()))
        {
            arraylist.add(mRightButton);
        }
        if (arraylist.size() > 0)
        {
            mBottomToolBar.init(arraylist);
            mBottomToolBar.setVisibility(0);
            return;
        } else
        {
            mBottomToolBar.setVisibility(8);
            return;
        }
    }

    public void clearHistory()
    {
        mShouldClearHistory = true;
        mCurrHistIndex = -1;
        mPendingIndex = -1;
    }

    public void destroy()
    {
        mHandler.removeCallbacks(mDismissSpinnerJob);
    }

    public void dismissSpinnerOnNonWebviewAnimation()
    {
        mDismissSpinnerOnNonWebviewAnimation = true;
        if (DEBUG)
        {
            Log.d("MShopWebViewContainer", "spinner set spinner dismiss flag based on content height change, page finished or progress 100");
        }
        tryRemoveSpinner();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        Context context = getContext();
        if (!(context instanceof AmazonActivity) || !((AmazonActivity)context).menuDispatchedKeyEvent(keyevent))
        {
            if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
            {
                if (mIsHTTPBlockedErrorShown)
                {
                    mIsHTTPBlockedErrorShown = false;
                    if (mWebView.copyBackForwardList().getSize() > 0)
                    {
                        clearError();
                        return true;
                    } else
                    {
                        return super.dispatchKeyEvent(keyevent);
                    }
                }
                mWebView.stopLoading();
                keyevent = mWebView.getUrl();
                if (keyevent != null)
                {
                    if (keyevent.equals(mStartLoadingUrl))
                    {
                        if (mWebView.canGoBack())
                        {
                            clearError();
                            if (!shouldPreventBackWhenWebPageIsScrolling())
                            {
                                mWebView.goBack();
                                return true;
                            }
                        } else
                        {
                            return false;
                        }
                    } else
                    {
                        mStartLoadingUrl = keyevent;
                        restoreOldBottomToolBar();
                        hideSpinner();
                        clearError();
                        return true;
                    }
                } else
                {
                    return false;
                }
            } else
            {
                return super.dispatchKeyEvent(keyevent);
            }
        }
        return true;
    }

    public void doUpdateVisitedHistory(boolean flag)
    {
        WebBackForwardList webbackforwardlist;
        if (isShowingSpinner())
        {
            if ((webbackforwardlist = mWebView.copyBackForwardList()) != null)
            {
                String s = getHistoryUrl(webbackforwardlist, mCurrHistIndex);
                String s1 = mWebView.getUrl();
                int i = webbackforwardlist.getCurrentIndex();
                if (flag || i >= 0 && (mIsUrlReloading || s == null && s1 != null || s != null && !s.equalsIgnoreCase(s1)))
                {
                    mCurrHistIndex = i;
                    hasUpdatedVisitedHistory = true;
                    isPageFinished = false;
                    hasWebviewAnimated = false;
                    hasContentHeightChanged = false;
                    if (DEBUG)
                    {
                        Log.i("MShopWebViewContainer", "spinner set hasUpdatedVisitedHistory to true");
                        Log.i("MShopWebViewContainer", (new StringBuilder()).append("spinner: height:").append(mWebView.getContentHeight()).toString());
                    }
                    if (mErrorBox == null)
                    {
                        mShouldInjectAnimation = true;
                    } else
                    {
                        mDismissSpinnerOnNonWebviewAnimation = true;
                        mShouldInjectAnimation = false;
                    }
                    mIsUrlReloading = false;
                    return;
                }
            }
        }
    }

    public String getHistoryUrl(WebBackForwardList webbackforwardlist, int i)
    {
        String s = null;
        if (i >= 0 && i < webbackforwardlist.getSize())
        {
            webbackforwardlist = webbackforwardlist.getItemAtIndex(i);
        } else
        {
            webbackforwardlist = null;
        }
        if (webbackforwardlist != null)
        {
            s = webbackforwardlist.getUrl();
        }
        return s;
    }

    protected View getProgressBarContainer()
    {
        return mProgressBarContainer;
    }

    public int getProgressHideSpinner()
    {
        return mProgressHideSpinner;
    }

    public CharSequence getTitle()
    {
        if (!mWebView.isReceivedError()) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((CharSequence) (obj));
_L2:
        String s;
        s = mWebView.getTitle();
        if (Util.isEmpty(s))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s;
        if (!isURLFormat(s)) goto _L4; else goto _L3
_L3:
        return mTitle;
    }

    MShopWebViewTransitionManager getTransitionManager()
    {
        return mTransitionManager;
    }

    public WebView getWebView()
    {
        return mWebView;
    }

    public void handlePageLoadNatively()
    {
        if (mIsPageLoadHandledNatively)
        {
            mIsPageLoadHandledNatively = false;
            if (mTransitionManager != null)
            {
                mTransitionManager.doTransitionAnimation();
            }
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final MShopWebViewContainer this$0;

                public void run()
                {
                    hideSpinner();
                }

            
            {
                this$0 = MShopWebViewContainer.this;
                super();
            }
            });
        }
    }

    void hideBottomButton(int i)
    {
        if (i == 0)
        {
            mLeftButton = null;
        } else
        {
            mRightButton = null;
        }
        updateBottomToolBar();
    }

    public void hideProgressDialog()
    {
        if (mProgressDialog != null)
        {
            try
            {
                mProgressDialog.dismiss();
            }
            catch (Exception exception)
            {
                Log.e("MShopWebViewContainer", (new StringBuilder()).append("hideAmazonProgressDialog ").append(exception.getMessage()).toString());
            }
            mProgressDialog = null;
        }
    }

    public void hideSpinner()
    {
label0:
        {
            synchronized (mSyncLockSpinner)
            {
                if (isShowingSpinner())
                {
                    break label0;
                }
            }
            return;
        }
        mIsShowingSpinner = false;
        obj;
        JVM INSTR monitorexit ;
        int i = (int)(System.currentTimeMillis() - mSpinnerAppearTimeStamp.longValue());
        if (mShouldClearHistory)
        {
            mShouldClearHistory = false;
            mWebView.clearHistory();
        }
        mPendingIndex = mWebView.copyBackForwardList().getCurrentIndex();
        mHandler.removeCallbacks(mDismissSpinnerJob);
        obj = new AlphaAnimation(1.0F, 0.0F);
        ((Animation) (obj)).setDuration(250L);
        mProgressBarContainer.clearAnimation();
        mProgressBarContainer.startAnimation(((Animation) (obj)));
        injectJavaScriptAnimationRemoval();
        obj = mWebView;
        byte byte0;
        if (mErrorBox != null)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        ((MShopWebView) (obj)).setVisibility(byte0);
        mProgressBarContainer.setVisibility(8);
        updateBottomToolBar();
        mPageHasStarted = false;
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("-- Hide spinner after ").append(i).append("ms --").toString());
            return;
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isShouldDelayTransition()
    {
        return mShouldDelayTransition;
    }

    public boolean isShowingAmazonProgressDialog()
    {
        return mProgressDialog != null && mProgressDialog.isShowing();
    }

    public boolean isShowingSpinner()
    {
        return mIsShowingSpinner;
    }

    public boolean isWebViewReceivedError()
    {
        return mWebView.isReceivedError();
    }

    public void navigate(String s, boolean flag, boolean flag1)
    {
        if (shouldNavigate(s))
        {
            mCurrHistIndex = mWebView.copyBackForwardList().getCurrentIndex();
            if (!flag1 && mTransitionManager != null)
            {
                if (flag)
                {
                    if (mCurrHistIndex >= mPendingIndex)
                    {
                        mPendingIndex = mCurrHistIndex + 1;
                        mTransitionManager.beginForwardTransition(s);
                    }
                } else
                if (mCurrHistIndex <= mPendingIndex)
                {
                    mPendingIndex = mCurrHistIndex - 1;
                    mTransitionManager.beginBackwardTransition(s);
                }
            }
            if (s != null)
            {
                showSpinner();
                setShouldDelayTransition(false);
            } else
            {
                setShouldDelayTransition(true);
            }
            if (flag1 || Util.isEmpty(s))
            {
                doUpdateVisitedHistory(true);
                return;
            }
        }
    }

    public void navigateBackward(String s)
    {
        navigate(s, false, false);
    }

    public void navigateForward(String s)
    {
        navigate(s, true, isReload(s));
    }

    protected void onMeasure(int i, int j)
    {
        if (mErrorBox != null && android.view.View.MeasureSpec.getMode(i) != 0 && android.view.View.MeasureSpec.getMode(j) != 0)
        {
            applyOrientationToErrorBox(android.view.View.MeasureSpec.getSize(i), android.view.View.MeasureSpec.getSize(j));
        }
        super.onMeasure(i, j);
    }

    void onPageFinished(String s)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("onPageFinished url = ").append(s).toString());
        }
        mStartLoadingUrl = mWebView.getUrl();
        if (isShowingAmazonProgressDialog())
        {
            hideProgressDialog();
        }
        boolean flag;
        if (!Util.isEmpty(s) && s.equals(mStartLoadingUrl))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isPageFinished = flag;
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("onPageFinished isPageFinished is ").append(isPageFinished).append(", mStartLoadingUrl is ").append(mStartLoadingUrl).toString());
        }
        tryRemoveSpinner();
        if (!ActivityUtils.isSpinnerV2Enabled())
        {
            hideSpinner();
        }
        updateActivityTitle();
    }

    void onPageStarted(String s)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("spinner onPageStarted mStartLoadingUrl = ").append(s).toString());
        }
        mStartLoadingUrl = s;
        Object obj = mWebView.copyBackForwardList();
        if (obj != null)
        {
            obj = getHistoryUrl(((WebBackForwardList) (obj)), mCurrHistIndex);
            if (obj != null && ((String) (obj)).equalsIgnoreCase(s))
            {
                mIsUrlReloading = true;
            }
        }
        if (mErrorBox == null)
        {
            showSpinner();
            clearBottomToolBar();
        }
        mPageHasStarted = true;
        s = Uri.parse(s);
        if (s.isHierarchical())
        {
            mTitle = s.getQueryParameter("app-title");
            if (!Util.isEmpty(mTitle))
            {
                updateActivityTitle();
            }
        }
    }

    public void onProgressChanged(int i)
    {
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", (new StringBuilder()).append("progress: ").append(i).toString());
        }
        if (!isInEmbeddedBrowserMode() && hasUpdatedVisitedHistory && mShouldInjectAnimation && mPageHasStarted && !Util.isEmpty(mWebView.getUrl()) && i >= mProgressSpinnerInjectThreshold && mWebView.shouldHideProgressIndicator())
        {
            if (DEBUG)
            {
                Log.i("MShopWebViewContainer", (new StringBuilder()).append(" spinner progress: ").append(i).append(", begin to inject the animation js").toString());
            }
            mShouldInjectAnimation = false;
            mPageHasStarted = false;
            injectJavaScriptAnimation(mWebView.getUrl());
        }
        tryRemoveSpinner();
    }

    public void onToolBarItemSelected(com.amazon.mShop.ui.BottomToolBar.ToolBarItem toolbaritem)
    {
        toolbaritem = getMShopButtonById(toolbaritem.getItemId()).getOnTouchCallbackId();
        MShopWebViewJavaScriptClient.MASHcallback.execSuccessCallback(mWebView, toolbaritem, null, true);
    }

    void setBottomButtonEnabled(int i, boolean flag)
    {
        BottomButton bottombutton = getMShopButtonById(i);
        bottombutton.setEnabled(flag);
        mBottomToolBar.setToolBarItemEnabled(bottombutton, flag);
    }

    void setBottomButtonOnTouch(int i, String s)
    {
        getMShopButtonById(i).setOnTouchCallbackId(s);
    }

    void setBottomButtonText(int i, String s)
    {
        getMShopButtonById(i).setItemName(s);
        View view = mBottomToolBar.findViewById(i);
        if (view instanceof TextView)
        {
            ((TextView)view).setText(s);
        }
    }

    public void setIsPageLoadHandledNatively(boolean flag)
    {
        mIsPageLoadHandledNatively = flag;
    }

    public void setProgressHideSpinner(int i)
    {
        mProgressHideSpinner = i;
    }

    public void setShouldDelayTransition(boolean flag)
    {
        mShouldDelayTransition = flag;
    }

    public void setTitle(CharSequence charsequence)
    {
        mTitle = charsequence;
        updateActivityTitle();
    }

    public void showAmazonProgressDialog(String s, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (isShowingSpinner())
        {
            Log.w("MShopWebViewContainer", "showAmazonProgressDialog: Not allow to show dual progress bar");
            return;
        }
        hideProgressDialog();
        mProgressDialog = new AmazonProgressDialog(getContext());
        mProgressDialog.setTitle(s);
        mProgressDialog.setCanceledOnTouchOutside(false);
        if (oncancellistener != null)
        {
            mProgressDialog.setOnCancelListener(oncancellistener);
        }
        try
        {
            mProgressDialog.show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("MShopWebViewContainer", (new StringBuilder()).append("showAmazonProgressDialog ").append(s.getMessage()).toString());
        }
    }

    void showBottomButton(int i, String s, boolean flag, String s1)
    {
        BottomButton bottombutton = getMShopButtonById(i);
        bottombutton.setItemName(s);
        bottombutton.setEnabled(flag);
        bottombutton.setOnTouchCallbackId(s1);
        updateBottomToolBar();
    }

    void showError()
    {
        byte byte0;
        if (NetInfo.hasNetworkConnection())
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        showErrorBox(byte0, null, new android.view.View.OnClickListener() {

            final MShopWebViewContainer this$0;

            public void onClick(View view)
            {
                mWebView.clearView();
                mWebView.reload();
                clearError();
            }

            
            {
                this$0 = MShopWebViewContainer.this;
                super();
            }
        });
    }

    public void showSpinner()
    {
label0:
        {
            synchronized (mSyncLockSpinner)
            {
                if (!isShowingSpinner())
                {
                    break label0;
                }
            }
            return;
        }
        mIsShowingSpinner = true;
        obj;
        JVM INSTR monitorexit ;
        if (isShowingAmazonProgressDialog())
        {
            Log.w("MShopWebViewContainer", "showSpinner: Not allow to show dual progress bar");
            return;
        }
        break MISSING_BLOCK_LABEL_47;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        hasUpdatedVisitedHistory = false;
        mSpinnerAppearTimeStamp = Long.valueOf(System.currentTimeMillis());
        updateBottomToolBar();
        mHandler.postDelayed(mDismissSpinnerJob, 30000L);
        mProgressBarContainer.setVisibility(0);
        mWebView.setVisibility(0);
        if (mTransitionManager != null)
        {
            mTransitionManager.doTransitionAnimation();
        }
        if (DEBUG)
        {
            Log.i("MShopWebViewContainer", "-- Show spinner --");
        }
        return;
    }

    void showSslError(int i)
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final MShopWebViewContainer this$0;

            public void onClick(View view)
            {
                ActivityUtils.startHomeActivity(view.getContext());
                if (getContext() instanceof MShopWebGatewayActivity)
                {
                    mIsHTTPBlockedErrorShown = false;
                    clearError();
                }
            }

            
            {
                this$0 = MShopWebViewContainer.this;
                super();
            }
        };
        showErrorBox(i, getContext().getString(com.amazon.mShop.android.lib.R.string.go_to_amazon_home), onclicklistener);
    }

    void updateActivityTitle()
    {
        if (getContext() instanceof AmazonActivity)
        {
            ((AmazonActivity)getContext()).updateTitle(this);
        }
    }

    public void webviewAnimated()
    {
        hasWebviewAnimated = true;
        if (DEBUG)
        {
            Log.d("MShopWebViewContainer", "spinner webviewAnimated in webviewAnimated()");
        }
        tryRemoveSpinner();
    }

    public void webviewContentHeightChanged()
    {
        hasContentHeightChanged = true;
        if (DEBUG)
        {
            Log.d("MShopWebViewContainer", (new StringBuilder()).append("spinner contentHeightChanged, ").append(mWebView.getContentHeight()).toString());
        }
        tryRemoveSpinner();
    }






/*
    static boolean access$302(MShopWebViewContainer mshopwebviewcontainer, boolean flag)
    {
        mshopwebviewcontainer.mIsHTTPBlockedErrorShown = flag;
        return flag;
    }

*/
}
