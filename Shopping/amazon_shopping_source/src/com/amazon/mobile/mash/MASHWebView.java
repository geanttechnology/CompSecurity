// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import com.amazon.mobile.mash.api.MASHPluginManager;
import com.amazon.mobile.mash.appcontext.AppContext;
import com.amazon.mobile.mash.nav.MASHWebBackForwardList;
import java.util.List;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginManager;

public class MASHWebView extends CordovaWebView
{

    private AppContext mAppContext;
    private boolean mIsInEmbeddedBrowserMode;
    private MASHWebBackForwardList mMASHWebBackForwardList;
    private com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mPendingNavRequest;
    private boolean mShouldHideProgressIndicator;

    public MASHWebView(AppContext appcontext, Context context)
    {
        super(context);
        mMASHWebBackForwardList = new MASHWebBackForwardList();
        mShouldHideProgressIndicator = true;
        init((CordovaInterface)getContext(), null, null, Config.getPluginEntries(), Config.getWhitelist(), Config.getExternalWhitelist(), Config.getPreferences());
        mAppContext = appcontext;
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

    public boolean shouldHideProgressIndicator()
    {
        return mShouldHideProgressIndicator;
    }
}
