// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.smule.android.f;
import com.smule.android.f.g;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.android.e:
//            b

public class a extends Activity
{

    static final String a = com/smule/android/e/a.getName();
    WebView b;
    int c;
    private int d;

    public a()
    {
    }

    private String a()
    {
        String s = (new StringBuilder()).append("\n\n\n\n").append("App Version: ").append(com.smule.android.network.core.b.d().h()).append("\n").toString();
        s = (new StringBuilder()).append(s).append("API: ").append(com.smule.android.network.core.b.c()).append("\n").toString();
        s = (new StringBuilder()).append(s).append("AccountId: ").append(UserManager.n().b()).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Email: ").append(UserManager.n().f()).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Push token: ").append(com.smule.android.notifications.a.a().b()).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Advertising ID: ").append(g.a(this, true)).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Device ID: ").append(g.a(this)).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Android ID: ").append(g.b(this)).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Device Model: ").append(Build.MODEL).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Device OS: ").append(android.os.Build.VERSION.RELEASE).append("\n").toString();
        s = (new StringBuilder()).append(s).append("OS Version: ").append(System.getProperty("os.version")).append("(").append(android.os.Build.VERSION.INCREMENTAL).append(")\n").toString();
        s = (new StringBuilder()).append(s).append("OS API Level: ").append(android.os.Build.VERSION.SDK_INT).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Device: ").append(Build.DEVICE).append("\n").toString();
        s = (new StringBuilder()).append(s).append("Model (and Product): ").append(Build.MODEL).append(" (").append(Build.PRODUCT).append(")\n").toString();
        s = (new StringBuilder()).append(s).append(b()).toString();
        return (new StringBuilder()).append(s).append(d()).toString();
    }

    static String a(a a1)
    {
        return a1.a();
    }

    static int b(a a1)
    {
        return a1.d;
    }

    private String b()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null)
        {
            return (new StringBuilder()).append("").append("Active Network: none\n").toString();
        } else
        {
            String s = (new StringBuilder()).append("").append("Active Network: ").append(networkinfo.getTypeName()).append("\n").toString();
            s = (new StringBuilder()).append(s).append("Network Connected: ").append(networkinfo.isConnected()).append("\n").toString();
            return (new StringBuilder()).append(s).append("Network Detailed State: ").append(networkinfo.getDetailedState()).append("\n").toString();
        }
    }

    protected void c()
    {
        b = (WebView)findViewById(f.webview);
        b.setWebViewClient(new com.smule.android.e.b(this));
        b.getSettings().setJavaScriptEnabled(true);
        if (getIntent().getStringExtra("SUPPORT_LINK") == null)
        {
            finish();
            Log.i(a, "No support link set!");
            return;
        } else
        {
            c = getIntent().getIntExtra("NO_EMAIL_CLIENT_RESOURCE", 0);
            d = getIntent().getIntExtra("CANT_CONNECT_RESOURCE", 0);
            b.loadUrl(getIntent().getStringExtra("SUPPORT_LINK"));
            return;
        }
    }

    protected String d()
    {
        return "";
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(com.smule.android.g.help_web);
        onNewIntent(getIntent());
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && b.canGoBack())
        {
            b.goBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        c();
    }

}
