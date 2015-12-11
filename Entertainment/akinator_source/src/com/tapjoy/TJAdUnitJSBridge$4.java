// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tapjoy.mraid.view.MraidView;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge, TapjoyUtil

final class a
    implements Runnable
{

    final JSONObject a;
    final TJAdUnitJSBridge b;

    public final void run()
    {
        String s;
        MraidView mraidview;
        int i;
        try
        {
            s = a.getString("html");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            exception = null;
        }
        if (TJAdUnitJSBridge.c(b) != null && TJAdUnitJSBridge.c(b).getParent() != null)
        {
            ((ViewGroup)TJAdUnitJSBridge.c(b).getParent()).removeView(TJAdUnitJSBridge.c(b));
        }
        mraidview = new MraidView(TJAdUnitJSBridge.d(b));
        TJAdUnitJSBridge.e(b).getSettings().setJavaScriptEnabled(true);
        mraidview.setPlacementType(com.tapjoy.mraid.view._TYPE.INLINE);
        mraidview.setLayoutParams(new android.view.ams(640, 100));
        mraidview.setInitialScale(100);
        mraidview.setBackgroundColor(0);
        mraidview.loadDataWithBaseURL(null, s, "text/html", "utf-8", null);
        i = ((WindowManager)((Activity)TJAdUnitJSBridge.d(b)).getSystemService("window")).getDefaultDisplay().getWidth();
        TJAdUnitJSBridge.a(b, TapjoyUtil.scaleDisplayAd(mraidview, i));
        ((Activity)TJAdUnitJSBridge.d(b)).addContentView(TJAdUnitJSBridge.c(b), new android.view.ams(i, (int)(100D * ((double)i / 640D))));
    }

    arams(TJAdUnitJSBridge tjadunitjsbridge, JSONObject jsonobject)
    {
        b = tjadunitjsbridge;
        a = jsonobject;
        super();
    }
}
