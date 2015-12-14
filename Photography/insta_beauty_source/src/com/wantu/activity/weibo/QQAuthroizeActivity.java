// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.weibo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import bjw;
import bob;
import brd;
import brz;
import bsb;
import bse;
import bsi;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.fotoable.fotobeauty.ShareEditActivity;

public class QQAuthroizeActivity extends FullscreenActivity
{

    private WebView a;
    private String b;
    private ProgressDialog c;
    private Resources d;
    private brz e;
    private bse f;
    private String g;
    private String h;
    private Button i;
    private int j;

    public QQAuthroizeActivity()
    {
        j = 0;
    }

    public static ProgressDialog a(QQAuthroizeActivity qqauthroizeactivity, ProgressDialog progressdialog)
    {
        qqauthroizeactivity.c = progressdialog;
        return progressdialog;
    }

    public static String a(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.b;
    }

    public static ProgressDialog b(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.c;
    }

    public static Resources c(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.d;
    }

    public static WebView d(QQAuthroizeActivity qqauthroizeactivity)
    {
        return qqauthroizeactivity.a;
    }

    public String a()
    {
        j = 0;
        bsb.a = bsi.a(((WifiManager)getSystemService("wifi")).getConnectionInfo().getIpAddress());
        e = new brz("http://callback.fotoable.com/callback/qq_callback.html");
        f = new bse();
        String s;
        try
        {
            e = f.a(e);
            s = e.e();
            s = (new StringBuilder()).append("http://open.t.qq.com/cgi-bin/authorize?oauth_token=").append(s).toString();
            b = s;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return s;
    }

    public void a(String s, String s1)
    {
        b(s, s1);
        if (e.g() == 2)
        {
            Toast.makeText(this, d.getString(0x7f0601ce), 1).show();
            finish();
        }
        brd.a(this, true, e.e(), e.f());
        s = f.c(e);
        if (s != null)
        {
            try
            {
                (new bob(this, s)).execute(new String[0]);
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (h.compareTo("share") == 0)
        {
            s = new Intent(this, com/fotoable/fotobeauty/ShareEditActivity);
            s.putExtra("com.wantu.android.weibo", "qq");
            startActivity(s);
            finish();
            return;
        }
        try
        {
            finish();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(this, d.getString(0x7f0601ce), 1).show();
        }
        s.printStackTrace();
        finish();
        return;
    }

    public void b(String s, String s1)
    {
        e.e(s);
        e.c(s1);
        g = bsb.a;
        e = f.b(e);
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b8);
        d = getResources();
        h = getIntent().getStringExtra("com.wantu.android.source");
        i = (Button)findViewById(0x7f0d010b);
        i.setVisibility(4);
        ((TextView)findViewById(0x7f0d0034)).setText(d.getString(0x7f0601cf));
        a = (WebView)findViewById(0x7f0d02fd);
        a.getSettings().setJavaScriptEnabled(true);
        a.getSettings().setBuiltInZoomControls(true);
        c = new ProgressDialog(this);
        c.requestWindowFeature(1);
        c.setMessage(d.getString(0x7f0601d0));
        c.show();
        (new bjw(this)).execute(new String[0]);
    }
}
