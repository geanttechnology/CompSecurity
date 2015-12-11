// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import com.amazon.mobile.mash.api.MASHPluginManager;
import com.amazon.mobile.mash.appcontext.AppContext;
import com.amazon.mobile.mash.nav.MASHWebBackForwardList;
import java.util.List;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewClient;
import org.apache.cordova.PluginManager;

// Referenced classes of package com.amazon.mobile.mash:
//            MASHContentDownloadHandler, MASHWebViewClient

public class MASHWebView extends CordovaWebView
{

    private AppContext mAppContext;
    private boolean mIsInEmbeddedBrowserMode;
    private MASHWebBackForwardList mMASHWebBackForwardList;
    private com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mPendingNavRequest;
    private boolean mShouldHideProgressIndicator;
    private MASHWebViewClient mWebViewClient;

    public MASHWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMASHWebBackForwardList = new MASHWebBackForwardList();
        mShouldHideProgressIndicator = true;
        init((CordovaInterface)getContext(), null, null, Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        setUp();
    }

    public MASHWebView(AppContext appcontext, Context context)
    {
        super(context);
        mMASHWebBackForwardList = new MASHWebBackForwardList();
        mShouldHideProgressIndicator = true;
        init((CordovaInterface)getContext(), null, null, Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        mAppContext = appcontext;
        setUp();
    }

    private void enableMediaAutoplay()
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    private void setUp()
    {
        enableMediaAutoplay();
        setDownloadListener(new MASHContentDownloadHandler(this));
    }

    public void checkForFileChooserActivityResult(int i, int j, Intent intent)
    {
        ValueCallback valuecallback;
label0:
        {
            if (i == 5173)
            {
                valuecallback = getWebChromeClient().mUploadMessage;
                if (valuecallback != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (intent == null || j != -1)
        {
            intent = null;
        } else
        {
            intent = intent.getData();
        }
        valuecallback.onReceiveValue(intent);
    }

    public PluginManager createPluginManager(List list)
    {
        return new MASHPluginManager(this, (CordovaInterface)getContext(), list);
    }

    public void destroy()
    {
        super.destroy();
        handleDestroy();
    }

    public Activity getActivity()
    {
        Context context1 = getContext();
        Context context = context1;
        if (context1 instanceof MutableContextWrapper)
        {
            context = ((MutableContextWrapper)context1).getBaseContext();
        }
        if (context instanceof Activity)
        {
            return (Activity)context;
        } else
        {
            return null;
        }
    }

    public AppContext getAppContext()
    {
        return mAppContext;
    }

    public MASHWebBackForwardList getMASHWebBackForwardList()
    {
        return mMASHWebBackForwardList;
    }

    public com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest getPendingNavRequest()
    {
        return mPendingNavRequest;
    }

    public MASHWebViewClient getWebViewClient()
    {
        return mWebViewClient;
    }

    public void handleDestroy()
    {
        if (pluginManager != null)
        {
            pluginManager.onDestroy();
        }
    }

    public boolean isInEmbeddedBrowserMode()
    {
        return mIsInEmbeddedBrowserMode;
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        while (i == 84 || i == 4) 
        {
            return false;
        }
        return super.onKeyUp(i, keyevent);
    }

    public void postUrl(String s, byte abyte0[])
    {
        pluginManager.init();
        super.postUrl(s, abyte0);
    }

    public void setAppContext(AppContext appcontext)
    {
        mAppContext = appcontext;
    }

    public void setIsInEmbeddedBrowserMode(boolean flag)
    {
        mIsInEmbeddedBrowserMode = flag;
    }

    public void setPendingNavRequest(com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mashnavrequest)
    {
        mPendingNavRequest = mashnavrequest;
    }

    public void setShouldHideProgressIndicator(boolean flag)
    {
        mShouldHideProgressIndicator = flag;
    }

    public void setWebViewClient(CordovaWebViewClient cordovawebviewclient)
    {
        if (cordovawebviewclient instanceof MASHWebViewClient)
        {
            mWebViewClient = (MASHWebViewClient)cordovawebviewclient;
        }
        super.setWebViewClient(cordovawebviewclient);
    }

    public boolean shouldHideProgressIndicator()
    {
        return mShouldHideProgressIndicator;
    }
}
