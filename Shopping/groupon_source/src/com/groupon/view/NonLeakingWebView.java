// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class NonLeakingWebView extends WebView
{
    protected static class MyWebViewClient extends WebViewClient
    {

        private WeakReference activityRef;

        protected String internalizePaths(WebView webview, String s)
        {
            String s1 = s;
            if (webview instanceof NonLeakingWebView)
            {
                s1 = s;
                if (((NonLeakingWebView)webview).shouldInternalizePaths)
                {
                    s1 = s;
                    if (s.startsWith("/"))
                    {
                        s1 = (new StringBuilder()).append("internal://").append(s).toString();
                    }
                }
            }
            return s1;
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            Activity activity = (Activity)activityRef.get();
            if (activity != null)
            {
                try
                {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(internalizePaths(webview, s))));
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    Ln.e(webview);
                }
            }
            return true;
        }

        public MyWebViewClient(Activity activity)
        {
            activityRef = new WeakReference(activity);
        }
    }


    private static Field sConfigCallback;
    private static WeakHashMap webViewsInMemory = new WeakHashMap();
    private boolean isDestroying;
    private boolean shouldInternalizePaths;

    public NonLeakingWebView(Context context)
    {
        this(context, null, 0);
    }

    public NonLeakingWebView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public NonLeakingWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context.getApplicationContext(), attributeset, i);
        shouldInternalizePaths = false;
        setWebViewClient(createWebViewClientInstance((Activity)context));
        com/groupon/view/NonLeakingWebView;
        JVM INSTR monitorenter ;
        webViewsInMemory.put(this, null);
        com/groupon/view/NonLeakingWebView;
        JVM INSTR monitorexit ;
        return;
        context;
        com/groupon/view/NonLeakingWebView;
        JVM INSTR monitorexit ;
        throw context;
    }

    protected WebViewClient createWebViewClientInstance(Activity activity)
    {
        return new MyWebViewClient(activity);
    }

    public void destroy()
    {
        isDestroying = true;
        super.destroy();
        try
        {
            if (sConfigCallback != null)
            {
                sConfigCallback.set(null, null);
            }
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException(illegalaccessexception);
        }
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        com/groupon/view/NonLeakingWebView;
        JVM INSTR monitorenter ;
        Ln.v("WebViews: %s", new Object[] {
            Strings.join(", ", webViewsInMemory.keySet())
        });
        com/groupon/view/NonLeakingWebView;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/groupon/view/NonLeakingWebView;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public WebSettings getSettings()
    {
        if (isDestroying)
        {
            return null;
        } else
        {
            return super.getSettings();
        }
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        if (isDestroying)
        {
            return;
        } else
        {
            super.loadDataWithBaseURL(s, s1, s2, s3, s4);
            return;
        }
    }

    public void setShouldInternalizePaths(boolean flag)
    {
        shouldInternalizePaths = flag;
    }

    static 
    {
        try
        {
            sConfigCallback = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            sConfigCallback.setAccessible(true);
        }
        catch (Exception exception) { }
    }

}
