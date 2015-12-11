// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge, TapjoyConnectCore, TapjoyUtil, TapjoyLog

public class TJEventOptimizer extends WebView
{
    final class a extends WebChromeClient
    {

        final TJEventOptimizer a;

        public final boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            TapjoyLog.d(TJEventOptimizer.b(), (new StringBuilder("JS CONSOLE: ")).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
            return true;
        }

        private a()
        {
            a = TJEventOptimizer.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    final class b extends WebViewClient
    {

        final TJEventOptimizer a;

        public final void onPageFinished(WebView webview, String s)
        {
            TapjoyLog.d(TJEventOptimizer.b(), "boostrap html loaded successfully");
        }

        public final void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            TapjoyLog.e(TJEventOptimizer.b(), (new StringBuilder("error:")).append(s).toString());
        }

        private b()
        {
            a = TJEventOptimizer.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }


    private static String a = "TJEventOptimizer";
    private static TJEventOptimizer b;
    private static CountDownLatch c;
    private Context d;
    private TJAdUnitJSBridge e;

    private TJEventOptimizer(Context context)
    {
        super(context);
        d = context;
        e = new TJAdUnitJSBridge(d, this);
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(new b((byte)0));
        setWebChromeClient(new a((byte)0));
        loadUrl((new StringBuilder()).append(TapjoyConnectCore.getHostURL()).append("events/proxy?").append(TapjoyUtil.convertURLParams(TapjoyConnectCore.getGenericURLParams(), true)).toString());
    }

    TJEventOptimizer(Context context, byte byte0)
    {
        this(context);
    }

    static TJEventOptimizer a(TJEventOptimizer tjeventoptimizer)
    {
        b = tjeventoptimizer;
        return tjeventoptimizer;
    }

    static CountDownLatch a()
    {
        return c;
    }

    static String b()
    {
        return a;
    }

    public static TJEventOptimizer getInstance()
    {
        return b;
    }

    public static void init(Context context)
    {
        TapjoyLog.d(a, "Initializing event optimizer");
        c = new CountDownLatch(1);
        TapjoyUtil.runOnMainThread(new Runnable(context) {

            final Context a;

            public final void run()
            {
                TJEventOptimizer.a(new TJEventOptimizer(a, (byte)0));
                TJEventOptimizer.a().countDown();
            }

            
            {
                a = context;
                super();
            }
        });
        c.await();
    }

}
