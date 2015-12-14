// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView

class a extends WebChromeClient
{

    private WeakReference a;

    private static String a(Context context)
    {
        PackageManager packagemanager = context.getApplicationContext().getPackageManager();
        try
        {
            context = packagemanager.getApplicationInfo(context.getPackageName(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = null;
        }
        if (context != null)
        {
            context = packagemanager.getApplicationLabel(context);
        } else
        {
            context = "This app";
        }
        return (String)context;
    }

    static void a(a a1, boolean flag)
    {
        a1 = (MMWebView)a1.a.get();
        if (a1 != null)
        {
            a1 = a1.getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
            a1.Boolean("mm_use_geo_location", flag);
            a1.mit();
        }
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
        super.onConsoleMessage(s, i, s1);
    }

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.ack ack)
    {
        MMWebView mmwebview = (MMWebView)a.get();
        boolean flag;
        boolean flag1;
        if (mmwebview != null)
        {
            if (!mmwebview.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        mmwebview = (MMWebView)a.get();
        if (mmwebview != null)
        {
            flag1 = mmwebview.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false);
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        ack.invoke(s, true, true);
_L4:
        return;
_L2:
        Object obj = (MMWebView)a.get();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((MMWebView) (obj)).h();
        if (obj == null) goto _L4; else goto _L5
_L5:
        android.app.istener istener = new android.app.WebChromeClient.a(((Context) (obj)));
        istener.(a(((Context) (obj))));
        istener.ge("Would like to use your Current Location.").iveButton("Allow", new android.content.DialogInterface.OnClickListener(ack, s) {

            private android.webkit.GeolocationPermissions.Callback a;
            private String b;
            private MMWebView.MyWebChromeClient c;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                MMWebView.MyWebChromeClient.a(c, true);
                a.invoke(b, true, true);
            }

            
            {
                c = MMWebView.MyWebChromeClient.this;
                a = callback;
                b = s;
                super();
            }
        }).iveButton("Don't Allow", new android.content.DialogInterface.OnClickListener(ack, s) {

            private android.webkit.GeolocationPermissions.Callback a;
            private String b;
            private MMWebView.MyWebChromeClient c;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                MMWebView.MyWebChromeClient.a(c, false);
                a.invoke(b, false, false);
            }

            
            {
                c = MMWebView.MyWebChromeClient.this;
                a = callback;
                b = s;
                super();
            }
        });
        istener.WebChromeClient().show();
        return;
        ack.invoke(s, false, false);
        return;
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        MMWebView mmwebview = (MMWebView)a.get();
        if (mmwebview != null)
        {
            if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
            {
                return super.onJsAlert(webview, s, s1, jsresult);
            }
            Toast.makeText(mmwebview.getContext(), s1, 0).show();
        }
        return true;
    }

    public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        MMWebView mmwebview = (MMWebView)a.get();
        if (mmwebview != null)
        {
            if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
            {
                return super.onJsBeforeUnload(webview, s, s1, jsresult);
            }
            Toast.makeText(mmwebview.getContext(), s1, 0).show();
        }
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        MMWebView mmwebview = (MMWebView)a.get();
        if (mmwebview != null)
        {
            if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
            {
                return super.onJsConfirm(webview, s, s1, jsresult);
            }
            Toast.makeText(mmwebview.getContext(), s1, 0).show();
        }
        return true;
    }

    public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        MMWebView mmwebview = (MMWebView)a.get();
        if (mmwebview != null)
        {
            if (mmwebview.getContext() != mmwebview.getContext().getApplicationContext())
            {
                return super.onJsPrompt(webview, s, s1, s2, jspromptresult);
            }
            Toast.makeText(mmwebview.getContext(), s1, 0).show();
        }
        return true;
    }

    _cls2.b(MMWebView mmwebview)
    {
        a = new WeakReference(mmwebview);
    }
}
