// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.error.MASHError;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginManager;

public class MASHPluginManager extends PluginManager
{

    private static final String TAG = com/amazon/mobile/mash/api/MASHPluginManager.getSimpleName();
    private CordovaWebView mWebView;

    public MASHPluginManager(CordovaWebView cordovawebview, CordovaInterface cordovainterface, List list)
    {
        super(cordovawebview, cordovainterface, list);
        mWebView = cordovawebview;
    }

    public void exec(String s, String s1, String s2, String s3)
    {
        CallbackContext callbackcontext = new CallbackContext(s2, mWebView);
        if (((MASHWebView)mWebView).isInEmbeddedBrowserMode())
        {
            boolean flag;
            if ("ExitEmbeddedBrowser".equalsIgnoreCase(s1) || "Device".equalsIgnoreCase(s) || "NetworkStatus".equalsIgnoreCase(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                callbackcontext.error(MASHError.PERMISSION_DENIED.toJSONObejct());
                Log.e(TAG, (new StringBuilder()).append("MASHError.PERMISSION_DENIED for ").append(s).append(":").append(s1).toString());
                return;
            }
        }
        super.exec(overrideServiceName(s, s1), s1, s2, s3);
    }

    protected String overrideServiceName(String s, String s1)
    {
        String s2;
label0:
        {
            s2 = s;
            if (!"Mash".equals(s))
            {
                break label0;
            }
            if (!"ShowEmbeddedBrowser".equals(s1))
            {
                s2 = s;
                if (!"ExitEmbeddedBrowser".equals(s1))
                {
                    break label0;
                }
            }
            s2 = "MASHEmbeddedBrowser";
        }
        return s2;
    }

}
