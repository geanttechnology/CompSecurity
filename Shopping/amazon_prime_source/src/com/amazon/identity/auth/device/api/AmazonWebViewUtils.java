// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.content.Context;
import android.view.View;
import com.amazon.android.webkit.AmazonCookieManager;
import com.amazon.android.webkit.AmazonCookieSyncManager;
import com.amazon.android.webkit.AmazonWebKitFactories;
import com.amazon.android.webkit.AmazonWebKitFactory;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AmazonWebViewUtils
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/api/AmazonWebViewUtils.getName();
    private static AtomicBoolean sIsFactoryInitialized = new AtomicBoolean(false);

    private AmazonWebViewUtils()
    {
    }

    public static AmazonWebView createAmazonWebView(Context context)
    {
        initAmazonWebViewFactory(context);
        return AmazonWebKitFactories.getDefaultFactory().createWebView(context, 0, null, false);
    }

    public static AmazonCookieManager getAmazonCookieManager(Context context)
    {
        initAmazonWebViewFactory(context);
        return AmazonCookieManager.getInstance();
    }

    public static AmazonWebView getAmazonWebViewFromView(View view, Context context)
    {
        initAmazonWebViewFactory(context);
        if (view instanceof AmazonWebView)
        {
            view = (AmazonWebView)view;
            try
            {
                AmazonWebKitFactories.getDefaultFactory().initializeWebView(view, 0, false, null);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                MAPLog.e(LOG_TAG, "IllegalStateException occureed while calling AmazonWebView initialization. Please make sure you have not already initialized the webview", view);
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                MAPLog.e(LOG_TAG, "Unexpected Error calling AmazonWebView initialization.", view);
                return null;
            }
            return view;
        }
        if (view == null)
        {
            MAPLog.e(LOG_TAG, "The webView passed in is null, most likely because findViewById() failed!");
            return null;
        } else
        {
            MAPLog.e(LOG_TAG, String.format("The View object with class %s cann't be casted to AmazonWebView.", new Object[] {
                view.getClass().getSimpleName()
            }));
            throw new IllegalArgumentException("The View object is not an AmazonWebView object");
        }
    }

    public static void initAmazonWebViewFactory(Context context)
    {
        if (sIsFactoryInitialized.compareAndSet(false, true))
        {
            AmazonWebKitFactories.getDefaultFactory().initialize(context.getApplicationContext());
            AmazonWebKitFactories.getDefaultFactory().getCookieManager().setAcceptCookie(true);
            (new StringBuilder("Using the webview implementation:")).append(AmazonWebKitFactories.getDefaultFactory().getClass().getName());
        }
    }

    public static void makeSureAmazonCookieSyncManagerIsInitialized(Context context)
    {
        initAmazonWebViewFactory(context);
        try
        {
            AmazonCookieSyncManager.getInstance();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            AmazonCookieSyncManager.initialize(context);
        }
    }

    public static void syncAmazonCookieSyncManager(Context context)
    {
        initAmazonWebViewFactory(context);
        makeSureAmazonCookieSyncManagerIsInitialized(context);
        AmazonCookieSyncManager.getInstance().sync();
    }

}
