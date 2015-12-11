// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            hf, he, hj, hk, 
//            hl

public class gn
{
    public static class a extends gn
    {

        public final int a()
        {
            return 6;
        }

        public boolean a(android.app.DownloadManager.Request request)
        {
            request.setShowRunningNotification(true);
            return true;
        }

        public final int b()
        {
            return 7;
        }

        public a()
        {
            super((byte)0);
        }
    }

    public static class b extends a
    {

        public WebChromeClient a(he he)
        {
            return new hj(he);
        }

        public final hf a(he he, boolean flag)
        {
            return new hk(he, flag);
        }

        public final Set a(Uri uri)
        {
            return uri.getQueryParameterNames();
        }

        public final boolean a(android.app.DownloadManager.Request request)
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

        public final boolean a(Window window)
        {
            window.setFlags(0x1000000, 0x1000000);
            return true;
        }

        public final boolean a(WebView webview)
        {
            webview.onPause();
            return true;
        }

        public final boolean b(View view)
        {
            view.setLayerType(0, null);
            return true;
        }

        public final boolean b(WebView webview)
        {
            webview.onResume();
            return true;
        }

        public final boolean c(View view)
        {
            view.setLayerType(1, null);
            return true;
        }

        public b()
        {
        }
    }

    public static class c extends b
    {

        public final WebChromeClient a(he he)
        {
            return new hl(he);
        }

        public final String a(SslError sslerror)
        {
            return sslerror.getUrl();
        }

        public c()
        {
        }
    }

    public static class d extends f
    {

        public final String a(Context context)
        {
            return WebSettings.getDefaultUserAgent(context);
        }

        public final boolean a(Context context, WebSettings websettings)
        {
            super.a(context, websettings);
            websettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }

        public d()
        {
        }
    }

    public static class e extends d
    {

        public boolean a(View view)
        {
            return super.a(view) || view.getWindowId() != null;
        }

        public final int c()
        {
            return 14;
        }

        public e()
        {
        }
    }

    public static class f extends c
    {

        public final void a(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
        {
            activity = activity.getWindow();
            if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
            {
                activity.getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(ongloballayoutlistener);
            }
        }

        public final void a(ViewTreeObserver viewtreeobserver, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
        {
            viewtreeobserver.removeOnGlobalLayoutListener(ongloballayoutlistener);
        }

        public f()
        {
        }
    }

    public static final class g extends e
    {

        public final boolean a(View view)
        {
            return view.isAttachedToWindow();
        }

        public final android.view.ViewGroup.LayoutParams d()
        {
            return new android.view.ViewGroup.LayoutParams(-1, -1);
        }

        public g()
        {
        }
    }


    public gn()
    {
    }

    gn(byte byte0)
    {
        this();
    }

    public int a()
    {
        return 0;
    }

    public WebChromeClient a(he he)
    {
        return null;
    }

    public hf a(he he, boolean flag)
    {
        return new hf(he, flag);
    }

    public String a(Context context)
    {
        return "";
    }

    public String a(SslError sslerror)
    {
        return "";
    }

    public Set a(Uri uri)
    {
        if (uri.isOpaque())
        {
            return Collections.emptySet();
        }
        uri = uri.getEncodedQuery();
        if (uri == null)
        {
            return Collections.emptySet();
        }
        LinkedHashSet linkedhashset = new LinkedHashSet();
        int j = 0;
        do
        {
            int i;
            int k;
label0:
            {
                k = uri.indexOf('&', j);
                i = k;
                if (k == -1)
                {
                    i = uri.length();
                }
                int l = uri.indexOf('=', j);
                if (l <= i)
                {
                    k = l;
                    if (l != -1)
                    {
                        break label0;
                    }
                }
                k = i;
            }
            linkedhashset.add(Uri.decode(uri.substring(j, k)));
            i++;
            j = i;
            if (i >= uri.length())
            {
                return Collections.unmodifiableSet(linkedhashset);
            }
        } while (true);
    }

    public void a(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        activity = activity.getWindow();
        if (activity != null && activity.getDecorView() != null && activity.getDecorView().getViewTreeObserver() != null)
        {
            a(activity.getDecorView().getViewTreeObserver(), ongloballayoutlistener);
        }
    }

    public void a(ViewTreeObserver viewtreeobserver, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        viewtreeobserver.removeGlobalOnLayoutListener(ongloballayoutlistener);
    }

    public boolean a(android.app.DownloadManager.Request request)
    {
        return false;
    }

    public boolean a(Context context, WebSettings websettings)
    {
        return false;
    }

    public boolean a(View view)
    {
        return view.getWindowToken() != null || view.getWindowVisibility() != 8;
    }

    public boolean a(Window window)
    {
        return false;
    }

    public boolean a(WebView webview)
    {
        return false;
    }

    public int b()
    {
        return 1;
    }

    public boolean b(View view)
    {
        return false;
    }

    public boolean b(WebView webview)
    {
        return false;
    }

    public int c()
    {
        return 5;
    }

    public boolean c(View view)
    {
        return false;
    }

    public android.view.ViewGroup.LayoutParams d()
    {
        return new android.view.ViewGroup.LayoutParams(-2, -2);
    }
}
