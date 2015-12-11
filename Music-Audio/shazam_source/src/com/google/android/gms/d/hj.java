// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            he, gm

public class hj extends WebChromeClient
{

    private final he a;

    public hj(he he1)
    {
        a = he1;
    }

    private static Context a(WebView webview)
    {
        if (!(webview instanceof he))
        {
            webview = webview.getContext();
        } else
        {
            he he1 = (he)webview;
            Activity activity = he1.c();
            webview = activity;
            if (activity == null)
            {
                return he1.getContext();
            }
        }
        return webview;
    }

    private static boolean a(Context context, String s, String s1, String s2, JsResult jsresult, JsPromptResult jspromptresult, boolean flag)
    {
        android.app.AlertDialog.Builder builder;
        try
        {
            builder = new android.app.AlertDialog.Builder(context);
            builder.setTitle(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            b.a(5);
            return true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        s = new LinearLayout(context);
        s.setOrientation(1);
        jsresult = new TextView(context);
        jsresult.setText(s1);
        context = new EditText(context);
        context.setText(s2);
        s.addView(jsresult);
        s.addView(context);
        builder.setView(s).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jspromptresult, context) {

            final JsPromptResult a;
            final EditText b;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm(b.getText().toString());
            }

            
            {
                a = jspromptresult;
                b = edittext;
                super();
            }
        }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(jspromptresult) {

            final JsPromptResult a;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                a.cancel();
            }

            
            {
                a = jspromptresult;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(jspromptresult) {

            final JsPromptResult a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.cancel();
            }

            
            {
                a = jspromptresult;
                super();
            }
        }).create().show();
        return true;
        builder.setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm();
            }

            
            {
                a = jsresult;
                super();
            }
        }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;

            public final void onClick(DialogInterface dialoginterface, int i)
            {
                a.cancel();
            }

            
            {
                a = jsresult;
                super();
            }
        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(jsresult) {

            final JsResult a;

            public final void onCancel(DialogInterface dialoginterface)
            {
                a.cancel();
            }

            
            {
                a = jsresult;
                super();
            }
        }).create().show();
        return true;
    }

    protected final void a(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        d d1 = a.f();
        if (d1 == null)
        {
            b.a(5);
            customviewcallback.onCustomViewHidden();
            return;
        } else
        {
            d1.k = new FrameLayout(d1.b);
            d1.k.setBackgroundColor(0xff000000);
            d1.k.addView(view, -1, -1);
            d1.b.setContentView(d1.k);
            d1.r = true;
            d1.l = customviewcallback;
            d1.j = true;
            d1.a(i);
            return;
        }
    }

    public final void onCloseWindow(WebView webview)
    {
        if (!(webview instanceof he))
        {
            b.a(5);
            return;
        }
        webview = ((he)webview).f();
        if (webview == null)
        {
            b.a(5);
            return;
        } else
        {
            webview.a();
            return;
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        String s;
        s = (new StringBuilder("JS: ")).append(consolemessage.message()).append(" (").append(consolemessage.sourceId()).append(":").append(consolemessage.lineNumber()).append(")").toString();
        if (s.contains("Application Cache"))
        {
            return super.onConsoleMessage(consolemessage);
        }
        static final class _cls7
        {

            static final int a[];

            static 
            {
                a = new int[android.webkit.ConsoleMessage.MessageLevel.values().length];
                try
                {
                    a[android.webkit.ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[android.webkit.ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[android.webkit.ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[android.webkit.ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[android.webkit.ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls7.a[consolemessage.messageLevel().ordinal()];
        JVM INSTR tableswitch 1 5: default 108
    //                   1 119
    //                   2 126
    //                   3 134
    //                   4 134
    //                   5 142;
           goto _L1 _L2 _L3 _L4 _L4 _L5
_L1:
        b.a(4);
_L7:
        return super.onConsoleMessage(consolemessage);
_L2:
        b.a(s);
        continue; /* Loop/switch isn't completed */
_L3:
        b.a(5);
        continue; /* Loop/switch isn't completed */
_L4:
        b.a(4);
        continue; /* Loop/switch isn't completed */
_L5:
        b.a(3);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        android.webkit.WebView.WebViewTransport webviewtransport = (android.webkit.WebView.WebViewTransport)message.obj;
        webview = new WebView(webview.getContext());
        webview.setWebViewClient(a.i());
        webviewtransport.setWebView(webview);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        long l3;
        l3 = 0x500000L - l2;
        if (l3 <= 0L)
        {
            quotaupdater.updateQuota(l);
            return;
        }
        if (l != 0L) goto _L2; else goto _L1
_L1:
        if (l1 > l3 || l1 > 0x100000L)
        {
            l1 = 0L;
        }
_L4:
        quotaupdater.updateQuota(l1);
        return;
_L2:
        if (l1 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        l2 = Math.min(Math.min(0x20000L, l3) + l, 0x100000L);
_L5:
        l1 = l2;
        if (true) goto _L4; else goto _L3
_L3:
        l2 = l;
        if (l1 <= Math.min(0x100000L - l, l3))
        {
            l2 = l + l1;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public final void onGeolocationPermissionsShowPrompt(String s, android.webkit.GeolocationPermissions.Callback callback)
    {
        if (callback == null) goto _L2; else goto _L1
_L1:
        p.e();
        if (gm.a(a.getContext().getPackageManager(), a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) goto _L4; else goto _L3
_L3:
        p.e();
        if (!gm.a(a.getContext().getPackageManager(), a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) goto _L5; else goto _L4
_L4:
        boolean flag = true;
_L7:
        callback.invoke(s, flag, true);
_L2:
        return;
_L5:
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final void onHideCustomView()
    {
        d d1 = a.f();
        if (d1 == null)
        {
            b.a(5);
            return;
        } else
        {
            d1.b();
            return;
        }
    }

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a(a(webview), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a(a(webview), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a(a(webview), s, s1, null, jsresult, null, false);
    }

    public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        return a(a(webview), s, s1, s2, null, jspromptresult, true);
    }

    public final void onReachedMaxAppCacheSize(long l, long l1, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        l = 0x20000L + l;
        if (0x500000L - l1 < l)
        {
            quotaupdater.updateQuota(0L);
            return;
        } else
        {
            quotaupdater.updateQuota(l);
            return;
        }
    }

    public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        a(view, -1, customviewcallback);
    }
}
