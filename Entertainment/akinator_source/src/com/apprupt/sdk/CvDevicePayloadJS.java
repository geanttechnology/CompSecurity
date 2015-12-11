// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvCrypto

class CvDevicePayloadJS
{

    private static final String PAGE_TEMPLATE = "<!DOCTYPE html>\n<html>\n <head>\n  <meta charset=\"utf-8\" />\n  <title>pg</title>\n  <script type=\"text/javascript\">\n//<![CDATA[\n%s\n(function () {\n    var loader = function () {\n        var getPayload = function () {\n            try { \n                if (cv && cv.payload) { \n                    return cv.payload(); \n                } else { \n                    return ''; \n                } \n            } catch (e) { \n                return ''; \n            }\n        };\n        window.removeEventListener('load',loader,false);\n        jsb.loaded();\n        jsb.onPayload(getPayload());\n    };\n    window.addEventListener('load',loader,false);\n}());\n//]]>\n  </script>\n </head>\n <body>\n dummy body\n </body>\n</html>";
    private boolean finished;
    private Listener listener;
    private final Logger.log log = Logger.get("DEVICE_PAYLOAD");
    private WebView webView;

    CvDevicePayloadJS(Context context, String s, Listener listener1)
    {
        finished = false;
        listener = listener1;
        try
        {
            webView = new WebView(context);
            webView.setWebViewClient(new _cls1());
    /* block-local class not found */
    class ChromeClient {}

            webView.setWebChromeClient(new ChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(this, "jsb");
            context = String.format("<!DOCTYPE html>\n<html>\n <head>\n  <meta charset=\"utf-8\" />\n  <title>pg</title>\n  <script type=\"text/javascript\">\n//<![CDATA[\n%s\n(function () {\n    var loader = function () {\n        var getPayload = function () {\n            try { \n                if (cv && cv.payload) { \n                    return cv.payload(); \n                } else { \n                    return ''; \n                } \n            } catch (e) { \n                return ''; \n            }\n        };\n        window.removeEventListener('load',loader,false);\n        jsb.loaded();\n        jsb.onPayload(getPayload());\n    };\n    window.addEventListener('load',loader,false);\n}());\n//]]>\n  </script>\n </head>\n <body>\n dummy body\n </body>\n</html>", new Object[] {
                s
            });
            webView.loadDataWithBaseURL("http://cv.apprupt.com", context, "text/html", "utf-8", null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.e(context, new Object[] {
                "Error creating webview"
            });
        }
        onPayload("");
    }

    public void loaded()
    {
        log.v(new Object[] {
            "SCRIPT LOADED"
        });
    }

    public void onPayload(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!finished)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        log.w(new Object[] {
            "Second payload received"
        });
        this;
        JVM INSTR monitorexit ;
        return;
        finished = true;
        this;
        JVM INSTR monitorexit ;
        log.e(new Object[] {
            "GOT PAYLOAD FROM JS"
        });
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() <= 0) goto _L2; else goto _L3
_L3:
        s = CvCrypto.encode(s.getBytes());
        log.v(new Object[] {
            "Got device payload"
        });
_L4:
        (new Handler(Looper.getMainLooper())).post(new _cls2(s));
        webView = null;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
_L2:
        s = "";
        log.e(new Object[] {
            "Device payload empty"
        });
          goto _L4
        s;
        log.e(s, new Object[] {
            "Error trying to prepare payload listener callback"
        });
        webView = null;
        return;
        s;
        webView = null;
        throw s;
    }




/*
    static Listener access$102(CvDevicePayloadJS cvdevicepayloadjs, Listener listener1)
    {
        cvdevicepayloadjs.listener = listener1;
        return listener1;
    }

*/

    // Unreferenced inner class com/apprupt/sdk/CvDevicePayloadJS$Listener
    /* block-local class not found */
    class Listener {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
