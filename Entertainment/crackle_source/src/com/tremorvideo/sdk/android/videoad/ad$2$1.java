// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad

class a extends WebViewClient
{

    final WebView a;
    final a b;

    public void onPageFinished(WebView webview, String s)
    {
label0:
        {
            ad.d("BlueKai Page Loaded");
            if (!ad.N() && !ad.b)
            {
                webview = (new StringBuilder()).append("init(").append(b.b).append(")").toString();
                ad.a(true);
                ad.b = true;
                if (ad.q() >= 19)
                {
                    break label0;
                }
                a.loadUrl((new StringBuilder()).append("javascript:").append(webview).toString());
            }
            return;
        }
        a.evaluateJavascript(webview, null);
    }

    a(a a1, WebView webview)
    {
        b = a1;
        a = webview;
        super();
    }

    // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ad$2

/* anonymous class */
    static final class ad._cls2
        implements Runnable
    {

        final JSONObject a;

        public void run()
        {
            ad.d("Init BlueKai");
            WebView webview = new WebView(ad.a);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.setWebViewClient(new ad._cls2._cls1(this, webview));
            webview.setWebChromeClient(new ad._cls2._cls2());
            try
            {
                ad.d("Loading URL");
                webview.loadUrl(a.getString("template-url"));
                return;
            }
            catch (Exception exception)
            {
                ad.d((new StringBuilder()).append("enableBlueKaiJS loadurl Exception:").append(exception).toString());
            }
        }

            
            {
                a = jsonobject;
                super();
            }

        // Unreferenced inner class com/tremorvideo/sdk/android/videoad/ad$2$2

/* anonymous class */
        class ad._cls2._cls2 extends WebChromeClient
        {

            final ad._cls2 a;

            public void onConsoleMessage(String s, int i, String s1)
            {
                ad.d((new StringBuilder()).append("BluKai Console: ").append(s).toString());
            }

            public boolean onConsoleMessage(ConsoleMessage consolemessage)
            {
                ad.d((new StringBuilder()).append("BluKai Console: ").append(consolemessage.message()).toString());
                return false;
            }

                    
                    {
                        a = ad._cls2.this;
                        super();
                    }
        }

    }

}
