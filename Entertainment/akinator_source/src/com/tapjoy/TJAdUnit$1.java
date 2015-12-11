// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.widget.VideoView;
import com.tapjoy.internal.cw;
import com.tapjoy.mraid.view.BasicWebView;
import com.tapjoy.mraid.view.MraidView;

// Referenced classes of package com.tapjoy:
//            TJAdUnit, TJAdUnitJSBridge, TJPlacementData, TapjoyLog

final class >
    implements Runnable
{

    final TJPlacementData a;
    final TJAdUnit b;

    public final void run()
    {
        if (TJAdUnit.a(b))
        {
            return;
        }
        TJAdUnit.b(b);
        TJAdUnit.a(b, new BasicWebView(TJAdUnit.c(b)));
        TJAdUnit.d(b).loadDataWithBaseURL(null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", null);
        TJAdUnit.a(b, new MraidView(TJAdUnit.c(b)));
        TJAdUnit.e(b).setListener(new <init>(b, (byte)0));
        TJAdUnit.a(b, new VideoView(TJAdUnit.c(b)));
        TJAdUnit.f(b).setOnCompletionListener(b);
        TJAdUnit.f(b).setOnErrorListener(b);
        TJAdUnit.f(b).setOnPreparedListener(b);
        TJAdUnit.f(b).setVisibility(4);
        TJAdUnit.a(b, new TJAdUnitJSBridge(TJAdUnit.c(b), b));
        if (!cw.c(a.getRedirectURL()))
        {
            TJAdUnit.e(b).loadUrl(a.getRedirectURL());
            return;
        }
        if (a.getBaseURL() != null && a.getHttpResponse() != null)
        {
            TJAdUnit.e(b).loadDataWithBaseURL(a.getBaseURL(), a.getHttpResponse(), "text/html", "utf-8", null);
            return;
        }
        if (a.getUrl() != null)
        {
            TJAdUnit.e(b).loadUrl(a.getUrl());
            return;
        } else
        {
            TapjoyLog.e("TJAdUnit", "Error loading ad unit content");
            return;
        }
    }

    Data(TJAdUnit tjadunit, TJPlacementData tjplacementdata)
    {
        b = tjadunit;
        a = tjplacementdata;
        super();
    }
}
