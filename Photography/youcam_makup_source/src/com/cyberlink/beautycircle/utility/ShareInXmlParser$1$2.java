// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.res.AssetManager;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.cyberlink.beautycircle.controller.activity.ShareInActivity;
import com.perfectcorp.utility.e;
import java.io.IOException;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser, aa

class a extends WebChromeClient
{

    final a a;

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        e.b(new Object[] {
            "(", Integer.valueOf(consolemessage.lineNumber()), ")", consolemessage.message()
        });
        return true;
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        e.b(new Object[] {
            s
        });
        webview.loadUrl("javascript:(function() {\tvar s = document.createElement('script');\ts.type = 'text/javascript';\ts.src = 'LOCAL_JS_TOKEN';\tdocument.head.appendChild(s);})();", null);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/utility/ShareInXmlParser$1

/* anonymous class */
    class ShareInXmlParser._cls1
        implements Runnable
    {

        final ShareInXmlParser a;

        public void run()
        {
            e.b(new Object[] {
                "Dynamic parsing begin; ", ShareInXmlParser.g(a).e()
            });
            WebSettings websettings = ShareInXmlParser.p(a).getSettings();
            websettings.setJavaScriptEnabled(true);
            websettings.setAllowFileAccess(true);
            websettings.setLoadsImagesAutomatically(false);
            websettings.setUserAgentString("Dalvik/1.6.0 (Linux; U; Android 4.2.2)");
            ShareInXmlParser.p(a).setWebViewClient(new ShareInXmlParser._cls1._cls1());
            ShareInXmlParser.p(a).setWebChromeClient(new ShareInXmlParser._cls1._cls2(this));
            ShareInXmlParser.p(a).addJavascriptInterface(ShareInXmlParser.q(a), "parseEventListener");
            ShareInXmlParser.p(a).loadUrl(ShareInXmlParser.h(a));
        }

            
            {
                a = shareinxmlparser;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/utility/ShareInXmlParser$1$1

/* anonymous class */
        class ShareInXmlParser._cls1._cls1 extends WebViewClient
        {

            final ShareInXmlParser._cls1 a;

            public void onPageFinished(WebView webview, String s)
            {
                e.b(new Object[] {
                    s
                });
                super.onPageFinished(webview, s);
                ShareInXmlParser.g(a.a).c();
            }

            public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
            {
                e.b(new Object[] {
                    s
                });
                webview = super.shouldInterceptRequest(webview, s);
                if (s == null || !s.contains("LOCAL_JS_TOKEN"))
                {
                    break MISSING_BLOCK_LABEL_69;
                }
                s = new WebResourceResponse("application/javascript", "UTF8", ShareInXmlParser.r(a.a).getAssets().open("BeautyCircle/shareInParser.js"));
                return s;
                s;
                s.printStackTrace();
                return webview;
            }

                    
                    {
                        a = ShareInXmlParser._cls1.this;
                        super();
                    }
        }

    }

}
