// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            NonLeakingWebView

protected static class activityRef extends WebViewClient
{

    private WeakReference activityRef;

    protected String internalizePaths(WebView webview, String s)
    {
        String s1 = s;
        if (webview instanceof NonLeakingWebView)
        {
            s1 = s;
            if (NonLeakingWebView.access$000((NonLeakingWebView)webview))
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

    public (Activity activity)
    {
        activityRef = new WeakReference(activity);
    }
}
