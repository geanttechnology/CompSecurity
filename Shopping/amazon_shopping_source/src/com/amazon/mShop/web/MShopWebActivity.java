// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ViewAnimator;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.net.LRUCache;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.constants.WebConstants;
import com.amazon.mobile.mash.nav.MASHNavInterface;
import com.amazon.mobile.mash.nav.MASHNavUtils;
import com.facebook.Session;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.json.JSONException;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewTransitionManager, MShopWebViewContainer, TitledImageView, MShopWebFragment, 
//            MShopWebView, MShopWebViewClient, MShopModalWebActivity

public class MShopWebActivity extends AmazonActivity
    implements MShopWebViewTransitionManager, MASHNavInterface, CordovaInterface
{

    protected static final String KEEP_HISTORY_STACK = "KeepHistoryStack";
    public static final String TAG = "MShopWebActivity";
    private CordovaPlugin mActivityResultCallback;
    private boolean mBackTransitionPending;
    private boolean mForwardTransitionPending;
    private boolean mIsFirstOnResume;
    private boolean mIsLastOnPause;
    protected TitledImageView mPicture;
    private ExecutorService mThreadPool;
    protected MShopWebFragment mWebFragment;
    protected long mWebviewLoadStartTime;

    public MShopWebActivity()
    {
        mIsFirstOnResume = true;
        mIsLastOnPause = false;
    }

    private void cordovaOnCreate()
    {
        if (DEBUG)
        {
            LOG.setLogLevel(2);
        }
        Config.init(this);
    }

    private void goBackTransition()
    {
        if (mPicture != null)
        {
            popView();
            mPicture = null;
        }
    }

    public void beginBackwardTransition(String s)
    {
        captureTopView();
        mBackTransitionPending = true;
    }

    public void beginForwardTransition(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        s = Uri.parse(s);
        if (s == null || !s.isHierarchical() || Util.isEmpty(s.getQueryParameter("app-action"))) goto _L2; else goto _L3
_L3:
        return;
_L2:
        if (!getWebViewContainer().isShowingSpinner() && !getWebViewContainer().isShowingAmazonProgressDialog())
        {
            captureTopView();
            mForwardTransitionPending = true;
            return;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public void calcWebviewStartTime()
    {
        mWebviewLoadStartTime = System.currentTimeMillis();
    }

    protected void captureTopView()
    {
        if (mPicture == null && getWebView().getUrl() != null)
        {
            getViewAnimator().clearDisappearingChildren();
            Bitmap bitmap = getCaptureTopView();
            mPicture = new TitledImageView(this);
            mPicture.setImageBitmap(bitmap);
            mPicture.setTitle(mWebFragment.getContainer().getTitle());
            pushView(mPicture, false);
            if (DEBUG)
            {
                Log.i("MShopWebActivity", "captureTopView");
                return;
            }
        }
    }

    protected MShopWebView createWebView()
    {
        return new MShopWebView(this);
    }

    protected MShopWebViewClient createWebViewClient()
    {
        return new MShopWebViewClient(this);
    }

    protected MShopWebViewContainer createWebViewContainer()
    {
        return new MShopWebViewContainer(this);
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        boolean flag = false;
        if (getCurrentView().getId() == com.amazon.mShop.android.lib.R.id.web_view_frame)
        {
            flag = getWebViewContainer().dispatchKeyEvent(keyevent);
        }
        boolean flag1 = flag;
        if (!flag)
        {
            flag1 = super.dispatchKeyEvent(keyevent);
        }
        return flag1;
    }

    public void doTransitionAnimation()
    {
        final MShopWebViewContainer container = getWebViewContainer();
        long l;
        if (container != null && container.isShouldDelayTransition())
        {
            l = 250L;
        } else
        {
            l = 0L;
        }
        if (mForwardTransitionPending && !isPushAnimationInProgress())
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final MShopWebActivity this$0;
                final MShopWebViewContainer val$container;

                public void run()
                {
                    if (mForwardTransitionPending && !isPushAnimationInProgress())
                    {
                        goForwardTransition();
                        mForwardTransitionPending = false;
                        if (container != null)
                        {
                            container.setShouldDelayTransition(false);
                        }
                    }
                }

            
            {
                this$0 = MShopWebActivity.this;
                container = mshopwebviewcontainer;
                super();
            }
            }, l);
        }
        if (mBackTransitionPending)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                final MShopWebActivity this$0;
                final MShopWebViewContainer val$container;

                public void run()
                {
                    if (mBackTransitionPending)
                    {
                        goBackTransition();
                        mBackTransitionPending = false;
                        if (container != null)
                        {
                            container.setShouldDelayTransition(false);
                        }
                    }
                }

            
            {
                this$0 = MShopWebActivity.this;
                container = mshopwebviewcontainer;
                super();
            }
            }, l);
        }
    }

    public void finish()
    {
        super.finish();
        mIsLastOnPause = true;
    }

    public Activity getActivity()
    {
        return this;
    }

    protected Bitmap getCaptureTopView()
    {
        Bitmap bitmap;
        Object obj;
        bitmap = null;
        obj = null;
        if (mWebFragment.getContainer() == null) goto _L2; else goto _L1
_L1:
        Bitmap bitmap1;
        mWebFragment.getContainer().setDrawingCacheEnabled(true);
        bitmap1 = mWebFragment.getContainer().getDrawingCache();
        bitmap = obj;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        bitmap = Bitmap.createBitmap(bitmap1);
_L4:
        mWebFragment.getContainer().setDrawingCacheEnabled(false);
_L2:
        return bitmap;
        Object obj1;
        obj1;
        mPicture = null;
        bitmap = obj;
        if (DEBUG)
        {
            Log.e("MShopWebActivity", "exception happend in captureTopView", ((Throwable) (obj1)));
            bitmap = obj;
        }
        continue; /* Loop/switch isn't completed */
        obj1;
        mPicture = null;
        LRUCache.reduceByPercent(50);
        bitmap = obj;
        if (DEBUG)
        {
            Log.e("MShopWebActivity", "OutOfMemoryError happend in captureTopView", ((Throwable) (obj1)));
            bitmap = obj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected String getCurrentUrl()
    {
        return getWebView().getUrl();
    }

    public Class getModalActivityClass()
    {
        return com/amazon/mShop/web/MShopModalWebActivity;
    }

    public byte[] getPostParameters()
    {
        return getIntent().getByteArrayExtra("postParams");
    }

    public long getRealClickTime()
    {
        return mWebviewLoadStartTime;
    }

    public ExecutorService getThreadPool()
    {
        if (mThreadPool == null)
        {
            mThreadPool = Executors.newCachedThreadPool();
        }
        return mThreadPool;
    }

    public String getUrl()
    {
        return getIntent().getStringExtra(WebConstants.getWebViewUrlKey());
    }

    public WebView getWebView()
    {
        if (mWebFragment.getContainer() != null)
        {
            return mWebFragment.getContainer().getWebView();
        } else
        {
            return null;
        }
    }

    public MShopWebViewContainer getWebViewContainer()
    {
        return mWebFragment.getContainer();
    }

    protected void goForwardTransition()
    {
        View view = findViewById(com.amazon.mShop.android.lib.R.id.web_view_frame);
        if (mPicture != null && removeView(view, false))
        {
            pushView(view);
            removeView(mPicture, false);
            mPicture = null;
            if (DEBUG)
            {
                Log.i("MShopWebActivity", "goForwardTransition");
            }
        }
    }

    protected void initLayout()
    {
        pushView(getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.web_activity, null));
    }

    protected void initWebView()
    {
        mWebFragment.initWebViewContainer(this);
        if (isMethodPOST())
        {
            getWebView().postUrl(getUrl(), getPostParameters());
        } else
        {
            loadUrl();
        }
        initLayout();
    }

    public boolean isBackTransitionPending()
    {
        return mBackTransitionPending;
    }

    public boolean isForwardTransitionPending()
    {
        return mForwardTransitionPending;
    }

    public boolean isMethodPOST()
    {
        return "POST".equalsIgnoreCase(getIntent().getStringExtra("method"));
    }

    protected void loadUrl()
    {
        getWebView().loadUrl(getUrl());
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (mActivityResultCallback != null)
        {
            mActivityResultCallback.onActivityResult(i, j, intent);
        }
        if (getWebView() instanceof MASHWebView)
        {
            ((MASHWebView)getWebView()).checkForFileChooserActivityResult(i, j, intent);
        }
        if (i == 17 && j == -1)
        {
            getWebView().loadUrl("javascript:try{app.willReappear2();}catch(e){}");
        }
        if (i == 64206)
        {
            Session.getActiveSession().onActivityResult(this, i, j, intent);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        calcWebviewStartTime();
        cordovaOnCreate();
        super.onCreate(bundle);
        mWebFragment = MShopWebFragment.add(getSupportFragmentManager(), com.amazon.mShop.android.lib.R.id.web_view_frame);
        processSavedInstanceAndInitWebview(bundle);
    }

    protected void onDestroy()
    {
        WebView webview = getWebView();
        removeAllViews();
        if (getWebViewContainer() != null)
        {
            getWebViewContainer().destroy();
        }
        if (webview != null)
        {
            webview.destroy();
        }
        super.onDestroy();
    }

    public Object onMessage(String s, Object obj)
    {
        return null;
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        Config.init(this);
        calcWebviewStartTime();
        String s = intent.getStringExtra(WebConstants.getWebViewUrlKey());
        if (!Util.isEmpty(s))
        {
            getWebView().stopLoading();
            if (!intent.getBooleanExtra("KeepHistoryStack", false))
            {
                getWebViewContainer().clearHistory();
            }
            getWebView().loadUrl(s);
        }
    }

    protected void onPause()
    {
        getViewAnimator().clearDisappearingChildren();
        super.onPause();
        if (!mIsLastOnPause)
        {
            ((MShopWebView)getWebView()).handlePause(true);
        }
        mWebFragment.detach();
    }

    protected void onResume()
    {
        super.onResume();
        if (mIsFirstOnResume)
        {
            mIsFirstOnResume = false;
        } else
        {
            ((MShopWebView)getWebView()).handleResume(true, true);
        }
        getWebViewContainer().setIsPageLoadHandledNatively(false);
        mWebFragment.attach();
    }

    protected void onStop()
    {
        super.onStop();
        if (getWebViewContainer() != null)
        {
            getWebViewContainer().handlePageLoadNatively();
        }
    }

    protected void processSavedInstanceAndInitWebview(Bundle bundle)
    {
        boolean flag1 = true;
        if (bundle != null)
        {
            finish();
            return;
        }
        boolean flag = flag1;
        if (ActivityUtils.isHtmlGatewayWebViewHAOff())
        {
            if (!(this instanceof MShopWebGatewayActivity))
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
        }
        if (ActivityUtils.isSpinnerV2Enabled() && flag)
        {
            getWindow().setFlags(0x1000000, 0x1000000);
        }
        initWebView();
    }

    public void refresh()
    {
        WebView webview = getWebView();
        if (webview != null)
        {
            webview.stopLoading();
            webview.reload();
        }
    }

    public void replaceRootWebViewWithNewUrl(MASHWebView mashwebview, com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mashnavrequest)
    {
        if (!"POST".equalsIgnoreCase(mashnavrequest.getMethod())) goto _L2; else goto _L1
_L1:
        mashwebview = com.amazon.mobile.mash.util.Util.getPostDataAsByteArray(mashnavrequest.getParams());
        getIntent().putExtra("method", mashnavrequest.getMethod());
        getIntent().putExtra("postParams", mashwebview);
        getIntent().putExtra(WebConstants.getWebViewUrlKey(), mashnavrequest.getUrl());
_L4:
        getWebView().stopLoading();
        getWebView().destroy();
        mashwebview = new MShopWebFragment();
        getSupportFragmentManager().beginTransaction().replace(mWebFragment.getId(), mashwebview).commit();
        mWebFragment = mashwebview;
        removeAllViews();
        initWebView();
        return;
_L2:
        try
        {
            getIntent().putExtra(WebConstants.getWebViewUrlKey(), MASHNavUtils.getFullUrlForGetRequest(mashnavrequest.getUrl(), mashnavrequest.getParams()));
        }
        // Misplaced declaration of an exception variable
        catch (MASHWebView mashwebview)
        {
            Log.e("MShopWebActivity", (new StringBuilder()).append("JSON parameters parse error : ").append(mashwebview.getMessage()).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setActivityResultCallback(CordovaPlugin cordovaplugin)
    {
        mActivityResultCallback = cordovaplugin;
    }

    public void startActivityForResult(CordovaPlugin cordovaplugin, Intent intent, int i)
    {
        mActivityResultCallback = cordovaplugin;
        startActivityForResult(intent, i);
    }



/*
    static boolean access$002(MShopWebActivity mshopwebactivity, boolean flag)
    {
        mshopwebactivity.mForwardTransitionPending = flag;
        return flag;
    }

*/



/*
    static boolean access$102(MShopWebActivity mshopwebactivity, boolean flag)
    {
        mshopwebactivity.mBackTransitionPending = flag;
        return flag;
    }

*/

}
