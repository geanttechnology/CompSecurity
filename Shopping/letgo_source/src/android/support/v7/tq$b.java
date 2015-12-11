// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            tq, ur, uq, ul, 
//            um

static class gs extends gs
{

    public um a(ul ul, boolean flag)
    {
        return new ur(ul, flag);
    }

    public WebChromeClient a(ul ul)
    {
        return new uq(ul);
    }

    public Set a(Uri uri)
    {
        return uri.getQueryParameterNames();
    }

    public boolean a(android.app.oadManager.Request request)
    {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    public boolean a(Context context, WebSettings websettings)
    {
        if (context.getCacheDir() != null)
        {
            websettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            websettings.setAppCacheMaxSize(0L);
            websettings.setAppCacheEnabled(true);
        }
        websettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        websettings.setDatabaseEnabled(true);
        websettings.setDomStorageEnabled(true);
        websettings.setDisplayZoomControls(false);
        websettings.setBuiltInZoomControls(true);
        websettings.setSupportZoom(true);
        return true;
    }

    public boolean a(Window window)
    {
        window.setFlags(0x1000000, 0x1000000);
        return true;
    }

    public boolean a(WebView webview)
    {
        webview.onPause();
        return true;
    }

    public boolean b(View view)
    {
        view.setLayerType(0, null);
        return true;
    }

    public boolean b(WebView webview)
    {
        webview.onResume();
        return true;
    }

    public boolean c(View view)
    {
        view.setLayerType(1, null);
        return true;
    }

    gs()
    {
    }
}
